package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: DimensionDependency.java */
/* JADX INFO: loaded from: classes4.dex */
class g extends f {
    public int m;

    g(p r2) {
        super(r2);
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L5;
        this.f34694e = f.a.f34696b;
        return;
    L5:
        this.f34694e = f.a.f34697c;
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.f
    public void a(int r3) {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.g = r3;
        Iterator<d> r2 = this.k.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.aiagent.plugin");
        r4.update(r4);
        goto L7
    }
}
