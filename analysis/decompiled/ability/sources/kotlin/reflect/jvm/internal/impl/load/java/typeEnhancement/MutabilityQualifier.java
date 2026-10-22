package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class MutabilityQualifier {

    /* renamed from: a, reason: collision with root package name */
    public static final MutabilityQualifier f5004a;
    public static final MutabilityQualifier b;
    public static final /* synthetic */ MutabilityQualifier[] c;

    static {
        MutabilityQualifier mutabilityQualifier = new MutabilityQualifier("READ_ONLY", 0);
        f5004a = mutabilityQualifier;
        MutabilityQualifier mutabilityQualifier2 = new MutabilityQualifier("MUTABLE", 1);
        b = mutabilityQualifier2;
        MutabilityQualifier[] mutabilityQualifierArr = {mutabilityQualifier, mutabilityQualifier2};
        c = mutabilityQualifierArr;
        a.a(mutabilityQualifierArr);
    }

    public static MutabilityQualifier valueOf(String str) {
        return (MutabilityQualifier) Enum.valueOf(MutabilityQualifier.class, str);
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[]) c.clone();
    }
}
