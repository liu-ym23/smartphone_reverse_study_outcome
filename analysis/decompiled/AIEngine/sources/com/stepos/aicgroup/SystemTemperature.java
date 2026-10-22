package com.stepos.aicgroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SystemTemperature {
    public static final SystemTemperature CRITICAL;
    public static final SystemTemperature HIGH;
    public static final SystemTemperature MODERATE;
    public static final SystemTemperature NORMAL;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ SystemTemperature[] f5660b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ sb.a f5661c;

    /* renamed from: a, reason: collision with root package name */
    public final int f5662a;

    static {
        SystemTemperature systemTemperature = new SystemTemperature("NORMAL", 0, 0);
        NORMAL = systemTemperature;
        SystemTemperature systemTemperature2 = new SystemTemperature("MODERATE", 1, 1);
        MODERATE = systemTemperature2;
        SystemTemperature systemTemperature3 = new SystemTemperature("HIGH", 2, 2);
        HIGH = systemTemperature3;
        SystemTemperature systemTemperature4 = new SystemTemperature("CRITICAL", 3, 3);
        CRITICAL = systemTemperature4;
        SystemTemperature[] systemTemperatureArr = {systemTemperature, systemTemperature2, systemTemperature3, systemTemperature4};
        f5660b = systemTemperatureArr;
        f5661c = kotlin.enums.a.a(systemTemperatureArr);
    }

    public SystemTemperature(String str, int i10, int i11) {
        this.f5662a = i11;
    }

    public static sb.a<SystemTemperature> getEntries() {
        return f5661c;
    }

    public static SystemTemperature valueOf(String str) {
        return (SystemTemperature) Enum.valueOf(SystemTemperature.class, str);
    }

    public static SystemTemperature[] values() {
        return (SystemTemperature[]) f5660b.clone();
    }

    public final int getLevel() {
        return this.f5662a;
    }
}
