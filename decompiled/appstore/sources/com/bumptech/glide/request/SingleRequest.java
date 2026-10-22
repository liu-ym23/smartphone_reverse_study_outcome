package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = false;
    private static final Pools$Pool<SingleRequest<?>> POOL = null;
    private static final String TAG = "Request";
    private TransitionFactory<? super R> animationFactory;
    private Executor callbackExecutor;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;

    @Nullable
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;

    @Nullable
    private List<RequestListener<R>> requestListeners;
    private BaseRequestOptions<?> requestOptions;

    @Nullable
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;

    @GuardedBy("this")
    private Status status;

    @Nullable
    private final String tag;
    private Target<R> target;

    @Nullable
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CLEARED = null;
        public static final Status COMPLETE = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status WAITING_FOR_SIZE = null;

        static {
            Status r10 = new Status("PENDING", 0);
            PENDING = r10;
            Status r11 = new Status("RUNNING", 1);
            RUNNING = r11;
            Status r12 = new Status("WAITING_FOR_SIZE", 2);
            WAITING_FOR_SIZE = r12;
            Status r13 = new Status("COMPLETE", 3);
            COMPLETE = r13;
            Status r14 = new Status("FAILED", 4);
            FAILED = r14;
            Status r15 = new Status("CLEARED", 5);
            CLEARED = r15;
            $VALUES = new Status[]{r10, r11, r12, r13, r14, r15};
        }

        private Status(String r10, int r11) {
            super(r10, r11);
        }

        public static Status valueOf(String r10) {
            return (Status) Enum.valueOf(Status.class, r10);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    static {
        POOL = FactoryPools.threadSafe(AnimationConstants.DURATION_150, new AnonymousClass1());
        IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    public SingleRequest() {
        if (IS_VERBOSE_LOGGABLE == false) goto L5;
        String r10 = String.valueOf(super.hashCode());
    L6:
        this.tag = r10;
        this.stateVerifier = StateVerifier.newInstance();
        return;
    L5:
        r10 = null;
        goto L6
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    private boolean canNotifyCleared() {
        RequestCoordinator r10 = this.requestCoordinator;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canNotifyCleared(this) == true) goto L8;
        return false;
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator r10 = this.requestCoordinator;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canNotifyStatusChanged(this) == true) goto L8;
        return false;
    }

    private boolean canSetResource() {
        RequestCoordinator r10 = this.requestCoordinator;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canSetImage(this) == true) goto L8;
        return false;
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus r10 = this.loadStatus;
        if (r10 == null) goto L6;
        r10.cancel();
        this.loadStatus = null;
        return;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable != null) goto L10;
        Drawable r10 = this.requestOptions.getErrorPlaceholder();
        this.errorDrawable = r10;
        if (r10 != null) goto L10;
        if (this.requestOptions.getErrorId() <= 0) goto L10;
        this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
    L10:
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable != null) goto L10;
        Drawable r10 = this.requestOptions.getFallbackDrawable();
        this.fallbackDrawable = r10;
        if (r10 != null) goto L10;
        if (this.requestOptions.getFallbackId() <= 0) goto L10;
        this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
    L10:
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable != null) goto L10;
        Drawable r10 = this.requestOptions.getPlaceholderDrawable();
        this.placeholderDrawable = r10;
        if (r10 != null) goto L10;
        if (this.requestOptions.getPlaceholderId() <= 0) goto L10;
        this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
    L10:
        return this.placeholderDrawable;
    }

    private synchronized void init(Context r10, GlideContext r11, Object r12, Class<R> r13, BaseRequestOptions<?> r14, int r15, int r16, Priority r17, Target<R> r18, RequestListener<R> r19, @Nullable List<RequestListener<R>> r110, RequestCoordinator r111, Engine r112, TransitionFactory<? super R> r113, Executor r114) {
        monitor-enter(this);
        this.context = r10;     // Catch: Throwable -> L9
        this.glideContext = r11;     // Catch: Throwable -> L9
        this.model = r12;     // Catch: Throwable -> L9
        this.transcodeClass = r13;     // Catch: Throwable -> L9
        this.requestOptions = r14;     // Catch: Throwable -> L9
        this.overrideWidth = r15;     // Catch: Throwable -> L9
        this.overrideHeight = r16;     // Catch: Throwable -> L9
        this.priority = r17;     // Catch: Throwable -> L9
        this.target = r18;     // Catch: Throwable -> L9
        this.targetListener = r19;     // Catch: Throwable -> L9
        this.requestListeners = r110;     // Catch: Throwable -> L9
        this.requestCoordinator = r111;     // Catch: Throwable -> L9
        this.engine = r112;     // Catch: Throwable -> L9
        this.animationFactory = r113;     // Catch: Throwable -> L9
        this.callbackExecutor = r114;     // Catch: Throwable -> L9
        this.status = Status.PENDING;     // Catch: Throwable -> L9
        if (this.requestOrigin == null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (r11.isLoggingRequestOriginsEnabled() == false) goto L11;
        this.requestOrigin = new RuntimeException("Glide request origin trace");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator r10 = this.requestCoordinator;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isAnyResourceSet() == false) goto L8;
        return false;
    }

    private synchronized boolean listenerCountEquals(SingleRequest<?> r10) {
        monitor-enter(this);
        monitor-enter(r10);     // Catch: Throwable -> L20
        List<RequestListener<R>> r11 = this.requestListeners;     // Catch: Throwable -> L17
        boolean r12 = false;
        if (r11 != null) goto L7;
        int r13 = 0;
    L8:
        List<RequestListener<?>> r14 = r10.requestListeners;     // Catch: Throwable -> L17
        if (r14 != null) goto L11;
        int r15 = 0;
    L12:
        if (r13 != r15) goto L14;
        r12 = true;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r12;
    L11:
        r15 = r14.size();     // Catch: Throwable -> L17
        goto L12
    L7:
        r13 = r11.size();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private Drawable loadDrawable(@DrawableRes int r10) {
        if (this.requestOptions.getTheme() == null) goto L5;
        Resources.Theme r11 = this.requestOptions.getTheme();
    L7:
        return DrawableDecoderCompat.getDrawable(this.glideContext, r10, r11);
    L5:
        r11 = this.context.getTheme();
        goto L7
    }

    private void logV(String r10) {
        Log.v(TAG, r10 + " this: " + this.tag);
    }

    private static int maybeApplySizeMultiplier(int r10, float r11) {
        if (r10 != Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        return Math.round(r11 * r10);
    }

    private void notifyLoadFailed() {
        RequestCoordinator r10 = this.requestCoordinator;
        if (r10 == null) goto L6;
        r10.onRequestFailed(this);
        return;
    }

    private void notifyLoadSuccess() {
        RequestCoordinator r10 = this.requestCoordinator;
        if (r10 == null) goto L6;
        r10.onRequestSuccess(this);
        return;
    }

    public static <R> SingleRequest<R> obtain(Context r17, GlideContext r18, Object r19, Class<R> r20, BaseRequestOptions<?> r21, int r22, int r23, Priority r24, Target<R> r25, RequestListener<R> r26, @Nullable List<RequestListener<R>> r27, RequestCoordinator r28, Engine r29, TransitionFactory<? super R> r30, Executor r31) {
        SingleRequest<R> r10 = (SingleRequest) POOL.acquire();
        if (r10 != null) goto L5;
        r10 = new SingleRequest();
    L5:
        r10.init(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
        return r10;
    }

    private void releaseResource(Resource<?> r10) {
        this.engine.release(r10);
        this.resource = null;
    }

    private synchronized void setErrorPlaceholder() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (canNotifyStatusChanged() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.model != null) goto L12;
        Drawable r10 = getFallbackDrawable();     // Catch: Throwable -> L10
    L13:
        if (r10 != null) goto L15;
        r10 = getErrorDrawable();     // Catch: Throwable -> L10
    L15:
        if (r10 != null) goto L17;
        r10 = getPlaceholderDrawable();     // Catch: Throwable -> L10
    L17:
        this.target.onLoadFailed(r10);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L12:
        r10 = null;
        goto L13
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void begin() {
        monitor-enter(this);
        assertNotCallingCallbacks();     // Catch: Throwable -> L8
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L8
        this.startTime = LogTime.getLogTime();     // Catch: Throwable -> L8
        if (this.model == null) goto L6;
        Status r10 = this.status;     // Catch: Throwable -> L8
        Status r11 = Status.RUNNING;     // Catch: Throwable -> L8
        if (r10 == r11) goto L40;
        if (r10 != Status.COMPLETE) goto L24;
        onResourceReady(this.resource, DataSource.MEMORY_CACHE);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L24:
        Status r12 = Status.WAITING_FOR_SIZE;     // Catch: Throwable -> L8
        this.status = r12;     // Catch: Throwable -> L8
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight) == false) goto L27;
        onSizeReady(this.overrideWidth, this.overrideHeight);     // Catch: Throwable -> L8
    L28:
        Status r13 = this.status;     // Catch: Throwable -> L8
        if (r13 == r11) goto L32;
        if (r13 == r12) goto L32;
    L35:
        if (IS_VERBOSE_LOGGABLE == false) goto L37;
        logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L8
    L37:
        monitor-exit(this);
        return;
    L32:
        if (canNotifyStatusChanged() == false) goto L35;
        this.target.onLoadStarted(getPlaceholderDrawable());     // Catch: Throwable -> L8
        goto L35
    L27:
        this.target.getSize(this);     // Catch: Throwable -> L8
        goto L28
    L40:
        throw new IllegalArgumentException("Cannot restart a running request");     // Catch: Throwable -> L8
    L6:
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight) == false) goto L11;
        this.width = this.overrideWidth;     // Catch: Throwable -> L8
        this.height = this.overrideHeight;     // Catch: Throwable -> L8
    L11:
        if (getFallbackDrawable() != null) goto L13;
        int r14 = 5;
    L14:
        onLoadFailed(new GlideException("Received null model"), r14);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L13:
        r14 = 3;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void clear() {
        monitor-enter(this);
        assertNotCallingCallbacks();     // Catch: Throwable -> L10
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L10
        Status r10 = this.status;     // Catch: Throwable -> L10
        Status r11 = Status.CLEARED;     // Catch: Throwable -> L10
        if (r10 != r11) goto L7;
        monitor-exit(this);
        return;
    L7:
        cancel();     // Catch: Throwable -> L10
        Resource<R> r12 = this.resource;     // Catch: Throwable -> L10
        if (r12 == null) goto L13;
        releaseResource(r12);     // Catch: Throwable -> L10
    L13:
        if (canNotifyCleared() == false) goto L15;
        this.target.onLoadCleared(getPlaceholderDrawable());     // Catch: Throwable -> L10
    L15:
        this.status = r11;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isCleared() {
        monitor-enter(this);
        if (this.status != Status.CLEARED) goto L6;
        boolean r10 = true;
    L7:
        monitor-exit(this);
        return r10;
    L6:
        r10 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isComplete() {
        monitor-enter(this);
        if (this.status != Status.COMPLETE) goto L6;
        boolean r10 = true;
    L7:
        monitor-exit(this);
        return r10;
    L6:
        r10 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isEquivalentTo(Request r10) {
        monitor-enter(this);
        boolean r11 = false;
        if ((r10 instanceof SingleRequest) == false) goto L31;
        SingleRequest<?> r12 = (SingleRequest) r10;     // Catch: Throwable -> L29
        monitor-enter(r12);     // Catch: Throwable -> L29
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L8:
        if (this.overrideWidth == r12.overrideWidth) goto L10;
    L24:
        monitor-exit(r12);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r11;
    L10:
        if (this.overrideHeight != r12.overrideHeight) goto L24;
        if (Util.bothModelsNullEquivalentOrEquals(this.model, r12.model) == false) goto L24;
        if (this.transcodeClass.equals(r12.transcodeClass) == false) goto L24;
        if (this.requestOptions.equals(r12.requestOptions) == false) goto L24;
        if (this.priority != r12.priority) goto L24;
        if (listenerCountEquals(r12) == false) goto L24;
        r11 = true;
        goto L24
    L31:
        monitor-exit(this);
        return false;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isFailed() {
        monitor-enter(this);
        if (this.status != Status.FAILED) goto L6;
        boolean r10 = true;
    L7:
        monitor-exit(this);
        return r10;
    L6:
        r10 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isResourceSet() {
        monitor-enter(this);
        boolean r10 = isComplete();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isRunning() {
        monitor-enter(this);
        Status r10 = this.status;     // Catch: Throwable -> L9
        if (r10 == Status.RUNNING) goto L11;
        if (r10 == Status.WAITING_FOR_SIZE) goto L11;
        boolean r11 = false;
    L12:
        monitor-exit(this);
        return r11;
    L11:
        r11 = true;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onLoadFailed(GlideException r10) {
        monitor-enter(this);
        onLoadFailed(r10, 5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onResourceReady(Resource<?> r10, DataSource r11) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L8
        this.loadStatus = null;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        Object r12 = r10.get();     // Catch: Throwable -> L8
        if (r12 != null) goto L13;
    L23:
        releaseResource(r10);     // Catch: Throwable -> L8
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L8
        r13.append("Expected to receive an object of ");     // Catch: Throwable -> L8
        r13.append(this.transcodeClass);     // Catch: Throwable -> L8
        r13.append(" but instead got ");     // Catch: Throwable -> L8
        if (r12 == null) goto L26;
        Object r14 = r12.getClass();     // Catch: Throwable -> L8
    L27:
        r13.append(r14);     // Catch: Throwable -> L8
        r13.append("{");     // Catch: Throwable -> L8
        r13.append(r12);     // Catch: Throwable -> L8
        r13.append("} inside Resource{");     // Catch: Throwable -> L8
        r13.append(r10);     // Catch: Throwable -> L8
        r13.append("}.");     // Catch: Throwable -> L8
        if (r12 == null) goto L30;
        String r15 = "";
    L31:
        r13.append(r15);     // Catch: Throwable -> L8
        onLoadFailed(new GlideException(r13.toString()));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L30:
        r15 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        goto L31
    L26:
        r14 = "";
        goto L27
    L13:
        if (this.transcodeClass.isAssignableFrom(r12.getClass()) == false) goto L23;
        if (canSetResource() == true) goto L20;
        releaseResource(r10);     // Catch: Throwable -> L8
        this.status = Status.COMPLETE;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L20:
        onResourceReady(r10, r12, r11);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public synchronized void onSizeReady(int r24, int r25) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L7
        boolean r10 = IS_VERBOSE_LOGGABLE;     // Catch: Throwable -> L7
        if (r10 == false) goto L10;
        logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L7
    L10:
        if (this.status == Status.WAITING_FOR_SIZE) goto L13;
        monitor-exit(this);
        return;
    L13:
        Status r14 = Status.RUNNING;     // Catch: Throwable -> L7
        this.status = r14;     // Catch: Throwable -> L7
        float r11 = this.requestOptions.getSizeMultiplier();     // Catch: Throwable -> L7
        this.width = maybeApplySizeMultiplier(r24, r11);     // Catch: Throwable -> L7
        this.height = maybeApplySizeMultiplier(r25, r11);     // Catch: Throwable -> L7
        if (r10 == false) goto L16;
        logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L7
    L16:
        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);     // Catch: Throwable -> L23
        if (this.status == r14) goto L25;
        this.loadStatus = null;     // Catch: Throwable -> L23
    L25:
        if (r10 == false) goto L27;
        logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L23
    L27:
        monitor-exit(this);
        return;
    L29:
        th = th;
    L31:
        monitor-exit(this);     // Catch: Throwable -> L23
        throw th;
    L7:
        th = th;
    L23:
        th = th;
        goto L31
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void recycle() {
        monitor-enter(this);
        assertNotCallingCallbacks();     // Catch: Throwable -> L6
        this.context = null;     // Catch: Throwable -> L6
        this.glideContext = null;     // Catch: Throwable -> L6
        this.model = null;     // Catch: Throwable -> L6
        this.transcodeClass = null;     // Catch: Throwable -> L6
        this.requestOptions = null;     // Catch: Throwable -> L6
        this.overrideWidth = -1;     // Catch: Throwable -> L6
        this.overrideHeight = -1;     // Catch: Throwable -> L6
        this.target = null;     // Catch: Throwable -> L6
        this.requestListeners = null;     // Catch: Throwable -> L6
        this.targetListener = null;     // Catch: Throwable -> L6
        this.requestCoordinator = null;     // Catch: Throwable -> L6
        this.animationFactory = null;     // Catch: Throwable -> L6
        this.loadStatus = null;     // Catch: Throwable -> L6
        this.errorDrawable = null;     // Catch: Throwable -> L6
        this.placeholderDrawable = null;     // Catch: Throwable -> L6
        this.fallbackDrawable = null;     // Catch: Throwable -> L6
        this.width = -1;     // Catch: Throwable -> L6
        this.height = -1;     // Catch: Throwable -> L6
        this.requestOrigin = null;     // Catch: Throwable -> L6
        POOL.release(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void onLoadFailed(GlideException r10, int r11) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L8
        r10.setOrigin(this.requestOrigin);     // Catch: Throwable -> L8
        int r12 = this.glideContext.getLogLevel();     // Catch: Throwable -> L8
        if (r12 > r11) goto L10;
        Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + FixCard.FixStyle.KEY_X + this.height + "]", r10);     // Catch: Throwable -> L8
        if (r12 > 4) goto L10;
        r10.logRootCauses(GLIDE_TAG);     // Catch: Throwable -> L8
    L10:
        this.loadStatus = null;     // Catch: Throwable -> L8
        this.status = Status.FAILED;     // Catch: Throwable -> L8
        boolean r13 = true;
        this.isCallingCallbacks = true;     // Catch: Throwable -> L8
        List<RequestListener<R>> r14 = this.requestListeners;     // Catch: Throwable -> L18
        if (r14 == null) goto L20;
        Iterator<RequestListener<R>> r15 = r14.iterator();     // Catch: Throwable -> L18
        boolean r16 = false;
    L16:
        if (r15.hasNext() == false) goto L21;
        r16 = r16 | r15.next().onLoadFailed(r10, this.model, this.target, isFirstReadyResource());     // Catch: Throwable -> L18
    L21:
        RequestListener<R> r17 = this.targetListener;     // Catch: Throwable -> L18
        if (r17 != null) goto L24;
    L26:
        r13 = false;
    L28:
        if ((r16 | r13) == true) goto L30;
        setErrorPlaceholder();     // Catch: Throwable -> L18
    L30:
        this.isCallingCallbacks = false;     // Catch: Throwable -> L8
        notifyLoadFailed();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L24:
        if (r17.onLoadFailed(r10, this.model, this.target, isFirstReadyResource()) == false) goto L26;
    L20:
        r16 = false;
    L18:
        th = move-exception;
        this.isCallingCallbacks = false;     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized void onResourceReady(Resource<R> r11, R r12, DataSource r13) {
        monitor-enter(this);
        boolean r10 = isFirstReadyResource();     // Catch: Throwable -> L6
        this.status = Status.COMPLETE;     // Catch: Throwable -> L6
        this.resource = r11;     // Catch: Throwable -> L6
        if (this.glideContext.getLogLevel() > 3) goto L8;
        Log.d(GLIDE_TAG, "Finished loading " + r12.getClass().getSimpleName() + " from " + r13 + " for " + this.model + " with size [" + this.width + FixCard.FixStyle.KEY_X + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");     // Catch: Throwable -> L6
    L8:
        boolean r14 = true;
        this.isCallingCallbacks = true;     // Catch: Throwable -> L6
        List<RequestListener<R>> r15 = this.requestListeners;     // Catch: Throwable -> L16
        if (r15 == null) goto L18;
        Iterator<RequestListener<R>> r16 = r15.iterator();     // Catch: Throwable -> L16
        boolean r17 = false;
    L14:
        if (r16.hasNext() == false) goto L19;
        r17 = r17 | r16.next().onResourceReady(r12, this.model, this.target, r13, r10);     // Catch: Throwable -> L16
    L19:
        RequestListener<R> r18 = this.targetListener;     // Catch: Throwable -> L16
        if (r18 != null) goto L22;
    L24:
        r14 = false;
    L26:
        if ((r14 | r17) == true) goto L28;
        this.target.onResourceReady(r12, this.animationFactory.build(r13, r10));     // Catch: Throwable -> L16
    L28:
        this.isCallingCallbacks = false;     // Catch: Throwable -> L6
        notifyLoadSuccess();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L22:
        if (r18.onResourceReady(r12, this.model, this.target, r13, r10) == false) goto L24;
    L18:
        r17 = false;
    L16:
        th = move-exception;
        this.isCallingCallbacks = false;     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
