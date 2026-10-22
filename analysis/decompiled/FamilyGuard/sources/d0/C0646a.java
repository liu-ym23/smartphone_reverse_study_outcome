package d0;

/* renamed from: d0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0646a implements InterfaceC0650e {

    /* renamed from: a, reason: collision with root package name */
    private final String f16571a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f16572b;

    public C0646a(String str, Object[] objArr) {
        this.f16571a = str;
        this.f16572b = objArr;
    }

    private static void b(InterfaceC0649d interfaceC0649d, int i5, Object obj) {
        if (obj == null) {
            interfaceC0649d.Z(i5);
            return;
        }
        if (obj instanceof byte[]) {
            interfaceC0649d.F(i5, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            interfaceC0649d.q(i5, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            interfaceC0649d.q(i5, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            interfaceC0649d.z(i5, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            interfaceC0649d.z(i5, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            interfaceC0649d.z(i5, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            interfaceC0649d.z(i5, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            interfaceC0649d.l(i5, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            interfaceC0649d.z(i5, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i5 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void d(InterfaceC0649d interfaceC0649d, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i5 = 0;
        while (i5 < length) {
            Object obj = objArr[i5];
            i5++;
            b(interfaceC0649d, i5, obj);
        }
    }

    @Override // d0.InterfaceC0650e
    public void a(InterfaceC0649d interfaceC0649d) {
        d(interfaceC0649d, this.f16572b);
    }

    @Override // d0.InterfaceC0650e
    public String c() {
        return this.f16571a;
    }

    public C0646a(String str) {
        this(str, null);
    }
}
