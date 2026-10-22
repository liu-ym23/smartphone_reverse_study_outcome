package com.stepos.base.model.data;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PowerProfile {

    /* renamed from: a, reason: collision with root package name */
    public static final PowerProfile f6373a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PowerProfile[] f6374b;

    static {
        PowerProfile powerProfile = new PowerProfile("PERFORMANCE", 0);
        PowerProfile powerProfile2 = new PowerProfile("BALANCED", 1);
        f6373a = powerProfile2;
        PowerProfile[] powerProfileArr = {powerProfile, powerProfile2, new PowerProfile("EFFICIENT", 2), new PowerProfile("LOW_POWER", 3)};
        f6374b = powerProfileArr;
        a.a(powerProfileArr);
    }

    public PowerProfile() {
        throw null;
    }

    public static PowerProfile valueOf(String str) {
        return (PowerProfile) Enum.valueOf(PowerProfile.class, str);
    }

    public static PowerProfile[] values() {
        return (PowerProfile[]) f6374b.clone();
    }
}
