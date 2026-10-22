package ba;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class d implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public a f1594f;

    public final boolean isEmpty() {
        return this.f1594f.a() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f1594f.iterator();
    }
}
