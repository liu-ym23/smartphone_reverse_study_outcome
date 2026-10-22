package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class a1 implements t {

    /* renamed from: a, reason: collision with root package name */
    public final v f7693a;

    public a1(v vVar) {
        this.f7693a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new z0(this.f7693a.b());
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
