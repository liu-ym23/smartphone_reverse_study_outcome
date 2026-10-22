package com.fasterxml.jackson.annotation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Nulls {

    /* renamed from: a, reason: collision with root package name */
    public static final Nulls f3491a;

    /* renamed from: b, reason: collision with root package name */
    public static final Nulls f3492b;

    /* renamed from: c, reason: collision with root package name */
    public static final Nulls f3493c;

    /* renamed from: d, reason: collision with root package name */
    public static final Nulls f3494d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ Nulls[] f3495e;

    /* JADX INFO: Fake field, exist only in values array */
    Nulls EF0;

    static {
        Nulls nulls = new Nulls("SET", 0);
        Nulls nulls2 = new Nulls("SKIP", 1);
        f3491a = nulls2;
        Nulls nulls3 = new Nulls("FAIL", 2);
        f3492b = nulls3;
        Nulls nulls4 = new Nulls("AS_EMPTY", 3);
        f3493c = nulls4;
        Nulls nulls5 = new Nulls("DEFAULT", 4);
        f3494d = nulls5;
        f3495e = new Nulls[]{nulls, nulls2, nulls3, nulls4, nulls5};
    }

    public Nulls() {
        throw null;
    }

    public static Nulls valueOf(String str) {
        return (Nulls) Enum.valueOf(Nulls.class, str);
    }

    public static Nulls[] values() {
        return (Nulls[]) f3495e.clone();
    }
}
