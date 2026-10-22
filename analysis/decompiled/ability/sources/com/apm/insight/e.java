package com.apm.insight;

import android.content.Context;
import android.text.TextUtils;
import e2.C1404a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e implements ICommonParams {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2157a;
    public final /* synthetic */ MonitorCrash b;

    public e(f fVar, MonitorCrash monitorCrash) {
        this.f2157a = fVar;
        this.b = monitorCrash;
    }

    @Override // com.apm.insight.ICommonParams
    public final Map getCommonParams() {
        JSONObject jSONObjectD = this.f2157a.d(false);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObjectD.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObjectD.opt(next));
        }
        return map;
    }

    @Override // com.apm.insight.ICommonParams
    public final String getDeviceId() {
        String deviceId = this.b.mConfig.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        Context context = g.f2160a;
        try {
            C1404a c1404aC = C1404a.c(g.a().s());
            return c1404aC != null ? c1404aC.b() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.apm.insight.ICommonParams
    public final List getPatchInfo() {
        return null;
    }

    @Override // com.apm.insight.ICommonParams
    public final Map getPluginInfo() {
        return null;
    }

    @Override // com.apm.insight.ICommonParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.apm.insight.ICommonParams
    public final long getUserId() {
        return 0L;
    }
}
