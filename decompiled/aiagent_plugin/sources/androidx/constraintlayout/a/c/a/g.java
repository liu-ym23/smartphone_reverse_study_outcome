package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: DimensionDependency.java */
/* JADX INFO: loaded from: classes.dex */
class g extends f {
    public int m;

    public g(p r2) {
        super(r2);
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L5;
        this.f713e = f.a.f715b;
        return;
    L5:
        this.f713e = f.a.f716c;
    }

    @Override // androidx.constraintlayout.a.c.a.f
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
