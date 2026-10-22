package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;
import javax.annotation.CheckReturnValue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CharMatcher implements Predicate<Character> {
    public static final CharMatcher ANY = null;
    public static final CharMatcher ASCII = null;
    public static final CharMatcher BREAKING_WHITESPACE = null;
    public static final CharMatcher DIGIT = null;
    private static final int DISTINCT_CHARS = 65536;
    public static final CharMatcher INVISIBLE = null;
    public static final CharMatcher JAVA_DIGIT = null;
    public static final CharMatcher JAVA_ISO_CONTROL = null;
    public static final CharMatcher JAVA_LETTER = null;
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = null;
    public static final CharMatcher JAVA_LOWER_CASE = null;
    public static final CharMatcher JAVA_UPPER_CASE = null;
    private static final String NINES = null;
    public static final CharMatcher NONE = null;
    public static final CharMatcher SINGLE_WIDTH = null;
    public static final CharMatcher WHITESPACE = null;
    static final int WHITESPACE_MULTIPLIER = 1682554634;
    static final int WHITESPACE_SHIFT = 0;
    static final String WHITESPACE_TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";
    private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";
    final String description;

    private static class And extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        And(CharMatcher r3, CharMatcher r4) {
            this(r3, r4, "CharMatcher.and(" + r3 + ", " + r4 + ")");
        }

        And(CharMatcher r1, CharMatcher r2, String r3) {
            super(r3);
            this.first = (CharMatcher) Preconditions.checkNotNull(r1);
            this.second = (CharMatcher) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (this.first.matches(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.second.matches(r2) == false) goto L7;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r3) {
            BitSet r0 = new BitSet();
            this.first.setBits(r0);
            BitSet r1 = new BitSet();
            this.second.setBits(r1);
            r0.and(r1);
            r3.or(r0);
        }

        @Override // com.google.common.base.CharMatcher
        CharMatcher withToString(String r3) {
            return new And(this.first, this.second, r3);
        }
    }

    private static class BitSetMatcher extends FastMatcher {
        private final BitSet table;

        /* synthetic */ BitSetMatcher(BitSet r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private BitSetMatcher(BitSet r2, String r3) {
            super(r3);
            if ((r2.length() + 64) >= r2.size()) goto L5;
            r2 = (BitSet) r2.clone();
        L5:
            this.table = r2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return this.table.get(r1);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r1) {
            r1.or(this.table);
        }
    }

    static abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }

        FastMatcher() {
        }

        FastMatcher(String r1) {
            super(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    static final class NegatedFastMatcher extends NegatedMatcher {
        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }

        NegatedFastMatcher(CharMatcher r1) {
            super(r1);
        }

        NegatedFastMatcher(String r1, CharMatcher r2) {
            super(r1, r2);
        }

        @Override // com.google.common.base.CharMatcher.NegatedMatcher, com.google.common.base.CharMatcher
        CharMatcher withToString(String r2) {
            return new NegatedFastMatcher(r2, this.original);
        }
    }

    private static class NegatedMatcher extends CharMatcher {
        final CharMatcher original;

        NegatedMatcher(String r1, CharMatcher r2) {
            super(r1);
            this.original = r2;
        }

        NegatedMatcher(CharMatcher r3) {
            this(r3 + ".negate()", r3);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return !this.original.matches(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r1) {
            return this.original.matchesNoneOf(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r1) {
            return this.original.matchesAllOf(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r2) {
            return r2.length() - this.original.countIn(r2);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r3) {
            BitSet r0 = new BitSet();
            this.original.setBits(r0);
            r0.flip(0, 65536);
            r3.or(r0);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return this.original;
        }

        @Override // com.google.common.base.CharMatcher
        CharMatcher withToString(String r2) {
            return new NegatedMatcher(r2, this.original);
        }
    }

    private static class Or extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        Or(CharMatcher r1, CharMatcher r2, String r3) {
            super(r3);
            this.first = (CharMatcher) Preconditions.checkNotNull(r1);
            this.second = (CharMatcher) Preconditions.checkNotNull(r2);
        }

        Or(CharMatcher r3, CharMatcher r4) {
            this(r3, r4, "CharMatcher.or(" + r3 + ", " + r4 + ")");
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r2) {
            this.first.setBits(r2);
            this.second.setBits(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (this.first.matches(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.second.matches(r2) == true) goto L8;
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        CharMatcher withToString(String r3) {
            return new Or(this.first, this.second, r3);
        }
    }

    private static class RangesMatcher extends CharMatcher {
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        RangesMatcher(String r4, char[] r5, char[] r6) {
            super(r4);
            this.rangeStarts = r5;
            this.rangeEnds = r6;
            if (r5.length != r6.length) goto L5;
            boolean r3 = true;
        L6:
            Preconditions.checkArgument(r3);
            int r7 = 0;
        L8:
            if (r7 >= r5.length) goto L21;
            if (r5[r7] > r6[r7]) goto L12;
            boolean r8 = true;
        L13:
            Preconditions.checkArgument(r8);
            int r9 = r7 + 1;
            if (r9 >= r5.length) goto L20;
            if (r6[r7] >= r5[r9]) goto L18;
            boolean r10 = true;
        L19:
            Preconditions.checkArgument(r10);
            goto L20
        L18:
            r10 = false;
        L20:
            r7 = r9;
            goto L8
        L12:
            r8 = false;
            goto L13
        L21:
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r3) {
            int r0 = Arrays.binarySearch(this.rangeStarts, r3);
            if (r0 < 0) goto L5;
            return true;
        L5:
            int r1 = (~r0) - 1;
            if (r1 >= 0) goto L8;
        L10:
            return false;
        L8:
            if (r3 > this.rangeEnds[r1]) goto L10;
            return true;
        }
    }

    private static boolean isSmall(int r1, int r2) {
        if (r1 <= 1023) goto L5;
    L7:
        return false;
    L5:
        if (r2 <= ((r1 * 4) * 16)) goto L7;
        return true;
    }

    public abstract boolean matches(char r1);

    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Character r1) {
        return apply2(r1);
    }

    static {
        BREAKING_WHITESPACE = new AnonymousClass1();
        ASCII = inRange(0, Ascii.MAX, "CharMatcher.ASCII");
        StringBuilder r0 = new StringBuilder(31);
        int r4 = 0;
    L4:
        if (r4 >= 31) goto L6;
        r0.append((char) (ZEROES.charAt(r4) + '\t'));
        r4 = r4 + 1;
        goto L4
    L6:
        String r1 = r0.toString();
        NINES = r1;
        DIGIT = new RangesMatcher("CharMatcher.DIGIT", ZEROES.toCharArray(), r1.toCharArray());
        final String r5 = "CharMatcher.JAVA_DIGIT";
        JAVA_DIGIT = new AnonymousClass2(r5);
        final String r6 = "CharMatcher.JAVA_LETTER";
        JAVA_LETTER = new AnonymousClass3(r6);
        final String r7 = "CharMatcher.JAVA_LETTER_OR_DIGIT";
        JAVA_LETTER_OR_DIGIT = new AnonymousClass4(r7);
        final String r8 = "CharMatcher.JAVA_UPPER_CASE";
        JAVA_UPPER_CASE = new AnonymousClass5(r8);
        final String r9 = "CharMatcher.JAVA_LOWER_CASE";
        JAVA_LOWER_CASE = new AnonymousClass6(r9);
        JAVA_ISO_CONTROL = inRange(0, 31).or(inRange(Ascii.MAX, 159)).withToString("CharMatcher.JAVA_ISO_CONTROL");
        INVISIBLE = new RangesMatcher("CharMatcher.INVISIBLE", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        SINGLE_WIDTH = new RangesMatcher("CharMatcher.SINGLE_WIDTH", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        final String r2 = "CharMatcher.ANY";
        ANY = new AnonymousClass7(r2);
        final String r3 = "CharMatcher.NONE";
        NONE = new AnonymousClass8(r3);
        WHITESPACE_SHIFT = Integer.numberOfLeadingZeros(31);
        final String r10 = "WHITESPACE";
        WHITESPACE = new AnonymousClass15(r10);
    }

    private static String showCharacter(char r6) {
        char[] r0 = {'\\', 'u', 0, 0, 0, 0};
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L7;
        r0[5 - r1] = "0123456789ABCDEF".charAt(r6 & 15);
        r6 = (char) (r6 >> 4);
        r1 = r1 + 1;
        goto L4
    L7:
        return String.copyValueOf(r0);
    }

    public static CharMatcher is(final char r2) {
        final String r0 = "CharMatcher.is('" + showCharacter(r2) + "')";
        return new AnonymousClass9(r0, r2);
    }

    public static CharMatcher isNot(final char r2) {
        final String r0 = "CharMatcher.isNot('" + showCharacter(r2) + "')";
        return new AnonymousClass10(r0, r2);
    }

    public static CharMatcher anyOf(CharSequence r4) {
        int r0 = r4.length();
        if (r0 == 0) goto L18;
        int r1 = 0;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L14;
        final char[] r5 = r4.toString().toCharArray();
        Arrays.sort(r5);
        StringBuilder r2 = new StringBuilder("CharMatcher.anyOf(\"");
        int r3 = r5.length;
    L9:
        if (r1 >= r3) goto L11;
        r2.append(showCharacter(r5[r1]));
        r1 = r1 + 1;
        goto L9
    L11:
        r2.append("\")");
        final String r6 = r2.toString();
        return new AnonymousClass11(r6, r5);
    L14:
        return isEither(r4.charAt(0), r4.charAt(1));
    L16:
        return is(r4.charAt(0));
    L18:
        return NONE;
    }

    private static CharMatcher isEither(final char r2, final char r3) {
        final String r0 = "CharMatcher.anyOf(\"" + showCharacter(r2) + showCharacter(r3) + "\")";
        return new AnonymousClass12(r0, r2, r3);
    }

    public static CharMatcher noneOf(CharSequence r0) {
        return anyOf(r0).negate();
    }

    public static CharMatcher inRange(char r2, char r3) {
        if (r3 < r2) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0);
        return inRange(r2, r3, "CharMatcher.inRange('" + showCharacter(r2) + "', '" + showCharacter(r3) + "')");
    L4:
        r0 = false;
        goto L5
    }

    static CharMatcher inRange(final char r1, final char r2, final String r3) {
        return new AnonymousClass13(r3, r1, r2);
    }

    public static CharMatcher forPredicate(final Predicate<? super Character> r2) {
        Preconditions.checkNotNull(r2);
        if ((r2 instanceof CharMatcher) == true) goto L5;
        final String r0 = "CharMatcher.forPredicate(" + r2 + ")";
        return new AnonymousClass14(r0, r2);
    L5:
        return (CharMatcher) r2;
    }

    CharMatcher(String r1) {
        this.description = r1;
    }

    protected CharMatcher() {
        this.description = super.toString();
    }

    public CharMatcher negate() {
        return new NegatedMatcher(this);
    }

    public CharMatcher and(CharMatcher r2) {
        return new And(this, (CharMatcher) Preconditions.checkNotNull(r2));
    }

    public CharMatcher or(CharMatcher r2) {
        return new Or(this, (CharMatcher) Preconditions.checkNotNull(r2));
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    CharMatcher withToString(String r1) {
        throw new UnsupportedOperationException();
    }

    CharMatcher precomputedInternal() {
        BitSet r0 = new BitSet();
        setBits(r0);
        int r1 = r0.cardinality();
        if ((r1 * 2) <= 65536) goto L5;
        r0.flip(0, 65536);
        int r3 = 65536 - r1;
        if (this.description.endsWith(".negate()") == false) goto L9;
        String r2 = this.description;
        String r4 = r2.substring(0, r2.length() - 9);
    L11:
        return new NegatedFastMatcher(toString(), precomputedPositive(r3, r0, r4));
    L9:
        r4 = this.description + ".negate()";
        goto L11
    L5:
        return precomputedPositive(r1, r0, this.description);
    }

    private static CharMatcher precomputedPositive(int r2, BitSet r3, String r4) {
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L8;
        char r5 = (char) r3.nextSetBit(0);
        return isEither(r5, (char) r3.nextSetBit(r5 + 1));
    L8:
        if (isSmall(r2, r3.length()) == false) goto L11;
        return SmallCharMatcher.from(r3, r4);
    L11:
        return new BitSetMatcher(r3, r4, null);
    L15:
        return is((char) r3.nextSetBit(0));
    L17:
        return NONE;
    }

    void setBits(BitSet r3) {
        int r0 = 65535;
    L3:
        if (r0 < 0) goto L8;
        if (matches((char) r0) == false) goto L7;
        r3.set(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    public boolean matchesAnyOf(CharSequence r1) {
        return !matchesNoneOf(r1);
    }

    public boolean matchesAllOf(CharSequence r4) {
        int r0 = r4.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (matches(r4.charAt(r0)) == false) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public boolean matchesNoneOf(CharSequence r1) {
        if (indexIn(r1) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int indexIn(CharSequence r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (matches(r4.charAt(r1)) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public int indexIn(CharSequence r3, int r4) {
        int r0 = r3.length();
        Preconditions.checkPositionIndex(r4, r0);
    L3:
        if (r4 >= r0) goto L8;
        if (matches(r3.charAt(r4)) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return -1;
    }

    public int lastIndexIn(CharSequence r3) {
        int r0 = r3.length() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (matches(r3.charAt(r0)) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    public int countIn(CharSequence r4) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length()) goto L9;
        if (matches(r4.charAt(r0)) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    @CheckReturnValue
    public String removeFrom(CharSequence r6) {
        String r7 = r6.toString();
        int r0 = indexIn(r7);
        if (r0 != (-1)) goto L5;
        return r7;
    L5:
        char[] r8 = r7.toCharArray();
        int r2 = 1;
    L6:
        r0 = r0 + 1;
    L8:
        if (r0 == r8.length) goto L10;
        if (matches(r8[r0]) == true) goto L13;
        r8[r0 - r2] = r8[r0];
        r0 = r0 + 1;
        goto L8
    L13:
        r2 = r2 + 1;
        goto L6
    L10:
        return new String(r8, 0, r0 - r2);
    }

    @CheckReturnValue
    public String retainFrom(CharSequence r1) {
        return negate().removeFrom(r1);
    }

    @CheckReturnValue
    public String replaceFrom(CharSequence r3, char r4) {
        String r5 = r3.toString();
        int r0 = indexIn(r5);
        if (r0 != (-1)) goto L5;
        return r5;
    L5:
        char[] r6 = r5.toCharArray();
        r6[r0] = r4;
    L6:
        r0 = r0 + 1;
        if (r0 >= r6.length) goto L12;
        if (matches(r6[r0]) == false) goto L6;
        r6[r0] = r4;
        goto L6
    L12:
        return new String(r6);
    }

    @CheckReturnValue
    public String replaceFrom(CharSequence r8, CharSequence r9) {
        int r0 = r9.length();
        if (r0 == 0) goto L5;
        int r1 = 0;
        if (r0 == 1) goto L9;
        String r10 = r8.toString();
        int r2 = indexIn(r10);
        if (r2 != (-1)) goto L13;
        return r10;
    L13:
        int r4 = r10.length();
        StringBuilder r5 = new StringBuilder(((r4 * 3) / 2) + 16);
    L14:
        r5.append(r10, r1, r2);
        r5.append(r9);
        r1 = r2 + 1;
        r2 = indexIn(r10, r1);
        if (r2 != (-1)) goto L14;
        r5.append(r10, r1, r4);
        return r5.toString();
    L9:
        return replaceFrom(r8, r9.charAt(0));
    L5:
        return removeFrom(r8);
    }

    @CheckReturnValue
    public String trimFrom(CharSequence r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (matches(r4.charAt(r1)) == false) goto L8;
        r1 = r1 + 1;
    L8:
        int r2 = r0 - 1;
    L9:
        if (r2 <= r1) goto L15;
        if (matches(r4.charAt(r2)) == false) goto L15;
        r2 = r2 - 1;
    L15:
        return r4.subSequence(r1, r2 + 1).toString();
    }

    @CheckReturnValue
    public String trimLeadingFrom(CharSequence r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (matches(r4.charAt(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r4.subSequence(r1, r0).toString();
    L9:
        return "";
    }

    @CheckReturnValue
    public String trimTrailingFrom(CharSequence r3) {
        int r0 = r3.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (matches(r3.charAt(r0)) == false) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r3.subSequence(0, r0 + 1).toString();
    L9:
        return "";
    }

    @CheckReturnValue
    public String collapseFrom(CharSequence r8, char r9) {
        int r3 = r8.length();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L16;
        char r2 = r8.charAt(r1);
        if (matches(r2) == false) goto L14;
        if (r2 != r9) goto L13;
        if (r1 != (r3 - 1)) goto L10;
    L11:
        r1 = r1 + 1;
        goto L14
    L10:
        if (matches(r8.charAt(r1 + 1)) == false) goto L11;
    L13:
        return finishCollapseFrom(r8, r1 + 1, r3, r9, new StringBuilder(r3).append(r8.subSequence(0, r1)).append(r9), true);
    L14:
        r1 = r1 + 1;
        goto L3
    L16:
        return r8.toString();
    }

    @CheckReturnValue
    public String trimAndCollapseFrom(CharSequence r10, char r11) {
        int r0 = r10.length();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L7;
        if (matches(r10.charAt(r4)) == false) goto L7;
        r4 = r4 + 1;
    L7:
        int r1 = r0 - 1;
        int r2 = r1;
    L8:
        if (r2 <= r4) goto L12;
        if (matches(r10.charAt(r2)) == false) goto L12;
        r2 = r2 - 1;
    L12:
        if (r4 != 0) goto L15;
        if (r2 != r1) goto L15;
        return collapseFrom(r10, r11);
    L15:
        int r5 = r2 + 1;
        return finishCollapseFrom(r10, r4, r5, r11, new StringBuilder(r5 - r4), false);
    }

    private String finishCollapseFrom(CharSequence r3, int r4, int r5, char r6, StringBuilder r7, boolean r8) {
    L2:
        if (r4 >= r5) goto L10;
        char r0 = r3.charAt(r4);
        if (matches(r0) == false) goto L7;
        if (r8 == true) goto L8;
        r7.append(r6);
        r8 = true;
    L8:
        r4 = r4 + 1;
        goto L2
    L7:
        r7.append(r0);
        r8 = false;
        goto L8
    L10:
        return r7.toString();
    }

    @Deprecated
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public boolean apply2(Character r1) {
        return matches(r1.charValue());
    }

    public String toString() {
        return this.description;
    }
}
