package r2;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import b0.y;
import com.stepos.agentsafetycenter.R;
import h0.l0;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import n3.e0;
import n3.k0;
import o1.a0;
import o1.x;
import o1.z;
import u1.g0;
import u1.n1;
import v1.d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends h {
    public final View D;
    public final n1.d E;
    public t0.f F;
    public xb.l G;
    public xb.l H;
    public xb.l I;

    public q(Context context, xb.l lVar, k0.p pVar, t0.g gVar, int i, n1 n1Var) {
        View view = (View) lVar.invoke(context);
        n1.d dVar = new n1.d();
        super(context);
        this.f10387c = dVar;
        this.f10388f = view;
        this.f10389g = n1Var;
        LinkedHashMap linkedHashMap = d2.f14405a;
        setTag(R.id.androidx_compose_ui_view_composition_context, pVar);
        int i3 = 0;
        setSaveFromParentEnabled(false);
        addView(view);
        k0.i(this, new a(this, i3));
        e0.b(this, this);
        this.f10390h = f.f10383h;
        this.f10391j = f.f10382g;
        this.f10392k = f.f10381f;
        this.f10393l = w0.j.f15113c;
        this.f10395n = p5.f.b(1.0f, 1.0f);
        int i10 = 2;
        this.f10399r = new int[2];
        this.f10400s = 0L;
        int i11 = 1;
        this.f10402u = new g(this, i11);
        this.f10403v = new g(this, i3);
        this.f10405x = new int[2];
        this.f10406y = Integer.MIN_VALUE;
        this.f10407z = Integer.MIN_VALUE;
        this.A = new l0();
        g0 g0Var = new g0(3);
        g0Var.f13801r = this;
        w0.m mVarA = a2.l.a(androidx.compose.ui.input.nestedscroll.a.a(dVar), true, c.f10372h);
        z zVar = new z();
        p5.i iVar = new p5.i();
        iVar.f9733h = zVar;
        iVar.f9731f = x.f9098c;
        VarHandle.storeStoreFence();
        zVar.f9107h = iVar;
        VarHandle.storeStoreFence();
        zVar.f9104c = new a0(this, 0);
        j9.f fVar = new j9.f(i10);
        j9.f fVar2 = zVar.f9105f;
        if (fVar2 != null) {
            fVar2.f6662f = null;
        }
        zVar.f9105f = fVar;
        fVar.f6662f = zVar;
        setOnRequestDisallowInterceptTouchEvent$ui_release(fVar);
        w0.m mVarB = androidx.compose.ui.layout.a.b(androidx.compose.ui.draw.a.a(mVarA.d(zVar), new b.g(this, g0Var, this, 5)), new d(this, g0Var, i10));
        g0Var.d0(this.f10393l.d(mVarB));
        this.f10394m = new b0.n(12, g0Var, mVarB);
        g0Var.Z(this.f10395n);
        this.f10396o = new a2.m(g0Var, 11);
        g0Var.O = new d(this, g0Var, i3);
        g0Var.P = new a0(this, 1);
        y yVar = new y(i11);
        yVar.f1799b = this;
        yVar.f1800c = g0Var;
        VarHandle.storeStoreFence();
        g0Var.c0(yVar);
        this.C = g0Var;
        this.D = view;
        this.E = dVar;
        setClipChildren(false);
        String strValueOf = String.valueOf(i);
        Object objC = gVar != null ? gVar.c(strValueOf) : null;
        SparseArray<Parcelable> sparseArray = objC instanceof SparseArray ? (SparseArray) objC : null;
        if (sparseArray != null) {
            view.restoreHierarchyState(sparseArray);
        }
        if (gVar != null) {
            setSavableRegistryEntry(gVar.d(strValueOf, new g(this, i10)));
        }
        c cVar = c.i;
        this.G = cVar;
        this.H = cVar;
        this.I = cVar;
    }

    public static final void g(q qVar) {
        qVar.setSavableRegistryEntry(null);
    }

    private final void setSavableRegistryEntry(t0.f fVar) {
        t0.f fVar2 = this.F;
        if (fVar2 != null) {
            ((p5.m) fVar2).V();
        }
        this.F = fVar;
    }

    public final n1.d getDispatcher() {
        return this.E;
    }

    public final xb.l getReleaseBlock() {
        return this.I;
    }

    public final xb.l getResetBlock() {
        return this.H;
    }

    public /* bridge */ /* synthetic */ v1.a getSubCompositionView() {
        return null;
    }

    public final xb.l getUpdateBlock() {
        return this.G;
    }

    public final void setReleaseBlock(xb.l lVar) {
        this.I = lVar;
        setRelease(new g(this, 3));
    }

    public final void setResetBlock(xb.l lVar) {
        this.H = lVar;
        setReset(new g(this, 4));
    }

    public final void setUpdateBlock(xb.l lVar) {
        this.G = lVar;
        setUpdate(new g(this, 5));
    }

    public View getViewRoot() {
        return this;
    }
}
