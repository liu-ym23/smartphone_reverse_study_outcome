package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.IApplicationThread;
import android.app.SysMonitorFwBridge;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Slog;
import android.util.SparseArray;
import android.view.RemoteAnimationAdapter;
import com.android.internal.util.ArrayUtils;
import com.android.server.SysOptBridge;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.PendingIntentRecord;
import com.android.server.am.ProcessList;
import com.android.server.uri.NeededUriGrants;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityStartController {
    private static final int DO_PENDING_ACTIVITY_LAUNCHES_MSG = 1;
    private static final String TAG = "ActivityTaskManager";
    boolean mCheckedForSetup;
    private final ActivityStarter.Factory mFactory;
    private ArrayList<TaskDisplayArea> mHomeLaunchingTaskDisplayAreas;
    private boolean mInExecution;
    private ActivityRecord mLastHomeActivityStartRecord;
    private int mLastHomeActivityStartResult;
    private ActivityStarter mLastStarter;
    private final PendingRemoteAnimationRegistry mPendingRemoteAnimationRegistry;
    private final ActivityTaskManagerService mService;
    private final ActivityTaskSupervisor mSupervisor;
    private ActivityRecord[] tmpOutRecord;

    public static /* synthetic */ Intent[] $r8$lambda$PRaEnwcckEo4XKtmHnHmsUkmZLo(int r0) {
        return lambda$startActivities$0(r0);
    }

    ActivityStartController(ActivityTaskManagerService service) {
        this(service, service.mTaskSupervisor, new ActivityStarter.DefaultFactory(service, service.mTaskSupervisor, new ActivityStartInterceptor(service, service.mTaskSupervisor)));
    }

    ActivityStartController(ActivityTaskManagerService service, ActivityTaskSupervisor supervisor, ActivityStarter.Factory factory) {
        this.tmpOutRecord = new ActivityRecord[1];
        this.mCheckedForSetup = false;
        this.mInExecution = false;
        this.mHomeLaunchingTaskDisplayAreas = new ArrayList();
        this.mService = service;
        this.mSupervisor = supervisor;
        this.mFactory = factory;
        this.mFactory.setController(this);
        this.mPendingRemoteAnimationRegistry = new PendingRemoteAnimationRegistry(service.mGlobalLock, service.mH);
    }

    ActivityStarter obtainStarter(Intent intent, String reason) {
        return this.mFactory.obtain().setIntent(intent).setReason(reason);
    }

    void onExecutionStarted() {
        this.mInExecution = true;
    }

    boolean isInExecution() {
        return this.mInExecution;
    }

    void onExecutionComplete(ActivityStarter starter) {
        this.mInExecution = false;
        if (this.mLastStarter != null) goto L5;
        this.mLastStarter = this.mFactory.obtain();
    L5:
        this.mLastStarter.set(starter);
        this.mFactory.recycle(starter);
    }

    void postStartActivityProcessingForLastStarter(ActivityRecord r, int result, Task targetRootTask) {
        if (this.mLastStarter != null) goto L5;
        return;
    L5:
        this.mLastStarter.postStartActivityProcessing(r, result, targetRootTask);
    }

    void startHomeActivity(Intent intent, ActivityInfo aInfo, String reason, TaskDisplayArea taskDisplayArea) {
        if (this.mHomeLaunchingTaskDisplayAreas.contains(taskDisplayArea) == false) goto L6;
        Slog.e(TAG, "Abort starting home on " + taskDisplayArea + " recursively.");
        return;
    L6:
        ActivityOptions options = ActivityOptions.makeBasic();
        options.setLaunchWindowingMode(1);
        if (ActivityRecord.isResolverActivity(aInfo.name) == true) goto L9;
        options.setLaunchActivityType(2);
    L9:
        int displayId = taskDisplayArea.getDisplayId();
        options.setLaunchDisplayId(displayId);
        options.setLaunchTaskDisplayArea(taskDisplayArea.mRemoteToken.toWindowContainerToken());
        this.mSupervisor.beginDeferResume();
        Task rootHomeTask = taskDisplayArea.getOrCreateRootHomeTask(true);     // Catch: Throwable -> L20
        this.mSupervisor.endDeferResume();
        this.mHomeLaunchingTaskDisplayAreas.add(taskDisplayArea);     // Catch: Throwable -> L17
        this.mLastHomeActivityStartResult = obtainStarter(intent, "startHomeActivity: " + reason).setOutActivity(this.tmpOutRecord).setCallingUid(0).setActivityInfo(aInfo).setActivityOptions(options.toBundle(), Binder.getCallingPid(), Binder.getCallingUid()).execute();     // Catch: Throwable -> L17
        this.mHomeLaunchingTaskDisplayAreas.remove(taskDisplayArea);
        this.mLastHomeActivityStartRecord = this.tmpOutRecord[0];
        if (rootHomeTask.mInResumeTopActivity == false) goto L27;
        this.mSupervisor.scheduleResumeTopActivities();
        return;
    L27:
        return;
    L17:
        th = move-exception;
        this.mHomeLaunchingTaskDisplayAreas.remove(taskDisplayArea);
        throw th;
    L20:
        th = move-exception;
        this.mSupervisor.endDeferResume();
        throw th;
    }

    void startSetupActivity() {
        if (this.mCheckedForSetup == false) goto L5;
        return;
    L5:
        ContentResolver resolver = this.mService.mContext.getContentResolver();
        if (this.mService.mFactoryTest != 1) goto L8;
        return;
    L8:
        if (Settings.Global.getInt(resolver, "device_provisioned", 0) == 0) goto L27;
        this.mCheckedForSetup = true;
        Intent intent = new Intent("android.intent.action.UPGRADE_SETUP");
        List<ResolveInfo> ris = this.mService.mContext.getPackageManager().queryIntentActivities(intent, 1049728);
        if (ris.isEmpty() == true) goto L28;
        ResolveInfo ri = ris.get(0);
        if (ri.activityInfo.metaData == null) goto L14;
        String vers = ri.activityInfo.metaData.getString("android.SETUP_VERSION");
    L16:
        if (vers == null) goto L18;
    L20:
        String lastVers = Settings.Secure.getStringForUser(resolver, "last_setup_shown", resolver.getUserId());
        if (vers != null) goto L23;
        return;
    L23:
        if (vers.equals(lastVers) == true) goto L30;
        intent.setFlags(268435456);
        intent.setComponent(new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name));
        obtainStarter(intent, "startSetupActivity").setCallingUid(0).setActivityInfo(ri.activityInfo).execute();
        return;
    L30:
        return;
    L18:
        if (ri.activityInfo.applicationInfo.metaData == null) goto L20;
        vers = ri.activityInfo.applicationInfo.metaData.getString("android.SETUP_VERSION");
        goto L20
    L14:
        vers = null;
        goto L16
    L28:
        return;
    }

    int checkTargetUser(int targetUserId, boolean validateIncomingUser, int realCallingPid, int realCallingUid, String reason) {
        if (validateIncomingUser == true) goto L4;
        this.mService.mAmInternal.ensureNotSpecialUser(targetUserId);
        return targetUserId;
    L4:
        return this.mService.handleIncomingUser(realCallingPid, realCallingUid, targetUserId, reason);
    }

    final int startActivityInPackage(int uid, int realCallingPid, int realCallingUid, String callingPackage, String callingFeatureId, Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags, SafeActivityOptions options, int userId, Task inTask, String reason, boolean validateIncomingUser, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess) {
        int userId2 = checkTargetUser(userId, validateIncomingUser, realCallingPid, realCallingUid, reason);
        return obtainStarter(intent, reason).setCallingUid(uid).setRealCallingPid(realCallingPid).setRealCallingUid(realCallingUid).setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setResolvedType(resolvedType).setResultTo(resultTo).setResultWho(resultWho).setRequestCode(requestCode).setStartFlags(startFlags).setActivityOptions(options).setUserId(userId2).setInTask(inTask).setOriginatingPendingIntent(originatingPendingIntent).setAllowBalExemptionForSystemProcess(allowBalExemptionForSystemProcess).execute();
    }

    final int startActivitiesInPackage(int uid, String callingPackage, String callingFeatureId, Intent[] intents, String[] resolvedTypes, IBinder resultTo, SafeActivityOptions options, int userId, boolean validateIncomingUser, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess) {
        return startActivitiesInPackage(uid, 0, -1, callingPackage, callingFeatureId, intents, resolvedTypes, resultTo, options, userId, validateIncomingUser, originatingPendingIntent, allowBalExemptionForSystemProcess);
    }

    final int startActivitiesInPackage(int uid, int realCallingPid, int realCallingUid, String callingPackage, String callingFeatureId, Intent[] intents, String[] resolvedTypes, IBinder resultTo, SafeActivityOptions options, int userId, boolean validateIncomingUser, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess) {
        return startActivities(null, uid, realCallingPid, realCallingUid, callingPackage, callingFeatureId, intents, resolvedTypes, resultTo, options, checkTargetUser(userId, validateIncomingUser, Binder.getCallingPid(), Binder.getCallingUid(), "startActivityInPackage"), "startActivityInPackage", originatingPendingIntent, allowBalExemptionForSystemProcess);
    }

    int startActivities(IApplicationThread caller, int callingUid, int incomingRealCallingPid, int incomingRealCallingUid, String callingPackage, String callingFeatureId, Intent[] intents, String[] resolvedTypes, IBinder resultTo, SafeActivityOptions options, int userId, String reason, PendingIntentRecord originatingPendingIntent, boolean allowBalExemptionForSystemProcess) {
        IApplicationThread r2 = caller;
        String[] r11 = resolvedTypes;
        if (intents == null) goto L216;
        if (r11 == null) goto L214;
        if (intents.length != r11.length) goto L212;
        if (incomingRealCallingPid == 0) goto L9;
        int r0 = incomingRealCallingPid;
    L10:
        int callingUid2 = r0;
        if (incomingRealCallingUid == (-1)) goto L13;
        int r1 = incomingRealCallingUid;
    L14:
        int realCallingUid = r1;
        if (callingUid < 0) goto L17;
        int callingUid3 = callingUid;
        int callingPid = -1;
    L20:
        int filterCallingUid = ActivityStarter.computeResolveFilterUid(callingUid3, realCallingUid, ProcessList.INVALID_ADJ);
        SparseArray<String> startingUidPkgs = new SparseArray();
        long origId = Binder.clearCallingIdentity();
        if (options == null) goto L23;
        SafeActivityOptions bottomOptions = options.selectiveCloneLaunchOptions();
        SafeActivityOptions bottomOptions2 = bottomOptions;
    L222:
        Intent[] intents2 = (Intent[]) ArrayUtils.filterNotNull(intents, new ActivityStartController$$ExternalSyntheticLambda0());     // Catch: Throwable -> L207
        ActivityStarter[] starters = new ActivityStarter[intents2.length];     // Catch: Throwable -> L205
        int i = 0;
    L27:
        boolean r27 = false;
        if (i >= intents2.length) goto L130;
        Intent intent = intents2[i];     // Catch: Throwable -> L125
        NeededUriGrants intentGrants = null;
        if (intent.hasFileDescriptors() == true) goto L129;
        if (intent.getComponent() == null) goto L35;
        boolean componentSpecified = true;
    L36:
        Intent intent2 = new Intent(intent);     // Catch: Throwable -> L125
        intent2.removeExtendedFlags(1);     // Catch: Throwable -> L125
        ActivityInfo aInfo = this.mSupervisor.resolveActivity(intent2, r11[i], 0, null, userId, filterCallingUid, callingPid);     // Catch: Throwable -> L125
        SparseArray<String> startingUidPkgs2 = startingUidPkgs;
        boolean r16 = true;
        int filterCallingUid2 = filterCallingUid;
        int callingPid2 = callingPid;
        Intent[] intents3 = intents2;
        int callingUid4 = callingUid3;
        ActivityInfo aInfo2 = this.mService.mAmInternal.getActivityInfoForUser(aInfo, userId);     // Catch: Throwable -> L121
        String creatorPackage = null;
        if (ActivityManagerService.IntentCreatorToken.isValid(intent2) == false) goto L49;
        ActivityManagerService.IntentCreatorToken creatorToken = (ActivityManagerService.IntentCreatorToken) intent2.getCreatorToken();     // Catch: Throwable -> L46
        int creatorUid = creatorToken.getCreatorUid();     // Catch: Throwable -> L46
        if (creatorUid == filterCallingUid2) goto L49;
        int creatorUid2 = creatorToken.getCreatorUid();     // Catch: Throwable -> L46
        creatorPackage = creatorToken.getCreatorPackage();     // Catch: Throwable -> L46
        int creatorUid3 = creatorUid2;
    L50:
        if (aInfo2 != null) goto L229;
        int r12 = realCallingUid;
        intents3 = intents3;
        r16 = true;
        int realCallingUid2 = r12;
        aInfo2 = aInfo2;
        ActivityStarter[] starters2 = starters;
        startingUidPkgs2 = startingUidPkgs2;
        int creatorUid4 = creatorUid3;
        callingUid2 = callingUid2;
        String r4 = callingPackage;
        int realCallingPid = i;
        String creatorPackage2 = creatorPackage;
        componentSpecified = componentSpecified;
    L241:
        if (realCallingPid != (intents3.length - 1)) goto L95;
        r27 = r16;
    L95:
        boolean top = r27;
        if (top == false) goto L98;
        SafeActivityOptions checkedOptions = options;
    L99:
        int i2 = realCallingPid;
        int realCallingPid2 = callingUid2;
        ActivityStarter r3 = obtainStarter(intent2, reason).setIntentGrants(intentGrants).setCaller(r2).setResolvedType(resolvedTypes[i2]).setActivityInfo(aInfo2).setRequestCode(-1).setCallingPid(callingPid2).setCallingUid(callingUid4).setCallingPackage(r4).setCallingFeatureId(callingFeatureId).setIntentCreatorUid(creatorUid4).setIntentCreatorPackage(creatorPackage2).setRealCallingPid(realCallingPid2);     // Catch: Throwable -> L113
        int realCallingPid3 = realCallingUid2;
        ActivityStarter r5 = r3.setRealCallingUid(realCallingPid3).setActivityOptions(checkedOptions).setComponentSpecified(componentSpecified).setAllowPendingRemoteAnimationRegistryLookup(top).setOriginatingPendingIntent(originatingPendingIntent).setAllowBalExemptionForSystemProcess(allowBalExemptionForSystemProcess);     // Catch: Throwable -> L109
        ActivityStarter[] starters3 = starters2;
        starters3[i2] = r5;     // Catch: Throwable -> L109
        i = i2 + 1;     // Catch: Throwable -> L109
        r11 = resolvedTypes;
        starters = starters3;
        filterCallingUid = filterCallingUid2;
        callingUid3 = callingUid4;
        callingPid = callingPid2;
        intents2 = intents3;
        callingUid2 = realCallingPid2;
        r2 = caller;
        realCallingUid = realCallingPid3;
        startingUidPkgs = startingUidPkgs2;
    L109:
        th = th;
    L209:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L111:
        th = th;
    L113:
        th = th;
    L115:
        th = th;
    L117:
        th = th;
        goto L209
    L98:
        checkedOptions = bottomOptions2;
    L119:
        th = th;
        goto L209
    L229:
        starters2 = starters;
        realCallingPid = i;
        NeededUriGrants intentGrants2 = this.mSupervisor.mService.mUgmInternal.checkGrantUriPermissionFromIntent(intent2, filterCallingUid2, aInfo2.applicationInfo.packageName, UserHandle.getUserId(aInfo2.applicationInfo.uid));     // Catch: Throwable -> L70 SecurityException -> L81
        if (creatorUid3 != (-1)) goto L219;
        realCallingUid2 = realCallingUid;
        creatorPackage2 = creatorPackage;
        NeededUriGrants intentGrants3 = intentGrants2;
        creatorUid4 = creatorUid3;
        r4 = callingPackage;
    L73:
        intentGrants = intentGrants3;
    L251:
    L77:
        th = th;
        goto L209
    L75:
        if ((aInfo2.applicationInfo.privateFlags & 2) != 0) goto L80;
        startingUidPkgs2.put(aInfo2.applicationInfo.uid, aInfo2.applicationInfo.packageName);     // Catch: Throwable -> L77
        goto L241
    L80:
        throw new IllegalArgumentException("FLAG_CANT_SAVE_STATE not supported here");     // Catch: Throwable -> L77
    L219:
        NeededUriGrants creatorIntentGrants = this.mSupervisor.mService.mUgmInternal.checkGrantUriPermissionFromIntent(intent2, creatorUid3, aInfo2.applicationInfo.packageName, UserHandle.getUserId(aInfo2.applicationInfo.uid));     // Catch: Throwable -> L46 SecurityException -> L63
        if (intentGrants2 != null) goto L61;
        intentGrants2 = creatorIntentGrants;
    L62:
        int r7 = realCallingUid;
        intents3 = intents3;
        r16 = true;
        realCallingUid2 = r7;
        starters2 = starters2;
        aInfo2 = aInfo2;
        intentGrants = intentGrants2;
        startingUidPkgs2 = startingUidPkgs2;
        creatorPackage2 = creatorPackage;
        creatorUid4 = creatorUid3;
        componentSpecified = componentSpecified;
        callingUid2 = callingUid2;
        realCallingPid = realCallingPid;
        r4 = callingPackage;
        goto L251
    L61:
        intentGrants2.merge(creatorIntentGrants);     // Catch: Throwable -> L46 SecurityException -> L63
    L63:
        securityException = move-exception;
        creatorUid4 = creatorUid3;
        realCallingUid2 = realCallingUid;
        creatorPackage2 = creatorPackage;
        intentGrants3 = intentGrants2;
        ActivityStarter.logAndThrowExceptionForIntentRedirect(this.mService.mContext, 2, intent2, creatorUid4, creatorPackage2, filterCallingUid2, callingPackage, securityException);     // Catch: Throwable -> L68
        r4 = callingPackage;
    L68:
        th = th;
        goto L209
    L70:
        th = th;
    L87:
        Slog.d(TAG, "Not allowed to start activity since no uri permission.");     // Catch: Throwable -> L77
        Binder.restoreCallingIdentity(origId);
        return -96;
    L46:
        th = th;
    L49:
        creatorUid3 = -1;
    L121:
        th = th;
    L123:
        th = th;
        goto L209
    L35:
        componentSpecified = false;
        goto L36
    L129:
        throw new IllegalArgumentException("File descriptors passed in Intent");     // Catch: Throwable -> L109
    L125:
        th = th;
        goto L209
    L130:
        SparseArray<String> startingUidPkgs3 = startingUidPkgs;
        ActivityStarter[] starters4 = starters;
        int filterCallingUid3 = filterCallingUid;
        if (startingUidPkgs3.size() <= 1) goto L140;
        StringBuilder sb = new StringBuilder("startActivities: different apps [");     // Catch: Throwable -> L109
        int size = startingUidPkgs3.size();     // Catch: Throwable -> L109
        int i3 = 0;
    L133:
        if (i3 >= size) goto L139;
        sb.append(startingUidPkgs3.valueAt(i3));     // Catch: Throwable -> L109
        if (i3 != (size - 1)) goto L137;
        String r9 = "]";
    L138:
        sb.append(r9);     // Catch: Throwable -> L109
        i3 = i3 + 1;     // Catch: Throwable -> L109
        goto L133
    L137:
        r9 = ", ";
        goto L138
    L139:
        sb.append(" from ");     // Catch: Throwable -> L109
        sb.append(callingPackage);     // Catch: Throwable -> L109
        Slog.wtf(TAG, sb.toString());     // Catch: Throwable -> L109
    L140:
        ActivityRecord[] outActivity = new ActivityRecord[1];     // Catch: Throwable -> L109
        WindowManagerGlobalLock r10 = this.mService.mGlobalLock;     // Catch: Throwable -> L109
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L109
        monitor-enter(r10);     // Catch: Throwable -> L109
        this.mService.deferWindowLayout();     // Catch: Throwable -> L200
        this.mService.mWindowManager.mStartingSurfaceController.beginDeferAddStartingWindow();     // Catch: Throwable -> L200
        int i4 = 0;
        IBinder resultTo2 = resultTo;
    L144:
        ActivityOptions r17 = null;
    L154:
        th = th;
    L195:
        StartingSurfaceController r6 = this.mService.mWindowManager.mStartingSurfaceController;     // Catch: Throwable -> L161
        if (options == null) goto L198;
        r17 = options.getOriginalOptions();     // Catch: Throwable -> L161
    L198:
        r6.endDeferAddStartingWindow(r17);     // Catch: Throwable -> L161
        this.mService.continueWindowLayout();     // Catch: Throwable -> L161
        throw th;     // Catch: Throwable -> L161
    L146:
        if (i4 >= starters4.length) goto L185;
        int startResult = starters4[i4].setResultTo(resultTo2).setOutActivity(outActivity).execute();     // Catch: Throwable -> L154
        if (startResult < 0) goto L149;
        ActivityRecord started = outActivity[0];     // Catch: Throwable -> L154
        if (started != null) goto L171;
    L174:
        IBinder resultTo3 = resultTo;
    L179:
        th = th;
        goto L195
    L176:
        if (i4 >= (starters4.length - 1)) goto L183;
        starters4[i4 + 1].getIntent().addFlags(268435456);     // Catch: Throwable -> L179
    L183:
        resultTo2 = resultTo3;
        i4 = i4 + 1;
        goto L144
    L171:
        if (started.getUid() != filterCallingUid3) goto L174;
        resultTo3 = started.token;     // Catch: Throwable -> L154
        goto L183
    L149:
        int startResult2 = i4 + 1;     // Catch: Throwable -> L154
    L150:
        if (startResult2 >= starters4.length) goto L157;
        int j = startResult2;
        this.mFactory.recycle(starters4[j]);     // Catch: Throwable -> L154
        startResult2 = j + 1;
        goto L150
    L157:
        StartingSurfaceController r8 = this.mService.mWindowManager.mStartingSurfaceController;     // Catch: Throwable -> L161
        if (options == null) goto L163;
        r17 = options.getOriginalOptions();     // Catch: Throwable -> L161
    L163:
        r8.endDeferAddStartingWindow(r17);     // Catch: Throwable -> L161
        this.mService.continueWindowLayout();     // Catch: Throwable -> L161
        monitor-exit(r10);     // Catch: Throwable -> L161
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return startResult;
    L185:
        StartingSurfaceController r13 = this.mService.mWindowManager.mStartingSurfaceController;     // Catch: Throwable -> L161
        if (options == null) goto L188;
        r17 = options.getOriginalOptions();     // Catch: Throwable -> L161
    L188:
        r13.endDeferAddStartingWindow(r17);     // Catch: Throwable -> L161
        this.mService.continueWindowLayout();     // Catch: Throwable -> L161
        monitor-exit(r10);     // Catch: Throwable -> L161
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L193
        Binder.restoreCallingIdentity(origId);
        return 0;
    L200:
        th = th;
    L202:
        monitor-exit(r10);     // Catch: Throwable -> L161
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L193
        throw th;     // Catch: Throwable -> L193
    L161:
        th = th;
    L193:
        th = th;
    L205:
        th = th;
    L207:
        th = th;
        goto L209
    L23:
        bottomOptions2 = null;
        goto L222
    L17:
        if (r2 != null) goto L19;
        callingUid3 = realCallingUid;
        callingPid = callingUid2;
        goto L20
    L19:
        callingPid = -1;
        callingUid3 = -1;
        goto L20
    L13:
        r1 = Binder.getCallingUid();
        goto L14
    L9:
        r0 = Binder.getCallingPid();
        goto L10
    L212:
        throw new IllegalArgumentException("intents are length different than resolvedTypes");
    L214:
        throw new NullPointerException("resolvedTypes is null");
    L216:
        throw new NullPointerException("intents is null");
    }

    private static /* synthetic */ Intent[] lambda$startActivities$0(int x$0) {
        return new Intent[x$0];
    }

    int startActivityInTaskFragment(TaskFragment taskFragment, Intent activityIntent, SafeActivityOptions activityOptions, IBinder resultTo, int callingUid, int callingPid, IBinder errorCallbackToken) {
        if (resultTo == null) goto L4;
        ActivityRecord caller = ActivityRecord.forTokenLocked(resultTo);
    L5:
        String resolvedType = activityIntent.resolveTypeIfNeeded(this.mService.mContext.getContentResolver());
        ActivityStarter r2 = obtainStarter(activityIntent, "startActivityInTaskFragment").setActivityOptions(activityOptions).setInTaskFragment(taskFragment).setResultTo(resultTo).setRequestCode(-1).setResolvedType(resolvedType).setCallingUid(callingUid).setCallingPid(callingPid).setRealCallingUid(callingUid).setRealCallingPid(callingPid);
        if (caller == null) goto L8;
        int r3 = caller.mUserId;
    L10:
        return r2.setUserId(r3).setErrorCallbackToken(errorCallbackToken).execute();
    L8:
        r3 = this.mService.getCurrentUserId();
        goto L10
    L4:
        caller = null;
        goto L5
    }

    boolean startExistingRecentsIfPossible(Intent intent, ActivityOptions options) {
        Trace.traceBegin(32, "startExistingRecents");     // Catch: Throwable -> L9
        if (startExistingRecents(intent, options) == false) goto L7;
        Trace.traceEnd(32);
        return true;
    L7:
        Trace.traceEnd(32);
        return false;
    L9:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private boolean startExistingRecents(Intent intent, ActivityOptions options) {
        if (this.mService.getRecentTasks().getRecentsComponent().equals(intent.getComponent()) == false) goto L5;
        int r0 = 3;
    L6:
        int activityType = r0;
        Task rootTask = this.mService.mRootWindowContainer.getDefaultTaskDisplayArea().getRootTask(0, activityType);
        if (rootTask != null) goto L9;
        return false;
    L9:
        ActivityRecord r = rootTask.topRunningActivity();
        if (r == null) goto L48;
        if (r.isVisibleRequested() == false) goto L18;
        if (rootTask.isTopRootTaskInDisplayArea() == true) goto L48;
    L18:
        if (r.attachedToProcess() == false) goto L48;
        if (r.mActivityComponent.equals(intent.getComponent()) == false) goto L48;
        if (this.mService.isCallerRecents(r.getUid()) == false) goto L48;
        if (r.mDisplayContent.isKeyguardLocked() == true) goto L48;
        this.mService.mRootWindowContainer.startPowerModeLaunchIfNeeded(true, r);
        ActivityMetricsLogger.LaunchingState launchingState = this.mSupervisor.getActivityMetricsLogger().notifyActivityLaunching(intent);
        Task task = r.getTask();
        this.mService.deferWindowLayout();
        int prefetchState = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(r.packageName, r.getUid());
        boolean prefetchAffected = SysMonitorFwBridge.getFactory().getPrefetchState().prefetchActivityNotShown(prefetchState);
        int startType = SysOptBridge.getFactory().getAppRecordManagerService().getActivityStartType(r, prefetchAffected);
        SysOptBridge.getFactory().getIntelliScene().onActivityStartEventSync(r, startType, prefetchAffected);
        Transition transition = r.mTransitionController.getCollectingTransition();     // Catch: Throwable -> L40
        if (transition != null) goto L49;
    L33:
        task.moveToFront("startExistingRecents");     // Catch: Throwable -> L40
        task.mInResumeTopActivity = true;     // Catch: Throwable -> L40
        task.resumeTopActivity(null, options, true);     // Catch: Throwable -> L40
        this.mSupervisor.getActivityMetricsLogger().notifyActivityLaunched(launchingState, 2, false, r, options);     // Catch: Throwable -> L38
        task.mInResumeTopActivity = false;
        this.mService.continueWindowLayout();
        return true;
    L38:
        th = th;
    L42:
        task.mInResumeTopActivity = false;
        this.mService.continueWindowLayout();
        throw th;
    L49:
        transition.setRemoteAnimationApp(r.app.getThread());     // Catch: Throwable -> L31
        transition.setTransientLaunch(r, TaskDisplayArea.getRootTaskAbove(rootTask));     // Catch: Throwable -> L31
    L31:
        th = th;
    L40:
        th = th;
    L48:
        return false;
    L5:
        r0 = 2;
        goto L6
    }

    void registerRemoteAnimationForNextActivityStart(String packageName, RemoteAnimationAdapter adapter, IBinder launchCookie) {
        this.mPendingRemoteAnimationRegistry.addPendingAnimation(packageName, adapter, launchCookie);
    }

    PendingRemoteAnimationRegistry getPendingRemoteAnimationRegistry() {
        return this.mPendingRemoteAnimationRegistry;
    }

    ActivityRecord getLastStartActivity() {
        if (this.mLastStarter != null) goto L7;
        return null;
    L7:
        return this.mLastStarter.mStartActivity;
    }

    void dumpLastHomeActivityStartResult(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mLastHomeActivityStartResult=");
        pw.println(this.mLastHomeActivityStartResult);
    }

    void dump(PrintWriter pw, String prefix, String dumpPackage) {
        boolean dumped = false;
        boolean dump = false;
        if (dumpPackage == null) goto L5;
        boolean dumpPackagePresent = true;
    L7:
        if (this.mLastHomeActivityStartRecord == null) goto L13;
        if (dumpPackagePresent == true) goto L10;
    L11:
        dumped = true;
        dumpLastHomeActivityStartResult(pw, prefix);
        pw.print(prefix);
        pw.println("mLastHomeActivityStartRecord:");
        this.mLastHomeActivityStartRecord.dump(pw, prefix + "  ", true);
        goto L13
    L10:
        if (dumpPackage.equals(this.mLastHomeActivityStartRecord.packageName) == true) goto L11;
    L13:
        if (this.mLastStarter == null) goto L32;
        if (dumpPackagePresent == true) goto L16;
    L23:
        dump = true;
    L25:
        if (dump == false) goto L32;
        if (dumped == true) goto L28;
        dumped = true;
        dumpLastHomeActivityStartResult(pw, prefix);
    L28:
        pw.print(prefix);
        pw.println("mLastStarter:");
        this.mLastStarter.dump(pw, prefix + "  ");
        if (dumpPackagePresent == false) goto L32;
        return;
    L16:
        if (this.mLastStarter.relatedToPackage(dumpPackage) == true) goto L23;
        if (this.mLastHomeActivityStartRecord == null) goto L25;
        if (dumpPackage.equals(this.mLastHomeActivityStartRecord.packageName) == false) goto L25;
    L32:
        if (this.mHomeLaunchingTaskDisplayAreas.isEmpty() == true) goto L34;
        dumped = true;
        pw.print(prefix);
        pw.println("mHomeLaunchingTaskDisplayAreas:" + this.mHomeLaunchingTaskDisplayAreas);
    L34:
        if (dumped == true) goto L37;
        pw.print(prefix);
        pw.println("(nothing)");
        return;
    L37:
        return;
    L5:
        dumpPackagePresent = false;
        goto L7
    }
}
