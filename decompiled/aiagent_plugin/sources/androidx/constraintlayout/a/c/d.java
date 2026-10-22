package androidx.constraintlayout.a.c;

import androidx.constraintlayout.a.c.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f760e;
    androidx.constraintlayout.a.h f;
    private HashSet<d> g;
    private int h;
    private boolean i;

    /* JADX INFO: renamed from: androidx.constraintlayout.a.c.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintAnchor.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f761a = null;

        static {
            int[] r0 = new int[a.values().length];
            f761a = r0;
            r0[a.g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f761a[a.f763b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f761a[a.f765d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f761a[a.f764c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f761a[a.f766e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f761a[a.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f761a[a.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f761a[a.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f761a[a.f762a.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f762a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f763b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f764c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f765d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f766e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        private static final /* synthetic */ a[] j = null;

        static {
            a r0 = new a("NONE", 0);
            f762a = r0;
            a r1 = new a("LEFT", 1);
            f763b = r1;
            a r3 = new a("TOP", 2);
            f764c = r3;
            a r5 = new a("RIGHT", 3);
            f765d = r5;
            a r7 = new a("BOTTOM", 4);
            f766e = r7;
            a r9 = new a("BASELINE", 5);
            f = r9;
            a r11 = new a("CENTER", 6);
            g = r11;
            a r13 = new a("CENTER_X", 7);
            h = r13;
            a r15 = new a("CENTER_Y", 8);
            i = r15;
            j = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(j.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public void a(int r4, ArrayList<o> r5, o r6) {
        HashSet<d> r3 = this.g;
        if (r3 == null) goto L8;
        Iterator<d> r7 = r3.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        androidx.constraintlayout.a.c.a.i.a(((d) ZeusTransformUtils.preCheckCast(r7.next(), d.class, "com.obric.aiagent.plugin")).f756a, r4, r5, r6);
        goto L6
    L10:
        return;
    }

    public HashSet<d> a() {
        return this.g;
    }

    public boolean b() {
        HashSet<d> r1 = this.g;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean c() {
        HashSet<d> r4 = this.g;
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<d> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (((d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin")).m().l() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void a(int r1) {
        this.h = r1;
        this.i = true;
    }

    public int d() {
        if (this.i == true) goto L7;
        return 0;
    L7:
        return this.h;
    }

    public void e() {
        this.i = false;
        this.h = 0;
    }

    public boolean f() {
        return this.i;
    }

    public d(e r2, a r3) {
        this.g = null;
        this.f759d = 0;
        this.f760e = Integer.MIN_VALUE;
        this.f756a = r2;
        this.f757b = r3;
    }

    public androidx.constraintlayout.a.h g() {
        return this.f;
    }

    public void a(androidx.constraintlayout.a.c r3) {
        androidx.constraintlayout.a.h r4 = this.f;
        if (r4 != null) goto L5;
        this.f = new androidx.constraintlayout.a.h(androidx.constraintlayout.a.h.a.f811a, null);
        return;
    L5:
        r4.b();
    }

    public e h() {
        return this.f756a;
    }

    public a getType() {
        return this.f757b;
    }

    public int i() {
        if (this.f756a.B() != 8) goto L7;
        return 0;
    L7:
        if (this.f760e == Integer.MIN_VALUE) goto L15;
        d r0 = this.f758c;
        if (r0 == null) goto L15;
        if (r0.f756a.B() != 8) goto L15;
        return this.f760e;
    L15:
        return this.f759d;
    }

    public d j() {
        return this.f758c;
    }

    public void k() {
        d r0 = this.f758c;
        if (r0 == null) goto L9;
        HashSet<d> r1 = r0.g;
        if (r1 == null) goto L9;
        r1.remove(this);
        if (this.f758c.g.size() != 0) goto L9;
        this.f758c.g = null;
    L9:
        this.g = null;
        this.f758c = null;
        this.f759d = 0;
        this.f760e = Integer.MIN_VALUE;
        this.i = false;
        this.h = 0;
    }

    public boolean a(d r2, int r3, int r4, boolean r5) {
        if (r2 != null) goto L6;
        k();
        return true;
    L6:
        if (r5 == false) goto L8;
    L11:
        this.f758c = r2;
        if (r2.g != null) goto L14;
        r2.g = new HashSet();
    L14:
        HashSet<d> r6 = this.f758c.g;
        if (r6 == null) goto L17;
        r6.add(this);
    L17:
        this.f759d = r3;
        this.f760e = r4;
        return true;
    L8:
        if (a(r2) == true) goto L11;
        return false;
    }

    public boolean a(d r3, int r4) {
        return a(r3, r4, Integer.MIN_VALUE, false);
    }

    public boolean l() {
        if (this.f758c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(d r6) {
        boolean r0 = false;
        if (r6 != null) goto L5;
        return false;
    L5:
        a r1 = r6.getType();
        a r2 = this.f757b;
        if (r1 != r2) goto L16;
        if (r2 == a.f) goto L10;
    L14:
        return true;
    L10:
        if (r6.h().R() == true) goto L12;
    L13:
        return false;
    L12:
        if (h().R() == true) goto L14;
    L16:
        switch(AnonymousClass1.f761a[this.f757b.ordinal()]) {
            case 1: goto L58;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(this.f757b.name());
    L21:
        if (r1 != a.f763b) goto L23;
    L26:
        return false;
    L23:
        if (r1 == a.f765d) goto L26;
        return true;
    L28:
        if (r1 != a.f764c) goto L30;
    L33:
        boolean r5 = true;
    L35:
        if (ZeusTransformUtils.instanceOf(r6.h(), h.class) == false) goto L65;
        if (r5 == false) goto L38;
    L39:
        r0 = true;
    L41:
        return r0;
    L38:
        if (r1 != a.i) goto L41;
    L65:
        return r5;
    L30:
        if (r1 == a.f766e) goto L33;
        r5 = false;
        goto L35
    L43:
        if (r1 != a.f763b) goto L45;
    L48:
        boolean r7 = true;
    L50:
        if (ZeusTransformUtils.instanceOf(r6.h(), h.class) == false) goto L66;
        if (r7 == false) goto L53;
    L54:
        r0 = true;
    L56:
        return r0;
    L53:
        if (r1 != a.h) goto L56;
    L66:
        return r7;
    L45:
        if (r1 == a.f765d) goto L48;
        r7 = false;
        goto L50
    L58:
        if (r1 != a.f) goto L60;
        return false;
    L60:
        if (r1 != a.h) goto L62;
        return false;
    L62:
        if (r1 != a.i) goto L64;
        return false;
    L64:
        return true;
    }

    public void b(int r2) {
        if (l() == false) goto L6;
        this.f760e = r2;
        return;
    }

    public String toString() {
        return this.f756a.C() + ":" + this.f757b.toString();
    }

    public final d m() {
        switch(AnonymousClass1.f761a[this.f757b.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(this.f757b.name());
    L7:
        return this.f756a.B;
    L9:
        return this.f756a.D;
    L11:
        return this.f756a.A;
    L13:
        return this.f756a.C;
    }
}
