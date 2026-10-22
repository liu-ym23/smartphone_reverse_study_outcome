package D7;

import java.util.AbstractList;
import java.util.List;

/* renamed from: D7.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0218j extends AbstractList implements List, T7.c {
    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return removeAt(i);
    }

    public abstract Object removeAt(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
