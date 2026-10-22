package com.android.server.tv.tunerresourcemanager;

import android.app.ActivityManager;
import android.content.Context;
import android.media.IResourceManagerService;
import android.media.tv.TvInputManager;
import android.media.tv.tunerresourcemanager.CasSessionRequest;
import android.media.tv.tunerresourcemanager.IResourcesReclaimListener;
import android.media.tv.tunerresourcemanager.ITunerResourceManager;
import android.media.tv.tunerresourcemanager.ResourceClientProfile;
import android.media.tv.tunerresourcemanager.TunerCiCamRequest;
import android.media.tv.tunerresourcemanager.TunerDemuxInfo;
import android.media.tv.tunerresourcemanager.TunerDemuxRequest;
import android.media.tv.tunerresourcemanager.TunerDescramblerRequest;
import android.media.tv.tunerresourcemanager.TunerFrontendInfo;
import android.media.tv.tunerresourcemanager.TunerFrontendRequest;
import android.media.tv.tunerresourcemanager.TunerLnbRequest;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class TunerResourceManagerService extends SystemService implements IBinder.DeathRecipient {
    private static final boolean DEBUG = false;
    public static final int INVALID_CLIENT_ID = -1;
    private static final int INVALID_FE_COUNT = -1;
    private static final long INVALID_THREAD_ID = -1;
    private static final int MAX_CLIENT_PRIORITY = 1000;
    private static final long RESOURCE_COUNT_MASK = 16777215;
    private static final long RESOURCE_ID_MASK = -1;
    private static final int RESOURCE_ID_SHIFT = 24;
    private static final long RESOURCE_TYPE_MASK = 255;
    private static final int RESOURCE_TYPE_SHIFT = 56;
    private static final String TAG = "TunerResourceManagerService";
    private static final long TRMS_LOCK_TIMEOUT = 500;
    private ActivityManager mActivityManager;
    private Map<Integer, CasResource> mCasResources;
    private Map<Integer, CiCamResource> mCiCamResources;
    private Map<Integer, ClientProfile> mClientProfiles;
    private Map<Long, DemuxResource> mDemuxResources;
    private SparseIntArray mFrontendExistingNums;
    private SparseIntArray mFrontendExistingNumsBackup;
    private SparseIntArray mFrontendMaxUsableNums;
    private SparseIntArray mFrontendMaxUsableNumsBackup;
    private Map<Long, FrontendResource> mFrontendResources;
    private Map<Long, FrontendResource> mFrontendResourcesBackup;
    private SparseIntArray mFrontendUsedNums;
    private SparseIntArray mFrontendUsedNumsBackup;
    private Map<Integer, ResourcesReclaimListenerRecord> mListeners;
    private Map<Long, LnbResource> mLnbResources;
    private final Object mLock;
    private final ReentrantLock mLockForTRMSLock;
    private IResourceManagerService mMediaResourceManager;
    private int mNextUnusedClientId;
    private UseCasePriorityHints mPriorityCongfig;
    private int mResourceRequestCount;
    private int mTunerApiLockHolder;
    private long mTunerApiLockHolderThreadId;
    private int mTunerApiLockNestedCount;
    private final Condition mTunerApiLockReleasedCV;
    private TvInputManager mTvInputManager;

    private final class BinderService extends ITunerResourceManager.Stub {
        final /* synthetic */ TunerResourceManagerService this$0;

        /* synthetic */ BinderService(TunerResourceManagerService r1, TunerResourceManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(TunerResourceManagerService r1) {
            this.this$0 = r1;
        }

        public void registerClientProfile(ResourceClientProfile profile, IResourcesReclaimListener listener, int[] clientId) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "registerClientProfile");
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "registerClientProfile");
            if (profile == null) goto L23;
            if (clientId == null) goto L21;
            if (listener == null) goto L19;
            if (TunerResourceManagerService.m9020$$Nest$fgetmPriorityCongfig(this.this$0).isDefinedUseCase(profile.useCase) == false) goto L17;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.registerClientProfileInternal(profile, listener, clientId);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L17:
            throw new RemoteException("Use undefined client use case:" + profile.useCase);
        L19:
            throw new RemoteException("IResourcesReclaimListener can't be null!");
        L21:
            throw new RemoteException("clientId can't be null!");
        L23:
            throw new RemoteException("ResourceClientProfile can't be null");
        }

        public void unregisterClientProfile(int clientId) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "unregisterClientProfile");
            this.this$0.unregisterClientProfileInternal(clientId);
        }

        public boolean updateClientPriority(int clientId, int priority, int niceValue) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "updateClientPriority");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.this$0.updateClientPriorityInternal(clientId, priority, niceValue);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean hasUnusedFrontend(int frontendType) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "hasUnusedFrontend");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.this$0.hasUnusedFrontendInternal(frontendType);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setResourceOwnershipRetention(int clientId, boolean enabled) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "setResourceOwnershipRetention");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.getClientProfile(clientId).setResourceOwnershipRetention(enabled);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isLowestPriority(int clientId, int frontendType) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "isLowestPriority");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.checkClientExists(clientId) == false) goto L12;
            boolean r1 = this.this$0.isLowestPriorityInternal(clientId, frontendType);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L12:
            throw new RemoteException("isLowestPriority called from unregistered client: " + clientId);     // Catch: Throwable -> L9
        }

        public void setFrontendInfoList(TunerFrontendInfo[] infos) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "setFrontendInfoList");
            if (infos == null) goto L13;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.setFrontendInfoListInternal(infos);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new RemoteException("TunerFrontendInfo can't be null");
        }

        public void setDemuxInfoList(TunerDemuxInfo[] infos) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "setDemuxInfoList");
            if (infos == null) goto L13;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.setDemuxInfoListInternal(infos);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new RemoteException("TunerDemuxInfo can't be null");
        }

        public void updateCasInfo(int casSystemId, int maxSessionNum) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "updateCasInfo");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.updateCasInfoInternal(casSystemId, maxSessionNum);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setLnbInfoList(long[] lnbHandles) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "setLnbInfoList");
            if (lnbHandles == null) goto L13;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.setLnbInfoListInternal(lnbHandles);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new RemoteException("Lnb handle list can't be null");
        }

        public boolean requestFrontend(TunerFrontendRequest request, long[] frontendHandle) {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "requestFrontend");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "requestFrontend");
            if (frontendHandle != null) goto L7;
            Slog.e(TunerResourceManagerService.TAG, "frontendHandle can't be null");
            return false;
        L7:
            return this.this$0.requestFrontendInternal(request, frontendHandle);
        }

        public boolean setMaxNumberOfFrontends(int frontendType, int maxUsableNum) {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "setMaxNumberOfFrontends");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "setMaxNumberOfFrontends");
            if (maxUsableNum >= 0) goto L6;
            Slog.w(TunerResourceManagerService.TAG, "setMaxNumberOfFrontends failed with maxUsableNum:" + maxUsableNum + " frontendType:" + frontendType);
            return false;
        L6:
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = TunerResourceManagerService.m9030$$Nest$msetMaxNumberOfFrontendsInternal(this.this$0, frontendType, maxUsableNum);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public int getMaxNumberOfFrontends(int frontendType) {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "getMaxNumberOfFrontends");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "getMaxNumberOfFrontends");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = TunerResourceManagerService.m9027$$Nest$mgetMaxNumberOfFrontendsInternal(this.this$0, frontendType);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void shareFrontend(int selfClientId, int targetClientId) throws RemoteException {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "shareFrontend");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "shareFrontend");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.checkClientExists(selfClientId) == false) goto L20;
            if (this.this$0.checkClientExists(targetClientId) == false) goto L18;
            if (this.this$0.getClientProfile(targetClientId).getInUseFrontendHandles().isEmpty() == true) goto L16;
            this.this$0.shareFrontendInternal(selfClientId, targetClientId);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L16:
            throw new RemoteException("Request to share frontend with a client that has no frontend resources. Target client id:" + targetClientId);     // Catch: Throwable -> L13
        L18:
            throw new RemoteException("Request to share frontend with an unregistered client:" + targetClientId);     // Catch: Throwable -> L13
        L20:
            throw new RemoteException("Share frontend request from an unregistered client:" + selfClientId);     // Catch: Throwable -> L13
        }

        public boolean transferOwner(int resourceType, int currentOwnerId, int newOwnerId) {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "transferOwner");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "transferOwner");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.checkClientExists(currentOwnerId) == true) goto L12;
            Slog.e(TunerResourceManagerService.TAG, "currentOwnerId:" + currentOwnerId + " does not exit");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L12:
            if (this.this$0.checkClientExists(newOwnerId) == true) goto L16;
            Slog.e(TunerResourceManagerService.TAG, "newOwnerId:" + newOwnerId + " does not exit");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L16:
            boolean r1 = this.this$0.transferOwnerInternal(resourceType, currentOwnerId, newOwnerId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        }

        public boolean requestDemux(TunerDemuxRequest request, long[] demuxHandle) throws RemoteException {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "requestDemux");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "requestDemux");
            if (demuxHandle == null) goto L7;
            return this.this$0.requestDemuxInternal(request, demuxHandle);
        L7:
            throw new RemoteException("demuxHandle can't be null");
        }

        public boolean requestDescrambler(TunerDescramblerRequest request, long[] descramblerHandle) throws RemoteException {
            TunerResourceManagerService.m9024$$Nest$menforceDescramblerAccessPermission(this.this$0, "requestDescrambler");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "requestDescrambler");
            if (descramblerHandle == null) goto L18;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.checkClientExists(request.clientId) == false) goto L14;
            boolean r1 = this.this$0.requestDescramblerInternal(request, descramblerHandle);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L14:
            throw new RemoteException("Request descrambler from unregistered client:" + request.clientId);     // Catch: Throwable -> L11
        L18:
            throw new RemoteException("descramblerHandle can't be null");
        }

        public boolean requestCasSession(CasSessionRequest request, long[] casSessionHandle) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "requestCasSession");
            if (casSessionHandle == null) goto L7;
            return this.this$0.requestCasSessionInternal(request, casSessionHandle);
        L7:
            throw new RemoteException("casSessionHandle can't be null");
        }

        public boolean requestCiCam(TunerCiCamRequest request, long[] ciCamHandle) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "requestCiCam");
            if (ciCamHandle == null) goto L7;
            return this.this$0.requestCiCamInternal(request, ciCamHandle);
        L7:
            throw new RemoteException("ciCamHandle can't be null");
        }

        public boolean requestLnb(TunerLnbRequest request, long[] lnbHandle) throws RemoteException {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "requestLnb");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "requestLnb");
            if (lnbHandle == null) goto L7;
            return this.this$0.requestLnbInternal(request, lnbHandle);
        L7:
            throw new RemoteException("lnbHandle can't be null");
        }

        public void releaseFrontend(long frontendHandle, int clientId) throws RemoteException {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "releaseFrontend");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseFrontend");
            this.this$0.releaseFrontendInternal(frontendHandle, clientId);
        }

        public void releaseDemux(long demuxHandle, int clientId) throws RemoteException {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "releaseDemux");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseDemux");
            if (TunerResourceManagerService.m9032$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.e(TunerResourceManagerService.TAG, "releaseDemux(demuxHandle=" + demuxHandle + ")");
        L5:
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (TunerResourceManagerService.m9008$$Nest$fgetmDemuxResources(this.this$0).size() != 0) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L14:
            if (this.this$0.checkClientExists(clientId) == false) goto L27;
            DemuxResource demux = this.this$0.getDemuxResource(demuxHandle);     // Catch: Throwable -> L11
            if (demux == null) goto L25;
            if (demux.getOwnerClientId() != clientId) goto L23;
            this.this$0.releaseDemuxInternal(demux);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L23:
            throw new RemoteException("Client is not the current owner of the releasing demux.");     // Catch: Throwable -> L11
        L25:
            throw new RemoteException("Releasing demux does not exist.");     // Catch: Throwable -> L11
        L27:
            throw new RemoteException("Release demux for unregistered client:" + clientId);     // Catch: Throwable -> L11
        }

        public void releaseDescrambler(long descramblerHandle, int clientId) {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "releaseDescrambler");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseDescrambler");
            if (TunerResourceManagerService.m9032$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.d(TunerResourceManagerService.TAG, "releaseDescrambler(descramblerHandle=" + descramblerHandle + ")");
            return;
        }

        public void releaseCasSession(long casSessionHandle, int clientId) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseCasSession");
            if (TunerResourceManagerService.m9031$$Nest$mvalidateResourceHandle(this.this$0, 4, casSessionHandle) == false) goto L26;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.checkClientExists(clientId) == false) goto L22;
            int casSystemId = this.this$0.getClientProfile(clientId).getInUseCasSystemId();     // Catch: Throwable -> L15
            CasResource cas = this.this$0.getCasResource(casSystemId);     // Catch: Throwable -> L15
            if (cas == null) goto L20;
            if (cas.getOwnerClientIds().contains(Integer.valueOf(clientId)) == false) goto L18;
            this.this$0.releaseCasSessionInternal(cas, clientId);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L18:
            throw new RemoteException("Client is not the current owner of the releasing cas.");     // Catch: Throwable -> L15
        L20:
            throw new RemoteException("Releasing cas does not exist.");     // Catch: Throwable -> L15
        L22:
            throw new RemoteException("Release cas from unregistered client:" + clientId);     // Catch: Throwable -> L15
        L26:
            throw new RemoteException("casSessionHandle can't be invalid");
        }

        public void releaseCiCam(long ciCamHandle, int clientId) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseCiCam");
            if (TunerResourceManagerService.m9031$$Nest$mvalidateResourceHandle(this.this$0, 5, ciCamHandle) == false) goto L30;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L17:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.checkClientExists(clientId) == false) goto L26;
            int ciCamId = this.this$0.getClientProfile(clientId).getInUseCiCamId();     // Catch: Throwable -> L17
            if (ciCamId != this.this$0.getResourceIdFromHandle(ciCamHandle)) goto L24;
            CiCamResource ciCam = this.this$0.getCiCamResource(ciCamId);     // Catch: Throwable -> L17
            if (ciCam == null) goto L22;
            if (ciCam.getOwnerClientIds().contains(Integer.valueOf(clientId)) == false) goto L20;
            this.this$0.releaseCiCamInternal(ciCam, clientId);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L20:
            throw new RemoteException("Client is not the current owner of the releasing ciCam.");     // Catch: Throwable -> L17
        L22:
            throw new RemoteException("Releasing ciCam does not exist.");     // Catch: Throwable -> L17
        L24:
            throw new RemoteException("The client " + clientId + " is not the owner of the releasing ciCam.");     // Catch: Throwable -> L17
        L26:
            throw new RemoteException("Release ciCam from unregistered client:" + clientId);     // Catch: Throwable -> L17
        L30:
            throw new RemoteException("ciCamHandle can't be invalid");
        }

        public void releaseLnb(long lnbHandle, int clientId) throws RemoteException {
            TunerResourceManagerService.m9026$$Nest$menforceTunerAccessPermission(this.this$0, "releaseLnb");
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseLnb");
            if (TunerResourceManagerService.m9031$$Nest$mvalidateResourceHandle(this.this$0, 3, lnbHandle) == false) goto L26;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.checkClientExists(clientId) == false) goto L22;
            LnbResource lnb = this.this$0.getLnbResource(lnbHandle);     // Catch: Throwable -> L15
            if (lnb == null) goto L20;
            if (lnb.getOwnerClientId() != clientId) goto L18;
            this.this$0.releaseLnbInternal(lnb);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L18:
            throw new RemoteException("Client is not the current owner of the releasing lnb.");     // Catch: Throwable -> L15
        L20:
            throw new RemoteException("Releasing lnb does not exist.");     // Catch: Throwable -> L15
        L22:
            throw new RemoteException("Release lnb from unregistered client:" + clientId);     // Catch: Throwable -> L15
        L26:
            throw new RemoteException("lnbHandle can't be invalid");
        }

        public boolean isHigherPriority(ResourceClientProfile challengerProfile, ResourceClientProfile holderProfile) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "isHigherPriority");
            if (challengerProfile == null) goto L14;
            if (holderProfile == null) goto L14;
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.this$0.isHigherPriorityInternal(challengerProfile, holderProfile);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new RemoteException("Client profiles can't be null.");
        }

        public void storeResourceMap(int resourceType) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "storeResourceMap");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.storeResourceMapInternal(resourceType);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void clearResourceMap(int resourceType) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "clearResourceMap");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.clearResourceMapInternal(resourceType);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void restoreResourceMap(int resourceType) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "restoreResourceMap");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.restoreResourceMapInternal(resourceType);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean acquireLock(int clientId, long clientThreadId) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "acquireLock");
            return TunerResourceManagerService.m9021$$Nest$macquireLockInternal(this.this$0, clientId, clientThreadId, 500);
        }

        public boolean releaseLock(int clientId) {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "releaseLock");
            return TunerResourceManagerService.m9028$$Nest$mreleaseLockInternal(this.this$0, clientId, 500, false, false);
        }

        protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
            IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
            pw.println("Permission Denial: can't dump!");
            return;
        L6:
            Object r1 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9007$$Nest$fgetmClientProfiles(this.this$0), "ClientProfiles:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9013$$Nest$fgetmFrontendResources(this.this$0), "FrontendResources:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9023$$Nest$mdumpSIA(this.this$0, TunerResourceManagerService.m9009$$Nest$fgetmFrontendExistingNums(this.this$0), "FrontendExistingNums:", ", ", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9023$$Nest$mdumpSIA(this.this$0, TunerResourceManagerService.m9015$$Nest$fgetmFrontendUsedNums(this.this$0), "FrontendUsedNums:", ", ", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9023$$Nest$mdumpSIA(this.this$0, TunerResourceManagerService.m9011$$Nest$fgetmFrontendMaxUsableNums(this.this$0), "FrontendMaxUsableNums:", ", ", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9014$$Nest$fgetmFrontendResourcesBackup(this.this$0), "FrontendResourcesBackUp:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9023$$Nest$mdumpSIA(this.this$0, TunerResourceManagerService.m9010$$Nest$fgetmFrontendExistingNumsBackup(this.this$0), "FrontendExistingNumsBackup:", ", ", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9023$$Nest$mdumpSIA(this.this$0, TunerResourceManagerService.m9016$$Nest$fgetmFrontendUsedNumsBackup(this.this$0), "FrontendUsedNumsBackup:", ", ", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9023$$Nest$mdumpSIA(this.this$0, TunerResourceManagerService.m9012$$Nest$fgetmFrontendMaxUsableNumsBackup(this.this$0), "FrontendUsedNumsBackup:", ", ", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9008$$Nest$fgetmDemuxResources(this.this$0), "DemuxResource:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9018$$Nest$fgetmLnbResources(this.this$0), "LnbResource:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9005$$Nest$fgetmCasResources(this.this$0), "CasResource:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9006$$Nest$fgetmCiCamResources(this.this$0), "CiCamResource:", "\n", pw);     // Catch: Throwable -> L11
            TunerResourceManagerService.m9022$$Nest$mdumpMap(this.this$0, TunerResourceManagerService.m9017$$Nest$fgetmListeners(this.this$0), "Listners:", "\n", pw);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public int getClientPriority(int useCase, int pid) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "getClientPriority");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = this.this$0.getClientPriority(useCase, this.this$0.checkIsForeground(pid));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getConfigPriority(int useCase, boolean isForeground) throws RemoteException {
            TunerResourceManagerService.m9025$$Nest$menforceTrmAccessPermission(this.this$0, "getConfigPriority");
            Object r0 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = this.this$0.getClientPriority(useCase, isForeground);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    protected class ResourcesReclaimListenerRecord implements IBinder.DeathRecipient {
        private final int mClientId;
        private final IResourcesReclaimListener mListener;
        final /* synthetic */ TunerResourceManagerService this$0;

        public ResourcesReclaimListenerRecord(TunerResourceManagerService this$0, IResourcesReclaimListener listener, int clientId) {
            this.this$0 = this$0;
            this.mListener = listener;
            this.mClientId = clientId;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r1 = TunerResourceManagerService.m9019$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L14
            monitor-enter(r1);     // Catch: Throwable -> L14
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L5:
            if (this.this$0.checkClientExists(this.mClientId) == false) goto L9;
            TunerResourceManagerService.m9029$$Nest$mremoveClientProfile(this.this$0, this.mClientId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            TunerResourceManagerService.m9028$$Nest$mreleaseLockInternal(this.this$0, this.mClientId, 500, true, true);
            return;
        L14:
            th = move-exception;
            TunerResourceManagerService.m9028$$Nest$mreleaseLockInternal(this.this$0, this.mClientId, 500, true, true);
            throw th;
        }

        public int getId() {
            return this.mClientId;
        }

        public IResourcesReclaimListener getListener() {
            return this.mListener;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCasResources, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9005$$Nest$fgetmCasResources(TunerResourceManagerService r0) {
        return r0.mCasResources;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCiCamResources, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9006$$Nest$fgetmCiCamResources(TunerResourceManagerService r0) {
        return r0.mCiCamResources;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClientProfiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9007$$Nest$fgetmClientProfiles(TunerResourceManagerService r0) {
        return r0.mClientProfiles;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDemuxResources, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9008$$Nest$fgetmDemuxResources(TunerResourceManagerService r0) {
        return r0.mDemuxResources;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendExistingNums, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9009$$Nest$fgetmFrontendExistingNums(TunerResourceManagerService r0) {
        return r0.mFrontendExistingNums;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendExistingNumsBackup, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9010$$Nest$fgetmFrontendExistingNumsBackup(TunerResourceManagerService r0) {
        return r0.mFrontendExistingNumsBackup;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendMaxUsableNums, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9011$$Nest$fgetmFrontendMaxUsableNums(TunerResourceManagerService r0) {
        return r0.mFrontendMaxUsableNums;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendMaxUsableNumsBackup, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9012$$Nest$fgetmFrontendMaxUsableNumsBackup(TunerResourceManagerService r0) {
        return r0.mFrontendMaxUsableNumsBackup;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendResources, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9013$$Nest$fgetmFrontendResources(TunerResourceManagerService r0) {
        return r0.mFrontendResources;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendResourcesBackup, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9014$$Nest$fgetmFrontendResourcesBackup(TunerResourceManagerService r0) {
        return r0.mFrontendResourcesBackup;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendUsedNums, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9015$$Nest$fgetmFrontendUsedNums(TunerResourceManagerService r0) {
        return r0.mFrontendUsedNums;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrontendUsedNumsBackup, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9016$$Nest$fgetmFrontendUsedNumsBackup(TunerResourceManagerService r0) {
        return r0.mFrontendUsedNumsBackup;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9017$$Nest$fgetmListeners(TunerResourceManagerService r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLnbResources, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9018$$Nest$fgetmLnbResources(TunerResourceManagerService r0) {
        return r0.mLnbResources;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9019$$Nest$fgetmLock(TunerResourceManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPriorityCongfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ UseCasePriorityHints m9020$$Nest$fgetmPriorityCongfig(TunerResourceManagerService r0) {
        return r0.mPriorityCongfig;
    }

    /* JADX INFO: renamed from: -$$Nest$macquireLockInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9021$$Nest$macquireLockInternal(TunerResourceManagerService r0, int r1, long r2, long r4) {
        return r0.acquireLockInternal(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9022$$Nest$mdumpMap(TunerResourceManagerService r0, Map r1, String r2, String r3, IndentingPrintWriter r4) {
        r0.dumpMap(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpSIA, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9023$$Nest$mdumpSIA(TunerResourceManagerService r0, SparseIntArray r1, String r2, String r3, IndentingPrintWriter r4) {
        r0.dumpSIA(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceDescramblerAccessPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9024$$Nest$menforceDescramblerAccessPermission(TunerResourceManagerService r0, String r1) {
        r0.enforceDescramblerAccessPermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceTrmAccessPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9025$$Nest$menforceTrmAccessPermission(TunerResourceManagerService r0, String r1) {
        r0.enforceTrmAccessPermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceTunerAccessPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9026$$Nest$menforceTunerAccessPermission(TunerResourceManagerService r0, String r1) {
        r0.enforceTunerAccessPermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMaxNumberOfFrontendsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9027$$Nest$mgetMaxNumberOfFrontendsInternal(TunerResourceManagerService r0, int r1) {
        return r0.getMaxNumberOfFrontendsInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseLockInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9028$$Nest$mreleaseLockInternal(TunerResourceManagerService r0, int r1, long r2, boolean r4, boolean r5) {
        return r0.releaseLockInternal(r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveClientProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9029$$Nest$mremoveClientProfile(TunerResourceManagerService r0, int r1) {
        r0.removeClientProfile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetMaxNumberOfFrontendsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9030$$Nest$msetMaxNumberOfFrontendsInternal(TunerResourceManagerService r0, int r1, int r2) {
        return r0.setMaxNumberOfFrontendsInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mvalidateResourceHandle, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9031$$Nest$mvalidateResourceHandle(TunerResourceManagerService r0, int r1, long r2) {
        return r0.validateResourceHandle(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9032$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public TunerResourceManagerService(Context context) {
        super(context);
        this.mClientProfiles = new HashMap();
        this.mNextUnusedClientId = 0;
        this.mFrontendResources = new HashMap();
        this.mFrontendMaxUsableNums = new SparseIntArray();
        this.mFrontendUsedNums = new SparseIntArray();
        this.mFrontendExistingNums = new SparseIntArray();
        this.mFrontendResourcesBackup = new HashMap();
        this.mFrontendMaxUsableNumsBackup = new SparseIntArray();
        this.mFrontendUsedNumsBackup = new SparseIntArray();
        this.mFrontendExistingNumsBackup = new SparseIntArray();
        this.mDemuxResources = new HashMap();
        this.mLnbResources = new HashMap();
        this.mCasResources = new HashMap();
        this.mCiCamResources = new HashMap();
        this.mListeners = new HashMap();
        this.mPriorityCongfig = new UseCasePriorityHints();
        this.mResourceRequestCount = 0;
        this.mLock = new Object();
        this.mLockForTRMSLock = new ReentrantLock();
        this.mTunerApiLockReleasedCV = this.mLockForTRMSLock.newCondition();
        this.mTunerApiLockHolder = -1;
        this.mTunerApiLockHolderThreadId = -1;
        this.mTunerApiLockNestedCount = 0;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        onStart(false);
    }

    protected void onStart(boolean isForTesting) {
        if (isForTesting == true) goto L4;
        publishBinderService("tv_tuner_resource_mgr", new BinderService(this, null));
    L4:
        this.mTvInputManager = (TvInputManager) getContext().getSystemService("tv_input");
        this.mActivityManager = (ActivityManager) getContext().getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        this.mPriorityCongfig.parse();
        if (isForTesting == true) goto L10;
        boolean lazyHal = SystemProperties.getBoolean("ro.tuner.lazyhal", false);
        if (lazyHal == true) goto L10;
        SystemProperties.set("tuner.server.enable", "true");
    L10:
        if (this.mMediaResourceManager != null) goto L20;
        IBinder mediaResourceManagerBinder = getBinderService("media.resource_manager");
        if (mediaResourceManagerBinder != null) goto L21;
        Slog.w(TAG, "Resource Manager Service not available.");
        return;
    L21:
        mediaResourceManagerBinder.linkToDeath(this, 0);     // Catch: RemoteException -> L17
        this.mMediaResourceManager = IResourceManagerService.Stub.asInterface(mediaResourceManagerBinder);
        return;
    L18:
        Slog.w(TAG, "Could not link to death of native resource manager service.");
        return;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        if (DEBUG == false) goto L5;
        Slog.w(TAG, "Native media resource manager service has died");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMediaResourceManager = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    protected void registerClientProfileInternal(ResourceClientProfile profile, IResourcesReclaimListener listener, int[] clientId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "registerClientProfile(clientProfile=" + profile + ")");
    L5:
        clientId[0] = -1;
        if (this.mTvInputManager != null) goto L9;
        Slog.e(TAG, "TvInputManager is null. Can't register client profile.");
        return;
    L9:
        int r0 = this.mNextUnusedClientId;
        this.mNextUnusedClientId = r0 + 1;
        clientId[0] = r0;
        if (profile.tvInputSessionId != null) goto L12;
        int pid = Binder.getCallingPid();
    L14:
        if (profile.tvInputSessionId != null) goto L16;
    L21:
        ClientProfile clientProfile = new ClientProfile.Builder(clientId[0]).tvInputSessionId(profile.tvInputSessionId).useCase(profile.useCase).processId(pid).build();
        clientProfile.setPriority(getClientPriority(profile.useCase, checkIsForeground(pid)));
        addClientProfile(clientId[0], clientProfile, listener);
        return;
    L16:
        if (this.mMediaResourceManager == null) goto L21;
        this.mMediaResourceManager.overridePid(Binder.getCallingPid(), pid);     // Catch: RemoteException -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Could not overridePid in resourceManagerSercice, remote exception: " + e);
        goto L21
    L12:
        pid = this.mTvInputManager.getClientPid(profile.tvInputSessionId);
        goto L14
    }

    protected void unregisterClientProfileInternal(int clientId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(clientId) == true) goto L12;
        Slog.e(TAG, "Unregistering non exists client:" + clientId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "unregisterClientProfile(clientId=" + clientId + ")");     // Catch: Throwable -> L9
    L14:
        removeClientProfile(clientId);     // Catch: Throwable -> L9
        if (this.mMediaResourceManager != null) goto L25;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L25:
        this.mMediaResourceManager.overridePid(Binder.getCallingPid(), -1);     // Catch: Throwable -> L9 RemoteException -> L18
    L18:
        e = move-exception;
        Slog.e(TAG, "Could not overridePid in resourceManagerSercice when unregister, remote exception: " + e);     // Catch: Throwable -> L9
        goto L20
    }

    protected boolean updateClientPriorityInternal(int clientId, int priority, int niceValue) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "updateClientPriority(clientId=" + clientId + ", priority=" + priority + ", niceValue=" + niceValue + ")");
    L5:
        ClientProfile profile = getClientProfile(clientId);
        if (profile != null) goto L9;
        Slog.e(TAG, "Can not find client profile with id " + clientId + " when trying to update the client priority.");
        return false;
    L9:
        profile.overwritePriority(priority);
        profile.setNiceValue(niceValue);
        return true;
    }

    protected boolean hasUnusedFrontendInternal(int frontendType) {
        Iterator<FrontendResource> r0 = getFrontendResources().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        FrontendResource fr = r0.next();
        if (fr.getType() != frontendType) goto L4;
        if (fr.isInUse() == true) goto L4;
        return true;
    L12:
        return false;
    }

    protected boolean isLowestPriorityInternal(int clientId, int frontendType) throws RemoteException {
        ClientProfile requestClient = getClientProfile(clientId);
        if (requestClient != null) goto L5;
        return true;
    L5:
        clientPriorityUpdateOnRequest(requestClient);
        int clientPriority = requestClient.getPriority();
        Iterator<FrontendResource> r3 = getFrontendResources().values().iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        FrontendResource fr = r3.next();
        if (fr.getType() != frontendType) goto L7;
        if (fr.isInUse() == false) goto L7;
        int priority = updateAndGetOwnerClientPriority(fr.getOwnerClientId());
        if (clientPriority <= priority) goto L7;
        return false;
    L17:
        return true;
    }

    protected void storeResourceMapInternal(int resourceType) {
        switch(resourceType) {
            case 0: goto L4;
            default: goto L6;
        };
    L4:
        replaceFeResourceMap(this.mFrontendResources, this.mFrontendResourcesBackup);
        replaceFeCounts(this.mFrontendExistingNums, this.mFrontendExistingNumsBackup);
        replaceFeCounts(this.mFrontendUsedNums, this.mFrontendUsedNumsBackup);
        replaceFeCounts(this.mFrontendMaxUsableNums, this.mFrontendMaxUsableNumsBackup);
        return;
    }

    protected void clearResourceMapInternal(int resourceType) {
        switch(resourceType) {
            case 0: goto L4;
            default: goto L6;
        };
    L4:
        replaceFeResourceMap(null, this.mFrontendResources);
        replaceFeCounts(null, this.mFrontendExistingNums);
        replaceFeCounts(null, this.mFrontendUsedNums);
        replaceFeCounts(null, this.mFrontendMaxUsableNums);
        return;
    }

    protected void restoreResourceMapInternal(int resourceType) {
        switch(resourceType) {
            case 0: goto L4;
            default: goto L6;
        };
    L4:
        replaceFeResourceMap(this.mFrontendResourcesBackup, this.mFrontendResources);
        replaceFeCounts(this.mFrontendExistingNumsBackup, this.mFrontendExistingNums);
        replaceFeCounts(this.mFrontendUsedNumsBackup, this.mFrontendUsedNums);
        replaceFeCounts(this.mFrontendMaxUsableNumsBackup, this.mFrontendMaxUsableNums);
        return;
    }

    protected void setFrontendInfoListInternal(TunerFrontendInfo[] infos) {
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "updateFrontendInfo:");
        int i = 0;
    L6:
        if (i >= infos.length) goto L8;
        Slog.d(TAG, infos[i].toString());
        i = i + 1;
    L8:
        Set<Long> updatingFrontendHandles = new HashSet(getFrontendResources().keySet());
        int i2 = 0;
    L10:
        if (i2 >= infos.length) goto L19;
        if (getFrontendResource(infos[i2].handle) != null) goto L14;
        FrontendResource newFe = new FrontendResource.Builder(infos[i2].handle).type(infos[i2].type).exclusiveGroupId(infos[i2].exclusiveGroupId).build();
        addFrontendResource(newFe);
    L18:
        i2 = i2 + 1;
        goto L10
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Frontend handle=" + infos[i2].handle + "exists.");
    L16:
        updatingFrontendHandles.remove(Long.valueOf(infos[i2].handle));
        goto L18
    L19:
        Iterator<Long> r1 = updatingFrontendHandles.iterator();
    L21:
        if (r1.hasNext() == false) goto L23;
        long removingHandle = r1.next().longValue();
        removeFrontendResource(removingHandle);
        goto L21
    }

    protected void setDemuxInfoListInternal(TunerDemuxInfo[] infos) {
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "updateDemuxInfo:");
        int i = 0;
    L6:
        if (i >= infos.length) goto L8;
        Slog.d(TAG, infos[i].toString());
        i = i + 1;
    L8:
        Set<Long> updatingDemuxHandles = new HashSet(getDemuxResources().keySet());
        int i2 = 0;
    L10:
        if (i2 >= infos.length) goto L19;
        if (getDemuxResource(infos[i2].handle) != null) goto L14;
        DemuxResource newDemux = new DemuxResource.Builder(infos[i2].handle).filterTypes(infos[i2].filterTypes).build();
        addDemuxResource(newDemux);
    L18:
        i2 = i2 + 1;
        goto L10
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Demux handle=" + infos[i2].handle + "exists.");
    L16:
        updatingDemuxHandles.remove(Long.valueOf(infos[i2].handle));
        goto L18
    L19:
        Iterator<Long> r1 = updatingDemuxHandles.iterator();
    L21:
        if (r1.hasNext() == false) goto L23;
        long removingHandle = r1.next().longValue();
        removeDemuxResource(removingHandle);
        goto L21
    }

    protected void setLnbInfoListInternal(long[] lnbHandles) {
        if (DEBUG == false) goto L8;
        int i = 0;
    L6:
        if (i >= lnbHandles.length) goto L8;
        Slog.d(TAG, "updateLnbInfo(lnbHanle=" + lnbHandles[i] + ")");
        i = i + 1;
    L8:
        Set<Long> updatingLnbHandles = new HashSet(getLnbResources().keySet());
        int i2 = 0;
    L10:
        if (i2 >= lnbHandles.length) goto L19;
        if (getLnbResource(lnbHandles[i2]) != null) goto L14;
        LnbResource newLnb = new LnbResource.Builder(lnbHandles[i2]).build();
        addLnbResource(newLnb);
    L18:
        i2 = i2 + 1;
        goto L10
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Lnb handle=" + lnbHandles[i2] + "exists.");
    L16:
        updatingLnbHandles.remove(Long.valueOf(lnbHandles[i2]));
        goto L18
    L19:
        Iterator<Long> r1 = updatingLnbHandles.iterator();
    L21:
        if (r1.hasNext() == false) goto L23;
        long removingHandle = r1.next().longValue();
        removeLnbResource(removingHandle);
        goto L21
    }

    protected void updateCasInfoInternal(int casSystemId, int maxSessionNum) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "updateCasInfo(casSystemId=" + casSystemId + ", maxSessionNum=" + maxSessionNum + ")");
    L5:
        if (maxSessionNum != 0) goto L8;
        removeCasResource(casSystemId);
        removeCiCamResource(casSystemId);
        return;
    L8:
        CasResource cas = getCasResource(casSystemId);
        CiCamResource ciCam = getCiCamResource(casSystemId);
        if (cas != null) goto L11;
        long casSessionHandle = generateResourceHandle(4, casSystemId);
        CasResource cas2 = new CasResource.Builder(casSessionHandle, casSystemId).maxSessionNum(maxSessionNum).build();
        long ciCamHandle = generateResourceHandle(5, casSystemId);
        CiCamResource ciCam2 = new CiCamResource.Builder(ciCamHandle, casSystemId).maxSessionNum(maxSessionNum).build();
        addCasResource(cas2);
        addCiCamResource(ciCam2);
        return;
    L11:
        if (cas.getUsedSessionNum() <= maxSessionNum) goto L13;
        cas.getUsedSessionNum();
    L13:
        cas.updateMaxSessionNum(maxSessionNum);
        if (ciCam == null) goto L19;
        ciCam.updateMaxSessionNum(maxSessionNum);
        return;
    }

    protected boolean requestFrontendInternal(TunerFrontendRequest request, long[] frontendHandle) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestFrontend(request=" + request + ")");
    L5:
        int[] reclaimOwnerId = new int[1];
        if (claimFrontend(request, frontendHandle, reclaimOwnerId) == true) goto L9;
        return false;
    L9:
        if (frontendHandle[0] != (-1)) goto L12;
        return false;
    L12:
        if (reclaimOwnerId[0] != (-1)) goto L14;
    L30:
        return true;
    L14:
        if (reclaimResource(reclaimOwnerId[0], 0) == true) goto L16;
        return false;
    L16:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (getFrontendResource(frontendHandle[0]).isInUse() == false) goto L25;
        Slog.e(TAG, "Reclaimed frontend still in use");     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return false;
    L25:
        updateFrontendClientMappingOnNewGrant(frontendHandle[0], request.clientId);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        goto L30
    }

    protected boolean claimFrontend(TunerFrontendRequest request, long[] frontendHandle, int[] reclaimOwnerId) {
        boolean r0 = false;
        frontendHandle[0] = -1;
        reclaimOwnerId[0] = -1;
        Object r4 = this.mLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(request.clientId) == true) goto L12;
        Slog.e(TAG, "Request frontend from unregistered client: " + request.clientId);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    L12:
        if (getClientProfile(request.clientId).getInUseFrontendHandles().isEmpty() == true) goto L16;
        Slog.e(TAG, "Release frontend before requesting another one. Client id: " + request.clientId);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    L16:
        ClientProfile requestClient = getClientProfile(request.clientId);     // Catch: Throwable -> L9
        clientPriorityUpdateOnRequest(requestClient);     // Catch: Throwable -> L9
        FrontendResource grantingFrontend = null;
        FrontendResource inUseLowestPriorityFrontend = null;
        int currentLowestPriority = 1001;
        boolean isRequestFromSameProcess = false;
        if (request.desiredId == (-1)) goto L19;
        boolean hasDesiredFrontend = true;
    L20:
        Iterator<FrontendResource> r10 = getFrontendResources().values().iterator();     // Catch: Throwable -> L9
    L22:
        if (r10.hasNext() == false) goto L58;
        FrontendResource fr = r10.next();     // Catch: Throwable -> L9
        int frontendId = getResourceIdFromHandle(fr.getHandle());     // Catch: Throwable -> L9
        if (fr.getType() != request.frontendType) goto L56;
        if (hasDesiredFrontend == false) goto L31;
        if (frontendId == request.desiredId) goto L31;
        boolean r19 = r0;
        boolean hasDesiredFrontend2 = hasDesiredFrontend;
    L57:
        r0 = r19;
        hasDesiredFrontend = hasDesiredFrontend2;
    L31:
        if (fr.isInUse() == false) goto L33;
        if (grantingFrontend != null) goto L55;
        int priority = getFrontendHighestClientPriority(fr.getOwnerClientId());     // Catch: Throwable -> L9
        if (currentLowestPriority <= priority) goto L54;
        ClientProfile targetOwnerProfile = getClientProfile(fr.getOwnerClientId());     // Catch: Throwable -> L9
        long primaryFeId = targetOwnerProfile.getPrimaryFrontend();     // Catch: Throwable -> L9
        FrontendResource primaryFe = getFrontendResource(primaryFeId);     // Catch: Throwable -> L9
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        if (fr.getType() == primaryFe.getType()) goto L50;
        if (isFrontendMaxNumUseReached(fr.getType()) == false) goto L50;
    L48:
        r0 = r19;
        hasDesiredFrontend = hasDesiredFrontend2;
    L50:
        if (requestClient.getProcessId() != getClientProfile(fr.getOwnerClientId()).getProcessId()) goto L52;
        boolean r7 = true;
    L53:
        currentLowestPriority = priority;
        isRequestFromSameProcess = r7;
        inUseLowestPriorityFrontend = fr;
        goto L57
    L52:
        r7 = r19;
        goto L53
    L54:
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        goto L57
    L55:
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        goto L57
    L33:
        if (isFrontendMaxNumUseReached(request.frontendType) == false) goto L36;
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        goto L48
    L36:
        if (fr.getExclusiveGroupMemberFeHandles().isEmpty() == true) goto L37;
        if (grantingFrontend != null) goto L40;
        grantingFrontend = fr;
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        goto L57
    L40:
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        goto L57
    L37:
        grantingFrontend = fr;
        boolean r16 = true;
    L59:
        if (grantingFrontend == null) goto L63;
        updateFrontendClientMappingOnNewGrant(grantingFrontend.getHandle(), request.clientId);     // Catch: Throwable -> L9
        frontendHandle[r0] = grantingFrontend.getHandle();     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return r16;
    L63:
        if (inUseLowestPriorityFrontend != null) goto L65;
    L74:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return r0;
    L65:
        if (requestClient.getPriority() <= currentLowestPriority) goto L67;
    L71:
        frontendHandle[r0] = inUseLowestPriorityFrontend.getHandle();     // Catch: Throwable -> L9
        reclaimOwnerId[r0] = inUseLowestPriorityFrontend.getOwnerClientId();     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return r16;
    L67:
        if (requestClient.getPriority() != currentLowestPriority) goto L74;
        if (isRequestFromSameProcess == false) goto L74;
        if (requestClient.resourceOwnershipRetentionEnabled() == true) goto L74;
    L56:
        r19 = r0;
        hasDesiredFrontend2 = hasDesiredFrontend;
        goto L57
    L58:
        r16 = true;
        goto L59
    L19:
        hasDesiredFrontend = false;
        goto L20
    }

    protected void shareFrontendInternal(int selfClientId, int targetClientId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "shareFrontend from " + selfClientId + " with " + targetClientId);
    L5:
        Integer shareeFeClientId = getClientProfile(selfClientId).getShareeFeClientId();
        if (shareeFeClientId.intValue() == (-1)) goto L8;
        getClientProfile(shareeFeClientId.intValue()).stopSharingFrontend(selfClientId);
        getClientProfile(selfClientId).releaseFrontend();
    L8:
        Iterator<Long> r1 = getClientProfile(targetClientId).getInUseFrontendHandles().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        long feId = r1.next().longValue();
        getClientProfile(selfClientId).useFrontend(feId);
        goto L10
    L12:
        getClientProfile(selfClientId).setShareeFeClientId(Integer.valueOf(targetClientId));
        getClientProfile(targetClientId).shareFrontend(selfClientId);
    }

    private boolean transferFeOwner(int currentOwnerId, int newOwnerId) {
        ClientProfile currentOwnerProfile = getClientProfile(currentOwnerId);
        ClientProfile newOwnerProfile = getClientProfile(newOwnerId);
        newOwnerProfile.shareFrontend(currentOwnerId);
        currentOwnerProfile.stopSharingFrontend(newOwnerId);
        newOwnerProfile.setShareeFeClientId(-1);
        currentOwnerProfile.setShareeFeClientId(Integer.valueOf(newOwnerId));
        Iterator<Long> r2 = newOwnerProfile.getInUseFrontendHandles().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        getFrontendResource(r2.next().longValue()).setOwner(newOwnerId);
        goto L4
    L6:
        newOwnerProfile.setPrimaryFrontend(currentOwnerProfile.getPrimaryFrontend());
        currentOwnerProfile.setPrimaryFrontend(-1);
        Iterator<Long> r3 = currentOwnerProfile.getInUseFrontendHandles().iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        long inUseHandle = r3.next().longValue();
        int ownerId = getFrontendResource(inUseHandle).getOwnerClientId();
        if (ownerId == newOwnerId) goto L8;
        Slog.e(TAG, "something is wrong in transferFeOwner:" + inUseHandle + ", " + ownerId + ", " + newOwnerId);
        return false;
    L14:
        return true;
    }

    private boolean transferFeCiCamOwner(int currentOwnerId, int newOwnerId) {
        ClientProfile currentOwnerProfile = getClientProfile(currentOwnerId);
        ClientProfile newOwnerProfile = getClientProfile(newOwnerId);
        int ciCamId = currentOwnerProfile.getInUseCiCamId();
        newOwnerProfile.useCiCam(ciCamId);
        CiCamResource ciCam = getCiCamResource(ciCamId);
        ciCam.setOwner(newOwnerId);
        currentOwnerProfile.releaseCiCam();
        return true;
    }

    private boolean transferLnbOwner(int currentOwnerId, int newOwnerId) {
        ClientProfile currentOwnerProfile = getClientProfile(currentOwnerId);
        ClientProfile newOwnerProfile = getClientProfile(newOwnerId);
        Set<Long> inUseLnbHandles = new HashSet();
        Iterator<Long> r3 = currentOwnerProfile.getInUseLnbHandles().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Long lnbHandle = r3.next();
        newOwnerProfile.useLnb(lnbHandle.longValue());
        LnbResource lnb = getLnbResource(lnbHandle.longValue());
        lnb.setOwner(newOwnerId);
        inUseLnbHandles.add(lnbHandle);
        goto L4
    L6:
        Iterator<Long> r4 = inUseLnbHandles.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        currentOwnerProfile.releaseLnb(r4.next().longValue());
        goto L8
    L10:
        return true;
    }

    protected boolean transferOwnerInternal(int resourceType, int currentOwnerId, int newOwnerId) {
        switch(resourceType) {
            case 0: goto L10;
            case 3: goto L8;
            case 5: goto L6;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, "transferOwnerInternal. unsupported resourceType: " + resourceType);
        return false;
    L6:
        return transferFeCiCamOwner(currentOwnerId, newOwnerId);
    L8:
        return transferLnbOwner(currentOwnerId, newOwnerId);
    L10:
        return transferFeOwner(currentOwnerId, newOwnerId);
    }

    protected boolean requestLnbInternal(TunerLnbRequest request, long[] lnbHandle) throws RemoteException {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestLnb(request=" + request + ")");
    L5:
        int[] reclaimOwnerId = new int[1];
        if (claimLnb(request, lnbHandle, reclaimOwnerId) == true) goto L9;
        return false;
    L9:
        if (lnbHandle[0] != (-1)) goto L12;
        return false;
    L12:
        if (reclaimOwnerId[0] != (-1)) goto L14;
    L30:
        return true;
    L14:
        if (reclaimResource(reclaimOwnerId[0], 3) == true) goto L16;
        return false;
    L16:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (getLnbResource(lnbHandle[0]).isInUse() == false) goto L25;
        Slog.e(TAG, "Reclaimed lnb still in use");     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return false;
    L25:
        updateLnbClientMappingOnNewGrant(lnbHandle[0], request.clientId);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        goto L30
    }

    protected boolean claimLnb(TunerLnbRequest request, long[] lnbHandle, int[] reclaimOwnerId) throws RemoteException {
        lnbHandle[0] = -1;
        reclaimOwnerId[0] = -1;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(request.clientId) == false) goto L40;
        ClientProfile requestClient = getClientProfile(request.clientId);     // Catch: Throwable -> L19
        clientPriorityUpdateOnRequest(requestClient);     // Catch: Throwable -> L19
        LnbResource grantingLnb = null;
        LnbResource inUseLowestPriorityLnb = null;
        int currentLowestPriority = 1001;
        boolean isRequestFromSameProcess = false;
        Iterator<LnbResource> r7 = getLnbResources().values().iterator();     // Catch: Throwable -> L19
    L7:
        boolean r9 = true;
        if (r7.hasNext() == false) goto L22;
        LnbResource lnb = r7.next();     // Catch: Throwable -> L19
        if (lnb.isInUse() == false) goto L11;
        int priority = updateAndGetOwnerClientPriority(lnb.getOwnerClientId());     // Catch: Throwable -> L19
        if (currentLowestPriority <= priority) goto L7;
        inUseLowestPriorityLnb = lnb;
        currentLowestPriority = priority;
        if (requestClient.getProcessId() == getClientProfile(lnb.getOwnerClientId()).getProcessId()) goto L18;
        r9 = false;
    L18:
        isRequestFromSameProcess = r9;
        goto L7
    L11:
        grantingLnb = lnb;
    L22:
        if (grantingLnb == null) goto L26;
        updateLnbClientMappingOnNewGrant(grantingLnb.getHandle(), request.clientId);     // Catch: Throwable -> L19
        lnbHandle[0] = grantingLnb.getHandle();     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return true;
    L26:
        if (inUseLowestPriorityLnb != null) goto L28;
    L37:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return false;
    L28:
        if (requestClient.getPriority() <= currentLowestPriority) goto L30;
    L34:
        lnbHandle[0] = inUseLowestPriorityLnb.getHandle();     // Catch: Throwable -> L19
        reclaimOwnerId[0] = inUseLowestPriorityLnb.getOwnerClientId();     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return true;
    L30:
        if (requestClient.getPriority() != currentLowestPriority) goto L37;
        if (isRequestFromSameProcess == false) goto L37;
        if (requestClient.resourceOwnershipRetentionEnabled() == true) goto L37;
    L40:
        throw new RemoteException("Request lnb from unregistered client:" + request.clientId);     // Catch: Throwable -> L19
    }

    protected boolean requestCasSessionInternal(CasSessionRequest request, long[] casSessionHandle) throws RemoteException {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestCasSession(request=" + request + ")");
    L5:
        int[] reclaimOwnerId = new int[1];
        if (claimCasSession(request, casSessionHandle, reclaimOwnerId) == true) goto L9;
        return false;
    L9:
        if (casSessionHandle[0] != (-1)) goto L12;
        return false;
    L12:
        if (reclaimOwnerId[0] != (-1)) goto L14;
    L30:
        return true;
    L14:
        if (reclaimResource(reclaimOwnerId[0], 4) == true) goto L16;
        return false;
    L16:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (getCasResource(request.casSystemId).isFullyUsed() == false) goto L25;
        Slog.e(TAG, "Reclaimed cas still fully used");     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return false;
    L25:
        updateCasClientMappingOnNewGrant(request.casSystemId, request.clientId);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        goto L30
    }

    protected boolean claimCasSession(CasSessionRequest request, long[] casSessionHandle, int[] reclaimOwnerId) throws RemoteException {
        casSessionHandle[0] = -1;
        reclaimOwnerId[0] = -1;
        Object r4 = this.mLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(request.clientId) == false) goto L41;
        CasResource cas = getCasResource(request.casSystemId);     // Catch: Throwable -> L9
        if (cas != null) goto L11;
        long resourceHandle = generateResourceHandle(4, request.clientId);     // Catch: Throwable -> L9
        cas = new CasResource.Builder(resourceHandle, request.casSystemId).maxSessionNum(Integer.MAX_VALUE).build();     // Catch: Throwable -> L9
        addCasResource(cas);     // Catch: Throwable -> L9
    L11:
        ClientProfile requestClient = getClientProfile(request.clientId);     // Catch: Throwable -> L9
        clientPriorityUpdateOnRequest(requestClient);     // Catch: Throwable -> L9
        int lowestPriorityOwnerId = -1;
        int currentLowestPriority = 1001;
        boolean isRequestFromSameProcess = false;
        if (cas.isFullyUsed() == true) goto L16;
        updateCasClientMappingOnNewGrant(request.casSystemId, request.clientId);     // Catch: Throwable -> L9
        casSessionHandle[0] = cas.getHandle();     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    L16:
        Iterator<Integer> r10 = cas.getOwnerClientIds().iterator();     // Catch: Throwable -> L9
    L18:
        if (r10.hasNext() == false) goto L27;
        int ownerId = r10.next().intValue();     // Catch: Throwable -> L9
        int priority = updateAndGetOwnerClientPriority(ownerId);     // Catch: Throwable -> L9
        if (currentLowestPriority <= priority) goto L18;
        lowestPriorityOwnerId = ownerId;
        currentLowestPriority = priority;
        if (requestClient.getProcessId() != getClientProfile(ownerId).getProcessId()) goto L24;
        boolean r14 = true;
    L25:
        isRequestFromSameProcess = r14;
        goto L18
    L24:
        r14 = false;
        goto L25
    L27:
        if (lowestPriorityOwnerId != (-1)) goto L29;
    L38:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    L29:
        if (requestClient.getPriority() <= currentLowestPriority) goto L31;
    L35:
        casSessionHandle[0] = cas.getHandle();     // Catch: Throwable -> L9
        reclaimOwnerId[0] = lowestPriorityOwnerId;     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    L31:
        if (requestClient.getPriority() != currentLowestPriority) goto L38;
        if (isRequestFromSameProcess == false) goto L38;
        if (requestClient.resourceOwnershipRetentionEnabled() == true) goto L38;
    L41:
        throw new RemoteException("Request cas from unregistered client:" + request.clientId);     // Catch: Throwable -> L9
    }

    protected boolean requestCiCamInternal(TunerCiCamRequest request, long[] ciCamHandle) throws RemoteException {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestCiCamInternal(TunerCiCamRequest=" + request + ")");
    L5:
        int[] reclaimOwnerId = new int[1];
        if (claimCiCam(request, ciCamHandle, reclaimOwnerId) == true) goto L9;
        return false;
    L9:
        if (ciCamHandle[0] != (-1)) goto L12;
        return false;
    L12:
        if (reclaimOwnerId[0] != (-1)) goto L14;
    L30:
        return true;
    L14:
        if (reclaimResource(reclaimOwnerId[0], 5) == true) goto L16;
        return false;
    L16:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (getCiCamResource(request.ciCamId).isFullyUsed() == false) goto L25;
        Slog.e(TAG, "Reclaimed ciCam still fully used");     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return false;
    L25:
        updateCiCamClientMappingOnNewGrant(request.ciCamId, request.clientId);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        goto L30
    }

    protected boolean claimCiCam(TunerCiCamRequest request, long[] ciCamHandle, int[] reclaimOwnerId) throws RemoteException {
        ciCamHandle[0] = -1;
        reclaimOwnerId[0] = -1;
        Object r4 = this.mLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(request.clientId) == false) goto L41;
        CiCamResource ciCam = getCiCamResource(request.ciCamId);     // Catch: Throwable -> L9
        if (ciCam != null) goto L11;
        long resourceHandle = generateResourceHandle(5, request.ciCamId);     // Catch: Throwable -> L9
        ciCam = new CiCamResource.Builder(resourceHandle, request.ciCamId).maxSessionNum(Integer.MAX_VALUE).build();     // Catch: Throwable -> L9
        addCiCamResource(ciCam);     // Catch: Throwable -> L9
    L11:
        ClientProfile requestClient = getClientProfile(request.clientId);     // Catch: Throwable -> L9
        clientPriorityUpdateOnRequest(requestClient);     // Catch: Throwable -> L9
        int lowestPriorityOwnerId = -1;
        int currentLowestPriority = 1001;
        boolean isRequestFromSameProcess = false;
        if (ciCam.isFullyUsed() == true) goto L16;
        updateCiCamClientMappingOnNewGrant(request.ciCamId, request.clientId);     // Catch: Throwable -> L9
        ciCamHandle[0] = ciCam.getHandle();     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    L16:
        Iterator<Integer> r10 = ciCam.getOwnerClientIds().iterator();     // Catch: Throwable -> L9
    L18:
        if (r10.hasNext() == false) goto L27;
        int ownerId = r10.next().intValue();     // Catch: Throwable -> L9
        int priority = updateAndGetOwnerClientPriority(ownerId);     // Catch: Throwable -> L9
        if (currentLowestPriority <= priority) goto L18;
        lowestPriorityOwnerId = ownerId;
        currentLowestPriority = priority;
        if (requestClient.getProcessId() != getClientProfile(ownerId).getProcessId()) goto L24;
        boolean r14 = true;
    L25:
        isRequestFromSameProcess = r14;
        goto L18
    L24:
        r14 = false;
        goto L25
    L27:
        if (lowestPriorityOwnerId != (-1)) goto L29;
    L38:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    L29:
        if (requestClient.getPriority() <= currentLowestPriority) goto L31;
    L35:
        ciCamHandle[0] = ciCam.getHandle();     // Catch: Throwable -> L9
        reclaimOwnerId[0] = lowestPriorityOwnerId;     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    L31:
        if (requestClient.getPriority() != currentLowestPriority) goto L38;
        if (isRequestFromSameProcess == false) goto L38;
        if (requestClient.resourceOwnershipRetentionEnabled() == true) goto L38;
    L41:
        throw new RemoteException("Request ciCam from unregistered client:" + request.clientId);     // Catch: Throwable -> L9
    }

    protected boolean isHigherPriorityInternal(ResourceClientProfile challengerProfile, ResourceClientProfile holderProfile) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "isHigherPriority(challengerProfile=" + challengerProfile + ", holderProfile=" + challengerProfile + ")");
    L6:
        if (this.mTvInputManager != null) goto L10;
        Slog.e(TAG, "TvInputManager is null. Can't compare the priority.");
        return true;
    L10:
        if (challengerProfile.tvInputSessionId != null) goto L12;
        int challengerPid = Binder.getCallingPid();
    L14:
        if (holderProfile.tvInputSessionId != null) goto L16;
        int holderPid = Binder.getCallingPid();
    L17:
        int challengerPriority = getClientPriority(challengerProfile.useCase, checkIsForeground(challengerPid));
        int holderPriority = getClientPriority(holderProfile.useCase, checkIsForeground(holderPid));
        if (challengerPriority > holderPriority) goto L22;
        return false;
    L22:
        return true;
    L16:
        holderPid = this.mTvInputManager.getClientPid(holderProfile.tvInputSessionId);
        goto L17
    L12:
        challengerPid = this.mTvInputManager.getClientPid(challengerProfile.tvInputSessionId);
        goto L14
    }

    protected void releaseFrontendInternal(long frontendHandle, int clientId) throws RemoteException {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "releaseFrontend(id=" + frontendHandle + ", clientId=" + clientId + " )");
    L6:
        if (validateResourceHandle(0, frontendHandle) == false) goto L22;
        Set<Integer> reclaimedResourceOwnerIds = unclaimFrontend(frontendHandle, clientId);
        if (reclaimedResourceOwnerIds == null) goto L13;
        Iterator<Integer> r2 = reclaimedResourceOwnerIds.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        int shareOwnerId = r2.next().intValue();
        reclaimResource(shareOwnerId, 0);
    L13:
        Object r0 = this.mLock;
        monitor-enter(r0);
        clearFrontendAndClientMapping(getClientProfile(clientId));     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new RemoteException("frontendHandle can't be invalid");
    }

    private Set<Integer> unclaimFrontend(long frontendHandle, int clientId) throws RemoteException {
        Set<Integer> reclaimedResourceOwnerIds = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(clientId) == false) goto L22;
        FrontendResource fe = getFrontendResource(frontendHandle);     // Catch: Throwable -> L11
        if (fe == null) goto L20;
        int ownerClientId = fe.getOwnerClientId();     // Catch: Throwable -> L11
        ClientProfile ownerProfile = getClientProfile(ownerClientId);     // Catch: Throwable -> L11
        if (ownerClientId != clientId) goto L14;
        reclaimedResourceOwnerIds = ownerProfile.getShareFeClientIds();     // Catch: Throwable -> L11
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return reclaimedResourceOwnerIds;
    L14:
        if (ownerProfile.getShareFeClientIds().contains(Integer.valueOf(clientId)) == true) goto L15;
        throw new RemoteException("Client is not a sharee of the releasing fe.");     // Catch: Throwable -> L11
    L20:
        throw new RemoteException("Releasing frontend does not exist.");     // Catch: Throwable -> L11
    L22:
        throw new RemoteException("Release frontend from unregistered client:" + clientId);     // Catch: Throwable -> L11
    }

    protected void releaseDemuxInternal(DemuxResource demux) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "releaseDemux(DemuxHandle=" + demux.getHandle() + ")");
    L5:
        updateDemuxClientMappingOnRelease(demux);
    }

    protected void releaseLnbInternal(LnbResource lnb) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "releaseLnb(lnbHandle=" + lnb.getHandle() + ")");
    L5:
        updateLnbClientMappingOnRelease(lnb);
    }

    protected void releaseCasSessionInternal(CasResource cas, int ownerClientId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "releaseCasSession(sessionResourceId=" + cas.getSystemId() + ")");
    L5:
        updateCasClientMappingOnRelease(cas, ownerClientId);
    }

    protected void releaseCiCamInternal(CiCamResource ciCam, int ownerClientId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "releaseCiCamInternal(ciCamId=" + ciCam.getCiCamId() + ")");
    L5:
        updateCiCamClientMappingOnRelease(ciCam, ownerClientId);
    }

    public boolean requestDemuxInternal(TunerDemuxRequest request, long[] demuxHandle) throws RemoteException {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestDemux(request=" + request + ")");
    L5:
        int[] reclaimOwnerId = new int[1];
        if (claimDemux(request, demuxHandle, reclaimOwnerId) == true) goto L9;
        return false;
    L9:
        if (demuxHandle[0] != (-1)) goto L12;
        return false;
    L12:
        if (reclaimOwnerId[0] != (-1)) goto L14;
    L30:
        return true;
    L14:
        if (reclaimResource(reclaimOwnerId[0], 1) == true) goto L16;
        return false;
    L16:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (getDemuxResource(demuxHandle[0]).isInUse() == false) goto L25;
        Slog.e(TAG, "Reclaimed demux still in use");     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return false;
    L25:
        updateDemuxClientMappingOnNewGrant(demuxHandle[0], request.clientId);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean claimDemux(TunerDemuxRequest r21, long[] r22, int[] r23) throws RemoteException {
        boolean r0 = false;
        r22[0] = -1;
        r23[0] = -1;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (checkClientExists(r21.clientId) == false) goto L73;
        boolean r5 = true;
        if (this.mDemuxResources.size() != 0) goto L13;
        r22[0] = generateResourceHandle(1, 0);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        return true;
    L13:
        ClientProfile r4 = getClientProfile(r21.clientId);     // Catch: Throwable -> L11
        if (r4 != null) goto L17;
        monitor-exit(r3);     // Catch: Throwable -> L11
        return false;
    L17:
        clientPriorityUpdateOnRequest(r4);     // Catch: Throwable -> L11
        DemuxResource r6 = null;
        DemuxResource r7 = null;
        int r8 = 1001;
        boolean r9 = false;
        if (r21.desiredFilterTypes == 0) goto L20;
        Object[] r10 = true;
    L21:
        int r11 = 33;
        int r12 = 33;
        Iterator<DemuxResource> r13 = getDemuxResources().values().iterator();     // Catch: Throwable -> L11
    L23:
        if (r13.hasNext() == false) goto L54;
        DemuxResource r14 = r13.next();     // Catch: Throwable -> L11
        if (r10 == false) goto L31;
        if (r14.hasSufficientCaps(r21.desiredFilterTypes) == true) goto L31;
        boolean r18 = r0;
        boolean r19 = r5;
    L53:
        r0 = r18;
        r5 = r19;
    L31:
        if (r14.isInUse() == true) goto L36;
        int r15 = r14.getNumOfCaps();     // Catch: Throwable -> L11
        if (r11 <= r15) goto L35;
        r11 = r15;
        r6 = r14;
    L35:
        r18 = r0;
        r19 = r5;
        goto L53
    L36:
        if (r6 != null) goto L52;
        int r16 = updateAndGetOwnerClientPriority(r14.getOwnerClientId());     // Catch: Throwable -> L11
        if (r8 < r16) goto L51;
        int r17 = r14.getNumOfCaps();     // Catch: Throwable -> L11
        boolean r110 = false;
        if (r8 <= r16) goto L46;
        r8 = r16;
        r18 = r0;
        r19 = r5;
        if (r4.getProcessId() != getClientProfile(r14.getOwnerClientId()).getProcessId()) goto L44;
        boolean r1 = r19;
    L45:
        r9 = r1;
        r12 = r17;
        r110 = true;
    L49:
        if (r110 == false) goto L53;
        r7 = r14;
        goto L53
    L44:
        r1 = r18;
        goto L45
    L46:
        r18 = r0;
        r19 = r5;
        if (r12 <= r17) goto L49;
        r12 = r17;
        r110 = true;
        goto L49
    L51:
        r18 = r0;
        r19 = r5;
        goto L53
    L52:
        r18 = r0;
        r19 = r5;
        goto L53
    L54:
        boolean r111 = r0;
        boolean r112 = r5;
        if (r6 == null) goto L59;
        updateDemuxClientMappingOnNewGrant(r6.getHandle(), r21.clientId);     // Catch: Throwable -> L11
        r22[r111 ? 1 : 0] = r6.getHandle();     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        return r112;
    L59:
        if (r7 != null) goto L61;
    L70:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return r111;
    L61:
        if (r4.getPriority() <= r8) goto L63;
    L67:
        r22[r111 ? 1 : 0] = r7.getHandle();     // Catch: Throwable -> L11
        r23[r111 ? 1 : 0] = r7.getOwnerClientId();     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        return r112;
    L63:
        if (r4.getPriority() != r8) goto L70;
        if (r9 == false) goto L70;
        if (r4.resourceOwnershipRetentionEnabled() == true) goto L70;
    L20:
        r10 = false;
        goto L21
    L73:
        throw new RemoteException("Request demux from unregistered client:" + r21.clientId);     // Catch: Throwable -> L11
    }

    protected void clientPriorityUpdateOnRequest(ClientProfile profile) {
        if (profile.isPriorityOverwritten() == false) goto L5;
        return;
    L5:
        int pid = profile.getProcessId();
        boolean currentIsForeground = checkIsForeground(pid);
        profile.setPriority(getClientPriority(profile.getUseCase(), currentIsForeground));
    }

    protected boolean requestDescramblerInternal(TunerDescramblerRequest request, long[] descramblerHandle) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestDescrambler(request=" + request + ")");
    L5:
        descramblerHandle[0] = generateResourceHandle(2, 0);
        return true;
    }

    private long getElapsedTime(long begin) {
        long now = SystemClock.uptimeMillis();
        if (now >= begin) goto L9;
        long elapsed = (Long.MAX_VALUE - begin) + now;
        if (elapsed >= 0) goto L10;
        return Long.MAX_VALUE;
    L10:
        return elapsed;
    L9:
        return now - begin;
    }

    private boolean lockForTunerApiLock(int clientId, long timeoutMS, String callerFunction) {
    L9:
        ie = move-exception;
        Slog.e(TAG, "exception thrown in " + callerFunction + ":" + ie);
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L13;
        this.mLockForTRMSLock.unlock();
    L13:
        return false;
    L4:
        if (this.mLockForTRMSLock.tryLock(timeoutMS, TimeUnit.MILLISECONDS) == false) goto L7;
        return true;
    L7:
        Slog.e(TAG, "FAILED to lock mLockForTRMSLock in " + callerFunction + ", clientId:" + clientId + ", timeoutMS:" + timeoutMS + ", mTunerApiLockHolder:" + this.mTunerApiLockHolder);     // Catch: InterruptedException -> L9
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean acquireLockInternal(int clientId, long clientThreadId, long timeoutMS) {
        long begin = SystemClock.uptimeMillis();
        boolean r11 = false;
        if (lockForTunerApiLock(clientId, timeoutMS, "acquireLockInternal()") == true) goto L87;
        return false;
    L87:
    L74:
        ie = e;
        boolean r16 = false;
    L77:
        Slog.e(TAG, "exception thrown in acquireLockInternal(" + clientId + ", " + clientThreadId + ", " + timeoutMS + "):" + ie);     // Catch: Throwable -> L31
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L81;
        this.mLockForTRMSLock.unlock();
    L81:
        return r16;
    L35:
        ie = th;
    L83:
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L85;
        this.mLockForTRMSLock.unlock();
    L85:
        throw ie;
    L6:
        if (this.mTunerApiLockHolder != (-1)) goto L8;
        boolean available = true;
    L9:
        if (clientId == this.mTunerApiLockHolder) goto L92;
    L19:
        boolean nestedSelf = false;
    L20:
        boolean recovery = false;
    L21:
        r16 = r11;
        if (available == true) goto L47;
        if (nestedSelf == true) goto L47;
    L37:
        ie = e;
        goto L77
    L25:
        boolean nestedSelf2 = nestedSelf;
        int r19 = 1;
        long leftOverMS = timeoutMS - getElapsedTime(begin);
        if (leftOverMS <= 0) goto L28;
        long begin2 = begin;
        this.mTunerApiLockReleasedCV.await(leftOverMS, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L31 InterruptedException -> L33
        if (this.mTunerApiLockHolder != (-1)) goto L43;
        available = true;
    L44:
        if (available == true) goto L46;
        Slog.w(TAG, "acquireLockInternal(" + clientId + ", " + clientThreadId + ", " + timeoutMS + ") - woken up from cond wait, but " + this.mTunerApiLockHolder + "(" + this.mTunerApiLockHolderThreadId + ") is already holding the lock. Going to wait again if timeout hasn't reached yet");     // Catch: Throwable -> L31 InterruptedException -> L33
    L46:
        r11 = r16;
        nestedSelf = nestedSelf2;
        begin = begin2;
        goto L21
    L43:
        available = r16;
    L33:
        ie = e;
        goto L77
    L28:
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L35 InterruptedException -> L37
    L30:
        r0.append("FAILED:acquireLockInternal(");     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(clientId);     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(", ");     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(clientThreadId);     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(", ");     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(timeoutMS);     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(") - timed out, but will grant the lock to the callee by stealing it from the current holder:");     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(this.mTunerApiLockHolder);     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append("(");     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append(this.mTunerApiLockHolderThreadId);     // Catch: Throwable -> L31 InterruptedException -> L33
        r0.append("), who likely failed to call releaseLock(), to prevent this from becoming an unrecoverable error");     // Catch: Throwable -> L31 InterruptedException -> L33
        Slog.e(TAG, r0.toString());     // Catch: Throwable -> L31 InterruptedException -> L33
        recovery = true;
    L48:
        if (available != 0) goto L58;
        if (recovery == true) goto L58;
        if (nestedSelf2 == false) goto L56;
        this.mTunerApiLockNestedCount++;     // Catch: Throwable -> L31 InterruptedException -> L33
        if (DEBUG == false) goto L55;
        Slog.d(TAG, "acquireLockInternal(" + clientId + ", " + clientThreadId + ", " + timeoutMS + ") - nested count incremented to " + this.mTunerApiLockNestedCount);     // Catch: Throwable -> L31 InterruptedException -> L33
        int r1 = r19;
    L64:
        if (available == true) goto L69;
        if (nestedSelf2 == true) goto L69;
        if (recovery == true) goto L69;
        boolean r12 = r16;
    L71:
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L73;
        this.mLockForTRMSLock.unlock();
    L73:
        return r12;
    L69:
        r12 = r1;
        goto L71
    L55:
        r1 = r19;
        goto L64
    L56:
        Slog.e(TAG, "acquireLockInternal(" + clientId + ", " + clientThreadId + ", " + timeoutMS + ") - should not reach here");     // Catch: Throwable -> L31 InterruptedException -> L33
        r1 = r19;
    L58:
        if (DEBUG == false) goto L61;
        Slog.d(TAG, "SUCCESS:acquireLockInternal(" + clientId + ", " + clientThreadId + ", " + timeoutMS + ")");     // Catch: Throwable -> L31 InterruptedException -> L33
    L61:
        if (this.mTunerApiLockNestedCount == 0) goto L63;
        Slog.w(TAG, "Something is wrong as nestedCount(" + this.mTunerApiLockNestedCount + ") is not zero. Will overriding it to 1 anyways");     // Catch: Throwable -> L31 InterruptedException -> L33
    L63:
        this.mTunerApiLockHolder = clientId;     // Catch: Throwable -> L31 InterruptedException -> L33
        this.mTunerApiLockHolderThreadId = clientThreadId;     // Catch: Throwable -> L31 InterruptedException -> L33
        r1 = r19;
        this.mTunerApiLockNestedCount = r1;     // Catch: Throwable -> L31 InterruptedException -> L33
    L47:
        nestedSelf2 = nestedSelf;
        r19 = 1;
        goto L48
    L92:
    L13:
        if (clientThreadId != this.mTunerApiLockHolderThreadId) goto L19;
        nestedSelf = true;
    L17:
        ie = e;
        r16 = false;
    L15:
        ie = th;
        goto L83
    L8:
        available = false;
    L31:
        ie = th;
        goto L83
    }

    private boolean releaseLockInternal(int clientId, long timeoutMS, boolean ignoreNestedCount, boolean suppressError) {
        if (lockForTunerApiLock(clientId, timeoutMS, "releaseLockInternal()") == true) goto L44;
        return false;
    L44:
    L16:
        th = move-exception;
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L43;
        this.mLockForTRMSLock.unlock();
    L43:
        throw th;
    L7:
        if (this.mTunerApiLockHolder != clientId) goto L27;
        this.mTunerApiLockNestedCount--;     // Catch: Throwable -> L16
        if (ignoreNestedCount == true) goto L19;
        if (this.mTunerApiLockNestedCount <= 0) goto L19;
        if (DEBUG == false) goto L23;
        Slog.d(TAG, "releaseLockInternal(" + clientId + ", " + timeoutMS + ", " + ignoreNestedCount + ", " + suppressError + ") - NOT signaling because nested count is not zero (" + this.mTunerApiLockNestedCount + ")");     // Catch: Throwable -> L16
    L23:
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L25;
        this.mLockForTRMSLock.unlock();
    L25:
        return true;
    L19:
        if (DEBUG == false) goto L21;
        Slog.d(TAG, "SUCCESS:releaseLockInternal(" + clientId + ", " + timeoutMS + ", " + ignoreNestedCount + ", " + suppressError + ") - signaling!");     // Catch: Throwable -> L16
    L21:
        this.mTunerApiLockHolder = -1;     // Catch: Throwable -> L16
        this.mTunerApiLockHolderThreadId = -1;     // Catch: Throwable -> L16
        this.mTunerApiLockNestedCount = 0;     // Catch: Throwable -> L16
        this.mTunerApiLockReleasedCV.signal();     // Catch: Throwable -> L16
        goto L23
    L27:
        if (this.mTunerApiLockHolder != (-1)) goto L34;
        if (suppressError == true) goto L31;
        Slog.w(TAG, "releaseLockInternal(" + clientId + ", " + timeoutMS + ") - called while there is no current holder");     // Catch: Throwable -> L16
    L31:
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L33;
        this.mLockForTRMSLock.unlock();
    L33:
        return false;
    L34:
        if (suppressError == true) goto L37;
        Slog.e(TAG, "releaseLockInternal(" + clientId + ", " + timeoutMS + ") - called while someone else:" + this.mTunerApiLockHolder + "is the current holder");     // Catch: Throwable -> L16
    L37:
        if (this.mLockForTRMSLock.isHeldByCurrentThread() == false) goto L39;
        this.mLockForTRMSLock.unlock();
    L39:
        return false;
    }

    private void addResourcesReclaimListener(int clientId, IResourcesReclaimListener listener) {
        if (listener == null) goto L4;
        ResourcesReclaimListenerRecord record = new ResourcesReclaimListenerRecord(this, listener, clientId);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L17
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mListeners.put(Integer.valueOf(clientId), record);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        Slog.w(TAG, "Listener already died.");
        return;
    L4:
        if (DEBUG == false) goto L24;
        Slog.w(TAG, "Listener is null when client " + clientId + " registered!");
        return;
    }

    protected boolean reclaimResource(int reclaimingClientId, int resourceType) {
        Binder.allowBlockingForCurrentThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        ClientProfile profile = getClientProfile(reclaimingClientId);     // Catch: Throwable -> L8
        if (profile != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L10:
        Set<Integer> shareFeClientIds = profile.getShareFeClientIds();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Iterator<Integer> r1 = shareFeClientIds.iterator();
    L14:
        if (r1.hasNext() == false) goto L29;
        int clientId = r1.next().intValue();
        Object r5 = this.mLock;
        monitor-enter(r5);
        ResourcesReclaimListenerRecord listenerRecord = this.mListeners.get(Integer.valueOf(clientId));     // Catch: Throwable -> L25
        monitor-exit(r5);     // Catch: Throwable -> L25
        if (listenerRecord == null) goto L14;
        listenerRecord.getListener().onReclaimResources();     // Catch: RemoteException -> L22
    L22:
        e = move-exception;
        Slog.e(TAG, "Failed to reclaim resources on client " + clientId, e);
    L25:
        th = move-exception;
        throw th;
    L29:
        if (DEBUG == false) goto L31;
        Slog.d(TAG, "Reclaiming resources because higher priority client request resource type " + resourceType + ", clientId:" + reclaimingClientId);
    L31:
        Object r2 = this.mLock;
        monitor-enter(r2);
        ResourcesReclaimListenerRecord listenerRecord2 = this.mListeners.get(Integer.valueOf(reclaimingClientId));     // Catch: Throwable -> L41
        monitor-exit(r2);     // Catch: Throwable -> L41
        if (listenerRecord2 != null) goto L46;
    L40:
        return true;
    L46:
        listenerRecord2.getListener().onReclaimResources();     // Catch: RemoteException -> L38
    L38:
        e = move-exception;
        Slog.e(TAG, "Failed to reclaim resources on client " + reclaimingClientId, e);
    L41:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    protected int getClientPriority(int useCase, boolean isForeground) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "getClientPriority useCase=" + useCase + ", isForeground=" + isForeground + ")");
    L5:
        if (isForeground == false) goto L9;
        return this.mPriorityCongfig.getForegroundPriority(useCase);
    L9:
        return this.mPriorityCongfig.getBackgroundPriority(useCase);
    }

    protected boolean checkIsForeground(int pid) {
        if (this.mActivityManager != null) goto L5;
        return false;
    L5:
        List<ActivityManager.RunningAppProcessInfo> appProcesses = this.mActivityManager.getRunningAppProcesses();
        if (appProcesses != null) goto L8;
        return false;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = appProcesses.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo appProcess = r2.next();
        if (appProcess.pid != pid) goto L10;
        if (appProcess.importance != 100) goto L10;
        return true;
    L18:
        return false;
    }

    private void updateFrontendClientMappingOnNewGrant(long grantingHandle, int ownerClientId) {
        FrontendResource grantingFrontend = getFrontendResource(grantingHandle);
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        grantingFrontend.setOwner(ownerClientId);
        increFrontendNum(this.mFrontendUsedNums, grantingFrontend.getType());
        ownerProfile.useFrontend(grantingHandle);
        Iterator<Long> r2 = grantingFrontend.getExclusiveGroupMemberFeHandles().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        long exclusiveGroupMember = r2.next().longValue();
        getFrontendResource(exclusiveGroupMember).setOwner(ownerClientId);
        ownerProfile.useFrontend(exclusiveGroupMember);
        goto L4
    L6:
        ownerProfile.setPrimaryFrontend(grantingHandle);
    }

    private void updateDemuxClientMappingOnNewGrant(long grantingHandle, int ownerClientId) {
        DemuxResource grantingDemux = getDemuxResource(grantingHandle);
        if (grantingDemux == null) goto L6;
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        grantingDemux.setOwner(ownerClientId);
        ownerProfile.useDemux(grantingHandle);
        return;
    }

    private void updateDemuxClientMappingOnRelease(DemuxResource releasingDemux) {
        ClientProfile ownerProfile = getClientProfile(releasingDemux.getOwnerClientId());
        releasingDemux.removeOwner();
        ownerProfile.releaseDemux(releasingDemux.getHandle());
    }

    private void updateLnbClientMappingOnNewGrant(long grantingHandle, int ownerClientId) {
        LnbResource grantingLnb = getLnbResource(grantingHandle);
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        grantingLnb.setOwner(ownerClientId);
        ownerProfile.useLnb(grantingHandle);
    }

    private void updateLnbClientMappingOnRelease(LnbResource releasingLnb) {
        ClientProfile ownerProfile = getClientProfile(releasingLnb.getOwnerClientId());
        releasingLnb.removeOwner();
        ownerProfile.releaseLnb(releasingLnb.getHandle());
    }

    private void updateCasClientMappingOnNewGrant(int grantingId, int ownerClientId) {
        CasResource grantingCas = getCasResource(grantingId);
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        grantingCas.setOwner(ownerClientId);
        ownerProfile.useCas(grantingId);
    }

    private void updateCiCamClientMappingOnNewGrant(int grantingId, int ownerClientId) {
        CiCamResource grantingCiCam = getCiCamResource(grantingId);
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        grantingCiCam.setOwner(ownerClientId);
        ownerProfile.useCiCam(grantingId);
    }

    private void updateCasClientMappingOnRelease(CasResource cas, int ownerClientId) {
        cas.removeSession(ownerClientId);
        if (cas.hasOpenSessions(ownerClientId) == true) goto L6;
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        cas.removeOwner(ownerClientId);
        ownerProfile.releaseCas();
        return;
    }

    private void updateCiCamClientMappingOnRelease(CiCamResource releasingCiCam, int ownerClientId) {
        ClientProfile ownerProfile = getClientProfile(ownerClientId);
        releasingCiCam.removeOwner(ownerClientId);
        ownerProfile.releaseCiCam();
    }

    private int updateAndGetOwnerClientPriority(int clientId) {
        ClientProfile profile = getClientProfile(clientId);
        clientPriorityUpdateOnRequest(profile);
        return profile.getPriority();
    }

    private int getFrontendHighestClientPriority(int clientId) {
        ClientProfile ownerClient = getClientProfile(clientId);
        if (ownerClient != null) goto L6;
        return 0;
    L6:
        int highestPriority = updateAndGetOwnerClientPriority(clientId);
        Iterator<Integer> r2 = ownerClient.getShareFeClientIds().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        int shareeId = r2.next().intValue();
        int priority = updateAndGetOwnerClientPriority(shareeId);
        if (priority <= highestPriority) goto L8;
        highestPriority = priority;
        goto L8
    L13:
        return highestPriority;
    }

    protected FrontendResource getFrontendResource(long frontendHandle) {
        return this.mFrontendResources.get(Long.valueOf(frontendHandle));
    }

    protected Map<Long, FrontendResource> getFrontendResources() {
        return this.mFrontendResources;
    }

    protected DemuxResource getDemuxResource(long demuxHandle) {
        return this.mDemuxResources.get(Long.valueOf(demuxHandle));
    }

    protected Map<Long, DemuxResource> getDemuxResources() {
        return this.mDemuxResources;
    }

    private boolean setMaxNumberOfFrontendsInternal(int frontendType, int maxUsableNum) {
        int usedNum = this.mFrontendUsedNums.get(frontendType, -1);
        if (usedNum == (-1)) goto L8;
        if (usedNum <= maxUsableNum) goto L8;
        Slog.e(TAG, "max number of frontend for frontendType: " + frontendType + " cannot be set to a value lower than the current usage count. (requested max num = " + maxUsableNum + ", current usage = " + usedNum);
        return false;
    L8:
        this.mFrontendMaxUsableNums.put(frontendType, maxUsableNum);
        return true;
    }

    private int getMaxNumberOfFrontendsInternal(int frontendType) {
        int existingNum = this.mFrontendExistingNums.get(frontendType, -1);
        if (existingNum != (-1)) goto L6;
        Log.e(TAG, "existingNum is -1 for " + frontendType);
        return -1;
    L6:
        int maxUsableNum = this.mFrontendMaxUsableNums.get(frontendType, -1);
        if (maxUsableNum != (-1)) goto L9;
        return existingNum;
    L9:
        return maxUsableNum;
    }

    private boolean isFrontendMaxNumUseReached(int frontendType) {
        int maxUsableNum = this.mFrontendMaxUsableNums.get(frontendType, -1);
        if (maxUsableNum != (-1)) goto L5;
        return false;
    L5:
        int useNum = this.mFrontendUsedNums.get(frontendType, -1);
        if (useNum != (-1)) goto L8;
        useNum = 0;
    L8:
        if (useNum < maxUsableNum) goto L11;
        return true;
    L11:
        return false;
    }

    private void increFrontendNum(SparseIntArray targetNums, int frontendType) {
        int num = targetNums.get(frontendType, -1);
        if (num != (-1)) goto L5;
        targetNums.put(frontendType, 1);
        return;
    L5:
        targetNums.put(frontendType, num + 1);
    }

    private void decreFrontendNum(SparseIntArray targetNums, int frontendType) {
        int num = targetNums.get(frontendType, -1);
        if (num == (-1)) goto L6;
        targetNums.put(frontendType, num - 1);
        return;
    }

    private void replaceFeResourceMap(Map<Long, FrontendResource> srcMap, Map<Long, FrontendResource> dstMap) {
        if (dstMap == null) goto L9;
        dstMap.clear();
        if (srcMap != null) goto L6;
        return;
    L6:
        if (srcMap.size() <= 0) goto L11;
        dstMap.putAll(srcMap);
        return;
    L11:
        return;
    }

    private void replaceFeCounts(SparseIntArray srcCounts, SparseIntArray dstCounts) {
        if (dstCounts == null) goto L9;
        dstCounts.clear();
        if (srcCounts == null) goto L11;
        int i = 0;
    L7:
        if (i >= srcCounts.size()) goto L12;
        dstCounts.put(srcCounts.keyAt(i), srcCounts.valueAt(i));
        i = i + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private void dumpMap(Map<?, ?> targetMap, String headline, String delimiter, IndentingPrintWriter pw) {
        if (targetMap == null) goto L10;
        pw.println(headline);
        pw.increaseIndent();
        Iterator<Map.Entry<?, ?>> r0 = targetMap.entrySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L7;
        Map.Entry<?, ?> entry = r0.next();
        pw.print(entry.getKey() + " : " + entry.getValue());
        pw.print(delimiter);
        goto L5
    L7:
        pw.println();
        pw.decreaseIndent();
        return;
    }

    private void dumpSIA(SparseIntArray array, String headline, String delimiter, IndentingPrintWriter pw) {
        if (array == null) goto L10;
        pw.println(headline);
        pw.increaseIndent();
        int i = 0;
    L5:
        if (i >= array.size()) goto L7;
        pw.print(array.keyAt(i) + " : " + array.valueAt(i));
        pw.print(delimiter);
        i = i + 1;
        goto L5
    L7:
        pw.println();
        pw.decreaseIndent();
        return;
    }

    private void addFrontendResource(FrontendResource newFe) {
        Iterator<FrontendResource> r0 = getFrontendResources().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        FrontendResource fe = r0.next();
        if (fe.getExclusiveGroupId() != newFe.getExclusiveGroupId()) goto L4;
        newFe.addExclusiveGroupMemberFeHandle(fe.getHandle());
        newFe.addExclusiveGroupMemberFeHandles(fe.getExclusiveGroupMemberFeHandles());
        Iterator<Long> r1 = fe.getExclusiveGroupMemberFeHandles().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        long excGroupmemberFeHandle = r1.next().longValue();
        getFrontendResource(excGroupmemberFeHandle).addExclusiveGroupMemberFeHandle(newFe.getHandle());
        goto L9
    L11:
        fe.addExclusiveGroupMemberFeHandle(newFe.getHandle());
    L13:
        this.mFrontendResources.put(Long.valueOf(newFe.getHandle()), newFe);
        increFrontendNum(this.mFrontendExistingNums, newFe.getType());
    }

    private void addDemuxResource(DemuxResource newDemux) {
        this.mDemuxResources.put(Long.valueOf(newDemux.getHandle()), newDemux);
    }

    private void removeFrontendResource(long removingHandle) {
        FrontendResource fe = getFrontendResource(removingHandle);
        if (fe != null) goto L6;
        return;
    L6:
        if (fe.isInUse() == false) goto L12;
        ClientProfile ownerClient = getClientProfile(fe.getOwnerClientId());
        Iterator<Integer> r2 = ownerClient.getShareFeClientIds().iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        int shareOwnerId = r2.next().intValue();
        clearFrontendAndClientMapping(getClientProfile(shareOwnerId));
        goto L9
    L11:
        clearFrontendAndClientMapping(ownerClient);
    L12:
        Iterator<Long> r1 = fe.getExclusiveGroupMemberFeHandles().iterator();
    L14:
        if (r1.hasNext() == false) goto L16;
        long excGroupmemberFeHandle = r1.next().longValue();
        getFrontendResource(excGroupmemberFeHandle).removeExclusiveGroupMemberFeId(fe.getHandle());
        goto L14
    L16:
        decreFrontendNum(this.mFrontendExistingNums, fe.getType());
        this.mFrontendResources.remove(Long.valueOf(removingHandle));
    }

    private void removeDemuxResource(long removingHandle) {
        DemuxResource demux = getDemuxResource(removingHandle);
        if (demux != null) goto L6;
        return;
    L6:
        if (demux.isInUse() == false) goto L8;
        releaseDemuxInternal(demux);
    L8:
        this.mDemuxResources.remove(Long.valueOf(removingHandle));
    }

    protected LnbResource getLnbResource(long lnbHandle) {
        return this.mLnbResources.get(Long.valueOf(lnbHandle));
    }

    protected Map<Long, LnbResource> getLnbResources() {
        return this.mLnbResources;
    }

    private void addLnbResource(LnbResource newLnb) {
        this.mLnbResources.put(Long.valueOf(newLnb.getHandle()), newLnb);
    }

    private void removeLnbResource(long removingHandle) {
        LnbResource lnb = getLnbResource(removingHandle);
        if (lnb != null) goto L6;
        return;
    L6:
        if (lnb.isInUse() == false) goto L8;
        releaseLnbInternal(lnb);
    L8:
        this.mLnbResources.remove(Long.valueOf(removingHandle));
    }

    protected CasResource getCasResource(int systemId) {
        return this.mCasResources.get(Integer.valueOf(systemId));
    }

    protected CiCamResource getCiCamResource(int ciCamId) {
        return this.mCiCamResources.get(Integer.valueOf(ciCamId));
    }

    protected Map<Integer, CasResource> getCasResources() {
        return this.mCasResources;
    }

    protected Map<Integer, CiCamResource> getCiCamResources() {
        return this.mCiCamResources;
    }

    private void addCasResource(CasResource newCas) {
        this.mCasResources.put(Integer.valueOf(newCas.getSystemId()), newCas);
    }

    private void addCiCamResource(CiCamResource newCiCam) {
        this.mCiCamResources.put(Integer.valueOf(newCiCam.getCiCamId()), newCiCam);
    }

    private void removeCasResource(int removingId) {
        CasResource cas = getCasResource(removingId);
        if (cas != null) goto L5;
        return;
    L5:
        Iterator<Integer> r1 = cas.getOwnerClientIds().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        int ownerId = r1.next().intValue();
        getClientProfile(ownerId).releaseCas();
        goto L7
    L9:
        this.mCasResources.remove(Integer.valueOf(removingId));
    }

    private void removeCiCamResource(int removingId) {
        CiCamResource ciCam = getCiCamResource(removingId);
        if (ciCam != null) goto L5;
        return;
    L5:
        Iterator<Integer> r1 = ciCam.getOwnerClientIds().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        int ownerId = r1.next().intValue();
        getClientProfile(ownerId).releaseCiCam();
        goto L7
    L9:
        this.mCiCamResources.remove(Integer.valueOf(removingId));
    }

    private void releaseLowerPriorityClientCasResources(int releasingCasResourceNum) {
    }

    protected ClientProfile getClientProfile(int clientId) {
        return this.mClientProfiles.get(Integer.valueOf(clientId));
    }

    private void addClientProfile(int clientId, ClientProfile profile, IResourcesReclaimListener listener) {
        this.mClientProfiles.put(Integer.valueOf(clientId), profile);
        addResourcesReclaimListener(clientId, listener);
    }

    private void removeClientProfile(int clientId) {
        Iterator<Integer> r0 = getClientProfile(clientId).getShareFeClientIds().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int shareOwnerId = r0.next().intValue();
        clearFrontendAndClientMapping(getClientProfile(shareOwnerId));
        goto L4
    L6:
        clearAllResourcesAndClientMapping(getClientProfile(clientId));
        this.mClientProfiles.remove(Integer.valueOf(clientId));
        ResourcesReclaimListenerRecord record = this.mListeners.remove(Integer.valueOf(clientId));
        if (record == null) goto L11;
        record.getListener().asBinder().unlinkToDeath(record, 0);
        return;
    }

    private void clearFrontendAndClientMapping(ClientProfile profile) {
        if (profile != null) goto L4;
        return;
    L4:
        Iterator<Long> r0 = profile.getInUseFrontendHandles().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        Long feId = r0.next();
        FrontendResource fe = getFrontendResource(feId.longValue());
        int ownerClientId = fe.getOwnerClientId();
        if (ownerClientId == profile.getId()) goto L9;
        ClientProfile ownerClientProfile = getClientProfile(ownerClientId);
        if (ownerClientProfile == null) goto L6;
        ownerClientProfile.stopSharingFrontend(profile.getId());
        goto L6
    L9:
        fe.removeOwner();
        goto L6
    L14:
        long primaryFeId = profile.getPrimaryFrontend();
        if (primaryFeId == (-1)) goto L19;
        FrontendResource primaryFe = getFrontendResource(primaryFeId);
        if (primaryFe == null) goto L19;
        decreFrontendNum(this.mFrontendUsedNums, primaryFe.getType());
    L19:
        profile.releaseFrontend();
    }

    protected void clearAllResourcesAndClientMapping(ClientProfile profile) {
        if (profile != null) goto L4;
        return;
    L4:
        Iterator<Long> r0 = profile.getInUseLnbHandles().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        Long lnbHandle = r0.next();
        getLnbResource(lnbHandle.longValue()).removeOwner();
        goto L6
    L9:
        if (profile.getInUseCasSystemId() == (-1)) goto L12;
        getCasResource(profile.getInUseCasSystemId()).removeOwner(profile.getId());
    L12:
        if (profile.getInUseCiCamId() == (-1)) goto L14;
        getCiCamResource(profile.getInUseCiCamId()).removeOwner(profile.getId());
    L14:
        Iterator<Long> r1 = profile.getInUseDemuxHandles().iterator();
    L16:
        if (r1.hasNext() == false) goto L18;
        Long demuxHandle = r1.next();
        getDemuxResource(demuxHandle.longValue()).removeOwner();
        goto L16
    L18:
        clearFrontendAndClientMapping(profile);
        profile.reclaimAllResources();
    }

    protected boolean checkClientExists(int clientId) {
        return this.mClientProfiles.keySet().contains(Integer.valueOf(clientId));
    }

    private long generateResourceHandle(int resourceType, int resourceId) {
        long r0 = ((((long) resourceType) & RESOURCE_TYPE_MASK) << 56) | ((((long) resourceId) & (-1)) << 24);
        int r2 = this.mResourceRequestCount;
        this.mResourceRequestCount = r2 + 1;
        return r0 | (((long) r2) & RESOURCE_COUNT_MASK);
    }

    protected int getResourceIdFromHandle(long resourceHandle) {
        if (resourceHandle != (-1)) goto L7;
        return (int) resourceHandle;
    L7:
        return (int) ((-1) & (resourceHandle >> 24));
    }

    private boolean validateResourceHandle(int resourceType, long resourceHandle) {
        if (resourceHandle != (-1)) goto L5;
        return false;
    L5:
        if (((resourceHandle >> 56) & RESOURCE_TYPE_MASK) != resourceType) goto L11;
        return true;
    L11:
        return false;
    }

    private void enforceTrmAccessPermission(String apiName) {
        getContext().enforceCallingOrSelfPermission("android.permission.TUNER_RESOURCE_ACCESS", "TunerResourceManagerService: " + apiName);
    }

    private void enforceTunerAccessPermission(String apiName) {
        getContext().enforceCallingPermission("android.permission.ACCESS_TV_TUNER", "TunerResourceManagerService: " + apiName);
    }

    private void enforceDescramblerAccessPermission(String apiName) {
        getContext().enforceCallingPermission("android.permission.ACCESS_TV_DESCRAMBLER", "TunerResourceManagerService: " + apiName);
    }
}
