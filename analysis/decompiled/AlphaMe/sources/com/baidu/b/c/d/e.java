package com.baidu.b.c.d;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private BigInteger f4859a;

    /* renamed from: b, reason: collision with root package name */
    private BigInteger f4860b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f4859a = new BigInteger(bArr);
        this.f4860b = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger a() {
        return this.f4859a;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger b() {
        return this.f4860b;
    }
}
