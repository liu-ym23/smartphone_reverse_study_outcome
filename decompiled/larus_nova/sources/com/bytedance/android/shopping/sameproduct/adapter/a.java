package com.bytedance.android.shopping.sameproduct.adapter;

import com.bytedance.android.ec.core.utils.y;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements y.b {
    public a() {
    }

    @Override // com.bytedance.android.ec.core.utils.y.b
    public final void onFailure() {
    }

    @Override // com.bytedance.android.ec.core.utils.y.b
    public final void onSuccess(DataSource<CloseableReference<CloseableImage>> r100) {
        if (r100 == null) goto L5;
        r100.close();
        return;
    }
}
