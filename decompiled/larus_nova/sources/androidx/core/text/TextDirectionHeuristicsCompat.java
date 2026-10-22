package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = null;
    public static final TextDirectionHeuristicCompat LOCALE = null;
    public static final TextDirectionHeuristicCompat LTR = null;
    public static final TextDirectionHeuristicCompat RTL = null;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    public static class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong INSTANCE_RTL = null;
        private final boolean mLookForRtl;

        static {
            INSTANCE_RTL = new AnyStrong(true);
        }

        private AnyStrong(boolean r100) {
            this.mLookForRtl = r100;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r100, int r101, int r102) {
            int r103 = r102 + r101;
            boolean r104 = false;
        L3:
            if (r101 >= r103) goto L16;
            int r105 = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(r100.charAt(r101)));
            if (r105 == 0) goto L12;
            if (r105 != 1) goto L15;
            if (this.mLookForRtl == false) goto L10;
        L14:
            r104 = true;
            goto L15
        L10:
            return 1;
        L15:
            r101 = r101 + 1;
            goto L3
        L12:
            if (this.mLookForRtl == false) goto L14;
            return 0;
        L16:
            if (r104 == true) goto L18;
            return 2;
        L18:
            return this.mLookForRtl ? 1 : 0;
        }
    }

    public static class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong INSTANCE = null;

        static {
            INSTANCE = new FirstStrong();
        }

        private FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r100, int r101, int r102) {
            int r103 = r102 + r101;
            int r104 = 2;
        L3:
            if (r101 >= r103) goto L6;
            if (r104 != 2) goto L6;
            r104 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(r100.charAt(r101)));
            r101 = r101 + 1;
        L6:
            return r104;
        }
    }

    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence r100, int r101, int r102);
    }

    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        public abstract boolean defaultIsRtl();

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm r100) {
            this.mAlgorithm = r100;
        }

        private boolean doCheck(CharSequence r100, int r101, int r102) {
            int r103 = this.mAlgorithm.checkRtl(r100, r101, r102);
            if (r103 == 0) goto L9;
            if (r103 != 1) goto L6;
            return false;
        L6:
            return defaultIsRtl();
        L9:
            return true;
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence r100, int r101, int r102) {
            if (r100 == null) goto L14;
            if (r101 < 0) goto L14;
            if (r102 < 0) goto L14;
            if ((r100.length() - r102) < r101) goto L14;
            if (this.mAlgorithm != null) goto L12;
            return defaultIsRtl();
        L12:
            return doCheck(r100, r101, r102);
        L14:
            throw new IllegalArgumentException();
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] r100, int r101, int r102) {
            return isRtl(CharBuffer.wrap(r100), r101, r102);
        }
    }

    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }

        public TextDirectionHeuristicInternal(TextDirectionAlgorithm r100, boolean r101) {
            super(r100);
            this.mDefaultIsRtl = r101;
        }
    }

    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale INSTANCE = null;

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        static {
            INSTANCE = new TextDirectionHeuristicLocale();
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    private TextDirectionHeuristicsCompat() {
    }

    public static int isRtlText(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L6;
        return 0;
    L6:
        if (r100 == 2) goto L11;
        return 2;
    L11:
        return 0;
    L10:
        return 1;
    }

    public static int isRtlTextOrFormat(int r100) {
        if (r100 == 0) goto L11;
        if (r100 != 1) goto L6;
        return 0;
    L6:
        if (r100 == 2) goto L12;
        switch(r100) {
            case 14: goto L11;
            case 15: goto L11;
            case 16: goto L13;
            case 17: goto L13;
            default: goto L8;
        };
    L8:
        return 2;
    L13:
        return 0;
    L12:
        return 0;
    L11:
        return 1;
    }

    static {
        LTR = new TextDirectionHeuristicInternal(null, false);
        RTL = new TextDirectionHeuristicInternal(null, true);
        FirstStrong r100 = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(r100, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(r100, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }
}
