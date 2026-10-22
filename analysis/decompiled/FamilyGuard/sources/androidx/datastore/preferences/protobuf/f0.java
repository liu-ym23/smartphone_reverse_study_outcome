package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class f0 implements P {

    /* renamed from: a, reason: collision with root package name */
    private final S f10005a;

    /* renamed from: b, reason: collision with root package name */
    private final String f10006b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f10007c;

    /* renamed from: d, reason: collision with root package name */
    private final int f10008d;

    f0(S s5, String str, Object[] objArr) {
        this.f10005a = s5;
        this.f10006b = str;
        this.f10007c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f10008d = cCharAt;
            return;
        }
        int i5 = cCharAt & 8191;
        int i6 = 13;
        int i7 = 1;
        while (true) {
            int i8 = i7 + 1;
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 < 55296) {
                this.f10008d = i5 | (cCharAt2 << i6);
                return;
            } else {
                i5 |= (cCharAt2 & 8191) << i6;
                i6 += 13;
                i7 = i8;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.P
    public boolean a() {
        return (this.f10008d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.P
    public S b() {
        return this.f10005a;
    }

    @Override // androidx.datastore.preferences.protobuf.P
    public c0 c() {
        return (this.f10008d & 1) == 1 ? c0.PROTO2 : c0.PROTO3;
    }

    Object[] d() {
        return this.f10007c;
    }

    String e() {
        return this.f10006b;
    }
}
