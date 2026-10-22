package androidx.preference;

import K.S;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: A, reason: collision with root package name */
    public final boolean f4064A;

    /* renamed from: B, reason: collision with root package name */
    public final boolean f4065B;

    /* renamed from: C, reason: collision with root package name */
    public final boolean f4066C;

    /* renamed from: D, reason: collision with root package name */
    public final boolean f4067D;

    /* renamed from: E, reason: collision with root package name */
    public int f4068E;

    /* renamed from: F, reason: collision with root package name */
    public int f4069F;

    /* renamed from: G, reason: collision with root package name */
    public InterfaceC0343o f4070G;

    /* renamed from: H, reason: collision with root package name */
    public ArrayList f4071H;

    /* renamed from: I, reason: collision with root package name */
    public PreferenceGroup f4072I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f4073J;

    /* renamed from: K, reason: collision with root package name */
    public q f4074K;

    /* renamed from: L, reason: collision with root package name */
    public r f4075L;

    /* renamed from: M, reason: collision with root package name */
    public final ViewOnClickListenerC0341m f4076M;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4077a;

    /* renamed from: b, reason: collision with root package name */
    public H f4078b;

    /* renamed from: c, reason: collision with root package name */
    public long f4079c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4080d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0344p f4081e;

    /* renamed from: f, reason: collision with root package name */
    public B0.m f4082f;

    /* renamed from: g, reason: collision with root package name */
    public int f4083g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f4084h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f4085i;

    /* renamed from: j, reason: collision with root package name */
    public int f4086j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f4087k;

    /* renamed from: l, reason: collision with root package name */
    public final String f4088l;

    /* renamed from: m, reason: collision with root package name */
    public Intent f4089m;

    /* renamed from: n, reason: collision with root package name */
    public final String f4090n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f4091o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f4092p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f4093q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f4094r;

    /* renamed from: s, reason: collision with root package name */
    public final String f4095s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f4096t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4097u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4098v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4099w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f4100x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f4101y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f4102z;

    public static class BaseSavedState extends AbsSavedState {

        @NonNull
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new C0342n();

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f4083g = Integer.MAX_VALUE;
        this.f4092p = true;
        this.f4093q = true;
        this.f4094r = true;
        this.f4097u = true;
        this.f4098v = true;
        this.f4099w = true;
        this.f4100x = true;
        this.f4101y = true;
        this.f4064A = true;
        this.f4067D = true;
        this.f4068E = R.layout.preference;
        this.f4076M = new ViewOnClickListenerC0341m(this);
        this.f4077a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4047g, i4, i5);
        this.f4086j = typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.f4088l = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.f4084h = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.f4085i = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.f4083g = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        String string2 = typedArrayObtainStyledAttributes.getString(22);
        this.f4090n = string2 == null ? typedArrayObtainStyledAttributes.getString(13) : string2;
        this.f4068E = typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        this.f4069F = typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.f4092p = typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        this.f4093q = z4;
        this.f4094r = typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        String string3 = typedArrayObtainStyledAttributes.getString(19);
        this.f4095s = string3 == null ? typedArrayObtainStyledAttributes.getString(10) : string3;
        this.f4100x = typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, z4));
        this.f4101y = typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, z4));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.f4096t = o(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.f4096t = o(typedArrayObtainStyledAttributes, 11);
        }
        this.f4067D = typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(32);
        this.f4102z = zHasValue;
        if (zHasValue) {
            this.f4064A = typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        this.f4065B = typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        this.f4099w = typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        this.f4066C = typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void u(View view, boolean z4) {
        view.setEnabled(z4);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                u(viewGroup.getChildAt(childCount), z4);
            }
        }
    }

    public final boolean a(Serializable serializable) {
        InterfaceC0344p interfaceC0344p = this.f4081e;
        return interfaceC0344p == null || interfaceC0344p.b(this, serializable);
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        if (!(!TextUtils.isEmpty(this.f4088l)) || (parcelable = bundle.getParcelable(this.f4088l)) == null) {
            return;
        }
        this.f4073J = false;
        p(parcelable);
        if (!this.f4073J) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void c(Bundle bundle) {
        if (!TextUtils.isEmpty(this.f4088l)) {
            this.f4073J = false;
            Parcelable parcelableQ = q();
            if (!this.f4073J) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableQ != null) {
                bundle.putParcelable(this.f4088l, parcelableQ);
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i4 = this.f4083g;
        int i5 = preference2.f4083g;
        if (i4 != i5) {
            return i4 - i5;
        }
        CharSequence charSequence = this.f4084h;
        CharSequence charSequence2 = preference2.f4084h;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.f4084h.toString());
    }

    public long d() {
        return this.f4079c;
    }

    public final String e(String str) {
        return !x() ? str : this.f4078b.b().getString(this.f4088l, str);
    }

    public CharSequence f() {
        r rVar = this.f4075L;
        return rVar != null ? rVar.b(this) : this.f4085i;
    }

    public boolean g() {
        return this.f4092p && this.f4097u && this.f4098v;
    }

    public void h() {
        InterfaceC0343o interfaceC0343o = this.f4070G;
        if (interfaceC0343o != null) {
            interfaceC0343o.onPreferenceChange(this);
        }
    }

    public void i(boolean z4) {
        ArrayList arrayList = this.f4071H;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Preference preference = (Preference) arrayList.get(i4);
            if (preference.f4097u == z4) {
                preference.f4097u = !z4;
                preference.i(preference.w());
                preference.h();
            }
        }
    }

    public void j() {
        PreferenceScreen preferenceScreen;
        String str = this.f4095s;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        H h4 = this.f4078b;
        Preference preferenceZ = null;
        if (h4 != null && (preferenceScreen = h4.f4028g) != null) {
            preferenceZ = preferenceScreen.z(str);
        }
        if (preferenceZ == null) {
            StringBuilder sbW = B0.g.w("Dependency \"", str, "\" not found for preference \"");
            sbW.append(this.f4088l);
            sbW.append("\" (title: \"");
            sbW.append((Object) this.f4084h);
            sbW.append("\"");
            throw new IllegalStateException(sbW.toString());
        }
        if (preferenceZ.f4071H == null) {
            preferenceZ.f4071H = new ArrayList();
        }
        preferenceZ.f4071H.add(this);
        boolean zW = preferenceZ.w();
        if (this.f4097u == zW) {
            this.f4097u = !zW;
            i(w());
            h();
        }
    }

    public final void k(H h4) {
        long j4;
        this.f4078b = h4;
        if (!this.f4080d) {
            synchronized (h4) {
                j4 = h4.f4023b;
                h4.f4023b = 1 + j4;
            }
            this.f4079c = j4;
        }
        if (x()) {
            H h5 = this.f4078b;
            if ((h5 != null ? h5.b() : null).contains(this.f4088l)) {
                r(null);
                return;
            }
        }
        Object obj = this.f4096t;
        if (obj != null) {
            r(obj);
        }
    }

    public void l(K k4) {
        Integer numValueOf;
        View view = k4.itemView;
        view.setOnClickListener(this.f4076M);
        view.setId(0);
        TextView textView = (TextView) k4.a(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceF = f();
            if (TextUtils.isEmpty(charSequenceF)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceF);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) k4.a(android.R.id.title);
        boolean z4 = this.f4093q;
        if (textView2 != null) {
            CharSequence charSequence = this.f4084h;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.f4102z) {
                    textView2.setSingleLine(this.f4064A);
                }
                if (!z4 && g() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) k4.a(android.R.id.icon);
        boolean z5 = this.f4065B;
        if (imageView != null) {
            int i4 = this.f4086j;
            if (i4 != 0 || this.f4087k != null) {
                if (this.f4087k == null) {
                    this.f4087k = Z2.I.o(this.f4077a, i4);
                }
                Drawable drawable = this.f4087k;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f4087k != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(z5 ? 4 : 8);
            }
        }
        View viewA = k4.a(R.id.icon_frame);
        if (viewA == null) {
            viewA = k4.a(android.R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.f4087k != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(z5 ? 4 : 8);
            }
        }
        if (this.f4067D) {
            u(view, g());
        } else {
            u(view, true);
        }
        view.setFocusable(z4);
        view.setClickable(z4);
        k4.f4039d = this.f4100x;
        k4.f4040e = this.f4101y;
        boolean z6 = this.f4066C;
        if (z6 && this.f4074K == null) {
            this.f4074K = new q(this);
        }
        view.setOnCreateContextMenuListener(z6 ? this.f4074K : null);
        view.setLongClickable(z6);
        if (!z6 || z4) {
            return;
        }
        WeakHashMap weakHashMap = S.f939a;
        view.setBackground(null);
    }

    public void m() {
    }

    public void n() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.f4095s;
        if (str != null) {
            H h4 = this.f4078b;
            Preference preferenceZ = null;
            if (h4 != null && (preferenceScreen = h4.f4028g) != null) {
                preferenceZ = preferenceScreen.z(str);
            }
            if (preferenceZ == null || (arrayList = preferenceZ.f4071H) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object o(TypedArray typedArray, int i4) {
        return null;
    }

    public void p(Parcelable parcelable) {
        this.f4073J = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable q() {
        this.f4073J = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void r(Object obj) {
    }

    public void s(View view) {
        Intent intent;
        G g4;
        if (g() && this.f4093q) {
            m();
            B0.m mVar = this.f4082f;
            if (mVar != null) {
                ((PreferenceGroup) mVar.f155b).C(Integer.MAX_VALUE);
                ((C) mVar.f156c).onPreferenceHierarchyChange(this);
                ((PreferenceGroup) mVar.f155b).getClass();
                return;
            }
            H h4 = this.f4078b;
            if ((h4 == null || (g4 = h4.f4029h) == null || !g4.onPreferenceTreeClick(this)) && (intent = this.f4089m) != null) {
                this.f4077a.startActivity(intent);
            }
        }
    }

    public final void t(String str) {
        if (x() && !TextUtils.equals(str, e(null))) {
            SharedPreferences.Editor editorA = this.f4078b.a();
            editorA.putString(this.f4088l, str);
            y(editorA);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f4084h;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceF = f();
        if (!TextUtils.isEmpty(charSequenceF)) {
            sb.append(charSequenceF);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public void v(CharSequence charSequence) {
        if (this.f4075L != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f4085i, charSequence)) {
            return;
        }
        this.f4085i = charSequence;
        h();
    }

    public boolean w() {
        return !g();
    }

    public final boolean x() {
        return this.f4078b != null && this.f4094r && (TextUtils.isEmpty(this.f4088l) ^ true);
    }

    public final void y(SharedPreferences.Editor editor) {
        if (!this.f4078b.f4026e) {
            editor.apply();
        }
    }

    public Preference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, Z2.I.m(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle), 0);
    }
}
