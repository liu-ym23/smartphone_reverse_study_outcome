package z8;

/* loaded from: classes.dex */
public enum h implements f9.p {
    CLASS(0),
    INTERFACE(1),
    ENUM_CLASS(2),
    /* JADX INFO: Fake field, exist only in values array */
    ENUM_ENTRY(3),
    ANNOTATION_CLASS(4),
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT(5),
    COMPANION_OBJECT(6);


    /* renamed from: f, reason: collision with root package name */
    public final int f12180f;

    h(int i2) {
        this.f12180f = i2;
    }

    @Override // f9.p
    public final int getNumber() {
        return this.f12180f;
    }
}
