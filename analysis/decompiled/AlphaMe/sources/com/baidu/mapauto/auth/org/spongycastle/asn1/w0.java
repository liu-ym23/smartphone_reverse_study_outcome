package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class w0 implements o {

    /* renamed from: a, reason: collision with root package name */
    public o1 f7781a;

    public w0(o1 o1Var) {
        this.f7781a = o1Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new v0(this.f7781a.c());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return this.f7781a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e4) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("IOException converting stream to byte array: ");
            sbA.append(e4.getMessage());
            throw new q(sbA.toString(), e4);
        }
    }
}
