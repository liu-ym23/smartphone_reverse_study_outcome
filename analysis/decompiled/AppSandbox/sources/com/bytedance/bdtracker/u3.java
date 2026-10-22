package com.bytedance.bdtracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import stepos.com.android.os.StatsLogEnums;

/* loaded from: classes.dex */
public class u3 implements Handler.Callback {
    public final e0 a;
    public final Handler b;
    public final Map<String, b> c = new HashMap();
    public final Set<String> d = new HashSet();
    public String e = "";

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ Set a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(u3 u3Var, Set set, String str, boolean z) {
            this.a = set;
            this.b = str;
            this.c = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("$$APP_ID", this.b);
                jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                jSONObject.put("$$UPLOAD_STATUS", this.c ? "success" : "failed");
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static class b {
        public String a;
        public JSONObject b;

        public b(String str, JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        public String toString() {
            StringBuilder sbA = com.bytedance.bdtracker.a.a("ProfileDataWrapper{apiName='");
            sbA.append(this.a);
            sbA.append('\'');
            sbA.append(", jsonObject=");
            sbA.append(this.b);
            sbA.append('}');
            return sbA.toString();
        }
    }

    public u3(e0 e0Var) {
        this.a = e0Var;
        StringBuilder sbA = com.bytedance.bdtracker.a.a("bd_tracker_profile:");
        sbA.append(e0Var.d.m);
        HandlerThread handlerThread = new HandlerThread(sbA.toString());
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(b bVar) {
        if (this.a == null) {
            return;
        }
        StringBuilder sbA = com.bytedance.bdtracker.a.a("__profile_");
        sbA.append(bVar.a);
        p4 p4Var = new p4(sbA.toString(), bVar.b.toString());
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.a.d())) {
            e0 e0Var = this.a;
            e0Var.n.a(e0Var.d, p4Var, arrayList);
        } else {
            e0 e0Var2 = this.a;
            e0Var2.n.a(e0Var2.d, p4Var);
        }
        this.a.b(p4Var);
        arrayList.add(p4Var);
        this.a.c().c.b(arrayList);
        this.b.sendMessageDelayed(this.b.obtainMessage(StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD_VALUE), 500L);
    }

    public void a(JSONObject jSONObject) {
        a(StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_EXPLICIT_BINS_NOT_STRICTLY_ORDERED_VALUE, new b("append", jSONObject));
    }

    public void b(JSONObject jSONObject) {
        a(StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_FEW_BINS_VALUE, new b("increment", jSONObject));
    }

    public void c(JSONObject jSONObject) {
        a(100, new b("set", jSONObject));
    }

    public void d(JSONObject jSONObject) {
        a(StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE, new b("set_once", jSONObject));
    }

    public void e(JSONObject jSONObject) {
        a(StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_MANY_BINS_VALUE, new b("unset", jSONObject));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0287  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleMessage(android.os.Message r13) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.u3.handleMessage(android.os.Message):boolean");
    }

    public final void a(int i, b bVar) {
        if (this.a.d.x) {
            return;
        }
        Handler handler = this.b;
        handler.sendMessage(handler.obtainMessage(i, bVar));
    }

    public final void a(Set<String> set, boolean z) {
        if (LogUtils.isDisabled() || set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new a(this, set, this.a.d.m, z));
    }
}
