package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class m8 extends p8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f27624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27625d;

    public m8(p8 r100) {
        super(r100);
        this.f27624c = new StringBuilder();
        this.f27625d = true;
    }

    @Override // com.amap.api.mapcore.util.p8
    public void a(byte[] r100) {
        String r101 = x5.c(r100);
        if (this.f27625d == false) goto L5;
        this.f27625d = false;
    L6:
        StringBuilder r102 = this.f27624c;
        r102.append("{\"log\":\"");
        r102.append(r101);
        r102.append("\"}");
        return;
    L5:
        this.f27624c.append(",");
        goto L6
    }

    @Override // com.amap.api.mapcore.util.p8
    public byte[] b(byte[] r100) {
        byte[] r101 = x5.e(this.f27624c.toString());
        this.f27851b = r101;
        this.f27625d = true;
        StringBuilder r102 = this.f27624c;
        r102.delete(0, r102.length());
        return r101;
    }
}
