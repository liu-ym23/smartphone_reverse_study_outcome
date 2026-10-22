package y2;

/* renamed from: y2.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5936q extends v {

    /* renamed from: a, reason: collision with root package name */
    public String f43832a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f43833b;

    /* renamed from: c, reason: collision with root package name */
    public int f43834c;

    /* renamed from: d, reason: collision with root package name */
    public byte f43835d;

    @Override // y2.v
    public final v a(boolean z10) {
        this.f43833b = true;
        this.f43835d = (byte) (1 | this.f43835d);
        return this;
    }

    @Override // y2.v
    public final v b(int i10) {
        this.f43834c = 1;
        this.f43835d = (byte) (this.f43835d | 2);
        return this;
    }

    @Override // y2.v
    public final w c() {
        String str;
        if (this.f43835d == 3 && (str = this.f43832a) != null) {
            return new s(str, this.f43833b, this.f43834c, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f43832a == null) {
            sb2.append(" libraryName");
        }
        if ((this.f43835d & 1) == 0) {
            sb2.append(" enableFirelog");
        }
        if ((this.f43835d & 2) == 0) {
            sb2.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }

    public final v d(String str) {
        this.f43832a = "common";
        return this;
    }
}
