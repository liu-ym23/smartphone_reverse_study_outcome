package com.obric.memorydata.sdk.service;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.memorydata.sdk.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MemoryDataServiceProxy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemoryDataServiceProxy {
    private static final String TAG = "MemoryDataServiceProxy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryDataServiceProxy f33905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile IMemoryDataService f33906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f33907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f33908d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f33909e;
    private static volatile int f;
    private static final Runnable g = null;
    private static final ConcurrentHashMap<Integer, a> h = null;
    private static final MemoryDataServiceProxy$deathRecipient$1 i = null;
    private static final ServiceConnection j = null;

    /* JADX INFO: compiled from: MemoryDataServiceProxy.kt */
    private static final class ServiceProxy implements IMemoryDataService {
        private final IMemoryDataService service;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public ServiceProxy(IMemoryDataService r3) {
            IMemoryDataService r4 = (IMemoryDataService) ZeusTransformUtils.wrapperContextForParams(r3, IMemoryDataService.class, "com.obric.aiagent.plugin");
            o.e(r4, WsConstants.KEY_SERVICE);
            this.service = r4;
        }

        public final IMemoryDataService getService() {
            return this.service;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryDataServiceProxy.TAG, "asBinder error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        @Override // com.obric.memorydata.sdk.service.IMemoryDataService
        public IBinder queryBinder(int r2) {
            return this.service.queryBinder(r2);
        L4:
            e = move-exception;
            INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MemoryDataServiceProxy.TAG, "queryBinder error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$ServiceProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: MemoryDataServiceProxy.kt */
    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: lambda$ByY8y8XhQTJJmTCWd-GYyufyi90, reason: not valid java name */
    public static /* synthetic */ void m963lambda$ByY8y8XhQTJJmTCWdGYyufyi90() {
        k();
    }

    public static /* synthetic */ boolean lambda$WhdOmsTUKl03RzkBu6Ta8DejbME(Context r0, int r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$c-7VuDtHbz1hJtpqOD46MVZu0bU, reason: not valid java name */
    public static /* synthetic */ Object m964lambda$c7VuDtHbz1hJtpqOD46MVZu0bU() {
        return l();
    }

    public static /* synthetic */ x lambda$wuPDamqGjYC2ZEEMsAkZC1WrapM() {
        return j();
    }

    public final boolean bindService(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        return a(this, r5, 0, 2, null);
    }

    private MemoryDataServiceProxy() {
    }

    public static final /* synthetic */ void a(IMemoryDataService r2) {
        f33906b = (IMemoryDataService) ZeusTransformUtils.wrapperContextForParams(r2, IMemoryDataService.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(MemoryDataServiceProxy r0) {
        r0.i();
    }

    public static final /* synthetic */ void a(boolean r0) {
        f33909e = r0;
    }

    public static final /* synthetic */ IMemoryDataService b() {
        return f33906b;
    }

    public static final /* synthetic */ Handler c() {
        return f33908d;
    }

    public static final /* synthetic */ Runnable d() {
        return g;
    }

    public static final /* synthetic */ ConcurrentHashMap e() {
        return h;
    }

    public static final /* synthetic */ Context f() {
        return f33907c;
    }

    public static final /* synthetic */ ServiceConnection g() {
        return j;
    }

    public static final /* synthetic */ MemoryDataServiceProxy$deathRecipient$1 h() {
        return i;
    }

    static {
        f33905a = new MemoryDataServiceProxy();
        f33908d = new Handler(Looper.getMainLooper());
        f = 64;
        g = $$Lambda$MemoryDataServiceProxy$ByY8y8XhQTJJmTCWdGYyufyi90.INSTANCE;
        h = new ConcurrentHashMap();
        i = new MemoryDataServiceProxy$deathRecipient$1();
        j = (ServiceConnection) ZeusTransformUtils.preCheckCast(new MemoryDataServiceProxy$connection$1(), ServiceConnection.class, "com.obric.aiagent.plugin");
    }

    private static final void k() {
        MemoryDataServiceProxy r0 = f33905a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f33909e == true) goto L7;
    L9:
        x r1 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (f33906b != null) goto L9;
        b(TAG, "bindService timeout");     // Catch: Throwable -> L12
        f33909e = false;     // Catch: Throwable -> L12
        c.a($$Lambda$MemoryDataServiceProxy$wuPDamqGjYC2ZEEMsAkZC1WrapM.INSTANCE);     // Catch: Throwable -> L12
        goto L9
    }

    private static final x j() {
        Context r0 = f33907c;
        if (r0 == null) goto L5;
        ZeusTransformUtils.unbindService(r0, j, "com.obric.aiagent.plugin");
        return x.f38692a;
    L5:
        return null;
    }

    public static /* synthetic */ boolean a(MemoryDataServiceProxy r1, Context r2, int r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 64;
    L6:
        return r1.bindService(r6, r3);
    }

    public final boolean bindService(Context r2, final int r3) {
        final Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(c.a(new $$Lambda$MemoryDataServiceProxy$WhdOmsTUKl03RzkBu6Ta8DejbME(r1, r3)), Boolean.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.booleanValue();
    }

    private static final boolean b(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a(TAG, "bindService");
        if (f33906b == null) goto L7;
        b(TAG, "service already bound");
        return false;
    L7:
        if (f33909e == false) goto L10;
        b(TAG, "service binding in progress");
        return false;
    L10:
        MemoryDataServiceProxy r0 = f33905a;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L13:
        if (f33906b == null) goto L18;
        b(TAG, "service already bound");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return false;
    L18:
        if (f33909e == false) goto L22;
        b(TAG, "service binding in progress");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return false;
    L22:
        boolean r6 = r0.a(r5, r4);     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r6;
    }

    public final void unbindService() {
        c.a($$Lambda$MemoryDataServiceProxy$c7VuDtHbz1hJtpqOD46MVZu0bU.INSTANCE);
    }

    private static final Object l() {
        a(TAG, "unbindService");
        if (f33906b == null) goto L5;
    L8:
        MemoryDataServiceProxy r0 = f33905a;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L11:
        if (f33906b == null) goto L13;
    L14:
        Context r1 = f33907c;     // Catch: Throwable -> L22
        if (r1 == null) goto L17;
        ZeusTransformUtils.unbindService(r1, j, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
    L17:
        f33908d.removeCallbacks(g);     // Catch: Throwable -> L22
        f33906b = null;     // Catch: Throwable -> L22
        f33909e = false;     // Catch: Throwable -> L22
    L18:
        x r2 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return x.f38692a;
    L13:
        if (f33909e == false) goto L18;
    L5:
        if (f33909e == true) goto L8;
        return Integer.valueOf(b(TAG, "service already unbound"));
    }

    private final void i() {
        a(TAG, "rebindService");
        Context r2 = f33907c;
        if (r2 == null) goto L6;
        f33905a.bindService(r2, f);
        return;
    }

    private final boolean a(Context r7, int r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        a(TAG, "bindServiceReal");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f33907c = r9;
        f = r8;
        f33909e = true;
        Handler r2 = f33908d;
        Runnable r3 = g;
        r2.removeCallbacks(r3);
        r2.postDelayed(r3, 12000);
        Intent r4 = new Intent();
        r4.setAction(com.obric.memorydata.sdk.BuildConfig.LIBRARY_PACKAGE_NAME);
        r4.setPackage("com.larus.nova");
        boolean r10 = ZeusTransformUtils.bindService(r9, r4, j, r8 | 1, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
    L7:
        a(TAG, "bindService: " + r10);
        if (r10 == true) goto L10;
        f33908d.removeCallbacks(g);
        f33909e = false;
    L10:
        return r10;
    L5:
        e = move-exception;
        a(TAG, "bindServiceReal error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r10 = false;
        goto L7
    }

    public final IMemoryDataService a() {
        a(TAG, "getService");
        if (f33906b == null) goto L5;
    L22:
        StringBuilder r0 = new StringBuilder().append("getService: remoteService=");
        if (f33906b == null) goto L25;
        boolean r1 = true;
    L26:
        b(TAG, r0.append(r1).append(", isBinding=").append(f33909e).toString());
    L28:
        return f33906b;
    L25:
        r1 = false;
        goto L26
    L5:
        if (f33909e == true) goto L22;
        b(TAG, "getService: remoteService is null and not binding");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L9:
        if (f33906b == null) goto L11;
    L16:
        x r2 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(this);
        goto L28
    L11:
        if (f33909e == true) goto L16;
        Context r3 = f33907c;     // Catch: Throwable -> L19
        if (r3 == null) goto L15;
        f33905a.a(r3, f);     // Catch: Throwable -> L19
        goto L16
    L15:
        c(TAG, "context is null, cannot rebind service");     // Catch: Throwable -> L19
        goto L16
    }

    public final void a(int r3, a r4) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r2, "listener");
        Integer r5 = Integer.valueOf(r3);
        ((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.aiagent.plugin")).put(r5, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
