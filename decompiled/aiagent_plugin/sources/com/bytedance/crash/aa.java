package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: NpthApi.java */
/* JADX INFO: loaded from: classes.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aa f7111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f7112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f7113c;

    /* JADX INFO: compiled from: NpthApi.java */
    public interface a {
        File a();
    }

    /* JADX INFO: compiled from: NpthApi.java */
    public interface b {
    }

    static {
    }

    public String a() {
        return "";
    }

    public void a(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    aa() {
        f7111a = this;
        a r0 = f7112b;
        if (r0 == null) goto L6;
        a(r0);
        return;
    }

    public static void a(b r2) {
        f7113c = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public static String c() {
        aa r0 = f7111a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.a();
    }
}
