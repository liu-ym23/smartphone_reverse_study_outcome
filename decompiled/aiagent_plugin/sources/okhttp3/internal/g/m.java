package okhttp3.internal.g;

import androidx.core.internal.view.SupportMenu;
import d.h.b.o;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f40086c;

    /* JADX INFO: compiled from: Settings.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f40084a = new a(null);
    }

    public m() {
        this.f40086c = new int[10];
    }

    public final int a() {
        if ((this.f40085b & 2) != 0) goto L7;
        return -1;
    L7:
        return this.f40086c[1];
    }

    public final int b() {
        if ((this.f40085b & 128) != 0) goto L7;
        return SupportMenu.USER_MASK;
    L7:
        return this.f40086c[7];
    }

    public final m a(int r4, int r5) {
        if (r4 < 0) goto L7;
        int[] r0 = this.f40086c;
        if (r4 >= r0.length) goto L7;
        this.f40085b = (1 << r4) | this.f40085b;
        r0[r4] = r5;
    L7:
        return this;
    }

    public final boolean a(int r2) {
        int r1 = this.f40085b;
        if ((r1 & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final int b(int r1) {
        return this.f40086c[r1];
    }

    public final int c() {
        return Integer.bitCount(this.f40085b);
    }

    public final int d() {
        if ((this.f40085b & 16) != 0) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return this.f40086c[4];
    }

    public final int c(int r2) {
        if ((this.f40085b & 32) != 0) goto L5;
        return r2;
    L5:
        return this.f40086c[5];
    }

    public final void a(m r3) {
        o.e(r3, "other");
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L9;
        if (r3.a(r0) == false) goto L8;
        a(r0, r3.b(r0));
    L8:
        r0 = r0 + 1;
        goto L4
    }
}
