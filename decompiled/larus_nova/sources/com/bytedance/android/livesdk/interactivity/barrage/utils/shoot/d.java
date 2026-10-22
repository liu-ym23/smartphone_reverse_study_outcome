package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q72.b f133973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r22.a.b f133974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d f133975c;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        q72.b r101 = this.f133973a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f531925c != true) goto L9;
        this.f133974b.a(this.f133975c);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L23;
        Bitmap r101 = BitmapTranslateUtils.b(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isRecycled() == true) goto L24;
        q72.b r102 = this.f133973a;
        if (r102 == null) goto L14;
        r102.f531923a = r101;
    L14:
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.f531925c != true) goto L22;
        this.f133974b.a(this.f133975c);
        return;
    L22:
        return;
    L24:
        return;
    }

    public d(q72.b r100, r22.a.b r101, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r102) {
        this.f133973a = r100;
        this.f133974b = r101;
        this.f133975c = r102;
    }
}
