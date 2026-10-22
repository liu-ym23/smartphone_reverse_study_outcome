package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class LightClassOriginKind {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LightClassOriginKind[] f5003a;

    static {
        LightClassOriginKind[] lightClassOriginKindArr = {new LightClassOriginKind("SOURCE", 0), new LightClassOriginKind("BINARY", 1)};
        f5003a = lightClassOriginKindArr;
        a.a(lightClassOriginKindArr);
    }

    public static LightClassOriginKind valueOf(String str) {
        return (LightClassOriginKind) Enum.valueOf(LightClassOriginKind.class, str);
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[]) f5003a.clone();
    }
}
