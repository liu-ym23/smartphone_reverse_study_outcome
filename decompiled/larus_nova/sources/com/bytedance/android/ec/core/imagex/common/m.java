package com.bytedance.android.ec.core.imagex.common;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes43.dex */
public interface m extends Supplier<DataSource<CloseableReference<CloseableImage>>> {
    ImageRequest getImageRequest();
}
