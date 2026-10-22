package p001j;

/* JADX INFO: loaded from: classes.dex */
public class h extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f20808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f20809e;

    public h(String r10) {
        this.f20782a = r10;
        int r11 = r10.indexOf(40);
        int r12 = r10.indexOf(44, r11);
        this.f20808d = Double.parseDouble(r10.substring(r11 + 1, r12).trim());
        int r13 = r12 + 1;
        this.f20809e = Double.parseDouble(r10.substring(r13, r10.indexOf(44, r13)).trim());
    }

    @Override // p001j.c
    public double a(double r10) {
        return e(r10);
    }

    @Override // p001j.c
    public double b(double r10) {
        return d(r10);
    }

    public final double d(double r13) {
        double r10 = this.f20809e;
        if (r13 >= r10) goto L6;
        double r11 = this.f20808d;
        return ((r11 * r10) * r10) / ((((r10 - r13) * r11) + r13) * ((r11 * (r10 - r13)) + r13));
    L6:
        double r12 = this.f20808d;
        return (((r10 - 1.0d) * r12) * (r10 - 1.0d)) / (((((-r12) * (r10 - r13)) - r13) + 1.0d) * ((((-r12) * (r10 - r13)) - r13) + 1.0d));
    }

    public final double e(double r10) {
        double r11 = this.f20809e;
        if (r10 >= r11) goto L7;
        return (r11 * r10) / (r10 + (this.f20808d * (r11 - r10)));
    L7:
        return ((1.0d - r11) * (r10 - 1.0d)) / ((1.0d - r10) - (this.f20808d * (r11 - r10)));
    }
}
