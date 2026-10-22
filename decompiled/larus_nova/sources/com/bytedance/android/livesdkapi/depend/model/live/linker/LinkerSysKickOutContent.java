package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00198&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "Lvh7/c;", "", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "()V", "userId", "", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "getOpenId$annotations", "openId", "getLinkmicIdStr", "setLinkmicIdStr", "getLinkmicIdStr$annotations", "linkmicIdStr", "getToastMsg", "setToastMsg", "getToastMsg$annotations", "toastMsg", "", "getKickOutSource", "()I", "setKickOutSource", "(I)V", "getKickOutSource$annotations", "kickOutSource", "getLocalReasonToast", "setLocalReasonToast", "getLocalReasonToast$annotations", "localReasonToast", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkerSysKickOutContent extends c<LinkerSysKickOutContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "kick_out_source")
        public static /* synthetic */ void getKickOutSource$annotations() {
        }

        @FieldName(name = "linkmic_id_str")
        public static /* synthetic */ void getLinkmicIdStr$annotations() {
        }

        @FieldName(name = "reason_toast")
        public static /* synthetic */ void getLocalReasonToast$annotations() {
        }

        @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
        public static /* synthetic */ void getOpenId$annotations() {
        }

        @FieldName(name = UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
        public static /* synthetic */ void getToastMsg$annotations() {
        }

        @FieldName(name = "user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "kick_out_source")
    int getKickOutSource();

    @FieldName(name = "linkmic_id_str")
    String getLinkmicIdStr();

    @FieldName(name = "reason_toast")
    String getLocalReasonToast();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getOpenId();

    @FieldName(name = UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    String getToastMsg();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "kick_out_source#setter")
    void setKickOutSource(int r100);

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkmicIdStr(String r100);

    @FieldName(name = "reason_toast#setter")
    void setLocalReasonToast(String r100);

    @FieldName(name = "open_id#setter")
    void setOpenId(String r100);

    @FieldName(name = "toast_msg#setter")
    void setToastMsg(String r100);

    @FieldName(name = "user_id#setter")
    void setUserId(long r100);
}
