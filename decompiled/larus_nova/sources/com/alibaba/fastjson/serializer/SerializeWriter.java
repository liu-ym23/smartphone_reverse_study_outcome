package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import com.alipay.sdk.m.n.a;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class SerializeWriter extends Writer {
    private static int BUFFER_THRESHOLD;
    private static final char[] VALUE_FALSE = null;
    private static final char[] VALUE_TRUE = null;
    private static final ThreadLocal<char[]> bufLocal = null;
    private static final ThreadLocal<byte[]> bytesBufLocal = null;
    static final int nonDirectFeatures = 0;
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this(null);
    }

    public void reset() {
        this.count = 0;
    }

    static {
        bufLocal = new ThreadLocal();
        bytesBufLocal = new ThreadLocal();
        VALUE_TRUE = ":true".toCharArray();
        VALUE_FALSE = ":false".toCharArray();
        BUFFER_THRESHOLD = 131072;
        String r100 = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");     // Catch: Throwable -> L14
        if (r100 == null) goto L12;
        if (r100.length() <= 0) goto L12;
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L14
        if (r101 < 64) goto L12;
        if (r101 > 65536) goto L12;
        BUFFER_THRESHOLD = r101 * 1024;     // Catch: Throwable -> L14
    L12:
        nonDirectFeatures = ((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask;
    }

    private byte[] encodeToUTF8Bytes() {
        int r100 = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> r101 = bytesBufLocal;
        byte[] r102 = r101.get();
        if (r102 != null) goto L6;
        r102 = new byte[8192];
        r101.set(r102);
    L6:
        if (r102.length >= r100) goto L8;
        byte[] r103 = new byte[r100];
    L9:
        int r104 = IOUtils.encodeUTF8(this.buf, 0, this.count, r103);
        byte[] r105 = new byte[r104];
        System.arraycopy(r103, 0, r105, 0, r104);
        if (r103 != r102) goto L12;
    L14:
        return r105;
    L12:
        if (r103.length > BUFFER_THRESHOLD) goto L14;
        r101.set(r103);
        goto L14
    L8:
        r103 = r102;
        goto L9
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null) goto L5;
    L7:
        char[] r100 = this.buf;
        if (r100.length > BUFFER_THRESHOLD) goto L10;
        bufLocal.set(r100);
    L10:
        this.buf = null;
        return;
    L5:
        if (this.count <= 0) goto L7;
        flush();
        goto L7
    }

    public void computeFeatures() {
        int r100 = this.features;
        boolean r101 = true;
        if ((SerializerFeature.QuoteFieldNames.mask & r100) == 0) goto L5;
        boolean r102 = true;
    L6:
        this.quoteFieldNames = r102;
        if ((SerializerFeature.UseSingleQuotes.mask & r100) == 0) goto L9;
        boolean r103 = true;
    L10:
        this.useSingleQuotes = r103;
        if ((SerializerFeature.SortField.mask & r100) == 0) goto L13;
        boolean r104 = true;
    L14:
        this.sortField = r104;
        if ((SerializerFeature.DisableCircularReferenceDetect.mask & r100) == 0) goto L17;
        boolean r105 = true;
    L18:
        this.disableCircularReferenceDetect = r105;
        if ((SerializerFeature.BeanToArray.mask & r100) == 0) goto L21;
        boolean r106 = true;
    L22:
        this.beanToArray = r106;
        if ((SerializerFeature.WriteNonStringValueAsString.mask & r100) == 0) goto L25;
        boolean r107 = true;
    L26:
        this.writeNonStringValueAsString = r107;
        if ((SerializerFeature.NotWriteDefaultValue.mask & r100) == 0) goto L29;
        boolean r108 = true;
    L30:
        this.notWriteDefaultValue = r108;
        if ((SerializerFeature.WriteEnumUsingName.mask & r100) == 0) goto L33;
        boolean r109 = true;
    L34:
        this.writeEnumUsingName = r109;
        if ((SerializerFeature.WriteEnumUsingToString.mask & r100) == 0) goto L37;
        boolean r110 = true;
    L38:
        this.writeEnumUsingToString = r110;
        if (r102 == true) goto L41;
    L45:
        boolean r111 = false;
    L46:
        this.writeDirect = r111;
        if (r103 == false) goto L49;
        char r112 = '\'';
    L50:
        this.keySeperator = r112;
        if ((SerializerFeature.BrowserSecure.mask & r100) != 0) goto L54;
        r101 = false;
    L54:
        this.browserSecure = r101;
        if (r101 == false) goto L58;
        long r113 = 5764610843043954687L;
    L61:
        this.sepcialBits = r113;
        return;
    L58:
        if ((r100 & SerializerFeature.WriteSlashAsSpecial.mask) == 0) goto L60;
        r113 = 140758963191807L;
        goto L61
    L60:
        r113 = 21474836479L;
        goto L61
    L49:
        r112 = Typography.quote;
        goto L50
    L41:
        if ((nonDirectFeatures & r100) != 0) goto L45;
        if (r106 == true) goto L44;
        if (r109 == false) goto L45;
    L44:
        r111 = true;
        goto L46
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer r100 = this.writer;
        if (r100 != null) goto L11;
        return;
    L11:
        r100.write(this.buf, 0, this.count);     // Catch: IOException -> L8
        this.writer.flush();     // Catch: IOException -> L8
        this.count = 0;
        return;
    L8:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public char[] toCharArray() {
        if (this.writer != null) goto L7;
        int r100 = this.count;
        char[] r101 = new char[r100];
        System.arraycopy(this.buf, 0, r101, 0, r100);
        return r101;
    L7:
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer != null) goto L7;
        int r100 = this.count;
        char[] r101 = new char[r100 - 2];
        System.arraycopy(this.buf, 1, r101, 0, r100 - 2);
        return r101;
    L7:
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void writeNull() {
        write("null");
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public int size() {
        return this.count;
    }

    public SerializeWriter(Writer r100) {
        this(r100, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    private int encodeToUTF8(OutputStream r100) throws IOException {
        int r101 = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> r102 = bytesBufLocal;
        byte[] r103 = r102.get();
        if (r103 != null) goto L6;
        r103 = new byte[8192];
        r102.set(r103);
    L6:
        if (r103.length >= r101) goto L8;
        byte[] r104 = new byte[r101];
    L9:
        int r105 = IOUtils.encodeUTF8(this.buf, 0, this.count, r104);
        r100.write(r104, 0, r105);
        if (r104 != r103) goto L12;
    L14:
        return r105;
    L12:
        if (r104.length > BUFFER_THRESHOLD) goto L14;
        r102.set(r104);
        goto L14
    L8:
        r104 = r103;
        goto L9
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String r110) {
        byte[] r100 = IOUtils.specicalFlags_singleQuotes;
        int r101 = r110.length();
        boolean r102 = true;
        int r103 = (this.count + r101) + 1;
        int r104 = 0;
        if (r103 > this.buf.length) goto L5;
    L33:
        if (r101 != 0) goto L39;
        int r105 = this.count;
        if ((r105 + 3) <= this.buf.length) goto L37;
        expandCapacity(r105 + 3);
    L37:
        char[] r106 = this.buf;
        int r107 = this.count;
        int r108 = r107 + 1;
        r106[r107] = '\'';
        int r109 = r108 + 1;
        r106[r108] = '\'';
        this.count = r109 + 1;
        r106[r109] = ':';
        return;
    L39:
        int r111 = this.count;
        int r112 = r111 + r101;
        r110.getChars(0, r101, this.buf, r111);
        this.count = r103;
        int r113 = r111;
        boolean r114 = false;
    L40:
        if (r113 >= r112) goto L55;
        char[] r115 = this.buf;
        char r116 = r115[r113];
        if (r116 >= r100.length) goto L54;
        if (r100[r116] == 0) goto L54;
        if (r114 == true) goto L50;
        r103 = r103 + 3;
        if (r103 <= r115.length) goto L49;
        expandCapacity(r103);
    L49:
        this.count = r103;
        char[] r117 = this.buf;
        int r118 = r113 + 1;
        System.arraycopy(r117, r118, r117, r113 + 3, (r112 - r113) - 1);
        char[] r119 = this.buf;
        System.arraycopy(r119, r104, r119, 1, r113);
        char[] r120 = this.buf;
        r120[r111] = '\'';
        r120[r118] = '\\';
        int r121 = r118 + 1;
        r120[r121] = IOUtils.replaceChars[r116];
        r112 = r112 + 2;
        r120[this.count - 2] = '\'';
        r113 = r121;
        r114 = true;
        goto L54
    L50:
        r103 = r103 + 1;
        if (r103 <= r115.length) goto L53;
        expandCapacity(r103);
    L53:
        this.count = r103;
        char[] r122 = this.buf;
        int r123 = r113 + 1;
        System.arraycopy(r122, r123, r122, r113 + 2, r112 - r113);
        char[] r124 = this.buf;
        r124[r113] = '\\';
        r124[r123] = IOUtils.replaceChars[r116];
        r112 = r112 + 1;
        r113 = r123;
    L54:
        r113 = r113 + 1;
        r104 = 0;
        goto L40
    L55:
        this.buf[r103 - 1] = ':';
        return;
    L5:
        if (this.writer == null) goto L32;
        if (r101 != 0) goto L9;
        write(39);
        write(39);
        write(58);
        return;
    L9:
        int r125 = 0;
    L10:
        if (r125 >= r101) goto L17;
        char r126 = r110.charAt(r125);
        if (r126 >= r100.length) goto L16;
        if (r100[r126] == 0) goto L16;
    L18:
        if (r102 == false) goto L20;
        write(39);
    L20:
        if (r104 >= r101) goto L28;
        char r127 = r110.charAt(r104);
        if (r127 < r100.length) goto L24;
    L26:
        write(r127);
    L27:
        r104 = r104 + 1;
        goto L20
    L24:
        if (r100[r127] == 0) goto L26;
        write(92);
        write(IOUtils.replaceChars[r127]);
        goto L27
    L28:
        if (r102 == false) goto L30;
        write(39);
    L30:
        write(58);
        return;
    L16:
        r125 = r125 + 1;
        goto L10
    L17:
        r102 = false;
        goto L18
    L32:
        expandCapacity(r103);
        goto L33
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence r100) {
        if (r100 != null) goto L4;
        String r101 = "null";
    L5:
        write(r101, 0, r101.length());
        return this;
    L4:
        r101 = r100.toString();
        goto L5
    }

    public void expandCapacity(int r100) {
        int r101 = this.maxBufSize;
        if (r101 == (-1)) goto L8;
        if (r100 < r101) goto L8;
        throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + r100);
    L8:
        char[] r102 = this.buf;
        int r103 = (r102.length + (r102.length >> 1)) + 1;
        if (r103 < r100) goto L12;
        r100 = r103;
    L12:
        char[] r104 = new char[r100];
        System.arraycopy(r102, 0, r104, 0, this.count);
        if (this.buf.length >= BUFFER_THRESHOLD) goto L19;
        ThreadLocal<char[]> r105 = bufLocal;
        char[] r106 = r105.get();
        if (r106 != null) goto L17;
    L18:
        r105.set(this.buf);
        goto L19
    L17:
        if (r106.length < this.buf.length) goto L18;
    L19:
        this.buf = r104;
    }

    public boolean isEnabled(SerializerFeature r100) {
        int r101 = this.features;
        if ((r100.mask & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMaxBufSize(int r100) {
        if (r100 < this.buf.length) goto L7;
        this.maxBufSize = r100;
        return;
    L7:
        throw new JSONException("must > " + this.buf.length);
    }

    public byte[] toBytes(Charset r100) {
        if (this.writer != null) goto L11;
        if (r100 != IOUtils.UTF8) goto L9;
        return encodeToUTF8Bytes();
    L9:
        return new String(this.buf, 0, this.count).getBytes(r100);
    L11:
        throw new UnsupportedOperationException("writer not null");
    }

    public void write(List<String> r110) {
        if (r110.isEmpty() == false) goto L6;
        write("[]");
        return;
    L6:
        int r100 = this.count;
        int r101 = r110.size();
        int r102 = r100;
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L51;
        String r104 = (String) ListProtector.get(r110, r103);
        if (r104 != null) goto L12;
        boolean r111 = true;
    L28:
        if (r111 == true) goto L29;
        int r105 = (r104.length() + r102) + 3;
        if (r103 != (r110.size() - 1)) goto L45;
        r105 = r105 + 1;
    L45:
        if (r105 <= this.buf.length) goto L47;
        this.count = r102;
        expandCapacity(r105);
    L47:
        if (r103 != 0) goto L49;
        int r106 = r102 + 1;
        this.buf[r102] = '[';
    L50:
        int r107 = r106 + 1;
        this.buf[r106] = Typography.quote;
        r104.getChars(0, r104.length(), this.buf, r107);
        int r108 = r107 + r104.length();
        this.buf[r108] = Typography.quote;
        r103 = r103 + 1;
        r102 = r108 + 1;
        goto L8
    L49:
        r106 = r102 + 1;
        this.buf[r102] = ',';
        goto L50
    L29:
        this.count = r100;
        write(91);
        int r109 = 0;
    L31:
        if (r109 >= r110.size()) goto L39;
        String r112 = (String) ListProtector.get(r110, r109);
        if (r109 == 0) goto L35;
        write(44);
    L35:
        if (r112 != null) goto L37;
        write("null");
    L38:
        r109 = r109 + 1;
        goto L31
    L37:
        writeStringWithDoubleQuote(r112, 0);
        goto L38
    L39:
        write(93);
        return;
    L12:
        int r113 = r104.length();
        int r114 = 0;
        r111 = false;
    L13:
        if (r114 >= r113) goto L28;
        char r115 = r104.charAt(r114);
        if (r115 >= ' ') goto L17;
    L23:
        r111 = true;
    L24:
        if (r111 == true) goto L28;
        r114 = r114 + 1;
        goto L13
    L17:
        if (r115 > '~') goto L23;
        if (r115 == '\"') goto L23;
        if (r115 == '\\') goto L23;
        r111 = false;
        goto L24
    L51:
        this.buf[r102] = ']';
        this.count = r102 + 1;
    }

    public void writeByteArray(byte[] r110) {
        if (isEnabled(SerializerFeature.WriteClassName.mask) == false) goto L6;
        writeHex(r110);
        return;
    L6:
        int r100 = r110.length;
        boolean r101 = this.useSingleQuotes;
        if (r101 == false) goto L9;
        char r102 = '\'';
    L10:
        if (r100 != 0) goto L16;
        if (r101 == false) goto L13;
        String r103 = "''";
    L14:
        write(r103);
        return;
    L13:
        r103 = "\"\"";
        goto L14
    L16:
        char[] r104 = IOUtils.CA;
        int r105 = (r100 / 3) * 3;
        int r106 = r100 - 1;
        int r107 = this.count;
        int r108 = ((((r106 / 3) + 1) << 2) + r107) + 2;
        int r111 = 0;
        if (r108 > this.buf.length) goto L19;
    L36:
        this.count = r108;
        int r112 = r107 + 1;
        this.buf[r107] = r102;
        int r109 = 0;
    L37:
        if (r109 >= r105) goto L39;
        int r113 = r109 + 1;
        int r114 = r113 + 1;
        int r115 = ((r110[r109] & UByte.MAX_VALUE) << 16) | ((r110[r113] & UByte.MAX_VALUE) << 8);
        int r116 = r114 + 1;
        int r117 = r115 | (r110[r114] & UByte.MAX_VALUE);
        char[] r118 = this.buf;
        int r119 = r112 + 1;
        r118[r112] = r104[(r117 >>> 18) & 63];
        int r120 = r119 + 1;
        r118[r119] = r104[(r117 >>> 12) & 63];
        int r121 = r120 + 1;
        r118[r120] = r104[(r117 >>> 6) & 63];
        r112 = r121 + 1;
        r118[r121] = r104[r117 & 63];
        r109 = r116;
        goto L37
    L39:
        int r122 = r100 - r105;
        if (r122 <= 0) goto L49;
        int r123 = (r110[r105] & UByte.MAX_VALUE) << 10;
        if (r122 != 2) goto L44;
        r111 = (r110[r106] & UByte.MAX_VALUE) << 2;
    L44:
        int r124 = r123 | r111;
        char[] r125 = this.buf;
        r125[r108 - 5] = r104[r124 >> 12];
        r125[r108 - 4] = r104[(r124 >>> 6) & 63];
        int r126 = r108 - 3;
        if (r122 != 2) goto L47;
        char r127 = r104[r124 & 63];
    L48:
        r125[r126] = r127;
        r125[r108 - 2] = a.f25612h;
        goto L49
    L47:
        r127 = a.f25612h;
    L49:
        this.buf[r108 - 1] = r102;
        return;
    L19:
        if (this.writer == null) goto L35;
        write(r102);
        int r128 = 0;
    L21:
        if (r128 >= r105) goto L23;
        int r129 = r128 + 1;
        int r130 = r129 + 1;
        int r131 = ((r110[r128] & UByte.MAX_VALUE) << 16) | ((r110[r129] & UByte.MAX_VALUE) << 8);
        int r132 = r131 | (r110[r130] & UByte.MAX_VALUE);
        write(r104[(r132 >>> 18) & 63]);
        write(r104[(r132 >>> 12) & 63]);
        write(r104[(r132 >>> 6) & 63]);
        write(r104[r132 & 63]);
        r128 = r130 + 1;
        goto L21
    L23:
        int r133 = r100 - r105;
        if (r133 <= 0) goto L33;
        int r134 = (r110[r105] & UByte.MAX_VALUE) << 10;
        if (r133 != 2) goto L28;
        r111 = (r110[r106] & UByte.MAX_VALUE) << 2;
    L28:
        int r135 = r134 | r111;
        write(r104[r135 >> 12]);
        write(r104[(r135 >>> 6) & 63]);
        if (r133 != 2) goto L31;
        char r136 = r104[r135 & 63];
    L32:
        write(r136);
        write(61);
        goto L33
    L31:
        r136 = a.f25612h;
    L33:
        write(r102);
        return;
    L35:
        expandCapacity(r108);
        goto L36
    L9:
        r102 = Typography.quote;
        goto L10
    }

    public void writeEnum(Enum<?> r100) {
        if (r100 != null) goto L6;
        writeNull();
        return;
    L6:
        if (this.writeEnumUsingName == false) goto L11;
        if (this.writeEnumUsingToString == true) goto L11;
        String r101 = r100.name();
    L14:
        if (r101 != null) goto L16;
        writeInt(r100.ordinal());
        return;
    L16:
        if (isEnabled(SerializerFeature.UseSingleQuotes) == false) goto L18;
        int r102 = 39;
    L19:
        write(r102);
        write(r101);
        write(r102);
        return;
    L18:
        r102 = 34;
    L11:
        if (this.writeEnumUsingToString == false) goto L13;
        r101 = r100.toString();
        goto L14
    L13:
        r101 = null;
        goto L14
    }

    public void writeFieldName(String r100) {
        writeFieldName(r100, false);
    }

    public void writeFieldNameDirect(String r100) {
        int r101 = r100.length();
        int r102 = (this.count + r101) + 3;
        if (r102 <= this.buf.length) goto L5;
        expandCapacity(r102);
    L5:
        int r103 = this.count;
        char[] r104 = this.buf;
        r104[r103] = Typography.quote;
        r100.getChars(0, r101, r104, r103 + 1);
        this.count = r102;
        char[] r105 = this.buf;
        r105[r102 - 2] = Typography.quote;
        r105[r102 - 1] = ':';
    }

    public void writeHex(byte[] r110) {
        int r100 = (this.count + (r110.length * 2)) + 3;
        if (r100 <= this.buf.length) goto L5;
        expandCapacity(r100);
    L5:
        char[] r101 = this.buf;
        int r102 = this.count;
        int r103 = r102 + 1;
        r101[r102] = Permission.EXECUTE;
        this.count = r103 + 1;
        r101[r103] = '\'';
        int r104 = 0;
    L7:
        if (r104 >= r110.length) goto L17;
        int r105 = r110[r104] & UByte.MAX_VALUE;
        int r106 = r105 >> 4;
        int r107 = r105 & 15;
        char[] r108 = this.buf;
        int r109 = this.count;
        int r111 = r109 + 1;
        this.count = r111;
        int r112 = 48;
        if (r106 >= 10) goto L11;
        int r113 = 48;
    L12:
        r108[r109] = (char) (r106 + r113);
        this.count = r111 + 1;
        if (r107 < 10) goto L16;
        r112 = 55;
    L16:
        r108[r111] = (char) (r107 + r112);
        r104 = r104 + 1;
        goto L7
    L11:
        r113 = 55;
        goto L12
    L17:
        char[] r114 = this.buf;
        int r115 = this.count;
        this.count = r115 + 1;
        r114[r115] = '\'';
    }

    public void writeInt(int r100) {
        if (r100 != Integer.MIN_VALUE) goto L6;
        write("-2147483648");
        return;
    L6:
        if (r100 >= 0) goto L8;
        int r101 = IOUtils.stringSize(-r100) + 1;
    L9:
        int r102 = this.count + r101;
        if (r102 > this.buf.length) goto L12;
    L16:
        IOUtils.getChars(r100, r102, this.buf);
        this.count = r102;
        return;
    L12:
        if (this.writer != null) goto L14;
        expandCapacity(r102);
        goto L16
    L14:
        char[] r103 = new char[r101];
        IOUtils.getChars(r100, r101, r103);
        write(r103, 0, r101);
        return;
    L8:
        r101 = IOUtils.stringSize(r100);
        goto L9
    }

    public void writeLong(long r100) {
        if (isEnabled(SerializerFeature.BrowserCompatible) == true) goto L5;
    L11:
        boolean r101 = false;
    L13:
        if (r100 != Long.MIN_VALUE) goto L19;
        if (r101 == false) goto L16;
        write("\"-9223372036854775808\"");
        return;
    L16:
        write("-9223372036854775808");
        return;
    L19:
        if (r100 >= 0) goto L21;
        int r102 = IOUtils.stringSize(-r100) + 1;
    L22:
        int r103 = this.count + r102;
        if (r101 == false) goto L26;
        r103 = r103 + 2;
    L26:
        if (r103 > this.buf.length) goto L28;
    L35:
        if (r101 == false) goto L37;
        char[] r104 = this.buf;
        r104[this.count] = Typography.quote;
        int r105 = r103 - 1;
        IOUtils.getChars(r100, r105, r104);
        this.buf[r105] = Typography.quote;
    L38:
        this.count = r103;
        return;
    L37:
        IOUtils.getChars(r100, r103, this.buf);
        goto L38
    L28:
        if (this.writer != null) goto L30;
        expandCapacity(r103);
        goto L35
    L30:
        char[] r106 = new char[r102];
        IOUtils.getChars(r100, r102, r106);
        if (r101 == false) goto L33;
        write(34);
        write(r106, 0, r102);
        write(34);
        return;
    L33:
        write(r106, 0, r102);
        return;
    L21:
        r102 = IOUtils.stringSize(r100);
        goto L22
    L5:
        if (isEnabled(SerializerFeature.WriteClassName) == true) goto L11;
        if (r100 <= 9007199254740991L) goto L9;
    L10:
        r101 = true;
        goto L13
    L9:
        if (r100 >= (-9007199254740991L)) goto L11;
        goto L10
    }

    public void writeNull(SerializerFeature r100) {
        writeNull(0, r100.mask);
    }

    public void writeString(char[] r100) {
        if (this.useSingleQuotes == false) goto L5;
        writeStringWithSingleQuote(r100);
        return;
    L5:
        writeStringWithDoubleQuote(new String(r100), 0);
    }

    public void writeStringWithSingleQuote(String r110) {
        int r100 = 0;
        if (r110 != null) goto L9;
        int r111 = this.count + 4;
        if (r111 <= this.buf.length) goto L7;
        expandCapacity(r111);
    L7:
        "null".getChars(0, 4, this.buf, this.count);
        this.count = r111;
        return;
    L9:
        int r101 = r110.length();
        int r102 = (this.count + r101) + 2;
        if (r102 > this.buf.length) goto L12;
    L30:
        int r103 = this.count;
        int r104 = r103 + 1;
        int r105 = r104 + r101;
        char[] r112 = this.buf;
        r112[r103] = '\'';
        r110.getChars(0, r101, r112, r104);
        this.count = r102;
        int r113 = -1;
        int r106 = r104;
        char r107 = 0;
    L31:
        if (r106 >= r105) goto L41;
        char r114 = this.buf[r106];
        if (r114 <= '\r') goto L39;
        if (r114 == '\\') goto L39;
        if (r114 == '\'') goto L39;
        if (r114 != '/') goto L40;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L39;
    L40:
        r106 = r106 + 1;
    L39:
        r100 = r100 + 1;
        r113 = r106;
        r107 = r114;
        goto L40
    L41:
        int r108 = r102 + r100;
        if (r108 <= this.buf.length) goto L44;
        expandCapacity(r108);
    L44:
        this.count = r108;
        if (r100 != 1) goto L47;
        char[] r109 = this.buf;
        int r115 = r113 + 1;
        System.arraycopy(r109, r115, r109, r113 + 2, (r105 - r113) - 1);
        char[] r116 = this.buf;
        r116[r113] = '\\';
        r116[r115] = IOUtils.replaceChars[r107];
    L59:
        this.buf[this.count - 1] = '\'';
        return;
    L47:
        if (r100 <= 1) goto L59;
        char[] r117 = this.buf;
        int r118 = r113 + 1;
        System.arraycopy(r117, r118, r117, r113 + 2, (r105 - r113) - 1);
        char[] r119 = this.buf;
        r119[r113] = '\\';
        r119[r118] = IOUtils.replaceChars[r107];
        int r120 = r105 + 1;
        int r121 = r118 - 2;
    L49:
        if (r121 < r104) goto L59;
        char r122 = this.buf[r121];
        if (r122 <= '\r') goto L57;
        if (r122 == '\\') goto L57;
        if (r122 == '\'') goto L57;
        if (r122 != '/') goto L58;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L57;
    L58:
        r121 = r121 - 1;
    L57:
        char[] r123 = this.buf;
        int r124 = r121 + 1;
        System.arraycopy(r123, r124, r123, r121 + 2, (r120 - r121) - 1);
        char[] r125 = this.buf;
        r125[r121] = '\\';
        r125[r124] = IOUtils.replaceChars[r122];
        r120 = r120 + 1;
        goto L58
    L12:
        if (this.writer == null) goto L29;
        write(39);
    L15:
        if (r100 >= r110.length()) goto L27;
        char r126 = r110.charAt(r100);
        if (r126 <= '\r') goto L25;
        if (r126 == '\\') goto L25;
        if (r126 == '\'') goto L25;
        if (r126 == '/') goto L22;
    L24:
        write(r126);
    L26:
        r100 = r100 + 1;
        goto L15
    L22:
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == false) goto L24;
    L25:
        write(92);
        write(IOUtils.replaceChars[r126]);
        goto L26
    L27:
        write(39);
        return;
    L29:
        expandCapacity(r102);
        goto L30
    }

    public void writeTo(Writer r100) throws IOException {
        if (this.writer != null) goto L7;
        r100.write(this.buf, 0, this.count);
        return;
    L7:
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(int r100) {
        this(null, r100);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(char r100) throws IOException {
        return append(r100);
    }

    public boolean isEnabled(int r100) {
        if ((r100 & this.features) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte[] toBytes(String r100) {
        if (r100 != null) goto L4;
    L7:
        Charset r101 = IOUtils.UTF8;
    L9:
        return toBytes(r101);
    L4:
        if ("UTF-8".equals(r100) == true) goto L7;
        r101 = Charset.forName(r100);
        goto L9
    }

    @Override // java.io.Writer
    public void write(int r100) {
        int r101 = 1;
        int r102 = this.count + 1;
        if (r102 > this.buf.length) goto L5;
    L8:
        r101 = r102;
    L9:
        this.buf[this.count] = (char) r100;
        this.count = r101;
        return;
    L5:
        if (this.writer != null) goto L7;
        expandCapacity(r102);
        goto L8
    L7:
        flush();
        goto L9
    }

    public void writeString(String r100) {
        if (this.useSingleQuotes == false) goto L5;
        writeStringWithSingleQuote(r100);
        return;
    L5:
        writeStringWithDoubleQuote(r100, 0);
    }

    public void writeStringWithSingleQuote(char[] r110) {
        int r100 = 0;
        if (r110 != null) goto L9;
        int r111 = this.count + 4;
        if (r111 <= this.buf.length) goto L7;
        expandCapacity(r111);
    L7:
        "null".getChars(0, 4, this.buf, this.count);
        this.count = r111;
        return;
    L9:
        int r101 = r110.length;
        int r102 = (this.count + r101) + 2;
        if (r102 > this.buf.length) goto L12;
    L30:
        int r103 = this.count;
        int r104 = r103 + 1;
        int r105 = r101 + r104;
        char[] r106 = this.buf;
        r106[r103] = '\'';
        System.arraycopy(r110, 0, r106, r104, r110.length);
        this.count = r102;
        int r112 = -1;
        int r107 = r104;
        char r108 = 0;
    L31:
        if (r107 >= r105) goto L41;
        char r113 = this.buf[r107];
        if (r113 <= '\r') goto L39;
        if (r113 == '\\') goto L39;
        if (r113 == '\'') goto L39;
        if (r113 != '/') goto L40;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L39;
    L40:
        r107 = r107 + 1;
    L39:
        r100 = r100 + 1;
        r112 = r107;
        r108 = r113;
        goto L40
    L41:
        int r109 = r102 + r100;
        if (r109 <= this.buf.length) goto L44;
        expandCapacity(r109);
    L44:
        this.count = r109;
        if (r100 != 1) goto L47;
        char[] r114 = this.buf;
        int r115 = r112 + 1;
        System.arraycopy(r114, r115, r114, r112 + 2, (r105 - r112) - 1);
        char[] r116 = this.buf;
        r116[r112] = '\\';
        r116[r115] = IOUtils.replaceChars[r108];
    L59:
        this.buf[this.count - 1] = '\'';
        return;
    L47:
        if (r100 <= 1) goto L59;
        char[] r117 = this.buf;
        int r118 = r112 + 1;
        System.arraycopy(r117, r118, r117, r112 + 2, (r105 - r112) - 1);
        char[] r119 = this.buf;
        r119[r112] = '\\';
        r119[r118] = IOUtils.replaceChars[r108];
        int r120 = r105 + 1;
        int r121 = r118 - 2;
    L49:
        if (r121 < r104) goto L59;
        char r122 = this.buf[r121];
        if (r122 <= '\r') goto L57;
        if (r122 == '\\') goto L57;
        if (r122 == '\'') goto L57;
        if (r122 != '/') goto L58;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L57;
    L58:
        r121 = r121 - 1;
    L57:
        char[] r123 = this.buf;
        int r124 = r121 + 1;
        System.arraycopy(r123, r124, r123, r121 + 2, (r120 - r121) - 1);
        char[] r125 = this.buf;
        r125[r121] = '\\';
        r125[r124] = IOUtils.replaceChars[r122];
        r120 = r120 + 1;
        goto L58
    L12:
        if (this.writer == null) goto L29;
        write(39);
    L15:
        if (r100 >= r110.length) goto L27;
        char r126 = r110[r100];
        if (r126 <= '\r') goto L25;
        if (r126 == '\\') goto L25;
        if (r126 == '\'') goto L25;
        if (r126 == '/') goto L22;
    L24:
        write(r126);
    L26:
        r100 = r100 + 1;
        goto L15
    L22:
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == false) goto L24;
    L25:
        write(92);
        write(IOUtils.replaceChars[r126]);
        goto L26
    L27:
        write(39);
        return;
    L29:
        expandCapacity(r102);
        goto L30
    }

    public SerializeWriter(SerializerFeature... r100) {
        this(null, r100);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r100) throws IOException {
        return append(r100);
    }

    @Override // java.io.Writer
    public void write(String r100) {
        if (r100 != null) goto L5;
        writeNull();
        return;
    L5:
        write(r100, 0, r100.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r100) throws IOException {
        return append(r100);
    }

    public void write(boolean r100) {
        if (r100 == false) goto L4;
        write("true");
        return;
    L4:
        write("false");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
        return append(r100);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char r100) {
        write(r100);
        return this;
    }

    public SerializeWriter(Writer r100, int r101) {
        this.maxBufSize = -1;
        this.writer = r100;
        if (r101 <= 0) goto L7;
        this.buf = new char[r101];
        computeFeatures();
        return;
    L7:
        throw new IllegalArgumentException("Negative initial size: " + r101);
    }

    public void config(SerializerFeature r100, boolean r101) {
        if (r101 == false) goto L9;
        int r102 = this.features | r100.getMask();
        this.features = r102;
        SerializerFeature r103 = SerializerFeature.WriteEnumUsingToString;
        if (r100 != r103) goto L7;
        this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & r102;
    L10:
        computeFeatures();
        return;
    L7:
        if (r100 != SerializerFeature.WriteEnumUsingName) goto L10;
        this.features = (~r103.getMask()) & r102;
        goto L10
    L9:
        int r104 = this.features;
        this.features = (~r100.getMask()) & r104;
        goto L10
    }

    public void writeDouble(double r100, boolean r101) {
        if (Double.isNaN(r100) == false) goto L5;
    L24:
        writeNull();
        return;
    L5:
        if (Double.isInfinite(r100) == true) goto L24;
        int r102 = this.count + 24;
        if (r102 > this.buf.length) goto L10;
    L18:
        this.count += RyuDouble.toString(r100, this.buf, this.count);
        if (r101 == true) goto L21;
        return;
    L21:
        if (isEnabled(SerializerFeature.WriteClassName) == false) goto L29;
        write(68);
        return;
    L29:
        return;
    L10:
        if (this.writer != null) goto L12;
        expandCapacity(r102);
        goto L18
    L12:
        String r103 = RyuDouble.toString(r100);
        write(r103, 0, r103.length());
        if (r101 == true) goto L15;
        return;
    L15:
        if (isEnabled(SerializerFeature.WriteClassName) == false) goto L27;
        write(68);
        return;
    }

    public void writeFieldName(String r110, boolean r111) {
        if (r110 != null) goto L6;
        write("null:");
        return;
    L6:
        if (this.useSingleQuotes == false) goto L12;
        if (this.quoteFieldNames == false) goto L10;
        writeStringWithSingleQuote(r110);
        write(58);
        return;
    L10:
        writeKeyWithSingleQuoteIfHasSpecial(r110);
        return;
    L12:
        if (this.quoteFieldNames == false) goto L14;
        writeStringWithDoubleQuote(r110, ':');
        return;
    L14:
        boolean r100 = true;
        if (r110.length() != 0) goto L17;
        boolean r112 = true;
    L18:
        int r101 = 0;
    L20:
        if (r101 >= r110.length()) goto L32;
        char r102 = r110.charAt(r101);
        if (r102 >= '@') goto L26;
        if ((this.sepcialBits & (1 << r102)) == 0) goto L26;
    L27:
        boolean r103 = true;
    L29:
        if (r103 == true) goto L33;
        r101 = r101 + 1;
    L33:
        if (r100 == false) goto L35;
        writeStringWithDoubleQuote(r110, ':');
        return;
    L35:
        write(r110);
        write(58);
        return;
    L26:
        if (r102 == '\\') goto L27;
        r103 = false;
        goto L29
    L32:
        r100 = r112;
        goto L33
    L17:
        r112 = false;
        goto L18
    }

    public void writeFloat(float r100, boolean r101) {
        if (r100 == r100) goto L5;
    L25:
        writeNull();
        return;
    L5:
        if (r100 == Float.POSITIVE_INFINITY) goto L25;
        if (r100 == Float.NEGATIVE_INFINITY) goto L25;
        int r102 = this.count + 15;
        if (r102 > this.buf.length) goto L12;
    L20:
        this.count += RyuFloat.toString(r100, this.buf, this.count);
        if (r101 == true) goto L23;
        return;
    L23:
        if (isEnabled(SerializerFeature.WriteClassName) == false) goto L30;
        write(70);
        return;
    L30:
        return;
    L12:
        if (this.writer != null) goto L14;
        expandCapacity(r102);
        goto L20
    L14:
        String r103 = RyuFloat.toString(r100);
        write(r103, 0, r103.length());
        if (r101 == true) goto L17;
        return;
    L17:
        if (isEnabled(SerializerFeature.WriteClassName) == false) goto L28;
        write(70);
        return;
    }

    public void writeLongAndChar(long r100, char r101) throws IOException {
        writeLong(r100);
        write(r101);
    }

    public void writeNull(int r100, int r101) {
        if ((r100 & r101) == 0) goto L5;
    L8:
        int r102 = SerializerFeature.WriteMapNullValue.mask;
        if ((r100 & r102) == 0) goto L15;
        if (((r100 & (~r102)) & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) goto L15;
        writeNull();
        return;
    L15:
        if (r101 != SerializerFeature.WriteNullListAsEmpty.mask) goto L18;
        write("[]");
        return;
    L18:
        if (r101 != SerializerFeature.WriteNullStringAsEmpty.mask) goto L21;
        writeString("");
        return;
    L21:
        if (r101 != SerializerFeature.WriteNullBooleanAsFalse.mask) goto L24;
        write("false");
        return;
    L24:
        if (r101 != SerializerFeature.WriteNullNumberAsZero.mask) goto L26;
        write(48);
        return;
    L26:
        writeNull();
        return;
    L5:
        if ((this.features & r101) != 0) goto L8;
        writeNull();
    }

    public void writeString(String r100, char r101) {
        if (this.useSingleQuotes == false) goto L5;
        writeStringWithSingleQuote(r100);
        write(r101);
        return;
    L5:
        writeStringWithDoubleQuote(r100, r101);
    }

    public void writeStringWithDoubleQuote(String r210, char r211) {
        if (r210 != null) goto L8;
        writeNull();
        if (r211 == 0) goto L267;
        write(r211);
        return;
    L267:
        return;
    L8:
        int r100 = r210.length();
        int r101 = (this.count + r100) + 2;
        if (r211 == 0) goto L11;
        r101 = r101 + 1;
    L11:
        int r102 = this.buf.length;
        char r103 = Typography.greater;
        if (r101 > r102) goto L14;
    L66:
        int r104 = this.count;
        int r105 = r104 + 1;
        int r106 = r105 + r100;
        char[] r107 = this.buf;
        r107[r104] = Typography.quote;
        r210.getChars(0, r100, r107, r105);
        this.count = r101;
        int r108 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible) == false) goto L129;
        int r109 = r105;
    L69:
        if (r109 >= r106) goto L95;
        char r110 = this.buf[r109];
        if (r110 != '\"') goto L73;
    L91:
        r101 = r101 + 1;
    L92:
        r108 = r109;
    L93:
        r109 = r109 + 1;
        goto L69
    L73:
        if (r110 == '/') goto L91;
        if (r110 == '\\') goto L91;
        if (r110 == '\b') goto L91;
        if (r110 == '\f') goto L91;
        if (r110 == '\n') goto L91;
        if (r110 == '\r') goto L91;
        if (r110 == '\t') goto L91;
        if (r110 >= ' ') goto L89;
    L87:
        r101 = r101 + 5;
        goto L92
    L89:
        if (r110 < 127) goto L93;
    L95:
        if (r101 <= this.buf.length) goto L97;
        expandCapacity(r101);
    L97:
        this.count = r101;
    L98:
        if (r108 < r105) goto L125;
        char[] r111 = this.buf;
        char r112 = r111[r108];
        if (r112 == '\b') goto L122;
        if (r112 == '\f') goto L122;
        if (r112 == '\n') goto L122;
        if (r112 == '\r') goto L122;
        if (r112 == '\t') goto L122;
        if (r112 != '\"') goto L111;
    L121:
        int r113 = r108 + 1;
        System.arraycopy(r111, r113, r111, r108 + 2, (r106 - r108) - 1);
        char[] r114 = this.buf;
        r114[r108] = '\\';
        r114[r113] = r112;
    L123:
        r106 = r106 + 1;
    L124:
        r108 = r108 - 1;
        goto L98
    L111:
        if (r112 == '/') goto L121;
        if (r112 == '\\') goto L121;
        if (r112 >= ' ') goto L119;
        int r115 = r108 + 1;
        System.arraycopy(r111, r115, r111, r108 + 6, (r106 - r108) - 1);
        char[] r116 = this.buf;
        r116[r108] = '\\';
        r116[r115] = 'u';
        r116[r108 + 2] = '0';
        r116[r108 + 3] = '0';
        char[] r117 = IOUtils.ASCII_CHARS;
        int r118 = r112 * 2;
        r116[r108 + 4] = r117[r118];
        r116[r108 + 5] = r117[r118 + 1];
    L117:
        r106 = r106 + 5;
        goto L124
    L119:
        if (r112 < 127) goto L124;
        int r119 = r108 + 1;
        System.arraycopy(r111, r119, r111, r108 + 6, (r106 - r108) - 1);
        char[] r120 = this.buf;
        r120[r108] = '\\';
        r120[r119] = 'u';
        char[] r121 = IOUtils.DIGITS;
        r120[r108 + 2] = r121[(r112 >>> '\f') & 15];
        r120[r108 + 3] = r121[(r112 >>> '\b') & 15];
        r120[r108 + 4] = r121[(r112 >>> 4) & 15];
        r120[r108 + 5] = r121[r112 & 15];
    L122:
        int r122 = r108 + 1;
        System.arraycopy(r111, r122, r111, r108 + 2, (r106 - r108) - 1);
        char[] r123 = this.buf;
        r123[r108] = '\\';
        r123[r122] = IOUtils.replaceChars[r112];
        goto L123
    L125:
        if (r211 == 0) goto L127;
        char[] r124 = this.buf;
        int r125 = this.count;
        r124[r125 - 2] = Typography.quote;
        r124[r125 - 1] = r211;
        return;
    L127:
        this.buf[this.count - 1] = Typography.quote;
        return;
    L129:
        int r126 = r105;
        int r127 = -1;
        int r128 = 0;
        char r129 = 0;
        int r130 = -1;
    L131:
        if (r126 >= r106) goto L172;
        char r131 = this.buf[r126];
        if (r131 < ']') goto L147;
        if (r131 < 127) goto L171;
        if (r131 != 8232) goto L138;
    L141:
        if (r127 != r108) goto L143;
        r127 = r126;
    L143:
        r128 = r128 + 1;
        r101 = r101 + 4;
    L144:
        r130 = r126;
    L145:
        r129 = r131;
        goto L171
    L138:
        if (r131 == 8233) goto L141;
        if (r131 < 160) goto L141;
    L171:
        r126 = r126 + 1;
        goto L131
    L147:
        if (r131 < '@') goto L149;
    L150:
        if (r131 != '\\') goto L152;
    L151:
        boolean r132 = true;
    L153:
        if (r132 == false) goto L170;
        r128 = r128 + 1;
        if (r131 != '(') goto L157;
    L166:
        r101 = r101 + 4;
    L167:
        r108 = -1;
        if (r127 != (-1)) goto L144;
        r127 = r126;
        r130 = r127;
        goto L145
    L157:
        if (r131 == ')') goto L166;
        if (r131 == '<') goto L166;
        if (r131 == '>') goto L166;
        byte[] r133 = IOUtils.specicalFlags_doubleQuotes;
        if (r131 >= r133.length) goto L167;
        if (r133[r131] != 4) goto L167;
    L170:
        r108 = -1;
        goto L171
    L152:
        r132 = false;
        goto L153
    L149:
        if ((this.sepcialBits & (1 << r131)) != 0) goto L151;
    L172:
        if (r128 <= 0) goto L240;
        int r134 = r101 + r128;
        if (r134 <= this.buf.length) goto L176;
        expandCapacity(r134);
    L176:
        this.count = r134;
        if (r128 != 1) goto L201;
        if (r129 != 8232) goto L182;
        int r135 = r130 + 1;
        char[] r136 = this.buf;
        System.arraycopy(r136, r135, r136, r130 + 6, (r106 - r130) - 1);
        char[] r137 = this.buf;
        r137[r130] = '\\';
        r137[r135] = 'u';
        int r138 = r135 + 1;
        r137[r138] = '2';
        int r139 = r138 + 1;
        r137[r139] = '0';
        int r140 = r139 + 1;
        r137[r140] = '2';
        r137[r140 + 1] = '8';
        goto L240
    L182:
        if (r129 != 8233) goto L185;
        int r141 = r130 + 1;
        char[] r142 = this.buf;
        System.arraycopy(r142, r141, r142, r130 + 6, (r106 - r130) - 1);
        char[] r143 = this.buf;
        r143[r130] = '\\';
        r143[r141] = 'u';
        int r144 = r141 + 1;
        r143[r144] = '2';
        int r145 = r144 + 1;
        r143[r145] = '0';
        int r146 = r145 + 1;
        r143[r146] = '2';
        r143[r146 + 1] = '9';
        goto L240
    L185:
        if (r129 != '(') goto L187;
    L199:
        int r147 = r130 + 1;
        char[] r148 = this.buf;
        System.arraycopy(r148, r147, r148, r130 + 6, (r106 - r130) - 1);
        char[] r149 = this.buf;
        r149[r130] = '\\';
        r149[r147] = 'u';
        int r150 = r147 + 1;
        char[] r151 = IOUtils.DIGITS;
        r149[r150] = r151[(r129 >>> '\f') & 15];
        int r152 = r150 + 1;
        r149[r152] = r151[(r129 >>> '\b') & 15];
        int r153 = r152 + 1;
        r149[r153] = r151[(r129 >>> 4) & 15];
        r149[r153 + 1] = r151[r129 & 15];
        goto L240
    L187:
        if (r129 == ')') goto L199;
        if (r129 == '<') goto L199;
        if (r129 == '>') goto L199;
        byte[] r154 = IOUtils.specicalFlags_doubleQuotes;
        if (r129 < r154.length) goto L196;
    L198:
        int r155 = r130 + 1;
        char[] r156 = this.buf;
        System.arraycopy(r156, r155, r156, r130 + 2, (r106 - r130) - 1);
        char[] r157 = this.buf;
        r157[r130] = '\\';
        r157[r155] = IOUtils.replaceChars[r129];
        goto L240
    L196:
        if (r154[r129] != 4) goto L198;
        int r158 = r130 + 1;
        char[] r159 = this.buf;
        System.arraycopy(r159, r158, r159, r130 + 6, (r106 - r130) - 1);
        char[] r160 = this.buf;
        r160[r130] = '\\';
        int r161 = r158 + 1;
        r160[r158] = 'u';
        int r162 = r161 + 1;
        char[] r163 = IOUtils.DIGITS;
        r160[r161] = r163[(r129 >>> '\f') & 15];
        int r164 = r162 + 1;
        r160[r162] = r163[(r129 >>> '\b') & 15];
        r160[r164] = r163[(r129 >>> 4) & 15];
        r160[r164 + 1] = r163[r129 & 15];
        goto L240
    L201:
        if (r128 <= 1) goto L240;
        int r165 = r127 - r105;
    L204:
        if (r165 >= r210.length()) goto L240;
        char r166 = r210.charAt(r165);
        if (this.browserSecure == false) goto L218;
        if (r166 == '(') goto L215;
        if (r166 == ')') goto L215;
        if (r166 == '<') goto L215;
        if (r166 != '>') goto L218;
    L215:
        char[] r167 = this.buf;
        int r168 = r127 + 1;
        r167[r127] = '\\';
        int r169 = r168 + 1;
        r167[r168] = 'u';
        int r170 = r169 + 1;
        char[] r171 = IOUtils.DIGITS;
        r167[r169] = r171[(r166 >>> '\f') & 15];
        int r172 = r170 + 1;
        r167[r170] = r171[(r166 >>> '\b') & 15];
        int r173 = r172 + 1;
        r167[r172] = r171[(r166 >>> 4) & 15];
        r127 = r173 + 1;
        r167[r173] = r171[r166 & 15];
    L239:
        r165 = r165 + 1;
    L218:
        byte[] r174 = IOUtils.specicalFlags_doubleQuotes;
        if (r166 >= r174.length) goto L225;
        if (r174[r166] == 0) goto L225;
    L228:
        char[] r175 = this.buf;
        int r176 = r127 + 1;
        r175[r127] = '\\';
        if (r174[r166] != 4) goto L231;
        int r177 = r176 + 1;
        r175[r176] = 'u';
        int r178 = r177 + 1;
        char[] r179 = IOUtils.DIGITS;
        r175[r177] = r179[(r166 >>> '\f') & 15];
        int r180 = r178 + 1;
        r175[r178] = r179[(r166 >>> '\b') & 15];
        int r181 = r180 + 1;
        r175[r180] = r179[(r166 >>> 4) & 15];
        r127 = r181 + 1;
        r175[r181] = r179[r166 & 15];
        goto L239
    L231:
        r127 = r176 + 1;
        r175[r176] = IOUtils.replaceChars[r166];
    L225:
        if (r166 != '/') goto L233;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L228;
    L233:
        if (r166 != 8232) goto L235;
    L238:
        char[] r182 = this.buf;
        int r183 = r127 + 1;
        r182[r127] = '\\';
        int r184 = r183 + 1;
        r182[r183] = 'u';
        int r185 = r184 + 1;
        char[] r186 = IOUtils.DIGITS;
        r182[r184] = r186[(r166 >>> '\f') & 15];
        int r187 = r185 + 1;
        r182[r185] = r186[(r166 >>> '\b') & 15];
        int r188 = r187 + 1;
        r182[r187] = r186[(r166 >>> 4) & 15];
        r127 = r188 + 1;
        r182[r188] = r186[r166 & 15];
        goto L239
    L235:
        if (r166 == 8233) goto L238;
        this.buf[r127] = r166;
        r127 = r127 + 1;
    L240:
        if (r211 == 0) goto L242;
        char[] r189 = this.buf;
        int r190 = this.count;
        r189[r190 - 2] = Typography.quote;
        r189[r190 - 1] = r211;
        return;
    L242:
        this.buf[this.count - 1] = Typography.quote;
        return;
    L14:
        if (this.writer == null) goto L65;
        write(34);
        int r191 = 0;
    L17:
        if (r191 >= r210.length()) goto L61;
        char r192 = r210.charAt(r191);
        if (isEnabled(SerializerFeature.BrowserSecure) == false) goto L26;
        if (r192 == '(') goto L24;
        if (r192 == ')') goto L24;
        if (r192 == '<') goto L24;
        if (r192 != r103) goto L26;
    L24:
        write(92);
        write(117);
        char[] r193 = IOUtils.DIGITS;
        write(r193[(r192 >>> '\f') & 15]);
        write(r193[(r192 >>> '\b') & 15]);
        write(r193[(r192 >>> 4) & 15]);
        write(r193[r192 & 15]);
    L60:
        r191 = r191 + 1;
        r103 = Typography.greater;
    L26:
        if (isEnabled(SerializerFeature.BrowserCompatible) == false) goto L47;
        if (r192 == '\b') goto L46;
        if (r192 == '\f') goto L46;
        if (r192 == '\n') goto L46;
        if (r192 == '\r') goto L46;
        if (r192 == '\t') goto L46;
        if (r192 == '\"') goto L46;
        if (r192 == '/') goto L46;
        if (r192 == '\\') goto L46;
        if (r192 >= ' ') goto L44;
        write(92);
        write(117);
        write(48);
        write(48);
        char[] r194 = IOUtils.ASCII_CHARS;
        int r195 = r192 * 2;
        write(r194[r195]);
        write(r194[r195 + 1]);
        goto L60
    L44:
        if (r192 < 127) goto L59;
        write(92);
        write(117);
        char[] r196 = IOUtils.DIGITS;
        write(r196[(r192 >>> '\f') & 15]);
        write(r196[(r192 >>> '\b') & 15]);
        write(r196[(r192 >>> 4) & 15]);
        write(r196[r192 & 15]);
    L59:
        write(r192);
    L46:
        write(92);
        write(IOUtils.replaceChars[r192]);
        goto L60
    L47:
        byte[] r197 = IOUtils.specicalFlags_doubleQuotes;
        if (r192 >= r197.length) goto L52;
        if (r197[r192] == 0) goto L52;
    L55:
        write(92);
        if (r197[r192] != 4) goto L58;
        write(117);
        char[] r198 = IOUtils.DIGITS;
        write(r198[(r192 >>> '\f') & 15]);
        write(r198[(r192 >>> '\b') & 15]);
        write(r198[(r192 >>> 4) & 15]);
        write(r198[r192 & 15]);
        goto L60
    L58:
        write(IOUtils.replaceChars[r192]);
    L52:
        if (r192 != '/') goto L59;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == false) goto L59;
    L61:
        write(34);
        if (r211 == 0) goto L268;
        write(r211);
        return;
    L268:
        return;
    L65:
        expandCapacity(r101);
        goto L66
    }

    public void writeTo(OutputStream r100, String r101) throws IOException {
        writeTo(r100, Charset.forName(r101));
    }

    public int writeToEx(OutputStream r100, Charset r101) throws IOException {
        if (this.writer != null) goto L11;
        if (r101 == IOUtils.UTF8) goto L7;
        byte[] r102 = new String(this.buf, 0, this.count).getBytes(r101);
        r100.write(r102);
        return r102.length;
    L7:
        return encodeToUTF8(r100);
    L11:
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer r100, SerializerFeature... r101) {
        this(r100, 0, r101);
    }

    public void writeStringWithDoubleQuote(char[] r210, char r211) {
        if (r210 != null) goto L8;
        writeNull();
        if (r211 == 0) goto L267;
        write(r211);
        return;
    L267:
        return;
    L8:
        int r100 = r210.length;
        int r101 = (this.count + r100) + 2;
        if (r211 == 0) goto L11;
        r101 = r101 + 1;
    L11:
        int r102 = this.buf.length;
        char r103 = Typography.greater;
        if (r101 > r102) goto L14;
    L66:
        int r104 = this.count;
        int r105 = r104 + 1;
        int r106 = r100 + r105;
        char[] r107 = this.buf;
        r107[r104] = Typography.quote;
        System.arraycopy(r210, 0, r107, r105, r210.length);
        this.count = r101;
        int r108 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible) == false) goto L129;
        int r109 = r105;
    L69:
        if (r109 >= r106) goto L95;
        char r110 = this.buf[r109];
        if (r110 != '\"') goto L73;
    L91:
        r101 = r101 + 1;
    L92:
        r108 = r109;
    L93:
        r109 = r109 + 1;
        goto L69
    L73:
        if (r110 == '/') goto L91;
        if (r110 == '\\') goto L91;
        if (r110 == '\b') goto L91;
        if (r110 == '\f') goto L91;
        if (r110 == '\n') goto L91;
        if (r110 == '\r') goto L91;
        if (r110 == '\t') goto L91;
        if (r110 >= ' ') goto L89;
    L87:
        r101 = r101 + 5;
        goto L92
    L89:
        if (r110 < 127) goto L93;
    L95:
        if (r101 <= this.buf.length) goto L97;
        expandCapacity(r101);
    L97:
        this.count = r101;
    L98:
        if (r108 < r105) goto L125;
        char[] r111 = this.buf;
        char r112 = r111[r108];
        if (r112 == '\b') goto L122;
        if (r112 == '\f') goto L122;
        if (r112 == '\n') goto L122;
        if (r112 == '\r') goto L122;
        if (r112 == '\t') goto L122;
        if (r112 != '\"') goto L111;
    L121:
        int r113 = r108 + 1;
        System.arraycopy(r111, r113, r111, r108 + 2, (r106 - r108) - 1);
        char[] r114 = this.buf;
        r114[r108] = '\\';
        r114[r113] = r112;
    L123:
        r106 = r106 + 1;
    L124:
        r108 = r108 - 1;
        goto L98
    L111:
        if (r112 == '/') goto L121;
        if (r112 == '\\') goto L121;
        if (r112 >= ' ') goto L119;
        int r115 = r108 + 1;
        System.arraycopy(r111, r115, r111, r108 + 6, (r106 - r108) - 1);
        char[] r116 = this.buf;
        r116[r108] = '\\';
        r116[r115] = 'u';
        r116[r108 + 2] = '0';
        r116[r108 + 3] = '0';
        char[] r117 = IOUtils.ASCII_CHARS;
        int r118 = r112 * 2;
        r116[r108 + 4] = r117[r118];
        r116[r108 + 5] = r117[r118 + 1];
    L117:
        r106 = r106 + 5;
        goto L124
    L119:
        if (r112 < 127) goto L124;
        int r119 = r108 + 1;
        System.arraycopy(r111, r119, r111, r108 + 6, (r106 - r108) - 1);
        char[] r120 = this.buf;
        r120[r108] = '\\';
        r120[r119] = 'u';
        char[] r121 = IOUtils.DIGITS;
        r120[r108 + 2] = r121[(r112 >>> '\f') & 15];
        r120[r108 + 3] = r121[(r112 >>> '\b') & 15];
        r120[r108 + 4] = r121[(r112 >>> 4) & 15];
        r120[r108 + 5] = r121[r112 & 15];
    L122:
        int r122 = r108 + 1;
        System.arraycopy(r111, r122, r111, r108 + 2, (r106 - r108) - 1);
        char[] r123 = this.buf;
        r123[r108] = '\\';
        r123[r122] = IOUtils.replaceChars[r112];
        goto L123
    L125:
        if (r211 == 0) goto L127;
        char[] r124 = this.buf;
        int r125 = this.count;
        r124[r125 - 2] = Typography.quote;
        r124[r125 - 1] = r211;
        return;
    L127:
        this.buf[this.count - 1] = Typography.quote;
        return;
    L129:
        int r126 = r105;
        int r127 = -1;
        int r128 = 0;
        char r129 = 0;
        int r130 = -1;
    L131:
        if (r126 >= r106) goto L174;
        char r131 = this.buf[r126];
        if (r131 >= ']') goto L135;
        int r212 = r127;
        if (r131 < '@') goto L149;
    L150:
        if (r131 != '\\') goto L152;
    L151:
        boolean r132 = true;
    L153:
        if (r132 == false) goto L172;
        r128 = r128 + 1;
        if (r131 != '(') goto L157;
    L166:
        r101 = r101 + 4;
    L167:
        int r133 = r212;
        if (r133 != (-1)) goto L170;
        r133 = r126;
        r130 = r133;
    L171:
        r129 = r131;
    L173:
        r126 = r126 + 1;
        r127 = r133;
        r108 = -1;
        goto L131
    L170:
        r130 = r126;
        goto L171
    L157:
        if (r131 == ')') goto L166;
        if (r131 == '<') goto L166;
        if (r131 == '>') goto L166;
        byte[] r134 = IOUtils.specicalFlags_doubleQuotes;
        if (r131 >= r134.length) goto L167;
        if (r134[r131] != 4) goto L167;
    L172:
        r133 = r212;
        goto L173
    L152:
        r132 = false;
        goto L153
    L149:
        if ((this.sepcialBits & (1 << r131)) != 0) goto L151;
    L135:
        if (r131 < 127) goto L145;
        if (r131 != 8232) goto L138;
    L141:
        if (r127 != r108) goto L143;
        r127 = r126;
    L143:
        r128 = r128 + 1;
        r101 = r101 + 4;
        r130 = r126;
        r133 = r127;
        r129 = r131;
        goto L173
    L138:
        if (r131 == 8233) goto L141;
        if (r131 < 160) goto L141;
    L145:
        r133 = r127;
        goto L173
    L174:
        int r135 = r127;
        if (r128 <= 0) goto L242;
        int r136 = r101 + r128;
        if (r136 <= this.buf.length) goto L179;
        expandCapacity(r136);
    L179:
        this.count = r136;
        if (r128 != 1) goto L203;
        if (r129 != 8232) goto L185;
        int r137 = r130 + 1;
        char[] r138 = this.buf;
        System.arraycopy(r138, r137, r138, r130 + 6, (r106 - r130) - 1);
        char[] r139 = this.buf;
        r139[r130] = '\\';
        r139[r137] = 'u';
        int r140 = r137 + 1;
        r139[r140] = '2';
        int r141 = r140 + 1;
        r139[r141] = '0';
        int r142 = r141 + 1;
        r139[r142] = '2';
        r139[r142 + 1] = '8';
        goto L242
    L185:
        if (r129 != 8233) goto L187;
        int r143 = r130 + 1;
        char[] r144 = this.buf;
        System.arraycopy(r144, r143, r144, r130 + 6, (r106 - r130) - 1);
        char[] r145 = this.buf;
        r145[r130] = '\\';
        r145[r143] = 'u';
        int r146 = r143 + 1;
        r145[r146] = '2';
        int r147 = r146 + 1;
        r145[r147] = '0';
        int r148 = r147 + 1;
        r145[r148] = '2';
        r145[r148 + 1] = '9';
        goto L242
    L187:
        if (r129 != '(') goto L189;
    L201:
        int r149 = r130 + 1;
        char[] r150 = this.buf;
        System.arraycopy(r150, r149, r150, r130 + 6, (r106 - r130) - 1);
        char[] r151 = this.buf;
        r151[r130] = '\\';
        r151[r149] = 'u';
        int r152 = r149 + 1;
        char[] r153 = IOUtils.DIGITS;
        r151[r152] = r153[(r129 >>> '\f') & 15];
        int r154 = r152 + 1;
        r151[r154] = r153[(r129 >>> '\b') & 15];
        int r155 = r154 + 1;
        r151[r155] = r153[(r129 >>> 4) & 15];
        r151[r155 + 1] = r153[r129 & 15];
        goto L242
    L189:
        if (r129 == ')') goto L201;
        if (r129 == '<') goto L201;
        if (r129 == '>') goto L201;
        byte[] r156 = IOUtils.specicalFlags_doubleQuotes;
        if (r129 < r156.length) goto L198;
    L200:
        int r157 = r130 + 1;
        char[] r158 = this.buf;
        System.arraycopy(r158, r157, r158, r130 + 2, (r106 - r130) - 1);
        char[] r159 = this.buf;
        r159[r130] = '\\';
        r159[r157] = IOUtils.replaceChars[r129];
        goto L242
    L198:
        if (r156[r129] != 4) goto L200;
        int r160 = r130 + 1;
        char[] r161 = this.buf;
        System.arraycopy(r161, r160, r161, r130 + 6, (r106 - r130) - 1);
        char[] r162 = this.buf;
        r162[r130] = '\\';
        int r163 = r160 + 1;
        r162[r160] = 'u';
        int r164 = r163 + 1;
        char[] r165 = IOUtils.DIGITS;
        r162[r163] = r165[(r129 >>> '\f') & 15];
        int r166 = r164 + 1;
        r162[r164] = r165[(r129 >>> '\b') & 15];
        r162[r166] = r165[(r129 >>> 4) & 15];
        r162[r166 + 1] = r165[r129 & 15];
        goto L242
    L203:
        if (r128 <= 1) goto L242;
        int r167 = r135 - r105;
    L206:
        if (r167 >= r210.length) goto L242;
        char r168 = r210[r167];
        if (this.browserSecure == false) goto L220;
        if (r168 == '(') goto L217;
        if (r168 == ')') goto L217;
        if (r168 == '<') goto L217;
        if (r168 != '>') goto L220;
    L217:
        char[] r169 = this.buf;
        int r170 = r135 + 1;
        r169[r135] = '\\';
        int r171 = r170 + 1;
        r169[r170] = 'u';
        int r172 = r171 + 1;
        char[] r173 = IOUtils.DIGITS;
        r169[r171] = r173[(r168 >>> '\f') & 15];
        int r174 = r172 + 1;
        r169[r172] = r173[(r168 >>> '\b') & 15];
        int r175 = r174 + 1;
        r169[r174] = r173[(r168 >>> 4) & 15];
        r135 = r175 + 1;
        r169[r175] = r173[r168 & 15];
    L241:
        r167 = r167 + 1;
    L220:
        byte[] r176 = IOUtils.specicalFlags_doubleQuotes;
        if (r168 >= r176.length) goto L227;
        if (r176[r168] == 0) goto L227;
    L230:
        char[] r177 = this.buf;
        int r178 = r135 + 1;
        r177[r135] = '\\';
        if (r176[r168] != 4) goto L233;
        int r179 = r178 + 1;
        r177[r178] = 'u';
        int r180 = r179 + 1;
        char[] r181 = IOUtils.DIGITS;
        r177[r179] = r181[(r168 >>> '\f') & 15];
        int r182 = r180 + 1;
        r177[r180] = r181[(r168 >>> '\b') & 15];
        int r183 = r182 + 1;
        r177[r182] = r181[(r168 >>> 4) & 15];
        r135 = r183 + 1;
        r177[r183] = r181[r168 & 15];
        goto L241
    L233:
        r135 = r178 + 1;
        r177[r178] = IOUtils.replaceChars[r168];
    L227:
        if (r168 != '/') goto L235;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L230;
    L235:
        if (r168 != 8232) goto L237;
    L240:
        char[] r184 = this.buf;
        int r185 = r135 + 1;
        r184[r135] = '\\';
        int r186 = r185 + 1;
        r184[r185] = 'u';
        int r187 = r186 + 1;
        char[] r188 = IOUtils.DIGITS;
        r184[r186] = r188[(r168 >>> '\f') & 15];
        int r189 = r187 + 1;
        r184[r187] = r188[(r168 >>> '\b') & 15];
        int r190 = r189 + 1;
        r184[r189] = r188[(r168 >>> 4) & 15];
        r135 = r190 + 1;
        r184[r190] = r188[r168 & 15];
        goto L241
    L237:
        if (r168 == 8233) goto L240;
        this.buf[r135] = r168;
        r135 = r135 + 1;
    L242:
        if (r211 == 0) goto L244;
        char[] r191 = this.buf;
        int r192 = this.count;
        r191[r192 - 2] = Typography.quote;
        r191[r192 - 1] = r211;
        return;
    L244:
        this.buf[this.count - 1] = Typography.quote;
        return;
    L14:
        if (this.writer == null) goto L65;
        write(34);
        int r193 = 0;
    L17:
        if (r193 >= r210.length) goto L61;
        char r194 = r210[r193];
        if (isEnabled(SerializerFeature.BrowserSecure) == false) goto L26;
        if (r194 == '(') goto L24;
        if (r194 == ')') goto L24;
        if (r194 == '<') goto L24;
        if (r194 != r103) goto L26;
    L24:
        write(92);
        write(117);
        char[] r195 = IOUtils.DIGITS;
        write(r195[(r194 >>> '\f') & 15]);
        write(r195[(r194 >>> '\b') & 15]);
        write(r195[(r194 >>> 4) & 15]);
        write(r195[r194 & 15]);
    L60:
        r193 = r193 + 1;
        r103 = Typography.greater;
    L26:
        if (isEnabled(SerializerFeature.BrowserCompatible) == false) goto L47;
        if (r194 == '\b') goto L46;
        if (r194 == '\f') goto L46;
        if (r194 == '\n') goto L46;
        if (r194 == '\r') goto L46;
        if (r194 == '\t') goto L46;
        if (r194 == '\"') goto L46;
        if (r194 == '/') goto L46;
        if (r194 == '\\') goto L46;
        if (r194 >= ' ') goto L44;
        write(92);
        write(117);
        write(48);
        write(48);
        char[] r196 = IOUtils.ASCII_CHARS;
        int r197 = r194 * 2;
        write(r196[r197]);
        write(r196[r197 + 1]);
        goto L60
    L44:
        if (r194 < 127) goto L59;
        write(92);
        write(117);
        char[] r198 = IOUtils.DIGITS;
        write(r198[(r194 >>> '\f') & 15]);
        write(r198[(r194 >>> '\b') & 15]);
        write(r198[(r194 >>> 4) & 15]);
        write(r198[r194 & 15]);
    L59:
        write(r194);
    L46:
        write(92);
        write(IOUtils.replaceChars[r194]);
        goto L60
    L47:
        byte[] r199 = IOUtils.specicalFlags_doubleQuotes;
        if (r194 >= r199.length) goto L52;
        if (r199[r194] == 0) goto L52;
    L55:
        write(92);
        if (r199[r194] != 4) goto L58;
        write(117);
        char[] r200 = IOUtils.DIGITS;
        write(r200[(r194 >>> '\f') & 15]);
        write(r200[(r194 >>> '\b') & 15]);
        write(r200[(r194 >>> 4) & 15]);
        write(r200[r194 & 15]);
        goto L60
    L58:
        write(IOUtils.replaceChars[r194]);
    L52:
        if (r194 != '/') goto L59;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == false) goto L59;
    L61:
        write(34);
        if (r211 == 0) goto L268;
        write(r211);
        return;
    L268:
        return;
    L65:
        expandCapacity(r101);
        goto L66
    }

    public void writeTo(OutputStream r100, Charset r101) throws IOException {
        writeToEx(r100, r101);
    }

    public SerializeWriter(Writer r100, int r101, SerializerFeature... r102) {
        this.maxBufSize = -1;
        this.writer = r100;
        ThreadLocal<char[]> r103 = bufLocal;
        char[] r104 = r103.get();
        this.buf = r104;
        if (r104 == null) goto L5;
        r103.set(null);
    L6:
        int r105 = r102.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r101 = r101 | r102[r106].getMask();
        r106 = r106 + 1;
        goto L7
    L9:
        this.features = r101;
        computeFeatures();
        return;
    L5:
        this.buf = new char[2048];
        goto L6
    }

    private void writeEnumFieldValue(char r100, String r101, String r102) {
        if (this.useSingleQuotes == false) goto L5;
        writeFieldValue(r100, r101, r102);
        return;
    L5:
        writeFieldValueStringWithDoubleQuote(r100, r101, r102);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence r100, int r101, int r102) {
        if (r100 != null) goto L4;
        r100 = "null";
    L4:
        String r103 = r100.subSequence(r101, r102).toString();
        write(r103, 0, r103.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] r100, int r101, int r102) {
        if (r101 < 0) goto L22;
        if (r101 > r100.length) goto L22;
        if (r102 < 0) goto L22;
        int r103 = r101 + r102;
        if (r103 > r100.length) goto L22;
        if (r103 < 0) goto L22;
        if (r102 != 0) goto L11;
        return;
    L11:
        int r104 = this.count + r102;
        if (r104 > this.buf.length) goto L14;
    L19:
        System.arraycopy(r100, r101, this.buf, this.count, r102);
        this.count = r104;
        return;
    L14:
        if (this.writer != null) goto L16;
        expandCapacity(r104);
    L16:
        char[] r105 = this.buf;
        int r106 = r105.length;
        int r107 = this.count;
        int r108 = r106 - r107;
        System.arraycopy(r100, r101, r105, r107, r108);
        this.count = this.buf.length;
        flush();
        r102 = r102 - r108;
        r101 = r101 + r108;
        if (r102 > this.buf.length) goto L16;
        r104 = r102;
    L22:
        throw new IndexOutOfBoundsException();
    }

    public void writeFieldValue(char r100, String r101, long r102) {
        if (r102 != Long.MIN_VALUE) goto L5;
    L22:
        write(r100);
        writeFieldName(r101);
        writeLong(r102);
        return;
    L5:
        if (this.quoteFieldNames == false) goto L22;
        if (isEnabled(SerializerFeature.BrowserCompatible.mask) == true) goto L22;
        if (r102 >= 0) goto L12;
        int r103 = IOUtils.stringSize(-r102) + 1;
    L13:
        int r104 = r101.length();
        int r105 = ((this.count + r104) + 4) + r103;
        if (r105 > this.buf.length) goto L16;
    L20:
        int r106 = this.count;
        this.count = r105;
        char[] r107 = this.buf;
        r107[r106] = r100;
        int r108 = (r106 + r104) + 1;
        r107[r106 + 1] = this.keySeperator;
        r101.getChars(0, r104, r107, r106 + 2);
        char[] r109 = this.buf;
        r109[r108 + 1] = this.keySeperator;
        r109[r108 + 2] = ':';
        IOUtils.getChars(r102, this.count, r109);
        return;
    L16:
        if (this.writer == null) goto L19;
        write(r100);
        writeFieldName(r101);
        writeLong(r102);
        return;
    L19:
        expandCapacity(r105);
        goto L20
    L12:
        r103 = IOUtils.stringSize(r102);
        goto L13
    }

    public void writeFieldValueStringWithDoubleQuote(char r110, String r111, String r112) {
        int r100 = r111.length();
        int r101 = this.count;
        int r102 = r112.length();
        int r103 = r101 + ((r100 + r102) + 6);
        if (r103 > this.buf.length) goto L5;
    L9:
        char[] r104 = this.buf;
        int r105 = this.count;
        r104[r105] = r110;
        int r113 = r105 + 2;
        int r106 = r113 + r100;
        r104[r105 + 1] = Typography.quote;
        r111.getChars(0, r100, r104, r113);
        this.count = r103;
        char[] r114 = this.buf;
        r114[r106] = Typography.quote;
        int r107 = r106 + 1;
        int r115 = r107 + 1;
        r114[r107] = ':';
        r114[r115] = Typography.quote;
        r112.getChars(0, r102, r114, r115 + 1);
        this.buf[this.count - 1] = Typography.quote;
        return;
    L5:
        if (this.writer == null) goto L8;
        write(r110);
        writeStringWithDoubleQuote(r111, ':');
        writeStringWithDoubleQuote(r112, 0);
        return;
    L8:
        expandCapacity(r103);
        goto L9
    }

    public void writeFieldValueStringWithDoubleQuoteCheck(char r210, String r211, String r212) {
        int r100 = r211.length();
        int r101 = this.count;
        if (r212 != null) goto L5;
        int r102 = r101 + (r100 + 8);
        int r103 = 4;
    L7:
        if (r102 > this.buf.length) goto L9;
    L13:
        char[] r104 = this.buf;
        int r110 = this.count;
        r104[r110] = r210;
        int r111 = r110 + 2;
        int r112 = r111 + r100;
        r104[r110 + 1] = Typography.quote;
        r211.getChars(0, r100, r104, r111);
        this.count = r102;
        char[] r105 = this.buf;
        r105[r112] = Typography.quote;
        int r113 = r112 + 1;
        int r106 = r113 + 1;
        r105[r113] = ':';
        if (r212 != null) goto L17;
        int r107 = r106 + 1;
        r105[r106] = 'n';
        int r108 = r107 + 1;
        r105[r107] = 'u';
        r105[r108] = Symlink.UNIX_ID;
        r105[r108 + 1] = Symlink.UNIX_ID;
        return;
    L17:
        int r109 = r106 + 1;
        r105[r106] = Typography.quote;
        int r114 = r109 + r103;
        r212.getChars(0, r103, r105, r109);
        int r115 = -1;
        int r116 = r109;
        int r117 = 0;
        char r118 = 0;
        int r119 = -1;
        int r120 = -1;
    L19:
        if (r116 >= r114) goto L59;
        char r121 = this.buf[r116];
        if (r121 < ']') goto L34;
        if (r121 < 127) goto L58;
        if (r121 == 8232) goto L28;
        if (r121 == 8233) goto L28;
        if (r121 >= 160) goto L58;
    L28:
        if (r119 != r115) goto L30;
        r119 = r116;
    L30:
        r117 = r117 + 1;
        r102 = r102 + 4;
    L31:
        r120 = r116;
    L32:
        r118 = r121;
    L58:
        r116 = r116 + 1;
        goto L19
    L34:
        if (r121 < '@') goto L36;
    L37:
        if (r121 != '\\') goto L39;
    L38:
        boolean r122 = true;
    L40:
        if (r122 == false) goto L57;
        r117 = r117 + 1;
        if (r121 != '(') goto L44;
    L53:
        r102 = r102 + 4;
    L54:
        r115 = -1;
        if (r119 != (-1)) goto L31;
        r119 = r116;
        r120 = r119;
        goto L32
    L44:
        if (r121 == ')') goto L53;
        if (r121 == '<') goto L53;
        if (r121 == '>') goto L53;
        byte[] r123 = IOUtils.specicalFlags_doubleQuotes;
        if (r121 >= r123.length) goto L54;
        if (r123[r121] != 4) goto L54;
    L57:
        r115 = -1;
        goto L58
    L39:
        r122 = false;
        goto L40
    L36:
        if ((this.sepcialBits & (1 << r121)) != 0) goto L38;
    L59:
        if (r117 <= 0) goto L123;
        int r124 = r102 + r117;
        if (r124 <= this.buf.length) goto L63;
        expandCapacity(r124);
    L63:
        this.count = r124;
        if (r117 == 1) goto L66;
        if (r117 <= 1) goto L123;
        int r125 = r119 - r109;
    L89:
        if (r125 >= r212.length()) goto L123;
        char r126 = r212.charAt(r125);
        if (this.browserSecure == false) goto L102;
        if (r126 == '(') goto L100;
        if (r126 == ')') goto L100;
        if (r126 == '<') goto L100;
        if (r126 != '>') goto L102;
    L100:
        char[] r127 = this.buf;
        int r128 = r119 + 1;
        r127[r119] = '\\';
        int r129 = r128 + 1;
        r127[r128] = 'u';
        int r130 = r129 + 1;
        char[] r131 = IOUtils.DIGITS;
        r127[r129] = r131[(r126 >>> '\f') & 15];
        int r132 = r130 + 1;
        r127[r130] = r131[(r126 >>> '\b') & 15];
        int r133 = r132 + 1;
        r127[r132] = r131[(r126 >>> 4) & 15];
        r119 = r133 + 1;
        r127[r133] = r131[r126 & 15];
    L122:
        r125 = r125 + 1;
    L102:
        byte[] r134 = IOUtils.specicalFlags_doubleQuotes;
        if (r126 >= r134.length) goto L107;
        if (r134[r126] == 0) goto L107;
    L110:
        char[] r135 = this.buf;
        int r136 = r119 + 1;
        r135[r119] = '\\';
        if (r134[r126] != 4) goto L113;
        int r137 = r136 + 1;
        r135[r136] = 'u';
        int r138 = r137 + 1;
        char[] r139 = IOUtils.DIGITS;
        r135[r137] = r139[(r126 >>> '\f') & 15];
        int r140 = r138 + 1;
        r135[r138] = r139[(r126 >>> '\b') & 15];
        int r141 = r140 + 1;
        r135[r140] = r139[(r126 >>> 4) & 15];
        int r142 = r141 + 1;
        r135[r141] = r139[r126 & 15];
    L114:
        r119 = r142;
        goto L122
    L113:
        r142 = r136 + 1;
        r135[r136] = IOUtils.replaceChars[r126];
    L107:
        if (r126 != '/') goto L117;
        if (isEnabled(SerializerFeature.WriteSlashAsSpecial) == true) goto L110;
    L117:
        if (r126 == 8232) goto L121;
        if (r126 == 8233) goto L121;
        this.buf[r119] = r126;
        r119 = r119 + 1;
    L121:
        char[] r143 = this.buf;
        int r144 = r119 + 1;
        r143[r119] = '\\';
        int r145 = r144 + 1;
        r143[r144] = 'u';
        int r146 = r145 + 1;
        char[] r147 = IOUtils.DIGITS;
        r143[r145] = r147[(r126 >>> '\f') & 15];
        int r148 = r146 + 1;
        r143[r146] = r147[(r126 >>> '\b') & 15];
        int r149 = r148 + 1;
        r143[r148] = r147[(r126 >>> 4) & 15];
        r119 = r149 + 1;
        r143[r149] = r147[r126 & 15];
        goto L122
    L66:
        if (r118 != 8232) goto L68;
        int r150 = r120 + 1;
        char[] r151 = this.buf;
        System.arraycopy(r151, r150, r151, r120 + 6, (r114 - r120) - 1);
        char[] r152 = this.buf;
        r152[r120] = '\\';
        r152[r150] = 'u';
        int r153 = r150 + 1;
        r152[r153] = '2';
        int r154 = r153 + 1;
        r152[r154] = '0';
        int r155 = r154 + 1;
        r152[r155] = '2';
        r152[r155 + 1] = '8';
        goto L123
    L68:
        if (r118 != 8233) goto L71;
        int r156 = r120 + 1;
        char[] r157 = this.buf;
        System.arraycopy(r157, r156, r157, r120 + 6, (r114 - r120) - 1);
        char[] r158 = this.buf;
        r158[r120] = '\\';
        r158[r156] = 'u';
        int r159 = r156 + 1;
        r158[r159] = '2';
        int r160 = r159 + 1;
        r158[r160] = '0';
        int r161 = r160 + 1;
        r158[r161] = '2';
        r158[r161 + 1] = '9';
        goto L123
    L71:
        if (r118 != '(') goto L73;
    L85:
        int r162 = r120 + 1;
        char[] r163 = this.buf;
        System.arraycopy(r163, r162, r163, r120 + 6, (r114 - r120) - 1);
        char[] r164 = this.buf;
        r164[r120] = '\\';
        int r165 = r162 + 1;
        r164[r162] = 'u';
        int r166 = r165 + 1;
        char[] r167 = IOUtils.DIGITS;
        r164[r165] = r167[(r118 >>> '\f') & 15];
        int r168 = r166 + 1;
        r164[r166] = r167[(r118 >>> '\b') & 15];
        r164[r168] = r167[(r118 >>> 4) & 15];
        r164[r168 + 1] = r167[r118 & 15];
        goto L123
    L73:
        if (r118 == ')') goto L85;
        if (r118 == '<') goto L85;
        if (r118 == '>') goto L85;
        byte[] r169 = IOUtils.specicalFlags_doubleQuotes;
        if (r118 < r169.length) goto L82;
    L84:
        int r170 = r120 + 1;
        char[] r171 = this.buf;
        System.arraycopy(r171, r170, r171, r120 + 2, (r114 - r120) - 1);
        char[] r172 = this.buf;
        r172[r120] = '\\';
        r172[r170] = IOUtils.replaceChars[r118];
        goto L123
    L82:
        if (r169[r118] != 4) goto L84;
        int r173 = r120 + 1;
        char[] r174 = this.buf;
        System.arraycopy(r174, r173, r174, r120 + 6, (r114 - r120) - 1);
        char[] r175 = this.buf;
        r175[r120] = '\\';
        int r176 = r173 + 1;
        r175[r173] = 'u';
        int r177 = r176 + 1;
        char[] r178 = IOUtils.DIGITS;
        r175[r176] = r178[(r118 >>> '\f') & 15];
        int r179 = r177 + 1;
        r175[r177] = r178[(r118 >>> '\b') & 15];
        r175[r179] = r178[(r118 >>> 4) & 15];
        r175[r179 + 1] = r178[r118 & 15];
    L123:
        this.buf[this.count - 1] = Typography.quote;
        return;
    L9:
        if (this.writer == null) goto L12;
        write(r210);
        writeStringWithDoubleQuote(r211, ':');
        writeStringWithDoubleQuote(r212, 0);
        return;
    L12:
        expandCapacity(r102);
        goto L13
    L5:
        r103 = r212.length();
        r102 = r101 + ((r100 + r103) + 6);
        goto L7
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r100, int r101, int r102) throws IOException {
        return append(r100, r101, r102);
    }

    @Override // java.io.Writer
    public void write(String r100, int r101, int r102) {
        int r103 = this.count + r102;
        if (r103 > this.buf.length) goto L5;
    L11:
        r100.getChars(r101, r102 + r101, this.buf, this.count);
        this.count = r103;
        return;
    L5:
        if (this.writer != null) goto L7;
        expandCapacity(r103);
    L7:
        char[] r104 = this.buf;
        int r105 = r104.length;
        int r106 = this.count;
        int r107 = r105 - r106;
        int r108 = r101 + r107;
        r100.getChars(r101, r108, r104, r106);
        this.count = this.buf.length;
        flush();
        r102 = r102 - r107;
        if (r102 <= this.buf.length) goto L9;
        r101 = r108;
        goto L7
    L9:
        r103 = r102;
        r101 = r108;
        goto L11
    }

    public void writeFieldValue(char r100, String r101, int r102) {
        if (r102 != Integer.MIN_VALUE) goto L5;
    L19:
        write(r100);
        writeFieldName(r101);
        writeInt(r102);
        return;
    L5:
        if (this.quoteFieldNames == false) goto L19;
        if (r102 >= 0) goto L9;
        int r103 = IOUtils.stringSize(-r102) + 1;
    L10:
        int r104 = r101.length();
        int r105 = ((this.count + r104) + 4) + r103;
        if (r105 > this.buf.length) goto L13;
    L17:
        int r106 = this.count;
        this.count = r105;
        char[] r107 = this.buf;
        r107[r106] = r100;
        int r108 = (r106 + r104) + 1;
        r107[r106 + 1] = this.keySeperator;
        r101.getChars(0, r104, r107, r106 + 2);
        char[] r109 = this.buf;
        r109[r108 + 1] = this.keySeperator;
        r109[r108 + 2] = ':';
        IOUtils.getChars(r102, this.count, r109);
        return;
    L13:
        if (this.writer == null) goto L16;
        write(r100);
        writeFieldName(r101);
        writeInt(r102);
        return;
    L16:
        expandCapacity(r105);
        goto L17
    L9:
        r103 = IOUtils.stringSize(r102);
        goto L10
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) throws IOException {
        return append(r100, r101, r102);
    }

    public void writeFieldValue(char r100, String r101, boolean r102) {
        if (this.quoteFieldNames == true) goto L7;
        write(r100);
        writeFieldName(r101);
        write(r102);
        return;
    L7:
        if (r102 == false) goto L9;
        int r103 = 4;
    L10:
        int r104 = r101.length();
        int r105 = ((this.count + r104) + 4) + r103;
        if (r105 > this.buf.length) goto L13;
    L17:
        int r106 = this.count;
        this.count = r105;
        char[] r107 = this.buf;
        r107[r106] = r100;
        int r108 = (r106 + r104) + 1;
        r107[r106 + 1] = this.keySeperator;
        r101.getChars(0, r104, r107, r106 + 2);
        char[] r109 = this.buf;
        r109[r108 + 1] = this.keySeperator;
        if (r102 == false) goto L20;
        System.arraycopy(VALUE_TRUE, 0, r109, r108 + 2, 5);
        return;
    L20:
        System.arraycopy(VALUE_FALSE, 0, r109, r108 + 2, 6);
        return;
    L13:
        if (this.writer == null) goto L16;
        write(r100);
        writeString(r101);
        write(58);
        write(r102);
        return;
    L16:
        expandCapacity(r105);
        goto L17
    L9:
        r103 = 5;
        goto L10
    }

    public void writeFieldValue(char r100, String r101, String r102) {
        if (this.quoteFieldNames == true) goto L5;
        write(r100);
        writeFieldName(r101);
        if (r102 != null) goto L17;
        writeNull();
        return;
    L17:
        writeString(r102);
        return;
    L5:
        if (this.useSingleQuotes == false) goto L11;
        write(r100);
        writeFieldName(r101);
        if (r102 != null) goto L9;
        writeNull();
        return;
    L9:
        writeString(r102);
        return;
    L11:
        if (isEnabled(SerializerFeature.BrowserCompatible) == false) goto L13;
        write(r100);
        writeStringWithDoubleQuote(r101, ':');
        writeStringWithDoubleQuote(r102, 0);
        return;
    L13:
        writeFieldValueStringWithDoubleQuoteCheck(r100, r101, r102);
    }

    public void writeFieldValue(char r100, String r101, Enum<?> r102) {
        if (r102 != null) goto L6;
        write(r100);
        writeFieldName(r101);
        writeNull();
        return;
    L6:
        if (this.writeEnumUsingName == false) goto L11;
        if (this.writeEnumUsingToString == true) goto L11;
        writeEnumFieldValue(r100, r101, r102.name());
        return;
    L11:
        if (this.writeEnumUsingToString == false) goto L13;
        writeEnumFieldValue(r100, r101, r102.toString());
        return;
    L13:
        writeFieldValue(r100, r101, r102.ordinal());
    }

    public void writeFieldValue(char r100, String r101, BigDecimal r102) {
        write(r100);
        writeFieldName(r101);
        if (r102 != null) goto L5;
        writeNull();
        return;
    L5:
        int r103 = r102.scale();
        if (isEnabled(SerializerFeature.WriteBigDecimalAsPlain) == true) goto L8;
    L12:
        String r104 = r102.toString();
    L13:
        write(r104);
        return;
    L8:
        if (r103 < (-100)) goto L12;
        if (r103 >= 100) goto L12;
        r104 = r102.toPlainString();
        goto L13
    }

    public void writeFieldValue(char r100, String r101, char r102) {
        write(r100);
        writeFieldName(r101);
        if (r102 != 0) goto L5;
        writeString("\u0000");
        return;
    L5:
        writeString(Character.toString(r102));
    }

    public void writeFieldValue(char r100, String r101, double r102) {
        write(r100);
        writeFieldName(r101);
        writeDouble(r102, false);
    }

    public void writeFieldValue(char r100, String r101, float r102) {
        write(r100);
        writeFieldName(r101);
        writeFloat(r102, false);
    }
}
