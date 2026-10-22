package g1;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f19805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19806b;

    public c() {
        this.f19805a = new long[4];
        this.f19806b = false;
    }

    public void a(long r10) {
        long[] r11 = this.f19805a;
        if (r11[0] != 0) goto L5;
        r11[0] = SystemClock.uptimeMillis();
    L5:
        long[] r12 = this.f19805a;
        r12[1] = r12[1] + 1;
        if (r10 >= r12[2]) goto L9;
        r12[2] = r10;
    L9:
        if (r10 <= r12[3]) goto L11;
        r12[3] = r10;
    L11:
        this.f19806b = true;
    }

    public boolean b() {
        long[] r10 = this.f19805a;
        if ((r10[0] - r10[2]) <= 100) goto L6;
        return true;
    L6:
        return false;
    }

    public void c() {
        long[] r10 = this.f19805a;
        r10[0] = 0;
        r10[1] = 0;
        r10[2] = Long.MAX_VALUE;
        r10[3] = 0;
        this.f19806b = false;
    }
}
