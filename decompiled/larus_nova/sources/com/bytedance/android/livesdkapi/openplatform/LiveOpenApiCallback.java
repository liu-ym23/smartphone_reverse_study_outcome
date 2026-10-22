package com.bytedance.android.livesdkapi.openplatform;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "extraInfo", "", "result", "Lorg/json/JSONObject;", "onSuccess", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveOpenApiCallback {
    void onError(String r100, JSONObject r101);

    void onSuccess(JSONObject r100);
}
