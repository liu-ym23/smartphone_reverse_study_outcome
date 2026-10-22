package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements Supplier<DataSource<CloseableReference<CloseableImage>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageRequest f50958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f50959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SlcPipelineDraweeControllerBuilder f50960c;

    @Override // com.facebook.common.internal.Supplier
    public final DataSource<CloseableReference<CloseableImage>> get() {
        SlcPipelineDraweeControllerBuilder r100 = this.f50960c;
        ImageRequest r101 = this.f50958a;
        Object r102 = this.f50959b;
        SlcPipelineDraweeControllerBuilder.CacheLevel r103 = SlcPipelineDraweeControllerBuilder.CacheLevel.FULL_FETCH;
        ImagePipeline r104 = r100.f50925j;
        int r105 = SlcPipelineDraweeControllerBuilder.b.f50928a[r103.ordinal()];
        if (r105 != 1) goto L5;
        ImageRequest.RequestLevel r106 = ImageRequest.RequestLevel.FULL_FETCH;
    L13:
        ImageRequest.RequestLevel r107 = r106;
        Priority r108 = Priority.HIGH;
        if (r101 == null) goto L16;
        Priority r109 = r101.getPriority();
    L18:
        return r104.fetchDecodedImage(r101, r102, r107, null, Priority.getHigherPriority(r108, r109));
    L16:
        r109 = r108;
        goto L18
    L5:
        if (r105 != 2) goto L7;
        r106 = ImageRequest.RequestLevel.DISK_CACHE;
        goto L13
    L7:
        if (r105 != 3) goto L10;
        r106 = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        goto L13
    L10:
        throw new RuntimeException("Cache level" + r103 + "is not supported. ");
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("request", this.f50958a.toString()).toString();
    }

    public i(SlcPipelineDraweeControllerBuilder r100, ImageRequest r101, Object r102) {
        this.f50960c = r100;
        this.f50958a = r101;
        this.f50959b = r102;
    }
}
