package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class IntegerLiteralTypeConstructor$Companion$Mode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntegerLiteralTypeConstructor$Companion$Mode[] f5117a;

    static {
        IntegerLiteralTypeConstructor$Companion$Mode[] integerLiteralTypeConstructor$Companion$ModeArr = {new IntegerLiteralTypeConstructor$Companion$Mode("COMMON_SUPER_TYPE", 0), new IntegerLiteralTypeConstructor$Companion$Mode("INTERSECTION_TYPE", 1)};
        f5117a = integerLiteralTypeConstructor$Companion$ModeArr;
        kotlin.enums.a.a(integerLiteralTypeConstructor$Companion$ModeArr);
    }

    public static IntegerLiteralTypeConstructor$Companion$Mode valueOf(String str) {
        return (IntegerLiteralTypeConstructor$Companion$Mode) Enum.valueOf(IntegerLiteralTypeConstructor$Companion$Mode.class, str);
    }

    public static IntegerLiteralTypeConstructor$Companion$Mode[] values() {
        return (IntegerLiteralTypeConstructor$Companion$Mode[]) f5117a.clone();
    }
}
