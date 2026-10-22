package com.airbnb.lottie.model;

import B0.d;

/* loaded from: classes.dex */
public class MutablePair<T> {
    T first;
    T second;

    private static boolean objectsEqual(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return objectsEqual(dVar.f1411a, this.first) && objectsEqual(dVar.f1412b, this.second);
    }

    public int hashCode() {
        T t10 = this.first;
        int iHashCode = t10 == null ? 0 : t10.hashCode();
        T t11 = this.second;
        return iHashCode ^ (t11 != null ? t11.hashCode() : 0);
    }

    public void set(T t10, T t11) {
        this.first = t10;
        this.second = t11;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
