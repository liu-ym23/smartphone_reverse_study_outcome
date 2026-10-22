package com.stepos.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.LruCache;

/* loaded from: classes.dex */
public class StrokeDrawableUtils {
    private static final int DEF_STROKE_RADIUS = 2;
    private static final int EFFECTIVE_COLOR = 335544320;
    private static final int MAX_LENGTH = 1000;
    private static final int STROKE_ALPHA_VALUE = 255;
    private static final int STROKE_RECT_ALPHA_VALUE = 26;
    private static final Object syncStroke = new Object();
    private static final Object syncStrokeRect = new Object();

    public static Drawable createStrokeDrawable(Drawable originalDrawable, Resources resources, Boolean recycle) {
        Drawable drawable;
        int createHeight;
        int createWidth;
        Bitmap strokeBitmap;
        synchronized (syncStroke) {
            BitmapDrawable newDrawable = null;
            Bitmap mapBitmap = drawable2Bitmap(originalDrawable);
            if (mapBitmap != null && (strokeBitmap = Bitmap.createBitmap((createWidth = mapBitmap.getWidth() + 4), (createHeight = mapBitmap.getHeight() + 4), Bitmap.Config.ARGB_8888)) != null) {
                int hashCode = originalDrawable.hashCode();
                strokeBitmap.eraseColor(0);
                Canvas canvas = StrokeLruCache.obtainStrokeCanvas();
                canvas.setBitmap(strokeBitmap);
                Paint filterPaint = StrokeLruCache.obtainStokePaint();
                Bitmap alphaBitmap = StrokeLruCache.getExtraAlphaBitmap(createWidth, createHeight, hashCode, mapBitmap);
                filterPaint.reset();
                filterPaint.setColor(EFFECTIVE_COLOR);
                canvas.drawBitmap(alphaBitmap, (createWidth - alphaBitmap.getWidth()) >> 1, (createHeight - alphaBitmap.getHeight()) >> 1, filterPaint);
                canvas.drawBitmap(mapBitmap, (createWidth - mapBitmap.getWidth()) >> 1, (createHeight - mapBitmap.getHeight()) >> 1, (Paint) null);
                newDrawable = new BitmapDrawable(resources, strokeBitmap);
                newDrawable.setBounds(0, 0, createWidth, createHeight);
            }
            drawable = newDrawable == null ? originalDrawable : newDrawable;
        }
        return drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable createStrokeDrawable(android.graphics.drawable.Drawable r19, int r20, int r21, android.content.res.Resources r22, java.lang.Boolean r23) throws java.lang.Throwable {
        /*
            r1 = r20
            r2 = r21
            java.lang.Object r3 = com.stepos.util.StrokeDrawableUtils.syncStroke
            monitor-enter(r3)
            r0 = 0
            android.graphics.Bitmap r4 = drawable2Bitmap(r19)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto La4
            r5 = 1
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r4, r1, r2, r5)     // Catch: java.lang.Throwable -> Lb2
            if (r6 == 0) goto L9f
            int r7 = r6.getHeight()     // Catch: java.lang.Throwable -> Lb2
            r8 = 2
            int r7 = r7 + r8
            int r9 = r6.getWidth()     // Catch: java.lang.Throwable -> Lb2
            int r9 = r9 + r8
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Throwable -> Lb2
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r9, r7, r10)     // Catch: java.lang.Throwable -> Lb2
            if (r10 == 0) goto L9a
            int r11 = r19.hashCode()     // Catch: java.lang.Throwable -> Lb2
            r12 = 0
            r10.eraseColor(r12)     // Catch: java.lang.Throwable -> Lb2
            android.graphics.Canvas r13 = com.stepos.util.StrokeDrawableUtils.StrokeLruCache.obtainStrokeCanvas()     // Catch: java.lang.Throwable -> Lb2
            r13.setBitmap(r10)     // Catch: java.lang.Throwable -> Lb2
            android.graphics.Paint r14 = com.stepos.util.StrokeDrawableUtils.StrokeLruCache.obtainStokePaint()     // Catch: java.lang.Throwable -> Lb2
            int[] r8 = new int[r8]     // Catch: java.lang.Throwable -> Lb2
            android.graphics.Bitmap r15 = com.stepos.util.StrokeDrawableUtils.StrokeLruCache.getExtraAlphaBitmap(r9, r7, r11, r6, r8)     // Catch: java.lang.Throwable -> Lb2
            r14.reset()     // Catch: java.lang.Throwable -> Lb2
            r12 = 335544320(0x14000000, float:6.4623485E-27)
            r14.setColor(r12)     // Catch: java.lang.Throwable -> Lb2
            int r12 = r1 + 2
            r16 = r0
            int r0 = r2 + 2
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r6, r12, r0, r5)     // Catch: java.lang.Throwable -> Lb2
            int r12 = r10.getDensity()     // Catch: java.lang.Throwable -> Lb2
            r0.setDensity(r12)     // Catch: java.lang.Throwable -> Lb2
            int r12 = r0.getWidth()     // Catch: java.lang.Throwable -> Lb2
            int r12 = r9 - r12
            int r12 = r12 >> r5
            float r12 = (float) r12     // Catch: java.lang.Throwable -> Lb2
            int r17 = r0.getHeight()     // Catch: java.lang.Throwable -> Lb2
            int r17 = r7 - r17
            r18 = r5
            int r5 = r17 >> 1
            float r5 = (float) r5     // Catch: java.lang.Throwable -> Lb2
            r1 = 0
            r13.drawBitmap(r0, r12, r5, r1)     // Catch: java.lang.Throwable -> Lb2
            int r1 = r10.getDensity()     // Catch: java.lang.Throwable -> Lb2
            r15.setDensity(r1)     // Catch: java.lang.Throwable -> Lb2
            int r1 = r15.getWidth()     // Catch: java.lang.Throwable -> Lb2
            int r1 = r9 - r1
            int r1 = r1 >> 1
            float r1 = (float) r1     // Catch: java.lang.Throwable -> Lb2
            int r5 = r15.getHeight()     // Catch: java.lang.Throwable -> Lb2
            int r5 = r7 - r5
            int r5 = r5 >> 1
            float r5 = (float) r5     // Catch: java.lang.Throwable -> Lb2
            r13.drawBitmap(r15, r1, r5, r14)     // Catch: java.lang.Throwable -> Lb2
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Throwable -> Lb2
            r5 = r22
            r1.<init>(r5, r10)     // Catch: java.lang.Throwable -> Lb7
            r12 = 0
            r1.setBounds(r12, r12, r9, r7)     // Catch: java.lang.Throwable -> Lb7
            r0 = r1
            goto Laa
        L9a:
            r5 = r22
            r16 = r0
            goto La8
        L9f:
            r5 = r22
            r16 = r0
            goto La8
        La4:
            r5 = r22
            r16 = r0
        La8:
            r0 = r16
        Laa:
            if (r0 != 0) goto Laf
            r1 = r19
            goto Lb0
        Laf:
            r1 = r0
        Lb0:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb7
            return r1
        Lb2:
            r0 = move-exception
            r5 = r22
        Lb5:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb7
            throw r0
        Lb7:
            r0 = move-exception
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.util.StrokeDrawableUtils.createStrokeDrawable(android.graphics.drawable.Drawable, int, int, android.content.res.Resources, java.lang.Boolean):android.graphics.drawable.Drawable");
    }

    @Deprecated
    public static Drawable createStrokeDrawable(Drawable originalDrawable, Resources resources) {
        return createStrokeDrawable(originalDrawable, resources, true);
    }

    private static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null || drawable.getIntrinsicHeight() > MAX_LENGTH || drawable.getIntrinsicWidth() > MAX_LENGTH) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if ((!(drawable instanceof NinePatchDrawable) && !(drawable instanceof StateListDrawable) && !(drawable instanceof GradientDrawable) && !(drawable instanceof InsetDrawable) && !(drawable instanceof LayerDrawable) && !(drawable instanceof LevelListDrawable) && !(drawable instanceof PaintDrawable) && !(drawable instanceof PictureDrawable) && !(drawable instanceof RotateDrawable) && !(drawable instanceof ScaleDrawable) && !(drawable instanceof ShapeDrawable) && !(drawable instanceof ClipDrawable) && !(drawable instanceof AdaptiveIconDrawable)) || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0 || (bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        Canvas canvas = StrokeLruCache.obtainStrokeCanvas();
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Drawable createRectStrokeDrawable(Drawable originalDrawable, Resources res) {
        Drawable drawable;
        synchronized (syncStrokeRect) {
            BitmapDrawable newDrawable = null;
            int createWidth = originalDrawable.getIntrinsicWidth();
            int createHeight = originalDrawable.getIntrinsicHeight();
            Bitmap strokeBitmap = Bitmap.createBitmap(createWidth, createHeight, Bitmap.Config.ARGB_8888);
            if (strokeBitmap != null) {
                strokeBitmap.eraseColor(0);
                Canvas canvas = StrokeLruCache.obtainStrokeCanvas();
                canvas.setBitmap(strokeBitmap);
                originalDrawable.setBounds(0, 0, createWidth, createHeight);
                originalDrawable.draw(canvas);
                canvas.save();
                Paint strokePaint = StrokeLruCache.obtainStokePaint();
                strokePaint.setStrokeWidth(2.0f);
                strokePaint.setColor(EFFECTIVE_COLOR);
                strokePaint.setAlpha(26);
                strokePaint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(2.0f, 2.0f, createWidth - 2, createHeight - 2, strokePaint);
                newDrawable = new BitmapDrawable(res, strokeBitmap);
            }
            drawable = newDrawable == null ? originalDrawable : newDrawable;
        }
        return drawable;
    }

    public static void clearStrokeDrawableCache() {
        StrokeLruCache.clearLruCache();
    }

    private static class StrokeLruCache {
        private static BlurMaskFilter mBlurMaskFilter;
        private static Canvas mStrokeCanvas;
        private static Paint mStrokePaint;
        private static final int mMaxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        private static final int mCacheSize = mMaxMemory / 8;
        private static LruCache<String, Bitmap> mMemoryCache = new LruCache<String, Bitmap>(mCacheSize) { // from class: com.stepos.util.StrokeDrawableUtils.StrokeLruCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };

        private StrokeLruCache() {
        }

        public static Bitmap getExtraAlphaBitmap(int width, int height, int hashCode, Bitmap src) {
            String imageKey = String.valueOf(hashCode) + String.valueOf(width) + String.valueOf(height);
            Bitmap bitmap = mMemoryCache.get(imageKey);
            if (bitmap != null) {
                return bitmap;
            }
            BlurMaskFilter maskFilter = obtainBlurMaskFilter();
            Paint filterPaint = obtainStokePaint();
            filterPaint.setMaskFilter(maskFilter);
            Bitmap newBitmap = src.extractAlpha(filterPaint, new int[2]);
            mMemoryCache.put(imageKey, newBitmap);
            return newBitmap;
        }

        public static Bitmap getExtraAlphaBitmap(int width, int height, int hashCode, Bitmap src, int[] offsetxy) {
            String imageKey = String.valueOf(hashCode) + String.valueOf(width) + String.valueOf(height);
            Bitmap bitmap = mMemoryCache.get(imageKey);
            if (bitmap != null) {
                return bitmap;
            }
            BlurMaskFilter maskFilter = obtainBlurMaskFilter();
            Paint filterPaint = obtainStokePaint();
            filterPaint.setMaskFilter(maskFilter);
            Bitmap newBitmap = src.extractAlpha(filterPaint, offsetxy);
            mMemoryCache.put(imageKey, newBitmap);
            return newBitmap;
        }

        public static Paint obtainStokePaint() {
            if (mStrokePaint == null) {
                mStrokePaint = new Paint();
                mStrokePaint.setColor(StrokeDrawableUtils.EFFECTIVE_COLOR);
            }
            return mStrokePaint;
        }

        public static Canvas obtainStrokeCanvas() {
            if (mStrokeCanvas == null) {
                mStrokeCanvas = new Canvas();
            }
            return mStrokeCanvas;
        }

        public static BlurMaskFilter obtainBlurMaskFilter() {
            if (mBlurMaskFilter == null) {
                mBlurMaskFilter = new BlurMaskFilter(2.0f, BlurMaskFilter.Blur.OUTER);
            }
            return mBlurMaskFilter;
        }

        public static void clearLruCache() {
            if (mMemoryCache != null) {
                mMemoryCache.evictAll();
            }
        }
    }
}
