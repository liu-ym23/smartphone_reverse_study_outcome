package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class TypeVariance {
    public static final TypeVariance b;
    public static final TypeVariance c;
    public static final TypeVariance d;
    public static final /* synthetic */ TypeVariance[] e;

    /* renamed from: a, reason: collision with root package name */
    public final String f5165a;

    static {
        TypeVariance typeVariance = new TypeVariance("IN", 0, "in");
        b = typeVariance;
        TypeVariance typeVariance2 = new TypeVariance("OUT", 1, "out");
        c = typeVariance2;
        TypeVariance typeVariance3 = new TypeVariance("INV", 2, "");
        d = typeVariance3;
        TypeVariance[] typeVarianceArr = {typeVariance, typeVariance2, typeVariance3};
        e = typeVarianceArr;
        a.a(typeVarianceArr);
    }

    public TypeVariance(String str, int i, String str2) {
        this.f5165a = str2;
    }

    public static TypeVariance valueOf(String str) {
        return (TypeVariance) Enum.valueOf(TypeVariance.class, str);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) e.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f5165a;
    }
}
