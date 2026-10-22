package K;

import android.view.WindowInsets;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class p0 extends r0 {

    /* renamed from: b, reason: collision with root package name */
    public final WindowInsets.Builder f998b;

    public p0() {
        this.f998b = new WindowInsets.Builder();
    }

    @Override // K.r0
    @NonNull
    public z0 b() {
        a();
        z0 z0VarF = z0.f(null, this.f998b.build());
        z0VarF.f1023a.l(null);
        return z0VarF;
    }

    @Override // K.r0
    public void c(@NonNull D.c cVar) {
        this.f998b.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // K.r0
    public void d(@NonNull D.c cVar) {
        this.f998b.setSystemGestureInsets(cVar.d());
    }

    @Override // K.r0
    public void e(@NonNull D.c cVar) {
        this.f998b.setSystemWindowInsets(cVar.d());
    }

    @Override // K.r0
    public void f(@NonNull D.c cVar) {
        this.f998b.setTappableElementInsets(cVar.d());
    }

    public void g(@NonNull D.c cVar) {
        this.f998b.setStableInsets(cVar.d());
    }

    public p0(@NonNull z0 z0Var) {
        WindowInsets.Builder builder;
        super(z0Var);
        WindowInsets windowInsetsE = z0Var.e();
        if (windowInsetsE != null) {
            builder = new WindowInsets.Builder(windowInsetsE);
        } else {
            builder = new WindowInsets.Builder();
        }
        this.f998b = builder;
    }
}
