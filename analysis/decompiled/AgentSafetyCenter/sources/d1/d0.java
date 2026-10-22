package d1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d0[] f2965c;

    static {
        d0[] d0VarArr = {new d0("CounterClockwise", 0), new d0("Clockwise", 1)};
        f2965c = d0VarArr;
        a.a.p(d0VarArr);
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) f2965c.clone();
    }
}
