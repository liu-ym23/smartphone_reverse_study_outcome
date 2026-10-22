package org.yaml.snakeyaml.external.com.google.gdata.util.common.base;

import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class UnicodeEscaper implements Escaper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEST_PAD = 32;
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() { // from class: org.yaml.snakeyaml.external.com.google.gdata.util.common.base.UnicodeEscaper.2
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    };

    public static final int codePointAt(CharSequence charSequence, int i10, int i11) {
        if (i10 >= i11) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i12 = i10 + 1;
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i10);
        }
        if (i12 == i11) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i12);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i12);
    }

    private static final char[] growBuffer(char[] cArr, int i10, int i11) {
        char[] cArr2 = new char[i11];
        if (i10 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i10);
        }
        return cArr2;
    }

    @Override // org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper
    public String escape(String str) {
        int length = str.length();
        int iNextEscapeIndex = nextEscapeIndex(str, 0, length);
        return iNextEscapeIndex == length ? str : escapeSlow(str, iNextEscapeIndex);
    }

    public abstract char[] escape(int i10);

    public final String escapeSlow(String str, int i10) {
        int length = str.length();
        char[] cArrGrowBuffer = DEST_TL.get();
        int i11 = 0;
        int length2 = 0;
        while (i10 < length) {
            int iCodePointAt = codePointAt(str, i10, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            if (cArrEscape != null) {
                int i12 = i10 - i11;
                int i13 = length2 + i12;
                int length3 = cArrEscape.length + i13;
                if (cArrGrowBuffer.length < length3) {
                    cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, length3 + (length - i10) + 32);
                }
                if (i12 > 0) {
                    str.getChars(i11, i10, cArrGrowBuffer, length2);
                    length2 = i13;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrGrowBuffer, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
            }
            i11 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i10;
            i10 = nextEscapeIndex(str, i11, length);
        }
        int i14 = length - i11;
        if (i14 > 0) {
            int i15 = i14 + length2;
            if (cArrGrowBuffer.length < i15) {
                cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, i15);
            }
            str.getChars(i11, length, cArrGrowBuffer, length2);
            length2 = i15;
        }
        return new String(cArrGrowBuffer, 0, length2);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            int iCodePointAt = codePointAt(charSequence, i10, i11);
            if (iCodePointAt < 0 || escape(iCodePointAt) != null) {
                break;
            }
            i10 += Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1;
        }
        return i10;
    }

    @Override // org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper
    public Appendable escape(final Appendable appendable) {
        return new Appendable() { // from class: org.yaml.snakeyaml.external.com.google.gdata.util.common.base.UnicodeEscaper.1
            int pendingHighSurrogate = -1;
            final char[] decodedChars = new char[2];

            private void outputChars(char[] cArr, int i10) throws IOException {
                for (int i11 = 0; i11 < i10; i11++) {
                    appendable.append(cArr[i11]);
                }
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) throws IOException {
                return append(charSequence, 0, charSequence.length());
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
                int i12;
                if (i10 < i11) {
                    if (this.pendingHighSurrogate != -1) {
                        int i13 = i10 + 1;
                        char cCharAt = charSequence.charAt(i10);
                        if (!Character.isLowSurrogate(cCharAt)) {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + cCharAt);
                        }
                        char[] cArrEscape = UnicodeEscaper.this.escape(Character.toCodePoint((char) this.pendingHighSurrogate, cCharAt));
                        if (cArrEscape != null) {
                            outputChars(cArrEscape, cArrEscape.length);
                            i10 = i13;
                        } else {
                            appendable.append((char) this.pendingHighSurrogate);
                        }
                        this.pendingHighSurrogate = -1;
                        i12 = i10;
                        i10 = i13;
                    } else {
                        i12 = i10;
                    }
                    while (true) {
                        int iNextEscapeIndex = UnicodeEscaper.this.nextEscapeIndex(charSequence, i10, i11);
                        if (iNextEscapeIndex > i12) {
                            appendable.append(charSequence, i12, iNextEscapeIndex);
                        }
                        if (iNextEscapeIndex == i11) {
                            break;
                        }
                        int iCodePointAt = UnicodeEscaper.codePointAt(charSequence, iNextEscapeIndex, i11);
                        if (iCodePointAt < 0) {
                            this.pendingHighSurrogate = -iCodePointAt;
                            return this;
                        }
                        char[] cArrEscape2 = UnicodeEscaper.this.escape(iCodePointAt);
                        if (cArrEscape2 != null) {
                            outputChars(cArrEscape2, cArrEscape2.length);
                        } else {
                            outputChars(this.decodedChars, Character.toChars(iCodePointAt, this.decodedChars, 0));
                        }
                        i12 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + iNextEscapeIndex;
                        i10 = i12;
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c10) throws IOException {
                if (this.pendingHighSurrogate != -1) {
                    if (Character.isLowSurrogate(c10)) {
                        char[] cArrEscape = UnicodeEscaper.this.escape(Character.toCodePoint((char) this.pendingHighSurrogate, c10));
                        if (cArrEscape != null) {
                            outputChars(cArrEscape, cArrEscape.length);
                        } else {
                            appendable.append((char) this.pendingHighSurrogate);
                            appendable.append(c10);
                        }
                        this.pendingHighSurrogate = -1;
                        return this;
                    }
                    throw new IllegalArgumentException("Expected low surrogate character but got '" + c10 + "' with value " + ((int) c10));
                }
                if (Character.isHighSurrogate(c10)) {
                    this.pendingHighSurrogate = c10;
                    return this;
                }
                if (!Character.isLowSurrogate(c10)) {
                    char[] cArrEscape2 = UnicodeEscaper.this.escape(c10);
                    if (cArrEscape2 != null) {
                        outputChars(cArrEscape2, cArrEscape2.length);
                        return this;
                    }
                    appendable.append(c10);
                    return this;
                }
                throw new IllegalArgumentException("Unexpected low surrogate character '" + c10 + "' with value " + ((int) c10));
            }
        };
    }
}
