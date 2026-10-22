package g9;

/* loaded from: classes.dex */
public enum a {
    NO_ARGUMENTS(3),
    /* JADX INFO: Fake field, exist only in values array */
    UNLESS_EMPTY(2),
    /* JADX INFO: Fake field, exist only in values array */
    ALWAYS_PARENTHESIZED(true, true);


    /* renamed from: f, reason: collision with root package name */
    public final boolean f3925f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3926g;

    /* synthetic */ a(int i2) {
        this((i2 & 1) == 0, false);
    }

    a(boolean z4, boolean z10) {
        this.f3925f = z4;
        this.f3926g = z10;
    }
}
