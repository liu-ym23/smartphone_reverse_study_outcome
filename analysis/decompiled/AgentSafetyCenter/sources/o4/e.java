package o4;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicBoolean;
import pc.v;
import pc.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements b {

    /* renamed from: c, reason: collision with root package name */
    public i f9168c;

    /* renamed from: f, reason: collision with root package name */
    public i f9169f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadLocal f9170g;

    /* renamed from: h, reason: collision with root package name */
    public AtomicBoolean f9171h;
    public long i;

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f9171h.compareAndSet(false, true)) {
            this.f9168c.b();
            this.f9169f.b();
        }
    }

    public final nb.g d(q qVar) {
        qVar.getClass();
        a aVar = new a();
        aVar.f9155c = qVar;
        VarHandle.storeStoreFence();
        ThreadLocal threadLocal = this.f9170g;
        threadLocal.getClass();
        v vVar = new v();
        vVar.f9987c = qVar;
        vVar.f9988f = threadLocal;
        w wVar = new w();
        wVar.f9990c = threadLocal;
        VarHandle.storeStoreFence();
        vVar.f9989g = wVar;
        VarHandle.storeStoreFence();
        return ac.a.N(aVar, vVar);
    }

    public final void e(boolean z10) {
        String str = z10 ? "reader" : "writer";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Timed out attempting to acquire a " + str + " connection.");
        sb2.append("\n\nWriter pool:\n");
        this.f9169f.c(sb2);
        sb2.append("Reader pool:");
        sb2.append('\n');
        this.f9168c.c(sb2);
        t0.a.l(5, sb2.toString());
        throw null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|(3:(1:(1:(1:(1:(8:14|134|15|16|140|93|(3:95|(2:153|97)|98)|99)(2:20|21))(5:22|144|23|24|67))(2:27|28))(2:29|30))(2:31|(4:33|(2:35|(1:37)(1:38))|(1:(2:46|(2:48|(0)(1:51))(2:52|(0)(1:55)))(2:44|45))(9:(1:57)(1:59)|58|60|138|61|62|136|63|(2:66|67))|91)(2:127|128))|146|(1:(1:(3:89|(5:92|140|93|(0)|99)|91)(3:103|104|105))(2:108|109))(2:110|111))|68|142|72|(4:147|74|(1:78)(1:77)|79)(1:84)|85|(2:(0)|(1:152))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01bc, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01bd, code lost:
    
        r4 = r16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d2 A[Catch: all -> 0x01cd, TryCatch #7 {all -> 0x01cd, blocks: (B:104:0x01c5, B:105:0x01cc, B:109:0x01d1, B:110:0x01d2, B:111:0x01d7), top: B:146:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a2 A[Catch: all -> 0x01bb, TRY_LEAVE, TryCatch #4 {all -> 0x01bb, blocks: (B:93:0x019c, B:95:0x01a2, B:97:0x01ab, B:98:0x01b2), top: B:140:0x019c }] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // o4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(boolean r18, xb.p r19, pb.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.e.m(boolean, xb.p, pb.c):java.lang.Object");
    }
}
