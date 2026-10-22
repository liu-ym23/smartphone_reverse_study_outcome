package com.bytedance.android.ec.common.api.marketing;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/api/marketing/IMarketingRouterUtilsService;", "", "getMegaObject", "Lorg/json/JSONObject;", "megaObjectId", "", "setMegaObject", "", "megaObject", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IMarketingRouterUtilsService {
    JSONObject getMegaObject(String r100);

    void setMegaObject(String r100, JSONObject r101);
}
