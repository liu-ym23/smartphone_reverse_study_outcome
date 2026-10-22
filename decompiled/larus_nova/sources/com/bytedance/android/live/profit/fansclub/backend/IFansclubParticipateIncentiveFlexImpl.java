package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.FansclubParticipateIncentive")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentiveFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentive;", "", "goldCoinsCount$delegate", "Ljava/lang/Object;", "getGoldCoinsCount", "()Ljava/lang/Long;", "goldCoinsCount", "", "awardUnit$delegate", "getAwardUnit", "()Ljava/lang/String;", "awardUnit", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IFansclubParticipateIncentiveFlexImpl extends FlexModelBase<IFansclubParticipateIncentive> implements IFansclubParticipateIncentive, h {

    @SerializedName("award_unit")
    protected String _$$awardUnit;

    @SerializedName("gold_coins_count")
    protected Long _$$goldCoinsCount;

    public IFansclubParticipateIncentiveFlexImpl() {
        super(IFansclubParticipateIncentive.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive
    public final String getAwardUnit() {
        return this._$$awardUnit;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive
    public final Long getGoldCoinsCount() {
        return this._$$goldCoinsCount;
    }

    public IFansclubParticipateIncentiveFlexImpl(g r100) {
        super(IFansclubParticipateIncentive.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$goldCoinsCount = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$awardUnit = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
