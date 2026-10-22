package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f169520c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
    public final void c(boolean r100) {
        h r101 = this.f169520c;
        r101.f169510d = r100;
        if (r100 == true) goto L9;
        Runnable r102 = r101.f169512f;
        if (r102 == null) goto L7;
        r102.run();
        return;
    L7:
        r101.f169509c.setVisibility(4);
        return;
    }

    public l(h r100, h r101) {
        this.f169520c = r100;
        super(r101, true, false, true, 8);
    }
}
