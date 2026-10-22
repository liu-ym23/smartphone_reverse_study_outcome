package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/NormalPaidLinkmicAddPriceContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a1;", "", "addPriceStrategy", "I", "getAddPriceStrategy", "()I", "setAddPriceStrategy", "(I)V", "", "customAddPriceValue", "J", "getCustomAddPriceValue", "()J", "setCustomAddPriceValue", "(J)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalPaidLinkmicAddPriceContent extends FlexModelBase<a1> implements a1, vh7.h {

    @SerializedName("add_price_strategy")
    protected int addPriceStrategy;

    @SerializedName("custom_add_price_value")
    protected long customAddPriceValue;

    public NormalPaidLinkmicAddPriceContent() {
        super(a1.class);
        this.addPriceStrategy = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.a1
    public int getAddPriceStrategy() {
        return this.addPriceStrategy;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.a1
    public long getCustomAddPriceValue() {
        return this.customAddPriceValue;
    }

    public NormalPaidLinkmicAddPriceContent(am3.g r100) {
        super(a1.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.addPriceStrategy = r100.i();
        r101 = r101 | true;
        goto L3
    L8:
        if (r103 != 2) goto L9;
        this.customAddPriceValue = r100.j();
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L25;
        this.addPriceStrategy = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.a1
    public void setAddPriceStrategy(int r100) {
        this.addPriceStrategy = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.a1
    public void setCustomAddPriceValue(long r100) {
        this.customAddPriceValue = r100;
    }
}
