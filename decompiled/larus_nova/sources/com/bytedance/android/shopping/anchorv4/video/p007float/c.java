package com.bytedance.android.shopping.anchorv4.video.p007float;

import com.bytedance.android.shopping.anchorv4.video.d;
import com.bytedance.android.shopping.anchorv4.video.f;
import gj.b;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ a f167602i;

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean e() {
        return this.f167602i.f167591g.f167596b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final Object getPlayer() {
        b r100 = this.f167602i.f167591g.e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayer();
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean isPlaying() {
        return this.f167602i.c();
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean b() {
        if (isPlaying() == false) goto L7;
        this.f167602i.pause();
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean c() {
        if (isPlaying() == true) goto L7;
        this.f167602i.d();
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean g(boolean r100) {
        a.b r101 = this.f167602i.f167591g;
        if (r101.f167596b == r100) goto L7;
        r101.c(false);
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final Boolean j(Boolean r100, boolean r101) {
        a r102 = this.f167602i;
        if (r102.f167594j.f167620d.f167653c != null) goto L5;
        return null;
    L5:
        if (this.f167578b == false) goto L8;
        return null;
    L8:
        return Boolean.valueOf(r102.f167591g.f167596b);
    }

    public c(a r100, f r101, Boolean r110) {
        this.f167602i = r100;
        super("float_video", r101, r110, true, false, 40);
    }
}
