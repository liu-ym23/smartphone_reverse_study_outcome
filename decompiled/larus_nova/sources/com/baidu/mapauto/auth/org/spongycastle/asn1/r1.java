package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class r1 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f31882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f31883b;

    public r1(byte[] r100) {
        this.f31882a = new i(r100, 0);
        this.f31883b = a();
    }

    public final r a() {
        return this.f31882a.a();
    L4:
        e = move-exception;
        throw new q("malformed DER construction: " + e, e);
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        if (this.f31883b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        r r100 = this.f31883b;
        this.f31883b = a();
        return r100;
    }
}
