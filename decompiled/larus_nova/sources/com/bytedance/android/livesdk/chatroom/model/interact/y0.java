package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R$\u0010\u000f\u001a\u0004\u0018\u00010\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/y0;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "", "getScene", "()I", "getScene$annotations", "()V", "scene", "Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "getKtvLiveCoreInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "setKtvLiveCoreInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;)V", "getKtvLiveCoreInfo$annotations", "ktvLiveCoreInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/g2;", "getVideoDuoBattleLiveCoreInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/g2;", "getVideoDuoBattleLiveCoreInfo$annotations", "videoDuoBattleLiveCoreInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y0 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.u1>, com.bytedance.android.livesdk.link.model.bridge.u1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.u1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "ktv_live_core_info")
    i0 getKtvLiveCoreInfo();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.p1 getMultiAnchorLiveCoreInfo();

    @FieldName(name = "scene")
    int getScene();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.i2 getSingingChallengeLiveCoreInfo();

    @FieldName(name = "video_duo_battle_live_core_info")
    g2 getVideoDuoBattleLiveCoreInfo();

    @FieldName(name = "video_equal_room_live_core_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.l2 getVideoEqualRoomLiveCoreInfo();

    @FieldName(name = "video_position_live_core_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.m2 getVideoPositionLiveCoreInfo();

    @FieldName(name = "ktv_live_core_info#setter")
    void setKtvLiveCoreInfo(i0 r100);
}
