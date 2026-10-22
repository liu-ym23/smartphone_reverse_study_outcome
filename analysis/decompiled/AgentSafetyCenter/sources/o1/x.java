package o1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public static final x f9098c;

    /* renamed from: f, reason: collision with root package name */
    public static final x f9099f;

    /* renamed from: g, reason: collision with root package name */
    public static final x f9100g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ x[] f9101h;

    static {
        x xVar = new x("Unknown", 0);
        f9098c = xVar;
        x xVar2 = new x("Dispatching", 1);
        f9099f = xVar2;
        x xVar3 = new x("NotDispatching", 2);
        f9100g = xVar3;
        x[] xVarArr = {xVar, xVar2, xVar3};
        f9101h = xVarArr;
        a.a.p(xVarArr);
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f9101h.clone();
    }
}
