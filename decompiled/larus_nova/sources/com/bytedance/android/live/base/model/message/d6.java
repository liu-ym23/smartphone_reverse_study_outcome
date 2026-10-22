package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/base/model/message/d6;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "getEnlargeGuestInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "setEnlargeGuestInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;)V", "getEnlargeGuestInfo$annotations", "()V", "enlargeGuestInfo", "", "get_enlargedUserId", "()J", "get_enlargedUserId$annotations", "_enlargedUserId", "", "get_enlargedOpenId", "()Ljava/lang/String;", "get_enlargedOpenId$annotations", "_enlargedOpenId", "getTrackingData", "getTrackingData$annotations", "trackingData", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d6 extends vh7.c<d6> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "info")
    EnlargeGuestInfo getEnlargeGuestInfo();

    @FieldName(name = "tracking_data")
    String getTrackingData();

    @FieldName(name = "enlarged_openid")
    String get_enlargedOpenId();

    @FieldName(name = "enlarged_user_id")
    long get_enlargedUserId();

    @FieldName(name = "info#setter")
    void setEnlargeGuestInfo(EnlargeGuestInfo r100);
}
