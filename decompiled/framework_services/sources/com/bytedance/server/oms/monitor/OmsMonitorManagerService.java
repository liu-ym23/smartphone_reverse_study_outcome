package com.bytedance.server.oms.monitor;

import android.app.ActivityManager;
import android.app.UidObserver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.server.pm.PackageManagerService;
import com.bytedance.internal.oms.connector.OmsFrameworkMonitor;
import com.bytedance.internal.oms.connector.strategies.IdleTimeoutStrategy;
import com.bytedance.os.oms.connector.DisconnectStrategy;
import com.bytedance.os.oms.monitor.IOmsMonitorBackend;
import com.bytedance.os.oms.monitor.IOmsMonitorManager;
import com.bytedance.server.oms.OceanMobileBackendConnector;
import com.bytedance.server.oms.OceanMobileSystemService;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class OmsMonitorManagerService extends OceanMobileSystemService<IOmsMonitorBackend> {
    private static final long BACKEND_IDLE_TIMEOUT_MS = 60000;
    private static final int INVALID_CHANNEL_ID = -1;
    private static final ComponentName PROVIDER_COMPONENT = null;
    private static final String TAG = "OmsMonitorService";
    private final IOmsMonitorManager.Stub mBinder;
    private final Object mChannelLock;
    private final Map<Integer, ChannelRecord> mChannels;
    private final Map<Integer, Set<Integer>> mChannelsByUid;
    private final AtomicInteger mNextChannelId;
    private final Set<Integer> mObservedUids;
    private final UidObserver mUidObserver;
    private IBinder mUidObserverToken;

    private final class BackendConnector extends OceanMobileBackendConnector<IOmsMonitorBackend> {
        private final Context mContext;
        private final Intent mIntent;
        final /* synthetic */ OmsMonitorManagerService this$0;

        BackendConnector(OmsMonitorManagerService r8, Context context) {
            this.this$0 = r8;
            super(context, new Intent().setComponent(OmsMonitorManagerService.m10541$$Nest$sfgetPROVIDER_COMPONENT()), AudioFormat.AAC_MAIN, new OmsMonitorManagerService$BackendConnector$$ExternalSyntheticLambda0(), "oms_monitor");
            this.mContext = context;
            this.mIntent = new Intent().setComponent(OmsMonitorManagerService.m10541$$Nest$sfgetPROVIDER_COMPONENT());
        }

        boolean isProviderInstalled() {
            if (this.mContext.getPackageManager().resolveService(this.mIntent, 0) == null) goto L6;
            return true;
        L6:
            return false;
        }
    }

    private static final class ChannelRecord {
        final int channelId;
        final int ownerUid;
        final String packageName;
        volatile boolean registeredToBackend;

        ChannelRecord(int channelId, int ownerUid, String packageName) {
            this.channelId = channelId;
            this.ownerUid = ownerUid;
            this.packageName = packageName;
        }
    }

    public static /* synthetic */ void $r8$lambda$7cTYlmfnn4XF3E8FegwasTO_1Rc(int r0, IOmsMonitorBackend r1) {
        lambda$unregisterChannelInternal$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FhWpKog2HcjUlC7WCoLV5Vd_pho(int r0, IOmsMonitorBackend r1) {
        lambda$notifyChannelInternal$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Q-Xupl4rPJYmpdP_FOwBR2fbmZE, reason: not valid java name */
    public static /* synthetic */ void m10534$r8$lambda$QXupl4rPJYmpdP_FOwBR2fbmZE(Void r0, Throwable r1) {
        lambda$registerChannelInternal$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$gP2KBxKaluXErZ9ZiWd3X8l4fR8(Void r0, Throwable r1) {
        lambda$notifyChannelInternal$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$hfvmzjvo4ZfN-_q3wqXeDqAsu3Q, reason: not valid java name */
    public static /* synthetic */ void m10535$r8$lambda$hfvmzjvo4ZfN_q3wqXeDqAsu3Q(int r0, ChannelRecord r1, SharedMemory r2, ParcelFileDescriptor r3, SharedMemory r4, ParcelFileDescriptor r5, IOmsMonitorBackend r6) {
        lambda$registerChannelInternal$0(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$tcaSU4thnnd5M8vdf3cTGLW2ifs(Void r0, Throwable r1) {
        lambda$unregisterChannelInternal$3(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOwnerUidGone, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10536$$Nest$mhandleOwnerUidGone(OmsMonitorManagerService r0, int r1) {
        r0.handleOwnerUidGone(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misCallerPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10537$$Nest$misCallerPackage(OmsMonitorManagerService r0, String r1) {
        return r0.isCallerPackage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyChannelInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10538$$Nest$mnotifyChannelInternal(OmsMonitorManagerService r0, int r1) {
        r0.notifyChannelInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterChannelInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10539$$Nest$mregisterChannelInternal(OmsMonitorManagerService r0, String r1, SharedMemory r2, ParcelFileDescriptor r3) {
        return r0.registerChannelInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterChannelInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10540$$Nest$munregisterChannelInternal(OmsMonitorManagerService r0, int r1) {
        r0.unregisterChannelInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPROVIDER_COMPONENT, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m10541$$Nest$sfgetPROVIDER_COMPONENT() {
        return PROVIDER_COMPONENT;
    }

    static /* synthetic */ OceanMobileBackendConnector access$000(OmsMonitorManagerService x0) {
        return x0.getBackendConnector();
    }

    static {
        PROVIDER_COMPONENT = new ComponentName("com.obric.matrix", "com.obric.matrix.monitor.OmsMonitorBackendService");
    }

    public OmsMonitorManagerService(Context context) {
        super(context);
        this.mChannelLock = new Object();
        this.mNextChannelId = new AtomicInteger(1);
        this.mChannels = new HashMap();
        this.mChannelsByUid = new HashMap();
        this.mObservedUids = new HashSet();
        this.mUidObserver = new AnonymousClass1(this);
        this.mBinder = new AnonymousClass2(this);
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected String getOmsServiceName() {
        return "oms_monitor";
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected OceanMobileBackendConnector<IOmsMonitorBackend> createBackendConnector(Context context) {
        return new BackendConnector(this, context);
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected IBinder createBinderService() {
        return this.mBinder;
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected Class<?> getBinderStubClass() {
        return IOmsMonitorManager.Stub.class;
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected List<DisconnectStrategy> createDisconnectStrategies() {
        return List.of(new IdleTimeoutStrategy(60000));
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected boolean shouldKeepBackendConnected() {
        return false;
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected void onOmsServiceStarted() {
        OmsFrameworkMonitor.setSink(new AnonymousClass3(this));
    }

    private int registerChannelInternal(String packageName, final SharedMemory buffer, final ParcelFileDescriptor signalReadFd) {
        if (buffer == null) goto L17;
        if (signalReadFd == null) goto L17;
        final SharedMemory backendBuffer = SharedMemory.fromFileDescriptor(buffer.getFdDup());     // Catch: IOException -> L13
        final ParcelFileDescriptor backendSignalReadFd = signalReadFd.dup();     // Catch: IOException -> L13
        final int channelId = this.mNextChannelId.getAndIncrement();
        if (TextUtils.isEmpty(packageName) == false) goto L10;
        String safePackageName = "unknown";
    L11:
        int ownerUid = Binder.getCallingUid();
        final ChannelRecord record = new ChannelRecord(channelId, ownerUid, safePackageName);
        addChannelRecord(record);
        getBackendConnector().post(new OmsMonitorManagerService$$ExternalSyntheticLambda4(channelId, record, backendBuffer, backendSignalReadFd, buffer, signalReadFd)).whenComplete(new OmsMonitorManagerService$$ExternalSyntheticLambda5());
        return channelId;
    L10:
        safePackageName = packageName;
    L13:
        e = move-exception;
        log(5, "registerChannel failed to dup channel fds", e);
        closeQuietly(buffer);
        closeQuietly(signalReadFd);
        return -1;
    L17:
        log(5, "registerChannel rejected null channel", null);
        return -1;
    }

    private static /* synthetic */ void lambda$registerChannelInternal$0(int channelId, ChannelRecord record, SharedMemory backendBuffer, ParcelFileDescriptor backendSignalReadFd, SharedMemory buffer, ParcelFileDescriptor signalReadFd, IOmsMonitorBackend backend) throws Exception {
        backend.registerChannel(channelId, record.packageName, backendBuffer, backendSignalReadFd);     // Catch: Throwable -> L5
        record.registeredToBackend = true;     // Catch: Throwable -> L5
        closeQuietly(backendBuffer);
        closeQuietly(backendSignalReadFd);
        closeQuietly(buffer);
        closeQuietly(signalReadFd);
        return;
    L5:
        th = move-exception;
        closeQuietly(backendBuffer);
        closeQuietly(backendSignalReadFd);
        closeQuietly(buffer);
        closeQuietly(signalReadFd);
        throw th;
    }

    private static /* synthetic */ void lambda$registerChannelInternal$1(Void result, Throwable error) {
        if (error == null) goto L5;
        log(5, "registerChannel route failed", error);
        return;
    }

    private void unregisterChannelInternal(final int channelId) {
        removeChannelRecord(channelId);
        getBackendConnector().post(new OmsMonitorManagerService$$ExternalSyntheticLambda0(channelId)).whenComplete(new OmsMonitorManagerService$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ void lambda$unregisterChannelInternal$2(int channelId, IOmsMonitorBackend backend) throws Exception {
        backend.unregisterChannel(channelId);
    }

    private static /* synthetic */ void lambda$unregisterChannelInternal$3(Void result, Throwable error) {
        if (error == null) goto L5;
        log(5, "unregisterChannel route failed", error);
        return;
    }

    private static /* synthetic */ void lambda$notifyChannelInternal$4(int channelId, IOmsMonitorBackend backend) throws Exception {
        backend.notifyChannel(channelId);
    }

    private void notifyChannelInternal(final int channelId) {
        getBackendConnector().post(new OmsMonitorManagerService$$ExternalSyntheticLambda2(channelId)).whenComplete(new OmsMonitorManagerService$$ExternalSyntheticLambda3());
    }

    private static /* synthetic */ void lambda$notifyChannelInternal$5(Void result, Throwable error) {
        if (error == null) goto L5;
        log(5, "notifyChannel route failed", error);
        return;
    }

    private void handleOwnerUidGone(int uid) {
        ArrayList<Integer> channelIds = new ArrayList();
        Object r1 = this.mChannelLock;
        monitor-enter(r1);
        Set<Integer> channels = this.mChannelsByUid.remove(Integer.valueOf(uid));     // Catch: Throwable -> L10
        if (channels == null) goto L12;
        channelIds.addAll(channels);     // Catch: Throwable -> L10
        Iterator<Integer> r3 = channels.iterator();     // Catch: Throwable -> L10
    L8:
        if (r3.hasNext() == false) goto L12;
        this.mChannels.remove(r3.next());     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        Iterator<Integer> r2 = channelIds.iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        int channelId = r2.next().intValue();
        log(4, "owner uid gone, unregisterChannel id=" + channelId + ", uid=" + uid, null);
        unregisterChannelInternal(channelId);
        goto L15
    L17:
        updateUidObserverAfterRemove(uid);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void addChannelRecord(ChannelRecord record) {
        Object r0 = this.mChannelLock;
        monitor-enter(r0);
        this.mChannels.put(Integer.valueOf(record.channelId), record);     // Catch: Throwable -> L7
        Set<Integer> channels = this.mChannelsByUid.get(Integer.valueOf(record.ownerUid));     // Catch: Throwable -> L7
        if (channels != null) goto L9;
        channels = new HashSet();     // Catch: Throwable -> L7
        this.mChannelsByUid.put(Integer.valueOf(record.ownerUid), channels);     // Catch: Throwable -> L7
    L9:
        channels.add(Integer.valueOf(record.channelId));     // Catch: Throwable -> L7
        if (this.mObservedUids.contains(Integer.valueOf(record.ownerUid)) == true) goto L12;
        boolean shouldObserve = true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (shouldObserve == true) goto L16;
        return;
    L16:
        if (record.ownerUid != 1000) goto L18;
        return;
    L18:
        if (record.ownerUid == 0) goto L27;
        observeOwnerUid(record.ownerUid);
        return;
    L27:
        return;
    L12:
        shouldObserve = false;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeChannelRecord(int channelId) {
        Object r0 = this.mChannelLock;
        monitor-enter(r0);
        ChannelRecord record = this.mChannels.remove(Integer.valueOf(channelId));     // Catch: Throwable -> L8
        if (record != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Set<Integer> channels = this.mChannelsByUid.get(Integer.valueOf(record.ownerUid));     // Catch: Throwable -> L8
        if (channels == null) goto L15;
        channels.remove(Integer.valueOf(channelId));     // Catch: Throwable -> L8
        if (channels.isEmpty() == false) goto L15;
        this.mChannelsByUid.remove(Integer.valueOf(record.ownerUid));     // Catch: Throwable -> L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateUidObserverAfterRemove(record.ownerUid);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void observeOwnerUid(int uid) {
        Object r1 = this.mChannelLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservedUids.contains(Integer.valueOf(uid)) == false) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        IBinder token = this.mUidObserverToken;     // Catch: RemoteException -> L14
        if (token != null) goto L16;
        this.mUidObserverToken = ActivityManager.getService().registerUidObserverForUids(this.mUidObserver, 2, -1, PackageManagerService.PLATFORM_PACKAGE_NAME, new int[]{uid});     // Catch: RemoteException -> L14
    L17:
        Object r2 = this.mChannelLock;     // Catch: RemoteException -> L14
        monitor-enter(r2);     // Catch: RemoteException -> L14
        this.mObservedUids.add(Integer.valueOf(uid));     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
    L33:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L14
    L16:
        ActivityManager.getService().addUidToObserver(token, PackageManagerService.PLATFORM_PACKAGE_NAME, uid);     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        log(5, "observeOwnerUid failed uid=" + uid, e);
    }

    private void updateUidObserverAfterRemove(int uid) {
        Object r0 = this.mChannelLock;
        monitor-enter(r0);
        boolean shouldUnregister = false;
        if (this.mChannelsByUid.containsKey(Integer.valueOf(uid)) == false) goto L7;
    L11:
        boolean shouldRemove = false;
    L13:
        if (shouldRemove == true) goto L15;
    L17:
        IBinder token = this.mUidObserverToken;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (shouldRemove == false) goto L26;
        if (token == null) goto L26;
        ActivityManager.getService().removeUidFromObserver(token, PackageManagerService.PLATFORM_PACKAGE_NAME, uid);     // Catch: RemoteException -> L24
    L24:
        e = move-exception;
        log(5, "removeUidFromObserver failed uid=" + uid, e);
    L26:
        if (shouldUnregister == false) goto L41;
        ActivityManager.getService().unregisterUidObserver(this.mUidObserver);     // Catch: RemoteException -> L29
    L31:
        this.mUidObserverToken = null;
        return;
    L29:
        e = move-exception;
        log(5, "unregisterUidObserver failed", e);
        goto L31
    L41:
        return;
    L15:
        if (this.mObservedUids.isEmpty() == false) goto L17;
        shouldUnregister = true;
        goto L17
    L7:
        if (this.mObservedUids.remove(Integer.valueOf(uid)) == false) goto L11;
        shouldRemove = true;
    L9:
        th = move-exception;
        throw th;
    }

    private static void log(int priority, String message, Throwable throwable) {
        OmsFrameworkMonitor.log("oms_monitor", priority, TAG, message, throwable);
    }

    private boolean isCallerPackage(String packageName) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L20;
        if (callingUid == 0) goto L20;
        if (TextUtils.isEmpty(packageName) == false) goto L9;
        return false;
    L9:
        String[] packages = getContext().getPackageManager().getPackagesForUid(callingUid);
        if (packages != null) goto L12;
        return false;
    L12:
        int callingUserId = UserHandle.getUserId(callingUid);
        int r5 = packages.length;
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L19;
        String candidate = packages[r6];
        if (packageName.equals(candidate) == false) goto L18;
        if (callingUserId < 0) goto L18;
        return true;
    L18:
        r6 = r6 + 1;
        goto L13
    L19:
        return false;
    L20:
        return true;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) goto L8;
        return;
    L8:
        closeable.close();     // Catch: IOException -> L6
        return;
    }
}
