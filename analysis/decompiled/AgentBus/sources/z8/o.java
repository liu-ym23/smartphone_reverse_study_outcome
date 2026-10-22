package z8;

/* loaded from: classes.dex */
public enum o implements f9.p {
    RETURNS_CONSTANT(0),
    CALLS(1),
    RETURNS_NOT_NULL(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f12277f;

    o(int i2) {
        this.f12277f = i2;
    }

    @Override // f9.p
    public final int getNumber() {
        return this.f12277f;
    }
}
