package androidx.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.datastore.preferences.protobuf.b1;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends RecyclerView.Adapter<h> implements PreferenceGroup.b {

    /* renamed from: a, reason: collision with root package name */
    public final PreferenceGroup f2390a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2391b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f2392c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2393d;

    /* renamed from: f, reason: collision with root package name */
    public final a f2395f = new a();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f2394e = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.f();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.preference.b$b, reason: collision with other inner class name */
    public static class C0016b {

        /* renamed from: a, reason: collision with root package name */
        public final int f2397a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2398b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2399c;

        public C0016b(Preference preference) {
            this.f2399c = preference.getClass().getName();
            this.f2397a = preference.I;
            this.f2398b = preference.J;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0016b)) {
                return false;
            }
            C0016b c0016b = (C0016b) obj;
            return this.f2397a == c0016b.f2397a && this.f2398b == c0016b.f2398b && TextUtils.equals(this.f2399c, c0016b.f2399c);
        }

        public final int hashCode() {
            return this.f2399c.hashCode() + ((((527 + this.f2397a) * 31) + this.f2398b) * 31);
        }
    }

    public b(PreferenceScreen preferenceScreen) {
        this.f2390a = preferenceScreen;
        preferenceScreen.K = this;
        this.f2391b = new ArrayList();
        this.f2392c = new ArrayList();
        this.f2393d = new ArrayList();
        setHasStableIds(preferenceScreen.Z);
        f();
    }

    @Override // androidx.preference.PreferenceGroup.b
    public final int a(Preference preference) {
        int size = this.f2392c.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preference2 = (Preference) this.f2392c.get(i10);
            if (preference2 != null && preference2.equals(preference)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.preference.PreferenceGroup.b
    public final int b(String str) {
        int size = this.f2392c.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (TextUtils.equals(str, ((Preference) this.f2392c.get(i10)).f2357o)) {
                return i10;
            }
        }
        return -1;
    }

    public final ArrayList c(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.T.size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Preference preferenceD = preferenceGroup.D(i12);
            if (preferenceD.A) {
                int i13 = preferenceGroup.X;
                if (i13 == Integer.MAX_VALUE || i11 < i13) {
                    arrayList.add(preferenceD);
                } else {
                    arrayList2.add(preferenceD);
                }
                if (preferenceD instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceD;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else {
                        if (preferenceGroup.X != Integer.MAX_VALUE && preferenceGroup2.X != Integer.MAX_VALUE) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        ArrayList arrayListC = c(preferenceGroup2);
                        int size2 = arrayListC.size();
                        int i14 = 0;
                        while (i14 < size2) {
                            Object obj = arrayListC.get(i14);
                            i14++;
                            Preference preference = (Preference) obj;
                            int i15 = preferenceGroup.X;
                            if (i15 == Integer.MAX_VALUE || i11 < i15) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i11++;
                        }
                    }
                } else {
                    i11++;
                }
            }
        }
        int i16 = preferenceGroup.X;
        if (i16 != Integer.MAX_VALUE && i11 > i16) {
            Context context = preferenceGroup.f2347a;
            long j10 = preferenceGroup.f2349c;
            CharSequence string = null;
            androidx.preference.a aVar = new androidx.preference.a(context, null);
            aVar.I = R.layout.expand_button;
            Context context2 = aVar.f2347a;
            Drawable drawableL = b1.L(R.drawable.ic_arrow_down_24dp, context2);
            if (aVar.f2356n != drawableL) {
                aVar.f2356n = drawableL;
                aVar.f2355m = 0;
                aVar.j();
            }
            aVar.f2355m = R.drawable.ic_arrow_down_24dp;
            String string2 = context2.getString(R.string.expand_button_title);
            if (!TextUtils.equals(string2, aVar.f2353k)) {
                aVar.f2353k = string2;
                aVar.j();
            }
            if (999 != aVar.f2352j) {
                aVar.f2352j = 999;
                b bVar = aVar.K;
                if (bVar != null) {
                    Handler handler = bVar.f2394e;
                    a aVar2 = bVar.f2395f;
                    handler.removeCallbacks(aVar2);
                    handler.post(aVar2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size3 = arrayList2.size();
            while (i10 < size3) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                Preference preference2 = (Preference) obj2;
                CharSequence charSequence = preference2.f2353k;
                boolean z = preference2 instanceof PreferenceGroup;
                if (z && !TextUtils.isEmpty(charSequence)) {
                    arrayList3.add((PreferenceGroup) preference2);
                }
                if (arrayList3.contains(preference2.M)) {
                    if (z) {
                        arrayList3.add((PreferenceGroup) preference2);
                    }
                } else if (!TextUtils.isEmpty(charSequence)) {
                    string = string == null ? charSequence : context2.getString(R.string.summary_collapsed_preference_list, string, charSequence);
                }
            }
            aVar.x(string);
            aVar.R = j10 + 1000000;
            c cVar = new c();
            cVar.f2401b = this;
            cVar.f2400a = preferenceGroup;
            aVar.h = cVar;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public final void d(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.T);
        }
        int size = preferenceGroup.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preferenceD = preferenceGroup.D(i10);
            arrayList.add(preferenceD);
            C0016b c0016b = new C0016b(preferenceD);
            if (!this.f2393d.contains(c0016b)) {
                this.f2393d.add(c0016b);
            }
            if (preferenceD instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceD;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    d(arrayList, preferenceGroup2);
                }
            }
            preferenceD.K = this;
        }
    }

    public final Preference e(int i10) {
        if (i10 < 0 || i10 >= this.f2392c.size()) {
            return null;
        }
        return (Preference) this.f2392c.get(i10);
    }

    public final void f() {
        ArrayList arrayList = this.f2391b;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((Preference) obj).K = null;
        }
        ArrayList arrayList2 = new ArrayList(this.f2391b.size());
        this.f2391b = arrayList2;
        PreferenceGroup preferenceGroup = this.f2390a;
        d(arrayList2, preferenceGroup);
        this.f2392c = c(preferenceGroup);
        notifyDataSetChanged();
        ArrayList arrayList3 = this.f2391b;
        int size2 = arrayList3.size();
        while (i10 < size2) {
            Object obj2 = arrayList3.get(i10);
            i10++;
            ((Preference) obj2).getClass();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f2392c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i10) {
        if (hasStableIds()) {
            return e(i10).e();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        C0016b c0016b = new C0016b(e(i10));
        ArrayList arrayList = this.f2393d;
        int iIndexOf = arrayList.indexOf(c0016b);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = arrayList.size();
        arrayList.add(c0016b);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        h hVar = (h) viewHolder;
        Preference preferenceE = e(i10);
        ColorStateList colorStateList = hVar.f2423b;
        Drawable background = hVar.itemView.getBackground();
        Drawable drawable = hVar.f2422a;
        if (background != drawable) {
            View view = hVar.itemView;
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) hVar.a(android.R.id.title);
        if (textView != null && colorStateList != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        preferenceE.n(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        C0016b c0016b = (C0016b) this.f2393d.get(i10);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, i.f2427a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = b1.L(android.R.drawable.list_selector_background, viewGroup.getContext());
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(c0016b.f2397a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(android.R.id.widget_frame);
        if (viewGroup2 != null) {
            int i11 = c0016b.f2398b;
            if (i11 != 0) {
                layoutInflaterFrom.inflate(i11, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new h(viewInflate);
    }
}
