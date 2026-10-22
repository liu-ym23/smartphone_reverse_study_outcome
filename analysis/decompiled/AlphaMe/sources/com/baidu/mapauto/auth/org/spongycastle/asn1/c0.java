package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c0 implements o {

    /* renamed from: a, reason: collision with root package name */
    public final v f7706a;

    public c0(v vVar) {
        this.f7706a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        InputStream inputStreamB = b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i4 = inputStreamB.read(bArr, 0, 4096);
            if (i4 < 0) {
                return new b0(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr, 0, i4);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new j0(this.f7706a);
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
