package y1;

/* JADX INFO: loaded from: classes.dex */
public class g implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f26033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f26034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f26036e;

    public g(String r10, long r11, String r12) {
        this.f26032a = r10;
        this.f26034c = r11;
        this.f26036e = System.currentTimeMillis();
        this.f26035d = 1;
        this.f26033b = r12;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r10) {
        long r11 = this.f26034c;
        long r12 = ((g) r10).f26034c;
        if (r11 != r12) goto L7;
        return 0;
    L7:
        if (r11 <= r12) goto L10;
        return 1;
    L10:
        return -1;
    }
}
