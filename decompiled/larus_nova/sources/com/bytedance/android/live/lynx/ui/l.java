package com.bytedance.android.live.lynx.ui;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLottieView.a f82743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f82744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataSource f82745c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        this.f82743a.onFailed();
        if (r100 == null) goto L5;
        r100.close();
    L5:
        this.f82744b.countDown();
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f82745c.isFinished() == false) goto L8;
        if (r100 == null) goto L8;
        this.f82743a.onSuccess(r100);
        DataSource r101 = this.f82745c;
        if (r101 == null) goto L8;
        r101.close();
    L8:
        this.f82744b.countDown();
    }

    public l(LynxLottieView.c r100, CountDownLatch r101, DataSource r102) {
        this.f82743a = r100;
        this.f82744b = r101;
        this.f82745c = r102;
    }
}
