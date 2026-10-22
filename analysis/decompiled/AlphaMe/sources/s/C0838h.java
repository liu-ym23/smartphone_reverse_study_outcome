package s;

/* renamed from: s.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0838h extends B0.f {
    @Override // B0.f
    public final boolean f(AbstractC0840j abstractC0840j, C0835e c0835e, C0835e c0835e2) {
        synchronized (abstractC0840j) {
            try {
                if (abstractC0840j.f14146b != c0835e) {
                    return false;
                }
                abstractC0840j.f14146b = c0835e2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // B0.f
    public final boolean g(AbstractC0840j abstractC0840j, Object obj, Object obj2) {
        synchronized (abstractC0840j) {
            try {
                if (abstractC0840j.f14145a != obj) {
                    return false;
                }
                abstractC0840j.f14145a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // B0.f
    public final void g0(C0839i c0839i, C0839i c0839i2) {
        c0839i.f14140b = c0839i2;
    }

    @Override // B0.f
    public final boolean h(AbstractC0840j abstractC0840j, C0839i c0839i, C0839i c0839i2) {
        synchronized (abstractC0840j) {
            try {
                if (abstractC0840j.f14147c != c0839i) {
                    return false;
                }
                abstractC0840j.f14147c = c0839i2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // B0.f
    public final void h0(C0839i c0839i, Thread thread) {
        c0839i.f14139a = thread;
    }
}
