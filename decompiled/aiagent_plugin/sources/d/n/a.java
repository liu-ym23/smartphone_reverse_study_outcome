package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<j<T>> f38563a;

    public a(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "sequence");
        this.f38563a = new AtomicReference(r4);
    }

    @Override // d.n.j
    public Iterator<T> a() {
        j r2 = (j) ZeusTransformUtils.preCheckCast(this.f38563a.getAndSet(null), j.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        return r2.a();
    L7:
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
