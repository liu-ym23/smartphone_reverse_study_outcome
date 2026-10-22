package com.bytedance.apm.d;

import android.text.TextUtils;
import com.bytedance.apm.c;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.d.b;
import com.bytedance.apm.h.e;
import com.bytedance.apm.j;
import com.bytedance.apm.util.i;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseDataPipeline.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends b> implements com.bytedance.services.slardar.config.a {
    private static final String TAG = "BaseDataPipeline";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4526b = 1000;
    private static boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4527a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<T> f4528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f4529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f4530e;

    static {
    }

    public boolean b(T r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        return true;
    }

    public void c(T r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public abstract void d(T r1);

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
    }

    static /* synthetic */ LinkedList a(a r0) {
        return r0.f4528c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(a r2, b r3) {
        r2.e((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin"));
    }

    public a() {
        this.f4530e = false;
        this.f4527a = false;
        this.f4528c = new LinkedList();
    }

    public void a() {
        ((IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).registerConfigListener(this);
    }

    public final void a(T r3) {
        final b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm.thread.b.a().b() == true) goto L5;
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this, r4));
        return;
    L5:
        e(r4);
    }

    private void e(T r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (b(r4) == true) goto L5;
        return;
    L5:
        c(r4);
        if (this.f4529d == false) goto L8;
        d(r4);
        return;
    L8:
        f(r4);
    }

    private void f(T r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        LinkedList<T> r0 = this.f4528c;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.f4528c.size() <= f4526b) goto L15;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f4528c.poll(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (f == true) goto L12;
    L22:
        com.bytedance.apm.h.a.b("apm_debug", "apm_cache_buffer_full:" + r1.a().toString());     // Catch: Exception -> L21 Throwable -> L18
        goto L15
    L12:
        if (this.f4530e == true) goto L22;
        j.a().a("apm_cache_buffer_full");     // Catch: Throwable -> L18
        this.f4530e = true;     // Catch: Throwable -> L18
    L15:
        this.f4528c.add((T) r7);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    private void c() {
        com.bytedance.apm.thread.b.a().a(new AnonymousClass2(this));
    }

    public void a(String r5, String r6, JSONObject r7, boolean r8, boolean r9) {
        if (c.i() == false) goto L5;
        e.d(TAG, new String[]{"type:" + r5 + " isSaveUnSampleLog:" + r9 + "isSampled:" + r8 + " log:" + r7});
    L5:
        if (r8 == false) goto L18;
        if (this.f4527a == false) goto L9;
        JSONObject r10 = i.f(r7);
    L11:
        if (TextUtils.equals(r5, "tracing") == false) goto L14;
        a(new com.bytedance.b.a.d(r10, null, false, r6));
    L27:
        com.bytedance.apm.j.a.a().a(r5, r6, r7);
        if (TextUtils.equals(r5, "ui_action") == false) goto L33;
        com.bytedance.apm.d.c.a.a().a(r7);
        return;
    L33:
        return;
    L14:
        if (TextUtils.equals(r5, "common_log") == false) goto L16;
        com.bytedance.apm6.commonevent.a.a(new com.bytedance.apm6.commonevent.b.c(r6, r10));
        goto L27
    L16:
        com.bytedance.apm6.commonevent.a.a(new com.bytedance.apm6.commonevent.b.c(r5, r10));
        goto L27
    L9:
        r10 = i.d(r7);
        goto L11
    L18:
        if (c.i() == false) goto L20;
        com.bytedance.apm.doctor.a.a(r5, r7, false);
    L20:
        if (r9 == false) goto L27;
        if (com.bytedance.apm.h.a.b() == false) goto L27;
        com.bytedance.apm.h.a.d(r5, r7.toString());     // Catch: Exception -> L25
    L25:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "apm_unsampled_log_error");
        goto L27
    }

    private void a(com.bytedance.b.a.d r2) {
        if ("batch_tracing".equals(r2.c()) == false) goto L5;
        com.bytedance.apm6.commonevent.a.a(new com.bytedance.apm6.commonevent.b.d(com.bytedance.b.a.a.a(r2.a())));
        return;
    L5:
        com.bytedance.apm6.commonevent.a.a(new com.bytedance.apm6.commonevent.b.d(r2.a()));
    }

    public static boolean b() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
        this.f4529d = true;
        c();
    }

    public static void a(int r0) {
        f4526b = r0;
    }

    public static void a(boolean r0) {
        f = r0;
    }
}
