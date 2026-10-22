package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;", "Lvh7/c;", "", "getCollaborateRoomId", "()J", "setCollaborateRoomId", "(J)V", "getCollaborateRoomId$annotations", "()V", "collaborateRoomId", "", "getCollaborateRoomIdString", "()Ljava/lang/String;", "setCollaborateRoomIdString", "(Ljava/lang/String;)V", "getCollaborateRoomIdString$annotations", "collaborateRoomIdString", "getJumpCollaborateRoomTime", "setJumpCollaborateRoomTime", "getJumpCollaborateRoomTime$annotations", "jumpCollaborateRoomTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ICloudCollaborateData extends c<ICloudCollaborateData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "collaborate_room_id")
        public static /* synthetic */ void getCollaborateRoomId$annotations() {
        }

        @FieldName(name = "collaborate_room_id_str")
        public static /* synthetic */ void getCollaborateRoomIdString$annotations() {
        }

        @FieldName(name = "rejoin_time")
        public static /* synthetic */ void getJumpCollaborateRoomTime$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "collaborate_room_id")
    long getCollaborateRoomId();

    @FieldName(name = "collaborate_room_id_str")
    String getCollaborateRoomIdString();

    @FieldName(name = "rejoin_time")
    long getJumpCollaborateRoomTime();

    @FieldName(name = "collaborate_room_id#setter")
    void setCollaborateRoomId(long r100);

    @FieldName(name = "collaborate_room_id_str#setter")
    void setCollaborateRoomIdString(String r100);

    @FieldName(name = "rejoin_time#setter")
    void setJumpCollaborateRoomTime(long r100);
}
