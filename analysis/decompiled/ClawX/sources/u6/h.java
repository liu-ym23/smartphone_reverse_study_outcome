package u6;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final c7.i f5702a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f5703b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f5704c;
    public static final String[] d;

    static {
        c7.i iVar = c7.i.d;
        f5702a = t1.f.f("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f5703b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f5704c = new String[64];
        String[] strArr = new String[256];
        for (int i8 = 0; i8 < 256; i8++) {
            String binaryString = Integer.toBinaryString(i8);
            kotlin.jvm.internal.p.d(binaryString, "toBinaryString(...)");
            strArr[i8] = x5.u.Z0(o6.f.d("%8s", binaryString), ' ', '0');
        }
        d = strArr;
        String[] strArr2 = f5704c;
        strArr2[0] = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i9 = iArr[0];
        strArr2[i9 | 8] = m0.f.f(new StringBuilder(), strArr2[i9], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr2[i10];
            int i12 = iArr[0];
            String[] strArr3 = f5704c;
            int i13 = i12 | i11;
            strArr3[i13] = strArr3[i12] + '|' + strArr3[i11];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i12]);
            sb.append('|');
            strArr3[i13 | 8] = m0.f.f(sb, strArr3[i11], "|PADDED");
        }
        int length = f5704c.length;
        for (int i14 = 0; i14 < length; i14++) {
            String[] strArr4 = f5704c;
            if (strArr4[i14] == null) {
                strArr4[i14] = d[i14];
            }
        }
    }

    public static String a(int i8) {
        String[] strArr = f5703b;
        return i8 < strArr.length ? strArr[i8] : o6.f.d("0x%02x", Integer.valueOf(i8));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            java.lang.String r0 = a(r7)
            if (r8 != 0) goto L9
            java.lang.String r7 = ""
            goto L57
        L9:
            r1 = 2
            java.lang.String[] r2 = u6.h.d
            if (r7 == r1) goto L55
            r1 = 3
            if (r7 == r1) goto L55
            r1 = 4
            if (r7 == r1) goto L4c
            r1 = 6
            if (r7 == r1) goto L4c
            r1 = 7
            if (r7 == r1) goto L55
            r1 = 8
            if (r7 == r1) goto L55
            java.lang.String[] r1 = u6.h.f5704c
            int r3 = r1.length
            if (r8 >= r3) goto L29
            r1 = r1[r8]
            kotlin.jvm.internal.p.b(r1)
            goto L2b
        L29:
            r1 = r2[r8]
        L2b:
            r2 = 5
            if (r7 != r2) goto L3b
            r2 = r8 & 4
            if (r2 == 0) goto L3b
            java.lang.String r7 = "HEADERS"
            java.lang.String r8 = "PUSH_PROMISE"
            java.lang.String r7 = x5.u.a1(r1, r7, r8)
            goto L57
        L3b:
            if (r7 != 0) goto L4a
            r7 = r8 & 32
            if (r7 == 0) goto L4a
            java.lang.String r7 = "PRIORITY"
            java.lang.String r8 = "COMPRESSED"
            java.lang.String r7 = x5.u.a1(r1, r7, r8)
            goto L57
        L4a:
            r7 = r1
            goto L57
        L4c:
            r7 = 1
            if (r8 != r7) goto L52
            java.lang.String r7 = "ACK"
            goto L57
        L52:
            r7 = r2[r8]
            goto L57
        L55:
            r7 = r2[r8]
        L57:
            if (r4 == 0) goto L5c
            java.lang.String r4 = "<<"
            goto L5e
        L5c:
            java.lang.String r4 = ">>"
        L5e:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5, r6, r0, r7}
            java.lang.String r5 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r4 = o6.f.d(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.h.b(boolean, int, int, int, int):java.lang.String");
    }

    public static String c(boolean z, int i8, int i9, long j4) {
        return o6.f.d("%s 0x%08x %5d %-13s %d", z ? "<<" : ">>", Integer.valueOf(i8), Integer.valueOf(i9), a(8), Long.valueOf(j4));
    }
}
