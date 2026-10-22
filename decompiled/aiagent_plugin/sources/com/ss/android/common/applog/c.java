package com.ss.android.common.applog;

import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppLogNewMonitor.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.applog.util.a<MonitorV3Helper> f37162a = null;

    static {
        f37162a = new AnonymousClass1();
    }

    public static MonitorV3Helper a() {
        return (MonitorV3Helper) ZeusTransformUtils.preCheckCast(f37162a.c(new Object[0]), MonitorV3Helper.class, "com.obric.aiagent.plugin");
    }
}
