package android.content.res.stepostheme;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class StepOSAdaptiveIconExtImpl implements IStepOSAdaptiveIconExt {
    private static final float STANDARD_RECTANGLE_MASK_RADIUS = 47.1f;
    private static final int STANDARD_RECT_SIZE = 216;
    private static final String TAG = "StepOSAdaptiveIconExtImpl";
    private int mSavedNightModeState = 0;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getCustomMaskPathData(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = r2.isAppUsingTheme()
            if (r0 == 0) goto L7
            return r3
        L7:
            java.lang.String r0 = r2.getCornerSize()
            if (r0 == 0) goto L57
            java.lang.String r1 = "corner_size_1"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L16
            goto L57
        L16:
            int r1 = r0.hashCode()
            switch(r1) {
                case 84680862: goto L3c;
                case 84680863: goto L32;
                case 84680864: goto L28;
                case 84680865: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L46
        L1e:
            java.lang.String r1 = "corner_size_5"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L1d
            r1 = 3
            goto L47
        L28:
            java.lang.String r1 = "corner_size_4"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L1d
            r1 = 2
            goto L47
        L32:
            java.lang.String r1 = "corner_size_3"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L1d
            r1 = 1
            goto L47
        L3c:
            java.lang.String r1 = "corner_size_2"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L1d
            r1 = 0
            goto L47
        L46:
            r1 = -1
        L47:
            switch(r1) {
                case 0: goto L54;
                case 1: goto L51;
                case 2: goto L4e;
                case 3: goto L4b;
                default: goto L4a;
            }
        L4a:
            return r3
        L4b:
            java.lang.String r1 = "config_icon_mask5"
            return r1
        L4e:
            java.lang.String r1 = "config_icon_mask4"
            return r1
        L51:
            java.lang.String r1 = "config_icon_mask3"
            return r1
        L54:
            java.lang.String r1 = "config_icon_mask2"
            return r1
        L57:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.res.stepostheme.StepOSAdaptiveIconExtImpl.getCustomMaskPathData(java.lang.String):java.lang.String");
    }

    public void initCanvas(Canvas canvas) {
    }

    public void onAddLayer(Drawable drawable) {
        Bitmap bitmap;
        if (!isColorManagementEnabled() && isWideColorGamut(drawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.setColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        }
    }

    public void beforeDraw(Canvas canvas, Bitmap layersBitmap, Drawable bgDrawable, Drawable fgDrawable) {
        ColorSpace colorSpace;
        this.mSavedNightModeState = 0;
        if (isColorManagementEnabled() && layersBitmap != null) {
            boolean isWideGamut = isWideColorGamut(bgDrawable) || isWideColorGamut(fgDrawable);
            if (isWideGamut) {
                colorSpace = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
            } else {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            layersBitmap.setColorSpace(colorSpace);
        }
    }

    public void afterDraw(Canvas canvas) {
    }

    public boolean isAppUsingTheme() {
        IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
        if (themeUtils != null) {
            return themeUtils.isAppUsingTheme("icons");
        }
        return false;
    }

    public String getCornerSize() {
        IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
        if (themeUtils != null) {
            return themeUtils.getCornerSize();
        }
        return "corner_size_3";
    }

    public boolean isColorManagementEnabled() {
        IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
        if (themeUtils != null) {
            return themeUtils.isColorManagementEnabled();
        }
        return false;
    }

    public float getStandardRadiusScale() {
        return 0.21805555f;
    }

    private boolean isWideColorGamut(Drawable drawable) {
        Bitmap bitmap;
        return (drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.getColorSpace() == null || bitmap.getColorSpace().getDataSpace() != 143261696) ? false : true;
    }
}
