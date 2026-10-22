package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkScreenCastType f80206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.linkcast.c f80207g;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        com.bytedance.android.live.liveinteract.linkcast.c r100 = this.f80207g;
        if (r100 == null) goto L6;
        String r101 = r100.f74322c;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        int r101 = qy.a.f535172a;
        com.bytedance.android.live.liveinteract.linkcast.c r102 = this.f80207g;
        if (r102 == null) goto L5;
        String r103 = r102.f74321b;
    L6:
        ImageUtil.loadRoundImage(r100, qy.a.b("", CollectionsKt.listOf(String.valueOf(r103))));
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = com.bytedance.android.live.liveinteract.linkcast.i.f74332a;
        LinkScreenCastType r102 = this.f80206f;
        com.bytedance.android.live.liveinteract.linkcast.c r103 = this.f80207g;
        String r104 = "";
        if (r103 == null) goto L6;
        String r105 = r103.f74320a;
        if (r105 == null) goto L6;
    L7:
        com.bytedance.android.live.liveinteract.linkcast.i.a.b(r102, r105);
        q0 r106 = this.f80221e;
        LinkScreenCastType r107 = this.f80206f;
        com.bytedance.android.live.liveinteract.linkcast.c r108 = this.f80207g;
        if (r108 == null) goto L11;
        String r109 = r108.f74320a;
        if (r109 == null) goto L11;
    L12:
        if (r108 == null) goto L17;
        String r110 = r108.f74322c;
        if (r110 == null) goto L17;
        r104 = r110;
    L17:
        r106.H0(r107, r109, r104);
        return;
    L11:
        r109 = "";
    L6:
        r105 = "";
        goto L7
    }

    public e(LinkScreenCastType r100, com.bytedance.android.live.liveinteract.linkcast.c r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r100, "linkCastType");
        Intrinsics.checkNotNullParameter(r102, "action");
        super(r102);
        this.f80206f = r100;
        this.f80207g = r101;
    }
}
