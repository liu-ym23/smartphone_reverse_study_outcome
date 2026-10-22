package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.ObservableEmitter;

/* JADX INFO: loaded from: classes8.dex */
public final class u0 extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f114637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f114638b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (this.f114637a.isDisposed() == true) goto L6;
        this.f114637a.onError(r100.getFailureCause());
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f114637a.isDisposed() == true) goto L12;
        if (r100 != null) goto L7;
        this.f114637a.onError(new IllegalStateException("No bitmap loaded for imageModel: " + this.f114638b.toString()));
        return;
    L7:
        Bitmap.Config r101 = r100.getConfig();
        if (r101 != null) goto L10;
        r101 = Bitmap.Config.ARGB_8888;
    L10:
        this.f114637a.onNext(r100.copy(r101, false));
        this.f114637a.onComplete();
        return;
    }

    public u0(ObservableEmitter r100, py.k r101) {
        this.f114637a = r100;
        this.f114638b = r101;
    }
}
