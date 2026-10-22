package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.core.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FpsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33657a = null;
    private static final f.c<d> o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f33658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f33659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33661e;
    private int f;
    private int g;
    private int h;
    private int i;
    private double j;
    private int k;
    private int l;
    private int m;
    private int n;

    /* JADX INFO: compiled from: FpsBean.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final d a() {
            d r0 = (d) ZeusTransformUtils.preCheckCast(d.b().a(), d.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new d(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
        }
    }

    public d() {
        this(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (o.a(Double.valueOf(this.f33658b), Double.valueOf(r10.f33658b)) == true) goto L12;
        return false;
    L12:
        if (this.f33659c == r10.f33659c) goto L15;
        return false;
    L15:
        if (this.f33660d == r10.f33660d) goto L18;
        return false;
    L18:
        if (this.f33661e == r10.f33661e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (o.a(Double.valueOf(this.j), Double.valueOf(r10.j)) == true) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (this.l == r10.l) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Double.hashCode(this.f33658b) * 31) + Long.hashCode(this.f33659c)) * 31) + Integer.hashCode(this.f33660d)) * 31) + Integer.hashCode(this.f33661e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Double.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n);
    }

    public d(double r4, long r6, int r8, int r9, int r10, int r11, int r12, int r13, double r14, int r16, int r17, int r18, int r19) {
        this.f33658b = r4;
        this.f33659c = r6;
        this.f33660d = r8;
        this.f33661e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
    }

    public /* synthetic */ d(double r17, long r19, int r21, int r22, int r23, int r24, int r25, int r26, double r27, int r29, int r30, int r31, int r32, int r33, h r34) {
        double r2 = 0.0d;
        if ((r33 & 1) == 0) goto L5;
        double r4 = 0.0d;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r1 = 0;
    L15:
        if ((r33 & 8) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r10 = 0;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r11 = 0;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r12 = 0;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r13 = 0;
    L35:
        if ((r33 & 256) != 0) goto L39;
        r2 = r27;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r14 = 0;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        int r15 = 0;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        int r8 = 0;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r0 = 0;
    L54:
        this(r4, r6, r1, r9, r10, r11, r12, r13, r2, r14, r15, r8, r0);
        return;
    L53:
        r0 = r32;
        goto L54
    L49:
        r8 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L43
    L33:
        r13 = r26;
        goto L35
    L29:
        r12 = r25;
        goto L31
    L25:
        r11 = r24;
        goto L27
    L21:
        r10 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r1 = r21;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public static final /* synthetic */ f.c b() {
        return o;
    }

    public final void a(double r1) {
        this.f33658b = r1;
    }

    public final void a(long r1) {
        this.f33659c = r1;
    }

    public final void b(double r1) {
        this.j = r1;
    }

    public final void a(int r1) {
        this.k = r1;
    }

    public final void b(int r1) {
        this.l = r1;
    }

    public final void c(int r1) {
        this.m = r1;
    }

    public final void d(int r1) {
        this.n = r1;
    }

    public final void a() {
        this.f33658b = 0.0d;
        this.j = 0.0d;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.k = 0;
        this.f33659c = 0;
        this.f33660d = 0;
        this.f33661e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        o.a(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("FpsBean(fps=").append(this.f33658b).append(", duration=").append(this.f33659c).append(", startX=").append(this.f33660d).append(", startY=").append(this.f33661e).append(", endX=").append(this.f).append(", endY=").append(this.g).append(", distantX=").append(this.h).append(", distantY=").append(this.i).append(", dropRate=").append(this.j).append(", frameCount=").append(this.k).append(", drop3=").append(this.l).append(", drop7=");
        r0.append(this.m).append(", drop25=").append(this.n).append(')');
        return r0.toString();
    }

    static {
        f33657a = new a(null);
        o = new f.c(5);
    }
}
