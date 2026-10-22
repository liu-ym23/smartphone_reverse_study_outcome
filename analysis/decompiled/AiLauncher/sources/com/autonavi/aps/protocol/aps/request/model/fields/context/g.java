package com.autonavi.aps.protocol.aps.request.model.fields.context;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.protocol.aps.common.e.h;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private double f19054a;

    /* renamed from: b, reason: collision with root package name */
    private double f19055b;

    /* renamed from: c, reason: collision with root package name */
    private int f19056c;

    /* renamed from: d, reason: collision with root package name */
    private double f19057d;

    public g(double d10, double d11, int i10, double d12) {
        this.f19054a = d10;
        this.f19055b = d11;
        this.f19056c = i10;
        this.f19057d = d12;
    }

    public double a() {
        return this.f19054a;
    }

    public double b() {
        return this.f19055b;
    }

    public int c() {
        return this.f19056c;
    }

    public double d() {
        return this.f19057d;
    }

    public String toString() {
        return h.a(new Object[]{Double.valueOf((((int) (this.f19054a * 100000.0d)) * 1.0d) / 100000.0d), Double.valueOf((((int) (this.f19055b * 100000.0d)) * 1.0d) / 100000.0d), Integer.valueOf(this.f19056c), Double.valueOf((((int) (this.f19057d * 100.0d)) * 1.0d) / 100.0d)}, Const.STR_MART_COMMA);
    }
}
