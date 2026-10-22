package u0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ x[] f9928f;

    static {
        x[] xVarArr = {new x("CounterClockwise", 0), new x("Clockwise", 1)};
        f9928f = xVarArr;
        w7.e0.s(xVarArr);
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f9928f.clone();
    }
}
