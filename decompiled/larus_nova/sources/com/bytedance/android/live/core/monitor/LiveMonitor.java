package com.bytedance.android.live.core.monitor;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import om0.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class LiveMonitor {
    public static final String ALOG_SERVICE_NAME = "service_name";
    public static final String ALOG_TAG = "LiveMonitorALog";
    public static final int SUCCESS = 0;
    public static final String TAG = "LiveMonitor";
    public JSONObject mCategory;
    private boolean mCompatibleWithVQOS;
    public LiveTracingMonitor.EventModule mEventModule;
    public JSONObject mExtraLog;
    public JSONObject mMetrics;
    private boolean mReportInLocalTest;
    public String mServiceName;
    private boolean mUseNewReportAction;
    private boolean mWriteLocalLog;
    private boolean mWriteLogcat;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f64898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LiveTracingMonitor.EventModule f64899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f64900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f64901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public JSONObject f64902e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f64903f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f64904g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f64905h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f64906i;

        public LiveMonitor a() {
            LiveMonitor r100 = new LiveMonitor();
            r100.mCategory = this.f64900c;
            r100.mEventModule = this.f64899b;
            r100.mServiceName = this.f64898a;
            r100.mExtraLog = this.f64902e;
            r100.mMetrics = this.f64901d;
            LiveMonitor.access$002(r100, this.f64903f);
            LiveMonitor.access$102(r100, this.f64904g);
            LiveMonitor.access$202(r100, this.f64905h);
            LiveMonitor.access$302(r100, false);
            LiveMonitor.access$402(r100, this.f64906i);
            return r100;
        }

        public final void b(JSONObject r100) {
            if (this.f64900c == null) goto L13;
            Iterator<String> r101 = r100.keys();
        L6:
            if (r101.hasNext() == false) goto L22;
            String r102 = r101.next();
            if (TextUtils.isEmpty(r102) == true) goto L6;
            this.f64900c.put(r102, r100.opt(r102));     // Catch: JSONException -> L11
        L11:
            e = move-exception;
            ALogger.w(LiveMonitor.TAG, e.getMessage());
            goto L6
        L22:
            return;
        L13:
            this.f64900c = r100;
        }

        public final void c(String r100) {
            if (this.f64900c != null) goto L9;
            this.f64900c = new JSONObject();
        L9:
            this.f64900c.put("category_1", r100);     // Catch: JSONException -> L8
            return;
        }

        public final void d(String r100) {
            if (this.f64900c != null) goto L9;
            this.f64900c = new JSONObject();
        L9:
            this.f64900c.put("category_2", r100);     // Catch: JSONException -> L8
            return;
        }

        public final void h(long r100) {
            if (this.f64901d != null) goto L9;
            this.f64901d = new JSONObject();
        L9:
            this.f64901d.put("duration", r100);     // Catch: JSONException -> L8
            return;
        }

        public final void j(long r100) {
            if (this.f64901d != null) goto L9;
            this.f64901d = new JSONObject();
        L9:
            this.f64901d.put("latency", r100);     // Catch: JSONException -> L8
            return;
        }

        public final void k(JSONObject r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.f64901d == null) goto L15;
            Iterator<String> r101 = r100.keys();
        L8:
            if (r101.hasNext() == false) goto L24;
            String r102 = r101.next();
            if (TextUtils.isEmpty(r102) == true) goto L8;
            this.f64901d.put(r102, r100.opt(r102));     // Catch: JSONException -> L13
        L13:
            e = move-exception;
            ALogger.w(LiveMonitor.TAG, e.getMessage());
            goto L8
        L24:
            return;
        L15:
            this.f64901d = r100;
        }

        public final void l(int r100) {
            if (this.f64900c != null) goto L9;
            this.f64900c = new JSONObject();
        L9:
            this.f64900c.put("status_code", r100);     // Catch: JSONException -> L8
            return;
        }

        public final void m(String r100) {
            if (this.f64900c != null) goto L9;
            this.f64900c = new JSONObject();
        L9:
            this.f64900c.put("status_msg", r100);     // Catch: JSONException -> L8
            return;
        }

        public a(String r100, LiveTracingMonitor.EventModule r101) {
            this.f64903f = false;
            this.f64904g = false;
            this.f64905h = true;
            this.f64906i = false;
            this.f64898a = r100;
            this.f64899b = r101;
        }

        public final void e(String r100, String r101) {
            if (this.f64900c != null) goto L9;
            this.f64900c = new JSONObject();
        L9:
            this.f64900c.put(r100, r101);     // Catch: JSONException -> L8
            return;
        }

        public final void f(String r100, float r101) {
            if (this.f64901d != null) goto L9;
            this.f64901d = new JSONObject();
        L9:
            this.f64901d.put(r100, Float.valueOf(r101));     // Catch: JSONException -> L8
            return;
        }

        public final void g(String r100, long r101) {
            if (this.f64901d != null) goto L9;
            this.f64901d = new JSONObject();
        L9:
            this.f64901d.put(r100, r101);     // Catch: JSONException -> L8
            return;
        }

        public final void i(String r100, Object r101) {
            if (this.f64902e != null) goto L9;
            this.f64902e = new JSONObject();
        L9:
            this.f64902e.put(r100, r101);     // Catch: JSONException -> L8
            return;
        }
    }

    public void report() {
        if (this.mWriteLocalLog == false) goto L6;
        HashMap r100 = new HashMap();
        r100.put("service_name", this.mServiceName);
        sinkJsonToMap(this.mCategory, r100);
        sinkJsonToMap(this.mMetrics, r100);
        sinkJsonToMap(this.mExtraLog, r100);
        ALogger.i(ALOG_TAG, r100.toString());
    L6:
        if (this.mReportInLocalTest == true) goto L11;
        if (v.a() == false) goto L11;
        return;
    L11:
        if (this.mExtraLog != null) goto L14;
        this.mExtraLog = new JSONObject();
    L14:
        if (this.mCompatibleWithVQOS == false) goto L42;
        JSONObject r101 = new JSONObject();
        JSONObject r102 = this.mCategory;
        int r103 = 0;
        if (r102 == null) goto L56;
        r103 = r102.optInt("status_code", 0);
    L56:
        r101.put("status", r103);     // Catch: JSONException -> L21
    L23:
        JSONObject r104 = this.mMetrics;
        long r105 = -1;
        if (r104 == null) goto L28;
        r105 = r104.optLong("latency", -1);
    L28:
        if (r105 <= 0) goto L35;
        r101.put("value", durationJson(r105));     // Catch: JSONException -> L32
        r101.put("extra", this.mExtraLog);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L35:
        if (this.mUseNewReportAction == false) goto L40;
        wm0.a r106 = c.h();
        if (r106 == null) goto L39;
        r106.d(this.mServiceName, this.mCategory, this.mMetrics, r101);
    L49:
        if (this.mWriteLogcat == true) goto L51;
        return;
    L51:
        if (v.a() == false) goto L59;
        Objects.toString(this.mCategory);
        Objects.toString(this.mExtraLog);
        Objects.toString(this.mEventModule);
        Objects.toString(this.mMetrics);
        return;
    L59:
        return;
    L39:
        LiveTracingMonitor.i(this.mServiceName, this.mCategory, this.mMetrics, r101);
        goto L49
    L40:
        LiveTracingMonitor.i(this.mServiceName, this.mCategory, this.mMetrics, r101);
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L42:
        if (this.mUseNewReportAction == false) goto L47;
        wm0.a r107 = c.h();
        if (r107 == null) goto L46;
        r107.g(this.mServiceName, this.mEventModule.getName(), LiveTracingMonitor.EventType.BUSSINESS_API_CALL.getName(), this.mCategory, this.mMetrics, this.mExtraLog);
        goto L49
    L46:
        LiveTracingMonitor.e(this.mServiceName, this.mEventModule, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.mCategory, this.mMetrics, this.mExtraLog);
        goto L49
    L47:
        LiveTracingMonitor.e(this.mServiceName, this.mEventModule, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.mCategory, this.mMetrics, this.mExtraLog);
        goto L49
    }

    public LiveMonitor() {
        this.mUseNewReportAction = false;
    }

    private static JSONObject durationJson(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("duration", r100);     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static /* synthetic */ boolean access$002(LiveMonitor r100, boolean r101) {
        r100.mWriteLocalLog = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(LiveMonitor r100, boolean r101) {
        r100.mWriteLogcat = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(LiveMonitor r100, boolean r101) {
        r100.mReportInLocalTest = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(LiveMonitor r100, boolean r101) {
        r100.mCompatibleWithVQOS = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(LiveMonitor r100, boolean r101) {
        r100.mUseNewReportAction = r101;
        return r101;
    }

    private void sinkJsonToMap(JSONObject r100, Map<String, Object> r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L16;
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r101.put(r103, r104);
        goto L7
    L17:
        return;
    L16:
        return;
    }
}
