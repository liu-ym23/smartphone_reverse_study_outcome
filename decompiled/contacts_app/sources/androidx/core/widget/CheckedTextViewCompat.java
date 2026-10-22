package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        private Api14Impl() {
        }

        static Drawable getCheckMarkDrawable(CheckedTextView r4) {
            if (sResolved == false) goto L17;
        L10:
            Field r0 = sCheckMarkDrawableField;
            if (r0 != null) goto L19;
        L16:
            return null;
        L19:
            return (Drawable) r0.get(r4);
        L14:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e);
            sCheckMarkDrawableField = null;
            goto L16
        L17:
            Field r2 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");     // Catch: NoSuchFieldException -> L7
            sCheckMarkDrawableField = r2;     // Catch: NoSuchFieldException -> L7
            r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        L9:
            sResolved = true;
        L7:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
            goto L9
        }
    }

    private static class Api16Impl {
        private Api16Impl() {
        }

        static Drawable getCheckMarkDrawable(CheckedTextView r0) {
            return r0.getCheckMarkDrawable();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void setCheckMarkTintList(CheckedTextView r0, ColorStateList r1) {
            r0.setCheckMarkTintList(r1);
        }

        static ColorStateList getCheckMarkTintList(CheckedTextView r0) {
            return r0.getCheckMarkTintList();
        }

        static void setCheckMarkTintMode(CheckedTextView r0, PorterDuff.Mode r1) {
            r0.setCheckMarkTintMode(r1);
        }

        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView r0) {
            return r0.getCheckMarkTintMode();
        }
    }

    private CheckedTextViewCompat() {
    }

    public static void setCheckMarkTintList(CheckedTextView r0, ColorStateList r1) {
        Api21Impl.setCheckMarkTintList(r0, r1);
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView r0) {
        return Api21Impl.getCheckMarkTintList(r0);
    }

    public static void setCheckMarkTintMode(CheckedTextView r0, PorterDuff.Mode r1) {
        Api21Impl.setCheckMarkTintMode(r0, r1);
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView r0) {
        return Api21Impl.getCheckMarkTintMode(r0);
    }

    public static Drawable getCheckMarkDrawable(CheckedTextView r0) {
        return Api16Impl.getCheckMarkDrawable(r0);
    }
}
