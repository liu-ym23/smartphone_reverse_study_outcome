package y0;

import H.h;
import P.c;
import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import g1.AbstractC1451a;
import h2.RunnableC1484b;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import u1.d;
import z0.C2153a;

/* renamed from: y0.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2126b {
    public static final C2126b g = new C2126b();
    public static final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    public static boolean i = false;

    /* renamed from: a, reason: collision with root package name */
    public Handler f6887a;
    public ReferenceQueue b;
    public CopyOnWriteArraySet c;
    public Q.a d;
    public long e;
    public volatile d f;

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(C2153a c2153a) {
        if (h.b) {
            Log.e("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"Leak:" + c2153a.b}));
        }
        Activity activity = (Activity) c2153a.get();
        if (activity == null) {
            return;
        }
        boolean serviceSwitch = AbstractC1451a.f4474w.getServiceSwitch("apmplus_activity_fixer_switch");
        boolean serviceSwitch2 = AbstractC1451a.f4474w.getServiceSwitch("apmplus_activity_leak_monitor");
        if (h.b) {
            Log.d("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"apmplus_activity_fixer_switch: " + serviceSwitch}));
            Log.d("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"apmplus_activity_leak_monitor: " + serviceSwitch2}));
        }
        C2126b c2126b = g;
        if (serviceSwitch) {
            c2126b.f6887a.post(new RunnableC1484b(c2153a));
        }
        if (serviceSwitch2) {
            String name = activity.getClass().getName();
            if (AbstractC1451a.f4474w.getServiceSwitch("apmplus_activity_leak_monitor") && !TextUtils.isEmpty(name)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("leak_activity", name);
                    O.a.g().c(new c("apmplus_activity_leak_monitor", 0, null, jSONObject, null, null));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (h.b) {
                Log.i("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"upload leak activity:" + activity.getLocalClassName()}));
            }
        }
        ApmInsightInitConfig apmInsightInitConfig = (ApmInsightInitConfig) ((Q.a) c2126b.d.b).b;
        if (apmInsightInitConfig.getActivityLeakListener() != null) {
            apmInsightInitConfig.getActivityLeakListener().onActivityLeaked(activity);
        }
    }
}
