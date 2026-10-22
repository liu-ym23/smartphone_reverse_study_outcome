package I1;

import P.i;
import P.j;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private i f2901a;

    /* renamed from: b, reason: collision with root package name */
    private i f2902b;

    /* renamed from: c, reason: collision with root package name */
    private View f2903c;

    /* renamed from: d, reason: collision with root package name */
    private float f2904d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f2905e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2906f = true;

    public a(View view) {
        this.f2903c = view;
    }

    private void a() {
        i iVar = this.f2901a;
        if (iVar != null && iVar.i()) {
            this.f2901a.d();
        }
        i iVar2 = this.f2902b;
        if (iVar2 == null || !iVar2.i()) {
            return;
        }
        this.f2902b.d();
    }

    private i b(boolean z5) {
        i iVar = new i(this.f2903c, P.e.f4491q);
        j jVar = new j();
        jVar.g(z5 ? this.f2904d : 1.0f);
        jVar.h(250.0f).f(0.89f);
        iVar.x(jVar);
        return iVar;
    }

    private i c(boolean z5) {
        i iVar = new i(this.f2903c, P.e.f4492r);
        j jVar = new j();
        jVar.g(z5 ? this.f2905e : 1.0f);
        jVar.h(250.0f).f(0.89f);
        iVar.x(jVar);
        return iVar;
    }

    private void d(boolean z5) {
        a();
        i iVarC = c(z5);
        this.f2902b = iVarC;
        iVarC.p();
        i iVarB = b(z5);
        this.f2901a = iVarB;
        iVarB.p();
    }

    public boolean e(MotionEvent motionEvent) {
        if (!this.f2906f) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            d(true);
        } else if (actionMasked == 1 || actionMasked == 3) {
            d(false);
        }
        return false;
    }

    public void f(float f5, float f6) {
        this.f2904d = f5;
        this.f2905e = f6;
    }

    public void g(boolean z5) {
        this.f2906f = z5;
    }
}
