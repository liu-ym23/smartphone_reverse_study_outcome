package com.amap.location.support.bean.gnss;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapGnssClock implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public int f18092a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f18093b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public double f18094c = -9999.0d;

    /* renamed from: d, reason: collision with root package name */
    public double f18095d = -1.0d;

    /* renamed from: e, reason: collision with root package name */
    public double f18096e = -9999.0d;

    /* renamed from: f, reason: collision with root package name */
    public double f18097f = -1.0d;

    /* renamed from: g, reason: collision with root package name */
    public long f18098g = -1;

    /* renamed from: h, reason: collision with root package name */
    public double f18099h = -1.0d;

    /* renamed from: i, reason: collision with root package name */
    public long f18100i = Long.MAX_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f18101j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f18102k = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f18103l = -1;

    /* renamed from: m, reason: collision with root package name */
    public double f18104m = -1.0d;

    public String toString() {
        return "AmapGnssClock{describeContents=" + this.f18093b + ", biasNanos=" + this.f18094c + ", biasUncertaintyNanos=" + this.f18095d + ", driftNanosPerSecond=" + this.f18096e + ", driftUncertaintyNanosPerSecond=" + this.f18097f + ", elapsedRealtimeNanos=" + this.f18098g + ", elapsedRealtimeUncertaintyNanos=" + this.f18099h + ", fullBiasNanos=" + this.f18100i + ", hardwareClockDiscontinuityCount=" + this.f18101j + ", leapSecond=" + this.f18102k + ", timeNanos=" + this.f18103l + ", timeUncertaintyNanos=" + this.f18104m + '}';
    }
}
