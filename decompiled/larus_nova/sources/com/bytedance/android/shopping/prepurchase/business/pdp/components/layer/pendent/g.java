package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends com.bytedance.android.shopping.anchorv4.video.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f181459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MoreVideoComponent f181460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.f f181461k;

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean e() {
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean b() {
        MoreVideoComponent.b r100 = MoreVideoComponent.i2(this.f181460j);
        if (r100 == null) goto L9;
        x73.a r101 = r100.f181428c;
        if (r101 == null) goto L10;
        r101.pausePlay();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean c() {
        MoreVideoComponent.b r100 = MoreVideoComponent.i2(this.f181460j);
        if (r100 == null) goto L9;
        x73.a r101 = r100.f181428c;
        if (r101 == null) goto L10;
        r101.startPlay();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final Object getPlayer() {
        MoreVideoComponent.b r100 = MoreVideoComponent.i2(this.f181460j);
        if (r100 == null) goto L7;
        x73.a r101 = r100.f181428c;
        if (r101 == null) goto L7;
        return r101.getPlayer();
    L7:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean isPlaying() {
        MoreVideoComponent.b r100 = MoreVideoComponent.i2(this.f181460j);
        if (r100 == null) goto L9;
        x73.a r101 = r100.f181428c;
        if (r101 == null) goto L9;
        if (r101.isPlaying() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean m() {
        return this.f181459i;
    }

    public g(MoreVideoComponent r100, com.bytedance.android.shopping.anchorv4.video.f r101, com.bytedance.android.shopping.anchorv4.video.f r110) {
        this.f181460j = r100;
        this.f181461k = r101;
        super("more_video", r110, null, false, false, 60);
        this.f181459i = true;
    }
}
