package com.bytedance.android.livehostapi.business.depend.share;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/IUgShareCallback;", "", "onFailed", "", "code", "", "msg", "", "data", "onSuccess", "Lorg/json/JSONObject;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUgShareCallback {
    void onFailed(int r100, String r101, Object r102);

    void onSuccess(JSONObject r100);
}
