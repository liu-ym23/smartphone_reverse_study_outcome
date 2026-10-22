package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/GameBarrageRtcInfo;", "Lvh7/c;", "", "getLinkerId", "()J", "setLinkerId", "(J)V", "getLinkerId$annotations", "()V", "linkerId", "", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "getRtcExtInfo$annotations", "rtcExtInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface GameBarrageRtcInfo extends vh7.c<GameBarrageRtcInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "linker_id")
    long getLinkerId();

    @FieldName(name = "rtc_info")
    String getRtcExtInfo();

    @FieldName(name = "linker_id#setter")
    void setLinkerId(long r100);

    @FieldName(name = "rtc_info#setter")
    void setRtcExtInfo(String r100);
}
