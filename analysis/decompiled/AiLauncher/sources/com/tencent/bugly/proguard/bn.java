package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public final class bn extends m implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static byte[] f31580d;

    /* renamed from: a, reason: collision with root package name */
    public byte f31581a;

    /* renamed from: b, reason: collision with root package name */
    public String f31582b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f31583c;

    public bn() {
        this.f31581a = (byte) 0;
        this.f31582b = "";
        this.f31583c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        this.f31581a = k10.a(this.f31581a, 0, true);
        this.f31582b = k10.u(1, true);
        if (f31580d == null) {
            f31580d = new byte[]{0};
        }
        this.f31583c = k10.y(2, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.b(this.f31581a, 0);
        l10.j(this.f31582b, 1);
        byte[] bArr = this.f31583c;
        if (bArr != null) {
            l10.o(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
    }

    public bn(byte b10, String str, byte[] bArr) {
        this.f31581a = b10;
        this.f31582b = str;
        this.f31583c = bArr;
    }
}
