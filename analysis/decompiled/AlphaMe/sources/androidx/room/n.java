package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f4222a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ n[] f4223b;

    static {
        n nVar = new n("ASC", 0);
        f4222a = nVar;
        f4223b = new n[]{nVar, new n("DESC", 1)};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f4223b.clone();
    }
}
