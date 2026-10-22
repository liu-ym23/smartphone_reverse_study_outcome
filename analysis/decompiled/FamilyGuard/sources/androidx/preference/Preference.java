package androidx.preference;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.H;
import androidx.preference.j;
import h.C0744a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: A, reason: collision with root package name */
    private boolean f10965A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f10966B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f10967C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f10968D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f10969E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f10970F;

    /* renamed from: G, reason: collision with root package name */
    private int f10971G;

    /* renamed from: H, reason: collision with root package name */
    private int f10972H;

    /* renamed from: I, reason: collision with root package name */
    private c f10973I;

    /* renamed from: J, reason: collision with root package name */
    private List<Preference> f10974J;

    /* renamed from: K, reason: collision with root package name */
    private PreferenceGroup f10975K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f10976L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f10977M;

    /* renamed from: Q, reason: collision with root package name */
    private f f10978Q;

    /* renamed from: R, reason: collision with root package name */
    private g f10979R;

    /* renamed from: S, reason: collision with root package name */
    private final View.OnClickListener f10980S;

    /* renamed from: a, reason: collision with root package name */
    private final Context f10981a;

    /* renamed from: b, reason: collision with root package name */
    private j f10982b;

    /* renamed from: c, reason: collision with root package name */
    private long f10983c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10984d;

    /* renamed from: e, reason: collision with root package name */
    private d f10985e;

    /* renamed from: f, reason: collision with root package name */
    private e f10986f;

    /* renamed from: g, reason: collision with root package name */
    private int f10987g;

    /* renamed from: h, reason: collision with root package name */
    private int f10988h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f10989i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f10990j;

    /* renamed from: k, reason: collision with root package name */
    private int f10991k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f10992l;

    /* renamed from: m, reason: collision with root package name */
    private String f10993m;

    /* renamed from: n, reason: collision with root package name */
    private Intent f10994n;

    /* renamed from: o, reason: collision with root package name */
    private String f10995o;

    /* renamed from: p, reason: collision with root package name */
    private Bundle f10996p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f10997q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10998r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f10999s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11000t;

    /* renamed from: u, reason: collision with root package name */
    private String f11001u;

    /* renamed from: v, reason: collision with root package name */
    private Object f11002v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11003w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f11004x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f11005y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f11006z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.j0(view);
        }
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface c {
        void b(Preference preference);

        void e(Preference preference);

        void g(Preference preference);
    }

    public interface d {
        boolean c(Preference preference, Object obj);
    }

    public interface e {
        boolean f(Preference preference);
    }

    private static class f implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final Preference f11008a;

        f(Preference preference) {
            this.f11008a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence charSequenceG = this.f11008a.G();
            if (!this.f11008a.L() || TextUtils.isEmpty(charSequenceG)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceG);
            contextMenu.add(0, 0, 0, q.f11153a).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f11008a.l().getSystemService("clipboard");
            CharSequence charSequenceG = this.f11008a.G();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceG));
            Toast.makeText(this.f11008a.l(), this.f11008a.l().getString(q.f11156d, charSequenceG), 0).show();
            return true;
        }
    }

    public interface g<T extends Preference> {
        CharSequence a(T t5);
    }

    public Preference(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f10987g = Integer.MAX_VALUE;
        this.f10988h = 0;
        this.f10997q = true;
        this.f10998r = true;
        this.f11000t = true;
        this.f11003w = true;
        this.f11004x = true;
        this.f11005y = true;
        this.f11006z = true;
        this.f10965A = true;
        this.f10967C = true;
        this.f10970F = true;
        int i7 = p.f11150b;
        this.f10971G = i7;
        this.f10980S = new a();
        this.f10981a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11177J, i5, i6);
        this.f10991k = androidx.core.content.res.k.l(typedArrayObtainStyledAttributes, s.f11233h0, s.f11179K, 0);
        this.f10993m = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11242k0, s.f11191Q);
        this.f10989i = androidx.core.content.res.k.n(typedArrayObtainStyledAttributes, s.f11258s0, s.f11187O);
        this.f10990j = androidx.core.content.res.k.n(typedArrayObtainStyledAttributes, s.f11256r0, s.f11193R);
        this.f10987g = androidx.core.content.res.k.d(typedArrayObtainStyledAttributes, s.f11246m0, s.f11195S, Integer.MAX_VALUE);
        this.f10995o = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11230g0, s.f11205X);
        this.f10971G = androidx.core.content.res.k.l(typedArrayObtainStyledAttributes, s.f11244l0, s.f11185N, i7);
        this.f10972H = androidx.core.content.res.k.l(typedArrayObtainStyledAttributes, s.f11260t0, s.f11197T, 0);
        this.f10997q = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11227f0, s.f11183M, true);
        this.f10998r = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11250o0, s.f11189P, true);
        this.f11000t = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11248n0, s.f11181L, true);
        this.f11001u = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11221d0, s.f11199U);
        int i8 = s.f11212a0;
        this.f11006z = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i8, i8, this.f10998r);
        int i9 = s.f11215b0;
        this.f10965A = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i9, i9, this.f10998r);
        int i10 = s.f11218c0;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.f11002v = a0(typedArrayObtainStyledAttributes, i10);
        } else {
            int i11 = s.f11201V;
            if (typedArrayObtainStyledAttributes.hasValue(i11)) {
                this.f11002v = a0(typedArrayObtainStyledAttributes, i11);
            }
        }
        this.f10970F = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11252p0, s.f11203W, true);
        int i12 = s.f11254q0;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i12);
        this.f10966B = zHasValue;
        if (zHasValue) {
            this.f10967C = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i12, s.f11207Y, true);
        }
        this.f10968D = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11236i0, s.f11209Z, false);
        int i13 = s.f11239j0;
        this.f11005y = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i13, i13, true);
        int i14 = s.f11224e0;
        this.f10969E = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i14, i14, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void O0(SharedPreferences.Editor editor) {
        if (this.f10982b.t()) {
            editor.apply();
        }
    }

    private void P0() {
        Preference preferenceK;
        String str = this.f11001u;
        if (str == null || (preferenceK = k(str)) == null) {
            return;
        }
        preferenceK.Q0(this);
    }

    private void Q0(Preference preference) {
        List<Preference> list = this.f10974J;
        if (list != null) {
            list.remove(preference);
        }
    }

    private void j() {
        C();
        if (N0() && F().contains(this.f10993m)) {
            h0(true, null);
            return;
        }
        Object obj = this.f11002v;
        if (obj != null) {
            h0(false, obj);
        }
    }

    private void o0() {
        if (TextUtils.isEmpty(this.f11001u)) {
            return;
        }
        Preference preferenceK = k(this.f11001u);
        if (preferenceK != null) {
            preferenceK.p0(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.f11001u + "\" not found for preference \"" + this.f10993m + "\" (title: \"" + ((Object) this.f10989i) + "\"");
    }

    private void p0(Preference preference) {
        if (this.f10974J == null) {
            this.f10974J = new ArrayList();
        }
        this.f10974J.add(preference);
        preference.Y(this, M0());
    }

    private void u0(View view, boolean z5) {
        view.setEnabled(z5);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                u0(viewGroup.getChildAt(childCount), z5);
            }
        }
    }

    final void A0(c cVar) {
        this.f10973I = cVar;
    }

    public void B0(d dVar) {
        this.f10985e = dVar;
    }

    public androidx.preference.e C() {
        j jVar = this.f10982b;
        if (jVar != null) {
            jVar.j();
        }
        return null;
    }

    public void C0(e eVar) {
        this.f10986f = eVar;
    }

    public void D0(int i5) {
        if (i5 != this.f10987g) {
            this.f10987g = i5;
            S();
        }
    }

    public j E() {
        return this.f10982b;
    }

    public void E0(boolean z5) {
        this.f11000t = z5;
    }

    public SharedPreferences F() {
        if (this.f10982b == null) {
            return null;
        }
        C();
        return this.f10982b.l();
    }

    public void F0(boolean z5) {
        if (this.f10998r != z5) {
            this.f10998r = z5;
            Q();
        }
    }

    public CharSequence G() {
        return H() != null ? H().a(this) : this.f10990j;
    }

    public void G0(CharSequence charSequence) {
        if (H() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f10990j, charSequence)) {
            return;
        }
        this.f10990j = charSequence;
        Q();
    }

    public final g H() {
        return this.f10979R;
    }

    public final void H0(g gVar) {
        this.f10979R = gVar;
        Q();
    }

    public CharSequence I() {
        return this.f10989i;
    }

    public void I0(int i5) {
        J0(this.f10981a.getString(i5));
    }

    public final int J() {
        return this.f10972H;
    }

    public void J0(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f10989i)) {
            return;
        }
        this.f10989i = charSequence;
        Q();
    }

    public boolean K() {
        return !TextUtils.isEmpty(this.f10993m);
    }

    public final void K0(boolean z5) {
        if (this.f11005y != z5) {
            this.f11005y = z5;
            c cVar = this.f10973I;
            if (cVar != null) {
                cVar.e(this);
            }
        }
    }

    public boolean L() {
        return this.f10969E;
    }

    public void L0(int i5) {
        this.f10972H = i5;
    }

    public boolean M() {
        return this.f10997q && this.f11003w && this.f11004x;
    }

    public boolean M0() {
        return !M();
    }

    public boolean N() {
        return this.f11000t;
    }

    protected boolean N0() {
        return this.f10982b != null && N() && K();
    }

    public boolean O() {
        return this.f10998r;
    }

    public final boolean P() {
        return this.f11005y;
    }

    protected void Q() {
        c cVar = this.f10973I;
        if (cVar != null) {
            cVar.g(this);
        }
    }

    public void R(boolean z5) {
        List<Preference> list = this.f10974J;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            list.get(i5).Y(this, z5);
        }
    }

    protected void S() {
        c cVar = this.f10973I;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public void T() {
        o0();
    }

    protected void U(j jVar) {
        this.f10982b = jVar;
        if (!this.f10984d) {
            this.f10983c = jVar.f();
        }
        j();
    }

    protected void V(j jVar, long j5) {
        this.f10983c = j5;
        this.f10984d = true;
        try {
            U(jVar);
        } finally {
            this.f10984d = false;
        }
    }

    public void W(l lVar) {
        Integer numValueOf;
        View view = lVar.itemView;
        view.setOnClickListener(this.f10980S);
        view.setId(this.f10988h);
        TextView textView = (TextView) lVar.a(R.id.summary);
        if (textView != null) {
            CharSequence charSequenceG = G();
            if (TextUtils.isEmpty(charSequenceG)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceG);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) lVar.a(R.id.title);
        if (textView2 != null) {
            CharSequence charSequenceI = I();
            if (TextUtils.isEmpty(charSequenceI)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequenceI);
                textView2.setVisibility(0);
                if (this.f10966B) {
                    textView2.setSingleLine(this.f10967C);
                }
                if (!O() && M() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) lVar.a(R.id.icon);
        if (imageView != null) {
            int i5 = this.f10991k;
            if (i5 != 0 || this.f10992l != null) {
                if (this.f10992l == null) {
                    this.f10992l = C0744a.b(this.f10981a, i5);
                }
                Drawable drawable = this.f10992l;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f10992l != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.f10968D ? 4 : 8);
            }
        }
        View viewA = lVar.a(o.f11143a);
        if (viewA == null) {
            viewA = lVar.a(R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.f10992l != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(this.f10968D ? 4 : 8);
            }
        }
        if (this.f10970F) {
            u0(view, M());
        } else {
            u0(view, true);
        }
        boolean zO = O();
        view.setFocusable(zO);
        view.setClickable(zO);
        lVar.e(this.f11006z);
        lVar.f(this.f10965A);
        boolean zL = L();
        if (zL && this.f10978Q == null) {
            this.f10978Q = new f(this);
        }
        view.setOnCreateContextMenuListener(zL ? this.f10978Q : null);
        view.setLongClickable(zL);
        if (!zL || zO) {
            return;
        }
        H.o0(view, null);
    }

    protected void X() {
    }

    public void Y(Preference preference, boolean z5) {
        if (this.f11003w == z5) {
            this.f11003w = !z5;
            R(M0());
            Q();
        }
    }

    public void Z() {
        P0();
        this.f10976L = true;
    }

    protected Object a0(TypedArray typedArray, int i5) {
        return null;
    }

    void b(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.f10975K != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.f10975K = preferenceGroup;
    }

    @Deprecated
    public void b0(E.c cVar) {
    }

    public void c0(Preference preference, boolean z5) {
        if (this.f11004x == z5) {
            this.f11004x = !z5;
            R(M0());
            Q();
        }
    }

    public boolean d(Object obj) {
        d dVar = this.f10985e;
        return dVar == null || dVar.c(this, obj);
    }

    protected void d0() {
        P0();
    }

    final void e() {
        this.f10976L = false;
    }

    protected void e0(Parcelable parcelable) {
        this.f10977M = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable f0() {
        this.f10977M = true;
        return AbsSavedState.EMPTY_STATE;
    }

    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i5 = this.f10987g;
        int i6 = preference.f10987g;
        if (i5 != i6) {
            return i5 - i6;
        }
        CharSequence charSequence = this.f10989i;
        CharSequence charSequence2 = preference.f10989i;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f10989i.toString());
    }

    protected void g0(Object obj) {
    }

    void h(Bundle bundle) {
        Parcelable parcelable;
        if (!K() || (parcelable = bundle.getParcelable(this.f10993m)) == null) {
            return;
        }
        this.f10977M = false;
        e0(parcelable);
        if (!this.f10977M) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    @Deprecated
    protected void h0(boolean z5, Object obj) {
        g0(obj);
    }

    void i(Bundle bundle) {
        if (K()) {
            this.f10977M = false;
            Parcelable parcelableF0 = f0();
            if (!this.f10977M) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableF0 != null) {
                bundle.putParcelable(this.f10993m, parcelableF0);
            }
        }
    }

    public void i0() {
        j.c cVarH;
        if (M() && O()) {
            X();
            e eVar = this.f10986f;
            if (eVar == null || !eVar.f(this)) {
                j jVarE = E();
                if ((jVarE == null || (cVarH = jVarE.h()) == null || !cVarH.j(this)) && this.f10994n != null) {
                    l().startActivity(this.f10994n);
                }
            }
        }
    }

    protected void j0(View view) {
        i0();
    }

    protected <T extends Preference> T k(String str) {
        j jVar = this.f10982b;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(str);
    }

    protected boolean k0(boolean z5) {
        if (!N0()) {
            return false;
        }
        if (z5 == w(!z5)) {
            return true;
        }
        C();
        SharedPreferences.Editor editorE = this.f10982b.e();
        editorE.putBoolean(this.f10993m, z5);
        O0(editorE);
        return true;
    }

    public Context l() {
        return this.f10981a;
    }

    protected boolean l0(int i5) {
        if (!N0()) {
            return false;
        }
        if (i5 == x(~i5)) {
            return true;
        }
        C();
        SharedPreferences.Editor editorE = this.f10982b.e();
        editorE.putInt(this.f10993m, i5);
        O0(editorE);
        return true;
    }

    public Bundle m() {
        if (this.f10996p == null) {
            this.f10996p = new Bundle();
        }
        return this.f10996p;
    }

    protected boolean m0(String str) {
        if (!N0()) {
            return false;
        }
        if (TextUtils.equals(str, y(null))) {
            return true;
        }
        C();
        SharedPreferences.Editor editorE = this.f10982b.e();
        editorE.putString(this.f10993m, str);
        O0(editorE);
        return true;
    }

    StringBuilder n() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceI = I();
        if (!TextUtils.isEmpty(charSequenceI)) {
            sb.append(charSequenceI);
            sb.append(' ');
        }
        CharSequence charSequenceG = G();
        if (!TextUtils.isEmpty(charSequenceG)) {
            sb.append(charSequenceG);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public boolean n0(Set<String> set) {
        if (!N0()) {
            return false;
        }
        if (set.equals(z(null))) {
            return true;
        }
        C();
        SharedPreferences.Editor editorE = this.f10982b.e();
        editorE.putStringSet(this.f10993m, set);
        O0(editorE);
        return true;
    }

    public String o() {
        return this.f10995o;
    }

    public Drawable p() {
        int i5;
        if (this.f10992l == null && (i5 = this.f10991k) != 0) {
            this.f10992l = C0744a.b(this.f10981a, i5);
        }
        return this.f10992l;
    }

    long q() {
        return this.f10983c;
    }

    void q0() {
        if (TextUtils.isEmpty(this.f10993m)) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        this.f10999s = true;
    }

    public Intent r() {
        return this.f10994n;
    }

    public void r0(Bundle bundle) {
        h(bundle);
    }

    public String s() {
        return this.f10993m;
    }

    public void s0(Bundle bundle) {
        i(bundle);
    }

    public final int t() {
        return this.f10971G;
    }

    public void t0(boolean z5) {
        if (this.f10997q != z5) {
            this.f10997q = z5;
            R(M0());
            Q();
        }
    }

    public String toString() {
        return n().toString();
    }

    public int u() {
        return this.f10987g;
    }

    public PreferenceGroup v() {
        return this.f10975K;
    }

    public void v0(int i5) {
        w0(C0744a.b(this.f10981a, i5));
        this.f10991k = i5;
    }

    protected boolean w(boolean z5) {
        if (!N0()) {
            return z5;
        }
        C();
        return this.f10982b.l().getBoolean(this.f10993m, z5);
    }

    public void w0(Drawable drawable) {
        if (this.f10992l != drawable) {
            this.f10992l = drawable;
            this.f10991k = 0;
            Q();
        }
    }

    protected int x(int i5) {
        if (!N0()) {
            return i5;
        }
        C();
        return this.f10982b.l().getInt(this.f10993m, i5);
    }

    public void x0(Intent intent) {
        this.f10994n = intent;
    }

    protected String y(String str) {
        if (!N0()) {
            return str;
        }
        C();
        return this.f10982b.l().getString(this.f10993m, str);
    }

    public void y0(String str) {
        this.f10993m = str;
        if (!this.f10999s || K()) {
            return;
        }
        q0();
    }

    public Set<String> z(Set<String> set) {
        if (!N0()) {
            return set;
        }
        C();
        return this.f10982b.l().getStringSet(this.f10993m, set);
    }

    public void z0(int i5) {
        this.f10971G = i5;
    }

    public Preference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11137h, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
