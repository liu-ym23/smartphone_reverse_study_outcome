package com.bytedance.android.livesdk.chatroom.ui.decoration.legacy;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomDecorationListAdapter.d f112751a;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
    }

    public a(RoomDecorationListAdapter.d r100) {
        this.f112751a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f112751a.f112747a.setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
        RoomDecorationListAdapter.d r101 = this.f112751a;
        r101.itemView.setOnClickListener(r101.f112748b);
    }
}
