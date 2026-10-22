package Z6;

import com.volcengine.tos.model.object.CancelHook;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class d implements a, CancelHook {

    /* renamed from: a, reason: collision with root package name */
    public String f1601a;
    public String b;
    public K1.a c;

    public d() {
        new ReentrantLock();
    }

    @Override // Z6.a
    public final void a() {
        K1.a aVar = this.c;
        if (aVar != null) {
            aVar.j();
        }
        k.u(this.f1601a);
        new File(this.b).delete();
    }

    @Override // com.volcengine.tos.model.object.CancelHook
    public final void cancel(boolean z10) {
        if (z10) {
            a();
            return;
        }
        K1.a aVar = this.c;
        if (aVar != null) {
            aVar.j();
        }
    }
}
