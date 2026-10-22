package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;

/* JADX INFO: loaded from: classes17.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static CharSequence getInitialSelectedText(EditorInfo r100, int r101) {
            return r100.getInitialSelectedText(r101);
        }

        public static CharSequence getInitialTextAfterCursor(EditorInfo r100, int r101, int r102) {
            return r100.getInitialTextAfterCursor(r101, r102);
        }

        public static CharSequence getInitialTextBeforeCursor(EditorInfo r100, int r101, int r102) {
            return r100.getInitialTextBeforeCursor(r101, r102);
        }

        public static void setInitialSurroundingSubText(EditorInfo r100, CharSequence r101, int r102) {
            r100.setInitialSurroundingSubText(r101, r102);
        }
    }

    public static class Api35Impl {
        private Api35Impl() {
        }

        public static boolean isStylusHandwritingEnabled(EditorInfo r100) {
            return r100.isStylusHandwritingEnabled();
        }

        public static void setStylusHandwritingEnabled(EditorInfo r100, boolean r101) {
            r100.setStylusHandwritingEnabled(r101);
        }
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    private static boolean isPasswordInputType(int r100) {
        int r101 = r100 & UnixStat.PERM_MASK;
        if (r101 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r101 == 225) goto L10;
        if (r101 == 18) goto L10;
        return false;
    }

    public EditorInfoCompat() {
    }

    public static String[] getContentMimeTypes(EditorInfo r100) {
        if (Build.VERSION.SDK_INT < 25) goto L9;
        String[] r101 = r100.contentMimeTypes;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return EMPTY_STRING_ARRAY;
    L9:
        Bundle r102 = r100.extras;
        if (r102 == null) goto L12;
        String[] r103 = r102.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (r103 != null) goto L16;
        r103 = r100.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
    L16:
        if (r103 == null) goto L19;
        return r103;
    L19:
        return EMPTY_STRING_ARRAY;
    L12:
        return EMPTY_STRING_ARRAY;
    }

    public static int getProtocol(EditorInfo r100) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        return 1;
    L6:
        Bundle r101 = r100.extras;
        if (r101 != null) goto L9;
        return 0;
    L9:
        boolean r102 = r101.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean r103 = r100.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (r102 == false) goto L14;
        if (r103 == false) goto L14;
        return 4;
    L14:
        if (r102 == false) goto L17;
        return 3;
    L17:
        if (r103 == false) goto L20;
        return 2;
    L20:
        return 0;
    }

    public static boolean isStylusHandwritingEnabled(EditorInfo r100) {
        Bundle r101 = r100.extras;
        if (r101 == null) goto L9;
        if (r101.containsKey(STYLUS_HANDWRITING_ENABLED_KEY) == false) goto L9;
        return r100.extras.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
    L9:
        if (BuildCompat.isAtLeastV() == true) goto L11;
        return false;
    L11:
        return Api35Impl.isStylusHandwritingEnabled(r100);
    }

    public static CharSequence getInitialSelectedText(EditorInfo r100, int r101) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getInitialSelectedText(r100, r101);
    L7:
        if (r100.extras != null) goto L9;
        return null;
    L9:
        int r102 = Math.min(r100.initialSelStart, r100.initialSelEnd);
        int r103 = Math.max(r100.initialSelStart, r100.initialSelEnd);
        int r104 = r100.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r105 = r100.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r106 = r103 - r102;
        if (r100.initialSelStart >= 0) goto L12;
    L24:
        return null;
    L12:
        if (r100.initialSelEnd < 0) goto L24;
        if ((r105 - r104) != r106) goto L24;
        CharSequence r107 = r100.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r107 != null) goto L20;
        return null;
    L20:
        if ((r101 & 1) == 0) goto L23;
        return r107.subSequence(r104, r105);
    L23:
        return TextUtils.substring(r107, r104, r105);
    }

    public static void setContentMimeTypes(EditorInfo r100, String[] r101) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        r100.contentMimeTypes = r101;
        return;
    L6:
        if (r100.extras != null) goto L8;
        r100.extras = new Bundle();
    L8:
        r100.extras.putStringArray(CONTENT_MIME_TYPES_KEY, r101);
        r100.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, r101);
    }

    public static void setInitialSurroundingText(EditorInfo r100, CharSequence r101) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Api30Impl.setInitialSurroundingSubText(r100, r101, 0);
        return;
    L5:
        setInitialSurroundingSubText(r100, r101, 0);
    }

    public static void setStylusHandwritingEnabled(EditorInfo r100, boolean r101) {
        if (BuildCompat.isAtLeastV() == false) goto L6;
        Api35Impl.setStylusHandwritingEnabled(r100, r101);
    L6:
        if (r100.extras != null) goto L8;
        r100.extras = new Bundle();
    L8:
        r100.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, r101);
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo r100, int r101, int r102) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Bundle r103 = r100.extras;
        if (r103 != null) goto L9;
        return null;
    L9:
        CharSequence r104 = r103.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r104 != null) goto L12;
        return null;
    L12:
        int r105 = r100.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r106 = Math.min(r101, r104.length() - r105);
        if ((r102 & 1) == 0) goto L16;
        return r104.subSequence(r105, r106 + r105);
    L16:
        return TextUtils.substring(r104, r105, r106 + r105);
    L5:
        return Api30Impl.getInitialTextAfterCursor(r100, r101, r102);
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo r100, int r101, int r102) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Bundle r103 = r100.extras;
        if (r103 != null) goto L9;
        return null;
    L9:
        CharSequence r104 = r103.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r104 != null) goto L12;
        return null;
    L12:
        int r105 = r100.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r106 = Math.min(r101, r105);
        if ((r102 & 1) == 0) goto L16;
        return r104.subSequence(r105 - r106, r105);
    L16:
        return TextUtils.substring(r104, r105 - r106, r105);
    L5:
        return Api30Impl.getInitialTextBeforeCursor(r100, r101, r102);
    }

    private static boolean isCutOnSurrogate(CharSequence r100, int r101, int r102) {
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L8;
        return false;
    L8:
        return Character.isHighSurrogate(r100.charAt(r101));
    L10:
        return Character.isLowSurrogate(r100.charAt(r101));
    }

    public static void setInitialSurroundingSubText(EditorInfo r100, CharSequence r101, int r102) {
        Preconditions.checkNotNull(r101);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setInitialSurroundingSubText(r100, r101, r102);
        return;
    L6:
        int r103 = r100.initialSelStart;
        int r104 = r100.initialSelEnd;
        if (r103 <= r104) goto L9;
        int r105 = r104 - r102;
    L10:
        if (r103 <= r104) goto L12;
        int r106 = r103 - r102;
    L13:
        int r107 = r101.length();
        if (r102 < 0) goto L28;
        if (r105 < 0) goto L28;
        if (r106 > r107) goto L28;
        if (isPasswordInputType(r100.inputType) == false) goto L23;
        setSurroundingText(r100, null, 0, 0);
        return;
    L23:
        if (r107 > 2048) goto L26;
        setSurroundingText(r100, r101, r105, r106);
        return;
    L26:
        trimLongSurroundingText(r100, r101, r105, r106);
        return;
    L28:
        setSurroundingText(r100, null, 0, 0);
        return;
    L12:
        r106 = r104 - r102;
        goto L13
    L9:
        r105 = r103 - r102;
        goto L10
    }

    private static void setSurroundingText(EditorInfo r100, CharSequence r101, int r102, int r103) {
        if (r100.extras != null) goto L5;
        r100.extras = new Bundle();
    L5:
        if (r101 == null) goto L7;
        SpannableStringBuilder r104 = new SpannableStringBuilder(r101);
    L8:
        r100.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, r104);
        r100.extras.putInt(CONTENT_SELECTION_HEAD_KEY, r102);
        r100.extras.putInt(CONTENT_SELECTION_END_KEY, r103);
        return;
    L7:
        r104 = null;
        goto L8
    }

    private static void trimLongSurroundingText(EditorInfo r100, CharSequence r110, int r111, int r112) {
        int r101 = r112 - r111;
        if (r101 <= 1024) goto L5;
        int r102 = 0;
    L6:
        int r103 = 2048 - r102;
        int r104 = Math.min(r110.length() - r112, r103 - Math.min(r111, (int) (((double) r103) * 0.8d)));
        int r105 = Math.min(r111, r103 - r104);
        int r113 = r111 - r105;
        if (isCutOnSurrogate(r110, r113, 0) == false) goto L10;
        r113 = r113 + 1;
        r105 = r105 - 1;
    L10:
        if (isCutOnSurrogate(r110, (r112 + r104) - 1, 1) == false) goto L12;
        r104 = r104 - 1;
    L12:
        int r106 = (r105 + r102) + r104;
        if (r102 == r101) goto L15;
        CharSequence r114 = TextUtils.concat(new CharSequence[]{r110.subSequence(r113, r113 + r105), r110.subSequence(r112, r104 + r112)});
    L16:
        int r107 = r105 + 0;
        setSurroundingText(r100, r114, r107, r102 + r107);
        return;
    L15:
        r114 = r110.subSequence(r113, r106 + r113);
        goto L16
    L5:
        r102 = r101;
        goto L6
    }
}
