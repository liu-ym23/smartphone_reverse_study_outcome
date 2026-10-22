package com.google.android.gms.internal.location;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class f extends l {

    /* renamed from: a, reason: collision with root package name */
    public final int f9963a;

    /* renamed from: b, reason: collision with root package name */
    public int f9964b;

    public f(int i4, int i5) {
        if (i5 < 0 || i5 > i4) {
            throw new IndexOutOfBoundsException(com.airbnb.lottie.h.P(i5, i4, MapBundleKey.MapObjKey.OBJ_SL_INDEX));
        }
        this.f9963a = i4;
        this.f9964b = i5;
    }

    public abstract Object b(int i4);

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f9964b < this.f9963a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9964b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i4 = this.f9964b;
        this.f9964b = i4 + 1;
        return b(i4);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9964b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i4 = this.f9964b - 1;
        this.f9964b = i4;
        return b(i4);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9964b - 1;
    }
}
