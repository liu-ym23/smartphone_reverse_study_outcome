package com.bytedance.apm.block;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.npth.NpthUtil;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f6395b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6396a;

    public class a implements NpthUtil.IGetUserData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f6397a;

        public a(f r10) {
            this.f6397a = r10;
        }

        @Override // com.bytedance.apm.npth.NpthUtil.IGetUserData
        public Map getUserData() {
            HashMap r10 = new HashMap();
            JSONObject r11 = PerfMonitorManager.o().e();
            Iterator<String> r12 = r11.keys();
        L4:
            if (r12.hasNext() == false) goto L6;
            String r13 = r12.next();
            r10.put(r13, r11.optString(r13));
            goto L4
        L6:
            HashMap r14 = new HashMap();
            String r15 = g1.e.E().D(0, SystemClock.uptimeMillis());
            if (TextUtils.isEmpty(r15) == true) goto L9;
            r10.put("evil_method", r15);
            r14.put(CommonKey.KEY_WITH_EVIL_METHOD, "true");
        L10:
            String r16 = PerfMonitorManager.o().i(0, SystemClock.uptimeMillis());
            if (TextUtils.isEmpty(r16) == false) goto L13;
        L15:
            r14.put(CommonKey.KEY_WITH_STACK_TRACE, "false");
        L16:
            r14.put(CommonKey.KEY_WITH_APM_TRACE, String.valueOf(com.bytedance.apm.internal.a.c(2)));
            NpthUtil.a(r14);
            return r10;
        L13:
            if (r16.length() <= 10) goto L15;
            r10.put("profiler_monitor", r16);
            r14.put(CommonKey.KEY_WITH_STACK_TRACE, "true");
            goto L16
        L9:
            r14.put(CommonKey.KEY_WITH_EVIL_METHOD, "false");
            goto L10
        }
    }

    public f() {
        this.f6396a = 0;
    }

    public static f a() {
        if (f6395b != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6395b != null) goto L11;
        f6395b = new f();     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return f6395b;
    }

    public static int b(int r10) {
        if (r10 != 11) goto L5;
        return 2;
    L5:
        if (r10 != 101) goto L7;
        return 3;
    L7:
        if (r10 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static int c(JSONObject r10) {
        int r11 = com.bytedance.apm.util.i.f(r10, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH, SlardarSettingsConsts.PERF_SMOOTH_BLOCK_MONITOR_MODE);
        if (r11 != 11) goto L5;
        return 2;
    L5:
        if (r11 != 101) goto L7;
        return 3;
    L7:
        if (r11 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public void d() {
        NpthUtil.b(new a(this));
    }

    public void e() {
        PerfMonitorManager.o().w();
    }

    public void f(int r10, boolean r11) {
        this.f6396a = b(r10);
        PerfMonitorManager.o().x(this.f6396a);
    }
}
