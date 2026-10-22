package androidx.constraintlayout.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: PriorityGoalRow.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends b {
    a g;
    c h;
    private int i;
    private h[] j;
    private h[] k;
    private int l;

    /* JADX INFO: compiled from: PriorityGoalRow.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h f803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f805c;

        public a(g r1, g r2) {
            this.f805c = r1;
            this.f804b = r2;
        }

        public void a(h r1) {
            this.f803a = r1;
        }

        public boolean a(h r10, float r11) {
            boolean r4 = true;
            int r5 = 0;
            if (this.f803a.f806a == false) goto L14;
            int r0 = 0;
        L5:
            if (r0 >= 9) goto L11;
            float[] r6 = this.f803a.h;
            r6[r0] = r6[r0] + (r10.h[r0] * r11);
            if (Math.abs(this.f803a.h[r0]) >= 1.0E-4f) goto L9;
            this.f803a.h[r0] = 0.0f;
        L10:
            r0 = r0 + 1;
            goto L5
        L9:
            r4 = false;
            goto L10
        L11:
            if (r4 == false) goto L13;
            g.a(this.f805c, this.f803a);
        L13:
            return false;
        L14:
            if (r5 >= 9) goto L23;
            float r1 = r10.h[r5];
            if (r1 == 0.0f) goto L21;
            float r2 = r1 * r11;
            if (Math.abs(r2) >= 1.0E-4f) goto L20;
            r2 = 0.0f;
        L20:
            this.f803a.h[r5] = r2;
        L22:
            r5 = r5 + 1;
            goto L14
        L21:
            this.f803a.h[r5] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public final boolean a() {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L13;
            float r2 = this.f803a.h[r0];
            if (r2 > 0.0f) goto L7;
            if (r2 < 0.0f) goto L10;
            r0 = r0 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public final boolean b(h r6) {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L12;
            float r2 = r6.h[r0];
            float r3 = this.f803a.h[r0];
            if (r3 != r2) goto L9;
            r0 = r0 - 1;
            goto L4
        L9:
            if (r3 >= r2) goto L12;
            return true;
        L12:
            return false;
        }

        public void b() {
            Arrays.fill(this.f803a.h, 0.0f);
        }

        public String toString() {
            String r1 = "[ ";
            if (this.f803a == null) goto L9;
            int r0 = 0;
        L6:
            if (r0 >= 9) goto L9;
            r1 = r1 + this.f803a.h[r0] + " ";
            r0 = r0 + 1;
        L9:
            return r1 + "] " + this.f803a;
        }
    }

    static /* synthetic */ void a(g r0, h r1) {
        r0.f(r1);
    }

    @Override // androidx.constraintlayout.a.b, androidx.constraintlayout.a.d.a
    public void f() {
        this.l = 0;
        this.f680b = 0.0f;
    }

    public g(c r3) {
        super(r3);
        this.i = 128;
        this.j = new h[128];
        this.k = new h[128];
        this.l = 0;
        this.g = new a(this, this);
        this.h = r3;
    }

    @Override // androidx.constraintlayout.a.b, androidx.constraintlayout.a.d.a
    public boolean e() {
        if (this.l != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.a.b, androidx.constraintlayout.a.d.a
    public h a(d r5, boolean[] r6) {
        int r0 = 0;
        int r1 = -1;
    L4:
        if (r0 >= this.l) goto L17;
        h r2 = this.j[r0];
        if (r6[r2.f807b] == true) goto L16;
        this.g.a(r2);
        if (r1 != (-1)) goto L14;
        if (this.g.a() == false) goto L16;
    L15:
        r1 = r0;
        goto L16
    L14:
        if (this.g.b(this.j[r1]) == true) goto L15;
    L16:
        r0 = r0 + 1;
        goto L4
    L17:
        if (r1 != (-1)) goto L21;
        return null;
    L21:
        return this.j[r1];
    }

    @Override // androidx.constraintlayout.a.b, androidx.constraintlayout.a.d.a
    public void d(h r4) {
        this.g.a(r4);
        this.g.b();
        r4.h[r4.f809d] = 1.0f;
        e(r4);
    }

    private final void e(h r6) {
        int r0 = this.l + 1;
        h[] r2 = this.j;
        if (r0 <= r2.length) goto L5;
        h[] r1 = (h[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), h[].class, "com.obric.aiagent.plugin");
        this.j = r1;
        this.k = (h[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), h[].class, "com.obric.aiagent.plugin");
    L5:
        h[] r3 = this.j;
        int r4 = this.l;
        r3[r4] = r6;
        int r5 = r4 + 1;
        this.l = r5;
        if (r5 > 1) goto L8;
    L17:
        r6.f806a = true;
        r6.a(this);
        return;
    L8:
        if (r3[r5 - 1].f807b <= r6.f807b) goto L17;
        int r7 = 0;
        int r8 = 0;
    L10:
        int r9 = this.l;
        if (r8 >= r9) goto L13;
        this.k[r8] = this.j[r8];
        r8 = r8 + 1;
        goto L10
    L13:
        Arrays.sort(this.k, 0, r9, new AnonymousClass1(this));
    L15:
        if (r7 >= this.l) goto L17;
        this.j[r7] = this.k[r7];
        r7 = r7 + 1;
        goto L15
    }

    private final void f(h r6) {
        int r1 = 0;
    L4:
        if (r1 >= this.l) goto L13;
        if (this.j[r1] == r6) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = this.l;
        if (r1 >= (r2 - 1)) goto L10;
        h[] r3 = this.j;
        int r4 = r1 + 1;
        r3[r1] = r3[r4];
        r1 = r4;
        goto L7
    L10:
        this.l = r2 - 1;
        r6.f806a = false;
        return;
    }

    @Override // androidx.constraintlayout.a.b
    public void a(d r6, b r7, boolean r8) {
        h r9 = r7.f679a;
        if (r9 != null) goto L5;
        return;
    L5:
        b.a r10 = r7.f683e;
        int r0 = r10.c();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        h r2 = r10.a(r1);
        float r3 = r10.b(r1);
        this.g.a(r2);
        if (this.g.a(r9, r3) == false) goto L10;
        e(r2);
    L10:
        this.f680b += r7.f680b * r3;
        r1 = r1 + 1;
        goto L6
    L11:
        f(r9);
    }

    @Override // androidx.constraintlayout.a.b
    public String toString() {
        String r0 = " goal -> (" + this.f680b + ") : ";
        int r1 = 0;
    L4:
        if (r1 >= this.l) goto L6;
        this.g.a(this.j[r1]);
        r0 = r0 + this.g + " ";
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
