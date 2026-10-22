package fg;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f19686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f19687b = null;

    static {
        ByteString.a r10 = ByteString.Companion;
        f19686a = r10.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$jvm();
        f19687b = r10.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$jvm();
    }

    public static final byte[] a(String r15) {
        kotlin.jvm.internal.q.h(r15, "$receiver");
        int r10 = r15.length();
    L4:
        if (r10 <= 0) goto L13;
        char r11 = r15.charAt(r10 - 1);
        if (r11 == '=') goto L12;
        if (r11 == '\n') goto L12;
        if (r11 == '\r') goto L12;
        if (r11 == ' ') goto L12;
        if (r11 != '\t') goto L13;
    L12:
        r10 = r10 - 1;
    L13:
        int r12 = (int) ((((long) r10) * 6) / 8);
        byte[] r13 = new byte[r12];
        int r14 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L15:
        if (r14 >= r10) goto L56;
        char r19 = r15.charAt(r14);
        if ('A' > r19) goto L23;
        if ('Z' < r19) goto L23;
        int r110 = r19 - 'A';
    L52:
        r17 = (r17 << 6) | r110;
        r16 = r16 + 1;
        if ((r16 % 4) != 0) goto L55;
        r13[r18] = (byte) (r17 >> 16);
        int r111 = r18 + 2;
        r13[r18 + 1] = (byte) (r17 >> 8);
        r18 = r18 + 3;
        r13[r111] = (byte) r17;
    L55:
        r14 = r14 + 1;
    L23:
        if ('a' > r19) goto L29;
        if ('z' < r19) goto L29;
        r110 = r19 - 'G';
    L29:
        if ('0' > r19) goto L35;
        if ('9' < r19) goto L35;
        r110 = r19 + 4;
    L35:
        if (r19 != '+') goto L37;
    L51:
        r110 = 62;
        goto L52
    L37:
        if (r19 == '-') goto L51;
        if (r19 != '/') goto L42;
    L50:
        r110 = 63;
        goto L52
    L42:
        if (r19 == '_') goto L50;
        if (r19 == '\n') goto L55;
        if (r19 == '\r') goto L55;
        if (r19 == ' ') goto L55;
        if (r19 == '\t') goto L55;
        return null;
    L56:
        int r20 = r16 % 4;
        if (r20 != 1) goto L59;
        return null;
    L59:
        if (r20 != 2) goto L61;
        r13[r18] = (byte) ((r17 << 12) >> 16);
        r18 = r18 + 1;
    L65:
        if (r18 != r12) goto L67;
        return r13;
    L67:
        byte[] r112 = new byte[r18];
        b.a(r13, 0, r112, 0, r18);
        return r112;
    L61:
        if (r20 != 3) goto L65;
        int r113 = r17 << 6;
        int r21 = r18 + 1;
        r13[r18] = (byte) (r113 >> 16);
        r18 = r18 + 2;
        r13[r21] = (byte) (r113 >> 8);
        goto L65
    }

    public static final String b(byte[] r11, byte[] r12) {
        kotlin.jvm.internal.q.h(r11, "$receiver");
        kotlin.jvm.internal.q.h(r12, "map");
        byte[] r10 = new byte[((r11.length + 2) / 3) * 4];
        int r13 = r11.length - (r11.length % 3);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        byte r16 = r11[r14];
        int r17 = r14 + 2;
        byte r18 = r11[r14 + 1];
        r14 = r14 + 3;
        byte r19 = r11[r17];
        r10[r15] = r12[(r16 & UnsignedBytes.MAX_VALUE) >> 2];
        r10[r15 + 1] = r12[((r16 & 3) << 4) | ((r18 & UnsignedBytes.MAX_VALUE) >> 4)];
        int r20 = r15 + 3;
        r10[r15 + 2] = r12[((r18 & Ascii.SI) << 2) | ((r19 & UnsignedBytes.MAX_VALUE) >> 6)];
        r15 = r15 + 4;
        r10[r20] = r12[r19 & 63];
        goto L3
    L5:
        int r21 = r11.length - r13;
        if (r21 == 1) goto L10;
        if (r21 != 2) goto L12;
        int r22 = r14 + 1;
        byte r23 = r11[r14];
        byte r110 = r11[r22];
        r10[r15] = r12[(r23 & UnsignedBytes.MAX_VALUE) >> 2];
        r10[r15 + 1] = r12[((r23 & 3) << 4) | ((r110 & UnsignedBytes.MAX_VALUE) >> 4)];
        r10[r15 + 2] = r12[(r110 & Ascii.SI) << 2];
        r10[r15 + 3] = (byte) 61;
    L12:
        return b.c(r10);
    L10:
        byte r111 = r11[r14];
        r10[r15] = r12[(r111 & UnsignedBytes.MAX_VALUE) >> 2];
        r10[r15 + 1] = r12[(r111 & 3) << 4];
        byte r112 = (byte) 61;
        r10[r15 + 2] = r112;
        r10[r15 + 3] = r112;
        goto L12
    }

    public static /* bridge */ /* synthetic */ String c(byte[] r10, byte[] r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = f19686a;
    L6:
        return b(r10, r11);
    }

    public static final byte[] d() {
        return f19687b;
    }
}
