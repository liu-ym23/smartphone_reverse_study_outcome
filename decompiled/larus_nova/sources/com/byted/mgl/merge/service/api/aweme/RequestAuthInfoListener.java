package com.byted.mgl.merge.service.api.aweme;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/RequestAuthInfoListener;", "", "onFail", "", "errorCode", "", "errorMsg", "onSuccess", "scopeInfoMap", "Lorg/json/JSONObject;", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface RequestAuthInfoListener {
    void onFail(String r100, String r101);

    void onSuccess(JSONObject r100);
}
