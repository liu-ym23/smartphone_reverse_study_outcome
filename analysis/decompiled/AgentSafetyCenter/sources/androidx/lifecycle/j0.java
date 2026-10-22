package androidx.lifecycle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 implements v {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ o f1400c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ yb.u f1401f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ kc.t f1402g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ o f1403h;
    public /* synthetic */ kc.g i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ sc.c f1404j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ f4.b f1405k;

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) {
        yb.u uVar = this.f1401f;
        if (oVar == this.f1400c) {
            uVar.f16098c = kc.w.u(this.f1402g, null, null, new i0(this.f1404j, this.f1405k, null), 3);
            return;
        }
        if (oVar == this.f1403h) {
            kc.x0 x0Var = (kc.x0) uVar.f16098c;
            if (x0Var != null) {
                x0Var.e(null);
            }
            uVar.f16098c = null;
        }
        if (oVar == o.ON_DESTROY) {
            this.i.resumeWith(jb.v.f6774a);
        }
    }
}
