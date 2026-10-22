package w3;

import a6.j1;
import a6.s0;
import b5.a0;
import java.util.concurrent.CancellationException;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6197a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6198b;

    public /* synthetic */ i(int i8, Object obj) {
        this.f6197a = i8;
        this.f6198b = obj;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f6197a) {
            case 0:
                ((s0) this.f6198b).b();
                break;
            default:
                Throwable th = (Throwable) obj;
                if (th != null) {
                    ((j1) this.f6198b).y(new CancellationException(th.getMessage()));
                }
                break;
        }
        return a0.f883a;
    }
}
