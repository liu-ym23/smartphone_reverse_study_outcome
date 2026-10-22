package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessingNode implements Node<In, Void> {
    private static final String TAG = "ProcessingNode";
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> mBitmap2JpegBytes;
    private Operation<Packet<Bitmap>, Packet<Bitmap>> mBitmapEffect;
    final Executor mBlockingExecutor;
    private final boolean mHasIncorrectJpegMetadataQuirk;
    private Operation<Packet<ImageProxy>, Bitmap> mImage2Bitmap;
    private Operation<Image2JpegBytes.In, Packet<byte[]>> mImage2JpegBytes;
    final InternalImageProcessor mImageProcessor;
    private Operation<InputPacket, Packet<ImageProxy>> mInput2Packet;
    private In mInputEdge;
    private Operation<Packet<byte[]>, Packet<Bitmap>> mJpegBytes2CroppedBitmap;
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> mJpegBytes2Disk;
    private Operation<Packet<byte[]>, Packet<ImageProxy>> mJpegBytes2Image;
    private Operation<Packet<ImageProxy>, ImageProxy> mJpegImage2Result;
    private final Quirks mQuirks;

    public static abstract class In {
        public In() {
        }

        public abstract Edge<InputPacket> getEdge();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract Edge<InputPacket> getPostviewEdge();

        public static In of(int r100, int r101) {
            return new AutoValue_ProcessingNode_In(new Edge(), new Edge(), r100, r101);
        }
    }

    public static abstract class InputPacket {
        public InputPacket() {
        }

        public abstract ImageProxy getImageProxy();

        public abstract ProcessingRequest getProcessingRequest();

        public static InputPacket of(ProcessingRequest r100, ImageProxy r101) {
            return new AutoValue_ProcessingNode_InputPacket(r100, r101);
        }
    }

    public static /* synthetic */ void a(ProcessingNode r100, InputPacket r101) {
        r100.lambda$transform$0(r101);
    }

    public static /* synthetic */ void b(ProcessingNode r100, InputPacket r101) {
        r100.lambda$transform$1(r101);
    }

    public static /* synthetic */ void c(ProcessingRequest r100, ImageProxy r101) {
        lambda$processInputPacket$4(r100, r101);
    }

    public static /* synthetic */ void d(ProcessingNode r100, InputPacket r101) {
        r100.lambda$transform$2(r101);
    }

    public static /* synthetic */ void e(ProcessingNode r100, InputPacket r101) {
        r100.lambda$transform$3(r101);
    }

    public static /* synthetic */ void f(ProcessingRequest r100, ImageCaptureException r101) {
        lambda$sendError$7(r100, r101);
    }

    public static /* synthetic */ void g(ProcessingRequest r100, Bitmap r101) {
        lambda$processPostviewInputPacket$6(r100, r101);
    }

    public static /* synthetic */ void h(ProcessingRequest r100, ImageCapture.OutputFileResults r101) {
        lambda$processInputPacket$5(r100, r101);
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }

    public ProcessingNode(Executor r100) {
        this(r100, null, DeviceQuirks.getAll());
    }

    private /* synthetic */ void lambda$transform$0(InputPacket r100) {
        processInputPacket(r100);
    }

    private /* synthetic */ void lambda$transform$1(final InputPacket r100) {
        if (r100.getProcessingRequest().isAborted() == false) goto L6;
        r100.getImageProxy().close();
        return;
    L6:
        this.mBlockingExecutor.execute(new p(this, r100));
    }

    private /* synthetic */ void lambda$transform$2(InputPacket r100) {
        processPostviewInputPacket(r100);
    }

    private /* synthetic */ void lambda$transform$3(final InputPacket r100) {
        if (r100.getProcessingRequest().isAborted() == false) goto L6;
        Logger.w(TAG, "The postview image is closed due to request aborted");
        r100.getImageProxy().close();
        return;
    L6:
        this.mBlockingExecutor.execute(new o(this, r100));
    }

    public void injectProcessingInput2Packet(Operation<InputPacket, Packet<ImageProxy>> r100) {
        this.mInput2Packet = r100;
    }

    public ImageProxy processInMemoryCapture(InputPacket r100) throws ImageCaptureException {
        ProcessingRequest r101 = r100.getProcessingRequest();
        Packet<ImageProxy> r102 = this.mInput2Packet.apply(r100);
        if (r102.getFormat() == 35) goto L9;
        if (this.mBitmapEffect != null) goto L9;
        if (this.mHasIncorrectJpegMetadataQuirk == true) goto L9;
    L15:
        return this.mJpegImage2Result.apply(r102);
    L9:
        if (this.mInputEdge.getOutputFormat() != 256) goto L15;
        Packet<byte[]> r103 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(r102, r101.getJpegQuality()));
        if (this.mBitmapEffect == null) goto L13;
        r103 = cropAndMaybeApplyEffect(r103, r101.getJpegQuality());
    L13:
        r102 = this.mJpegBytes2Image.apply(r103);
        goto L15
    }

    public void processInputPacket(InputPacket r100) {
        final ProcessingRequest r101 = r100.getProcessingRequest();
    L12:
        e = move-exception;
        sendError(r101, e);
        return;
    L10:
        e = move-exception;
        sendError(r101, new ImageCaptureException(0, "Processing failed due to low memory.", e));
        return;
    L8:
        e = move-exception;
        sendError(r101, new ImageCaptureException(0, "Processing failed.", e));
        return;
    L4:
        if (r100.getProcessingRequest().isInMemoryCapture() == false) goto L6;
        final ImageProxy r102 = processInMemoryCapture(r100);     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
        CameraXExecutors.mainThreadExecutor().execute(new q(r101, r102));     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
    L15:
        return;
    L6:
        final ImageCapture.OutputFileResults r103 = processOnDiskCapture(r100);     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
        CameraXExecutors.mainThreadExecutor().execute(new r(r101, r103));     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
        goto L15
    }

    public ImageCapture.OutputFileResults processOnDiskCapture(InputPacket r100) throws ImageCaptureException {
        int r101 = this.mInputEdge.getOutputFormat();
        Preconditions.checkArgument(ImageUtil.isJpegFormats(r101), String.format("On-disk capture only support JPEG and JPEG/R output formats. Output format: %s", new Object[]{Integer.valueOf(r101)}));
        ProcessingRequest r102 = r100.getProcessingRequest();
        Packet<byte[]> r103 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(this.mInput2Packet.apply(r100), r102.getJpegQuality()));
        if (r103.hasCropping() == false) goto L5;
    L6:
        r103 = cropAndMaybeApplyEffect(r103, r102.getJpegQuality());
    L7:
        Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> r104 = this.mJpegBytes2Disk;
        ImageCapture.OutputFileOptions r105 = r102.getOutputFileOptions();
        Objects.requireNonNull(r105);
        return r104.apply(JpegBytes2Disk.In.of(r103, r105));
    L5:
        if (this.mBitmapEffect == null) goto L7;
        goto L6
    }

    public void processPostviewInputPacket(InputPacket r100) {
        int r101 = this.mInputEdge.getOutputFormat();
        if (r101 != 35) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Preconditions.checkArgument(r102, String.format("Postview only support YUV and JPEG output formats. Output format: %s", new Object[]{Integer.valueOf(r101)}));
        final ProcessingRequest r103 = r100.getProcessingRequest();
        final Bitmap r104 = this.mImage2Bitmap.apply(this.mInput2Packet.apply(r100));     // Catch: Exception -> L12
        CameraXExecutors.mainThreadExecutor().execute(new k(r103, r104));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        r100.getImageProxy().close();
        Logger.e(TAG, "process postview input packet failed.", e);
        return;
    L5:
        if (r101 == 256) goto L8;
        r102 = false;
        goto L9
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public Void transform2(In r100) {
        this.mInputEdge = r100;
        r100.getEdge().setListener(new l(this));
        r100.getPostviewEdge().setListener(new m(this));
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes(this.mQuirks);
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        this.mImage2Bitmap = new Image2Bitmap();
        if (r100.getInputFormat() != 35) goto L5;
    L8:
        this.mJpegBytes2Image = new JpegBytes2Image();
    L9:
        InternalImageProcessor r101 = this.mImageProcessor;
        if (r101 == null) goto L14;
        this.mBitmapEffect = new BitmapEffect(r101);
        return null;
    L14:
        return null;
    L5:
        if (this.mImageProcessor != null) goto L8;
        if (this.mHasIncorrectJpegMetadataQuirk == false) goto L9;
        goto L8
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ Void transform(In r100) {
        return transform2(r100);
    }

    public ProcessingNode(Executor r100, InternalImageProcessor r101) {
        this(r100, r101, DeviceQuirks.getAll());
    }

    private Packet<byte[]> cropAndMaybeApplyEffect(Packet<byte[]> r100, int r101) throws ImageCaptureException {
        Preconditions.checkState(ImageUtil.isJpegFormats(r100.getFormat()));
        Packet<Bitmap> r102 = this.mJpegBytes2CroppedBitmap.apply(r100);
        Operation<Packet<Bitmap>, Packet<Bitmap>> r103 = this.mBitmapEffect;
        if (r103 == null) goto L6;
        r102 = r103.apply(r102);
    L6:
        return this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(r102, r101));
    }

    private static /* synthetic */ void lambda$processInputPacket$4(ProcessingRequest r100, ImageProxy r101) {
        r100.onFinalResult(r101);
    }

    private static /* synthetic */ void lambda$processInputPacket$5(ProcessingRequest r100, ImageCapture.OutputFileResults r101) {
        r100.onFinalResult(r101);
    }

    private static /* synthetic */ void lambda$processPostviewInputPacket$6(ProcessingRequest r100, Bitmap r101) {
        r100.onPostviewBitmapAvailable(r101);
    }

    private static /* synthetic */ void lambda$sendError$7(ProcessingRequest r100, ImageCaptureException r101) {
        r100.onProcessFailure(r101);
    }

    private static void sendError(final ProcessingRequest r100, final ImageCaptureException r101) {
        CameraXExecutors.mainThreadExecutor().execute(new n(r100, r101));
    }

    public ProcessingNode(Executor r100, Quirks r101) {
        this(r100, null, r101);
    }

    public ProcessingNode(Executor r100, InternalImageProcessor r101, Quirks r102) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(r100);
    L9:
        this.mImageProcessor = r101;
        this.mQuirks = r102;
        this.mHasIncorrectJpegMetadataQuirk = r102.contains(IncorrectJpegMetadataQuirk.class);
        return;
    L8:
        this.mBlockingExecutor = r100;
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
