package v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 extends a {

    /* renamed from: m, reason: collision with root package name */
    public k0.k1 f14600m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14601n;

    @Override // v1.a
    public final void a(int i, k0.s sVar) {
        sVar.Z(420213850);
        int i3 = (sVar.h(this) ? 4 : 2) | i;
        if (sVar.P(i3 & 1, (i3 & 3) != 2)) {
            xb.p pVar = (xb.p) this.f14600m.getValue();
            if (pVar == null) {
                sVar.X(-1238798753);
            } else {
                sVar.X(98586082);
                pVar.invoke(sVar, 0);
            }
            sVar.q(false);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.s(i, 6, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return z0.class.getName();
    }

    @Override // v1.a
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f14601n;
    }

    public final void setContent(xb.p pVar) {
        this.f14601n = true;
        this.f14600m.setValue(pVar);
        if (isAttachedToWindow()) {
            if (this.f14327h != null || isAttachedToWindow()) {
                c();
            } else {
                od.f.e("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
            }
        }
    }

    public static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }
}
