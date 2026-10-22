package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class i0 implements d, p1 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7723a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7724b;

    /* renamed from: c, reason: collision with root package name */
    public final v f7725c;

    public i0(boolean z4, int i4, v vVar) {
        this.f7723a = z4;
        this.f7724b = i4;
        this.f7725c = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return this.f7725c.a(this.f7723a, this.f7724b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e4) {
            throw new q(e4.getMessage());
        }
    }
}
