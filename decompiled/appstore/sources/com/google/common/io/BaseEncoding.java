package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16 = null;
    private static final BaseEncoding BASE32 = null;
    private static final BaseEncoding BASE32_HEX = null;
    private static final BaseEncoding BASE64 = null;
    private static final BaseEncoding BASE64_URL = null;

    public static final class Alphabet {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        public Alphabet(String r10, char[] r11) {
            this.name = (String) Preconditions.checkNotNull(r10);
            this.chars = (char[]) Preconditions.checkNotNull(r11);
            int r12 = IntMath.log2(r11.length, RoundingMode.UNNECESSARY);     // Catch: ArithmeticException -> L27
            this.bitsPerChar = r12;     // Catch: ArithmeticException -> L27
            int r13 = Math.min(8, Integer.lowestOneBit(r12));
            this.charsPerChunk = 8 / r13;     // Catch: ArithmeticException -> L24
            this.bytesPerChunk = r12 / r13;     // Catch: ArithmeticException -> L24
            this.mask = r11.length - 1;
            byte[] r14 = new byte[128];
            Arrays.fill(r14, (byte) -1);
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r16 >= r11.length) goto L18;
            char r17 = r11[r16];
            if (r17 >= 128) goto L12;
            boolean r18 = true;
        L13:
            Preconditions.checkArgument(r18, "Non-ASCII character: %s", r17);
            if (r14[r17] != (-1)) goto L16;
            boolean r19 = true;
        L17:
            Preconditions.checkArgument(r19, "Duplicate character: %s", r17);
            r14[r17] = (byte) r16;
            r16 = r16 + 1;
            goto L8
        L16:
            r19 = false;
            goto L17
        L12:
            r18 = false;
            goto L13
        L18:
            this.decodabet = r14;
            boolean[] r20 = new boolean[this.charsPerChunk];
        L20:
            if (r15 >= this.bytesPerChunk) goto L22;
            r20[IntMath.divide(r15 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
            r15 = r15 + 1;
            goto L20
        L22:
            this.validPadding = r20;
            return;
        L24:
            e = move-exception;
            throw new IllegalArgumentException("Illegal alphabet " + new String(r11), e);
        L27:
            e = move-exception;
            throw new IllegalArgumentException("Illegal alphabet length " + r11.length, e);
        }

        public static /* synthetic */ char[] access$000(Alphabet r10) {
            return r10.chars;
        }

        private boolean hasLowerCase() {
            char[] r10 = this.chars;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            if (Ascii.isLowerCase(r10[r12]) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private boolean hasUpperCase() {
            char[] r10 = this.chars;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            if (Ascii.isUpperCase(r10[r12]) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public boolean canDecode(char r10) {
            if (r10 <= 127) goto L5;
        L7:
            return false;
        L5:
            if (this.decodabet[r10] == (-1)) goto L7;
            return true;
        }

        public int decode(char r10) throws DecodingException {
            if (r10 > 127) goto L16;
            byte r11 = this.decodabet[r10];
            if (r11 == (-1)) goto L7;
            return r11;
        L7:
            if (r10 <= ' ') goto L13;
            if (r10 == 127) goto L13;
            throw new DecodingException("Unrecognized character: " + r10);
        L13:
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(r10));
        L16:
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(r10));
        }

        public char encode(int r10) {
            return this.chars[r10];
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof Alphabet) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(this.chars, ((Alphabet) r10).chars);
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        public boolean isValidPaddingStartPosition(int r10) {
            return this.validPadding[r10 % this.charsPerChunk];
        }

        public Alphabet lowerCase() {
            if (hasUpperCase() == true) goto L5;
            return this;
        L5:
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] r10 = new char[this.chars.length];
            int r11 = 0;
        L6:
            char[] r12 = this.chars;
            if (r11 >= r12.length) goto L10;
            r10[r11] = Ascii.toLowerCase(r12[r11]);
            r11 = r11 + 1;
            goto L6
        L10:
            return new Alphabet(this.name + ".lowerCase()", r10);
        }

        public boolean matches(char r10) {
            byte[] r11 = this.decodabet;
            if (r10 < r11.length) goto L5;
        L7:
            return false;
        L5:
            if (r11[r10] == (-1)) goto L7;
            return true;
        }

        public String toString() {
            return this.name;
        }

        public Alphabet upperCase() {
            if (hasLowerCase() == true) goto L5;
            return this;
        L5:
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] r10 = new char[this.chars.length];
            int r11 = 0;
        L6:
            char[] r12 = this.chars;
            if (r11 >= r12.length) goto L10;
            r10[r11] = Ascii.toUpperCase(r12[r11]);
            r11 = r11 + 1;
            goto L6
        L10:
            return new Alphabet(this.name + ".upperCase()", r10);
        }
    }

    public static final class Base16Encoding extends StandardBaseEncoding {
        final char[] encoding;

        public Base16Encoding(String r10, String r11) {
            this(new Alphabet(r10, r11.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public int decodeTo(byte[] r10, CharSequence r11) throws DecodingException {
            Preconditions.checkNotNull(r10);
            if ((r11.length() % 2) == 1) goto L10;
            int r12 = 0;
            int r13 = 0;
        L6:
            if (r12 >= r11.length()) goto L8;
            r10[r13] = (byte) ((this.alphabet.decode(r11.charAt(r12)) << 4) | this.alphabet.decode(r11.charAt(r12 + 1)));
            r12 = r12 + 2;
            r13 = r13 + 1;
            goto L6
        L8:
            return r13;
        L10:
            throw new DecodingException("Invalid input length " + r11.length());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public void encodeTo(Appendable r10, byte[] r11, int r12, int r13) throws IOException {
            Preconditions.checkNotNull(r10);
            Preconditions.checkPositionIndexes(r12, r12 + r13, r11.length);
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            int r15 = r11[r12 + r14] & UnsignedBytes.MAX_VALUE;
            r10.append(this.encoding[r15]);
            r10.append(this.encoding[r15 | 256]);
            r14 = r14 + 1;
            goto L3
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public BaseEncoding newInstance(Alphabet r10, @NullableDecl Character r11) {
            return new Base16Encoding(r10);
        }

        private Base16Encoding(Alphabet r10) {
            super(r10, null);
            this.encoding = new char[512];
            int r11 = 0;
            if (Alphabet.access$000(r10).length != 16) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12);
        L8:
            if (r11 >= 256) goto L10;
            this.encoding[r11] = r10.encode(r11 >>> 4);
            this.encoding[r11 | 256] = r10.encode(r11 & 15);
            r11 = r11 + 1;
            goto L8
        L10:
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    public static final class Base64Encoding extends StandardBaseEncoding {
        public Base64Encoding(String r10, String r11, @NullableDecl Character r12) {
            this(new Alphabet(r10, r11.toCharArray()), r12);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public int decodeTo(byte[] r10, CharSequence r11) throws DecodingException {
            Preconditions.checkNotNull(r10);
            CharSequence r12 = trimTrailingPadding(r11);
            if (this.alphabet.isValidPaddingStartPosition(r12.length()) == false) goto L16;
            int r13 = 0;
            int r14 = 0;
        L6:
            if (r13 >= r12.length()) goto L14;
            int r15 = r13 + 2;
            int r16 = (this.alphabet.decode(r12.charAt(r13)) << 18) | (this.alphabet.decode(r12.charAt(r13 + 1)) << 12);
            int r17 = r14 + 1;
            r10[r14] = (byte) (r16 >>> 16);
            if (r15 < r12.length()) goto L9;
            r14 = r17;
            r13 = r15;
            goto L6
        L9:
            int r18 = r13 + 3;
            int r19 = r16 | (this.alphabet.decode(r12.charAt(r15)) << 6);
            int r20 = r14 + 2;
            r10[r17] = (byte) ((r19 >>> 8) & PrivateKeyType.INVALID);
            if (r18 < r12.length()) goto L11;
            r14 = r20;
            r13 = r18;
            goto L6
        L11:
            r13 = r13 + 4;
            r14 = r14 + 3;
            r10[r20] = (byte) ((r19 | this.alphabet.decode(r12.charAt(r18))) & PrivateKeyType.INVALID);
            goto L6
        L14:
            return r14;
        L16:
            throw new DecodingException("Invalid input length " + r12.length());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public void encodeTo(Appendable r10, byte[] r11, int r12, int r13) throws IOException {
            Preconditions.checkNotNull(r10);
            int r14 = r12 + r13;
            Preconditions.checkPositionIndexes(r12, r14, r11.length);
        L4:
            if (r13 < 3) goto L6;
            int r15 = r12 + 2;
            int r16 = ((r11[r12 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((r11[r12] & UnsignedBytes.MAX_VALUE) << 16);
            r12 = r12 + 3;
            int r17 = r16 | (r11[r15] & UnsignedBytes.MAX_VALUE);
            r10.append(this.alphabet.encode(r17 >>> 18));
            r10.append(this.alphabet.encode((r17 >>> 12) & 63));
            r10.append(this.alphabet.encode((r17 >>> 6) & 63));
            r10.append(this.alphabet.encode(r17 & 63));
            r13 = r13 - 3;
            goto L4
        L6:
            if (r12 >= r14) goto L10;
            encodeChunkTo(r10, r11, r12, r14 - r12);
            return;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public BaseEncoding newInstance(Alphabet r10, @NullableDecl Character r11) {
            return new Base64Encoding(r10, r11);
        }

        private Base64Encoding(Alphabet r10, @NullableDecl Character r11) {
            super(r10, r11);
            if (Alphabet.access$000(r10).length != 64) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12);
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    public static final class DecodingException extends IOException {
        public DecodingException(String r10) {
            super(r10);
        }

        public DecodingException(Throwable r10) {
            super(r10);
        }
    }

    public static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        public SeparatedBaseEncoding(BaseEncoding r10, String r11, int r12) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(r10);
            this.separator = (String) Preconditions.checkNotNull(r11);
            this.afterEveryChars = r12;
            if (r12 <= 0) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "Cannot add a separator after every %s chars", r12);
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence r10) {
            StringBuilder r11 = new StringBuilder();
            int r12 = 0;
        L4:
            if (r12 >= r10.length()) goto L10;
            char r13 = r10.charAt(r12);
            if (this.separator.indexOf(r13) >= 0) goto L8;
            r11.append(r13);
        L8:
            r12 = r12 + 1;
            goto L4
        L10:
            return this.delegate.canDecode(r11);
        }

        @Override // com.google.common.io.BaseEncoding
        public int decodeTo(byte[] r10, CharSequence r11) throws DecodingException {
            StringBuilder r12 = new StringBuilder(r11.length());
            int r13 = 0;
        L4:
            if (r13 >= r11.length()) goto L10;
            char r14 = r11.charAt(r13);
            if (this.separator.indexOf(r14) >= 0) goto L8;
            r12.append(r14);
        L8:
            r13 = r13 + 1;
            goto L4
        L10:
            return this.delegate.decodeTo(r10, r12);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(Reader r10) {
            return this.delegate.decodingStream(BaseEncoding.ignoringReader(r10, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable r10, byte[] r11, int r12, int r13) throws IOException {
            this.delegate.encodeTo(BaseEncoding.separatingAppendable(r10, this.separator, this.afterEveryChars), r11, r12, r13);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(Writer r10) {
            return this.delegate.encodingStream(BaseEncoding.separatingWriter(r10, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxDecodedSize(int r10) {
            return this.delegate.maxDecodedSize(r10);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxEncodedSize(int r10) {
            int r11 = this.delegate.maxEncodedSize(r10);
            return r11 + (this.separator.length() * IntMath.divide(Math.max(0, r11 - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence trimTrailingPadding(CharSequence r10) {
            return this.delegate.trimTrailingPadding(r10);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char r10) {
            return this.delegate.withPadChar(r10).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String r10, int r11) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    public static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet alphabet;

        @MonotonicNonNullDecl
        private transient BaseEncoding lowerCase;

        @NullableDecl
        final Character paddingChar;

        @MonotonicNonNullDecl
        private transient BaseEncoding upperCase;

        public StandardBaseEncoding(String r10, String r11, @NullableDecl Character r12) {
            this(new Alphabet(r10, r11.toCharArray()), r12);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            CharSequence r11 = trimTrailingPadding(r10);
            if (this.alphabet.isValidPaddingStartPosition(r11.length()) == true) goto L5;
            return false;
        L5:
            int r12 = 0;
        L7:
            if (r12 >= r11.length()) goto L12;
            if (this.alphabet.canDecode(r11.charAt(r12)) == false) goto L10;
            r12 = r12 + 1;
            goto L7
        L10:
            return false;
        L12:
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        public int decodeTo(byte[] r14, CharSequence r15) throws DecodingException {
            Preconditions.checkNotNull(r14);
            CharSequence r16 = trimTrailingPadding(r15);
            if (this.alphabet.isValidPaddingStartPosition(r16.length()) == false) goto L20;
            int r10 = 0;
            int r11 = 0;
        L6:
            if (r10 >= r16.length()) goto L18;
            long r12 = 0;
            int r13 = 0;
            int r17 = 0;
        L8:
            Alphabet r18 = this.alphabet;
            if (r13 >= r18.charsPerChunk) goto L14;
            r12 = r12 << r18.bitsPerChar;
            if ((r10 + r13) >= r16.length()) goto L13;
            r12 = r12 | ((long) this.alphabet.decode(r16.charAt(r17 + r10)));
            r17 = r17 + 1;
        L13:
            r13 = r13 + 1;
            goto L8
        L14:
            int r19 = r18.bytesPerChunk;
            int r20 = (r19 * 8) - (r17 * r18.bitsPerChar);
            int r21 = (r19 - 1) * 8;
        L15:
            if (r21 < r20) goto L17;
            r14[r11] = (byte) ((r12 >>> r21) & 255);
            r21 = r21 - 8;
            r11 = r11 + 1;
            goto L15
        L17:
            r10 = r10 + this.alphabet.charsPerChunk;
            goto L6
        L18:
            return r11;
        L20:
            throw new DecodingException("Invalid input length " + r16.length());
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(final Reader r10) {
            Preconditions.checkNotNull(r10);
            return new AnonymousClass2(this, r10);
        }

        public void encodeChunkTo(Appendable r10, byte[] r11, int r12, int r13) throws IOException {
            Preconditions.checkNotNull(r10);
            Preconditions.checkPositionIndexes(r12, r12 + r13, r11.length);
            int r14 = 0;
            if (r13 > this.alphabet.bytesPerChunk) goto L5;
            boolean r15 = true;
        L6:
            Preconditions.checkArgument(r15);
            long r16 = 0;
            int r17 = 0;
        L8:
            if (r17 >= r13) goto L10;
            r16 = (r16 | ((long) (r11[r12 + r17] & UnsignedBytes.MAX_VALUE))) << 8;
            r17 = r17 + 1;
            goto L8
        L10:
            int r18 = ((r13 + 1) * 8) - this.alphabet.bitsPerChar;
        L12:
            if (r14 >= (r13 * 8)) goto L15;
            Alphabet r19 = this.alphabet;
            r10.append(r19.encode(((int) (r16 >>> (r18 - r14))) & r19.mask));
            r14 = r14 + this.alphabet.bitsPerChar;
            goto L12
        L15:
            if (this.paddingChar != null) goto L17;
            return;
        L17:
            if (r14 >= (this.alphabet.bytesPerChunk * 8)) goto L23;
            r10.append(this.paddingChar.charValue());
            r14 = r14 + this.alphabet.bitsPerChar;
            goto L17
        L23:
            return;
        L5:
            r15 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable r10, byte[] r11, int r12, int r13) throws IOException {
            Preconditions.checkNotNull(r10);
            Preconditions.checkPositionIndexes(r12, r12 + r13, r11.length);
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            encodeChunkTo(r10, r11, r12 + r14, Math.min(this.alphabet.bytesPerChunk, r13 - r14));
            r14 = r14 + this.alphabet.bytesPerChunk;
            goto L3
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(final Writer r10) {
            Preconditions.checkNotNull(r10);
            return new AnonymousClass1(this, r10);
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof StandardBaseEncoding) == false) goto L10;
            StandardBaseEncoding r11 = (StandardBaseEncoding) r10;
            if (this.alphabet.equals(r11.alphabet) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.paddingChar, r11.paddingChar) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r10 = this.alphabet.hashCode();
            return Objects.hashCode(new Object[]{this.paddingChar}) ^ r10;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding r10 = this.lowerCase;
            if (r10 != null) goto L9;
            Alphabet r11 = this.alphabet.lowerCase();
            if (r11 != this.alphabet) goto L7;
            r10 = this;
        L8:
            this.lowerCase = r10;
            goto L9
        L7:
            r10 = newInstance(r11, this.paddingChar);
        L9:
            return r10;
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxDecodedSize(int r10) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) r10)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxEncodedSize(int r10) {
            Alphabet r11 = this.alphabet;
            return r11.charsPerChunk * IntMath.divide(r10, r11.bytesPerChunk, RoundingMode.CEILING);
        }

        public BaseEncoding newInstance(Alphabet r10, @NullableDecl Character r11) {
            return new StandardBaseEncoding(r10, r11);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            if (this.paddingChar != null) goto L6;
            return this;
        L6:
            return newInstance(this.alphabet, null);
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder("BaseEncoding.");
            r10.append(this.alphabet.toString());
            if ((8 % this.alphabet.bitsPerChar) == 0) goto L9;
            if (this.paddingChar != null) goto L7;
            r10.append(".omitPadding()");
            goto L9
        L7:
            r10.append(".withPadChar('");
            r10.append(this.paddingChar);
            r10.append("')");
        L9:
            return r10.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence trimTrailingPadding(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            Character r11 = this.paddingChar;
            if (r11 != null) goto L5;
            return r10;
        L5:
            char r12 = r11.charValue();
            int r13 = r10.length() - 1;
        L6:
            if (r13 < 0) goto L12;
            if (r10.charAt(r13) != r12) goto L12;
            r13 = r13 - 1;
        L12:
            return r10.subSequence(0, r13 + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding r10 = this.upperCase;
            if (r10 != null) goto L9;
            Alphabet r11 = this.alphabet.upperCase();
            if (r11 != this.alphabet) goto L7;
            r10 = this;
        L8:
            this.upperCase = r10;
            goto L9
        L7:
            r10 = newInstance(r11, this.paddingChar);
        L9:
            return r10;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char r10) {
            if ((8 % this.alphabet.bitsPerChar) == 0) goto L11;
            Character r11 = this.paddingChar;
            if (r11 == null) goto L10;
            if (r11.charValue() != r10) goto L10;
            return this;
        L10:
            return newInstance(this.alphabet, Character.valueOf(r10));
        L11:
            return this;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String r10, int r11) {
            boolean r12 = false;
            int r13 = 0;
        L4:
            if (r13 >= r10.length()) goto L6;
            Preconditions.checkArgument(!this.alphabet.matches(r10.charAt(r13)), "Separator (%s) cannot contain alphabet characters", r10);
            r13 = r13 + 1;
            goto L4
        L6:
            Character r14 = this.paddingChar;
            if (r14 == null) goto L13;
            if (r10.indexOf(r14.charValue()) >= 0) goto L11;
            r12 = true;
        L11:
            Preconditions.checkArgument(r12, "Separator (%s) cannot contain padding character", r10);
        L13:
            return new SeparatedBaseEncoding(this, r10, r11);
        }

        public StandardBaseEncoding(Alphabet r10, @NullableDecl Character r11) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(r10);
            if (r11 != null) goto L5;
        L8:
            boolean r12 = true;
        L9:
            Preconditions.checkArgument(r12, "Padding character %s was already in alphabet", r11);
            this.paddingChar = r11;
            return;
        L5:
            if (r10.matches(r11.charValue()) == false) goto L8;
            r12 = false;
            goto L9
        }
    }

    static {
        BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
    }

    public BaseEncoding() {
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    private static byte[] extract(byte[] r10, int r11) {
        if (r11 != r10.length) goto L5;
        return r10;
    L5:
        byte[] r12 = new byte[r11];
        System.arraycopy(r10, 0, r12, 0, r11);
        return r12;
    }

    @GwtIncompatible
    public static Reader ignoringReader(final Reader r10, final String r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass3(r10, r11);
    }

    public static Appendable separatingAppendable(final Appendable r10, final String r11, final int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (r12 <= 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13);
        return new AnonymousClass4(r12, r10, r11);
    L5:
        r13 = false;
        goto L6
    }

    @GwtIncompatible
    public static Writer separatingWriter(final Writer r10, String r11, int r12) {
        final Appendable r13 = separatingAppendable(r10, r11, r12);
        return new AnonymousClass5(r13, r10);
    }

    public abstract boolean canDecode(CharSequence r10);

    public final byte[] decode(CharSequence r10) {
        return decodeChecked(r10);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public final byte[] decodeChecked(CharSequence r10) throws DecodingException {
        CharSequence r11 = trimTrailingPadding(r10);
        byte[] r12 = new byte[maxDecodedSize(r11.length())];
        return extract(r12, decodeTo(r12, r11));
    }

    public abstract int decodeTo(byte[] r10, CharSequence r11) throws DecodingException;

    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass2(this, r10);
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader r10);

    public String encode(byte[] r10) {
        return encode(r10, 0, r10.length);
    }

    public abstract void encodeTo(Appendable r10, byte[] r11, int r12, int r13) throws IOException;

    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass1(this, r10);
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer r10);

    public abstract BaseEncoding lowerCase();

    public abstract int maxDecodedSize(int r10);

    public abstract int maxEncodedSize(int r10);

    public abstract BaseEncoding omitPadding();

    public CharSequence trimTrailingPadding(CharSequence r10) {
        return (CharSequence) Preconditions.checkNotNull(r10);
    }

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char r10);

    public abstract BaseEncoding withSeparator(String r10, int r11);

    public final String encode(byte[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        StringBuilder r13 = new StringBuilder(maxEncodedSize(r12));
        encodeTo(r13, r10, r11, r12);     // Catch: IOException -> L6
        return r13.toString();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }
}
