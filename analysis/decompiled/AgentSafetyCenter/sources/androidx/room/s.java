package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: c, reason: collision with root package name */
    public static final s f1622c;

    /* renamed from: f, reason: collision with root package name */
    public static final s f1623f;

    /* renamed from: g, reason: collision with root package name */
    public static final s f1624g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ s[] f1625h;

    static {
        s sVar = new s("AUTOMATIC", 0);
        f1622c = sVar;
        s sVar2 = new s("TRUNCATE", 1);
        f1623f = sVar2;
        s sVar3 = new s("WRITE_AHEAD_LOGGING", 2);
        f1624g = sVar3;
        s[] sVarArr = {sVar, sVar2, sVar3};
        f1625h = sVarArr;
        a.a.p(sVarArr);
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f1625h.clone();
    }
}
