package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleImageProxyBundle implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    public void close() {
        this.mImageProxy.close();
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    public List<Integer> getCaptureIds() {
        return Collections.singletonList(Integer.valueOf(this.mCaptureId));
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    public ListenableFuture<ImageProxy> getImageProxy(int r100) {
        if (r100 == this.mCaptureId) goto L7;
        return Futures.immediateFailedFuture(new IllegalArgumentException("Capture id does not exist in the bundle"));
    L7:
        return Futures.immediateFuture(this.mImageProxy);
    }

    public SingleImageProxyBundle(ImageProxy r100, String r101) {
        ImageInfo r102 = r100.getImageInfo();
        if (r102 == null) goto L11;
        Integer r103 = (Integer) r102.getTagBundle().getTag(r101);
        if (r103 == null) goto L9;
        this.mCaptureId = r103.intValue();
        this.mImageProxy = r100;
        return;
    L9:
        throw new IllegalArgumentException("ImageProxy has no associated tag");
    L11:
        throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
    }

    public SingleImageProxyBundle(ImageProxy r100, int r101) {
        this.mCaptureId = r101;
        this.mImageProxy = r100;
    }
}
