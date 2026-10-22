package com.android.ttcjpaysdk.base.h5.jsb;

import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/jsb/ICJPayH5ActivityMethod;", "", "getMegaJSONObjectMap", "Ljava/util/HashMap;", "", "Lorg/json/JSONObject;", "getUrl", "isHybridkitKernel", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayH5ActivityMethod {
    HashMap<String, JSONObject> getMegaJSONObjectMap();

    String getUrl();

    boolean isHybridkitKernel();
}
