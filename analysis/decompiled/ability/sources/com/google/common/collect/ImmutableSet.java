package com.google.common.collect;

import B7.a;
import N9.j;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import m3.C1674a;

/* loaded from: classes3.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    public static final /* synthetic */ int c = 0;
    public transient ImmutableList b;

    public static class SerializedForm implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f2750a;

        public SerializedForm(Object[] objArr) {
            this.f2750a = objArr;
        }

        public Object readResolve() {
            int i = ImmutableSet.c;
            Object[] objArr = this.f2750a;
            int length = objArr.length;
            return length != 0 ? length != 1 ? ImmutableSet.j(objArr.length, (Object[]) objArr.clone()) : new SingletonImmutableSet(objArr[0]) : RegularImmutableSet.f2751j;
        }
    }

    public static int i(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return BasicMeasure.EXACTLY;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static ImmutableSet j(int i, Object... objArr) {
        if (i == 0) {
            return RegularImmutableSet.f2751j;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new SingletonImmutableSet(obj);
        }
        int i6 = i(i);
        Object[] objArr2 = new Object[i6];
        int i10 = i6 - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i; i13++) {
            Object obj2 = objArr[i13];
            if (obj2 == null) {
                throw new NullPointerException(a.h(i13, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iP = j.P(iHashCode);
            while (true) {
                int i14 = iP & i10;
                Object obj3 = objArr2[i14];
                if (obj3 == null) {
                    objArr[i12] = obj2;
                    objArr2[i14] = obj2;
                    i11 += iHashCode;
                    i12++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iP++;
            }
        }
        Arrays.fill(objArr, i12, i, (Object) null);
        if (i12 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new SingletonImmutableSet(obj4);
        }
        if (i(i12) < i6 / 2) {
            return j(i12, objArr);
        }
        int length = objArr.length;
        if (i12 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i12);
        }
        return new RegularImmutableSet(objArr, objArr2, i11, i10, i12);
    }

    public static ImmutableSet n() {
        return RegularImmutableSet.f2751j;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && (this instanceof RegularImmutableSet)) {
            ImmutableSet immutableSet = (ImmutableSet) obj;
            immutableSet.getClass();
            if ((immutableSet instanceof RegularImmutableSet) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public ImmutableList h() {
        ImmutableList immutableList = this.b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList immutableListL = l();
        this.b = immutableListL;
        return immutableListL;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            E next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public ImmutableList l() {
        Object[] array = toArray(ImmutableCollection.f2746a);
        C1674a c1674a = ImmutableList.b;
        int length = array.length;
        return length == 0 ? RegularImmutableList.e : new RegularImmutableList(array, length);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray(ImmutableCollection.f2746a));
    }
}
