package com.android.ttcjpaysdk.base.network;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/network/ICJPayTTNetCallback;", "Lcom/android/ttcjpaysdk/base/network/ICJPayCallback;", "Lorg/json/JSONObject;", "json", "Lte4/b;", "response", "", "onResponse", "base-context_release"}, k = 1, mv = {1, 6, 0})
public interface ICJPayTTNetCallback extends ICJPayCallback {
    void onResponse(JSONObject r100, te4.b r101);
}
