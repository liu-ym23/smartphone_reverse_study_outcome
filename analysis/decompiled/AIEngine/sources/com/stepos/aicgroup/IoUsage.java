package com.stepos.aicgroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class IoUsage {
    public static final IoUsage CRITICAL;
    public static final IoUsage HIGH;
    public static final IoUsage MODERATE;
    public static final IoUsage NORMAL;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ IoUsage[] f5645b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ sb.a f5646c;

    /* renamed from: a, reason: collision with root package name */
    public final int f5647a;

    static {
        IoUsage ioUsage = new IoUsage("NORMAL", 0, 0);
        NORMAL = ioUsage;
        IoUsage ioUsage2 = new IoUsage("MODERATE", 1, 1);
        MODERATE = ioUsage2;
        IoUsage ioUsage3 = new IoUsage("HIGH", 2, 2);
        HIGH = ioUsage3;
        IoUsage ioUsage4 = new IoUsage("CRITICAL", 3, 3);
        CRITICAL = ioUsage4;
        IoUsage[] ioUsageArr = {ioUsage, ioUsage2, ioUsage3, ioUsage4};
        f5645b = ioUsageArr;
        f5646c = kotlin.enums.a.a(ioUsageArr);
    }

    public IoUsage(String str, int i10, int i11) {
        this.f5647a = i11;
    }

    public static sb.a<IoUsage> getEntries() {
        return f5646c;
    }

    public static IoUsage valueOf(String str) {
        return (IoUsage) Enum.valueOf(IoUsage.class, str);
    }

    public static IoUsage[] values() {
        return (IoUsage[]) f5645b.clone();
    }

    public final int getLevel() {
        return this.f5647a;
    }
}
