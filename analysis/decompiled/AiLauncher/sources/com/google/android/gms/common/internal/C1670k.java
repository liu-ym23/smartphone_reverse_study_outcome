package com.google.android.gms.common.internal;

/* renamed from: com.google.android.gms.common.internal.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1670k {

    /* renamed from: b, reason: collision with root package name */
    public static C1670k f19835b;

    /* renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f19836c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public RootTelemetryConfiguration f19837a;

    public static synchronized C1670k b() {
        try {
            if (f19835b == null) {
                f19835b = new C1670k();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f19835b;
    }

    public RootTelemetryConfiguration a() {
        return this.f19837a;
    }

    public final synchronized void c(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f19837a = f19836c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f19837a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
            this.f19837a = rootTelemetryConfiguration;
        }
    }
}
