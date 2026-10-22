package qb;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a[] f8834f = {new a("AGREEMENT", 0), new a("ENCRYPTION", 1), new a("DECRYPTION", 2), new a("KEYGEN", 3), new a("SIGNING", 4), new a("VERIFYING", 5), new a("AUTHENTICATION", 6), new a("VERIFICATION", 7), new a("PRF", 8), new a("ANY", 9)};

    /* JADX INFO: Fake field, exist only in values array */
    a EF5;

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8834f.clone();
    }
}
