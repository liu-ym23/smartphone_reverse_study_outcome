package d7;

import java.util.AbstractSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class j extends AbstractSet implements Set, r7.e {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
