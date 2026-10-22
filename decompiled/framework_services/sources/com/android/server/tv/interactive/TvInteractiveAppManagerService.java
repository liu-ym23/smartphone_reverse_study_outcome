package com.android.server.tv.interactive;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.graphics.Rect;
import android.media.PlaybackParams;
import android.media.tv.AdBuffer;
import android.media.tv.AdRequest;
import android.media.tv.AdResponse;
import android.media.tv.BroadcastInfoRequest;
import android.media.tv.BroadcastInfoResponse;
import android.media.tv.TvRecordingInfo;
import android.media.tv.TvTrackInfo;
import android.media.tv.ad.ITvAdClient;
import android.media.tv.ad.ITvAdManager;
import android.media.tv.ad.ITvAdManagerCallback;
import android.media.tv.ad.ITvAdService;
import android.media.tv.ad.ITvAdServiceCallback;
import android.media.tv.ad.ITvAdSession;
import android.media.tv.ad.ITvAdSessionCallback;
import android.media.tv.ad.TvAdServiceInfo;
import android.media.tv.interactive.AppLinkInfo;
import android.media.tv.interactive.ITvInteractiveAppClient;
import android.media.tv.interactive.ITvInteractiveAppManager;
import android.media.tv.interactive.ITvInteractiveAppManagerCallback;
import android.media.tv.interactive.ITvInteractiveAppService;
import android.media.tv.interactive.ITvInteractiveAppServiceCallback;
import android.media.tv.interactive.ITvInteractiveAppSession;
import android.media.tv.interactive.ITvInteractiveAppSessionCallback;
import android.media.tv.interactive.TvInteractiveAppServiceInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputChannel;
import android.view.Surface;
import com.android.internal.content.PackageMonitor;
import com.android.server.SystemService;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class TvInteractiveAppManagerService extends SystemService {
    private static final boolean DEBUG = false;
    private static final String METADATA_CLASS_NAME = "android.media.tv.interactive.AppLinkInfo.ClassName";
    private static final String METADATA_URI = "android.media.tv.interactive.AppLinkInfo.Uri";
    private static final String TAG = "TvInteractiveAppManagerService";
    private final Context mContext;
    private int mCurrentUserId;
    private boolean mGetAdServiceListCalled;
    private boolean mGetAppLinkInfoListCalled;
    private boolean mGetServiceListCalled;
    private final Object mLock;
    private final MyPackageMonitor mPackageMonitor;
    private final Set<Integer> mRunningProfiles;
    private final UserManager mUserManager;
    private final SparseArray<UserState> mUserStates;

    private final class AdServiceCallback extends ITvAdServiceCallback.Stub {
        private final ComponentName mComponent;
        private final int mUserId;

        AdServiceCallback(TvInteractiveAppManagerService r1, ComponentName component, int userId) {
            this.mComponent = component;
            this.mUserId = userId;
        }
    }

    private final class AdServiceConnection implements ServiceConnection {
        private final ComponentName mComponent;
        private final int mUserId;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* synthetic */ AdServiceConnection(TvInteractiveAppManagerService r1, ComponentName r2, int r3, TvInteractiveAppManagerServiceIA r4) {
            this(r1, r2, r3);
        }

        private AdServiceConnection(TvInteractiveAppManagerService r1, ComponentName component, int userId) {
            this.this$0 = r1;
            this.mComponent = component;
            this.mUserId = userId;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName component, IBinder service) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInteractiveAppManagerService.m8905$$Nest$mgetUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L9
            if (userState != null) goto L11;
            TvInteractiveAppManagerService.m8878$$Nest$fgetmContext(this.this$0).unbindService(this);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(this.mComponent);     // Catch: Throwable -> L9
            AdServiceState.m8931$$Nest$fputmService(serviceState, ITvAdService.Stub.asInterface(service));     // Catch: Throwable -> L9
            if (AdServiceState.m8921$$Nest$fgetmCallback(serviceState) != null) goto L19;
            AdServiceState.m8929$$Nest$fputmCallback(serviceState, new AdServiceCallback(this.this$0, this.mComponent, this.mUserId));     // Catch: Throwable -> L9
            AdServiceState.m8926$$Nest$fgetmService(serviceState).registerCallback(AdServiceState.m8921$$Nest$fgetmCallback(serviceState));     // Catch: Throwable -> L9 RemoteException -> L16
        L16:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in registerCallback", e);     // Catch: Throwable -> L9
        L19:
            if (AdServiceState.m8924$$Nest$fgetmPendingAppLinkCommand(serviceState).isEmpty() == true) goto L35;
            Iterator<Bundle> it = AdServiceState.m8924$$Nest$fgetmPendingAppLinkCommand(serviceState).iterator();     // Catch: Throwable -> L9
        L22:
            if (it.hasNext() == false) goto L35;
            Bundle command = it.next();     // Catch: Throwable -> L9
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            AdServiceState.m8926$$Nest$fgetmService(serviceState).sendAppLinkCommand(command);     // Catch: Throwable -> L27 RemoteException -> L29
            it.remove();     // Catch: Throwable -> L27 RemoteException -> L29
        L25:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L9
        L29:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendAppLinkCommand(" + command + ") when onServiceConnected", e);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L35:
            List<IBinder> tokensToBeRemoved = new ArrayList();     // Catch: Throwable -> L9
            Iterator r4 = AdServiceState.m8927$$Nest$fgetmSessionTokens(serviceState).iterator();     // Catch: Throwable -> L9
        L37:
            if (r4.hasNext() == false) goto L42;
            IBinder sessionToken = (IBinder) r4.next();     // Catch: Throwable -> L9
            if (TvInteractiveAppManagerService.m8895$$Nest$mcreateAdSessionInternalLocked(this.this$0, AdServiceState.m8926$$Nest$fgetmService(serviceState), sessionToken, this.mUserId) == true) goto L37;
            tokensToBeRemoved.add(sessionToken);     // Catch: Throwable -> L9
            goto L37
        L42:
            Iterator<IBinder> r5 = tokensToBeRemoved.iterator();     // Catch: Throwable -> L9
        L44:
            if (r5.hasNext() == false) goto L46;
            TvInteractiveAppManagerService.m8909$$Nest$mremoveAdSessionStateLocked(this.this$0, r5.next(), this.mUserId);     // Catch: Throwable -> L9
            goto L44
        L46:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName component) {
            if (this.mComponent.equals(component) == false) goto L16;
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L9
            AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(this.mComponent);     // Catch: Throwable -> L9
            if (serviceState == null) goto L11;
            AdServiceState.m8930$$Nest$fputmReconnecting(serviceState, true);     // Catch: Throwable -> L9
            AdServiceState.m8928$$Nest$fputmBound(serviceState, false);     // Catch: Throwable -> L9
            AdServiceState.m8931$$Nest$fputmService(serviceState, null);     // Catch: Throwable -> L9
            AdServiceState.m8929$$Nest$fputmCallback(serviceState, null);     // Catch: Throwable -> L9
            TvInteractiveAppManagerService.m8888$$Nest$mabortPendingCreateAdSessionRequestsLocked(this.this$0, serviceState, null, this.mUserId);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L16:
            throw new IllegalArgumentException("Mismatched ComponentName: " + this.mComponent + " (expected), " + component + " (actual).");
        }
    }

    private final class AdServiceState {
        private final String mAdServiceId;
        private boolean mBound;
        private AdServiceCallback mCallback;
        private final ComponentName mComponent;
        private final ServiceConnection mConnection;
        private final List<Bundle> mPendingAppLinkCommand;
        private boolean mReconnecting;
        private ITvAdService mService;
        private final List<IBinder> mSessionTokens;

        /* JADX INFO: renamed from: -$$Nest$fgetmBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8920$$Nest$fgetmBound(AdServiceState r0) {
            return r0.mBound;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ AdServiceCallback m8921$$Nest$fgetmCallback(AdServiceState r0) {
            return r0.mCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmComponent, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8922$$Nest$fgetmComponent(AdServiceState r0) {
            return r0.mComponent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConnection, reason: not valid java name */
        static /* bridge */ /* synthetic */ ServiceConnection m8923$$Nest$fgetmConnection(AdServiceState r0) {
            return r0.mConnection;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingAppLinkCommand, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8924$$Nest$fgetmPendingAppLinkCommand(AdServiceState r0) {
            return r0.mPendingAppLinkCommand;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReconnecting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8925$$Nest$fgetmReconnecting(AdServiceState r0) {
            return r0.mReconnecting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvAdService m8926$$Nest$fgetmService(AdServiceState r0) {
            return r0.mService;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8927$$Nest$fgetmSessionTokens(AdServiceState r0) {
            return r0.mSessionTokens;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8928$$Nest$fputmBound(AdServiceState r0, boolean r1) {
            r0.mBound = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8929$$Nest$fputmCallback(AdServiceState r0, AdServiceCallback r1) {
            r0.mCallback = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmReconnecting, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8930$$Nest$fputmReconnecting(AdServiceState r0, boolean r1) {
            r0.mReconnecting = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8931$$Nest$fputmService(AdServiceState r0, ITvAdService r1) {
            r0.mService = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$maddPendingAppLinkCommand, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8932$$Nest$maddPendingAppLinkCommand(AdServiceState r0, Bundle r1) {
            r0.addPendingAppLinkCommand(r1);
        }

        /* synthetic */ AdServiceState(TvInteractiveAppManagerService r1, ComponentName r2, String r3, int r4, TvInteractiveAppManagerServiceIA r5) {
            this(r1, r2, r3, r4);
        }

        private AdServiceState(TvInteractiveAppManagerService r3, ComponentName component, String tasId, int userId) {
            this.mSessionTokens = new ArrayList();
            this.mPendingAppLinkCommand = new ArrayList();
            this.mComponent = component;
            this.mConnection = new AdServiceConnection(r3, component, userId, null);
            this.mAdServiceId = tasId;
        }

        private void addPendingAppLinkCommand(Bundle command) {
            this.mPendingAppLinkCommand.add(command);
        }
    }

    private final class AdSessionCallback extends ITvAdSessionCallback.Stub {
        private final InputChannel[] mInputChannels;
        private final AdSessionState mSessionState;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        AdSessionCallback(TvInteractiveAppManagerService r1, AdSessionState sessionState, InputChannel[] channels) {
            this.this$0 = r1;
            this.mSessionState = sessionState;
            this.mInputChannels = channels;
        }

        public void onSessionCreated(ITvAdSession session) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            AdSessionState.m8942$$Nest$fputmSession(this.mSessionState, session);     // Catch: Throwable -> L9
            if (session != null) goto L7;
        L11:
            TvInteractiveAppManagerService.m8909$$Nest$mremoveAdSessionStateLocked(this.this$0, AdSessionState.m8939$$Nest$fgetmSessionToken(this.mSessionState), AdSessionState.m8941$$Nest$fgetmUserId(this.mSessionState));     // Catch: Throwable -> L9
            TvInteractiveAppManagerService.m8913$$Nest$msendAdSessionTokenToClientLocked(this.this$0, AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState), AdSessionState.m8933$$Nest$fgetmAdServiceId(this.mSessionState), null, null, AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L9
        L12:
            this.mInputChannels[0].dispose();     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L7:
            if (addAdSessionTokenToClientStateLocked(session) == false) goto L11;
            TvInteractiveAppManagerService.m8913$$Nest$msendAdSessionTokenToClientLocked(this.this$0, AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState), AdSessionState.m8933$$Nest$fgetmAdServiceId(this.mSessionState), AdSessionState.m8939$$Nest$fgetmSessionToken(this.mSessionState), this.mInputChannels[0], AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void onLayoutSurface(int left, int top, int right, int bottom) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r9 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r9;
        L17:
            th = move-exception;
            r9 = th;
            goto L28
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) == null) goto L26;
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L26;
        L31:
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onLayoutSurface(left, top, right, bottom, AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onLayoutSurface", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onRequestCurrentVideoBounds() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onRequestCurrentVideoBounds(AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentVideoBounds", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestCurrentChannelUri() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onRequestCurrentChannelUri(AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentChannelUri", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestTrackInfoList() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onRequestTrackInfoList(AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestTrackInfoList", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestCurrentTvInputId() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onRequestCurrentTvInputId(AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentTvInputId", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestSigning(String id, String algorithm, String alias, byte[] data) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r9 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r9;
        L17:
            th = move-exception;
            r9 = th;
            goto L28
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) == null) goto L26;
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L26;
        L31:
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onRequestSigning(id, algorithm, alias, data, AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestSigning", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onTvAdSessionData(String type, Bundle data) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (AdSessionState.m8938$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).onTvAdSessionData(type, data, AdSessionState.m8937$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onTvAdSessionData", e);     // Catch: Throwable -> L11
            goto L15
        }

        private boolean addAdSessionTokenToClientStateLocked(ITvAdSession session) {
            session.asBinder().linkToDeath(this.mSessionState, 0);     // Catch: RemoteException -> L14
            IBinder clientToken = AdSessionState.m8935$$Nest$fgetmClient(this.mSessionState).asBinder();
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, AdSessionState.m8941$$Nest$fgetmUserId(this.mSessionState));
            ClientState clientState = (ClientState) UserState.m8987$$Nest$fgetmClientStateMap(userState).get(clientToken);
            if (clientState != null) goto L12;
            clientState = new ClientState(this.this$0, clientToken, AdSessionState.m8941$$Nest$fgetmUserId(this.mSessionState));
            clientToken.linkToDeath(clientState, 0);     // Catch: RemoteException -> L9
            UserState.m8987$$Nest$fgetmClientStateMap(userState).put(clientToken, clientState);
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "client process has already died", e);
            return false;
        L12:
            ClientState.m8943$$Nest$fgetmSessionTokens(clientState).add(AdSessionState.m8939$$Nest$fgetmSessionToken(this.mSessionState));
            return true;
        L14:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "session process has already died", e);
            return false;
        }
    }

    private final class AdSessionState implements IBinder.DeathRecipient {
        private final String mAdServiceId;
        private final int mCallingPid;
        private final int mCallingUid;
        private final ITvAdClient mClient;
        private final ComponentName mComponent;
        private final int mSeq;
        private ITvAdSession mSession;
        private final IBinder mSessionToken;
        private final String mType;
        private final int mUserId;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmAdServiceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8933$$Nest$fgetmAdServiceId(AdSessionState r0) {
            return r0.mAdServiceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8934$$Nest$fgetmCallingUid(AdSessionState r0) {
            return r0.mCallingUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvAdClient m8935$$Nest$fgetmClient(AdSessionState r0) {
            return r0.mClient;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmComponent, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8936$$Nest$fgetmComponent(AdSessionState r0) {
            return r0.mComponent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSeq, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8937$$Nest$fgetmSeq(AdSessionState r0) {
            return r0.mSeq;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvAdSession m8938$$Nest$fgetmSession(AdSessionState r0) {
            return r0.mSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8939$$Nest$fgetmSessionToken(AdSessionState r0) {
            return r0.mSessionToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8940$$Nest$fgetmType(AdSessionState r0) {
            return r0.mType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8941$$Nest$fgetmUserId(AdSessionState r0) {
            return r0.mUserId;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8942$$Nest$fputmSession(AdSessionState r0, ITvAdSession r1) {
            r0.mSession = r1;
        }

        /* synthetic */ AdSessionState(TvInteractiveAppManagerService r1, IBinder r2, String r3, String r4, ComponentName r5, ITvAdClient r6, int r7, int r8, int r9, int r10, TvInteractiveAppManagerServiceIA r11) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        private AdSessionState(TvInteractiveAppManagerService r1, IBinder sessionToken, String serviceId, String type, ComponentName componentName, ITvAdClient client, int seq, int callingUid, int callingPid, int userId) {
            this.this$0 = r1;
            this.mSessionToken = sessionToken;
            this.mAdServiceId = serviceId;
            this.mType = type;
            this.mComponent = componentName;
            this.mClient = client;
            this.mSeq = seq;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mUserId = userId;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mSession = null;     // Catch: Throwable -> L8
            TvInteractiveAppManagerService.m8893$$Nest$mclearAdSessionAndNotifyClientLocked(this.this$0, this);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private final class BinderService extends ITvInteractiveAppManager.Stub {
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* synthetic */ BinderService(TvInteractiveAppManagerService r1, TvInteractiveAppManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(TvInteractiveAppManagerService r1) {
            this.this$0 = r1;
        }

        public List<TvInteractiveAppServiceInfo> getTvInteractiveAppServiceList(int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getTvInteractiveAppServiceList");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L19
            monitor-enter(r3);     // Catch: Throwable -> L19
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L6:
            if (TvInteractiveAppManagerService.m8882$$Nest$fgetmGetServiceListCalled(this.this$0) == true) goto L10;
            TvInteractiveAppManagerService.m8892$$Nest$mbuildTvInteractiveAppServiceListLocked(this.this$0, userId, null);     // Catch: Throwable -> L8
            TvInteractiveAppManagerService.m8887$$Nest$fputmGetServiceListCalled(this.this$0, true);     // Catch: Throwable -> L8
        L10:
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            List<TvInteractiveAppServiceInfo> iAppList = new ArrayList();     // Catch: Throwable -> L8
            Iterator r6 = UserState.m8988$$Nest$fgetmIAppMap(userState).values().iterator();     // Catch: Throwable -> L8
        L12:
            if (r6.hasNext() == false) goto L14;
            TvInteractiveAppState state = (TvInteractiveAppState) r6.next();     // Catch: Throwable -> L8
            iAppList.add(TvInteractiveAppState.m8976$$Nest$fgetmInfo(state));     // Catch: Throwable -> L8
            goto L12
        L14:
            monitor-exit(r3);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return iAppList;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<AppLinkInfo> getAppLinkInfoList(int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getAppLinkInfoList");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r3);     // Catch: Throwable -> L16
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L6:
            if (TvInteractiveAppManagerService.m8881$$Nest$fgetmGetAppLinkInfoListCalled(this.this$0) == true) goto L10;
            TvInteractiveAppManagerService.m8890$$Nest$mbuildAppLinkInfoLocked(this.this$0, userId);     // Catch: Throwable -> L8
            TvInteractiveAppManagerService.m8886$$Nest$fputmGetAppLinkInfoListCalled(this.this$0, true);     // Catch: Throwable -> L8
        L10:
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            List<AppLinkInfo> appLinkInfos = new ArrayList(UserState.m8985$$Nest$fgetmAppLinkInfoList(userState));     // Catch: Throwable -> L8
            monitor-exit(r3);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return appLinkInfos;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void registerAppLinkInfo(String tiasId, AppLinkInfo appLinkInfo, int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "registerAppLinkInfo: " + appLinkInfo);
            long identity = Binder.clearCallingIdentity();
            Object r12 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L24 RemoteException -> L26
            monitor-enter(r12);     // Catch: Throwable -> L24 RemoteException -> L26
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L11
            TvInteractiveAppState iAppState = (TvInteractiveAppState) UserState.m8988$$Nest$fgetmIAppMap(userState).get(tiasId);     // Catch: Throwable -> L11
            if (iAppState != null) goto L13;
            Slogf.e(TvInteractiveAppManagerService.TAG, "failed to registerAppLinkInfo - unknown TIAS id " + tiasId);     // Catch: Throwable -> L11
            monitor-exit(r12);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return;
        L13:
            ComponentName componentName = TvInteractiveAppState.m8976$$Nest$fgetmInfo(iAppState).getComponent();     // Catch: Throwable -> L11
            ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(componentName);     // Catch: Throwable -> L11
            if (serviceState != null) goto L17;
            ServiceState serviceState2 = new ServiceState(this.this$0, componentName, tiasId, resolvedUserId, null);     // Catch: Throwable -> L11
            ServiceState.m8958$$Nest$maddPendingAppLink(serviceState2, appLinkInfo, true);     // Catch: Throwable -> L11
            UserState.m8990$$Nest$fgetmServiceStateMap(userState).put(componentName, serviceState2);     // Catch: Throwable -> L11
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L11
        L20:
            monitor-exit(r12);     // Catch: Throwable -> L11
        L21:
            Binder.restoreCallingIdentity(identity);
            return;
        L17:
            if (ServiceState.m8952$$Nest$fgetmService(serviceState) == null) goto L19;
            ServiceState.m8952$$Nest$fgetmService(serviceState).registerAppLinkInfo(appLinkInfo);     // Catch: Throwable -> L11
            goto L20
        L19:
            ServiceState.m8958$$Nest$maddPendingAppLink(serviceState, appLinkInfo, true);     // Catch: Throwable -> L11
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24 RemoteException -> L26
        L26:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in registerAppLinkInfo", e);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unregisterAppLinkInfo(String tiasId, AppLinkInfo appLinkInfo, int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "unregisterAppLinkInfo: " + appLinkInfo);
            long identity = Binder.clearCallingIdentity();
            Object r12 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L24 RemoteException -> L26
            monitor-enter(r12);     // Catch: Throwable -> L24 RemoteException -> L26
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L11
            TvInteractiveAppState iAppState = (TvInteractiveAppState) UserState.m8988$$Nest$fgetmIAppMap(userState).get(tiasId);     // Catch: Throwable -> L11
            if (iAppState != null) goto L13;
            Slogf.e(TvInteractiveAppManagerService.TAG, "failed to unregisterAppLinkInfo - unknown TIAS id " + tiasId);     // Catch: Throwable -> L11
            monitor-exit(r12);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return;
        L13:
            ComponentName componentName = TvInteractiveAppState.m8976$$Nest$fgetmInfo(iAppState).getComponent();     // Catch: Throwable -> L11
            ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(componentName);     // Catch: Throwable -> L11
            if (serviceState != null) goto L17;
            ServiceState serviceState2 = new ServiceState(this.this$0, componentName, tiasId, resolvedUserId, null);     // Catch: Throwable -> L11
            ServiceState.m8958$$Nest$maddPendingAppLink(serviceState2, appLinkInfo, false);     // Catch: Throwable -> L11
            UserState.m8990$$Nest$fgetmServiceStateMap(userState).put(componentName, serviceState2);     // Catch: Throwable -> L11
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L11
        L20:
            monitor-exit(r12);     // Catch: Throwable -> L11
        L21:
            Binder.restoreCallingIdentity(identity);
            return;
        L17:
            if (ServiceState.m8952$$Nest$fgetmService(serviceState) == null) goto L19;
            ServiceState.m8952$$Nest$fgetmService(serviceState).unregisterAppLinkInfo(appLinkInfo);     // Catch: Throwable -> L11
            goto L20
        L19:
            ServiceState.m8958$$Nest$maddPendingAppLink(serviceState, appLinkInfo, false);     // Catch: Throwable -> L11
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24 RemoteException -> L26
        L26:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in unregisterAppLinkInfo", e);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendAppLinkCommand(String tiasId, Bundle command, int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "sendAppLinkCommand");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L35 RemoteException -> L37
            monitor-enter(r3);     // Catch: Throwable -> L35 RemoteException -> L37
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L21
            TvInteractiveAppState iAppState = (TvInteractiveAppState) UserState.m8988$$Nest$fgetmIAppMap(userState).get(tiasId);     // Catch: Throwable -> L21
            if (iAppState == null) goto L47;
            ComponentName componentName = TvInteractiveAppState.m8976$$Nest$fgetmInfo(iAppState).getComponent();     // Catch: Throwable -> L21
            ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(componentName);     // Catch: Throwable -> L21
            if (serviceState != null) goto L24;
            ServiceState serviceState2 = new ServiceState(this.this$0, componentName, tiasId, resolvedUserId, null);     // Catch: Throwable -> L19
            ServiceState.m8959$$Nest$maddPendingAppLinkCommand(serviceState2, command);     // Catch: Throwable -> L19
            UserState.m8990$$Nest$fgetmServiceStateMap(userState).put(componentName, serviceState2);     // Catch: Throwable -> L19
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L19
        L27:
            monitor-exit(r3);     // Catch: Throwable -> L19
        L28:
            Binder.restoreCallingIdentity(identity);
            return;
        L24:
            if (ServiceState.m8952$$Nest$fgetmService(serviceState) == null) goto L26;
            ServiceState.m8952$$Nest$fgetmService(serviceState).sendAppLinkCommand(command);     // Catch: Throwable -> L19
            goto L27
        L26:
            ServiceState.m8959$$Nest$maddPendingAppLinkCommand(serviceState, command);     // Catch: Throwable -> L19
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L19
            goto L27
        L47:
            Slogf.e(TvInteractiveAppManagerService.TAG, "failed to sendAppLinkCommand - unknown TIAS id " + tiasId);     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            th = th;
        L29:
            monitor-exit(r3);     // Catch: Throwable -> L19
            throw th;     // Catch: Throwable -> L31 RemoteException -> L33
        L33:
            e = move-exception;
            RemoteException e = e;
        L40:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendAppLinkCommand", e);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            Throwable r13 = th;
        L43:
            Binder.restoreCallingIdentity(identity);
            throw r13;
        L21:
            th = th;
            goto L29
        L19:
            th = th;
        L37:
            e = move-exception;
            e = e;
        L35:
            th = move-exception;
            r13 = th;
            goto L43
        }

        public void createSession(ITvInteractiveAppClient client, String iAppServiceId, int type, int seq, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "createSession");
            long identity = Binder.clearCallingIdentity();
            Object r17 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L53
            monitor-enter(r17);     // Catch: Throwable -> L53
        L15:
            th = th;
        L51:
            monitor-exit(r17);     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L53
        L6:
            if (userId == TvInteractiveAppManagerService.m8879$$Nest$fgetmCurrentUserId(this.this$0)) goto L20;
        L17:
            th = th;
            goto L51
        L8:
            if (TvInteractiveAppManagerService.m8884$$Nest$fgetmRunningProfiles(this.this$0).contains(Integer.valueOf(userId)) == true) goto L20;
            TvInteractiveAppManagerService.m8914$$Nest$msendSessionTokenToClientLocked(this.this$0, client, iAppServiceId, null, null, seq);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L20:
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L15
            TvInteractiveAppState iAppState = (TvInteractiveAppState) UserState.m8988$$Nest$fgetmIAppMap(userState).get(iAppServiceId);     // Catch: Throwable -> L15
            if (iAppState != null) goto L26;
            Slogf.w(TvInteractiveAppManagerService.TAG, "Failed to find state for iAppServiceId=" + iAppServiceId);     // Catch: Throwable -> L15
            TvInteractiveAppManagerService.m8914$$Nest$msendSessionTokenToClientLocked(this.this$0, client, iAppServiceId, null, null, seq);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L26:
            ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(TvInteractiveAppState.m8975$$Nest$fgetmComponentName(iAppState));     // Catch: Throwable -> L15
            if (serviceState != null) goto L35;
            int r2 = PackageManager.getApplicationInfoAsUserCached(TvInteractiveAppState.m8975$$Nest$fgetmComponentName(iAppState).getPackageName(), 0, resolvedUserId).uid;     // Catch: Throwable -> L15
            ServiceState serviceState2 = new ServiceState(this.this$0, TvInteractiveAppState.m8975$$Nest$fgetmComponentName(iAppState), iAppServiceId, resolvedUserId, null);     // Catch: Throwable -> L33
            UserState.m8990$$Nest$fgetmServiceStateMap(userState).put(TvInteractiveAppState.m8975$$Nest$fgetmComponentName(iAppState), serviceState2);     // Catch: Throwable -> L15
            ServiceState serviceState3 = serviceState2;
        L37:
            if (ServiceState.m8951$$Nest$fgetmReconnecting(serviceState3) == false) goto L42;
            TvInteractiveAppManagerService.m8914$$Nest$msendSessionTokenToClientLocked(this.this$0, client, iAppServiceId, null, null, seq);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L42:
            Binder r4 = new Binder();     // Catch: Throwable -> L15
            SessionState sessionState = new SessionState(this.this$0, r4, iAppServiceId, type, TvInteractiveAppState.m8975$$Nest$fgetmComponentName(iAppState), client, seq, callingUid, callingPid, resolvedUserId, null);     // Catch: Throwable -> L15
            UserState.m8991$$Nest$fgetmSessionStateMap(userState).put(r4, sessionState);     // Catch: Throwable -> L15
            ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState3).add(r4);     // Catch: Throwable -> L15
            if (ServiceState.m8952$$Nest$fgetmService(serviceState3) != null) goto L45;
            TvInteractiveAppManagerService.m8919$$Nest$mupdateServiceConnectionLocked(this.this$0, TvInteractiveAppState.m8975$$Nest$fgetmComponentName(iAppState), resolvedUserId);     // Catch: Throwable -> L15
        L48:
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L45:
            if (TvInteractiveAppManagerService.m8896$$Nest$mcreateSessionInternalLocked(this.this$0, ServiceState.m8952$$Nest$fgetmService(serviceState3), r4, resolvedUserId) == true) goto L48;
            TvInteractiveAppManagerService.m8910$$Nest$mremoveSessionStateLocked(this.this$0, r4, resolvedUserId);     // Catch: Throwable -> L15
        L33:
            th = th;
            goto L51
        L35:
            serviceState3 = serviceState;
        L53:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void releaseSession(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "releaseSession");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r4);     // Catch: Throwable -> L12
            TvInteractiveAppManagerService.m8907$$Nest$mreleaseAdSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L9
            monitor-exit(r4);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTuned(IBinder sessionToken, Uri channelUri, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTuned");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTuned(channelUri);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTuned", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTrackSelected(IBinder sessionToken, int type, String trackId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTrackSelected");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTrackSelected(type, trackId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTrackSelected", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTracksChanged(IBinder sessionToken, List<TvTrackInfo> tracks, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTracksChanged");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTracksChanged(tracks);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTracksChanged", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyVideoAvailable(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyVideoAvailable");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyVideoAvailable();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyVideoAvailable", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyVideoUnavailable(IBinder sessionToken, int reason, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyVideoUnavailable");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyVideoUnavailable(reason);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyVideoUnavailable", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyVideoFreezeUpdated(IBinder sessionToken, boolean isFrozen, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyVideoFreezeUpdated");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyVideoFreezeUpdated(isFrozen);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyVideoFreezeUpdated", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyContentAllowed(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyContentAllowed");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyContentAllowed();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyContentAllowed", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyContentBlocked(IBinder sessionToken, String rating, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyContentBlocked");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyContentBlocked(rating);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyContentBlocked", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifySignalStrength(IBinder sessionToken, int strength, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifySignalStrength");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifySignalStrength(strength);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifySignalStrength", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTvMessage(IBinder sessionToken, int type, Bundle data, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyTvMessage");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTvMessage(type, data);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTvMessage", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingStarted(IBinder sessionToken, String recordingId, String requestId, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyRecordingStarted");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingStarted(recordingId, requestId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingStarted", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingStopped(IBinder sessionToken, String recordingId, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyRecordingStopped");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingStopped(recordingId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingStopped", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void startInteractiveApp(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "startInteractiveApp");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).startInteractiveApp();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in start", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void stopInteractiveApp(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "stopInteractiveApp");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).stopInteractiveApp();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in stop", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void resetInteractiveApp(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "resetInteractiveApp");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).resetInteractiveApp();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in reset", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void createBiInteractiveApp(IBinder sessionToken, Uri biIAppUri, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "createBiInteractiveApp");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).createBiInteractiveApp(biIAppUri, params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in createBiInteractiveApp", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void destroyBiInteractiveApp(IBinder sessionToken, String biIAppId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "destroyBiInteractiveApp");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).destroyBiInteractiveApp(biIAppId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in destroyBiInteractiveApp", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setTeletextAppEnabled(IBinder sessionToken, boolean enable, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setTeletextAppEnabled");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).setTeletextAppEnabled(enable);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in setTeletextAppEnabled", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentVideoBounds(IBinder sessionToken, Rect bounds, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentVideoBounds");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendCurrentVideoBounds(bounds);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentVideoBounds", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentChannelUri(IBinder sessionToken, Uri channelUri, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentChannelUri");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendCurrentChannelUri(channelUri);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentChannelUri", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentChannelLcn(IBinder sessionToken, int lcn, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentChannelLcn");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendCurrentChannelLcn(lcn);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentChannelLcn", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendStreamVolume(IBinder sessionToken, float volume, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendStreamVolume");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendStreamVolume(volume);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendStreamVolume", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendTrackInfoList(IBinder sessionToken, List<TvTrackInfo> tracks, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendTrackInfoList");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendTrackInfoList(tracks);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendTrackInfoList", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendSelectedTrackInfo(IBinder sessionToken, List<TvTrackInfo> tracks, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendSelectedTrackInfo");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendSelectedTrackInfo(tracks);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendSelectedTrackInfo", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentTvInputId(IBinder sessionToken, String inputId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentTvInputId");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendCurrentTvInputId(inputId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentTvInputId", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendTimeShiftMode(IBinder sessionToken, int mode, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendTimeShiftMode");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendTimeShiftMode(mode);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendTimeShiftMode", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendAvailableSpeeds(IBinder sessionToken, float[] speeds, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendAvailableSpeeds");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendAvailableSpeeds(speeds);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendAvailableSpeeds", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendTvRecordingInfo(IBinder sessionToken, TvRecordingInfo recordingInfo, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendTvRecordingInfo");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendTvRecordingInfo(recordingInfo);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendTvRecordingInfo", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendTvRecordingInfoList(IBinder sessionToken, List<TvRecordingInfo> recordingInfoList, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendTvRecordingInfoList");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendTvRecordingInfoList(recordingInfoList);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendTvRecordingInfoList", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendSigningResult(IBinder sessionToken, String signingId, byte[] result, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendSigningResult");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendSigningResult(signingId, result);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendSigningResult", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCertificate(IBinder sessionToken, String host, int port, Bundle certBundle, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCertificate");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).sendCertificate(host, port, certBundle);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCertificate", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyError(IBinder sessionToken, String errMsg, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyError");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyError(errMsg, params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyError", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTimeShiftPlaybackParams(IBinder sessionToken, PlaybackParams params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTimeShiftPlaybackParams");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTimeShiftPlaybackParams(params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTimeShiftPlaybackParams", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTimeShiftStatusChanged(IBinder sessionToken, String inputId, int status, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTimeShiftStatusChanged");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTimeShiftStatusChanged(inputId, status);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTimeShiftStatusChanged", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTimeShiftStartPositionChanged(IBinder sessionToken, String inputId, long timeMs, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTimeShiftStartPositionChanged");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTimeShiftStartPositionChanged(inputId, timeMs);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTimeShiftStartPositionChanged", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTimeShiftCurrentPositionChanged(IBinder sessionToken, String inputId, long timeMs, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTimeShiftCurrentPositionChanged");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTimeShiftCurrentPositionChanged(inputId, timeMs);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTimeShiftCurrentPositionChanged", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingConnectionFailed(IBinder sessionToken, String recordingId, String inputId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyRecordingConnectionFailed");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingConnectionFailed(recordingId, inputId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingConnectionFailed", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingDisconnected(IBinder sessionToken, String recordingId, String inputId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyRecordingDisconnected");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingDisconnected(recordingId, inputId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingDisconnected", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingTuned(IBinder sessionToken, String recordingId, Uri channelUri, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyRecordingTuned");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingTuned(recordingId, channelUri);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingTuned", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingError(IBinder sessionToken, String recordingId, int err, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyRecordingError");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingError(recordingId, err);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingError", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyRecordingScheduled(IBinder sessionToken, String recordingId, String requestId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyRecordingScheduled");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyRecordingScheduled(recordingId, requestId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyRecordingScheduled", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setSurface(IBinder sessionToken, Surface surface, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setSurface");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r5);     // Catch: Throwable -> L18
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).setSurface(surface);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            if (surface == null) goto L14;
            surface.release();
        L14:
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in setSurface", e);     // Catch: Throwable -> L7
        L18:
            th = move-exception;
            if (surface == null) goto L21;
            surface.release();
        L21:
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void dispatchSurfaceChanged(IBinder sessionToken, int format, int width, int height, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "dispatchSurfaceChanged");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).dispatchSurfaceChanged(format, width, height);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in dispatchSurfaceChanged", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyBroadcastInfoResponse(IBinder sessionToken, BroadcastInfoResponse response, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyBroadcastInfoResponse");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyBroadcastInfoResponse(response);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyBroadcastInfoResponse", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyAdResponse(IBinder sessionToken, AdResponse response, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyAdResponse");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyAdResponse(response);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyAdResponse", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyAdBufferConsumed(IBinder sessionToken, AdBuffer buffer, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyAdBufferConsumed");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L27
            monitor-enter(r5);     // Catch: Throwable -> L27
            SessionState sessionState = TvInteractiveAppManagerService.m8904$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L12 Throwable -> L14
            TvInteractiveAppManagerService.m8903$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyAdBufferConsumed(buffer);     // Catch: Throwable -> L12 Throwable -> L14
            if (buffer == null) goto L18;
            SharedMemory r6 = buffer.getSharedMemory();     // Catch: Throwable -> L10
        L8:
            r6.close();     // Catch: Throwable -> L10
        L18:
            monitor-exit(r5);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L14:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyAdBufferConsumed", e);     // Catch: Throwable -> L12
            if (buffer == null) goto L18;
            r6 = buffer.getSharedMemory();     // Catch: Throwable -> L10
            goto L8
        L12:
            th = move-exception;
            if (buffer == null) goto L24;
            buffer.getSharedMemory().close();     // Catch: Throwable -> L10
        L24:
            throw th;     // Catch: Throwable -> L10
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void registerCallback(ITvInteractiveAppManagerCallback callback, int userId) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "registerCallback");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r5);     // Catch: Throwable -> L15
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            if (UserState.m8986$$Nest$fgetmCallbacks(userState).register(callback) == true) goto L10;
            Slog.e(TvInteractiveAppManagerService.TAG, "client process has already died");     // Catch: Throwable -> L8
        L10:
            monitor-exit(r5);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unregisterCallback(ITvInteractiveAppManagerCallback callback, int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "unregisterCallback");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            UserState.m8986$$Nest$fgetmCallbacks(userState).unregister(callback);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void createMediaView(IBinder sessionToken, IBinder windowToken, Rect frame, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "createMediaView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInteractiveAppManagerService.m8902$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).createMediaView(windowToken, frame);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in createMediaView", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void relayoutMediaView(IBinder sessionToken, Rect frame, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "relayoutMediaView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInteractiveAppManagerService.m8902$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).relayoutMediaView(frame);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in relayoutMediaView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removeMediaView(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "removeMediaView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInteractiveAppManagerService.m8902$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).removeMediaView();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in removeMediaView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static class ClientPidNotFoundException extends IllegalArgumentException {
        ClientPidNotFoundException(String name) {
            super(name);
        }
    }

    private final class ClientState implements IBinder.DeathRecipient {
        private IBinder mClientToken;
        private final List<IBinder> mSessionTokens;
        private final int mUserId;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8943$$Nest$fgetmSessionTokens(ClientState r0) {
            return r0.mSessionTokens;
        }

        ClientState(TvInteractiveAppManagerService r1, IBinder clientToken, int userId) {
            this.this$0 = r1;
            this.mSessionTokens = new ArrayList();
            this.mClientToken = clientToken;
            this.mUserId = userId;
        }

        public boolean isEmpty() {
            return this.mSessionTokens.isEmpty();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L11
            ClientState clientState = (ClientState) UserState.m8987$$Nest$fgetmClientStateMap(userState).get(this.mClientToken);     // Catch: Throwable -> L11
            if (clientState != null) goto L7;
        L14:
            this.mClientToken = null;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (clientState.mSessionTokens.size() <= 0) goto L14;
            IBinder sessionToken = clientState.mSessionTokens.get(0);     // Catch: Throwable -> L11
            TvInteractiveAppManagerService.m8908$$Nest$mreleaseSessionLocked(this.this$0, sessionToken, 1000, this.mUserId);     // Catch: Throwable -> L11
            if (clientState.mSessionTokens.contains(sessionToken) == false) goto L7;
            Slogf.d(TvInteractiveAppManagerService.TAG, "remove sessionToken " + sessionToken + " for " + this.mClientToken);     // Catch: Throwable -> L11
            clientState.mSessionTokens.remove(sessionToken);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }
    }

    private final class InteractiveAppServiceConnection implements ServiceConnection {
        private final ComponentName mComponent;
        private final int mUserId;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* synthetic */ InteractiveAppServiceConnection(TvInteractiveAppManagerService r1, ComponentName r2, int r3, TvInteractiveAppManagerServiceIA r4) {
            this(r1, r2, r3);
        }

        private InteractiveAppServiceConnection(TvInteractiveAppManagerService r1, ComponentName component, int userId) {
            this.this$0 = r1;
            this.mComponent = component;
            this.mUserId = userId;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName component, IBinder service) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInteractiveAppManagerService.m8905$$Nest$mgetUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L9
            if (userState != null) goto L11;
            TvInteractiveAppManagerService.m8878$$Nest$fgetmContext(this.this$0).unbindService(this);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(this.mComponent);     // Catch: Throwable -> L9
            ServiceState.m8957$$Nest$fputmService(serviceState, ITvInteractiveAppService.Stub.asInterface(service));     // Catch: Throwable -> L9
            if (ServiceState.m8945$$Nest$fgetmCallback(serviceState) != null) goto L19;
            ServiceState.m8955$$Nest$fputmCallback(serviceState, new ServiceCallback(this.this$0, this.mComponent, this.mUserId));     // Catch: Throwable -> L9
            ServiceState.m8952$$Nest$fgetmService(serviceState).registerCallback(ServiceState.m8945$$Nest$fgetmCallback(serviceState));     // Catch: Throwable -> L9 RemoteException -> L16
        L16:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in registerCallback", e);     // Catch: Throwable -> L9
        L19:
            if (ServiceState.m8950$$Nest$fgetmPendingAppLinkInfo(serviceState).isEmpty() == true) goto L42;
            Iterator<Pair<AppLinkInfo, Boolean>> it = ServiceState.m8950$$Nest$fgetmPendingAppLinkInfo(serviceState).iterator();     // Catch: Throwable -> L9
        L22:
            if (it.hasNext() == false) goto L42;
            Pair<AppLinkInfo, Boolean> appLinkInfoPair = it.next();     // Catch: Throwable -> L9
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            if (((Boolean) appLinkInfoPair.second).booleanValue() == false) goto L31;
            ServiceState.m8952$$Nest$fgetmService(serviceState).registerAppLinkInfo((AppLinkInfo) appLinkInfoPair.first);     // Catch: Throwable -> L27 RemoteException -> L29
        L32:
            it.remove();     // Catch: Throwable -> L27 RemoteException -> L29
        L33:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L9
            goto L22
        L31:
            ServiceState.m8952$$Nest$fgetmService(serviceState).unregisterAppLinkInfo((AppLinkInfo) appLinkInfoPair.first);     // Catch: Throwable -> L27 RemoteException -> L29
            goto L32
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L29:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyAppLinkInfo(" + appLinkInfoPair + ") when onServiceConnected", e);     // Catch: Throwable -> L27
        L42:
            if (ServiceState.m8949$$Nest$fgetmPendingAppLinkCommand(serviceState).isEmpty() == true) goto L58;
            Iterator<Bundle> it2 = ServiceState.m8949$$Nest$fgetmPendingAppLinkCommand(serviceState).iterator();     // Catch: Throwable -> L9
        L45:
            if (it2.hasNext() == false) goto L58;
            Bundle command = it2.next();     // Catch: Throwable -> L9
            long identity2 = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            ServiceState.m8952$$Nest$fgetmService(serviceState).sendAppLinkCommand(command);     // Catch: Throwable -> L50 RemoteException -> L52
            it2.remove();     // Catch: Throwable -> L50 RemoteException -> L52
        L48:
            Binder.restoreCallingIdentity(identity2);     // Catch: Throwable -> L9
        L52:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendAppLinkCommand(" + command + ") when onServiceConnected", e);     // Catch: Throwable -> L50
        L50:
            th = move-exception;
            Binder.restoreCallingIdentity(identity2);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L58:
            List<IBinder> tokensToBeRemoved = new ArrayList();     // Catch: Throwable -> L9
            Iterator r4 = ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState).iterator();     // Catch: Throwable -> L9
        L60:
            if (r4.hasNext() == false) goto L65;
            IBinder sessionToken = (IBinder) r4.next();     // Catch: Throwable -> L9
            if (TvInteractiveAppManagerService.m8896$$Nest$mcreateSessionInternalLocked(this.this$0, ServiceState.m8952$$Nest$fgetmService(serviceState), sessionToken, this.mUserId) == true) goto L60;
            tokensToBeRemoved.add(sessionToken);     // Catch: Throwable -> L9
            goto L60
        L65:
            Iterator<IBinder> r5 = tokensToBeRemoved.iterator();     // Catch: Throwable -> L9
        L67:
            if (r5.hasNext() == false) goto L69;
            TvInteractiveAppManagerService.m8910$$Nest$mremoveSessionStateLocked(this.this$0, r5.next(), this.mUserId);     // Catch: Throwable -> L9
            goto L67
        L69:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName component) {
            if (this.mComponent.equals(component) == false) goto L16;
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L9
            ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(this.mComponent);     // Catch: Throwable -> L9
            if (serviceState == null) goto L11;
            ServiceState.m8956$$Nest$fputmReconnecting(serviceState, true);     // Catch: Throwable -> L9
            ServiceState.m8954$$Nest$fputmBound(serviceState, false);     // Catch: Throwable -> L9
            ServiceState.m8957$$Nest$fputmService(serviceState, null);     // Catch: Throwable -> L9
            ServiceState.m8955$$Nest$fputmCallback(serviceState, null);     // Catch: Throwable -> L9
            TvInteractiveAppManagerService.m8889$$Nest$mabortPendingCreateSessionRequestsLocked(this.this$0, serviceState, null, this.mUserId);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L16:
            throw new IllegalArgumentException("Mismatched ComponentName: " + this.mComponent + " (expected), " + component + " (actual).");
        }
    }

    private class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        MyPackageMonitor(TvInteractiveAppManagerService r1, boolean supportsPackageRestartQuery) {
            this.this$0 = r1;
            super(supportsPackageRestartQuery);
        }

        private void buildTvInteractiveAppServiceList(String[] packages) {
            int userId = getChangingUserId();
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (TvInteractiveAppManagerService.m8879$$Nest$fgetmCurrentUserId(this.this$0) == userId) goto L11;
            if (TvInteractiveAppManagerService.m8884$$Nest$fgetmRunningProfiles(this.this$0).contains(Integer.valueOf(userId)) == true) goto L11;
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L11:
            TvInteractiveAppManagerService.m8892$$Nest$mbuildTvInteractiveAppServiceListLocked(this.this$0, userId, packages);     // Catch: Throwable -> L9
            TvInteractiveAppManagerService.m8890$$Nest$mbuildAppLinkInfoLocked(this.this$0, userId);     // Catch: Throwable -> L9
            goto L12
        }

        private void buildTvAdServiceList(String[] packages) {
            int userId = getChangingUserId();
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (TvInteractiveAppManagerService.m8879$$Nest$fgetmCurrentUserId(this.this$0) == userId) goto L11;
            if (TvInteractiveAppManagerService.m8884$$Nest$fgetmRunningProfiles(this.this$0).contains(Integer.valueOf(userId)) == true) goto L11;
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L11:
            TvInteractiveAppManagerService.m8891$$Nest$mbuildTvAdServiceListLocked(this.this$0, userId, packages);     // Catch: Throwable -> L9
            goto L12
        }

        public void onPackageUpdateFinished(String packageName, int uid) {
            buildTvInteractiveAppServiceList(new String[]{packageName});
            buildTvAdServiceList(new String[]{packageName});
        }

        public void onPackagesAvailable(String[] packages) {
            if (isReplacing() == false) goto L6;
            buildTvInteractiveAppServiceList(packages);
            buildTvAdServiceList(packages);
            return;
        }

        public void onPackagesUnavailable(String[] packages) {
            if (isReplacing() == false) goto L6;
            buildTvInteractiveAppServiceList(packages);
            buildTvAdServiceList(packages);
            return;
        }

        public void onSomePackagesChanged() {
            if (isReplacing() == false) goto L5;
            return;
        L5:
            buildTvInteractiveAppServiceList(null);
            buildTvAdServiceList(null);
        }

        public boolean onPackageChanged(String packageName, int uid, String[] components) {
            return true;
        }
    }

    private final class ServiceCallback extends ITvInteractiveAppServiceCallback.Stub {
        private final ComponentName mComponent;
        private final int mUserId;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        ServiceCallback(TvInteractiveAppManagerService r1, ComponentName component, int userId) {
            this.this$0 = r1;
            this.mComponent = component;
            this.mUserId = userId;
        }

        public void onStateChanged(int type, int state, int error) {
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L19
            monitor-enter(r3);     // Catch: Throwable -> L19
            ServiceState serviceState = TvInteractiveAppManagerService.m8901$$Nest$mgetServiceStateLocked(this.this$0, this.mComponent, this.mUserId);     // Catch: Throwable -> L13
            String iAppServiceId = ServiceState.m8948$$Nest$fgetmIAppServiceId(serviceState);     // Catch: Throwable -> L13
            UserState userState = TvInteractiveAppManagerService.m8905$$Nest$mgetUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L13
            TvInteractiveAppManagerService.m8906$$Nest$mnotifyStateChangedLocked(this.this$0, userState, iAppServiceId, type, state, error);     // Catch: Throwable -> L11
            monitor-exit(r3);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return;
        L13:
            th = move-exception;
            Throwable r12 = th;
        L15:
            monitor-exit(r3);     // Catch: Throwable -> L11
            throw r12;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Throwable r13 = th;
        L21:
            Binder.restoreCallingIdentity(identity);
            throw r13;
        L11:
            th = move-exception;
            r12 = th;
        L19:
            th = move-exception;
            r13 = th;
            goto L21
        }
    }

    private final class ServiceState {
        private boolean mBound;
        private ServiceCallback mCallback;
        private final ComponentName mComponent;
        private final ServiceConnection mConnection;
        private final String mIAppServiceId;
        private final List<Bundle> mPendingAppLinkCommand;
        private final List<Pair<AppLinkInfo, Boolean>> mPendingAppLinkInfo;
        private boolean mReconnecting;
        private ITvInteractiveAppService mService;
        private final List<IBinder> mSessionTokens;

        /* JADX INFO: renamed from: -$$Nest$fgetmBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8944$$Nest$fgetmBound(ServiceState r0) {
            return r0.mBound;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ ServiceCallback m8945$$Nest$fgetmCallback(ServiceState r0) {
            return r0.mCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmComponent, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8946$$Nest$fgetmComponent(ServiceState r0) {
            return r0.mComponent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConnection, reason: not valid java name */
        static /* bridge */ /* synthetic */ ServiceConnection m8947$$Nest$fgetmConnection(ServiceState r0) {
            return r0.mConnection;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIAppServiceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8948$$Nest$fgetmIAppServiceId(ServiceState r0) {
            return r0.mIAppServiceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingAppLinkCommand, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8949$$Nest$fgetmPendingAppLinkCommand(ServiceState r0) {
            return r0.mPendingAppLinkCommand;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingAppLinkInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8950$$Nest$fgetmPendingAppLinkInfo(ServiceState r0) {
            return r0.mPendingAppLinkInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReconnecting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8951$$Nest$fgetmReconnecting(ServiceState r0) {
            return r0.mReconnecting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvInteractiveAppService m8952$$Nest$fgetmService(ServiceState r0) {
            return r0.mService;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8953$$Nest$fgetmSessionTokens(ServiceState r0) {
            return r0.mSessionTokens;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmBound, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8954$$Nest$fputmBound(ServiceState r0, boolean r1) {
            r0.mBound = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8955$$Nest$fputmCallback(ServiceState r0, ServiceCallback r1) {
            r0.mCallback = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmReconnecting, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8956$$Nest$fputmReconnecting(ServiceState r0, boolean r1) {
            r0.mReconnecting = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8957$$Nest$fputmService(ServiceState r0, ITvInteractiveAppService r1) {
            r0.mService = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$maddPendingAppLink, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8958$$Nest$maddPendingAppLink(ServiceState r0, AppLinkInfo r1, boolean r2) {
            r0.addPendingAppLink(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$maddPendingAppLinkCommand, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8959$$Nest$maddPendingAppLinkCommand(ServiceState r0, Bundle r1) {
            r0.addPendingAppLinkCommand(r1);
        }

        /* synthetic */ ServiceState(TvInteractiveAppManagerService r1, ComponentName r2, String r3, int r4, TvInteractiveAppManagerServiceIA r5) {
            this(r1, r2, r3, r4);
        }

        private ServiceState(TvInteractiveAppManagerService r3, ComponentName component, String tias, int userId) {
            this.mSessionTokens = new ArrayList();
            this.mPendingAppLinkInfo = new ArrayList();
            this.mPendingAppLinkCommand = new ArrayList();
            this.mComponent = component;
            this.mConnection = new InteractiveAppServiceConnection(r3, component, userId, null);
            this.mIAppServiceId = tias;
        }

        private void addPendingAppLink(AppLinkInfo info, boolean register) {
            this.mPendingAppLinkInfo.add(Pair.create(info, Boolean.valueOf(register)));
        }

        private void addPendingAppLinkCommand(Bundle command) {
            this.mPendingAppLinkCommand.add(command);
        }
    }

    private final class SessionCallback extends ITvInteractiveAppSessionCallback.Stub {
        private final InputChannel[] mInputChannels;
        private final SessionState mSessionState;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        SessionCallback(TvInteractiveAppManagerService r1, SessionState sessionState, InputChannel[] channels) {
            this.this$0 = r1;
            this.mSessionState = sessionState;
            this.mInputChannels = channels;
        }

        public void onSessionCreated(ITvInteractiveAppSession session) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            SessionState.m8969$$Nest$fputmSession(this.mSessionState, session);     // Catch: Throwable -> L9
            if (session != null) goto L7;
        L11:
            TvInteractiveAppManagerService.m8910$$Nest$mremoveSessionStateLocked(this.this$0, SessionState.m8966$$Nest$fgetmSessionToken(this.mSessionState), SessionState.m8968$$Nest$fgetmUserId(this.mSessionState));     // Catch: Throwable -> L9
            TvInteractiveAppManagerService.m8914$$Nest$msendSessionTokenToClientLocked(this.this$0, SessionState.m8961$$Nest$fgetmClient(this.mSessionState), SessionState.m8963$$Nest$fgetmIAppServiceId(this.mSessionState), null, null, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L9
        L12:
            this.mInputChannels[0].dispose();     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L7:
            if (addSessionTokenToClientStateLocked(session) == false) goto L11;
            TvInteractiveAppManagerService.m8914$$Nest$msendSessionTokenToClientLocked(this.this$0, SessionState.m8961$$Nest$fgetmClient(this.mSessionState), SessionState.m8963$$Nest$fgetmIAppServiceId(this.mSessionState), SessionState.m8966$$Nest$fgetmSessionToken(this.mSessionState), this.mInputChannels[0], SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void onLayoutSurface(int left, int top, int right, int bottom) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r9 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r9;
        L17:
            th = move-exception;
            r9 = th;
            goto L28
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) == null) goto L26;
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L26;
        L31:
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onLayoutSurface(left, top, right, bottom, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onLayoutSurface", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onBroadcastInfoRequest(BroadcastInfoRequest request) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onBroadcastInfoRequest(request, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onBroadcastInfoRequest", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRemoveBroadcastInfo(int requestId) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRemoveBroadcastInfo(requestId, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRemoveBroadcastInfo", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onCommandRequest(String cmdType, Bundle parameters) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onCommandRequest(cmdType, parameters, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onCommandRequest", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTimeShiftCommandRequest(String cmdType, Bundle parameters) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onTimeShiftCommandRequest(cmdType, parameters, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onTimeShiftCommandRequest", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onSetVideoBounds(Rect rect) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onSetVideoBounds(rect, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onSetVideoBounds", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestCurrentVideoBounds() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestCurrentVideoBounds(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentVideoBounds", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestCurrentChannelUri() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestCurrentChannelUri(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentChannelUri", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestCurrentChannelLcn() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestCurrentChannelLcn(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentChannelLcn", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestStreamVolume() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestStreamVolume(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestStreamVolume", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestTrackInfoList() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestTrackInfoList(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestTrackInfoList", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestSelectedTrackInfo() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestSelectedTrackInfo(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestSelectedTrackInfo", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestCurrentTvInputId() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestCurrentTvInputId(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCurrentTvInputId", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestTimeShiftMode() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestTimeShiftMode(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestTimeShiftMode", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestAvailableSpeeds() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestAvailableSpeeds(SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestAvailableSpeeds", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestStartRecording(String requestId, Uri programUri) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestStartRecording(requestId, programUri, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestStartRecording", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestStopRecording(String recordingId) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestStopRecording(recordingId, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestStopRecording", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestScheduleRecording(String requestId, String inputId, Uri channelUri, Uri programUri, Bundle params) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r10 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r10;
        L17:
            th = move-exception;
            r10 = th;
            goto L28
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) == null) goto L26;
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L26;
        L33:
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestScheduleRecording(requestId, inputId, channelUri, programUri, params, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestScheduleRecording", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onRequestScheduleRecording2(String requestId, String inputId, Uri channelUri, long start, long duration, int repeat, Bundle params) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestScheduleRecording2(requestId, inputId, channelUri, start, duration, repeat, params, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestScheduleRecording2", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onSetTvRecordingInfo(String recordingId, TvRecordingInfo recordingInfo) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onSetTvRecordingInfo(recordingId, recordingInfo, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onSetTvRecordingInfo", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestTvRecordingInfo(String recordingId) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestTvRecordingInfo(recordingId, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestTvRecordingInfo", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestTvRecordingInfoList(int type) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestTvRecordingInfoList(type, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestTvRecordingInfoList", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRequestSigning(String id, String algorithm, String alias, byte[] data) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r9 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r9;
        L17:
            th = move-exception;
            r9 = th;
            goto L28
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) == null) goto L26;
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L26;
        L31:
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestSigning(id, algorithm, alias, data, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestSigning", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onRequestSigning2(String id, String algorithm, String host, int port, byte[] data) {
            Object r1 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r10 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r10;
        L17:
            th = move-exception;
            r10 = th;
            goto L28
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) == null) goto L26;
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L26;
        L33:
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestSigning2(id, algorithm, host, port, data, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestSigning", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onRequestCertificate(String host, int port) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onRequestCertificate(host, port, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onRequestCertificate", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAdRequest(AdRequest request) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onAdRequest(request, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onAdRequest", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onSessionStateChanged(int state, int err) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onSessionStateChanged(state, err, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onSessionStateChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onBiInteractiveAppCreated(Uri biIAppUri, String biIAppId) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onBiInteractiveAppCreated(biIAppUri, biIAppId, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onBiInteractiveAppCreated", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTeletextAppStateChanged(int state) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L17;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onTeletextAppStateChanged(state, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onTeletextAppStateChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAdBufferReady(AdBuffer buffer) {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8965$$Nest$fgetmSession(this.mSessionState) != null) goto L33;
        L28:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L33:
            if (SessionState.m8961$$Nest$fgetmClient(this.mSessionState) == null) goto L28;
            SessionState.m8961$$Nest$fgetmClient(this.mSessionState).onAdBufferReady(buffer, SessionState.m8964$$Nest$fgetmSeq(this.mSessionState));     // Catch: Throwable -> L16 RemoteException -> L18
            if (buffer == null) goto L22;
            SharedMemory r1 = buffer.getSharedMemory();     // Catch: Throwable -> L14
        L12:
            r1.close();     // Catch: Throwable -> L14
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L18:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in onAdBuffer", e);     // Catch: Throwable -> L16
            if (buffer == null) goto L22;
            r1 = buffer.getSharedMemory();     // Catch: Throwable -> L14
        L16:
            th = move-exception;
            if (buffer == null) goto L27;
            buffer.getSharedMemory().close();     // Catch: Throwable -> L14
        L27:
            throw th;     // Catch: Throwable -> L14
        }

        private boolean addSessionTokenToClientStateLocked(ITvInteractiveAppSession session) {
            session.asBinder().linkToDeath(this.mSessionState, 0);     // Catch: RemoteException -> L14
            IBinder clientToken = SessionState.m8961$$Nest$fgetmClient(this.mSessionState).asBinder();
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, SessionState.m8968$$Nest$fgetmUserId(this.mSessionState));
            ClientState clientState = (ClientState) UserState.m8987$$Nest$fgetmClientStateMap(userState).get(clientToken);
            if (clientState != null) goto L12;
            clientState = new ClientState(this.this$0, clientToken, SessionState.m8968$$Nest$fgetmUserId(this.mSessionState));
            clientToken.linkToDeath(clientState, 0);     // Catch: RemoteException -> L9
            UserState.m8987$$Nest$fgetmClientStateMap(userState).put(clientToken, clientState);
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "client process has already died", e);
            return false;
        L12:
            ClientState.m8943$$Nest$fgetmSessionTokens(clientState).add(SessionState.m8966$$Nest$fgetmSessionToken(this.mSessionState));
            return true;
        L14:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "session process has already died", e);
            return false;
        }
    }

    private static class SessionNotFoundException extends IllegalArgumentException {
        SessionNotFoundException(String name) {
            super(name);
        }
    }

    private final class SessionState implements IBinder.DeathRecipient {
        private final int mCallingPid;
        private final int mCallingUid;
        private final ITvInteractiveAppClient mClient;
        private final ComponentName mComponent;
        private final String mIAppServiceId;
        private final int mSeq;
        private ITvInteractiveAppSession mSession;
        private final IBinder mSessionToken;
        private final int mType;
        private final int mUserId;
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallingUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8960$$Nest$fgetmCallingUid(SessionState r0) {
            return r0.mCallingUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvInteractiveAppClient m8961$$Nest$fgetmClient(SessionState r0) {
            return r0.mClient;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmComponent, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8962$$Nest$fgetmComponent(SessionState r0) {
            return r0.mComponent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIAppServiceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8963$$Nest$fgetmIAppServiceId(SessionState r0) {
            return r0.mIAppServiceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSeq, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8964$$Nest$fgetmSeq(SessionState r0) {
            return r0.mSeq;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvInteractiveAppSession m8965$$Nest$fgetmSession(SessionState r0) {
            return r0.mSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8966$$Nest$fgetmSessionToken(SessionState r0) {
            return r0.mSessionToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8967$$Nest$fgetmType(SessionState r0) {
            return r0.mType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8968$$Nest$fgetmUserId(SessionState r0) {
            return r0.mUserId;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8969$$Nest$fputmSession(SessionState r0, ITvInteractiveAppSession r1) {
            r0.mSession = r1;
        }

        /* synthetic */ SessionState(TvInteractiveAppManagerService r1, IBinder r2, String r3, int r4, ComponentName r5, ITvInteractiveAppClient r6, int r7, int r8, int r9, int r10, TvInteractiveAppManagerServiceIA r11) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        private SessionState(TvInteractiveAppManagerService r1, IBinder sessionToken, String iAppServiceId, int type, ComponentName componentName, ITvInteractiveAppClient client, int seq, int callingUid, int callingPid, int userId) {
            this.this$0 = r1;
            this.mSessionToken = sessionToken;
            this.mIAppServiceId = iAppServiceId;
            this.mComponent = componentName;
            this.mType = type;
            this.mClient = client;
            this.mSeq = seq;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mUserId = userId;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mSession = null;     // Catch: Throwable -> L8
            TvInteractiveAppManagerService.m8894$$Nest$mclearSessionAndNotifyClientLocked(this.this$0, this);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private final class TvAdBinderService extends ITvAdManager.Stub {
        final /* synthetic */ TvInteractiveAppManagerService this$0;

        /* synthetic */ TvAdBinderService(TvInteractiveAppManagerService r1, TvInteractiveAppManagerServiceIA r2) {
            this(r1);
        }

        private TvAdBinderService(TvInteractiveAppManagerService r1) {
            this.this$0 = r1;
        }

        public List<TvAdServiceInfo> getTvAdServiceList(int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getTvAdServiceList");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L19
            monitor-enter(r3);     // Catch: Throwable -> L19
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L6:
            if (TvInteractiveAppManagerService.m8880$$Nest$fgetmGetAdServiceListCalled(this.this$0) == true) goto L10;
            TvInteractiveAppManagerService.m8891$$Nest$mbuildTvAdServiceListLocked(this.this$0, userId, null);     // Catch: Throwable -> L8
            TvInteractiveAppManagerService.m8885$$Nest$fputmGetAdServiceListCalled(this.this$0, true);     // Catch: Throwable -> L8
        L10:
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            List<TvAdServiceInfo> adServiceList = new ArrayList();     // Catch: Throwable -> L8
            Iterator r6 = UserState.m8982$$Nest$fgetmAdServiceMap(userState).values().iterator();     // Catch: Throwable -> L8
        L12:
            if (r6.hasNext() == false) goto L14;
            TvAdServiceState state = (TvAdServiceState) r6.next();     // Catch: Throwable -> L8
            adServiceList.add(TvAdServiceState.m8971$$Nest$fgetmInfo(state));     // Catch: Throwable -> L8
            goto L12
        L14:
            monitor-exit(r3);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return adServiceList;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendAppLinkCommand(String serviceId, Bundle command, int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "sendAppLinkCommand");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L35 RemoteException -> L37
            monitor-enter(r3);     // Catch: Throwable -> L35 RemoteException -> L37
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L21
            TvAdServiceState adServiceState = (TvAdServiceState) UserState.m8982$$Nest$fgetmAdServiceMap(userState).get(serviceId);     // Catch: Throwable -> L21
            if (adServiceState == null) goto L47;
            ComponentName componentName = TvAdServiceState.m8971$$Nest$fgetmInfo(adServiceState).getComponent();     // Catch: Throwable -> L21
            AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(componentName);     // Catch: Throwable -> L21
            if (serviceState != null) goto L24;
            AdServiceState serviceState2 = new AdServiceState(this.this$0, componentName, serviceId, resolvedUserId, null);     // Catch: Throwable -> L19
            AdServiceState.m8932$$Nest$maddPendingAppLinkCommand(serviceState2, command);     // Catch: Throwable -> L19
            UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).put(componentName, serviceState2);     // Catch: Throwable -> L19
            TvInteractiveAppManagerService.m8918$$Nest$mupdateAdServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L19
        L27:
            monitor-exit(r3);     // Catch: Throwable -> L19
        L28:
            Binder.restoreCallingIdentity(identity);
            return;
        L24:
            if (AdServiceState.m8926$$Nest$fgetmService(serviceState) == null) goto L26;
            AdServiceState.m8926$$Nest$fgetmService(serviceState).sendAppLinkCommand(command);     // Catch: Throwable -> L19
            goto L27
        L26:
            AdServiceState.m8932$$Nest$maddPendingAppLinkCommand(serviceState, command);     // Catch: Throwable -> L19
            TvInteractiveAppManagerService.m8918$$Nest$mupdateAdServiceConnectionLocked(this.this$0, componentName, resolvedUserId);     // Catch: Throwable -> L19
            goto L27
        L47:
            Slogf.e(TvInteractiveAppManagerService.TAG, "failed to sendAppLinkCommand - unknown service id " + serviceId);     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            th = th;
        L29:
            monitor-exit(r3);     // Catch: Throwable -> L19
            throw th;     // Catch: Throwable -> L31 RemoteException -> L33
        L33:
            e = move-exception;
            RemoteException e = e;
        L40:
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendAppLinkCommand", e);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            Throwable r13 = th;
        L43:
            Binder.restoreCallingIdentity(identity);
            throw r13;
        L21:
            th = th;
            goto L29
        L19:
            th = th;
        L37:
            e = move-exception;
            e = e;
        L35:
            th = move-exception;
            r13 = th;
            goto L43
        }

        public void createSession(ITvAdClient client, String serviceId, String type, int seq, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "createSession");
            long identity = Binder.clearCallingIdentity();
            Object r17 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L53
            monitor-enter(r17);     // Catch: Throwable -> L53
        L15:
            th = th;
        L51:
            monitor-exit(r17);     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L53
        L6:
            if (userId == TvInteractiveAppManagerService.m8879$$Nest$fgetmCurrentUserId(this.this$0)) goto L20;
        L17:
            th = th;
            goto L51
        L8:
            if (TvInteractiveAppManagerService.m8884$$Nest$fgetmRunningProfiles(this.this$0).contains(Integer.valueOf(userId)) == true) goto L20;
            TvInteractiveAppManagerService.m8913$$Nest$msendAdSessionTokenToClientLocked(this.this$0, client, serviceId, null, null, seq);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L20:
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L15
            TvAdServiceState adState = (TvAdServiceState) UserState.m8982$$Nest$fgetmAdServiceMap(userState).get(serviceId);     // Catch: Throwable -> L15
            if (adState != null) goto L26;
            Slogf.w(TvInteractiveAppManagerService.TAG, "Failed to find state for serviceId=" + serviceId);     // Catch: Throwable -> L15
            TvInteractiveAppManagerService.m8913$$Nest$msendAdSessionTokenToClientLocked(this.this$0, client, serviceId, null, null, seq);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L26:
            AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(TvAdServiceState.m8970$$Nest$fgetmComponentName(adState));     // Catch: Throwable -> L15
            if (serviceState != null) goto L35;
            int r2 = PackageManager.getApplicationInfoAsUserCached(TvAdServiceState.m8970$$Nest$fgetmComponentName(adState).getPackageName(), 0, resolvedUserId).uid;     // Catch: Throwable -> L15
            AdServiceState serviceState2 = new AdServiceState(this.this$0, TvAdServiceState.m8970$$Nest$fgetmComponentName(adState), serviceId, resolvedUserId, null);     // Catch: Throwable -> L33
            UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).put(TvAdServiceState.m8970$$Nest$fgetmComponentName(adState), serviceState2);     // Catch: Throwable -> L15
            AdServiceState serviceState3 = serviceState2;
        L37:
            if (AdServiceState.m8925$$Nest$fgetmReconnecting(serviceState3) == false) goto L42;
            TvInteractiveAppManagerService.m8913$$Nest$msendAdSessionTokenToClientLocked(this.this$0, client, serviceId, null, null, seq);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L42:
            Binder r4 = new Binder();     // Catch: Throwable -> L15
            AdSessionState sessionState = new AdSessionState(this.this$0, r4, serviceId, type, TvAdServiceState.m8970$$Nest$fgetmComponentName(adState), client, seq, callingUid, callingPid, resolvedUserId, null);     // Catch: Throwable -> L15
            UserState.m8984$$Nest$fgetmAdSessionStateMap(userState).put(r4, sessionState);     // Catch: Throwable -> L15
            AdServiceState.m8927$$Nest$fgetmSessionTokens(serviceState3).add(r4);     // Catch: Throwable -> L15
            if (AdServiceState.m8926$$Nest$fgetmService(serviceState3) != null) goto L45;
            TvInteractiveAppManagerService.m8918$$Nest$mupdateAdServiceConnectionLocked(this.this$0, TvAdServiceState.m8970$$Nest$fgetmComponentName(adState), resolvedUserId);     // Catch: Throwable -> L15
        L48:
            monitor-exit(r17);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return;
        L45:
            if (TvInteractiveAppManagerService.m8895$$Nest$mcreateAdSessionInternalLocked(this.this$0, AdServiceState.m8926$$Nest$fgetmService(serviceState3), r4, resolvedUserId) == true) goto L48;
            TvInteractiveAppManagerService.m8909$$Nest$mremoveAdSessionStateLocked(this.this$0, r4, resolvedUserId);     // Catch: Throwable -> L15
        L33:
            th = th;
            goto L51
        L35:
            serviceState3 = serviceState;
        L53:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void releaseSession(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "releaseSession");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r4);     // Catch: Throwable -> L12
            TvInteractiveAppManagerService.m8908$$Nest$mreleaseSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L9
            monitor-exit(r4);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setSurface(IBinder sessionToken, Surface surface, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setSurface");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r5);     // Catch: Throwable -> L18
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).setSurface(surface);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            if (surface == null) goto L14;
            surface.release();
        L14:
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in setSurface", e);     // Catch: Throwable -> L7
        L18:
            th = move-exception;
            if (surface == null) goto L21;
            surface.release();
        L21:
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void dispatchSurfaceChanged(IBinder sessionToken, int format, int width, int height, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "dispatchSurfaceChanged");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).dispatchSurfaceChanged(format, width, height);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in dispatchSurfaceChanged", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void startAdService(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "startAdService");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).startAdService();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in start", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void stopAdService(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "stopAdService");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).stopAdService();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in stop", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void resetAdService(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "resetAdService");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).resetAdService();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in reset", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentVideoBounds(IBinder sessionToken, Rect bounds, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentVideoBounds");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).sendCurrentVideoBounds(bounds);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentVideoBounds", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentChannelUri(IBinder sessionToken, Uri channelUri, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentChannelUri");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).sendCurrentChannelUri(channelUri);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentChannelUri", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendTrackInfoList(IBinder sessionToken, List<TvTrackInfo> tracks, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendTrackInfoList");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).sendTrackInfoList(tracks);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendTrackInfoList", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendCurrentTvInputId(IBinder sessionToken, String inputId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendCurrentTvInputId");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).sendCurrentTvInputId(inputId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendCurrentTvInputId", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendSigningResult(IBinder sessionToken, String signingId, byte[] result, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendSigningResult");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).sendSigningResult(signingId, result);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in sendSigningResult", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyError(IBinder sessionToken, String errMsg, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyError");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).notifyError(errMsg, params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyError", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTvMessage(IBinder sessionToken, int type, Bundle data, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyTvMessage");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).notifyTvMessage(type, data);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTvMessage", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTvInputSessionData(IBinder sessionToken, String type, Bundle data, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyTvInputSessionData");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            AdSessionState sessionState = TvInteractiveAppManagerService.m8899$$Nest$mgetAdSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInteractiveAppManagerService.m8898$$Nest$mgetAdSessionLocked(this.this$0, sessionState).notifyTvInputSessionData(type, data);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slogf.e(TvInteractiveAppManagerService.TAG, "error in notifyTvInputSessionData", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void registerCallback(ITvAdManagerCallback callback, int userId) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "registerCallback");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r5);     // Catch: Throwable -> L15
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            if (UserState.m8981$$Nest$fgetmAdCallbacks(userState).register(callback) == true) goto L10;
            Slog.e(TvInteractiveAppManagerService.TAG, "client process has already died");     // Catch: Throwable -> L8
        L10:
            monitor-exit(r5);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unregisterCallback(ITvAdManagerCallback callback, int userId) {
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "unregisterCallback");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInteractiveAppManagerService.m8900$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            UserState.m8981$$Nest$fgetmAdCallbacks(userState).unregister(callback);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void createMediaView(IBinder sessionToken, IBinder windowToken, Rect frame, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "createMediaView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInteractiveAppManagerService.m8897$$Nest$mgetAdSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).createMediaView(windowToken, frame);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in createMediaView", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void relayoutMediaView(IBinder sessionToken, Rect frame, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "relayoutMediaView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInteractiveAppManagerService.m8897$$Nest$mgetAdSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).relayoutMediaView(frame);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in relayoutMediaView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removeMediaView(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInteractiveAppManagerService.m8912$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "removeMediaView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInteractiveAppManagerService.m8883$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInteractiveAppManagerService.m8897$$Nest$mgetAdSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).removeMediaView();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInteractiveAppManagerService.TAG, "error in removeMediaView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static final class TvAdServiceState {
        private int mAdNumber;
        private String mAdServiceId;
        private ComponentName mComponentName;
        private TvAdServiceInfo mInfo;
        private int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8970$$Nest$fgetmComponentName(TvAdServiceState r0) {
            return r0.mComponentName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ TvAdServiceInfo m8971$$Nest$fgetmInfo(TvAdServiceState r0) {
            return r0.mInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmComponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8972$$Nest$fputmComponentName(TvAdServiceState r0, ComponentName r1) {
            r0.mComponentName = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8973$$Nest$fputmInfo(TvAdServiceState r0, TvAdServiceInfo r1) {
            r0.mInfo = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8974$$Nest$fputmUid(TvAdServiceState r0, int r1) {
            r0.mUid = r1;
        }

        /* synthetic */ TvAdServiceState(TvInteractiveAppManagerServiceIA r1) {
            this();
        }

        private TvAdServiceState() {
        }
    }

    private static final class TvInteractiveAppState {
        private ComponentName mComponentName;
        private int mIAppNumber;
        private String mIAppServiceId;
        private TvInteractiveAppServiceInfo mInfo;
        private int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8975$$Nest$fgetmComponentName(TvInteractiveAppState r0) {
            return r0.mComponentName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ TvInteractiveAppServiceInfo m8976$$Nest$fgetmInfo(TvInteractiveAppState r0) {
            return r0.mInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmComponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8977$$Nest$fputmComponentName(TvInteractiveAppState r0, ComponentName r1) {
            r0.mComponentName = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIAppNumber, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8978$$Nest$fputmIAppNumber(TvInteractiveAppState r0, int r1) {
            r0.mIAppNumber = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8979$$Nest$fputmInfo(TvInteractiveAppState r0, TvInteractiveAppServiceInfo r1) {
            r0.mInfo = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8980$$Nest$fputmUid(TvInteractiveAppState r0, int r1) {
            r0.mUid = r1;
        }

        /* synthetic */ TvInteractiveAppState(TvInteractiveAppManagerServiceIA r1) {
            this();
        }

        private TvInteractiveAppState() {
        }
    }

    private static final class UserState {
        private final RemoteCallbackList<ITvAdManagerCallback> mAdCallbacks;
        private Map<String, TvAdServiceState> mAdServiceMap;
        private final Map<ComponentName, AdServiceState> mAdServiceStateMap;
        private final Map<IBinder, AdSessionState> mAdSessionStateMap;
        private final List<AppLinkInfo> mAppLinkInfoList;
        private final RemoteCallbackList<ITvInteractiveAppManagerCallback> mCallbacks;
        private final Map<IBinder, ClientState> mClientStateMap;
        private Map<String, TvInteractiveAppState> mIAppMap;
        private final Set<String> mPackageSet;
        private final Map<ComponentName, ServiceState> mServiceStateMap;
        private final Map<IBinder, SessionState> mSessionStateMap;
        private final int mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmAdCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ RemoteCallbackList m8981$$Nest$fgetmAdCallbacks(UserState r0) {
            return r0.mAdCallbacks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAdServiceMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8982$$Nest$fgetmAdServiceMap(UserState r0) {
            return r0.mAdServiceMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAdServiceStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8983$$Nest$fgetmAdServiceStateMap(UserState r0) {
            return r0.mAdServiceStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAdSessionStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8984$$Nest$fgetmAdSessionStateMap(UserState r0) {
            return r0.mAdSessionStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAppLinkInfoList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8985$$Nest$fgetmAppLinkInfoList(UserState r0) {
            return r0.mAppLinkInfoList;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ RemoteCallbackList m8986$$Nest$fgetmCallbacks(UserState r0) {
            return r0.mCallbacks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClientStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8987$$Nest$fgetmClientStateMap(UserState r0) {
            return r0.mClientStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIAppMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8988$$Nest$fgetmIAppMap(UserState r0) {
            return r0.mIAppMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageSet, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m8989$$Nest$fgetmPackageSet(UserState r0) {
            return r0.mPackageSet;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmServiceStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8990$$Nest$fgetmServiceStateMap(UserState r0) {
            return r0.mServiceStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8991$$Nest$fgetmSessionStateMap(UserState r0) {
            return r0.mSessionStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAdServiceMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8992$$Nest$fputmAdServiceMap(UserState r0, Map r1) {
            r0.mAdServiceMap = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIAppMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8993$$Nest$fputmIAppMap(UserState r0, Map r1) {
            r0.mIAppMap = r1;
        }

        /* synthetic */ UserState(int r1, TvInteractiveAppManagerServiceIA r2) {
            this(r1);
        }

        private UserState(int userId) {
            this.mAdServiceStateMap = new HashMap();
            this.mAdSessionStateMap = new HashMap();
            this.mIAppMap = new HashMap();
            this.mAdServiceMap = new HashMap();
            this.mClientStateMap = new HashMap();
            this.mServiceStateMap = new HashMap();
            this.mSessionStateMap = new HashMap();
            this.mPackageSet = new HashSet();
            this.mAppLinkInfoList = new ArrayList();
            this.mAdCallbacks = new RemoteCallbackList();
            this.mCallbacks = new RemoteCallbackList();
            this.mUserId = userId;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8878$$Nest$fgetmContext(TvInteractiveAppManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8879$$Nest$fgetmCurrentUserId(TvInteractiveAppManagerService r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGetAdServiceListCalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8880$$Nest$fgetmGetAdServiceListCalled(TvInteractiveAppManagerService r0) {
        return r0.mGetAdServiceListCalled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGetAppLinkInfoListCalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8881$$Nest$fgetmGetAppLinkInfoListCalled(TvInteractiveAppManagerService r0) {
        return r0.mGetAppLinkInfoListCalled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGetServiceListCalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8882$$Nest$fgetmGetServiceListCalled(TvInteractiveAppManagerService r0) {
        return r0.mGetServiceListCalled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8883$$Nest$fgetmLock(TvInteractiveAppManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunningProfiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8884$$Nest$fgetmRunningProfiles(TvInteractiveAppManagerService r0) {
        return r0.mRunningProfiles;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmGetAdServiceListCalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8885$$Nest$fputmGetAdServiceListCalled(TvInteractiveAppManagerService r0, boolean r1) {
        r0.mGetAdServiceListCalled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmGetAppLinkInfoListCalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8886$$Nest$fputmGetAppLinkInfoListCalled(TvInteractiveAppManagerService r0, boolean r1) {
        r0.mGetAppLinkInfoListCalled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmGetServiceListCalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8887$$Nest$fputmGetServiceListCalled(TvInteractiveAppManagerService r0, boolean r1) {
        r0.mGetServiceListCalled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mabortPendingCreateAdSessionRequestsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8888$$Nest$mabortPendingCreateAdSessionRequestsLocked(TvInteractiveAppManagerService r0, AdServiceState r1, String r2, int r3) {
        r0.abortPendingCreateAdSessionRequestsLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mabortPendingCreateSessionRequestsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8889$$Nest$mabortPendingCreateSessionRequestsLocked(TvInteractiveAppManagerService r0, ServiceState r1, String r2, int r3) {
        r0.abortPendingCreateSessionRequestsLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildAppLinkInfoLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8890$$Nest$mbuildAppLinkInfoLocked(TvInteractiveAppManagerService r0, int r1) {
        r0.buildAppLinkInfoLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildTvAdServiceListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8891$$Nest$mbuildTvAdServiceListLocked(TvInteractiveAppManagerService r0, int r1, String[] r2) {
        r0.buildTvAdServiceListLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildTvInteractiveAppServiceListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8892$$Nest$mbuildTvInteractiveAppServiceListLocked(TvInteractiveAppManagerService r0, int r1, String[] r2) {
        r0.buildTvInteractiveAppServiceListLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAdSessionAndNotifyClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8893$$Nest$mclearAdSessionAndNotifyClientLocked(TvInteractiveAppManagerService r0, AdSessionState r1) {
        r0.clearAdSessionAndNotifyClientLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearSessionAndNotifyClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8894$$Nest$mclearSessionAndNotifyClientLocked(TvInteractiveAppManagerService r0, SessionState r1) {
        r0.clearSessionAndNotifyClientLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateAdSessionInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8895$$Nest$mcreateAdSessionInternalLocked(TvInteractiveAppManagerService r0, ITvAdService r1, IBinder r2, int r3) {
        return r0.createAdSessionInternalLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateSessionInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8896$$Nest$mcreateSessionInternalLocked(TvInteractiveAppManagerService r0, ITvInteractiveAppService r1, IBinder r2, int r3) {
        return r0.createSessionInternalLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAdSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITvAdSession m8897$$Nest$mgetAdSessionLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2, int r3) {
        return r0.getAdSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAdSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITvAdSession m8898$$Nest$mgetAdSessionLocked(TvInteractiveAppManagerService r0, AdSessionState r1) {
        return r0.getAdSessionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAdSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdSessionState m8899$$Nest$mgetAdSessionStateLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2, int r3) {
        return r0.getAdSessionStateLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetOrCreateUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserState m8900$$Nest$mgetOrCreateUserStateLocked(TvInteractiveAppManagerService r0, int r1) {
        return r0.getOrCreateUserStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetServiceStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceState m8901$$Nest$mgetServiceStateLocked(TvInteractiveAppManagerService r0, ComponentName r1, int r2) {
        return r0.getServiceStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITvInteractiveAppSession m8902$$Nest$mgetSessionLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2, int r3) {
        return r0.getSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITvInteractiveAppSession m8903$$Nest$mgetSessionLocked(TvInteractiveAppManagerService r0, SessionState r1) {
        return r0.getSessionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionState m8904$$Nest$mgetSessionStateLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2, int r3) {
        return r0.getSessionStateLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserState m8905$$Nest$mgetUserStateLocked(TvInteractiveAppManagerService r0, int r1) {
        return r0.getUserStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8906$$Nest$mnotifyStateChangedLocked(TvInteractiveAppManagerService r0, UserState r1, String r2, int r3, int r4, int r5) {
        r0.notifyStateChangedLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseAdSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdSessionState m8907$$Nest$mreleaseAdSessionLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2, int r3) {
        return r0.releaseAdSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionState m8908$$Nest$mreleaseSessionLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2, int r3) {
        return r0.releaseSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAdSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8909$$Nest$mremoveAdSessionStateLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2) {
        r0.removeAdSessionStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8910$$Nest$mremoveSessionStateLocked(TvInteractiveAppManagerService r0, IBinder r1, int r2) {
        r0.removeSessionStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8911$$Nest$mremoveUser(TvInteractiveAppManagerService r0, int r1) {
        r0.removeUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolveCallingUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8912$$Nest$mresolveCallingUserId(TvInteractiveAppManagerService r0, int r1, int r2, int r3, String r4) {
        return r0.resolveCallingUserId(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msendAdSessionTokenToClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8913$$Nest$msendAdSessionTokenToClientLocked(TvInteractiveAppManagerService r0, ITvAdClient r1, String r2, IBinder r3, InputChannel r4, int r5) {
        r0.sendAdSessionTokenToClientLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$msendSessionTokenToClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8914$$Nest$msendSessionTokenToClientLocked(TvInteractiveAppManagerService r0, ITvInteractiveAppClient r1, String r2, IBinder r3, InputChannel r4, int r5) {
        r0.sendSessionTokenToClientLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8915$$Nest$mstartUser(TvInteractiveAppManagerService r0, int r1) {
        r0.startUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8916$$Nest$mstopUser(TvInteractiveAppManagerService r0, int r1) {
        r0.stopUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8917$$Nest$mswitchUser(TvInteractiveAppManagerService r0, int r1) {
        r0.switchUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAdServiceConnectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8918$$Nest$mupdateAdServiceConnectionLocked(TvInteractiveAppManagerService r0, ComponentName r1, int r2) {
        r0.updateAdServiceConnectionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateServiceConnectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8919$$Nest$mupdateServiceConnectionLocked(TvInteractiveAppManagerService r0, ComponentName r1, int r2) {
        r0.updateServiceConnectionLocked(r1, r2);
    }

    public TvInteractiveAppManagerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mCurrentUserId = 0;
        this.mRunningProfiles = new HashSet();
        this.mUserStates = new SparseArray();
        this.mGetServiceListCalled = false;
        this.mGetAdServiceListCalled = false;
        this.mGetAppLinkInfoListCalled = false;
        this.mContext = context;
        this.mUserManager = (UserManager) getContext().getSystemService("user");
        this.mPackageMonitor = new MyPackageMonitor(this, true);
    }

    private void buildAppLinkInfoLocked(int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        PackageManager pm = this.mContext.getPackageManager();
        List<ApplicationInfo> appInfos = pm.getInstalledApplicationsAsUser(PackageManager.ApplicationInfoFlags.of(128), userId);
        ArrayList r3 = new ArrayList();
        Iterator<ApplicationInfo> r4 = appInfos.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        ApplicationInfo appInfo = r4.next();
        AppLinkInfo info = buildAppLinkInfoLocked(appInfo);
        if (info == null) goto L4;
        r3.add(info);
        goto L4
    L9:
        Collections.sort(r3, Comparator.comparing(new TvInteractiveAppManagerService$$ExternalSyntheticLambda2()));
        UserState.m8985$$Nest$fgetmAppLinkInfoList(userState).clear();
        UserState.m8985$$Nest$fgetmAppLinkInfoList(userState).addAll(r3);
    }

    private AppLinkInfo buildAppLinkInfoLocked(ApplicationInfo appInfo) {
        if (appInfo.metaData != null) goto L5;
    L14:
        return null;
    L5:
        if (appInfo.packageName == null) goto L14;
        String className = appInfo.metaData.getString(METADATA_CLASS_NAME, null);
        String uri = appInfo.metaData.getString(METADATA_URI, null);
        if (className == null) goto L13;
        if (uri == null) goto L13;
        return new AppLinkInfo(appInfo.packageName, className, uri);
    L13:
        return null;
    }

    private void buildTvInteractiveAppServiceListLocked(int userId, String[] updatedPackages) {
        UserState userState = getOrCreateUserStateLocked(userId);
        UserState.m8989$$Nest$fgetmPackageSet(userState).clear();
        PackageManager pm = this.mContext.getPackageManager();
        List<ResolveInfo> services = pm.queryIntentServicesAsUser(new Intent("android.media.tv.interactive.TvInteractiveAppService"), 132, userId);
        List<TvInteractiveAppServiceInfo> iAppList = new ArrayList();
        Iterator<ResolveInfo> r4 = services.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        ResolveInfo ri = r4.next();
        ServiceInfo si = ri.serviceInfo;
        if ("android.permission.BIND_TV_INTERACTIVE_APP".equals(si.permission) == false) goto L7;
        TvInteractiveAppServiceInfo info = new TvInteractiveAppServiceInfo(this.mContext, new ComponentName(si.packageName, si.name));     // Catch: Exception -> L11
        iAppList.add(info);     // Catch: Exception -> L11
        UserState.m8989$$Nest$fgetmPackageSet(userState).add(si.packageName);
    L11:
        e = move-exception;
        Slogf.e(TAG, "failed to load TV Interactive App service " + si.name, e);
        goto L4
    L7:
        Slog.w(TAG, "Skipping TV interactiva app service " + si.name + ": it does not require the permission android.permission.BIND_TV_INTERACTIVE_APP");
        goto L4
    L13:
        Collections.sort(iAppList, Comparator.comparing(new TvInteractiveAppManagerService$$ExternalSyntheticLambda1()));
        Map<String, TvInteractiveAppState> iAppMap = new HashMap();
        ArrayMap<String, Integer> tiasAppCount = new ArrayMap(iAppMap.size());
        Iterator<TvInteractiveAppServiceInfo> r6 = iAppList.iterator();
    L15:
        if (r6.hasNext() == false) goto L24;
        TvInteractiveAppServiceInfo info2 = r6.next();
        String iAppServiceId = info2.getId();
        Integer count = tiasAppCount.get(iAppServiceId);
        int r10 = 1;
        if (count == null) goto L20;
        r10 = 1 + count.intValue();
    L20:
        Integer count2 = Integer.valueOf(r10);
        tiasAppCount.put(iAppServiceId, count2);
        TvInteractiveAppState iAppState = (TvInteractiveAppState) UserState.m8988$$Nest$fgetmIAppMap(userState).get(iAppServiceId);
        if (iAppState != null) goto L23;
        iAppState = new TvInteractiveAppState(null);
    L23:
        TvInteractiveAppState.m8979$$Nest$fputmInfo(iAppState, info2);
        TvInteractiveAppState.m8980$$Nest$fputmUid(iAppState, getInteractiveAppUid(info2));
        TvInteractiveAppState.m8977$$Nest$fputmComponentName(iAppState, info2.getComponent());
        iAppMap.put(iAppServiceId, iAppState);
        TvInteractiveAppState.m8978$$Nest$fputmIAppNumber(iAppState, count2.intValue());
        goto L15
    L24:
        Iterator<String> r7 = iAppMap.keySet().iterator();
    L26:
        if (r7.hasNext() == false) goto L39;
        String iAppServiceId2 = r7.next();
        if (UserState.m8988$$Nest$fgetmIAppMap(userState).containsKey(iAppServiceId2) == false) goto L29;
        if (updatedPackages == null) goto L26;
        ComponentName component = TvInteractiveAppState.m8976$$Nest$fgetmInfo(iAppMap.get(iAppServiceId2)).getComponent();
        int r9 = updatedPackages.length;
        int r11 = 0;
    L33:
        if (r11 >= r9) goto L26;
        String updatedPackage = updatedPackages[r11];
        if (component.getPackageName().equals(updatedPackage) == true) goto L36;
        r11 = r11 + 1;
        goto L33
    L36:
        updateServiceConnectionLocked(component, userId);
        notifyInteractiveAppServiceUpdatedLocked(userState, iAppServiceId2);
        goto L26
    L29:
        notifyInteractiveAppServiceAddedLocked(userState, iAppServiceId2);
        goto L26
    L39:
        Iterator r8 = UserState.m8988$$Nest$fgetmIAppMap(userState).keySet().iterator();
    L41:
        if (r8.hasNext() == false) goto L49;
        String iAppServiceId3 = (String) r8.next();
        if (iAppMap.containsKey(iAppServiceId3) == true) goto L41;
        ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(TvInteractiveAppState.m8976$$Nest$fgetmInfo((TvInteractiveAppState) UserState.m8988$$Nest$fgetmIAppMap(userState).get(iAppServiceId3)).getComponent());
        if (serviceState == null) goto L47;
        abortPendingCreateSessionRequestsLocked(serviceState, iAppServiceId3, userId);
    L47:
        notifyInteractiveAppServiceRemovedLocked(userState, iAppServiceId3);
        goto L41
    L49:
        UserState.m8988$$Nest$fgetmIAppMap(userState).clear();
        UserState.m8993$$Nest$fputmIAppMap(userState, iAppMap);
    }

    private void buildTvAdServiceListLocked(int userId, String[] updatedPackages) {
        UserState userState = getOrCreateUserStateLocked(userId);
        UserState.m8989$$Nest$fgetmPackageSet(userState).clear();
        PackageManager pm = this.mContext.getPackageManager();
        List<ResolveInfo> services = pm.queryIntentServicesAsUser(new Intent("android.media.tv.ad.TvAdService"), 132, userId);
        List<TvAdServiceInfo> serviceList = new ArrayList();
        Iterator<ResolveInfo> r4 = services.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        ResolveInfo ri = r4.next();
        ServiceInfo si = ri.serviceInfo;
        if ("android.permission.BIND_TV_AD_SERVICE".equals(si.permission) == false) goto L7;
        TvAdServiceInfo info = new TvAdServiceInfo(this.mContext, new ComponentName(si.packageName, si.name));     // Catch: Exception -> L11
        serviceList.add(info);     // Catch: Exception -> L11
        UserState.m8989$$Nest$fgetmPackageSet(userState).add(si.packageName);
    L11:
        e = move-exception;
        Slogf.e(TAG, "failed to load TV AD service " + si.name, e);
        goto L4
    L7:
        Slog.w(TAG, "Skipping TV AD service " + si.name + ": it does not require the permission android.permission.BIND_TV_AD_SERVICE");
        goto L4
    L13:
        Collections.sort(serviceList, Comparator.comparing(new TvInteractiveAppManagerService$$ExternalSyntheticLambda0()));
        Map<String, TvAdServiceState> adServiceMap = new HashMap();
        Iterator<TvAdServiceInfo> r5 = serviceList.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        TvAdServiceInfo info2 = r5.next();
        String serviceId = info2.getId();
        TvAdServiceState adServiceState = (TvAdServiceState) UserState.m8982$$Nest$fgetmAdServiceMap(userState).get(serviceId);
        if (adServiceState != null) goto L19;
        adServiceState = new TvAdServiceState(null);
    L19:
        TvAdServiceState.m8973$$Nest$fputmInfo(adServiceState, info2);
        TvAdServiceState.m8974$$Nest$fputmUid(adServiceState, getAdServiceUid(info2));
        TvAdServiceState.m8972$$Nest$fputmComponentName(adServiceState, info2.getComponent());
        adServiceMap.put(serviceId, adServiceState);
        goto L15
    L20:
        Iterator<String> r6 = adServiceMap.keySet().iterator();
    L22:
        if (r6.hasNext() == false) goto L35;
        String serviceId2 = r6.next();
        if (UserState.m8982$$Nest$fgetmAdServiceMap(userState).containsKey(serviceId2) == false) goto L25;
        if (updatedPackages == null) goto L22;
        ComponentName component = TvAdServiceState.m8971$$Nest$fgetmInfo(adServiceMap.get(serviceId2)).getComponent();
        int r8 = updatedPackages.length;
        int r9 = 0;
    L29:
        if (r9 >= r8) goto L22;
        String updatedPackage = updatedPackages[r9];
        if (component.getPackageName().equals(updatedPackage) == true) goto L32;
        r9 = r9 + 1;
        goto L29
    L32:
        updateAdServiceConnectionLocked(component, userId);
        notifyAdServiceUpdatedLocked(userState, serviceId2);
        goto L22
    L25:
        notifyAdServiceAddedLocked(userState, serviceId2);
        goto L22
    L35:
        Iterator r7 = UserState.m8982$$Nest$fgetmAdServiceMap(userState).keySet().iterator();
    L37:
        if (r7.hasNext() == false) goto L45;
        String serviceId3 = (String) r7.next();
        if (adServiceMap.containsKey(serviceId3) == true) goto L37;
        AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(TvAdServiceState.m8971$$Nest$fgetmInfo((TvAdServiceState) UserState.m8982$$Nest$fgetmAdServiceMap(userState).get(serviceId3)).getComponent());
        if (serviceState == null) goto L43;
        abortPendingCreateAdSessionRequestsLocked(serviceState, serviceId3, userId);
    L43:
        notifyAdServiceRemovedLocked(userState, serviceId3);
        goto L37
    L45:
        UserState.m8982$$Nest$fgetmAdServiceMap(userState).clear();
        UserState.m8992$$Nest$fputmAdServiceMap(userState, adServiceMap);
    }

    private void notifyAdServiceAddedLocked(UserState userState, String serviceId) {
        int n = UserState.m8981$$Nest$fgetmAdCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8981$$Nest$fgetmAdCallbacks(userState).getBroadcastItem(i).onAdServiceAdded(serviceId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report added AD service to callback", e);
        goto L8
    L9:
        UserState.m8981$$Nest$fgetmAdCallbacks(userState).finishBroadcast();
    }

    private void notifyAdServiceRemovedLocked(UserState userState, String serviceId) {
        int n = UserState.m8981$$Nest$fgetmAdCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8981$$Nest$fgetmAdCallbacks(userState).getBroadcastItem(i).onAdServiceRemoved(serviceId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report removed AD service to callback", e);
        goto L8
    L9:
        UserState.m8981$$Nest$fgetmAdCallbacks(userState).finishBroadcast();
    }

    private void notifyAdServiceUpdatedLocked(UserState userState, String serviceId) {
        int n = UserState.m8981$$Nest$fgetmAdCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8981$$Nest$fgetmAdCallbacks(userState).getBroadcastItem(i).onAdServiceUpdated(serviceId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report updated AD service to callback", e);
        goto L8
    L9:
        UserState.m8981$$Nest$fgetmAdCallbacks(userState).finishBroadcast();
    }

    private void notifyInteractiveAppServiceAddedLocked(UserState userState, String iAppServiceId) {
        int n = UserState.m8986$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8986$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInteractiveAppServiceAdded(iAppServiceId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report added Interactive App service to callback", e);
        goto L8
    L9:
        UserState.m8986$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void notifyInteractiveAppServiceRemovedLocked(UserState userState, String iAppServiceId) {
        int n = UserState.m8986$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8986$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInteractiveAppServiceRemoved(iAppServiceId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report removed Interactive App service to callback", e);
        goto L8
    L9:
        UserState.m8986$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void notifyInteractiveAppServiceUpdatedLocked(UserState userState, String iAppServiceId) {
        int n = UserState.m8986$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8986$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInteractiveAppServiceUpdated(iAppServiceId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report updated Interactive App service to callback", e);
        goto L8
    L9:
        UserState.m8986$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void notifyStateChangedLocked(UserState userState, String iAppServiceId, int type, int state, int err) {
        int n = UserState.m8986$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8986$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onStateChanged(iAppServiceId, type, state, err);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report RTE state changed", e);
        goto L8
    L9:
        UserState.m8986$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private int getInteractiveAppUid(TvInteractiveAppServiceInfo info) {
        return getContext().getPackageManager().getApplicationInfo(info.getServiceInfo().packageName, 0).uid;
    L4:
        e = move-exception;
        Slogf.w(TAG, "Unable to get UID for  " + info, e);
        return -1;
    }

    private int getAdServiceUid(TvAdServiceInfo info) {
        return getContext().getPackageManager().getApplicationInfo(info.getServiceInfo().packageName, 0).uid;
    L4:
        e = move-exception;
        Slogf.w(TAG, "Unable to get UID for  " + info, e);
        return -1;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        TvInteractiveAppManagerServiceIA r1 = null;
        publishBinderService("tv_interactive_app", new BinderService(this, r1));
        publishBinderService("tv_ad", new TvAdBinderService(this, r1));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        registerBroadcastReceivers();
        return;
    L6:
        if (phase != 600) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
        buildTvInteractiveAppServiceListLocked(this.mCurrentUserId, null);     // Catch: Throwable -> L12
        buildAppLinkInfoLocked(this.mCurrentUserId);     // Catch: Throwable -> L12
        buildTvAdServiceListLocked(this.mCurrentUserId, null);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void registerBroadcastReceivers() {
        this.mPackageMonitor.register(this.mContext, null, UserHandle.ALL, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_SWITCHED");
        intentFilter.addAction("android.intent.action.USER_REMOVED");
        intentFilter.addAction("android.intent.action.USER_STARTED");
        intentFilter.addAction("android.intent.action.USER_STOPPED");
        this.mContext.registerReceiverAsUser(new AnonymousClass1(this), UserHandle.ALL, intentFilter, null, null);
    }

    private void switchUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId != userId) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L8
        if (userInfo.isProfile() == false) goto L15;
        Slog.w(TAG, "cannot switch to a profile!");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        Iterator<Integer> r2 = this.mRunningProfiles.iterator();     // Catch: Throwable -> L8
    L17:
        if (r2.hasNext() == false) goto L19;
        int runningId = r2.next().intValue();     // Catch: Throwable -> L8
        releaseSessionOfUserLocked(runningId);     // Catch: Throwable -> L8
        unbindServiceOfUserLocked(runningId);     // Catch: Throwable -> L8
        goto L17
    L19:
        this.mRunningProfiles.clear();     // Catch: Throwable -> L8
        releaseSessionOfUserLocked(this.mCurrentUserId);     // Catch: Throwable -> L8
        unbindServiceOfUserLocked(this.mCurrentUserId);     // Catch: Throwable -> L8
        this.mCurrentUserId = userId;     // Catch: Throwable -> L8
        buildTvInteractiveAppServiceListLocked(userId, null);     // Catch: Throwable -> L8
        buildAppLinkInfoLocked(userId);     // Catch: Throwable -> L8
        buildTvAdServiceListLocked(userId, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void removeUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L8
        if (userState != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator r2 = UserState.m8991$$Nest$fgetmSessionStateMap(userState).values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L20;
        SessionState state = (SessionState) r2.next();     // Catch: Throwable -> L8
        if (SessionState.m8965$$Nest$fgetmSession(state) == null) goto L12;
        SessionState.m8965$$Nest$fgetmSession(state).release();     // Catch: Throwable -> L8 RemoteException -> L17
    L17:
        e = move-exception;
        Slog.e(TAG, "error in release", e);     // Catch: Throwable -> L8
        goto L12
    L20:
        UserState.m8991$$Nest$fgetmSessionStateMap(userState).clear();     // Catch: Throwable -> L8
        Iterator r3 = UserState.m8990$$Nest$fgetmServiceStateMap(userState).values().iterator();     // Catch: Throwable -> L8
    L22:
        if (r3.hasNext() == false) goto L33;
        ServiceState serviceState = (ServiceState) r3.next();     // Catch: Throwable -> L8
        if (ServiceState.m8952$$Nest$fgetmService(serviceState) == null) goto L22;
        if (ServiceState.m8945$$Nest$fgetmCallback(serviceState) != null) goto L41;
    L31:
        this.mContext.unbindService(ServiceState.m8947$$Nest$fgetmConnection(serviceState));     // Catch: Throwable -> L8
        goto L22
    L41:
        ServiceState.m8952$$Nest$fgetmService(serviceState).unregisterCallback(ServiceState.m8945$$Nest$fgetmCallback(serviceState));     // Catch: Throwable -> L8 RemoteException -> L29
    L29:
        e = move-exception;
        Slog.e(TAG, "error in unregisterCallback", e);     // Catch: Throwable -> L8
        goto L31
    L33:
        UserState.m8990$$Nest$fgetmServiceStateMap(userState).clear();     // Catch: Throwable -> L8
        UserState.m8988$$Nest$fgetmIAppMap(userState).clear();     // Catch: Throwable -> L8
        UserState.m8989$$Nest$fgetmPackageSet(userState).clear();     // Catch: Throwable -> L8
        UserState.m8987$$Nest$fgetmClientStateMap(userState).clear();     // Catch: Throwable -> L8
        UserState.m8986$$Nest$fgetmCallbacks(userState).kill();     // Catch: Throwable -> L8
        this.mRunningProfiles.remove(Integer.valueOf(userId));     // Catch: Throwable -> L8
        this.mUserStates.remove(userId);     // Catch: Throwable -> L8
        if (userId != this.mCurrentUserId) goto L36;
        switchUser(0);     // Catch: Throwable -> L8
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void startUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (userId == this.mCurrentUserId) goto L19;
        if (this.mRunningProfiles.contains(Integer.valueOf(userId)) == true) goto L19;
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L15
        UserInfo parentInfo = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L15
        if (userInfo.isProfile() == false) goto L17;
        if (parentInfo == null) goto L17;
        if (parentInfo.id != this.mCurrentUserId) goto L17;
        startProfileLocked(userId);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    private void stopUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (userId != this.mCurrentUserId) goto L11;
        switchUser(ActivityManager.getCurrentUser());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        releaseSessionOfUserLocked(userId);     // Catch: Throwable -> L9
        unbindServiceOfUserLocked(userId);     // Catch: Throwable -> L9
        this.mRunningProfiles.remove(Integer.valueOf(userId));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void startProfileLocked(int userId) {
        this.mRunningProfiles.add(Integer.valueOf(userId));
        buildTvInteractiveAppServiceListLocked(userId, null);
        buildAppLinkInfoLocked(userId);
        buildTvAdServiceListLocked(userId, null);
    }

    private void releaseSessionOfUserLocked(int userId) {
        UserState userState = getUserStateLocked(userId);
        if (userState != null) goto L5;
        return;
    L5:
        List<SessionState> sessionStatesToRelease = new ArrayList();
        Iterator r2 = UserState.m8991$$Nest$fgetmSessionStateMap(userState).values().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        SessionState sessionState = (SessionState) r2.next();
        if (SessionState.m8965$$Nest$fgetmSession(sessionState) == null) goto L7;
        sessionStatesToRelease.add(sessionState);
        goto L7
    L12:
        Iterator<SessionState> r3 = sessionStatesToRelease.iterator();
    L14:
        if (r3.hasNext() == false) goto L21;
        SessionState sessionState2 = r3.next();
        SessionState.m8965$$Nest$fgetmSession(sessionState2).release();     // Catch: RemoteException -> L18
    L20:
        clearSessionAndNotifyClientLocked(sessionState2);
    L18:
        e = move-exception;
        Slog.e(TAG, "error in release", e);
        goto L20
    }

    private void unbindServiceOfUserLocked(int userId) {
        UserState userState = getUserStateLocked(userId);
        if (userState != null) goto L5;
        return;
    L5:
        Iterator<ComponentName> it = UserState.m8990$$Nest$fgetmServiceStateMap(userState).keySet().iterator();
    L7:
        if (it.hasNext() == false) goto L21;
        ComponentName component = it.next();
        ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(component);
        if (serviceState == null) goto L7;
        if (ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState).isEmpty() == false) goto L7;
        if (ServiceState.m8945$$Nest$fgetmCallback(serviceState) != null) goto L22;
    L18:
        this.mContext.unbindService(ServiceState.m8947$$Nest$fgetmConnection(serviceState));
        it.remove();
        goto L7
    L22:
        ServiceState.m8952$$Nest$fgetmService(serviceState).unregisterCallback(ServiceState.m8945$$Nest$fgetmCallback(serviceState));     // Catch: RemoteException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "error in unregisterCallback", e);
        goto L18
    }

    private void clearSessionAndNotifyClientLocked(SessionState state) {
        if (SessionState.m8961$$Nest$fgetmClient(state) != null) goto L10;
    L8:
        removeAdSessionStateLocked(SessionState.m8966$$Nest$fgetmSessionToken(state), SessionState.m8968$$Nest$fgetmUserId(state));
        return;
    L10:
        SessionState.m8961$$Nest$fgetmClient(state).onSessionReleased(SessionState.m8964$$Nest$fgetmSeq(state));     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "error in onSessionReleased", e);
        goto L8
    }

    private void clearAdSessionAndNotifyClientLocked(AdSessionState state) {
        if (AdSessionState.m8935$$Nest$fgetmClient(state) != null) goto L10;
    L8:
        removeAdSessionStateLocked(AdSessionState.m8939$$Nest$fgetmSessionToken(state), AdSessionState.m8941$$Nest$fgetmUserId(state));
        return;
    L10:
        AdSessionState.m8935$$Nest$fgetmClient(state).onSessionReleased(AdSessionState.m8937$$Nest$fgetmSeq(state));     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "error in onSessionReleased", e);
        goto L8
    }

    private int resolveCallingUserId(int callingPid, int callingUid, int requestedUserId, String methodName) {
        return ActivityManager.handleIncomingUser(callingPid, callingUid, requestedUserId, false, false, methodName, null);
    }

    private UserState getOrCreateUserStateLocked(int userId) {
        UserState userState = getUserStateLocked(userId);
        if (userState != null) goto L6;
        UserState userState2 = new UserState(userId, null);
        this.mUserStates.put(userId, userState2);
        return userState2;
    L6:
        return userState;
    }

    private UserState getUserStateLocked(int userId) {
        return this.mUserStates.get(userId);
    }

    private ServiceState getServiceStateLocked(ComponentName component, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(component);
        if (serviceState == null) goto L6;
        return serviceState;
    L6:
        throw new IllegalStateException("Service state not found for " + component + " (userId=" + userId + ")");
    }

    private AdSessionState getAdSessionStateLocked(IBinder sessionToken, int callingUid, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        return getAdSessionStateLocked(sessionToken, callingUid, userState);
    }

    private AdSessionState getAdSessionStateLocked(IBinder sessionToken, int callingUid, UserState userState) {
        AdSessionState sessionState = (AdSessionState) UserState.m8984$$Nest$fgetmAdSessionStateMap(userState).get(sessionToken);
        if (sessionState == null) goto L13;
        if (callingUid != 1000) goto L7;
    L11:
        return sessionState;
    L7:
        if (callingUid == AdSessionState.m8934$$Nest$fgetmCallingUid(sessionState)) goto L11;
        throw new SecurityException("Illegal access to the session with token " + sessionToken + " from uid " + callingUid);
    L13:
        throw new SessionNotFoundException("Session state not found for token " + sessionToken);
    }

    private ITvAdSession getAdSessionLocked(IBinder sessionToken, int callingUid, int userId) {
        return getAdSessionLocked(getAdSessionStateLocked(sessionToken, callingUid, userId));
    }

    private ITvAdSession getAdSessionLocked(AdSessionState sessionState) {
        ITvAdSession session = AdSessionState.m8938$$Nest$fgetmSession(sessionState);
        if (session == null) goto L6;
        return session;
    L6:
        throw new IllegalStateException("Session not yet created for token " + AdSessionState.m8939$$Nest$fgetmSessionToken(sessionState));
    }

    private SessionState getSessionStateLocked(IBinder sessionToken, int callingUid, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        return getSessionStateLocked(sessionToken, callingUid, userState);
    }

    private SessionState getSessionStateLocked(IBinder sessionToken, int callingUid, UserState userState) {
        SessionState sessionState = (SessionState) UserState.m8991$$Nest$fgetmSessionStateMap(userState).get(sessionToken);
        if (sessionState == null) goto L13;
        if (callingUid != 1000) goto L7;
    L11:
        return sessionState;
    L7:
        if (callingUid == SessionState.m8960$$Nest$fgetmCallingUid(sessionState)) goto L11;
        throw new SecurityException("Illegal access to the session with token " + sessionToken + " from uid " + callingUid);
    L13:
        throw new SessionNotFoundException("Session state not found for token " + sessionToken);
    }

    private ITvInteractiveAppSession getSessionLocked(IBinder sessionToken, int callingUid, int userId) {
        return getSessionLocked(getSessionStateLocked(sessionToken, callingUid, userId));
    }

    private ITvInteractiveAppSession getSessionLocked(SessionState sessionState) {
        ITvInteractiveAppSession session = SessionState.m8965$$Nest$fgetmSession(sessionState);
        if (session == null) goto L6;
        return session;
    L6:
        throw new IllegalStateException("Session not yet created for token " + SessionState.m8966$$Nest$fgetmSessionToken(sessionState));
    }

    private void sendSessionTokenToClientLocked(ITvInteractiveAppClient client, String iAppServiceId, IBinder sessionToken, InputChannel channel, int seq) {
        client.onSessionCreated(iAppServiceId, sessionToken, channel, seq);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slogf.e(TAG, "error in onSessionCreated", e);
    }

    private void sendAdSessionTokenToClientLocked(ITvAdClient client, String serviceId, IBinder sessionToken, InputChannel channel, int seq) {
        client.onSessionCreated(serviceId, sessionToken, channel, seq);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slogf.e(TAG, "error in onSessionCreated", e);
    }

    private boolean createSessionInternalLocked(ITvInteractiveAppService service, IBinder sessionToken, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        SessionState sessionState = (SessionState) UserState.m8991$$Nest$fgetmSessionStateMap(userState).get(sessionToken);
        InputChannel[] channels = InputChannel.openInputChannelPair(sessionToken.toString());
        SessionCallback r0 = new SessionCallback(this, sessionState, channels);
        boolean created = true;
        service.createSession(channels[1], r0, SessionState.m8963$$Nest$fgetmIAppServiceId(sessionState), SessionState.m8967$$Nest$fgetmType(sessionState));     // Catch: RemoteException -> L7
    L12:
        channels[1].dispose();
        return created;
    L7:
        e = e;
    L11:
        Slogf.e(TAG, "error in createSession", e);
        sendSessionTokenToClientLocked(SessionState.m8961$$Nest$fgetmClient(sessionState), SessionState.m8963$$Nest$fgetmIAppServiceId(sessionState), null, null, SessionState.m8964$$Nest$fgetmSeq(sessionState));
        created = false;
    L9:
        e = e;
        goto L11
    }

    private boolean createAdSessionInternalLocked(ITvAdService service, IBinder sessionToken, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        AdSessionState sessionState = (AdSessionState) UserState.m8984$$Nest$fgetmAdSessionStateMap(userState).get(sessionToken);
        InputChannel[] channels = InputChannel.openInputChannelPair(sessionToken.toString());
        AdSessionCallback r0 = new AdSessionCallback(this, sessionState, channels);
        boolean created = true;
        service.createSession(channels[1], r0, AdSessionState.m8933$$Nest$fgetmAdServiceId(sessionState), AdSessionState.m8940$$Nest$fgetmType(sessionState));     // Catch: RemoteException -> L7
    L12:
        channels[1].dispose();
        return created;
    L7:
        e = e;
    L11:
        Slogf.e(TAG, "error in createSession", e);
        sendAdSessionTokenToClientLocked(AdSessionState.m8935$$Nest$fgetmClient(sessionState), AdSessionState.m8933$$Nest$fgetmAdServiceId(sessionState), null, null, AdSessionState.m8937$$Nest$fgetmSeq(sessionState));
        created = false;
    L9:
        e = e;
        goto L11
    }

    private AdSessionState releaseAdSessionLocked(IBinder sessionToken, int callingUid, int userId) {
        AdSessionState sessionState = null;
        sessionState = getAdSessionStateLocked(sessionToken, callingUid, userId);     // Catch: Throwable -> L7 Throwable -> L9
        getOrCreateUserStateLocked(userId);     // Catch: Throwable -> L7 Throwable -> L9
        if (AdSessionState.m8938$$Nest$fgetmSession(sessionState) == null) goto L11;
        AdSessionState.m8938$$Nest$fgetmSession(sessionState).asBinder().unlinkToDeath(sessionState, 0);     // Catch: Throwable -> L7 Throwable -> L9
        AdSessionState.m8938$$Nest$fgetmSession(sessionState).release();     // Catch: Throwable -> L7 Throwable -> L9
    L11:
        if (sessionState == null) goto L17;
    L12:
        AdSessionState.m8942$$Nest$fputmSession(sessionState, null);
    L17:
        removeAdSessionStateLocked(sessionToken, userId);
        return sessionState;
    L9:
        e = move-exception;
        Slogf.e(TAG, "error in releaseSession", e);     // Catch: Throwable -> L7
        if (sessionState == null) goto L17;
    L7:
        th = move-exception;
        if (sessionState == null) goto L21;
        AdSessionState.m8942$$Nest$fputmSession(sessionState, null);
    L21:
        throw th;
    }

    private SessionState releaseSessionLocked(IBinder sessionToken, int callingUid, int userId) {
        SessionState sessionState = null;
        sessionState = getSessionStateLocked(sessionToken, callingUid, userId);     // Catch: Throwable -> L7 Throwable -> L9
        getOrCreateUserStateLocked(userId);     // Catch: Throwable -> L7 Throwable -> L9
        if (SessionState.m8965$$Nest$fgetmSession(sessionState) == null) goto L11;
        SessionState.m8965$$Nest$fgetmSession(sessionState).asBinder().unlinkToDeath(sessionState, 0);     // Catch: Throwable -> L7 Throwable -> L9
        SessionState.m8965$$Nest$fgetmSession(sessionState).release();     // Catch: Throwable -> L7 Throwable -> L9
    L11:
        if (sessionState == null) goto L17;
    L12:
        SessionState.m8969$$Nest$fputmSession(sessionState, null);
    L17:
        removeSessionStateLocked(sessionToken, userId);
        return sessionState;
    L9:
        e = move-exception;
        Slogf.e(TAG, "error in releaseSession", e);     // Catch: Throwable -> L7
        if (sessionState == null) goto L17;
    L7:
        th = move-exception;
        if (sessionState == null) goto L21;
        SessionState.m8969$$Nest$fputmSession(sessionState, null);
    L21:
        throw th;
    }

    private void removeSessionStateLocked(IBinder sessionToken, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        SessionState sessionState = (SessionState) UserState.m8991$$Nest$fgetmSessionStateMap(userState).remove(sessionToken);
        if (sessionState != null) goto L6;
        Slogf.e(TAG, "sessionState null, no more remove session action!");
        return;
    L6:
        ClientState clientState = (ClientState) UserState.m8987$$Nest$fgetmClientStateMap(userState).get(SessionState.m8961$$Nest$fgetmClient(sessionState).asBinder());
        if (clientState == null) goto L11;
        ClientState.m8943$$Nest$fgetmSessionTokens(clientState).remove(sessionToken);
        if (clientState.isEmpty() == false) goto L11;
        UserState.m8987$$Nest$fgetmClientStateMap(userState).remove(SessionState.m8961$$Nest$fgetmClient(sessionState).asBinder());
        SessionState.m8961$$Nest$fgetmClient(sessionState).asBinder().unlinkToDeath(clientState, 0);
    L11:
        ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(SessionState.m8962$$Nest$fgetmComponent(sessionState));
        if (serviceState == null) goto L14;
        ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState).remove(sessionToken);
    L14:
        updateServiceConnectionLocked(SessionState.m8962$$Nest$fgetmComponent(sessionState), userId);
    }

    private void removeAdSessionStateLocked(IBinder sessionToken, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        AdSessionState sessionState = (AdSessionState) UserState.m8984$$Nest$fgetmAdSessionStateMap(userState).remove(sessionToken);
        if (sessionState != null) goto L6;
        Slogf.e(TAG, "sessionState null, no more remove session action!");
        return;
    L6:
        ClientState clientState = (ClientState) UserState.m8987$$Nest$fgetmClientStateMap(userState).get(AdSessionState.m8935$$Nest$fgetmClient(sessionState).asBinder());
        if (clientState == null) goto L11;
        ClientState.m8943$$Nest$fgetmSessionTokens(clientState).remove(sessionToken);
        if (clientState.isEmpty() == false) goto L11;
        UserState.m8987$$Nest$fgetmClientStateMap(userState).remove(AdSessionState.m8935$$Nest$fgetmClient(sessionState).asBinder());
        AdSessionState.m8935$$Nest$fgetmClient(sessionState).asBinder().unlinkToDeath(clientState, 0);
    L11:
        AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(AdSessionState.m8936$$Nest$fgetmComponent(sessionState));
        if (serviceState == null) goto L14;
        AdServiceState.m8927$$Nest$fgetmSessionTokens(serviceState).remove(sessionToken);
    L14:
        updateAdServiceConnectionLocked(AdSessionState.m8936$$Nest$fgetmComponent(sessionState), userId);
    }

    private void abortPendingCreateSessionRequestsLocked(ServiceState serviceState, String iAppServiceId, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        List<SessionState> sessionsToAbort = new ArrayList();
        Iterator r2 = ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState).iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        IBinder sessionToken = (IBinder) r2.next();
        SessionState sessionState = (SessionState) UserState.m8991$$Nest$fgetmSessionStateMap(userState).get(sessionToken);
        if (SessionState.m8965$$Nest$fgetmSession(sessionState) != null) goto L4;
        if (iAppServiceId == null) goto L10;
        if (SessionState.m8963$$Nest$fgetmIAppServiceId(sessionState).equals(iAppServiceId) == false) goto L4;
    L10:
        sessionsToAbort.add(sessionState);
        goto L4
    L12:
        Iterator<SessionState> r3 = sessionsToAbort.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        SessionState sessionState2 = r3.next();
        removeSessionStateLocked(SessionState.m8966$$Nest$fgetmSessionToken(sessionState2), SessionState.m8968$$Nest$fgetmUserId(sessionState2));
        sendSessionTokenToClientLocked(SessionState.m8961$$Nest$fgetmClient(sessionState2), SessionState.m8963$$Nest$fgetmIAppServiceId(sessionState2), null, null, SessionState.m8964$$Nest$fgetmSeq(sessionState2));
        goto L14
    L16:
        updateServiceConnectionLocked(ServiceState.m8946$$Nest$fgetmComponent(serviceState), userId);
    }

    private void abortPendingCreateAdSessionRequestsLocked(AdServiceState serviceState, String serviceId, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        List<AdSessionState> sessionsToAbort = new ArrayList();
        Iterator r2 = AdServiceState.m8927$$Nest$fgetmSessionTokens(serviceState).iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        IBinder sessionToken = (IBinder) r2.next();
        AdSessionState sessionState = (AdSessionState) UserState.m8984$$Nest$fgetmAdSessionStateMap(userState).get(sessionToken);
        if (AdSessionState.m8938$$Nest$fgetmSession(sessionState) != null) goto L4;
        if (serviceState == null) goto L10;
        if (AdSessionState.m8933$$Nest$fgetmAdServiceId(sessionState).equals(serviceId) == false) goto L4;
    L10:
        sessionsToAbort.add(sessionState);
        goto L4
    L12:
        Iterator<AdSessionState> r3 = sessionsToAbort.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        AdSessionState sessionState2 = r3.next();
        removeAdSessionStateLocked(AdSessionState.m8939$$Nest$fgetmSessionToken(sessionState2), AdSessionState.m8941$$Nest$fgetmUserId(sessionState2));
        sendAdSessionTokenToClientLocked(AdSessionState.m8935$$Nest$fgetmClient(sessionState2), AdSessionState.m8933$$Nest$fgetmAdServiceId(sessionState2), null, null, AdSessionState.m8937$$Nest$fgetmSeq(sessionState2));
        goto L14
    L16:
        updateAdServiceConnectionLocked(AdServiceState.m8922$$Nest$fgetmComponent(serviceState), userId);
    }

    private void updateServiceConnectionLocked(ComponentName component, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        ServiceState serviceState = (ServiceState) UserState.m8990$$Nest$fgetmServiceStateMap(userState).get(component);
        if (serviceState != null) goto L5;
        return;
    L5:
        boolean shouldBind = false;
        if (ServiceState.m8951$$Nest$fgetmReconnecting(serviceState) == false) goto L12;
        if (ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState).isEmpty() == true) goto L10;
        return;
    L10:
        ServiceState.m8956$$Nest$fputmReconnecting(serviceState, false);
    L12:
        if (ServiceState.m8953$$Nest$fgetmSessionTokens(serviceState).isEmpty() == true) goto L14;
    L17:
        shouldBind = true;
    L19:
        if (ServiceState.m8952$$Nest$fgetmService(serviceState) != null) goto L27;
        if (shouldBind == false) goto L27;
        if (ServiceState.m8944$$Nest$fgetmBound(serviceState) == false) goto L24;
        return;
    L24:
        Intent i = new Intent("android.media.tv.interactive.TvInteractiveAppService").setComponent(component);
        ServiceState.m8954$$Nest$fputmBound(serviceState, this.mContext.bindServiceAsUser(i, ServiceState.m8947$$Nest$fgetmConnection(serviceState), 33554433, new UserHandle(userId)));
        return;
    L27:
        if (ServiceState.m8952$$Nest$fgetmService(serviceState) == null) goto L32;
        if (shouldBind == true) goto L33;
        this.mContext.unbindService(ServiceState.m8947$$Nest$fgetmConnection(serviceState));
        UserState.m8990$$Nest$fgetmServiceStateMap(userState).remove(component);
        return;
    L33:
        return;
    L32:
        return;
    L14:
        if (ServiceState.m8950$$Nest$fgetmPendingAppLinkInfo(serviceState).isEmpty() == false) goto L17;
        if (ServiceState.m8949$$Nest$fgetmPendingAppLinkCommand(serviceState).isEmpty() == true) goto L19;
        goto L17
    }

    private void updateAdServiceConnectionLocked(ComponentName component, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        AdServiceState serviceState = (AdServiceState) UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).get(component);
        if (serviceState != null) goto L5;
        return;
    L5:
        boolean shouldBind = false;
        if (AdServiceState.m8925$$Nest$fgetmReconnecting(serviceState) == false) goto L12;
        if (AdServiceState.m8927$$Nest$fgetmSessionTokens(serviceState).isEmpty() == true) goto L10;
        return;
    L10:
        AdServiceState.m8930$$Nest$fputmReconnecting(serviceState, false);
    L12:
        if (AdServiceState.m8927$$Nest$fgetmSessionTokens(serviceState).isEmpty() == true) goto L14;
    L15:
        shouldBind = true;
    L17:
        if (AdServiceState.m8926$$Nest$fgetmService(serviceState) != null) goto L25;
        if (shouldBind == false) goto L25;
        if (AdServiceState.m8920$$Nest$fgetmBound(serviceState) == false) goto L22;
        return;
    L22:
        Intent i = new Intent("android.media.tv.ad.TvAdService").setComponent(component);
        AdServiceState.m8928$$Nest$fputmBound(serviceState, this.mContext.bindServiceAsUser(i, AdServiceState.m8923$$Nest$fgetmConnection(serviceState), 33554433, new UserHandle(userId)));
        return;
    L25:
        if (AdServiceState.m8926$$Nest$fgetmService(serviceState) == null) goto L30;
        if (shouldBind == true) goto L31;
        this.mContext.unbindService(AdServiceState.m8923$$Nest$fgetmConnection(serviceState));
        UserState.m8983$$Nest$fgetmAdServiceStateMap(userState).remove(component);
        return;
    L31:
        return;
    L30:
        return;
    L14:
        if (AdServiceState.m8924$$Nest$fgetmPendingAppLinkCommand(serviceState).isEmpty() == true) goto L17;
        goto L15
    }
}
