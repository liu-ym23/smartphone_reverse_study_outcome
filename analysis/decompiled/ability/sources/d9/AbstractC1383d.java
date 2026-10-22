package d9;

import java.util.Iterator;

/* renamed from: d9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1383d implements Iterable, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC1380a f4305a;

    public final boolean isEmpty() {
        return this.f4305a.b() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f4305a.iterator();
    }
}
