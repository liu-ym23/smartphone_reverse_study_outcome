package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class JvmBuiltIns$Kind {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JvmBuiltIns$Kind[] f4947a;

    static {
        JvmBuiltIns$Kind[] jvmBuiltIns$KindArr = {new JvmBuiltIns$Kind("FROM_DEPENDENCIES", 0), new JvmBuiltIns$Kind("FROM_CLASS_LOADER", 1), new JvmBuiltIns$Kind("FALLBACK", 2)};
        f4947a = jvmBuiltIns$KindArr;
        kotlin.enums.a.a(jvmBuiltIns$KindArr);
    }

    public static JvmBuiltIns$Kind valueOf(String str) {
        return (JvmBuiltIns$Kind) Enum.valueOf(JvmBuiltIns$Kind.class, str);
    }

    public static JvmBuiltIns$Kind[] values() {
        return (JvmBuiltIns$Kind[]) f4947a.clone();
    }
}
