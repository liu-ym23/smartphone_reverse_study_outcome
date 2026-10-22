package com.bytedance.android.live.profit.vote.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010!\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010%\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\"\u0010)\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\b\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/a;", "Lvh7/c;", "", "getVoteId", "()Ljava/lang/String;", "setVoteId", "(Ljava/lang/String;)V", "getVoteId$annotations", "()V", "voteId", "", "Lcom/bytedance/android/live/profit/vote/a;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getVoteItems", "()Ljava/util/List;", "setVoteItems", "(Ljava/util/List;)V", "getVoteItems$annotations", "voteItems", "", "getFinishTime", "()J", "setFinishTime", "(J)V", "getFinishTime$annotations", "finishTime", "getCurrentTime", "setCurrentTime", "getCurrentTime$annotations", "currentTime", "getStatus", "setStatus", "getStatus$annotations", "status", "getVoteType", "setVoteType", "getVoteType$annotations", "voteType", "getUserCount", "setUserCount", "getUserCount$annotations", "userCount", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.model.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1369a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "current_time")
    long getCurrentTime();

    @FieldName(name = "finish_time")
    long getFinishTime();

    @FieldName(name = "status")
    long getStatus();

    @FieldName(name = "user_count")
    long getUserCount();

    @FieldName(name = "vote_id")
    String getVoteId();

    @FieldName(name = "results")
    List<com.bytedance.android.live.profit.vote.a> getVoteItems();

    @FieldName(name = "vote_type")
    long getVoteType();

    @FieldName(name = "current_time#setter")
    void setCurrentTime(long r100);

    @FieldName(name = "finish_time#setter")
    void setFinishTime(long r100);

    @FieldName(name = "status#setter")
    void setStatus(long r100);

    @FieldName(name = "user_count#setter")
    void setUserCount(long r100);

    @FieldName(name = "vote_id#setter")
    void setVoteId(String r100);

    @FieldName(name = "results#setter")
    void setVoteItems(List<? extends com.bytedance.android.live.profit.vote.a> r100);

    @FieldName(name = "vote_type#setter")
    void setVoteType(long r100);
}
