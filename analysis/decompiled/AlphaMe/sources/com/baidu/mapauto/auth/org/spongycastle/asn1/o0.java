package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class o0 implements d, p1 {

    /* renamed from: a, reason: collision with root package name */
    public final v f7745a;

    public o0(v vVar) {
        this.f7745a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        try {
            return new n0(this.f7745a.b());
        } catch (IllegalArgumentException e4) {
            throw new g(e4.getMessage(), e4);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e4) {
            throw new q("unable to get DER object", e4);
        } catch (IllegalArgumentException e5) {
            throw new q("unable to get DER object", e5);
        }
    }
}
