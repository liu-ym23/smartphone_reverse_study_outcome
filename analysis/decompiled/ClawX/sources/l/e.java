package l;

import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends v {
    @Override // k4.v
    public final void d0(f fVar, f fVar2) {
        fVar.f3719b = fVar2;
    }

    @Override // k4.v
    public final void e0(f fVar, Thread thread) {
        fVar.f3718a = thread;
    }

    @Override // k4.v
    public final boolean h(g gVar, c cVar) {
        c cVar2 = c.f3711b;
        synchronized (gVar) {
            try {
                if (gVar.f3724b != cVar) {
                    return false;
                }
                gVar.f3724b = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k4.v
    public final boolean i(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            try {
                if (gVar.f3723a != obj) {
                    return false;
                }
                gVar.f3723a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k4.v
    public final boolean j(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f3725c != fVar) {
                    return false;
                }
                gVar.f3725c = fVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
