package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001f\u001a\u00060\u001aj\u0002`\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b \u0010\u0017R\u001a\u0010%\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0007\u001a\u0004\b#\u0010\u0017R\u001a\u0010(\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0007\u001a\u0004\b&\u0010\u0017R\u001a\u0010+\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0007\u001a\u0004\b)\u0010\u0017¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/l2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/y;", "", "getFromUserId", "()J", "getFromUserId$annotations", "()V", "fromUserId", "getFromRoomId", "getFromRoomId$annotations", "fromRoomId", "getToUserId", "getToUserId$annotations", "toUserId", "getToRoomId", "getToRoomId$annotations", "toRoomId", "getWaitSec", "getWaitSec$annotations", "waitSec", "", "getBattleAttachedInfo", "()Ljava/lang/String;", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getToRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getToRoom$annotations", "toRoom", "getTips", "getTips$annotations", "tips", "getReserveId", "getReserveId$annotations", "reserveId", "getFromOpenId", "getFromOpenId$annotations", "fromOpenId", "getToOpenId", "getToOpenId$annotations", "toOpenId", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l2 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.y>, com.bytedance.android.livesdk.link.model.bridge.y {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.y, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.y, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_open_id")
    String getFromOpenId();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "from_user_id")
    long getFromUserId();

    @FieldName(name = AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID)
    String getReserveId();

    @FieldName(name = "tips")
    String getTips();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = "to_room")
    IRoom getToRoom();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    long getToUserId();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
