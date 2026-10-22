package com.autonavi.aps.protocol.aps.request.model.fields.context;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.protocol.aps.common.e.h;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public double f19041a;

    /* renamed from: b, reason: collision with root package name */
    public double f19042b;

    /* renamed from: c, reason: collision with root package name */
    private int f19043c;

    /* renamed from: d, reason: collision with root package name */
    private double f19044d;

    /* renamed from: e, reason: collision with root package name */
    private byte f19045e;

    /* renamed from: f, reason: collision with root package name */
    private int f19046f;

    public d(double d10, double d11, int i10, byte b10, double d12, int i11) {
        this.f19041a = d10;
        this.f19042b = d11;
        this.f19043c = i10;
        this.f19045e = b10;
        this.f19044d = d12;
        this.f19046f = i11;
    }

    public double a() {
        return this.f19041a;
    }

    public double b() {
        return this.f19042b;
    }

    public int c() {
        return this.f19043c;
    }

    public byte d() {
        return this.f19045e;
    }

    public double e() {
        return this.f19044d;
    }

    public int f() {
        return this.f19046f;
    }

    public String toString() {
        return h.a(new Object[]{Double.valueOf((((int) (this.f19041a * 100000.0d)) * 1.0d) / 100000.0d), Double.valueOf((((int) (this.f19042b * 100000.0d)) * 1.0d) / 100000.0d), Integer.valueOf(this.f19043c), Byte.valueOf(this.f19045e), Double.valueOf((((int) (this.f19044d * 100.0d)) * 1.0d) / 100.0d), Integer.valueOf(this.f19046f)}, Const.STR_MART_COMMA);
    }
}
