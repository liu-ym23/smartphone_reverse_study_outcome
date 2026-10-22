package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/l2;", "getVideoEqualRoomLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/l2;", "getVideoEqualRoomLiveCoreInfo$annotations", "()V", "videoEqualRoomLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/m2;", "getVideoPositionLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/m2;", "getVideoPositionLiveCoreInfo$annotations", "videoPositionLiveCoreInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "getKtvLiveCoreInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "setKtvLiveCoreInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;)V", "getKtvLiveCoreInfo$annotations", "ktvLiveCoreInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u1 extends vh7.c<u1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ktv_live_core_info")
    com.bytedance.android.livesdk.chatroom.model.interact.i0 getKtvLiveCoreInfo();

    /* synthetic */ p1 getMultiAnchorLiveCoreInfo();

    /* synthetic */ i2 getSingingChallengeLiveCoreInfo();

    @FieldName(name = "video_equal_room_live_core_info")
    l2 getVideoEqualRoomLiveCoreInfo();

    @FieldName(name = "video_position_live_core_info")
    m2 getVideoPositionLiveCoreInfo();

    @FieldName(name = "ktv_live_core_info#setter")
    void setKtvLiveCoreInfo(com.bytedance.android.livesdk.chatroom.model.interact.i0 r100);
}
