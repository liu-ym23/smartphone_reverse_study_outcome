package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.LuckyBoxExpandAward")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILuckyBoxReceiveResult_LuckyBoxExpandAwardFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/n1$d;", "Lcom/bytedance/android/livesdk/chatroom/model/n1$c;", "<set-?>", "caijingVoucher$delegate", "Ljava/lang/Object;", "getCaijingVoucher", "()Lcom/bytedance/android/livesdk/chatroom/model/n1$c;", "setCaijingVoucher", "(Lcom/bytedance/android/livesdk/chatroom/model/n1$c;)V", "caijingVoucher", "", "extraAward$delegate", "getExtraAward", "()Ljava/lang/String;", "setExtraAward", "(Ljava/lang/String;)V", "extraAward", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILuckyBoxReceiveResult_LuckyBoxExpandAwardFlexImpl extends FlexModelBase<n1.d> implements n1.d, vh7.h {

    @SerializedName("caijing_voucher")
    protected n1.c _$$caijingVoucher;

    @SerializedName("extra_award")
    protected String _$$extraAward;

    public ILuckyBoxReceiveResult_LuckyBoxExpandAwardFlexImpl() {
        super(n1.d.class);
        this._$$extraAward = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.chatroom.model.n1$c, java.lang.Object] */
    public ILuckyBoxReceiveResult_LuckyBoxExpandAwardFlexImpl(am3.g r100) {
        super(n1.d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$caijingVoucher = vh7.f.a(r100, n1.c.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$extraAward = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$extraAward != null) goto L25;
        this._$$extraAward = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.d
    public final n1.c getCaijingVoucher() {
        return this._$$caijingVoucher;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.d
    public final String getExtraAward() {
        return this._$$extraAward;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.d
    public final void setCaijingVoucher(n1.c r100) {
        this._$$caijingVoucher = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.d
    public final void setExtraAward(String r100) {
        this._$$extraAward = r100;
    }
}
