package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f4264a;

    /* renamed from: b, reason: collision with root package name */
    public static final y f4265b;

    /* renamed from: c, reason: collision with root package name */
    public static final y f4266c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ y[] f4267d;

    static {
        y yVar = new y("AUTOMATIC", 0);
        f4264a = yVar;
        y yVar2 = new y("TRUNCATE", 1);
        f4265b = yVar2;
        y yVar3 = new y("WRITE_AHEAD_LOGGING", 2);
        f4266c = yVar3;
        f4267d = new y[]{yVar, yVar2, yVar3};
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f4267d.clone();
    }
}
