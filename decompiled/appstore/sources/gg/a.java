package gg;

import com.bytedanceos.common.model.AppInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import fg.b;
import fg.c;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f20135a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f20136b = null;

    static {
        f20135a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f20136b = ByteString.Companion.f(new byte[0]);
    }

    public static final String A(ByteString r20) {
        q.h(r20, "$receiver");
        if (r20.getData$jvm().length != 0) goto L6;
        return "[size=0]";
    L6:
        int r10 = a(r20.getData$jvm(), 64);
        if (r10 == (-1)) goto L9;
        String r11 = r20.utf8();
        if (r11 == null) goto L21;
        String r12 = r11.substring(0, r10);
        q.c(r12, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String r13 = o.x(o.x(o.x(r12, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r10 >= r11.length()) goto L19;
        return "[size=" + r20.getData$jvm().length + " text=" + r13 + "…]";
    L19:
        return "[text=" + r13 + ']';
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L9:
        if (r20.getData$jvm().length > 64) goto L12;
        return "[hex=" + r20.hex() + ']';
    L12:
        return "[size=" + r20.getData$jvm().length + " hex=" + w(r20, 0, 64).hex() + "…]";
    }

    public static final String B(ByteString r10) {
        q.h(r10, "$receiver");
        String r11 = r10.getUtf8$jvm();
        if (r11 != null) goto L6;
        String r12 = b.c(r10.internalArray$jvm());
        r10.setUtf8$jvm(r12);
        return r12;
    L6:
        return r11;
    }

    public static final int C(char r10) {
        if ('0' > r10) goto L9;
        if ('9' < r10) goto L9;
        return r10 - '0';
    L9:
        if ('a' > r10) goto L15;
        if ('f' < r10) goto L15;
        return r10 - 'W';
    L15:
        if ('A' > r10) goto L21;
        if ('F' < r10) goto L21;
        return r10 - '7';
    L21:
        throw new IllegalArgumentException("Unexpected hex digit: " + r10);
    }

    public static final ByteString D() {
        return f20136b;
    }

    public static final int a(byte[] r18, int r19) {
        int r10 = r18.length;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r11 >= r10) goto L191;
        byte r14 = r18[r11];
        if (r14 >= 0) goto L6;
        if ((r14 >> 5) == (-2)) goto L46;
        if ((r14 >> 4) != (-2)) goto L130;
        int r15 = r11 + 2;
        if (r10 <= r15) goto L83;
        byte r16 = r18[r11 + 1];
        if ((r16 & 192) != 128) goto L126;
        byte r17 = r18[r15];
        if ((r17 & 192) != 128) goto L123;
        int r20 = (r14 << Ascii.FF) ^ ((r17 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (r16 << 6));
        if (r20 < 2048) goto L92;
        if (55296 > r20) goto L101;
        if (57343 < r20) goto L101;
        if (r13 != r19) goto L100;
        return r12;
    L100:
        return -1;
    L101:
        int r21 = r13 + 1;
        if (r13 == r19) goto L103;
        if (r20 == 10) goto L115;
        if (r20 == 13) goto L115;
        if (r20 < 0) goto L109;
        if (31 < r20) goto L109;
    L116:
        return -1;
    L109:
        if (127 > r20) goto L115;
        if (159 >= r20) goto L116;
    L115:
        if (r20 == 65533) goto L116;
        if (r20 >= 65536) goto L120;
        int r110 = 1;
    L121:
        r12 = r12 + r110;
        r11 = r11 + 3;
    L122:
        r13 = r21;
        goto L3
    L120:
        r110 = 2;
        goto L121
    L103:
        return r12;
    L92:
        if (r13 != r19) goto L94;
        return r12;
    L94:
        return -1;
    L123:
        if (r13 != r19) goto L125;
        return r12;
    L125:
        return -1;
    L126:
        if (r13 != r19) goto L128;
        return r12;
    L128:
        return -1;
    L83:
        if (r13 != r19) goto L85;
        return r12;
    L85:
        return -1;
    L130:
        if ((r14 >> 3) != (-2)) goto L188;
        int r22 = r11 + 3;
        if (r10 <= r22) goto L133;
        byte r111 = r18[r11 + 1];
        if ((r111 & 192) != 128) goto L185;
        byte r112 = r18[r11 + 2];
        if ((r112 & 192) != 128) goto L182;
        byte r23 = r18[r22];
        if ((r23 & 192) != 128) goto L179;
        int r24 = (r14 << Ascii.DC2) ^ (((r23 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (r112 << 6)) ^ (r111 << Ascii.FF));
        if (r24 > 1114111) goto L144;
        if (55296 > r24) goto L153;
        if (57343 < r24) goto L153;
        if (r13 != r19) goto L152;
        return r12;
    L152:
        return -1;
    L153:
        if (r24 < 65536) goto L154;
        r21 = r13 + 1;
        if (r13 == r19) goto L159;
        if (r24 == 10) goto L172;
        if (r24 == 13) goto L172;
        if (r24 < 0) goto L166;
        if (31 < r24) goto L166;
    L173:
        return -1;
    L166:
        if (127 > r24) goto L172;
        if (159 >= r24) goto L173;
    L172:
        if (r24 == 65533) goto L173;
        if (r24 >= 65536) goto L177;
        int r113 = 1;
    L178:
        r12 = r12 + r113;
        r11 = r11 + 4;
        goto L122
    L177:
        r113 = 2;
        goto L178
    L159:
        return r12;
    L154:
        if (r13 != r19) goto L156;
        return r12;
    L156:
        return -1;
    L144:
        if (r13 != r19) goto L146;
        return r12;
    L146:
        return -1;
    L179:
        if (r13 != r19) goto L181;
        return r12;
    L181:
        return -1;
    L182:
        if (r13 != r19) goto L184;
        return r12;
    L184:
        return -1;
    L185:
        if (r13 != r19) goto L187;
        return r12;
    L187:
        return -1;
    L133:
        if (r13 != r19) goto L135;
        return r12;
    L135:
        return -1;
    L188:
        if (r13 != r19) goto L190;
        return r12;
    L190:
        return -1;
    L46:
        int r114 = r11 + 1;
        if (r10 <= r114) goto L48;
        byte r115 = r18[r114];
        if ((r115 & 192) != 128) goto L76;
        int r25 = (r14 << 6) ^ (r115 ^ UnsignedBytes.MAX_POWER_OF_TWO);
        if (r25 < 128) goto L55;
        int r116 = r13 + 1;
        if (r13 == r19) goto L60;
        if (r25 == 10) goto L69;
        if (r25 == 13) goto L69;
        if (r25 < 0) goto L65;
        if (31 < r25) goto L65;
    L70:
        return -1;
    L65:
        if (127 > r25) goto L69;
        if (159 >= r25) goto L70;
    L69:
        if (r25 == 65533) goto L70;
        if (r25 >= 65536) goto L74;
        int r117 = 1;
    L75:
        r12 = r12 + r117;
        r11 = r11 + 2;
        r13 = r116;
        goto L3
    L74:
        r117 = 2;
        goto L75
    L60:
        return r12;
    L55:
        if (r13 != r19) goto L57;
        return r12;
    L57:
        return -1;
    L76:
        if (r13 != r19) goto L78;
        return r12;
    L78:
        return -1;
    L48:
        if (r13 != r19) goto L50;
        return r12;
    L50:
        return -1;
    L6:
        int r118 = r13 + 1;
        if (r13 == r19) goto L8;
        if (r14 == 10) goto L17;
        if (r14 == 13) goto L17;
        if (r14 < 0) goto L13;
        if (31 < r14) goto L13;
    L18:
        return -1;
    L13:
        if (127 > r14) goto L17;
        if (159 >= r14) goto L18;
    L17:
        if (r14 == 65533) goto L18;
        if (r14 >= 65536) goto L21;
        int r26 = 1;
    L22:
        r12 = r12 + r26;
        r11 = r11 + 1;
    L23:
        r13 = r118;
        if (r11 >= r10) goto L3;
        byte r27 = r18[r11];
        if (r27 < 0) goto L3;
        r11 = r11 + 1;
        r118 = r13 + 1;
        if (r13 == r19) goto L29;
        if (r27 == 10) goto L38;
        if (r27 == 13) goto L38;
        if (r27 < 0) goto L34;
        if (31 < r27) goto L34;
    L39:
        return -1;
    L34:
        if (127 > r27) goto L38;
        if (159 >= r27) goto L39;
    L38:
        if (r27 == 65533) goto L39;
        if (r27 >= 65536) goto L42;
        int r28 = 1;
    L43:
        r12 = r12 + r28;
        goto L23
    L42:
        r28 = 2;
        goto L43
    L29:
        return r12;
    L21:
        r26 = 2;
        goto L22
    L8:
        return r12;
    L191:
        return r12;
    }

    public static final String b(ByteString r10) {
        q.h(r10, "$receiver");
        return fg.a.c(r10.getData$jvm(), null, 1, null);
    }

    public static final String c(ByteString r10) {
        q.h(r10, "$receiver");
        return fg.a.b(r10.getData$jvm(), fg.a.d());
    }

    public static final int d(ByteString r10, ByteString r11) {
        q.h(r10, "$receiver");
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        int r12 = r10.size();
        int r13 = r11.size();
        int r14 = Math.min(r12, r13);
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L12;
        int r16 = r10.getByte(r15) & UnsignedBytes.MAX_VALUE;
        int r17 = r11.getByte(r15) & UnsignedBytes.MAX_VALUE;
        if (r16 != r17) goto L8;
        r15 = r15 + 1;
        goto L4
    L8:
        if (r16 >= r17) goto L11;
        return -1;
    L11:
        return 1;
    L12:
        if (r12 != r13) goto L14;
        return 0;
    L14:
        if (r12 >= r13) goto L17;
        return -1;
    L17:
        return 1;
    }

    public static final ByteString e(String r10) {
        q.h(r10, "$receiver");
        byte[] r11 = fg.a.a(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new ByteString(r11);
    }

    public static final ByteString f(String r10) {
        q.h(r10, "$receiver");
        if ((r10.length() % 2) != 0) goto L10;
        int r11 = r10.length() / 2;
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L8;
        int r14 = r13 * 2;
        r12[r13] = (byte) ((C(r10.charAt(r14)) << 4) + C(r10.charAt(r14 + 1)));
        r13 = r13 + 1;
        goto L5
    L8:
        return new ByteString(r12);
    L10:
        throw new IllegalArgumentException(("Unexpected hex string: " + r10).toString());
    }

    public static final ByteString g(String r10) {
        q.h(r10, "$receiver");
        ByteString r11 = new ByteString(b.b(r10));
        r11.setUtf8$jvm(r10);
        return r11;
    }

    public static final boolean h(ByteString r10, ByteString r11) {
        q.h(r10, "$receiver");
        q.h(r11, "suffix");
        return r10.rangeEquals(r10.size() - r11.size(), r11, 0, r11.size());
    }

    public static final boolean i(ByteString r10, byte[] r11) {
        q.h(r10, "$receiver");
        q.h(r11, "suffix");
        return r10.rangeEquals(r10.size() - r11.length, r11, 0, r11.length);
    }

    public static final boolean j(ByteString r10, Object r11) {
        q.h(r10, "$receiver");
        if (r11 != r10) goto L6;
        return true;
    L6:
        if ((r11 instanceof ByteString) == false) goto L13;
        ByteString r12 = (ByteString) r11;
        if (r12.size() != r10.getData$jvm().length) goto L13;
        if (r12.rangeEquals(0, r10.getData$jvm(), 0, r10.getData$jvm().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static final byte k(ByteString r10, int r11) {
        q.h(r10, "$receiver");
        return r10.getData$jvm()[r11];
    }

    public static final int l(ByteString r10) {
        q.h(r10, "$receiver");
        return r10.getData$jvm().length;
    }

    public static final int m(ByteString r10) {
        q.h(r10, "$receiver");
        int r11 = r10.getHashCode$jvm();
        if (r11 == 0) goto L5;
        return r11;
    L5:
        r10.setHashCode$jvm(Arrays.hashCode(r10.getData$jvm()));
        return r10.getHashCode$jvm();
    }

    public static final String n(ByteString r10) {
        q.h(r10, "$receiver");
        char[] r11 = new char[r10.getData$jvm().length * 2];
        byte[] r12 = r10.getData$jvm();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L6;
        byte r16 = r12[r14];
        int r17 = r15 + 1;
        char[] r18 = f20135a;
        r11[r15] = r18[(r16 >> 4) & 15];
        r15 = r15 + 2;
        r11[r17] = r18[r16 & Ascii.SI];
        r14 = r14 + 1;
        goto L3
    L6:
        return new String(r11);
    }

    public static final int o(ByteString r10, byte[] r11, int r12) {
        q.h(r10, "$receiver");
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        int r13 = r10.getData$jvm().length - r11.length;
        int r14 = Math.max(r12, 0);
        if (r14 <= r13) goto L5;
        return -1;
    L5:
        if (c.a(r10.getData$jvm(), r14, r11, 0, r11.length) == true) goto L6;
        if (r14 == r13) goto L13;
        r14 = r14 + 1;
        goto L5
    L13:
        return -1;
    L6:
        return r14;
    }

    public static final byte[] p(ByteString r10) {
        q.h(r10, "$receiver");
        return r10.getData$jvm();
    }

    public static final int q(ByteString r10, byte[] r11, int r12) {
        q.h(r10, "$receiver");
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        int r13 = Math.min(r12, r10.getData$jvm().length - r11.length);
    L3:
        if (r13 < 0) goto L8;
        if (c.a(r10.getData$jvm(), r13, r11, 0, r11.length) == true) goto L6;
        r13 = r13 - 1;
        goto L3
    L6:
        return r13;
    L8:
        return -1;
    }

    public static final ByteString r(byte[] r10) {
        q.h(r10, "data");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        q.c(r11, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(r11);
    }

    public static final boolean s(ByteString r10, int r11, ByteString r12, int r13, int r14) {
        q.h(r10, "$receiver");
        q.h(r12, AppInfo.SEARCH_SOURCE_EXTENAL);
        return r12.rangeEquals(r13, r10.getData$jvm(), r11, r14);
    }

    public static final boolean t(ByteString r10, int r11, byte[] r12, int r13, int r14) {
        q.h(r10, "$receiver");
        q.h(r12, AppInfo.SEARCH_SOURCE_EXTENAL);
        if (r11 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r11 > (r10.getData$jvm().length - r14)) goto L12;
        if (r13 < 0) goto L12;
        if (r13 > (r12.length - r14)) goto L12;
        if (c.a(r10.getData$jvm(), r11, r12, r13, r14) == false) goto L12;
        return true;
    }

    public static final boolean u(ByteString r10, ByteString r11) {
        q.h(r10, "$receiver");
        q.h(r11, "prefix");
        return r10.rangeEquals(0, r11, 0, r11.size());
    }

    public static final boolean v(ByteString r10, byte[] r11) {
        q.h(r10, "$receiver");
        q.h(r11, "prefix");
        return r10.rangeEquals(0, r11, 0, r11.length);
    }

    public static final ByteString w(ByteString r10, int r11, int r12) {
        q.h(r10, "$receiver");
        if (r11 < 0) goto L19;
        if (r12 > r10.getData$jvm().length) goto L17;
        int r13 = r12 - r11;
        if (r13 < 0) goto L15;
        if (r11 == 0) goto L10;
    L12:
        byte[] r14 = new byte[r13];
        b.a(r10.getData$jvm(), r11, r14, 0, r13);
        return new ByteString(r14);
    L10:
        if (r12 != r10.getData$jvm().length) goto L12;
        return r10;
    L15:
        throw new IllegalArgumentException("endIndex < beginIndex");
    L17:
        throw new IllegalArgumentException(("endIndex > length(" + r10.getData$jvm().length + ')').toString());
    L19:
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public static final ByteString x(ByteString r10) {
        q.h(r10, "$receiver");
        int r11 = 0;
    L4:
        if (r11 >= r10.getData$jvm().length) goto L22;
        byte r12 = r10.getData$jvm()[r11];
        byte r13 = (byte) 65;
        if (r12 < r13) goto L21;
        byte r14 = (byte) 90;
        if (r12 > r14) goto L21;
        byte[] r15 = r10.getData$jvm();
        byte[] r16 = Arrays.copyOf(r15, r15.length);
        q.c(r16, "java.util.Arrays.copyOf(this, size)");
        int r17 = r11 + 1;
        r16[r11] = (byte) (r12 + 32);
    L12:
        if (r17 >= r16.length) goto L20;
        byte r18 = r16[r17];
        if (r18 < r13) goto L18;
        if (r18 > r14) goto L18;
        r16[r17] = (byte) (r18 + 32);
    L18:
        r17 = r17 + 1;
        goto L12
    L20:
        return new ByteString(r16);
    L21:
        r11 = r11 + 1;
        goto L4
    L22:
        return r10;
    }

    public static final ByteString y(ByteString r10) {
        q.h(r10, "$receiver");
        int r11 = 0;
    L4:
        if (r11 >= r10.getData$jvm().length) goto L22;
        byte r12 = r10.getData$jvm()[r11];
        byte r13 = (byte) 97;
        if (r12 < r13) goto L21;
        byte r14 = (byte) 122;
        if (r12 > r14) goto L21;
        byte[] r15 = r10.getData$jvm();
        byte[] r16 = Arrays.copyOf(r15, r15.length);
        q.c(r16, "java.util.Arrays.copyOf(this, size)");
        int r17 = r11 + 1;
        r16[r11] = (byte) (r12 - 32);
    L12:
        if (r17 >= r16.length) goto L20;
        byte r18 = r16[r17];
        if (r18 < r13) goto L18;
        if (r18 > r14) goto L18;
        r16[r17] = (byte) (r18 - 32);
    L18:
        r17 = r17 + 1;
        goto L12
    L20:
        return new ByteString(r16);
    L21:
        r11 = r11 + 1;
        goto L4
    L22:
        return r10;
    }

    public static final byte[] z(ByteString r10) {
        q.h(r10, "$receiver");
        byte[] r11 = r10.getData$jvm();
        byte[] r12 = Arrays.copyOf(r11, r11.length);
        q.c(r12, "java.util.Arrays.copyOf(this, size)");
        return r12;
    }
}
