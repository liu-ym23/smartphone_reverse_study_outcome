package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class Count implements Serializable {
    private int value;

    public Count(int r10) {
        this.value = r10;
    }

    public void add(int r10) {
        this.value += r10;
    }

    public int addAndGet(int r10) {
        int r11 = this.value + r10;
        this.value = r11;
        return r11;
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof Count) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Count) r10).value != this.value) goto L7;
        return true;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int r10) {
        int r11 = this.value;
        this.value = r10;
        return r11;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int r10) {
        this.value = r10;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
