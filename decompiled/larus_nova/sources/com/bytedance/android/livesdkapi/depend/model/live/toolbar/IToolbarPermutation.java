package com.bytedance.android.livesdkapi.depend.model.live.toolbar;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R6\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarPermutation;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarPermutationRule;", "getVertical", "()Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarPermutationRule;", "getVertical$annotations", "()V", "vertical", "getLandscape", "getLandscape$annotations", "landscape", "getGeneral", "getGeneral$annotations", "general", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getDemandList", "()Ljava/util/List;", "setDemandList", "(Ljava/util/List;)V", "getDemandList$annotations", "demandList", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IBlockComponent;", "getBlockList", "getBlockList$annotations", "blockList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IToolbarPermutation extends c<IToolbarPermutation> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "block_component_list")
        public static /* synthetic */ void getBlockList$annotations() {
        }

        @FieldName(name = "on_demand_component_list")
        public static /* synthetic */ void getDemandList$annotations() {
        }

        @FieldName(name = "general")
        public static /* synthetic */ void getGeneral$annotations() {
        }

        @FieldName(name = "landscape")
        public static /* synthetic */ void getLandscape$annotations() {
        }

        @FieldName(name = "vertical")
        public static /* synthetic */ void getVertical$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "block_component_list")
    List<IBlockComponent> getBlockList();

    @FieldName(name = "on_demand_component_list")
    List<Integer> getDemandList();

    @FieldName(name = "general")
    IToolbarPermutationRule getGeneral();

    @FieldName(name = "landscape")
    IToolbarPermutationRule getLandscape();

    @FieldName(name = "vertical")
    IToolbarPermutationRule getVertical();

    @FieldName(name = "on_demand_component_list#setter")
    void setDemandList(List<Integer> r100);
}
