package com.bytedance.android.livesdk.chatroom.ui.decoration.legacy;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomDecorationListAdapter.e f112752a;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
    }

    public b(RoomDecorationListAdapter.e r100) {
        this.f112752a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f112752a.f112749a.setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
        RoomDecorationListAdapter.e r101 = this.f112752a;
        r101.itemView.setOnClickListener(r101.f112750b);
        this.f112752a.itemView.setTag(R.id.ttlive_decoration_view_height, Integer.valueOf(r100.getHeight()));
    }
}
