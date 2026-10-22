package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.facebook.keyframes.model.KFFeature;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jk\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u0001042\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u00042\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0001¢\u0006\u0004\b:\u0010;J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0007J5\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010?J\u0018\u0010)\u001a\u00020@2\u000e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0004H\u0007J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010<\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020.H\u0017J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010M\u001a\u00020$H\u0002J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010<\u001a\u00020.H\u0016J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010M\u001a\u00020$H\u0002J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0007J%\u0010W\u001a\u00020D2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0017¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020DH\u0017R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR$\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "()V", "cameraInfos", "", "Landroidx/camera/core/CameraInfo;", "activeConcurrentCameraInfos", "getActiveConcurrentCameraInfos", "()Ljava/util/List;", "setActiveConcurrentCameraInfos", "(Ljava/util/List;)V", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "cameraOperatingMode", "", "getCameraOperatingMode", "()I", "setCameraOperatingMode", "(I)V", "isConcurrentCameraModeOn", "", "()Z", "mCameraInfoMap", "", "Landroidx/camera/core/internal/CameraUseCaseAdapter$CameraId;", "Landroidx/camera/core/impl/RestrictedCameraInfo;", "mCameraX", "Landroidx/camera/core/CameraX;", "mCameraXConfigProvider", "Landroidx/camera/core/CameraXConfig$Provider;", "mCameraXInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "mCameraXShutdownFuture", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mLifecycleCameraRepository", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", "mLock", "", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "primaryCameraSelector", "Landroidx/camera/core/CameraSelector;", "secondaryCameraSelector", "primaryLayoutSettings", "Landroidx/camera/core/LayoutSettings;", "secondaryLayoutSettings", "viewPort", "Landroidx/camera/core/ViewPort;", KFFeature.EFFECT_JSON_FIELD, "Landroidx/camera/core/CameraEffect;", "useCases", "", "Landroidx/camera/core/UseCase;", "bindToLifecycle$camera_lifecycle_release", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/ViewPort;Ljava/util/List;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "cameraSelector", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "configureInstanceInternal", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getAvailableCameraInfos", "getCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "cameraInfo", "getCameraInfo", "getOrCreateCameraXInstance", PerfLog.PARAM_KEY_CONTEXT_ID, "hasCamera", "isBound", "useCase", "isPreview", "isVideoCapture", "setCameraX", "cameraX", "setContext", "shutdownAsync", "unbind", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    public static final Companion Companion = null;
    private static final ProcessCameraProvider sAppInstance = null;
    private final Map<CameraUseCaseAdapter.CameraId, RestrictedCameraInfo> mCameraInfoMap;
    private CameraX mCameraX;
    private CameraXConfig.Provider mCameraXConfigProvider;
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    private ListenableFuture<Void> mCameraXShutdownFuture;
    private Context mContext;
    private final LifecycleCameraRepository mLifecycleCameraRepository;
    private final Object mLock;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider$Companion;", "", "()V", "sAppInstance", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "configureInstance", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getInstance", "Lcom/google/common/util/concurrent/ListenableFuture;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ ProcessCameraProvider a(Function1 r100, Object r101) {
            return getInstance$lambda$0(r100, r101);
        }

        @JvmStatic
        public final void configureInstance(CameraXConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "cameraXConfig");
            Trace.beginSection("CX:configureInstance");
            ProcessCameraProvider.access$configureInstanceInternal(ProcessCameraProvider.access$getSAppInstance$cp(), r100);     // Catch: Throwable -> L6
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
            Trace.endSection();
            return;
        L6:
            th = move-exception;
            Trace.endSection();
            throw th;
        }

        @JvmStatic
        public final ListenableFuture<ProcessCameraProvider> getInstance(final Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Preconditions.checkNotNull(r100);
            ListenableFuture r101 = ProcessCameraProvider.access$getOrCreateCameraXInstance(ProcessCameraProvider.access$getSAppInstance$cp(), r100);
            final Function1<CameraX, ProcessCameraProvider> r102 = new ProcessCameraProvider$Companion$getInstance$1(r100);
            return Futures.transform(r101, new d(r102), CameraXExecutors.directExecutor());
        }

        private static final ProcessCameraProvider getInstance$lambda$0(Function1 r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "$tmp0");
            return (ProcessCameraProvider) r100.invoke(r101);
        }
    }

    public static /* synthetic */ Object a(ProcessCameraProvider r100, CameraX r101, CallbackToFutureAdapter.Completer r102) {
        return getOrCreateCameraXInstance$lambda$18$lambda$17(r100, r101, r102);
    }

    public static /* synthetic */ ListenableFuture b(Function1 r100, Object r101) {
        return getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(r100, r101);
    }

    public static /* synthetic */ void c(ProcessCameraProvider r100) {
        shutdownAsync$lambda$0(r100);
    }

    @JvmStatic
    public static final void configureInstance(CameraXConfig r100) {
        Companion.configureInstance(r100);
    }

    @JvmStatic
    public static final ListenableFuture<ProcessCameraProvider> getInstance(Context r100) {
        return Companion.getInstance(r100);
    }

    static {
        Companion = new Companion(null);
        sAppInstance = new ProcessCameraProvider();
    }

    private final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX r100 = this.mCameraX;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
    L5:
        return new ArrayList();
    }

    private final int getCameraOperatingMode() {
        CameraX r100 = this.mCameraX;
        if (r100 != null) goto L6;
        return 0;
    L6:
        Intrinsics.checkNotNull(r100);
        return r100.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L10
        CameraX r101 = access$getMCameraX$p(this);     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L10
        Iterator<CameraInternal> r102 = r101.getCameraRepository().getCameras().iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L8;
        r100.add(r102.next().getCameraInfo());     // Catch: Throwable -> L10
        goto L5
    L8:
        Trace.endSection();
        return r100;
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public final List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        Objects.requireNonNull(access$getMCameraX$p(this));     // Catch: Throwable -> L16
        CameraX r100 = access$getMCameraX$p(this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L16
        Objects.requireNonNull(r100.getCameraFactory().getCameraCoordinator());     // Catch: Throwable -> L16
        CameraX r101 = access$getMCameraX$p(this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L16
        List<List<CameraSelector>> r102 = r101.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();     // Catch: Throwable -> L16
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<List<CameraSelector>> r104 = r102.iterator();     // Catch: Throwable -> L16
    L4:
        if (r104.hasNext() == false) goto L14;
        List<CameraSelector> r105 = r104.next();     // Catch: Throwable -> L16
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<CameraSelector> r107 = r105.iterator();     // Catch: Throwable -> L16
    L8:
        if (r107.hasNext() == false) goto L12;
        r106.add(getCameraInfo(r107.next()));     // Catch: Throwable -> L16
        goto L8
    L12:
        r103.add(r106);     // Catch: Throwable -> L16
        goto L4
    L14:
        Trace.endSection();
        return r103;
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public final ListenableFuture<Void> shutdownAsync() {
        Threads.runOnMainSync(new b(this));
        CameraX r100 = this.mCameraX;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.getCameraFactory().getCameraCoordinator().shutdown();
    L5:
        CameraX r101 = this.mCameraX;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        ListenableFuture<Void> r102 = r101.shutdown();
    L9:
        Object r103 = this.mLock;
        monitor-enter(r103);
        this.mCameraXConfigProvider = null;     // Catch: Throwable -> L15
        this.mCameraXInitializeFuture = null;     // Catch: Throwable -> L15
        this.mCameraXShutdownFuture = r102;     // Catch: Throwable -> L15
        this.mCameraInfoMap.clear();     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r103);
        this.mCameraX = null;
        this.mContext = null;
        return r102;
    L15:
        th = move-exception;
        throw th;
    L8:
        r102 = Futures.immediateFuture(null);
        goto L9
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        Threads.checkMainThread();     // Catch: Throwable -> L6
        access$setCameraOperatingMode(this, 0);     // Catch: Throwable -> L6
        access$getMLifecycleCameraRepository$p(this).unbindAll();     // Catch: Throwable -> L6
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
        Trace.endSection();
        return;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    private ProcessCameraProvider() {
        this.mLock = new Object();
        this.mCameraXShutdownFuture = Futures.immediateFuture(null);
        this.mLifecycleCameraRepository = new LifecycleCameraRepository();
        this.mCameraInfoMap = new HashMap();
    }

    public final boolean isConcurrentCameraModeOn() {
        if (getCameraOperatingMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ ProcessCameraProvider access$getSAppInstance$cp() {
        return sAppInstance;
    }

    public static final /* synthetic */ List access$getActiveConcurrentCameraInfos(ProcessCameraProvider r100) {
        return r100.getActiveConcurrentCameraInfos();
    }

    public static final /* synthetic */ int access$getCameraOperatingMode(ProcessCameraProvider r100) {
        return r100.getCameraOperatingMode();
    }

    public static final /* synthetic */ Map access$getMCameraInfoMap$p(ProcessCameraProvider r100) {
        return r100.mCameraInfoMap;
    }

    public static final /* synthetic */ CameraX access$getMCameraX$p(ProcessCameraProvider r100) {
        return r100.mCameraX;
    }

    public static final /* synthetic */ CameraXConfig.Provider access$getMCameraXConfigProvider$p(ProcessCameraProvider r100) {
        return r100.mCameraXConfigProvider;
    }

    public static final /* synthetic */ Context access$getMContext$p(ProcessCameraProvider r100) {
        return r100.mContext;
    }

    public static final /* synthetic */ LifecycleCameraRepository access$getMLifecycleCameraRepository$p(ProcessCameraProvider r100) {
        return r100.mLifecycleCameraRepository;
    }

    public static final /* synthetic */ Object access$getMLock$p(ProcessCameraProvider r100) {
        return r100.mLock;
    }

    private final void configureInstanceInternal(final CameraXConfig r100) {
        Trace.beginSection("CX:configureInstanceInternal");
        Object r101 = access$getMLock$p(this);     // Catch: Throwable -> L16
        monitor-enter(r101);     // Catch: Throwable -> L16
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L13
        if (access$getMCameraXConfigProvider$p(this) != null) goto L8;
        boolean r102 = true;
    L9:
        Preconditions.checkState(r102, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");     // Catch: Throwable -> L13
        access$setMCameraXConfigProvider$p(this, new ProcessCameraProvider$configureInstanceInternal$1$1$1(r100));     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L16
        Trace.endSection();
        return;
    L8:
        r102 = false;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    private final ListenableFuture<CameraX> getOrCreateCameraXInstance(Context r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        ListenableFuture<CameraX> r102 = this.mCameraXInitializeFuture;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");     // Catch: Throwable -> L12
        monitor-exit(r101);
        return r102;
    L9:
        final CameraX r103 = new CameraX(r100, this.mCameraXConfigProvider);     // Catch: Throwable -> L12
        ListenableFuture<CameraX> r104 = CallbackToFutureAdapter.getFuture(new c(this, r103));     // Catch: Throwable -> L12
        this.mCameraXInitializeFuture = r104;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");     // Catch: Throwable -> L12
        monitor-exit(r101);
        return r104;
    L12:
        th = move-exception;
        throw th;
    }

    private final boolean isPreview(UseCase r100) {
        return r100 instanceof Preview;
    }

    private final boolean isVideoCapture(UseCase r100) {
        if (r100.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getCurrentConfig().getCaptureType() != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) goto L7;
        return true;
    }

    private final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> r100) {
        CameraX r101 = this.mCameraX;
        if (r101 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        r101.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(r100);
    }

    private final void setCameraOperatingMode(int r100) {
        CameraX r101 = this.mCameraX;
        if (r101 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        r101.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(r100);
    }

    private final void setCameraX(CameraX r100) {
        this.mCameraX = r100;
    }

    private final void setContext(Context r100) {
        this.mContext = r100;
    }

    private static final void shutdownAsync$lambda$0(ProcessCameraProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.unbindAll();
        r100.mLifecycleCameraRepository.clear();
    }

    public final ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> r110) {
        Intrinsics.checkNotNullParameter(r110, "singleCameraConfigs");
        Trace.beginSection("CX:bindToLifecycle-Concurrent");
    L80:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (r110.size() < 2) goto L79;
        if (r110.size() > 2) goto L77;
        ConcurrentCamera.SingleCameraConfig r100 = r110.get(0);     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L80
        ConcurrentCamera.SingleCameraConfig r101 = r100;     // Catch: Throwable -> L80
        boolean r102 = true;
        ConcurrentCamera.SingleCameraConfig r103 = r110.get(1);     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L80
        ConcurrentCamera.SingleCameraConfig r104 = r103;     // Catch: Throwable -> L80
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L80
        if (Intrinsics.areEqual(r101.getCameraSelector().getLensFacing(), r104.getCameraSelector().getLensFacing()) == true) goto L11;
        Context r105 = access$getMContext$p(this);     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L80
        if (r105.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent") == false) goto L75;
        if (access$getCameraOperatingMode(this) == 1) goto L73;
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L80
        CameraInfo r106 = getCameraInfo(r101.getCameraSelector());     // Catch: IllegalArgumentException -> L70 Throwable -> L80
        CameraInfo r107 = getCameraInfo(r104.getCameraSelector());     // Catch: IllegalArgumentException -> L70 Throwable -> L80
        r112.add(r106);     // Catch: Throwable -> L80
        r112.add(r107);     // Catch: Throwable -> L80
        if ((!access$getActiveConcurrentCameraInfos(this).isEmpty()) == true) goto L42;
    L46:
        access$setCameraOperatingMode(this, 2);     // Catch: Throwable -> L80
        if (Objects.equals(r101.getUseCaseGroup().getUseCases(), r104.getUseCaseGroup().getUseCases()) == true) goto L49;
    L59:
        r102 = false;
    L60:
        if (r102 == false) goto L62;
        LifecycleOwner r108 = r101.getLifecycleOwner();     // Catch: Throwable -> L80
        CameraSelector r109 = r101.getCameraSelector();     // Catch: Throwable -> L80
        CameraSelector r113 = r104.getCameraSelector();     // Catch: Throwable -> L80
        LayoutSettings r114 = r101.getLayoutSettings();     // Catch: Throwable -> L80
        LayoutSettings r115 = r104.getLayoutSettings();     // Catch: Throwable -> L80
        ViewPort r116 = r101.getUseCaseGroup().getViewPort();     // Catch: Throwable -> L80
        List<CameraEffect> r117 = r101.getUseCaseGroup().getEffects();     // Catch: Throwable -> L80
        UseCase[] r118 = (UseCase[]) r101.getUseCaseGroup().getUseCases().toArray(new UseCase[0]);     // Catch: Throwable -> L80
        r111.add(bindToLifecycle$camera_lifecycle_release(r108, r109, r113, r114, r115, r116, r117, (UseCase[]) Arrays.copyOf(r118, r118.length)));     // Catch: Throwable -> L80
    L66:
        access$setActiveConcurrentCameraInfos(this, r112);     // Catch: Throwable -> L80
    L67:
        ConcurrentCamera r119 = new ConcurrentCamera(r111);     // Catch: Throwable -> L80
        Trace.endSection();
        return r119;
    L62:
        Iterator<ConcurrentCamera.SingleCameraConfig> r120 = r110.iterator();     // Catch: Throwable -> L80
    L64:
        if (r120.hasNext() == false) goto L66;
        ConcurrentCamera.SingleCameraConfig r121 = r120.next();     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r121);     // Catch: Throwable -> L80
        LifecycleOwner r122 = r121.getLifecycleOwner();     // Catch: Throwable -> L80
        CameraSelector r123 = r121.getCameraSelector();     // Catch: Throwable -> L80
        LayoutSettings r124 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L80
        ViewPort r125 = r121.getUseCaseGroup().getViewPort();     // Catch: Throwable -> L80
        List<CameraEffect> r126 = r121.getUseCaseGroup().getEffects();     // Catch: Throwable -> L80
        UseCase[] r127 = (UseCase[]) r121.getUseCaseGroup().getUseCases().toArray(new UseCase[0]);     // Catch: Throwable -> L80
        r111.add(bindToLifecycle$camera_lifecycle_release(r122, r123, null, r124, r124, r125, r126, (UseCase[]) Arrays.copyOf(r127, r127.length)));     // Catch: Throwable -> L80
        goto L64
    L49:
        if (r101.getUseCaseGroup().getUseCases().size() != 2) goto L59;
        UseCase r128 = r101.getUseCaseGroup().getUseCases().get(0);     // Catch: Throwable -> L80
        UseCase r129 = r101.getUseCaseGroup().getUseCases().get(1);     // Catch: Throwable -> L80
        if (access$isVideoCapture(this, r128) == false) goto L55;
        if (access$isPreview(this, r129) == true) goto L60;
    L55:
        if (access$isPreview(this, r128) == false) goto L59;
        if (access$isVideoCapture(this, r129) == false) goto L59;
    L42:
        if (Intrinsics.areEqual(r112, access$getActiveConcurrentCameraInfos(this)) == true) goto L46;
        throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras.");     // Catch: Throwable -> L80
    L71:
        throw new IllegalArgumentException("Invalid camera selectors in camera configs.");     // Catch: Throwable -> L80
    L73:
        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");     // Catch: Throwable -> L80
    L75:
        throw new UnsupportedOperationException("Concurrent camera is not supported on the device.");     // Catch: Throwable -> L80
    L11:
        if (access$getCameraOperatingMode(this) == 2) goto L32;
        if (Intrinsics.areEqual(r101.getLifecycleOwner(), r104.getLifecycleOwner()) == false) goto L30;
        if (Intrinsics.areEqual(r101.getUseCaseGroup().getViewPort(), r104.getUseCaseGroup().getViewPort()) == false) goto L30;
        if (Intrinsics.areEqual(r101.getUseCaseGroup().getEffects(), r104.getUseCaseGroup().getEffects()) == false) goto L30;
        LifecycleOwner r130 = r101.getLifecycleOwner();     // Catch: Throwable -> L80
        CameraSelector r131 = r101.getCameraSelector();     // Catch: Throwable -> L80
        ViewPort r132 = r101.getUseCaseGroup().getViewPort();     // Catch: Throwable -> L80
        List<CameraEffect> r133 = r101.getUseCaseGroup().getEffects();     // Catch: Throwable -> L80
        ArrayList r134 = new ArrayList();     // Catch: Throwable -> L80
        Iterator<ConcurrentCamera.SingleCameraConfig> r135 = r110.iterator();     // Catch: Throwable -> L80
    L20:
        if (r135.hasNext() == false) goto L28;
        ConcurrentCamera.SingleCameraConfig r136 = r135.next();     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r136);     // Catch: Throwable -> L80
        Iterator<UseCase> r137 = r136.getUseCaseGroup().getUseCases().iterator();     // Catch: Throwable -> L80
    L23:
        if (r137.hasNext() == false) goto L27;
        UseCase r138 = r137.next();     // Catch: Throwable -> L80
        String r139 = r136.getCameraSelector().getPhysicalCameraId();     // Catch: Throwable -> L80
        if (r139 == null) goto L23;
        r138.setPhysicalCameraId(r139);     // Catch: Throwable -> L80
        goto L23
    L27:
        r134.addAll(r136.getUseCaseGroup().getUseCases());     // Catch: Throwable -> L80
        goto L20
    L28:
        access$setCameraOperatingMode(this, 1);     // Catch: Throwable -> L80
        LayoutSettings r140 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L80
        UseCase[] r141 = (UseCase[]) r134.toArray(new UseCase[0]);     // Catch: Throwable -> L80
        r111.add(bindToLifecycle$camera_lifecycle_release(r130, r131, null, r140, r140, r132, r133, (UseCase[]) Arrays.copyOf(r141, r141.length)));     // Catch: Throwable -> L80
    L30:
        throw new IllegalArgumentException("Two camera configs need to have the same lifecycle owner, view port and effects.");     // Catch: Throwable -> L80
    L32:
        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");     // Catch: Throwable -> L80
    L77:
        throw new IllegalArgumentException("Concurrent camera is only supporting two cameras at maximum.");     // Catch: Throwable -> L80
    L79:
        throw new IllegalArgumentException("Concurrent camera needs two camera configs.");     // Catch: Throwable -> L80
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector r100) {
        Intrinsics.checkNotNullParameter(r100, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        CameraX r101 = access$getMCameraX$p(this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L16
        CameraInfoInternal r102 = r100.select(r101.getCameraRepository().getCameras()).getCameraInfoInternal();     // Catch: Throwable -> L16
        CameraConfig r103 = access$getCameraConfig(this, r100, r102);     // Catch: Throwable -> L16
        CameraUseCaseAdapter.CameraId r104 = CameraUseCaseAdapter.CameraId.create(r102.getCameraId(), r103.getCompatibilityId());     // Catch: Throwable -> L16
        Object r105 = access$getMLock$p(this);     // Catch: Throwable -> L16
        monitor-enter(r105);     // Catch: Throwable -> L16
        Object r106 = access$getMCameraInfoMap$p(this).get(r104);     // Catch: Throwable -> L13
        if (r106 != null) goto L8;
        r106 = new RestrictedCameraInfo(r102, r103);     // Catch: Throwable -> L13
        access$getMCameraInfoMap$p(this).put(r104, r106);     // Catch: Throwable -> L13
    L8:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r105);     // Catch: Throwable -> L16
        RestrictedCameraInfo r108 = (RestrictedCameraInfo) r106;     // Catch: Throwable -> L16
        Trace.endSection();
        return r108;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector r100) throws CameraInfoUnavailableException {
        Intrinsics.checkNotNullParameter(r100, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        CameraX r101 = access$getMCameraX$p(this);     // Catch: Throwable -> L5 IllegalArgumentException -> L8
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L5 IllegalArgumentException -> L8
        r100.select(r101.getCameraRepository().getCameras());     // Catch: Throwable -> L5 IllegalArgumentException -> L8
        boolean r102 = true;
    L9:
        Trace.endSection();
        return r102;
    L8:
        r102 = false;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(UseCase r100) {
        Intrinsics.checkNotNullParameter(r100, "useCase");
        Iterator<LifecycleCamera> r101 = this.mLifecycleCameraRepository.getLifecycleCameras().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().isBound(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(UseCase... r100) {
        Intrinsics.checkNotNullParameter(r100, "useCases");
        Trace.beginSection("CX:unbind");
        Threads.checkMainThread();     // Catch: Throwable -> L10
        if (access$getCameraOperatingMode(this) == 2) goto L9;
        access$getMLifecycleCameraRepository$p(this).unbind(CollectionsKt.listOf(Arrays.copyOf(r100, r100.length)));     // Catch: Throwable -> L10
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        Trace.endSection();
        return;
    L9:
        throw new UnsupportedOperationException("Unbind usecase is not supported in concurrent camera mode, call unbindAll() first.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static final /* synthetic */ void access$configureInstanceInternal(ProcessCameraProvider r100, CameraXConfig r101) {
        r100.configureInstanceInternal(r101);
    }

    public static final /* synthetic */ ListenableFuture access$getOrCreateCameraXInstance(ProcessCameraProvider r100, Context r101) {
        return r100.getOrCreateCameraXInstance(r101);
    }

    public static final /* synthetic */ boolean access$isPreview(ProcessCameraProvider r100, UseCase r101) {
        return r100.isPreview(r101);
    }

    public static final /* synthetic */ boolean access$isVideoCapture(ProcessCameraProvider r100, UseCase r101) {
        return r100.isVideoCapture(r101);
    }

    public static final /* synthetic */ void access$setActiveConcurrentCameraInfos(ProcessCameraProvider r100, List r101) {
        r100.setActiveConcurrentCameraInfos(r101);
    }

    public static final /* synthetic */ void access$setCameraOperatingMode(ProcessCameraProvider r100, int r101) {
        r100.setCameraOperatingMode(r101);
    }

    public static final /* synthetic */ void access$setCameraX(ProcessCameraProvider r100, CameraX r101) {
        r100.setCameraX(r101);
    }

    public static final /* synthetic */ void access$setContext(ProcessCameraProvider r100, Context r101) {
        r100.setContext(r101);
    }

    public static final /* synthetic */ void access$setMCameraXConfigProvider$p(ProcessCameraProvider r100, CameraXConfig.Provider r101) {
        r100.mCameraXConfigProvider = r101;
    }

    private final CameraConfig getCameraConfig(CameraSelector r100, CameraInfo r101) {
        Iterator<CameraFilter> r102 = r100.getCameraFilterSet().iterator();
        CameraConfig r103 = null;
    L4:
        if (r102.hasNext() == false) goto L14;
        CameraFilter r104 = r102.next();
        if (Intrinsics.areEqual(r104.getIdentifier(), CameraFilter.DEFAULT_ID) == true) goto L4;
        CameraConfigProvider r105 = ExtendedCameraConfigProviderStore.getConfigProvider(r104.getIdentifier());
        Context r106 = this.mContext;
        Intrinsics.checkNotNull(r106);
        CameraConfig r107 = r105.getConfig(r101, r106);
        if (r107 == null) goto L4;
        if (r103 != null) goto L13;
        r103 = r107;
        goto L4
    L13:
        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
    L14:
        if (r103 == null) goto L16;
        return r103;
    L16:
        return CameraConfigs.defaultConfig();
    }

    private static final ListenableFuture getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return (ListenableFuture) r100.invoke(r101);
    }

    public static final /* synthetic */ CameraConfig access$getCameraConfig(ProcessCameraProvider r100, CameraSelector r101, CameraInfo r102) {
        return r100.getCameraConfig(r101, r102);
    }

    private static final Object getOrCreateCameraXInstance$lambda$18$lambda$17(ProcessCameraProvider r100, final CameraX r101, final CallbackToFutureAdapter.Completer r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "$cameraX");
        Intrinsics.checkNotNullParameter(r102, "completer");
        Object r103 = r100.mLock;
        monitor-enter(r103);
        FutureChain r104 = FutureChain.from(r100.mCameraXShutdownFuture);     // Catch: Throwable -> L8
        final Function1<Void, ListenableFuture<Void>> r105 = new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1(r101);     // Catch: Throwable -> L8
        Futures.addCallback(r104.transformAsync(new a(r105), CameraXExecutors.directExecutor()), new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1(r102, r101), CameraXExecutors.directExecutor());     // Catch: Throwable -> L8
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r103);
        return "ProcessCameraProvider-initializeCameraX";
    L8:
        th = move-exception;
        throw th;
    }

    public final Camera bindToLifecycle(LifecycleOwner r110, CameraSelector r111, UseCaseGroup r112) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r111, "cameraSelector");
        Intrinsics.checkNotNullParameter(r112, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (access$getCameraOperatingMode(this) == 2) goto L9;
        access$setCameraOperatingMode(this, 1);     // Catch: Throwable -> L10
        LayoutSettings r100 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L10
        ViewPort r101 = r112.getViewPort();     // Catch: Throwable -> L10
        List<CameraEffect> r102 = r112.getEffects();     // Catch: Throwable -> L10
        UseCase[] r113 = (UseCase[]) r112.getUseCases().toArray(new UseCase[0]);     // Catch: Throwable -> L10
        Camera r114 = bindToLifecycle$camera_lifecycle_release(r110, r111, null, r100, r100, r101, r102, (UseCase[]) Arrays.copyOf(r113, r113.length));     // Catch: Throwable -> L10
        Trace.endSection();
        return r114;
    L9:
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");     // Catch: Throwable -> L10
    }

    public final Camera bindToLifecycle(LifecycleOwner r110, CameraSelector r111, UseCase... r112) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r111, "cameraSelector");
        Intrinsics.checkNotNullParameter(r112, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (access$getCameraOperatingMode(this) == 2) goto L9;
        access$setCameraOperatingMode(this, 1);     // Catch: Throwable -> L10
        LayoutSettings r100 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L10
        Camera r113 = bindToLifecycle$camera_lifecycle_release(r110, r111, null, r100, r100, null, CollectionsKt.emptyList(), (UseCase[]) Arrays.copyOf(r112, r112.length));     // Catch: Throwable -> L10
        Trace.endSection();
        return r113;
    L9:
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");     // Catch: Throwable -> L10
    }

    public final Camera bindToLifecycle$camera_lifecycle_release(LifecycleOwner r110, CameraSelector r210, CameraSelector r211, LayoutSettings r212, LayoutSettings r213, ViewPort r214, List<? extends CameraEffect> r215, UseCase... r216) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r210, "primaryCameraSelector");
        Intrinsics.checkNotNullParameter(r212, "primaryLayoutSettings");
        Intrinsics.checkNotNullParameter(r213, "secondaryLayoutSettings");
        Intrinsics.checkNotNullParameter(r215, KFFeature.EFFECT_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r216, "useCases");
        Trace.beginSection("CX:bindToLifecycle-internal");
        Threads.checkMainThread();     // Catch: Throwable -> L33
        CameraX r100 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L33
        CameraInternal r101 = r210.select(r100.getCameraRepository().getCameras());     // Catch: Throwable -> L33
        boolean r102 = true;
        r101.setPrimary(true);     // Catch: Throwable -> L33
        CameraInfo r103 = getCameraInfo(r210);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");     // Catch: Throwable -> L33
        RestrictedCameraInfo r111 = (RestrictedCameraInfo) r103;     // Catch: Throwable -> L33
        if (r211 == null) goto L6;
        CameraX r104 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L33
        CameraInternal r105 = r211.select(r104.getCameraRepository().getCameras());     // Catch: Throwable -> L33
        r105.setPrimary(false);     // Catch: Throwable -> L33
        CameraInfo r106 = getCameraInfo(r211);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");     // Catch: Throwable -> L33
        RestrictedCameraInfo r112 = (RestrictedCameraInfo) r106;     // Catch: Throwable -> L33
        CameraInternal r107 = r105;
    L7:
        LifecycleCamera r108 = access$getMLifecycleCameraRepository$p(this).getLifecycleCamera(r110, CameraUseCaseAdapter.generateCameraId(r111, r112));     // Catch: Throwable -> L33
        Collection<LifecycleCamera> r109 = access$getMLifecycleCameraRepository$p(this).getLifecycleCameras();     // Catch: Throwable -> L33
        Iterator r113 = ArraysKt.filterNotNull(r216).iterator();     // Catch: Throwable -> L33
    L9:
        if (r113.hasNext() == false) goto L22;
        UseCase r114 = (UseCase) r113.next();     // Catch: Throwable -> L33
        Iterator<LifecycleCamera> r115 = r109.iterator();     // Catch: Throwable -> L33
    L12:
        if (r115.hasNext() == false) goto L9;
        LifecycleCamera r116 = r115.next();     // Catch: Throwable -> L33
        if (r116.isBound(r114) == false) goto L12;
        if (Intrinsics.areEqual(r116, r108) == true) goto L12;
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L33
        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{r114}, 1)));     // Catch: Throwable -> L33
    L22:
        if (r108 != null) goto L25;
        LifecycleCameraRepository r118 = access$getMLifecycleCameraRepository$p(this);     // Catch: Throwable -> L33
        CameraX r119 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r119);     // Catch: Throwable -> L33
        CameraCoordinator r120 = r119.getCameraFactory().getCameraCoordinator();     // Catch: Throwable -> L33
        CameraX r121 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r121);     // Catch: Throwable -> L33
        CameraDeviceSurfaceManager r122 = r121.getCameraDeviceSurfaceManager();     // Catch: Throwable -> L33
        CameraX r123 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r123);     // Catch: Throwable -> L33
        r108 = r118.createLifecycleCamera(r110, new CameraUseCaseAdapter(r101, r107, r111, r112, r212, r213, r120, r122, r123.getDefaultConfigFactory()));     // Catch: Throwable -> L33
    L25:
        if (r216.length == 0) goto L28;
        r102 = false;
    L28:
        if (r102 == false) goto L30;
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L33
    L31:
        Trace.endSection();
        return r108;
    L30:
        LifecycleCameraRepository r124 = access$getMLifecycleCameraRepository$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L33
        List r125 = CollectionsKt.listOf(Arrays.copyOf(r216, r216.length));     // Catch: Throwable -> L33
        CameraX r126 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r126);     // Catch: Throwable -> L33
        r124.bindToLifecycleCamera(r108, r214, r215, r125, r126.getCameraFactory().getCameraCoordinator());     // Catch: Throwable -> L33
        goto L31
    L6:
        r107 = null;
        r112 = null;
    L33:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
