package com.baidu.bbalbscesium.k.d;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes39.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f30381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f30382b;

    public e(BigInteger r100, BigInteger r101) {
        this.f30381a = r100;
        this.f30382b = r101;
    }

    public e(byte[] r100, byte[] r101) {
        this.f30381a = new BigInteger(r100);
        this.f30382b = new BigInteger(r101);
    }

    @Override // com.baidu.bbalbscesium.k.d.d
    public BigInteger a() {
        return this.f30381a;
    }

    @Override // com.baidu.bbalbscesium.k.d.d
    public BigInteger b() {
        return this.f30382b;
    }
}
