package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class r1 implements Enumeration {

    /* renamed from: a, reason: collision with root package name */
    public i f7762a;

    /* renamed from: b, reason: collision with root package name */
    public r f7763b = a();

    public r1(byte[] bArr) {
        this.f7762a = new i(bArr, 0);
    }

    public final r a() {
        try {
            return this.f7762a.a();
        } catch (IOException e4) {
            throw new q("malformed DER construction: " + e4, e4);
        }
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return this.f7763b != null;
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        r rVar = this.f7763b;
        this.f7763b = a();
        return rVar;
    }
}
