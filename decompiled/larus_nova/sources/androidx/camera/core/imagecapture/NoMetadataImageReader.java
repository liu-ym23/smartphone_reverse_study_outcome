package androidx.camera.core.imagecapture;

import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class NoMetadataImageReader implements ImageReaderProxy {
    private ProcessingRequest mPendingRequest;
    private final ImageReaderProxy mWrappedImageReader;

    public static /* synthetic */ void a(NoMetadataImageReader r100, ImageReaderProxy.OnImageAvailableListener r101, ImageReaderProxy r102) {
        r100.lambda$setOnImageAvailableListener$0(r101, r102);
    }

    public void clearProcessingRequest() {
        this.mPendingRequest = null;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        return createImageProxyWithEmptyMetadata(this.mWrappedImageReader.acquireLatestImage());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        return createImageProxyWithEmptyMetadata(this.mWrappedImageReader.acquireNextImage());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        this.mWrappedImageReader.clearOnImageAvailableListener();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        this.mWrappedImageReader.close();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        return this.mWrappedImageReader.getHeight();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        return this.mWrappedImageReader.getImageFormat();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        return this.mWrappedImageReader.getMaxImages();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        return this.mWrappedImageReader.getSurface();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        return this.mWrappedImageReader.getWidth();
    }

    public NoMetadataImageReader(ImageReaderProxy r100) {
        this.mWrappedImageReader = r100;
    }

    private ImageProxy createImageProxyWithEmptyMetadata(ImageProxy r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.mPendingRequest != null) goto L8;
        TagBundle r101 = TagBundle.emptyBundle();
    L9:
        this.mPendingRequest = null;
        return new SettableImageProxy(r100, new Size(r100.getWidth(), r100.getHeight()), new CameraCaptureResultImageInfo(new VirtualCameraCaptureResult(r101, r100.getImageInfo().getTimestamp())));
    L8:
        r101 = TagBundle.create(new Pair(this.mPendingRequest.getTagBundleKey(), ListProtector.get(this.mPendingRequest.getStageIds(), 0)));
        goto L9
    }

    public void acceptProcessingRequest(ProcessingRequest r100) {
        if (this.mPendingRequest != null) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkState(r101, "Pending request should be null");
        this.mPendingRequest = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$0(ImageReaderProxy.OnImageAvailableListener r100, ImageReaderProxy r101) {
        r100.onImageAvailable(this);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(final ImageReaderProxy.OnImageAvailableListener r100, Executor r101) {
        this.mWrappedImageReader.setOnImageAvailableListener(new j(this, r100), r101);
    }
}
