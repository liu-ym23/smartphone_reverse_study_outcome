package kotlin.reflect.jvm.internal.impl.types;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class TypeCheckerState$LowerCapturedTypePolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeCheckerState$LowerCapturedTypePolicy[] f5140a;

    static {
        TypeCheckerState$LowerCapturedTypePolicy[] typeCheckerState$LowerCapturedTypePolicyArr = {new TypeCheckerState$LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0), new TypeCheckerState$LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1), new TypeCheckerState$LowerCapturedTypePolicy("SKIP_LOWER", 2)};
        f5140a = typeCheckerState$LowerCapturedTypePolicyArr;
        kotlin.enums.a.a(typeCheckerState$LowerCapturedTypePolicyArr);
    }

    public static TypeCheckerState$LowerCapturedTypePolicy valueOf(String str) {
        return (TypeCheckerState$LowerCapturedTypePolicy) Enum.valueOf(TypeCheckerState$LowerCapturedTypePolicy.class, str);
    }

    public static TypeCheckerState$LowerCapturedTypePolicy[] values() {
        return (TypeCheckerState$LowerCapturedTypePolicy[]) f5140a.clone();
    }
}
