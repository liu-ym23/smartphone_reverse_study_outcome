package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
final class ExifAttribute {
    static final Charset ASCII = null;
    public static final long BYTES_OFFSET_UNKNOWN = -1;
    static final byte[] EXIF_ASCII_PREFIX = null;
    static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = null;
    static final int IFD_FORMAT_DOUBLE = 12;
    static final String[] IFD_FORMAT_NAMES = null;
    static final int IFD_FORMAT_SBYTE = 6;
    static final int IFD_FORMAT_SINGLE = 11;
    static final int IFD_FORMAT_SLONG = 9;
    static final int IFD_FORMAT_SRATIONAL = 10;
    static final int IFD_FORMAT_SSHORT = 8;
    static final int IFD_FORMAT_STRING = 2;
    static final int IFD_FORMAT_ULONG = 4;
    static final int IFD_FORMAT_UNDEFINED = 7;
    static final int IFD_FORMAT_URATIONAL = 5;
    static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    static {
        ASCII = StandardCharsets.US_ASCII;
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
    }

    public int size() {
        return IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }

    public String toString() {
        return "(" + IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
    }

    public static ExifAttribute createByte(String r100) {
        if (r100.length() == 1) goto L5;
    L10:
        byte[] r101 = r100.getBytes(ASCII);
        return new ExifAttribute(1, r101.length, r101);
    L5:
        if (r100.charAt(0) < '0') goto L10;
        if (r100.charAt(0) > '1') goto L10;
        return new ExifAttribute(1, 1, new byte[]{(byte) (r100.charAt(0) - '0')});
    }

    public static ExifAttribute createString(String r100) {
        byte[] r101 = (r100 + 0).getBytes(ASCII);
        return new ExifAttribute(2, r101.length, r101);
    }

    public double getDoubleValue(ByteOrder r100) {
        Object r101 = getValue(r100);
        if (r101 == null) goto L43;
        if ((r101 instanceof String) == false) goto L9;
        return CastDoubleProtector.parseDouble((String) r101);
    L9:
        if ((r101 instanceof long[]) == false) goto L17;
        long[] r102 = (long[]) r101;
        if (r102.length != 1) goto L15;
        return r102[0];
    L15:
        throw new NumberFormatException("There are more than one component");
    L17:
        if ((r101 instanceof int[]) == false) goto L25;
        int[] r103 = (int[]) r101;
        if (r103.length != 1) goto L23;
        return r103[0];
    L23:
        throw new NumberFormatException("There are more than one component");
    L25:
        if ((r101 instanceof double[]) == false) goto L33;
        double[] r104 = (double[]) r101;
        if (r104.length != 1) goto L31;
        return r104[0];
    L31:
        throw new NumberFormatException("There are more than one component");
    L33:
        if ((r101 instanceof LongRational[]) == false) goto L41;
        LongRational[] r105 = (LongRational[]) r101;
        if (r105.length != 1) goto L39;
        return r105[0].toDouble();
    L39:
        throw new NumberFormatException("There are more than one component");
    L41:
        throw new NumberFormatException("Couldn't find a double value");
    L43:
        throw new NumberFormatException("NULL can't be converted to a double value");
    }

    public int getIntValue(ByteOrder r100) {
        Object r101 = getValue(r100);
        if (r101 == null) goto L27;
        if ((r101 instanceof String) == false) goto L9;
        return CastIntegerProtector.parseInt((String) r101);
    L9:
        if ((r101 instanceof long[]) == false) goto L17;
        long[] r102 = (long[]) r101;
        if (r102.length != 1) goto L15;
        return (int) r102[0];
    L15:
        throw new NumberFormatException("There are more than one component");
    L17:
        if ((r101 instanceof int[]) == false) goto L25;
        int[] r103 = (int[]) r101;
        if (r103.length != 1) goto L23;
        return r103[0];
    L23:
        throw new NumberFormatException("There are more than one component");
    L25:
        throw new NumberFormatException("Couldn't find a integer value");
    L27:
        throw new NumberFormatException("NULL can't be converted to a integer value");
    }

    public String getStringValue(ByteOrder r100) {
        Object r101 = getValue(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof String) == true) goto L8;
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        if ((r101 instanceof long[]) == false) goto L20;
        long[] r104 = (long[]) r101;
    L13:
        if (r103 >= r104.length) goto L18;
        r102.append(r104[r103]);
        r103 = r103 + 1;
        if (r103 == r104.length) goto L13;
        r102.append(",");
        goto L13
    L18:
        return r102.toString();
    L20:
        if ((r101 instanceof int[]) == false) goto L30;
        int[] r105 = (int[]) r101;
    L23:
        if (r103 >= r105.length) goto L28;
        r102.append(r105[r103]);
        r103 = r103 + 1;
        if (r103 == r105.length) goto L23;
        r102.append(",");
        goto L23
    L28:
        return r102.toString();
    L30:
        if ((r101 instanceof double[]) == false) goto L40;
        double[] r106 = (double[]) r101;
    L33:
        if (r103 >= r106.length) goto L38;
        r102.append(r106[r103]);
        r103 = r103 + 1;
        if (r103 == r106.length) goto L33;
        r102.append(",");
        goto L33
    L38:
        return r102.toString();
    L40:
        if ((r101 instanceof LongRational[]) == false) goto L49;
        LongRational[] r107 = (LongRational[]) r101;
    L43:
        if (r103 >= r107.length) goto L48;
        r102.append(r107[r103].getNumerator());
        r102.append('/');
        r102.append(r107[r103].getDenominator());
        r103 = r103 + 1;
        if (r103 == r107.length) goto L43;
        r102.append(",");
        goto L43
    L48:
        return r102.toString();
    L49:
        return null;
    L8:
        return (String) r101;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0198: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777624), block:B:151:0x0198 */
    public Object getValue(ByteOrder r110) {
        InputStream r100 = null;
        ByteOrderedDataInputStream r101 = new ByteOrderedDataInputStream(this.bytes);     // Catch: Throwable -> L139 IOException -> L141
        r101.setByteOrder(r110);     // Catch: IOException -> L137 Throwable -> L150
        int r102 = 0;
        boolean r103 = true;
        switch(this.format) {
            case 1: goto L115;
            case 2: goto L88;
            case 3: goto L77;
            case 4: goto L67;
            case 5: goto L57;
            case 6: goto L115;
            case 7: goto L88;
            case 8: goto L47;
            case 9: goto L37;
            case 10: goto L27;
            case 11: goto L17;
            case 12: goto L7;
            default: goto L186;
        };     // Catch: IOException -> L137 Throwable -> L150
    L7:
        double[] r111 = new double[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L9:
        if (r102 >= this.numberOfComponents) goto L166;
        r111[r102] = r101.readDouble();     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L9
    L166:
        r101.close();     // Catch: IOException -> L14
    L16:
        return r111;
    L14:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L16
    L17:
        double[] r112 = new double[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L19:
        if (r102 >= this.numberOfComponents) goto L170;
        r112[r102] = r101.readFloat();     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L19
    L170:
        r101.close();     // Catch: IOException -> L24
    L26:
        return r112;
    L24:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L26
    L27:
        LongRational[] r113 = new LongRational[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L29:
        if (r102 >= this.numberOfComponents) goto L164;
        r113[r102] = new LongRational(r101.readInt(), r101.readInt());     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L29
    L164:
        r101.close();     // Catch: IOException -> L34
    L36:
        return r113;
    L34:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L36
    L37:
        int[] r114 = new int[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L39:
        if (r102 >= this.numberOfComponents) goto L168;
        r114[r102] = r101.readInt();     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L39
    L168:
        r101.close();     // Catch: IOException -> L44
    L46:
        return r114;
    L44:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L46
    L47:
        int[] r115 = new int[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L49:
        if (r102 >= this.numberOfComponents) goto L179;
        r115[r102] = r101.readShort();     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L49
    L179:
        r101.close();     // Catch: IOException -> L54
    L56:
        return r115;
    L54:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L56
    L57:
        LongRational[] r116 = new LongRational[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L59:
        if (r102 >= this.numberOfComponents) goto L176;
        r116[r102] = new LongRational(r101.readUnsignedInt(), r101.readUnsignedInt());     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L59
    L176:
        r101.close();     // Catch: IOException -> L64
    L66:
        return r116;
    L64:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L66
    L67:
        long[] r117 = new long[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L69:
        if (r102 >= this.numberOfComponents) goto L184;
        r117[r102] = r101.readUnsignedInt();     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L69
    L184:
        r101.close();     // Catch: IOException -> L74
    L76:
        return r117;
    L74:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L76
    L77:
        int[] r118 = new int[this.numberOfComponents];     // Catch: IOException -> L137 Throwable -> L150
    L79:
        if (r102 >= this.numberOfComponents) goto L158;
        r118[r102] = r101.readUnsignedShort();     // Catch: IOException -> L137 Throwable -> L150
        r102 = r102 + 1;
        goto L79
    L158:
        r101.close();     // Catch: IOException -> L84
    L86:
        return r118;
    L84:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L86
    L115:
        byte[] r119 = this.bytes;     // Catch: IOException -> L137 Throwable -> L150
        if (r119.length != 1) goto L126;
        byte r104 = r119[0];     // Catch: IOException -> L137 Throwable -> L150
        if (r104 < 0) goto L126;
        if (r104 > 1) goto L126;
        String r120 = new String(new char[]{(char) (r104 + 48)});     // Catch: IOException -> L137 Throwable -> L150
        r101.close();     // Catch: IOException -> L123
    L125:
        return r120;
    L123:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
    L126:
        String r105 = new String(r119, ASCII);     // Catch: IOException -> L137 Throwable -> L150
        r101.close();     // Catch: IOException -> L129
    L131:
        return r105;
    L129:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L131
    L186:
        r101.close();     // Catch: IOException -> L134
    L136:
        return null;
    L134:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L136
    L88:
        if (this.numberOfComponents < EXIF_ASCII_PREFIX.length) goto L98;
        int r121 = 0;
    L90:
        byte[] r106 = EXIF_ASCII_PREFIX;     // Catch: IOException -> L137 Throwable -> L150
        if (r121 >= r106.length) goto L96;
        if (this.bytes[r121] != r106[r121]) goto L94;
        r121 = r121 + 1;     // Catch: IOException -> L137 Throwable -> L150
        goto L90
    L94:
        r103 = false;
    L96:
        if (r103 == false) goto L98;
        r102 = r106.length;     // Catch: IOException -> L137 Throwable -> L150
    L98:
        StringBuilder r122 = new StringBuilder();     // Catch: IOException -> L137 Throwable -> L150
    L100:
        if (r102 >= this.numberOfComponents) goto L109;
        byte r107 = this.bytes[r102];     // Catch: IOException -> L137 Throwable -> L150
        if (r107 == 0) goto L109;
        if (r107 < 32) goto L107;
        r122.append((char) r107);     // Catch: IOException -> L137 Throwable -> L150
    L108:
        r102 = r102 + 1;     // Catch: IOException -> L137 Throwable -> L150
        goto L100
    L107:
        r122.append('?');     // Catch: IOException -> L137 Throwable -> L150
    L109:
        String r123 = r122.toString();     // Catch: IOException -> L137 Throwable -> L150
        r101.close();     // Catch: IOException -> L112
    L114:
        return r123;
    L112:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
    L137:
        e = e;
    L143:
        Logger.w(TAG, "IOException occurred during reading a value", e);     // Catch: Throwable -> L150
        if (r101 != null) goto L162;
    L149:
        return null;
    L162:
        r101.close();     // Catch: IOException -> L147
    L147:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
        goto L149
    L150:
        th = th;
        r100 = r3;
    L152:
        if (r100 != null) goto L182;
    L157:
        throw th;
    L182:
        r100.close();     // Catch: IOException -> L155
    L155:
        e = move-exception;
        Logger.e(TAG, "IOException occurred while closing InputStream", e);
    L141:
        e = e;
        r101 = null;
    L139:
        th = th;
        goto L152
    }

    public static ExifAttribute createDouble(double[] r100, ByteOrder r101) {
        ByteBuffer r102 = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[12] * r100.length]);
        r102.order(r101);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102.putDouble(r100[r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return new ExifAttribute(12, r100.length, r102.array());
    }

    public static ExifAttribute createSLong(int[] r100, ByteOrder r101) {
        ByteBuffer r102 = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[9] * r100.length]);
        r102.order(r101);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102.putInt(r100[r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return new ExifAttribute(9, r100.length, r102.array());
    }

    public static ExifAttribute createSRational(LongRational[] r100, ByteOrder r101) {
        ByteBuffer r102 = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[10] * r100.length]);
        r102.order(r101);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        LongRational r105 = r100[r104];
        r102.putInt((int) r105.getNumerator());
        r102.putInt((int) r105.getDenominator());
        r104 = r104 + 1;
        goto L3
    L6:
        return new ExifAttribute(10, r100.length, r102.array());
    }

    public static ExifAttribute createULong(long[] r100, ByteOrder r101) {
        ByteBuffer r102 = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[4] * r100.length]);
        r102.order(r101);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102.putInt((int) r100[r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return new ExifAttribute(4, r100.length, r102.array());
    }

    public static ExifAttribute createURational(LongRational[] r100, ByteOrder r101) {
        ByteBuffer r102 = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[5] * r100.length]);
        r102.order(r101);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        LongRational r105 = r100[r104];
        r102.putInt((int) r105.getNumerator());
        r102.putInt((int) r105.getDenominator());
        r104 = r104 + 1;
        goto L3
    L6:
        return new ExifAttribute(5, r100.length, r102.array());
    }

    public static ExifAttribute createUShort(int[] r100, ByteOrder r101) {
        ByteBuffer r102 = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[3] * r100.length]);
        r102.order(r101);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102.putShort((short) r100[r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return new ExifAttribute(3, r100.length, r102.array());
    }

    public static ExifAttribute createDouble(double r100, ByteOrder r101) {
        return createDouble(new double[]{r100}, r101);
    }

    public static ExifAttribute createSLong(int r100, ByteOrder r101) {
        return createSLong(new int[]{r100}, r101);
    }

    public static ExifAttribute createSRational(LongRational r100, ByteOrder r101) {
        return createSRational(new LongRational[]{r100}, r101);
    }

    public static ExifAttribute createULong(long r100, ByteOrder r101) {
        return createULong(new long[]{r100}, r101);
    }

    public static ExifAttribute createURational(LongRational r100, ByteOrder r101) {
        return createURational(new LongRational[]{r100}, r101);
    }

    public static ExifAttribute createUShort(int r100, ByteOrder r101) {
        return createUShort(new int[]{r100}, r101);
    }

    public ExifAttribute(int r100, int r101, byte[] r102) {
        this(r100, r101, -1, r102);
    }

    public ExifAttribute(int r100, int r101, long r102, byte[] r103) {
        this.format = r100;
        this.numberOfComponents = r101;
        this.bytesOffset = r102;
        this.bytes = r103;
    }
}
