package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class TypeComponentPosition {

    /* renamed from: a, reason: collision with root package name */
    public static final TypeComponentPosition f5006a;
    public static final TypeComponentPosition b;
    public static final TypeComponentPosition c;
    public static final /* synthetic */ TypeComponentPosition[] d;

    static {
        TypeComponentPosition typeComponentPosition = new TypeComponentPosition("FLEXIBLE_LOWER", 0);
        f5006a = typeComponentPosition;
        TypeComponentPosition typeComponentPosition2 = new TypeComponentPosition("FLEXIBLE_UPPER", 1);
        b = typeComponentPosition2;
        TypeComponentPosition typeComponentPosition3 = new TypeComponentPosition("INFLEXIBLE", 2);
        c = typeComponentPosition3;
        TypeComponentPosition[] typeComponentPositionArr = {typeComponentPosition, typeComponentPosition2, typeComponentPosition3};
        d = typeComponentPositionArr;
        a.a(typeComponentPositionArr);
    }

    public static TypeComponentPosition valueOf(String str) {
        return (TypeComponentPosition) Enum.valueOf(TypeComponentPosition.class, str);
    }

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[]) d.clone();
    }
}
