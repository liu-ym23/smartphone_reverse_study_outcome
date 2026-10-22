package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\"\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010&\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\u0006R\"\u0010*\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010.\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R*\u00106\u001a\n\u0018\u00010/j\u0004\u0018\u0001`08&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\b\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010:\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\b\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R$\u0010A\u001a\u0004\u0018\u00010;8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\b\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010H\u001a\u00020B8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bG\u0010\b\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010L\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bK\u0010\b\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR$\u0010P\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bO\u0010\b\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000e¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IApplyResult;", "Lvh7/c;", "", "getLinkMicId", "()J", "setLinkMicId", "(J)V", "getLinkMicId$annotations", "()V", "linkMicId", "", "getPrompts", "()Ljava/lang/String;", "setPrompts", "(Ljava/lang/String;)V", "getPrompts$annotations", "prompts", "", "getVendor", "()I", "setVendor", "(I)V", "getVendor$annotations", Constants.OperatorKey.KEY_VENDOR, "getLinkMicIdStr", "setLinkMicIdStr", "getLinkMicIdStr$annotations", "linkMicIdStr", "", "getAutoJoin", "()Z", "setAutoJoin", "(Z)V", "getAutoJoin$annotations", "autoJoin", "getWaitingListOffset", "setWaitingListOffset", "getWaitingListOffset$annotations", "waitingListOffset", "getAutoJoinFull", "setAutoJoinFull", "getAutoJoinFull$annotations", "autoJoinFull", "getSilenceStatus", "setSilenceStatus", "getSilenceStatus$annotations", "silenceStatus", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getDisplayText$annotations", "displayText", "getLinkType", "setLinkType", "getLinkType$annotations", "linkType", "Lcom/bytedance/android/live/liveinteract/plantform/model/g;", "getEarlyInitRtInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g;", "setEarlyInitRtInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g;)V", "getEarlyInitRtInfo$annotations", "earlyInitRtInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "getMicPosTagInfo$annotations", "micPosTagInfo", "getLinkerSessionId", "setLinkerSessionId", "getLinkerSessionId$annotations", "linkerSessionId", "getSubRtcToken", "setSubRtcToken", "getSubRtcToken$annotations", "subRtcToken", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IApplyResult extends vh7.c<IApplyResult> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = ILiveRoomPlayFragmentConstant.IS_CHAT_AUTO_JOIN)
    boolean getAutoJoin();

    @FieldName(name = "auto_join_full")
    boolean getAutoJoinFull();

    @FieldName(name = "fast_match_display_text")
    a5 getDisplayText();

    @FieldName(name = "early_init_rtc_engine_data")
    com.bytedance.android.live.liveinteract.plantform.model.g getEarlyInitRtInfo();

    @FieldName(name = "linkmic_id")
    long getLinkMicId();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdStr();

    @FieldName(name = "link_type")
    int getLinkType();

    @FieldName(name = "linker_session_id")
    String getLinkerSessionId();

    @FieldName(name = "mic_pos_tag_info")
    com.bytedance.android.live.liveinteract.plantform.model.g0 getMicPosTagInfo();

    @FieldName(name = "prompts")
    String getPrompts();

    @FieldName(name = "silence_status")
    int getSilenceStatus();

    @FieldName(name = "sub_rtc_ext_info")
    String getSubRtcToken();

    @FieldName(name = Constants.OperatorKey.KEY_VENDOR)
    int getVendor();

    @FieldName(name = "waiting_list_offset")
    long getWaitingListOffset();

    @FieldName(name = "auto_join#setter")
    void setAutoJoin(boolean r100);

    @FieldName(name = "auto_join_full#setter")
    void setAutoJoinFull(boolean r100);

    @FieldName(name = "fast_match_display_text#setter")
    void setDisplayText(a5 r100);

    @FieldName(name = "early_init_rtc_engine_data#setter")
    void setEarlyInitRtInfo(com.bytedance.android.live.liveinteract.plantform.model.g r100);

    @FieldName(name = "linkmic_id#setter")
    void setLinkMicId(long r100);

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkMicIdStr(String r100);

    @FieldName(name = "link_type#setter")
    void setLinkType(int r100);

    @FieldName(name = "linker_session_id#setter")
    void setLinkerSessionId(String r100);

    @FieldName(name = "mic_pos_tag_info#setter")
    void setMicPosTagInfo(com.bytedance.android.live.liveinteract.plantform.model.g0 r100);

    @FieldName(name = "prompts#setter")
    void setPrompts(String r100);

    @FieldName(name = "silence_status#setter")
    void setSilenceStatus(int r100);

    @FieldName(name = "sub_rtc_ext_info#setter")
    void setSubRtcToken(String r100);

    @FieldName(name = "vendor#setter")
    void setVendor(int r100);

    @FieldName(name = "waiting_list_offset#setter")
    void setWaitingListOffset(long r100);
}
