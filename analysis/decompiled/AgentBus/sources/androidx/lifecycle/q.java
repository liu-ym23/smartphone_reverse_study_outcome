package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: f, reason: collision with root package name */
    public static final q f1020f;

    /* renamed from: g, reason: collision with root package name */
    public static final q f1021g;

    /* renamed from: h, reason: collision with root package name */
    public static final q f1022h;

    /* renamed from: i, reason: collision with root package name */
    public static final q f1023i;

    /* renamed from: j, reason: collision with root package name */
    public static final q f1024j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ q[] f1025k;

    static {
        q qVar = new q("DESTROYED", 0);
        f1020f = qVar;
        q qVar2 = new q("INITIALIZED", 1);
        f1021g = qVar2;
        q qVar3 = new q("CREATED", 2);
        f1022h = qVar3;
        q qVar4 = new q("STARTED", 3);
        f1023i = qVar4;
        q qVar5 = new q("RESUMED", 4);
        f1024j = qVar5;
        q[] qVarArr = {qVar, qVar2, qVar3, qVar4, qVar5};
        f1025k = qVarArr;
        w7.e0.s(qVarArr);
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f1025k.clone();
    }
}
