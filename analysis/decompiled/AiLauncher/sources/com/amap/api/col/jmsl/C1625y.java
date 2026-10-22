package com.amap.api.col.jmsl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.amap.api.col.jmsl.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1625y extends AbstractC1614v0 {

    /* renamed from: c, reason: collision with root package name */
    public ByteArrayOutputStream f17033c;

    public C1625y(AbstractC1614v0 abstractC1614v0) {
        super(abstractC1614v0);
        this.f17033c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public void a(byte[] bArr) {
        try {
            this.f17033c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public byte[] c(byte[] bArr) throws IOException {
        byte[] byteArray = this.f17033c.toByteArray();
        try {
            this.f17033c.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        this.f17033c = new ByteArrayOutputStream();
        return byteArray;
    }
}
