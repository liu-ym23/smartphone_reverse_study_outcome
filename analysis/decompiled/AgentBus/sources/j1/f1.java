package j1;

/* loaded from: classes.dex */
public final class f1 extends b {

    /* renamed from: n, reason: collision with root package name */
    public final b0.o1 f5161n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5162o;

    public f1(c.i iVar) {
        super(iVar, null, 0);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        b0 b0Var = new b0(1, this);
        addOnAttachStateChangeListener(b0Var);
        b4.b bVar = new b4.b(6);
        n7.a.m(this).f8969a.add(bVar);
        this.f5100j = new eb.k(this, b0Var, bVar, 1);
        this.f5161n = b0.b.n(null);
    }

    public static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    @Override // j1.b
    public final void a(int i2, b0.p pVar) {
        pVar.T(420213850);
        int i10 = (pVar.h(this) ? 4 : 2) | i2;
        if (pVar.L(i10 & 1, (i10 & 3) != 2)) {
            p7.n nVar = (p7.n) this.f5161n.getValue();
            if (nVar == null) {
                pVar.S(-1238798753);
            } else {
                pVar.S(98586082);
                nVar.invoke(pVar, 0);
            }
            pVar.q(false);
        } else {
            pVar.O();
        }
        b0.z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new a(i2, 1, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return f1.class.getName();
    }

    @Override // j1.b
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f5162o;
    }

    public final void setContent(p7.n nVar) {
        this.f5162o = true;
        this.f5161n.setValue(nVar);
        if (isAttachedToWindow()) {
            if (this.f5099i == null && !isAttachedToWindow()) {
                throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
            }
            c();
        }
    }
}
