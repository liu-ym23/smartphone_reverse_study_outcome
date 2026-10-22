package A2;

/* renamed from: A2.g5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0617g5 extends m5 {

    /* renamed from: a, reason: collision with root package name */
    public String f685a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f686b;

    /* renamed from: c, reason: collision with root package name */
    public int f687c;

    /* renamed from: d, reason: collision with root package name */
    public byte f688d;

    @Override // A2.m5
    public final m5 a(boolean z10) {
        this.f686b = true;
        this.f688d = (byte) (1 | this.f688d);
        return this;
    }

    @Override // A2.m5
    public final m5 b(int i10) {
        this.f687c = 1;
        this.f688d = (byte) (this.f688d | 2);
        return this;
    }

    @Override // A2.m5
    public final n5 c() {
        String str;
        if (this.f688d == 3 && (str = this.f685a) != null) {
            return new j5(str, this.f686b, this.f687c, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f685a == null) {
            sb2.append(" libraryName");
        }
        if ((this.f688d & 1) == 0) {
            sb2.append(" enableFirelog");
        }
        if ((this.f688d & 2) == 0) {
            sb2.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }

    public final m5 d(String str) {
        this.f685a = "vision-common";
        return this;
    }
}
