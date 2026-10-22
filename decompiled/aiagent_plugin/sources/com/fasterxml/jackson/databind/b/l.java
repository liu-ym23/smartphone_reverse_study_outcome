package com.fasterxml.jackson.databind.b;

/* JADX INFO: compiled from: DataFormatReaders.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.u[] f12527a;

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append('[');
        com.fasterxml.jackson.databind.u[] r1 = this.f12527a;
        int r2 = r1.length;
        if (r2 <= 0) goto L7;
        r0.append(r1[0].b().d());
        int r3 = 1;
    L5:
        if (r3 >= r2) goto L7;
        r0.append(", ");
        r0.append(this.f12527a[r3].b().d());
        r3 = r3 + 1;
    L7:
        r0.append(']');
        return r0.toString();
    }
}
