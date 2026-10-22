package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerSysKickOutContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R/\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R+\u0010!\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R/\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "", "<set-?>", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()J", "setUserId", "(J)V", "userId", "", "openId$delegate", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "openId", "linkmicIdStr$delegate", "getLinkmicIdStr", "setLinkmicIdStr", "linkmicIdStr", "toastMsg$delegate", "getToastMsg", "setToastMsg", "toastMsg", "", "kickOutSource$delegate", "getKickOutSource", "()I", "setKickOutSource", "(I)V", "kickOutSource", "localReasonToast$delegate", "getLocalReasonToast", "setLocalReasonToast", "localReasonToast", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerSysKickOutContentFlexImpl extends FlexModelBase<LinkerSysKickOutContent> implements LinkerSysKickOutContent, h {

    @SerializedName("kick_out_source")
    protected int _$$kickOutSource;

    @SerializedName("linkmic_id_str")
    protected String _$$linkmicIdStr;

    @SerializedName("reason_toast")
    protected String _$$localReasonToast;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _$$openId;

    @SerializedName(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    protected String _$$toastMsg;

    @SerializedName("user_id")
    protected long _$$userId;

    public LinkerSysKickOutContentFlexImpl() {
        super(LinkerSysKickOutContent.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final int getKickOutSource() {
        return this._$$kickOutSource;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final String getLinkmicIdStr() {
        return this._$$linkmicIdStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final String getLocalReasonToast() {
        return this._$$localReasonToast;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final String getOpenId() {
        return this._$$openId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final String getToastMsg() {
        return this._$$toastMsg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final long getUserId() {
        return this._$$userId;
    }

    public LinkerSysKickOutContentFlexImpl(g r100) {
        super(LinkerSysKickOutContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$linkmicIdStr = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$toastMsg = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$kickOutSource = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._$$localReasonToast = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._$$openId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final void setKickOutSource(int r100) {
        this._$$kickOutSource = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final void setLinkmicIdStr(String r100) {
        this._$$linkmicIdStr = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final void setLocalReasonToast(String r100) {
        this._$$localReasonToast = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final void setOpenId(String r100) {
        this._$$openId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final void setToastMsg(String r100) {
        this._$$toastMsg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent
    public final void setUserId(long r100) {
        this._$$userId = r100;
    }
}
