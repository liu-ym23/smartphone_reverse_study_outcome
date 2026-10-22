package hd;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends dd.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f5515e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5516f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f5517g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, o oVar, int i, long j10) {
        super(str, true);
        this.f5515e = oVar;
        this.f5516f = i;
        this.f5517g = j10;
    }

    @Override // dd.a
    public final long a() {
        o oVar = this.f5515e;
        try {
            oVar.A.A(this.f5516f, this.f5517g);
            return -1L;
        } catch (IOException e10) {
            oVar.d(2, 2, e10);
            return -1L;
        }
    }
}
