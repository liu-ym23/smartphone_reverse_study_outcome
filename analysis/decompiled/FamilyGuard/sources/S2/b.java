package S2;

/* loaded from: classes.dex */
public enum b {
    PHONE(1),
    TV(2),
    PAD(3),
    WEARABLE(4);


    /* renamed from: a, reason: collision with root package name */
    private final int f5241a;

    b(int i5) {
        this.f5241a = i5;
    }

    public int d() {
        return this.f5241a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f5241a);
    }
}
