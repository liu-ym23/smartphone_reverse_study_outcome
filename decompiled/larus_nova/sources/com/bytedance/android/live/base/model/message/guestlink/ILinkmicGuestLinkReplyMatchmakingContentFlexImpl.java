package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestLinkReplyMatchmakingContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyMatchmakingContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/j;", "", "<set-?>", "replyType$delegate", "Ljava/lang/Object;", "getReplyType", "()I", "setReplyType", "(I)V", "replyType", "", "callDuration$delegate", "getCallDuration", "()J", "setCallDuration", "(J)V", "callDuration", "linkThreshold$delegate", "getLinkThreshold", "setLinkThreshold", "linkThreshold", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkReplyMatchmakingContentFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("call_duration")
    protected long _$$callDuration;

    @SerializedName("link_threshold")
    protected long _$$linkThreshold;

    @SerializedName("reply_type")
    protected int _$$replyType;

    public ILinkmicGuestLinkReplyMatchmakingContentFlexImpl() {
        super(j.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.j
    public final long getCallDuration() {
        return this._$$callDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.j
    public final long getLinkThreshold() {
        return this._$$linkThreshold;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.j
    public final int getReplyType() {
        return this._$$replyType;
    }

    public ILinkmicGuestLinkReplyMatchmakingContentFlexImpl(am3.g r100) {
        super(j.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$replyType = r100.i();
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

    @Override // com.bytedance.android.live.base.model.message.guestlink.j
    public final void setCallDuration(long r100) {
        this._$$callDuration = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.j
    public final void setLinkThreshold(long r100) {
        this._$$linkThreshold = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.j
    public final void setReplyType(int r100) {
        this._$$replyType = r100;
    }
}
