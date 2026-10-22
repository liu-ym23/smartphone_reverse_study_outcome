package com.fasterxml.jackson.databind.type;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogicalType {

    /* renamed from: a, reason: collision with root package name */
    public static final LogicalType f4428a;

    /* renamed from: b, reason: collision with root package name */
    public static final LogicalType f4429b;

    /* renamed from: c, reason: collision with root package name */
    public static final LogicalType f4430c;

    /* renamed from: d, reason: collision with root package name */
    public static final LogicalType f4431d;

    /* renamed from: e, reason: collision with root package name */
    public static final LogicalType f4432e;
    public static final LogicalType h;

    /* renamed from: j, reason: collision with root package name */
    public static final LogicalType f4433j;

    /* renamed from: k, reason: collision with root package name */
    public static final LogicalType f4434k;

    /* renamed from: l, reason: collision with root package name */
    public static final LogicalType f4435l;

    /* renamed from: m, reason: collision with root package name */
    public static final LogicalType f4436m;

    /* renamed from: n, reason: collision with root package name */
    public static final LogicalType f4437n;

    /* renamed from: o, reason: collision with root package name */
    public static final LogicalType f4438o;

    /* renamed from: p, reason: collision with root package name */
    public static final LogicalType f4439p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ LogicalType[] f4440q;

    static {
        LogicalType logicalType = new LogicalType("Array", 0);
        f4428a = logicalType;
        LogicalType logicalType2 = new LogicalType("Collection", 1);
        f4429b = logicalType2;
        LogicalType logicalType3 = new LogicalType("Map", 2);
        f4430c = logicalType3;
        LogicalType logicalType4 = new LogicalType("POJO", 3);
        f4431d = logicalType4;
        LogicalType logicalType5 = new LogicalType("Untyped", 4);
        f4432e = logicalType5;
        LogicalType logicalType6 = new LogicalType("Integer", 5);
        h = logicalType6;
        LogicalType logicalType7 = new LogicalType("Float", 6);
        f4433j = logicalType7;
        LogicalType logicalType8 = new LogicalType("Boolean", 7);
        f4434k = logicalType8;
        LogicalType logicalType9 = new LogicalType("Enum", 8);
        f4435l = logicalType9;
        LogicalType logicalType10 = new LogicalType("Textual", 9);
        f4436m = logicalType10;
        LogicalType logicalType11 = new LogicalType("Binary", 10);
        f4437n = logicalType11;
        LogicalType logicalType12 = new LogicalType("DateTime", 11);
        f4438o = logicalType12;
        LogicalType logicalType13 = new LogicalType("OtherScalar", 12);
        f4439p = logicalType13;
        f4440q = new LogicalType[]{logicalType, logicalType2, logicalType3, logicalType4, logicalType5, logicalType6, logicalType7, logicalType8, logicalType9, logicalType10, logicalType11, logicalType12, logicalType13};
    }

    public LogicalType() {
        throw null;
    }

    public static LogicalType valueOf(String str) {
        return (LogicalType) Enum.valueOf(LogicalType.class, str);
    }

    public static LogicalType[] values() {
        return (LogicalType[]) f4440q.clone();
    }
}
