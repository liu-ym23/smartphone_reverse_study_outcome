package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import com.baidu.bbalbscesium.d;
import com.baidu.bbalbscesium.f;
import com.baidu.bbalbscesium.g;
import com.baidu.bbalbscesium.h;
import com.baidu.bbalbscesium.o.c;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class DeviceId {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f30039h = "DeviceId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f30040i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static h.a f30041j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile DeviceId f30042k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f30043l = 3600000;
    public static boolean sDataCuidInfoShable = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f30044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f30045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f30046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f30047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.a f30048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h.a f30049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f30050g;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a f30051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DeviceId f30052b;

        public a(DeviceId r100, h.a r101) {
            this.f30052b = r100;
            this.f30051a = r101;
        }

        public void com_baidu_android_bbalbs_common_util_DeviceId$a__run$___twin___() {
            DeviceId.a(this.f30052b, this.f30051a);     // Catch: Throwable -> L5
            DeviceId.a(this.f30052b).c();
            return;
        L5:
            th = move-exception;
            DeviceId.a(this.f30052b).c();
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_android_bbalbs_common_util_DeviceId$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_android_bbalbs_common_util_DeviceId$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_android_bbalbs_common_util_DeviceId$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private DeviceId(Context r100) {
        Context r101 = r100.getApplicationContext();
        this.f30044a = r101;
        this.f30047d = new d();
        this.f30045b = new h(r101, new com.baidu.bbalbscesium.n.a(r101), this.f30047d);
        this.f30046c = new g(r101, this.f30047d);
    }

    public static DeviceId a(Context r100) {
        monitor-enter(f.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f30042k != null) goto L7;
        f30042k = new DeviceId(r100);     // Catch: Throwable -> L10
    L7:
        DeviceId r101 = f30042k;     // Catch: Throwable -> L10
        monitor-exit(f.class);     // Catch: Throwable -> L10
        return r101;
    }

    private h.a a() {
        h.a r100 = this.f30049f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        long r101 = System.currentTimeMillis();
        if (Math.abs(r101 - this.f30050g) <= 3600000) goto L8;
        this.f30049f = c();
        this.f30050g = r101;
    L8:
        h.a r102 = this.f30049f;
        if (r102 == null) goto L12;
        return r102;
    L12:
        if (this.f30048e != null) goto L15;
        this.f30049f = a(null);
    L15:
        return this.f30049f;
    }

    private h.a a(String r100) {
        return this.f30045b.c(r100);
    }

    public static /* synthetic */ h a(DeviceId r100) {
        return r100.f30045b;
    }

    private Runnable a(h.a r100) {
        return new a(this, r100);
    }

    public static /* synthetic */ void a(DeviceId r100, h.a r101) {
        r100.b(r101);
    }

    private h.a b(String r100) {
        f r101 = this.f30046c.b(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return this.f30045b.a(r101);
    }

    private void b(h.a r100) {
        if (r100 == null) goto L6;
        f r101 = r100.g();
        this.f30045b.a(r100, true, false);
        this.f30046c.a(r101);
        this.f30045b.a(r100);
        return;
    L6:
        throw new NullPointerException("cuidV270Info should not be null");
    }

    private h.a c() {
        return c(null);
    L5:
        th = move-exception;
        throw th;
    }

    private h.a c(String r100) {
        h.a r101 = this.f30045b.d();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return b(r100);
    }

    private synchronized void c(h.a r100) {
        monitor-enter(this);
        ThreadMethodProxy.start(new PthreadThreadV2(a(r100), "util/DeviceId"));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private h.a d() {
        h.a r100 = f();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return e();
    }

    private h.a e() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f30044a.getFilesDir(), f.f30074g);
        if (r100.exists() == false) goto L7;
        f r101 = f.a(c.a(r100));
        if (r101 == null) goto L7;
        return this.f30045b.a(r101);
    L7:
        return null;
    }

    private h.a f() {
        return this.f30045b.b();
    }

    public static String getCUID(Context r100) {
        monitor-enter(DeviceId.class);
        String r101 = a(r100).a().d();     // Catch: Throwable -> L7
        monitor-exit(DeviceId.class);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getDeviceID(Context r100) {
        return a(r100).a().b();
    }

    public static boolean isMySelfTrusted(Context r100) {
        return a(r100).f30047d.a(r100.getApplicationContext());
    }

    public static void setAndroidId(String r100) {
        h.d(r100);
    }

    public static void setCuidDataShable(Context r100, boolean r101) {
    }

    public h b() {
        return this.f30045b;
    }
}
