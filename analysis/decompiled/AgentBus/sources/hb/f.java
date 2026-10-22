package hb;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final ob.k f4285a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f4286b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f4287c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f4288d;

    static {
        ob.k kVar = ob.k.f7997i;
        f4285a = h4.n.j("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f4286b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f4287c = new String[64];
        String[] strArr = new String[256];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            q7.k.d(binaryString, "toBinaryString(it)");
            strArr[i2] = ga.r.d0(bb.b.i("%8s", binaryString), ' ', '0');
        }
        f4288d = strArr;
        String[] strArr2 = f4287c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = iArr[0];
        strArr2[i10 | 8] = a1.a.m(new StringBuilder(), strArr2[i10], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = f4287c;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i13]);
            sb2.append('|');
            strArr3[i14 | 8] = a1.a.m(sb2, strArr3[i12], "|PADDED");
        }
        int length = f4287c.length;
        for (int i15 = 0; i15 < length; i15++) {
            String[] strArr4 = f4287c;
            if (strArr4[i15] == null) {
                strArr4[i15] = f4288d[i15];
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            java.lang.String[] r0 = hb.f.f4286b
            int r1 = r0.length
            if (r7 >= r1) goto L8
            r0 = r0[r7]
            goto L16
        L8:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "0x%02x"
            java.lang.String r0 = bb.b.i(r1, r0)
        L16:
            if (r8 != 0) goto L1b
            java.lang.String r7 = ""
            goto L69
        L1b:
            r1 = 2
            java.lang.String[] r2 = hb.f.f4288d
            if (r7 == r1) goto L67
            r1 = 3
            if (r7 == r1) goto L67
            r1 = 4
            if (r7 == r1) goto L5e
            r1 = 6
            if (r7 == r1) goto L5e
            r1 = 7
            if (r7 == r1) goto L67
            r1 = 8
            if (r7 == r1) goto L67
            java.lang.String[] r1 = hb.f.f4287c
            int r3 = r1.length
            if (r8 >= r3) goto L3b
            r1 = r1[r8]
            q7.k.b(r1)
            goto L3d
        L3b:
            r1 = r2[r8]
        L3d:
            r2 = 5
            if (r7 != r2) goto L4d
            r2 = r8 & 4
            if (r2 == 0) goto L4d
            java.lang.String r7 = "HEADERS"
            java.lang.String r8 = "PUSH_PROMISE"
            java.lang.String r7 = ga.r.e0(r1, r7, r8)
            goto L69
        L4d:
            if (r7 != 0) goto L5c
            r7 = r8 & 32
            if (r7 == 0) goto L5c
            java.lang.String r7 = "PRIORITY"
            java.lang.String r8 = "COMPRESSED"
            java.lang.String r7 = ga.r.e0(r1, r7, r8)
            goto L69
        L5c:
            r7 = r1
            goto L69
        L5e:
            r7 = 1
            if (r8 != r7) goto L64
            java.lang.String r7 = "ACK"
            goto L69
        L64:
            r7 = r2[r8]
            goto L69
        L67:
            r7 = r2[r8]
        L69:
            if (r4 == 0) goto L6e
            java.lang.String r4 = "<<"
            goto L70
        L6e:
            java.lang.String r4 = ">>"
        L70:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5, r6, r0, r7}
            java.lang.String r5 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r4 = bb.b.i(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.f.a(boolean, int, int, int, int):java.lang.String");
    }
}
