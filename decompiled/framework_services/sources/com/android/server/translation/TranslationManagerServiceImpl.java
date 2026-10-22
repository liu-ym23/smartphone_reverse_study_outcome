package com.android.server.translation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.service.translation.TranslationServiceInfo;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.inputmethod.InputMethodInfo;
import android.view.translation.ITranslationServiceCallback;
import android.view.translation.TranslationCapability;
import android.view.translation.TranslationContext;
import android.view.translation.TranslationSpec;
import android.view.translation.UiTranslationSpec;
import com.android.internal.os.IResultReceiver;
import com.android.internal.os.TransferPipe;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class TranslationManagerServiceImpl extends AbstractPerUserSystemService<TranslationManagerServiceImpl, TranslationManagerService> implements IBinder.DeathRecipient {
    private static final boolean DEBUG = false;
    private static final String TAG = "TranslationManagerServiceImpl";
    private final ArrayMap<IBinder, ActiveTranslation> mActiveTranslations;
    private final ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private final RemoteCallbackList<IRemoteCallback> mCallbacks;
    private WeakReference<ActivityTaskManagerInternal.ActivityTokens> mLastActivityTokens;
    private final TranslationServiceRemoteCallback mRemoteServiceCallback;
    private RemoteTranslationService mRemoteTranslationService;
    private ServiceInfo mRemoteTranslationServiceInfo;
    private final RemoteCallbackList<IRemoteCallback> mTranslationCapabilityCallbacks;
    private TranslationServiceInfo mTranslationServiceInfo;
    private final ArraySet<IBinder> mWaitingFinishedCallbackActivities;

    private static final class ActiveTranslation {
        public boolean isPaused;
        public final String packageName;
        public final TranslationSpec sourceSpec;
        public final TranslationSpec targetSpec;
        public final int translatedAppUid;

        /* synthetic */ ActiveTranslation(TranslationSpec r1, TranslationSpec r2, int r3, String r4, TranslationManagerServiceImplIA r5) {
            this(r1, r2, r3, r4);
        }

        private ActiveTranslation(TranslationSpec sourceSpec, TranslationSpec targetSpec, int translatedAppUid, String packageName) {
            this.isPaused = false;
            this.sourceSpec = sourceSpec;
            this.targetSpec = targetSpec;
            this.translatedAppUid = translatedAppUid;
            this.packageName = packageName;
        }
    }

    private final class TranslationServiceRemoteCallback extends ITranslationServiceCallback.Stub {
        final /* synthetic */ TranslationManagerServiceImpl this$0;

        /* synthetic */ TranslationServiceRemoteCallback(TranslationManagerServiceImpl r1, TranslationManagerServiceImplIA r2) {
            this(r1);
        }

        private TranslationServiceRemoteCallback(TranslationManagerServiceImpl r1) {
            this.this$0 = r1;
        }

        public void updateTranslationCapability(TranslationCapability capability) {
            if (capability != null) goto L5;
            Slog.wtf(TranslationManagerServiceImpl.TAG, "received a null TranslationCapability from TranslationService.");
            return;
        L5:
            TranslationManagerServiceImpl.m8637$$Nest$mnotifyClientsTranslationCapability(this.this$0, capability);
        }
    }

    public static /* synthetic */ void $r8$lambda$Rl2aRRQwTHg90n7dONkwfe2wugs(TranslationManagerServiceImpl r0, int r1, Bundle r2, List r3, IRemoteCallback r4, Object r5) {
        r0.lambda$invokeCallbacks$0(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$j6tbxkY2NmhHvTAm3VTwgKmWdLs(Bundle r0, IRemoteCallback r1, Object r2) {
        lambda$notifyClientsTranslationCapability$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyClientsTranslationCapability, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8637$$Nest$mnotifyClientsTranslationCapability(TranslationManagerServiceImpl r0, TranslationCapability r1) {
        r0.notifyClientsTranslationCapability(r1);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    protected TranslationManagerServiceImpl(TranslationManagerService master, Object lock, int userId, boolean disabled) {
        super(master, lock, userId);
        this.mRemoteServiceCallback = new TranslationServiceRemoteCallback(this, null);
        this.mTranslationCapabilityCallbacks = new RemoteCallbackList();
        this.mWaitingFinishedCallbackActivities = new ArraySet();
        this.mActiveTranslations = new ArrayMap();
        this.mCallbacks = new RemoteCallbackList();
        updateRemoteServiceLocked();
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        this.mTranslationServiceInfo = new TranslationServiceInfo(getContext(), serviceComponent, isTemporaryServiceSetLocked(), this.mUserId);
        this.mRemoteTranslationServiceInfo = this.mTranslationServiceInfo.getServiceInfo();
        return this.mTranslationServiceInfo.getServiceInfo();
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        boolean enabledChanged = super.updateLocked(disabled);
        updateRemoteServiceLocked();
        return enabledChanged;
    }

    private void updateRemoteServiceLocked() {
        if (this.mRemoteTranslationService != null) goto L5;
        return;
    L5:
        if (((TranslationManagerService) this.mMaster).debug == false) goto L7;
        Slog.d(TAG, "updateRemoteService(): destroying old remote service");
    L7:
        this.mRemoteTranslationService.unbind();
        this.mRemoteTranslationService = null;
    }

    private RemoteTranslationService ensureRemoteServiceLocked() {
        if (this.mRemoteTranslationService != null) goto L25;
        String serviceName = getComponentNameLocked();
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        long identity = Binder.clearCallingIdentity();
        boolean isServiceAvailableForUser = isServiceAvailableForUser(serviceComponent);     // Catch: Throwable -> L15
        if (((TranslationManagerService) this.mMaster).verbose == false) goto L17;
        Slog.v(TAG, "ensureRemoteServiceLocked(): isServiceAvailableForUser=" + isServiceAvailableForUser);     // Catch: Throwable -> L15
    L17:
        Binder.restoreCallingIdentity(identity);
        if (isServiceAvailableForUser == true) goto L21;
        Slog.w(TAG, "ensureRemoteServiceLocked(): " + serviceComponent + " is not available,");
        return null;
    L21:
        this.mRemoteTranslationService = new RemoteTranslationService(getContext(), serviceComponent, this.mUserId, false, this.mRemoteServiceCallback);
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L7:
        if (((TranslationManagerService) this.mMaster).verbose == false) goto L9;
        Slog.v(TAG, "ensureRemoteServiceLocked(): no service component name.");
    L9:
        return null;
    L25:
        return this.mRemoteTranslationService;
    }

    private boolean isServiceAvailableForUser(ComponentName serviceComponent) {
        Intent intent = new Intent("android.service.translation.TranslationService").setComponent(serviceComponent);
        ResolveInfo resolveInfo = getContext().getPackageManager().resolveServiceAsUser(intent, 132, this.mUserId);
        if (resolveInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (resolveInfo.serviceInfo == null) goto L7;
        return true;
    }

    void onTranslationCapabilitiesRequestLocked(int sourceFormat, int destFormat, ResultReceiver resultReceiver) {
        RemoteTranslationService remoteService = ensureRemoteServiceLocked();
        if (remoteService == null) goto L5;
        remoteService.onTranslationCapabilitiesRequest(sourceFormat, destFormat, resultReceiver);
        return;
    L5:
        Slog.v(TAG, "onTranslationCapabilitiesRequestLocked(): no remote service.");
        resultReceiver.send(2, null);
    }

    public void registerTranslationCapabilityCallback(IRemoteCallback callback, int sourceUid) {
        this.mTranslationCapabilityCallbacks.register(callback, Integer.valueOf(sourceUid));
        ensureRemoteServiceLocked();
    }

    public void unregisterTranslationCapabilityCallback(IRemoteCallback callback) {
        this.mTranslationCapabilityCallbacks.unregister(callback);
    }

    void onSessionCreatedLocked(TranslationContext translationContext, int sessionId, IResultReceiver resultReceiver) throws RemoteException {
        RemoteTranslationService remoteService = ensureRemoteServiceLocked();
        if (remoteService == null) goto L5;
        remoteService.onSessionCreated(translationContext, sessionId, resultReceiver);
        return;
    L5:
        Slog.v(TAG, "onSessionCreatedLocked(): no remote service.");
        resultReceiver.send(2, null);
    }

    private int getAppUidByComponentName(Context context, ComponentName componentName, int userId) {
        if (componentName == null) goto L12;
        int translatedAppUid = context.getPackageManager().getApplicationInfoAsUser(componentName.getPackageName(), 0, userId).uid;     // Catch: PackageManager.NameNotFoundException -> L6
        return translatedAppUid;
    L7:
        Slog.d(TAG, "Cannot find packageManager for" + componentName);
        return -1;
    L12:
        return -1;
    }

    public void onTranslationFinishedLocked(boolean activityDestroyed, IBinder token, ComponentName componentName) {
        int translatedAppUid = getAppUidByComponentName(getContext(), componentName, getUserId());
        String packageName = componentName.getPackageName();
        if (activityDestroyed == false) goto L5;
    L8:
        invokeCallbacks(3, null, null, packageName, translatedAppUid);
        this.mWaitingFinishedCallbackActivities.remove(token);
        this.mActiveTranslations.remove(token);
        return;
    L5:
        if (this.mWaitingFinishedCallbackActivities.contains(token) == true) goto L8;
    }

    public void updateUiTranslationStateLocked(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, List<AutofillId> viewIds, IBinder token, int taskId, UiTranslationSpec uiTranslationSpec) {
        ActivityTaskManagerInternal.ActivityTokens candidateActivityTokens = this.mActivityTaskManagerInternal.getAttachedNonFinishingActivityForTask(taskId, token);
        if (candidateActivityTokens != null) goto L6;
        Slog.w(TAG, "Unknown activity or it was finished to query for update translation state for token=" + token + " taskId=" + taskId + " for state= " + state);
        return;
    L6:
        this.mLastActivityTokens = new WeakReference(candidateActivityTokens);
        if (state != 3) goto L9;
        this.mWaitingFinishedCallbackActivities.add(token);
    L9:
        IBinder activityToken = candidateActivityTokens.getActivityToken();
        candidateActivityTokens.getApplicationThread().updateUiTranslationState(activityToken, state, sourceSpec, targetSpec, viewIds, uiTranslationSpec);     // Catch: RemoteException -> L12
    L14:
        ComponentName componentName = this.mActivityTaskManagerInternal.getActivityName(activityToken);
        int translatedAppUid = getAppUidByComponentName(getContext(), componentName, getUserId());
        String packageName = componentName.getPackageName();
        invokeCallbacksIfNecessaryLocked(state, sourceSpec, targetSpec, packageName, token, translatedAppUid);
        updateActiveTranslationsLocked(state, sourceSpec, targetSpec, packageName, token, translatedAppUid);
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Update UiTranslationState fail: " + e);
        goto L14
    }

    private void updateActiveTranslationsLocked(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, String packageName, IBinder shareableActivityToken, int translatedAppUid) {
        ActiveTranslation activeTranslation = this.mActiveTranslations.get(shareableActivityToken);
        switch(state) {
            case 0: goto L14;
            case 1: goto L11;
            case 2: goto L8;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        int r12 = translatedAppUid;
    L22:
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "Updating to translation state=" + state + " for app with uid=" + r12 + " packageName=" + packageName);
        return;
    L25:
        return;
    L5:
        if (activeTranslation == null) goto L7;
        this.mActiveTranslations.remove(shareableActivityToken);
        r12 = translatedAppUid;
        goto L22
    L7:
        r12 = translatedAppUid;
        goto L22
    L8:
        if (activeTranslation == null) goto L10;
        activeTranslation.isPaused = false;
        r12 = translatedAppUid;
        goto L22
    L10:
        r12 = translatedAppUid;
        goto L22
    L11:
        if (activeTranslation == null) goto L13;
        activeTranslation.isPaused = true;
        r12 = translatedAppUid;
        goto L22
    L13:
        r12 = translatedAppUid;
        goto L22
    L14:
        if (activeTranslation == null) goto L26;
        r12 = translatedAppUid;
        goto L22
    L26:
        shareableActivityToken.linkToDeath(this, 0);     // Catch: RemoteException -> L17
        r12 = translatedAppUid;
        this.mActiveTranslations.put(shareableActivityToken, new ActiveTranslation(sourceSpec, targetSpec, r12, packageName, null));
    L17:
        e = move-exception;
        Slog.w(TAG, "Failed to call linkToDeath for translated app with uid=" + translatedAppUid + "; activity is already dead", e);
        invokeCallbacks(3, sourceSpec, targetSpec, packageName, translatedAppUid);
    }

    private void invokeCallbacksIfNecessaryLocked(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, String packageName, IBinder shareableActivityToken, int translatedAppUid) {
        boolean shouldInvokeCallbacks = true;
        ActiveTranslation activeTranslation = this.mActiveTranslations.get(shareableActivityToken);
        if (activeTranslation != null) goto L6;
        if (state == 0) goto L27;
        shouldInvokeCallbacks = false;
        Slog.w(TAG, "Updating to translation state=" + state + " for app with uid=" + translatedAppUid + " packageName=" + packageName + " but no active translation was found for it");
        int stateForCallbackInvocation = state;
    L28:
        if (shouldInvokeCallbacks == false) goto L31;
        invokeCallbacks(stateForCallbackInvocation, sourceSpec, targetSpec, packageName, translatedAppUid);
        return;
    L31:
        return;
    L27:
        stateForCallbackInvocation = state;
        goto L28
    L6:
        switch(state) {
            case 0: goto L16;
            case 1: goto L13;
            case 2: goto L10;
            case 3: goto L8;
            default: goto L35;
        };
    L8:
        shouldInvokeCallbacks = false;
        stateForCallbackInvocation = state;
        goto L28
    L35:
        stateForCallbackInvocation = state;
        goto L28
    L10:
        if (activeTranslation.isPaused == true) goto L32;
        shouldInvokeCallbacks = false;
        stateForCallbackInvocation = state;
        goto L28
    L32:
        stateForCallbackInvocation = state;
        goto L28
    L13:
        if (activeTranslation.isPaused == false) goto L33;
        shouldInvokeCallbacks = false;
        stateForCallbackInvocation = state;
        goto L28
    L33:
        stateForCallbackInvocation = state;
        goto L28
    L16:
        if (activeTranslation.sourceSpec.getLocale().equals(sourceSpec.getLocale()) == true) goto L18;
    L20:
        boolean specsAreIdentical = false;
    L22:
        if (specsAreIdentical == true) goto L24;
        stateForCallbackInvocation = state;
        goto L28
    L24:
        if (activeTranslation.isPaused == false) goto L26;
        stateForCallbackInvocation = 2;
        goto L28
    L26:
        shouldInvokeCallbacks = false;
        stateForCallbackInvocation = state;
        goto L28
    L18:
        if (activeTranslation.targetSpec.getLocale().equals(targetSpec.getLocale()) == false) goto L20;
        specsAreIdentical = true;
        goto L22
    }

    public void dumpLocked(String prefix, FileDescriptor fd, PrintWriter pw) {
        if (this.mLastActivityTokens == null) goto L24;
        ActivityTaskManagerInternal.ActivityTokens activityTokens = this.mLastActivityTokens.get();
        if (activityTokens != null) goto L36;
        return;
    L36:
        TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L11 IOException -> L13
        activityTokens.getApplicationThread().dumpActivity(tp.getWriteFd(), activityTokens.getActivityToken(), prefix, new String[]{"--dump-dumpable", "UiTranslationController"});     // Catch: Throwable -> L15
        tp.go(fd);     // Catch: Throwable -> L15
        tp.close();     // Catch: RemoteException -> L11 IOException -> L13
    L25:
        int waitingFinishCallbackSize = this.mWaitingFinishedCallbackActivities.size();
        if (waitingFinishCallbackSize <= 0) goto L31;
        pw.print(prefix);
        pw.print("number waiting finish callback activities: ");
        pw.println(waitingFinishCallbackSize);
        Iterator<IBinder> r1 = this.mWaitingFinishedCallbackActivities.iterator();
    L29:
        if (r1.hasNext() == false) goto L38;
        IBinder activityToken = r1.next();
        pw.print(prefix);
        pw.print("shareableActivityToken: ");
        pw.println(activityToken);
        goto L29
    L38:
        return;
    L31:
        return;
    L15:
        th = move-exception;
        tp.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: RemoteException -> L11 IOException -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L11 IOException -> L13
    L13:
        e = move-exception;
        pw.println(prefix + "Failure while dumping the activity: " + e);
    L21:
        pw.println(prefix + "Got a RemoteException while dumping the activity");
        goto L25
    L24:
        pw.print(prefix);
        pw.println("No requested UiTranslation Activity.");
        goto L25
    }

    private void invokeCallbacks(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, String packageName, final int translatedAppUid) {
        final Bundle result = createResultForCallback(state, sourceSpec, targetSpec, packageName);
        int registeredCallbackCount = this.mCallbacks.getRegisteredCallbackCount();
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Invoking " + registeredCallbackCount + " callbacks for translation state=" + state + " for app with uid=" + translatedAppUid + " packageName=" + packageName);
    L5:
        if (registeredCallbackCount != 0) goto L7;
        return;
    L7:
        final List<InputMethodInfo> enabledInputMethods = getEnabledInputMethods();
        this.mCallbacks.broadcast(new TranslationManagerServiceImpl$$ExternalSyntheticLambda1(this, translatedAppUid, result, enabledInputMethods));
    }

    private /* synthetic */ void lambda$invokeCallbacks$0(int translatedAppUid, Bundle result, List enabledInputMethods, IRemoteCallback callback, Object uid) {
        invokeCallback(((Integer) uid).intValue(), translatedAppUid, callback, result, enabledInputMethods);
    }

    private List<InputMethodInfo> getEnabledInputMethods() {
        return ((InputMethodManagerInternal) LocalServices.getService(InputMethodManagerInternal.class)).getEnabledInputMethodListAsUser(this.mUserId);
    }

    private Bundle createResultForCallback(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, String packageName) {
        Bundle result = new Bundle();
        result.putInt("state", state);
        if (sourceSpec == null) goto L5;
        result.putSerializable("source_locale", sourceSpec.getLocale());
        result.putSerializable("target_locale", targetSpec.getLocale());
    L5:
        result.putString("package_name", packageName);
        return result;
    }

    private void invokeCallback(int callbackSourceUid, int translatedAppUid, IRemoteCallback callback, Bundle result, List<InputMethodInfo> enabledInputMethods) {
        if (callbackSourceUid == translatedAppUid) goto L23;
        boolean isIme = false;
        Iterator<InputMethodInfo> r3 = enabledInputMethods.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        InputMethodInfo inputMethod = r3.next();
        if (callbackSourceUid != inputMethod.getServiceInfo().applicationInfo.uid) goto L11;
        isIme = true;
    L16:
        if (isIme == true) goto L25;
        return;
    L25:
        callback.sendResult(result);     // Catch: RemoteException -> L20
        return;
    L20:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke UiTranslationStateCallback: " + e);
        return;
    L23:
        callback.sendResult(result);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke UiTranslationStateCallback: " + e);
    }

    public void registerUiTranslationStateCallbackLocked(IRemoteCallback callback, int sourceUid) {
        this.mCallbacks.register(callback, Integer.valueOf(sourceUid));
        int numActiveTranslations = this.mActiveTranslations.size();
        Slog.i(TAG, "New registered callback for sourceUid=" + sourceUid + " with currently " + numActiveTranslations + " active translations");
        if (numActiveTranslations != 0) goto L5;
        return;
    L5:
        List<InputMethodInfo> enabledInputMethods = getEnabledInputMethods();
        int i = 0;
    L7:
        if (i >= this.mActiveTranslations.size()) goto L16;
        ActiveTranslation activeTranslation = this.mActiveTranslations.valueAt(i);
        int translatedAppUid = activeTranslation.translatedAppUid;
        String packageName = activeTranslation.packageName;
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Triggering callback for sourceUid=" + sourceUid + " for translated app with uid=" + translatedAppUid + "packageName=" + packageName + " isPaused=" + activeTranslation.isPaused);
    L11:
        Bundle startedResult = createResultForCallback(0, activeTranslation.sourceSpec, activeTranslation.targetSpec, packageName);
        IRemoteCallback callback2 = callback;
        int sourceUid2 = sourceUid;
        invokeCallback(sourceUid2, translatedAppUid, callback2, startedResult, enabledInputMethods);
        if (activeTranslation.isPaused == false) goto L14;
        Bundle pausedResult = createResultForCallback(1, activeTranslation.sourceSpec, activeTranslation.targetSpec, packageName);
        invokeCallback(sourceUid2, translatedAppUid, callback2, pausedResult, enabledInputMethods);
    L14:
        i = i + 1;
        sourceUid = sourceUid2;
        callback = callback2;
        goto L7
    }

    public void unregisterUiTranslationStateCallback(IRemoteCallback callback) {
        this.mCallbacks.unregister(callback);
    }

    public ComponentName getServiceSettingsActivityLocked() {
        if (this.mTranslationServiceInfo != null) goto L5;
        return null;
    L5:
        String activityName = this.mTranslationServiceInfo.getSettingsActivity();
        if (activityName != null) goto L8;
        return null;
    L8:
        String packageName = this.mTranslationServiceInfo.getServiceInfo().packageName;
        return new ComponentName(packageName, activityName);
    }

    private void notifyClientsTranslationCapability(TranslationCapability capability) {
        final Bundle res = new Bundle();
        res.putParcelable("translation_capabilities", capability);
        this.mTranslationCapabilityCallbacks.broadcast(new TranslationManagerServiceImpl$$ExternalSyntheticLambda0(res));
    }

    private static /* synthetic */ void lambda$notifyClientsTranslationCapability$1(Bundle res, IRemoteCallback callback, Object uid) {
        callback.sendResult(res);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke UiTranslationStateCallback: " + e);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder who) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mWaitingFinishedCallbackActivities.remove(who);     // Catch: Throwable -> L7
        ActiveTranslation activeTranslation = this.mActiveTranslations.remove(who);     // Catch: Throwable -> L7
        if (activeTranslation == null) goto L9;
        invokeCallbacks(3, activeTranslation.sourceSpec, activeTranslation.targetSpec, activeTranslation.packageName, activeTranslation.translatedAppUid);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
