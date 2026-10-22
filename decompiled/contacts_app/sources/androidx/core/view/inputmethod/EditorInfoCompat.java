package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
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

    private static class Api30Impl {
        private Api30Impl() {
        }

        static void setInitialSurroundingSubText(EditorInfo r0, CharSequence r1, int r2) {
            r0.setInitialSurroundingSubText(r1, r2);
        }

        static CharSequence getInitialTextBeforeCursor(EditorInfo r0, int r1, int r2) {
            return r0.getInitialTextBeforeCursor(r1, r2);
        }

        static CharSequence getInitialSelectedText(EditorInfo r0, int r1) {
            return r0.getInitialSelectedText(r1);
        }

        static CharSequence getInitialTextAfterCursor(EditorInfo r0, int r1, int r2) {
            return r0.getInitialTextAfterCursor(r1, r2);
        }
    }

    static int getProtocol(EditorInfo r0) {
        return 1;
    }

    private static boolean isPasswordInputType(int r1) {
        int r2 = r1 & 4095;
        if (r2 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 225) goto L10;
        if (r2 == 18) goto L10;
        return false;
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static void setContentMimeTypes(EditorInfo r0, String[] r1) {
        r0.contentMimeTypes = r1;
    }

    public static String[] getContentMimeTypes(EditorInfo r0) {
        String[] r1 = r0.contentMimeTypes;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return EMPTY_STRING_ARRAY;
    }

    public static void setInitialSurroundingText(EditorInfo r1, CharSequence r2) {
        Api30Impl.setInitialSurroundingSubText(r1, r2, 0);
    }

    public static void setInitialSurroundingSubText(EditorInfo r0, CharSequence r1, int r2) {
        Preconditions.checkNotNull(r1);
        Api30Impl.setInitialSurroundingSubText(r0, r1, r2);
    }

    private static void trimLongSurroundingText(EditorInfo r9, CharSequence r10, int r11, int r12) {
        int r0 = r12 - r11;
        if (r0 <= 1024) goto L5;
        int r1 = 0;
    L6:
        int r4 = 2048 - r1;
        int r3 = Math.min(r10.length() - r12, r4 - Math.min(r11, (int) (((double) r4) * 0.8d)));
        int r5 = Math.min(r11, r4 - r3);
        int r13 = r11 - r5;
        if (isCutOnSurrogate(r10, r13, 0) == false) goto L10;
        r13 = r13 + 1;
        r5 = r5 - 1;
    L10:
        if (isCutOnSurrogate(r10, (r12 + r3) - 1, 1) == false) goto L12;
        r3 = r3 - 1;
    L12:
        int r6 = (r5 + r1) + r3;
        if (r1 == r0) goto L15;
        CharSequence r14 = TextUtils.concat(new CharSequence[]{r10.subSequence(r13, r13 + r5), r10.subSequence(r12, r3 + r12)});
    L16:
        int r7 = r5 + 0;
        setSurroundingText(r9, r14, r7, r1 + r7);
        return;
    L15:
        r14 = r10.subSequence(r13, r6 + r13);
        goto L16
    L5:
        r1 = r0;
        goto L6
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo r0, int r1, int r2) {
        return Api30Impl.getInitialTextBeforeCursor(r0, r1, r2);
    }

    public static CharSequence getInitialSelectedText(EditorInfo r0, int r1) {
        return Api30Impl.getInitialSelectedText(r0, r1);
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo r0, int r1, int r2) {
        return Api30Impl.getInitialTextAfterCursor(r0, r1, r2);
    }

    private static boolean isCutOnSurrogate(CharSequence r1, int r2, int r3) {
        if (r3 == 0) goto L10;
        if (r3 == 1) goto L8;
        return false;
    L8:
        return Character.isHighSurrogate(r1.charAt(r2));
    L10:
        return Character.isLowSurrogate(r1.charAt(r2));
    }

    private static void setSurroundingText(EditorInfo r2, CharSequence r3, int r4, int r5) {
        if (r2.extras != null) goto L5;
        r2.extras = new Bundle();
    L5:
        if (r3 == null) goto L7;
        SpannableStringBuilder r0 = new SpannableStringBuilder(r3);
    L8:
        r2.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, r0);
        r2.extras.putInt(CONTENT_SELECTION_HEAD_KEY, r4);
        r2.extras.putInt(CONTENT_SELECTION_END_KEY, r5);
        return;
    L7:
        r0 = null;
        goto L8
    }

    @Deprecated
    public EditorInfoCompat() {
    }
}
