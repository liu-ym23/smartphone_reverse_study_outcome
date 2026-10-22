package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public ArgumentList(int r1) {
        super(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return contains((TypeArgumentMarker) r2);
    }

    public /* bridge */ boolean contains(TypeArgumentMarker r1) {
        return super.contains(r1);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return indexOf((TypeArgumentMarker) r2);
    }

    public /* bridge */ int indexOf(TypeArgumentMarker r1) {
        return super.indexOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((TypeArgumentMarker) r2);
    }

    public /* bridge */ int lastIndexOf(TypeArgumentMarker r1) {
        return super.lastIndexOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return remove((TypeArgumentMarker) r2);
    }

    public /* bridge */ boolean remove(TypeArgumentMarker r1) {
        return super.remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
