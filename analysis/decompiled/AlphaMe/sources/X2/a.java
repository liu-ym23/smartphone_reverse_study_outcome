package X2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a[] f2110a = {new a("PASS_THROUGH", 0), new a("FULL", 1), new a("SPECIAL", 2), new a("UNBOUNDED_IN", 3), new a("ERROR", 4), new a("NONE", 5)};

    /* JADX INFO: Fake field, exist only in values array */
    a EF5;

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2110a.clone();
    }
}
