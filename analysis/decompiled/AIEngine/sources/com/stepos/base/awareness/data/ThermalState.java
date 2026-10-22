package com.stepos.base.awareness.data;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThermalState {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6199a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThermalState f6200b;

    /* renamed from: c, reason: collision with root package name */
    public static final ThermalState f6201c;

    /* renamed from: d, reason: collision with root package name */
    public static final ThermalState f6202d;

    /* renamed from: e, reason: collision with root package name */
    public static final ThermalState f6203e;
    public static final /* synthetic */ ThermalState[] h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    static {
        ThermalState thermalState = new ThermalState("NORMAL", 0);
        f6200b = thermalState;
        ThermalState thermalState2 = new ThermalState("MODERATE", 1);
        f6201c = thermalState2;
        ThermalState thermalState3 = new ThermalState("SEVERE", 2);
        f6202d = thermalState3;
        ThermalState thermalState4 = new ThermalState("CRITICAL", 3);
        f6203e = thermalState4;
        ThermalState[] thermalStateArr = {thermalState, thermalState2, thermalState3, thermalState4};
        h = thermalStateArr;
        kotlin.enums.a.a(thermalStateArr);
        f6199a = new a();
    }

    public ThermalState() {
        throw null;
    }

    public static ThermalState valueOf(String str) {
        return (ThermalState) Enum.valueOf(ThermalState.class, str);
    }

    public static ThermalState[] values() {
        return (ThermalState[]) h.clone();
    }
}
