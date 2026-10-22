package com.obric.autogui.agents.vlm.models.impl.e.f;

import com.obric.autogui.agents.scripted.impl.w;
import com.obric.autogui.agents.vlm.models.impl.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: ScriptExecutionStats.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f27881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w.a f27882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.agents.scripted.b.b f27883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27884e;
    private String f;
    private boolean g;
    private boolean h;

    public d() {
        this.f27884e = "success";
    }

    public final int a() {
        return this.f27880a;
    }

    public final String b() {
        return this.f27881b;
    }

    public final w.a c() {
        return this.f27882c;
    }

    public final com.obric.autogui.agents.scripted.b.b d() {
        return this.f27883d;
    }

    public final String e() {
        return this.f27884e;
    }

    public final String f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final boolean i() {
        return o.a(this.f27884e, "success");
    }

    public final void a(int r2) {
        this.f27880a += r2;
    }

    public final void a(String r2) {
        o.e(r2, "name");
        this.f27881b = r2;
    }

    public final void a(w.a r2) {
        o.e(r2, "snapshot");
        this.f27882c = r2;
    }

    public final void a(com.obric.autogui.agents.scripted.b.b r2) {
        o.e(r2, "measurement");
        this.f27883d = r2;
    }

    public final void a(l.b<?> r3) {
        o.e(r3, "logicResult");
        if (ZeusTransformUtils.instanceOf(r3, l.b.C0700b.class) == false) goto L6;
        this.f27884e = "success";
        this.f = null;
        this.g = false;
        this.h = false;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, l.b.a.class) == false) goto L10;
        this.f27884e = ((l.b.a) ZeusTransformUtils.preCheckCast(r3, l.b.a.class, "com.obric.aiagent.plugin")).a();
        this.f = ((l.b.a) ZeusTransformUtils.preCheckCast(r3, l.b.a.class, "com.obric.aiagent.plugin")).h();
        this.g = ((l.b.a) ZeusTransformUtils.preCheckCast(r3, l.b.a.class, "com.obric.aiagent.plugin")).b();
        this.h = ((l.b.a) ZeusTransformUtils.preCheckCast(r3, l.b.a.class, "com.obric.aiagent.plugin")).c();
        return;
    L10:
        throw new k();
    }

    public final void a(Exception r13) {
        o.e(r13, "e");
        this.f27884e = "execution_exception";
        this.f = p.a((Iterable) ZeusTransformUtils.preCheckCast(p.e(new String[]{aa.b(r13.getClass()).b(), r13.getMessage()}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(": ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        this.g = true;
        this.h = true;
    }
}
