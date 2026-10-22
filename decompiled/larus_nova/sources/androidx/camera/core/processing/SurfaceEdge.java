package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceEdge {
    private final Rect mCropRect;
    private final int mFormat;
    private final boolean mHasCameraTransform;
    private boolean mHasConsumer;
    private boolean mIsClosed;
    private final boolean mMirroring;
    private final Set<Runnable> mOnInvalidatedListeners;
    private SurfaceRequest mProviderSurfaceRequest;
    private int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private SettableSurface mSettableSurface;
    private final StreamSpec mStreamSpec;
    private int mTargetRotation;
    private final int mTargets;
    private final List<Consumer<SurfaceRequest.TransformationInfo>> mTransformationUpdatesListeners;

    public static class SettableSurface extends DeferrableSurface {
        CallbackToFutureAdapter.Completer<Surface> mCompleter;
        private SurfaceOutputImpl mConsumer;
        private DeferrableSurface mProvider;
        final ListenableFuture<Surface> mSurfaceFuture;

        public static /* synthetic */ void d(SettableSurface r100) {
            r100.lambda$close$1();
        }

        public static /* synthetic */ Object e(SettableSurface r100, CallbackToFutureAdapter.Completer r101) {
            return r100.lambda$new$0(r101);
        }

        private /* synthetic */ void lambda$close$1() {
            SurfaceOutputImpl r100 = this.mConsumer;
            if (r100 == null) goto L6;
            r100.requestClose();
        L6:
            if (this.mProvider != null) goto L9;
            this.mCompleter.setCancelled();
            return;
        }

        public boolean hasProvider() {
            if (this.mProvider == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean canSetProvider() {
            Threads.checkMainThread();
            if (this.mProvider == null) goto L5;
        L7:
            return false;
        L5:
            if (isClosed() == true) goto L7;
            return true;
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public void close() {
            super.close();
            Threads.runOnMain(new b0(this));
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public ListenableFuture<Surface> provideSurface() {
            return this.mSurfaceFuture;
        }

        private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r100) throws Exception {
            this.mCompleter = r100;
            return "SettableFuture hashCode: " + hashCode();
        }

        public void setConsumer(SurfaceOutputImpl r100) {
            if (this.mConsumer != null) goto L5;
            boolean r101 = true;
        L6:
            Preconditions.checkState(r101, "Consumer can only be linked once.");
            this.mConsumer = r100;
            return;
        L5:
            r101 = false;
            goto L6
        }

        public SettableSurface(Size r100, int r101) {
            super(r100, r101);
            this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new z(this));
        }

        public boolean setProvider(final DeferrableSurface r100, Runnable r101) throws DeferrableSurface.SurfaceClosedException {
            Threads.checkMainThread();
            Preconditions.checkNotNull(r100);
            DeferrableSurface r102 = this.mProvider;
            if (r102 != r100) goto L6;
            return false;
        L6:
            if (r102 != null) goto L8;
            boolean r103 = true;
        L9:
            Preconditions.checkState(r103, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            Preconditions.checkArgument(getPrescribedSize().equals(r100.getPrescribedSize()), String.format("The provider's size(%s) must match the parent(%s)", new Object[]{getPrescribedSize(), r100.getPrescribedSize()}));
            if (getPrescribedStreamFormat() != r100.getPrescribedStreamFormat()) goto L12;
            boolean r104 = true;
        L13:
            Preconditions.checkArgument(r104, String.format("The provider's format(%s) must match the parent(%s)", new Object[]{Integer.valueOf(getPrescribedStreamFormat()), Integer.valueOf(r100.getPrescribedStreamFormat())}));
            Preconditions.checkState(!isClosed(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.mProvider = r100;
            Futures.propagate(r100.getSurface(), this.mCompleter);
            r100.incrementUseCount();
            getTerminationFuture().addListener(new a0(r100), CameraXExecutors.directExecutor());
            r100.getCloseFuture().addListener(r101, CameraXExecutors.mainThreadExecutor());
            return true;
        L12:
            r104 = false;
            goto L13
        L8:
            r103 = false;
            goto L9
        }
    }

    public static /* synthetic */ void a(SurfaceEdge r100, int r101, int r102) {
        r100.lambda$updateTransformation$3(r101, r102);
    }

    public static /* synthetic */ void b(SurfaceEdge r100) {
        r100.lambda$createSurfaceRequest$1();
    }

    public static /* synthetic */ void c(SurfaceEdge r100) {
        r100.lambda$createSurfaceRequest$0();
    }

    public static /* synthetic */ ListenableFuture d(SurfaceEdge r100, SettableSurface r101, int r102, SurfaceOutput.CameraInputInfo r103, SurfaceOutput.CameraInputInfo r104, Surface r105) {
        return r100.lambda$createSurfaceOutputFuture$2(r101, r102, r103, r104, r105);
    }

    private void checkAndSetHasConsumer() {
        Preconditions.checkState(!this.mHasConsumer, "Consumer can only be linked once.");
        this.mHasConsumer = true;
    }

    private void checkNotClosed() {
        Preconditions.checkState(!this.mIsClosed, "Edge is already closed.");
    }

    private /* synthetic */ void lambda$createSurfaceRequest$0() {
        if (this.mIsClosed == true) goto L6;
        invalidate();
        return;
    }

    public boolean hasProvider() {
        return this.mSettableSurface.hasProvider();
    }

    private /* synthetic */ void lambda$createSurfaceRequest$1() {
        CameraXExecutors.mainThreadExecutor().execute(new s(this));
    }

    private void notifyTransformationInfoUpdate() {
        Threads.checkMainThread();
        SurfaceRequest.TransformationInfo r100 = SurfaceRequest.TransformationInfo.of(this.mCropRect, this.mRotationDegrees, this.mTargetRotation, hasCameraTransform(), this.mSensorToBufferTransform, this.mMirroring);
        SurfaceRequest r101 = this.mProviderSurfaceRequest;
        if (r101 == null) goto L5;
        r101.updateTransformationInfo(r100);
    L5:
        Iterator<Consumer<SurfaceRequest.TransformationInfo>> r102 = this.mTransformationUpdatesListeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().accept(r100);
        goto L7
    }

    public final void close() {
        Threads.checkMainThread();
        this.mSettableSurface.close();
        this.mIsClosed = true;
    }

    public final void disconnect() {
        Threads.checkMainThread();
        checkNotClosed();
        this.mSettableSurface.close();
    }

    public DeferrableSurface getDeferrableSurface() {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        return this.mSettableSurface;
    }

    public void invalidate() {
        Threads.checkMainThread();
        checkNotClosed();
        if (this.mSettableSurface.canSetProvider() == false) goto L5;
        return;
    L5:
        this.mHasConsumer = false;
        this.mSettableSurface.close();
        this.mSettableSurface = new SettableSurface(this.mStreamSpec.getResolution(), this.mFormat);
        Iterator<Runnable> r100 = this.mOnInvalidatedListeners.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        r100.next().run();
        goto L7
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public DeferrableSurface getDeferrableSurfaceForTesting() {
        return this.mSettableSurface;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public StreamSpec getStreamSpec() {
        return this.mStreamSpec;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public boolean hasCameraTransform() {
        return this.mHasCameraTransform;
    }

    public boolean isClosed() {
        return this.mIsClosed;
    }

    public boolean isMirroring() {
        return this.mMirroring;
    }

    public void addOnInvalidatedListener(Runnable r100) {
        Threads.checkMainThread();
        checkNotClosed();
        this.mOnInvalidatedListeners.add(r100);
    }

    public void addTransformationUpdateListener(Consumer<SurfaceRequest.TransformationInfo> r100) {
        Preconditions.checkNotNull(r100);
        this.mTransformationUpdatesListeners.add(r100);
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal r100) {
        return createSurfaceRequest(r100, true);
    }

    public void removeTransformationUpdateListener(Consumer<SurfaceRequest.TransformationInfo> r100) {
        Preconditions.checkNotNull(r100);
        this.mTransformationUpdatesListeners.remove(r100);
    }

    public void setProvider(DeferrableSurface r100) throws DeferrableSurface.SurfaceClosedException {
        Threads.checkMainThread();
        checkNotClosed();
        SettableSurface r101 = this.mSettableSurface;
        Objects.requireNonNull(r101);
        r101.setProvider(r100, new t(r101));
    }

    public void updateTransformation(int r100) {
        updateTransformation(r100, -1);
    }

    private /* synthetic */ void lambda$updateTransformation$3(int r100, int r101) {
        boolean r102 = true;
        if (this.mRotationDegrees == r100) goto L5;
        this.mRotationDegrees = r100;
        boolean r103 = true;
    L7:
        if (this.mTargetRotation == r101) goto L9;
        this.mTargetRotation = r101;
    L10:
        if (r102 == false) goto L13;
        notifyTransformationInfoUpdate();
        return;
    L13:
        return;
    L9:
        r102 = r103;
        goto L10
    L5:
        r103 = false;
        goto L7
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal r100, boolean r110) {
        Threads.checkMainThread();
        checkNotClosed();
        SurfaceRequest r101 = new SurfaceRequest(this.mStreamSpec.getResolution(), r100, r110, this.mStreamSpec.getDynamicRange(), this.mStreamSpec.getExpectedFrameRateRange(), new u(this));
        final DeferrableSurface r102 = r101.getDeferrableSurface();     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        SettableSurface r111 = this.mSettableSurface;     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        Objects.requireNonNull(r111);     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        if (r111.setProvider(r102, new t(r111)) == false) goto L6;
        ListenableFuture<Void> r112 = r111.getTerminationFuture();     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        Objects.requireNonNull(r102);     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        r112.addListener(new v(r102), CameraXExecutors.directExecutor());     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
    L6:
        this.mProviderSurfaceRequest = r101;
        notifyTransformationInfoUpdate();
        return r101;
    L11:
        e = move-exception;
        throw new AssertionError("Surface is somehow already closed", e);
    L8:
        e = move-exception;
        r101.willNotProvideSurface();
        throw e;
    }

    public void updateTransformation(final int r100, final int r101) {
        Threads.runOnMain(new y(this, r100, r101));
    }

    public ListenableFuture<SurfaceOutput> createSurfaceOutputFuture(final int r100, final SurfaceOutput.CameraInputInfo r110, final SurfaceOutput.CameraInputInfo r111) {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        final SettableSurface r101 = this.mSettableSurface;
        return Futures.transformAsync(r101.getSurface(), new w(this, r101, r100, r110, r111), CameraXExecutors.mainThreadExecutor());
    }

    private /* synthetic */ ListenableFuture lambda$createSurfaceOutputFuture$2(final SettableSurface r110, int r111, SurfaceOutput.CameraInputInfo r112, SurfaceOutput.CameraInputInfo r113, Surface r114) throws Exception {
        Preconditions.checkNotNull(r114);
        r110.incrementUseCount();     // Catch: DeferrableSurface.SurfaceClosedException -> L6
        SurfaceOutputImpl r100 = new SurfaceOutputImpl(r114, getTargets(), r111, this.mStreamSpec.getResolution(), r112, r113, this.mSensorToBufferTransform);
        r100.getCloseFuture().addListener(new x(r110), CameraXExecutors.directExecutor());
        r110.setConsumer(r100);
        return Futures.immediateFuture(r100);
    L6:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    }

    public SurfaceEdge(int r100, int r101, StreamSpec r102, Matrix r103, boolean r104, Rect r105, int r106, int r110, boolean r111) {
        this.mHasConsumer = false;
        this.mOnInvalidatedListeners = new HashSet();
        this.mIsClosed = false;
        this.mTransformationUpdatesListeners = new ArrayList();
        this.mTargets = r100;
        this.mFormat = r101;
        this.mStreamSpec = r102;
        this.mSensorToBufferTransform = r103;
        this.mHasCameraTransform = r104;
        this.mCropRect = r105;
        this.mRotationDegrees = r106;
        this.mTargetRotation = r110;
        this.mMirroring = r111;
        this.mSettableSurface = new SettableSurface(r102.getResolution(), this.mFormat);
    }
}
