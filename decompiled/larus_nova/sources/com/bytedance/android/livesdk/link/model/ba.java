package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R>\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR6\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ba;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLikeToScore", "()Ljava/util/Map;", "setLikeToScore", "(Ljava/util/Map;)V", "getLikeToScore$annotations", "()V", "likeToScore", "", "getCommentToScore", "setCommentToScore", "getCommentToScore$annotations", "commentToScore", "", "Lcom/bytedance/android/livesdk/link/model/ea;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getGiftEvalList", "()Ljava/util/List;", "setGiftEvalList", "(Ljava/util/List;)V", "getGiftEvalList$annotations", "giftEvalList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ba extends vh7.c<ba> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "comment_to_score")
    Map<String, Long> getCommentToScore();

    @FieldName(name = "gift_eval_list")
    List<ea> getGiftEvalList();

    @FieldName(name = "like_to_score")
    Map<Long, Long> getLikeToScore();

    @FieldName(name = "comment_to_score#setter")
    void setCommentToScore(Map<String, Long> r100);

    @FieldName(name = "gift_eval_list#setter")
    void setGiftEvalList(List<? extends ea> r100);

    @FieldName(name = "like_to_score#setter")
    void setLikeToScore(Map<Long, Long> r100);
}
