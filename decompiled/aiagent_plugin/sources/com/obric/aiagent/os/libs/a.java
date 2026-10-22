package com.obric.aiagent.os.libs;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.cae.libs.multipath.ICaeMultipathManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CaeMultipathClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final String TAG = "CaeMultipathClient";
    private static volatile a g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICaeMultipathManager f18725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IBinder f18726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f18727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f18728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18729e;
    private int f;
    private Gson h;

    static /* synthetic */ int a(a r0, int r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f();
    }

    static /* synthetic */ int b(a r2) {
        int r0 = r2.f;
        r2.f = r0 + 1;
        return r0;
    }

    static /* synthetic */ int c(a r0) {
        return r0.f;
    }

    static /* synthetic */ boolean d(a r0) {
        return r0.i();
    }

    static /* synthetic */ void e(a r0) {
        r0.h();
    }

    private a() {
        this.f18729e = false;
        this.f = 0;
        this.h = new Gson();
        e();
        this.f18728d.sendEmptyMessage(1);
    }

    public static a a() {
        if (g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    private void e() {
        HandlerThread r0 = new HandlerThread("CaeMultipathConnectThread");
        this.f18727c = r0;
        r0.start();
        final Looper r1 = this.f18727c.getLooper();
        this.f18728d = new CaeMultipathClient$1(this, r1);
    }

    private boolean f() {
        if (this.f18729e == false) goto L6;
        ILogDepend.Companion.d(TAG, "Already connecting, skipping");
        return false;
    L6:
        this.f18729e = true;
        IBinder r3 = a("cae_multipath");     // Catch: Throwable -> L25 Exception -> L27
        if (r3 != null) goto L12;
        ILogDepend.Companion.e(TAG, "Failed to get cae_multipath service binder");     // Catch: Throwable -> L25 Exception -> L27
        g();     // Catch: Throwable -> L25 Exception -> L27
        this.f18729e = false;
        return false;
    L12:
        ICaeMultipathManager r4 = ICaeMultipathManager.Stub.asInterface(r3);     // Catch: Throwable -> L25 Exception -> L27
        this.f18725a = r4;     // Catch: Throwable -> L25 Exception -> L27
        if (r4 != null) goto L17;
        ILogDepend.Companion.e(TAG, "Failed to create service interface");     // Catch: Throwable -> L25 Exception -> L27
        g();     // Catch: Throwable -> L25 Exception -> L27
        this.f18729e = false;
        return false;
    L17:
        this.f18726b = r3;     // Catch: Throwable -> L25 Exception -> L27
        r3.linkToDeath(new CaeMultipathClient$2(this), 0);     // Catch: RemoteException -> L20 Throwable -> L25 Exception -> L27
    L22:
        ILogDepend.Companion.d(TAG, "Connected to cae_multipath service");     // Catch: Throwable -> L25 Exception -> L27
        this.f18729e = false;
        return true;
    L20:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to link to death", e);     // Catch: Throwable -> L25 Exception -> L27
    L27:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L25
        g();     // Catch: Throwable -> L25
        this.f18729e = false;
        return false;
    L25:
        th = move-exception;
        this.f18729e = false;
        throw th;
    }

    private void g() {
        this.f18728d.sendEmptyMessageDelayed(2, 10000);
    }

    private void h() {
        this.f18725a = null;
        this.f18726b = null;
        this.f18728d.sendEmptyMessage(1);
    }

    private boolean i() {
        if (this.f18725a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public NetworkStateInfo b() {
        ILogDepend.Companion.i(TAG, "getLatestNetworkTruth");
        String r0 = c();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return null;
    L10:
        return (NetworkStateInfo) ZeusTransformUtils.preCheckCast(this.h.fromJson(r0, NetworkStateInfo.class), NetworkStateInfo.class, "com.obric.aiagent.plugin");
    L7:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getLatestNetworkTruth Error", e);
        return null;
    }

    public String c() {
        ILogDepend.Companion.i(TAG, "getLatestNetworkTruthStr");
        if (i() == true) goto L11;
        ILogDepend.Companion.e(TAG, "Service not connected, triggering background reconnect");
        this.f18728d.sendEmptyMessage(1);
        return null;
    L11:
        return this.f18725a.getLatestNetworkTruth();
    L8:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to get latest network truth", e);
        h();
        return null;
    }

    public boolean d() {
        ILogDepend.Companion.i(TAG, "reportAssistantFailure");
        if (i() == true) goto L11;
        ILogDepend.Companion.e(TAG, "Service not connected, triggering background reconnect");
        this.f18728d.sendEmptyMessage(1);
        return false;
    L11:
        this.f18725a.reportAssistantFailure();     // Catch: Exception -> L8
        ILogDepend.Companion.i(TAG, "Success to report assistant failure");     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to report assistant failure", e);
        h();
        return false;
    }

    public boolean a(int[] r5) {
        ILogDepend.Companion.i(TAG, "reportAssistantOperateApps");
        if (r5 != null) goto L5;
    L16:
        ILogDepend.Companion.w(TAG, "reportAssistantOperateApps: empty apps");
        return false;
    L5:
        if (r5.length == 0) goto L16;
        if (i() == true) goto L18;
        ILogDepend.Companion.e(TAG, "Service not connected, triggering background reconnect");
        this.f18728d.sendEmptyMessage(1);
        return false;
    L18:
        this.f18725a.reportAssistantOperateApps(r5);     // Catch: Exception -> L13
        ILogDepend.Companion.i(TAG, "Success to report assistant failure");     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to report assistant failure", e);
        h();
        return false;
    }

    private IBinder a(String r8) {
        Object r9 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{r8});     // Catch: Exception -> L7
        if (ZeusTransformUtils.instanceOf(r9, IBinder.class) == false) goto L9;
        return (IBinder) ZeusTransformUtils.preCheckCast(r9, IBinder.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    L7:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to get service binder using reflection", e);
        goto L9
    }
}
