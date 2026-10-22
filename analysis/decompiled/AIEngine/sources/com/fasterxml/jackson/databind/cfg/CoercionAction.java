package com.fasterxml.jackson.databind.cfg;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CoercionAction {

    /* renamed from: a, reason: collision with root package name */
    public static final CoercionAction f3796a;

    /* renamed from: b, reason: collision with root package name */
    public static final CoercionAction f3797b;

    /* renamed from: c, reason: collision with root package name */
    public static final CoercionAction f3798c;

    /* renamed from: d, reason: collision with root package name */
    public static final CoercionAction f3799d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ CoercionAction[] f3800e;

    static {
        CoercionAction coercionAction = new CoercionAction("Fail", 0);
        f3796a = coercionAction;
        CoercionAction coercionAction2 = new CoercionAction("TryConvert", 1);
        f3797b = coercionAction2;
        CoercionAction coercionAction3 = new CoercionAction("AsNull", 2);
        f3798c = coercionAction3;
        CoercionAction coercionAction4 = new CoercionAction("AsEmpty", 3);
        f3799d = coercionAction4;
        f3800e = new CoercionAction[]{coercionAction, coercionAction2, coercionAction3, coercionAction4};
    }

    public CoercionAction() {
        throw null;
    }

    public static CoercionAction valueOf(String str) {
        return (CoercionAction) Enum.valueOf(CoercionAction.class, str);
    }

    public static CoercionAction[] values() {
        return (CoercionAction[]) f3800e.clone();
    }
}
