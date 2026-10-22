package os.teatracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
class TeaServiceProxy implements ServiceConnection {
    private static final int MAX_RETRY_COUNT = 10;
    private static final long RETRY_DELAY = 1000;
    public static final String TEA_SERVICE_ACTION = "os.teatracker.ACTION_TEA_TRACKER_SERVICE";
    private a mBindCallback;
    private final AtomicBoolean mConnected;
    private Context mContext;
    private Handler mHandler;
    private Messenger mMessenger;
    private final AtomicInteger mRetryCount;
    private boolean mUnbindMySelf;

    interface a {
        void a();

        void b();
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TeaServiceProxy f40682a = null;

        static {
            f40682a = new TeaServiceProxy(null);
        }
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    /* synthetic */ TeaServiceProxy(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$000(TeaServiceProxy r0) {
        return r0.bindTeaService();
    }

    private TeaServiceProxy() {
        this.mConnected = new AtomicBoolean(false);
        this.mRetryCount = new AtomicInteger(0);
        this.mUnbindMySelf = false;
    }

    public boolean bindService(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "bindService context is null");
        return false;
    L6:
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        if (this.mConnected.get() == false) goto L13;
        if (this.mMessenger == null) goto L13;
        notifyBindCallback(true);
        return true;
    L13:
        if (bindTeaService() == false) goto L15;
        return true;
    L15:
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "Can't connect to service");
        unbindService();
        return false;
    }

    public void setBindCallback(a r3) {
        this.mBindCallback = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public boolean isTeaServiceConnected() {
        if (this.mConnected.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mMessenger == null) goto L7;
        return true;
    }

    private boolean bindTeaService() {
        Intent r0 = new Intent(TEA_SERVICE_ACTION);
        Context r1 = this.mContext;
        if (r1 != null) goto L6;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "bindTeaService mContext is null");
        return false;
    L6:
        PackageManager r2 = r1.getPackageManager();
        if (r2 != null) goto L10;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "Can not resolve app! packageManager is null ");
        return false;
    L10:
        List<ResolveInfo> r3 = r2.queryIntentServices(r0, 0);
        if (r3 != null) goto L14;
        return false;
    L14:
        if (r3.isEmpty() == false) goto L18;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "Can not resolve app! We got empty list!");
        return false;
    L18:
        if (r3.size() <= 1) goto L21;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "can not resolve app! We got several results!");
        return false;
    L21:
        r0.setPackage(((ResolveInfo) ZeusTransformUtils.preCheckCast(r3.get(0), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo.packageName);
        return ZeusTransformUtils.bindService(this.mContext, r0, this, 1, "com.obric.aiagent.plugin");
    }

    public void unbindService() {
        this.mUnbindMySelf = true;
        if (isTeaServiceConnected() == false) goto L5;
        ZeusTransformUtils.unbindService(this.mContext, this, "com.obric.aiagent.plugin");
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
    }

    public boolean onEvent(List<g> r10, boolean r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
    L24:
        e = move-exception;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "ServiceProxy onEvent ex: " + e);
    L26:
        return false;
    L4:
        if (isTeaServiceConnected() == false) goto L26;
        Message r2 = new Message();     // Catch: RemoteException -> L24
        r2.what = 101;     // Catch: RemoteException -> L24
        Bundle r3 = new Bundle();     // Catch: RemoteException -> L24
        r2.setData(r3);     // Catch: RemoteException -> L24
        e r4 = TeaHandler.d().e();     // Catch: RemoteException -> L24
        if (r11 == false) goto L8;
        String r13 = "568726";
    L9:
        r3.putString("key_app_id", r13);     // Catch: RemoteException -> L24
        ArrayList<? extends Parcelable> r14 = new ArrayList(r12.size());     // Catch: RemoteException -> L24
        Iterator r15 = r12.iterator();     // Catch: RemoteException -> L24
    L11:
        if (r15.hasNext() == false) goto L17;
        g r5 = (g) ZeusTransformUtils.preCheckCast(r15.next(), g.class, "com.obric.aiagent.plugin");     // Catch: RemoteException -> L24
        Bundle r6 = new Bundle();     // Catch: RemoteException -> L24
        r6.putString("key_event", r5.a());     // Catch: RemoteException -> L24
        if (r5.b() != null) goto L15;
        String r7 = null;
    L16:
        r6.putString("key_params", r7);     // Catch: RemoteException -> L24
        r6.putBoolean("key_instant", r5.c());     // Catch: RemoteException -> L24
        r6.putLong("key_timestamp", r5.d());     // Catch: RemoteException -> L24
        r14.add(r6);     // Catch: RemoteException -> L24
        goto L11
    L15:
        r7 = r5.b().toString();     // Catch: RemoteException -> L24
        goto L16
    L17:
        r3.putParcelableArrayList("key_data", r14);     // Catch: RemoteException -> L24
        Messenger r9 = this.mMessenger;     // Catch: RemoteException -> L24
        if (r9 != null) goto L21;
        r3.clear();     // Catch: RemoteException -> L24
        r2.recycle();     // Catch: RemoteException -> L24
        return false;
    L21:
        r9.send(r2);     // Catch: RemoteException -> L24
        return true;
    L8:
        r13 = r4.a();     // Catch: RemoteException -> L24
        goto L9
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        this.mRetryCount.set(0);
        this.mMessenger = new Messenger(r4);
        setAbSdkVersion(TeaHandler.d().c());
        Boolean r5 = TeaHandler.d().b();
        if (r5 == null) goto L5;
        setPrivacyPolicyConfirmed(r5.booleanValue());
    L5:
        notifyBindCallback(true);
        this.mConnected.set(true);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r4) {
        this.mConnected.set(false);
        this.mMessenger = null;
        if (this.mUnbindMySelf == true) goto L9;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "ServiceProxy retry times: " + this.mRetryCount.get());
        if (this.mRetryCount.getAndIncrement() >= 10) goto L7;
        this.mHandler.postDelayed(new AnonymousClass1(this), 1000);
        return;
    L7:
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "ServiceProxy connted to tea service error with " + this.mRetryCount.get() + " times retry.");
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        onServiceDisconnected(r1);
    }

    private void notifyBindCallback(boolean r1) {
        a r0 = this.mBindCallback;
        if (r0 == null) goto L8;
        if (r1 == false) goto L6;
        r0.a();
        return;
    L6:
        r0.b();
        return;
    }

    public void setAbSdkVersion(String r5) {
        Message r0 = new Message();     // Catch: RemoteException -> L4
        r0.what = 102;     // Catch: RemoteException -> L4
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L4
        r1.putString("key_app_id", TeaHandler.d().e().a());     // Catch: RemoteException -> L4
        r1.putString("key_ab_sdk_version", r5);     // Catch: RemoteException -> L4
        r0.setData(r1);     // Catch: RemoteException -> L4
        this.mMessenger.send(r0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "ServiceProxy setAbSdkVersion ex: " + e);
    }

    public void setPrivacyPolicyConfirmed(boolean r5) {
        Message r0 = new Message();     // Catch: RemoteException -> L4
        r0.what = 103;     // Catch: RemoteException -> L4
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L4
        r1.putString("key_app_id", TeaHandler.d().e().a());     // Catch: RemoteException -> L4
        r1.putBoolean("key_privacy_confirmed", r5);     // Catch: RemoteException -> L4
        r0.setData(r1);     // Catch: RemoteException -> L4
        this.mMessenger.send(r0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(e.f40691b, "ServiceProxy setPrivacyPolicyConfirmed ex: " + e);
    }

    public static TeaServiceProxy getTeaServiceProxy(Handler r2) {
        if (b.f40682a.mHandler != null) goto L11;
        if (r2 == null) goto L9;
        if (r2.getLooper() == Looper.getMainLooper()) goto L9;
        b.f40682a.mHandler = r2;
    L9:
        throw new RuntimeException("A handler needed by ServiceProxy and handler should runs in the non-main thread");
    L11:
        return b.f40682a;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_os_teatracker_TeaServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
