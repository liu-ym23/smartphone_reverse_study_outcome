package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ColorStateList getButtonTintList(CompoundButton r100) {
            return r100.getButtonTintList();
        }

        public static PorterDuff.Mode getButtonTintMode(CompoundButton r100) {
            return r100.getButtonTintMode();
        }

        public static void setButtonTintList(CompoundButton r100, ColorStateList r101) {
            r100.setButtonTintList(r101);
        }

        public static void setButtonTintMode(CompoundButton r100, PorterDuff.Mode r101) {
            r100.setButtonTintMode(r101);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Drawable getButtonDrawable(CompoundButton r100) {
            return r100.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    public static Drawable getButtonDrawable(CompoundButton r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getButtonDrawable(r100);
    L7:
        if (sButtonDrawableFieldFetched == false) goto L18;
    L11:
        Field r101 = sButtonDrawableField;
        if (r101 != null) goto L20;
    L16:
        return null;
    L20:
        return (Drawable) r101.get(r100);
    L15:
        sButtonDrawableField = null;
        goto L16
    L18:
        Field r102 = CompoundButton.class.getDeclaredField("mButtonDrawable");     // Catch: NoSuchFieldException -> L17
        sButtonDrawableField = r102;     // Catch: NoSuchFieldException -> L17
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sButtonDrawableFieldFetched = true;
        goto L11
    }

    public static ColorStateList getButtonTintList(CompoundButton r100) {
        return Api21Impl.getButtonTintList(r100);
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton r100) {
        return Api21Impl.getButtonTintMode(r100);
    }

    public static void setButtonTintList(CompoundButton r100, ColorStateList r101) {
        Api21Impl.setButtonTintList(r100, r101);
    }

    public static void setButtonTintMode(CompoundButton r100, PorterDuff.Mode r101) {
        Api21Impl.setButtonTintMode(r100, r101);
    }
}
