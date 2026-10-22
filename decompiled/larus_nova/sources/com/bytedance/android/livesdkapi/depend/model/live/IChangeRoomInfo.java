package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;", "Lvh7/c;", "", "getChangeRoomReason", "()I", "setChangeRoomReason", "(I)V", "getChangeRoomReason$annotations", "()V", "changeRoomReason", "", "getBeforeRoomId", "()J", "setBeforeRoomId", "(J)V", "getBeforeRoomId$annotations", "beforeRoomId", "getBeforeAnchorId", "setBeforeAnchorId", "getBeforeAnchorId$annotations", "beforeAnchorId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IChangeRoomInfo extends c<IChangeRoomInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "before_anchor_id")
        public static /* synthetic */ void getBeforeAnchorId$annotations() {
        }

        @FieldName(name = "before_room_id")
        public static /* synthetic */ void getBeforeRoomId$annotations() {
        }

        @FieldName(name = "has_change_room")
        public static /* synthetic */ void getChangeRoomReason$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "before_anchor_id")
    long getBeforeAnchorId();

    @FieldName(name = "before_room_id")
    long getBeforeRoomId();

    @FieldName(name = "has_change_room")
    int getChangeRoomReason();

    @FieldName(name = "before_anchor_id#setter")
    void setBeforeAnchorId(long r100);

    @FieldName(name = "before_room_id#setter")
    void setBeforeRoomId(long r100);

    @FieldName(name = "has_change_room#setter")
    void setChangeRoomReason(int r100);
}
