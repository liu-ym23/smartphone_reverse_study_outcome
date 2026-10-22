package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends com.bytedance.android.shopping.anchorv4.video.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ a f181534i;

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean e() {
        return this.f181534i.f181513g.f181529b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final Object getPlayer() {
        gj.b r100 = this.f181534i.f181513g.e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayer();
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean isPlaying() {
        return this.f181534i.c();
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean b() {
        if (isPlaying() == false) goto L7;
        this.f181534i.pause();
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean c() {
        if (isPlaying() == true) goto L7;
        this.f181534i.d();
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean g(boolean r100) {
        c r101 = this.f181534i.f181513g;
        if (r101.f181529b == r100) goto L7;
        r101.c(false);
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final Boolean j(Boolean r100, boolean r101) {
        a r102 = this.f181534i;
        if (r102.f181516j.f181554c.f181580c != null) goto L5;
        return null;
    L5:
        if (this.f167578b == false) goto L8;
        return null;
    L8:
        return Boolean.valueOf(r102.f181513g.f181529b);
    }

    public e(a r100, com.bytedance.android.shopping.anchorv4.video.f r101, Boolean r110) {
        this.f181534i = r100;
        super("float_video", r101, r110, true, false, 40);
    }
}
