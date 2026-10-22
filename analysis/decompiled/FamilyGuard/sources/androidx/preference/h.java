package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.H;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import h.C0744a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h extends RecyclerView.Adapter<l> implements Preference.c {

    /* renamed from: a, reason: collision with root package name */
    private final PreferenceGroup f11089a;

    /* renamed from: b, reason: collision with root package name */
    private List<Preference> f11090b;

    /* renamed from: c, reason: collision with root package name */
    private List<Preference> f11091c;

    /* renamed from: d, reason: collision with root package name */
    private final List<c> f11092d;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f11094f = new a();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f11093e = new Handler(Looper.getMainLooper());

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.t();
        }
    }

    class b implements Preference.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreferenceGroup f11096a;

        b(PreferenceGroup preferenceGroup) {
            this.f11096a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.e
        public boolean f(Preference preference) {
            this.f11096a.c1(Integer.MAX_VALUE);
            h.this.b(preference);
            this.f11096a.V0();
            return true;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        int f11098a;

        /* renamed from: b, reason: collision with root package name */
        int f11099b;

        /* renamed from: c, reason: collision with root package name */
        String f11100c;

        c(Preference preference) {
            this.f11100c = preference.getClass().getName();
            this.f11098a = preference.t();
            this.f11099b = preference.J();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f11098a == cVar.f11098a && this.f11099b == cVar.f11099b && TextUtils.equals(this.f11100c, cVar.f11100c);
        }

        public int hashCode() {
            return ((((527 + this.f11098a) * 31) + this.f11099b) * 31) + this.f11100c.hashCode();
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this.f11089a = preferenceGroup;
        preferenceGroup.A0(this);
        this.f11090b = new ArrayList();
        this.f11091c = new ArrayList();
        this.f11092d = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).f1());
        } else {
            setHasStableIds(true);
        }
        t();
    }

    private androidx.preference.b j(PreferenceGroup preferenceGroup, List<Preference> list) {
        androidx.preference.b bVar = new androidx.preference.b(preferenceGroup.l(), list, preferenceGroup.q());
        bVar.C0(new b(preferenceGroup));
        return bVar;
    }

    private List<Preference> k(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iX0 = preferenceGroup.X0();
        int i5 = 0;
        for (int i6 = 0; i6 < iX0; i6++) {
            Preference preferenceW0 = preferenceGroup.W0(i6);
            if (preferenceW0.P()) {
                if (!p(preferenceGroup) || i5 < preferenceGroup.U0()) {
                    arrayList.add(preferenceW0);
                } else {
                    arrayList2.add(preferenceW0);
                }
                if (preferenceW0 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceW0;
                    if (!preferenceGroup2.Y0()) {
                        continue;
                    } else {
                        if (p(preferenceGroup) && p(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : k(preferenceGroup2)) {
                            if (!p(preferenceGroup) || i5 < preferenceGroup.U0()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i5++;
                        }
                    }
                } else {
                    i5++;
                }
            }
        }
        if (p(preferenceGroup) && i5 > preferenceGroup.U0()) {
            arrayList.add(j(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void l(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.e1();
        int iX0 = preferenceGroup.X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            Preference preferenceW0 = preferenceGroup.W0(i5);
            list.add(preferenceW0);
            c cVar = new c(preferenceW0);
            if (!this.f11092d.contains(cVar)) {
                this.f11092d.add(cVar);
            }
            if (preferenceW0 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceW0;
                if (preferenceGroup2.Y0()) {
                    l(list, preferenceGroup2);
                }
            }
            preferenceW0.A0(this);
        }
    }

    private boolean p(PreferenceGroup preferenceGroup) {
        return preferenceGroup.U0() != Integer.MAX_VALUE;
    }

    @Override // androidx.preference.Preference.c
    public void b(Preference preference) {
        this.f11093e.removeCallbacks(this.f11094f);
        this.f11093e.post(this.f11094f);
    }

    @Override // androidx.preference.Preference.c
    public void e(Preference preference) {
        b(preference);
    }

    @Override // androidx.preference.Preference.c
    public void g(Preference preference) {
        int iIndexOf = this.f11091c.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11091c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i5) {
        if (hasStableIds()) {
            return n(i5).q();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        c cVar = new c(n(i5));
        int iIndexOf = this.f11092d.indexOf(cVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.f11092d.size();
        this.f11092d.add(cVar);
        return size;
    }

    public Preference n(int i5) {
        if (i5 < 0 || i5 >= getItemCount()) {
            return null;
        }
        return this.f11091c.get(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l lVar, int i5) {
        Preference preferenceN = n(i5);
        lVar.d();
        preferenceN.W(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(ViewGroup viewGroup, int i5) {
        c cVar = this.f11092d.get(i5);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, s.f11211a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(s.f11214b);
        if (drawable == null) {
            drawable = C0744a.b(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(cVar.f11098a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            H.o0(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i6 = cVar.f11099b;
            if (i6 != 0) {
                layoutInflaterFrom.inflate(i6, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(viewInflate);
    }

    void t() {
        Iterator<Preference> it = this.f11090b.iterator();
        while (it.hasNext()) {
            it.next().A0(null);
        }
        ArrayList arrayList = new ArrayList(this.f11090b.size());
        this.f11090b = arrayList;
        l(arrayList, this.f11089a);
        this.f11091c = k(this.f11089a);
        j jVarE = this.f11089a.E();
        if (jVarE != null) {
            jVarE.i();
        }
        notifyDataSetChanged();
        Iterator<Preference> it2 = this.f11090b.iterator();
        while (it2.hasNext()) {
            it2.next().e();
        }
    }
}
