package com.baidu.platform.comapi.logstatistics;

import java.util.Map;

/* loaded from: classes.dex */
public class LogUsrActStatistics extends com.baidu.platform.comapi.logstatistics.a {

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final LogUsrActStatistics f8776a = new LogUsrActStatistics();
    }

    public static LogUsrActStatistics getInstance() {
        return b.f8776a;
    }

    public void addLogWithLowLevel(String str, String str2, String str3, Map<String, Object> map) {
        LogStatistics.getInstance().a(1200, 1, appendLogTag(str, str2, str3), map);
    }

    private LogUsrActStatistics() {
    }
}
