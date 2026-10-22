package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.runtime.ConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NpthBus.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConfigManager f7114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f7115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f7116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f7117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.bytedance.crash.runtime.e f7118e;

    public ac() {
    }

    static {
        f7114a = new ConfigManager();
        f7115b = new a();
        f7116c = null;
        f7117d = new Object();
    }

    public static ConfigManager a() {
        return f7114a;
    }

    public static Context b() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static long c() {
        return i.f();
    }

    public static com.bytedance.crash.runtime.e d() {
        if (f7118e != null) goto L13;
        monitor-enter(ac.class);
        f7118e = new com.bytedance.crash.runtime.e();     // Catch: Throwable -> L9
        monitor-exit(ac.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f7118e;
    }
}
