package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0006R\"\u0010\u001f\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u0006R$\u0010'\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010\u0006R$\u0010+\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010\u0006¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/t2;", "Lvh7/c;", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getAccessToken$annotations", "()V", "accessToken", "", "getLinkMicId", "()J", "setLinkMicId", "(J)V", "getLinkMicId$annotations", "linkMicId", "", "getVendor", "()I", "setVendor", "(I)V", "getVendor$annotations", Constants.OperatorKey.KEY_VENDOR, "getLinkMicIdStr", "setLinkMicIdStr", "getLinkMicIdStr$annotations", "linkMicIdStr", "getRivalLinkmicId", "setRivalLinkmicId", "getRivalLinkmicId$annotations", "rivalLinkmicId", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "getRivalLinkmicIdStr$annotations", "rivalLinkmicIdStr", "getRtcExtInfo", "setRtcExtInfo", "getRtcExtInfo$annotations", "rtcExtInfo", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "getRemoteLinkerSessionId$annotations", "remoteLinkerSessionId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t2 extends vh7.c<t2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "access_key")
    String getAccessToken();

    @FieldName(name = "linkmic_id")
    long getLinkMicId();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdStr();

    @FieldName(name = "remote_linker_session_id")
    String getRemoteLinkerSessionId();

    @FieldName(name = "rival_linkmic_id")
    long getRivalLinkmicId();

    @FieldName(name = "rival_linkmic_id_str")
    String getRivalLinkmicIdStr();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = Constants.OperatorKey.KEY_VENDOR)
    int getVendor();

    @FieldName(name = "access_key#setter")
    void setAccessToken(String r100);

    @FieldName(name = "linkmic_id#setter")
    void setLinkMicId(long r100);

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkMicIdStr(String r100);

    @FieldName(name = "remote_linker_session_id#setter")
    void setRemoteLinkerSessionId(String r100);

    @FieldName(name = "rival_linkmic_id#setter")
    void setRivalLinkmicId(long r100);

    @FieldName(name = "rival_linkmic_id_str#setter")
    void setRivalLinkmicIdStr(String r100);

    @FieldName(name = "rtc_ext_info#setter")
    void setRtcExtInfo(String r100);

    @FieldName(name = "vendor#setter")
    void setVendor(int r100);
}
