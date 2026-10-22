package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketballStage;", "Lvh7/c;", "", "getCurrentStage", "()I", "setCurrentStage", "(I)V", "getCurrentStage$annotations", "()V", "currentStage", "getFinalStage", "setFinalStage", "getFinalStage$annotations", "finalStage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBasketballStage extends c<IBasketballStage> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "current_stage")
        public static /* synthetic */ void getCurrentStage$annotations() {
        }

        @FieldName(name = "final_stage")
        public static /* synthetic */ void getFinalStage$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "current_stage")
    int getCurrentStage();

    @FieldName(name = "final_stage")
    int getFinalStage();

    @FieldName(name = "current_stage#setter")
    void setCurrentStage(int r100);

    @FieldName(name = "final_stage#setter")
    void setFinalStage(int r100);
}
