package b7;

import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.p;
import org.tukaani.xz.common.Util;
import r6.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends q6.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f945e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f946f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(q qVar, String str) {
        super(str, true);
        this.f946f = qVar;
    }

    @Override // q6.a
    public final long a() throws IOException {
        switch (this.f945e) {
            case 0:
                h hVar = (h) this.f946f;
                try {
                } catch (IOException e9) {
                    h.c(hVar, e9, null, 2);
                }
                return hVar.g() ? 0L : -1L;
            default:
                q qVar = (q) this.f946f;
                long jNanoTime = System.nanoTime();
                long j4 = (jNanoTime - qVar.f5190a) + 1;
                Iterator it = qVar.d.iterator();
                p.d(it, "iterator(...)");
                r6.p pVar = null;
                long j8 = Util.VLI_MAX;
                int i8 = 0;
                r6.p pVar2 = null;
                r6.p pVar3 = null;
                int i9 = 0;
                while (it.hasNext()) {
                    r6.p pVar4 = (r6.p) it.next();
                    p.b(pVar4);
                    synchronized (pVar4) {
                        if (qVar.a(pVar4, jNanoTime) > 0) {
                            i9++;
                        } else {
                            long j9 = pVar4.f5189r;
                            if (j9 < j4) {
                                pVar2 = pVar4;
                                j4 = j9;
                            }
                            i8++;
                            if (j9 < j8) {
                                pVar3 = pVar4;
                                j8 = j9;
                            }
                        }
                    }
                }
                if (pVar2 != null) {
                    pVar = pVar2;
                } else if (i8 > 5) {
                    j4 = j8;
                    pVar = pVar3;
                } else {
                    j4 = -1;
                }
                if (pVar == null) {
                    if (pVar3 != null) {
                        return (j8 + qVar.f5190a) - jNanoTime;
                    }
                    if (i9 > 0) {
                        return qVar.f5190a;
                    }
                    return -1L;
                }
                synchronized (pVar) {
                    if (pVar.f5188q.isEmpty() && pVar.f5189r == j4) {
                        pVar.f5182k = true;
                        qVar.d.remove(pVar);
                        o6.f.c(pVar.f5176e);
                        if (!qVar.d.isEmpty()) {
                            return 0L;
                        }
                        q6.c cVar = qVar.f5191b;
                        synchronized (cVar.f4873a) {
                            if (cVar.a()) {
                                cVar.f4873a.c(cVar);
                            }
                        }
                        return 0L;
                    }
                    return 0L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar) {
        super(m0.f.f(new StringBuilder(), hVar.f959m, " writer"), true);
        this.f946f = hVar;
    }
}
