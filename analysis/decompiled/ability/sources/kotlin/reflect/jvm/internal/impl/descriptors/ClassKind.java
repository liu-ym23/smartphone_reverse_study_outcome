package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ClassKind {

    /* renamed from: a, reason: collision with root package name */
    public static final ClassKind f4951a;
    public static final ClassKind b;
    public static final ClassKind c;
    public static final ClassKind d;
    public static final ClassKind e;
    public static final ClassKind f;
    public static final /* synthetic */ ClassKind[] g;

    static {
        ClassKind classKind = new ClassKind("CLASS", 0);
        f4951a = classKind;
        ClassKind classKind2 = new ClassKind("INTERFACE", 1);
        b = classKind2;
        ClassKind classKind3 = new ClassKind("ENUM_CLASS", 2);
        c = classKind3;
        ClassKind classKind4 = new ClassKind("ENUM_ENTRY", 3);
        d = classKind4;
        ClassKind classKind5 = new ClassKind("ANNOTATION_CLASS", 4);
        e = classKind5;
        ClassKind classKind6 = new ClassKind("OBJECT", 5);
        f = classKind6;
        ClassKind[] classKindArr = {classKind, classKind2, classKind3, classKind4, classKind5, classKind6};
        g = classKindArr;
        kotlin.enums.a.a(classKindArr);
    }

    public static ClassKind valueOf(String str) {
        return (ClassKind) Enum.valueOf(ClassKind.class, str);
    }

    public static ClassKind[] values() {
        return (ClassKind[]) g.clone();
    }

    public final boolean a() {
        return this == f || this == d;
    }
}
