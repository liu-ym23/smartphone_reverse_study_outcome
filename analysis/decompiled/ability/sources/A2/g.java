package A2;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Process;
import android.os.SystemClock;
import ca.AbstractC0897f;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICommonParams;
import com.stepos.deepbinder.core.constant.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final CrashType f89a;
    public final Context b;
    public final ICommonParams c = (ICommonParams) com.apm.insight.g.a().c;
    public final e d;
    public final h e;

    public g(CrashType crashType, Context context, e eVar, h hVar) {
        this.f89a = crashType;
        this.b = context;
        this.d = eVar;
        this.e = hVar;
    }

    public n2.a a(int i, n2.a aVar) {
        int length;
        int i6;
        if (aVar == null) {
            aVar = new n2.a();
        }
        if (i == 0) {
            d(aVar);
            return aVar;
        }
        int intProperty = 0;
        if (i == 1) {
            e(aVar);
            u1.d dVar = com.apm.insight.g.h;
            CrashType crashType = this.f89a;
            List list = (List) ((HashMap) dVar.b).get(crashType);
            HashMap map = new HashMap();
            JSONObject jSONObjectOptJSONObject = aVar.f5345a.optJSONObject("custom");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                aVar.e(jSONObjectOptJSONObject, "custom");
            }
            if (list != null) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    try {
                        AttachUserData attachUserData = (AttachUserData) list.get(i10);
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        n2.a.k(jSONObjectOptJSONObject, attachUserData.getUserData(crashType));
                        map.put("custom_cost_" + attachUserData.getClass().getName() + "_" + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
                    } catch (Throwable th) {
                        n2.a.j(jSONObjectOptJSONObject, th);
                    }
                }
            }
            if (crashType != CrashType.EXIT) {
                try {
                    try {
                        length = new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
                    } catch (Throwable unused) {
                        length = -1;
                    }
                    jSONObjectOptJSONObject.put("fd_count", length);
                } catch (Throwable unused2) {
                }
            }
            List list2 = (List) ((HashMap) com.apm.insight.g.h.c).get(crashType);
            if (list2 != null) {
                JSONObject jSONObjectOptJSONObject2 = aVar.f5345a.optJSONObject("custom_long");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    aVar.e(jSONObjectOptJSONObject2, "custom_long");
                }
                while (intProperty < list2.size()) {
                    try {
                        AttachUserData attachUserData2 = (AttachUserData) list2.get(intProperty);
                        long jUptimeMillis2 = SystemClock.uptimeMillis();
                        n2.a.k(jSONObjectOptJSONObject2, attachUserData2.getUserData(crashType));
                        map.put("custom_cost_" + attachUserData2.getClass().getName() + "_" + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis2));
                    } catch (Throwable th2) {
                        n2.a.j(jSONObjectOptJSONObject2, th2);
                    }
                    intProperty++;
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                try {
                    jSONObjectOptJSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (Throwable unused3) {
                }
            }
        } else if (i == 2) {
            h hVar = this.e;
            if (hVar != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - hVar.b < 60000) {
                    i6 = hVar.f90a;
                } else {
                    Context context = com.apm.insight.g.f2160a;
                    if (context != null) {
                        try {
                            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
                            hVar.b = jCurrentTimeMillis;
                            intProperty = batteryManager.getIntProperty(4);
                        } catch (Throwable unused4) {
                        }
                    }
                    hVar.f90a = intProperty;
                    i6 = hVar.f90a;
                }
                intProperty = i6;
            }
            aVar.e(Integer.valueOf(intProperty), "battery");
            aVar.r((HashMap) com.apm.insight.g.h.d);
            aVar.f("is_harmony_os", D2.b.e() ? "1" : "0");
        } else {
            if (i == 4) {
                g(aVar);
                return aVar;
            }
            if (i == 5 && f()) {
                n2.a.l(aVar.f5345a, AbstractC0897f.e());
                return aVar;
            }
        }
        return aVar;
    }

    public n2.a b(n2.a aVar) {
        return aVar;
    }

    public final n2.a c(n2.a aVar, f fVar, boolean z10) {
        if (aVar == null) {
            aVar = new n2.a();
        }
        n2.a aVar2 = aVar;
        for (int i = 0; i < 6; i++) {
            SystemClock.uptimeMillis();
            if (fVar != null) {
                try {
                    aVar2 = fVar.f(i, aVar2);
                } catch (Throwable unused) {
                }
            }
            try {
                aVar2 = a(i, aVar2);
            } catch (Throwable unused2) {
            }
            if (fVar != null) {
                try {
                    aVar2 = fVar.e(i, aVar2);
                } catch (Throwable unused3) {
                }
                if (z10) {
                    if (i != 0) {
                        n2.a.o(aVar.f5345a, aVar2.f5345a);
                    } else {
                        aVar = aVar2;
                    }
                    aVar2 = new n2.a();
                }
            }
        }
        return b(aVar);
    }

    public void d(n2.a aVar) {
        int i = com.apm.insight.g.m;
        String str = com.apm.insight.g.n;
        JSONObject jSONObject = aVar.f5345a;
        try {
            jSONObject.put("miniapp_id", i);
            jSONObject.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (com.apm.insight.g.e) {
            aVar.e(1, "is_mp");
        }
        try {
            aVar.h(this.c.getPluginInfo());
        } catch (Throwable th) {
            try {
                HashMap map = new HashMap();
                map.put("代码中发生了错误导致数据获取失败:\n" + y2.e.b(th), 0);
                aVar.h(map);
            } catch (Throwable unused) {
            }
        }
        ConcurrentHashMap concurrentHashMap = com.apm.insight.g.i;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            for (Integer num : concurrentHashMap.keySet()) {
                try {
                    jSONObject2.put(String.valueOf(num), concurrentHashMap.get(num));
                } catch (JSONException e6) {
                    S0.b.p0(e6);
                }
            }
            try {
                aVar.f5345a.put("sdk_info", jSONObject2);
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
        }
        Context context = com.apm.insight.g.f2160a;
        aVar.e(com.stepos.statsrpk.d.o(), "process_name");
    }

    public void e(n2.a aVar) {
        e eVar;
        if (!com.stepos.statsrpk.d.l(com.apm.insight.g.f2160a)) {
            aVar.e(1, "remote_process");
        }
        aVar.e(Integer.valueOf(Process.myPid()), Constants.PARAM_PID);
        aVar.c(com.apm.insight.g.c);
        if (!(this instanceof k) && (eVar = this.d) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("last_create_activity", e.a(eVar.g, eVar.f));
                jSONObject.put("last_start_activity", e.a(eVar.i, eVar.h));
                jSONObject.put("last_resume_activity", e.a(eVar.k, eVar.f85j));
                jSONObject.put("last_pause_activity", e.a(eVar.m, eVar.l));
                jSONObject.put("last_stop_activity", e.a(eVar.o, eVar.n));
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList = eVar.f84a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        try {
                            jSONArray.put(e.a(((Long) eVar.b.get(i)).longValue(), (String) arrayList.get(i)));
                        } catch (Throwable unused) {
                        }
                    }
                }
                jSONObject.put("alive_activities", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                ArrayList arrayList2 = eVar.c;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                        try {
                            jSONArray2.put(e.a(((Long) eVar.d.get(i6)).longValue(), (String) arrayList2.get(i6)));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                jSONObject.put("finish_activities", jSONArray2);
            } catch (JSONException unused3) {
            }
            aVar.e(jSONObject, "activity_trace");
            JSONArray jSONArray3 = new JSONArray();
            Iterator it = new ArrayList(eVar.e).iterator();
            while (it.hasNext()) {
                jSONArray3.put(((d) it.next()).toString());
            }
            JSONObject jSONObjectOptJSONObject = aVar.f5345a.optJSONObject("custom_long");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                aVar.e(jSONObjectOptJSONObject, "custom_long");
            }
            try {
                jSONObjectOptJSONObject.put("activity_track", jSONArray3);
            } catch (JSONException unused4) {
            }
        }
        try {
            aVar.g(this.c.getPatchInfo());
        } catch (Throwable th) {
            try {
                aVar.g(Arrays.asList("代码中发生了错误导致数据获取失败:\n" + y2.e.b(th)));
            } catch (Throwable unused5) {
            }
        }
        aVar.e(com.apm.insight.g.d, "business");
        aVar.e(Boolean.valueOf(!com.stepos.statsrpk.d.e(this.b)), "is_background");
    }

    public boolean f() {
        return !(this instanceof i);
    }

    public void g(n2.a aVar) {
    }
}
