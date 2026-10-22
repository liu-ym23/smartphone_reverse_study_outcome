package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.m.c<? extends f> f22637a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22637a, r6.f22637a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f22637a.hashCode();
    }

    public String toString() {
        return "LogicComponentSpec(type=" + this.f22637a + ')';
    }

    public j(d.m.c<? extends f> r3) {
        d.m.c<? extends f> r4 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "type");
        super(null);
        this.f22637a = r4;
    }

    @Override // com.obric.autoaction.a.d
    public d.m.c<? extends f> getType() {
        return this.f22637a;
    }
}
