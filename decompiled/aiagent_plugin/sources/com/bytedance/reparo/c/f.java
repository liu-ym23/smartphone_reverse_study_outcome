package com.bytedance.reparo.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f9115a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ScheduledExecutorService f9116e;
    private static Context f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f9117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f9119d;

    public f() {
        this.f9117b = new HashSet();
        this.f9118c = false;
        this.f9119d = null;
    }

    static /* synthetic */ void a(f r0) {
        r0.d();
    }

    static {
        f9115a = new f();
        f9116e = null;
        f = null;
    }

    public static void a(Context r2, ScheduledExecutorService r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        f9116e = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledExecutorService.class, "com.obric.aiagent.plugin");
        f = r4;
    }

    private void c() {
        if (this.f9118c == false) goto L5;
        return;
    L5:
        this.f9118c = true;
        e();
        f9116e.schedule(new AnonymousClass1(this), 10, TimeUnit.SECONDS);
    }

    private void d() {
        if (g.c().b("inited") == true) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.f9119d.keys();
    L7:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        this.f9117b.remove(r1);
        b(r1);
        goto L7
    L9:
        Iterator<String> r2 = this.f9117b.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        b((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
        goto L11
    L13:
        f();
    }

    private void b(String r2) {
        if (g.c().b(r2) == false) goto L7;
        this.f9119d.put(r2, 1);     // Catch: JSONException -> L10
        return;
    L15:
        return;
    L7:
        if (this.f9119d.opt(r2) == null) goto L13;
        this.f9119d.remove(r2);
        return;
    }

    private void e() {
        File r0 = new File(f.getFilesDir(), "reparo-root/localConfig");     // Catch: Throwable -> L9
        if (r0.exists() == false) goto L6;
        this.f9119d = new JSONObject(com.bytedance.reparo.core.a.b.b.f(r0));     // Catch: Throwable -> L9
    L6:
        if (this.f9119d != null) goto L12;
        this.f9119d = new JSONObject();
        return;
    }

    private void f() {
        JSONObject r0 = this.f9119d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() == 0) goto L14;
        File r1 = new File(f.getFilesDir(), "reparo-root/localConfig");
        com.bytedance.reparo.core.a.b.b.a(r1, this.f9119d.toString(), false);     // Catch: IOException -> L10
        return;
    L15:
        return;
    }

    public static f a() {
        f9115a.c();
        return f9115a;
    }

    public boolean a(String r2) {
        this.f9117b.add(r2);
        if (this.f9119d.opt(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        return a("enable15");
    }
}
