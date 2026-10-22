package k3;

import java.util.RandomAccess;
import kotlin.collections.AbstractList;

/* loaded from: classes2.dex */
public final class t extends AbstractList implements RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f13376c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final l[] f13377a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f13378b;

    public t(l[] lVarArr, int[] iArr) {
        this.f13377a = lVarArr;
        this.f13378b = iArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof l) {
            return super.contains((l) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i4) {
        return this.f13377a[i4];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public final int get_size() {
        return this.f13377a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof l) {
            return super.indexOf((l) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof l) {
            return super.lastIndexOf((l) obj);
        }
        return -1;
    }
}
