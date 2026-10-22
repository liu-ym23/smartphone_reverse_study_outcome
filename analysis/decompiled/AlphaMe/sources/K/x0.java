package K;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public class x0 {

    /* renamed from: b, reason: collision with root package name */
    public static final z0 f1015b = new q0().b().f1023a.a().f1023a.b().f1023a.c();

    /* renamed from: a, reason: collision with root package name */
    public final z0 f1016a;

    public x0(@NonNull z0 z0Var) {
        this.f1016a = z0Var;
    }

    @NonNull
    public z0 a() {
        return this.f1016a;
    }

    @NonNull
    public z0 b() {
        return this.f1016a;
    }

    @NonNull
    public z0 c() {
        return this.f1016a;
    }

    public void d(@NonNull View view) {
    }

    @Nullable
    public C0075g e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return k() == x0Var.k() && j() == x0Var.j() && Objects.equals(h(), x0Var.h()) && Objects.equals(g(), x0Var.g()) && Objects.equals(e(), x0Var.e());
    }

    @NonNull
    public D.c f(int i4) {
        return D.c.f356e;
    }

    @NonNull
    public D.c g() {
        return D.c.f356e;
    }

    @NonNull
    public D.c h() {
        return D.c.f356e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(k()), Boolean.valueOf(j()), h(), g(), e());
    }

    @NonNull
    public z0 i(int i4, int i5, int i6, int i7) {
        return f1015b;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public void l(D.c[] cVarArr) {
    }

    public void m(@Nullable z0 z0Var) {
    }
}
