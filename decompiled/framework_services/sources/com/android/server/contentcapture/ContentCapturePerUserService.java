package com.android.server.contentcapture;

import android.app.ActivityManagerInternal;
import android.app.assist.ActivityId;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.content.ContentCaptureOptions;
import android.content.Context;
import android.content.pm.ActivityPresentationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.contentcapture.ActivityEvent;
import android.service.contentcapture.ContentCaptureService;
import android.service.contentcapture.ContentCaptureServiceInfo;
import android.service.contentcapture.FlushMetrics;
import android.service.contentcapture.IContentCaptureServiceCallback;
import android.service.contentcapture.IDataShareCallback;
import android.service.contentcapture.SnapshotData;
import android.service.voice.VoiceInteractionManagerInternal;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.contentcapture.ContentCaptureCondition;
import android.view.contentcapture.DataRemovalRequest;
import android.view.contentcapture.DataShareRequest;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.CollectionUtils;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ContentCapturePerUserService extends AbstractPerUserSystemService<ContentCapturePerUserService, ContentCaptureManagerService> implements RemoteContentCaptureService.ContentCaptureServiceCallbacks {
    static final int EVENT_LOG_CONNECT_STATE_CONNECTED = 1;
    private static final int EVENT_LOG_CONNECT_STATE_DIED = 0;
    static final int EVENT_LOG_CONNECT_STATE_DISCONNECTED = 2;
    private static final String TAG = null;
    private final ArrayMap<String, ArraySet<ContentCaptureCondition>> mConditionsByPkg;
    private ContentCaptureServiceInfo mInfo;
    RemoteContentCaptureService mRemoteService;
    private final ContentCaptureServiceRemoteCallback mRemoteServiceCallback;
    private final SparseArray<ContentCaptureServerSession> mSessions;
    private boolean mZombie;

    private final class ContentCaptureServiceRemoteCallback extends IContentCaptureServiceCallback.Stub {
        final /* synthetic */ ContentCapturePerUserService this$0;

        /* synthetic */ ContentCaptureServiceRemoteCallback(ContentCapturePerUserService r1, ContentCapturePerUserServiceIA r2) {
            this(r1);
        }

        private ContentCaptureServiceRemoteCallback(ContentCapturePerUserService r1) {
            this.this$0 = r1;
        }

        public void setContentCaptureWhitelist(List<String> packages, List<ComponentName> activities) {
            if (((ContentCaptureManagerService) ContentCapturePerUserService.access$000(this.this$0)).verbose == false) goto L13;
            String r0 = ContentCapturePerUserService.m3226$$Nest$sfgetTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("setContentCaptureWhitelist(");
            if (packages != null) goto L7;
            String r2 = "null_packages";
        L8:
            r1.append(r2);
            r1.append(", ");
            if (activities != null) goto L11;
            String r3 = "null_activities";
        L12:
            r1.append(r3);
            r1.append(") for user ");
            r1.append(ContentCapturePerUserService.access$100(this.this$0));
            Slog.v(r0, r1.toString());
            goto L13
        L11:
            r3 = activities.size() + " activities";
            goto L12
        L7:
            r2 = packages.size() + " packages";
        L13:
            ArraySet<String> oldList = ((ContentCaptureManagerService) ContentCapturePerUserService.access$300(this.this$0)).mGlobalContentCaptureOptions.getWhitelistedPackages(ContentCapturePerUserService.access$200(this.this$0));
            EventLog.writeEvent(EventLogTags.CC_CURRENT_ALLOWLIST, new Object[]{Integer.valueOf(ContentCapturePerUserService.access$400(this.this$0)), Integer.valueOf(CollectionUtils.size(oldList))});
            ((ContentCaptureManagerService) ContentCapturePerUserService.access$600(this.this$0)).mGlobalContentCaptureOptions.setWhitelist(ContentCapturePerUserService.access$500(this.this$0), packages, activities);
            EventLog.writeEvent(EventLogTags.CC_SET_ALLOWLIST, new Object[]{Integer.valueOf(ContentCapturePerUserService.access$700(this.this$0)), Integer.valueOf(CollectionUtils.size(packages)), Integer.valueOf(CollectionUtils.size(activities))});
            ContentCaptureMetricsLogger.writeSetWhitelistEvent(this.this$0.getServiceComponentName(), packages, activities);
            updateContentCaptureOptions(oldList);
            int numSessions = ContentCapturePerUserService.m3225$$Nest$fgetmSessions(this.this$0).size();
            if (numSessions > 0) goto L16;
            return;
        L16:
            SparseBooleanArray blacklistedSessions = new SparseBooleanArray(numSessions);
            int i = 0;
        L17:
            if (i >= numSessions) goto L25;
            ContentCaptureServerSession session = (ContentCaptureServerSession) ContentCapturePerUserService.m3225$$Nest$fgetmSessions(this.this$0).valueAt(i);
            boolean whitelisted = ((ContentCaptureManagerService) ContentCapturePerUserService.access$900(this.this$0)).mGlobalContentCaptureOptions.isWhitelisted(ContentCapturePerUserService.access$800(this.this$0), session.appComponentName);
            if (whitelisted == true) goto L24;
            int sessionId = ContentCapturePerUserService.m3225$$Nest$fgetmSessions(this.this$0).keyAt(i);
            if (((ContentCaptureManagerService) ContentCapturePerUserService.access$1000(this.this$0)).debug == false) goto L23;
            Slog.d(ContentCapturePerUserService.m3226$$Nest$sfgetTAG(), "marking session " + sessionId + " (" + session.appComponentName + ") for un-whitelisting");
        L23:
            blacklistedSessions.append(sessionId, true);
        L24:
            i = i + 1;
            goto L17
        L25:
            int numBlacklisted = blacklistedSessions.size();
            if (numBlacklisted > 0) goto L28;
            return;
        L28:
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            int i2 = 0;
        L31:
            if (i2 >= numBlacklisted) goto L39;
            int sessionId2 = blacklistedSessions.keyAt(i2);     // Catch: Throwable -> L35
            if (((ContentCaptureManagerService) ContentCapturePerUserService.access$1100(this.this$0)).debug == false) goto L37;
            Slog.d(ContentCapturePerUserService.m3226$$Nest$sfgetTAG(), "un-whitelisting " + sessionId2);     // Catch: Throwable -> L35
        L37:
            ((ContentCaptureServerSession) ContentCapturePerUserService.m3225$$Nest$fgetmSessions(this.this$0).get(sessionId2)).setContentCaptureEnabledLocked(false);     // Catch: Throwable -> L35
            i2 = i2 + 1;     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L39:
            monitor-exit(r4);     // Catch: Throwable -> L35
        }

        public void setContentCaptureConditions(String packageName, List<ContentCaptureCondition> conditions) {
            if (((ContentCaptureManagerService) ContentCapturePerUserService.access$1200(this.this$0)).verbose == false) goto L9;
            String r0 = ContentCapturePerUserService.m3226$$Nest$sfgetTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("setContentCaptureConditions(");
            r1.append(packageName);
            r1.append("): ");
            if (conditions != null) goto L7;
            String r2 = "null";
        L8:
            r1.append(r2);
            Slog.v(r0, r1.toString());
            goto L9
        L7:
            r2 = conditions.size() + " conditions";
        L9:
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            if (conditions != null) goto L15;
            ContentCapturePerUserService.m3224$$Nest$fgetmConditionsByPkg(this.this$0).remove(packageName);     // Catch: Throwable -> L13
        L16:
            monitor-exit(r3);     // Catch: Throwable -> L13
            return;
        L15:
            ContentCapturePerUserService.m3224$$Nest$fgetmConditionsByPkg(this.this$0).put(packageName, new ArraySet(conditions));     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        public void disableSelf() {
            if (((ContentCaptureManagerService) ContentCapturePerUserService.access$1300(this.this$0)).verbose == false) goto L5;
            Slog.v(ContentCapturePerUserService.m3226$$Nest$sfgetTAG(), "disableSelf()");
        L5:
            long token = Binder.clearCallingIdentity();
            Settings.Secure.putStringForUser(ContentCapturePerUserService.access$1400(this.this$0).getContentResolver(), "content_capture_enabled", "0", ContentCapturePerUserService.access$1500(this.this$0));     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            ContentCaptureMetricsLogger.writeServiceEvent(4, this.this$0.getServiceComponentName());
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void writeSessionFlush(int sessionId, ComponentName app, FlushMetrics flushMetrics, ContentCaptureOptions options, int flushReason) {
            ContentCaptureMetricsLogger.writeSessionFlush(sessionId, this.this$0.getServiceComponentName(), flushMetrics, options, flushReason);
        }

        private void updateContentCaptureOptions(ArraySet<String> oldList) {
            ArraySet<String> adding = ((ContentCaptureManagerService) ContentCapturePerUserService.access$1700(this.this$0)).mGlobalContentCaptureOptions.getWhitelistedPackages(ContentCapturePerUserService.access$1600(this.this$0));
            int addingCount = CollectionUtils.size(adding);
            EventLog.writeEvent(EventLogTags.CC_CURRENT_ALLOWLIST, new Object[]{Integer.valueOf(ContentCapturePerUserService.access$1800(this.this$0)), Integer.valueOf(addingCount)});
            if (oldList == null) goto L6;
            if (adding == null) goto L6;
            adding.removeAll(oldList);
        L6:
            int addingCount2 = CollectionUtils.size(adding);
            EventLog.writeEvent(EventLogTags.CC_UPDATE_OPTIONS, new Object[]{Integer.valueOf(ContentCapturePerUserService.access$1900(this.this$0)), Integer.valueOf(addingCount2)});
            int i = 0;
        L7:
            if (i >= addingCount2) goto L10;
            String packageName = adding.valueAt(i);
            ContentCaptureOptions options = ((ContentCaptureManagerService) ContentCapturePerUserService.access$2100(this.this$0)).mGlobalContentCaptureOptions.getOptions(ContentCapturePerUserService.access$2000(this.this$0), packageName);
            ((ContentCaptureManagerService) ContentCapturePerUserService.access$2200(this.this$0)).updateOptions(packageName, options);
            i = i + 1;
            goto L7
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConditionsByPkg, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m3224$$Nest$fgetmConditionsByPkg(ContentCapturePerUserService r0) {
        return r0.mConditionsByPkg;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3225$$Nest$fgetmSessions(ContentCapturePerUserService r0) {
        return r0.mSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3226$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ AbstractMasterSystemService access$000(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ int access$100(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ AbstractMasterSystemService access$1000(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ AbstractMasterSystemService access$1100(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ AbstractMasterSystemService access$1200(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ AbstractMasterSystemService access$1300(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ Context access$1400(ContentCapturePerUserService x0) {
        return x0.getContext();
    }

    static /* synthetic */ int access$1500(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ int access$1600(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ AbstractMasterSystemService access$1700(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ int access$1800(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ int access$1900(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ int access$200(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ int access$2000(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ AbstractMasterSystemService access$2100(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ AbstractMasterSystemService access$2200(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ AbstractMasterSystemService access$300(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ int access$400(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ int access$500(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ AbstractMasterSystemService access$600(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    static /* synthetic */ int access$700(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ int access$800(ContentCapturePerUserService x0) {
        return x0.mUserId;
    }

    static /* synthetic */ AbstractMasterSystemService access$900(ContentCapturePerUserService x0) {
        return x0.mMaster;
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteContentCaptureService) r1);
    }

    static {
        TAG = ContentCapturePerUserService.class.getSimpleName();
    }

    ContentCapturePerUserService(ContentCaptureManagerService master, Object lock, boolean disabled, int userId) {
        super(master, lock, userId);
        this.mSessions = new SparseArray();
        this.mRemoteServiceCallback = new ContentCaptureServiceRemoteCallback(this, null);
        this.mConditionsByPkg = new ArrayMap();
        updateRemoteServiceLocked(disabled);
    }

    private void updateRemoteServiceLocked(boolean disabled) {
        if (((ContentCaptureManagerService) this.mMaster).verbose == false) goto L6;
        Slog.v(TAG, "updateRemoteService(disabled=" + disabled + ")");
    L6:
        if (this.mRemoteService != null) goto L8;
    L11:
        ComponentName serviceComponentName = updateServiceInfoLocked();
        if (serviceComponentName == null) goto L14;
        if (disabled == true) goto L23;
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L21;
        Slog.d(TAG, "updateRemoteService(): creating new remote service for " + serviceComponentName);
    L21:
        this.mRemoteService = new RemoteContentCaptureService(((ContentCaptureManagerService) this.mMaster).getContext(), "android.service.contentcapture.ContentCaptureService", serviceComponentName, this.mRemoteServiceCallback, this.mUserId, this, ((ContentCaptureManagerService) this.mMaster).isBindInstantServiceAllowed(), ((ContentCaptureManagerService) this.mMaster).verbose, ((ContentCaptureManagerService) this.mMaster).mDevCfgIdleUnbindTimeoutMs);
        return;
    L23:
        return;
    L14:
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L24;
        Slog.d(TAG, "updateRemoteService(): no service component name");
        return;
    L24:
        return;
    L8:
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L10;
        Slog.d(TAG, "updateRemoteService(): destroying old remote service");
    L10:
        this.mRemoteService.destroy();
        this.mRemoteService = null;
        resetContentCaptureWhitelistLocked();
        goto L11
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        this.mInfo = new ContentCaptureServiceInfo(getContext(), serviceComponent, isTemporaryServiceSetLocked(), this.mUserId);
        return this.mInfo.getServiceInfo();
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        boolean disabledStateChanged = super.updateLocked(disabled);
        if (disabledStateChanged == false) goto L8;
        int i = 0;
    L6:
        if (i >= this.mSessions.size()) goto L8;
        this.mSessions.valueAt(i).setContentCaptureEnabledLocked(!disabled);
        i = i + 1;
    L8:
        destroyLocked();
        updateRemoteServiceLocked(disabled);
        return disabledStateChanged;
    }

    public void onServiceDied(RemoteContentCaptureService service) {
        Slog.w(TAG, "remote service died: " + service);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mZombie = true;     // Catch: Throwable -> L8
        ComponentName serviceComponent = getServiceComponentName();     // Catch: Throwable -> L8
        ContentCaptureMetricsLogger.writeServiceEvent(16, serviceComponent);     // Catch: Throwable -> L8
        EventLog.writeEvent(EventLogTags.CC_CONNECT_STATE_CHANGED, new Object[]{Integer.valueOf(this.mUserId), 0, 0});     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onConnected() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mZombie == true) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mRemoteService != null) goto L13;
        Slog.w(TAG, "Cannot ressurect sessions because remote service is null");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        this.mZombie = false;     // Catch: Throwable -> L11
        resurrectSessionsLocked();     // Catch: Throwable -> L11
        goto L14
    }

    private void resurrectSessionsLocked() {
        int numSessions = this.mSessions.size();
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L5;
        Slog.d(TAG, "Ressurrecting remote service (" + this.mRemoteService + ") on " + numSessions + " sessions");
    L5:
        int i = 0;
    L6:
        if (i >= numSessions) goto L9;
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        session.resurrectLocked();
        i = i + 1;
        goto L6
    }

    void onPackageUpdatingLocked() {
        int numSessions = this.mSessions.size();
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L5;
        Slog.d(TAG, "Pausing " + numSessions + " sessions while package is updating");
    L5:
        int i = 0;
    L6:
        if (i >= numSessions) goto L9;
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        session.pauseLocked();
        i = i + 1;
        goto L6
    }

    void onPackageUpdatedLocked() {
        updateRemoteServiceLocked(!isEnabledLocked());
        resurrectSessionsLocked();
    }

    public void startSessionLocked(IBinder activityToken, IBinder shareableActivityToken, ActivityPresentationInfo activityPresentationInfo, int sessionId, int uid, int flags, IResultReceiver clientReceiver) {
        if (activityPresentationInfo != null) goto L6;
        Slog.w(TAG, "basic activity info is null");
        ContentCaptureService.setClientState(clientReceiver, 260, null);
        return;
    L6:
        int taskId = activityPresentationInfo.taskId;
        int displayId = activityPresentationInfo.displayId;
        ComponentName componentName = activityPresentationInfo.componentName;
        if (((ContentCaptureManagerService) this.mMaster).mGlobalContentCaptureOptions.isWhitelisted(this.mUserId, componentName) == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        boolean whiteListed = r1;
        ComponentName serviceComponentName = getServiceComponentName();
        boolean enabled = isEnabledLocked();
        if (((ContentCaptureManagerService) this.mMaster).mRequestsHistory == null) goto L21;
        StringBuilder r2 = new StringBuilder();
        r2.append("id=");
        r2.append(sessionId);
        r2.append(" uid=");
        int r10 = uid;
        r2.append(r10);
        r2.append(" a=");
        r2.append(ComponentName.flattenToShortString(componentName));
        r2.append(" t=");
        r2.append(taskId);
        r2.append(" d=");
        r2.append(displayId);
        r2.append(" s=");
        r2.append(ComponentName.flattenToShortString(serviceComponentName));
        r2.append(" u=");
        r2.append(this.mUserId);
        r2.append(" f=");
        int r11 = flags;
        r2.append(r11);
        if (enabled == false) goto L19;
        String r16 = "";
    L20:
        r2.append(r16);
        r2.append(" w=");
        r2.append(whiteListed);
        String historyItem = r2.toString();
        ((ContentCaptureManagerService) this.mMaster).mRequestsHistory.log(historyItem);
    L23:
        if (enabled == true) goto L27;
        ContentCaptureService.setClientState(clientReceiver, 20, null);
        ContentCaptureMetricsLogger.writeSessionEvent(sessionId, 3, 20, serviceComponentName, false);
        return;
    L27:
        if (serviceComponentName == null) goto L29;
        if (whiteListed == false) goto L34;
        ContentCaptureServerSession existingSession = this.mSessions.get(sessionId);
        if (existingSession == null) goto L43;
        Slog.w(TAG, "startSession(id=" + existingSession + ", token=" + activityToken + ": ignoring because it already exists for " + existingSession.mActivityToken);
        ContentCaptureService.setClientState(clientReceiver, 12, null);
        ContentCaptureMetricsLogger.writeSessionEvent(sessionId, 3, 12, serviceComponentName, false);
        return;
    L43:
        if (this.mRemoteService != null) goto L46;
        updateRemoteServiceLocked(false);
    L46:
        if (this.mRemoteService != null) goto L49;
        Slog.w(TAG, "startSession(id=" + existingSession + ", token=" + activityToken + ": ignoring because service is not set");
        ContentCaptureService.setClientState(clientReceiver, 20, null);
        ContentCaptureMetricsLogger.writeSessionEvent(sessionId, 3, 20, serviceComponentName, false);
        return;
    L49:
        this.mRemoteService.ensureBoundLocked();
        ContentCaptureServerSession newSession = new ContentCaptureServerSession(this.mLock, activityToken, new ActivityId(taskId, shareableActivityToken), this, componentName, clientReceiver, taskId, displayId, sessionId, r10, r11);
        if (((ContentCaptureManagerService) this.mMaster).verbose == false) goto L52;
        Slog.v(TAG, "startSession(): new session for " + ComponentName.flattenToShortString(componentName) + " and id " + sessionId);
    L52:
        this.mSessions.put(sessionId, newSession);
        newSession.notifySessionStartedLocked(clientReceiver);
        return;
    L34:
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L36;
        Slog.d(TAG, "startSession(" + componentName + "): package or component not whitelisted");
    L36:
        ContentCaptureService.setClientState(clientReceiver, 516, null);
        ContentCaptureMetricsLogger.writeSessionEvent(sessionId, 3, 516, serviceComponentName, false);
        return;
    L29:
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L54;
        Slog.d(TAG, "startSession(" + activityToken + "): hold your horses");
        return;
    L54:
        return;
    L19:
        r16 = " (disabled)";
        goto L20
    L21:
        r10 = uid;
        r11 = flags;
        goto L23
    L9:
        if (((ContentCaptureManagerService) this.mMaster).mGlobalContentCaptureOptions.isWhitelisted(this.mUserId, componentName.getPackageName()) == true) goto L12;
        r1 = false;
        goto L13
    }

    public void finishSessionLocked(int sessionId) {
        if (isEnabledLocked() == true) goto L5;
        return;
    L5:
        ContentCaptureServerSession session = this.mSessions.get(sessionId);
        if (session != null) goto L12;
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L16;
        Slog.d(TAG, "finishSession(): no session with id" + sessionId);
        return;
    L16:
        return;
    L12:
        if (((ContentCaptureManagerService) this.mMaster).verbose == false) goto L14;
        Slog.v(TAG, "finishSession(): id=" + sessionId);
    L14:
        session.removeSelfLocked(true);
    }

    public void removeDataLocked(DataRemovalRequest request) {
        if (isEnabledLocked() == true) goto L5;
        return;
    L5:
        assertCallerLocked(request.getPackageName());
        this.mRemoteService.onDataRemovalRequest(request);
    }

    public void onDataSharedLocked(DataShareRequest request, IDataShareCallback.Stub dataShareCallback) {
        if (isEnabledLocked() == true) goto L5;
        return;
    L5:
        assertCallerLocked(request.getPackageName());
        this.mRemoteService.onDataShareRequest(request, dataShareCallback);
    }

    public ComponentName getServiceSettingsActivityLocked() {
        if (this.mInfo != null) goto L5;
        return null;
    L5:
        String activityName = this.mInfo.getSettingsActivity();
        if (activityName != null) goto L8;
        return null;
    L8:
        String packageName = this.mInfo.getServiceInfo().packageName;
        return new ComponentName(packageName, activityName);
    }

    private void assertCallerLocked(String packageName) {
        PackageManager pm = getContext().getPackageManager();
        int callingUid = Binder.getCallingUid();
        int packageUid = pm.getPackageUidAsUser(packageName, UserHandle.getCallingUserId());     // Catch: PackageManager.NameNotFoundException -> L24
        if (callingUid != packageUid) goto L6;
        return;
    L6:
        if (((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).hasRunningActivity(callingUid, packageName) == true) goto L29;
        VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity hotwordDetectionServiceIdentity = ((VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class)).getHotwordDetectionServiceIdentity();
        if (hotwordDetectionServiceIdentity != null) goto L10;
    L14:
        boolean isHotwordDetectionServiceCall = false;
    L16:
        if (isHotwordDetectionServiceCall == true) goto L30;
        String[] packages = pm.getPackagesForUid(callingUid);
        if (packages == null) goto L20;
        String callingPackage = packages[0];
    L21:
        Slog.w(TAG, "App (package=" + callingPackage + ", UID=" + callingUid + ") passed package (" + packageName + ") owned by UID " + packageUid);
        throw new SecurityException("Invalid package: " + packageName);
    L20:
        callingPackage = "uid-" + callingUid;
        goto L21
    L30:
        return;
    L10:
        if (callingUid != hotwordDetectionServiceIdentity.getIsolatedUid()) goto L14;
        if (packageUid != hotwordDetectionServiceIdentity.getOwnerUid()) goto L14;
        isHotwordDetectionServiceCall = true;
        goto L16
    L29:
        return;
    L26:
        throw new SecurityException("Could not verify UID for " + packageName);
    }

    public boolean sendActivityAssistDataLocked(IBinder activityToken, Bundle data) {
        int id = getSessionId(activityToken);
        Bundle assistData = data.getBundle("data");
        AssistStructure assistStructure = (AssistStructure) data.getParcelable(ActivityTaskManagerInternal.ASSIST_KEY_STRUCTURE, AssistStructure.class);
        AssistContent assistContent = (AssistContent) data.getParcelable(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT, AssistContent.class);
        SnapshotData snapshotData = new SnapshotData(assistData, assistStructure, assistContent);
        if (id == 0) goto L7;
        ContentCaptureServerSession session = this.mSessions.get(id);
        session.sendActivitySnapshotLocked(snapshotData);
        return true;
    L7:
        if (this.mRemoteService == null) goto L10;
        this.mRemoteService.onActivitySnapshotRequest(0, snapshotData);
        Slog.d(TAG, "Notified activity assist data for activity: " + activityToken + " without a session Id");
        return true;
    L10:
        return false;
    }

    public void removeSessionLocked(int sessionId) {
        this.mSessions.remove(sessionId);
    }

    public boolean isContentCaptureServiceForUserLocked(int uid) {
        if (uid != getServiceUidLocked()) goto L5;
        return true;
    L5:
        return false;
    }

    private ContentCaptureServerSession getSession(IBinder activityToken) {
        int i = 0;
    L4:
        if (i >= this.mSessions.size()) goto L9;
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        if (session.mActivityToken.equals(activityToken) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return session;
    L9:
        return null;
    }

    public void destroyLocked() {
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L6;
        Slog.d(TAG, "destroyLocked()");
    L6:
        if (this.mRemoteService == null) goto L8;
        this.mRemoteService.destroy();
    L8:
        destroySessionsLocked();
    }

    void destroySessionsLocked() {
        int numSessions = this.mSessions.size();
        int i = 0;
    L3:
        if (i >= numSessions) goto L5;
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        session.destroyLocked(true);
        i = i + 1;
        goto L3
    L5:
        this.mSessions.clear();
    }

    void listSessionsLocked(ArrayList<String> output) {
        int numSessions = this.mSessions.size();
        int i = 0;
    L3:
        if (i >= numSessions) goto L6;
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        output.add(session.toShortString());
        i = i + 1;
        goto L3
    }

    ArraySet<ContentCaptureCondition> getContentCaptureConditionsLocked(String packageName) {
        return this.mConditionsByPkg.get(packageName);
    }

    ArraySet<String> getContentCaptureAllowlist() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<String> allowPackages = ((ContentCaptureManagerService) this.mMaster).mGlobalContentCaptureOptions.getWhitelistedPackages(this.mUserId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return allowPackages;
    L7:
        th = move-exception;
        throw th;
    }

    void onActivityEventLocked(ActivityId activityId, ComponentName componentName, int type) {
        if (this.mRemoteService != null) goto L9;
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L19;
        Slog.d(this.mTag, "onActivityEvent(): no remote service");
        return;
    L19:
        return;
    L9:
        if (this.mRemoteService.getServiceInterface() == null) goto L11;
        ActivityEvent event = new ActivityEvent(activityId, componentName, type);
        if (((ContentCaptureManagerService) this.mMaster).verbose == false) goto L17;
        Slog.v(this.mTag, "onActivityEvent(): " + event);
    L17:
        this.mRemoteService.onActivityLifecycleEvent(event);
        return;
    L11:
        if (((ContentCaptureManagerService) this.mMaster).debug == false) goto L20;
        Slog.d(this.mTag, "onActivityEvent(): remote service is dead or unbound");
        return;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        String prefix2 = prefix + "  ";
        pw.print(prefix);
        pw.print("Service Info: ");
        if (this.mInfo != null) goto L5;
        pw.println("N/A");
    L6:
        pw.print(prefix);
        pw.print("Zombie: ");
        pw.println(this.mZombie);
        if (this.mRemoteService == null) goto L10;
        pw.print(prefix);
        pw.println("remote service:");
        this.mRemoteService.dump(prefix2, pw);
    L10:
        if (this.mSessions.size() != 0) goto L12;
        pw.print(prefix);
        pw.println("no sessions");
        return;
    L12:
        int sessionsSize = this.mSessions.size();
        pw.print(prefix);
        pw.print("number sessions: ");
        pw.println(sessionsSize);
        int i = 0;
    L13:
        if (i >= sessionsSize) goto L17;
        pw.print(prefix);
        pw.print("#");
        pw.println(i);
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        session.dumpLocked(prefix2, pw);
        pw.println();
        i = i + 1;
        goto L13
    L17:
        return;
    L5:
        pw.println();
        this.mInfo.dump(prefix2, pw);
        goto L6
    }

    private int getSessionId(IBinder activityToken) {
        int i = 0;
    L4:
        if (i >= this.mSessions.size()) goto L10;
        ContentCaptureServerSession session = this.mSessions.valueAt(i);
        if (session.isActivitySession(activityToken) == true) goto L8;
        i = i + 1;
        goto L4
    L8:
        return this.mSessions.keyAt(i);
    L10:
        return 0;
    }

    private void resetContentCaptureWhitelistLocked() {
        if (((ContentCaptureManagerService) this.mMaster).verbose == false) goto L5;
        Slog.v(TAG, "resetting content capture whitelist");
    L5:
        ((ContentCaptureManagerService) this.mMaster).mGlobalContentCaptureOptions.resetWhitelist(this.mUserId);
    }
}
