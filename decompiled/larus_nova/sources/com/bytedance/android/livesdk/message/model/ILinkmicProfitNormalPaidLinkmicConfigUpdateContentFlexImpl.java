package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicProfitNormalPaidLinkmicConfigUpdateContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicProfitNormalPaidLinkmicConfigUpdateContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/x9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "normalPaidLinkmicInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "getNormalPaidLinkmicInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "setNormalPaidLinkmicInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;)V", "", "waitingUserNeedLeave$delegate", "Ljava/lang/Object;", "getWaitingUserNeedLeave", "()Ljava/lang/Boolean;", "waitingUserNeedLeave", "", "waitingUserToast$delegate", "getWaitingUserToast", "()Ljava/lang/String;", "waitingUserToast", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicProfitNormalPaidLinkmicConfigUpdateContentFlexImpl extends FlexModelBase<x9> implements x9, vh7.h {

    @SerializedName("waiting_user_need_leave")
    protected Boolean _$$waitingUserNeedLeave;

    @SerializedName("waiting_user_toast")
    protected String _$$waitingUserToast;

    @SerializedName("normal_paid_linkmic_info")
    protected com.bytedance.android.livesdk.chatroom.model.interact.c1 normalPaidLinkmicInfo;

    public ILinkmicProfitNormalPaidLinkmicConfigUpdateContentFlexImpl() {
        super(x9.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.interact.c1, java.lang.Object] */
    public ILinkmicProfitNormalPaidLinkmicConfigUpdateContentFlexImpl(am3.g r100) {
        super(x9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$waitingUserNeedLeave = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$waitingUserToast = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.normalPaidLinkmicInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.interact.c1.class);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.message.model.x9
    public com.bytedance.android.livesdk.chatroom.model.interact.c1 getNormalPaidLinkmicInfo() {
        return this.normalPaidLinkmicInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.x9
    public final Boolean getWaitingUserNeedLeave() {
        return this._$$waitingUserNeedLeave;
    }

    @Override // com.bytedance.android.livesdk.message.model.x9
    public final String getWaitingUserToast() {
        return this._$$waitingUserToast;
    }

    public void setNormalPaidLinkmicInfo(com.bytedance.android.livesdk.chatroom.model.interact.c1 r100) {
        this.normalPaidLinkmicInfo = r100;
    }
}
