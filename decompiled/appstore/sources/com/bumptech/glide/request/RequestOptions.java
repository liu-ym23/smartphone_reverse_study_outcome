package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bytedanceos.common.ui.animation.AnimationConstants;

/* JADX INFO: loaded from: classes.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {

    @Nullable
    private static RequestOptions centerCropOptions;

    @Nullable
    private static RequestOptions centerInsideOptions;

    @Nullable
    private static RequestOptions circleCropOptions;

    @Nullable
    private static RequestOptions fitCenterOptions;

    @Nullable
    private static RequestOptions noAnimationOptions;

    @Nullable
    private static RequestOptions noTransformOptions;

    @Nullable
    private static RequestOptions skipMemoryCacheFalseOptions;

    @Nullable
    private static RequestOptions skipMemoryCacheTrueOptions;

    public RequestOptions() {
    }

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> r10) {
        return new RequestOptions().transform(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerCropTransform() {
        if (centerCropOptions != null) goto L6;
        centerCropOptions = new RequestOptions().centerCrop().autoClone();
    L6:
        return centerCropOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions != null) goto L6;
        centerInsideOptions = new RequestOptions().centerInside().autoClone();
    L6:
        return centerInsideOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions circleCropTransform() {
        if (circleCropOptions != null) goto L6;
        circleCropOptions = new RequestOptions().circleCrop().autoClone();
    L6:
        return circleCropOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> r10) {
        return new RequestOptions().decode(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy r10) {
        return new RequestOptions().diskCacheStrategy(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy r10) {
        return new RequestOptions().downsample(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat r10) {
        return new RequestOptions().encodeFormat(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, to = AnimationConstants.DURATION_100L) int r10) {
        return new RequestOptions().encodeQuality(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable r10) {
        return new RequestOptions().error(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions != null) goto L6;
        fitCenterOptions = new RequestOptions().fitCenter().autoClone();
    L6:
        return fitCenterOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat r10) {
        return new RequestOptions().format(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long r10) {
        return new RequestOptions().frame(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions noAnimation() {
        if (noAnimationOptions != null) goto L6;
        noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
    L6:
        return noAnimationOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noTransformation() {
        if (noTransformOptions != null) goto L6;
        noTransformOptions = new RequestOptions().dontTransform().autoClone();
    L6:
        return noTransformOptions;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> r10, @NonNull T r11) {
        return new RequestOptions().set(r10, r11);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int r10, @IntRange(from = 0) int r11) {
        return new RequestOptions().override(r10, r11);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable r10) {
        return new RequestOptions().placeholder(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority r10) {
        return new RequestOptions().priority(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key r10) {
        return new RequestOptions().signature(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        return new RequestOptions().sizeMultiplier(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean r10) {
        if (r10 == false) goto L9;
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

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int r10) {
        return new RequestOptions().timeout(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int r10) {
        return new RequestOptions().error(r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int r10) {
        return overrideOf(r10, r10);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int r10) {
        return new RequestOptions().placeholder(r10);
    }
}
