package kotlin.reflect.jvm.internal.impl.types;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class TypeUsage {

    /* renamed from: a, reason: collision with root package name */
    public static final TypeUsage f5142a;
    public static final TypeUsage b;
    public static final /* synthetic */ TypeUsage[] c;

    static {
        TypeUsage typeUsage = new TypeUsage("SUPERTYPE", 0);
        f5142a = typeUsage;
        TypeUsage typeUsage2 = new TypeUsage("COMMON", 1);
        b = typeUsage2;
        TypeUsage[] typeUsageArr = {typeUsage, typeUsage2};
        c = typeUsageArr;
        kotlin.enums.a.a(typeUsageArr);
    }

    public static TypeUsage valueOf(String str) {
        return (TypeUsage) Enum.valueOf(TypeUsage.class, str);
    }

    public static TypeUsage[] values() {
        return (TypeUsage[]) c.clone();
    }
}
