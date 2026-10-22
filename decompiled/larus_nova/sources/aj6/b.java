package aj6;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f3935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f3936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f3937c;

    public final String toString() {
        return "RTCSpatialAudioHumanOrientation(forward=" + this.f3935a + ", right=" + this.f3936b + ", up=" + this.f3937c + ')';
    }

    public b() {
        this.f3935a = new c(1.0f, 0.0f, 0.0f);
        this.f3936b = new c(0.0f, 1.0f, 0.0f);
        this.f3937c = new c(0.0f, 0.0f, 1.0f);
    }

    public b(c r100, c r101, c r102) {
        if (r100 != null) goto L5;
        r100 = new c(1.0f, 0.0f, 0.0f);
    L5:
        this.f3935a = r100;
        if (r101 != null) goto L8;
        r101 = new c(0.0f, 1.0f, 0.0f);
    L8:
        this.f3936b = r101;
        if (r102 != null) goto L11;
        r102 = new c(0.0f, 0.0f, 1.0f);
    L11:
        this.f3937c = r102;
    }
}
