package com.bytedance.android.live.saas.middleware.middlelayer;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qm0.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/AppLogServiceImpl;", "Lqm0/a;", "", "eventName", "", "map", "", "logV3", "", "needDropEventBySampling", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class AppLogServiceImpl implements a {
    public AppLogServiceImpl() {
    }

    @Override // qm0.a
    public boolean needDropEventBySampling(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return false;
    }

    @Override // qm0.a
    public void logV3(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L13
        if (r101 == null) goto L9;
        Iterator<String> r103 = r101.keySet().iterator();     // Catch: JSONException -> L13
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();     // Catch: JSONException -> L13
        r102.put(r104, r101.get(r104));     // Catch: JSONException -> L13
    L9:
        IAppLog r105 = BDLiveSdk.appLog();     // Catch: JSONException -> L13
        if (r105 == null) goto L21;
        r105.onEventV3(r100, r102);     // Catch: JSONException -> L13
        return;
    L21:
        return;
    L13:
        e = move-exception;
        ILogProtocol r106 = BDLiveSdk.getALog();
        if (r106 == null) goto L22;
        r106.e("AppLogServiceImpl#logV3", e);
        return;
    }
}
