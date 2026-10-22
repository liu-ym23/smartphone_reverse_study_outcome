package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoCoverLayout f169796a;

    @Override // com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c
    public final void onLoadSuccess() {
        dm.a.a("VideoCoverLayout").i("initVideoCtrlContainerComponent onLoadSuccess");
        VideoCoverLayout r100 = this.f169796a;
        r100.f169731a = true;
        VideoCoverLayout.b(r100);
    }

    public g(VideoCoverLayout r100) {
        this.f169796a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c
    public final void a(String r100) {
        dm.a.a("VideoCoverLayout").b("initVideoCtrlContainerComponent onLoadFailed errMsg=" + r100, null);
        VideoCoverLayout r101 = this.f169796a;
        r101.f169731a = false;
        VideoCoverLayout.a(r101);
    }
}
