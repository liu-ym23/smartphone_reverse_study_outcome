package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintWidget f12064a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f12065b;

    /* renamed from: c, reason: collision with root package name */
    public ConstraintWidget f12066c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget f12067d;

    /* renamed from: e, reason: collision with root package name */
    public ConstraintWidget f12068e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintWidget f12069f;

    /* renamed from: g, reason: collision with root package name */
    public ConstraintWidget f12070g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f12071h;

    /* renamed from: i, reason: collision with root package name */
    public int f12072i;

    /* renamed from: j, reason: collision with root package name */
    public int f12073j;

    /* renamed from: k, reason: collision with root package name */
    public float f12074k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public int f12075l;

    /* renamed from: m, reason: collision with root package name */
    public int f12076m;

    /* renamed from: n, reason: collision with root package name */
    public int f12077n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12078o;

    /* renamed from: p, reason: collision with root package name */
    public int f12079p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12080q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12081r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12082s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12083t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12084u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12085v;

    public c(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f12064a = constraintWidget;
        this.f12079p = i10;
        this.f12080q = z10;
    }

    public static boolean c(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget.X() == 8 || constraintWidget.f11981b0[i10] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        int i11 = constraintWidget.f12026y[i10];
        return i11 == 0 || i11 == 3;
    }

    public void a() {
        if (!this.f12085v) {
            b();
        }
        this.f12085v = true;
    }

    public final void b() {
        int i10 = this.f12079p * 2;
        ConstraintWidget constraintWidget = this.f12064a;
        this.f12078o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z10 = false;
        while (!z10) {
            this.f12072i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.f11963P0;
            int i11 = this.f12079p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i11] = null;
            constraintWidget.f11961O0[i11] = null;
            if (constraintWidget.X() != 8) {
                this.f12075l++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(this.f12079p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour) {
                    this.f12076m += constraintWidget.G(this.f12079p);
                }
                int iF = this.f12076m + constraintWidget.f11976Y[i10].f();
                this.f12076m = iF;
                int i12 = i10 + 1;
                this.f12076m = iF + constraintWidget.f11976Y[i12].f();
                int iF2 = this.f12077n + constraintWidget.f11976Y[i10].f();
                this.f12077n = iF2;
                this.f12077n = iF2 + constraintWidget.f11976Y[i12].f();
                if (this.f12065b == null) {
                    this.f12065b = constraintWidget;
                }
                this.f12067d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f11981b0;
                int i13 = this.f12079p;
                if (dimensionBehaviourArr[i13] == dimensionBehaviour) {
                    int i14 = constraintWidget.f12026y[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f12073j++;
                        float f10 = constraintWidget.f11959N0[i13];
                        if (f10 > 0.0f) {
                            this.f12074k += f10;
                        }
                        if (c(constraintWidget, i13)) {
                            if (f10 < 0.0f) {
                                this.f12081r = true;
                            } else {
                                this.f12082s = true;
                            }
                            if (this.f12071h == null) {
                                this.f12071h = new ArrayList<>();
                            }
                            this.f12071h.add(constraintWidget);
                        }
                        if (this.f12069f == null) {
                            this.f12069f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f12070g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.f11961O0[this.f12079p] = constraintWidget;
                        }
                        this.f12070g = constraintWidget;
                    }
                    if (this.f12079p == 0) {
                        if (constraintWidget.f12022w != 0 || constraintWidget.f12028z != 0 || constraintWidget.f11932A != 0) {
                            this.f12078o = false;
                        }
                    } else if (constraintWidget.f12024x != 0 || constraintWidget.f11936C != 0 || constraintWidget.f11938D != 0) {
                        this.f12078o = false;
                    }
                    if (constraintWidget.f11989f0 != 0.0f) {
                        this.f12078o = false;
                        this.f12084u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.f11963P0[this.f12079p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.f11976Y[i10 + 1].f11927f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f11925d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.f11976Y[i10].f11927f;
                if (constraintAnchor2 != null && constraintAnchor2.f11925d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z10 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f12065b;
        if (constraintWidget6 != null) {
            this.f12076m -= constraintWidget6.f11976Y[i10].f();
        }
        ConstraintWidget constraintWidget7 = this.f12067d;
        if (constraintWidget7 != null) {
            this.f12076m -= constraintWidget7.f11976Y[i10 + 1].f();
        }
        this.f12066c = constraintWidget;
        if (this.f12079p == 0 && this.f12080q) {
            this.f12068e = constraintWidget;
        } else {
            this.f12068e = this.f12064a;
        }
        this.f12083t = this.f12082s && this.f12081r;
    }
}
