package kotlin.reflect;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/reflect/KParameter$Kind", "", "Lkotlin/reflect/KParameter$Kind;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KParameter$Kind {

    /* renamed from: a, reason: collision with root package name */
    public static final KParameter$Kind f4930a;
    public static final KParameter$Kind b;
    public static final KParameter$Kind c;
    public static final /* synthetic */ KParameter$Kind[] d;

    static {
        KParameter$Kind kParameter$Kind = new KParameter$Kind("INSTANCE", 0);
        f4930a = kParameter$Kind;
        KParameter$Kind kParameter$Kind2 = new KParameter$Kind("CONTEXT", 1);
        KParameter$Kind kParameter$Kind3 = new KParameter$Kind("EXTENSION_RECEIVER", 2);
        b = kParameter$Kind3;
        KParameter$Kind kParameter$Kind4 = new KParameter$Kind("VALUE", 3);
        c = kParameter$Kind4;
        KParameter$Kind[] kParameter$KindArr = {kParameter$Kind, kParameter$Kind2, kParameter$Kind3, kParameter$Kind4};
        d = kParameter$KindArr;
        kotlin.enums.a.a(kParameter$KindArr);
    }

    public static KParameter$Kind valueOf(String str) {
        return (KParameter$Kind) Enum.valueOf(KParameter$Kind.class, str);
    }

    public static KParameter$Kind[] values() {
        return (KParameter$Kind[]) d.clone();
    }
}
