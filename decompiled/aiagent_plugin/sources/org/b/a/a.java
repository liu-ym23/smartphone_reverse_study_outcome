package org.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import org.b.b.j;
import org.b.e;

/* JADX INFO: compiled from: EventRecordingLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends org.b.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f40263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    j f40264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Queue<d> f40265c;

    @Override // org.b.c
    public boolean b() {
        return true;
    }

    @Override // org.b.c
    public boolean c() {
        return true;
    }

    @Override // org.b.c
    public boolean d() {
        return true;
    }

    @Override // org.b.c
    public boolean e() {
        return true;
    }

    @Override // org.b.c
    public boolean f() {
        return true;
    }

    public a(j r3, Queue<d> r4) {
        Queue<d> r5 = (Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.aiagent.plugin");
        this.f40264b = r3;
        this.f40263a = r3.a();
        this.f40265c = r5;
    }

    @Override // org.b.b.a, org.b.c
    public String a() {
        return this.f40263a;
    }

    @Override // org.b.b.a
    public void a(b r4, e r5, String r6, Object[] r7, Throwable r8) {
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.aiagent.plugin");
        d r0 = new d();
        r0.a(System.currentTimeMillis());
        r0.a(r4);
        r0.a(this.f40264b);
        r0.a(this.f40263a);
        if (r9 == null) goto L5;
        r0.a(r9);
    L5:
        r0.b(r6);
        r0.c(Thread.currentThread().getName());
        r0.a(r7);
        r0.a(r8);
        this.f40265c.add(r0);
    }
}
