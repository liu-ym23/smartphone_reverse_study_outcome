package com.stepos.base.model.data;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ComputeType {

    /* renamed from: a, reason: collision with root package name */
    public static final ComputeType f6362a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ComputeType[] f6363b;

    static {
        ComputeType computeType = new ComputeType("CPU", 0);
        f6362a = computeType;
        ComputeType[] computeTypeArr = {computeType, new ComputeType("GPU", 1), new ComputeType("NPU", 2), new ComputeType("HYBRID", 3)};
        f6363b = computeTypeArr;
        a.a(computeTypeArr);
    }

    public ComputeType() {
        throw null;
    }

    public static ComputeType valueOf(String str) {
        return (ComputeType) Enum.valueOf(ComputeType.class, str);
    }

    public static ComputeType[] values() {
        return (ComputeType[]) f6363b.clone();
    }
}
