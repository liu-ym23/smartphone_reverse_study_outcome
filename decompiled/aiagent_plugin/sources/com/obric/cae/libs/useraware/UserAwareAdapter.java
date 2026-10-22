package com.obric.cae.libs.useraware;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.utils.SmartBindService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class UserAwareAdapter {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static volatile UserAwareAdapter f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeUserAware f31799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f31800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f31801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartBindService f31802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f31803e;

    public interface ServiceConnectionListener {
        void onServiceConnected(UserAwareAdapter r1);

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserAwareAdapter f31804a;

        public a(UserAwareAdapter r1) {
            this.f31804a = r1;
        }

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.i(r0, r1);
        }

        public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter$a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("UserAwareAdapter", "service connected: " + r3.getPackageName());
            monitor-enter(UserAwareAdapter.class);
            this.f31804a.f31799a = ICaeUserAware.Stub.asInterface(r5);     // Catch: Throwable -> L16
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L16
            Iterator r6 = this.f31804a.f31801c.iterator();
        L8:
            if (r6.hasNext() == false) goto L15;
            ServiceConnectionListener r7 = (ServiceConnectionListener) ZeusTransformUtils.preCheckCast(r6.next(), ServiceConnectionListener.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L8;
            r7.onServiceConnected(this.f31804a);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter$a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "Error in onServiceConnected callback", e);
            goto L8
        L15:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter$a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("UserAwareAdapter", "service disconnected: " + r3.getPackageName());
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r2 = this.f31804a;     // Catch: Throwable -> L16
            r2.f31799a = null;     // Catch: Throwable -> L16
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L16
            Iterator r4 = r2.f31801c.iterator();
        L8:
            if (r4.hasNext() == false) goto L15;
            ServiceConnectionListener r5 = (ServiceConnectionListener) ZeusTransformUtils.preCheckCast(r4.next(), ServiceConnectionListener.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L8;
            r5.onServiceDisconnected();     // Catch: Exception -> L13
        L13:
            e = move-exception;
            INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter$a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "Error in onServiceDisconnected callback", e);
            goto L8
        L15:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter$a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter$a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public UserAwareAdapter(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.f31801c = new CopyOnWriteArrayList();
        a r0 = new a(this);
        this.f31803e = r0;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.f31800b = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        SmartBindService r1 = new SmartBindService(r7, r0, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.f31802d = r1;
        r1.smartBindToService();
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static UserAwareAdapter getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new UserAwareAdapter(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public void addBssidsToAvoidRomingScan(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.addBssidsToAvoidRomingScan(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "addBssidsToAvoidRomingScan failed", e);
    }

    public void addHomeWifiBssids(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.addHomeWifiBssids(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "addHomeWifiBssids failed", e);
    }

    public boolean checkLocationPermission(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L6;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("UserAwareAdapter", "checkLocationPermission passed.");
        return true;
    L6:
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "Critical error: Host application lacks ACCESS_FINE_LOCATION permission! WiFi scanning will not work.");
        throw new SecurityException("Your app must grant ACCESS_FINE_LOCATION permission to use this SDK");
    }

    public void clearHomeWifiBssids() {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.clearHomeWifiBssids();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "clearHomeWifiBssids failed", e);
    }

    public boolean isServiceConnected() {
        if (this.f31799a != null) goto L6;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("UserAwareAdapter", "UserAwareService is not connected.");
        this.f31802d.smartBindToService();
    L6:
        if (this.f31799a == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void notifyGeofenceChanged(int r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.notifyGeofenceChanged(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "notifyGeofenceChanged failed", e);
    }

    public void notifyHarEvent(HarEventData r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.notifyHarEvent(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "notifyHarEvent failed", e);
    }

    public void notifyLearningSuccess(boolean r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.notifyLearningSuccess(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "notifyLearningSuccess failed", e);
    }

    public void notifyRoomChangedPredicted(int r2) {
        ICaeUserAware r1 = this.f31799a;
        if (r1 == null) goto L11;
        r1.notifyRoomChangedPredicted(r2);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "Failed to notify room changed predicted", e);
        return;
    }

    public void registerCallback(ICaeUserAwareCallback r3) {
        ICaeUserAwareCallback r4 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.registerCallback(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "registerCallback failed", e);
    }

    public void registerConnectionListener(ServiceConnectionListener r3) {
        ServiceConnectionListener r4 = (ServiceConnectionListener) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnectionListener.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.f31801c.contains(r4) == true) goto L11;
        this.f31801c.add(r4);
        if (this.f31799a == null) goto L12;
        r4.onServiceConnected(this);
        return;
    L12:
        return;
    }

    public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r3) {
        ISmartBluetoothEventCallback r4 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r3, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.registerSmartBluetoothEvent(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "registerSmartBluetoothEvent failed", e);
    }

    public void release() {
        if (this.f31799a == null) goto L5;
        ZeusTransformUtils.unbindService(this.f31800b, this.f31803e, "com.obric.aiagent.plugin");
        this.f31799a = null;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("UserAwareAdapter", "UserAwareAdapter released and service unbound.");
    L5:
        f = null;
    }

    public void setHarMonitorParams(HarMonitorParams r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.setHarMonitorParams(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "setHarMonitorParams failed", e);
    }

    public void setHarState(int r2, long r3, int r5) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.setHarState(r2, r3, r5);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "setHarState failed", e);
    }

    public void setLevel2DataCollection(List<HarLevel2DataReq> r3, int r4, HarLevel2DataResp r5) {
        List<HarLevel2DataReq> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        HarLevel2DataResp r7 = (HarLevel2DataResp) ZeusTransformUtils.wrapperContextForParams(r5, HarLevel2DataResp.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.setLevel2DataCollection(r6, r4, r7);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "setLevel2DataCollection failed", e);
    }

    public void unregisterCallback(ICaeUserAwareCallback r3) {
        ICaeUserAwareCallback r4 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.unregisterCallback(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "unregisterCallback failed", e);
    }

    public void unregisterConnectionListener(ServiceConnectionListener r3) {
        ServiceConnectionListener r4 = (ServiceConnectionListener) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnectionListener.class, "com.obric.aiagent.plugin");
        this.f31801c.remove(r4);
    }

    public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r3) {
        ISmartBluetoothEventCallback r4 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r3, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f31799a.unregisterSmartBluetoothEvent(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "unregisterSmartBluetoothEvent failed", e);
    }

    public static UserAwareAdapter getInstance(Context r2, ServiceConnectionListener r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ServiceConnectionListener r5 = (ServiceConnectionListener) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnectionListener.class, "com.obric.aiagent.plugin");
        if (f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new UserAwareAdapter(r4, r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public UserAwareAdapter(Context r4, ServiceConnectionListener r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        ServiceConnectionListener r7 = (ServiceConnectionListener) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnectionListener.class, "com.obric.aiagent.plugin");
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.f31801c = r0;
        this.f31803e = new a(this);
        this.f31800b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L13:
        SmartBindService r8 = new SmartBindService(this.f31800b, this.f31803e, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.f31802d = r8;
        r8.smartBindToService();
        return;
    L5:
        if (r0.contains(r7) == true) goto L8;
        r0.add(r7);
    L8:
        if (this.f31799a == null) goto L13;
        r7.onServiceConnected(this);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("UserAwareAdapter", "Error notifying onServiceConnected immediately", e);
        goto L13
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_useraware_UserAwareAdapter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
