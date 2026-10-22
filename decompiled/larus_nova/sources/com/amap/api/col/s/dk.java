package com.amap.api.col.s;

/* JADX INFO: loaded from: classes28.dex */
public final class dk extends dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f26576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26577b;

    public dk() {
        this.f26576a = new StringBuilder();
        this.f26577b = true;
    }

    public dk(dn r100) {
        super(r100);
        this.f26576a = new StringBuilder();
        this.f26577b = true;
    }

    @Override // com.amap.api.col.s.dn
    public final byte[] a(byte[] r100) {
        byte[] r101 = bs.a(this.f26576a.toString());
        this.f26582d = r101;
        this.f26577b = true;
        StringBuilder r102 = this.f26576a;
        r102.delete(0, r102.length());
        return r101;
    }

    @Override // com.amap.api.col.s.dn
    public final void b(byte[] r100) {
        String r101 = bs.a(r100);
        if (this.f26577b == false) goto L5;
        this.f26577b = false;
    L6:
        StringBuilder r102 = this.f26576a;
        r102.append("{\"log\":\"");
        r102.append(r101);
        r102.append("\"}");
        return;
    L5:
        this.f26576a.append(",");
        goto L6
    }
}
