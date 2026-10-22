package n3;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class j1 {

    /* renamed from: b, reason: collision with root package name */
    public static final m1 f8720b;

    /* renamed from: a, reason: collision with root package name */
    public final m1 f8721a;

    static {
        int i = Build.VERSION.SDK_INT;
        f8720b = (i >= 36 ? new z0() : i >= 35 ? new y0() : i >= 34 ? new x0() : new w0()).b().f8737a.a().f8737a.b().f8737a.c();
    }

    public j1(m1 m1Var) {
        this.f8721a = m1Var;
    }

    public m1 a() {
        return this.f8721a;
    }

    public m1 b() {
        return this.f8721a;
    }

    public m1 c() {
        return this.f8721a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return t() == j1Var.t() && s() == j1Var.s() && Objects.equals(n(), j1Var.n()) && Objects.equals(l(), j1Var.l()) && Objects.equals(h(), j1Var.h());
    }

    public List<Rect> f(int i) {
        return Collections.EMPTY_LIST;
    }

    public List<Rect> g(int i) {
        return Collections.EMPTY_LIST;
    }

    public f h() {
        return null;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(t()), Boolean.valueOf(s()), n(), l(), h());
    }

    public f3.b i(int i) {
        return f3.b.f3899e;
    }

    public f3.b j(int i) {
        if ((i & 8) == 0) {
            return f3.b.f3899e;
        }
        g5.f.s("Unable to query the maximum insets for IME");
        return null;
    }

    public f3.b k() {
        return n();
    }

    public f3.b l() {
        return f3.b.f3899e;
    }

    public f3.b m() {
        return n();
    }

    public f3.b n() {
        return f3.b.f3899e;
    }

    public f3.b o() {
        return n();
    }

    public m1 r(int i, int i3, int i10, int i11) {
        return f8720b;
    }

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public boolean u(int i) {
        return true;
    }

    public void q() {
    }

    public void A(Rect[][] rectArr) {
    }

    public void B(Rect[][] rectArr) {
    }

    public void d(View view) {
    }

    public void e(m1 m1Var) {
    }

    public void p(View view) {
    }

    public void v(h hVar) {
    }

    public void w(f3.b[] bVarArr) {
    }

    public void x(f3.b bVar) {
    }

    public void y(m1 m1Var) {
    }

    public void z(int i) {
    }
}
