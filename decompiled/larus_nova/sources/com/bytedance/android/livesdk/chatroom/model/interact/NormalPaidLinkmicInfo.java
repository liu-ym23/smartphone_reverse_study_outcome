package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\u001a\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/NormalPaidLinkmicInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "", "status", "J", "getStatus", "()J", "setStatus", "(J)V", "paidCount", "getPaidCount", "setPaidCount", "limitedTime", "getLimitedTime", "setLimitedTime", "", "addPriceStrategy", "I", "getAddPriceStrategy", "()I", "setAddPriceStrategy", "(I)V", "addPriceValue", "getAddPriceValue", "setAddPriceValue", "addPriceMultiple", "getAddPriceMultiple", "setAddPriceMultiple", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NormalPaidLinkmicInfo extends FlexModelBase<c1> implements c1, vh7.h {

    @SerializedName("add_price_multiple")
    protected long addPriceMultiple;

    @SerializedName("add_price_strategy")
    protected int addPriceStrategy;

    @SerializedName("add_price_value")
    protected long addPriceValue;

    @SerializedName("limited_time")
    protected long limitedTime;

    @SerializedName("paid_count")
    protected long paidCount;

    @SerializedName("status")
    protected long status;

    public NormalPaidLinkmicInfo() {
        super(c1.class);
        this.addPriceStrategy = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c1
    public long getAddPriceMultiple() {
        return this.addPriceMultiple;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c1
    public int getAddPriceStrategy() {
        return this.addPriceStrategy;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c1
    public long getAddPriceValue() {
        return this.addPriceValue;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c1
    public long getLimitedTime() {
        return this.limitedTime;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c1
    public long getPaidCount() {
        return this.paidCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.c1
    public long getStatus() {
        return this.status;
    }

    public NormalPaidLinkmicInfo(am3.g r100) {
        super(c1.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.addPriceMultiple = r100.j();
        goto L3
    L9:
        this.addPriceValue = r100.j();
        goto L3
    L10:
        this.addPriceStrategy = r100.i();
        r101 = r101 | true;
        goto L3
    L11:
        this.status = r100.i();
        goto L3
    L12:
        this.limitedTime = r100.j();
        goto L3
    L13:
        this.paidCount = r100.j();
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L14:
        r100.d(r102);
        setThreadSafe(true);
        if ((true & r101) == true) goto L34;
        this.addPriceStrategy = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
        return;
    }

    public void setAddPriceMultiple(long r100) {
        this.addPriceMultiple = r100;
    }

    public void setAddPriceStrategy(int r100) {
        this.addPriceStrategy = r100;
    }

    public void setAddPriceValue(long r100) {
        this.addPriceValue = r100;
    }

    public void setLimitedTime(long r100) {
        this.limitedTime = r100;
    }

    public void setPaidCount(long r100) {
        this.paidCount = r100;
    }

    public void setStatus(long r100) {
        this.status = r100;
    }
}
