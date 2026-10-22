package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList getImageTintList(ImageView r0) {
            return r0.getImageTintList();
        }

        static void setImageTintList(ImageView r0, ColorStateList r1) {
            r0.setImageTintList(r1);
        }

        static PorterDuff.Mode getImageTintMode(ImageView r0) {
            return r0.getImageTintMode();
        }

        static void setImageTintMode(ImageView r0, PorterDuff.Mode r1) {
            r0.setImageTintMode(r1);
        }
    }

    public static ColorStateList getImageTintList(ImageView r0) {
        return Api21Impl.getImageTintList(r0);
    }

    public static void setImageTintList(ImageView r0, ColorStateList r1) {
        Api21Impl.setImageTintList(r0, r1);
    }

    public static PorterDuff.Mode getImageTintMode(ImageView r0) {
        return Api21Impl.getImageTintMode(r0);
    }

    public static void setImageTintMode(ImageView r0, PorterDuff.Mode r1) {
        Api21Impl.setImageTintMode(r0, r1);
    }

    private ImageViewCompat() {
    }
}
