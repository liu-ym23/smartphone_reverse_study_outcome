package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestLinkInviter")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkInviteContent_ILinkmicGuestLinkInviterFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/f$b;", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "<set-?>", "inviterInfo$delegate", "Ljava/lang/Object;", "getInviterInfo", "()Lcom/bytedance/android/live/base/model/message/guestlink/k;", "setInviterInfo", "(Lcom/bytedance/android/live/base/model/message/guestlink/k;)V", "inviterInfo", "", "source$delegate", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "source", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkInviteContent_ILinkmicGuestLinkInviterFlexImpl extends FlexModelBase<f.b> implements f.b, vh7.h {

    @SerializedName("inviter_info")
    protected k _$$inviterInfo;

    @SerializedName("source")
    protected String _$$source;

    public ILinkmicGuestLinkInviteContent_ILinkmicGuestLinkInviterFlexImpl() {
        super(f.b.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.guestlink.k, java.lang.Object] */
    public ILinkmicGuestLinkInviteContent_ILinkmicGuestLinkInviterFlexImpl(am3.g r100) {
        super(f.b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$inviterInfo = vh7.f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$source = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.f.b
    public final k getInviterInfo() {
        return this._$$inviterInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.f.b
    public final String getSource() {
        return this._$$source;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.f.b
    public final void setInviterInfo(k r100) {
        this._$$inviterInfo = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.f.b
    public final void setSource(String r100) {
        this._$$source = r100;
    }
}
