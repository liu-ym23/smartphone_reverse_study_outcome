package com.bytedance.android.livesdk.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f159301a;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
    }

    public l(ImageView r100) {
        this.f159301a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 == null) goto L7;
        Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, true);
        if (r101 == null) goto L8;
        BitmapDrawable r102 = new BitmapDrawable(this.f159301a.getResources(), r101);
        this.f159301a.setImageDrawable(r102);
        return;
    L8:
        return;
    }
}
