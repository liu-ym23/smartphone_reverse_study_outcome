package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.ICrossRoomRTCInfoContent;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c4;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ICrossRoomRTCInfoContent;", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo$annotations", "()V", "multiChannelInfo", "getOtherMultiChannelInfo", "getOtherMultiChannelInfo$annotations", "otherMultiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo$annotations", "preRtcInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c4 extends vh7.e<ICrossRoomRTCInfoContent>, ICrossRoomRTCInfoContent {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICrossRoomRTCInfoContent, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ICrossRoomRTCInfoContent, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "other_multi_channel_info")
    b7 getOtherMultiChannelInfo();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();
}
