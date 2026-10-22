package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f1421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f1424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f1425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f1426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable f1429i;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type CENTER = null;
        public static final Type CENTER_X = null;
        public static final Type CENTER_Y = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        static {
            Type r10 = new Type("NONE", 0);
            NONE = r10;
            Type r11 = new Type("LEFT", 1);
            LEFT = r11;
            Type r12 = new Type("TOP", 2);
            TOP = r12;
            Type r13 = new Type("RIGHT", 3);
            RIGHT = r13;
            Type r14 = new Type("BOTTOM", 4);
            BOTTOM = r14;
            Type r15 = new Type("BASELINE", 5);
            BASELINE = r15;
            Type r16 = new Type("CENTER", 6);
            CENTER = r16;
            Type r17 = new Type("CENTER_X", 7);
            CENTER_X = r17;
            Type r18 = new Type("CENTER_Y", 8);
            CENTER_Y = r18;
            $VALUES = new Type[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1430a = null;

        static {
            int[] r10 = new int[Type.values().length];
            f1430a = r10;
            r10[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f1430a[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f1430a[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f1430a[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f1430a[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f1430a[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f1430a[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f1430a[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f1430a[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public ConstraintAnchor(ConstraintWidget r10, Type r11) {
        this.f1421a = null;
        this.f1427g = 0;
        this.f1428h = Integer.MIN_VALUE;
        this.f1424d = r10;
        this.f1425e = r11;
    }

    public boolean a(ConstraintAnchor r10, int r11) {
        return b(r10, r11, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor r10, int r11, int r12, boolean r13) {
        if (r10 != null) goto L6;
        q();
        return true;
    L6:
        if (r13 == false) goto L8;
    L11:
        this.f1426f = r10;
        if (r10.f1421a != null) goto L14;
        r10.f1421a = new HashSet();
    L14:
        HashSet r14 = this.f1426f.f1421a;
        if (r14 == null) goto L17;
        r14.add(this);
    L17:
        this.f1427g = r11;
        this.f1428h = r12;
        return true;
    L8:
        if (p(r10) == true) goto L11;
        return false;
    }

    public void c(int r10, ArrayList r11, l r12) {
        HashSet r13 = this.f1421a;
        if (r13 == null) goto L8;
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        androidx.constraintlayout.core.widgets.analyzer.f.a(((ConstraintAnchor) r14.next()).f1424d, r10, r11, r12);
        goto L6
    L10:
        return;
    }

    public HashSet d() {
        return this.f1421a;
    }

    public int e() {
        if (this.f1423c == true) goto L7;
        return 0;
    L7:
        return this.f1422b;
    }

    public int f() {
        if (this.f1424d.U() != 8) goto L7;
        return 0;
    L7:
        if (this.f1428h == Integer.MIN_VALUE) goto L15;
        ConstraintAnchor r10 = this.f1426f;
        if (r10 == null) goto L15;
        if (r10.f1424d.U() != 8) goto L15;
        return this.f1428h;
    L15:
        return this.f1427g;
    }

    public final ConstraintAnchor g() {
        switch(a.f1430a[this.f1425e.ordinal()]) {
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
        throw new AssertionError(this.f1425e.name());
    L7:
        return this.f1424d.R;
    L9:
        return this.f1424d.T;
    L11:
        return this.f1424d.Q;
    L13:
        return this.f1424d.S;
    }

    public ConstraintWidget h() {
        return this.f1424d;
    }

    public SolverVariable i() {
        return this.f1429i;
    }

    public ConstraintAnchor j() {
        return this.f1426f;
    }

    public Type k() {
        return this.f1425e;
    }

    public boolean l() {
        HashSet r10 = this.f1421a;
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (((ConstraintAnchor) r11.next()).g().o() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean m() {
        HashSet r10 = this.f1421a;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean n() {
        return this.f1423c;
    }

    public boolean o() {
        if (this.f1426f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean p(ConstraintAnchor r10) {
        boolean r11 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        Type r12 = r10.k();
        Type r13 = this.f1425e;
        if (r12 != r13) goto L16;
        if (r13 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r10.h().Y() == true) goto L12;
    L13:
        return false;
    L12:
        if (h().Y() == true) goto L14;
    L16:
        switch(a.f1430a[r13.ordinal()]) {
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
        throw new AssertionError(this.f1425e.name());
    L21:
        if (r12 != Type.LEFT) goto L23;
    L26:
        return false;
    L23:
        if (r12 == Type.RIGHT) goto L26;
        return true;
    L28:
        if (r12 != Type.TOP) goto L30;
    L33:
        boolean r14 = true;
    L35:
        if ((r10.h() instanceof e) == false) goto L65;
        if (r14 == false) goto L38;
    L39:
        r11 = true;
    L41:
        return r11;
    L38:
        if (r12 != Type.CENTER_Y) goto L41;
    L65:
        return r14;
    L30:
        if (r12 == Type.BOTTOM) goto L33;
        r14 = false;
        goto L35
    L43:
        if (r12 != Type.LEFT) goto L45;
    L48:
        boolean r15 = true;
    L50:
        if ((r10.h() instanceof e) == false) goto L66;
        if (r15 == false) goto L53;
    L54:
        r11 = true;
    L56:
        return r11;
    L53:
        if (r12 != Type.CENTER_X) goto L56;
    L66:
        return r15;
    L45:
        if (r12 == Type.RIGHT) goto L48;
        r15 = false;
        goto L50
    L58:
        if (r12 != Type.BASELINE) goto L60;
        return false;
    L60:
        if (r12 != Type.CENTER_X) goto L62;
        return false;
    L62:
        if (r12 != Type.CENTER_Y) goto L64;
        return false;
    L64:
        return true;
    }

    public void q() {
        ConstraintAnchor r10 = this.f1426f;
        if (r10 == null) goto L9;
        HashSet r11 = r10.f1421a;
        if (r11 == null) goto L9;
        r11.remove(this);
        if (this.f1426f.f1421a.size() != 0) goto L9;
        this.f1426f.f1421a = null;
    L9:
        this.f1421a = null;
        this.f1426f = null;
        this.f1427g = 0;
        this.f1428h = Integer.MIN_VALUE;
        this.f1423c = false;
        this.f1422b = 0;
    }

    public void r() {
        this.f1423c = false;
        this.f1422b = 0;
    }

    public void s(androidx.constraintlayout.core.b r10) {
        SolverVariable r11 = this.f1429i;
        if (r11 != null) goto L5;
        this.f1429i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        return;
    L5:
        r11.e();
    }

    public void t(int r10) {
        this.f1422b = r10;
        this.f1423c = true;
    }

    public String toString() {
        return this.f1424d.s() + ":" + this.f1425e.toString();
    }

    public void u(int r10) {
        if (o() == false) goto L6;
        this.f1428h = r10;
        return;
    }
}
