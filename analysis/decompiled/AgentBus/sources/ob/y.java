package ob;

import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class y extends d7.f implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final k[] f8040f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f8041g;

    public y(k[] kVarArr, int[] iArr) {
        this.f8040f = kVarArr;
        this.f8041g = iArr;
    }

    @Override // d7.a
    public final int a() {
        return this.f8040f.length;
    }

    @Override // d7.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof k) {
            return super.contains((k) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        return this.f8040f[i2];
    }

    @Override // d7.f, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof k) {
            return super.indexOf((k) obj);
        }
        return -1;
    }

    @Override // d7.f, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof k) {
            return super.lastIndexOf((k) obj);
        }
        return -1;
    }
}
