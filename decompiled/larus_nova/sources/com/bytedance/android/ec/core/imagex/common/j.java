package com.bytedance.android.ec.core.imagex.common;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes43.dex */
public interface j extends i, k {
    Supplier<DataSource<CloseableReference<CloseableImage>>> c(ImageRequest[] r100, ImageRequest r101);

    RequestListener d();

    String e();

    boolean f();

    ImageRequest getImageRequest();
}
