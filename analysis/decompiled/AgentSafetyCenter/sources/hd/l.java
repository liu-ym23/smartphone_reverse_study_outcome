package hd;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends dd.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f5507e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5508f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ od.i f5509g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5510h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, o oVar, int i, od.i iVar, int i3, boolean z10) {
        super(str, true);
        this.f5507e = oVar;
        this.f5508f = i;
        this.f5509g = iVar;
        this.f5510h = i3;
    }

    @Override // dd.a
    public final long a() {
        try {
            y yVar = this.f5507e.f5527o;
            od.i iVar = this.f5509g;
            int i = this.f5510h;
            yVar.getClass();
            iVar.W(i);
            this.f5507e.A.r(this.f5508f, 9);
            synchronized (this.f5507e) {
                this.f5507e.C.remove(Integer.valueOf(this.f5508f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
