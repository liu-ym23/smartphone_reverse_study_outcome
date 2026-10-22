package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ o[] f4224a = {new o("ASC", 0), new o("DESC", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    o EF5;

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) f4224a.clone();
    }
}
