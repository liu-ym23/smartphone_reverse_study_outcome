package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class DeprecationLevelValue {

    /* renamed from: a, reason: collision with root package name */
    public static final DeprecationLevelValue f5118a;
    public static final /* synthetic */ DeprecationLevelValue[] b;

    static {
        DeprecationLevelValue deprecationLevelValue = new DeprecationLevelValue("WARNING", 0);
        DeprecationLevelValue deprecationLevelValue2 = new DeprecationLevelValue("ERROR", 1);
        f5118a = deprecationLevelValue2;
        DeprecationLevelValue[] deprecationLevelValueArr = {deprecationLevelValue, deprecationLevelValue2, new DeprecationLevelValue("HIDDEN", 2)};
        b = deprecationLevelValueArr;
        a.a(deprecationLevelValueArr);
    }

    public static DeprecationLevelValue valueOf(String str) {
        return (DeprecationLevelValue) Enum.valueOf(DeprecationLevelValue.class, str);
    }

    public static DeprecationLevelValue[] values() {
        return (DeprecationLevelValue[]) b.clone();
    }
}
