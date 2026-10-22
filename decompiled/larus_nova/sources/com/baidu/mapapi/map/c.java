package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f31585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f31586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f31587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f31588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f31589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f31590f;

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("minX: " + this.f31585a);
        r100.append(" minY: " + this.f31586b);
        r100.append(" maxX: " + this.f31587c);
        r100.append(" maxY: " + this.f31588d);
        r100.append(" midX: " + this.f31589e);
        r100.append(" midY: " + this.f31590f);
        return r100.toString();
    }

    public boolean a(double r100, double r101) {
        if (this.f31585a <= r100) goto L5;
    L11:
        return false;
    L5:
        if (r100 > this.f31587c) goto L11;
        if (this.f31586b > r101) goto L11;
        if (r101 > this.f31588d) goto L11;
        return true;
    }

    public c(double r100, double r101, double r102, double r103) {
        this.f31585a = r100;
        this.f31586b = r102;
        this.f31587c = r101;
        this.f31588d = r103;
        this.f31589e = (r100 + r101) / 2.0d;
        this.f31590f = (r102 + r103) / 2.0d;
    }
}
