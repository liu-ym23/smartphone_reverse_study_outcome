package com.android.server.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.FileUtils;
import android.os.SELinux;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.view.DisplayInfo;
import com.android.server.utils.TimingsTraceAndSlog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WallpaperCropper {
    static final int ADD = 1;
    static final int BALANCE = 3;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_CROP = true;
    static final float MAX_PARALLAX = 1.0f;
    static final int REMOVE = 2;
    private static final String TAG = null;
    private final WallpaperDefaultDisplayInfo mDefaultDisplayInfo;
    private final WallpaperDisplayHelper mWallpaperDisplayHelper;

    public static /* synthetic */ void $r8$lambda$wM11yNEwVRhaK9YEsBDy6GuErGc(int r0, int r1, int r2, Rect r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        lambda$generateCropInternal$0(r0, r1, r2, r3, r4, r5, r6);
    }

    static {
        TAG = WallpaperCropper.class.getSimpleName();
    }

    WallpaperCropper(WallpaperDisplayHelper wallpaperDisplayHelper) {
        this.mWallpaperDisplayHelper = wallpaperDisplayHelper;
        this.mDefaultDisplayInfo = this.mWallpaperDisplayHelper.getDefaultDisplayInfo();
    }

    public static Rect getCrop(Point displaySize, WallpaperDefaultDisplayInfo defaultDisplayInfo, Point bitmapSize, SparseArray<Rect> suggestedCrops, boolean rtl) {
        int orientation = WallpaperManager.getOrientation(displaySize);
        int r0 = 0;
        if (suggestedCrops != null) goto L5;
    L58:
        Rect crop = new Rect(0, 0, bitmapSize.x, bitmapSize.y);
        int unfoldedOrientation = defaultDisplayInfo.getUnfoldedOrientation(orientation);
        if (unfoldedOrientation == (-1)) goto L63;
        SparseArray<Rect> newSuggestedCrops = new SparseArray();
        newSuggestedCrops.put(unfoldedOrientation, crop);
        return getCrop(displaySize, defaultDisplayInfo, bitmapSize, newSuggestedCrops, rtl);
    L63:
        if (defaultDisplayInfo.isLargeScreen == false) goto L68;
        if (defaultDisplayInfo.isFoldable == true) goto L68;
        r0 = 1;
    L68:
        if (r0 != 0) goto L70;
    L75:
        Rect landscapeCrop = crop;
        return getAdjustedCrop(landscapeCrop, bitmapSize, displaySize, true, rtl, 1);
    L70:
        if (displaySize.x >= displaySize.y) goto L75;
        Point rotatedDisplaySize = new Point(displaySize.y, displaySize.x);
        Rect landscapeCrop2 = getCrop(rotatedDisplaySize, defaultDisplayInfo, bitmapSize, suggestedCrops, rtl);
        Rect landscapeCrop3 = noParallax(landscapeCrop2, rotatedDisplaySize, bitmapSize, rtl);
        crop = getAdjustedCrop(landscapeCrop3, bitmapSize, displaySize, false, rtl, 1);
        if (rtl == false) goto L74;
        crop.left = landscapeCrop3.left;
        goto L75
    L74:
        crop.right = landscapeCrop3.right;
        goto L75
    L5:
        if (suggestedCrops.size() == 0) goto L58;
        int i = 0;
    L9:
        if (i >= suggestedCrops.size()) goto L24;
        Rect testCrop = suggestedCrops.valueAt(i);
        if (testCrop == null) goto L22;
        if (testCrop.left < 0) goto L22;
        if (testCrop.top < 0) goto L22;
        if (testCrop.right > bitmapSize.x) goto L22;
        if (testCrop.bottom > bitmapSize.y) goto L22;
        i = i + 1;
    L22:
        Slog.w(TAG, "invalid crop: " + testCrop + " for bitmap size: " + bitmapSize);
        return getCrop(displaySize, defaultDisplayInfo, bitmapSize, new SparseArray(), rtl);
    L24:
        Rect suggestedCrop = suggestedCrops.get(orientation);
        if (suggestedCrop != null) goto L27;
        int rotatedOrientation = WallpaperManager.getRotatedOrientation(orientation);
        Rect suggestedCrop2 = suggestedCrops.get(rotatedOrientation);
        Point suggestedDisplaySize = defaultDisplayInfo.defaultDisplaySizes.get(rotatedOrientation);
        if (suggestedCrop2 != null) goto L31;
        int unfoldedOrientation2 = defaultDisplayInfo.getUnfoldedOrientation(orientation);
        Rect suggestedCrop3 = suggestedCrops.get(unfoldedOrientation2);
        Point suggestedDisplaySize2 = defaultDisplayInfo.defaultDisplaySizes.get(unfoldedOrientation2);
        Point suggestedDisplaySize3 = suggestedDisplaySize2;
        if (suggestedCrop3 == null) goto L42;
        Rect adjustedCrop = noParallax(suggestedCrop3, suggestedDisplaySize3, bitmapSize, rtl);
        Rect res = getAdjustedCrop(adjustedCrop, bitmapSize, displaySize, false, rtl, 2);
        if (res.width() >= adjustedCrop.width()) goto L41;
        if (rtl == false) goto L38;
        res.left = Math.min(res.left, adjustedCrop.left);
    L85:
        return getAdjustedCrop(res, bitmapSize, displaySize, true, rtl, 1);
    L38:
        res.right = Math.max(res.right, adjustedCrop.right);
        goto L85
    L41:
        return res;
    L42:
        int foldedOrientation = defaultDisplayInfo.getFoldedOrientation(orientation);
        Rect suggestedCrop4 = suggestedCrops.get(foldedOrientation);
        Point suggestedDisplaySize4 = defaultDisplayInfo.defaultDisplaySizes.get(foldedOrientation);
        Point suggestedDisplaySize5 = suggestedDisplaySize4;
        if (suggestedCrop4 != null) goto L45;
        Point rotatedDisplaySize2 = defaultDisplayInfo.defaultDisplaySizes.get(rotatedOrientation);
        if (rotatedDisplaySize2 == null) goto L56;
        int rotatedFolded = defaultDisplayInfo.getFoldedOrientation(rotatedOrientation);
        int rotateUnfolded = defaultDisplayInfo.getUnfoldedOrientation(rotatedOrientation);
        int[] r15 = {rotatedFolded, rotateUnfolded};
    L49:
        int rotatedFolded2 = rotatedFolded;
        if (r0 >= 2) goto L56;
        int suggestedOrientation = r15[r0];
        if (suggestedCrops.get(suggestedOrientation) != null) goto L53;
        r0 = r0 + 1;
        rotatedFolded = rotatedFolded2;
        goto L49
    L53:
        Rect rotatedCrop = getCrop(rotatedDisplaySize2, defaultDisplayInfo, bitmapSize, suggestedCrops, rtl);
        SparseArray<Rect> rotatedCropMap = new SparseArray();
        rotatedCropMap.put(rotatedOrientation, rotatedCrop);
        return getCrop(displaySize, defaultDisplayInfo, bitmapSize, rotatedCropMap, rtl);
    L56:
        Slog.w(TAG, "Could not find a proper default crop for display: " + displaySize + ", bitmap size: " + bitmapSize + ", suggested crops: " + suggestedCrops + ", orientation: " + orientation + ", rtl: " + rtl + ", defaultDisplaySizes: " + defaultDisplayInfo.defaultDisplaySizes);
        return getCrop(displaySize, defaultDisplayInfo, bitmapSize, new SparseArray(), rtl);
    L45:
        return getAdjustedCrop(noParallax(suggestedCrop4, suggestedDisplaySize5, bitmapSize, rtl), bitmapSize, displaySize, false, rtl, 1);
    L31:
        return getAdjustedCrop(noParallax(suggestedCrop2, suggestedDisplaySize, bitmapSize, rtl), bitmapSize, displaySize, false, rtl, 3);
    L27:
        return getAdjustedCrop(suggestedCrop, bitmapSize, displaySize, true, rtl, 1);
    }

    static Rect noParallax(Rect crop, Point displaySize, Point bitmapSize, boolean rtl) {
        if (displaySize != null) goto L4;
        return crop;
    L4:
        Rect adjustedCrop = getAdjustedCrop(crop, bitmapSize, displaySize, true, rtl, 1);
        float suggestedDisplayRatio = (displaySize.x * 1.0f) / displaySize.y;
        int widthToRemove = (int) ((adjustedCrop.width() - (adjustedCrop.height() * suggestedDisplayRatio)) + 0.5f);
        if (rtl == false) goto L7;
        adjustedCrop.left += widthToRemove;
    L8:
        return adjustedCrop;
    L7:
        adjustedCrop.right -= widthToRemove;
        goto L8
    }

    static Rect getAdjustedCrop(Rect crop, Point bitmapSize, Point screenSize, boolean parallax, boolean rtl, int mode) {
        Rect adjustedCrop = new Rect(crop);
        float cropRatio = crop.width() / crop.height();
        float screenRatio = screenSize.x / screenSize.y;
        if (cropRatio != screenRatio) goto L6;
        return crop;
    L6:
        if (cropRatio <= screenRatio) goto L18;
        if (parallax == true) goto L10;
        int newLeft = bitmapSize.y - crop.bottom;
        int newRight = newLeft + crop.height();
        int newTop = crop.left;
        int newBottom = newTop + crop.width();
        Rect rotatedCrop = new Rect(newLeft, newTop, newRight, newBottom);
        Point rotatedBitmap = new Point(bitmapSize.y, bitmapSize.x);
        Point rotatedScreen = new Point(screenSize.y, screenSize.x);
        Rect rect = getAdjustedCrop(rotatedCrop, rotatedBitmap, rotatedScreen, false, rtl, mode);
        int resultLeft = rect.top;
        int resultRight = resultLeft + rect.height();
        int resultTop = rotatedBitmap.x - rect.right;
        int resultBottom = resultTop + rect.width();
        return new Rect(resultLeft, resultTop, resultRight, resultBottom);
    L10:
        float additionalWidthForParallax = (cropRatio / screenRatio) - 1.0f;
        if (additionalWidthForParallax <= 1.0f) goto L35;
        int widthToRemove = (int) Math.ceil(((additionalWidthForParallax - 1.0f) * screenRatio) * crop.height());
        if (rtl == false) goto L15;
        adjustedCrop.left += widthToRemove;
        goto L35
    L15:
        adjustedCrop.right -= widthToRemove;
    L35:
        return adjustedCrop;
    L18:
        if (mode != 2) goto L21;
        int widthToAdd = 0;
    L24:
        int availableWidth = bitmapSize.x - crop.width();
        if (availableWidth < widthToAdd) goto L33;
        int widthToAddLeft = widthToAdd / 2;
        int widthToAddRight = (widthToAdd / 2) + (widthToAdd % 2);
        if (crop.left >= widthToAddLeft) goto L30;
        widthToAddRight = widthToAddRight + (widthToAddLeft - crop.left);
        widthToAddLeft = crop.left;
    L32:
        adjustedCrop.left -= widthToAddLeft;
        adjustedCrop.right += widthToAddRight;
    L34:
        int heightToRemove = (int) (crop.height() - (adjustedCrop.width() / screenRatio));
        adjustedCrop.top += (heightToRemove / 2) + (heightToRemove % 2);
        adjustedCrop.bottom -= heightToRemove / 2;
        goto L35
    L30:
        if ((bitmapSize.x - crop.right) >= widthToAddRight) goto L32;
        widthToAddLeft = widthToAddLeft + (widthToAddRight - (bitmapSize.x - crop.right));
        widthToAddRight = bitmapSize.x - crop.right;
        goto L32
    L33:
        adjustedCrop.left = 0;
        adjustedCrop.right = bitmapSize.x;
        goto L34
    L21:
        if (mode != 1) goto L23;
        widthToAdd = (int) ((crop.height() * screenRatio) - crop.width());
        goto L24
    L23:
        widthToAdd = (int) (((double) (-crop.width())) + Math.sqrt((crop.width() * crop.height()) * screenRatio));
        goto L24
    }

    public static Rect getTotalCrop(SparseArray<Rect> crops) {
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;
        int i = 0;
    L4:
        if (i >= crops.size()) goto L7;
        Rect rect = crops.valueAt(i);
        left = Math.min(left, rect.left);
        top = Math.min(top, rect.top);
        right = Math.max(right, rect.right);
        bottom = Math.max(bottom, rect.bottom);
        i = i + 1;
        goto L4
    L7:
        return new Rect(left, top, right, bottom);
    }

    SparseArray<Rect> getRelativeCropHints(WallpaperData wallpaper) {
        SparseArray<Rect> result = new SparseArray();
        int i = 0;
    L4:
        if (i >= wallpaper.mCropHints.size()) goto L7;
        Rect adjustedRect = new Rect(wallpaper.mCropHints.valueAt(i));
        adjustedRect.offset(-wallpaper.cropHint.left, -wallpaper.cropHint.top);
        adjustedRect.left = (int) ((adjustedRect.left / wallpaper.mSampleSize) + 0.5f);
        adjustedRect.top = (int) ((adjustedRect.top / wallpaper.mSampleSize) + 0.5f);
        adjustedRect.right = (int) Math.floor(adjustedRect.right / wallpaper.mSampleSize);
        adjustedRect.bottom = (int) Math.floor(adjustedRect.bottom / wallpaper.mSampleSize);
        result.put(wallpaper.mCropHints.keyAt(i), adjustedRect);
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    static List<Rect> getOriginalCropHints(WallpaperData wallpaper, List<Rect> relativeCropHints) {
        List<Rect> result = new ArrayList();
        Iterator<Rect> r1 = relativeCropHints.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Rect crop = r1.next();
        Rect originalRect = new Rect(crop);
        originalRect.scale(wallpaper.mSampleSize);
        originalRect.offset(wallpaper.cropHint.left, wallpaper.cropHint.top);
        result.add(originalRect);
        goto L4
    L6:
        return result;
    }

    SparseArray<Rect> getDefaultCrops(SparseArray<Rect> suggestedCrops, Point bitmapSize) {
        Rect cropHint = suggestedCrops.get(-1);
        boolean rtl = false;
        if (cropHint == null) goto L17;
        Rect bitmapRect = new Rect(0, 0, bitmapSize.x, bitmapSize.y);
        if (suggestedCrops.size() == 1) goto L7;
    L15:
        Slog.w(TAG, "Couldn't get default crops from suggested crops " + suggestedCrops + " for bitmap of size " + bitmapSize + "; ignoring suggested crops");
        return getDefaultCrops(new SparseArray(), bitmapSize);
    L7:
        if (bitmapRect.contains(cropHint) == false) goto L15;
        Point cropSize = new Point(cropHint.width(), cropHint.height());
        SparseArray<Rect> relativeDefaultCrops = getDefaultCrops(new SparseArray(), cropSize);
        int i = 0;
    L11:
        if (i >= relativeDefaultCrops.size()) goto L14;
        relativeDefaultCrops.valueAt(i).offset(cropHint.left, cropHint.top);
        i = i + 1;
        goto L11
    L14:
        return relativeDefaultCrops;
    L17:
        SparseArray<Point> defaultDisplaySizes = this.mWallpaperDisplayHelper.getDefaultDisplaySizes();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L20;
        rtl = true;
    L20:
        SparseArray<Rect> adjustedSuggestedCrops = new SparseArray();
        int i2 = 0;
    L22:
        if (i2 >= defaultDisplaySizes.size()) goto L27;
        int orientation = defaultDisplaySizes.keyAt(i2);
        Point displaySize = defaultDisplaySizes.valueAt(i2);
        Rect suggestedCrop = suggestedCrops.get(orientation);
        if (suggestedCrop == null) goto L26;
        adjustedSuggestedCrops.put(orientation, getCrop(displaySize, this.mDefaultDisplayInfo, bitmapSize, suggestedCrops, rtl));
    L26:
        i2 = i2 + 1;
        goto L22
    L27:
        SparseArray<Rect> result = adjustedSuggestedCrops.clone();
        int i3 = 0;
    L29:
        if (i3 >= defaultDisplaySizes.size()) goto L36;
        int orientation2 = defaultDisplaySizes.keyAt(i3);
        if (result.contains(orientation2) == true) goto L34;
        Point displaySize2 = defaultDisplaySizes.valueAt(i3);
        Rect newCrop = getCrop(displaySize2, this.mDefaultDisplayInfo, bitmapSize, adjustedSuggestedCrops, rtl);
        result.put(orientation2, newCrop);
    L34:
        i3 = i3 + 1;
        goto L29
    L36:
        return result;
    }

    void generateCrop(WallpaperData wallpaper) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("WPMS.generateCrop");
        generateCropInternal(wallpaper);
        t.traceEnd();
    }

    private void generateCropInternal(WallpaperData wallpaper) {
        boolean success = false;
        WallpaperDisplayHelper.DisplayData wpData = this.mWallpaperDisplayHelper.getDisplayDataOrCreate(0);
        DisplayInfo r6 = this.mWallpaperDisplayHelper.getDisplayInfo(0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(wallpaper.getWallpaperFile().getAbsolutePath(), options);
        if (options.outWidth <= 0) goto L120;
        if (options.outHeight <= 0) goto L120;
        Point bitmapSize = new Point(options.outWidth, options.outHeight);
        Rect bitmapRect = new Rect(0, 0, bitmapSize.x, bitmapSize.y);
        int i = 0;
    L9:
        if (i >= wallpaper.mCropHints.size()) goto L17;
        int orientation = wallpaper.mCropHints.keyAt(i);
        Rect crop = wallpaper.mCropHints.valueAt(i);
        if (crop.isEmpty() == true) goto L16;
        if (bitmapRect.contains(crop) == false) goto L16;
        i = i + 1;
    L16:
        Slog.w(TAG, "Invalid crop " + crop + " for orientation " + orientation + " and bitmap size " + bitmapSize + "; clearing suggested crops.");
        wallpaper.mCropHints.clear();
        wallpaper.cropHint.set(bitmapRect);
    L17:
        Rect tempCropHint = wallpaper.mCropHints.get(-1);
        if (tempCropHint == null) goto L21;
        wallpaper.cropHint.set(tempCropHint);
        wallpaper.mCropHints.clear();
    L21:
        if (wallpaper.mCropHints.size() <= 0) goto L31;
        SparseArray<Rect> defaultCrops = getDefaultCrops(wallpaper.mCropHints, bitmapSize);
        SparseArray<Rect> updatedCropHints = new SparseArray();
        int i2 = 0;
    L24:
        if (i2 >= wallpaper.mCropHints.size()) goto L29;
        int orientation2 = wallpaper.mCropHints.keyAt(i2);
        Rect defaultCrop = defaultCrops.get(orientation2);
        if (defaultCrop == null) goto L28;
        updatedCropHints.put(orientation2, defaultCrop);
    L28:
        i2 = i2 + 1;
        goto L24
    L29:
        wallpaper.mCropHints = updatedCropHints;
        Rect cropHint = getTotalCrop(defaultCrops);
        wallpaper.cropHint.set(cropHint);
        SparseArray<Rect> updatedCropHints2 = defaultCrops;
    L38:
        if (options.outHeight <= cropHint.height()) goto L40;
    L43:
        boolean r0 = true;
    L44:
        boolean needCrop = r0;
        if (cropHint.height() <= wpData.mHeight) goto L47;
    L52:
        boolean needScale = true;
    L53:
        float sampleSize = Float.MAX_VALUE;
        int i3 = 0;
    L55:
        if (i3 >= updatedCropHints2.size()) goto L61;
        int orientation3 = updatedCropHints2.keyAt(i3);
        Rect crop2 = updatedCropHints2.valueAt(i3);
        boolean needScale2 = needScale;
        Point displayForThisOrientation = this.mWallpaperDisplayHelper.getDefaultDisplaySizes().get(orientation3);
        if (displayForThisOrientation == null) goto L60;
        float r3 = Math.max(1.0f, Math.min(crop2.width() / displayForThisOrientation.x, crop2.height() / displayForThisOrientation.y));
        float sampleSizeForThisOrientation = Math.max(1.0f, Math.min(crop2.width() / displayForThisOrientation.x, crop2.height() / displayForThisOrientation.y));
        sampleSize = Math.min(sampleSize, sampleSizeForThisOrientation);
    L60:
        i3 = i3 + 1;
        needScale = needScale2;
        success = success;
        tempCropHint = tempCropHint;
        goto L55
    L61:
        success = success;
        int maxCropSize = Math.min(this.mWallpaperDisplayHelper.getDefaultDisplayLargestDimension() * 2, GLHelper.getMaxTextureSize());
        float minimumSampleSize = Math.max(1.0f, Math.max(cropHint.height() / maxCropSize, cropHint.width()) / maxCropSize);
        float sampleSize2 = Math.max(sampleSize, minimumSampleSize);
        if (sampleSize2 <= 1.0f) goto L64;
        boolean r16 = true;
    L65:
        boolean needScale3 = r16;
        Slog.v(TAG, "crop: w=" + cropHint.width() + " h=" + cropHint.height());
        String r1 = TAG;
        StringBuilder r4 = new StringBuilder();
        r4.append("defaultCrops: ");
        r4.append(updatedCropHints2);
        Slog.v(r1, r4.toString());
        Slog.v(TAG, "meas: w=" + options.outWidth + " h=" + options.outHeight);
        Slog.v(TAG, "crop?=" + needCrop + " scale?=" + needScale3);
        if (needCrop == true) goto L72;
        if (needScale3 == true) goto L72;
        boolean success2 = FileUtils.copyFile(wallpaper.getWallpaperFile(), wallpaper.getCropFile());
        if (success2 == true) goto L122;
        wallpaper.getCropFile().delete();
    L122:
        if (success2 == true) goto L125;
        Slog.e(TAG, "Unable to apply new wallpaper");
        wallpaper.getCropFile().delete();
        wallpaper.mCropHints.clear();
        wallpaper.cropHint.set(0, 0, 0, 0);
        wallpaper.mSampleSize = 1.0f;
    L125:
        if (wallpaper.getCropFile().exists() == false) goto L150;
        SELinux.restorecon(wallpaper.getCropFile().getAbsoluteFile());
        return;
    L150:
        return;
    L72:
        FileOutputStream f = null;
        BufferedOutputStream bos = null;
        int actualScale = cropHint.height() / wpData.mHeight;     // Catch: Throwable -> L109 Exception -> L111
        int scale = 1;
    L75:
        if ((scale * 2) > actualScale) goto L77;
        scale = scale * 2;     // Catch: Throwable -> L109 Exception -> L111
        goto L75
    L77:
        options.inSampleSize = scale;     // Catch: Throwable -> L109 Exception -> L111
        options.inJustDecodeBounds = false;     // Catch: Throwable -> L109 Exception -> L111
        final Rect estimateCrop = new Rect(cropHint);     // Catch: Throwable -> L109 Exception -> L111
        int actualScale2 = estimateCrop.left;     // Catch: Throwable -> L109 Exception -> L111
        FileOutputStream f2 = null;
        estimateCrop.left = (int) Math.floor(actualScale2 / sampleSize2);     // Catch: Throwable -> L105 Exception -> L107
        estimateCrop.top = (int) Math.floor(estimateCrop.top / sampleSize2);     // Catch: Throwable -> L105 Exception -> L107
        estimateCrop.right = (int) Math.ceil(estimateCrop.right / sampleSize2);     // Catch: Throwable -> L105 Exception -> L107
        estimateCrop.bottom = (int) Math.ceil(estimateCrop.bottom / sampleSize2);     // Catch: Throwable -> L105 Exception -> L107
        float hRatio = wpData.mHeight / estimateCrop.height();     // Catch: Throwable -> L105 Exception -> L107
        int r5 = (int) (estimateCrop.height() * hRatio);     // Catch: Throwable -> L105 Exception -> L107
        int r7 = (int) (estimateCrop.width() * hRatio);     // Catch: Throwable -> L105 Exception -> L107
        int safeHeight = (int) ((cropHint.height() / sampleSize2) + 0.5f);     // Catch: Throwable -> L105 Exception -> L107
        int destHeight = cropHint.width();     // Catch: Throwable -> L105 Exception -> L107
        int safeWidth = (int) ((destHeight / sampleSize2) + 0.5f);     // Catch: Throwable -> L105 Exception -> L107
    L138:
        Slog.v(TAG, "Decode parameters:");     // Catch: Throwable -> L101 Exception -> L103
        String r8 = TAG;     // Catch: Throwable -> L101 Exception -> L103
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L101 Exception -> L103
    L134:
        r9.append("  cropHint=");     // Catch: Throwable -> L86 Exception -> L88
        r9.append(cropHint);     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(r8, r9.toString());     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(TAG, "  estimateCrop=" + estimateCrop);     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(TAG, "  sampleSize=" + sampleSize2);     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(TAG, "  user defined crops: " + wallpaper.mCropHints);     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(TAG, "  all crops: " + updatedCropHints2);     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(TAG, "  targetSize=" + safeWidth + "x" + safeHeight);     // Catch: Throwable -> L86 Exception -> L88
        String r10 = TAG;     // Catch: Throwable -> L86 Exception -> L88
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L86 Exception -> L88
        r11.append("  maxTextureSize=");     // Catch: Throwable -> L86 Exception -> L88
        r11.append(GLHelper.getMaxTextureSize());     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(r10, r11.toString());     // Catch: Throwable -> L86 Exception -> L88
        if (wallpaper.getWallpaperFile().getName().equals("wallpaper_orig") == false) goto L90;
        String recordName = "decode_record";
    L91:
        File record = new File(WallpaperUtils.getWallpaperDir(wallpaper.userId), recordName);     // Catch: Throwable -> L86 Exception -> L88
        record.createNewFile();     // Catch: Throwable -> L86 Exception -> L88
        Slog.v(TAG, "record path =" + record.getPath() + ", record name =" + record.getName());     // Catch: Throwable -> L86 Exception -> L88
        ImageDecoder.Source srcData = ImageDecoder.createSource(wallpaper.getWallpaperFile());     // Catch: Throwable -> L86 Exception -> L88
        final int finalScale = scale;
        final int rescaledBitmapWidth = (int) Math.ceil((double) (((float) bitmapSize.x) / sampleSize2));     // Catch: Throwable -> L86 Exception -> L88
        final int rescaledBitmapHeight = (int) Math.ceil((double) (((float) bitmapSize.y) / sampleSize2));     // Catch: Throwable -> L86 Exception -> L88
        Bitmap cropped = ImageDecoder.decodeBitmap(srcData, new WallpaperCropper$$ExternalSyntheticLambda0(finalScale, rescaledBitmapWidth, rescaledBitmapHeight, estimateCrop));     // Catch: Throwable -> L86 Exception -> L88
        record.delete();     // Catch: Throwable -> L86 Exception -> L88
        wallpaper.mSampleSize = sampleSize2;     // Catch: Throwable -> L86 Exception -> L88
        FileOutputStream f3 = new FileOutputStream(wallpaper.getCropFile());     // Catch: Throwable -> L86 Exception -> L88
        bos = new BufferedOutputStream(f3, 32768);     // Catch: Throwable -> L97 Exception -> L99
        f2 = f3;
        cropped.compress(Bitmap.CompressFormat.PNG, 100, bos);     // Catch: Throwable -> L86 Exception -> L88
        bos.flush();     // Catch: Throwable -> L86 Exception -> L88
        success2 = true;
        IoUtils.closeQuietly(bos);
        IoUtils.closeQuietly(f2);
        goto L122
    L99:
        e = e;
        f = f3;
    L128:
        Slog.e(TAG, "Error decoding crop", e);     // Catch: Throwable -> L116
        IoUtils.closeQuietly(bos);
        IoUtils.closeQuietly(f);
    L121:
        success2 = success;
    L116:
        th = th;
    L117:
        IoUtils.closeQuietly(bos);
        IoUtils.closeQuietly(f);
        throw th;
    L97:
        th = th;
        f = f3;
        goto L117
    L90:
        recordName = "decode_lock_record";
    L88:
        e = e;
        f = f2;
    L86:
        th = th;
        f = f2;
    L103:
        e = e;
        f = null;
    L101:
        th = th;
        f = null;
    L107:
        e = e;
        f = null;
    L105:
        th = th;
        f = null;
        goto L117
    L111:
        e = e;
    L109:
        th = th;
        goto L117
    L64:
        r16 = false;
        goto L65
    L47:
        if (cropHint.height() > GLHelper.getMaxTextureSize()) goto L52;
        if (cropHint.width() > GLHelper.getMaxTextureSize()) goto L52;
        needScale = false;
        goto L53
    L40:
        if (options.outWidth > cropHint.width()) goto L43;
        r0 = false;
        goto L44
    L31:
        if (wallpaper.cropHint.isEmpty() == false) goto L34;
        wallpaper.cropHint.set(bitmapRect);
    L34:
        if (bitmapRect.contains(wallpaper.cropHint) == true) goto L36;
        Slog.w(TAG, "Ignoring wallpaper.cropHint = " + wallpaper.cropHint + "; not within the bitmap of size " + bitmapSize);
        wallpaper.cropHint.set(bitmapRect);
    L36:
        Point cropSize = new Point(wallpaper.cropHint.width(), wallpaper.cropHint.height());
        updatedCropHints2 = getDefaultCrops(new SparseArray(), cropSize);
        cropHint = getTotalCrop(updatedCropHints2);
        cropHint.offset(wallpaper.cropHint.left, wallpaper.cropHint.top);
        wallpaper.cropHint.set(cropHint);
    L120:
        Slog.w(TAG, "Invalid wallpaper data");
        goto L121
    }

    private static /* synthetic */ void lambda$generateCropInternal$0(int finalScale, int rescaledBitmapWidth, int rescaledBitmapHeight, Rect estimateCrop, ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source src) {
        decoder.setTargetSize(rescaledBitmapWidth, rescaledBitmapHeight);
        decoder.setCrop(estimateCrop);
    }

    boolean isWallpaperCompatibleForDisplay(int displayId, WallpaperData wallpaperData) {
        if (displayId != 0) goto L5;
        return true;
    L5:
        File wallpaperFile = wallpaperData.getWallpaperFile();
        if (wallpaperFile.exists() == true) goto L8;
        return true;
    L8:
        DisplayInfo displayInfo = this.mWallpaperDisplayHelper.getDisplayInfo(displayId);
        Point displaySize = new Point(displayInfo.logicalWidth, displayInfo.logicalHeight);
        int displayOrientation = WallpaperManager.getOrientation(displaySize);
        Point wallpaperImageSize = new Point((int) Math.ceil(wallpaperData.cropHint.width() / wallpaperData.mSampleSize), (int) Math.ceil(wallpaperData.cropHint.height() / wallpaperData.mSampleSize));
        if (wallpaperImageSize.equals(0, 0) == false) goto L12;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(wallpaperFile.getAbsolutePath(), options);
        wallpaperImageSize.set(options.outWidth, options.outHeight);
    L12:
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L14;
        boolean isRtl = true;
    L15:
        Rect croppedImageBound = getCrop(displaySize, this.mDefaultDisplayInfo, wallpaperImageSize, getRelativeCropHints(wallpaperData), isRtl);
        double maxDisplayToImageRatio = Math.max(((double) displaySize.x) / ((double) croppedImageBound.width()), ((double) displaySize.y) / ((double) croppedImageBound.height()));
        if (maxDisplayToImageRatio <= 1.5d) goto L19;
        return false;
    L19:
        if (displayOrientation == 1) goto L21;
        return true;
    L21:
        if ((((double) wallpaperImageSize.x) / ((double) wallpaperImageSize.y)) < 0.8461538461538461d) goto L26;
        return true;
    L26:
        return false;
    L14:
        isRtl = false;
        goto L15
    }
}
