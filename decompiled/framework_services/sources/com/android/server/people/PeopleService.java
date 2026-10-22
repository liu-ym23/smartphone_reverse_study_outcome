package com.android.server.people;

import android.app.ActivityManager;
import android.app.people.ConversationChannel;
import android.app.people.IConversationListener;
import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppPredictionSessionId;
import android.app.prediction.AppTarget;
import android.app.prediction.AppTargetEvent;
import android.app.prediction.IPredictionCallback;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ShortcutInfo;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.people.data.DataManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class PeopleService extends SystemService {
    private static final String TAG = "PeopleService";
    private ConversationListenerHelper mLazyConversationListenerHelper;
    private DataManager mLazyDataManager;
    private PackageManagerInternal mPackageManagerInternal;
    final IBinder mService;

    public static class ConversationListenerHelper implements ConversationsListener {
        final RemoteCallbackList<IConversationListener> mListeners;

        ConversationListenerHelper() {
            this.mListeners = new RemoteCallbackList();
        }

        public synchronized void addConversationListener(ListenerKey key, IConversationListener listener) {
            monitor-enter(this);
            this.mListeners.unregister(listener);     // Catch: Throwable -> L6
            this.mListeners.register(listener, key);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void removeConversationListener(IConversationListener listener) {
            monitor-enter(this);
            this.mListeners.unregister(listener);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.people.PeopleService.ConversationsListener
        public void onConversationsUpdate(List<ConversationChannel> conversations) {
            int count = this.mListeners.beginBroadcast();
            if (count != 0) goto L5;
            return;
        L5:
            Map<ListenerKey, ConversationChannel> keyedConversations = new HashMap();
            Iterator<ConversationChannel> r2 = conversations.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            ConversationChannel conversation = r2.next();
            keyedConversations.put(getListenerKey(conversation), conversation);
            goto L7
        L9:
            int i = 0;
        L10:
            if (i >= count) goto L19;
            ListenerKey listenerKey = (ListenerKey) this.mListeners.getBroadcastCookie(i);
            if (keyedConversations.containsKey(listenerKey) == false) goto L18;
            IConversationListener listener = this.mListeners.getBroadcastItem(i);
            ConversationChannel channel = keyedConversations.get(listenerKey);     // Catch: RemoteException -> L17
            listener.onConversationUpdate(channel);     // Catch: RemoteException -> L17
        L18:
            i = i + 1;
            goto L10
        L19:
            this.mListeners.finishBroadcast();
        }

        private ListenerKey getListenerKey(ConversationChannel conversation) {
            ShortcutInfo info = conversation.getShortcutInfo();
            return new ListenerKey(info.getPackage(), Integer.valueOf(info.getUserId()), info.getId());
        }
    }

    public interface ConversationsListener {
        default void onConversationsUpdate(List<ConversationChannel> conversations) {
        }
    }

    private static class ListenerKey {
        private final String mPackageName;
        private final String mShortcutId;
        private final Integer mUserId;

        ListenerKey(String packageName, Integer userId, String shortcutId) {
            this.mPackageName = packageName;
            this.mUserId = userId;
            this.mShortcutId = shortcutId;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public Integer getUserId() {
            return this.mUserId;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean equals(Object o) {
            ListenerKey key = (ListenerKey) o;
            if (key.getPackageName().equals(this.mPackageName) == true) goto L5;
        L9:
            return false;
        L5:
            if (Objects.equals(key.getUserId(), this.mUserId) == false) goto L9;
            if (key.getShortcutId().equals(this.mShortcutId) == false) goto L9;
            return true;
        }

        public int hashCode() {
            return (this.mPackageName.hashCode() + this.mUserId.hashCode()) + this.mShortcutId.hashCode();
        }
    }

    final class LocalService extends PeopleServiceInternal {
        private Map<AppPredictionSessionId, SessionInfo> mSessions;
        final /* synthetic */ PeopleService this$0;

        public static /* synthetic */ void $r8$lambda$5_2PIR4WYRpeNaq2yDrd0Jb1Pa4(IPredictionCallback r0, SessionInfo r1) {
            lambda$registerPredictionUpdates$4(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$89Ro9-INjMmcdS9ZB96M0CPavc4, reason: not valid java name */
        public static /* synthetic */ void m6495$r8$lambda$89Ro9INjMmcdS9ZB96M0CPavc4(String r0, ParceledListSlice r1, SessionInfo r2) {
            lambda$notifyLaunchLocationShown$1(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$E0oG5RMDT9K6EZUlt6ZC8BVESBU(LocalService r0, AppPredictionSessionId r1, SessionInfo r2) {
            r0.lambda$onDestroyPredictionSession$7(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$GRT5Hj4GoJbc53lTBnEjp-68uvQ, reason: not valid java name */
        public static /* synthetic */ void m6496$r8$lambda$GRT5Hj4GoJbc53lTBnEjp68uvQ(LocalService r0, IPredictionCallback r1, List r2) {
            r0.lambda$sortAppTargets$2(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$MYg3X8M0rYrt6LIBZaP_gPEaedo(IPredictionCallback r0, SessionInfo r1) {
            lambda$unregisterPredictionUpdates$5(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$PKKVWaj5ZmrFa7OPOXGJW1Iow7w(AppTargetEvent r0, SessionInfo r1) {
            lambda$notifyAppTargetEvent$0(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$SbmsPUFVhelG0UpstG6dPNh0rsA(LocalService r0, ParceledListSlice r1, IPredictionCallback r2, SessionInfo r3) {
            r0.lambda$sortAppTargets$3(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$xVMqvu3b2Qn1uHE8m24BENaV2yo(SessionInfo r0) {
            lambda$requestPredictionUpdate$6(r0);
        }

        LocalService(PeopleService this$0) {
            this.this$0 = this$0;
            this.mSessions = new ArrayMap();
        }

        public void onCreatePredictionSession(AppPredictionContext appPredictionContext, AppPredictionSessionId sessionId) {
            this.mSessions.put(sessionId, new SessionInfo(appPredictionContext, PeopleService.m6491$$Nest$mgetDataManager(this.this$0), sessionId.getUserId(), this.this$0.getContext()));
        }

        public void notifyAppTargetEvent(AppPredictionSessionId sessionId, final AppTargetEvent event) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda4(event));
        }

        private static /* synthetic */ void lambda$notifyAppTargetEvent$0(AppTargetEvent event, SessionInfo sessionInfo) {
            sessionInfo.getPredictor().onAppTargetEvent(event);
        }

        public void notifyLaunchLocationShown(AppPredictionSessionId sessionId, final String launchLocation, final ParceledListSlice targetIds) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda5(launchLocation, targetIds));
        }

        private static /* synthetic */ void lambda$notifyLaunchLocationShown$1(String launchLocation, ParceledListSlice targetIds, SessionInfo sessionInfo) {
            sessionInfo.getPredictor().onLaunchLocationShown(launchLocation, targetIds.getList());
        }

        public void sortAppTargets(AppPredictionSessionId sessionId, final ParceledListSlice targets, final IPredictionCallback callback) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda6(this, targets, callback));
        }

        private /* synthetic */ void lambda$sortAppTargets$3(ParceledListSlice targets, final IPredictionCallback callback, SessionInfo sessionInfo) {
            sessionInfo.getPredictor().onSortAppTargets(targets.getList(), new PeopleService$LocalService$$ExternalSyntheticLambda2(this, callback));
        }

        private /* synthetic */ void lambda$sortAppTargets$2(IPredictionCallback callback, List targetList) {
            invokePredictionCallback(callback, targetList);
        }

        private static /* synthetic */ void lambda$registerPredictionUpdates$4(IPredictionCallback callback, SessionInfo sessionInfo) {
            sessionInfo.addCallback(callback);
        }

        public void registerPredictionUpdates(AppPredictionSessionId sessionId, final IPredictionCallback callback) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda1(callback));
        }

        private static /* synthetic */ void lambda$unregisterPredictionUpdates$5(IPredictionCallback callback, SessionInfo sessionInfo) {
            sessionInfo.removeCallback(callback);
        }

        public void unregisterPredictionUpdates(AppPredictionSessionId sessionId, final IPredictionCallback callback) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda7(callback));
        }

        public void requestPredictionUpdate(AppPredictionSessionId sessionId) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda3());
        }

        private static /* synthetic */ void lambda$requestPredictionUpdate$6(SessionInfo sessionInfo) {
            sessionInfo.getPredictor().onRequestPredictionUpdate();
        }

        public void onDestroyPredictionSession(final AppPredictionSessionId sessionId) {
            runForSession(sessionId, new PeopleService$LocalService$$ExternalSyntheticLambda0(this, sessionId));
        }

        private /* synthetic */ void lambda$onDestroyPredictionSession$7(AppPredictionSessionId sessionId, SessionInfo sessionInfo) {
            sessionInfo.onDestroy();
            this.mSessions.remove(sessionId);
        }

        @Override // com.android.server.people.PeopleServiceInternal
        public void pruneDataForUser(int userId, CancellationSignal signal) {
            PeopleService.m6491$$Nest$mgetDataManager(this.this$0).pruneDataForUser(userId, signal);
        }

        @Override // com.android.server.people.PeopleServiceInternal
        public byte[] getBackupPayload(int userId) {
            return PeopleService.m6491$$Nest$mgetDataManager(this.this$0).getBackupPayload(userId);
        }

        @Override // com.android.server.people.PeopleServiceInternal
        public void restore(int userId, byte[] payload) {
            PeopleService.m6491$$Nest$mgetDataManager(this.this$0).restore(userId, payload);
        }

        public void requestServiceFeatures(AppPredictionSessionId sessionId, IRemoteCallback callback) {
        }

        SessionInfo getSessionInfo(AppPredictionSessionId sessionId) {
            return this.mSessions.get(sessionId);
        }

        private void runForSession(AppPredictionSessionId sessionId, Consumer<SessionInfo> method) {
            SessionInfo sessionInfo = this.mSessions.get(sessionId);
            if (sessionInfo != null) goto L6;
            Slog.e(PeopleService.TAG, "Failed to find the session: " + sessionId);
            return;
        L6:
            method.accept(sessionInfo);
        }

        private void invokePredictionCallback(IPredictionCallback callback, List<AppTarget> targets) {
            callback.onResult(new ParceledListSlice(targets));     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(PeopleService.TAG, "Failed to calling callback" + e);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSameApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6490$$Nest$mcheckCallerIsSameApp(PeopleService r0, String r1) {
        r0.checkCallerIsSameApp(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDataManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DataManager m6491$$Nest$mgetDataManager(PeopleService r0) {
        return r0.getDataManager();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleIncomingUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6492$$Nest$mhandleIncomingUser(PeopleService r0, int r1) {
        return r0.handleIncomingUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smenforceSystemOrRoot, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6493$$Nest$smenforceSystemOrRoot(String r0) {
        enforceSystemOrRoot(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisSystemOrRoot, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6494$$Nest$smisSystemOrRoot() {
        return isSystemOrRoot();
    }

    public PeopleService(Context context) {
        super(context);
        this.mService = new AnonymousClass1(this);
    }

    ConversationListenerHelper getConversationListenerHelper() {
        if (this.mLazyConversationListenerHelper != null) goto L6;
        initLazyStuff();
    L6:
        return this.mLazyConversationListenerHelper;
    }

    private synchronized void initLazyStuff() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mLazyDataManager != null) goto L9;
        this.mLazyDataManager = new DataManager(getContext());     // Catch: Throwable -> L7
        this.mLazyDataManager.initialize();     // Catch: Throwable -> L7
        this.mLazyConversationListenerHelper = new ConversationListenerHelper();     // Catch: Throwable -> L7
        this.mLazyDataManager.addConversationsListener(this.mLazyConversationListenerHelper);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    private DataManager getDataManager() {
        if (this.mLazyDataManager != null) goto L6;
        initLazyStuff();
    L6:
        return this.mLazyDataManager;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        onStart(false);
    }

    protected void onStart(boolean isForTesting) {
        if (isForTesting == true) goto L4;
        publishBinderService("people", this.mService);
    L4:
        publishLocalService(PeopleServiceInternal.class, new LocalService(this));
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L6;
        getDataManager();
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(SystemService.TargetUser user) {
        getDataManager().onUserUnlocked(user.getUserIdentifier());
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        getDataManager().onUserStopping(user.getUserIdentifier());
    }

    private static void enforceSystemOrRoot(String message) {
        if (isSystemOrRoot() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Only system may " + message);
    }

    private static boolean isSystemOrRoot() {
        int uid = Binder.getCallingUid();
        if (UserHandle.isSameApp(uid, 1000) == true) goto L7;
        if (uid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private int handleIncomingUser(int userId) {
        return ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, true, "", null);
    L15:
        return userId;
    L10:
        return userId;
    }

    private void checkCallerIsSameApp(String pkg) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (this.mPackageManagerInternal.getPackageUid(pkg, 0, callingUserId) != callingUid) goto L6;
        return;
    L6:
        throw new SecurityException("Calling uid " + callingUid + " cannot query eventsfor package " + pkg);
    }

    protected void enforceSystemRootOrSystemUI(Context context, String message) {
        if (isSystemOrRoot() == false) goto L5;
        return;
    L5:
        context.enforceCallingPermission("android.permission.STATUS_BAR_SERVICE", message);
    }
}
