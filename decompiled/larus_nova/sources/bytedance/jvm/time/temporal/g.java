package bytedance.jvm.time.temporal;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21713a;

    public /* synthetic */ g(int r100) {
        this.f21713a = r100;
    }

    @Override // bytedance.jvm.time.temporal.e
    public final b adjustInto(b r100) {
        int r101 = this.f21713a;
        int r102 = r100.get(ChronoField.DAY_OF_WEEK);
        if (r102 == r101) goto L11;
        int r103 = r102 - r101;
        if (r103 < 0) goto L8;
        int r104 = 7 - r103;
    L10:
        return r100.plus(r104, ChronoUnit.DAYS);
    L8:
        r104 = -r103;
        goto L10
    L11:
        return r100;
    }
}
