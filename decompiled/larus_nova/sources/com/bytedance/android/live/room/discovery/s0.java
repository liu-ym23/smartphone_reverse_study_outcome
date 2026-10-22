package com.bytedance.android.live.room.discovery;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class s0 implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f99587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TopLeftActivityBannerWidget f99588b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L17;
        return;
    L17:
        Bitmap r101 = Bitmap.createBitmap(r100);     // Catch: OutOfMemoryError -> L6
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isRecycled() == false) goto L11;
        return;
    L11:
        if (r101.getWidth() != 0) goto L13;
        return;
    L13:
        if (r101.getHeight() == 0) goto L22;
        int r102 = TopLeftActivityBannerWidget.f99357f;
        int r103 = s1.f(22.0f);
        int r104 = (r101.getWidth() * r103) / r101.getHeight();
        this.f99587a.getLayoutParams().width = r104;
        this.f99587a.getLayoutParams().height = r103;
        String.valueOf(r104);
        this.f99587a.setImageBitmap(r101);
        this.f99588b.getClass();
        Unit r105 = Unit.INSTANCE;
        return;
    L22:
        return;
    L6:
        r101 = null;
        goto L7
    }

    public s0(ImageView r100, TopLeftActivityBannerWidget r101) {
        this.f99587a = r100;
        this.f99588b = r101;
    }
}
