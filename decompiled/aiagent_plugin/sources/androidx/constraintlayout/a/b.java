package androidx.constraintlayout.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: ArrayRow.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    h f679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<h> f682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f683e;
    boolean f;

    /* JADX INFO: compiled from: ArrayRow.java */
    public interface a {
        float a(b r1, boolean r2);

        float a(h r1, boolean r2);

        h a(int r1);

        void a();

        void a(float r1);

        void a(h r1, float r2);

        void a(h r1, float r2, boolean r3);

        boolean a(h r1);

        float b(int r1);

        float b(h r1);

        void b();

        int c();
    }

    public b() {
        this.f679a = null;
        this.f680b = 0.0f;
        this.f681c = false;
        this.f682d = new ArrayList();
        this.f = false;
    }

    public b(c r3) {
        this.f679a = null;
        this.f680b = 0.0f;
        this.f681c = false;
        this.f682d = new ArrayList();
        this.f = false;
        this.f683e = new androidx.constraintlayout.a.a(this, r3);
    }

    boolean a() {
        h r0 = this.f679a;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.i != h.a.f811a) goto L7;
    L8:
        return true;
    L7:
        if (this.f680b < 0.0f) goto L9;
        goto L8
    }

    public String toString() {
        return b();
    }

    String b() {
        if (this.f679a != null) goto L5;
        String r0 = "0";
    L6:
        String r1 = r0 + " = ";
        int r3 = 0;
        if (this.f680b == 0.0f) goto L9;
        r1 = r1 + this.f680b;
        boolean r2 = true;
    L10:
        int r5 = this.f683e.c();
    L11:
        if (r3 >= r5) goto L33;
        h r6 = this.f683e.a(r3);
        if (r6 == null) goto L32;
        float r7 = this.f683e.b(r3);
        if (r7 == 0.0f) goto L32;
        String r8 = r6.toString();
        if (r2 == false) goto L21;
        if (r7 <= 0.0f) goto L25;
        r1 = r1 + " + ";
    L28:
        if (r7 != 1.0f) goto L30;
        r1 = r1 + r8;
    L31:
        r2 = true;
        goto L32
    L30:
        r1 = r1 + r7 + " " + r8;
        goto L31
    L25:
        r1 = r1 + " - ";
    L26:
        r7 = r7 * (-1.0f);
        goto L28
    L21:
        if (r7 >= 0.0f) goto L28;
        r1 = r1 + "- ";
    L32:
        r3 = r3 + 1;
        goto L11
    L33:
        if (r2 == false) goto L35;
        return r1;
    L35:
        return r1 + "0.0";
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = "" + this.f679a;
        goto L6
    }

    public void c() {
        this.f679a = null;
        this.f683e.a();
        this.f680b = 0.0f;
        this.f = false;
    }

    boolean a(h r1) {
        return this.f683e.a(r1);
    }

    b a(h r1, int r2) {
        this.f679a = r1;
        float r3 = r2;
        r1.f810e = r3;
        this.f680b = r3;
        this.f = true;
        return this;
    }

    public b b(h r2, int r3) {
        if (r3 >= 0) goto L4;
        this.f680b = r3 * (-1);
        this.f683e.a(r2, 1.0f);
    L5:
        return this;
    L4:
        this.f680b = r3;
        this.f683e.a(r2, -1.0f);
        goto L5
    }

    public b a(h r3, h r4, int r5) {
        boolean r0 = false;
        if (r5 == 0) goto L8;
        if (r5 >= 0) goto L6;
        r5 = r5 * (-1);
        r0 = true;
    L6:
        this.f680b = r5;
    L8:
        if (r0 == true) goto L10;
        this.f683e.a(r3, -1.0f);
        this.f683e.a(r4, 1.0f);
    L11:
        return this;
    L10:
        this.f683e.a(r3, 1.0f);
        this.f683e.a(r4, -1.0f);
        goto L11
    }

    b c(h r2, int r3) {
        this.f683e.a(r2, r3);
        return this;
    }

    public b a(h r3, h r4, h r5, int r6) {
        boolean r0 = false;
        if (r6 == 0) goto L8;
        if (r6 >= 0) goto L6;
        r6 = r6 * (-1);
        r0 = true;
    L6:
        this.f680b = r6;
    L8:
        if (r0 == true) goto L10;
        this.f683e.a(r3, -1.0f);
        this.f683e.a(r4, 1.0f);
        this.f683e.a(r5, 1.0f);
    L11:
        return this;
    L10:
        this.f683e.a(r3, 1.0f);
        this.f683e.a(r4, -1.0f);
        this.f683e.a(r5, -1.0f);
        goto L11
    }

    public b b(h r3, h r4, h r5, int r6) {
        boolean r0 = false;
        if (r6 == 0) goto L8;
        if (r6 >= 0) goto L6;
        r6 = r6 * (-1);
        r0 = true;
    L6:
        this.f680b = r6;
    L8:
        if (r0 == true) goto L10;
        this.f683e.a(r3, -1.0f);
        this.f683e.a(r4, 1.0f);
        this.f683e.a(r5, -1.0f);
    L11:
        return this;
    L10:
        this.f683e.a(r3, 1.0f);
        this.f683e.a(r4, -1.0f);
        this.f683e.a(r5, 1.0f);
        goto L11
    }

    public b a(float r5, float r6, float r7, h r8, h r9, h r10, h r11) {
        this.f680b = 0.0f;
        if (r6 != 0.0f) goto L5;
    L14:
        this.f683e.a(r8, 1.0f);
        this.f683e.a(r9, -1.0f);
        this.f683e.a(r11, 1.0f);
        this.f683e.a(r10, -1.0f);
    L15:
        return this;
    L5:
        if (r5 == r7) goto L14;
        if (r5 != 0.0f) goto L11;
        this.f683e.a(r8, 1.0f);
        this.f683e.a(r9, -1.0f);
        goto L15
    L11:
        if (r7 != 0.0f) goto L13;
        this.f683e.a(r10, 1.0f);
        this.f683e.a(r11, -1.0f);
        goto L15
    L13:
        float r12 = (r5 / r6) / (r7 / r6);
        this.f683e.a(r8, 1.0f);
        this.f683e.a(r9, -1.0f);
        this.f683e.a(r11, r12);
        this.f683e.a(r10, -r12);
        goto L15
    }

    b a(h r6, h r7, int r8, float r9, h r10, h r11, int r12) {
        if (r7 != r10) goto L7;
        this.f683e.a(r6, 1.0f);
        this.f683e.a(r11, 1.0f);
        this.f683e.a(r7, -2.0f);
        return this;
    L7:
        if (r9 != 0.5f) goto L13;
        this.f683e.a(r6, 1.0f);
        this.f683e.a(r7, -1.0f);
        this.f683e.a(r10, -1.0f);
        this.f683e.a(r11, 1.0f);
        if (r8 > 0) goto L11;
        if (r12 > 0) goto L11;
    L22:
        return this;
    L11:
        this.f680b = (-r8) + r12;
        goto L22
    L13:
        if (r9 > 0.0f) goto L16;
        this.f683e.a(r6, -1.0f);
        this.f683e.a(r7, 1.0f);
        this.f680b = r8;
        goto L22
    L16:
        if (r9 < 1.0f) goto L18;
        this.f683e.a(r11, -1.0f);
        this.f683e.a(r10, 1.0f);
        this.f680b = -r12;
        goto L22
    L18:
        float r3 = 1.0f - r9;
        this.f683e.a(r6, r3 * 1.0f);
        this.f683e.a(r7, r3 * (-1.0f));
        this.f683e.a(r10, (-1.0f) * r9);
        this.f683e.a(r11, 1.0f * r9);
        if (r8 > 0) goto L21;
        if (r12 <= 0) goto L22;
    L21:
        this.f680b = ((-r8) * r3) + (r12 * r9);
        goto L22
    }

    public b a(d r4, int r5) {
        this.f683e.a(r4.a(r5, "ep"), 1.0f);
        this.f683e.a(r4.a(r5, "em"), -1.0f);
        return this;
    }

    b a(h r3, h r4, float r5) {
        this.f683e.a(r3, -1.0f);
        this.f683e.a(r4, r5);
        return this;
    }

    public b a(h r3, h r4, h r5, h r6, float r7) {
        this.f683e.a(r3, -1.0f);
        this.f683e.a(r4, 1.0f);
        this.f683e.a(r5, r7);
        this.f683e.a(r6, -r7);
        return this;
    }

    public b b(h r3, h r4, h r5, h r6, float r7) {
        this.f683e.a(r5, 0.5f);
        this.f683e.a(r6, 0.5f);
        this.f683e.a(r3, -0.5f);
        this.f683e.a(r4, -0.5f);
        this.f680b = -r7;
        return this;
    }

    void d() {
        float r0 = this.f680b;
        if (r0 >= 0.0f) goto L6;
        this.f680b = r0 * (-1.0f);
        this.f683e.b();
        return;
    }

    boolean a(d r3) {
        h r4 = b(r3);
        if (r4 != null) goto L5;
        boolean r5 = true;
    L7:
        if (this.f683e.c() != 0) goto L9;
        this.f = true;
    L9:
        return r5;
    L5:
        b(r4);
        r5 = false;
        goto L7
    }

    h b(d r15) {
        int r0 = this.f683e.c();
        h r1 = null;
        int r4 = 0;
        boolean r5 = false;
        boolean r6 = false;
        float r7 = 0.0f;
        float r8 = 0.0f;
        h r2 = null;
    L3:
        if (r4 >= r0) goto L30;
        float r9 = this.f683e.b(r4);
        h r10 = this.f683e.a(r4);
        if (r10.i != h.a.f811a) goto L16;
        if (r1 != null) goto L10;
        boolean r3 = a(r10, r15);
    L8:
        r5 = r3;
        r7 = r9;
        r1 = r10;
    L29:
        r4 = r4 + 1;
        goto L3
    L10:
        if (r7 <= r9) goto L12;
        r3 = a(r10, r15);
        goto L8
    L12:
        if (r5 == true) goto L29;
        if (a(r10, r15) == false) goto L29;
        r7 = r9;
        r1 = r10;
        r5 = true;
        goto L29
    L16:
        if (r1 != null) goto L29;
        if (r9 >= 0.0f) goto L29;
        if (r2 != null) goto L23;
        boolean r11 = a(r10, r15);
    L21:
        r6 = r11;
        r8 = r9;
        r2 = r10;
        goto L29
    L23:
        if (r8 <= r9) goto L25;
        r11 = a(r10, r15);
        goto L21
    L25:
        if (r6 == true) goto L29;
        if (a(r10, r15) == false) goto L29;
        r8 = r9;
        r2 = r10;
        r6 = true;
        goto L29
    L30:
        if (r1 == null) goto L32;
        return r1;
    L32:
        return r2;
    }

    private boolean a(h r1, d r2) {
        if (r1.l <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    void b(h r4) {
        h r0 = this.f679a;
        if (r0 == null) goto L5;
        this.f683e.a(r0, -1.0f);
        this.f679a.f808c = -1;
        this.f679a = null;
    L5:
        float r1 = this.f683e.a(r4, true) * (-1.0f);
        this.f679a = r4;
        if (r1 != 1.0f) goto L8;
        return;
    L8:
        this.f680b /= r1;
        this.f683e.a(r1);
    }

    @Override // androidx.constraintlayout.a.d.a
    public boolean e() {
        if (this.f679a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f680b != 0.0f) goto L9;
        if (this.f683e.c() != 0) goto L9;
        return true;
    }

    public void a(d r4, b r5, boolean r6) {
        this.f680b += r5.f680b * this.f683e.a(r5, r6);
        if (r6 == false) goto L6;
        r5.f679a.b(this);
    L6:
        if (d.f792c == true) goto L8;
        return;
    L8:
        if (this.f679a != null) goto L10;
        return;
    L10:
        if (this.f683e.c() != 0) goto L15;
        this.f = true;
        r4.g = true;
        return;
    }

    public void a(d r4, h r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.f == false) goto L18;
        this.f680b += r5.f810e * this.f683e.b(r5);
        this.f683e.a(r5, r6);
        if (r6 == false) goto L10;
        r5.b(this);
    L10:
        if (d.f792c == true) goto L12;
        return;
    L12:
        if (this.f683e.c() != 0) goto L17;
        this.f = true;
        r4.g = true;
        return;
    L17:
        return;
    }

    public void b(d r4, h r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.m == false) goto L18;
        float r0 = this.f683e.b(r5);
        this.f680b += r5.o * r0;
        this.f683e.a(r5, r6);
        if (r6 == false) goto L9;
        r5.b(this);
    L9:
        this.f683e.a(r4.n.f692d[r5.n], r0, r6);
        if (d.f792c == true) goto L12;
        return;
    L12:
        if (this.f683e.c() != 0) goto L17;
        this.f = true;
        r4.g = true;
        return;
    L17:
        return;
    }

    private h a(boolean[] r10, h r11) {
        int r0 = this.f683e.c();
        h r2 = null;
        int r3 = 0;
        float r4 = 0.0f;
    L3:
        if (r3 >= r0) goto L19;
        float r5 = this.f683e.b(r3);
        if (r5 >= 0.0f) goto L18;
        h r6 = this.f683e.a(r3);
        if (r10 != null) goto L9;
    L10:
        if (r6 == r11) goto L18;
        if (r6.i == h.a.f813c) goto L16;
        if (r6.i != h.a.f814d) goto L18;
    L16:
        if (r5 >= r4) goto L18;
        r4 = r5;
        r2 = r6;
        goto L18
    L9:
        if (r10[r6.f807b] == false) goto L10;
    L18:
        r3 = r3 + 1;
        goto L3
    L19:
        return r2;
    }

    public h c(h r2) {
        return a(null, r2);
    }

    @Override // androidx.constraintlayout.a.d.a
    public h a(d r1, boolean[] r2) {
        return a(r2, null);
    }

    @Override // androidx.constraintlayout.a.d.a
    public void f() {
        this.f683e.a();
        this.f679a = null;
        this.f680b = 0.0f;
    }

    @Override // androidx.constraintlayout.a.d.a
    public void a(d.a r6) {
        d.a r7 = (d.a) ZeusTransformUtils.wrapperContextForParams(r6, d.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L8;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        this.f679a = null;
        this.f683e.a();
        int r0 = 0;
    L6:
        if (r0 >= r8.f683e.c()) goto L10;
        h r1 = r8.f683e.a(r0);
        float r2 = r8.f683e.b(r0);
        this.f683e.a(r1, r2, true);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.constraintlayout.a.d.a
    public void d(h r4) {
        float r1 = 1.0f;
        if (r4.f809d != 1) goto L6;
    L17:
        this.f683e.a(r4, r1);
        return;
    L6:
        if (r4.f809d != 2) goto L9;
        r1 = 1000.0f;
        goto L17
    L9:
        if (r4.f809d != 3) goto L12;
        r1 = 1000000.0f;
        goto L17
    L12:
        if (r4.f809d != 4) goto L15;
        r1 = 1.0E9f;
        goto L17
    L15:
        if (r4.f809d != 5) goto L17;
        r1 = 1.0E12f;
        goto L17
    }

    @Override // androidx.constraintlayout.a.d.a
    public h g() {
        return this.f679a;
    }

    public void c(d r9) {
        if (r9.i.length != 0) goto L5;
        return;
    L5:
        boolean r1 = false;
    L7:
        if (r1 == true) goto L33;
        int r3 = this.f683e.c();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L18;
        h r5 = this.f683e.a(r4);
        if (r5.f808c == (-1)) goto L13;
    L16:
        this.f682d.add(r5);
    L17:
        r4 = r4 + 1;
        goto L9
    L13:
        if (r5.f == true) goto L16;
        if (r5.m == false) goto L17;
    L18:
        int r6 = this.f682d.size();
        if (r6 > 0) goto L20;
        r1 = true;
        goto L7
    L20:
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L30;
        h r8 = (h) ZeusTransformUtils.preCheckCast(this.f682d.get(r7), h.class, "com.obric.aiagent.plugin");
        if (r8.f == false) goto L26;
        a(r9, r8, true);
    L29:
        r7 = r7 + 1;
        goto L21
    L26:
        if (r8.m == false) goto L28;
        b(r9, r8, true);
        goto L29
    L28:
        a(r9, r9.i[r8.f808c], true);
        goto L29
    L30:
        this.f682d.clear();
        goto L7
    L33:
        if (d.f792c == true) goto L35;
        return;
    L35:
        if (this.f679a != null) goto L37;
        return;
    L37:
        if (this.f683e.c() != 0) goto L55;
        this.f = true;
        r9.g = true;
        return;
    }
}
