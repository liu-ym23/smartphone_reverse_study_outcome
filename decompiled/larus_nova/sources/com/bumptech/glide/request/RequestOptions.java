package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: loaded from: classes39.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions != null) goto L6;
        centerCropOptions = new RequestOptions().centerCrop().autoClone();
    L6:
        return centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions != null) goto L6;
        centerInsideOptions = new RequestOptions().centerInside().autoClone();
    L6:
        return centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions != null) goto L6;
        circleCropOptions = new RequestOptions().circleCrop().autoClone();
    L6:
        return circleCropOptions;
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions != null) goto L6;
        fitCenterOptions = new RequestOptions().fitCenter().autoClone();
    L6:
        return fitCenterOptions;
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions != null) goto L6;
        noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
    L6:
        return noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions != null) goto L6;
        noTransformOptions = new RequestOptions().dontTransform().autoClone();
    L6:
        return noTransformOptions;
    }

    public RequestOptions() {
    }

    public static RequestOptions bitmapTransform(Transformation<Bitmap> r100) {
        return new RequestOptions().transform(r100);
    }

    public static RequestOptions decodeTypeOf(Class<?> r100) {
        return new RequestOptions().decode(r100);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy r100) {
        return new RequestOptions().diskCacheStrategy(r100);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy r100) {
        return new RequestOptions().downsample(r100);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat r100) {
        return new RequestOptions().encodeFormat(r100);
    }

    public static RequestOptions encodeQualityOf(int r100) {
        return new RequestOptions().encodeQuality(r100);
    }

    public static RequestOptions errorOf(int r100) {
        return new RequestOptions().error(r100);
    }

    public static RequestOptions formatOf(DecodeFormat r100) {
        return new RequestOptions().format(r100);
    }

    public static RequestOptions frameOf(long r100) {
        return new RequestOptions().frame(r100);
    }

    public static RequestOptions overrideOf(int r100) {
        return overrideOf(r100, r100);
    }

    public static RequestOptions placeholderOf(int r100) {
        return new RequestOptions().placeholder(r100);
    }

    public static RequestOptions priorityOf(Priority r100) {
        return new RequestOptions().priority(r100);
    }

    public static RequestOptions signatureOf(Key r100) {
        return new RequestOptions().signature(r100);
    }

    public static RequestOptions sizeMultiplierOf(float r100) {
        return new RequestOptions().sizeMultiplier(r100);
    }

    public static RequestOptions skipMemoryCacheOf(boolean r100) {
        if (r100 == false) goto L9;
        if (skipMemoryCacheTrueOptions != null) goto L7;
        skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
    L7:
        return skipMemoryCacheTrueOptions;
    L9:
        if (skipMemoryCacheFalseOptions != null) goto L12;
        skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
    L12:
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int r100) {
        return new RequestOptions().timeout(r100);
    }

    public static RequestOptions errorOf(Drawable r100) {
        return new RequestOptions().error(r100);
    }

    public static RequestOptions placeholderOf(Drawable r100) {
        return new RequestOptions().placeholder(r100);
    }

    public static <T> RequestOptions option(Option<T> r100, T r101) {
        return new RequestOptions().set(r100, r101);
    }

    public static RequestOptions overrideOf(int r100, int r101) {
        return new RequestOptions().override(r100, r101);
    }
}
