package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicProfitNormalPaidLinkmicOpenContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicProfitNormalPaidLinkmicOpenContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/y9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "normalPaidLinkmicInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "getNormalPaidLinkmicInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "setNormalPaidLinkmicInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;)V", "", "waitingUserNeedLeave$delegate", "Ljava/lang/Object;", "getWaitingUserNeedLeave", "()Ljava/lang/Boolean;", "waitingUserNeedLeave", "", "waitingUserToast$delegate", "getWaitingUserToast", "()Ljava/lang/String;", "waitingUserToast", "", "openSource$delegate", "getOpenSource", "()I", "openSource", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicProfitNormalPaidLinkmicOpenContentFlexImpl extends FlexModelBase<y9> implements y9, vh7.h {

    @SerializedName("source")
    protected int _$$openSource;

    @SerializedName("waiting_user_need_leave")
    protected Boolean _$$waitingUserNeedLeave;

    @SerializedName("waiting_user_toast")
    protected String _$$waitingUserToast;

    @SerializedName("normal_paid_linkmic_info")
    protected com.bytedance.android.livesdk.chatroom.model.interact.c1 normalPaidLinkmicInfo;

    public ILinkmicProfitNormalPaidLinkmicOpenContentFlexImpl() {
        super(y9.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.y9
    public com.bytedance.android.livesdk.chatroom.model.interact.c1 getNormalPaidLinkmicInfo() {
        return this.normalPaidLinkmicInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.y9
    public final int getOpenSource() {
        return this._$$openSource;
    }

    @Override // com.bytedance.android.livesdk.message.model.y9
    public final Boolean getWaitingUserNeedLeave() {
        return this._$$waitingUserNeedLeave;
    }

    @Override // com.bytedance.android.livesdk.message.model.y9
    public final String getWaitingUserToast() {
        return this._$$waitingUserToast;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdk.chatroom.model.interact.c1, java.lang.Object] */
    public ILinkmicProfitNormalPaidLinkmicOpenContentFlexImpl(am3.g r100) {
        super(y9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.normalPaidLinkmicInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.interact.c1.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$waitingUserNeedLeave = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$waitingUserToast = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$openSource = r100.i();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setNormalPaidLinkmicInfo(com.bytedance.android.livesdk.chatroom.model.interact.c1 r100) {
        this.normalPaidLinkmicInfo = r100;
    }
}
