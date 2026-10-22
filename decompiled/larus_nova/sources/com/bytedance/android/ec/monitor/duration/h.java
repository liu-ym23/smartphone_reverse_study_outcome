package com.bytedance.android.ec.monitor.duration;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface h {

    public static final class a {
        public static void c(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "timestampCache");
            System.out.println("Django >> [DurationMonitor]: report finish. params: " + r100 + '.');
        }

        public static void d(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "timestampCache");
            System.out.println("Django >> [DurationMonitor]: report start... params: " + r100 + '.');
        }

        public static void a(Exception r100, Map r101) {
            Intrinsics.checkNotNullParameter("ReportDuration has error", "msg");
            Intrinsics.checkNotNullParameter(r100, "e");
            Intrinsics.checkNotNullParameter(r101, "timestampCache");
            System.out.println("Django >> [DurationMonitor]: report fail: msg: ReportDuration has error; exception: " + r100);
        }

        public static void b(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            Intrinsics.checkNotNullParameter(r101, "timestampCache");
            System.out.println("Django >> [DurationMonitor]: report fail: " + r100 + '.');
        }
    }

    void a(Map<String, ? extends Object> r100);

    void b(String r100, Map<String, ? extends Object> r101);

    void c(JSONObject r100);

    void d(Map<String, ? extends Object> r100);

    void e(Exception r100, Map r101);

    void f(Map<String, ? extends Object> r100);
}
