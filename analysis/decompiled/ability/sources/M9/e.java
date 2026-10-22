package M9;

import okio.ByteString;
import s2.C1912a;

/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f980a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;

    static {
        ByteString byteString = ByteString.d;
        f980a = C1912a.i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        c = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            kotlin.jvm.internal.k.e(binaryString, "toBinaryString(it)");
            strArr[i] = j9.t.b0(G9.b.g("%8s", binaryString), ' ', '0');
        }
        d = strArr;
        String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i6 = iArr[0];
        strArr2[i6 | 8] = B7.a.q(new StringBuilder(), strArr2[i6], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr2[i10];
            int i12 = iArr[0];
            String[] strArr3 = c;
            int i13 = i12 | i11;
            strArr3[i13] = strArr3[i12] + '|' + strArr3[i11];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i12]);
            sb.append('|');
            strArr3[i13 | 8] = B7.a.q(sb, strArr3[i11], "|PADDED");
        }
        int length = c.length;
        for (int i14 = 0; i14 < length; i14++) {
            String[] strArr4 = c;
            if (strArr4[i14] == null) {
                strArr4[i14] = d[i14];
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
            java.lang.String[] r0 = M9.e.b
            int r1 = r0.length
            if (r7 >= r1) goto L8
            r0 = r0[r7]
            goto L16
        L8:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "0x%02x"
            java.lang.String r0 = G9.b.g(r1, r0)
        L16:
            if (r8 != 0) goto L1b
            java.lang.String r7 = ""
            goto L69
        L1b:
            r1 = 2
            java.lang.String[] r2 = M9.e.d
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
            java.lang.String[] r1 = M9.e.c
            int r3 = r1.length
            if (r8 >= r3) goto L3b
            r1 = r1[r8]
            kotlin.jvm.internal.k.c(r1)
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
            java.lang.String r7 = j9.t.c0(r1, r7, r8)
            goto L69
        L4d:
            if (r7 != 0) goto L5c
            r7 = r8 & 32
            if (r7 == 0) goto L5c
            java.lang.String r7 = "PRIORITY"
            java.lang.String r8 = "COMPRESSED"
            java.lang.String r7 = j9.t.c0(r1, r7, r8)
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
            java.lang.String r4 = G9.b.g(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: M9.e.a(boolean, int, int, int, int):java.lang.String");
    }
}
