package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends DispatchStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7480d = "d";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f7481c;

    static {
    }

    public d(JSONObject r10) {
        super(DispatchStrategy.DispatchStrategyType.STATIC_DISPATCH_STRATEGY);
        this.f7481c = new HashMap();
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<String> r11 = r10.keys();
    L7:
        if (r11.hasNext() == false) goto L13;
        String r12 = r11.next();
        String r13 = r10.optString(r12);
        if (TextUtils.isEmpty(r12) == true) goto L7;
        if (TextUtils.isEmpty(r13) == true) goto L7;
        this.f7481c.put(r12, r13);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String c(Uri r10) {
        String r11 = r10.getHost();
        String r12 = r10.toString();
        String r13 = (String) this.f7481c.get(r11);
        if (TextUtils.isEmpty(r13) == true) goto L6;
        Logger.d(f7480d, "replace host " + r13 + " for " + r11);
        return r12.replaceFirst(r11, r13);
    L6:
        return r12;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean d() {
        return false;
    }
}
