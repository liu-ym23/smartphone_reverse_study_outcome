package stepos.support.v7.app;

import P.e;
import android.app.Activity;
import android.util.Log;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes.dex */
final class p {

    /* renamed from: g, reason: collision with root package name */
    private static p f20877g = null;

    /* renamed from: h, reason: collision with root package name */
    public static float f20878h = 0.88f;

    /* renamed from: i, reason: collision with root package name */
    public static float f20879i = 340.0f;

    /* renamed from: j, reason: collision with root package name */
    public static float f20880j = 0.93f;

    /* renamed from: k, reason: collision with root package name */
    public static float f20881k = 400.0f;

    /* renamed from: a, reason: collision with root package name */
    private Activity f20882a;

    /* renamed from: b, reason: collision with root package name */
    private PopupNestedScrollingLayout f20883b;

    /* renamed from: c, reason: collision with root package name */
    private final P.i f20884c;

    /* renamed from: d, reason: collision with root package name */
    private final P.i f20885d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f20886e;

    /* renamed from: f, reason: collision with root package name */
    private int f20887f = -1;

    class a implements e.r {
        a() {
        }

        @Override // P.e.r
        public void a(P.e eVar, float f5, float f6) {
            p.this.f20883b.t((int) f5);
        }
    }

    class b implements e.r {
        b() {
        }

        @Override // P.e.r
        public void a(P.e eVar, float f5, float f6) {
            float f7 = f5 / 100.0f;
            p.this.f20883b.setScaleX(f7);
            p.this.f20883b.setScaleY(f7);
        }
    }

    private p() {
        P.i iVar = new P.i(new P.g());
        this.f20884c = iVar;
        iVar.c(new a());
        P.i iVar2 = new P.i(new P.g());
        this.f20885d = iVar2;
        iVar2.c(new b());
    }

    public static p f() {
        if (f20877g == null) {
            f20877g = new p();
        }
        return f20877g;
    }

    private boolean g() {
        if (this.f20882a != null) {
            return this.f20883b.getPositionState() == this.f20887f || this.f20883b.getPositionState() == 1;
        }
        return false;
    }

    public void b() {
        if (g()) {
            Log.d("popup_stack", " bottom stack pause , enter stack state ");
            int iA = (int) N1.i.a(10.0f, this.f20882a);
            if (this.f20883b.getPositionState() == 0) {
                iA = (int) N1.i.a(40.0f, this.f20882a);
            }
            this.f20884c.x(new P.j().f(f20878h).h(f20879i));
            this.f20884c.m(this.f20883b.getCurrentScrollY());
            this.f20884c.u().g(this.f20883b.getCurrentScrollY() + iA);
            this.f20884c.p();
            this.f20885d.x(new P.j().f(f20878h).h(f20879i));
            this.f20885d.m(100.0f);
            this.f20885d.u().g(93.0f);
            this.f20885d.p();
            this.f20886e = true;
        }
    }

    public void c() {
        if (!this.f20886e || !g()) {
            Log.e("popup_stack", "  call bottom stack do stackExit , but state error, return ");
            return;
        }
        Log.d("popup_stack", " bottom stack exit success!! ");
        int i5 = -((int) N1.i.a(10.0f, this.f20882a));
        if (this.f20883b.getPositionState() == 0) {
            i5 = -((int) N1.i.a(35.0f, this.f20882a));
        }
        this.f20884c.x(new P.j().f(f20880j).h(f20881k));
        this.f20884c.m(this.f20883b.getCurrentScrollY());
        this.f20884c.u().g(this.f20883b.getCurrentScrollY() + i5);
        this.f20884c.p();
        this.f20885d.x(new P.j().f(f20880j).h(f20881k));
        this.f20885d.m(93.0f);
        this.f20885d.u().g(100.0f);
        this.f20885d.p();
        this.f20886e = false;
    }

    public void d() {
        if (this.f20886e) {
            Log.e("popup_stack", " bottom stack resume, but still in stack, call exit ");
            c();
        }
        this.f20886e = false;
    }

    public Activity e() {
        return this.f20882a;
    }

    public void h() {
        f20877g = null;
    }
}
