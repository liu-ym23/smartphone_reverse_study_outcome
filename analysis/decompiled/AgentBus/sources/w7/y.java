package w7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: f, reason: collision with root package name */
    public static final y f10877f;

    /* renamed from: g, reason: collision with root package name */
    public static final y f10878g;

    /* renamed from: h, reason: collision with root package name */
    public static final y f10879h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ y[] f10880i;

    static {
        y yVar = new y("INVARIANT", 0);
        f10877f = yVar;
        y yVar2 = new y("IN", 1);
        f10878g = yVar2;
        y yVar3 = new y("OUT", 2);
        f10879h = yVar3;
        y[] yVarArr = {yVar, yVar2, yVar3};
        f10880i = yVarArr;
        e0.s(yVarArr);
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f10880i.clone();
    }
}
