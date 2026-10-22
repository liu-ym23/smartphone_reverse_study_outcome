package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class X implements I {

    /* renamed from: a, reason: collision with root package name */
    public final K f13499a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13500b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f13501c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13502d;

    public X(K k10, String str, Object[] objArr) {
        this.f13499a = k10;
        this.f13500b = str;
        this.f13501c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f13502d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.f13502d = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    public Object[] a() {
        return this.f13501c;
    }

    public String b() {
        return this.f13500b;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public K getDefaultInstance() {
        return this.f13499a;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public ProtoSyntax getSyntax() {
        return (this.f13502d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public boolean isMessageSetWireFormat() {
        return (this.f13502d & 2) == 2;
    }
}
