package r4;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: r4.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1030m {

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC1030m f20116c = new EnumC1030m("IGNORE_CASE", 0, 2, 0, 2, null);

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC1030m f20117d = new EnumC1030m("MULTILINE", 1, 8, 0, 2, null);

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC1030m f20118e = new EnumC1030m("LITERAL", 2, 16, 0, 2, null);

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC1030m f20119f = new EnumC1030m("UNIX_LINES", 3, 1, 0, 2, null);

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC1030m f20120g = new EnumC1030m("COMMENTS", 4, 4, 0, 2, null);

    /* renamed from: h, reason: collision with root package name */
    public static final EnumC1030m f20121h = new EnumC1030m("DOT_MATCHES_ALL", 5, 32, 0, 2, null);

    /* renamed from: i, reason: collision with root package name */
    public static final EnumC1030m f20122i = new EnumC1030m("CANON_EQ", 6, 128, 0, 2, null);

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ EnumC1030m[] f20123j;

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f20124k;

    /* renamed from: a, reason: collision with root package name */
    private final int f20125a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20126b;

    static {
        EnumC1030m[] enumC1030mArrB = b();
        f20123j = enumC1030mArrB;
        f20124k = C0567b.a(enumC1030mArrB);
    }

    private EnumC1030m(String str, int i5, int i6, int i7) {
        this.f20125a = i6;
        this.f20126b = i7;
    }

    private static final /* synthetic */ EnumC1030m[] b() {
        return new EnumC1030m[]{f20116c, f20117d, f20118e, f20119f, f20120g, f20121h, f20122i};
    }

    public static EnumC1030m valueOf(String str) {
        return (EnumC1030m) Enum.valueOf(EnumC1030m.class, str);
    }

    public static EnumC1030m[] values() {
        return (EnumC1030m[]) f20123j.clone();
    }

    public int d() {
        return this.f20125a;
    }

    /* synthetic */ EnumC1030m(String str, int i5, int i6, int i7, int i8, j4.g gVar) {
        this(str, i5, i6, (i8 & 2) != 0 ? i6 : i7);
    }
}
