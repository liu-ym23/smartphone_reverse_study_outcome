package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.datastore.preferences.protobuf.b1;
import androidx.preference.b;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.settings.ModelManagerSettingsFragment;
import java.util.ArrayList;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public boolean F;
    public final boolean G;
    public final boolean H;
    public int I;
    public int J;
    public androidx.preference.b K;
    public ArrayList L;
    public PreferenceGroup M;
    public boolean N;
    public b O;
    public c P;
    public final a Q;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2347a;

    /* renamed from: b, reason: collision with root package name */
    public f f2348b;

    /* renamed from: c, reason: collision with root package name */
    public long f2349c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2350d;

    /* renamed from: e, reason: collision with root package name */
    public com.stepos.core.ota.d f2351e;
    public androidx.preference.c h;

    /* renamed from: j, reason: collision with root package name */
    public int f2352j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f2353k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2354l;

    /* renamed from: m, reason: collision with root package name */
    public int f2355m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f2356n;

    /* renamed from: o, reason: collision with root package name */
    public String f2357o;

    /* renamed from: p, reason: collision with root package name */
    public Intent f2358p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2359q;
    public Bundle r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f2360s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2361t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2362u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2363v;

    /* renamed from: w, reason: collision with root package name */
    public final String f2364w;

    /* renamed from: x, reason: collision with root package name */
    public final Object f2365x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2366y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<BaseSavedState> {
            @Override // android.os.Parcelable.Creator
            public final BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final BaseSavedState[] newArray(int i10) {
                return new BaseSavedState[i10];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Preference.this.u(view);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Preference f2368a;

        public b(Preference preference) {
            this.f2368a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Preference preference = this.f2368a;
            CharSequence charSequenceH = preference.h();
            if (!preference.G || TextUtils.isEmpty(charSequenceH)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceH);
            contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Preference preference = this.f2368a;
            ClipboardManager clipboardManager = (ClipboardManager) preference.f2347a.getSystemService("clipboard");
            CharSequence charSequenceH = preference.h();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceH));
            Context context = preference.f2347a;
            Toast.makeText(context, context.getString(R.string.preference_copied, charSequenceH), 0).show();
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c<T extends Preference> {
        CharSequence a(T t8);
    }

    public Preference(Context context, AttributeSet attributeSet, int i10) {
        this.f2352j = Integer.MAX_VALUE;
        this.f2360s = true;
        this.f2361t = true;
        this.f2363v = true;
        this.f2366y = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.C = true;
        this.E = true;
        this.H = true;
        this.I = R.layout.preference;
        this.Q = new a();
        this.f2347a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2433g, i10, 0);
        this.f2355m = typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.f2357o = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.f2353k = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.f2354l = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.f2352j = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        String string2 = typedArrayObtainStyledAttributes.getString(22);
        this.f2359q = string2 == null ? typedArrayObtainStyledAttributes.getString(13) : string2;
        this.I = typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        this.J = typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.f2360s = typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        this.f2361t = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        this.f2363v = typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        String string3 = typedArrayObtainStyledAttributes.getString(19);
        this.f2364w = string3 == null ? typedArrayObtainStyledAttributes.getString(10) : string3;
        this.B = typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, this.f2361t));
        this.C = typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, this.f2361t));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.f2365x = q(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.f2365x = q(typedArrayObtainStyledAttributes, 11);
        }
        this.H = typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(32);
        this.D = zHasValue;
        if (zHasValue) {
            this.E = typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        this.F = typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        this.A = typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        this.G = typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void w(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                w(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final void A() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.f2364w;
        if (str != null) {
            f fVar = this.f2348b;
            Preference preferenceC = null;
            if (fVar != null && (preferenceScreen = fVar.f2415g) != null) {
                preferenceC = preferenceScreen.C(str);
            }
            if (preferenceC == null || (arrayList = preferenceC.L) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public final boolean a(Object obj) {
        return this.f2351e == null || ModelManagerSettingsFragment.onCreatePreferences$lambda$1$lambda$0(this, obj);
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        if (TextUtils.isEmpty(this.f2357o) || (parcelable = bundle.getParcelable(this.f2357o)) == null) {
            return;
        }
        this.N = false;
        r(parcelable);
        if (!this.N) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void c(Bundle bundle) {
        if (TextUtils.isEmpty(this.f2357o)) {
            return;
        }
        this.N = false;
        Parcelable parcelableS = s();
        if (!this.N) {
            throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
        }
        if (parcelableS != null) {
            bundle.putParcelable(this.f2357o, parcelableS);
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i10 = this.f2352j;
        int i11 = preference2.f2352j;
        if (i10 != i11) {
            return i10 - i11;
        }
        CharSequence charSequence = this.f2353k;
        CharSequence charSequence2 = preference2.f2353k;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.f2353k.toString());
    }

    public final Bundle d() {
        if (this.r == null) {
            this.r = new Bundle();
        }
        return this.r;
    }

    public long e() {
        return this.f2349c;
    }

    public final String g(String str) {
        return !z() ? str : this.f2348b.b().getString(this.f2357o, str);
    }

    public CharSequence h() {
        c cVar = this.P;
        return cVar != null ? cVar.a(this) : this.f2354l;
    }

    public boolean i() {
        return this.f2360s && this.f2366y && this.z;
    }

    public void j() {
        int iIndexOf;
        androidx.preference.b bVar = this.K;
        if (bVar == null || (iIndexOf = bVar.f2392c.indexOf(this)) == -1) {
            return;
        }
        bVar.notifyItemChanged(iIndexOf, this);
    }

    public void k(boolean z) {
        ArrayList arrayList = this.L;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preference = (Preference) arrayList.get(i10);
            if (preference.f2366y == z) {
                preference.f2366y = !z;
                preference.k(preference.y());
                preference.j();
            }
        }
    }

    public void l() {
        PreferenceScreen preferenceScreen;
        String str = this.f2364w;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f fVar = this.f2348b;
        Preference preferenceC = null;
        if (fVar != null && (preferenceScreen = fVar.f2415g) != null) {
            preferenceC = preferenceScreen.C(str);
        }
        if (preferenceC == null) {
            StringBuilder sbQ = a0.a.q("Dependency \"", str, "\" not found for preference \"");
            sbQ.append(this.f2357o);
            sbQ.append("\" (title: \"");
            sbQ.append((Object) this.f2353k);
            sbQ.append("\"");
            throw new IllegalStateException(sbQ.toString());
        }
        if (preferenceC.L == null) {
            preferenceC.L = new ArrayList();
        }
        preferenceC.L.add(this);
        boolean zY = preferenceC.y();
        if (this.f2366y == zY) {
            this.f2366y = !zY;
            k(y());
            j();
        }
    }

    public final void m(f fVar) {
        long j10;
        this.f2348b = fVar;
        if (!this.f2350d) {
            synchronized (fVar) {
                j10 = fVar.f2410b;
                fVar.f2410b = 1 + j10;
            }
            this.f2349c = j10;
        }
        if (z()) {
            f fVar2 = this.f2348b;
            if ((fVar2 != null ? fVar2.b() : null).contains(this.f2357o)) {
                t(null);
                return;
            }
        }
        Object obj = this.f2365x;
        if (obj != null) {
            t(obj);
        }
    }

    public void n(h hVar) {
        Integer numValueOf;
        View view = hVar.itemView;
        view.setOnClickListener(this.Q);
        view.setId(0);
        TextView textView = (TextView) hVar.a(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceH = h();
            if (TextUtils.isEmpty(charSequenceH)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceH);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) hVar.a(android.R.id.title);
        if (textView2 != null) {
            CharSequence charSequence = this.f2353k;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.D) {
                    textView2.setSingleLine(this.E);
                }
                if (!this.f2361t && i() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) hVar.a(android.R.id.icon);
        if (imageView != null) {
            int i10 = this.f2355m;
            if (i10 != 0 || this.f2356n != null) {
                if (this.f2356n == null) {
                    this.f2356n = b1.L(i10, this.f2347a);
                }
                Drawable drawable = this.f2356n;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f2356n != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.F ? 4 : 8);
            }
        }
        View viewA = hVar.a(R.id.icon_frame);
        if (viewA == null) {
            viewA = hVar.a(android.R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.f2356n != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(this.F ? 4 : 8);
            }
        }
        if (this.H) {
            w(view, i());
        } else {
            w(view, true);
        }
        boolean z = this.f2361t;
        view.setFocusable(z);
        view.setClickable(z);
        hVar.f2425d = this.B;
        hVar.f2426e = this.C;
        boolean z3 = this.G;
        if (z3 && this.O == null) {
            this.O = new b(this);
        }
        view.setOnCreateContextMenuListener(z3 ? this.O : null);
        view.setLongClickable(z3);
        if (!z3 || z) {
            return;
        }
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        view.setBackground(null);
    }

    public void p() {
        A();
    }

    public Object q(TypedArray typedArray, int i10) {
        return null;
    }

    public void r(Parcelable parcelable) {
        this.N = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable s() {
        this.N = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence charSequence = this.f2353k;
        if (!TextUtils.isEmpty(charSequence)) {
            sb2.append(charSequence);
            sb2.append(' ');
        }
        CharSequence charSequenceH = h();
        if (!TextUtils.isEmpty(charSequenceH)) {
            sb2.append(charSequenceH);
            sb2.append(' ');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public void u(View view) {
        Intent intent;
        PreferenceFragmentCompat preferenceFragmentCompat;
        if (i() && this.f2361t) {
            o();
            androidx.preference.c cVar = this.h;
            if (cVar != null) {
                ((PreferenceGroup) cVar.f2400a).X = Integer.MAX_VALUE;
                androidx.preference.b bVar = (androidx.preference.b) cVar.f2401b;
                Handler handler = bVar.f2394e;
                b.a aVar = bVar.f2395f;
                handler.removeCallbacks(aVar);
                handler.post(aVar);
                return;
            }
            f fVar = this.f2348b;
            if ((fVar == null || (preferenceFragmentCompat = fVar.h) == null || !preferenceFragmentCompat.onPreferenceTreeClick(this)) && (intent = this.f2358p) != null) {
                this.f2347a.startActivity(intent);
            }
        }
    }

    public final void v(String str) {
        if (z() && !TextUtils.equals(str, g(null))) {
            SharedPreferences.Editor editorA = this.f2348b.a();
            editorA.putString(this.f2357o, str);
            if (this.f2348b.f2413e) {
                return;
            }
            editorA.apply();
        }
    }

    public void x(CharSequence charSequence) {
        if (this.P != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f2354l, charSequence)) {
            return;
        }
        this.f2354l = charSequence;
        j();
    }

    public boolean y() {
        return !i();
    }

    public final boolean z() {
        return (this.f2348b == null || !this.f2363v || TextUtils.isEmpty(this.f2357o)) ? false : true;
    }

    public void o() {
    }

    public void t(Object obj) {
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.g.a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
