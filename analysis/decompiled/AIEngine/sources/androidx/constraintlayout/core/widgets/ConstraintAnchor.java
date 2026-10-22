package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import com.stepos.core.download.ModelFlowMeta;
import h0.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConstraintAnchor {

    /* renamed from: b, reason: collision with root package name */
    public int f1084b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1085c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f1086d;

    /* renamed from: e, reason: collision with root package name */
    public final Type f1087e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f1088f;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable f1090i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f1083a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f1089g = 0;
    public int h = Integer.MIN_VALUE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f1091a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f1092b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f1093c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f1094d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f1095e;
        public static final Type h;

        /* renamed from: j, reason: collision with root package name */
        public static final Type f1096j;

        /* renamed from: k, reason: collision with root package name */
        public static final Type f1097k;

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1098l;

        /* JADX INFO: Fake field, exist only in values array */
        Type EF0;

        static {
            Type type = new Type(ModelFlowMeta.PLAN_NONE, 0);
            Type type2 = new Type("LEFT", 1);
            f1091a = type2;
            Type type3 = new Type("TOP", 2);
            f1092b = type3;
            Type type4 = new Type("RIGHT", 3);
            f1093c = type4;
            Type type5 = new Type("BOTTOM", 4);
            f1094d = type5;
            Type type6 = new Type("BASELINE", 5);
            f1095e = type6;
            Type type7 = new Type("CENTER", 6);
            h = type7;
            Type type8 = new Type("CENTER_X", 7);
            f1096j = type8;
            Type type9 = new Type("CENTER_Y", 8);
            f1097k = type9;
            f1098l = new Type[]{type, type2, type3, type4, type5, type6, type7, type8, type9};
        }

        public Type() {
            throw null;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1098l.clone();
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1086d = constraintWidget;
        this.f1087e = type;
    }

    public final void a(ConstraintAnchor constraintAnchor, int i10) {
        b(constraintAnchor, i10, Integer.MIN_VALUE, false);
    }

    public final boolean b(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z) {
        if (constraintAnchor == null) {
            j();
            return true;
        }
        if (!z && !i(constraintAnchor)) {
            return false;
        }
        this.f1088f = constraintAnchor;
        if (constraintAnchor.f1083a == null) {
            constraintAnchor.f1083a = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.f1088f.f1083a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f1089g = i10;
        this.h = i11;
        return true;
    }

    public final void c(int i10, k kVar, ArrayList arrayList) {
        HashSet<ConstraintAnchor> hashSet = this.f1083a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                h0.h.a(it.next().f1086d, i10, arrayList, kVar);
            }
        }
    }

    public final int d() {
        if (this.f1085c) {
            return this.f1084b;
        }
        return 0;
    }

    public final int e() {
        ConstraintAnchor constraintAnchor;
        if (this.f1086d.f1113i0 == 8) {
            return 0;
        }
        int i10 = this.h;
        return (i10 == Integer.MIN_VALUE || (constraintAnchor = this.f1088f) == null || constraintAnchor.f1086d.f1113i0 != 8) ? this.f1089g : i10;
    }

    public final ConstraintAnchor f() {
        Type type = this.f1087e;
        int iOrdinal = type.ordinal();
        ConstraintWidget constraintWidget = this.f1086d;
        switch (iOrdinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return constraintWidget.L;
            case 2:
                return constraintWidget.M;
            case 3:
                return constraintWidget.J;
            case 4:
                return constraintWidget.K;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final boolean g() {
        HashSet<ConstraintAnchor> hashSet = this.f1083a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f1088f != null;
    }

    public final boolean i(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        ConstraintWidget constraintWidget = constraintAnchor.f1086d;
        Type type = constraintAnchor.f1087e;
        Type type2 = Type.f1095e;
        Type type3 = this.f1087e;
        if (type == type3) {
            return type3 != type2 || (constraintWidget.E && this.f1086d.E);
        }
        int iOrdinal = type3.ordinal();
        Type type4 = Type.f1093c;
        Type type5 = Type.f1091a;
        Type type6 = Type.f1097k;
        Type type7 = Type.f1096j;
        switch (iOrdinal) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z = type == type5 || type == type4;
                return constraintWidget instanceof f ? z || type == type7 : z;
            case 2:
            case 4:
                boolean z3 = type == Type.f1092b || type == Type.f1094d;
                return constraintWidget instanceof f ? z3 || type == type6 : z3;
            case 5:
                return (type == type5 || type == type4) ? false : true;
            case 6:
                return (type == type2 || type == type7 || type == type6) ? false : true;
            default:
                throw new AssertionError(type3.name());
        }
    }

    public final void j() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f1088f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f1083a) != null) {
            hashSet.remove(this);
            if (this.f1088f.f1083a.size() == 0) {
                this.f1088f.f1083a = null;
            }
        }
        this.f1083a = null;
        this.f1088f = null;
        this.f1089g = 0;
        this.h = Integer.MIN_VALUE;
        this.f1085c = false;
        this.f1084b = 0;
    }

    public final void k() {
        SolverVariable solverVariable = this.f1090i;
        if (solverVariable == null) {
            this.f1090i = new SolverVariable(SolverVariable.Type.f1043a);
        } else {
            solverVariable.c();
        }
    }

    public final void l(int i10) {
        this.f1084b = i10;
        this.f1085c = true;
    }

    public final String toString() {
        return this.f1086d.f1115j0 + ":" + this.f1087e.toString();
    }
}
