package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements PublicScreenConfigSliderView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorPublicScreenConfigDialog f140237a;

    public b(AnchorPublicScreenConfigDialog r100) {
        this.f140237a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void a(int r100) {
        this.f140237a.f140168v = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void b(float r100) {
        AnchorPublicScreenConfigDialog r101 = this.f140237a;
        r101.U90((int) (r101.f140169w + (r101.f140171y * r100)));
    }
}
