package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0016\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010#\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0007\u001a\u0004\b!\u0010\u000b¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s1;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/s;", "Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra;", "getBattleExtra", "()Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra;", "getBattleExtra$annotations", "()V", "battleExtra", "", "getFromRoomId", "()J", "getFromRoomId$annotations", "fromRoomId", "getToRoomId", "getToRoomId$annotations", "toRoomId", "", "getMatchType", "()I", "getMatchType$annotations", "matchType", "getInviteType", "getInviteType$annotations", "inviteType", "", "getClientInfo", "()Ljava/lang/String;", "getClientInfo$annotations", "clientInfo", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "getWaitSec", "getWaitSec$annotations", "waitSec", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s1 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.s>, com.bytedance.android.livesdk.link.model.bridge.s {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.s, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.s, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = AppConstants.KEY_MESSAGE_EXTRA)
    IBattleLinkerInviteMessageExtra getBattleExtra();

    @FieldName(name = "client_attached_info")
    String getClientInfo();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    int getMatchType();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    /* synthetic */ String get_fromUid();

    /* synthetic */ String get_toUid();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
