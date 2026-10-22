package gb;

import eb.m;
import java.io.IOException;
import ob.j;
import ob.k0;
import ob.m0;
import ob.r;
import q7.k;

/* loaded from: classes.dex */
public abstract class b implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final r f4034f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4035g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f4036h;

    public b(h hVar) {
        this.f4036h = hVar;
        this.f4034f = new r(((j) hVar.f4055e).timeout());
    }

    public final void a() {
        h hVar = this.f4036h;
        int i2 = hVar.f4052b;
        if (i2 == 6) {
            return;
        }
        if (i2 != 5) {
            throw new IllegalStateException("state: " + hVar.f4052b);
        }
        r rVar = this.f4034f;
        m0 m0Var = rVar.f8024e;
        rVar.f8024e = m0.f8007d;
        m0Var.a();
        m0Var.b();
        hVar.f4052b = 6;
    }

    @Override // ob.k0
    public long read(ob.h hVar, long j2) throws IOException {
        h hVar2 = this.f4036h;
        k.e(hVar, "sink");
        try {
            return ((j) hVar2.f4055e).read(hVar, j2);
        } catch (IOException e10) {
            ((m) hVar2.f4054d).k();
            this.a();
            throw e10;
        }
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f4034f;
    }
}
