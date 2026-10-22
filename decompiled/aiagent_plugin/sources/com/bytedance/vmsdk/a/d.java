package com.bytedance.vmsdk.a;

import com.bytedance.vmsdk.a.a.b.g;
import com.bytedance.vmsdk.a.a.b.i;
import com.bytedance.vmsdk.worker.JsWorker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: InspectorClientNew.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {
    private static final String TAG = "Inspector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.vmsdk.a.a.c f11726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile g f11727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JsWorker f11729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11730e;
    private final com.bytedance.vmsdk.a.a.a.a f;
    private final i g;
    private final List<c> h;

    public d(JsWorker r4) {
        if (f11726a != null) goto L5;
        f11726a = new com.bytedance.vmsdk.a.a.c();
        f11726a.a();
    L5:
        this.h = new LinkedList();
        if (r4.EngineType() != JsWorker.EngineType.V8) goto L8;
        String r0 = "V8";
    L9:
        this.f11728c = "VMSDK_JSWorker_" + r0;
        String r1 = "/inspector/" + r4.getNativePtr();
        this.f11730e = r1;
        this.f11729d = r4;
        this.f = new com.bytedance.vmsdk.a.a.a.a(r1);
        this.g = new i(new a(this));
        f11726a.a(this);
        return;
    L8:
        r0 = "QuickJS";
        goto L9
    }

    public String a() {
        return this.f11728c;
    }

    public String b() {
        return this.f11730e;
    }

    public com.bytedance.vmsdk.a.a.a.a c() {
        return this.f;
    }

    public i d() {
        return this.g;
    }

    @Override // com.bytedance.vmsdk.a.c
    public void a(g r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.aiagent.plugin");
        this.f11727b = r6;
        Iterator<c> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin")).a(r6);
        goto L4
    L6:
        this.f11729d.onOpenInspectorSession();
    }

    @Override // com.bytedance.vmsdk.a.c
    public boolean a(g r5, String r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.aiagent.plugin");
        Iterator<c> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin")).a(r7, r6) == false) goto L4;
        return true;
    L9:
        this.f11729d.onInspectorMessage(r6);
        return false;
    }

    @Override // com.bytedance.vmsdk.a.c
    public void b(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        this.f11727b = null;
        this.f11729d.onCloseInspectorSession();
        Iterator<c> r3 = this.h.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin")).b(r5);
        goto L4
    }

    public void a(String r2) {
        if (this.f11727b != null) goto L5;
        return;
    L5:
        this.f11727b.a(r2);
    }

    public void e() {
        f11726a.b(this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (Objects.equals(this.f11728c, r6.f11728c) == false) goto L16;
        if (Objects.equals(this.f11730e, r6.f11730e) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f11728c, this.f11730e});
    }
}
