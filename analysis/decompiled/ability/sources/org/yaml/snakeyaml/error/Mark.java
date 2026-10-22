package org.yaml.snakeyaml.error;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class Mark implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f5523a;
    public final int b;
    public final int c;
    public final int[] d;
    public final int e;

    public Mark(int i, int i6, int i10, int i11, int[] iArr) {
        this.f5523a = i;
        this.b = i6;
        this.c = i10;
        this.d = iArr;
        this.e = i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r9 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(int r10, int r11) {
        /*
            r9 = this;
            float r11 = (float) r11
            r0 = 1073741824(0x40000000, float:2.0)
            float r11 = r11 / r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r11 = r11 - r0
            int r0 = r9.e
            r1 = r0
        La:
            java.lang.String r2 = " ... "
            int[] r3 = r9.d
            java.lang.String r4 = ""
            if (r1 <= 0) goto L2d
            int r5 = r1 + (-1)
            r5 = r3[r5]
            na.a r6 = na.C1751a.e
            boolean r5 = r6.a(r5)
            if (r5 != 0) goto L2d
            int r5 = r1 + (-1)
            int r6 = r0 - r5
            float r6 = (float) r6
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 <= 0) goto L2b
            int r1 = r1 + 4
            r9 = r2
            goto L2e
        L2b:
            r1 = r5
            goto La
        L2d:
            r9 = r4
        L2e:
            r5 = r0
        L2f:
            int r6 = r3.length
            if (r5 >= r6) goto L4a
            r6 = r3[r5]
            na.a r7 = na.C1751a.e
            boolean r6 = r7.a(r6)
            if (r6 != 0) goto L4a
            int r6 = r5 + 1
            int r7 = r6 - r0
            float r7 = (float) r7
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 <= 0) goto L48
            int r5 = r5 + (-4)
            goto L4b
        L48:
            r5 = r6
            goto L2f
        L4a:
            r2 = r4
        L4b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r4 = 0
            r6 = r4
        L52:
            java.lang.String r7 = " "
            if (r6 >= r10) goto L5c
            r11.append(r7)
            int r6 = r6 + 1
            goto L52
        L5c:
            r11.append(r9)
            r6 = r1
        L60:
            if (r6 >= r5) goto L6a
            r8 = r3[r6]
            r11.appendCodePoint(r8)
            int r6 = r6 + 1
            goto L60
        L6a:
            r11.append(r2)
            java.lang.String r2 = "\n"
            r11.append(r2)
        L72:
            int r2 = r10 + r0
            int r2 = r2 - r1
            int r3 = r9.length()
            int r3 = r3 + r2
            if (r4 >= r3) goto L82
            r11.append(r7)
            int r4 = r4 + 1
            goto L72
        L82:
            java.lang.String r9 = "^"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.error.Mark.a(int, int):java.lang.String");
    }

    public final String toString() {
        return " in 'reader', line " + (this.b + 1) + ", column " + (this.c + 1) + ":\n" + a(4, 75);
    }
}
