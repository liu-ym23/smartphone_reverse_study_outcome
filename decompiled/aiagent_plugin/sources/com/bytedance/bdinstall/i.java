package com.bytedance.bdinstall;

import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.appstate.AppLifeCycleListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: BDInstall.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AppLifeCycleListener f6292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static aa f6293b;

    static {
        f6292a = new AppLifeCycleListener();
        f6293b = new l();
    }

    public static aa a() {
        return f6293b;
    }

    public static boolean a(aa r2) {
        if (((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.aiagent.plugin")) != f6293b) goto L5;
        return true;
    L5:
        return false;
    }

    public static aa a(String r0) {
        return l.a(r0);
    }

    public static aa b() {
        return new l();
    }

    public static AppLifeCycleListener c() {
        return f6292a;
    }

    public static u d() {
        return a().e();
    }

    public static void a(Context r2, Map<String, String> r3, boolean r4, ar r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        a().a(r6, r7, r4, r5);
    }

    public static void a(ag r2) {
        ag r3 = (ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.aiagent.plugin");
        a().a(r3);
    }

    public static com.bytedance.bdinstall.c.a e() {
        return a().k();
    }

    static void a(Application r2) {
        ((Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks(f6292a);
    }

    public static j f() {
        return a().n();
    }
}
