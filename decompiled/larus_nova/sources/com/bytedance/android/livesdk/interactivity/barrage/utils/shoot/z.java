package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f134029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d f134030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r22.a.b f134031c;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        x r101 = this.f134029a;
        r101.f134023d = true;
        if (r101.f134024e == false) goto L6;
        this.f134031c.a(this.f134030b);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L25;
        Bitmap r101 = BitmapTranslateUtils.b(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isRecycled() == true) goto L26;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r102 = this.f134030b;
        if ((r102 instanceof q72.f) == true) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r103 = null;
    L15:
        q72.f r104 = (q72.f) r103;
        if (r104 == null) goto L18;
        r104.f531951a = r101;
    L18:
        x r105 = this.f134029a;
        r105.f134023d = true;
        if (r105.f134024e == false) goto L24;
        this.f134031c.a(r102);
        return;
    L24:
        return;
    L14:
        r103 = r102;
        goto L15
    L26:
        return;
    }

    public z(x r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r101, r22.a.b r102) {
        this.f134029a = r100;
        this.f134030b = r101;
        this.f134031c = r102;
    }
}
