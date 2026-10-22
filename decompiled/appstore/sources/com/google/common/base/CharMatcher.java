package com.google.common.base;

import androidx.core.internal.view.SupportMenu;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate<Character> {
    private static final int DISTINCT_CHARS = 65536;

    public static final class And extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        public And(CharMatcher r10, CharMatcher r11) {
            this.first = (CharMatcher) Preconditions.checkNotNull(r10);
            this.second = (CharMatcher) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (this.first.matches(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.second.matches(r10) == false) goto L7;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            BitSet r11 = new BitSet();
            this.first.setBits(r11);
            BitSet r12 = new BitSet();
            this.second.setBits(r12);
            r11.and(r12);
            r10.or(r11);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.first + ", " + this.second + ")";
        }
    }

    public static final class Any extends NamedFastMatcher {
        static final Any INSTANCE = null;

        static {
            INSTANCE = new Any();
        }

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r10) {
            return (CharMatcher) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence r10, char r11) {
            if (r10.length() != 0) goto L6;
            return "";
        L6:
            return String.valueOf(r11);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r10) {
            return r10.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r10) {
            if (r10.length() != 0) goto L5;
            return -1;
        L5:
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence r10) {
            return r10.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r10) {
            if (r10.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r10) {
            Preconditions.checkNotNull(r10);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r10, char r11) {
            char[] r12 = new char[r10.length()];
            Arrays.fill(r12, r11);
            return new String(r12);
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r10, int r11) {
            int r12 = r10.length();
            Preconditions.checkPositionIndex(r11, r12);
            if (r11 != r12) goto L6;
            return -1;
        L6:
            return r11;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r10, CharSequence r11) {
            StringBuilder r12 = new StringBuilder(r10.length() * r11.length());
            int r13 = 0;
        L4:
            if (r13 >= r10.length()) goto L7;
            r12.append(r11);
            r13 = r13 + 1;
            goto L4
        L7:
            return r12.toString();
        }
    }

    public static final class AnyOf extends CharMatcher {
        private final char[] chars;

        public AnyOf(CharSequence r10) {
            char[] r11 = r10.toString().toCharArray();
            this.chars = r11;
            Arrays.sort(r11);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (Arrays.binarySearch(this.chars, r10) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            char[] r11 = this.chars;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10.set(r11[r13]);
            r13 = r13 + 1;
            goto L3
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder r10 = new StringBuilder("CharMatcher.anyOf(\"");
            char[] r11 = this.chars;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10.append(CharMatcher.access$100(r11[r13]));
            r13 = r13 + 1;
            goto L3
        L5:
            r10.append("\")");
            return r10.toString();
        }
    }

    public static final class Ascii extends NamedFastMatcher {
        static final Ascii INSTANCE = null;

        static {
            INSTANCE = new Ascii();
        }

        public Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (r10 > 127) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @GwtIncompatible
    public static final class BitSetMatcher extends NamedFastMatcher {
        private final BitSet table;

        public /* synthetic */ BitSetMatcher(BitSet r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return this.table.get(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public void setBits(BitSet r10) {
            r10.or(this.table);
        }

        private BitSetMatcher(BitSet r10, String r11) {
            super(r11);
            if ((r10.length() + 64) >= r10.size()) goto L5;
            r10 = (BitSet) r10.clone();
        L5:
            this.table = r10;
        }
    }

    public static final class BreakingWhitespace extends CharMatcher {
        static final CharMatcher INSTANCE = null;

        static {
            INSTANCE = new BreakingWhitespace();
        }

        private BreakingWhitespace() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (r10 != ' ') goto L5;
        L27:
            return true;
        L5:
            if (r10 == 133) goto L27;
            if (r10 == 5760) goto L27;
            if (r10 != 8199) goto L11;
            return false;
        L11:
            if (r10 == 8287) goto L27;
            if (r10 == 12288) goto L27;
            if (r10 == 8232) goto L27;
            if (r10 == 8233) goto L27;
            switch(r10) {
                case 9: goto L27;
                case 10: goto L27;
                case 11: goto L27;
                case 12: goto L27;
                case 13: goto L27;
                default: goto L20;
            };
        L20:
            if (r10 < 8192) goto L25;
            if (r10 > 8202) goto L25;
            return true;
        L25:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class Digit extends RangesMatcher {
        static final Digit INSTANCE = null;
        private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        static {
            INSTANCE = new Digit();
        }

        private Digit() {
            super("CharMatcher.digit()", zeroes(), nines());
        }

        private static char[] nines() {
            char[] r10 = new char[37];
            int r11 = 0;
        L3:
            if (r11 >= 37) goto L5;
            r10[r11] = (char) (ZEROES.charAt(r11) + '\t');
            r11 = r11 + 1;
            goto L3
        L5:
            return r10;
        }

        private static char[] zeroes() {
            return ZEROES.toCharArray();
        }
    }

    public static abstract class FastMatcher extends CharMatcher {
        public FastMatcher() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    public static final class ForPredicate extends CharMatcher {
        private final Predicate<? super Character> predicate;

        public ForPredicate(Predicate<? super Character> r10) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return apply(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return this.predicate.apply(Character.valueOf(r10));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.forPredicate(" + this.predicate + ")";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.CharMatcher
        public boolean apply(Character r10) {
            return this.predicate.apply(Preconditions.checkNotNull(r10));
        }
    }

    public static final class InRange extends FastMatcher {
        private final char endInclusive;
        private final char startInclusive;

        public InRange(char r10, char r11) {
            if (r11 < r10) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12);
            this.startInclusive = r10;
            this.endInclusive = r11;
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (this.startInclusive <= r10) goto L5;
        L7:
            return false;
        L5:
            if (r10 > this.endInclusive) goto L7;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            r10.set(this.startInclusive, this.endInclusive + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.access$100(this.startInclusive) + "', '" + CharMatcher.access$100(this.endInclusive) + "')";
        }
    }

    public static final class Invisible extends RangesMatcher {
        static final Invisible INSTANCE = null;
        private static final String RANGE_ENDS = "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";
        private static final String RANGE_STARTS = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

        static {
            INSTANCE = new Invisible();
        }

        private Invisible() {
            super("CharMatcher.invisible()", RANGE_STARTS.toCharArray(), RANGE_ENDS.toCharArray());
        }
    }

    public static final class Is extends FastMatcher {
        private final char match;

        public Is(char r10) {
            this.match = r10;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r10) {
            if (r10.matches(this.match) == false) goto L6;
            return this;
        L6:
            return CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (r10 != this.match) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.isNot(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r10) {
            if (r10.matches(this.match) == false) goto L6;
            return r10;
        L6:
            return super.or(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r10, char r11) {
            return r10.toString().replace(this.match, r11);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            r10.set(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.access$100(this.match) + "')";
        }
    }

    public static final class IsEither extends FastMatcher {
        private final char match1;
        private final char match2;

        public IsEither(char r10, char r11) {
            this.match1 = r10;
            this.match2 = r11;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (r10 != this.match1) goto L5;
        L8:
            return true;
        L5:
            if (r10 == this.match2) goto L8;
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            r10.set(this.match1);
            r10.set(this.match2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.access$100(this.match1) + CharMatcher.access$100(this.match2) + "\")";
        }
    }

    public static final class IsNot extends FastMatcher {
        private final char match;

        public IsNot(char r10) {
            this.match = r10;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r10) {
            if (r10.matches(this.match) == true) goto L5;
            return r10;
        L5:
            return super.and(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (r10 == this.match) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.is(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r10) {
            if (r10.matches(this.match) == true) goto L5;
            return this;
        L5:
            return CharMatcher.any();
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            r10.set(0, this.match);
            r10.set(this.match + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.access$100(this.match) + "')";
        }
    }

    public static final class JavaDigit extends CharMatcher {
        static final JavaDigit INSTANCE = null;

        static {
            INSTANCE = new JavaDigit();
        }

        private JavaDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return Character.isDigit(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class JavaIsoControl extends NamedFastMatcher {
        static final JavaIsoControl INSTANCE = null;

        static {
            INSTANCE = new JavaIsoControl();
        }

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (r10 > 31) goto L5;
        L10:
            return true;
        L5:
            if (r10 >= 127) goto L7;
        L9:
            return false;
        L7:
            if (r10 > 159) goto L9;
            goto L9
        }
    }

    public static final class JavaLetter extends CharMatcher {
        static final JavaLetter INSTANCE = null;

        static {
            INSTANCE = new JavaLetter();
        }

        private JavaLetter() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return Character.isLetter(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class JavaLetterOrDigit extends CharMatcher {
        static final JavaLetterOrDigit INSTANCE = null;

        static {
            INSTANCE = new JavaLetterOrDigit();
        }

        private JavaLetterOrDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return Character.isLetterOrDigit(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class JavaLowerCase extends CharMatcher {
        static final JavaLowerCase INSTANCE = null;

        static {
            INSTANCE = new JavaLowerCase();
        }

        private JavaLowerCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return Character.isLowerCase(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class JavaUpperCase extends CharMatcher {
        static final JavaUpperCase INSTANCE = null;

        static {
            INSTANCE = new JavaUpperCase();
        }

        private JavaUpperCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return Character.isUpperCase(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class NamedFastMatcher extends FastMatcher {
        private final String description;

        public NamedFastMatcher(String r10) {
            this.description = (String) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.description;
        }
    }

    public static class Negated extends CharMatcher {
        final CharMatcher original;

        public Negated(CharMatcher r10) {
            this.original = (CharMatcher) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r10) {
            return r10.length() - this.original.countIn(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return !this.original.matches(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r10) {
            return this.original.matchesNoneOf(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r10) {
            return this.original.matchesAllOf(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return this.original;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            BitSet r11 = new BitSet();
            this.original.setBits(r11);
            r11.flip(0, 65536);
            r10.or(r11);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.original + ".negate()";
        }
    }

    public static class NegatedFastMatcher extends Negated {
        public NegatedFastMatcher(CharMatcher r10) {
            super(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    public static final class None extends NamedFastMatcher {
        static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r10) {
            Preconditions.checkNotNull(r10);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence r10, char r11) {
            return r10.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r10) {
            if (r10.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.any();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r10) {
            return (CharMatcher) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence r10) {
            return r10.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r10, char r11) {
            return r10.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence r10) {
            return r10.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence r10) {
            return r10.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence r10) {
            return r10.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r10, int r11) {
            Preconditions.checkPositionIndex(r11, r10.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r10, CharSequence r11) {
            Preconditions.checkNotNull(r11);
            return r10.toString();
        }
    }

    public static final class Or extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        public Or(CharMatcher r10, CharMatcher r11) {
            this.first = (CharMatcher) Preconditions.checkNotNull(r10);
            this.second = (CharMatcher) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (this.first.matches(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.second.matches(r10) == true) goto L8;
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            this.first.setBits(r10);
            this.second.setBits(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.first + ", " + this.second + ")";
        }
    }

    public static class RangesMatcher extends CharMatcher {
        private final String description;
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        public RangesMatcher(String r10, char[] r11, char[] r12) {
            this.description = r10;
            this.rangeStarts = r11;
            this.rangeEnds = r12;
            if (r11.length != r12.length) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13);
            int r14 = 0;
        L8:
            if (r14 >= r11.length) goto L21;
            if (r11[r14] > r12[r14]) goto L12;
            boolean r15 = true;
        L13:
            Preconditions.checkArgument(r15);
            int r16 = r14 + 1;
            if (r16 >= r11.length) goto L20;
            if (r12[r14] >= r11[r16]) goto L18;
            boolean r17 = true;
        L19:
            Preconditions.checkArgument(r17);
            goto L20
        L18:
            r17 = false;
        L20:
            r14 = r16;
            goto L8
        L12:
            r15 = false;
            goto L13
        L21:
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r10) {
            return super.apply2(r10);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            int r11 = Arrays.binarySearch(this.rangeStarts, r10);
            if (r11 < 0) goto L5;
            return true;
        L5:
            int r12 = (~r11) - 1;
            if (r12 >= 0) goto L8;
        L10:
            return false;
        L8:
            if (r10 > this.rangeEnds[r12]) goto L10;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.description;
        }
    }

    public static final class SingleWidth extends RangesMatcher {
        static final SingleWidth INSTANCE = null;

        static {
            INSTANCE = new SingleWidth();
        }

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    @VisibleForTesting
    public static final class Whitespace extends NamedFastMatcher {
        static final Whitespace INSTANCE = null;
        static final int MULTIPLIER = 1682554634;
        static final int SHIFT = 0;
        static final String TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";

        static {
            SHIFT = Integer.numberOfLeadingZeros(31);
            INSTANCE = new Whitespace();
        }

        public Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r10) {
            if (TABLE.charAt((MULTIPLIER * r10) >>> SHIFT) != r10) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void setBits(BitSet r10) {
            int r11 = 0;
        L4:
            if (r11 >= 32) goto L6;
            r10.set(TABLE.charAt(r11));
            r11 = r11 + 1;
            goto L4
        }
    }

    public CharMatcher() {
    }

    public static /* synthetic */ String access$100(char r10) {
        return showCharacter(r10);
    }

    public static CharMatcher any() {
        return Any.INSTANCE;
    }

    public static CharMatcher anyOf(CharSequence r10) {
        int r11 = r10.length();
        if (r11 == 0) goto L15;
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        return new AnyOf(r10);
    L11:
        return isEither(r10.charAt(0), r10.charAt(1));
    L13:
        return is(r10.charAt(0));
    L15:
        return none();
    }

    public static CharMatcher ascii() {
        return Ascii.INSTANCE;
    }

    public static CharMatcher breakingWhitespace() {
        return BreakingWhitespace.INSTANCE;
    }

    @Deprecated
    public static CharMatcher digit() {
        return Digit.INSTANCE;
    }

    private String finishCollapseFrom(CharSequence r10, int r11, int r12, char r13, StringBuilder r14, boolean r15) {
    L2:
        if (r11 >= r12) goto L10;
        char r16 = r10.charAt(r11);
        if (matches(r16) == false) goto L7;
        if (r15 == true) goto L8;
        r14.append(r13);
        r15 = true;
    L8:
        r11 = r11 + 1;
        goto L2
    L7:
        r14.append(r16);
        r15 = false;
        goto L8
    L10:
        return r14.toString();
    }

    public static CharMatcher forPredicate(Predicate<? super Character> r10) {
        if ((r10 instanceof CharMatcher) == false) goto L6;
        return (CharMatcher) r10;
    L6:
        return new ForPredicate(r10);
    }

    public static CharMatcher inRange(char r10, char r11) {
        return new InRange(r10, r11);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return Invisible.INSTANCE;
    }

    public static CharMatcher is(char r10) {
        return new Is(r10);
    }

    private static IsEither isEither(char r10, char r11) {
        return new IsEither(r10, r11);
    }

    public static CharMatcher isNot(char r10) {
        return new IsNot(r10);
    }

    @GwtIncompatible
    private static boolean isSmall(int r10, int r11) {
        if (r10 <= 1023) goto L5;
    L7:
        return false;
    L5:
        if (r11 <= (r10 * 64)) goto L7;
        return true;
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return JavaDigit.INSTANCE;
    }

    public static CharMatcher javaIsoControl() {
        return JavaIsoControl.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return JavaLetter.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return JavaLetterOrDigit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return JavaLowerCase.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return JavaUpperCase.INSTANCE;
    }

    public static CharMatcher none() {
        return None.INSTANCE;
    }

    public static CharMatcher noneOf(CharSequence r10) {
        return anyOf(r10).negate();
    }

    @GwtIncompatible
    private static CharMatcher precomputedPositive(int r10, BitSet r11, String r12) {
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L8;
        char r13 = (char) r11.nextSetBit(0);
        return isEither(r13, (char) r11.nextSetBit(r13 + 1));
    L8:
        if (isSmall(r10, r11.length()) == false) goto L11;
        return SmallCharMatcher.from(r11, r12);
    L11:
        return new BitSetMatcher(r11, r12, null);
    L15:
        return is((char) r11.nextSetBit(0));
    L17:
        return none();
    }

    private static String showCharacter(char r10) {
        char[] r11 = new char[6];
        int r12 = 0;
        r11[0] = TokenParser.ESCAPE;
        r11[1] = 'u';
        r11[2] = 0;
        r11[3] = 0;
        r11[4] = 0;
        r11[5] = 0;
    L3:
        if (r12 >= 4) goto L6;
        r11[5 - r12] = "0123456789ABCDEF".charAt(r10 & 15);
        r10 = (char) (r10 >> 4);
        r12 = r12 + 1;
        goto L3
    L6:
        return String.copyValueOf(r11);
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return SingleWidth.INSTANCE;
    }

    public static CharMatcher whitespace() {
        return Whitespace.INSTANCE;
    }

    public CharMatcher and(CharMatcher r10) {
        return new And(this, r10);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Character r10) {
        return apply2(r10);
    }

    public String collapseFrom(CharSequence r10, char r11) {
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L16;
        char r14 = r10.charAt(r13);
        if (matches(r14) == false) goto L14;
        if (r14 != r11) goto L12;
        if (r13 != (r12 - 1)) goto L10;
    L11:
        r13 = r13 + 1;
        goto L14
    L10:
        if (matches(r10.charAt(r13 + 1)) == false) goto L11;
    L12:
        StringBuilder r15 = new StringBuilder(r12);
        r15.append(r10, 0, r13);
        r15.append(r11);
        return finishCollapseFrom(r10, r13 + 1, r12, r11, r15, true);
    L14:
        r13 = r13 + 1;
        goto L3
    L16:
        return r10.toString();
    }

    public int countIn(CharSequence r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= r10.length()) goto L9;
        if (matches(r10.charAt(r11)) == false) goto L8;
        r12 = r12 + 1;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r12;
    }

    public int indexIn(CharSequence r10) {
        return indexIn(r10, 0);
    }

    public int lastIndexIn(CharSequence r10) {
        int r11 = r10.length() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (matches(r10.charAt(r11)) == true) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    public abstract boolean matches(char r10);

    public boolean matchesAllOf(CharSequence r10) {
        int r11 = r10.length() - 1;
    L3:
        if (r11 < 0) goto L9;
        if (matches(r10.charAt(r11)) == false) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public boolean matchesAnyOf(CharSequence r10) {
        return !matchesNoneOf(r10);
    }

    public boolean matchesNoneOf(CharSequence r10) {
        if (indexIn(r10) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public CharMatcher negate() {
        return new Negated(this);
    }

    public CharMatcher or(CharMatcher r10) {
        return new Or(this, r10);
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    @GwtIncompatible
    public CharMatcher precomputedInternal() {
        BitSet r10 = new BitSet();
        setBits(r10);
        int r11 = r10.cardinality();
        if ((r11 * 2) <= 65536) goto L5;
        r10.flip(0, 65536);
        int r12 = 65536 - r11;
        final String r13 = toString();
        if (r13.endsWith(".negate()") == false) goto L9;
        String r14 = r13.substring(0, r13.length() - 9);
    L10:
        final CharMatcher r15 = precomputedPositive(r12, r10, r14);
        return new AnonymousClass1(this, r15, r13);
    L9:
        r14 = r13 + ".negate()";
        goto L10
    L5:
        return precomputedPositive(r11, r10, toString());
    }

    public String removeFrom(CharSequence r10) {
        String r11 = r10.toString();
        int r12 = indexIn(r11);
        if (r12 != (-1)) goto L5;
        return r11;
    L5:
        char[] r13 = r11.toCharArray();
        int r14 = 1;
    L6:
        r12 = r12 + 1;
    L8:
        if (r12 == r13.length) goto L10;
        if (matches(r13[r12]) == true) goto L13;
        r13[r12 - r14] = r13[r12];
        r12 = r12 + 1;
        goto L8
    L13:
        r14 = r14 + 1;
        goto L6
    L10:
        return new String(r13, 0, r12 - r14);
    }

    public String replaceFrom(CharSequence r10, char r11) {
        String r12 = r10.toString();
        int r13 = indexIn(r12);
        if (r13 != (-1)) goto L5;
        return r12;
    L5:
        char[] r14 = r12.toCharArray();
        r14[r13] = r11;
    L6:
        r13 = r13 + 1;
        if (r13 >= r14.length) goto L12;
        if (matches(r14[r13]) == false) goto L6;
        r14[r13] = r11;
        goto L6
    L12:
        return new String(r14);
    }

    public String retainFrom(CharSequence r10) {
        return negate().removeFrom(r10);
    }

    @GwtIncompatible
    public void setBits(BitSet r10) {
        int r11 = SupportMenu.USER_MASK;
    L3:
        if (r11 < 0) goto L8;
        if (matches((char) r11) == false) goto L7;
        r10.set(r11);
    L7:
        r11 = r11 - 1;
        goto L3
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence r11, char r12) {
        int r10 = r11.length();
        int r13 = r10 - 1;
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L7;
        if (matches(r11.charAt(r14)) == false) goto L7;
        r14 = r14 + 1;
    L7:
        int r15 = r13;
    L8:
        if (r15 <= r14) goto L12;
        if (matches(r11.charAt(r15)) == false) goto L12;
        r15 = r15 - 1;
    L12:
        if (r14 != 0) goto L15;
        if (r15 != r13) goto L15;
        return collapseFrom(r11, r12);
    L15:
        int r16 = r15 + 1;
        return finishCollapseFrom(r11, r14, r16, r12, new StringBuilder(r16 - r14), false);
    }

    public String trimFrom(CharSequence r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (matches(r10.charAt(r12)) == false) goto L8;
        r12 = r12 + 1;
    L8:
        int r13 = r11 - 1;
    L9:
        if (r13 <= r12) goto L15;
        if (matches(r10.charAt(r13)) == false) goto L15;
        r13 = r13 - 1;
    L15:
        return r10.subSequence(r12, r13 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (matches(r10.charAt(r12)) == false) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return r10.subSequence(r12, r11).toString();
    L9:
        return "";
    }

    public String trimTrailingFrom(CharSequence r10) {
        int r11 = r10.length() - 1;
    L3:
        if (r11 < 0) goto L9;
        if (matches(r10.charAt(r11)) == false) goto L7;
        r11 = r11 - 1;
        goto L3
    L7:
        return r10.subSequence(0, r11 + 1).toString();
    L9:
        return "";
    }

    @Deprecated
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public boolean apply2(Character r10) {
        return matches(r10.charValue());
    }

    public int indexIn(CharSequence r10, int r11) {
        int r12 = r10.length();
        Preconditions.checkPositionIndex(r11, r12);
    L3:
        if (r11 >= r12) goto L8;
        if (matches(r10.charAt(r11)) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    public String replaceFrom(CharSequence r10, CharSequence r11) {
        int r12 = r11.length();
        if (r12 == 0) goto L5;
        int r13 = 0;
        if (r12 == 1) goto L9;
        String r14 = r10.toString();
        int r15 = indexIn(r14);
        if (r15 != (-1)) goto L13;
        return r14;
    L13:
        int r16 = r14.length();
        StringBuilder r17 = new StringBuilder(((r16 * 3) / 2) + 16);
    L14:
        r17.append(r14, r13, r15);
        r17.append(r11);
        r13 = r15 + 1;
        r15 = indexIn(r14, r13);
        if (r15 != (-1)) goto L14;
        r17.append(r14, r13, r16);
        return r17.toString();
    L9:
        return replaceFrom(r10, r11.charAt(0));
    L5:
        return removeFrom(r10);
    }
}
