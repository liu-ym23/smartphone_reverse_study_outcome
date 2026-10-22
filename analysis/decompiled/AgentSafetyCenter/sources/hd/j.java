package hd;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends dd.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5500e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f5501f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5502g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5503h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, o oVar, int i, int i3, int i10) {
        super(str, true);
        this.f5500e = i10;
        this.f5501f = oVar;
        this.f5502g = i;
        this.f5503h = i3;
    }

    @Override // dd.a
    public final long a() {
        switch (this.f5500e) {
            case 0:
                o oVar = this.f5501f;
                try {
                    oVar.A.o(this.f5502g, this.f5503h, true);
                    return -1L;
                } catch (IOException e10) {
                    oVar.d(2, 2, e10);
                    return -1L;
                }
            case 1:
                y yVar = this.f5501f.f5527o;
                int i = this.f5503h;
                yVar.getClass();
                if (i == 0) {
                    throw null;
                }
                synchronized (this.f5501f) {
                    this.f5501f.C.remove(Integer.valueOf(this.f5502g));
                }
                return -1L;
            default:
                o oVar2 = this.f5501f;
                try {
                    int i3 = this.f5502g;
                    int i10 = this.f5503h;
                    if (i10 == 0) {
                        throw null;
                    }
                    oVar2.A.r(i3, i10);
                    return -1L;
                } catch (IOException e11) {
                    oVar2.d(2, 2, e11);
                    return -1L;
                }
        }
    }
}
