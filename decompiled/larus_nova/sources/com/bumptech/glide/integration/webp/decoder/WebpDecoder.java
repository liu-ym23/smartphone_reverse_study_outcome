package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpFrameInfo;
import com.bumptech.glide.integration.webp.WebpImage;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class WebpDecoder implements GifDecoder {
    private static final int MAX_FRAME_BITMAP_CACHE_SIZE = 5;
    private static final String TAG = "WebpDecoder";
    private int downsampledHeight;
    private int downsampledWidth;
    private Bitmap.Config mBitmapConfig;
    private final GifDecoder.BitmapProvider mBitmapProvider;
    private WebpFrameCacheStrategy mCacheStrategy;
    private final Context mContext;
    private final LruCache<Integer, Bitmap> mFrameBitmapCache;
    private final int[] mFrameDurations;
    private final WebpFrameInfo[] mFrameInfos;
    private int mFramePointer;
    private final Paint mTransparentFillPaint;
    private WebpImage mWebPImage;
    private ByteBuffer rawData;
    private int sampleSize;

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(InputStream r100, int r101) {
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(byte[] r100) {
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.mFramePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        WebpImage r100 = this.mWebPImage;
        if (r100 == null) goto L6;
        this.mFramePointer = (this.mFramePointer + 1) % r100.getFrameCount();
        return;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        WebpImage r100 = this.mWebPImage;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.mWebPImage = null;
        this.mFrameBitmapCache.evictAll();
        this.rawData = null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getSizeInBytes();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getFrameCount();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getHeight();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getLoopCount() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getLoopCount();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getLoopCount();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if (this.mFrameDurations.length == 0) goto L9;
        int r100 = this.mFramePointer;
        if (r100 >= 0) goto L8;
        return 0;
    L8:
        return getDelay(r100);
    L9:
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.getLoopCount() != 0) goto L8;
        return 0;
    L8:
        return this.mWebPImage.getLoopCount();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        WebpImage r100 = this.mWebPImage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getWidth();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public Bitmap getNextFrame() {
        int r100 = getCurrentFrameIndex();
        Bitmap r101 = this.mBitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, Bitmap.Config.ARGB_8888);
        r101.eraseColor(0);
        r101.setDensity(INVOKEVIRTUAL_com_bumptech_glide_integration_webp_decoder_WebpDecoder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).densityDpi);
        Canvas r102 = new Canvas(r101);
        r102.drawColor(0, PorterDuff.Mode.SRC);
        if (this.mCacheStrategy.noCache() == true) goto L12;
        Bitmap r103 = this.mFrameBitmapCache.get(Integer.valueOf(r100));
        if (r103 == null) goto L12;
        if (Log.isLoggable(TAG, 3) == true) goto L9;
    L9:
        r103.setDensity(r102.getDensity());
        r102.drawBitmap(r103, 0.0f, 0.0f, null);
        return r101;
    L12:
        if (isKeyFrame(r100) == true) goto L14;
        int r104 = prepareCanvasWithBlending(r100 - 1, r102);
    L16:
        if (Log.isLoggable(TAG, 3) == true) goto L18;
    L18:
        if (r104 >= r100) goto L29;
        WebpFrameInfo r105 = this.mFrameInfos[r104];
        if (r105.blendPreviousFrame == true) goto L22;
        disposeToBackground(r102, r105);
    L22:
        renderFrame(r104, r102);
        if (Log.isLoggable(TAG, 3) == true) goto L26;
    L26:
        if (r105.disposeBackgroundColor == false) goto L28;
        disposeToBackground(r102, r105);
    L28:
        r104 = r104 + 1;
        goto L18
    L29:
        WebpFrameInfo r106 = this.mFrameInfos[r100];
        if (r106.blendPreviousFrame == true) goto L32;
        disposeToBackground(r102, r106);
    L32:
        renderFrame(r100, r102);
        if (Log.isLoggable(TAG, 3) == true) goto L35;
    L35:
        cacheFrameBitmap(r100, r101);
        return r101;
    L14:
        r104 = r100;
        goto L16
    }

    public WebpFrameCacheStrategy getCacheStrategy() {
        return this.mCacheStrategy;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.mFramePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.rawData;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_integration_webp_decoder_WebpDecoder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ GifDecoder.BitmapProvider access$000(WebpDecoder r100) {
        return r100.mBitmapProvider;
    }

    private boolean isFullFrame(WebpFrameInfo r100) {
        if (r100.xOffset == 0) goto L5;
    L11:
        return false;
    L5:
        if (r100.yOffset != 0) goto L11;
        if (r100.width != this.mWebPImage.getWidth()) goto L11;
        if (r100.height != this.mWebPImage.getHeight()) goto L11;
        return true;
    }

    private boolean isKeyFrame(int r100) {
        if (r100 != 0) goto L5;
        return true;
    L5:
        WebpFrameInfo[] r101 = this.mFrameInfos;
        WebpFrameInfo r102 = r101[r100];
        WebpFrameInfo r103 = r101[r100 - 1];
        if (r102.blendPreviousFrame == true) goto L11;
        if (isFullFrame(r102) == false) goto L11;
        return true;
    L11:
        if (r103.disposeBackgroundColor == true) goto L13;
    L15:
        return false;
    L13:
        if (isFullFrame(r103) == false) goto L15;
        return true;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int r100) {
        if (r100 < 0) goto L6;
        int[] r101 = this.mFrameDurations;
        if (r100 >= r101.length) goto L6;
        return r101[r100];
    L6:
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(Bitmap.Config r100) {
        if (r100 != Bitmap.Config.ARGB_8888) goto L7;
        this.mBitmapConfig = r100;
        return;
    L7:
        throw new IllegalArgumentException("Unsupported format: " + r100 + ", must be one of " + Bitmap.Config.ARGB_8888);
    }

    private void cacheFrameBitmap(int r100, Bitmap r101) {
        this.mFrameBitmapCache.remove(Integer.valueOf(r100));
        Bitmap r102 = this.mBitmapProvider.obtain(r101.getWidth(), r101.getHeight(), r101.getConfig());
        r102.eraseColor(0);
        r102.setDensity(r101.getDensity());
        Canvas r103 = new Canvas(r102);
        r103.drawColor(0, PorterDuff.Mode.SRC);
        r103.drawBitmap(r101, 0.0f, 0.0f, null);
        this.mFrameBitmapCache.put(Integer.valueOf(r100), r102);
    }

    private void disposeToBackground(Canvas r110, WebpFrameInfo r111) {
        int r100 = r111.xOffset;
        int r101 = this.sampleSize;
        int r102 = r111.yOffset;
        r110.drawRect(r100 / r101, r102 / r101, (r100 + r111.width) / r101, (r102 + r111.height) / r101, this.mTransparentFillPaint);
    }

    private int prepareCanvasWithBlending(int r100, Canvas r101) {
    L2:
        if (r100 < 0) goto L23;
        WebpFrameInfo r102 = this.mFrameInfos[r100];
        if (r102.disposeBackgroundColor == true) goto L6;
    L10:
        Bitmap r103 = this.mFrameBitmapCache.get(Integer.valueOf(r100));
        if (r103 == null) goto L20;
        if (r103.isRecycled() == true) goto L20;
        r103.setDensity(r101.getDensity());
        r101.drawBitmap(r103, 0.0f, 0.0f, null);
        if (r102.disposeBackgroundColor == false) goto L18;
        disposeToBackground(r101, r102);
    L18:
        return r100 + 1;
    L20:
        if (isKeyFrame(r100) == true) goto L21;
        r100 = r100 - 1;
        goto L2
    L21:
        return r100;
    L6:
        if (isFullFrame(r102) == false) goto L10;
        return r100 + 1;
    L23:
        return 0;
    }

    private void renderFrame(int r100, Canvas r101) {
        WebpImage r102 = this.mWebPImage;
        if (r102 != null) goto L5;
        return;
    L5:
        WebpFrameInfo r103 = this.mFrameInfos[r100];
        int r104 = r103.width;
        int r105 = this.sampleSize;
        int r106 = r104 / r105;
        int r107 = r103.height / r105;
        int r108 = r103.xOffset / r105;
        int r109 = r103.yOffset / r105;
        if (r106 == 0) goto L19;
        if (r107 == 0) goto L23;
        WebpFrame r110 = r102.getFrame(r100);
        Bitmap r111 = this.mBitmapProvider.obtain(r106, r107, this.mBitmapConfig);     // Catch: Throwable -> L12 Throwable -> L14
        r111.eraseColor(0);     // Catch: Throwable -> L12 Throwable -> L14
        r111.setDensity(r101.getDensity());     // Catch: Throwable -> L12 Throwable -> L14
        r110.renderFrame(r106, r107, r111);     // Catch: Throwable -> L12 Throwable -> L14
        r101.drawBitmap(r111, r108, r109, null);     // Catch: Throwable -> L12 Throwable -> L14
        this.mBitmapProvider.release(r111);     // Catch: Throwable -> L12 Throwable -> L14
    L12:
        th = move-exception;
        r110.dispose();
        throw th;
    L15:
        r110.dispose();
        return;
    L23:
        return;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader r100, byte[] r101) {
        setData(r100, ByteBuffer.wrap(r101));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader r100, ByteBuffer r101) {
        setData(r100, r101, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setData(GifHeader r100, ByteBuffer r101, int r102) {
        if (r102 <= 0) goto L6;
        int r103 = Integer.highestOneBit(r102);
        ByteBuffer r104 = r101.asReadOnlyBuffer();
        this.rawData = r104;
        r104.position(0);
        this.sampleSize = r103;
        this.downsampledWidth = this.mWebPImage.getWidth() / r103;
        this.downsampledHeight = this.mWebPImage.getHeight() / r103;
        return;
    L6:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r102);
    }

    public WebpDecoder(Context r100, GifDecoder.BitmapProvider r101, WebpImage r110, ByteBuffer r111, int r112) {
        this(r100, r101, r110, r111, r112, WebpFrameCacheStrategy.NONE);
    }

    public WebpDecoder(Context r100, GifDecoder.BitmapProvider r101, WebpImage r102, ByteBuffer r103, int r104, WebpFrameCacheStrategy r105) {
        this.mFramePointer = -1;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.mContext = r100;
        this.mBitmapProvider = r101;
        this.mWebPImage = r102;
        this.mFrameDurations = r102.getFrameDurations();
        this.mFrameInfos = new WebpFrameInfo[r102.getFrameCount()];
        int r106 = 0;
    L4:
        if (r106 >= this.mWebPImage.getFrameCount()) goto L9;
        this.mFrameInfos[r106] = this.mWebPImage.getFrameInfo(r106);
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        this.mFrameInfos[r106].toString();
    L8:
        r106 = r106 + 1;
        goto L4
    L9:
        this.mCacheStrategy = r105;
        Paint r107 = new Paint();
        this.mTransparentFillPaint = r107;
        r107.setColor(0);
        r107.setStyle(Paint.Style.FILL);
        r107.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (this.mCacheStrategy.cacheAll() == false) goto L12;
        final int r108 = r102.getFrameCount();
    L13:
        this.mFrameBitmapCache = new AnonymousClass1(this, r108);
        setData(new GifHeader(), r103, r104);
        return;
    L12:
        r108 = Math.max(5, this.mCacheStrategy.getCacheSize());
        goto L13
    }
}
