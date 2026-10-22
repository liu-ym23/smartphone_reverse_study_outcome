package z2;

/* renamed from: z2.n8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6214n8 extends AbstractC6264s8 {

    /* renamed from: a, reason: collision with root package name */
    public String f45072a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f45073b;

    /* renamed from: c, reason: collision with root package name */
    public int f45074c;

    /* renamed from: d, reason: collision with root package name */
    public byte f45075d;

    @Override // z2.AbstractC6264s8
    public final AbstractC6264s8 a(boolean z10) {
        this.f45073b = true;
        this.f45075d = (byte) (1 | this.f45075d);
        return this;
    }

    @Override // z2.AbstractC6264s8
    public final AbstractC6264s8 b(int i10) {
        this.f45074c = 1;
        this.f45075d = (byte) (this.f45075d | 2);
        return this;
    }

    @Override // z2.AbstractC6264s8
    public final AbstractC6274t8 c() {
        String str;
        if (this.f45075d == 3 && (str = this.f45072a) != null) {
            return new C6234p8(str, this.f45073b, this.f45074c, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f45072a == null) {
            sb2.append(" libraryName");
        }
        if ((this.f45075d & 1) == 0) {
            sb2.append(" enableFirelog");
        }
        if ((this.f45075d & 2) == 0) {
            sb2.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }

    public final AbstractC6264s8 d(String str) {
        this.f45072a = str;
        return this;
    }
}
