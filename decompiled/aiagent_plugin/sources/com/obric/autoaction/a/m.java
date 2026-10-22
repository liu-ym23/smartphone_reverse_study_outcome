package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.m.c<? extends g> f22642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f22643b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22642a, r6.f22642a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22643b, r6.f22643b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f22642a.hashCode() * 31;
        Integer r1 = this.f22643b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "UISlotComponentSpec(type=" + this.f22642a + ", slotId=" + this.f22643b + ')';
    }

    @Override // com.obric.autoaction.a.d
    public d.m.c<? extends g> getType() {
        return this.f22642a;
    }

    public final Integer a() {
        return this.f22643b;
    }

    public m(d.m.c<? extends g> r3, Integer r4) {
        d.m.c<? extends g> r5 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r5, "type");
        super(null);
        this.f22642a = r5;
        this.f22643b = r4;
    }
}
