package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/m3;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/m3$b;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getStages", "()Ljava/util/List;", "getStages$annotations", "()V", "stages", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getMvpImage", "()Lpy/k;", "getMvpImage$annotations", "mvpImage", "", "getHighScoreThreshold", "()J", "getHighScoreThreshold$annotations", "highScoreThreshold", "b", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m3 extends vh7.c<m3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/m3$b;", "Lvh7/c;", "", "getTargetScore", "()J", "getTargetScore$annotations", "()V", "targetScore", "", "getEndAnimationUrl", "()Ljava/lang/String;", "getEndAnimationUrl$annotations", "endAnimationUrl", "getEndAtmosphereUrl", "getEndAtmosphereUrl$annotations", "endAtmosphereUrl", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "end_animation_url")
        String getEndAnimationUrl();

        @FieldName(name = "end_atmosphere_url")
        String getEndAtmosphereUrl();

        @FieldName(name = "target_score")
        long getTargetScore();
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "high_score_threshold")
    long getHighScoreThreshold();

    @FieldName(name = "mvp_image")
    py.k getMvpImage();

    @FieldName(name = "stages")
    List<b> getStages();
}
