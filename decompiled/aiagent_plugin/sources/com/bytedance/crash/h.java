package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONArray;

/* JADX INFO: compiled from: Flavor.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: compiled from: Flavor.java */
    public static class a {
        public static JSONArray a(CrashType r0, StackTraceElement[] r1, File r2) {
            return null;
        }
    }

    public static void a(Context r2, final com.bytedance.crash.monitor.d r3) {
        ad.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), i.d());
        DefaultWorkThread.post(new AnonymousClass1(r3));
    }

    public static void b(Context r2, final com.bytedance.crash.monitor.d r3) {
        ad.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), i.d());
        DefaultWorkThread.post(new AnonymousClass2(r3));
    }

    public static void a(File r0) {
        com.bytedance.crash.alog.a.c();
    }

    public static void a() {
        com.bytedance.crash.o.a.a(new AnonymousClass3());     // Catch: Throwable -> L4
        return;
    }
}
