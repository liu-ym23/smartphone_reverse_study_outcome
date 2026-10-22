package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.LuckyBoxBonus")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILuckyBoxBonusFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/m1;", "Lcom/bytedance/android/livesdk/chatroom/model/w0;", "<set-?>", "consumedGift$delegate", "Ljava/lang/Object;", "getConsumedGift", "()Lcom/bytedance/android/livesdk/chatroom/model/w0;", "setConsumedGift", "(Lcom/bytedance/android/livesdk/chatroom/model/w0;)V", "consumedGift", "", "openType$delegate", "getOpenType", "()Ljava/lang/Integer;", "setOpenType", "(Ljava/lang/Integer;)V", "openType", "", "boxIdStr$delegate", "getBoxIdStr", "()Ljava/lang/String;", "setBoxIdStr", "(Ljava/lang/String;)V", "boxIdStr", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILuckyBoxBonusFlexImpl extends FlexModelBase<m1> implements m1, vh7.h {

    @SerializedName("box_id_str")
    protected String _$$boxIdStr;

    @SerializedName("consumed_gift")
    protected w0 _$$consumedGift;

    @SerializedName("open_type")
    protected Integer _$$openType;

    public ILuckyBoxBonusFlexImpl() {
        super(m1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.m1
    public final String getBoxIdStr() {
        return this._$$boxIdStr;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.m1
    public final w0 getConsumedGift() {
        return this._$$consumedGift;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.m1
    public final Integer getOpenType() {
        return this._$$openType;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.chatroom.model.w0, java.lang.Object] */
    public ILuckyBoxBonusFlexImpl(am3.g r100) {
        super(m1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$consumedGift = vh7.f.a(r100, w0.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$openType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$boxIdStr = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.m1
    public final void setBoxIdStr(String r100) {
        this._$$boxIdStr = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.m1
    public final void setConsumedGift(w0 r100) {
        this._$$consumedGift = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.m1
    public final void setOpenType(Integer r100) {
        this._$$openType = r100;
    }
}
