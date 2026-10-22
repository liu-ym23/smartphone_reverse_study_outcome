package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e0 implements t {

    /* renamed from: a, reason: collision with root package name */
    public final v f7710a;

    public e0(v vVar) {
        this.f7710a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new d0(this.f7710a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e4) {
            throw new IllegalStateException(e4.getMessage());
        }
    }
}
