package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u0013\u001a\u00060\fj\u0002`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/vote/transfer/a;", "Lvh7/c;", "", "Lcom/bytedance/android/live/profit/vote/model/a;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMVotes", "()Ljava/util/List;", "setMVotes", "(Ljava/util/List;)V", "getMVotes$annotations", "()V", "mVotes", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getMVoteType", "()J", "setMVoteType", "(J)V", "getMVoteType$annotations", "mVoteType", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.transfer.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1371a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "vote_type")
    long getMVoteType();

    @FieldName(name = "votes")
    List<com.bytedance.android.live.profit.vote.model.a> getMVotes();

    @FieldName(name = "vote_type#setter")
    void setMVoteType(long r100);

    @FieldName(name = "votes#setter")
    void setMVotes(List<? extends com.bytedance.android.live.profit.vote.model.a> r100);
}
