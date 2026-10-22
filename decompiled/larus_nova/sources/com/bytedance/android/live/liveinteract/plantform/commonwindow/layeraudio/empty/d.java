package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends jg0.a<MultiLinkNormalEmptyViewBinder.a> {
    @Override // jg0.c
    public final int o() {
        return R.layout.ttlive_layer_multilink_audio_hamlet_avatar_empty_stub_large;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioHamletEmptyLargeLayer.name();
    }

    public d(MicSeatScene r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        super(r100, r101);
    }

    @Override // jg0.f
    public final void d(Object r100, int r101) {
        Intrinsics.checkNotNullParameter((MultiLinkNormalEmptyViewBinder.a) r100, "itemData");
    }

    @Override // jg0.f
    public final void k(Object r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter((MultiLinkNormalEmptyViewBinder.a) r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
    }
}
