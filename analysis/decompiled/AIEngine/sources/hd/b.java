package hd;

import bd.l;
import gc.o;
import kotlin.jvm.internal.g;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f9414a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f9415b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f9416c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f9417d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f9418e;

    static {
        ByteString byteString = ByteString.f11312d;
        f9415b = ByteString.a.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f9416c = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f9417d = new String[64];
        String[] strArr = new String[256];
        for (int i10 = 0; i10 < 256; i10++) {
            String binaryString = Integer.toBinaryString(i10);
            g.e(binaryString, "toBinaryString(...)");
            strArr[i10] = o.h0(l.d("%8s", binaryString), ' ', '0');
        }
        f9418e = strArr;
        String[] strArr2 = f9417d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i11 = iArr[0];
        strArr2[i11 | 8] = ai.onnxruntime.a.o(new StringBuilder(), strArr2[i11], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i12 = 0; i12 < 3; i12++) {
            int i13 = iArr2[i12];
            int i14 = iArr[0];
            String[] strArr3 = f9417d;
            int i15 = i14 | i13;
            strArr3[i15] = strArr3[i14] + '|' + strArr3[i13];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i14]);
            sb2.append('|');
            strArr3[i15 | 8] = ai.onnxruntime.a.o(sb2, strArr3[i13], "|PADDED");
        }
        int length = f9417d.length;
        for (int i16 = 0; i16 < length; i16++) {
            String[] strArr4 = f9417d;
            if (strArr4[i16] == null) {
                strArr4[i16] = f9418e[i16];
            }
        }
    }

    public static String a(int i10) {
        String[] strArr = f9416c;
        return i10 < strArr.length ? strArr[i10] : l.d("0x%02x", Integer.valueOf(i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(int r4, int r5, int r6, int r7, boolean r8) {
        /*
            java.lang.String r0 = a(r6)
            if (r7 != 0) goto L9
            java.lang.String r6 = ""
            goto L57
        L9:
            r1 = 2
            java.lang.String[] r2 = hd.b.f9418e
            if (r6 == r1) goto L55
            r1 = 3
            if (r6 == r1) goto L55
            r1 = 4
            if (r6 == r1) goto L4c
            r1 = 6
            if (r6 == r1) goto L4c
            r1 = 7
            if (r6 == r1) goto L55
            r1 = 8
            if (r6 == r1) goto L55
            java.lang.String[] r1 = hd.b.f9417d
            int r3 = r1.length
            if (r7 >= r3) goto L29
            r1 = r1[r7]
            kotlin.jvm.internal.g.c(r1)
            goto L2b
        L29:
            r1 = r2[r7]
        L2b:
            r2 = 5
            if (r6 != r2) goto L3b
            r2 = r7 & 4
            if (r2 == 0) goto L3b
            java.lang.String r6 = "HEADERS"
            java.lang.String r7 = "PUSH_PROMISE"
            java.lang.String r6 = gc.o.i0(r1, r6, r7)
            goto L57
        L3b:
            if (r6 != 0) goto L4a
            r6 = r7 & 32
            if (r6 == 0) goto L4a
            java.lang.String r6 = "PRIORITY"
            java.lang.String r7 = "COMPRESSED"
            java.lang.String r6 = gc.o.i0(r1, r6, r7)
            goto L57
        L4a:
            r6 = r1
            goto L57
        L4c:
            r6 = 1
            if (r7 != r6) goto L52
            java.lang.String r6 = "ACK"
            goto L57
        L52:
            r6 = r2[r7]
            goto L57
        L55:
            r6 = r2[r7]
        L57:
            if (r8 == 0) goto L5c
            java.lang.String r7 = "<<"
            goto L5e
        L5c:
            java.lang.String r7 = ">>"
        L5e:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object[] r4 = new java.lang.Object[]{r7, r4, r5, r0, r6}
            java.lang.String r5 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r4 = bd.l.d(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.b.b(int, int, int, int, boolean):java.lang.String");
    }

    public static String c(boolean z, int i10, int i11, long j10) {
        return l.d("%s 0x%08x %5d %-13s %d", z ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), a(8), Long.valueOf(j10));
    }
}
