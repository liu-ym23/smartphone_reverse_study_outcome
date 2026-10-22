package stepos.support.v7.app;

import K.InterfaceC0071c;
import K.InterfaceC0088u;
import K.x0;
import K.z0;
import android.content.Context;
import android.view.View;
import java.util.Objects;
import java.util.WeakHashMap;
import stepos.support.v7.widget.AbstractC0904y;
import stepos.support.v7.widget.C0897q;
import stepos.support.v7.widget.InterfaceC0900u;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;

/* renamed from: stepos.support.v7.app.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0872q implements stepos.support.v7.widget.F, K3.a, InterfaceC0863h, InterfaceC0088u, stepos.support.v7.widget.L, InterfaceC0071c, L3.v, InterfaceC0900u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14582a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14583b;

    public /* synthetic */ C0872q(int i4, Object obj) {
        this.f14582a = i4;
        this.f14583b = obj;
    }

    @Override // L3.v
    public final void d(L3.k kVar, boolean z4) {
        if (kVar instanceof L3.A) {
            kVar.k().c(false);
        }
        L3.v vVar = ((C0897q) this.f14583b).f15120e;
        if (vVar != null) {
            vVar.d(kVar, z4);
        }
    }

    @Override // K.InterfaceC0088u
    public final z0 e(View view, z0 z0Var) {
        Object obj = this.f14583b;
        x0 x0Var = z0Var.f1023a;
        switch (this.f14582a) {
            case 3:
                view.setPadding(0, z0Var.d(), 0, 0);
                ((WebViewActivity) obj).f14358a = z0Var.a();
                break;
            default:
                StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = (StepOSCollapsingToolbarLayout) ((AbstractC0904y) obj);
                if (!Objects.equals(stepOSCollapsingToolbarLayout.f14908y, z0Var)) {
                    stepOSCollapsingToolbarLayout.f14908y = z0Var;
                    stepOSCollapsingToolbarLayout.requestLayout();
                }
                WeakHashMap weakHashMap = K.S.f939a;
                if (!stepOSCollapsingToolbarLayout.getFitsSystemWindows()) {
                    z0Var = null;
                }
                if (!Objects.equals(stepOSCollapsingToolbarLayout.f15250w, z0Var)) {
                    stepOSCollapsingToolbarLayout.f15250w = z0Var;
                    stepOSCollapsingToolbarLayout.requestLayout();
                }
                break;
        }
        return x0Var.c();
    }

    @Override // L3.v
    public final boolean g(L3.k kVar) {
        if (kVar == null) {
            return false;
        }
        Object obj = this.f14583b;
        ((L3.A) kVar).f1244x.getClass();
        ((C0897q) obj).getClass();
        L3.v vVar = ((C0897q) obj).f15120e;
        return vVar != null && vVar.g(kVar);
    }

    @Override // K.InterfaceC0071c
    public final void h() {
        L3.k kVar = ((L3.l) this.f14583b).f1318n;
        kVar.f1287g = true;
        kVar.o(true);
    }

    @Override // stepos.support.v7.app.InterfaceC0863h
    public final DialogInterfaceC0865j newDialog(Context context, int i4) {
        S s4 = ((U) this.f14583b).f14346j;
        T t4 = new T(context, i4);
        t4.f14335a = s4;
        return t4;
    }

    @Override // stepos.support.v7.widget.L
    public final void onScrollChange(View view, int i4, int i5, int i6, int i7) {
        K3.f fVar = (K3.f) this.f14583b;
        K3.f.a(fVar, view, fVar.f1066d, fVar.f1072j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0872q(C0897q c0897q) {
        this(8, c0897q);
        this.f14582a = 8;
    }
}
