package com.bytedance.apm6.hub.a.a;

import android.text.TextUtils;
import com.bytedance.apm6.util.e;
import com.bytedance.apm6.util.e.c;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f5388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<b> f5390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile JSONObject f5391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5392e;
    private volatile boolean f;
    private com.bytedance.apm6.util.e.a g;
    private IConfigManager h;
    private com.bytedance.apm6.util.e.a i;

    static /* synthetic */ com.bytedance.apm6.util.e.a a(a r0, com.bytedance.apm6.util.e.a r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ JSONObject a(a r0) {
        return r0.f5391d;
    }

    static /* synthetic */ void a(a r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void b(a r0) {
        r0.c();
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a c(a r0) {
        return r0.g;
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a d(a r0) {
        return r0.i;
    }

    private a() {
        this.f5389b = false;
    }

    public static a a() {
        if (f5388a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5388a != null) goto L9;
        f5388a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5388a;
    }

    public synchronized void b() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f5389b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f5389b = true;     // Catch: Throwable -> L14
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L11;
        final long r3 = 500;
        final long r5 = 1000;
        this.g = new AnonymousClass1(this, r3, r5);     // Catch: Throwable -> L14
        com.bytedance.apm6.util.e.b.a(c.f5474b).a(this.g);     // Catch: Throwable -> L14
    L11:
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        this.h = r0;     // Catch: Throwable -> L14
        r0.registerConfigListener(new AnonymousClass2(this));     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private void c() {
        if (this.h != null) goto L5;
        this.h = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");
    L5:
        IConfigManager r0 = this.h;
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = r0.queryConfig();
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L16;
        com.bytedance.apm6.util.c.b.a("APM-Config", "initConfig:" + r1);
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        a(new JSONObject(r1), true);     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    private void a(JSONObject r2, boolean r3) {
        if (e.a(r2) == false) goto L5;
        return;
    L5:
        this.f5391d = r2;
        this.f5392e = r3;
        b(r2, r3);
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.f5390c != null) goto L9;
        this.f5390c = new CopyOnWriteArrayList();
    L9:
        if (this.f5390c.contains(r4) == true) goto L12;
        this.f5390c.add(r4);
    L12:
        if (this.f == false) goto L15;
        r4.a(this.f5391d, this.f5392e);
        return;
    }

    private void b(JSONObject r4, boolean r5) {
        this.f = true;
        List<b> r3 = this.f5390c;
        if (r3 == null) goto L10;
        Iterator<b> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L17;
        ((b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin")).a(r4, r5);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }
}
