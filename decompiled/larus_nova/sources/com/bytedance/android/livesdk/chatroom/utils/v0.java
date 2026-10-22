package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.ObservableEmitter;

/* JADX INFO: loaded from: classes8.dex */
public final class v0 extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f114649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f114650b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (this.f114649a.isDisposed() == true) goto L6;
        this.f114649a.onError(r100.getFailureCause());
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f114649a.isDisposed() == true) goto L9;
        if (r100 != null) goto L7;
        this.f114649a.onError(new IllegalStateException("No bitmap loaded for imageModel: " + this.f114650b.toString()));
        return;
    L7:
        this.f114649a.onNext(r100);
        this.f114649a.onComplete();
        return;
    }

    public v0(ObservableEmitter r100, py.k r101) {
        this.f114649a = r100;
        this.f114650b = r101;
    }
}
