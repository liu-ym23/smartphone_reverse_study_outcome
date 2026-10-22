package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ImageViewCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ColorStateList getImageTintList(ImageView r100) {
            return r100.getImageTintList();
        }

        public static PorterDuff.Mode getImageTintMode(ImageView r100) {
            return r100.getImageTintMode();
        }

        public static void setImageTintList(ImageView r100, ColorStateList r101) {
            r100.setImageTintList(r101);
        }

        public static void setImageTintMode(ImageView r100, PorterDuff.Mode r101) {
            r100.setImageTintMode(r101);
        }
    }

    private ImageViewCompat() {
    }

    public static ColorStateList getImageTintList(ImageView r100) {
        return Api21Impl.getImageTintList(r100);
    }

    public static PorterDuff.Mode getImageTintMode(ImageView r100) {
        return Api21Impl.getImageTintMode(r100);
    }

    public static void setImageTintList(ImageView r100, ColorStateList r101) {
        int r102 = Build.VERSION.SDK_INT;
        Api21Impl.setImageTintList(r100, r101);
        if (r102 != 21) goto L13;
        Drawable r103 = r100.getDrawable();
        if (r103 != null) goto L7;
        return;
    L7:
        if (Api21Impl.getImageTintList(r100) != null) goto L9;
        return;
    L9:
        if (r103.isStateful() == false) goto L11;
        r103.setState(r100.getDrawableState());
    L11:
        r100.setImageDrawable(r103);
        return;
    }

    public static void setImageTintMode(ImageView r100, PorterDuff.Mode r101) {
        int r102 = Build.VERSION.SDK_INT;
        Api21Impl.setImageTintMode(r100, r101);
        if (r102 != 21) goto L13;
        Drawable r103 = r100.getDrawable();
        if (r103 != null) goto L7;
        return;
    L7:
        if (Api21Impl.getImageTintList(r100) != null) goto L9;
        return;
    L9:
        if (r103.isStateful() == false) goto L11;
        r103.setState(r100.getDrawableState());
    L11:
        r100.setImageDrawable(r103);
        return;
    }
}
