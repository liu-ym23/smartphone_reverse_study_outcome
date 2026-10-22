package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0005R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/BizContentRequestParams;", "", "()V", "params", "", "", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "toJsonString", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BizContentRequestParams {
    private Map<String, String> params;

    public BizContentRequestParams() {
    }

    public final String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put("params", new JSONObject(this.params));     // Catch: Exception -> L5
    L8:
        return r100.toString();
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BizContentRequestParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BizContentRequestParams#toJsonString", e);
        r100.put("params", "");
        goto L8
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final void setParams(Map<String, String> r100) {
        this.params = r100;
    }
}
