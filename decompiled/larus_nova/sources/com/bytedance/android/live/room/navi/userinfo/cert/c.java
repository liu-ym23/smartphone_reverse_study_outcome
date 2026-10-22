package com.bytedance.android.live.room.navi.userinfo.cert;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomImageLayoutController f99787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f99788b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        this.f99787a.f99779a = false;
        ALogger.e("room_cert", "render cert UI failed：the image download fail");
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f99787a.f99779a = false;
        if (r100.isRecycled() == false) goto L6;
        return;
    L6:
        if (this.f99787a.c().getParent() == null) goto L9;
        RoomImageLayoutController r101 = this.f99787a;
        r101.f99781c.b(r100, r101.c(), this.f99788b);
        this.f99787a.c().setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
        this.f99787a.f99781c.onShow();
        return;
    }

    public c(RoomImageLayoutController r100, k r101) {
        this.f99787a = r100;
        this.f99788b = r101;
    }
}
