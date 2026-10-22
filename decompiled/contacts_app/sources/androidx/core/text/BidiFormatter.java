package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.google.common.base.Ascii;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE = null;
    static final BidiFormatter DEFAULT_RTL_INSTANCE = null;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char LRM = 8206;
    private static final String LRM_STRING = null;
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private static final char RLM = 8207;
    private static final String RLM_STRING = null;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(boolean r1) {
            initialize(r1);
        }

        public Builder(Locale r1) {
            initialize(BidiFormatter.isRtlLocale(r1));
        }

        private void initialize(boolean r1) {
            this.mIsRtlContext = r1;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public Builder stereoReset(boolean r1) {
            if (r1 == false) goto L4;
            this.mFlags |= 2;
        L5:
            return this;
        L4:
            this.mFlags &= -3;
            goto L5
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat r1) {
            this.mTextDirectionHeuristicCompat = r1;
            return this;
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean r0) {
            if (r0 == false) goto L5;
            return BidiFormatter.DEFAULT_RTL_INSTANCE;
        L5:
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        public BidiFormatter build() {
            if (this.mFlags != 2) goto L9;
            if (this.mTextDirectionHeuristicCompat != BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) goto L9;
            return getDefaultInstanceFromContext(this.mIsRtlContext);
        L9:
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }
    }

    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
            int r1 = 0;
        L3:
            if (r1 >= DIR_TYPE_CACHE_SIZE) goto L5;
            DIR_TYPE_CACHE[r1] = Character.getDirectionality(r1);
            r1 = r1 + 1;
            goto L3
        }

        DirectionalityEstimator(CharSequence r1, boolean r2) {
            this.text = r1;
            this.isHtml = r2;
            this.length = r1.length();
        }

        int getEntryDir() {
            this.charIndex = 0;
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
        L4:
            if (this.charIndex >= this.length) goto L23;
            if (r1 != 0) goto L23;
            byte r4 = dirTypeForward();
            if (r4 == 0) goto L20;
            if (r4 == 1) goto L18;
            if (r4 == 2) goto L18;
            if (r4 == 9) goto L4;
            switch(r4) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r3 = r3 + 1;
            r2 = 1;
            goto L4
        L17:
            r3 = r3 + 1;
            r2 = -1;
        L22:
            r1 = r3;
            goto L4
        L15:
            r3 = r3 - 1;
            r2 = 0;
        L18:
            if (r3 != 0) goto L22;
            return 1;
        L20:
            if (r3 != 0) goto L22;
            return -1;
        L23:
            if (r1 != 0) goto L25;
            return 0;
        L25:
            if (r2 == 0) goto L28;
            return r2;
        L28:
            if (this.charIndex <= 0) goto L38;
            switch(dirTypeBackward()) {
                case 14: goto L35;
                case 15: goto L35;
                case 16: goto L33;
                case 17: goto L33;
                case 18: goto L32;
                default: goto L28;
            };
        L32:
            r3 = r3 + 1;
            goto L28
        L33:
            if (r1 == r3) goto L34;
        L37:
            r3 = r3 - 1;
            goto L28
        L34:
            return 1;
        L35:
            if (r1 != r3) goto L37;
            return -1;
        L38:
            return 0;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int r1 = 0;
        L3:
            int r2 = r1;
        L5:
            if (this.charIndex <= 0) goto L31;
            byte r3 = dirTypeBackward();
            if (r3 != 0) goto L9;
            if (r1 == 0) goto L28;
            if (r2 != 0) goto L5;
        L28:
            return -1;
        L9:
            if (r3 == 1) goto L23;
            if (r3 == 2) goto L23;
            if (r3 == 9) goto L5;
            switch(r3) {
                case 14: goto L20;
                case 15: goto L20;
                case 16: goto L18;
                case 17: goto L18;
                case 18: goto L17;
                default: goto L15;
            };
        L17:
            r1 = r1 + 1;
            goto L5
        L18:
            if (r2 == r1) goto L19;
        L22:
            r1 = r1 - 1;
            goto L5
        L19:
            return 1;
        L20:
            if (r2 != r1) goto L22;
            return -1;
        L15:
            if (r2 != 0) goto L5;
        L23:
            if (r1 == 0) goto L24;
            if (r2 != 0) goto L5;
        L24:
            return 1;
        L31:
            return 0;
        }

        private static byte getCachedDirectionality(char r1) {
            if (r1 >= DIR_TYPE_CACHE_SIZE) goto L6;
            return DIR_TYPE_CACHE[r1];
        L6:
            return Character.getDirectionality(r1);
        }

        byte dirTypeForward() {
            char r0 = this.text.charAt(this.charIndex);
            this.lastChar = r0;
            if (Character.isHighSurrogate(r0) == false) goto L6;
            int r1 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(r1);
            return Character.getDirectionality(r1);
        L6:
            this.charIndex++;
            byte r2 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r3 = this.lastChar;
            if (r3 != '<') goto L12;
            return skipTagForward();
        L12:
            if (r3 == '&') goto L14;
            return r2;
        L14:
            return skipEntityForward();
        L15:
            return r2;
        }

        byte dirTypeBackward() {
            char r0 = this.text.charAt(this.charIndex - 1);
            this.lastChar = r0;
            if (Character.isLowSurrogate(r0) == false) goto L6;
            int r1 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(r1);
            return Character.getDirectionality(r1);
        L6:
            this.charIndex--;
            byte r2 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r3 = this.lastChar;
            if (r3 != '>') goto L12;
            return skipTagBackward();
        L12:
            if (r3 == ';') goto L14;
            return r2;
        L14:
            return skipEntityBackward();
        L15:
            return r2;
        }

        private byte skipTagForward() {
            int r0 = this.charIndex;
        L3:
            int r1 = this.charIndex;
            if (r1 >= this.length) goto L18;
            CharSequence r2 = this.text;
            this.charIndex = r1 + 1;
            char r3 = r2.charAt(r1);
            this.lastChar = r3;
            if (r3 == '>') goto L7;
            if (r3 == '\"') goto L13;
            if (r3 != '\'') goto L3;
        L13:
            int r4 = this.charIndex;
            if (r4 >= this.length) goto L3;
            CharSequence r5 = this.text;
            this.charIndex = r4 + 1;
            char r6 = r5.charAt(r4);
            this.lastChar = r6;
            if (r6 == r3) goto L3;
        L7:
            return Ascii.FF;
        L18:
            this.charIndex = r0;
            this.lastChar = '<';
            return Ascii.CR;
        }

        private byte skipTagBackward() {
            int r0 = this.charIndex;
        L3:
            int r1 = this.charIndex;
            if (r1 <= 0) goto L20;
            CharSequence r3 = this.text;
            int r2 = r1 - 1;
            this.charIndex = r2;
            char r4 = r3.charAt(r2);
            this.lastChar = r4;
            if (r4 == '<') goto L7;
            if (r4 == '>') goto L20;
            if (r4 == '\"') goto L15;
            if (r4 != '\'') goto L3;
        L15:
            int r5 = this.charIndex;
            if (r5 <= 0) goto L3;
            CharSequence r6 = this.text;
            int r7 = r5 - 1;
            this.charIndex = r7;
            char r8 = r6.charAt(r7);
            this.lastChar = r8;
            if (r8 == r4) goto L3;
        L7:
            return Ascii.FF;
        L20:
            this.charIndex = r0;
            this.lastChar = '>';
            return Ascii.CR;
        }

        private byte skipEntityForward() {
        L2:
            int r0 = this.charIndex;
            if (r0 >= this.length) goto L7;
            CharSequence r1 = this.text;
            this.charIndex = r0 + 1;
            char r2 = r1.charAt(r0);
            this.lastChar = r2;
            if (r2 != ';') goto L2;
            return Ascii.FF;
        L7:
            return Ascii.FF;
        }

        private byte skipEntityBackward() {
            int r0 = this.charIndex;
        L3:
            int r1 = this.charIndex;
            if (r1 <= 0) goto L10;
            CharSequence r3 = this.text;
            int r2 = r1 - 1;
            this.charIndex = r2;
            char r4 = r3.charAt(r2);
            this.lastChar = r4;
            if (r4 == '&') goto L7;
            if (r4 != ';') goto L3;
        L7:
            return Ascii.FF;
        L10:
            this.charIndex = r0;
            this.lastChar = ';';
            return Ascii.CR;
        }
    }

    static {
        TextDirectionHeuristicCompat r0 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = r0;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, r0);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, r0);
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(boolean r1) {
        return new Builder(r1).build();
    }

    public static BidiFormatter getInstance(Locale r1) {
        return new Builder(r1).build();
    }

    BidiFormatter(boolean r1, int r2, TextDirectionHeuristicCompat r3) {
        this.mIsRtlContext = r1;
        this.mFlags = r2;
        this.mDefaultTextDirectionHeuristicCompat = r3;
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public boolean getStereoReset() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private String markAfter(CharSequence r3, TextDirectionHeuristicCompat r4) {
        boolean r5 = r4.isRtl(r3, 0, r3.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r5 == true) goto L8;
        if (getExitDir(r3) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r5 == false) goto L15;
        if (getExitDir(r3) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    private String markBefore(CharSequence r3, TextDirectionHeuristicCompat r4) {
        boolean r5 = r4.isRtl(r3, 0, r3.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r5 == true) goto L8;
        if (getEntryDir(r3) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r5 == false) goto L15;
        if (getEntryDir(r3) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    public boolean isRtl(String r1) {
        return isRtl(r1);
    }

    public boolean isRtl(CharSequence r3) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(r3, 0, r3.length());
    }

    public String unicodeWrap(String r1, TextDirectionHeuristicCompat r2, boolean r3) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return unicodeWrap(r1, r2, r3).toString();
    }

    public CharSequence unicodeWrap(CharSequence r3, TextDirectionHeuristicCompat r4, boolean r5) {
        if (r3 != null) goto L5;
        return null;
    L5:
        boolean r6 = r4.isRtl(r3, 0, r3.length());
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        if (getStereoReset() == false) goto L13;
        if (r5 == false) goto L13;
        if (r6 == false) goto L10;
        TextDirectionHeuristicCompat r1 = TextDirectionHeuristicsCompat.RTL;
    L11:
        r0.append(markBefore(r3, r1));
        goto L13
    L10:
        r1 = TextDirectionHeuristicsCompat.LTR;
    L13:
        if (r6 == this.mIsRtlContext) goto L18;
        if (r6 == false) goto L16;
        char r2 = RLE;
    L17:
        r0.append(r2);
        r0.append(r3);
        r0.append(PDF);
    L19:
        if (r5 == false) goto L24;
        if (r6 == false) goto L22;
        TextDirectionHeuristicCompat r7 = TextDirectionHeuristicsCompat.RTL;
    L23:
        r0.append(markAfter(r3, r7));
        goto L24
    L22:
        r7 = TextDirectionHeuristicsCompat.LTR;
    L24:
        return r0;
    L16:
        r2 = LRE;
        goto L17
    L18:
        r0.append(r3);
        goto L19
    }

    public String unicodeWrap(String r2, TextDirectionHeuristicCompat r3) {
        return unicodeWrap(r2, r3, true);
    }

    public CharSequence unicodeWrap(CharSequence r2, TextDirectionHeuristicCompat r3) {
        return unicodeWrap(r2, r3, true);
    }

    public String unicodeWrap(String r2, boolean r3) {
        return unicodeWrap(r2, this.mDefaultTextDirectionHeuristicCompat, r3);
    }

    public CharSequence unicodeWrap(CharSequence r2, boolean r3) {
        return unicodeWrap(r2, this.mDefaultTextDirectionHeuristicCompat, r3);
    }

    public String unicodeWrap(String r3) {
        return unicodeWrap(r3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence r3) {
        return unicodeWrap(r3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    static boolean isRtlLocale(Locale r1) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static int getExitDir(CharSequence r2) {
        return new DirectionalityEstimator(r2, false).getExitDir();
    }

    private static int getEntryDir(CharSequence r2) {
        return new DirectionalityEstimator(r2, false).getEntryDir();
    }
}
