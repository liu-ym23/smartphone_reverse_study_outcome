package i1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: f, reason: collision with root package name */
    public static final s f4583f;

    /* renamed from: g, reason: collision with root package name */
    public static final s f4584g;

    /* renamed from: h, reason: collision with root package name */
    public static final s f4585h;

    /* renamed from: i, reason: collision with root package name */
    public static final s f4586i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ s[] f4587j;

    static {
        s sVar = new s("LookaheadMeasurement", 0);
        f4583f = sVar;
        s sVar2 = new s("LookaheadPlacement", 1);
        f4584g = sVar2;
        s sVar3 = new s("Measurement", 2);
        f4585h = sVar3;
        s sVar4 = new s("Placement", 3);
        f4586i = sVar4;
        s[] sVarArr = {sVar, sVar2, sVar3, sVar4};
        f4587j = sVarArr;
        w7.e0.s(sVarArr);
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f4587j.clone();
    }
}
