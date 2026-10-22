package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestLinkInvitationGuideContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkInvitationGuideContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/e;", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "<set-?>", "targetLinkUser$delegate", "Ljava/lang/Object;", "getTargetLinkUser", "()Lcom/bytedance/android/live/base/model/message/guestlink/k;", "setTargetLinkUser", "(Lcom/bytedance/android/live/base/model/message/guestlink/k;)V", "targetLinkUser", "", "callDuration$delegate", "getCallDuration", "()J", "setCallDuration", "(J)V", "callDuration", "linkThreshold$delegate", "getLinkThreshold", "setLinkThreshold", "linkThreshold", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkInvitationGuideContentFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("call_duration")
    protected long _$$callDuration;

    @SerializedName("link_threshold")
    protected long _$$linkThreshold;

    @SerializedName("target_link_user")
    protected k _$$targetLinkUser;

    public ILinkmicGuestLinkInvitationGuideContentFlexImpl() {
        super(e.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.e
    public final long getCallDuration() {
        return this._$$callDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.e
    public final long getLinkThreshold() {
        return this._$$linkThreshold;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.e
    public final k getTargetLinkUser() {
        return this._$$targetLinkUser;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.message.guestlink.k, java.lang.Object] */
    public ILinkmicGuestLinkInvitationGuideContentFlexImpl(am3.g r100) {
        super(e.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$targetLinkUser = vh7.f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$callDuration = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$linkThreshold = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.e
    public final void setCallDuration(long r100) {
        this._$$callDuration = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.e
    public final void setLinkThreshold(long r100) {
        this._$$linkThreshold = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.e
    public final void setTargetLinkUser(k r100) {
        this._$$targetLinkUser = r100;
    }
}
