package stepos.support.v7.app;

import android.app.Activity;
import android.util.Log;
import androidx.dynamicanimation.animation.e;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes5.dex */
public final class o {

    /* renamed from: g, reason: collision with root package name */
    public static o f40553g = null;

    /* renamed from: h, reason: collision with root package name */
    public static float f40554h = 0.88f;

    /* renamed from: i, reason: collision with root package name */
    public static float f40555i = 340.0f;

    /* renamed from: j, reason: collision with root package name */
    public static float f40556j = 0.93f;

    /* renamed from: k, reason: collision with root package name */
    public static float f40557k = 400.0f;

    /* renamed from: a, reason: collision with root package name */
    public Activity f40558a;

    /* renamed from: b, reason: collision with root package name */
    public PopupNestedScrollingLayout f40559b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.i f40560c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.i f40561d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40562e;

    /* renamed from: f, reason: collision with root package name */
    public int f40563f = -1;

    public class a implements e.r {
        public a() {
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            o.this.f40559b.n((int) f10);
        }
    }

    public class b implements e.r {
        public b() {
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            float f12 = f10 / 100.0f;
            o.this.f40559b.setScaleX(f12);
            o.this.f40559b.setScaleY(f12);
        }
    }

    public o() {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g());
        this.f40560c = iVar;
        iVar.c(new a());
        androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g());
        this.f40561d = iVar2;
        iVar2.c(new b());
    }

    public static o f() {
        if (f40553g == null) {
            f40553g = new o();
        }
        return f40553g;
    }

    public void b() {
        if (g()) {
            Log.d("popup_stack", " bottom stack pause , enter stack state ");
            int iA = (int) O6.s.a(10.0f, this.f40558a);
            if (this.f40559b.getPositionState() == 0) {
                iA = (int) O6.s.a(40.0f, this.f40558a);
            }
            this.f40560c.B(new androidx.dynamicanimation.animation.j().f(f40554h).h(f40555i));
            this.f40560c.q(this.f40559b.getCurrentScrollY());
            this.f40560c.y().g(this.f40559b.getCurrentScrollY() + iA);
            this.f40560c.t();
            this.f40561d.B(new androidx.dynamicanimation.animation.j().f(f40554h).h(f40555i));
            this.f40561d.q(100.0f);
            this.f40561d.y().g(93.0f);
            this.f40561d.t();
            this.f40562e = true;
        }
    }

    public void c() {
        if (!this.f40562e || !g()) {
            Log.e("popup_stack", "  call bottom stack do stackExit , but state error, return ");
            return;
        }
        Log.d("popup_stack", " bottom stack exit success!! ");
        int i10 = -((int) O6.s.a(10.0f, this.f40558a));
        if (this.f40559b.getPositionState() == 0) {
            i10 = -((int) O6.s.a(35.0f, this.f40558a));
        }
        this.f40560c.B(new androidx.dynamicanimation.animation.j().f(f40556j).h(f40557k));
        this.f40560c.q(this.f40559b.getCurrentScrollY());
        this.f40560c.y().g(this.f40559b.getCurrentScrollY() + i10);
        this.f40560c.t();
        this.f40561d.B(new androidx.dynamicanimation.animation.j().f(f40556j).h(f40557k));
        this.f40561d.q(93.0f);
        this.f40561d.y().g(100.0f);
        this.f40561d.t();
        this.f40562e = false;
    }

    public void d() {
        if (this.f40562e) {
            Log.e("popup_stack", " bottom stack resume, but still in stack, call exit ");
            c();
        }
        this.f40562e = false;
    }

    public Activity e() {
        return this.f40558a;
    }

    public final boolean g() {
        if (this.f40558a != null) {
            return this.f40559b.getPositionState() == this.f40563f || this.f40559b.getPositionState() == 1;
        }
        return false;
    }

    public void h() {
        f40553g = null;
    }
}
