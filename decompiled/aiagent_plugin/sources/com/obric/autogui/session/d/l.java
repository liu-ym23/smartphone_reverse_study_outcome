package com.obric.autogui.session.d;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SessionAsyncResources.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.session.a f30928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f30929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f30930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f30931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f30932e;
    private final j f;
    private final List<a<?>> g;

    public l(com.obric.autogui.session.a r8) {
        o.e(r8, SensitiveType.SESSION);
        this.f30928a = r8;
        j r1 = null;
        if (k() == false) goto L5;
        h r0 = new h(r8);
    L6:
        this.f30929b = r0;
        if (k() == false) goto L9;
        f r2 = new f(r8);
    L10:
        this.f30930c = r2;
        if (k() == false) goto L13;
        m r3 = new m(r8);
    L14:
        this.f30931d = r3;
        if (k() == false) goto L17;
        k r4 = new k(r8, p.q((Iterable) ZeusTransformUtils.preCheckCast(r8.S(), Iterable.class, "com.obric.aiagent.plugin")));
    L18:
        this.f30932e = r4;
        if (com.obric.autogui.common.a.d.f28974a.B() == false) goto L21;
        r1 = new j(r8);
    L21:
        this.f = r1;
        this.g = p.b(new a[]{r0, this.f30930c, r3, r4, r1});
        return;
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public final h a() {
        return this.f30929b;
    }

    public final void a(f r1) {
        this.f30930c = r1;
    }

    public final f b() {
        return this.f30930c;
    }

    public final m c() {
        return this.f30931d;
    }

    public final k d() {
        return this.f30932e;
    }

    public final j e() {
        return this.f;
    }

    private final boolean k() {
        return com.obric.autogui.common.a.d.f28974a.q();
    }

    public final void f() {
        if (k() == true) goto L5;
        return;
    L5:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        r0.b();
        goto L7
    }

    public final void g() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.c();
        goto L4
    }

    public final void h() {
        if (k() == true) goto L5;
        return;
    L5:
        k r0 = this.f30932e;
        if (r0 == null) goto L9;
        r0.a(p.q((Iterable) ZeusTransformUtils.preCheckCast(this.f30928a.S(), Iterable.class, "com.obric.aiagent.plugin")));
        return;
    }

    public final void i() {
        m r0 = this.f30931d;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final boolean j() {
        m r2 = this.f30931d;
        if (r2 == null) goto L8;
        if (r2.g() != true) goto L8;
        return true;
    L8:
        return false;
    }
}
