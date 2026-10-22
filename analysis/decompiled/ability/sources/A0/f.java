package A0;

import H4.o;
import java.io.File;

/* loaded from: classes2.dex */
public final class f implements C0.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f72a;
    public Object b;

    public synchronized void a() {
        File file;
        if (this.f72a) {
            return;
        }
        try {
            file = new File(S0.b.x0(), "header");
            this.b = file;
        } catch (Throwable th) {
            o.n("APM", "header store init error " + th.toString());
        }
        if (file.exists()) {
            this.f72a = true;
            return;
        } else {
            ((File) this.b).mkdirs();
            this.f72a = true;
            return;
        }
    }

    @Override // C0.a
    public synchronized void i(D0.a aVar) {
        ((C0.a) this.b).i(aVar);
    }

    @Override // C0.a
    public void j(boolean z10, boolean z11) {
        if (this.f72a) {
            return;
        }
        this.f72a = true;
        ((C0.a) this.b).j(z10, z11);
    }

    @Override // C0.a
    public synchronized void a(String str, boolean z10) {
        ((C0.a) this.b).a(str, z10);
    }

    @Override // C0.a
    public synchronized void a(String str) {
        ((C0.a) this.b).a(str);
    }
}
