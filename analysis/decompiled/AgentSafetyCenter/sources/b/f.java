package b;

import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f1696c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f1697f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, boolean z10) {
        super(0);
        this.f1696c = iVar;
        this.f1697f = z10;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [xb.a, yb.i] */
    @Override // xb.a
    public final Object invoke() {
        boolean z10 = this.f1697f;
        i iVar = this.f1696c;
        iVar.f699a = z10;
        ?? r12 = iVar.f701c;
        if (r12 != 0) {
            r12.invoke();
        }
        return v.f6774a;
    }
}
