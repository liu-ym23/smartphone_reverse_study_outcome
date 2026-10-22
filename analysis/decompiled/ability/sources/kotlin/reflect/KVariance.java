package kotlin.reflect;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/reflect/KVariance;", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KVariance {

    /* renamed from: a, reason: collision with root package name */
    public static final KVariance f4931a;
    public static final KVariance b;
    public static final KVariance c;
    public static final /* synthetic */ KVariance[] d;

    static {
        KVariance kVariance = new KVariance("INVARIANT", 0);
        f4931a = kVariance;
        KVariance kVariance2 = new KVariance("IN", 1);
        b = kVariance2;
        KVariance kVariance3 = new KVariance("OUT", 2);
        c = kVariance3;
        KVariance[] kVarianceArr = {kVariance, kVariance2, kVariance3};
        d = kVarianceArr;
        kotlin.enums.a.a(kVarianceArr);
    }

    public static KVariance valueOf(String str) {
        return (KVariance) Enum.valueOf(KVariance.class, str);
    }

    public static KVariance[] values() {
        return (KVariance[]) d.clone();
    }
}
