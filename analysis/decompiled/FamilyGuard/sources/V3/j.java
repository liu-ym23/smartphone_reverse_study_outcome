package V3;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f5524a = new j("SYNCHRONIZED", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final j f5525b = new j("PUBLICATION", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final j f5526c = new j("NONE", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f5527d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f5528e;

    static {
        j[] jVarArrB = b();
        f5527d = jVarArrB;
        f5528e = C0567b.a(jVarArrB);
    }

    private j(String str, int i5) {
    }

    private static final /* synthetic */ j[] b() {
        return new j[]{f5524a, f5525b, f5526c};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f5527d.clone();
    }
}
