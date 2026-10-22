package d.k;

import d.h.b.h;
import java.io.Serializable;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f38514b = null;

    /* JADX INFO: compiled from: Random.kt */
    public static final class a extends c implements Serializable {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        @Override // d.k.c
        public int a(int r1) {
            return c.d().a(r1);
        }

        @Override // d.k.c
        public int b() {
            return c.d().b();
        }

        @Override // d.k.c
        public long c() {
            return c.d().c();
        }

        @Override // d.k.c
        public long a(long r1, long r3) {
            return c.d().a(r1, r3);
        }
    }

    public abstract int a(int r1);

    public c() {
    }

    public static final /* synthetic */ c d() {
        return f38514b;
    }

    public int b() {
        return a(32);
    }

    public long c() {
        return (((long) b()) << 32) + ((long) b());
    }

    public long a(long r11, long r13) {
        d.a(r11, r13);
        long r0 = r13 - r11;
        if (r0 > 0) goto L5;
    L18:
        long r1 = c();
        boolean r3 = false;
        if (r11 > r1) goto L23;
        if (r1 >= r13) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L18;
        return r1;
    L5:
        if (((-r0) & r0) != r0) goto L13;
        int r14 = (int) r0;
        int r2 = (int) (r0 >>> 32);
        if (r14 == 0) goto L10;
        int r10 = a(d.a(r14));
    L9:
        long r15 = ((long) r10) & 4294967295L;
    L17:
        return r11 + r15;
    L10:
        if (r2 != 1) goto L12;
        r10 = b();
        goto L9
    L12:
        r15 = (((long) a(d.a(r2))) << 32) + (((long) b()) & 4294967295L);
    L13:
        long r16 = c() >>> 1;
        long r6 = r16 % r0;
        if (((r16 - r6) + (r0 - 1)) < 0) goto L13;
        r15 = r6;
        goto L17
    }

    static {
        f38513a = new a(null);
        f38514b = d.e.b.f38433a.a();
    }
}
