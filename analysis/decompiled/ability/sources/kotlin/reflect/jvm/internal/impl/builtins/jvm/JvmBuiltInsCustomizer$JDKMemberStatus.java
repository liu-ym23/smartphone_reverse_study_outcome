package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class JvmBuiltInsCustomizer$JDKMemberStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final JvmBuiltInsCustomizer$JDKMemberStatus f4948a;
    public static final JvmBuiltInsCustomizer$JDKMemberStatus b;
    public static final JvmBuiltInsCustomizer$JDKMemberStatus c;
    public static final JvmBuiltInsCustomizer$JDKMemberStatus d;
    public static final JvmBuiltInsCustomizer$JDKMemberStatus e;
    public static final /* synthetic */ JvmBuiltInsCustomizer$JDKMemberStatus[] f;

    static {
        JvmBuiltInsCustomizer$JDKMemberStatus jvmBuiltInsCustomizer$JDKMemberStatus = new JvmBuiltInsCustomizer$JDKMemberStatus("HIDDEN", 0);
        f4948a = jvmBuiltInsCustomizer$JDKMemberStatus;
        JvmBuiltInsCustomizer$JDKMemberStatus jvmBuiltInsCustomizer$JDKMemberStatus2 = new JvmBuiltInsCustomizer$JDKMemberStatus("VISIBLE", 1);
        b = jvmBuiltInsCustomizer$JDKMemberStatus2;
        JvmBuiltInsCustomizer$JDKMemberStatus jvmBuiltInsCustomizer$JDKMemberStatus3 = new JvmBuiltInsCustomizer$JDKMemberStatus("DEPRECATED_LIST_METHODS", 2);
        c = jvmBuiltInsCustomizer$JDKMemberStatus3;
        JvmBuiltInsCustomizer$JDKMemberStatus jvmBuiltInsCustomizer$JDKMemberStatus4 = new JvmBuiltInsCustomizer$JDKMemberStatus("NOT_CONSIDERED", 3);
        d = jvmBuiltInsCustomizer$JDKMemberStatus4;
        JvmBuiltInsCustomizer$JDKMemberStatus jvmBuiltInsCustomizer$JDKMemberStatus5 = new JvmBuiltInsCustomizer$JDKMemberStatus("DROP", 4);
        e = jvmBuiltInsCustomizer$JDKMemberStatus5;
        JvmBuiltInsCustomizer$JDKMemberStatus[] jvmBuiltInsCustomizer$JDKMemberStatusArr = {jvmBuiltInsCustomizer$JDKMemberStatus, jvmBuiltInsCustomizer$JDKMemberStatus2, jvmBuiltInsCustomizer$JDKMemberStatus3, jvmBuiltInsCustomizer$JDKMemberStatus4, jvmBuiltInsCustomizer$JDKMemberStatus5};
        f = jvmBuiltInsCustomizer$JDKMemberStatusArr;
        kotlin.enums.a.a(jvmBuiltInsCustomizer$JDKMemberStatusArr);
    }

    public static JvmBuiltInsCustomizer$JDKMemberStatus valueOf(String str) {
        return (JvmBuiltInsCustomizer$JDKMemberStatus) Enum.valueOf(JvmBuiltInsCustomizer$JDKMemberStatus.class, str);
    }

    public static JvmBuiltInsCustomizer$JDKMemberStatus[] values() {
        return (JvmBuiltInsCustomizer$JDKMemberStatus[]) f.clone();
    }
}
