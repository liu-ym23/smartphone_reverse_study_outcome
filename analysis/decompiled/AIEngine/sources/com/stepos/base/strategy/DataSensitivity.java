package com.stepos.base.strategy;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DataSensitivity {

    /* renamed from: a, reason: collision with root package name */
    public static final DataSensitivity f6384a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DataSensitivity[] f6385b;

    static {
        DataSensitivity dataSensitivity = new DataSensitivity("LOW", 0);
        DataSensitivity dataSensitivity2 = new DataSensitivity("MEDIUM", 1);
        f6384a = dataSensitivity2;
        DataSensitivity[] dataSensitivityArr = {dataSensitivity, dataSensitivity2, new DataSensitivity("HIGH", 2)};
        f6385b = dataSensitivityArr;
        a.a(dataSensitivityArr);
    }

    public DataSensitivity() {
        throw null;
    }

    public static DataSensitivity valueOf(String str) {
        return (DataSensitivity) Enum.valueOf(DataSensitivity.class, str);
    }

    public static DataSensitivity[] values() {
        return (DataSensitivity[]) f6385b.clone();
    }
}
