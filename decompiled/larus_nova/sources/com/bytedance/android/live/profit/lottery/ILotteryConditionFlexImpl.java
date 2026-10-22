package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.LotteryCondition")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010)R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\fR\u001b\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010!\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0011R\u001b\u0010$\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R\u001b\u0010'\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ILotteryConditionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/h;", "", "conditionId$delegate", "Ljava/lang/Object;", "getConditionId", "()J", "conditionId", "", "type$delegate", "getType", "()I", "type", "", "content$delegate", "getContent", "()Ljava/lang/String;", "content", "status$delegate", "getStatus", "status", "description$delegate", "getDescription", "description", "giftId$delegate", "getGiftId", "giftId", "giftCount$delegate", "getGiftCount", "giftCount", "giftName$delegate", "getGiftName", "giftName", "needDiamondCount$delegate", "getNeedDiamondCount", "needDiamondCount", "minFansLevel$delegate", "getMinFansLevel", "minFansLevel", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILotteryConditionFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("condition_id")
    protected long _$$conditionId;

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("description")
    protected String _$$description;

    @SerializedName("gift_count")
    protected long _$$giftCount;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long _$$giftId;

    @SerializedName("gift_name")
    protected String _$$giftName;

    @SerializedName("min_fans_level")
    protected long _$$minFansLevel;

    @SerializedName("need_diamond_count")
    protected long _$$needDiamondCount;

    @SerializedName("status")
    protected int _$$status;

    @SerializedName("type")
    protected int _$$type;

    public ILotteryConditionFlexImpl() {
        super(h.class);
        this._$$content = "";
        this._$$description = "";
        this._$$giftName = "";
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final long getConditionId() {
        return this._$$conditionId;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final String getDescription() {
        return this._$$description;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final long getGiftCount() {
        return this._$$giftCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final long getMinFansLevel() {
        return this._$$minFansLevel;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final long getNeedDiamondCount() {
        return this._$$needDiamondCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final int getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.profit.lottery.h
    public final int getType() {
        return this._$$type;
    }

    public ILotteryConditionFlexImpl(am3.g r100) {
        super(h.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this._$$minFansLevel = r100.j();
        goto L3
    L9:
        this._$$needDiamondCount = r100.j();
        goto L3
    L10:
        this._$$giftName = am3.h.c(r100);
        goto L3
    L11:
        this._$$giftCount = r100.j();
        goto L3
    L12:
        this._$$giftId = r100.j();
        goto L3
    L13:
        this._$$description = am3.h.c(r100);
        goto L3
    L14:
        this._$$status = r100.i();
        goto L3
    L15:
        this._$$content = am3.h.c(r100);
        goto L3
    L16:
        this._$$type = r100.i();
        goto L3
    L17:
        this._$$conditionId = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$content != null) goto L22;
        this._$$content = "";
    L22:
        if (this._$$description != null) goto L25;
        this._$$description = "";
    L25:
        if (this._$$giftName != null) goto L52;
        this._$$giftName = "";
        return;
    }
}
