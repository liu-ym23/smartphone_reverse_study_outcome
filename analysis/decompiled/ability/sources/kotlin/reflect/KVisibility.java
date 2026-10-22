package kotlin.reflect;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/reflect/KVisibility;", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KVisibility {

    /* renamed from: a, reason: collision with root package name */
    public static final KVisibility f4932a;
    public static final KVisibility b;
    public static final KVisibility c;
    public static final KVisibility d;
    public static final /* synthetic */ KVisibility[] e;

    static {
        KVisibility kVisibility = new KVisibility("PUBLIC", 0);
        f4932a = kVisibility;
        KVisibility kVisibility2 = new KVisibility("PROTECTED", 1);
        b = kVisibility2;
        KVisibility kVisibility3 = new KVisibility("INTERNAL", 2);
        c = kVisibility3;
        KVisibility kVisibility4 = new KVisibility("PRIVATE", 3);
        d = kVisibility4;
        KVisibility[] kVisibilityArr = {kVisibility, kVisibility2, kVisibility3, kVisibility4};
        e = kVisibilityArr;
        kotlin.enums.a.a(kVisibilityArr);
    }

    public static KVisibility valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) e.clone();
    }
}
