package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16 = null;
    private static final BaseEncoding BASE32 = null;
    private static final BaseEncoding BASE32_HEX = null;
    private static final BaseEncoding BASE64 = null;
    private static final BaseEncoding BASE64_URL = null;

    private static final class Alphabet extends CharMatcher {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        Alphabet(String r9, char[] r10) {
            this.name = (String) Preconditions.checkNotNull(r9);
            this.chars = (char[]) Preconditions.checkNotNull(r10);
            int r11 = IntMath.log2(r10.length, RoundingMode.UNNECESSARY);     // Catch: ArithmeticException -> L18
            this.bitsPerChar = r11;     // Catch: ArithmeticException -> L18
            int r0 = Math.min(8, Integer.lowestOneBit(r11));
            this.charsPerChunk = 8 / r0;
            this.bytesPerChunk = r11 / r0;
            this.mask = r10.length - 1;
            byte[] r12 = new byte[128];
            Arrays.fill(r12, (byte) -1);
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r3 >= r10.length) goto L12;
            char r4 = r10[r3];
            Preconditions.checkArgument(CharMatcher.ASCII.matches(r4), "Non-ASCII character: %s", new Object[]{Character.valueOf(r4)});
            if (r12[r4] != (-1)) goto L10;
            boolean r5 = true;
        L11:
            Preconditions.checkArgument(r5, "Duplicate character: %s", new Object[]{Character.valueOf(r4)});
            r12[r4] = (byte) r3;
            r3 = r3 + 1;
            goto L6
        L10:
            r5 = false;
            goto L11
        L12:
            this.decodabet = r12;
            boolean[] r13 = new boolean[this.charsPerChunk];
        L14:
            if (r2 >= this.bytesPerChunk) goto L16;
            r13[IntMath.divide(r2 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
            r2 = r2 + 1;
            goto L14
        L16:
            this.validPadding = r13;
            return;
        L18:
            e = move-exception;
            throw new IllegalArgumentException("Illegal alphabet length " + r10.length, e);
        }

        char encode(int r1) {
            return this.chars[r1];
        }

        boolean isValidPaddingStartPosition(int r2) {
            return this.validPadding[r2 % this.charsPerChunk];
        }

        int decode(char r3) throws IOException {
            if (r3 > 127) goto L8;
            byte r2 = this.decodabet[r3];
            if (r2 == (-1)) goto L8;
            return r2;
        L8:
            throw new DecodingException("Unrecognized character: " + r3);
        }

        private boolean hasLowerCase() {
            char[] r4 = this.chars;
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (Ascii.isLowerCase(r4[r2]) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private boolean hasUpperCase() {
            char[] r4 = this.chars;
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (Ascii.isUpperCase(r4[r2]) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        Alphabet upperCase() {
            if (hasLowerCase() == true) goto L5;
            return this;
        L5:
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] r0 = new char[this.chars.length];
            int r1 = 0;
        L6:
            char[] r2 = this.chars;
            if (r1 >= r2.length) goto L10;
            r0[r1] = Ascii.toUpperCase(r2[r1]);
            r1 = r1 + 1;
            goto L6
        L10:
            return new Alphabet(this.name + ".upperCase()", r0);
        }

        Alphabet lowerCase() {
            if (hasUpperCase() == true) goto L5;
            return this;
        L5:
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] r0 = new char[this.chars.length];
            int r1 = 0;
        L6:
            char[] r2 = this.chars;
            if (r1 >= r2.length) goto L10;
            r0[r1] = Ascii.toLowerCase(r2[r1]);
            r1 = r1 + 1;
            goto L6
        L10:
            return new Alphabet(this.name + ".lowerCase()", r0);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (CharMatcher.ASCII.matches(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.decodabet[r2] == (-1)) goto L7;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.name;
        }
    }

    public static final class DecodingException extends IOException {
        DecodingException(String r1) {
            super(r1);
        }

        DecodingException(Throwable r1) {
            super(r1);
        }
    }

    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;
        private final CharMatcher separatorChars;

        SeparatedBaseEncoding(BaseEncoding r3, String r4, int r5) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(r3);
            this.separator = (String) Preconditions.checkNotNull(r4);
            this.afterEveryChars = r5;
            if (r5 <= 0) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "Cannot add a separator after every %s chars", new Object[]{Integer.valueOf(r5)});
            this.separatorChars = CharMatcher.anyOf(r4).precomputed();
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding
        CharMatcher padding() {
            return this.delegate.padding();
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int r4) {
            int r5 = this.delegate.maxEncodedSize(r4);
            return r5 + (this.separator.length() * IntMath.divide(Math.max(0, r5 - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        GwtWorkarounds.ByteOutput encodingStream(GwtWorkarounds.CharOutput r3) {
            return this.delegate.encodingStream(separatingOutput(r3, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int r1) {
            return this.delegate.maxDecodedSize(r1);
        }

        @Override // com.google.common.io.BaseEncoding
        GwtWorkarounds.ByteInput decodingStream(GwtWorkarounds.CharInput r2) {
            return this.delegate.decodingStream(ignoringInput(r2, this.separatorChars));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char r2) {
            return this.delegate.withPadChar(r2).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String r1, int r2) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate.toString() + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }
    }

    static final class StandardBaseEncoding extends BaseEncoding {
        private final Alphabet alphabet;
        private transient BaseEncoding lowerCase;

        @Nullable
        private final Character paddingChar;
        private transient BaseEncoding upperCase;

        static /* synthetic */ Alphabet access$000(StandardBaseEncoding r0) {
            return r0.alphabet;
        }

        static /* synthetic */ Character access$100(StandardBaseEncoding r0) {
            return r0.paddingChar;
        }

        StandardBaseEncoding(String r2, String r3, @Nullable Character r4) {
            this(new Alphabet(r2, r3.toCharArray()), r4);
        }

        StandardBaseEncoding(Alphabet r4, @Nullable Character r5) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(r4);
            if (r5 != null) goto L5;
        L8:
            boolean r6 = true;
        L9:
            Preconditions.checkArgument(r6, "Padding character %s was already in alphabet", new Object[]{r5});
            this.paddingChar = r5;
            return;
        L5:
            if (r4.matches(r5.charValue()) == false) goto L8;
            r6 = false;
            goto L9
        }

        @Override // com.google.common.io.BaseEncoding
        CharMatcher padding() {
            Character r0 = this.paddingChar;
            if (r0 != null) goto L6;
            return CharMatcher.NONE;
        L6:
            return CharMatcher.is(r0.charValue());
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int r3) {
            return this.alphabet.charsPerChunk * IntMath.divide(r3, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        GwtWorkarounds.ByteOutput encodingStream(final GwtWorkarounds.CharOutput r2) {
            Preconditions.checkNotNull(r2);
            return new AnonymousClass1(this, r2);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int r3) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) r3)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        GwtWorkarounds.ByteInput decodingStream(final GwtWorkarounds.CharInput r2) {
            Preconditions.checkNotNull(r2);
            return new AnonymousClass2(this, r2);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            if (this.paddingChar != null) goto L6;
            return this;
        L6:
            return new StandardBaseEncoding(this.alphabet, null);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char r3) {
            if ((8 % this.alphabet.bitsPerChar) == 0) goto L11;
            Character r0 = this.paddingChar;
            if (r0 == null) goto L10;
            if (r0.charValue() == r3) goto L11;
        L10:
            return new StandardBaseEncoding(this.alphabet, Character.valueOf(r3));
        L11:
            return this;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String r3, int r4) {
            Preconditions.checkNotNull(r3);
            Preconditions.checkArgument(padding().or(this.alphabet).matchesNoneOf(r3), "Separator cannot contain alphabet or padding characters");
            return new SeparatedBaseEncoding(this, r3, r4);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding r0 = this.upperCase;
            if (r0 != null) goto L9;
            Alphabet r1 = this.alphabet.upperCase();
            if (r1 != this.alphabet) goto L7;
            r0 = this;
        L8:
            this.upperCase = r0;
            goto L9
        L7:
            r0 = new StandardBaseEncoding(r1, this.paddingChar);
        L9:
            return r0;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding r0 = this.lowerCase;
            if (r0 != null) goto L9;
            Alphabet r1 = this.alphabet.lowerCase();
            if (r1 != this.alphabet) goto L7;
            r0 = this;
        L8:
            this.lowerCase = r0;
            goto L9
        L7:
            r0 = new StandardBaseEncoding(r1, this.paddingChar);
        L9:
            return r0;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("BaseEncoding.");
            r0.append(this.alphabet.toString());
            if ((8 % this.alphabet.bitsPerChar) == 0) goto L9;
            if (this.paddingChar != null) goto L7;
            r0.append(".omitPadding()");
            goto L9
        L7:
            r0.append(".withPadChar(").append(this.paddingChar).append(')');
        L9:
            return r0.toString();
        }
    }

    abstract GwtWorkarounds.ByteInput decodingStream(GwtWorkarounds.CharInput r1);

    abstract GwtWorkarounds.ByteOutput encodingStream(GwtWorkarounds.CharOutput r1);

    @CheckReturnValue
    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int r1);

    abstract int maxEncodedSize(int r1);

    @CheckReturnValue
    public abstract BaseEncoding omitPadding();

    abstract CharMatcher padding();

    @CheckReturnValue
    public abstract BaseEncoding upperCase();

    @CheckReturnValue
    public abstract BaseEncoding withPadChar(char r1);

    @CheckReturnValue
    public abstract BaseEncoding withSeparator(String r1, int r2);

    BaseEncoding() {
    }

    public String encode(byte[] r3) {
        return encode((byte[]) Preconditions.checkNotNull(r3), 0, r3.length);
    }

    public final String encode(byte[] r4, int r5, int r6) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkPositionIndexes(r5, r5 + r6, r4.length);
        GwtWorkarounds.CharOutput r0 = GwtWorkarounds.stringBuilderOutput(maxEncodedSize(r6));
        GwtWorkarounds.ByteOutput r3 = encodingStream(r0);
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L6;
        r3.write(r4[r5 + r1]);     // Catch: IOException -> L9
        r1 = r1 + 1;     // Catch: IOException -> L9
    L10:
        throw new AssertionError("impossible");
    L6:
        r3.close();     // Catch: IOException -> L9
        return r0.toString();
    }

    public final OutputStream encodingStream(Writer r1) {
        return GwtWorkarounds.asOutputStream(encodingStream(GwtWorkarounds.asCharOutput(r1)));
    }

    public final ByteSink encodingSink(final CharSink r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(this, r2);
    }

    private static byte[] extract(byte[] r2, int r3) {
        if (r3 != r2.length) goto L5;
        return r2;
    L5:
        byte[] r0 = new byte[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    public final byte[] decode(CharSequence r1) {
        return decodeChecked(r1);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    final byte[] decodeChecked(CharSequence r4) throws DecodingException {
        String r5 = padding().trimTrailingFrom(r4);
        GwtWorkarounds.ByteInput r0 = decodingStream(GwtWorkarounds.asCharInput(r5));
        byte[] r3 = new byte[maxDecodedSize(r5.length())];
        int r6 = r0.read();     // Catch: IOException -> L10 DecodingException -> L13
        int r1 = 0;
    L5:
        if (r6 == (-1)) goto L9;
        int r2 = r1 + 1;     // Catch: IOException -> L10 DecodingException -> L13
        r3[r1] = (byte) r6;     // Catch: IOException -> L10 DecodingException -> L13
        r6 = r0.read();     // Catch: IOException -> L10 DecodingException -> L13
        r1 = r2;
        goto L5
    L9:
        return extract(r3, r1);
    L13:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final InputStream decodingStream(Reader r1) {
        return GwtWorkarounds.asInputStream(decodingStream(GwtWorkarounds.asCharInput(r1)));
    }

    public final ByteSource decodingSource(final CharSource r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(this, r2);
    }

    static {
        BASE64 = new StandardBaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        BASE64_URL = new StandardBaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        BASE16 = new StandardBaseEncoding("base16()", "0123456789ABCDEF", null);
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    static GwtWorkarounds.CharInput ignoringInput(final GwtWorkarounds.CharInput r1, final CharMatcher r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass3(r1, r2);
    }

    static GwtWorkarounds.CharOutput separatingOutput(final GwtWorkarounds.CharOutput r1, final String r2, final int r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass4(r3, r2, r1);
    L5:
        r0 = false;
        goto L6
    }
}
