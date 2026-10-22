package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestChannelFinishContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkChannelFinishContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/d;", "", "<set-?>", "reason$delegate", "Ljava/lang/Object;", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "reason", "linkerToast$delegate", "getLinkerToast", "setLinkerToast", "linkerToast", "aduienceToast$delegate", "getAduienceToast", "setAduienceToast", "aduienceToast", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkChannelFinishContentFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("channel_user_toast")
    protected String _$$aduienceToast;

    @SerializedName("linked_user_toast")
    protected String _$$linkerToast;

    @SerializedName("reason")
    protected String _$$reason;

    public ILinkmicGuestLinkChannelFinishContentFlexImpl() {
        super(d.class);
    }

    public ILinkmicGuestLinkChannelFinishContentFlexImpl(am3.g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$reason = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$linkerToast = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$aduienceToast = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.d
    public final String getAduienceToast() {
        return this._$$aduienceToast;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.d
    public final String getLinkerToast() {
        return this._$$linkerToast;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.d
    public final String getReason() {
        return this._$$reason;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.d
    public final void setAduienceToast(String r100) {
        this._$$aduienceToast = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.d
    public final void setLinkerToast(String r100) {
        this._$$linkerToast = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.d
    public final void setReason(String r100) {
        this._$$reason = r100;
    }
}
