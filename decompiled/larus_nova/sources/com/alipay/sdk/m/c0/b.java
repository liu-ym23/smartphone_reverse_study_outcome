package com.alipay.sdk.m.c0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f25261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.g0.a f25262b;

    public b(String r100, com.alipay.sdk.m.g0.a r101) {
        this.f25261a = null;
        this.f25262b = null;
        this.f25261a = new PolarisFileWrapper(r100);
        this.f25262b = r101;
    }

    public static String a(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("type", "id");     // Catch: Exception -> L6
        r101.put("error", r100);     // Catch: Exception -> L6
        return r101.toString();
    L6:
        return "";
    }

    public static /* synthetic */ void a(b r100) {
        r100.b();
    }

    private synchronized void b() {
        monitor-enter(this);
        File r100 = this.f25261a;     // Catch: Throwable -> L35
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100.exists() == true) goto L10;
    L33:
        monitor-exit(this);
        return;
    L10:
        if (this.f25261a.isDirectory() == false) goto L33;
        if (this.f25261a.list().length == 0) goto L33;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L35
        String[] r102 = this.f25261a.list();     // Catch: Throwable -> L35
        int r103 = r102.length;     // Catch: Throwable -> L35
        int r104 = 0;
        int r105 = 0;
    L15:
        if (r105 >= r103) goto L17;
        r101.add(r102[r105]);     // Catch: Throwable -> L35
        r105 = r105 + 1;     // Catch: Throwable -> L35
        goto L15
    L17:
        Collections.sort(r101);     // Catch: Throwable -> L35
        String r106 = (String) ListProtector.get(r101, r101.size() - 1);     // Catch: Throwable -> L35
        int r107 = r101.size();     // Catch: Throwable -> L35
        if (r106.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log") == false) goto L26;
        if (r101.size() >= 2) goto L24;
        monitor-exit(this);
        return;
    L24:
        r106 = (String) ListProtector.get(r101, r101.size() - 2);     // Catch: Throwable -> L35
        r107 = r107 - 1;     // Catch: Throwable -> L35
    L26:
        if (this.f25262b.logCollect(a(com.alipay.sdk.m.z.b.a(this.f25261a.getAbsolutePath(), r106))) == true) goto L28;
        r107 = r107 - 1;     // Catch: Throwable -> L35
    L28:
        if (r104 >= r107) goto L31;
        new PolarisFileWrapper(this.f25261a, (String) ListProtector.get(r101, r104)).delete();     // Catch: Throwable -> L35
        r104 = r104 + 1;
        goto L28
    L31:
        monitor-exit(this);
        return;
    L35:
        th = move-exception;
        throw th;
    }

    public final void a() {
        ThreadMethodProxy.start(new PthreadThreadV2(new c(this), "ay/sdk/m/c0/b"));
    }
}
