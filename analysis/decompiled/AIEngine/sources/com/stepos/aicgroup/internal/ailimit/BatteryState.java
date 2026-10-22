package com.stepos.aicgroup.internal.ailimit;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BatteryState {
    public static final BatteryState CRITICAL;
    public static final BatteryState LOW;
    public static final BatteryState NORMAL;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ BatteryState[] f5721b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ a f5722c;

    /* renamed from: a, reason: collision with root package name */
    public final int f5723a;

    static {
        BatteryState batteryState = new BatteryState("NORMAL", 0, 0);
        NORMAL = batteryState;
        BatteryState batteryState2 = new BatteryState("LOW", 1, 1);
        LOW = batteryState2;
        BatteryState batteryState3 = new BatteryState("CRITICAL", 2, 2);
        CRITICAL = batteryState3;
        BatteryState[] batteryStateArr = {batteryState, batteryState2, batteryState3};
        f5721b = batteryStateArr;
        f5722c = kotlin.enums.a.a(batteryStateArr);
    }

    public BatteryState(String str, int i10, int i11) {
        this.f5723a = i11;
    }

    public static a<BatteryState> getEntries() {
        return f5722c;
    }

    public static BatteryState valueOf(String str) {
        return (BatteryState) Enum.valueOf(BatteryState.class, str);
    }

    public static BatteryState[] values() {
        return (BatteryState[]) f5721b.clone();
    }

    public final int getLevel() {
        return this.f5723a;
    }
}
