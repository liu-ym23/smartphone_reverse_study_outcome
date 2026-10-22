package m4;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3907a = 0;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[PHI: r7
      0x0050: PHI (r7v5 long) = (r7v4 long), (r7v3 long) binds: [B:18:0x005e, B:13:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            java.util.List r0 = k4.w.f3639e
            com.stepos.stepclaw.gateway.d r1 = new com.stepos.stepclaw.gateway.d
            r2 = 23
            r1.<init>(r2)
            a6.y r2 = new a6.y
            r3 = 12
            r2.<init>(r3)
            k4.z.e(r0, r1, r2)
            u5.f r0 = new u5.f
            r1 = 0
            r2 = 255(0xff, float:3.57E-43)
            r3 = 1
            r0.<init>(r1, r2, r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r5 = c5.o.n0(r0, r4)
            r2.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L2b:
            r5 = r0
            u5.e r5 = (u5.e) r5
            boolean r6 = r5.f5668c
            if (r6 == 0) goto L6b
            int r5 = r5.nextInt()
            r6 = 48
            if (r6 > r5) goto L43
            r6 = 58
            if (r5 >= r6) goto L43
            long r5 = (long) r5
            r7 = 48
            long r5 = r5 - r7
            goto L63
        L43:
            long r5 = (long) r5
            r7 = 97
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L54
            r9 = 102(0x66, double:5.04E-322)
            int r9 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r9 > 0) goto L54
        L50:
            long r5 = r5 - r7
            long r7 = (long) r4
            long r5 = r5 + r7
            goto L63
        L54:
            r7 = 65
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L61
            r9 = 70
            int r9 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r9 > 0) goto L61
            goto L50
        L61:
            r5 = -1
        L63:
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r2.add(r5)
            goto L2b
        L6b:
            int r0 = r2.size()
            long[] r0 = new long[r0]
            int r5 = r2.size()
            r6 = r1
            r7 = r6
        L77:
            if (r7 >= r5) goto L8b
            java.lang.Object r8 = r2.get(r7)
            int r7 = r7 + 1
            java.lang.Number r8 = (java.lang.Number) r8
            long r8 = r8.longValue()
            int r10 = r6 + 1
            r0[r6] = r8
            r6 = r10
            goto L77
        L8b:
            u5.f r0 = new u5.f
            r2 = 15
            r0.<init>(r1, r2, r3)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = c5.o.n0(r0, r4)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L9f:
            r2 = r0
            u5.e r2 = (u5.e) r2
            boolean r3 = r2.f5668c
            if (r3 == 0) goto Lbe
            int r2 = r2.nextInt()
            if (r2 >= r4) goto Lb0
            int r2 = r2 + 48
        Lae:
            byte r2 = (byte) r2
            goto Lb6
        Lb0:
            int r2 = r2 + 97
            char r2 = (char) r2
            int r2 = r2 - r4
            char r2 = (char) r2
            goto Lae
        Lb6:
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r1.add(r2)
            goto L9f
        Lbe:
            c5.m.L0(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.f.<clinit>():void");
    }

    public static final int a(CharSequence charSequence, int i8, int i9) {
        p.e(charSequence, "<this>");
        int i10 = 0;
        while (i8 < i9) {
            int iCharAt = charSequence.charAt(i8);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            i10 = (i10 * 31) + iCharAt;
            i8++;
        }
        return i10;
    }

    public static final void b(b bVar, int i8) {
        throw new NumberFormatException("Invalid number: " + ((Object) bVar) + ", wrong digit: " + bVar.charAt(i8) + " at position " + i8);
    }
}
