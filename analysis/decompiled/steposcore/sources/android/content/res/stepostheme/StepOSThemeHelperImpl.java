package android.content.res.stepostheme;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.BuildExt;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StepOSThemeHelperImpl implements IStepOSThemeHelperExt {
    private static final int CALENDAR_ICON_SIZE = 192;
    private static final float CIRCLE_THRESHOLD = 0.85f;
    private static final int DATE_TEXT_SIZE = 72;
    private static final int DAY_TEXT_SIZE = 24;
    public static final int SHAPE_FILLET = 3;
    public static final int SHAPE_ROUND = 1;
    public static final int SHAPE_SQUARE = 2;
    public static final int SHAPE_UNKNOWN = 0;
    private static final long SHOPDEMO_INIT_DELAY_MS = 7000;
    private static final float SQUARE_THRESHOLD = 0.9f;
    private static final String TAG = "StepOSThemeHelper";

    public void init() {
        if (BuildExt.isShopDemo()) {
            StepOSLogUtil.d("StepOSThemeHelperImpl init: SHOPDEMO mode, delay 7000ms");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: android.content.res.stepostheme.StepOSThemeHelperImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.performDelayedInit();
                }
            }, SHOPDEMO_INIT_DELAY_MS);
        } else {
            StepOSLogUtil.d("StepOSThemeHelperImpl init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performDelayedInit() {
        try {
            IStepOSConfigurationExt.get().incrementThemeVersion();
            StepOSLogUtil.d("StepOSThemeHelperImpl SHOPDEMO delayed init fired");
        } catch (Throwable t) {
            StepOSLogUtil.d("performDelayedInit skipped: " + t.getMessage());
        }
    }

    public void clean() {
        StepOSLogUtil.d("StepOSThemeHelperImpl clean");
    }

    public Drawable getCustomIcon(String packageName) throws IOException {
        if (packageName == null) {
            return null;
        }
        String iconName = packageName + ".png";
        InputStream is = null;
        int iconColor = IStepOSThemeUtilsExt.get().getIconColorStatic();
        if (iconColor == 2) {
            is = StepOSThemeResource.get3rdPartThemeIcon(packageName + "_night.png");
        }
        if (is == null) {
            is = StepOSThemeResource.get3rdPartThemeIcon(iconName);
        }
        if (is != null) {
            try {
                try {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        if (bitmap != null) {
                            return new BitmapDrawable(Resources.getSystem(), bitmap);
                        }
                        is.close();
                    } catch (Exception e) {
                        StepOSLogUtil.e("getCustomIcon error: " + e.getMessage());
                        is.close();
                    }
                } catch (Exception e2) {
                }
            } finally {
                try {
                    is.close();
                } catch (Exception e3) {
                }
            }
        }
        return null;
    }

    public Drawable getStepOSStyleIcon(String packageName) throws IOException {
        Bitmap bitmap;
        if (packageName == null) {
            return null;
        }
        Resources sysResources = Resources.getSystem();
        int iconColorAdaptive = IStepOSThemeUtilsExt.get().getIconColorStatic();
        String foregroundPath = packageName + "_fg.png";
        String backgroundPath = packageName + "_bg.png";
        AdaptiveIconDrawable adaptiveDr = null;
        if (iconColorAdaptive == 2) {
            adaptiveDr = getAdaptiveIconDrawableFromFile(sysResources, foregroundPath, backgroundPath, true, true);
        }
        if (adaptiveDr == null) {
            adaptiveDr = getAdaptiveIconDrawableFromFile(sysResources, foregroundPath, backgroundPath, true, false);
        }
        if (adaptiveDr != null) {
            return maybeScaleForeground(adaptiveDr);
        }
        String iconName = packageName + ".png";
        InputStream is = null;
        int iconColor = IStepOSThemeUtilsExt.get().getIconColorStatic();
        if (iconColor == 2 && (is = StepOSThemeResource.getStepOSStyleIconNight(packageName + ".png")) == null) {
            is = StepOSThemeResource.getCloudStepOSStyleIconNight(packageName + ".png");
        }
        if (is == null) {
            is = StepOSThemeResource.getStepOSStyleIcon(iconName);
        }
        if (is == null) {
            is = StepOSThemeResource.getCloudStepOSStyleIcon(iconName);
        }
        try {
            if (is != null) {
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(is);
                    } catch (Exception e) {
                        StepOSLogUtil.e("getStepOSStyleIcon error: " + e.getMessage());
                        is.close();
                    }
                    if (bitmap != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), bitmap);
                        try {
                            is.close();
                        } catch (Exception e2) {
                        }
                        return bitmapDrawable;
                    }
                    is.close();
                } catch (Throwable th) {
                    try {
                        is.close();
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
        }
        return null;
    }

    private Drawable maybeScaleForeground(AdaptiveIconDrawable adaptiveDr) {
        if (adaptiveDr == null) {
            return null;
        }
        if (!IStepOSThemeUtilsExt.get().isAppUsingTheme("icons") && StepOSThemeHelper.getStepOSIconSwitchState() == 1) {
            return StepOSThemeHelper.scaleForegroundForAdaptiveIconDrawable(adaptiveDr);
        }
        return adaptiveDr;
    }

    public Drawable getCalendarIcon() {
        return StepOSThemeHelper.getCalendarIcon();
    }

    public Drawable makeThemeIcon(Resources res, Drawable srcDrawable, ApplicationInfo appInfo) throws IOException {
        if (srcDrawable == null || res == null) {
            return srcDrawable;
        }
        if (appInfo != null && !IStepOSThemeUtilsExt.get().isInWhiteList(appInfo)) {
            return srcDrawable;
        }
        Drawable working = srcDrawable;
        if (appInfo != null) {
            Drawable customIcon = getCustomIcon(appInfo.packageName);
            if (customIcon != null) {
                working = customIcon;
            } else {
                Drawable steposIcon = getStepOSStyleIcon(appInfo.packageName);
                if (steposIcon != null) {
                    return steposIcon;
                }
            }
        }
        return makeStandardStyleIcon(appInfo != null ? appInfo.packageName : "", res, working);
    }

    public Drawable makeStandardStyleIcon(String name, Resources res, Drawable srcDrawable) {
        return StepOSThemeIconThemeDelegate.makeStandardStyleIcon(name, res, srcDrawable);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        if (width <= 0) {
            width = 1;
        }
        if (height <= 0) {
            height = 1;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    public boolean hasStandardStyleIcon(String name) throws IOException {
        if (name == null) {
            return false;
        }
        InputStream is = StepOSThemeResource.get3rdPartThemeIcon(name + ".png");
        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
            }
            return true;
        }
        InputStream is2 = StepOSThemeResource.getStepOSStyleIcon(name + ".png");
        if (is2 == null) {
            return false;
        }
        try {
            is2.close();
        } catch (Exception e2) {
        }
        return true;
    }

    public Bitmap cropTransparentSpace(Bitmap originBitmap, float scale) {
        Bitmap originBitmap2;
        Exception e;
        int width;
        int height;
        int minX;
        int minY;
        int maxX;
        int maxY;
        int[] pixels;
        if (originBitmap == null) {
            return null;
        }
        try {
            width = originBitmap.getWidth();
            height = originBitmap.getHeight();
            minX = width;
            minY = height;
            maxX = 0;
            maxY = 0;
            pixels = new int[width * height];
            originBitmap2 = originBitmap;
        } catch (Exception e2) {
            originBitmap2 = originBitmap;
            e = e2;
        }
        try {
            originBitmap2.getPixels(pixels, 0, width, 0, 0, width, height);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int alpha = Color.alpha(pixels[(y * width) + x]);
                    if (alpha > 10) {
                        minX = Math.min(minX, x);
                        minY = Math.min(minY, y);
                        maxX = Math.max(maxX, x);
                        maxY = Math.max(maxY, y);
                    }
                }
            }
            if (minX <= maxX && minY <= maxY) {
                int cropWidth = (maxX - minX) + 1;
                int cropHeight = (maxY - minY) + 1;
                Bitmap cropped = Bitmap.createBitmap(originBitmap2, minX, minY, cropWidth, cropHeight);
                if (scale != 1.0f && scale > 0.0f) {
                    int scaledWidth = (int) (cropWidth * scale);
                    int scaledHeight = (int) (cropHeight * scale);
                    if (scaledWidth > 0 && scaledHeight > 0) {
                        return Bitmap.createScaledBitmap(cropped, scaledWidth, scaledHeight, true);
                    }
                    return cropped;
                }
                return cropped;
            }
            return originBitmap2;
        } catch (Exception e3) {
            e = e3;
            StepOSLogUtil.e("cropTransparentSpace error: " + e.getMessage());
            return originBitmap2;
        }
    }

    public int getIconShape(Bitmap bitmap) {
        int i = 0;
        if (bitmap == null) {
            return 0;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (Math.abs(width - height) > Math.min(width, height) * 0.1d) {
                return 0;
            }
            int size = Math.min(width, height);
            int centerX = width / 2;
            int centerY = height / 2;
            int radius = size / 2;
            int totalPixels = 0;
            int circleMatchPixels = 0;
            int squareMatchPixels = 0;
            int[] pixels = new int[width * height];
            bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
            int y = 0;
            while (y < height) {
                int x = 0;
                while (x < width) {
                    int alpha = Color.alpha(pixels[(y * width) + x]);
                    int i2 = alpha > 128 ? 1 : i;
                    int dx = x - centerX;
                    int dy = y - centerY;
                    int i3 = i;
                    int i4 = (dx * dx) + (dy * dy) <= radius * radius ? 1 : i3;
                    int i5 = (x < 0 || x >= width || y < 0 || y >= height) ? i3 : 1;
                    if (i2 != 0) {
                        totalPixels++;
                        if (i4 != 0) {
                            circleMatchPixels++;
                        }
                        if (i5 != 0) {
                            squareMatchPixels++;
                        }
                    }
                    x++;
                    i = i3;
                }
                y++;
            }
            int i6 = i;
            if (totalPixels == 0) {
                return i6;
            }
            float circleRatio = circleMatchPixels / totalPixels;
            float squareRatio = squareMatchPixels / totalPixels;
            if (circleRatio >= CIRCLE_THRESHOLD) {
                return 1;
            }
            if (squareRatio >= SQUARE_THRESHOLD) {
                return 2;
            }
            if (circleRatio > 0.5f) {
                return 3;
            }
            return i6;
        } catch (Exception e) {
            int i7 = i;
            StepOSLogUtil.e("getIconShape error: " + e.getMessage());
            return i7;
        }
    }

    public boolean isThemeIconEnabled() {
        IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
        return themeUtils.isUseStepOSThemeStatic() || themeUtils.isUsingThemeStatic();
    }

    public int getIconColor() {
        return IStepOSThemeUtilsExt.get().getIconColorStatic();
    }

    public String getCornerSize() {
        return IStepOSThemeUtilsExt.get().getCornerSizeStatic();
    }

    public float getForegroundScale() {
        return IStepOSThemeUtilsExt.get().getForegroundScaleStatic();
    }

    public Bitmap getMaskIcon(String cornerSize) {
        return StepOSThemeResource.getMaskIcon(cornerSize);
    }

    public Bitmap getThemeIcon(String iconName) {
        return StepOSThemeResource.getThemeIcon(iconName);
    }

    public Bitmap getShortcutBackground() {
        return StepOSThemeResource.getShortcutBackground();
    }

    public Bitmap getDefaultActivityIcon() {
        return StepOSThemeResource.getDefaultActivityIcon();
    }

    public Drawable getPreviewIcon(Resources res, String themeName, String iconName) {
        return StepOSThemeResource.getPreviewIcon(res, themeName, iconName);
    }

    public Drawable getThemeIconForPackage(String packageName, ApplicationInfo appInfo) throws IOException {
        if (!isThemeIconEnabled()) {
            return null;
        }
        IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
        if (themeUtils != null && appInfo != null && !themeUtils.isInWhiteList(appInfo)) {
            return null;
        }
        Drawable customIcon = getCustomIcon(packageName);
        if (customIcon != null) {
            return customIcon;
        }
        return getStepOSStyleIcon(packageName);
    }

    public Drawable processIconDrawable(Drawable dr, ApplicationInfo appInfo, Resources res) {
        if (dr == null || res == null || !isThemeIconEnabled()) {
            return dr;
        }
        IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
        if (themeUtils != null && appInfo != null && !themeUtils.isInWhiteList(appInfo)) {
            return dr;
        }
        return makeThemeIcon(res, dr, appInfo);
    }

    private static AdaptiveIconDrawable getAdaptiveIconDrawableFromFile(Resources sysResources, String foregroundPath, String backgroundPath, boolean isStyleIcon, boolean isNight) throws IOException {
        InputStream foregroundIS = null;
        InputStream backgroundIS = null;
        try {
            try {
                if (isStyleIcon) {
                    foregroundIS = isNight ? StepOSThemeResource.getCloudStepOSStyleIconNight(foregroundPath) : StepOSThemeResource.getCloudStepOSStyleIcon(foregroundPath);
                    if (foregroundIS != null) {
                        backgroundIS = isNight ? StepOSThemeResource.getCloudStepOSStyleIconNight(backgroundPath) : StepOSThemeResource.getCloudStepOSStyleIcon(backgroundPath);
                    } else {
                        foregroundIS = isNight ? StepOSThemeResource.getStepOSStyleIconNight(foregroundPath) : StepOSThemeResource.getStepOSStyleIcon(foregroundPath);
                        backgroundIS = isNight ? StepOSThemeResource.getStepOSStyleIconNight(backgroundPath) : StepOSThemeResource.getStepOSStyleIcon(backgroundPath);
                    }
                } else {
                    foregroundIS = StepOSThemeResource.get3rdPartThemeIconExceptStepOSStyleIcon(foregroundPath);
                    backgroundIS = StepOSThemeResource.get3rdPartThemeIconExceptStepOSStyleIcon(backgroundPath);
                }
                if (foregroundIS == null) {
                    if (foregroundIS != null) {
                        try {
                            foregroundIS.close();
                        } catch (Exception e) {
                        }
                    }
                    if (backgroundIS != null) {
                        try {
                            backgroundIS.close();
                        } catch (Exception e2) {
                        }
                    }
                    return null;
                }
                if (backgroundIS == null) {
                    if (isStyleIcon) {
                        backgroundIS = isNight ? StepOSThemeResource.getStepOSStyleIconNight("background.png") : StepOSThemeResource.getStepOSStyleIcon("background.png");
                    } else {
                        backgroundIS = StepOSThemeResource.get3rdPartThemeIconExceptStepOSStyleIcon("background.png");
                    }
                }
                if (backgroundIS == null) {
                    if (foregroundIS != null) {
                        try {
                            foregroundIS.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (backgroundIS != null) {
                        try {
                            backgroundIS.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                }
                Bitmap fgBitmap = BitmapFactory.decodeStream(foregroundIS);
                if (fgBitmap == null) {
                    if (foregroundIS != null) {
                        try {
                            foregroundIS.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (backgroundIS != null) {
                        try {
                            backgroundIS.close();
                        } catch (Exception e6) {
                        }
                    }
                    return null;
                }
                Bitmap bgBitmap = BitmapFactory.decodeStream(backgroundIS);
                if (bgBitmap == null) {
                    if (foregroundIS != null) {
                        try {
                            foregroundIS.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (backgroundIS != null) {
                        try {
                            backgroundIS.close();
                        } catch (Exception e8) {
                        }
                    }
                    return null;
                }
                Drawable foregroundDrawable = new BitmapDrawable(sysResources, fgBitmap);
                Drawable backgroundDrawable = new BitmapDrawable(sysResources, bgBitmap);
                AdaptiveIconDrawable adaptiveIconDrawable = new AdaptiveIconDrawable(backgroundDrawable, foregroundDrawable);
                if (foregroundIS != null) {
                    try {
                        foregroundIS.close();
                    } catch (Exception e9) {
                    }
                }
                if (backgroundIS != null) {
                    try {
                        backgroundIS.close();
                    } catch (Exception e10) {
                    }
                }
                return adaptiveIconDrawable;
            } catch (Exception e11) {
                StepOSLogUtil.e("getAdaptiveIconDrawableFromFile error: " + e11.getMessage());
                if (foregroundIS != null) {
                    try {
                        foregroundIS.close();
                    } catch (Exception e12) {
                    }
                }
                if (backgroundIS != null) {
                    try {
                        backgroundIS.close();
                    } catch (Exception e13) {
                    }
                }
                return null;
            }
        } finally {
        }
    }

    public Drawable getVectorDrawable(Resources res, InputStream is) {
        if (is != null) {
            try {
                return Drawable.createFromStream(is, "vector");
            } catch (Exception e) {
                StepOSLogUtil.e("getVectorDrawable failed: " + e.getMessage());
                return null;
            }
        }
        return null;
    }
}
