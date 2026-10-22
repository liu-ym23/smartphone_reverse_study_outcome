package com.bytedance.android.ec.model.abscontainer;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/model/abscontainer/ISkuBuySchemaModel;", "Lcom/bytedance/android/ec/model/abscontainer/ISchemaModel;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public interface ISkuBuySchemaModel extends ISchemaModel {
    String getFixEntranceInfoStr();

    Map<String, Object> getMegaObject();

    Map<String, String> getSimplifyQueryParams();

    Map<String, Object> getSkuLogData();

    void putValueInSkuLogData(String r100, Object r101);

    void setFixEntranceInfoStr(String r100);

    Map<String, Object> skuBuyTimestamp();
}
