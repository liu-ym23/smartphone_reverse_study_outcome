package cc.dd.ee.ee.ee;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f2139a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final /* synthetic */ d[] f;

    static {
        d dVar = new d("PROCESS_DETECT", 0);
        f2139a = dVar;
        d dVar2 = new d("PROCESS_DOUBLE_DETECT", 1);
        b = dVar2;
        d dVar3 = new d("THREAD_DETECT", 2);
        c = dVar3;
        d dVar4 = new d("COOL_DOWN", 3);
        d = dVar4;
        d dVar5 = new d("IDLE", 4);
        e = dVar5;
        f = new d[]{dVar, dVar2, dVar3, dVar4, dVar5};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f.clone();
    }
}
