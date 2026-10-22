package com.android.ttcjpaysdk.kmp.base.uri;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nJ\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nJ!\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u000f\u001a\u00020\nH\u0082\bJ*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J*\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/UriCodec;", "", "<init>", "()V", "encodeOrNull", "", "s", "allow", "encode", "isAllowed", "", "c", "", "decodeOrNull", "convertPlus", "throwOnFailure", "decode", "flushDecodingByteAccumulator", "", "Lcom/android/ttcjpaysdk/kmp/base/uri/UriCodec$ByteBuffer;", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "unexpectedCharacterException", "Lcom/android/ttcjpaysdk/kmp/base/uri/UriSyntaxException;", "uri", "name", "unexpected", "index", "", "getNextCharacter", "end", "hexCharToValue", "lowercaseAsciiAlphaRange", "Lkotlin/ranges/CharRange;", "lowercaseHexRange", "uppercaseAsciiAlphaRange", "uppercaseHexRange", "digitAsciiRange", "defaultAllowedSet", "", "hexDigits", "", "INVALID_INPUT_CHARACTER", "ByteBuffer", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UriCodec {
    public static final int $stable = 0;
    public static final UriCodec INSTANCE = null;
    private static final char INVALID_INPUT_CHARACTER = 65533;
    private static final Set<Character> defaultAllowedSet = null;
    private static final CharRange digitAsciiRange = null;
    private static final char[] hexDigits = null;
    private static final CharRange lowercaseAsciiAlphaRange = null;
    private static final CharRange lowercaseHexRange = null;
    private static final CharRange uppercaseAsciiAlphaRange = null;
    private static final CharRange uppercaseHexRange = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/UriCodec$ByteBuffer;", "", "size", "", "<init>", "(I)V", "buffer", "", "getBuffer", "()[B", "buffer$delegate", "Lkotlin/Lazy;", "value", "writePosition", "getWritePosition", "()I", "writeByte", "", "byte", "", "decodeToStringAndReset", "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ByteBuffer {
        private final Lazy buffer$delegate;
        private final int size;
        private int writePosition;

        public static /* synthetic */ byte[] a(ByteBuffer r100) {
            return buffer_delegate$lambda$0(r100);
        }

        public final String decodeToStringAndReset() {
            String r100 = StringsKt.decodeToString(getBuffer(), 0, this.writePosition, false);     // Catch: Throwable -> L6
            this.writePosition = 0;
            return r100;
        L6:
            th = move-exception;
            this.writePosition = 0;
            throw th;
        }

        private final byte[] getBuffer() {
            return (byte[]) this.buffer$delegate.getValue();
        }

        public final int getWritePosition() {
            return this.writePosition;
        }

        public ByteBuffer(int r100) {
            this.size = r100;
            this.buffer$delegate = LazyKt.lazy(new a(this));
        }

        private static final byte[] buffer_delegate$lambda$0(ByteBuffer r100) {
            int r101 = r100.size;
            byte[] r102 = new byte[r101];
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            r102[r103] = 0;
            r103 = r103 + 1;
            goto L3
        L5:
            return r102;
        }

        public final void writeByte(byte r100) {
            byte[] r101 = getBuffer();
            int r102 = this.writePosition;
            this.writePosition = r102 + 1;
            r101[r102] = r100;
        }
    }

    private UriCodec() {
    }

    static {
        INSTANCE = new UriCodec();
        lowercaseAsciiAlphaRange = new CharRange('a', 'z');
        lowercaseHexRange = new CharRange('a', 'f');
        uppercaseAsciiAlphaRange = new CharRange('A', Matrix.MATRIX_TYPE_ZERO);
        uppercaseHexRange = new CharRange('A', 'F');
        digitAsciiRange = new CharRange('0', '9');
        defaultAllowedSet = SetsKt.setOf(new Character[]{'_', '-', '!', '.', '~', '\'', '(', ')', '*'});
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        $stable = 8;
    }

    private final int hexCharToValue(char r100) {
        CharRange r101 = digitAsciiRange;
        char r102 = r101.getFirst();
        boolean r103 = true;
        if (r100 > r101.getLast()) goto L6;
        if (r102 > r100) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L25;
        CharRange r105 = lowercaseHexRange;
        char r106 = r105.getFirst();
        if (r100 > r105.getLast()) goto L13;
        if (r106 > r100) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L26;
        CharRange r108 = uppercaseHexRange;
        char r109 = r108.getFirst();
        if (r100 > r108.getLast()) goto L20;
        if (r109 > r100) goto L20;
    L21:
        if (r103 == true) goto L27;
        return -1;
    L27:
        return (r100 + '\n') - 65;
    L20:
        r103 = false;
        goto L21
    L26:
        return (r100 + '\n') - 97;
    L13:
        r107 = false;
        goto L14
    L25:
        return r100 - '0';
    L6:
        r104 = false;
        goto L7
    }

    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        return encode(r100, null);
    }

    public final String encodeOrNull(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return encode(r100, null);
    }

    private final boolean isAllowed(char r110, String r111) {
        CharRange r100 = lowercaseAsciiAlphaRange;
        char r101 = r100.getFirst();
        if (r110 > r100.getLast()) goto L6;
        if (r101 > r110) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L28;
        CharRange r103 = uppercaseAsciiAlphaRange;
        char r104 = r103.getFirst();
        if (r110 > r103.getLast()) goto L12;
        if (r104 > r110) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L29;
        CharRange r106 = digitAsciiRange;
        char r107 = r106.getFirst();
        if (r110 > r106.getLast()) goto L18;
        if (r107 > r110) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        return true;
    L21:
        if (defaultAllowedSet.contains(Character.valueOf(r110)) == true) goto L31;
        if (r111 != null) goto L24;
    L26:
        return false;
    L24:
        if (StringsKt.indexOf$default(r111, r110, 0, false, 6, null) == (-1)) goto L26;
        return true;
    L31:
        return true;
    L18:
        r108 = false;
        goto L19
    L29:
        return true;
    L12:
        r105 = false;
        goto L13
    L28:
        return true;
    L6:
        r102 = false;
        goto L7
    }

    public final String encode(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "s");
        int r100 = r110.length();
        StringBuilder r101 = null;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L31;
        int r103 = r102;
    L5:
        if (r103 >= r100) goto L9;
        if (isAllowed(r110.charAt(r103), r111) == false) goto L9;
        r103 = r103 + 1;
    L9:
        if (r103 == r100) goto L10;
        if (r101 != null) goto L16;
        r101 = new StringBuilder();
    L16:
        if (r103 <= r102) goto L18;
        r101.append(r110, r102, r103);
    L18:
        r102 = r103 + 1;
    L19:
        if (r102 >= r100) goto L38;
        if (isAllowed(r110.charAt(r102), r111) == true) goto L38;
        r102 = r102 + 1;
    L38:
        byte[] r104 = StringsKt.encodeToByteArray(r110.substring(r103, r102));     // Catch: Exception -> L28
        int r105 = r104.length;     // Catch: Exception -> L28
        int r106 = 0;
    L25:
        if (r106 >= r105) goto L3;
        r101.append('%');     // Catch: Exception -> L28
        char[] r107 = hexDigits;     // Catch: Exception -> L28
        r101.append(r107[(r104[r106] & 240) >> 4]);     // Catch: Exception -> L28
        r101.append(r107[r104[r106] & 15]);     // Catch: Exception -> L28
        r106 = r106 + 1;
    L28:
        e = move-exception;
        throw new AssertionError(e);
    L10:
        if (r102 == 0) goto L49;
        Intrinsics.checkNotNull(r101);
        r101.append(r110, r102, r100);
        String r112 = r101.toString();
        Intrinsics.checkNotNull(r112);
        return r112;
    L49:
        return r110;
    L31:
        StringsKt.decodeToString(new byte[0]);
        if (r101 == null) goto L50;
        String r113 = r101.toString();
        if (r113 != null) goto L37;
        return r110;
    L37:
        return r113;
    L50:
        return r110;
    }

    public final String encodeOrNull(String r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return encode(r100, r101);
    }

    private final void flushDecodingByteAccumulator(ByteBuffer r100, StringBuilder r101, boolean r102) {
        if (r100.getWritePosition() != 0) goto L13;
        return;
    L13:
        r101.append(r100.decodeToStringAndReset());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if (r102 == true) goto L12;
        r101.append(INVALID_INPUT_CHARACTER);
        return;
    L12:
        throw new IllegalArgumentException(e);
    }

    public final String decode(String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "s");
        StringBuilder r100 = new StringBuilder(r110.length());
        ByteBuffer r101 = new ByteBuffer(r110.length());
        int r102 = 0;
    L4:
        if (r102 >= r110.length()) goto L69;
        int r103 = r102 + 1;
        char r104 = r110.charAt(r102);
        if (r104 == '%') goto L32;
        char r105 = '+';
        if (r104 == '+') goto L20;
        if (r101.getWritePosition() != 0) goto L83;
    L18:
        r100.append(r104);
    L31:
        r102 = r103;
        goto L4
    L83:
        r100.append(r101.decodeToStringAndReset());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        if (r112 == true) goto L17;
        r100.append(INVALID_INPUT_CHARACTER);
        goto L18
    L17:
        throw new IllegalArgumentException(e);
    L20:
        if (r101.getWritePosition() != 0) goto L85;
    L28:
        if (r111 == false) goto L30;
        r105 = ' ';
    L30:
        r100.append(r105);
        goto L31
    L85:
        r100.append(r101.decodeToStringAndReset());     // Catch: Exception -> L23
    L23:
        e = move-exception;
        if (r112 == true) goto L27;
        r100.append(INVALID_INPUT_CHARACTER);
        goto L28
    L27:
        throw new IllegalArgumentException(e);
    L32:
        int r106 = 0;
        byte r107 = 0;
    L34:
        if (r106 >= 2) goto L67;
        UriCodec r108 = INSTANCE;     // Catch: UriSyntaxException -> L52
        char r109 = r108.getNextCharacter(r110, r103, r110.length(), null);     // Catch: UriSyntaxException -> L52
        r103 = r103 + 1;
        int r113 = r108.hexCharToValue(r109);
        if (r113 < 0) goto L38;
        r107 = (byte) ((r107 * 16) + r113);
        r106 = r106 + 1;
        goto L34
    L38:
        if (r112 == true) goto L50;
        if (r101.getWritePosition() != 0) goto L87;
    L48:
        r100.append(INVALID_INPUT_CHARACTER);
        goto L67
    L87:
        r100.append(r101.decodeToStringAndReset());     // Catch: Exception -> L43
    L43:
        e = move-exception;
        if (r112 == true) goto L47;
        r100.append(INVALID_INPUT_CHARACTER);
        goto L48
    L47:
        throw new IllegalArgumentException(e);
    L50:
        throw new IllegalArgumentException(r108.unexpectedCharacterException(r110, null, r109, r103 - 1));
    L52:
        e = move-exception;
        if (r112 == true) goto L66;
        if (r101.getWritePosition() != 0) goto L89;
    L63:
        r100.append(INVALID_INPUT_CHARACTER);
        return r100.toString();
    L89:
        r100.append(r101.decodeToStringAndReset());     // Catch: Exception -> L58
    L58:
        e = move-exception;
        if (r112 == true) goto L62;
        r100.append(INVALID_INPUT_CHARACTER);
        goto L63
    L62:
        throw new IllegalArgumentException(e);
    L66:
        throw new IllegalArgumentException(e);
    L67:
        r101.writeByte(r107);
        Unit r114 = Unit.INSTANCE;
        goto L31
    L69:
        if (r101.getWritePosition() == 0) goto L78;
        r100.append(r101.decodeToStringAndReset());     // Catch: Exception -> L72
    L72:
        e = move-exception;
        if (r112 == true) goto L76;
        r100.append(INVALID_INPUT_CHARACTER);
        goto L78
    L76:
        throw new IllegalArgumentException(e);
    L78:
        return r100.toString();
    }

    public final String decodeOrNull(String r100, boolean r101, boolean r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return decode(r100, r101, r102);
    }

    private final char getNextCharacter(String r100, int r101, int r102, String r103) {
        if (r101 < r102) goto L9;
        if (r103 != null) goto L5;
        String r104 = "";
    L7:
        throw new UriSyntaxException(r100, "Unexpected end of string " + r104, r101);
    L5:
        r104 = " in [" + r103 + ']';
        goto L7
    L9:
        return r100.charAt(r101);
    }

    private final UriSyntaxException unexpectedCharacterException(String r100, String r101, char r102, int r103) {
        if (r101 != null) goto L4;
        String r104 = "";
    L6:
        return new UriSyntaxException(r100, "Unexpected character" + r104 + ": " + r102, r103);
    L4:
        r104 = " in [" + r101 + ']';
        goto L6
    }

    public static /* synthetic */ String decode$default(UriCodec r100, String r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.decode(r101, r102, r103);
    }

    public static /* synthetic */ String decodeOrNull$default(UriCodec r100, String r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.decodeOrNull(r101, r102, r103);
    }
}
