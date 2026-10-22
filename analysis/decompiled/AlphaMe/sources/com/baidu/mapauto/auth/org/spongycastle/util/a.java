package com.baidu.mapauto.auth.org.spongycastle.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.baidu.mapauto.auth.org.spongycastle.util.a$a, reason: collision with other inner class name */
    public static class C0021a<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T[] f7791a;

        /* renamed from: b, reason: collision with root package name */
        public int f7792b = 0;

        public C0021a(T[] tArr) {
            this.f7791a = tArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7792b < this.f7791a.length;
        }

        @Override // java.util.Iterator
        public final T next() {
            int i4 = this.f7792b;
            T[] tArr = this.f7791a;
            if (i4 != tArr.length) {
                this.f7792b = i4 + 1;
                return tArr[i4];
            }
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Out of elements: ");
            sbA.append(this.f7792b);
            throw new NoSuchElementException(sbA.toString());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 != bArr.length; i4++) {
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    public static int b(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i4 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i4;
            }
            i4 = (i4 * 257) ^ bArr[length];
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
