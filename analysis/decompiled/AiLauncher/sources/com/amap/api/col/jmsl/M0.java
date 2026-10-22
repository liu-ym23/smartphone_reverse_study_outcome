package com.amap.api.col.jmsl;

import java.io.File;

/* loaded from: classes.dex */
public class M0 extends AbstractC1619w1 {

    /* renamed from: b, reason: collision with root package name */
    public String f16196b;

    public M0(int i10, String str, AbstractC1619w1 abstractC1619w1) {
        super(abstractC1619w1);
        this.f16196b = str;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1619w1
    public boolean e() {
        File file;
        try {
            file = new File(this.f16196b);
        } catch (Throwable th) {
            C1541c2.b(th, "fus", "gfn");
        }
        int length = !file.exists() ? 0 : file.list().length;
        return length >= 30;
    }
}
