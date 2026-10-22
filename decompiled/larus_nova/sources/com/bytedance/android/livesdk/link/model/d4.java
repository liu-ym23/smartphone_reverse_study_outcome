package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u001a\u001a\u00060\u0013j\u0002`\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/d4;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/c9;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getScoreElements", "()Ljava/util/List;", "setScoreElements", "(Ljava/util/List;)V", "getScoreElements$annotations", "()V", "scoreElements", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName$annotations", "name", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getDuration", "()J", "setDuration", "(J)V", "getDuration$annotations", "duration", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d4 extends vh7.c<d4> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "score_elements")
    List<c9> getScoreElements();

    @FieldName(name = "duration#setter")
    void setDuration(long r100);

    @FieldName(name = "name#setter")
    void setName(String r100);

    @FieldName(name = "score_elements#setter")
    void setScoreElements(List<? extends c9> r100);
}
