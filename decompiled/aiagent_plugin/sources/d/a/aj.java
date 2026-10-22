package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class aj<T> implements d.h.b.a.a, Iterable<ai<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<Iterator<T>> f38350a;

    public aj(d.h.a.a<? extends Iterator<? extends T>> r3) {
        d.h.a.a<Iterator<T>> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "iteratorFactory");
        this.f38350a = r4;
    }

    @Override // java.lang.Iterable
    public Iterator<ai<T>> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new ak((Iterator) ZeusTransformUtils.preCheckCast(this.f38350a.invoke(), Iterator.class, "com.obric.aiagent.plugin")), Iterator.class, "com.obric.aiagent.plugin");
    }
}
