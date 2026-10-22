package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";
    private final List<ImageProxy> mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;
    private boolean mClosed;
    private Executor mExecutor;
    private int mImageProxiesIndex;
    private final ImageReaderProxy mImageReaderProxy;
    ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock;
    private final List<ImageProxy> mMatchedImageProxies;
    private final LongSparseArray<ImageInfo> mPendingImageInfos;
    private final LongSparseArray<ImageProxy> mPendingImages;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;
    private int mUnAcquiredAvailableImageCount;

    public static /* synthetic */ void a(MetadataImageReader r100, ImageReaderProxy r101) {
        r100.lambda$new$0(r101);
    }

    public static /* synthetic */ void b(MetadataImageReader r100, ImageReaderProxy.OnImageAvailableListener r101) {
        r100.lambda$enqueueImageProxy$1(r101);
    }

    private void matchImages() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mPendingImageInfos.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (r101 < 0) goto L10;
        ImageInfo r102 = this.mPendingImageInfos.valueAt(r101);     // Catch: Throwable -> L13
        long r103 = r102.getTimestamp();     // Catch: Throwable -> L13
        ImageProxy r104 = this.mPendingImages.get(r103);     // Catch: Throwable -> L13
        if (r104 == null) goto L9;
        this.mPendingImages.remove(r103);     // Catch: Throwable -> L13
        this.mPendingImageInfos.removeAt(r101);     // Catch: Throwable -> L13
        enqueueImageProxy(new SettableImageProxy(r104, r102));     // Catch: Throwable -> L13
    L9:
        r101 = r101 - 1;     // Catch: Throwable -> L13
        goto L5
    L10:
        removeStaleData();     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void removeStaleData() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingImages.size() != 0) goto L7;
    L28:
        monitor-exit(r100);     // Catch: Throwable -> L30
        return;
    L7:
        if (this.mPendingImageInfos.size() == 0) goto L28;
        boolean r101 = false;
        Long r102 = Long.valueOf(this.mPendingImages.keyAt(0));     // Catch: Throwable -> L30
        Long r103 = Long.valueOf(this.mPendingImageInfos.keyAt(0));     // Catch: Throwable -> L30
        if (r103.equals(r102) == true) goto L12;
        r101 = true;
    L12:
        Preconditions.checkArgument(r101);     // Catch: Throwable -> L30
        if (r103.longValue() <= r102.longValue()) goto L20;
        int r104 = this.mPendingImages.size() - 1;     // Catch: Throwable -> L30
    L15:
        if (r104 < 0) goto L26;
        if (this.mPendingImages.keyAt(r104) >= r103.longValue()) goto L19;
        this.mPendingImages.valueAt(r104).close();     // Catch: Throwable -> L30
        this.mPendingImages.removeAt(r104);     // Catch: Throwable -> L30
    L19:
        r104 = r104 - 1;     // Catch: Throwable -> L30
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L30
        return;
    L20:
        int r105 = this.mPendingImageInfos.size() - 1;     // Catch: Throwable -> L30
    L21:
        if (r105 < 0) goto L26;
        if (this.mPendingImageInfos.keyAt(r105) >= r102.longValue()) goto L25;
        this.mPendingImageInfos.removeAt(r105);     // Catch: Throwable -> L30
    L25:
        r105 = r105 - 1;     // Catch: Throwable -> L30
        goto L21
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.mMatchedImageProxies.isEmpty() == false) goto L10;
        monitor-exit(r100);     // Catch: Throwable -> L27
        return null;
    L10:
        if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) goto L26;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L27
        int r102 = 0;
    L13:
        if (r102 >= (this.mMatchedImageProxies.size() - 1)) goto L18;
        if (this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(r102)) == true) goto L17;
        r101.add(this.mMatchedImageProxies.get(r102));     // Catch: Throwable -> L27
    L17:
        r102 = r102 + 1;     // Catch: Throwable -> L27
        goto L13
    L18:
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L27
    L20:
        if (r103.hasNext() == false) goto L22;
        ((ImageProxy) r103.next()).close();     // Catch: Throwable -> L27
        goto L20
    L22:
        int r104 = this.mMatchedImageProxies.size() - 1;     // Catch: Throwable -> L27
        List<ImageProxy> r105 = this.mMatchedImageProxies;     // Catch: Throwable -> L27
        this.mImageProxiesIndex = r104 + 1;     // Catch: Throwable -> L27
        ImageProxy r106 = r105.get(r104);     // Catch: Throwable -> L27
        this.mAcquiredImageProxies.add(r106);     // Catch: Throwable -> L27
        monitor-exit(r100);     // Catch: Throwable -> L27
        return r106;
    L26:
        throw new IllegalStateException("Maximum image number reached.");     // Catch: Throwable -> L27
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mMatchedImageProxies.isEmpty() == false) goto L10;
        monitor-exit(r100);     // Catch: Throwable -> L16
        return null;
    L10:
        if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) goto L15;
        List<ImageProxy> r101 = this.mMatchedImageProxies;     // Catch: Throwable -> L16
        int r102 = this.mImageProxiesIndex;     // Catch: Throwable -> L16
        this.mImageProxiesIndex = r102 + 1;     // Catch: Throwable -> L16
        ImageProxy r103 = r101.get(r102);     // Catch: Throwable -> L16
        this.mAcquiredImageProxies.add(r103);     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return r103;
    L15:
        throw new IllegalStateException("Maximum image number reached.");     // Catch: Throwable -> L16
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mImageReaderProxy.clearOnImageAvailableListener();     // Catch: Throwable -> L7
        this.mListener = null;     // Catch: Throwable -> L7
        this.mExecutor = null;     // Catch: Throwable -> L7
        this.mUnAcquiredAvailableImageCount = 0;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L8:
        Iterator r101 = new ArrayList(this.mMatchedImageProxies).iterator();     // Catch: Throwable -> L15
    L10:
        if (r101.hasNext() == false) goto L12;
        ((ImageProxy) r101.next()).close();     // Catch: Throwable -> L15
        goto L10
    L12:
        this.mMatchedImageProxies.clear();     // Catch: Throwable -> L15
        this.mImageReaderProxy.close();     // Catch: Throwable -> L15
        this.mClosed = true;     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReaderProxy.getHeight();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReaderProxy.getImageFormat();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReaderProxy.getMaxImages();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Surface r101 = this.mImageReaderProxy.getSurface();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReaderProxy.getWidth();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
    }

    public MetadataImageReader(ImageReaderProxy r100) {
        this.mLock = new Object();
        this.mCameraCaptureCallback = new AnonymousClass1(this);
        this.mUnAcquiredAvailableImageCount = 0;
        this.mTransformedListener = new y(this);
        this.mClosed = false;
        this.mPendingImageInfos = new LongSparseArray();
        this.mPendingImages = new LongSparseArray();
        this.mAcquiredImageProxies = new ArrayList();
        this.mImageReaderProxy = r100;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }

    private void dequeImageProxy(ImageProxy r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        int r102 = this.mMatchedImageProxies.indexOf(r100);     // Catch: Throwable -> L14
        if (r102 < 0) goto L9;
        this.mMatchedImageProxies.remove(r102);     // Catch: Throwable -> L14
        int r103 = this.mImageProxiesIndex;     // Catch: Throwable -> L14
        if (r102 > r103) goto L9;
        this.mImageProxiesIndex = r103 - 1;     // Catch: Throwable -> L14
    L9:
        this.mAcquiredImageProxies.remove(r100);     // Catch: Throwable -> L14
        if (this.mUnAcquiredAvailableImageCount <= 0) goto L12;
        imageIncoming(this.mImageReaderProxy);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void enqueueImageProxy(SettableImageProxy r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mMatchedImageProxies.size() >= getMaxImages()) goto L7;
        r100.addOnImageCloseListener(this);     // Catch: Throwable -> L14
        this.mMatchedImageProxies.add(r100);     // Catch: Throwable -> L14
        final ImageReaderProxy.OnImageAvailableListener r102 = this.mListener;     // Catch: Throwable -> L14
        Executor r103 = this.mExecutor;     // Catch: Throwable -> L14
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L14
        if (r102 == null) goto L19;
        if (r103 == null) goto L12;
        r103.execute(new x(this, r102));
        return;
    L12:
        r102.onImageAvailable(this);
        return;
    L19:
        return;
    L7:
        Logger.d("TAG", "Maximum image number reached.");     // Catch: Throwable -> L14
        r100.close();     // Catch: Throwable -> L14
        r102 = null;
        r103 = null;
        goto L8
    }

    private /* synthetic */ void lambda$enqueueImageProxy$1(ImageReaderProxy.OnImageAvailableListener r100) {
        r100.onImageAvailable(this);
    }

    private /* synthetic */ void lambda$new$0(ImageReaderProxy r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mUnAcquiredAvailableImageCount++;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        imageIncoming(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void imageIncoming(ImageReaderProxy r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mClosed     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
            return
        L9:
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r1 = r6.mPendingImages     // Catch: java.lang.Throwable -> L5e
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L5e
            java.util.List<androidx.camera.core.ImageProxy> r2 = r6.mMatchedImageProxies     // Catch: java.lang.Throwable -> L5e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L5e
            int r1 = r1 + r2
            int r2 = r7.getMaxImages()     // Catch: java.lang.Throwable -> L5e
            if (r1 < r2) goto L25
            java.lang.String r7 = "MetadataImageReader"
            java.lang.String r1 = "Skip to acquire the next image because the acquired image count has reached the max images count."
            androidx.camera.core.Logger.d(r7, r1)     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
            return
        L25:
            androidx.camera.core.ImageProxy r2 = r7.acquireNextImage()     // Catch: java.lang.Throwable -> L44 java.lang.IllegalStateException -> L46
            if (r2 == 0) goto L4f
            int r3 = r6.mUnAcquiredAvailableImageCount     // Catch: java.lang.Throwable -> L5e
            int r3 = r3 + (-1)
            r6.mUnAcquiredAvailableImageCount = r3     // Catch: java.lang.Throwable -> L5e
            int r1 = r1 + 1
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r3 = r6.mPendingImages     // Catch: java.lang.Throwable -> L5e
            androidx.camera.core.ImageInfo r4 = r2.getImageInfo()     // Catch: java.lang.Throwable -> L5e
            long r4 = r4.getTimestamp()     // Catch: java.lang.Throwable -> L5e
            r3.put(r4, r2)     // Catch: java.lang.Throwable -> L5e
            r6.matchImages()     // Catch: java.lang.Throwable -> L5e
            goto L4f
        L44:
            r7 = move-exception
            goto L5d
        L46:
            r2 = move-exception
            java.lang.String r3 = "MetadataImageReader"
            java.lang.String r4 = "Failed to acquire next image."
            androidx.camera.core.Logger.d(r3, r4, r2)     // Catch: java.lang.Throwable -> L44
            r2 = 0
        L4f:
            if (r2 == 0) goto L5b
            int r2 = r6.mUnAcquiredAvailableImageCount     // Catch: java.lang.Throwable -> L5e
            if (r2 <= 0) goto L5b
            int r2 = r7.getMaxImages()     // Catch: java.lang.Throwable -> L5e
            if (r1 < r2) goto L25
        L5b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
            return
        L5d:
            throw r7     // Catch: java.lang.Throwable -> L5e
        L5e:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.MetadataImageReader.imageIncoming(androidx.camera.core.impl.ImageReaderProxy):void");
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        dequeImageProxy(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void resultIncoming(CameraCaptureResult r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.mPendingImageInfos.put(r100.getTimestamp(), new CameraCaptureResultImageInfo(r100));     // Catch: Throwable -> L11
        matchImages();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener r100, Executor r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(r100);     // Catch: Throwable -> L7
        this.mExecutor = (Executor) Preconditions.checkNotNull(r101);     // Catch: Throwable -> L7
        this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public MetadataImageReader(int r100, int r101, int r102, int r103) {
        this(createImageReaderProxy(r100, r101, r102, r103));
    }

    private static ImageReaderProxy createImageReaderProxy(int r100, int r101, int r102, int r103) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(r100, r101, r102, r103));
    }
}
