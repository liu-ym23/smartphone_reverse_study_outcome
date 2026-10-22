package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/y;", "Lvh7/c;", "", "", "getDurationList", "()Ljava/util/List;", "getDurationList$annotations", "()V", "durationList", "", "getDressId", "()Ljava/lang/String;", "getDressId$annotations", "dressId", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c0;", "getScoreInfoList", "setScoreInfoList", "(Ljava/util/List;)V", "getScoreInfoList$annotations", "scoreInfoList", "", "getRecommendScoreType", "()I", "getRecommendScoreType$annotations", "recommendScoreType", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y extends vh7.c<y> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "dress_id")
    String getDressId();

    @FieldName(name = "duration_list")
    List<Long> getDurationList();

    @FieldName(name = "recommend_score_type")
    int getRecommendScoreType();

    @FieldName(name = "score_list")
    List<c0> getScoreInfoList();

    @FieldName(name = "score_list#setter")
    void setScoreInfoList(List<? extends c0> r100);
}
