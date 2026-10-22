package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0007R\"\u0010\u001e\u001a\u00020\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\t\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00100\u001a\u00020\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\t\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\"\u00107\u001a\u0002018&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\t\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010;\u001a\u00020\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\t\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cR\"\u0010?\u001a\u00020\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\t\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001c¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/a1;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getPlayerInfo", "()Ljava/util/List;", "setPlayerInfo", "(Ljava/util/List;)V", "getPlayerInfo$annotations", "()V", "playerInfo", "getFriends", "setFriends", "getFriends$annotations", "friends", "getAiGuests", "setAiGuests", "getAiGuests$annotations", "aiGuests", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "getLockedPositions", "setLockedPositions", "getLockedPositions$annotations", "lockedPositions", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getHasMore$annotations", "hasMore", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "getTotalCount$annotations", "totalCount", "", "getNextCursor", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "getNextCursor$annotations", "nextCursor", "getNow", "setNow", "getNow$annotations", TriggerTiming.NOW, "", "getSortStrategy", "()I", "setSortStrategy", "(I)V", "getSortStrategy$annotations", "sortStrategy", "getShowPaidLinkGuide", "setShowPaidLinkGuide", "getShowPaidLinkGuide$annotations", "showPaidLinkGuide", "getHasPreApply", "setHasPreApply", "getHasPreApply$annotations", "hasPreApply", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a1 extends vh7.c<a1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ai_guest")
    List<ILinkPlayerInfoBridge> getAiGuests();

    @FieldName(name = "friends")
    List<ILinkPlayerInfoBridge> getFriends();

    @FieldName(name = "has_more")
    boolean getHasMore();

    @FieldName(name = "has_prepare_apply")
    boolean getHasPreApply();

    @FieldName(name = "locked_positions")
    List<LinkmicPositionItem> getLockedPositions();

    @FieldName(name = "next_cursor")
    String getNextCursor();

    @FieldName(name = TriggerTiming.NOW)
    long getNow();

    @FieldName(name = "user")
    List<ILinkPlayerInfoBridge> getPlayerInfo();

    @FieldName(name = "show_paid_linkmic_guide")
    boolean getShowPaidLinkGuide();

    @FieldName(name = "sort_strategy")
    int getSortStrategy();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    long getTotalCount();

    @FieldName(name = "ai_guest#setter")
    void setAiGuests(List<? extends ILinkPlayerInfoBridge> r100);

    @FieldName(name = "friends#setter")
    void setFriends(List<? extends ILinkPlayerInfoBridge> r100);

    @FieldName(name = "has_more#setter")
    void setHasMore(boolean r100);

    @FieldName(name = "has_prepare_apply#setter")
    void setHasPreApply(boolean r100);

    @FieldName(name = "locked_positions#setter")
    void setLockedPositions(List<? extends LinkmicPositionItem> r100);

    @FieldName(name = "next_cursor#setter")
    void setNextCursor(String r100);

    @FieldName(name = "now#setter")
    void setNow(long r100);

    @FieldName(name = "user#setter")
    void setPlayerInfo(List<? extends ILinkPlayerInfoBridge> r100);

    @FieldName(name = "show_paid_linkmic_guide#setter")
    void setShowPaidLinkGuide(boolean r100);

    @FieldName(name = "sort_strategy#setter")
    void setSortStrategy(int r100);

    @FieldName(name = "total_count#setter")
    void setTotalCount(long r100);
}
