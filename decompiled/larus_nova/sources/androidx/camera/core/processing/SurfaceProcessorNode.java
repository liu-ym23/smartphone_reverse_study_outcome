package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";
    final CameraInternal mCameraInternal;
    private In mInput;
    private Out mOutput;
    final SurfaceProcessorInternal mSurfaceProcessor;

    public static abstract class In {
        public In() {
        }

        public abstract List<OutConfig> getOutConfigs();

        public abstract SurfaceEdge getSurfaceEdge();

        public static In of(SurfaceEdge r100, List<OutConfig> r101) {
            return new AutoValue_SurfaceProcessorNode_In(r100, r101);
        }
    }

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
        public Out() {
        }
    }

    public static /* synthetic */ void a(SurfaceProcessorNode r100, SurfaceEdge r101, Map.Entry r102) {
        r100.lambda$sendSurfaceOutputs$0(r101, r102);
    }

    public static /* synthetic */ void b(SurfaceProcessorNode r100) {
        r100.lambda$release$2();
    }

    public static /* synthetic */ void c(Map r100, SurfaceRequest.TransformationInfo r101) {
        lambda$setUpRotationUpdates$1(r100, r101);
    }

    private /* synthetic */ void lambda$release$2() {
        Out r100 = this.mOutput;
        if (r100 == null) goto L8;
        Iterator<SurfaceEdge> r101 = r100.values().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        r101.next().close();
        goto L6
    L10:
        return;
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        Threads.runOnMain(new g0(this));
    }

    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    private void sendSurfaceRequest(SurfaceEdge r100) {
        this.mSurfaceProcessor.onInputSurface(r100.createSurfaceRequest(this.mCameraInternal));     // Catch: ProcessingException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public Out transform2(In r100) {
        Threads.checkMainThread();
        this.mInput = r100;
        this.mOutput = new Out();
        SurfaceEdge r101 = r100.getSurfaceEdge();
        Iterator<OutConfig> r102 = r100.getOutConfigs().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        OutConfig r103 = r102.next();
        this.mOutput.put(r103, transformSingleOutput(r101, r103));
        goto L4
    L6:
        sendSurfaceRequest(r101);
        sendSurfaceOutputs(r101, this.mOutput);
        setUpRotationUpdates(r101, this.mOutput);
        return this.mOutput;
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ Out transform(In r100) {
        return transform2(r100);
    }

    public SurfaceProcessorNode(CameraInternal r100, SurfaceProcessorInternal r101) {
        this.mCameraInternal = r100;
        this.mSurfaceProcessor = r101;
    }

    private void createAndSendSurfaceOutput(SurfaceEdge r100, Map.Entry<OutConfig, SurfaceEdge> r101) {
        final SurfaceEdge r102 = r101.getValue();
        Size r103 = r100.getStreamSpec().getResolution();
        Rect r104 = r101.getKey().getCropRect();
        if (r100.hasCameraTransform() == false) goto L5;
        CameraInternal r105 = this.mCameraInternal;
    L6:
        Futures.addCallback(r102.createSurfaceOutputFuture(r101.getKey().getFormat(), SurfaceOutput.CameraInputInfo.of(r103, r104, r105, r101.getKey().getRotationDegrees(), r101.getKey().isMirroring()), null), new AnonymousClass1(this, r102), CameraXExecutors.mainThreadExecutor());
        return;
    L5:
        r105 = null;
        goto L6
    }

    private /* synthetic */ void lambda$sendSurfaceOutputs$0(SurfaceEdge r100, Map.Entry r101) {
        createAndSendSurfaceOutput(r100, r101);
    }

    private static /* synthetic */ void lambda$setUpRotationUpdates$1(Map r100, SurfaceRequest.TransformationInfo r101) {
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        int r104 = r101.getRotationDegrees() - ((OutConfig) r103.getKey()).getRotationDegrees();
        if (((OutConfig) r103.getKey()).isMirroring() == false) goto L8;
        r104 = -r104;
    L8:
        int r105 = TransformUtils.within360(r104);
        ((SurfaceEdge) r103.getValue()).updateTransformation(r105, -1);
        goto L4
    }

    private void sendSurfaceOutputs(final SurfaceEdge r100, Map<OutConfig, SurfaceEdge> r101) {
        Iterator<Map.Entry<OutConfig, SurfaceEdge>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final Map.Entry<OutConfig, SurfaceEdge> r103 = r102.next();
        createAndSendSurfaceOutput(r100, r103);
        r103.getValue().addOnInvalidatedListener(new f0(this, r100, r103));
        goto L4
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge r110, OutConfig r111) {
        Rect r100 = r111.getCropRect();
        int r101 = r111.getRotationDegrees();
        boolean r102 = r111.isMirroring();
        Matrix r103 = new Matrix(r110.getSensorToBufferTransform());
        Matrix r104 = TransformUtils.getRectToRect(new RectF(r100), TransformUtils.sizeToRectF(r111.getSize()), r101, r102);
        r103.postConcat(r104);
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(r100, r101), r111.getSize()));
        if (r111.shouldRespectInputCropRect() == false) goto L5;
        Preconditions.checkArgument(r111.getCropRect().contains(r110.getCropRect()), String.format("Output crop rect %s must contain input crop rect %s", new Object[]{r111.getCropRect(), r110.getCropRect()}));
        Rect r105 = new Rect();
        RectF r106 = new RectF(r110.getCropRect());
        r104.mapRect(r106);
        r106.round(r105);
    L6:
        Rect r107 = r105;
        StreamSpec r108 = r110.getStreamSpec().toBuilder().setResolution(r111.getSize()).build();
        int r109 = r111.getTargets();
        int r112 = r111.getFormat();
        int r113 = r110.getRotationDegrees() - r101;
        if (r110.isMirroring() == r102) goto L9;
        boolean r114 = true;
    L11:
        return new SurfaceEdge(r109, r112, r108, r103, false, r107, r113, -1, r114);
    L9:
        r114 = false;
        goto L11
    L5:
        r105 = TransformUtils.sizeToRect(r111.getSize());
        goto L6
    }

    public void setUpRotationUpdates(SurfaceEdge r100, final Map<OutConfig, SurfaceEdge> r101) {
        r100.addTransformationUpdateListener(new e0(r101));
    }
}
