package com.bytedance.android.livesdk.interactivity;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.comment.data.f f137463a;

    public k(com.bytedance.android.livesdk.interactivity.api.comment.data.f r100) {
        this.f137463a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        StringBuilder r101 = new StringBuilder("load icon failed, icon type is ");
        r101.append(this.f137463a.type);
        r101.append(" uri is ");
        py.k r102 = this.f137463a.icon;
        if (r102 == null) goto L5;
        String r103 = r102.getUri();
    L6:
        r101.append(r103);
        String r104 = r101.toString();
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        ALogger.e("CommentPresent", r104);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L19;
        Bitmap r101 = Bitmap.createBitmap(r100);     // Catch: OutOfMemoryError -> L8
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.isRecycled() == true) goto L20;
        this.f137463a.f133040a = r101;
        return;
    L20:
        return;
    L8:
        r101 = null;
        goto L9
    }
}
