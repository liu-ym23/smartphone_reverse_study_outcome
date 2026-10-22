package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class y implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f134026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d f134027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r22.a.b f134028c;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        x r101 = this.f134026a;
        r101.f134024e = true;
        if (r101.f134023d == false) goto L6;
        this.f134028c.a(this.f134027b);
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
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r102 = this.f134027b;
        if ((r102 instanceof q72.f) == true) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r103 = null;
    L15:
        q72.f r104 = (q72.f) r103;
        if (r104 == null) goto L18;
        r104.f531952b = r101;
    L18:
        x r105 = this.f134026a;
        r105.f134024e = true;
        if (r105.f134023d == false) goto L24;
        this.f134028c.a(r102);
        return;
    L24:
        return;
    L14:
        r103 = r102;
        goto L15
    L26:
        return;
    }

    public y(x r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r101, r22.a.b r102) {
        this.f134026a = r100;
        this.f134027b = r101;
        this.f134028c = r102;
    }
}
