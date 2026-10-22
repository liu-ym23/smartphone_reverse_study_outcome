package T0;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1792a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f1793b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f1794c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f1795d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f1796e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f1797f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ a[] f1798g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f1799h;

    static {
        a aVar = new a("LITE_POWER_HIGH", 0);
        f1792a = aVar;
        a aVar2 = new a("LITE_POWER_LOW", 1);
        f1793b = aVar2;
        a aVar3 = new a("LITE_POWER_FULL", 2);
        f1794c = aVar3;
        a aVar4 = new a("LITE_POWER_NO_BIND", 3);
        f1795d = aVar4;
        a aVar5 = new a("LITE_POWER_RAND_HIGH", 4);
        f1796e = aVar5;
        a aVar6 = new a("LITE_POWER_RAND_LOW", 5);
        f1797f = aVar6;
        a[] aVarArr = {aVar, aVar2, aVar3, aVar4, aVar5, aVar6};
        f1798g = aVarArr;
        f1799h = EnumEntriesKt.enumEntries(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1798g.clone();
    }
}
