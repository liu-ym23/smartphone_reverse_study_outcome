package com.obric.autogui.util.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: BaseState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f31503a;

    @Override // com.obric.autogui.util.c.b
    public void a(b r2) {
        o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "toState");
    }

    @Override // com.obric.autogui.util.c.b
    public void b(b r2) {
        o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "fromState");
    }

    public a(String r2) {
        o.e(r2, "name");
        this.f31503a = r2;
    }

    @Override // com.obric.autogui.util.c.b
    public Object a(b r3, d<? super x> r4) {
        return b.a.a(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.util.c.b
    public void c() {
        b.a.a(this);
    }

    public final String i() {
        return this.f31503a;
    }

    public String toString() {
        return "[State/" + this.f31503a + ']';
    }
}
