package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "Lvh7/c;", "", "getFirstHalfGoal", "()Ljava/lang/String;", "setFirstHalfGoal", "(Ljava/lang/String;)V", "getFirstHalfGoal$annotations", "()V", "firstHalfGoal", "getSecondHalfGoal", "setSecondHalfGoal", "getSecondHalfGoal$annotations", "secondHalfGoal", "getOvertime", "setOvertime", "getOvertime$annotations", "overtime", "getShots", "setShots", "getShots$annotations", "shots", "getTotal", "setTotal", "getTotal$annotations", "total", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGoalStageDetail extends c<IGoalStageDetail> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "first_half_goal")
        public static /* synthetic */ void getFirstHalfGoal$annotations() {
        }

        @FieldName(name = "overtime")
        public static /* synthetic */ void getOvertime$annotations() {
        }

        @FieldName(name = "second_half_goal")
        public static /* synthetic */ void getSecondHalfGoal$annotations() {
        }

        @FieldName(name = "shots")
        public static /* synthetic */ void getShots$annotations() {
        }

        @FieldName(name = "total")
        public static /* synthetic */ void getTotal$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "first_half_goal")
    String getFirstHalfGoal();

    @FieldName(name = "overtime")
    String getOvertime();

    @FieldName(name = "second_half_goal")
    String getSecondHalfGoal();

    @FieldName(name = "shots")
    String getShots();

    @FieldName(name = "total")
    String getTotal();

    @FieldName(name = "first_half_goal#setter")
    void setFirstHalfGoal(String r100);

    @FieldName(name = "overtime#setter")
    void setOvertime(String r100);

    @FieldName(name = "second_half_goal#setter")
    void setSecondHalfGoal(String r100);

    @FieldName(name = "shots#setter")
    void setShots(String r100);

    @FieldName(name = "total#setter")
    void setTotal(String r100);
}
