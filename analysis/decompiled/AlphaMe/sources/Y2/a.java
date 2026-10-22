package Y2;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2121a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f2122b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f2123c;

    static {
        a aVar = new a("SPARSE_ARRAY", 0);
        a aVar2 = new a("HASH_MAP", 1);
        f2121a = aVar2;
        a[] aVarArr = {aVar, aVar2, new a("NO_CACHE", 2)};
        f2122b = aVarArr;
        f2123c = EnumEntriesKt.enumEntries(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2122b.clone();
    }
}
