package com.bytedance.android.livesdk.performance;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f154676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f154677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f154678c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f154679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f154680b;

        public final JSONObject a() {
            JSONObject r100 = new JSONObject();
            r100.put("active", 1);     // Catch: Exception -> L13
            Map<String, String> r101 = this.f154680b;     // Catch: Exception -> L13
            if (r101 == null) goto L12;
            if (r101.size() <= 0) goto L12;
            Iterator<Map.Entry<String, String>> r102 = this.f154680b.entrySet().iterator();     // Catch: Exception -> L13
        L9:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<String, String> r103 = r102.next();     // Catch: Exception -> L13
            r100.put(r103.getKey(), r103.getValue());     // Catch: Exception -> L13
        L12:
            return r100;
        }

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            Map<String, String> r101 = this.f154680b;     // Catch: Exception -> L13
            if (r101 == null) goto L12;
            if (r101.size() <= 0) goto L12;
            Iterator<Map.Entry<String, String>> r102 = this.f154680b.entrySet().iterator();     // Catch: Exception -> L13
        L9:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<String, String> r103 = r102.next();     // Catch: Exception -> L13
            r100.put(r103.getKey(), r103.getValue());     // Catch: Exception -> L13
        L12:
            return r100;
        }

        public final String toString() {
            return "Module: " + this.f154679a + " : " + this.f154680b.toString();
        }

        public a(String r100, Map<String, String> r101) {
            this.f154679a = r100;
            this.f154680b = r101;
        }
    }

    public l0() {
        this.f154676a = new ConcurrentHashMap();
        this.f154677b = new JSONObject();
        this.f154678c = false;
    }

    public final void a(String r110) {
        a r100 = this.f154676a.get(r110);
        if (r100 == null) goto L66;
        Map<String, String> r101 = r100.f154680b;
        if (r101 != null) goto L7;
        return;
    L7:
        if (TextUtils.equals(r101.get(IPerformanceManager.CPU_RATE_FOR_MODULE_AVAILABLE), "true") == false) goto L10;
        return;
    L10:
        if (TextUtils.equals(r101.get(IPerformanceManager.CPU_TIME_APP_ON_MODULE_START), "-1") == false) goto L14;
        r101.put(IPerformanceManager.CPU_RATE_FOR_MODULE, "-3.0");
        r101.put(IPerformanceManager.CPU_RATE_FOR_MODULE_AVAILABLE, "true");
        return;
    L14:
        if (TextUtils.equals(r101.get(IPerformanceManager.CPU_TIME_APP_ON_MODULE_STOP), "-1") == false) goto L16;
        return;
    L16:
        double r111 = -1.0d;
    L61:
        String r102 = String.valueOf(-1.0d);
    L62:
        r101.put(IPerformanceManager.CPU_RATE_FOR_MODULE, r102);
        r101.put(IPerformanceManager.CPU_RATE_FOR_MODULE_AVAILABLE, "true");
        return;
    L58:
        th = move-exception;
        r101.put(IPerformanceManager.CPU_RATE_FOR_MODULE, String.valueOf(-1.0d));
        r101.put(IPerformanceManager.CPU_RATE_FOR_MODULE_AVAILABLE, "true");
        throw th;
    L18:
        if (TextUtils.isEmpty(r101.get(IPerformanceManager.CPU_TIME_APP_ON_MODULE_START)) == true) goto L20;
        double r112 = Double.parseDouble(r101.get(IPerformanceManager.CPU_TIME_APP_ON_MODULE_START));     // Catch: Throwable -> L58 Exception -> L61
    L22:
        if (TextUtils.isEmpty(r101.get(IPerformanceManager.CPU_TIME_APP_ON_MODULE_STOP)) == true) goto L24;
        double r103 = Double.parseDouble(r101.get(IPerformanceManager.CPU_TIME_APP_ON_MODULE_STOP));     // Catch: Throwable -> L58 Exception -> L61
    L26:
        if (TextUtils.isEmpty(r101.get(IPerformanceManager.CPU_TIME_SYS_ON_MODULE_START)) == true) goto L28;
        double r113 = Double.parseDouble(r101.get(IPerformanceManager.CPU_TIME_SYS_ON_MODULE_START));     // Catch: Throwable -> L58 Exception -> L61
    L30:
        if (TextUtils.isEmpty(r101.get(IPerformanceManager.CPU_TIME_SYS_ON_MODULE_STOP)) == true) goto L33;
        double r104 = Double.parseDouble(r101.get(IPerformanceManager.CPU_TIME_SYS_ON_MODULE_STOP));     // Catch: Throwable -> L58 Exception -> L61
    L35:
        if (r113 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        if (r104 <= r113) goto L40;
        double r105 = (r103 - r112) / (r104 - r113);
    L55:
        r102 = String.valueOf(r105);
        if (r105 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L62;
        r102 = new DecimalFormat("#.####").format(r105);
    L40:
        if (r113 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L42;
    L47:
        r111 = -2.0d;
    L49:
        if (r103 != r112) goto L51;
    L54:
        r105 = 0.0d;
        goto L55
    L51:
        if (r104 == r113) goto L54;
        r105 = r111;
        goto L55
    L42:
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L47;
        if (r112 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L47;
        if (r103 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L49;
    L33:
        r104 = -1.0d;
        goto L35
    L28:
        r113 = -1.0d;
        goto L30
    L24:
        r103 = -1.0d;
        goto L26
    L20:
        r112 = -1.0d;
        goto L22
    }

    public final a b(String r100) {
        if (this.f154676a.isEmpty() == false) goto L5;
        return null;
    L5:
        if (this.f154676a.containsKey(r100) == true) goto L7;
        return null;
    L7:
        return this.f154676a.get(r100);
    }
}
