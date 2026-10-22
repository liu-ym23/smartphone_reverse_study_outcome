package com.autonavi.aps.protocol.aps.request.model.fields.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    int f18950a;

    /* renamed from: b, reason: collision with root package name */
    int f18951b;

    /* renamed from: c, reason: collision with root package name */
    int f18952c;

    public int a() {
        return this.f18950a;
    }

    public int b() {
        return this.f18951b;
    }

    public int c() {
        return this.f18952c;
    }

    public int d() {
        return 0;
    }

    public String toString() {
        return "SensorFeature{lux=" + this.f18950a + ", satelliteSnr0=" + this.f18951b + ", satelliteSnr20=" + this.f18952c + ", movingStatus=0}";
    }

    public void a(int i10) {
        this.f18950a = i10;
    }

    public void b(int i10) {
        this.f18951b = i10;
    }

    public void c(int i10) {
        this.f18952c = i10;
    }
}
