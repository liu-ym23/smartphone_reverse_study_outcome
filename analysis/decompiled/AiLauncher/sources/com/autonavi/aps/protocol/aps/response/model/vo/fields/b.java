package com.autonavi.aps.protocol.aps.response.model.vo.fields;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private double f19146a;

    /* renamed from: b, reason: collision with root package name */
    private double f19147b;

    /* renamed from: c, reason: collision with root package name */
    private int f19148c;

    public double a() {
        return this.f19146a;
    }

    public double b() {
        return this.f19147b;
    }

    public int c() {
        return this.f19148c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\"pos\":{");
        sb2.append("\"lon\":" + this.f19147b);
        sb2.append(",\"lat\":" + this.f19146a);
        sb2.append(",\"radius\":" + this.f19148c);
        sb2.append("}");
        return sb2.toString();
    }

    public void a(double d10) {
        this.f19146a = BigDecimal.valueOf(d10).setScale(7, 4).doubleValue();
    }

    public void b(double d10) {
        this.f19147b = BigDecimal.valueOf(d10).setScale(7, 4).doubleValue();
    }

    public void a(int i10) {
        this.f19148c = i10;
    }
}
