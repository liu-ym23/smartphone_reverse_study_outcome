package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = null;
    private final Context context;

    @Nullable
    private RequestBuilder<TranscodeType> errorBuilder;
    private final Glide glide;
    private final GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;

    @Nullable
    private Object model;

    @Nullable
    private List<RequestListener<TranscodeType>> requestListeners;
    private final RequestManager requestManager;

    @Nullable
    private Float thumbSizeMultiplier;

    @Nullable
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;

    @NonNull
    private TransitionOptions<?, ? super TranscodeType> transitionOptions;

    /* JADX INFO: renamed from: com.bumptech.glide.RequestBuilder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority = null;

        static {
            int[] r10 = new int[Priority.values().length];
            $SwitchMap$com$bumptech$glide$Priority = r10;
            r10[Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L34:
            $SwitchMap$com$bumptech$glide$Priority[Priority.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L44:
            $SwitchMap$com$bumptech$glide$Priority[Priority.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            $SwitchMap$com$bumptech$glide$Priority[Priority.IMMEDIATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r11 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r11;
            r11[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L36:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L42:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L32:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L52:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L38:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(@NonNull Glide r10, RequestManager r11, Class<TranscodeType> r12, Context r13) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = r10;
        this.requestManager = r11;
        this.transcodeClass = r12;
        this.context = r13;
        this.transitionOptions = r11.getDefaultTransitionOptions(r12);
        this.glideContext = r10.getGlideContext();
        initRequestListeners(r11.getDefaultRequestListeners());
        apply(r11.getDefaultRequestOptions());
    }

    private Request buildRequest(Target<TranscodeType> r11, @Nullable RequestListener<TranscodeType> r12, BaseRequestOptions<?> r13, Executor r14) {
        return buildRequestRecursive(r11, r12, null, this.transitionOptions, r13.getPriority(), r13.getOverrideWidth(), r13.getOverrideHeight(), r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Request buildRequestRecursive(Target<TranscodeType> r13, @Nullable RequestListener<TranscodeType> r14, @Nullable RequestCoordinator r15, TransitionOptions<?, ? super TranscodeType> r16, Priority r17, int r18, int r19, BaseRequestOptions<?> r20, Executor r21) {
        if (this.errorBuilder == null) goto L5;
        RequestCoordinator r10 = new ErrorRequestCoordinator(r15);
        ErrorRequestCoordinator r11 = r10;
    L6:
        Request r12 = buildThumbnailRequestRecursive(r13, r14, r10, r16, r17, r18, r19, r20, r21);
        if (r11 != 0) goto L9;
        return r12;
    L9:
        int r22 = this.errorBuilder.getOverrideWidth();
        int r23 = this.errorBuilder.getOverrideHeight();
        if (Util.isValidDimensions(r18, r19) == true) goto L12;
    L14:
        RequestBuilder<TranscodeType> r24 = this.errorBuilder;
        ErrorRequestCoordinator r25 = r11;
        r11.setRequests(r12, r24.buildRequestRecursive(r13, r14, r25, r24.transitionOptions, r24.getPriority(), r22, r23, this.errorBuilder, r21));
        return r11;
    L12:
        if (this.errorBuilder.isValidOverride() == true) goto L14;
        r22 = r20.getOverrideWidth();
        r23 = r20.getOverrideHeight();
        goto L14
    L5:
        r11 = 0;
        r10 = r15;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Request buildThumbnailRequestRecursive(Target<TranscodeType> r22, RequestListener<TranscodeType> r23, @Nullable RequestCoordinator r24, TransitionOptions<?, ? super TranscodeType> r25, Priority r26, int r27, int r28, BaseRequestOptions<?> r29, Executor r30) {
        RequestBuilder<TranscodeType> r10 = this.thumbnailBuilder;
        if (r10 == null) goto L25;
        if (this.isThumbnailBuilt == true) goto L23;
        TransitionOptions<?, ? super TranscodeType> r11 = r10.transitionOptions;
        if (r10.isDefaultTransitionOptionsSet == false) goto L9;
        TransitionOptions<?, ? super TranscodeType> r15 = r25;
    L11:
        if (r10.isPrioritySet() == false) goto L14;
        Priority r12 = this.thumbnailBuilder.getPriority();
    L13:
        Priority r16 = r12;
        int r13 = this.thumbnailBuilder.getOverrideWidth();
        int r14 = this.thumbnailBuilder.getOverrideHeight();
        if (Util.isValidDimensions(r27, r28) == true) goto L18;
    L20:
        int r17 = r13;
        int r18 = r14;
        ThumbnailRequestCoordinator r19 = new ThumbnailRequestCoordinator(r24);
        Request r20 = obtainRequest(r22, r23, r29, r19, r25, r26, r27, r28, r30);
        this.isThumbnailBuilt = true;
        RequestBuilder<TranscodeType> r21 = this.thumbnailBuilder;
        Request r31 = r21.buildRequestRecursive(r22, r23, r19, r15, r16, r17, r18, r21, r30);
        this.isThumbnailBuilt = false;
        r19.setRequests(r20, r31);
        return r19;
    L18:
        if (this.thumbnailBuilder.isValidOverride() == true) goto L20;
        r13 = r29.getOverrideWidth();
        r14 = r29.getOverrideHeight();
        goto L20
    L14:
        r12 = getThumbnailPriority(r26);
        goto L13
    L9:
        r15 = r11;
        goto L11
    L23:
        throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    L25:
        if (this.thumbSizeMultiplier == null) goto L29;
        ThumbnailRequestCoordinator r110 = new ThumbnailRequestCoordinator(r24);
        r110.setRequests(obtainRequest(r22, r23, r29, r110, r25, r26, r27, r28, r30), obtainRequest(r22, r23, r29.clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), r110, r25, getThumbnailPriority(r26), r27, r28, r30));
        return r110;
    L29:
        return obtainRequest(r22, r23, r29, r24, r25, r26, r27, r28, r30);
    }

    @NonNull
    private Priority getThumbnailPriority(@NonNull Priority r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$bumptech$glide$Priority[r10.ordinal()];
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L16;
        if (r11 == 3) goto L14;
        if (r11 == 4) goto L14;
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    L14:
        return Priority.IMMEDIATE;
    L16:
        return Priority.HIGH;
    L18:
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    private void initRequestListeners(List<RequestListener<Object>> r10) {
        Iterator<RequestListener<Object>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        addListener((RequestListener) r11.next());
        goto L4
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(BaseRequestOptions<?> r10, Request r11) {
        if (r10.isMemoryCacheable() == false) goto L5;
    L7:
        return false;
    L5:
        if (r11.isComplete() == false) goto L7;
        return true;
    }

    @NonNull
    private RequestBuilder<TranscodeType> loadGeneric(@Nullable Object r10) {
        this.model = r10;
        this.isModelSet = true;
        return this;
    }

    private Request obtainRequest(Target<TranscodeType> r16, RequestListener<TranscodeType> r17, BaseRequestOptions<?> r18, RequestCoordinator r19, TransitionOptions<?, ? super TranscodeType> r20, Priority r21, int r22, int r23, Executor r24) {
        Context r10 = this.context;
        GlideContext r11 = this.glideContext;
        return SingleRequest.obtain(r10, r11, this.model, this.transcodeClass, r18, r22, r23, r21, r16, r17, this.requestListeners, r19, r11.getEngine(), r20.getTransitionFactory(), r24);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> r10) {
        if (r10 != null) goto L4;
    L7:
        return this;
    L4:
        if (this.requestListeners != null) goto L6;
        this.requestListeners = new ArrayList();
    L6:
        this.requestListeners.add(r10);
        goto L7
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ BaseRequestOptions apply(@NonNull BaseRequestOptions r10) {
        return apply(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    public /* bridge */ /* synthetic */ BaseRequestOptions clone() {
        return clone();
    }

    @CheckResult
    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(@NonNull Y r10) {
        return (Y) getDownloadOnlyRequest().into(r10);
    }

    @NonNull
    public RequestBuilder<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> r10) {
        this.errorBuilder = r10;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y r10) {
        return (Y) into(r10, null, Executors.mainThreadExecutor());
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> listener(@Nullable RequestListener<TranscodeType> r10) {
        this.requestListeners = null;
        return addListener(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable Bitmap r10) {
        return load(r10);
    }

    @NonNull
    public Target<TranscodeType> preload(int r10, int r11) {
        return into(PreloadTarget.obtain(this.requestManager, r10, r11));
    }

    @NonNull
    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> r10) {
        this.thumbnailBuilder = r10;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> r10) {
        this.transitionOptions = (TransitionOptions) Preconditions.checkNotNull(r10);
        this.isDefaultTransitionOptionsSet = false;
        return this;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> apply(@NonNull BaseRequestOptions<?> r10) {
        Preconditions.checkNotNull(r10);
        return (RequestBuilder) super.apply(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo5clone() throws CloneNotSupportedException {
        return clone();
    }

    @CheckResult
    @Deprecated
    public FutureTarget<File> downloadOnly(int r10, int r11) {
        return getDownloadOnlyRequest().submit(r10, r11);
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y r10, @Nullable RequestListener<TranscodeType> r11, Executor r12) {
        return (Y) into(r10, r11, this, r12);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable Drawable r10) {
        return load(r10);
    }

    @NonNull
    public FutureTarget<TranscodeType> submit(int r10, int r11) {
        RequestFutureTarget r12 = new RequestFutureTarget(r10, r11);
        return (FutureTarget) into(r12, r12, Executors.directExecutor());
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... r10) {
        RequestBuilder<TranscodeType> r11 = null;
        if (r10 == null) goto L19;
        if (r10.length == 0) goto L19;
        int r12 = r10.length - 1;
    L8:
        if (r12 < 0) goto L17;
        RequestBuilder<TranscodeType> r13 = r10[r12];
        if (r13 == null) goto L15;
        if (r11 != null) goto L14;
        r11 = r13;
        goto L15
    L14:
        r11 = r13.thumbnail(r11);
    L15:
        r12 = r12 - 1;
        goto L8
    L17:
        return thumbnail(r11);
    L19:
        return thumbnail(null);
    }

    private <Y extends Target<TranscodeType>> Y into(@NonNull Y r10, @Nullable RequestListener<TranscodeType> r11, BaseRequestOptions<?> r12, Executor r13) {
        Preconditions.checkNotNull(r10);
        if (this.isModelSet == false) goto L15;
        Request r14 = buildRequest(r10, r11, r12, r13);
        Request r15 = r10.getRequest();
        if (r14.isEquivalentTo(r15) == true) goto L7;
    L12:
        this.requestManager.clear(r10);
        r10.setRequest(r14);
        this.requestManager.track(r10, r14);
        return r10;
    L7:
        if (isSkipMemoryCacheWithCompletePreviousRequest(r12, r15) == true) goto L12;
        r14.recycle();
        if (((Request) Preconditions.checkNotNull(r15)).isRunning() == true) goto L11;
        r15.begin();
    L11:
        return r10;
    L15:
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    public RequestBuilder<TranscodeType> clone() {
        RequestBuilder<TranscodeType> r10 = (RequestBuilder) super.clone();
        r10.transitionOptions = r10.transitionOptions.clone();
        return r10;
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable Uri r10) {
        return load(r10);
    }

    @NonNull
    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable File r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable @DrawableRes @RawRes Integer r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable Object r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable String r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public /* bridge */ /* synthetic */ Object load(@Nullable URL r10) {
        return load(r10);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(float r10) {
        if (r10 < 0.0f) goto L9;
        if (r10 > 1.0f) goto L9;
        this.thumbSizeMultiplier = Float.valueOf(r10);
        return this;
    L9:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ Object load(@Nullable byte[] r10) {
        return load(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Object r10) {
        return loadGeneric(r10);
    }

    @SuppressLint({"CheckResult"})
    public RequestBuilder(Class<TranscodeType> r10, RequestBuilder<?> r11) {
        this(r11.glide, r11.requestManager, r10, r11.context);
        this.model = r11.model;
        this.isModelSet = r11.isModelSet;
        apply(r11);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Bitmap r10) {
        return loadGeneric(r10).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Drawable r10) {
        return loadGeneric(r10).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable String r10) {
        return loadGeneric(r10);
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> into(@NonNull ImageView r10) {
        Util.assertMainThread();
        Preconditions.checkNotNull(r10);
        if (isTransformationSet() == false) goto L5;
        BaseRequestOptions r11 = this;
    L17:
        return (ViewTarget) into(this.glideContext.buildImageViewTarget(r10, this.transcodeClass), null, r11, Executors.mainThreadExecutor());
    L5:
        if (isTransformationAllowed() == true) goto L7;
        r11 = this;
        goto L17
    L7:
        if (r10.getScaleType() != null) goto L9;
        r11 = this;
        goto L17
    L9:
        switch(AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[r10.getScaleType().ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L20;
        };
    L11:
        r11 = clone().optionalCenterInside();
        goto L17
    L12:
        r11 = clone().optionalFitCenter();
        goto L17
    L13:
        r11 = clone().optionalCenterInside();
        goto L17
    L14:
        r11 = clone().optionalCenterCrop();
        goto L17
    L20:
        r11 = this;
        goto L17
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Uri r10) {
        return loadGeneric(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable File r10) {
        return loadGeneric(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable @DrawableRes @RawRes Integer r10) {
        return loadGeneric(r10).apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(this.context)));
    }

    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public RequestBuilder<TranscodeType> load(@Nullable URL r10) {
        return loadGeneric(r10);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable byte[] r10) {
        RequestBuilder<TranscodeType> r11 = loadGeneric(r10);
        if (r11.isDiskCacheStrategySet() == true) goto L6;
        r11 = r11.apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    L6:
        if (r11.isSkipMemoryCacheSet() == false) goto L8;
        return r11;
    L8:
        return r11.apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int r10, int r11) {
        return submit(r10, r11);
    }
}
