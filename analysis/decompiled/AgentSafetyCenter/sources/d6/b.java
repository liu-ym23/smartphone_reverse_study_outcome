package d6;

import ad.e0;
import ad.n;
import android.graphics.Bitmap;
import h5.t;
import hc.h;
import java.io.EOFException;
import java.lang.invoke.VarHandle;
import od.b0;
import od.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3270a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3271b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3272c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3273d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3274e;

    /* renamed from: f, reason: collision with root package name */
    public final n f3275f;

    public b(c0 c0Var) throws NumberFormatException, EOFException {
        jb.e eVar = jb.e.f6757f;
        a aVar = new a(0);
        aVar.f3269f = this;
        VarHandle.storeStoreFence();
        this.f3270a = t.G(eVar, aVar);
        a aVar2 = new a(1 == true ? 1 : 0);
        aVar2.f3269f = this;
        VarHandle.storeStoreFence();
        this.f3271b = t.G(eVar, aVar2);
        this.f3272c = Long.parseLong(c0Var.q(Long.MAX_VALUE));
        this.f3273d = Long.parseLong(c0Var.q(Long.MAX_VALUE));
        this.f3274e = Integer.parseInt(c0Var.q(Long.MAX_VALUE)) > 0;
        int i = Integer.parseInt(c0Var.q(Long.MAX_VALUE));
        ne.b bVar = new ne.b();
        for (int i3 = 0; i3 < i; i3++) {
            String strQ = c0Var.q(Long.MAX_VALUE);
            Bitmap.Config config = i6.d.f5804a;
            int iD0 = h.d0(strQ, ':', 0, 6);
            if (iD0 == -1) {
                od.f.c("Unexpected header: ".concat(strQ));
                throw null;
            }
            bVar.c(h.w0(strQ.substring(0, iD0)).toString(), strQ.substring(iD0 + 1));
        }
        this.f3275f = bVar.d();
    }

    public final void a(b0 b0Var) {
        b0Var.I(this.f3272c);
        b0Var.writeByte(10);
        b0Var.I(this.f3273d);
        b0Var.writeByte(10);
        b0Var.I(this.f3274e ? 1L : 0L);
        b0Var.writeByte(10);
        n nVar = this.f3275f;
        b0Var.I(nVar.size());
        b0Var.writeByte(10);
        int size = nVar.size();
        for (int i = 0; i < size; i++) {
            b0Var.v(nVar.b(i));
            b0Var.v(": ");
            b0Var.v(nVar.d(i));
            b0Var.writeByte(10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(e0 e0Var) {
        jb.e eVar = jb.e.f6757f;
        a aVar = new a(0 == true ? 1 : 0);
        aVar.f3269f = this;
        VarHandle.storeStoreFence();
        this.f3270a = t.G(eVar, aVar);
        a aVar2 = new a(1);
        aVar2.f3269f = this;
        VarHandle.storeStoreFence();
        this.f3271b = t.G(eVar, aVar2);
        this.f3272c = e0Var.f477o;
        this.f3273d = e0Var.f478p;
        this.f3274e = e0Var.i != null;
        this.f3275f = e0Var.f472j;
    }
}
