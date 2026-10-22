package Fc;

import android.view.View;
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public i f2765a;

    /* renamed from: b, reason: collision with root package name */
    public i f2766b;

    public a(View view, float f10, float f11, e.q qVar, boolean z10) {
        i iVarB = new i(view, e.f13693q).B(a(f10, f11));
        this.f2765a = iVarB;
        iVarB.b(qVar);
        if (z10) {
            return;
        }
        this.f2766b = new i(view, e.f13694r).B(a(f10, f11));
    }

    public final j a(float f10, float f11) {
        j jVar = new j();
        jVar.f(f10);
        jVar.h(f11);
        return jVar;
    }

    public void b() {
        c(this.f2765a);
        c(this.f2766b);
    }

    public final void c(i iVar) {
        if (iVar == null || !iVar.i()) {
            return;
        }
        iVar.d();
    }
}
