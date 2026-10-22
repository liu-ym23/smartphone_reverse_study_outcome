package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class c1 implements d, p1 {

    /* renamed from: a, reason: collision with root package name */
    public final v f7707a;

    public c1(v vVar) {
        this.f7707a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new b1(this.f7707a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e4) {
            throw new q(e4.getMessage(), e4);
        }
    }
}
