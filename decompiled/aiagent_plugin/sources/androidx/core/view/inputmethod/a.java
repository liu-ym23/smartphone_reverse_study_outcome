package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EditorInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f1510a = null;

    /* JADX INFO: renamed from: androidx.core.view.inputmethod.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EditorInfoCompat.java */
    private static class C0041a {
        static void a(EditorInfo r2, CharSequence r3, int r4) {
            r2.setInitialSurroundingSubText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
        }
    }

    private static boolean a(int r1) {
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
        f1510a = new String[0];
    }

    public static void a(EditorInfo r2, String[] r3) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        r2.contentMimeTypes = r3;
        return;
    L6:
        if (r2.extras != null) goto L8;
        r2.extras = new Bundle();
    L8:
        r2.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", r3);
        r2.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", r3);
    }

    public static String[] a(EditorInfo r2) {
        if (Build.VERSION.SDK_INT < 25) goto L10;
        String[] r3 = r2.contentMimeTypes;
        if (r3 == null) goto L8;
        return r3;
    L8:
        return f1510a;
    L10:
        if (r2.extras == null) goto L12;
        String[] r0 = r2.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (r0 != null) goto L16;
        r0 = r2.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    L16:
        if (r0 == null) goto L19;
        return r0;
    L19:
        return f1510a;
    L12:
        return f1510a;
    }

    public static void a(EditorInfo r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        C0041a.a(r3, r5, 0);
        return;
    L5:
        a(r3, r5, 0);
    }

    public static void a(EditorInfo r5, CharSequence r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        g.a(r8);
        if (Build.VERSION.SDK_INT < 30) goto L7;
        C0041a.a(r5, r8, r7);
        return;
    L7:
        if (r5.initialSelStart <= r5.initialSelEnd) goto L9;
        int r0 = r5.initialSelEnd;
    L10:
        int r1 = r0 - r7;
        if (r5.initialSelStart <= r5.initialSelEnd) goto L13;
        int r2 = r5.initialSelStart;
    L14:
        int r3 = r2 - r7;
        int r4 = r8.length();
        if (r7 < 0) goto L29;
        if (r1 < 0) goto L29;
        if (r3 > r4) goto L29;
        if (a(r5.inputType) == false) goto L24;
        b(r5, null, 0, 0);
        return;
    L24:
        if (r4 > 2048) goto L27;
        b(r5, r8, r1, r3);
        return;
    L27:
        a(r5, r8, r1, r3);
        return;
    L29:
        b(r5, null, 0, 0);
        return;
    L13:
        r2 = r5.initialSelEnd;
        goto L14
    L9:
        r0 = r5.initialSelStart;
        goto L10
    }

    private static void a(EditorInfo r9, CharSequence r10, int r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = r12 - r11;
        if (r0 <= 1024) goto L5;
        int r2 = 0;
    L6:
        int r4 = 2048 - r2;
        int r3 = Math.min(r13.length() - r12, r4 - Math.min(r11, (int) (((double) r4) * 0.8d)));
        int r5 = Math.min(r11, r4 - r3);
        int r14 = r11 - r5;
        if (a(r13, r14, 0) == false) goto L10;
        r14 = r14 + 1;
        r5 = r5 - 1;
    L10:
        if (a(r13, (r12 + r3) - 1, 1) == false) goto L12;
        r3 = r3 - 1;
    L12:
        int r6 = (r5 + r2) + r3;
        if (r2 == r0) goto L15;
        CharSequence r15 = TextUtils.concat(new CharSequence[]{r13.subSequence(r14, r14 + r5), r13.subSequence(r12, r3 + r12)});
    L16:
        int r7 = r5 + 0;
        b(r9, r15, r7, r2 + r7);
        return;
    L15:
        r15 = r13.subSequence(r14, r6 + r14);
        goto L16
    L5:
        r2 = r0;
        goto L6
    }

    private static boolean a(CharSequence r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 == 0) goto L11;
        if (r4 == 1) goto L9;
        return false;
    L9:
        return Character.isHighSurrogate(r5.charAt(r3));
    L11:
        return Character.isLowSurrogate(r5.charAt(r3));
    }

    private static void b(EditorInfo r2, CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2.extras != null) goto L5;
        r2.extras = new Bundle();
    L5:
        if (r6 == null) goto L7;
        SpannableStringBuilder r0 = new SpannableStringBuilder(r6);
    L8:
        r2.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", r0);
        r2.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", r4);
        r2.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", r5);
        return;
    L7:
        r0 = null;
        goto L8
    }
}
