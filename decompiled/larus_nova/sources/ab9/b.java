package ab9;

import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.larus.bmhome.utils.c4;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.api.v;
import com.larus.gallery.api.w;
import com.larus.gallery.api.z;
import com.larus.platform.service.o;
import com.larus.utils.o0;
import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;
import org.json.JSONObject;
import tx9.a4;
import uo8.l;

/* JADX INFO: loaded from: classes29.dex */
public abstract class b<T> extends t<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0046b f2508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f2509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f2510m;

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T> f2511a;

        @Override // com.larus.gallery.api.v
        public final void a() {
            o.f365780a.reportEvent(PinchEnterMethod.PINCH, this.f2511a.y());
        }

        public a(b<T> r100) {
            this.f2511a = r100;
        }
    }

    /* JADX INFO: renamed from: ab9.b$b, reason: collision with other inner class name */
    public static final class C0046b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T> f2512a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            b<T> r100 = this.f2512a;
            r100.f2506i = "";
            r100.B("enter_background", System.currentTimeMillis() - this.f2512a.f2503f);
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            b<T> r100 = this.f2512a;
            r100.A(r100.f2504g, "enter_foreground", "");
            b<T> r101 = this.f2512a;
            r101.f2503f = System.currentTimeMillis();
        }

        public C0046b(b<T> r100) {
            this.f2512a = r100;
        }
    }

    public static final class c implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T> f2513a;

        public c(b<T> r100) {
            this.f2513a = r100;
        }

        public final void a(g r100, String r101) {
            if (this.f2513a.f2507j == true) goto L23;
            JSONObject r102 = new JSONObject();
            if (r101 == null) goto L7;
        L10:
            r102.put("play_source_type", r101);
            String r103 = r100.f520257a;
            c4 r104 = this.f2513a.z();
            String r105 = null;
            if (r104 == null) goto L13;
            String r106 = r104.f314985b;
        L14:
            c4 r107 = this.f2513a.z();
            if (r107 == null) goto L17;
            String r108 = r107.f314984a;
        L18:
            c4 r109 = this.f2513a.z();
            if (r109 == null) goto L21;
            r105 = r109.f314986c;
        L21:
            a4.g(r103, r106, r108, r105, r102);
            this.f2513a.f2507j = true;
            return;
        L17:
            r108 = null;
            goto L18
        L13:
            r106 = null;
            goto L14
        L7:
            if (o0.d(r100.f520259c) == false) goto L9;
            r101 = "direct_url";
            goto L10
        L9:
            r101 = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
            goto L10
        }

        @Override // com.larus.gallery.api.z
        public final void b(g r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            a(r100, r101);
        }

        @Override // com.larus.gallery.api.z
        public final void c(g r110, boolean r210) {
            Intrinsics.checkNotNullParameter(r110, "data");
            b<T> r100 = this.f2513a;
            r100.f2507j = false;
            String r101 = r110.f520257a;
            c4 r102 = r100.z();
            if (r102 == null) goto L5;
            String r103 = r102.f314985b;
        L6:
            c4 r104 = this.f2513a.z();
            if (r104 == null) goto L9;
            String r105 = r104.f314984a;
        L10:
            Boolean r106 = Boolean.valueOf(r210);
            c4 r107 = this.f2513a.z();
            if (r107 == null) goto L13;
            String r108 = r107.f314986c;
        L14:
            c4 r109 = this.f2513a.z();
            if (r109 == null) goto L17;
            String r111 = r109.f314990g;
        L18:
            c4 r112 = this.f2513a.z();
            if (r112 == null) goto L21;
            String r113 = r112.f314993j;
        L22:
            c4 r114 = this.f2513a.z();
            if (r114 == null) goto L25;
            Integer r115 = r114.f314992i;
        L26:
            c4 r116 = this.f2513a.z();
            if (r116 == null) goto L29;
            String r117 = r116.f314991h;
        L30:
            a4.f(r101, r103, r105, r106, r108, r111, r113, r115, r117, "video_detail", null, null, null, 16776192);
            return;
        L29:
            r117 = null;
            goto L30
        L25:
            r115 = null;
            goto L26
        L21:
            r113 = null;
            goto L22
        L17:
            r111 = null;
            goto L18
        L13:
            r108 = null;
            goto L14
        L9:
            r105 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.larus.gallery.api.z
        public final void d(g r110, long r111, boolean r210) {
            Intrinsics.checkNotNullParameter(r110, "data");
            String r100 = r110.f520257a;
            c4 r101 = this.f2513a.z();
            if (r101 == null) goto L5;
            String r102 = r101.f314985b;
        L6:
            c4 r103 = this.f2513a.z();
            if (r103 == null) goto L9;
            String r104 = r103.f314984a;
        L10:
            Boolean r105 = Boolean.valueOf(x19.a.f562148a);
            c4 r106 = this.f2513a.z();
            if (r106 == null) goto L13;
            String r107 = r106.f314986c;
        L14:
            Long r108 = Long.valueOf(r111);
            Boolean r109 = Boolean.valueOf(r210);
            c4 r112 = this.f2513a.z();
            if (r112 == null) goto L17;
            String r113 = r112.f314990g;
        L18:
            c4 r114 = this.f2513a.z();
            if (r114 == null) goto L21;
            String r115 = r114.f314991h;
        L22:
            a4.m(r100, r102, r104, r105, r107, r108, r109, r113, "video_detail", r115, null, null, null, 16776192);
            return;
        L21:
            r115 = null;
            goto L22
        L17:
            r113 = null;
            goto L18
        L13:
            r107 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    public abstract void A(int r100, String r101, String r102);

    public abstract JSONObject y();

    public c4 z() {
        return null;
    }

    @Override // com.larus.gallery.api.t
    public final void t() {
        w r100 = this.f343899e;
        if (r100 == null) goto L5;
        r100.Oi(this.f2509l);
    L5:
        w r101 = this.f343899e;
        if (r101 == null) goto L8;
        r101.xm(this.f2510m);
    L8:
        AppHost.f326268a.a().j(this.f2508k);
    }

    public b() {
        this.f2504g = -1;
        this.f2505h = true;
        this.f2506i = "click";
        this.f2508k = new C0046b(this);
        this.f2509l = new a(this);
        this.f2510m = new c(this);
    }

    @Override // com.larus.gallery.api.t
    public final void u() {
        B("close_picture_detail", System.currentTimeMillis() - this.f2503f);
        l.c();
        w r100 = this.f343899e;
        if (r100 == null) goto L5;
        r100.jE(this.f2509l);
    L5:
        w r101 = this.f343899e;
        if (r101 == null) goto L8;
        r101.bC(this.f2510m);
    L8:
        AppHost.f326268a.a().c(this.f2508k);
    }

    @Override // com.larus.gallery.api.t
    public final void x(p r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof p.f) == false) goto L6;
        this.f2506i = ((p.f) r100).f343881a;
        return;
    }

    public final void B(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveReason");
        o r102 = o.f365780a;
        JSONObject r103 = y();
        if (r103 == null) goto L5;
        r103.put("leave_reason", r100);
        r103.put("duration", r101);
        Unit r104 = Unit.INSTANCE;
    L6:
        r102.reportEvent("leave_picture_detail", r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.gallery.api.t
    public final void w(T r100, final int r101) {
        this.f343898d = r100;
        if (this.f2505h == false) goto L6;
        this.f2505h = false;
        t0.f375468a.postDelayed(new ab9.a(this, r101), 300);
    L22:
        this.f2503f = System.currentTimeMillis();
        this.f2504g = r101;
        return;
    L6:
        if (Intrinsics.areEqual(this.f2506i, "click") == true) goto L22;
        int r102 = this.f2504g;
        if (r101 <= r102) goto L10;
        String r103 = "left";
    L11:
        if (r101 <= r102) goto L13;
        String r104 = "slide_next";
    L14:
        A(r101, this.f2506i, r103);
        if (this.f2504g == r101) goto L17;
        B(r104, System.currentTimeMillis() - this.f2503f);
    L17:
        o r105 = o.f365780a;
        JSONObject r106 = y();
        if (r106 == null) goto L20;
        r106.put("status", r103);
        Unit r107 = Unit.INSTANCE;
    L21:
        r105.reportEvent("slide", r106);
        goto L22
    L20:
        r106 = null;
        goto L21
    L13:
        r104 = "slide_previous";
        goto L14
    L10:
        r103 = "right";
        goto L11
    }
}
