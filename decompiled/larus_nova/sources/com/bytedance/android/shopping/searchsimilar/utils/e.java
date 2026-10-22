package com.bytedance.android.shopping.searchsimilar.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.y;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements y.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f182497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f182498b;

    @Override // com.bytedance.android.ec.core.utils.y.b
    public final void onFailure() {
        boolean r100 = f.f182499a;
        f.a(this.f182498b, this.f182497a);
    }

    @Override // com.bytedance.android.ec.core.utils.y.b
    public final void onSuccess(DataSource<CloseableReference<CloseableImage>> r100) {
        boolean r101 = f.f182499a;
        f.a(this.f182498b, this.f182497a);
    }

    public e(boolean r100, Context r101) {
        this.f182497a = r100;
        this.f182498b = r101;
    }
}
