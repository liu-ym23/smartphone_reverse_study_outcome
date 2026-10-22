package com.stepos.aicgroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuUsage {
    public static final CpuUsage CRITICAL;
    public static final CpuUsage HIGH;
    public static final CpuUsage MODERATE;
    public static final CpuUsage NORMAL;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CpuUsage[] f5642b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ sb.a f5643c;

    /* renamed from: a, reason: collision with root package name */
    public final int f5644a;

    static {
        CpuUsage cpuUsage = new CpuUsage("NORMAL", 0, 0);
        NORMAL = cpuUsage;
        CpuUsage cpuUsage2 = new CpuUsage("MODERATE", 1, 1);
        MODERATE = cpuUsage2;
        CpuUsage cpuUsage3 = new CpuUsage("HIGH", 2, 2);
        HIGH = cpuUsage3;
        CpuUsage cpuUsage4 = new CpuUsage("CRITICAL", 3, 3);
        CRITICAL = cpuUsage4;
        CpuUsage[] cpuUsageArr = {cpuUsage, cpuUsage2, cpuUsage3, cpuUsage4};
        f5642b = cpuUsageArr;
        f5643c = kotlin.enums.a.a(cpuUsageArr);
    }

    public CpuUsage(String str, int i10, int i11) {
        this.f5644a = i11;
    }

    public static sb.a<CpuUsage> getEntries() {
        return f5643c;
    }

    public static CpuUsage valueOf(String str) {
        return (CpuUsage) Enum.valueOf(CpuUsage.class, str);
    }

    public static CpuUsage[] values() {
        return (CpuUsage[]) f5642b.clone();
    }

    public final int getLevel() {
        return this.f5644a;
    }
}
