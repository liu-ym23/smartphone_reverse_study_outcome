package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class z implements d, p1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f7788a;

    /* renamed from: b, reason: collision with root package name */
    public final v f7789b;

    public z(int i4, v vVar) {
        this.f7788a = i4;
        this.f7789b = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new y(this.f7788a, this.f7789b.b());
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
