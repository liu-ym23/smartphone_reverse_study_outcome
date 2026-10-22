package kotlin.reflect.jvm.internal.impl.types.model;

import X8.N;
import a9.InterfaceC0312d;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class ArgumentList extends ArrayList<N> implements InterfaceC0312d {
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof N) {
            return super.contains((N) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof N) {
            return super.indexOf((N) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof N) {
            return super.lastIndexOf((N) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof N) {
            return super.remove((N) obj);
        }
        return false;
    }
}
