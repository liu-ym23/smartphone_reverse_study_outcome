package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicProfitNormalPaidLinkmicAddPriceContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicProfitNormalPaidLinkmicAddPriceContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/u9;", "", "addPriceValue$delegate", "Ljava/lang/Object;", "getAddPriceValue", "()J", "addPriceValue", "_addPriceUserId$delegate", "get_addPriceUserId", "_addPriceUserId", "", "_addPriceOpenId$delegate", "get_addPriceOpenId", "()Ljava/lang/String;", "_addPriceOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicProfitNormalPaidLinkmicAddPriceContentFlexImpl extends FlexModelBase<u9> implements u9, vh7.h {

    @SerializedName("add_price_open_id")
    protected String _$$_addPriceOpenId;

    @SerializedName("add_price_user_id")
    protected long _$$_addPriceUserId;

    @SerializedName("add_price_value")
    protected long _$$addPriceValue;

    public ILinkmicProfitNormalPaidLinkmicAddPriceContentFlexImpl() {
        super(u9.class);
        this._$$_addPriceOpenId = "";
    }

    @Override // com.bytedance.android.livesdk.message.model.u9
    public final long getAddPriceValue() {
        return this._$$addPriceValue;
    }

    @Override // com.bytedance.android.livesdk.message.model.u9
    public final String get_addPriceOpenId() {
        return this._$$_addPriceOpenId;
    }

    @Override // com.bytedance.android.livesdk.message.model.u9
    public final long get_addPriceUserId() {
        return this._$$_addPriceUserId;
    }

    public ILinkmicProfitNormalPaidLinkmicAddPriceContentFlexImpl(am3.g r100) {
        super(u9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$_addPriceUserId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$addPriceValue = r100.j();
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this._$$_addPriceOpenId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$_addPriceOpenId != null) goto L31;
        this._$$_addPriceOpenId = "";
        return;
    }
}
