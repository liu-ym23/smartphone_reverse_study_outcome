package j1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ w1[] f5345f;

    static {
        w1[] w1VarArr = {new w1("Shown", 0), new w1("Hidden", 1)};
        f5345f = w1VarArr;
        w7.e0.s(w1VarArr);
    }

    public static w1 valueOf(String str) {
        return (w1) Enum.valueOf(w1.class, str);
    }

    public static w1[] values() {
        return (w1[]) f5345f.clone();
    }
}
