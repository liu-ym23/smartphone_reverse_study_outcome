package kotlin.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f21116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext.Key f21117b;

    public b(CoroutineContext.Key r10, Function1 r11) {
        q.g(r10, "baseKey");
        q.g(r11, "safeCast");
        this.f21116a = r11;
        if ((r10 instanceof b) == false) goto L5;
        r10 = ((b) r10).f21117b;
    L5:
        this.f21117b = r10;
    }

    public final boolean a(CoroutineContext.Key r10) {
        q.g(r10, "key");
        if (r10 != this) goto L5;
    L8:
        return true;
    L5:
        if (this.f21117b == r10) goto L8;
        return false;
    }

    public final CoroutineContext.Element b(CoroutineContext.Element r10) {
        q.g(r10, "element");
        return (CoroutineContext.Element) this.f21116a.invoke(r10);
    }
}
