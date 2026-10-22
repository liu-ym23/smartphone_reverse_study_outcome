package d.j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m.h;

/* JADX INFO: compiled from: ObservableProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b<V> implements c<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private V f38511a;

    public void a(h<?> r1, V r2, V r3) {
        o.e((h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.aiagent.plugin"), "property");
    }

    public boolean b(h<?> r1, V r2, V r3) {
        o.e((h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.aiagent.plugin"), "property");
        return true;
    }

    public b(V r1) {
        this.f38511a = r1;
    }

    @Override // d.j.c
    public V getValue(Object r2, h<?> r3) {
        o.e((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), "property");
        return this.f38511a;
    }

    @Override // d.j.c
    public void setValue(Object r2, h<?> r3, V r4) {
        h<?> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        o.e(r5, "property");
        V r6 = this.f38511a;
        if (b(r5, r6, r4) == true) goto L5;
        return;
    L5:
        this.f38511a = r4;
        a(r5, r6, r4);
    }

    public String toString() {
        return "ObservableProperty(value=" + this.f38511a + ')';
    }
}
