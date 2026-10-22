package d7;

import java.util.AbstractList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends AbstractList implements List, r7.c {
    public abstract int a();

    public abstract Object f(int i2);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i2) {
        return f(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
