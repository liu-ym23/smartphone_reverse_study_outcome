package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.fansclub.GetFansclubHomepageResult.Data.FansclubInfoHomePage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u000fR\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u000fR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u000fR#\u0010%\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010$R\u001d\u0010(\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePage;", "", "clubName$delegate", "Ljava/lang/Object;", "getClubName", "()Ljava/lang/String;", "clubName", "anchorName$delegate", "getAnchorName", "anchorName", "", "activeFansCount$delegate", "getActiveFansCount", "()Ljava/lang/Long;", "activeFansCount", "totalFansCount$delegate", "getTotalFansCount", "totalFansCount", "popularityRankHour$delegate", "getPopularityRankHour", "popularityRankHour", "incomeRatio$delegate", "getIncomeRatio", "incomeRatio", "numOfFansGroup$delegate", "getNumOfFansGroup", "numOfFansGroup", "maxLevel$delegate", "getMaxLevel", "maxLevel", "", "Lcom/bytedance/android/live/profit/fansclub/backend/IActivityCardFlexImpl;", "activityCards$delegate", "getActivityCards", "()Ljava/util/List;", "activityCards", "homepageSchema$delegate", "getHomepageSchema", "homepageSchema", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IFansclubInfoHomePageFlexImpl extends FlexModelBase<IFansclubInfoHomePage> implements IFansclubInfoHomePage, h {

    @SerializedName("active_fans_count")
    protected Long _$$activeFansCount;

    @SerializedName("activity_cards")
    protected List<IActivityCardFlexImpl> _$$activityCards;

    @SerializedName("anchor_name")
    protected String _$$anchorName;

    @SerializedName("club_name")
    protected String _$$clubName;

    @SerializedName("homepage_schema")
    protected String _$$homepageSchema;

    @SerializedName("income_ratio")
    protected String _$$incomeRatio;

    @SerializedName("max_level")
    protected Long _$$maxLevel;

    @SerializedName("num_of_fans_group")
    protected Long _$$numOfFansGroup;

    @SerializedName("popularity_rank_hour")
    protected Long _$$popularityRankHour;

    @SerializedName("total_fans_count")
    protected Long _$$totalFansCount;

    public IFansclubInfoHomePageFlexImpl() {
        super(IFansclubInfoHomePage.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final Long getActiveFansCount() {
        return this._$$activeFansCount;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final List<IActivityCardFlexImpl> getActivityCards() {
        return this._$$activityCards;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final String getAnchorName() {
        return this._$$anchorName;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final String getClubName() {
        return this._$$clubName;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final String getHomepageSchema() {
        return this._$$homepageSchema;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final String getIncomeRatio() {
        return this._$$incomeRatio;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final Long getMaxLevel() {
        return this._$$maxLevel;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final Long getNumOfFansGroup() {
        return this._$$numOfFansGroup;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final Long getPopularityRankHour() {
        return this._$$popularityRankHour;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage
    public final Long getTotalFansCount() {
        return this._$$totalFansCount;
    }

    public IFansclubInfoHomePageFlexImpl(g r100) {
        super(IFansclubInfoHomePage.class);
        this._$$activityCards = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L7;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this._$$homepageSchema = am3.h.c(r100);
        goto L3
    L9:
        this._$$activityCards.add(new IActivityCardFlexImpl(r100));
        goto L3
    L10:
        this._$$maxLevel = Long.valueOf(r100.j());
        goto L3
    L11:
        this._$$numOfFansGroup = Long.valueOf(r100.j());
        goto L3
    L12:
        this._$$incomeRatio = am3.h.c(r100);
        goto L3
    L13:
        this._$$popularityRankHour = Long.valueOf(r100.j());
        goto L3
    L14:
        this._$$totalFansCount = Long.valueOf(r100.j());
        goto L3
    L15:
        this._$$activeFansCount = Long.valueOf(r100.j());
        goto L3
    L16:
        this._$$anchorName = am3.h.c(r100);
        goto L3
    L17:
        this._$$clubName = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
