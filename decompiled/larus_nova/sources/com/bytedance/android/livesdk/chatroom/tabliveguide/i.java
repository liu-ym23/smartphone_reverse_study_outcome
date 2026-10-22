package com.bytedance.android.livesdk.chatroom.tabliveguide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends hf6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveInnerCardSkyLightVH f111679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f111680b;

    @Override // hf6.i
    public final void onCompleted(Bitmap r100) {
        if (r100 != null) goto L5;
        this.f111679a.f111641c.setImageResource(R.drawable.ttlive_history_tag_image);
        return;
    L5:
        BitmapDrawable r101 = new BitmapDrawable(this.f111680b.getResources(), r100);
        int r102 = (int) UIUtils.dip2Px(this.f111680b, 16.0f);
        r101.setBounds(0, 0, (int) ((r100.getWidth() / r100.getHeight()) * r102), r102);
        this.f111679a.f111641c.setImageDrawable(r101);
    }

    @Override // hf6.i
    public final void onFailed(Throwable r100) {
        this.f111679a.f111641c.setImageResource(R.drawable.ttlive_history_tag_image);
    }

    public i(LiveInnerCardSkyLightVH r100, Context r101) {
        this.f111679a = r100;
        this.f111680b = r101;
    }
}
