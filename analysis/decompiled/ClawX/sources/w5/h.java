package w5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f6215a;

    /* renamed from: b, reason: collision with root package name */
    public int f6216b = -2;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c5.k f6217c;

    public h(c5.k kVar) {
        this.f6217c = kVar;
    }

    public final void a() {
        Object objInvoke;
        if (this.f6216b == -2) {
            objInvoke = ((com.stepos.stepclaw.memory.lightmem.f) this.f6217c.f1090b).invoke();
        } else {
            x5.k kVar = x5.k.f6300a;
            Object obj = this.f6215a;
            p.b(obj);
            objInvoke = kVar.invoke(obj);
        }
        this.f6215a = objInvoke;
        this.f6216b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6216b < 0) {
            a();
        }
        return this.f6216b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f6216b < 0) {
            a();
        }
        if (this.f6216b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f6215a;
        p.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.f6216b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
