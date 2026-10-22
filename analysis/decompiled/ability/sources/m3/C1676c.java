package m3;

import java.util.NoSuchElementException;

/* renamed from: m3.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1676c extends AbstractC1677d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5300a;
    public final /* synthetic */ Object b;

    public C1676c(Object obj) {
        this.b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f5300a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5300a) {
            throw new NoSuchElementException();
        }
        this.f5300a = true;
        return this.b;
    }
}
