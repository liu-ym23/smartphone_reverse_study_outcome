package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006RB\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "Lvh7/c;", "", "getOneStepPay", "()J", "setOneStepPay", "(J)V", "getOneStepPay$annotations", "()V", "oneStepPay", "getBatchQueryInfo", "setBatchQueryInfo", "getBatchQueryInfo$annotations", "batchQueryInfo", "", "Lcom/bytedance/android/livesdkapi/depend/model/IDiamondRenderDataInfo;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRenderDataMap", "()Ljava/util/Map;", "setRenderDataMap", "(Ljava/util/Map;)V", "getRenderDataMap$annotations", "renderDataMap", "", "getCustomOneStepPay", "()I", "setCustomOneStepPay", "(I)V", "getCustomOneStepPay$annotations", "customOneStepPay", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPrePayCashierInfo extends c<IPrePayCashierInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "need_batch_query_cashier_info")
        public static /* synthetic */ void getBatchQueryInfo$annotations() {
        }

        @FieldName(name = "support_custom_one_step_pay")
        public static /* synthetic */ void getCustomOneStepPay$annotations() {
        }

        @FieldName(name = "support_one_step_pay")
        public static /* synthetic */ void getOneStepPay$annotations() {
        }

        @FieldName(name = "render_data_map")
        public static /* synthetic */ void getRenderDataMap$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "need_batch_query_cashier_info")
    long getBatchQueryInfo();

    @FieldName(name = "support_custom_one_step_pay")
    int getCustomOneStepPay();

    @FieldName(name = "support_one_step_pay")
    long getOneStepPay();

    @FieldName(name = "render_data_map")
    Map<Long, IDiamondRenderDataInfo> getRenderDataMap();

    @FieldName(name = "need_batch_query_cashier_info#setter")
    void setBatchQueryInfo(long r100);

    @FieldName(name = "support_custom_one_step_pay#setter")
    void setCustomOneStepPay(int r100);

    @FieldName(name = "support_one_step_pay#setter")
    void setOneStepPay(long r100);

    @FieldName(name = "render_data_map#setter")
    void setRenderDataMap(Map<Long, ? extends IDiamondRenderDataInfo> r100);
}
