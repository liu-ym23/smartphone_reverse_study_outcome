package M2;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: M2.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0377n {

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0377n f4069b = new EnumC0377n("NONE", 0, 0);

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0377n f4070c = new EnumC0377n("TOP_TO_BOTTOM", 1, 1);

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0377n f4071d = new EnumC0377n("BOTTOM_TO_TOP", 2, 2);

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0377n f4072e = new EnumC0377n("LEFT_TO_RIGHT", 3, 3);

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0377n f4073f = new EnumC0377n("RIGHT_TO_LEFT", 4, 4);

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumC0377n[] f4074g;

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f4075h;

    /* renamed from: a, reason: collision with root package name */
    private final int f4076a;

    static {
        EnumC0377n[] enumC0377nArrB = b();
        f4074g = enumC0377nArrB;
        f4075h = C0567b.a(enumC0377nArrB);
    }

    private EnumC0377n(String str, int i5, int i6) {
        this.f4076a = i6;
    }

    private static final /* synthetic */ EnumC0377n[] b() {
        return new EnumC0377n[]{f4069b, f4070c, f4071d, f4072e, f4073f};
    }

    public static EnumC0377n valueOf(String str) {
        return (EnumC0377n) Enum.valueOf(EnumC0377n.class, str);
    }

    public static EnumC0377n[] values() {
        return (EnumC0377n[]) f4074g.clone();
    }

    public final int d() {
        return this.f4076a;
    }
}
