package com.bytedance.applog.engine;

import android.content.Context;
import com.bytedance.applog.k;
import com.bytedance.applog.log.f;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.g;
import com.bytedance.applog.util.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ForwardSender.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f5606d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.applog.f.a f5607e;

    @Override // com.bytedance.applog.engine.a
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.applog.engine.a
    public String f() {
        return "ForwardSender";
    }

    static {
        f5606d = Collections.singletonList("ForwardSender");
    }

    public c(Engine r1, com.bytedance.applog.f.a r2) {
        super(r1);
        this.f5607e = r2;
    }

    @Override // com.bytedance.applog.engine.a
    public long d() {
        com.bytedance.applog.f.a r0 = this.f5607e;
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        return this.f5601a.getConfig().s();
    }

    @Override // com.bytedance.applog.engine.a
    public long[] e() {
        return f5600c;
    }

    @Override // com.bytedance.applog.engine.a
    public synchronized boolean b(int r10) {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L25
        e r2 = this.f5601a.getSession();     // Catch: Throwable -> L25
        f r3 = b().Z();     // Catch: Throwable -> L25
        List<String> r4 = f5606d;     // Catch: Throwable -> L25
        Object[] r6 = new Object[4];     // Catch: Throwable -> L25
        boolean r8 = false;
        r6[0] = f();     // Catch: Throwable -> L25
        r6[1] = Long.valueOf(r0);     // Catch: Throwable -> L25
        if (r2 == null) goto L6;
        String r5 = r2.b();     // Catch: Throwable -> L25
    L7:
        r6[2] = r5;     // Catch: Throwable -> L25
        r6[3] = Integer.valueOf(r10);     // Catch: Throwable -> L25
        r3.b(r4, "{} start doWork curTs={}, curSid={}, requestFrom={}", r6);     // Catch: Throwable -> L25
        DbStore r1 = this.f5601a.getDbStore();     // Catch: Throwable -> L25
        com.bytedance.applog.j.c r7 = this.f5601a.getDm();     // Catch: Throwable -> L25
        if (r7.e() == true) goto L10;
    L23:
        monitor-exit(this);
        return r8;
    L10:
        if (this.f5607e == null) goto L23;
        JSONObject r9 = m.a(r7.a());     // Catch: Throwable -> L25
        k r11 = b().s();     // Catch: Throwable -> L25
        if (r11 != null) goto L28;
    L17:
        List<com.bytedance.applog.store.e> r12 = r1.f();     // Catch: Throwable -> L25
        if (r12 != null) goto L20;
    L22:
        r8 = true;
        goto L23
    L20:
        if (r12.isEmpty() == true) goto L22;
        r1.b(r12);     // Catch: Throwable -> L25
        a(r12, r9, r10);     // Catch: Throwable -> L25
        goto L22
    L28:
        r11.a(r9);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        b().N().increaseStats(j.f5823J);     // Catch: Throwable -> L25
        b().N().sendError("HeaderCustomTimelyCallback update header failed", th);     // Catch: Throwable -> L25
        b().Z().a(f5606d, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L25
        goto L17
    L6:
        r5 = "null";
    L25:
        th = move-exception;
        throw th;
    }

    private void a(List<com.bytedance.applog.store.e> r19, JSONObject r20, int r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if (this.f5607e != null) goto L5;
        return;
    L5:
        Iterator r2 = r1.iterator();
        ArrayList r3 = new ArrayList();
        HashSet r4 = new HashSet();
    L6:
        boolean r6 = true;
        if (r2.hasNext() == false) goto L19;
        JSONArray r5 = new JSONArray();
        g r15 = new g();
        r15.a(b().b(), r20, null, null, null, new JSONArray[]{null, r5, null}, new long[]{0, 0, 0}, null, null, r21);
    L10:
        if (r2.hasNext() == false) goto L18;
        com.bytedance.applog.store.e r7 = (com.bytedance.applog.store.e) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.store.e.class, "com.obric.aiagent.plugin");
        r5.put(r7.k());
        if (l.a() == true) goto L17;
        if (r7.q <= 0) goto L17;
        r4.add(Long.valueOf(r7.q));
    L17:
        if (r5.length() != 200) goto L10;
    L18:
        r15.r();
        r3.add(r15);
        goto L6
    L19:
        String r8 = b().U().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f5607e.i());
        Iterator r9 = r3.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        r6 = r6 & b().V().a(r8, (g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.aiagent.plugin"));
        goto L21
    L23:
        a(this.f5601a.getAppLog().b(), r4, r6);
    }

    private void a(final String r3, Set<Long> r4, final boolean r5) {
        final Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        if (l.a() == false) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.isEmpty() == true) goto L12;
        l.a("event_upload_eid", new AnonymousClass1(this, r3, r6, r5));
        return;
    }
}
