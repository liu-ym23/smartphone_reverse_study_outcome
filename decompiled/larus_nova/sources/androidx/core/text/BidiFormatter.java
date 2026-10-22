package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
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

        public BidiFormatter build() {
            if (this.mFlags != 2) goto L9;
            if (this.mTextDirectionHeuristicCompat != BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) goto L9;
            return getDefaultInstanceFromContext(this.mIsRtlContext);
        L9:
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale r100) {
            initialize(BidiFormatter.isRtlLocale(r100));
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean r100) {
            if (r100 == false) goto L5;
            return BidiFormatter.DEFAULT_RTL_INSTANCE;
        L5:
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean r100) {
            this.mIsRtlContext = r100;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat r100) {
            this.mTextDirectionHeuristicCompat = r100;
            return this;
        }

        public Builder stereoReset(boolean r100) {
            if (r100 == false) goto L4;
            this.mFlags |= 2;
        L5:
            return this;
        L4:
            this.mFlags &= -3;
            goto L5
        }

        public Builder(boolean r100) {
            initialize(r100);
        }
    }

    public static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        public int getEntryDir() {
            this.charIndex = 0;
            int r100 = 0;
            int r101 = 0;
            int r102 = 0;
        L4:
            if (this.charIndex >= this.length) goto L23;
            if (r100 != 0) goto L23;
            byte r103 = dirTypeForward();
            if (r103 == 0) goto L20;
            if (r103 == 1) goto L18;
            if (r103 == 2) goto L18;
            if (r103 == 9) goto L4;
            switch(r103) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r102 = r102 + 1;
            r101 = 1;
            goto L4
        L17:
            r102 = r102 + 1;
            r101 = -1;
        L22:
            r100 = r102;
            goto L4
        L15:
            r102 = r102 - 1;
            r101 = 0;
        L18:
            if (r102 != 0) goto L22;
            return 1;
        L20:
            if (r102 != 0) goto L22;
            return -1;
        L23:
            if (r100 != 0) goto L25;
            return 0;
        L25:
            if (r101 == 0) goto L28;
            return r101;
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
            r102 = r102 + 1;
            goto L28
        L33:
            if (r100 == r102) goto L34;
        L37:
            r102 = r102 - 1;
            goto L28
        L34:
            return 1;
        L35:
            if (r100 != r102) goto L37;
            return -1;
        L38:
            return 0;
        }

        static {
            DIR_TYPE_CACHE = new byte[1792];
            int r100 = 0;
        L3:
            if (r100 >= 1792) goto L5;
            DIR_TYPE_CACHE[r100] = Character.getDirectionality(r100);
            r100 = r100 + 1;
            goto L3
        }

        private byte skipEntityBackward() {
            int r100 = this.charIndex;
        L3:
            int r101 = this.charIndex;
            if (r101 <= 0) goto L10;
            CharSequence r102 = this.text;
            int r103 = r101 - 1;
            this.charIndex = r103;
            char r104 = r102.charAt(r103);
            this.lastChar = r104;
            if (r104 == '&') goto L7;
            if (r104 != ';') goto L3;
        L7:
            return 12;
        L10:
            this.charIndex = r100;
            this.lastChar = ';';
            return HTTP.CR;
        }

        private byte skipEntityForward() {
        L2:
            int r100 = this.charIndex;
            if (r100 >= this.length) goto L7;
            CharSequence r101 = this.text;
            this.charIndex = r100 + 1;
            char r102 = r101.charAt(r100);
            this.lastChar = r102;
            if (r102 != ';') goto L2;
            return 12;
        L7:
            return 12;
        }

        private byte skipTagBackward() {
            int r100 = this.charIndex;
        L3:
            int r101 = this.charIndex;
            if (r101 <= 0) goto L20;
            CharSequence r102 = this.text;
            int r103 = r101 - 1;
            this.charIndex = r103;
            char r104 = r102.charAt(r103);
            this.lastChar = r104;
            if (r104 == '<') goto L7;
            if (r104 == '>') goto L20;
            if (r104 == '\"') goto L15;
            if (r104 != '\'') goto L3;
        L15:
            int r105 = this.charIndex;
            if (r105 <= 0) goto L3;
            CharSequence r106 = this.text;
            int r107 = r105 - 1;
            this.charIndex = r107;
            char r108 = r106.charAt(r107);
            this.lastChar = r108;
            if (r108 == r104) goto L3;
        L7:
            return 12;
        L20:
            this.charIndex = r100;
            this.lastChar = Typography.greater;
            return HTTP.CR;
        }

        private byte skipTagForward() {
            int r100 = this.charIndex;
        L3:
            int r101 = this.charIndex;
            if (r101 >= this.length) goto L18;
            CharSequence r102 = this.text;
            this.charIndex = r101 + 1;
            char r103 = r102.charAt(r101);
            this.lastChar = r103;
            if (r103 == '>') goto L7;
            if (r103 == '\"') goto L13;
            if (r103 != '\'') goto L3;
        L13:
            int r104 = this.charIndex;
            if (r104 >= this.length) goto L3;
            CharSequence r105 = this.text;
            this.charIndex = r104 + 1;
            char r106 = r105.charAt(r104);
            this.lastChar = r106;
            if (r106 == r103) goto L3;
        L7:
            return 12;
        L18:
            this.charIndex = r100;
            this.lastChar = Typography.less;
            return HTTP.CR;
        }

        public byte dirTypeBackward() {
            char r100 = this.text.charAt(this.charIndex - 1);
            this.lastChar = r100;
            if (Character.isLowSurrogate(r100) == false) goto L6;
            int r101 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(r101);
            return Character.getDirectionality(r101);
        L6:
            this.charIndex--;
            byte r102 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r103 = this.lastChar;
            if (r103 != '>') goto L12;
            return skipTagBackward();
        L12:
            if (r103 == ';') goto L14;
            return r102;
        L14:
            return skipEntityBackward();
        L15:
            return r102;
        }

        public byte dirTypeForward() {
            char r100 = this.text.charAt(this.charIndex);
            this.lastChar = r100;
            if (Character.isHighSurrogate(r100) == false) goto L6;
            int r101 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(r101);
            return Character.getDirectionality(r101);
        L6:
            this.charIndex++;
            byte r102 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r103 = this.lastChar;
            if (r103 != '<') goto L12;
            return skipTagForward();
        L12:
            if (r103 == '&') goto L14;
            return r102;
        L14:
            return skipEntityForward();
        L15:
            return r102;
        }

        public int getExitDir() {
            this.charIndex = this.length;
            int r100 = 0;
            int r101 = 0;
        L4:
            if (this.charIndex <= 0) goto L30;
            byte r102 = dirTypeBackward();
            if (r102 != 0) goto L8;
            if (r100 == 0) goto L27;
            if (r101 != 0) goto L4;
        L29:
            r101 = r100;
            goto L4
        L27:
            return -1;
        L8:
            if (r102 == 1) goto L22;
            if (r102 == 2) goto L22;
            if (r102 == 9) goto L4;
            switch(r102) {
                case 14: goto L19;
                case 15: goto L19;
                case 16: goto L17;
                case 17: goto L17;
                case 18: goto L16;
                default: goto L14;
            };
        L16:
            r100 = r100 + 1;
            goto L4
        L17:
            if (r101 == r100) goto L18;
        L21:
            r100 = r100 - 1;
            goto L4
        L18:
            return 1;
        L19:
            if (r101 != r100) goto L21;
            return -1;
        L14:
            if (r101 != 0) goto L4;
        L22:
            if (r100 == 0) goto L23;
            if (r101 != 0) goto L4;
        L23:
            return 1;
        L30:
            return 0;
        }

        private static byte getCachedDirectionality(char r100) {
            if (r100 >= 1792) goto L6;
            return DIR_TYPE_CACHE[r100];
        L6:
            return Character.getDirectionality(r100);
        }

        public DirectionalityEstimator(CharSequence r100, boolean r101) {
            this.text = r100;
            this.isHtml = r101;
            this.length = r100.length();
        }
    }

    static {
        TextDirectionHeuristicCompat r100 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = r100;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, r100);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, r100);
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public boolean getStereoReset() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    private static int getEntryDir(CharSequence r100) {
        return new DirectionalityEstimator(r100, false).getEntryDir();
    }

    private static int getExitDir(CharSequence r100) {
        return new DirectionalityEstimator(r100, false).getExitDir();
    }

    public static BidiFormatter getInstance(Locale r100) {
        return new Builder(r100).build();
    }

    public static boolean isRtlLocale(Locale r100) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(r100) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isRtl(CharSequence r100) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(r100, 0, r100.length());
    }

    public CharSequence unicodeWrap(CharSequence r100) {
        return unicodeWrap(r100, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public static BidiFormatter getInstance(boolean r100) {
        return new Builder(r100).build();
    }

    public boolean isRtl(String r100) {
        return isRtl(r100);
    }

    public String unicodeWrap(String r100) {
        return unicodeWrap(r100, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    private String markAfter(CharSequence r100, TextDirectionHeuristicCompat r101) {
        boolean r102 = r101.isRtl(r100, 0, r100.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r102 == true) goto L8;
        if (getExitDir(r100) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r102 == false) goto L15;
        if (getExitDir(r100) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    private String markBefore(CharSequence r100, TextDirectionHeuristicCompat r101) {
        boolean r102 = r101.isRtl(r100, 0, r100.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r102 == true) goto L8;
        if (getEntryDir(r100) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r102 == false) goto L15;
        if (getEntryDir(r100) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    public CharSequence unicodeWrap(CharSequence r100, boolean r101) {
        return unicodeWrap(r100, this.mDefaultTextDirectionHeuristicCompat, r101);
    }

    public String unicodeWrap(String r100, boolean r101) {
        return unicodeWrap(r100, this.mDefaultTextDirectionHeuristicCompat, r101);
    }

    public CharSequence unicodeWrap(CharSequence r100, TextDirectionHeuristicCompat r101) {
        return unicodeWrap(r100, r101, true);
    }

    public String unicodeWrap(String r100, TextDirectionHeuristicCompat r101) {
        return unicodeWrap(r100, r101, true);
    }

    public BidiFormatter(boolean r100, int r101, TextDirectionHeuristicCompat r102) {
        this.mIsRtlContext = r100;
        this.mFlags = r101;
        this.mDefaultTextDirectionHeuristicCompat = r102;
    }

    public CharSequence unicodeWrap(CharSequence r100, TextDirectionHeuristicCompat r101, boolean r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        boolean r103 = r101.isRtl(r100, 0, r100.length());
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        if (getStereoReset() == false) goto L13;
        if (r102 == false) goto L13;
        if (r103 == false) goto L10;
        TextDirectionHeuristicCompat r105 = TextDirectionHeuristicsCompat.RTL;
    L11:
        r104.append(markBefore(r100, r105));
        goto L13
    L10:
        r105 = TextDirectionHeuristicsCompat.LTR;
    L13:
        if (r103 == this.mIsRtlContext) goto L18;
        if (r103 == false) goto L16;
        char r106 = RLE;
    L17:
        r104.append(r106);
        r104.append(r100);
        r104.append(PDF);
    L19:
        if (r102 == false) goto L24;
        if (r103 == false) goto L22;
        TextDirectionHeuristicCompat r107 = TextDirectionHeuristicsCompat.RTL;
    L23:
        r104.append(markAfter(r100, r107));
        goto L24
    L22:
        r107 = TextDirectionHeuristicsCompat.LTR;
    L24:
        return r104;
    L16:
        r106 = LRE;
        goto L17
    L18:
        r104.append(r100);
        goto L19
    }

    public String unicodeWrap(String r100, TextDirectionHeuristicCompat r101, boolean r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return unicodeWrap(r100, r101, r102).toString();
    }
}
