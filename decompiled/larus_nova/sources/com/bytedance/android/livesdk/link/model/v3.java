package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v3;", "Lvh7/c;", "", "getPointTag", "()Ljava/lang/String;", "setPointTag", "(Ljava/lang/String;)V", "getPointTag$annotations", "()V", "pointTag", "getImprId", "setImprId", "getImprId$annotations", "imprId", "getInviteMode", "setInviteMode", "getInviteMode$annotations", "inviteMode", "getListNum", "setListNum", "getListNum$annotations", "listNum", "getInviterRoomStatus", "setInviterRoomStatus", "getInviterRoomStatus$annotations", "inviterRoomStatus", "getInviterConnectCnt", "setInviterConnectCnt", "getInviterConnectCnt$annotations", "inviterConnectCnt", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v3 extends vh7.c<v3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "impr_id")
    String getImprId();

    @FieldName(name = "invite_mode")
    String getInviteMode();

    @FieldName(name = "inviter_connect_cnt")
    String getInviterConnectCnt();

    @FieldName(name = "inviter_room_status")
    String getInviterRoomStatus();

    @FieldName(name = "list_num")
    String getListNum();

    @FieldName(name = "point_tag")
    String getPointTag();

    @FieldName(name = "impr_id#setter")
    void setImprId(String r100);

    @FieldName(name = "invite_mode#setter")
    void setInviteMode(String r100);

    @FieldName(name = "inviter_connect_cnt#setter")
    void setInviterConnectCnt(String r100);

    @FieldName(name = "inviter_room_status#setter")
    void setInviterRoomStatus(String r100);

    @FieldName(name = "list_num#setter")
    void setListNum(String r100);

    @FieldName(name = "point_tag#setter")
    void setPointTag(String r100);
}
