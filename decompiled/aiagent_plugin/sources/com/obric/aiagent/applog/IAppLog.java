package com.obric.aiagent.applog;

import android.os.Bundle;
import com.bytedance.applog.h;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: IAppLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAppLog {
    void awaitFlowDid(d.h.a.b<? super String, x> r1);

    String getFlowDid();

    void init(a r1);

    h inst();

    void report(String r1, Bundle r2);

    void report(String r1, JSONObject r2);

    void reportToFlow(String r1, Bundle r2);

    void reportToFlow(String r1, JSONObject r2);
}
