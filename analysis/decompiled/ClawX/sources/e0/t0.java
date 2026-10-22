package e0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class t0 {

    /* renamed from: b, reason: collision with root package name */
    public static final x0 f2335b;

    /* renamed from: a, reason: collision with root package name */
    public final x0 f2336a;

    static {
        int i8 = Build.VERSION.SDK_INT;
        f2335b = (i8 >= 36 ? new i0() : i8 >= 35 ? new h0() : i8 >= 34 ? new g0() : new f0()).b().f2338a.a().f2338a.b().f2338a.c();
    }

    public t0(x0 x0Var) {
        this.f2336a = x0Var;
    }

    public x0 a() {
        return this.f2336a;
    }

    public x0 b() {
        return this.f2336a;
    }

    public x0 c() {
        return this.f2336a;
    }

    public List<Rect> e(int i8) {
        return Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return o() == t0Var.o() && n() == t0Var.n() && Objects.equals(j(), t0Var.j()) && Objects.equals(i(), t0Var.i()) && Objects.equals(g(), t0Var.g());
    }

    public List<Rect> f(int i8) {
        return Collections.EMPTY_LIST;
    }

    public d g() {
        return null;
    }

    public x.b h(int i8) {
        return x.b.f6231e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(o()), Boolean.valueOf(n()), j(), i(), g());
    }

    public x.b i() {
        return x.b.f6231e;
    }

    public x.b j() {
        return x.b.f6231e;
    }

    public x0 m(int i8, int i9, int i10, int i11) {
        return f2335b;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public void l() {
    }

    public void d(View view) {
    }

    public void k(View view) {
    }

    public void p(f fVar) {
    }

    public void q(x.b[] bVarArr) {
    }

    public void r(x0 x0Var) {
    }

    public void s(int i8) {
    }

    public void t(Rect[][] rectArr) {
    }

    public void u(Rect[][] rectArr) {
    }
}
