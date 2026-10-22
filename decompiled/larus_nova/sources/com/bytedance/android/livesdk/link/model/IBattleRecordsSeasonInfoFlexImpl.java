package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.BattleRecord.SeasonInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRecordsSeasonInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h2;", "Lpy/k;", "rankBadge", "Lpy/k;", "getRankBadge", "()Lpy/k;", "setRankBadge", "(Lpy/k;)V", "", "rankDetail$delegate", "Ljava/lang/Object;", "getRankDetail", "()Ljava/lang/String;", "rankDetail", "scheme$delegate", "getScheme", "scheme", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRecordsSeasonInfoFlexImpl extends FlexModelBase<h2> implements h2, vh7.h {

    @SerializedName("cur_rank_detail")
    protected String _$$rankDetail;

    @SerializedName("delta_detail_scheme")
    protected String _$$scheme;

    @SerializedName("rank_badge")
    protected py.k rankBadge;

    public IBattleRecordsSeasonInfoFlexImpl() {
        super(h2.class);
        this._$$rankDetail = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IBattleRecordsSeasonInfoFlexImpl(am3.g r100) {
        super(h2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$rankDetail = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rankBadge = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$scheme = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$rankDetail != null) goto L31;
        this._$$rankDetail = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.h2
    public py.k getRankBadge() {
        return this.rankBadge;
    }

    @Override // com.bytedance.android.livesdk.link.model.h2
    public final String getRankDetail() {
        return this._$$rankDetail;
    }

    @Override // com.bytedance.android.livesdk.link.model.h2
    public final String getScheme() {
        return this._$$scheme;
    }

    public void setRankBadge(py.k r100) {
        this.rankBadge = r100;
    }
}
