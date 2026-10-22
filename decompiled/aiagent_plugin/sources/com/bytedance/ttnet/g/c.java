package com.bytedance.ttnet.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModePriorityManagement.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends i.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f11449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f11450e;
    private final Set<String> f;
    private final Set<String> g;
    private int h;

    public c() {
        this.f11448c = new f();
        this.f11449d = new g();
        this.f11450e = new h();
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
        this.h = 60000;
    }

    private boolean d(com.bytedance.retrofit2.b.c r2) {
        this.f11448c.a(r2);
        if (this.f.isEmpty() == true) goto L7;
        return i.a(this.f, r2.o());
    L7:
        if (this.g.isEmpty() == false) goto L9;
        return false;
    L9:
        return !i.a(this.g, r2.o());
    }

    @Override // com.bytedance.retrofit2.f.a
    public void a(com.bytedance.retrofit2.b.c r8) {
        if (d(r8) == false) goto L6;
        this.f11483a.a(r8, false, true, this.h);
        return;
    }

    @Override // com.bytedance.retrofit2.f.a
    public boolean a(com.bytedance.retrofit2.b.c r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.aiagent.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.aiagent.plugin");
        if (d(r10) == true) goto L5;
        return false;
    L5:
        return this.f11483a.a(r10, false, this.h, r7, r8);
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.b.c c(com.bytedance.retrofit2.b.c r2) {
        com.bytedance.retrofit2.b.c r3 = this.f11449d.a(r2);
        return this.f11450e.a(r3);
    }

    @Override // com.bytedance.ttnet.g.i.a
    public boolean a(JSONObject r3) {
        super.a(r3);
        this.f11448c.a(r3);
        this.f11483a.a(r3, this.f11484b);
        JSONObject r0 = r3.optJSONObject("priority");
        if (this.f11448c.a() == true) goto L7;
        if (r0 != null) goto L7;
        return false;
    L7:
        this.f11449d.a(r0);
        this.f11450e.a(r3);
        JSONObject r4 = r3.optJSONObject("delay");
        if (r4 == null) goto L12;
        this.f.addAll(i.a(r4, "bl_with_priority"));
        this.g.addAll(i.a(r4, "wl_with_priority"));
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ttnet.g.i.a
    public void a() {
        super.a();
        this.f11450e.a();
    }

    @Override // com.bytedance.ttnet.g.i.a
    public void b() {
        super.b();
        this.f11450e.b();
        this.f11483a.a();
    }

    @Override // com.bytedance.ttnet.g.i.a
    i.b c() {
        return i.b.f11492d;
    }
}
