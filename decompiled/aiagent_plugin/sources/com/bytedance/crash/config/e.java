package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: LogPathConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f7288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f7291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f7292e;
    private File f;
    private File g;

    static {
        f7288a = new e();
    }

    private static e e() {
        return f7288a;
    }

    private e() {
        this.f7289b = f();
        this.f7290c = "npth";
        g();
        if (this.f7291d.exists() == true) goto L6;
        this.f7291d.mkdirs();
        return;
    }

    private String f() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        return r2.getFilesDir().getAbsolutePath();
    L7:
        return "";
    L12:
        return "";
    }

    private void g() {
        this.f7291d = new File(this.f7289b, this.f7290c);
        this.f7292e = new File(this.f7291d, "asdawd");
        this.f = new File(this.f7291d, "selflib");
        this.g = new File(this.f7291d, "PriorityMonitor");
    }

    public static File a() {
        return e().f7291d;
    }

    public static File b() {
        return e().f7292e;
    }

    public static File c() {
        return e().f;
    }

    public static File d() {
        return e().g;
    }
}
