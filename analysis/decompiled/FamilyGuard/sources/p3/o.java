package p3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: A, reason: collision with root package name */
    private ListAdapter f19520A;

    /* renamed from: B, reason: collision with root package name */
    private Cursor f19521B;

    /* renamed from: C, reason: collision with root package name */
    private String f19522C;

    /* renamed from: D, reason: collision with root package name */
    private String f19523D;

    /* renamed from: E, reason: collision with root package name */
    private DialogInterface.OnClickListener f19524E;

    /* renamed from: F, reason: collision with root package name */
    private DialogInterface.OnMultiChoiceClickListener f19525F;

    /* renamed from: G, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f19526G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f19527H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f19528I;

    /* renamed from: J, reason: collision with root package name */
    private int f19529J;

    /* renamed from: K, reason: collision with root package name */
    private boolean[] f19530K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f19531L;

    /* renamed from: M, reason: collision with root package name */
    private ColorStateList f19532M;

    /* renamed from: N, reason: collision with root package name */
    private ColorStateList[] f19533N;

    /* renamed from: O, reason: collision with root package name */
    private ArrayList<Pair<String, String>> f19534O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f19535P;

    /* renamed from: Q, reason: collision with root package name */
    private View f19536Q;

    /* renamed from: R, reason: collision with root package name */
    private int f19537R;

    /* renamed from: S, reason: collision with root package name */
    private int f19538S;

    /* renamed from: T, reason: collision with root package name */
    private int f19539T;

    /* renamed from: U, reason: collision with root package name */
    private int f19540U;

    /* renamed from: V, reason: collision with root package name */
    private int f19541V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f19542W;

    /* renamed from: X, reason: collision with root package name */
    private boolean f19543X;

    /* renamed from: Y, reason: collision with root package name */
    private int f19544Y;

    /* renamed from: Z, reason: collision with root package name */
    private int f19545Z;

    /* renamed from: a, reason: collision with root package name */
    private final Context f19546a;

    /* renamed from: a0, reason: collision with root package name */
    private int f19547a0;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutInflater f19548b;

    /* renamed from: b0, reason: collision with root package name */
    private int f19549b0;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f19550c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f19551c0;

    /* renamed from: d, reason: collision with root package name */
    private int f19552d;

    /* renamed from: d0, reason: collision with root package name */
    private int f19553d0;

    /* renamed from: e, reason: collision with root package name */
    private int f19554e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f19555e0;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f19556f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f19557f0;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f19558g;

    /* renamed from: g0, reason: collision with root package name */
    private K2.o f19559g0;

    /* renamed from: h, reason: collision with root package name */
    private int f19560h;

    /* renamed from: i, reason: collision with root package name */
    private View f19561i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f19562j;

    /* renamed from: k, reason: collision with root package name */
    private int f19563k;

    /* renamed from: l, reason: collision with root package name */
    private MovementMethod f19564l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f19565m;

    /* renamed from: n, reason: collision with root package name */
    private DialogInterface.OnClickListener f19566n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f19567o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f19568p;

    /* renamed from: q, reason: collision with root package name */
    private DialogInterface.OnClickListener f19569q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f19570r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f19571s;

    /* renamed from: t, reason: collision with root package name */
    private DialogInterface.OnClickListener f19572t;

    /* renamed from: u, reason: collision with root package name */
    private Drawable f19573u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f19574v;

    /* renamed from: w, reason: collision with root package name */
    private DialogInterface.OnCancelListener f19575w;

    /* renamed from: x, reason: collision with root package name */
    private DialogInterface.OnDismissListener f19576x;

    /* renamed from: y, reason: collision with root package name */
    private DialogInterface.OnKeyListener f19577y;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence[] f19578z;

    private static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final a f19579a = new a();

        private a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i5) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    public o(Context context) {
        j4.k.g(context, "context");
        this.f19546a = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        j4.k.f(layoutInflaterFrom, "from(...)");
        this.f19548b = layoutInflaterFrom;
        this.f19560h = 2;
        this.f19563k = 2;
        this.f19574v = true;
        this.f19529J = -1;
        this.f19543X = true;
        this.f19549b0 = 1;
        this.f19551c0 = true;
        this.f19555e0 = true;
    }

    private final boolean t() {
        return (this.f19565m == null && this.f19567o == null && this.f19568p == null && this.f19570r == null && this.f19571s == null && this.f19573u == null) ? false : true;
    }

    public final void A(DialogInterface.OnClickListener onClickListener) {
        this.f19572t = onClickListener;
    }

    public final void B(CharSequence charSequence) {
        this.f19571s = charSequence;
    }

    public final void C(CharSequence charSequence) {
        this.f19558g = charSequence;
    }

    public final void D(View view) {
        this.f19536Q = view;
    }

    public final void E(int i5) {
        this.f19537R = i5;
    }

    public final void F(boolean z5) {
        this.f19542W = z5;
    }

    public final void a(g gVar) throws Resources.NotFoundException {
        g gVar2;
        j4.k.g(gVar, "controller");
        gVar.g0(this.f19560h);
        gVar.X(this.f19563k);
        View view = this.f19561i;
        if (view != null) {
            gVar.N(view);
        } else {
            CharSequence charSequence = this.f19558g;
            if (charSequence != null) {
                gVar.f0(charSequence);
            }
            Drawable drawable = this.f19550c;
            if (drawable != null) {
                gVar.T(drawable);
            }
            int i5 = this.f19552d;
            if (i5 != 0) {
                gVar.S(i5);
            }
            int i6 = this.f19554e;
            if (i6 != 0) {
                gVar.S(gVar.x(i6));
            }
        }
        gVar.U(this.f19556f);
        CharSequence charSequence2 = this.f19562j;
        if (charSequence2 != null) {
            gVar.W(charSequence2);
        }
        MovementMethod movementMethod = this.f19564l;
        if (movementMethod != null) {
            gVar.Y(movementMethod);
        }
        CharSequence charSequence3 = this.f19565m;
        if (charSequence3 == null && this.f19567o == null) {
            gVar2 = gVar;
        } else {
            gVar.L(-1, charSequence3, this.f19566n, null, this.f19567o);
            gVar2 = gVar;
        }
        CharSequence charSequence4 = this.f19568p;
        if (charSequence4 != null || this.f19570r != null) {
            gVar2.L(-2, charSequence4, this.f19569q, null, this.f19570r);
        }
        CharSequence charSequence5 = this.f19571s;
        if (charSequence5 != null || this.f19573u != null) {
            gVar2.L(-3, charSequence5, this.f19572t, null, this.f19573u);
        }
        if (this.f19578z != null || this.f19521B != null || this.f19520A != null) {
            gVar2.q(this);
            if (!t()) {
                gVar2.L(-2, this.f19546a.getText(l3.k.f18469a), a.f19579a, null, null);
            }
        }
        if (this.f19535P) {
            gVar2.Z(true);
            gVar2.t(this);
            ArrayList<Pair<String, String>> arrayList = this.f19534O;
            gVar2.a0(arrayList != null ? arrayList.size() : 0);
            gVar2.L(-2, this.f19546a.getText(l3.k.f18469a), a.f19579a, null, this.f19570r);
        }
        View view2 = this.f19536Q;
        if (view2 == null) {
            int i7 = this.f19537R;
            if (i7 != 0) {
                gVar2.j0(i7);
            }
        } else if (this.f19542W) {
            gVar2.l0(view2, this.f19538S, this.f19539T, this.f19540U, this.f19541V);
        } else {
            gVar2.k0(view2);
        }
        gVar2.Q(this.f19544Y);
        gVar2.M(this.f19553d0);
        gVar2.P(this.f19555e0);
        if (this.f19557f0) {
            gVar2.O(this.f19559g0);
        }
        gVar2.V(this.f19545Z);
        gVar2.R(this.f19547a0, this.f19549b0);
        gVar2.J(this.f19551c0);
    }

    public final ListAdapter b() {
        return this.f19520A;
    }

    public final boolean c() {
        return this.f19574v;
    }

    public final int d() {
        return this.f19529J;
    }

    public final boolean[] e() {
        return this.f19530K;
    }

    public final Context f() {
        return this.f19546a;
    }

    public final Cursor g() {
        return this.f19521B;
    }

    public final LayoutInflater h() {
        return this.f19548b;
    }

    public final ArrayList<Pair<String, String>> i() {
        return this.f19534O;
    }

    public final CharSequence[] j() {
        return this.f19578z;
    }

    public final String k() {
        return this.f19522C;
    }

    public final ColorStateList l() {
        return this.f19532M;
    }

    public final ColorStateList[] m() {
        return this.f19533N;
    }

    public final DialogInterface.OnCancelListener n() {
        return this.f19575w;
    }

    public final DialogInterface.OnMultiChoiceClickListener o() {
        return this.f19525F;
    }

    public final DialogInterface.OnClickListener p() {
        return this.f19524E;
    }

    public final DialogInterface.OnDismissListener q() {
        return this.f19576x;
    }

    public final AdapterView.OnItemSelectedListener r() {
        return this.f19526G;
    }

    public final DialogInterface.OnKeyListener s() {
        return this.f19577y;
    }

    public final String u() {
        return this.f19523D;
    }

    public final boolean v() {
        return this.f19531L;
    }

    public final boolean w() {
        return this.f19527H;
    }

    public final boolean x() {
        return this.f19528I;
    }

    public final void y(DialogInterface.OnClickListener onClickListener) {
        this.f19569q = onClickListener;
    }

    public final void z(CharSequence charSequence) {
        this.f19568p = charSequence;
    }
}
