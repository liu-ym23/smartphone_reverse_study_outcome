package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static List<Rect> getBoundingRects(DisplayCutout r100) {
            return r100.getBoundingRects();
        }

        public static int getSafeInsetBottom(DisplayCutout r100) {
            return r100.getSafeInsetBottom();
        }

        public static int getSafeInsetLeft(DisplayCutout r100) {
            return r100.getSafeInsetLeft();
        }

        public static int getSafeInsetRight(DisplayCutout r100) {
            return r100.getSafeInsetRight();
        }

        public static int getSafeInsetTop(DisplayCutout r100) {
            return r100.getSafeInsetTop();
        }

        public static DisplayCutout createDisplayCutout(Rect r100, List<Rect> r101) {
            return new DisplayCutout(r100, r101);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static DisplayCutout createDisplayCutout(Insets r100, Rect r101, Rect r102, Rect r110, Rect r111) {
            return new DisplayCutout(r100, r101, r102, r110, r111);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static Insets getWaterfallInsets(DisplayCutout r100) {
            return r100.getWaterfallInsets();
        }

        public static DisplayCutout createDisplayCutout(Insets r100, Rect r101, Rect r110, Rect r111, Rect r112, Insets r113) {
            return new DisplayCutout(r100, r101, r110, r111, r112, r113);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static Path getCutoutPath(DisplayCutout r100) {
            return r100.getCutoutPath();
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static DisplayCutout createDisplayCutout(Insets r100, Rect r101, Rect r102, Rect r103, Rect r104, Insets r105, Path r106) {
            return new DisplayCutout.Builder().setSafeInsets(r100).setBoundingRectLeft(r101).setBoundingRectTop(r102).setBoundingRectRight(r103).setBoundingRectBottom(r104).setWaterfallInsets(r105).setCutoutPath(r106).build();
        }
    }

    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getBoundingRects(this.mDisplayCutout);
    L7:
        return Collections.emptyList();
    }

    public Path getCutoutPath() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return null;
    L5:
        return Api31Impl.getCutoutPath(this.mDisplayCutout);
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
    L7:
        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        DisplayCutout r100 = this.mDisplayCutout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + com.alipay.sdk.m.u.i.f25855d;
    }

    public DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }

    private DisplayCutoutCompat(DisplayCutout r100) {
        this.mDisplayCutout = r100;
    }

    public static DisplayCutoutCompat wrap(DisplayCutout r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (DisplayCutoutCompat.class == r100.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) r100).mDisplayCutout);
    }

    public DisplayCutoutCompat(Rect r100, List<Rect> r101) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        DisplayCutout r102 = Api28Impl.createDisplayCutout(r100, r101);
    L6:
        this(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets r100, Rect r101, Rect r110, Rect r111, Rect r112, androidx.core.graphics.Insets r113) {
        this(constructDisplayCutout(r100, r101, r110, r111, r112, r113, null));
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets r100, Rect r101, Rect r102, Rect r103, Rect r104, androidx.core.graphics.Insets r105, Path r106) {
        this(constructDisplayCutout(r100, r101, r102, r103, r104, r105, r106));
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets r100, Rect r110, Rect r111, Rect r112, Rect r113, androidx.core.graphics.Insets r114, Path r115) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 33) goto L7;
        return Api33Impl.createDisplayCutout(r100.toPlatformInsets(), r110, r111, r112, r113, r114.toPlatformInsets(), r115);
    L7:
        if (r101 < 30) goto L11;
        return Api30Impl.createDisplayCutout(r100.toPlatformInsets(), r110, r111, r112, r113, r114.toPlatformInsets());
    L11:
        if (r101 < 29) goto L15;
        return Api29Impl.createDisplayCutout(r100.toPlatformInsets(), r110, r111, r112, r113);
    L15:
        if (r101 < 28) goto L27;
        Rect r116 = new Rect(r100.left, r100.top, r100.right, r100.bottom);
        ArrayList r102 = new ArrayList();
        if (r110 == null) goto L19;
        r102.add(r110);
    L19:
        if (r111 == null) goto L21;
        r102.add(r111);
    L21:
        if (r112 == null) goto L23;
        r102.add(r112);
    L23:
        if (r113 == null) goto L26;
        r102.add(r113);
    L26:
        return Api28Impl.createDisplayCutout(r116, r102);
    L27:
        return null;
    }
}
