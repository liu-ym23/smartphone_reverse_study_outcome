package com.baidu.b.c.a;

import java.security.InvalidKeyException;

/* loaded from: classes.dex */
abstract class f {

    /* renamed from: b, reason: collision with root package name */
    final b f4832b;

    /* renamed from: c, reason: collision with root package name */
    final int f4833c;

    /* renamed from: d, reason: collision with root package name */
    byte[] f4834d;

    public f(b bVar) {
        this.f4832b = bVar;
        this.f4833c = bVar.a();
    }

    public abstract void a();

    public abstract void a(boolean z4, String str, byte[] bArr, byte[] bArr2) throws InvalidKeyException;

    public abstract void a(byte[] bArr, int i4, int i5, byte[] bArr2, int i6);

    public abstract void b();

    public abstract void b(byte[] bArr, int i4, int i5, byte[] bArr2, int i6);

    public abstract void c();

    public void c(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        a(bArr, i4, i5, bArr2, i6);
    }

    public void d(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        b(bArr, i4, i5, bArr2, i6);
    }
}
