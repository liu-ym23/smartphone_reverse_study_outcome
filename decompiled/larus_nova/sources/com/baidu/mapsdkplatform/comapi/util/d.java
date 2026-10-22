package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f32300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f32301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f32302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<IAdvPermissionUpdateListener> f32303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f32306g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32308b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_util_d$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapsdkplatform_comapi_util_d$a__run$___twin___() {
            d.a(d.a(this.f32308b).getSharedPreferences("ad_auth", 0).getInt(this.f32307a, 0));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_util_d$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mapsdkplatform_comapi_util_d$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, String r101) {
            this.f32308b = r100;
            this.f32307a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32310b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_util_d$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapsdkplatform_comapi_util_d$b__run$___twin___() {
            d.b(d.a(this.f32310b).getSharedPreferences("ad_auth", 0).getInt(this.f32309a, 0));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_util_d$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_baidu_mapsdkplatform_comapi_util_d$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r100, String r101) {
            this.f32310b = r100;
            this.f32309a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f32313c;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_util_d$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapsdkplatform_comapi_util_d$c__run$___twin___() {
            d.a(this.f32313c).getSharedPreferences("ad_auth", 0).edit().putInt(this.f32311a, this.f32312b).apply();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_util_d$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_baidu_mapsdkplatform_comapi_util_d$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(d r100, String r101, int r102) {
            this.f32313c = r100;
            this.f32311a = r101;
            this.f32312b = r102;
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.util.d$d, reason: collision with other inner class name */
    public class RunnableC0649d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f32316c;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_util_d$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapsdkplatform_comapi_util_d$d__run$___twin___() {
            d.a(this.f32316c).getSharedPreferences("ad_auth", 0).edit().putInt(this.f32314a, this.f32315b).apply();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_util_d$d_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0649d r100) {
            r100.com_baidu_mapsdkplatform_comapi_util_d$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0649d(d r100, String r101, int r102) {
            this.f32316c = r100;
            this.f32314a = r101;
            this.f32315b = r102;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f32317a = null;

        static {
            f32317a = new d(null);
        }

        public static /* synthetic */ d a() {
            return f32317a;
        }
    }

    static {
        f32300a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("comapi/util/d"));
        f32301b = -1;
        f32302c = -1;
    }

    private void k() {
        List<IAdvPermissionUpdateListener> r100 = this.f32303d;
        monitor-enter(r100);
        int r101 = 0;
    L13:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r101 >= this.f32303d.size()) goto L8;
        this.f32303d.get(r101).onAdvPermissionUpdate(this.f32304e);     // Catch: Throwable -> L10
        r101 = r101 + 1;     // Catch: Throwable -> L10
        goto L13
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
    }

    public boolean c() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 33554432) != 33554432) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean d() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 67108864) != 67108864) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean e() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 134217728) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean f() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 65536) != 65536) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean g() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 1073741824) != 1073741824) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean h() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 1) != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean i() {
        int r100 = this.f32305f;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 268435456) != 268435456) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean j() {
        int r100 = this.f32304e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if ((r100 & 1024) != 1024) goto L11;
        return true;
    L11:
        return false;
    }

    private d() {
        this.f32303d = new CopyOnWriteArrayList();
        this.f32304e = -1;
    }

    public static d b() {
        return e.a();
    }

    public int a() {
        return this.f32304e;
    }

    public /* synthetic */ d(a r100) {
        this();
    }

    private int a(String r100) {
        if (this.f32306g != null) goto L7;
        return -101;
    L7:
        if (f32301b != (-1)) goto L10;
        f32300a.execute(new a(this, r100));
    L10:
        return f32301b;
    }

    private int b(String r100) {
        if (this.f32306g != null) goto L7;
        return -101;
    L7:
        if (f32302c != (-1)) goto L10;
        f32300a.execute(new b(this, r100));
    L10:
        return f32302c;
    }

    public void c(int r100) {
        if (r100 != (-1)) goto L7;
        r100 = a("ad_key");
        if (r100 != (-101)) goto L7;
        return;
    L7:
        this.f32304e = r100;
        a("ad_key", r100);
        k();
    }

    public void d(int r100) {
        if (r100 != (-1)) goto L7;
        r100 = b("ad_key_user");
        if (r100 != (-101)) goto L7;
        return;
    L7:
        this.f32305f = r100;
        b("ad_key_user", r100);
    }

    public static /* synthetic */ int a(int r100) {
        f32301b = r100;
        return r100;
    }

    public static /* synthetic */ int b(int r100) {
        f32302c = r100;
        return r100;
    }

    public static /* synthetic */ Context a(d r100) {
        return r100.f32306g;
    }

    public void a(Context r100) {
        this.f32306g = r100;
    }

    private void a(String r100, int r101) {
        if (this.f32306g != null) goto L5;
        return;
    L5:
        f32301b = r101;
        f32300a.execute(new c(this, r100, r101));
    }

    private void b(String r100, int r101) {
        if (this.f32306g != null) goto L5;
        return;
    L5:
        f32302c = r101;
        f32300a.execute(new RunnableC0649d(this, r100, r101));
    }
}
