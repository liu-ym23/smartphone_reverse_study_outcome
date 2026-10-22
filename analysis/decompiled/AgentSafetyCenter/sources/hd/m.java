package hd;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends dd.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5511e = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f5512f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5513g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f5514h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, o oVar, int i, List list) {
        super(str, true);
        this.f5512f = oVar;
        this.f5513g = i;
        this.f5514h = list;
    }

    @Override // dd.a
    public final long a() {
        switch (this.f5511e) {
            case 0:
                this.f5512f.f5527o.getClass();
                try {
                    this.f5512f.A.r(this.f5513g, 9);
                    synchronized (this.f5512f) {
                        this.f5512f.C.remove(Integer.valueOf(this.f5513g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            default:
                this.f5512f.f5527o.getClass();
                try {
                    this.f5512f.A.r(this.f5513g, 9);
                    synchronized (this.f5512f) {
                        this.f5512f.C.remove(Integer.valueOf(this.f5513g));
                    }
                    return -1L;
                } catch (IOException unused2) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, o oVar, int i, List list, boolean z10) {
        super(str, true);
        this.f5512f = oVar;
        this.f5513g = i;
        this.f5514h = list;
    }
}
