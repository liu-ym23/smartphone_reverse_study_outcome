package i9;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: i9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1566a implements i {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f4616a;

    public C1566a(i iVar) {
        this.f4616a = new AtomicReference(iVar);
    }

    @Override // i9.i
    public final Iterator iterator() {
        i iVar = (i) this.f4616a.getAndSet(null);
        if (iVar != null) {
            return iVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
