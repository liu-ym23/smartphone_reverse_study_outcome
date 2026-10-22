package com.stepos.base.inference.data;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BackendType {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6253c;

    /* renamed from: d, reason: collision with root package name */
    public static final BackendType f6254d;

    /* renamed from: e, reason: collision with root package name */
    public static final BackendType f6255e;
    public static final BackendType h;

    /* renamed from: j, reason: collision with root package name */
    public static final BackendType f6256j;

    /* renamed from: k, reason: collision with root package name */
    public static final BackendType f6257k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ BackendType[] f6258l;

    /* renamed from: a, reason: collision with root package name */
    public final int f6259a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6260b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    static {
        BackendType backendType = new BackendType("NPU", 0, 0, 2);
        f6254d = backendType;
        BackendType backendType2 = new BackendType("GPU", 1, 1, 4);
        f6255e = backendType2;
        BackendType backendType3 = new BackendType("HYBRID", 2, 1, 3);
        h = backendType3;
        BackendType backendType4 = new BackendType("CPU", 3, 2, 3);
        f6256j = backendType4;
        BackendType backendType5 = new BackendType("AUTO", 4, 99, 3);
        f6257k = backendType5;
        BackendType[] backendTypeArr = {backendType, backendType2, backendType3, backendType4, backendType5};
        f6258l = backendTypeArr;
        kotlin.enums.a.a(backendTypeArr);
        f6253c = new a();
    }

    public BackendType(String str, int i10, int i11, int i12) {
        this.f6259a = i11;
        this.f6260b = i12;
    }

    public static BackendType valueOf(String str) {
        return (BackendType) Enum.valueOf(BackendType.class, str);
    }

    public static BackendType[] values() {
        return (BackendType[]) f6258l.clone();
    }
}
