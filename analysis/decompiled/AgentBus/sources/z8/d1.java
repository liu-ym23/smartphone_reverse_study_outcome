package z8;

/* loaded from: classes.dex */
public enum d1 implements f9.p {
    /* JADX INFO: Fake field, exist only in values array */
    INTERNAL(0),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE(1),
    /* JADX INFO: Fake field, exist only in values array */
    PROTECTED(2),
    /* JADX INFO: Fake field, exist only in values array */
    PUBLIC(3),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE_TO_THIS(4),
    /* JADX INFO: Fake field, exist only in values array */
    LOCAL(5);


    /* renamed from: f, reason: collision with root package name */
    public final int f12104f;

    d1(int i2) {
        this.f12104f = i2;
    }

    @Override // f9.p
    public final int getNumber() {
        return this.f12104f;
    }
}
