package com.baidu.platform.comapi.logstatistics;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class LogUsrActStatistics extends com.baidu.platform.comapi.logstatistics.a {

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final LogUsrActStatistics f32915a = null;

        static {
            f32915a = new LogUsrActStatistics(null);
        }

        public static /* synthetic */ LogUsrActStatistics a() {
            return f32915a;
        }
    }

    public static LogUsrActStatistics getInstance() {
        return b.a();
    }

    private LogUsrActStatistics() {
    }

    public /* synthetic */ LogUsrActStatistics(a r100) {
        this();
    }

    public void addLogWithLowLevel(String r100, String r101, String r102, Map<String, Object> r103) {
        String r104 = appendLogTag(r100, r101, r102);
        LogStatistics.getInstance().a(1200, 1, r104, r103);
    }
}
