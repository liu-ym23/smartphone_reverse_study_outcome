package W3;

import java.util.Iterator;
import k4.InterfaceC0814a;

/* renamed from: W3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0402m implements Iterator<Character>, InterfaceC0814a {
    public abstract char b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
