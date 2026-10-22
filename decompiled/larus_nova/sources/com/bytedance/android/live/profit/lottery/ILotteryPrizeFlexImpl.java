package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.LotteryPrize")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ILotteryPrizeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/p;", "", "prizeId$delegate", "Ljava/lang/Object;", "getPrizeId", "()J", "prizeId", "", "type$delegate", "getType", "()I", "type", "", "name$delegate", "getName", "()Ljava/lang/String;", "name", "image$delegate", "getImage", "image", "prizeDescription$delegate", "getPrizeDescription", "prizeDescription", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILotteryPrizeFlexImpl extends FlexModelBase<p> implements p, vh7.h {

    @SerializedName("image")
    protected String _$$image;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("prize_description")
    protected String _$$prizeDescription;

    @SerializedName("prize_id")
    protected long _$$prizeId;

    @SerializedName("type")
    protected int _$$type;

    public ILotteryPrizeFlexImpl() {
        super(p.class);
        this._$$name = "";
        this._$$image = "";
        this._$$prizeDescription = "";
    }

    @Override // com.bytedance.android.live.profit.lottery.p
    public final String getImage() {
        return this._$$image;
    }

    @Override // com.bytedance.android.live.profit.lottery.p
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.live.profit.lottery.p
    public final String getPrizeDescription() {
        return this._$$prizeDescription;
    }

    @Override // com.bytedance.android.live.profit.lottery.p
    public final long getPrizeId() {
        return this._$$prizeId;
    }

    @Override // com.bytedance.android.live.profit.lottery.p
    public final int getType() {
        return this._$$type;
    }

    public ILotteryPrizeFlexImpl(am3.g r100) {
        super(p.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$prizeId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$type = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$name = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$image = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$prizeDescription = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$name != null) goto L25;
        this._$$name = "";
    L25:
        if (this._$$image != null) goto L28;
        this._$$image = "";
    L28:
        if (this._$$prizeDescription != null) goto L49;
        this._$$prizeDescription = "";
        return;
    }
}
