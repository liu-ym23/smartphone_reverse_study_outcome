package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y2;", "Lvh7/c;", "", "getGrade", "()Ljava/lang/String;", "getGrade$annotations", "()V", "grade", "", "getLevel", "()J", "getLevel$annotations", "level", "getStarCount", "getStarCount$annotations", "starCount", "getTargetStarCount", "getTargetStarCount$annotations", "targetStarCount", "Lcom/bytedance/android/livesdk/link/model/a3;", "getGradeMedal", "()Lcom/bytedance/android/livesdk/link/model/a3;", "getGradeMedal$annotations", "gradeMedal", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y2 extends vh7.c<y2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "grade")
    String getGrade();

    @FieldName(name = "star_activity_grade_medal")
    a3 getGradeMedal();

    @FieldName(name = "level")
    long getLevel();

    @FieldName(name = "star_count")
    long getStarCount();

    @FieldName(name = "target_star_count")
    long getTargetStarCount();
}
