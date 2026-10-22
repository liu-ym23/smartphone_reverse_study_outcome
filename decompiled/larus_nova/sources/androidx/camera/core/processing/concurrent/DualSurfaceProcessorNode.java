package androidx.camera.core.processing.concurrent;

import android.graphics.Matrix;
import android.graphics.Rect;
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
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DualSurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "DualSurfaceProcessorNode";
    private In mInput;
    private Out mOutput;
    final CameraInternal mPrimaryCameraInternal;
    final CameraInternal mSecondaryCameraInternal;
    final SurfaceProcessorInternal mSurfaceProcessor;

    public static abstract class In {
        public In() {
        }

        public abstract List<DualOutConfig> getOutConfigs();

        public abstract SurfaceEdge getPrimarySurfaceEdge();

        public abstract SurfaceEdge getSecondarySurfaceEdge();

        public static In of(SurfaceEdge r100, SurfaceEdge r101, List<DualOutConfig> r102) {
            return new AutoValue_DualSurfaceProcessorNode_In(r100, r101, r102);
        }
    }

    public static class Out extends HashMap<DualOutConfig, SurfaceEdge> {
        public Out() {
        }
    }

    public static /* synthetic */ void a(DualSurfaceProcessorNode r100, CameraInternal r101, CameraInternal r102, SurfaceEdge r103, SurfaceEdge r104, Map.Entry r105) {
        r100.lambda$sendSurfaceOutputs$0(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void b(DualSurfaceProcessorNode r100) {
        r100.lambda$release$1();
    }

    private /* synthetic */ void lambda$release$1() {
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
        Threads.runOnMain(new k(this));
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public Out transform2(In r100) {
        Threads.checkMainThread();
        this.mInput = r100;
        this.mOutput = new Out();
        SurfaceEdge r101 = this.mInput.getPrimarySurfaceEdge();
        SurfaceEdge r102 = this.mInput.getSecondarySurfaceEdge();
        Iterator<DualOutConfig> r103 = this.mInput.getOutConfigs().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        DualOutConfig r104 = r103.next();
        this.mOutput.put(r104, transformSingleOutput(r101, r104.getPrimaryOutConfig()));
        goto L4
    L6:
        sendSurfaceRequest(this.mPrimaryCameraInternal, r101, this.mOutput, true);
        sendSurfaceRequest(this.mSecondaryCameraInternal, r102, this.mOutput, false);
        sendSurfaceOutputs(this.mPrimaryCameraInternal, this.mSecondaryCameraInternal, r101, r102, this.mOutput);
        return this.mOutput;
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ Out transform(In r100) {
        return transform2(r100);
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge r110, OutConfig r111) {
        Rect r100 = r111.getCropRect();
        int r101 = r111.getRotationDegrees();
        boolean r102 = r111.isMirroring();
        Matrix r103 = new Matrix();
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(r100, r101), r111.getSize()));
        Rect r104 = TransformUtils.sizeToRect(r111.getSize());
        StreamSpec r105 = r110.getStreamSpec().toBuilder().setResolution(r111.getSize()).build();
        int r106 = r111.getTargets();
        int r107 = r111.getFormat();
        int r112 = r110.getRotationDegrees() - r101;
        if (r110.isMirroring() == r102) goto L5;
        boolean r113 = true;
    L7:
        return new SurfaceEdge(r106, r107, r105, r103, false, r104, r112, -1, r113);
    L5:
        r113 = false;
        goto L7
    }

    public DualSurfaceProcessorNode(CameraInternal r100, CameraInternal r101, SurfaceProcessorInternal r102) {
        this.mPrimaryCameraInternal = r100;
        this.mSecondaryCameraInternal = r101;
        this.mSurfaceProcessor = r102;
    }

    private void sendSurfaceRequest(CameraInternal r100, SurfaceEdge r101, Map<DualOutConfig, SurfaceEdge> r102, boolean r103) {
        SurfaceRequest r104 = r101.createSurfaceRequest(r100, r103);
        this.mSurfaceProcessor.onInputSurface(r104);     // Catch: ProcessingException -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
    }

    private void createAndSendSurfaceOutput(CameraInternal r100, CameraInternal r101, SurfaceEdge r102, SurfaceEdge r103, Map.Entry<DualOutConfig, SurfaceEdge> r110) {
        final SurfaceEdge r104 = r110.getValue();
        Size r105 = r102.getStreamSpec().getResolution();
        Rect r106 = r110.getKey().getPrimaryOutConfig().getCropRect();
        if (r102.hasCameraTransform() == true) goto L6;
        r100 = null;
    L6:
        SurfaceOutput.CameraInputInfo r107 = SurfaceOutput.CameraInputInfo.of(r105, r106, r100, r110.getKey().getPrimaryOutConfig().getRotationDegrees(), r110.getKey().getPrimaryOutConfig().isMirroring());
        Size r108 = r103.getStreamSpec().getResolution();
        Rect r109 = r110.getKey().getSecondaryOutConfig().getCropRect();
        if (r103.hasCameraTransform() == true) goto L10;
        r101 = null;
    L10:
        Futures.addCallback(r104.createSurfaceOutputFuture(r110.getKey().getPrimaryOutConfig().getFormat(), r107, SurfaceOutput.CameraInputInfo.of(r108, r109, r101, r110.getKey().getSecondaryOutConfig().getRotationDegrees(), r110.getKey().getSecondaryOutConfig().isMirroring())), new AnonymousClass1(this, r104), CameraXExecutors.mainThreadExecutor());
    }

    private /* synthetic */ void lambda$sendSurfaceOutputs$0(CameraInternal r100, CameraInternal r101, SurfaceEdge r102, SurfaceEdge r103, Map.Entry r104) {
        createAndSendSurfaceOutput(r100, r101, r102, r103, r104);
    }

    private void sendSurfaceOutputs(final CameraInternal r110, final CameraInternal r111, final SurfaceEdge r112, final SurfaceEdge r113, Map<DualOutConfig, SurfaceEdge> r114) {
        Iterator<Map.Entry<DualOutConfig, SurfaceEdge>> r115 = r114.entrySet().iterator();
    L4:
        if (r115.hasNext() == false) goto L6;
        final Map.Entry<DualOutConfig, SurfaceEdge> r100 = r115.next();
        createAndSendSurfaceOutput(r110, r111, r112, r113, r100);
        r100.getValue().addOnInvalidatedListener(new l(this, r110, r111, r112, r113, r100));
        goto L4
    }
}
