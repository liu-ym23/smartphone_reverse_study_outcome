package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.y1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class w extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f116025f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r100 = ToolbarButton.VS_SELECT_EPISODE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r100.setPureText(true), r100, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarVSAnthology.INSTANCE;
    }

    public w(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        super(null, null, 7);
        this.f116025f = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        IRoom r103 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f116025f);
        boolean r104 = false;
        if (((Boolean) this.f116025f.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L20;
        IEpisodeExtraInfo r105 = r103.getEpisodeExtra();
        if (r105 == null) goto L20;
        String r106 = r105.getCurrentPeriod();
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L14:
        if (r107 == true) goto L20;
        if (r103.getRoomAuthStatus().isDisableSelectionAlbum() == true) goto L20;
        if (r103.isMergeVSRoom() == false) goto L20;
        r104 = true;
        goto L20
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
    L20:
        if (r104 == true) goto L24;
        return null;
    L24:
        return new y1();
    }
}
