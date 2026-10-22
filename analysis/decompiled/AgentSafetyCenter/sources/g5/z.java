package g5;

import android.os.Trace;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ j f4347c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f4348f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ xb.a f4349g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ androidx.lifecycle.d0 f4350h;
    public /* synthetic */ t2.j i;

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f4347c;
        String str = this.f4348f;
        xb.a aVar = this.f4349g;
        androidx.lifecycle.d0 d0Var = this.f4350h;
        t2.j jVar2 = this.i;
        jVar.getClass();
        boolean zA = c5.a.a();
        if (zA) {
            try {
                Trace.beginSection(com.stepos.statsrpk.h.J(str));
            } finally {
                if (zA) {
                    Trace.endSection();
                }
            }
        }
        try {
            aVar.invoke();
            y yVar = j.f4323c;
            d0Var.a(yVar);
            jVar2.a(yVar);
        } catch (Throwable th) {
            x xVar = new x();
            xVar.f4345e = th;
            VarHandle.storeStoreFence();
            d0Var.a(xVar);
            jVar2.b(th);
        }
    }
}
