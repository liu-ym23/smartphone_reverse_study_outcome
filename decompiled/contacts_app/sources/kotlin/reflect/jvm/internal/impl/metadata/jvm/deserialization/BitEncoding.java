package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes4.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING = false;

    private static /* synthetic */ void $$$reportNull$$$0(int r19) {
        if (r19 == 1) goto L11;
        if (r19 == 3) goto L11;
        if (r19 == 6) goto L11;
        if (r19 == 8) goto L11;
        if (r19 == 10) goto L11;
        if (r19 == 12) goto L11;
        if (r19 == 14) goto L11;
        String r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L13:
        if (r19 == 1) goto L21;
        if (r19 == 3) goto L21;
        if (r19 == 6) goto L21;
        if (r19 == 8) goto L21;
        if (r19 == 10) goto L21;
        if (r19 == 12) goto L21;
        if (r19 == 14) goto L21;
        int r10 = 3;
    L22:
        Object[] r11 = new Object[r10];
        if (r19 == 1) goto L31;
        if (r19 == 3) goto L31;
        if (r19 == 6) goto L31;
        if (r19 == 8) goto L31;
        if (r19 == 10) goto L31;
        if (r19 == 12) goto L31;
        if (r19 == 14) goto L31;
        r11[0] = "data";
    L33:
        if (r19 == 1) goto L47;
        if (r19 == 3) goto L46;
        if (r19 == 6) goto L45;
        if (r19 == 8) goto L44;
        if (r19 == 10) goto L43;
        if (r19 == 12) goto L42;
        if (r19 == 14) goto L41;
        r11[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
    L48:
        switch(r19) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L57;
            case 7: goto L53;
            case 8: goto L57;
            case 9: goto L52;
            case 10: goto L57;
            case 11: goto L51;
            case 12: goto L57;
            case 13: goto L50;
            case 14: goto L57;
            default: goto L49;
        };
    L49:
        r11[2] = "encodeBytes";
        goto L57
    L50:
        r11[2] = "decode7to8";
        goto L57
    L51:
        r11[2] = "combineStringArrayIntoBytes";
        goto L57
    L52:
        r11[2] = "dropMarker";
        goto L57
    L53:
        r11[2] = "decodeBytes";
        goto L57
    L54:
        r11[2] = "splitBytesToStringArray";
        goto L57
    L55:
        r11[2] = "addModuloByte";
        goto L57
    L56:
        r11[2] = "encode8to7";
    L57:
        String r9 = String.format(r8, r11);
        if (r19 == 1) goto L67;
        if (r19 == 3) goto L67;
        if (r19 == 6) goto L67;
        if (r19 == 8) goto L67;
        if (r19 == 10) goto L67;
        if (r19 == 12) goto L67;
        if (r19 == 14) goto L67;
        throw new IllegalArgumentException(r9);
    L67:
        throw new IllegalStateException(r9);
    L41:
        r11[1] = "decode7to8";
        goto L48
    L42:
        r11[1] = "combineStringArrayIntoBytes";
        goto L48
    L43:
        r11[1] = "dropMarker";
        goto L48
    L44:
        r11[1] = "decodeBytes";
        goto L48
    L45:
        r11[1] = "splitBytesToStringArray";
        goto L48
    L46:
        r11[1] = "encode8to7";
        goto L48
    L47:
        r11[1] = "encodeBytes";
    L31:
        r11[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
    L21:
        r10 = 2;
    L11:
        r8 = "@NotNull method %s.%s must not return null";
        goto L13
    }

    static {
        String r0 = System.getProperty("kotlin.jvm.serialization.use8to7");     // Catch: SecurityException -> L4
    L5:
        FORCE_8TO7_ENCODING = "true".equals(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    private BitEncoding() {
    }

    private static void addModuloByte(byte[] r3, int r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        r3[r1] = (byte) ((r3[r1] + r4) & WorkQueueKt.MASK);
        r1 = r1 + 1;
        goto L5
    }

    public static byte[] decodeBytes(String[] r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r2.length > 0) goto L7;
    L17:
        byte[] r3 = combineStringArrayIntoBytes(r2);
        addModuloByte(r3, WorkQueueKt.MASK);
        return decode7to8(r3);
    L7:
        if (r2[0].isEmpty() == true) goto L17;
        char r0 = r2[0].charAt(0);
        if (r0 != 0) goto L15;
        byte[] r4 = UtfEncodingKt.stringsToBytes(dropMarker(r2));
        if (r4 != null) goto L13;
        $$$reportNull$$$0(8);
    L13:
        return r4;
    L15:
        if (r0 != 65535) goto L17;
        r2 = dropMarker(r2);
        goto L17
    }

    private static String[] dropMarker(String[] r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        String[] r4 = (String[]) r3.clone();
        r4[0] = r4[0].substring(1);
        if (r4 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        return r4;
    }

    private static byte[] combineStringArrayIntoBytes(String[] r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        int r0 = r10.length;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r3 = r3 + r10[r2].length();
        r2 = r2 + 1;
        goto L5
    L7:
        byte[] r1 = new byte[r3];
        int r4 = r10.length;
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r5 >= r4) goto L13;
        String r7 = r10[r5];
        int r8 = r7.length();
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L12;
        r1[r6] = (byte) r7.charAt(r9);
        r9 = r9 + 1;
        r6 = r6 + 1;
        goto L10
    L12:
        r5 = r5 + 1;
        goto L8
    L13:
        return r1;
    }

    private static byte[] decode7to8(byte[] r11) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        int r0 = (r11.length * 7) / 8;
        byte[] r1 = new byte[r0];
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r3 >= r0) goto L11;
        int r6 = (r11[r4] & 255) >>> r5;
        r4 = r4 + 1;
        int r9 = r5 + 1;
        r1[r3] = (byte) (r6 + ((r11[r4] & ((1 << r9) - 1)) << (7 - r5)));
        if (r5 != 6) goto L9;
        r4 = r4 + 1;
        r5 = 0;
    L10:
        r3 = r3 + 1;
        goto L5
    L9:
        r5 = r9;
        goto L10
    L11:
        return r1;
    }
}
