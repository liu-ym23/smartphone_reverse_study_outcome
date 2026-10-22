package com.bytedance.android.livesdk.skin;

import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/skin/ISkinRoom;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ActivityRoomSkinInfo;", "getActivitySkinInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ActivityRoomSkinInfo;", "setActivitySkinInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ActivityRoomSkinInfo;)V", "getActivitySkinInfo$annotations", "()V", "activitySkinInfo", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISkinRoom extends e<IRoom>, IRoom {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "activity_room_skin_info")
    ActivityRoomSkinInfo getActivitySkinInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "activity_room_skin_info#setter")
    void setActivitySkinInfo(ActivityRoomSkinInfo r100);
}
