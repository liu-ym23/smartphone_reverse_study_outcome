package com.bytedance.apm.launch.evil;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.t;
import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import m1.d;
import org.json.JSONException;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.apm.launch.evil.a$a, reason: collision with other inner class name */
    public static class RunnableC0074a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StackTraceElement[] f6513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6514b;

        public RunnableC0074a(StackTraceElement[] r10, long r11) {
            this.f6513a = r10;
            this.f6514b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = t.c(this.f6513a);     // Catch: JSONException -> L10
            if (this.f6514b != 0) goto L6;
            return;
        L6:
            if (r10.isEmpty() == true) goto L17;
            JSONObject r11 = new JSONObject();     // Catch: JSONException -> L10
            r11.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L10
            r11.put(CommonKey.KEY_CRASH_TIME, System.currentTimeMillis());     // Catch: JSONException -> L10
            r11.put("is_main_process", c.F());     // Catch: JSONException -> L10
            r11.put("process_name", c.h());     // Catch: JSONException -> L10
            r11.put("block_duration", this.f6514b);     // Catch: JSONException -> L10
            r11.put("stack", r10);     // Catch: JSONException -> L10
            r11.put("event_type", "lag");     // Catch: JSONException -> L10
            JSONObject r12 = m3.c.a().getPerfFiltersJson();     // Catch: JSONException -> L10
            r12.put("block_stack_type", "stack");     // Catch: JSONException -> L10
            r12.put("is_launch_binder", "true");     // Catch: JSONException -> L10
            r11.put("filters", r12);     // Catch: JSONException -> L10
            r1.a.b().d("binder report json: " + r11);     // Catch: JSONException -> L10
            l1.a.p().e(new d("block_monitor", r11));     // Catch: JSONException -> L10
            return;
        L17:
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static long a() {
        long r10 = 0;
        if (r1.a.b().c().a() == true) goto L5;
    L15:
        return r10;
    L5:
        if (com.bytedance.apm.internal.a.c(2) == false) goto L15;
        List r11 = PerfMonitorManager.o().d();
        if (r11 != null) goto L9;
    L14:
        r1.a.b().d("binder cost when launch: " + r10);
        goto L15
    L9:
        if (r11.isEmpty() == true) goto L14;
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        BinderMonitor.a r13 = (BinderMonitor.a) r12.next();
        long r14 = r13.c() - r13.a();
        r10 = r10 + r14;
        c(r14, b(r13.b()));
        goto L12
    }

    public static StackTraceElement[] b(StackTraceElement[] r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.length == 0) goto L21;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L13;
        if ("saveBinderInfo".equals(r10[r12].getMethodName()) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        r11 = r12;
    L13:
        int r13 = r11 + 1;
        if (r13 <= r10.length) goto L16;
        return r10;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r10, r13, r10.length);
    L21:
        return r10;
    }

    public static void c(long r10, StackTraceElement[] r11) {
        AsyncEventManager.e().h(new RunnableC0074a(r11, r10));
    }
}
