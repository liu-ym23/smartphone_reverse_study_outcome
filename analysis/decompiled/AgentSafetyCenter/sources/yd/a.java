package yd;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public int f16119c;

    /* renamed from: f, reason: collision with root package name */
    public int f16120f;

    /* renamed from: g, reason: collision with root package name */
    public int f16121g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f16122h;
    public int i;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r4 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(int r10, int r11) {
        /*
            r9 = this;
            int[] r0 = r9.f16122h
            float r11 = (float) r11
            r1 = 1073741824(0x40000000, float:2.0)
            float r11 = r11 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r11 = r11 - r1
            int r9 = r9.i
            r1 = r9
        Lc:
            java.lang.String r2 = " ... "
            java.lang.String r3 = ""
            if (r1 <= 0) goto L2d
            int r4 = r1 + (-1)
            r4 = r0[r4]
            fe.a r5 = fe.a.f4071e
            boolean r4 = r5.a(r4)
            if (r4 != 0) goto L2d
            int r4 = r1 + (-1)
            int r5 = r9 - r4
            float r5 = (float) r5
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L2b
            int r1 = r1 + 4
            r4 = r2
            goto L2e
        L2b:
            r1 = r4
            goto Lc
        L2d:
            r4 = r3
        L2e:
            r5 = r9
        L2f:
            int r6 = r0.length
            if (r5 >= r6) goto L4a
            r6 = r0[r5]
            fe.a r7 = fe.a.f4071e
            boolean r6 = r7.a(r6)
            if (r6 != 0) goto L4a
            int r6 = r5 + 1
            int r7 = r6 - r9
            float r7 = (float) r7
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 <= 0) goto L48
            int r5 = r5 + (-4)
            goto L4b
        L48:
            r5 = r6
            goto L2f
        L4a:
            r2 = r3
        L4b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r3 = 0
            r6 = r3
        L52:
            java.lang.String r7 = " "
            if (r6 >= r10) goto L5c
            r11.append(r7)
            int r6 = r6 + 1
            goto L52
        L5c:
            r11.append(r4)
            r6 = r1
        L60:
            if (r6 >= r5) goto L6a
            r8 = r0[r6]
            r11.appendCodePoint(r8)
            int r6 = r6 + 1
            goto L60
        L6a:
            r11.append(r2)
            java.lang.String r0 = "\n"
            r11.append(r0)
        L72:
            int r0 = r10 + r9
            int r0 = r0 - r1
            int r2 = r4.length()
            int r2 = r2 + r0
            if (r3 >= r2) goto L82
            r11.append(r7)
            int r3 = r3 + 1
            goto L72
        L82:
            java.lang.String r9 = "^"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: yd.a.a(int, int):java.lang.String");
    }

    public final String toString() {
        return " in 'reader', line " + (this.f16120f + 1) + ", column " + (this.f16121g + 1) + ":\n" + a(4, 75);
    }
}
