package c8;

/* loaded from: classes.dex */
public enum q {
    /* JADX INFO: Fake field, exist only in values array */
    UBYTE(e9.b.e("kotlin/UByte", false)),
    /* JADX INFO: Fake field, exist only in values array */
    USHORT(e9.b.e("kotlin/UShort", false)),
    /* JADX INFO: Fake field, exist only in values array */
    UINT(e9.b.e("kotlin/UInt", false)),
    /* JADX INFO: Fake field, exist only in values array */
    ULONG(e9.b.e("kotlin/ULong", false));


    /* renamed from: f, reason: collision with root package name */
    public final e9.b f2080f;

    /* renamed from: g, reason: collision with root package name */
    public final e9.f f2081g;

    /* renamed from: h, reason: collision with root package name */
    public final e9.b f2082h;

    q(e9.b bVar) {
        this.f2080f = bVar;
        e9.f fVarI = bVar.i();
        q7.k.d(fVarI, "classId.shortClassName");
        this.f2081g = fVarI;
        this.f2082h = new e9.b(bVar.g(), e9.f.e(fVarI.b() + "Array"));
    }
}
