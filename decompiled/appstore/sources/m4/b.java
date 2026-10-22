package m4;

import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f22080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f22082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22083d;

    public b(double r10) {
        this.f22082c = -1.0d;
        this.f22080a = r10;
        if (r10 != 0.0d) goto L5;
        int r11 = Channel.UNLIMITED;
    L6:
        this.f22081b = r11;
        return;
    L5:
        r11 = (int) Math.ceil(1.0d / r10);
        goto L6
    }

    public void a(double r10) {
        double r11 = 1.0d - this.f22080a;
        int r12 = this.f22083d;
        if (r12 <= this.f22081b) goto L5;
        this.f22082c = Math.exp((r11 * Math.log(this.f22082c)) + (this.f22080a * Math.log(r10)));
    L8:
        this.f22083d++;
        return;
    L5:
        if (r12 <= 0) goto L7;
        double r13 = (r11 * ((double) r12)) / (((double) r12) + 1.0d);
        this.f22082c = Math.exp((r13 * Math.log(this.f22082c)) + ((1.0d - r13) * Math.log(r10)));
        goto L8
    L7:
        this.f22082c = r10;
        goto L8
    }

    public double b() {
        return this.f22082c;
    }
}
