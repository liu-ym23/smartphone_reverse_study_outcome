package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class NullabilityQualifier {

    /* renamed from: a, reason: collision with root package name */
    public static final NullabilityQualifier f5005a;
    public static final NullabilityQualifier b;
    public static final NullabilityQualifier c;
    public static final /* synthetic */ NullabilityQualifier[] d;

    static {
        NullabilityQualifier nullabilityQualifier = new NullabilityQualifier("FORCE_FLEXIBILITY", 0);
        f5005a = nullabilityQualifier;
        NullabilityQualifier nullabilityQualifier2 = new NullabilityQualifier("NULLABLE", 1);
        b = nullabilityQualifier2;
        NullabilityQualifier nullabilityQualifier3 = new NullabilityQualifier("NOT_NULL", 2);
        c = nullabilityQualifier3;
        NullabilityQualifier[] nullabilityQualifierArr = {nullabilityQualifier, nullabilityQualifier2, nullabilityQualifier3};
        d = nullabilityQualifierArr;
        a.a(nullabilityQualifierArr);
    }

    public static NullabilityQualifier valueOf(String str) {
        return (NullabilityQualifier) Enum.valueOf(NullabilityQualifier.class, str);
    }

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[]) d.clone();
    }
}
