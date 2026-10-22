package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import v2.e;
import x2.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SerializedString implements e, Serializable {
    public static final c h = c.f13724c;

    /* renamed from: a, reason: collision with root package name */
    public final String f3610a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f3611b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3612c;

    /* renamed from: d, reason: collision with root package name */
    public char[] f3613d;

    /* renamed from: e, reason: collision with root package name */
    public transient String f3614e;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.f3610a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f3614e = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.f3610a);
    }

    @Override // v2.e
    public final int a(char[] cArr, int i10) {
        char[] cArrD = this.f3613d;
        if (cArrD == null) {
            h.getClass();
            cArrD = c.d(this.f3610a);
            this.f3613d = cArrD;
        }
        int length = cArrD.length;
        if (i10 + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArrD, 0, cArr, i10, length);
        return length;
    }

    @Override // v2.e
    public final char[] b() {
        char[] cArr = this.f3613d;
        if (cArr != null) {
            return cArr;
        }
        h.getClass();
        char[] cArrD = c.d(this.f3610a);
        this.f3613d = cArrD;
        return cArrD;
    }

    @Override // v2.e
    public final byte[] c() {
        byte[] bArr = this.f3611b;
        if (bArr != null) {
            return bArr;
        }
        h.getClass();
        byte[] bArrE = c.e(this.f3610a);
        this.f3611b = bArrE;
        return bArrE;
    }

    @Override // v2.e
    public final int d(byte[] bArr, int i10) {
        byte[] bArrE = this.f3611b;
        if (bArrE == null) {
            h.getClass();
            bArrE = c.e(this.f3610a);
            this.f3611b = bArrE;
        }
        int length = bArrE.length;
        if (i10 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrE, 0, bArr, i10, length);
        return length;
    }

    @Override // v2.e
    public final int e(char[] cArr, int i10) {
        String str = this.f3610a;
        int length = str.length();
        if (i10 + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i10);
        return length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f3610a.equals(((SerializedString) obj).f3610a);
    }

    @Override // v2.e
    public final int f(byte[] bArr, int i10) {
        byte[] bArrC = this.f3612c;
        if (bArrC == null) {
            h.getClass();
            bArrC = c.c(this.f3610a);
            this.f3612c = bArrC;
        }
        int length = bArrC.length;
        if (i10 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrC, 0, bArr, i10, length);
        return length;
    }

    @Override // v2.e
    public final byte[] g() {
        byte[] bArr = this.f3612c;
        if (bArr != null) {
            return bArr;
        }
        h.getClass();
        byte[] bArrC = c.c(this.f3610a);
        this.f3612c = bArrC;
        return bArrC;
    }

    @Override // v2.e
    public final String getValue() {
        return this.f3610a;
    }

    public final int hashCode() {
        return this.f3610a.hashCode();
    }

    public Object readResolve() {
        return new SerializedString(this.f3614e);
    }

    public final String toString() {
        return this.f3610a;
    }
}
