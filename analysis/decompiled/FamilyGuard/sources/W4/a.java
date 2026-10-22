package W4;

import P.e;
import P.i;
import P.j;
import android.view.View;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private i f5764a;

    /* renamed from: b, reason: collision with root package name */
    private i f5765b;

    public a(View view, float f5, float f6, e.q qVar, boolean z5) {
        i iVarX = new i(view, e.f4491q).x(a(f5, f6));
        this.f5764a = iVarX;
        iVarX.b(qVar);
        if (z5) {
            return;
        }
        this.f5765b = new i(view, e.f4492r).x(a(f5, f6));
    }

    private j a(float f5, float f6) {
        j jVar = new j();
        jVar.f(f5);
        jVar.h(f6);
        return jVar;
    }

    private void c(i iVar) {
        if (iVar == null || !iVar.i()) {
            return;
        }
        iVar.d();
    }

    public void b() {
        c(this.f5764a);
        c(this.f5765b);
    }
}
