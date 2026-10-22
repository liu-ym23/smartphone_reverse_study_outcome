package com.amap.api.col.jmsl;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class X extends AbstractC1614v0 {

    /* renamed from: c, reason: collision with root package name */
    public StringBuilder f16444c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16445d;

    public X(AbstractC1614v0 abstractC1614v0) {
        super(abstractC1614v0);
        this.f16444c = new StringBuilder();
        this.f16445d = true;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public void a(byte[] bArr) {
        String strN = C1604s2.n(bArr);
        if (this.f16445d) {
            this.f16445d = false;
        } else {
            this.f16444c.append(Const.STR_MART_COMMA);
        }
        StringBuilder sb2 = this.f16444c;
        sb2.append("{\"log\":\"");
        sb2.append(strN);
        sb2.append("\"}");
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public byte[] c(byte[] bArr) {
        byte[] bArrT = C1604s2.t(this.f16444c.toString());
        this.f16980b = bArrT;
        this.f16445d = true;
        StringBuilder sb2 = this.f16444c;
        sb2.delete(0, sb2.length());
        return bArrT;
    }
}
