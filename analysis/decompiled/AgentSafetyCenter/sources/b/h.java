package b;

import jb.v;
import k0.s;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends yb.l implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1702c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.a f1703f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1704g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(boolean z10, xb.a aVar, int i) {
        super(2);
        this.f1702c = z10;
        this.f1703f = aVar;
        this.f1704g = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int i = this.f1704g | 1;
        p5.f.a(this.f1702c, this.f1703f, (s) obj, i);
        return v.f6774a;
    }
}
