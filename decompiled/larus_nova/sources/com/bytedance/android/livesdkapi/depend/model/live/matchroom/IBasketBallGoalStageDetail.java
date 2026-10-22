package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001c\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R\"\u0010\u0019\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006R\"\u0010\u001d\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "Lvh7/c;", "", "getFirst_period", "()I", "setFirst_period", "(I)V", "getFirst_period$annotations", "()V", "first_period", "getSecond_period", "setSecond_period", "getSecond_period$annotations", "second_period", "getThird_period", "setThird_period", "getThird_period$annotations", "third_period", "getForth_period", "setForth_period", "getForth_period$annotations", "forth_period", "getOvertime", "setOvertime", "getOvertime$annotations", "overtime", "getTotal", "setTotal", "getTotal$annotations", "total", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBasketBallGoalStageDetail extends c<IBasketBallGoalStageDetail> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "first_period")
        public static /* synthetic */ void getFirst_period$annotations() {
        }

        @FieldName(name = "forth_period")
        public static /* synthetic */ void getForth_period$annotations() {
        }

        @FieldName(name = "overtime")
        public static /* synthetic */ void getOvertime$annotations() {
        }

        @FieldName(name = "second_period")
        public static /* synthetic */ void getSecond_period$annotations() {
        }

        @FieldName(name = "third_period")
        public static /* synthetic */ void getThird_period$annotations() {
        }

        @FieldName(name = "total")
        public static /* synthetic */ void getTotal$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "first_period")
    int getFirst_period();

    @FieldName(name = "forth_period")
    int getForth_period();

    @FieldName(name = "overtime")
    int getOvertime();

    @FieldName(name = "second_period")
    int getSecond_period();

    @FieldName(name = "third_period")
    int getThird_period();

    @FieldName(name = "total")
    int getTotal();

    @FieldName(name = "first_period#setter")
    void setFirst_period(int r100);

    @FieldName(name = "forth_period#setter")
    void setForth_period(int r100);

    @FieldName(name = "overtime#setter")
    void setOvertime(int r100);

    @FieldName(name = "second_period#setter")
    void setSecond_period(int r100);

    @FieldName(name = "third_period#setter")
    void setThird_period(int r100);

    @FieldName(name = "total#setter")
    void setTotal(int r100);
}
