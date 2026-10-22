package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;

    @NonNull
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;

    @Nullable
    private Drawable errorPlaceholder;

    @Nullable
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isCacheable;
    private boolean isLocked;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationAllowed;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;

    @NonNull
    private Options options;
    private int overrideHeight;
    private int overrideWidth;

    @Nullable
    private Drawable placeholderDrawable;
    private int placeholderId;

    @NonNull
    private Priority priority;

    @NonNull
    private Class<?> resourceClass;

    @NonNull
    private Key signature;
    private float sizeMultiplier;

    @Nullable
    private Resources.Theme theme;

    @NonNull
    private Map<Class<?>, Transformation<?>> transformations;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    public BaseRequestOptions() {
        this.sizeMultiplier = 1.0f;
        this.diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        this.priority = Priority.NORMAL;
        this.isCacheable = true;
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.signature = EmptySignature.obtain();
        this.isTransformationAllowed = true;
        this.options = new Options();
        this.transformations = new CachedHashCodeArrayMap();
        this.resourceClass = Object.class;
        this.isScaleOnlyOrNoTransform = true;
    }

    private static boolean isSet(int r10, int r11) {
        if ((r10 & r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    private T optionalScaleOnlyTransform(@NonNull DownsampleStrategy r10, @NonNull Transformation<Bitmap> r11) {
        return (T) scaleOnlyTransform(r10, r11, false);
    }

    @NonNull
    private T scaleOnlyTransform(@NonNull DownsampleStrategy r10, @NonNull Transformation<Bitmap> r11) {
        return (T) scaleOnlyTransform(r10, r11, true);
    }

    private T self() {
        return this;
    }

    @NonNull
    private T selfOrThrowIfLocked() {
        if (this.isLocked == true) goto L7;
        return (T) self();
    L7:
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    @CheckResult
    public T apply(@NonNull BaseRequestOptions<?> r10) {
        if (this.isAutoCloneEnabled == false) goto L7;
        return (T) clone().apply(r10);
    L7:
        if (isSet(r10.fields, 2) == false) goto L10;
        this.sizeMultiplier = r10.sizeMultiplier;
    L10:
        if (isSet(r10.fields, 262144) == false) goto L13;
        this.useUnlimitedSourceGeneratorsPool = r10.useUnlimitedSourceGeneratorsPool;
    L13:
        if (isSet(r10.fields, 1048576) == false) goto L16;
        this.useAnimationPool = r10.useAnimationPool;
    L16:
        if (isSet(r10.fields, 4) == false) goto L19;
        this.diskCacheStrategy = r10.diskCacheStrategy;
    L19:
        if (isSet(r10.fields, 8) == false) goto L22;
        this.priority = r10.priority;
    L22:
        if (isSet(r10.fields, 16) == false) goto L25;
        this.errorPlaceholder = r10.errorPlaceholder;
        this.errorId = 0;
        this.fields &= -33;
    L25:
        if (isSet(r10.fields, 32) == false) goto L28;
        this.errorId = r10.errorId;
        this.errorPlaceholder = null;
        this.fields &= -17;
    L28:
        if (isSet(r10.fields, 64) == false) goto L31;
        this.placeholderDrawable = r10.placeholderDrawable;
        this.placeholderId = 0;
        this.fields &= -129;
    L31:
        if (isSet(r10.fields, 128) == false) goto L34;
        this.placeholderId = r10.placeholderId;
        this.placeholderDrawable = null;
        this.fields &= -65;
    L34:
        if (isSet(r10.fields, 256) == false) goto L37;
        this.isCacheable = r10.isCacheable;
    L37:
        if (isSet(r10.fields, 512) == false) goto L40;
        this.overrideWidth = r10.overrideWidth;
        this.overrideHeight = r10.overrideHeight;
    L40:
        if (isSet(r10.fields, 1024) == false) goto L43;
        this.signature = r10.signature;
    L43:
        if (isSet(r10.fields, 4096) == false) goto L46;
        this.resourceClass = r10.resourceClass;
    L46:
        if (isSet(r10.fields, 8192) == false) goto L49;
        this.fallbackDrawable = r10.fallbackDrawable;
        this.fallbackId = 0;
        this.fields &= -16385;
    L49:
        if (isSet(r10.fields, 16384) == false) goto L52;
        this.fallbackId = r10.fallbackId;
        this.fallbackDrawable = null;
        this.fields &= -8193;
    L52:
        if (isSet(r10.fields, 32768) == false) goto L55;
        this.theme = r10.theme;
    L55:
        if (isSet(r10.fields, 65536) == false) goto L58;
        this.isTransformationAllowed = r10.isTransformationAllowed;
    L58:
        if (isSet(r10.fields, 131072) == false) goto L61;
        this.isTransformationRequired = r10.isTransformationRequired;
    L61:
        if (isSet(r10.fields, 2048) == false) goto L64;
        this.transformations.putAll(r10.transformations);
        this.isScaleOnlyOrNoTransform = r10.isScaleOnlyOrNoTransform;
    L64:
        if (isSet(r10.fields, 524288) == false) goto L67;
        this.onlyRetrieveFromCache = r10.onlyRetrieveFromCache;
    L67:
        if (this.isTransformationAllowed == true) goto L69;
        this.transformations.clear();
        int r11 = this.fields;
        this.isTransformationRequired = false;
        this.fields = r11 & (-133121);
        this.isScaleOnlyOrNoTransform = true;
    L69:
        this.fields |= r10.fields;
        this.options.putAll(r10.options);
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    public T autoClone() {
        if (this.isLocked == true) goto L5;
    L9:
        this.isAutoCloneEnabled = true;
        return (T) lock();
    L5:
        if (this.isAutoCloneEnabled == true) goto L9;
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    @NonNull
    @CheckResult
    public T centerCrop() {
        return (T) transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T centerInside() {
        return (T) scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @NonNull
    @CheckResult
    public T circleCrop() {
        return (T) transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    @CheckResult
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo5clone() throws CloneNotSupportedException {
        return clone();
    }

    @NonNull
    @CheckResult
    public T decode(@NonNull Class<?> r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.resourceClass = (Class) Preconditions.checkNotNull(r10);
        this.fields |= 4096;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().decode(r10);
    }

    @NonNull
    @CheckResult
    public T disallowHardwareConfig() {
        return (T) set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T diskCacheStrategy(@NonNull DiskCacheStrategy r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(r10);
        this.fields |= 4;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().diskCacheStrategy(r10);
    }

    @NonNull
    @CheckResult
    public T dontAnimate() {
        return (T) set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public T dontTransform() {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.transformations.clear();
        int r10 = this.fields;
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (r10 & (-133121)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().dontTransform();
    }

    @NonNull
    @CheckResult
    public T downsample(@NonNull DownsampleStrategy r10) {
        return (T) set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(r10));
    }

    @NonNull
    @CheckResult
    public T encodeFormat(@NonNull Bitmap.CompressFormat r10) {
        return (T) set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(r10));
    }

    @NonNull
    @CheckResult
    public T encodeQuality(@IntRange(from = 0, to = AnimationConstants.DURATION_100L) int r10) {
        return (T) set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(r10));
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof BaseRequestOptions) == false) goto L48;
        BaseRequestOptions r11 = (BaseRequestOptions) r10;
        if (Float.compare(r11.sizeMultiplier, this.sizeMultiplier) == 0) goto L7;
        return false;
    L7:
        if (this.errorId == r11.errorId) goto L9;
        return false;
    L9:
        if (Util.bothNullOrEqual(this.errorPlaceholder, r11.errorPlaceholder) == true) goto L11;
        return false;
    L11:
        if (this.placeholderId == r11.placeholderId) goto L13;
        return false;
    L13:
        if (Util.bothNullOrEqual(this.placeholderDrawable, r11.placeholderDrawable) == true) goto L15;
        return false;
    L15:
        if (this.fallbackId == r11.fallbackId) goto L17;
        return false;
    L17:
        if (Util.bothNullOrEqual(this.fallbackDrawable, r11.fallbackDrawable) == true) goto L19;
        return false;
    L19:
        if (this.isCacheable == r11.isCacheable) goto L21;
        return false;
    L21:
        if (this.overrideHeight == r11.overrideHeight) goto L23;
        return false;
    L23:
        if (this.overrideWidth == r11.overrideWidth) goto L25;
        return false;
    L25:
        if (this.isTransformationRequired == r11.isTransformationRequired) goto L27;
        return false;
    L27:
        if (this.isTransformationAllowed == r11.isTransformationAllowed) goto L29;
        return false;
    L29:
        if (this.useUnlimitedSourceGeneratorsPool == r11.useUnlimitedSourceGeneratorsPool) goto L31;
        return false;
    L31:
        if (this.onlyRetrieveFromCache == r11.onlyRetrieveFromCache) goto L33;
        return false;
    L33:
        if (this.diskCacheStrategy.equals(r11.diskCacheStrategy) == true) goto L35;
        return false;
    L35:
        if (this.priority == r11.priority) goto L37;
        return false;
    L37:
        if (this.options.equals(r11.options) == true) goto L39;
        return false;
    L39:
        if (this.transformations.equals(r11.transformations) == true) goto L41;
        return false;
    L41:
        if (this.resourceClass.equals(r11.resourceClass) == true) goto L43;
        return false;
    L43:
        if (Util.bothNullOrEqual(this.signature, r11.signature) == true) goto L45;
        return false;
    L45:
        if (Util.bothNullOrEqual(this.theme, r11.theme) == false) goto L69;
        return true;
    L69:
        return false;
    L48:
        return false;
    }

    @NonNull
    @CheckResult
    public T error(@Nullable Drawable r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.errorPlaceholder = r10;
        int r11 = this.fields | 16;
        this.errorId = 0;
        this.fields = r11 & (-33);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().error(r10);
    }

    @NonNull
    @CheckResult
    public T fallback(@Nullable Drawable r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.fallbackDrawable = r10;
        int r11 = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = r11 & (-16385);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().fallback(r10);
    }

    @NonNull
    @CheckResult
    public T fitCenter() {
        return (T) scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @NonNull
    @CheckResult
    public T format(@NonNull DecodeFormat r10) {
        Preconditions.checkNotNull(r10);
        return (T) set(Downsampler.DECODE_FORMAT, r10).set(GifOptions.DECODE_FORMAT, r10);
    }

    @NonNull
    @CheckResult
    public T frame(@IntRange(from = 0) long r10) {
        return (T) set(VideoDecoder.TARGET_FRAME, Long.valueOf(r10));
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    @NonNull
    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    @NonNull
    public final Priority getPriority() {
        return this.priority;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    @NonNull
    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.theme;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        int r10 = Util.hashCode(this.sizeMultiplier);
        int r11 = Util.hashCode(this.errorId, r10);
        int r12 = Util.hashCode(this.errorPlaceholder, r11);
        int r13 = Util.hashCode(this.placeholderId, r12);
        int r14 = Util.hashCode(this.placeholderDrawable, r13);
        int r15 = Util.hashCode(this.fallbackId, r14);
        int r16 = Util.hashCode(this.fallbackDrawable, r15);
        int r17 = Util.hashCode(this.isCacheable, r16);
        int r18 = Util.hashCode(this.overrideHeight, r17);
        int r19 = Util.hashCode(this.overrideWidth, r18);
        int r20 = Util.hashCode(this.isTransformationRequired, r19);
        int r21 = Util.hashCode(this.isTransformationAllowed, r20);
        int r22 = Util.hashCode(this.useUnlimitedSourceGeneratorsPool, r21);
        int r23 = Util.hashCode(this.onlyRetrieveFromCache, r22);
        int r24 = Util.hashCode(this.diskCacheStrategy, r23);
        int r25 = Util.hashCode(this.priority, r24);
        int r26 = Util.hashCode(this.options, r25);
        int r27 = Util.hashCode(this.transformations, r26);
        int r28 = Util.hashCode(this.resourceClass, r27);
        int r29 = Util.hashCode(this.signature, r28);
        return Util.hashCode(this.theme, r29);
    }

    public boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    @NonNull
    public T lock() {
        this.isLocked = true;
        return (T) self();
    }

    @NonNull
    @CheckResult
    public T onlyRetrieveFromCache(boolean r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.onlyRetrieveFromCache = r10;
        this.fields |= 524288;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().onlyRetrieveFromCache(r10);
    }

    @NonNull
    @CheckResult
    public T optionalCenterCrop() {
        return (T) optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @NonNull
    @CheckResult
    public T optionalCircleCrop() {
        return (T) optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @NonNull
    public final T optionalTransform(@NonNull DownsampleStrategy r10, @NonNull Transformation<Bitmap> r11) {
        if (this.isAutoCloneEnabled == true) goto L5;
        downsample(r10);
        return (T) transform(r11, false);
    L5:
        return (T) clone().optionalTransform(r10, r11);
    }

    @NonNull
    @CheckResult
    public T override(int r10, int r11) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.overrideWidth = r10;
        this.overrideHeight = r11;
        this.fields |= 512;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().override(r10, r11);
    }

    @NonNull
    @CheckResult
    public T placeholder(@Nullable Drawable r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.placeholderDrawable = r10;
        int r11 = this.fields | 64;
        this.placeholderId = 0;
        this.fields = r11 & (-129);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().placeholder(r10);
    }

    @NonNull
    @CheckResult
    public T priority(@NonNull Priority r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.priority = (Priority) Preconditions.checkNotNull(r10);
        this.fields |= 8;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().priority(r10);
    }

    @NonNull
    @CheckResult
    public <Y> T set(@NonNull Option<Y> r10, @NonNull Y r11) {
        if (this.isAutoCloneEnabled == true) goto L5;
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        this.options.set(r10, r11);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().set(r10, r11);
    }

    @NonNull
    @CheckResult
    public T signature(@NonNull Key r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.signature = (Key) Preconditions.checkNotNull(r10);
        this.fields |= 1024;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().signature(r10);
    }

    @NonNull
    @CheckResult
    public T sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        if (this.isAutoCloneEnabled == false) goto L7;
        return (T) clone().sizeMultiplier(r10);
    L7:
        if (r10 < 0.0f) goto L13;
        if (r10 > 1.0f) goto L13;
        this.sizeMultiplier = r10;
        this.fields |= 2;
        return (T) selfOrThrowIfLocked();
    L13:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public T skipMemoryCache(boolean r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.isCacheable = !r10;
        this.fields |= 256;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().skipMemoryCache(true);
    }

    @NonNull
    @CheckResult
    public T theme(@Nullable Resources.Theme r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.theme = r10;
        this.fields |= 32768;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().theme(r10);
    }

    @NonNull
    @CheckResult
    public T timeout(@IntRange(from = 0) int r10) {
        return (T) set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(r10));
    }

    @NonNull
    @CheckResult
    public final T transform(@NonNull DownsampleStrategy r10, @NonNull Transformation<Bitmap> r11) {
        if (this.isAutoCloneEnabled == true) goto L5;
        downsample(r10);
        return (T) transform(r11);
    L5:
        return (T) clone().transform(r10, r11);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T transforms(@NonNull Transformation<Bitmap>... r10) {
        return (T) transform(new MultiTransformation(r10), true);
    }

    @NonNull
    @CheckResult
    public T useAnimationPool(boolean r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.useAnimationPool = r10;
        this.fields |= 1048576;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().useAnimationPool(r10);
    }

    @NonNull
    @CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.useUnlimitedSourceGeneratorsPool = r10;
        this.fields |= 262144;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().useUnlimitedSourceGeneratorsPool(r10);
    }

    private boolean isSet(int r10) {
        return isSet(this.fields, r10);
    }

    @NonNull
    private T scaleOnlyTransform(@NonNull DownsampleStrategy r10, @NonNull Transformation<Bitmap> r11, boolean r12) {
        if (r12 == false) goto L4;
        T r13 = (T) transform(r10, r11);
    L5:
        r13.isScaleOnlyOrNoTransform = true;
        return r13;
    L4:
        r13 = (T) optionalTransform(r10, r11);
        goto L5
    }

    @CheckResult
    public T clone() {
        T r10 = (T) super.clone();     // Catch: CloneNotSupportedException -> L4
        Options r11 = new Options();     // Catch: CloneNotSupportedException -> L4
        r10.options = r11;     // Catch: CloneNotSupportedException -> L4
        r11.putAll(this.options);     // Catch: CloneNotSupportedException -> L4
        CachedHashCodeArrayMap r12 = new CachedHashCodeArrayMap();     // Catch: CloneNotSupportedException -> L4
        r10.transformations = r12;     // Catch: CloneNotSupportedException -> L4
        r12.putAll(this.transformations);     // Catch: CloneNotSupportedException -> L4
        r10.isLocked = false;     // Catch: CloneNotSupportedException -> L4
        r10.isAutoCloneEnabled = false;     // Catch: CloneNotSupportedException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @NonNull
    @CheckResult
    public T optionalTransform(@NonNull Transformation<Bitmap> r10) {
        return (T) transform(r10, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap> r10) {
        return (T) transform(r10, true);
    }

    @NonNull
    @CheckResult
    public <Y> T optionalTransform(@NonNull Class<Y> r10, @NonNull Transformation<Y> r11) {
        return (T) transform(r10, r11, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap>... r10) {
        if (r10.length <= 1) goto L7;
        return (T) transform(new MultiTransformation(r10), true);
    L7:
        if (r10.length != 1) goto L11;
        return (T) transform(r10[0]);
    L11:
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T override(int r10) {
        return (T) override(r10, r10);
    }

    @NonNull
    @CheckResult
    public T error(@DrawableRes int r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.errorId = r10;
        int r11 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = r11 & (-17);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().error(r10);
    }

    @NonNull
    @CheckResult
    public T fallback(@DrawableRes int r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.fallbackId = r10;
        int r11 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = r11 & (-8193);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().fallback(r10);
    }

    @NonNull
    @CheckResult
    public T placeholder(@DrawableRes int r10) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.placeholderId = r10;
        int r11 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = r11 & (-65);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().placeholder(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T transform(@NonNull Transformation<Bitmap> r10, boolean r11) {
        if (this.isAutoCloneEnabled == true) goto L5;
        DrawableTransformation r12 = new DrawableTransformation(r10, r11);
        transform(Bitmap.class, r10, r11);
        transform(Drawable.class, r12, r11);
        transform(BitmapDrawable.class, r12.asBitmapDrawable(), r11);
        transform(GifDrawable.class, new GifDrawableTransformation(r10), r11);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().transform(r10, r11);
    }

    @NonNull
    public <Y> T transform(@NonNull Class<Y> r10, @NonNull Transformation<Y> r11, boolean r12) {
        if (this.isAutoCloneEnabled == true) goto L5;
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        this.transformations.put(r10, r11);
        int r13 = this.fields;
        this.isTransformationAllowed = true;
        this.fields = 67584 | r13;
        this.isScaleOnlyOrNoTransform = false;
        if (r12 == false) goto L10;
        this.fields = r13 | 198656;
        this.isTransformationRequired = true;
    L10:
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().transform(r10, r11, r12);
    }

    @NonNull
    @CheckResult
    public <Y> T transform(@NonNull Class<Y> r10, @NonNull Transformation<Y> r11) {
        return (T) transform(r10, r11, true);
    }
}
