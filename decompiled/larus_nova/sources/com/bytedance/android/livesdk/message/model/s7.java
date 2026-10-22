package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getMsgType", "()J", "getMsgType$annotations", "()V", "msgType", "getVoteId", "getVoteId$annotations", "voteId", "", "Lcom/bytedance/android/live/profit/vote/a;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getResults", "()Ljava/util/List;", "getResults$annotations", "results", "getFinishTime", "getFinishTime$annotations", "finishTime", "getCurrentTime", "getCurrentTime$annotations", "currentTime", "getVoteType", "getVoteType$annotations", "voteType", "", "getExtra", "()Ljava/lang/String;", "getExtra$annotations", "extra", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s7 extends vh7.c<s7>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "current_time")
    long getCurrentTime();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "finish_time")
    long getFinishTime();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    long getMsgType();

    @FieldName(name = "results")
    List<com.bytedance.android.live.profit.vote.a> getResults();

    @FieldName(name = "vote_id")
    long getVoteId();

    @FieldName(name = "vote_type")
    long getVoteType();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
