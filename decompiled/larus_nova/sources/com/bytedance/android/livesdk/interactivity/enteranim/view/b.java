package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements ImageUtil.LoadImageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseEnterView f136873a;

    @Override // com.bytedance.android.live.core.utils.ImageUtil.LoadImageCallback
    public final void onFailed(Exception r100) {
    }

    public b(BaseEnterView r100) {
        this.f136873a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.ImageUtil.LoadImageCallback
    public final void onSuccess(Bitmap r100) {
        if (r100 == null) goto L10;
        HSImageView r101 = this.f136873a.f136805a;
        if (r101 == null) goto L6;
        r101.setImageBitmap(r100);
    L6:
        this.f136873a.invalidate();
        BaseEnterView r102 = this.f136873a;
        e r103 = r102.f136811g;
        if (r103 == null) goto L11;
        ((UserEnterLevelView) r103).e(r102);
        return;
    L11:
        return;
    }
}
