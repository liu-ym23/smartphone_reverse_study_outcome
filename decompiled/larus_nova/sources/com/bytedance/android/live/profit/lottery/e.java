package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b#\u0010$R\u001a\u0010)\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b'\u0010\u0015¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/e;", "Lvh7/c;", "Lcom/bytedance/android/live/profit/lottery/q;", "getUserCondition", "()Lcom/bytedance/android/live/profit/lottery/q;", "getUserCondition$annotations", "()V", "userCondition", "Lcom/bytedance/android/live/profit/lottery/k;", "getLotteryInfo", "()Lcom/bytedance/android/live/profit/lottery/k;", "getLotteryInfo$annotations", "lotteryInfo", "", "Lcom/bytedance/android/live/profit/lottery/d;", "getCandidateUsers", "()Ljava/util/List;", "getCandidateUsers$annotations", "candidateUsers", "", "getHitBlackList", "()Z", "getHitBlackList$annotations", "hitBlackList", "", "getCandidateUserNum", "()J", "getCandidateUserNum$annotations", "candidateUserNum", "Lcom/bytedance/android/live/profit/lottery/m;", "getUserLuckyInfo", "()Lcom/bytedance/android/live/profit/lottery/m;", "getUserLuckyInfo$annotations", "userLuckyInfo", "Lcom/bytedance/android/live/profit/lottery/j;", "getGiftGuide", "()Lcom/bytedance/android/live/profit/lottery/j;", "getGiftGuide$annotations", "giftGuide", "getHasWishGift", "getHasWishGift$annotations", "hasWishGift", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface e extends vh7.c<e> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "candidate_user_num")
    long getCandidateUserNum();

    @FieldName(name = "candidate_users")
    List<d> getCandidateUsers();

    @FieldName(name = "gift_guide")
    j getGiftGuide();

    @FieldName(name = "has_wish_gift")
    boolean getHasWishGift();

    @FieldName(name = "hit_black_list")
    boolean getHitBlackList();

    @FieldName(name = "lottery_info")
    k getLotteryInfo();

    @FieldName(name = "user_condition")
    q getUserCondition();

    @FieldName(name = "user_lucky_info")
    m getUserLuckyInfo();
}
