package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class y implements kc0.r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a f113535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.c f113536b;

    @Override // kc0.r.a
    public final vc0.a getLiveVideoClientFactory() {
        hh1.v0 r100 = this.f113536b.getLiveVideoClientFactory();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new vc0.a(r100);
    }

    @Override // kc0.r.a
    public final void a(LiveWidget r100) {
        this.f113535a.Uj(r100);
    }

    @Override // kc0.r.a
    public final void b(Widget r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.a(this.f113535a, R.id.multi_anchor_container, r100, false, 8);
    }

    public y(com.bytedance.android.livesdk.chatroom.ui.framework.a r100, com.bytedance.android.livesdk.chatroom.ui.framework.c r101) {
        this.f113535a = r100;
        this.f113536b = r101;
    }
}
