package com.fasterxml.jackson.databind.cfg;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CoercionInputShape {

    /* renamed from: a, reason: collision with root package name */
    public static final CoercionInputShape f3805a;

    /* renamed from: b, reason: collision with root package name */
    public static final CoercionInputShape f3806b;

    /* renamed from: c, reason: collision with root package name */
    public static final CoercionInputShape f3807c;

    /* renamed from: d, reason: collision with root package name */
    public static final CoercionInputShape f3808d;

    /* renamed from: e, reason: collision with root package name */
    public static final CoercionInputShape f3809e;
    public static final /* synthetic */ CoercionInputShape[] h;

    /* JADX INFO: Fake field, exist only in values array */
    CoercionInputShape EF0;

    static {
        CoercionInputShape coercionInputShape = new CoercionInputShape("Array", 0);
        CoercionInputShape coercionInputShape2 = new CoercionInputShape("Object", 1);
        CoercionInputShape coercionInputShape3 = new CoercionInputShape("Integer", 2);
        f3805a = coercionInputShape3;
        CoercionInputShape coercionInputShape4 = new CoercionInputShape("Float", 3);
        f3806b = coercionInputShape4;
        CoercionInputShape coercionInputShape5 = new CoercionInputShape("Boolean", 4);
        CoercionInputShape coercionInputShape6 = new CoercionInputShape("String", 5);
        f3807c = coercionInputShape6;
        CoercionInputShape coercionInputShape7 = new CoercionInputShape("Binary", 6);
        CoercionInputShape coercionInputShape8 = new CoercionInputShape("EmptyArray", 7);
        f3808d = coercionInputShape8;
        CoercionInputShape coercionInputShape9 = new CoercionInputShape("EmptyObject", 8);
        CoercionInputShape coercionInputShape10 = new CoercionInputShape("EmptyString", 9);
        f3809e = coercionInputShape10;
        h = new CoercionInputShape[]{coercionInputShape, coercionInputShape2, coercionInputShape3, coercionInputShape4, coercionInputShape5, coercionInputShape6, coercionInputShape7, coercionInputShape8, coercionInputShape9, coercionInputShape10};
    }

    public CoercionInputShape() {
        throw null;
    }

    public static CoercionInputShape valueOf(String str) {
        return (CoercionInputShape) Enum.valueOf(CoercionInputShape.class, str);
    }

    public static CoercionInputShape[] values() {
        return (CoercionInputShape[]) h.clone();
    }
}
