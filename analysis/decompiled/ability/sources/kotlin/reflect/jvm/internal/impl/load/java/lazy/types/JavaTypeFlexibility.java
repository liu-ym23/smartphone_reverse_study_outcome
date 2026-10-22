package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class JavaTypeFlexibility {

    /* renamed from: a, reason: collision with root package name */
    public static final JavaTypeFlexibility f5002a;
    public static final JavaTypeFlexibility b;
    public static final JavaTypeFlexibility c;
    public static final /* synthetic */ JavaTypeFlexibility[] d;

    static {
        JavaTypeFlexibility javaTypeFlexibility = new JavaTypeFlexibility("INFLEXIBLE", 0);
        f5002a = javaTypeFlexibility;
        JavaTypeFlexibility javaTypeFlexibility2 = new JavaTypeFlexibility("FLEXIBLE_UPPER_BOUND", 1);
        b = javaTypeFlexibility2;
        JavaTypeFlexibility javaTypeFlexibility3 = new JavaTypeFlexibility("FLEXIBLE_LOWER_BOUND", 2);
        c = javaTypeFlexibility3;
        JavaTypeFlexibility[] javaTypeFlexibilityArr = {javaTypeFlexibility, javaTypeFlexibility2, javaTypeFlexibility3};
        d = javaTypeFlexibilityArr;
        a.a(javaTypeFlexibilityArr);
    }

    public static JavaTypeFlexibility valueOf(String str) {
        return (JavaTypeFlexibility) Enum.valueOf(JavaTypeFlexibility.class, str);
    }

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[]) d.clone();
    }
}
