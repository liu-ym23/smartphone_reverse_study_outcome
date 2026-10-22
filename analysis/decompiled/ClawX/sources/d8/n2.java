package d8;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n2 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f2094f;

    @Override // d8.w2
    public final boolean equals(Object obj) {
        return super.equals(obj) && this.d == ((n2) obj).d;
    }

    @Override // d8.w2
    public final int hashCode() {
        int i8 = 0;
        for (byte b9 : n(false)) {
            i8 += (i8 << 3) + (b9 & 255);
        }
        return i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[LOOP:0: B:5:0x0011->B:37:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v6, types: [d8.d0] */
    /* JADX WARN: Type inference failed for: r2v7, types: [d8.d0] */
    /* JADX WARN: Type inference failed for: r2v8, types: [d8.d0] */
    /* JADX WARN: Type inference failed for: r2v9, types: [d8.b4, d8.d0] */
    @Override // d8.w2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(d8.u r9) throws d8.l4 {
        /*
            r8 = this;
            int r0 = r9.f2173c
            java.nio.ByteBuffer r1 = r9.f2171a
            int r2 = r1.remaining()
            if (r2 <= 0) goto L11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r8.f2094f = r2
        L11:
            int r2 = r1.remaining()
            if (r2 <= 0) goto Laf
            int r2 = r9.d()
            int r3 = r9.f2172b
            int r4 = r9.d()
            int r5 = r1.remaining()
            if (r5 < r4) goto La7
            int r5 = r1.limit()
            int r5 = r5 - r3
            int r6 = r1.position()
            int r6 = r0 - r6
            java.lang.String r7 = "cannot set active region past end of input"
            if (r4 > r6) goto La1
            int r6 = r1.position()
            int r6 = r6 + r4
            r1.limit(r6)
            r4 = 3
            if (r2 == r4) goto L85
            r4 = 15
            if (r2 == r4) goto L7f
            r4 = 5
            if (r2 == r4) goto L76
            r4 = 6
            if (r2 == r4) goto L76
            r4 = 7
            if (r2 == r4) goto L76
            r4 = 8
            if (r2 == r4) goto L70
            r4 = 10
            if (r2 == r4) goto L6a
            r4 = 11
            if (r2 == r4) goto L60
            d8.b0 r4 = new d8.b0
            r4.<init>(r2)
            goto L8b
        L60:
            d8.b4 r2 = new d8.b4
            r2.<init>(r4)
            r4 = 0
            r2.f1962b = r4
        L68:
            r4 = r2
            goto L8b
        L6a:
            d8.o r2 = new d8.o
            r2.<init>(r4)
            goto L68
        L70:
            d8.l r2 = new d8.l
            r2.<init>(r4)
            goto L68
        L76:
            d8.b0 r4 = new d8.b0
            r6 = 0
            int[] r6 = new int[r6]
            r4.<init>(r2, r6)
            goto L8b
        L7f:
            d8.f0 r2 = new d8.f0
            r2.<init>(r4)
            goto L68
        L85:
            d8.t1 r2 = new d8.t1
            r2.<init>(r4)
            goto L68
        L8b:
            r4.a(r9)
            int r5 = r5 + r3
            if (r5 > r0) goto L9b
            r1.limit(r5)
            java.util.ArrayList r2 = r8.f2094f
            r2.add(r4)
            goto L11
        L9b:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r7)
            throw r8
        La1:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r7)
            throw r8
        La7:
            d8.l4 r8 = new d8.l4
            java.lang.String r9 = "truncated option"
            r8.<init>(r9)
            throw r8
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.n2.j(d8.u):void");
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f2094f;
        if (arrayList != null) {
            sb.append(arrayList);
            sb.append(" ");
        }
        sb.append(" ; payload ");
        sb.append(this.f2197c);
        sb.append(", xrcode ");
        sb.append((int) (this.d >>> 24));
        sb.append(", version ");
        sb.append((int) ((this.d >>> 16) & 255));
        sb.append(", flags ");
        sb.append((int) (this.d & 65535));
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        ArrayList arrayList = this.f2094f;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            d0 d0Var = (d0) obj;
            jVar.j(d0Var.f1976a);
            int i9 = jVar.f832a;
            jVar.j(0);
            d0Var.c(jVar);
            jVar.k((jVar.f832a - i9) - 2, i9);
        }
    }

    @Override // d8.w2
    public final String toString() {
        return x1.f2208g + "\t\t\t\t" + f4.f1995a.d(this.f2196b) + "\t" + k();
    }
}
