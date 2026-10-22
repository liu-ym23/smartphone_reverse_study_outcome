package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f22629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f22630b;

    public a(c r3) {
        o.e(r3, "host");
        this.f22629a = r3;
        this.f22630b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final void a(d.h.a.b<? super i, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "block");
        i r0 = new i();
        r4.invoke(r0);
        ((Collection) ZeusTransformUtils.preCheckCast(this.f22630b, Collection.class, "com.obric.aiagent.plugin")).add(new j(r0.getType()));
    }

    public final void b(d.h.a.b<? super l, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "block");
        l r0 = new l();
        r4.invoke(r0);
        ((Collection) ZeusTransformUtils.preCheckCast(this.f22630b, Collection.class, "com.obric.aiagent.plugin")).add(new m(r0.getType(), r0.a()));
    }

    public final List<d> a() {
        return this.f22630b;
    }
}
