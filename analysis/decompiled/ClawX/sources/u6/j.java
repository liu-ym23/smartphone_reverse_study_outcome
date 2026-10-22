package u6;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5708a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f5709b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5710c;

    public /* synthetic */ j(n nVar, int i8, Object obj, int i9) {
        this.f5708a = i9;
        this.f5709b = nVar;
        this.f5710c = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f5708a) {
            case 0:
                n nVar = this.f5709b;
                int i8 = this.f5710c;
                nVar.f5723l.getClass();
                try {
                    nVar.y.n(i8, b.f5675h);
                    synchronized (nVar) {
                        nVar.A.remove(Integer.valueOf(i8));
                    }
                } catch (IOException unused) {
                }
                return b5.a0.f883a;
            case 1:
                n nVar2 = this.f5709b;
                int i9 = this.f5710c;
                nVar2.f5723l.getClass();
                synchronized (nVar2) {
                    nVar2.A.remove(Integer.valueOf(i9));
                }
                return b5.a0.f883a;
            default:
                n nVar3 = this.f5709b;
                int i10 = this.f5710c;
                nVar3.f5723l.getClass();
                try {
                    nVar3.y.n(i10, b.f5675h);
                    synchronized (nVar3) {
                        nVar3.A.remove(Integer.valueOf(i10));
                    }
                } catch (IOException unused2) {
                }
                return b5.a0.f883a;
        }
    }

    public /* synthetic */ j(n nVar, int i8, List list, boolean z) {
        this.f5708a = 2;
        this.f5709b = nVar;
        this.f5710c = i8;
    }
}
