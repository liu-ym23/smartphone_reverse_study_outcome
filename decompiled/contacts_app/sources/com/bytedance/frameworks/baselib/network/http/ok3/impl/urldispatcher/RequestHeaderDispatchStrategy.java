package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RequestHeaderDispatchStrategy extends DispatchStrategy {
    private static final String TAG = "RequestHeaderDispatchStrategy";
    private Map<String, String> mAddHeaderMap;

    static {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String r1, boolean r2, int r3) {
    }

    public RequestHeaderDispatchStrategy(JSONObject r5) {
        super(DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY);
        this.mAddHeaderMap = new HashMap();
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.keys();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mAddHeaderMap.put(r1, r2);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri r1) {
        return r1.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest r5) {
        if (r5.getHeaders() == null) goto L8;
        Iterator<Map.Entry<String, String>> r4 = this.mAddHeaderMap.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r4.next();
        r5.getHeaders().add(new Header(r0.getKey(), r0.getValue()));
        goto L6
    L10:
        return;
    }
}
