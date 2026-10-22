package com.baidu.mapapi.map;

/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    public final double f7150a;

    /* renamed from: b, reason: collision with root package name */
    public final double f7151b;

    /* renamed from: c, reason: collision with root package name */
    public final double f7152c;

    /* renamed from: d, reason: collision with root package name */
    public final double f7153d;

    /* renamed from: e, reason: collision with root package name */
    public final double f7154e;

    /* renamed from: f, reason: collision with root package name */
    public final double f7155f;

    public c(double d4, double d5, double d6, double d7) {
        this.f7150a = d4;
        this.f7151b = d6;
        this.f7152c = d5;
        this.f7153d = d7;
        this.f7154e = (d4 + d5) / 2.0d;
        this.f7155f = (d6 + d7) / 2.0d;
    }

    public boolean a(double d4, double d5) {
        return this.f7150a <= d4 && d4 <= this.f7152c && this.f7151b <= d5 && d5 <= this.f7153d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7150a);
        sb.append(" minY: " + this.f7151b);
        sb.append(" maxX: " + this.f7152c);
        sb.append(" maxY: " + this.f7153d);
        sb.append(" midX: " + this.f7154e);
        sb.append(" midY: " + this.f7155f);
        return sb.toString();
    }
}
