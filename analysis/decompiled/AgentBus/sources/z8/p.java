package z8;

/* loaded from: classes.dex */
public enum p implements f9.p {
    AT_MOST_ONCE(0),
    EXACTLY_ONCE(1),
    AT_LEAST_ONCE(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f12297f;

    p(int i2) {
        this.f12297f = i2;
    }

    @Override // f9.p
    public final int getNumber() {
        return this.f12297f;
    }
}
