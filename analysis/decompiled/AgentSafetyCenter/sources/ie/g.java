package ie;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class g implements f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5993c;

    /* renamed from: f, reason: collision with root package name */
    public i f5994f;

    @Override // ie.f
    public final void l(c cVar, o0 o0Var) {
        switch (this.f5993c) {
            case 0:
                boolean zE = o0Var.f6056a.e();
                i iVar = this.f5994f;
                if (!zE) {
                    iVar.completeExceptionally(new androidx.fragment.app.d(o0Var));
                    break;
                } else {
                    iVar.complete(o0Var.f6057b);
                    break;
                }
            default:
                this.f5994f.complete(o0Var);
                break;
        }
    }

    @Override // ie.f
    public final void t(c cVar, Throwable th) {
        switch (this.f5993c) {
            case 0:
                this.f5994f.completeExceptionally(th);
                break;
            default:
                this.f5994f.completeExceptionally(th);
                break;
        }
    }
}
