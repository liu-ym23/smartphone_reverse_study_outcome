package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0004R\u001a\u0010&\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\u0004R\u001a\u0010+\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001a\u0004\b(\u0010)R\u001a\u0010.\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0006\u001a\u0004\b,\u0010\u0004R\u001a\u00101\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b/\u0010\u0004R\u001a\u00104\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b2\u0010\u0004R\u001a\u00107\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0006\u001a\u0004\b5\u0010\u0004R\u001a\u0010:\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b8\u0010\u0004R\u001a\u0010=\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0006\u001a\u0004\b;\u0010\u0004R\u001a\u0010@\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0006\u001a\u0004\b>\u0010)R\u001a\u0010C\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0006\u001a\u0004\bA\u0010)R\u001a\u0010F\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0006\u001a\u0004\bD\u0010)R\u001a\u0010I\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0006\u001a\u0004\bG\u0010)R \u0010O\u001a\b\u0012\u0004\u0012\u00020K0J8&X§\u0004¢\u0006\f\u0012\u0004\bN\u0010\u0006\u001a\u0004\bL\u0010MR\u001a\u0010R\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0006\u001a\u0004\bP\u0010\u0004R\u001a\u0010U\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0006\u001a\u0004\bS\u0010\u0004R \u0010Y\u001a\b\u0012\u0004\u0012\u00020V0J8&X§\u0004¢\u0006\f\u0012\u0004\bX\u0010\u0006\u001a\u0004\bW\u0010MR\u001a\u0010\\\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0006\u001a\u0004\bZ\u0010)R\u001a\u0010_\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\b^\u0010\u0006\u001a\u0004\b]\u0010)R\u001a\u0010d\u001a\u00020`8&X§\u0004¢\u0006\f\u0012\u0004\bc\u0010\u0006\u001a\u0004\ba\u0010bR\u001a\u0010g\u001a\u00020'8&X§\u0004¢\u0006\f\u0012\u0004\bf\u0010\u0006\u001a\u0004\be\u0010)R\u001a\u0010j\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\bi\u0010\u0006\u001a\u0004\bh\u0010\nR\u001c\u0010m\u001a\u0004\u0018\u00010'8&X§\u0004¢\u0006\f\u0012\u0004\bl\u0010\u0006\u001a\u0004\bk\u0010)R\u001c\u0010p\u001a\u0004\u0018\u00010'8&X§\u0004¢\u0006\f\u0012\u0004\bo\u0010\u0006\u001a\u0004\bn\u0010)¨\u0006q"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/k;", "Lvh7/c;", "", "getLotteryId", "()J", "getLotteryId$annotations", "()V", "lotteryId", "", "getOwnerType", "()I", "getOwnerType$annotations", "ownerType", "getRoomId", "getRoomId$annotations", "roomId", "getStatus", "getStatus$annotations", "status", "Lcom/bytedance/android/live/profit/lottery/p;", "getPrizeInfo", "()Lcom/bytedance/android/live/profit/lottery/p;", "getPrizeInfo$annotations", "prizeInfo", "getPrizeCount", "getPrizeCount$annotations", "prizeCount", "getLuckyCount", "getLuckyCount$annotations", "luckyCount", "getCountDown", "getCountDown$annotations", "countDown", "getStartTime", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getDrawTime", "getDrawTime$annotations", "drawTime", "", "getExtra", "()Ljava/lang/String;", "getExtra$annotations", "extra", "getRealLuckyCount", "getRealLuckyCount$annotations", "realLuckyCount", "getTotalGrantCount", "getTotalGrantCount$annotations", "totalGrantCount", "getWithdrawCount", "getWithdrawCount$annotations", "withdrawCount", "getRealDrawTime", "getRealDrawTime$annotations", "realDrawTime", "getCurrentTime", "getCurrentTime$annotations", "currentTime", "getCandidateNum", "getCandidateNum$annotations", "candidateNum", "getLotteryIdStr", "getLotteryIdStr$annotations", "lotteryIdStr", "getRoomIdStr", "getRoomIdStr$annotations", "roomIdStr", "getOwnerUserOpenId", "getOwnerUserOpenId$annotations", "ownerUserOpenId", "getAnchorOpenId", "getAnchorOpenId$annotations", "anchorOpenId", "", "Lcom/bytedance/android/live/profit/lottery/h;", "getConditions", "()Ljava/util/List;", "getConditions$annotations", "conditions", "getOwnerUserId", "getOwnerUserId$annotations", "ownerUserId", "getAnchorId", "getAnchorId$annotations", "anchorId", "Lcom/bytedance/android/live/profit/lottery/m;", "getLuckyUsers", "getLuckyUsers$annotations", "luckyUsers", "getSecAnchorId", "getSecAnchorId$annotations", "secAnchorId", "getSecOwnerUserId", "getSecOwnerUserId$annotations", "secOwnerUserId", "", "getUseNewDrawInteraction", "()Z", "getUseNewDrawInteraction$annotations", "useNewDrawInteraction", "getLaunchTaskId", "getLaunchTaskId$annotations", "launchTaskId", "getIndex", "getIndex$annotations", "index", "getServerBizData", "getServerBizData$annotations", "serverBizData", "getUiConfig", "getUiConfig$annotations", "uiConfig", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_id")
    long getAnchorId();

    @FieldName(name = "anchor_open_id")
    String getAnchorOpenId();

    @FieldName(name = "candidate_num")
    long getCandidateNum();

    @FieldName(name = "conditions")
    List<h> getConditions();

    @FieldName(name = "count_down")
    long getCountDown();

    @FieldName(name = "current_time")
    long getCurrentTime();

    @FieldName(name = "draw_time")
    long getDrawTime();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "index")
    int getIndex();

    @FieldName(name = "launch_task_id")
    String getLaunchTaskId();

    @FieldName(name = "lottery_id")
    long getLotteryId();

    @FieldName(name = "lottery_id_str")
    String getLotteryIdStr();

    @FieldName(name = "lucky_count")
    long getLuckyCount();

    @FieldName(name = "lucky_users")
    List<m> getLuckyUsers();

    @FieldName(name = "owner_type")
    int getOwnerType();

    @FieldName(name = "owner_user_id")
    long getOwnerUserId();

    @FieldName(name = "owner_user_open_id")
    String getOwnerUserOpenId();

    @FieldName(name = "prize_count")
    long getPrizeCount();

    @FieldName(name = "prize_info")
    p getPrizeInfo();

    @FieldName(name = "real_draw_time")
    long getRealDrawTime();

    @FieldName(name = "real_lucky_count")
    long getRealLuckyCount();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "room_id_str")
    String getRoomIdStr();

    @FieldName(name = "sec_anchor_id")
    String getSecAnchorId();

    @FieldName(name = "sec_owner_user_id")
    String getSecOwnerUserId();

    @FieldName(name = "server_biz_data")
    String getServerBizData();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "total_grant_count")
    long getTotalGrantCount();

    @FieldName(name = "ui_config")
    String getUiConfig();

    @FieldName(name = "use_new_draw_interaction")
    boolean getUseNewDrawInteraction();

    @FieldName(name = "withdraw_count")
    long getWithdrawCount();
}
