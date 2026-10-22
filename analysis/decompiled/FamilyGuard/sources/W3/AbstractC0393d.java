package W3;

import java.util.AbstractList;
import java.util.List;
import k4.InterfaceC0815b;

/* renamed from: W3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0393d<E> extends AbstractList<E> implements List<E>, InterfaceC0815b {
    protected AbstractC0393d() {
    }

    public abstract int a();

    public abstract E c(int i5);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i5) {
        return c(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
