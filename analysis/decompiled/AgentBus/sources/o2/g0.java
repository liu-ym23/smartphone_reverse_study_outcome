package o2;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f7233a;

    static {
        int i2 = Build.VERSION.SDK_INT;
        (i2 >= 36 ? new w() : i2 >= 35 ? new v() : i2 >= 34 ? new u() : i2 >= 31 ? new t() : new s()).g().f7236a.a().f7236a.b().f7236a.c();
    }

    public g0(j0 j0Var) {
        this.f7233a = j0Var;
    }

    public j0 a() {
        return this.f7233a;
    }

    public j0 b() {
        return this.f7233a;
    }

    public j0 c() {
        return this.f7233a;
    }

    public void d(View view) {
    }

    public List<Rect> e(int i2) {
        return Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return o() == g0Var.o() && n() == g0Var.n() && Objects.equals(k(), g0Var.k()) && Objects.equals(j(), g0Var.j()) && Objects.equals(g(), g0Var.g());
    }

    public List<Rect> f(int i2) {
        return Collections.EMPTY_LIST;
    }

    public c g() {
        return null;
    }

    public k2.a h(int i2) {
        return k2.a.f5574e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), j(), g());
    }

    public k2.a i(int i2) {
        if ((i2 & 8) == 0) {
            return k2.a.f5574e;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    public k2.a j() {
        return k2.a.f5574e;
    }

    public k2.a k() {
        return k2.a.f5574e;
    }

    public void l(View view) {
    }

    public void m() {
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public boolean p(int i2) {
        return true;
    }

    public void q(e eVar) {
    }

    public void r(k2.a[] aVarArr) {
    }

    public void s(j0 j0Var) {
    }

    public void t(int i2) {
    }

    public void u(Rect[][] rectArr) {
    }

    public void v(Rect[][] rectArr) {
    }
}
