package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes43.dex */
public final class f0 extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataSource f45579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f45580b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (r100 == null) goto L4;
        r100.close();
    L4:
        this.f45580b.accept(null);
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f45579a.isFinished() == false) goto L6;
        if (r100 == null) goto L6;
        Bitmap r101 = Bitmap.createBitmap(r100);
        this.f45580b.accept(r101);
        this.f45579a.close();
        return;
    L6:
        this.f45580b.accept(null);
    }

    public f0(DataSource r100, o r101) {
        this.f45579a = r100;
        this.f45580b = r101;
    }
}
