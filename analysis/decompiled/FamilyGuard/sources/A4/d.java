package A4;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f185a = new d("SUCCESSFUL", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final d f186b = new d("REREGISTER", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final d f187c = new d("CANCELLED", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final d f188d = new d("ALREADY_SELECTED", 3);

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d[] f189e;

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f190f;

    static {
        d[] dVarArrB = b();
        f189e = dVarArrB;
        f190f = C0567b.a(dVarArrB);
    }

    private d(String str, int i5) {
    }

    private static final /* synthetic */ d[] b() {
        return new d[]{f185a, f186b, f187c, f188d};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f189e.clone();
    }
}
