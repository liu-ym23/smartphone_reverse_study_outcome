package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    private Key currentSourceKey;
    private Thread currentThread;
    private final DecodeHelper<R> decodeHelper;
    private final DeferredEncodeManager<?> deferredEncodeManager;
    private final DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private EngineKey loadKey;
    private Object model;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int order;
    private final Pools$Pool<DecodeJob<?>> pool;
    private Priority priority;
    private final ReleaseManager releaseManager;
    private RunReason runReason;
    private Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier;
    private final List<Throwable> throwables;
    private int width;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy = null;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = null;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = null;

        static {
            int[] r10 = new int[EncodeStrategy.values().length];
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy = r10;
            r10[EncodeStrategy.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L28:
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy[EncodeStrategy.TRANSFORMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L6:
            int[] r11 = new int[Stage.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = r11;
            r11[Stage.RESOURCE_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.DATA_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L46:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L32:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L38:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.INITIALIZE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r12 = new int[RunReason.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = r12;
            r12[RunReason.INITIALIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L42:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L30:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.DECODE_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public interface Callback<R> {
        void onLoadFailed(GlideException r10);

        void onResourceReady(Resource<R> r10, DataSource r11);

        void reschedule(DecodeJob<?> r10);
    }

    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource dataSource;
        final /* synthetic */ DecodeJob this$0;

        public DecodeCallback(DecodeJob r10, DataSource r11) {
            this.this$0 = r10;
            this.dataSource = r11;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        @NonNull
        public Resource<Z> onResourceDecoded(@NonNull Resource<Z> r10) {
            return this.this$0.onResourceDecoded(this.dataSource, r10);
        }
    }

    public static class DeferredEncodeManager<Z> {
        private ResourceEncoder<Z> encoder;
        private Key key;
        private LockedResource<Z> toEncode;

        public DeferredEncodeManager() {
        }

        public void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }

        public void encode(DiskCacheProvider r10, Options r11) {
            GlideTrace.beginSection("DecodeJob.encode");
            r10.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, r11));     // Catch: Throwable -> L6
            this.toEncode.unlock();
            GlideTrace.endSection();
            return;
        L6:
            th = move-exception;
            this.toEncode.unlock();
            GlideTrace.endSection();
            throw th;
        }

        public boolean hasResourceToEncode() {
            if (this.toEncode == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void init(Key r10, ResourceEncoder<X> r11, LockedResource<X> r12) {
            this.key = r10;
            this.encoder = r11;
            this.toEncode = r12;
        }
    }

    public interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    public static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        public ReleaseManager() {
        }

        private boolean isComplete(boolean r10) {
            if (this.isFailed == true) goto L8;
            if (r10 == true) goto L8;
            if (this.isEncodeComplete == true) goto L8;
        L10:
            return false;
        L8:
            if (this.isReleased == false) goto L10;
            return true;
        }

        public synchronized boolean onEncodeComplete() {
            monitor-enter(this);
            this.isEncodeComplete = true;     // Catch: Throwable -> L7
            boolean r10 = isComplete(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized boolean onFailed() {
            monitor-enter(this);
            this.isFailed = true;     // Catch: Throwable -> L7
            boolean r10 = isComplete(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized boolean release(boolean r10) {
            monitor-enter(this);
            this.isReleased = true;     // Catch: Throwable -> L7
            boolean r11 = isComplete(r10);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.isEncodeComplete = false;     // Catch: Throwable -> L7
            this.isReleased = false;     // Catch: Throwable -> L7
            this.isFailed = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final enum RunReason extends Enum<RunReason> {
        private static final /* synthetic */ RunReason[] $VALUES = null;
        public static final RunReason DECODE_DATA = null;
        public static final RunReason INITIALIZE = null;
        public static final RunReason SWITCH_TO_SOURCE_SERVICE = null;

        static {
            RunReason r10 = new RunReason("INITIALIZE", 0);
            INITIALIZE = r10;
            RunReason r11 = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
            SWITCH_TO_SOURCE_SERVICE = r11;
            RunReason r12 = new RunReason("DECODE_DATA", 2);
            DECODE_DATA = r12;
            $VALUES = new RunReason[]{r10, r11, r12};
        }

        private RunReason(String r10, int r11) {
            super(r10, r11);
        }

        public static RunReason valueOf(String r10) {
            return (RunReason) Enum.valueOf(RunReason.class, r10);
        }

        public static RunReason[] values() {
            return (RunReason[]) $VALUES.clone();
        }
    }

    public static final enum Stage extends Enum<Stage> {
        private static final /* synthetic */ Stage[] $VALUES = null;
        public static final Stage DATA_CACHE = null;
        public static final Stage ENCODE = null;
        public static final Stage FINISHED = null;
        public static final Stage INITIALIZE = null;
        public static final Stage RESOURCE_CACHE = null;
        public static final Stage SOURCE = null;

        static {
            Stage r10 = new Stage("INITIALIZE", 0);
            INITIALIZE = r10;
            Stage r11 = new Stage("RESOURCE_CACHE", 1);
            RESOURCE_CACHE = r11;
            Stage r12 = new Stage("DATA_CACHE", 2);
            DATA_CACHE = r12;
            Stage r13 = new Stage("SOURCE", 3);
            SOURCE = r13;
            Stage r14 = new Stage("ENCODE", 4);
            ENCODE = r14;
            Stage r15 = new Stage("FINISHED", 5);
            FINISHED = r15;
            $VALUES = new Stage[]{r10, r11, r12, r13, r14, r15};
        }

        private Stage(String r10, int r11) {
            super(r10, r11);
        }

        public static Stage valueOf(String r10) {
            return (Stage) Enum.valueOf(Stage.class, r10);
        }

        public static Stage[] values() {
            return (Stage[]) $VALUES.clone();
        }
    }

    public DecodeJob(DiskCacheProvider r10, Pools$Pool<DecodeJob<?>> r11) {
        this.decodeHelper = new DecodeHelper();
        this.throwables = new ArrayList();
        this.stateVerifier = StateVerifier.newInstance();
        this.deferredEncodeManager = new DeferredEncodeManager();
        this.releaseManager = new ReleaseManager();
        this.diskCacheProvider = r10;
        this.pool = r11;
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> r10, Data r11, DataSource r12) throws GlideException {
        if (r11 != null) goto L15;
        r10.cleanup();
        return null;
    L15:
        long r13 = LogTime.getLogTime();     // Catch: Throwable -> L9
        Resource<R> r14 = decodeFromFetcher(r11, r12);     // Catch: Throwable -> L9
        if (Log.isLoggable(TAG, 2) == false) goto L11;
        logWithTimeAndKey("Decoded result " + r14, r13);     // Catch: Throwable -> L9
    L11:
        r10.cleanup();
        return r14;
    L9:
        th = move-exception;
        r10.cleanup();
        throw th;
    }

    private <Data> Resource<R> decodeFromFetcher(Data r10, DataSource r11) throws GlideException {
        return runLoadPath(r10, r11, this.decodeHelper.getLoadPath(r10.getClass()));
    }

    private void decodeFromRetrievedData() {
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        logWithTimeAndKey("Retrieved data", this.startFetchTime, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
    L13:
        Resource<R> r10 = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);     // Catch: GlideException -> L7
    L9:
        if (r10 == null) goto L11;
        notifyEncodeAndRelease(r10, this.currentDataSource);
        return;
    L11:
        runGenerators();
        return;
    L7:
        e = move-exception;
        e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
        this.throwables.add(e);
        r10 = null;
        goto L9
    }

    private DataFetcherGenerator getNextGenerator() {
        int r10 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L13;
        return null;
    L13:
        throw new IllegalStateException("Unrecognized stage: " + this.stage);
    L15:
        return new SourceGenerator(this.decodeHelper, this);
    L17:
        return new DataCacheGenerator(this.decodeHelper, this);
    L19:
        return new ResourceCacheGenerator(this.decodeHelper, this);
    }

    private Stage getNextStage(Stage r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[r10.ordinal()];
        if (r11 == 1) goto L27;
        if (r11 == 2) goto L22;
        if (r11 == 3) goto L20;
        if (r11 == 4) goto L20;
        if (r11 != 5) goto L18;
        if (this.diskCacheStrategy.decodeCachedResource() == false) goto L16;
        return Stage.RESOURCE_CACHE;
    L16:
        return getNextStage(Stage.RESOURCE_CACHE);
    L18:
        throw new IllegalArgumentException("Unrecognized stage: " + r10);
    L20:
        return Stage.FINISHED;
    L22:
        if (this.onlyRetrieveFromCache == false) goto L25;
        return Stage.FINISHED;
    L25:
        return Stage.SOURCE;
    L27:
        if (this.diskCacheStrategy.decodeCachedData() == false) goto L30;
        return Stage.DATA_CACHE;
    L30:
        return getNextStage(Stage.DATA_CACHE);
    }

    @NonNull
    private Options getOptionsWithHardwareConfig(DataSource r10) {
        Options r11 = this.options;
        if (r10 != DataSource.RESOURCE_DISK_CACHE) goto L5;
    L8:
        boolean r12 = true;
    L9:
        Option<Boolean> r13 = Downsampler.ALLOW_HARDWARE_CONFIG;
        Boolean r14 = (Boolean) r11.get(r13);
        if (r14 != null) goto L12;
    L15:
        Options r15 = new Options();
        r15.putAll(this.options);
        r15.set(r13, Boolean.valueOf(r12));
        return r15;
    L12:
        if (r14.booleanValue() == false) goto L14;
        if (r12 == false) goto L15;
    L14:
        return r11;
    L5:
        if (this.decodeHelper.isScaleOnlyOrNoTransform() == true) goto L8;
        r12 = false;
        goto L9
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    private void logWithTimeAndKey(String r10, long r11) {
        logWithTimeAndKey(r10, r11, null);
    }

    private void notifyComplete(Resource<R> r10, DataSource r11) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyEncodeAndRelease(Resource<R> r10, DataSource r11) {
        if ((r10 instanceof Initializable) == false) goto L6;
        ((Initializable) r10).initialize();
    L6:
        if (this.deferredEncodeManager.hasResourceToEncode() == false) goto L8;
        r10 = LockedResource.obtain(r10);
        LockedResource r12 = r10;
    L9:
        notifyComplete(r10, r11);
        this.stage = Stage.ENCODE;
    L14:
        th = move-exception;
        if (r12 == 0) goto L22;
        r12.unlock();
    L22:
        throw th;
    L11:
        if (this.deferredEncodeManager.hasResourceToEncode() == false) goto L16;
        this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);     // Catch: Throwable -> L14
    L16:
        if (r12 == 0) goto L18;
        r12.unlock();
    L18:
        onEncodeComplete();
        return;
    L8:
        r12 = 0;
        goto L9
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        GlideException r10 = new GlideException("Failed to load resource", new ArrayList(this.throwables));
        this.callback.onLoadFailed(r10);
        onLoadFailed();
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete() == false) goto L6;
        releaseInternal();
        return;
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed() == false) goto L6;
        releaseInternal();
        return;
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean r10 = false;
    L4:
        if (this.isCancelled == true) goto L14;
        if (this.currentGenerator == null) goto L14;
        r10 = this.currentGenerator.startNext();
        if (r10 == true) goto L14;
        this.stage = getNextStage(this.stage);
        this.currentGenerator = getNextGenerator();
        if (this.stage != Stage.SOURCE) goto L4;
        reschedule();
        return;
    L14:
        if (this.stage != Stage.FINISHED) goto L16;
    L17:
        if (r10 == true) goto L26;
        notifyFailed();
        return;
    L26:
        return;
    L16:
        if (this.isCancelled == true) goto L17;
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data r10, DataSource r11, LoadPath<Data, ResourceType, R> r12) throws GlideException {
        Options r13 = getOptionsWithHardwareConfig(r11);
        DataRewinder<Data> r14 = this.glideContext.getRegistry().getRewinder(r10);
        Resource<R> r15 = r12.load(r14, r13, this.width, this.height, new DecodeCallback(this, r11));     // Catch: Throwable -> L6
        r14.cleanup();
        return r15;
    L6:
        th = move-exception;
        r14.cleanup();
        throw th;
    }

    private void runWrapped() {
        int r10 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (r10 != 1) goto L5;
        this.stage = getNextStage(Stage.INITIALIZE);
        this.currentGenerator = getNextGenerator();
        runGenerators();
        return;
    L5:
        if (r10 != 2) goto L7;
        runGenerators();
        return;
    L7:
        if (r10 != 3) goto L10;
        decodeFromRetrievedData();
        return;
    L10:
        throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
    }

    private void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified == true) goto L5;
        this.isCallbackNotified = true;
        return;
    L5:
        if (this.throwables.isEmpty() == false) goto L7;
        Throwable r10 = null;
    L9:
        throw new IllegalStateException("Already notified", r10);
    L7:
        List<Throwable> r11 = this.throwables;
        r10 = r11.get(r11.size() - 1);
        goto L9
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator r10 = this.currentGenerator;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull DecodeJob<?> r10) {
        return compareTo2(r10);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public DecodeJob<R> init(GlideContext r17, Object r18, EngineKey r19, Key r20, int r21, int r22, Class<?> r23, Class<R> r24, Priority r25, DiskCacheStrategy r26, Map<Class<?>, Transformation<?>> r27, boolean r28, boolean r29, boolean r30, Options r31, Callback<R> r32, int r33) {
        this.decodeHelper.init(r17, r18, r20, r21, r22, r26, r23, r24, r25, r31, r27, r28, r29, this.diskCacheProvider);
        this.glideContext = r17;
        this.signature = r20;
        this.priority = r25;
        this.loadKey = r19;
        this.width = r21;
        this.height = r22;
        this.diskCacheStrategy = r26;
        this.onlyRetrieveFromCache = r30;
        this.options = r31;
        this.callback = r32;
        this.order = r33;
        this.runReason = RunReason.INITIALIZE;
        this.model = r18;
        return this;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key r10, Exception r11, DataFetcher<?> r12, DataSource r13) {
        r12.cleanup();
        GlideException r14 = new GlideException("Fetching data failed", r11);
        r14.setLoggingDetails(r10, r13, r12.getDataClass());
        this.throwables.add(r14);
        if (Thread.currentThread() == this.currentThread) goto L5;
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
        return;
    L5:
        runGenerators();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key r10, Object r11, DataFetcher<?> r12, DataSource r13, Key r14) {
        this.currentSourceKey = r10;
        this.currentData = r11;
        this.currentFetcher = r12;
        this.currentDataSource = r13;
        this.currentAttemptingKey = r14;
        if (Thread.currentThread() == this.currentThread) goto L5;
        this.runReason = RunReason.DECODE_DATA;
        this.callback.reschedule(this);
        return;
    L5:
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        decodeFromRetrievedData();     // Catch: Throwable -> L9
        GlideTrace.endSection();
        return;
    L9:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    }

    @NonNull
    public <Z> Resource<Z> onResourceDecoded(DataSource r12, @NonNull Resource<Z> r13) {
        Class<?> r10 = r13.get().getClass();
        ResourceEncoder<Z> r11 = null;
        if (r12 == DataSource.RESOURCE_DISK_CACHE) goto L5;
        Transformation<Z> r14 = this.decodeHelper.getTransformation(r10);
        Transformation<Z> r15 = r14;
        Resource<Z> r16 = r14.transform(this.glideContext, r13, this.width, this.height);
    L7:
        if (r13.equals(r16) == true) goto L10;
        r13.recycle();
    L10:
        if (this.decodeHelper.isResourceEncoderAvailable(r16) == false) goto L13;
        r11 = this.decodeHelper.getResultEncoder(r16);
        EncodeStrategy r17 = r11.getEncodeStrategy(this.options);
    L12:
        ResourceEncoder r18 = r11;
        if (this.diskCacheStrategy.isResourceCacheable(!this.decodeHelper.isSourceKey(this.currentSourceKey), r12, r17) == false) goto L28;
        if (r18 == null) goto L27;
        int r19 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[r17.ordinal()];
        if (r19 != 1) goto L20;
        Key r110 = new DataCacheKey(this.currentSourceKey, this.signature);
    L25:
        LockedResource r20 = LockedResource.obtain(r16);
        this.deferredEncodeManager.init(r110, r18, r20);
        return r20;
    L20:
        if (r19 != 2) goto L23;
        r110 = new ResourceCacheKey(this.decodeHelper.getArrayPool(), this.currentSourceKey, this.signature, this.width, this.height, r15, r10, this.options);
        goto L25
    L23:
        throw new IllegalArgumentException("Unknown strategy: " + r17);
    L27:
        throw new Registry.NoResultEncoderAvailableException(r16.get().getClass());
    L28:
        return r16;
    L13:
        r17 = EncodeStrategy.NONE;
        goto L12
    L5:
        r16 = r13;
        r15 = null;
        goto L7
    }

    public void release(boolean r10) {
        if (this.releaseManager.release(r10) == false) goto L6;
        releaseInternal();
        return;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.model);
        DataFetcher<?> r10 = this.currentFetcher;
    L23:
        th = move-exception;
        if (r10 == null) goto L35;
        r10.cleanup();
    L35:
        GlideTrace.endSection();
        throw th;
    L10:
        th = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L26;
        Log.d(TAG, "DecodeJob threw unexpectedly, isCancelled: " + this.isCancelled + ", stage: " + this.stage, th);     // Catch: Throwable -> L23
    L26:
        if (this.stage == Stage.ENCODE) goto L29;
        this.throwables.add(th);     // Catch: Throwable -> L23
        notifyFailed();     // Catch: Throwable -> L23
    L29:
        if (this.isCancelled == true) goto L31;
        throw th;     // Catch: Throwable -> L23
    L31:
        throw th;     // Catch: Throwable -> L23
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L23
    L4:
        if (this.isCancelled == false) goto L14;
        notifyFailed();     // Catch: Throwable -> L10 CallbackException -> L12
        if (r10 == null) goto L8;
        r10.cleanup();
    L8:
        GlideTrace.endSection();
        return;
    L14:
        runWrapped();     // Catch: Throwable -> L10 CallbackException -> L12
        if (r10 == null) goto L17;
        r10.cleanup();
    L17:
        GlideTrace.endSection();
    }

    public boolean willDecodeFromCache() {
        Stage r10 = getNextStage(Stage.INITIALIZE);
        if (r10 != Stage.RESOURCE_CACHE) goto L5;
    L8:
        return true;
    L5:
        if (r10 == Stage.DATA_CACHE) goto L8;
        return false;
    }

    private void logWithTimeAndKey(String r10, long r11, String r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append(r10);
        r13.append(" in ");
        r13.append(LogTime.getElapsedMillis(r11));
        r13.append(", load key: ");
        r13.append(this.loadKey);
        if (r12 == null) goto L5;
        String r14 = ", " + r12;
    L6:
        r13.append(r14);
        r13.append(", thread: ");
        r13.append(Thread.currentThread().getName());
        Log.v(TAG, r13.toString());
        return;
    L5:
        r14 = "";
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull DecodeJob<?> r10) {
        int r11 = getPriority() - r10.getPriority();
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return this.order - r10.order;
    }
}
