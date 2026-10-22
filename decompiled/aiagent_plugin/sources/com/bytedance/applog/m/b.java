package com.bytedance.applog.m;

import com.bytedance.applog.log.m;
import com.bytedance.applog.store.g;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: CongestionController.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final long[][] f5726a = null;
    private static int m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.applog.j.b f5728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5730e;
    private float f;
    private int g;
    private long h;
    private long i;
    private long[][] j;
    private com.bytedance.applog.priority.b k;
    private boolean l;

    static {
        f5726a = new long[][]{new long[]{60000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
        m = -1;
    }

    public b(String r2, com.bytedance.applog.j.b r3, com.bytedance.applog.priority.b r4) {
        this.l = true;
        this.f5728c = r3;
        this.f5727b = r2;
        this.k = r4;
        a();
    }

    public void a() {
        this.f5729d = 0;
        if ((System.currentTimeMillis() - this.f5728c.f().getLong(this.f5727b + "downgrade_time", 0)) >= 10800000) goto L5;
        this.f5729d = this.f5728c.f().getInt(this.f5727b + "downgrade_index", 0);
    L6:
        long[][] r1 = f5726a;
        this.j = (long[][]) Array.newInstance(long.class, new int[]{r1.length, r1[0].length});
        int r2 = 0;
    L7:
        long[][] r3 = f5726a;
        if (r2 >= r3.length) goto L10;
        System.arraycopy(r3[r2], 0, this.j[r2], 0, r3[r2].length);
        r2 = r2 + 1;
        goto L7
    L10:
        int r4 = m;
        if (r4 <= 0) goto L13;
        this.j[0][2] = r4;
    L13:
        com.bytedance.applog.priority.b r5 = this.k;
        if (r5 == null) goto L31;
        int r6 = r5.a();
        if (r6 != 0) goto L19;
        this.j[0][2] = 2147483647L;
    L21:
        long r7 = this.k.c();
        if (r7 <= 0) goto L36;
        int r8 = 1;
    L24:
        long[][] r9 = this.j;
        if (r8 >= r9.length) goto L37;
        if (r8 != 1) goto L29;
        r9[r8][0] = 2 * r7;
    L30:
        r8 = r8 + 1;
        goto L24
    L29:
        r9[r8][0] = r9[r8 - 1][0] * 2;
        goto L30
    L37:
        return;
    L36:
        return;
    L19:
        if ((-1) == r6) goto L21;
        this.j[0][2] = 60;
        goto L21
    L31:
        return;
    L5:
        this.f5728c.f().edit().remove(this.f5727b + "downgrade_time").remove(this.f5727b + "downgrade_index").apply();
        goto L6
    }

    public boolean b() {
        if (g() == true) goto L5;
        return true;
    L5:
        long r2 = System.currentTimeMillis();
        long r4 = r2 - this.h;
        long[][] r0 = this.j;
        int r6 = this.f5729d;
        if (r4 < r0[r6][0]) goto L8;
        this.f5730e = 1;
        this.h = r2;
    L11:
        return true;
    L8:
        int r3 = this.f5730e;
        if (r3 >= r0[r6][2]) goto L12;
        this.f5730e = r3 + 1;
        goto L11
    L12:
        m.a().e("Congestion forbidden send by mTableIndex={}, mLastSendTime={}, mHasSendCount={}", new Object[]{Integer.valueOf(this.f5729d), Long.valueOf(this.h), Integer.valueOf(this.f5730e)});
        return false;
    }

    public boolean a(g r12) {
        if (g() == false) goto L22;
        if (r12 == null) goto L22;
        long r2 = System.currentTimeMillis();
        if (r12.B() <= 0) goto L9;
        int r13 = r12.B();
    L10:
        if (r13 < 200) goto L12;
        float r14 = 1.0f;
    L13:
        long r4 = r2 - this.h;
        long[][] r0 = this.j;
        int r6 = this.f5729d;
        if (r4 < r0[r6][0]) goto L16;
        this.f = r14;
        this.h = r2;
    L19:
        return true;
    L16:
        float r3 = this.f;
        if (r3 >= r0[r6][2]) goto L20;
        this.f = r3 + r14;
        goto L19
    L20:
        m.a().e("Congestion forbidden send by mTableIndex={}, mLastSendTime={}, mHasSendCount={}", new Object[]{Integer.valueOf(this.f5729d), Long.valueOf(this.h), Float.valueOf(this.f)});
        return false;
    L12:
        r14 = r13 / 200.0f;
        goto L13
    L9:
        r13 = 200;
    L22:
        return true;
    }

    public void c() {
        if (g() == true) goto L6;
        return;
    L6:
        if (this.f5729d >= (this.j.length - 1)) goto L8;
        f();
        return;
    L8:
        this.g = 0;
    }

    public void d() {
        if (g() == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        int r2 = this.g;
        long r3 = r2;
        long[][] r5 = this.j;
        int r6 = this.f5729d;
        if (r3 < r5[r6][1]) goto L8;
    L11:
        if (r6 <= 0) goto L15;
        e();
        return;
    L15:
        return;
    L8:
        if ((r0 - this.i) > 1800000) goto L11;
        this.g = r2 + 1;
    }

    private void e() {
        long r0 = System.currentTimeMillis();
        this.f5729d--;
        this.f5730e = 1;
        this.f = 1.0f;
        this.g = 1;
        this.h = r0;
        this.i = r0;
        this.f5728c.f().edit().putLong(this.f5727b + "downgrade_time", r0).putInt(this.f5727b + "downgrade_index", this.f5729d).apply();
    }

    private void f() {
        long r0 = System.currentTimeMillis();
        this.f5729d++;
        this.f5730e = 1;
        this.f = 1.0f;
        this.g = 0;
        this.h = r0;
        this.i = r0;
        this.f5728c.f().edit().putLong(this.f5727b + "downgrade_time", r0).putInt(this.f5727b + "downgrade_index", this.f5729d).apply();
    }

    private boolean g() {
        if (this.l == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f5728c.c().D() == false) goto L7;
        return true;
    }

    public void a(int r3) {
        this.j[0][2] = r3;
    }

    public String toString() {
        return "mPrefix=" + this.f5727b + ", mTableIndex=" + this.f5729d + ", mHasSendCount=" + this.f5730e + ", mHasSendPackCount=" + this.f + ", mContinueSuccSendCount=" + this.g + ", mLastSendTime=" + this.h;
    }
}
