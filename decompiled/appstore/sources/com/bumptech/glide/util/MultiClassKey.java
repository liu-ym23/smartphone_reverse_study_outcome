package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;
    private Class<?> third;

    public MultiClassKey() {
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L20;
        MultiClassKey r11 = (MultiClassKey) r10;
        if (this.first.equals(r11.first) == true) goto L14;
        return false;
    L14:
        if (this.second.equals(r11.second) == true) goto L17;
        return false;
    L17:
        if (Util.bothNullOrEqual(this.third, r11.third) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        int r10 = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        Class<?> r11 = this.third;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    public void set(@NonNull Class<?> r10, @NonNull Class<?> r11) {
        set(r10, r11, null);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }

    public MultiClassKey(@NonNull Class<?> r10, @NonNull Class<?> r11) {
        set(r10, r11);
    }

    public void set(@NonNull Class<?> r10, @NonNull Class<?> r11, @Nullable Class<?> r12) {
        this.first = r10;
        this.second = r11;
        this.third = r12;
    }

    public MultiClassKey(@NonNull Class<?> r10, @NonNull Class<?> r11, @Nullable Class<?> r12) {
        set(r10, r11, r12);
    }
}
