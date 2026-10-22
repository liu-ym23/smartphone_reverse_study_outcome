package com.bytedance.android.ec.core.imagex.opt;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* JADX INFO: loaded from: classes43.dex */
public final class q0 extends ImageRequest {
    @Override // com.facebook.imagepipeline.request.ImageRequest
    public final Uri getSourceUri() {
        return null;
    }

    public q0() {
        super(ImageRequestBuilder.newBuilderWithSource(Uri.EMPTY));
    }
}
