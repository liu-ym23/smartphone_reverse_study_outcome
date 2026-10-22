package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    public static final Option<Boolean> DISABLE_ANIMATION = null;
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
    private static TransformCallback sCallback;
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private Drawable errorPlaceholder;
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
    private Options options;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private float sizeMultiplier;
    private Resources.Theme theme;
    private Map<Class<?>, Transformation<?>> transformations;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    public interface TransformCallback {
        void onTransform(BaseRequestOptions r100, Transformation<Bitmap> r101, boolean r102);
    }

    private static boolean isSet(int r100, int r101) {
        if ((r100 & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private T self() {
        return this;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public T lock() {
        this.isLocked = true;
        return (T) self();
    }

    static {
        DISABLE_ANIMATION = Option.memory("com.bumptech.glide.request.BaseRequestOptions.DisableAnimation", Boolean.FALSE);
    }

    private T selfOrThrowIfLocked() {
        if (this.isLocked == true) goto L7;
        return (T) self();
    L7:
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public T autoClone() {
        if (this.isLocked == true) goto L5;
    L9:
        this.isAutoCloneEnabled = true;
        return (T) lock();
    L5:
        if (this.isAutoCloneEnabled == true) goto L9;
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public T centerCrop() {
        return (T) transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T centerInside() {
        return (T) scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T circleCrop() {
        return (T) transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    public T disallowHardwareConfig() {
        return (T) set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    public T dontAnimate() {
        return (T) set(DISABLE_ANIMATION, Boolean.TRUE);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.transformations.clear();
        int r100 = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (r100 & (-131073)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().dontTransform();
    }

    public T fitCenter() {
        return (T) scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public int hashCode() {
        int r100 = Util.hashCode(this.sizeMultiplier);
        int r101 = Util.hashCode(this.errorId, r100);
        int r102 = Util.hashCode(this.errorPlaceholder, r101);
        int r103 = Util.hashCode(this.placeholderId, r102);
        int r104 = Util.hashCode(this.placeholderDrawable, r103);
        int r105 = Util.hashCode(this.fallbackId, r104);
        int r106 = Util.hashCode(this.fallbackDrawable, r105);
        int r107 = Util.hashCode(this.isCacheable, r106);
        int r108 = Util.hashCode(this.overrideHeight, r107);
        int r109 = Util.hashCode(this.overrideWidth, r108);
        int r110 = Util.hashCode(this.isTransformationRequired, r109);
        int r111 = Util.hashCode(this.isTransformationAllowed, r110);
        int r112 = Util.hashCode(this.useUnlimitedSourceGeneratorsPool, r111);
        int r113 = Util.hashCode(this.onlyRetrieveFromCache, r112);
        int r114 = Util.hashCode(this.diskCacheStrategy, r113);
        int r115 = Util.hashCode(this.priority, r114);
        int r116 = Util.hashCode(this.options, r115);
        int r117 = Util.hashCode(this.transformations, r116);
        int r118 = Util.hashCode(this.resourceClass, r117);
        int r119 = Util.hashCode(this.signature, r118);
        return Util.hashCode(this.theme, r119);
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public T optionalCenterCrop() {
        return (T) optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T optionalCircleCrop() {
        return (T) optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

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

    public T clone() {
        T r100 = (T) super.clone();     // Catch: CloneNotSupportedException -> L4
        Options r101 = new Options();     // Catch: CloneNotSupportedException -> L4
        r100.options = r101;     // Catch: CloneNotSupportedException -> L4
        r101.putAll(this.options);     // Catch: CloneNotSupportedException -> L4
        CachedHashCodeArrayMap r102 = new CachedHashCodeArrayMap();     // Catch: CloneNotSupportedException -> L4
        r100.transformations = r102;     // Catch: CloneNotSupportedException -> L4
        r102.putAll(this.transformations);     // Catch: CloneNotSupportedException -> L4
        r100.isLocked = false;     // Catch: CloneNotSupportedException -> L4
        r100.isAutoCloneEnabled = false;     // Catch: CloneNotSupportedException -> L4
        return r100;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo8140clone() throws CloneNotSupportedException {
        return clone();
    }

    private boolean isSet(int r100) {
        return isSet(this.fields, r100);
    }

    public static void setTransformCallback(TransformCallback r100) {
        sCallback = r100;
    }

    public T apply(BaseRequestOptions<?> r100) {
        if (this.isAutoCloneEnabled == false) goto L7;
        return (T) clone().apply(r100);
    L7:
        if (isSet(r100.fields, 2) == false) goto L10;
        this.sizeMultiplier = r100.sizeMultiplier;
    L10:
        if (isSet(r100.fields, 262144) == false) goto L13;
        this.useUnlimitedSourceGeneratorsPool = r100.useUnlimitedSourceGeneratorsPool;
    L13:
        if (isSet(r100.fields, 1048576) == false) goto L16;
        this.useAnimationPool = r100.useAnimationPool;
    L16:
        if (isSet(r100.fields, 4) == false) goto L19;
        this.diskCacheStrategy = r100.diskCacheStrategy;
    L19:
        if (isSet(r100.fields, 8) == false) goto L22;
        this.priority = r100.priority;
    L22:
        if (isSet(r100.fields, 16) == false) goto L25;
        this.errorPlaceholder = r100.errorPlaceholder;
        this.errorId = 0;
        this.fields &= -33;
    L25:
        if (isSet(r100.fields, 32) == false) goto L28;
        this.errorId = r100.errorId;
        this.errorPlaceholder = null;
        this.fields &= -17;
    L28:
        if (isSet(r100.fields, 64) == false) goto L31;
        this.placeholderDrawable = r100.placeholderDrawable;
        this.placeholderId = 0;
        this.fields &= -129;
    L31:
        if (isSet(r100.fields, 128) == false) goto L34;
        this.placeholderId = r100.placeholderId;
        this.placeholderDrawable = null;
        this.fields &= -65;
    L34:
        if (isSet(r100.fields, 256) == false) goto L37;
        this.isCacheable = r100.isCacheable;
    L37:
        if (isSet(r100.fields, 512) == false) goto L40;
        this.overrideWidth = r100.overrideWidth;
        this.overrideHeight = r100.overrideHeight;
    L40:
        if (isSet(r100.fields, 1024) == false) goto L43;
        this.signature = r100.signature;
    L43:
        if (isSet(r100.fields, 4096) == false) goto L46;
        this.resourceClass = r100.resourceClass;
    L46:
        if (isSet(r100.fields, 8192) == false) goto L49;
        this.fallbackDrawable = r100.fallbackDrawable;
        this.fallbackId = 0;
        this.fields &= -16385;
    L49:
        if (isSet(r100.fields, 16384) == false) goto L52;
        this.fallbackId = r100.fallbackId;
        this.fallbackDrawable = null;
        this.fields &= -8193;
    L52:
        if (isSet(r100.fields, 32768) == false) goto L55;
        this.theme = r100.theme;
    L55:
        if (isSet(r100.fields, 65536) == false) goto L58;
        this.isTransformationAllowed = r100.isTransformationAllowed;
    L58:
        if (isSet(r100.fields, 131072) == false) goto L61;
        this.isTransformationRequired = r100.isTransformationRequired;
    L61:
        if (isSet(r100.fields, 2048) == false) goto L64;
        this.transformations.putAll(r100.transformations);
        this.isScaleOnlyOrNoTransform = r100.isScaleOnlyOrNoTransform;
    L64:
        if (isSet(r100.fields, 524288) == false) goto L67;
        this.onlyRetrieveFromCache = r100.onlyRetrieveFromCache;
    L67:
        if (this.isTransformationAllowed == true) goto L69;
        this.transformations.clear();
        int r101 = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.fields = r101 & (-131073);
        this.isScaleOnlyOrNoTransform = true;
    L69:
        this.fields |= r100.fields;
        this.options.putAll(r100.options);
        return (T) selfOrThrowIfLocked();
    }

    public T decode(Class<?> r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.resourceClass = (Class) Preconditions.checkNotNull(r100);
        this.fields |= 4096;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().decode(r100);
    }

    public T diskCacheStrategy(DiskCacheStrategy r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(r100);
        this.fields |= 4;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().diskCacheStrategy(r100);
    }

    public T downsample(DownsampleStrategy r100) {
        return (T) set(DownsampleStrategy.OPTION, (DownsampleStrategy) Preconditions.checkNotNull(r100));
    }

    public T encodeFormat(Bitmap.CompressFormat r100) {
        return (T) set(BitmapEncoder.COMPRESSION_FORMAT, (Bitmap.CompressFormat) Preconditions.checkNotNull(r100));
    }

    public T encodeQuality(int r100) {
        return (T) set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(r100));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof BaseRequestOptions) == false) goto L48;
        BaseRequestOptions r101 = (BaseRequestOptions) r100;
        if (Float.compare(r101.sizeMultiplier, this.sizeMultiplier) == 0) goto L7;
        return false;
    L7:
        if (this.errorId == r101.errorId) goto L9;
        return false;
    L9:
        if (Util.bothNullOrEqual(this.errorPlaceholder, r101.errorPlaceholder) == true) goto L11;
        return false;
    L11:
        if (this.placeholderId == r101.placeholderId) goto L13;
        return false;
    L13:
        if (Util.bothNullOrEqual(this.placeholderDrawable, r101.placeholderDrawable) == true) goto L15;
        return false;
    L15:
        if (this.fallbackId == r101.fallbackId) goto L17;
        return false;
    L17:
        if (Util.bothNullOrEqual(this.fallbackDrawable, r101.fallbackDrawable) == true) goto L19;
        return false;
    L19:
        if (this.isCacheable == r101.isCacheable) goto L21;
        return false;
    L21:
        if (this.overrideHeight == r101.overrideHeight) goto L23;
        return false;
    L23:
        if (this.overrideWidth == r101.overrideWidth) goto L25;
        return false;
    L25:
        if (this.isTransformationRequired == r101.isTransformationRequired) goto L27;
        return false;
    L27:
        if (this.isTransformationAllowed == r101.isTransformationAllowed) goto L29;
        return false;
    L29:
        if (this.useUnlimitedSourceGeneratorsPool == r101.useUnlimitedSourceGeneratorsPool) goto L31;
        return false;
    L31:
        if (this.onlyRetrieveFromCache == r101.onlyRetrieveFromCache) goto L33;
        return false;
    L33:
        if (this.diskCacheStrategy.equals(r101.diskCacheStrategy) == true) goto L35;
        return false;
    L35:
        if (this.priority == r101.priority) goto L37;
        return false;
    L37:
        if (this.options.equals(r101.options) == true) goto L39;
        return false;
    L39:
        if (this.transformations.equals(r101.transformations) == true) goto L41;
        return false;
    L41:
        if (this.resourceClass.equals(r101.resourceClass) == true) goto L43;
        return false;
    L43:
        if (Util.bothNullOrEqual(this.signature, r101.signature) == true) goto L45;
        return false;
    L45:
        if (Util.bothNullOrEqual(this.theme, r101.theme) == false) goto L69;
        return true;
    L69:
        return false;
    L48:
        return false;
    }

    public T error(int r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.errorId = r100;
        int r101 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = r101 & (-17);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().error(r100);
    }

    public T fallback(int r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.fallbackId = r100;
        int r101 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = r101 & (-8193);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().fallback(r100);
    }

    public T format(DecodeFormat r100) {
        Preconditions.checkNotNull(r100);
        return (T) set(Downsampler.DECODE_FORMAT, r100).set(GifOptions.DECODE_FORMAT, r100);
    }

    public T frame(long r100) {
        return (T) set(VideoDecoder.TARGET_FRAME, Long.valueOf(r100));
    }

    public T onlyRetrieveFromCache(boolean r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.onlyRetrieveFromCache = r100;
        this.fields |= 524288;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().onlyRetrieveFromCache(r100);
    }

    public T optionalTransform(Transformation<Bitmap> r100) {
        return (T) transform(r100, false);
    }

    public T override(int r100) {
        return (T) override(r100, r100);
    }

    public T placeholder(int r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.placeholderId = r100;
        int r101 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = r101 & (-65);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().placeholder(r100);
    }

    public T priority(Priority r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.priority = (Priority) Preconditions.checkNotNull(r100);
        this.fields |= 8;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().priority(r100);
    }

    public T signature(Key r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.signature = (Key) Preconditions.checkNotNull(r100);
        this.fields |= 1024;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().signature(r100);
    }

    public T sizeMultiplier(float r100) {
        if (this.isAutoCloneEnabled == false) goto L7;
        return (T) clone().sizeMultiplier(r100);
    L7:
        if (r100 < 0.0f) goto L13;
        if (r100 > 1.0f) goto L13;
        this.sizeMultiplier = r100;
        this.fields |= 2;
        return (T) selfOrThrowIfLocked();
    L13:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T skipMemoryCache(boolean r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.isCacheable = !r100;
        this.fields |= 256;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().skipMemoryCache(true);
    }

    public T theme(Resources.Theme r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.theme = r100;
        this.fields |= 32768;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().theme(r100);
    }

    public T timeout(int r100) {
        return (T) set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(r100));
    }

    public T transform(Transformation<Bitmap>... r100) {
        if (r100.length <= 1) goto L7;
        return (T) transform(new MultiTransformation(r100), true);
    L7:
        if (r100.length != 1) goto L11;
        return (T) transform(r100[0]);
    L11:
        return (T) selfOrThrowIfLocked();
    }

    public T transforms(Transformation<Bitmap>... r100) {
        return (T) transform(new MultiTransformation(r100), true);
    }

    public T useAnimationPool(boolean r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.useAnimationPool = r100;
        this.fields |= 1048576;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().useAnimationPool(r100);
    }

    public T useUnlimitedSourceGeneratorsPool(boolean r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.useUnlimitedSourceGeneratorsPool = r100;
        this.fields |= 262144;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().useUnlimitedSourceGeneratorsPool(r100);
    }

    public T error(Drawable r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.errorPlaceholder = r100;
        int r101 = this.fields | 16;
        this.errorId = 0;
        this.fields = r101 & (-33);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().error(r100);
    }

    public T fallback(Drawable r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.fallbackDrawable = r100;
        int r101 = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = r101 & (-16385);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().fallback(r100);
    }

    public T placeholder(Drawable r100) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.placeholderDrawable = r100;
        int r101 = this.fields | 64;
        this.placeholderId = 0;
        this.fields = r101 & (-129);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().placeholder(r100);
    }

    public T transform(Transformation<Bitmap> r100) {
        return (T) transform(r100, true);
    }

    private T optionalScaleOnlyTransform(DownsampleStrategy r100, Transformation<Bitmap> r101) {
        return (T) scaleOnlyTransform(r100, r101, false);
    }

    private T scaleOnlyTransform(DownsampleStrategy r100, Transformation<Bitmap> r101) {
        return (T) scaleOnlyTransform(r100, r101, true);
    }

    public final T optionalTransform(DownsampleStrategy r100, Transformation<Bitmap> r101) {
        if (this.isAutoCloneEnabled == true) goto L5;
        downsample(r100);
        return (T) transform(r101, false);
    L5:
        return (T) clone().optionalTransform(r100, r101);
    }

    public T override(int r100, int r101) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.overrideWidth = r100;
        this.overrideHeight = r101;
        this.fields |= 512;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().override(r100, r101);
    }

    public <Y> T set(Option<Y> r100, Y r101) {
        if (this.isAutoCloneEnabled == true) goto L5;
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        this.options.set(r100, r101);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().set(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T transform(Transformation<Bitmap> r100, boolean r101) {
        if (this.isAutoCloneEnabled == true) goto L5;
        DrawableTransformation r102 = new DrawableTransformation(r100, r101);
        transform(Bitmap.class, r100, r101);
        transform(Drawable.class, r102, r101);
        transform(BitmapDrawable.class, r102.asBitmapDrawable(), r101);
        transform(GifDrawable.class, new GifDrawableTransformation(r100), r101);
        TransformCallback r103 = sCallback;
        if (r103 == null) goto L10;
        r103.onTransform(this, r100, r101);
    L10:
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().transform(r100, r101);
    }

    public <Y> T optionalTransform(Class<Y> r100, Transformation<Y> r101) {
        return (T) transform(r100, r101, false);
    }

    public final T transform(DownsampleStrategy r100, Transformation<Bitmap> r101) {
        if (this.isAutoCloneEnabled == true) goto L5;
        downsample(r100);
        return (T) transform(r101);
    L5:
        return (T) clone().transform(r100, r101);
    }

    public <Y> T transform(Class<Y> r100, Transformation<Y> r101) {
        return (T) transform(r100, r101, true);
    }

    private T scaleOnlyTransform(DownsampleStrategy r100, Transformation<Bitmap> r101, boolean r102) {
        if (r102 == false) goto L4;
        T r103 = (T) transform(r100, r101);
    L5:
        r103.isScaleOnlyOrNoTransform = true;
        return r103;
    L4:
        r103 = (T) optionalTransform(r100, r101);
        goto L5
    }

    public T gifLimit(int r100, int r101, int r102) {
        return (T) set(GifOptions.MAX_WIDTH, Integer.valueOf(r100)).set(GifOptions.MAX_HEIGHT, Integer.valueOf(r101)).set(GifOptions.FILE_SIZE, Integer.valueOf(r102));
    }

    public <Y> T transform(Class<Y> r100, Transformation<Y> r101, boolean r102) {
        if (this.isAutoCloneEnabled == true) goto L5;
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        this.transformations.put(r100, r101);
        int r103 = this.fields | 2048;
        this.isTransformationAllowed = true;
        int r104 = r103 | 65536;
        this.fields = r104;
        this.isScaleOnlyOrNoTransform = false;
        if (r102 == false) goto L10;
        this.fields = r104 | 131072;
        this.isTransformationRequired = true;
    L10:
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().transform(r100, r101, r102);
    }
}
