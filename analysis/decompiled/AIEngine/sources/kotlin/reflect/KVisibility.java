package kotlin.reflect;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KVisibility {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KVisibility[] f10091a;

    static {
        KVisibility[] kVisibilityArr = {new KVisibility("PUBLIC", 0), new KVisibility("PROTECTED", 1), new KVisibility("INTERNAL", 2), new KVisibility("PRIVATE", 3)};
        f10091a = kVisibilityArr;
        a.a(kVisibilityArr);
    }

    public KVisibility() {
        throw null;
    }

    public static KVisibility valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) f10091a.clone();
    }
}
