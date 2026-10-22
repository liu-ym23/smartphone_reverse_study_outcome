package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes10.dex */
public final class m extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f145144a;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
    }

    public m(c r100) {
        this.f145144a = r100;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!r100.isRecycled()) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L13;
        Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, false);
        if (r101 == null) goto L14;
        this.f145144a.d(r101);
        return;
    L14:
        return;
    }
}
