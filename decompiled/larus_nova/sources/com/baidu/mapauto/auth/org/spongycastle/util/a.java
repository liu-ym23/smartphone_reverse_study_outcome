package com.baidu.mapauto.auth.org.spongycastle.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: com.baidu.mapauto.auth.org.spongycastle.util.a$a, reason: collision with other inner class name */
    public static class C0635a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T[] f31911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f31912b;

        public C0635a(T[] r100) {
            this.f31912b = 0;
            this.f31911a = r100;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f31912b >= this.f31911a.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }

        @Override // java.util.Iterator
        public final T next() {
            int r100 = this.f31912b;
            T[] r101 = this.f31911a;
            if (r100 == r101.length) goto L6;
            this.f31912b = r100 + 1;
            return r101[r100];
        L6:
            StringBuilder r102 = com.baidu.mapauto.auth.b.a("Out of elements: ");
            r102.append(this.f31912b);
            throw new NoSuchElementException(r102.toString());
        }
    }

    public static boolean a(byte[] r100, byte[] r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if (r100.length == r101.length) goto L12;
        return false;
    L12:
        int r102 = 0;
    L14:
        if (r102 == r100.length) goto L19;
        if (r100[r102] != r101[r102]) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L20:
        return false;
    }

    public static byte[] a(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[] r101 = new byte[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static int b(byte[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L9;
        r102 = (r102 * 257) ^ r100[r101];
        goto L6
    L9:
        return r102;
    }
}
