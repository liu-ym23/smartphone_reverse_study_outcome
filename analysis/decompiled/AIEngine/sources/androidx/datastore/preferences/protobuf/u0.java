package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u0 implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f1890a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1891b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f1892c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1893d;

    public u0(GeneratedMessageLite generatedMessageLite, String str, Object[] objArr) {
        this.f1890a = generatedMessageLite;
        this.f1891b = str;
        this.f1892c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f1893d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.f1893d = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final boolean a() {
        return (this.f1893d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final i0 b() {
        return this.f1890a;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final ProtoSyntax c() {
        return (this.f1893d & 1) == 1 ? ProtoSyntax.f1762a : ProtoSyntax.f1763b;
    }
}
