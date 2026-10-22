package cc.dd.ee.kk.ff;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f2142a;
    public static final c b;
    public static final c c;
    public static final /* synthetic */ c[] d;

    static {
        c cVar = new c("IO", 0);
        f2142a = cVar;
        c cVar2 = new c("LIGHT_WEIGHT", 1);
        b = cVar2;
        c cVar3 = new c("TIME_SENSITIVE", 2);
        c cVar4 = new c("CPU", 3);
        c = cVar4;
        d = new c[]{cVar, cVar2, cVar3, cVar4};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) d.clone();
    }
}
