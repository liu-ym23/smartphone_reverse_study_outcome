package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipImageView f136504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DisplayImageListView.b f136505b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        DisplayImageListView.b r101 = this.f136505b;
        int r102 = r101.f136469a + 1;
        r101.f136469a = r102;
        if (r102 != r101.f136470b) goto L6;
        r101.f136471c.invoke();
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L22;
        Bitmap r101 = Bitmap.createBitmap(r100);     // Catch: OutOfMemoryError -> L8
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.isRecycled() == true) goto L23;
        this.f136504a.setImageBitmap(r101);
        DisplayImageListView.b r102 = this.f136505b;
        int r103 = r102.f136469a + 1;
        r102.f136469a = r103;
        if (r103 != r102.f136470b) goto L21;
        r102.f136471c.invoke();
        return;
    L21:
        return;
    L23:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public g(ClipImageView r100, DisplayImageListView.b r101) {
        this.f136504a = r100;
        this.f136505b = r101;
    }
}
