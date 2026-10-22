package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes39.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;
    private Class<?> third;

    public int hashCode() {
        int r100 = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        Class<?> r101 = this.third;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }

    public MultiClassKey() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L20;
        MultiClassKey r101 = (MultiClassKey) r100;
        if (this.first.equals(r101.first) == true) goto L14;
        return false;
    L14:
        if (this.second.equals(r101.second) == true) goto L17;
        return false;
    L17:
        if (Util.bothNullOrEqual(this.third, r101.third) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public MultiClassKey(Class<?> r100, Class<?> r101) {
        set(r100, r101);
    }

    public void set(Class<?> r100, Class<?> r101) {
        set(r100, r101, null);
    }

    public MultiClassKey(Class<?> r100, Class<?> r101, Class<?> r102) {
        set(r100, r101, r102);
    }

    public void set(Class<?> r100, Class<?> r101, Class<?> r102) {
        this.first = r100;
        this.second = r101;
        this.third = r102;
    }
}
