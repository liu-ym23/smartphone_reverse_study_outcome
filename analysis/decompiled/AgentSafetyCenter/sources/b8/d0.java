package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.lang.ref.Reference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 implements r0 {

    /* renamed from: c, reason: collision with root package name */
    public long f1946c;

    /* renamed from: f, reason: collision with root package name */
    public Object f1947f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1948g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1949h;

    /* JADX WARN: Removed duplicated region for block: B:29:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0031 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(ad.a r5, ed.j r6, java.util.ArrayList r7, boolean r8) {
        /*
            r4 = this;
            java.lang.Object r4 = r4.f1949h
            java.util.concurrent.ConcurrentLinkedQueue r4 = (java.util.concurrent.ConcurrentLinkedQueue) r4
            java.util.Iterator r4 = r4.iterator()
        L8:
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 == 0) goto L35
            java.lang.Object r0 = r4.next()
            ed.m r0 = (ed.m) r0
            r0.getClass()
            monitor-enter(r0)
            r2 = 1
            if (r8 == 0) goto L26
            hd.o r3 = r0.f3825f     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L21
            r1 = r2
        L21:
            if (r1 == 0) goto L31
            goto L26
        L24:
            r4 = move-exception
            goto L33
        L26:
            boolean r1 = r0.g(r5, r7)     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L31
            r6.b(r0)     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r2
        L31:
            monitor-exit(r0)
            goto L8
        L33:
            monitor-exit(r0)
            throw r4
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.d0.a(ad.a, ed.j, java.util.ArrayList, boolean):boolean");
    }

    public int b(ed.m mVar, long j10) {
        byte[] bArr = bd.b.f2074a;
        ArrayList arrayList = mVar.f3833o;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + mVar.f3820a.f518a.f428h + " was leaked. Did you forget to close a response body?";
                id.n.Companion.getClass();
                id.n.platform.logCloseableLeak(str, ((ed.h) reference).f3799a);
                arrayList.remove(i);
                mVar.i = true;
                if (arrayList.isEmpty()) {
                    mVar.f3834p = j10 - this.f1946c;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    @Override // b8.r0
    public String k() {
        return String.valueOf(this.f1946c);
    }

    @Override // b8.r0
    public boolean o(JsonNode jsonNode) {
        boolean z10 = ((e0) this.f1949h).f1953h;
        if (jsonNode.isBigInteger()) {
            int iCompareTo = jsonNode.bigIntegerValue().compareTo(new BigInteger(((JsonNode) this.f1947f).asText()));
            if (iCompareTo <= 0) {
                return z10 && iCompareTo == 0;
            }
            return true;
        }
        if (jsonNode.isTextual()) {
            int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.f1948g));
            if (iCompareTo2 <= 0) {
                return z10 && iCompareTo2 == 0;
            }
            return true;
        }
        long jAsLong = jsonNode.asLong();
        long j10 = this.f1946c;
        if (j10 >= jAsLong) {
            return z10 && j10 == jAsLong;
        }
        return true;
    }
}
