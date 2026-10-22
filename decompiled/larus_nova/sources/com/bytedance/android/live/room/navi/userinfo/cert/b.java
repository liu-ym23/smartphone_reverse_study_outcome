package com.bytedance.android.live.room.navi.userinfo.cert;

import android.graphics.Bitmap;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f99785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f99786b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        this.f99785a.f99782a = false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f99785a.f99782a = false;
        if (r100.isRecycled() == false) goto L5;
        return;
    L5:
        ImageView r101 = this.f99786b;
        if (r101 == null) goto L8;
        ViewParent r102 = r101.getParent();
    L9:
        if (r102 == null) goto L12;
        this.f99786b.setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
        this.f99785a.f99784c.onShow();
        return;
    L12:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public b(a r100, ImageView r101) {
        this.f99785a = r100;
        this.f99786b = r101;
    }
}
