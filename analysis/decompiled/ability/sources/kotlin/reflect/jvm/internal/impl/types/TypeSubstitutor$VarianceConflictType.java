package kotlin.reflect.jvm.internal.impl.types;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class TypeSubstitutor$VarianceConflictType {

    /* renamed from: a, reason: collision with root package name */
    public static final TypeSubstitutor$VarianceConflictType f5141a;
    public static final TypeSubstitutor$VarianceConflictType b;
    public static final TypeSubstitutor$VarianceConflictType c;
    public static final /* synthetic */ TypeSubstitutor$VarianceConflictType[] d;

    static {
        TypeSubstitutor$VarianceConflictType typeSubstitutor$VarianceConflictType = new TypeSubstitutor$VarianceConflictType("NO_CONFLICT", 0);
        f5141a = typeSubstitutor$VarianceConflictType;
        TypeSubstitutor$VarianceConflictType typeSubstitutor$VarianceConflictType2 = new TypeSubstitutor$VarianceConflictType("IN_IN_OUT_POSITION", 1);
        b = typeSubstitutor$VarianceConflictType2;
        TypeSubstitutor$VarianceConflictType typeSubstitutor$VarianceConflictType3 = new TypeSubstitutor$VarianceConflictType("OUT_IN_IN_POSITION", 2);
        c = typeSubstitutor$VarianceConflictType3;
        d = new TypeSubstitutor$VarianceConflictType[]{typeSubstitutor$VarianceConflictType, typeSubstitutor$VarianceConflictType2, typeSubstitutor$VarianceConflictType3};
    }

    public static TypeSubstitutor$VarianceConflictType valueOf(String str) {
        return (TypeSubstitutor$VarianceConflictType) Enum.valueOf(TypeSubstitutor$VarianceConflictType.class, str);
    }

    public static TypeSubstitutor$VarianceConflictType[] values() {
        return (TypeSubstitutor$VarianceConflictType[]) d.clone();
    }
}
