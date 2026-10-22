package com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback;

import com.bytedance.android.ec.model.j;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadVideoController f167573a;

    @Override // com.bytedance.android.ec.model.j
    public final void onClick() {
    }

    @Override // com.bytedance.android.ec.model.j
    public final void onClose(boolean r100) {
    }

    @Override // com.bytedance.android.ec.model.j
    public final void onReturnClick() {
    }

    @Override // com.bytedance.android.ec.model.j
    public final void onShow() {
    }

    public a(HeadVideoController r100) {
        this.f167573a = r100;
    }

    @Override // com.bytedance.android.ec.model.j
    public final void onMuteButtonClick(boolean r100) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (this.f167573a.d() == false) goto L17;
        BasePdpVideoView r101 = this.f167573a.f167567d;
        boolean r102 = false;
        if (r101 == null) goto L8;
        boolean r103 = r101.isMute();
    L9:
        if (r103 == true) goto L18;
        BasePdpVideoView r104 = this.f167573a.f167567d;
        if (r104 == null) goto L14;
        r102 = r104.isMute();
    L14:
        this.f167573a.f(!r102, true);
        return;
    L18:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
