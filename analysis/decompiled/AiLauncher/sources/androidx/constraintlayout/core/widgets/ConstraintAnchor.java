package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import l0.C4855a;
import p0.j;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b, reason: collision with root package name */
    public int f11923b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11924c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f11925d;

    /* renamed from: e, reason: collision with root package name */
    public final Type f11926e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f11927f;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable f11930i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f11922a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f11928g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f11929h = Integer.MIN_VALUE;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f11925d = constraintWidget;
        this.f11926e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i10) {
        return b(constraintAnchor, i10, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z10) {
        if (constraintAnchor == null) {
            q();
            return true;
        }
        if (!z10 && !p(constraintAnchor)) {
            return false;
        }
        this.f11927f = constraintAnchor;
        if (constraintAnchor.f11922a == null) {
            constraintAnchor.f11922a = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.f11927f.f11922a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f11928g = i10;
        this.f11929h = i11;
        return true;
    }

    public void c(int i10, ArrayList<j> arrayList, j jVar) {
        HashSet<ConstraintAnchor> hashSet = this.f11922a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                p0.g.a(it.next().f11925d, i10, arrayList, jVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> d() {
        return this.f11922a;
    }

    public int e() {
        if (this.f11924c) {
            return this.f11923b;
        }
        return 0;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f11925d.X() == 8) {
            return 0;
        }
        return (this.f11929h == Integer.MIN_VALUE || (constraintAnchor = this.f11927f) == null || constraintAnchor.f11925d.X() != 8) ? this.f11928g : this.f11929h;
    }

    public final ConstraintAnchor g() {
        switch (this.f11926e) {
            case NONE:
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
                return null;
            case LEFT:
                return this.f11925d.f11968S;
            case TOP:
                return this.f11925d.f11970T;
            case RIGHT:
                return this.f11925d.f11964Q;
            case BOTTOM:
                return this.f11925d.f11966R;
            default:
                throw new AssertionError(this.f11926e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f11925d;
    }

    public SolverVariable i() {
        return this.f11930i;
    }

    public ConstraintAnchor j() {
        return this.f11927f;
    }

    public Type k() {
        return this.f11926e;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f11922a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f11922a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.f11924c;
    }

    public boolean o() {
        return this.f11927f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type typeK = constraintAnchor.k();
        Type type = this.f11926e;
        if (typeK == type) {
            return type != Type.BASELINE || (constraintAnchor.h().b0() && h().b0());
        }
        switch (type) {
            case NONE:
            case CENTER_X:
            case CENTER_Y:
                return false;
            case LEFT:
            case RIGHT:
                boolean z10 = typeK == Type.LEFT || typeK == Type.RIGHT;
                return constraintAnchor.h() instanceof f ? z10 || typeK == Type.CENTER_X : z10;
            case TOP:
            case BOTTOM:
                boolean z11 = typeK == Type.TOP || typeK == Type.BOTTOM;
                return constraintAnchor.h() instanceof f ? z11 || typeK == Type.CENTER_Y : z11;
            case BASELINE:
                return (typeK == Type.LEFT || typeK == Type.RIGHT) ? false : true;
            case CENTER:
                return (typeK == Type.BASELINE || typeK == Type.CENTER_X || typeK == Type.CENTER_Y) ? false : true;
            default:
                throw new AssertionError(this.f11926e.name());
        }
    }

    public void q() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f11927f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f11922a) != null) {
            hashSet.remove(this);
            if (this.f11927f.f11922a.size() == 0) {
                this.f11927f.f11922a = null;
            }
        }
        this.f11922a = null;
        this.f11927f = null;
        this.f11928g = 0;
        this.f11929h = Integer.MIN_VALUE;
        this.f11924c = false;
        this.f11923b = 0;
    }

    public void r() {
        this.f11924c = false;
        this.f11923b = 0;
    }

    public void s(C4855a c4855a) {
        SolverVariable solverVariable = this.f11930i;
        if (solverVariable == null) {
            this.f11930i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.i();
        }
    }

    public void t(int i10) {
        this.f11923b = i10;
        this.f11924c = true;
    }

    public String toString() {
        return this.f11925d.v() + ServerSentEventKt.COLON + this.f11926e.toString();
    }

    public void u(int i10) {
        if (o()) {
            this.f11929h = i10;
        }
    }
}
