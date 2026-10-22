package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;", "Lvh7/c;", "", "getCanJoinRtcAdvance", "()Z", "setCanJoinRtcAdvance", "(Z)V", "getCanJoinRtcAdvance$annotations", "()V", "canJoinRtcAdvance", "", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "getRtcExtInfo$annotations", "rtcExtInfo", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "getLiveCoreExtInfo$annotations", "liveCoreExtInfo", "getLinkMicIdString", "setLinkMicIdString", "getLinkMicIdString$annotations", "linkMicIdString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerRTCActionJoinRTCContent extends c<ILinkerRTCActionJoinRTCContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "join_rtc")
        public static /* synthetic */ void getCanJoinRtcAdvance$annotations() {
        }

        @FieldName(name = "linkmic_id_str")
        public static /* synthetic */ void getLinkMicIdString$annotations() {
        }

        @FieldName(name = "live_core_ext_info")
        public static /* synthetic */ void getLiveCoreExtInfo$annotations() {
        }

        @FieldName(name = "rtc_ext_info")
        public static /* synthetic */ void getRtcExtInfo$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "join_rtc")
    boolean getCanJoinRtcAdvance();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdString();

    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "join_rtc#setter")
    void setCanJoinRtcAdvance(boolean r100);

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkMicIdString(String r100);

    @FieldName(name = "live_core_ext_info#setter")
    void setLiveCoreExtInfo(String r100);

    @FieldName(name = "rtc_ext_info#setter")
    void setRtcExtInfo(String r100);
}
