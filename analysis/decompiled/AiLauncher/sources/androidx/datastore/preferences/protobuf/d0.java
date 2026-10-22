package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class d0 implements I {

    /* renamed from: a, reason: collision with root package name */
    public final ProtoSyntax f13532a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13533b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f13534c;

    /* renamed from: d, reason: collision with root package name */
    public final r[] f13535d;

    /* renamed from: e, reason: collision with root package name */
    public final K f13536e;

    public int[] a() {
        return this.f13534c;
    }

    public r[] b() {
        return this.f13535d;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public K getDefaultInstance() {
        return this.f13536e;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public ProtoSyntax getSyntax() {
        return this.f13532a;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public boolean isMessageSetWireFormat() {
        return this.f13533b;
    }
}
