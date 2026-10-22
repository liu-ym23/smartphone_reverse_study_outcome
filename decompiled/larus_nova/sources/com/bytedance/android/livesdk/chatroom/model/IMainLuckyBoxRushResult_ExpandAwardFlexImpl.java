package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.RushLuckyBoxResponse.ExpandAward")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IMainLuckyBoxRushResult_ExpandAwardFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/p1$c;", "Lcom/bytedance/android/livesdk/chatroom/model/p1$a;", "<set-?>", "caijingVoucher$delegate", "Ljava/lang/Object;", "getCaijingVoucher", "()Lcom/bytedance/android/livesdk/chatroom/model/p1$a;", "setCaijingVoucher", "(Lcom/bytedance/android/livesdk/chatroom/model/p1$a;)V", "caijingVoucher", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMainLuckyBoxRushResult_ExpandAwardFlexImpl extends FlexModelBase<p1.c> implements p1.c, vh7.h {

    @SerializedName("caijing_voucher")
    protected p1.a _$$caijingVoucher;

    public IMainLuckyBoxRushResult_ExpandAwardFlexImpl() {
        super(p1.c.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.p1$a, java.lang.Object] */
    public IMainLuckyBoxRushResult_ExpandAwardFlexImpl(am3.g r100) {
        super(p1.c.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$caijingVoucher = vh7.f.a(r100, p1.a.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.c
    public final p1.a getCaijingVoucher() {
        return this._$$caijingVoucher;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.c
    public final void setCaijingVoucher(p1.a r100) {
        this._$$caijingVoucher = r100;
    }
}
