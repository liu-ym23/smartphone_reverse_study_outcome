package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q72.e f134016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r22.a.b f134017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d f134018c;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        q72.e r101 = this.f134016a;
        if (r101 == null) goto L5;
        r101.f531947b = true;
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.f531949d != true) goto L11;
        this.f134017b.a(this.f134018c);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L26;
        Bitmap r101 = BitmapTranslateUtils.b(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isRecycled() == true) goto L27;
        q72.e r102 = this.f134016a;
        if (r102 == null) goto L15;
        r102.f531946a = r101;
    L15:
        if (r102 == null) goto L17;
        r102.f531947b = true;
    L17:
        if (r102 != null) goto L19;
        return;
    L19:
        if (r102.f531949d != true) goto L25;
        this.f134017b.a(this.f134018c);
        return;
    L25:
        return;
    L27:
        return;
    }

    public v(q72.e r100, r22.a.b r101, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r102) {
        this.f134016a = r100;
        this.f134017b = r101;
        this.f134018c = r102;
    }
}
