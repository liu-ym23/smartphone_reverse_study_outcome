package kotlin.reflect.jvm.internal.impl.types.model;

import Ca.j;
import Ca.k;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class ArgumentList extends ArrayList<k> implements j {
    public ArgumentList(int i10) {
        super(i10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof k) {
            return f((k) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(k kVar) {
        return super.contains(kVar);
    }

    public /* bridge */ int i() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof k) {
            return j((k) obj);
        }
        return -1;
    }

    public /* bridge */ int j(k kVar) {
        return super.indexOf(kVar);
    }

    public /* bridge */ int k(k kVar) {
        return super.lastIndexOf(kVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof k) {
            return k((k) obj);
        }
        return -1;
    }

    public /* bridge */ boolean n(k kVar) {
        return super.remove(kVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof k) {
            return n((k) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return i();
    }
}
