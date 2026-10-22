package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import jc1.k;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f85173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f85174b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f85173a = -1;
        this.f85174b = ((IPushStreamService) k.n(IPushStreamService.class)).getPushLiveStream();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void a(int r100) {
        int r101 = qo0.a.f534145a;
        qo0.a.c("MiniGameServerMixStream", "setCameraPushFrameRotation " + r100);
        com.bytedance.android.live.pushstream.d r102 = this.f85174b;
        if (r102 == null) goto L6;
        r102.Y0(r100);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void setRadioMode(boolean r100) {
        com.bytedance.android.live.pushstream.d r101 = this.f85174b;
        if (r101 == null) goto L22;
        d0 r102 = r101.getLiveCore();
        if (r102 == null) goto L26;
        int r103 = qo0.a.f534145a;
        qo0.a.c("MiniGameServerMixStream", "setRadioMode " + r100 + ", old video device=" + this.f85173a);
        uv0.a r104 = new uv0.a(LiveRequestSourceRole.Business, "MiniGameServerMixStream.setRadioMode", null);
        if (r100 == true) goto L10;
        int r105 = this.f85173a;
        if (r105 == (-1)) goto L25;
        com.bytedance.android.live.pushstream.d r106 = this.f85174b;
        if (r106 == null) goto L20;
        r106.Z0(r105, r104);
    L20:
        this.f85173a = -1;
        return;
    L25:
        return;
    L10:
        if (this.f85173a != (-1)) goto L12;
        this.f85173a = r102.g();
    L12:
        com.bytedance.android.live.pushstream.d r107 = this.f85174b;
        if (r107 == null) goto L23;
        r107.Z0(5, r104);
        return;
    L23:
        return;
    L26:
        return;
    }
}
