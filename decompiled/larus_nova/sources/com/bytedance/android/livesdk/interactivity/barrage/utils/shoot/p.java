package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q22.a f134006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r22.a.b f134007b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        this.f134007b.a(this.f134006a);
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L15;
        Bitmap r101 = BitmapTranslateUtils.b(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isRecycled() == true) goto L16;
        q22.a r102 = this.f134006a;
        r102.f531394a = r101;
        this.f134007b.a(r102);
        return;
    L16:
        return;
    }

    public p(q22.a r100, r22.a.b r101) {
        this.f134006a = r100;
        this.f134007b = r101;
    }
}
