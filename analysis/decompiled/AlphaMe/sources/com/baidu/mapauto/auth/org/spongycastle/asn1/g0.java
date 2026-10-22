package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class g0 implements d, p1 {

    /* renamed from: a, reason: collision with root package name */
    public final v f7715a;

    public g0(v vVar) {
        this.f7715a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new f0(this.f7715a.b());
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
