package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdk.chatroom.model.interact.CrossRoomLinkmicRtcInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo;
import com.bytedance.android.livesdk.link.model.g9;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/CrossRoomLinkmicRtcInfo;", "getCrossRoomLinkmicRtcInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v1 extends vh7.c<v1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    CrossRoomLinkmicRtcInfo getCrossRoomLinkmicRtcInfo();

    /* JADX INFO: renamed from: getCrossRoomLinkmicRtcInfo */
    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.interact.s mo8233getCrossRoomLinkmicRtcInfo();

    /* synthetic */ GameBarrageRtcInfo getGameBarrageRtcInfo();

    /* synthetic */ o1 getMultiAnchorLinkMicRtcInfo();

    /* synthetic */ g9 getSingingChallengeRtcInfo();

    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.interact.i2 getVideoEqualRoomRtcInfo();

    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.interact.j2 getVideoPositionRtcInfo();
}
