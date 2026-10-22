package com.bytedance.reparo;

import android.app.Application;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.bytedance.reparo.core.k;
import com.bytedance.reparo.core.m;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.provider.PatchChangeObserver;
import com.bytedance.reparo.provider.ReparoProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PatchUpdateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements k.a {
    private static final String TAG = "PatchManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f9336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f9337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Application f9338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f9339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9340e;
    private boolean f;
    private boolean g;
    private f h;

    static /* synthetic */ void a(d r0) {
        r0.g();
    }

    static /* synthetic */ void a(d r2, List r3, long r4) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4);
    }

    private d() {
        this.g = false;
    }

    public static d a() {
        if (f9336a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9336a != null) goto L9;
        f9336a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f9336a;
    }

    synchronized void a(Application r10, IReparoConfig r11, boolean r12, String r13, com.bytedance.reparo.core.e r14) {
        monitor-enter(this);
        Application r15 = (Application) ZeusTransformUtils.wrapperContextForParams(r10, Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (this.g == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f = r12;     // Catch: Throwable -> L13
        this.f9338c = r15;     // Catch: Throwable -> L13
        this.f9340e = r13;     // Catch: Throwable -> L13
        this.f9339d = new c(this.f9338c);     // Catch: Throwable -> L13
        m r1 = m.a();     // Catch: Throwable -> L13
        Application r2 = this.f9338c;     // Catch: Throwable -> L13
        r1.a(r2, r14, r13, r11.getAbiHelper(r2), r12, false, com.bytedance.reparo.c.f.a().b());     // Catch: Throwable -> L13
        m.a().a(this);     // Catch: Throwable -> L13
        this.h = new f(this.f9338c, r11, "0.0.4-rc.50");     // Catch: Throwable -> L13
        if (r12 == true) goto L10;
        f();     // Catch: Throwable -> L13
    L10:
        this.g = true;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void f() {
        if (this.f == false) goto L9;
        return;
    L9:
        ZeusProviderTransform.registerContentObserver(this.f9338c.getContentResolver(), com.bytedance.reparo.a.a.a(this.f9338c), true, new PatchChangeObserver(null), "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        return;
    L7:
        com.bytedance.reparo.c.e.b(TAG, "registerContentObserver failed, current process name: " + com.bytedance.reparo.core.a.b.d.a(this.f9338c));
    }

    void update() {
        if (this.g == true) goto L5;
        return;
    L5:
        if (this.f == true) goto L7;
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        b().execute(new AnonymousClass1(this));
        return;
    L9:
        g();
    }

    private void g() {
        final long r0 = SystemClock.elapsedRealtime();
        this.h.a(new AnonymousClass2(this, r0));
    }

    private synchronized void a(List<PatchFetchInfo> r5, long r6) {
        monitor-enter(this);
        List<PatchFetchInfo> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        String r0 = com.bytedance.reparo.core.i.b.a(r7);     // Catch: Throwable -> L12
        com.bytedance.reparo.c.e.a(TAG, "query remote patch info success. " + r0);     // Catch: Throwable -> L12
        com.bytedance.reparo.c.c.a(TAG, r0, r6);     // Catch: Throwable -> L12
        b(r7);     // Catch: Throwable -> L12
        List<PatchFetchInfo> r8 = a(r7);     // Catch: Throwable -> L12
        com.bytedance.reparo.c.e.a(TAG, "need update patch list: " + com.bytedance.reparo.core.i.b.a(r8));     // Catch: Throwable -> L12
        if (r8.size() <= 0) goto L9;
        Iterator<PatchFetchInfo> r9 = r8.iterator();     // Catch: Throwable -> L12
    L7:
        if (r9.hasNext() == false) goto L10;
        b().execute(new e((PatchFetchInfo) ZeusTransformUtils.preCheckCast(r9.next(), PatchFetchInfo.class, "com.obric.aiagent.plugin"), this.f9339d));     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L9:
        com.bytedance.reparo.c.e.a(TAG, "there is no new patch in server");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private List<PatchFetchInfo> a(List<PatchFetchInfo> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        Map<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> r2 = m.a().d();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        PatchFetchInfo r3 = (PatchFetchInfo) ZeusTransformUtils.preCheckCast(r11.next(), PatchFetchInfo.class, "com.obric.aiagent.plugin");
        if (a(r3) == false) goto L4;
        Set<com.bytedance.reparo.core.g.h> r4 = r2.keySet();
        if (r2.size() == 0) goto L10;
        boolean r5 = false;
        Iterator<com.bytedance.reparo.core.g.h> r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        if (r3.equals((com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin")) == false) goto L13;
        r5 = true;
        goto L13
    L17:
        if (r5 == true) goto L4;
        r0.add(r3);
        goto L4
    L10:
        r0.add(r3);
        goto L4
    L19:
        return r0;
    }

    private boolean a(PatchFetchInfo r2) {
        if (TextUtils.equals(this.f9340e, r2.getHostAppVersion()) == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r2.getMd5()) == true) goto L9;
        if (TextUtils.isEmpty(r2.getUrl()) == true) goto L9;
        return true;
    }

    private void b(List<PatchFetchInfo> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d>> r9 = m.a().d().entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.g.h r2 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r1.getKey(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.h.d r3 = (com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(r1.getValue(), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        Iterator r5 = r7.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (((PatchFetchInfo) ZeusTransformUtils.preCheckCast(r5.next(), PatchFetchInfo.class, "com.obric.aiagent.plugin")).equals(r2) == false) goto L7;
        r4 = true;
        goto L7
    L11:
        if (r4 == true) goto L4;
        r3.h();
        goto L4
    L13:
        m.a().e();
    }

    ScheduledExecutorService b() {
        if (this.f9337b != null) goto L6;
        this.f9337b = Executors.newScheduledThreadPool(1, new com.bytedance.reparo.d.b("reparo"));
    L6:
        return this.f9337b;
    }

    boolean c() {
        return this.g;
    }

    public void d() {
        if (this.f == false) goto L5;
        return;
    L5:
        m.a().f();
    }

    @Override // com.bytedance.reparo.core.k.a
    public void onChanged(ConcurrentHashMap<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> r3) {
        Object[] r4 = new Object[1];
        if (this.f == false) goto L5;
        String r0 = InitTaskProcess.MAIN;
    L6:
        r4[0] = r0;
        com.bytedance.reparo.c.e.a(TAG, String.format("patch changed in %s process", r4));
        if (this.f == false) goto L10;
        ReparoProvider.notifySubProcess(this.f9338c);
        return;
    L10:
        return;
    L5:
        r0 = "sub";
        goto L6
    }

    void e() {
        if (this.g == false) goto L6;
        com.bytedance.reparo.core.a.b.b.delete(this.f9339d.a());
        m.a().g();
        return;
    }
}
