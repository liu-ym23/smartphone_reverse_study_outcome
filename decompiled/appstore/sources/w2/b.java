package w2;

import android.util.Log;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements Monitorable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f25300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f25301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f25304e;

    public b(double r10, double r11, List r12, String r13, boolean r14) {
        this.f25300a = r10;
        this.f25301b = r11;
        this.f25302c = r13;
        this.f25303d = r14;
        this.f25304e = new ArrayList(r12);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "cpu_exception_trace";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        List r10 = this.f25304e;
        if (r10 != null) goto L5;
    L11:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L11;
        if (this.f25300a <= 0.0d) goto L11;
        if (this.f25301b <= 0.0d) goto L11;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r10 = new JSONObject();
        r10.put("event_type", "cpu_exception_trace");     // Catch: Throwable -> L7
        r10.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L7
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L7
        r10.put(CommonKey.KEY_CRASH_TIME, System.currentTimeMillis());     // Catch: Throwable -> L7
        r10.put("is_main_process", w0.c.F());     // Catch: Throwable -> L7
        r10.put("process_name", w0.c.h());     // Catch: Throwable -> L7
        if (this.f25303d == false) goto L9;
        r10.put("data_type", "back");     // Catch: Throwable -> L7
    L10:
        r10.put("scene", this.f25302c);     // Catch: Throwable -> L7
        r10.put(CommonKey.KEY_REPORT_SCENE, this.f25302c);     // Catch: Throwable -> L7
        if (w0.c.f() <= w0.c.z()) goto L14;
    L16:
        r10.put(ExceptionConsts.KEY_APP_START_TIME, w0.c.z());     // Catch: Throwable -> L7
    L17:
        r10.put("process_speed_avg", this.f25300a);     // Catch: Throwable -> L7
        r10.put("process_speed_max", this.f25301b);     // Catch: Throwable -> L7
        r10.put(Constants.KEY_BATTERY_TEMPERATURE, v1.g.d().f());     // Catch: Throwable -> L7
        r10.put("battery_recharge_state", v1.g.d().e());     // Catch: Throwable -> L7
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L7
        Iterator r12 = this.f25304e.iterator();     // Catch: Throwable -> L7
    L19:
        if (r12.hasNext() == false) goto L24;
        v2.g r13 = (v2.g) r12.next();     // Catch: Throwable -> L7
        if (r13 == null) goto L19;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L7
        r14.put("nice", r13.b());     // Catch: Throwable -> L7
        r14.put("weight", Double.valueOf(r13.h()));     // Catch: Throwable -> L7
        r14.put("cpu_usage", r13.a());     // Catch: Throwable -> L7
        r14.put("thread_name", r13.g());     // Catch: Throwable -> L7
        r14.put("thread_back_trace", r13.d());     // Catch: Throwable -> L7
        r14.put(TracingConstants.KEY_THREAD_NAME, r13.f());     // Catch: Throwable -> L7
        r11.put(r14);     // Catch: Throwable -> L7
        goto L19
    L24:
        r10.put("threads_info", r11);     // Catch: Throwable -> L7
    L28:
        Log.i("APM-CPU", "exception data: " + r10);
        return r10;
    L14:
        if (w0.c.f() == 0) goto L16;
        r10.put(ExceptionConsts.KEY_APP_START_TIME, w0.c.f());     // Catch: Throwable -> L7
        goto L17
    L9:
        r10.put("data_type", CommonKey.KEY_FRONT);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        s3.a.c("APM-CPU", "cpu_exception_data_assemble", th);
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L30
        r15.put("exception", th.getLocalizedMessage());     // Catch: Throwable -> L30
        k2.a.e("cpu_exception_no_stack", r15, null);     // Catch: Throwable -> L30
        goto L28
    }
}
