package androidx.preference;

import K.S;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class C extends RecyclerView.Adapter implements InterfaceC0343o, z {
    private final PreferenceGroup mPreferenceGroup;
    private final List<B> mPreferenceResourceDescriptors;
    private List<Preference> mPreferences;
    private List<Preference> mVisiblePreferences;
    private final Runnable mSyncRunnable = new u(3, this);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public C(PreferenceGroup preferenceGroup) {
        this.mPreferenceGroup = preferenceGroup;
        preferenceGroup.f4070G = this;
        this.mPreferences = new ArrayList();
        this.mVisiblePreferences = new ArrayList();
        this.mPreferenceResourceDescriptors = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).T);
        } else {
            setHasStableIds(true);
        }
        updatePreferences();
    }

    public static boolean c(PreferenceGroup preferenceGroup) {
        return preferenceGroup.f4108S != Integer.MAX_VALUE;
    }

    public final ArrayList a(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.f4104O.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Preference preferenceA = preferenceGroup.A(i5);
            if (preferenceA.f4099w) {
                if (!c(preferenceGroup) || i4 < preferenceGroup.f4108S) {
                    arrayList.add(preferenceA);
                } else {
                    arrayList2.add(preferenceA);
                }
                if (preferenceA instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceA;
                    if (!(!(preferenceGroup2 instanceof PreferenceScreen))) {
                        continue;
                    } else {
                        if (c(preferenceGroup) && c(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        Iterator it = a(preferenceGroup2).iterator();
                        while (it.hasNext()) {
                            Preference preference = (Preference) it.next();
                            if (!c(preferenceGroup) || i4 < preferenceGroup.f4108S) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i4++;
                        }
                    }
                } else {
                    i4++;
                }
            }
        }
        if (c(preferenceGroup) && i4 > preferenceGroup.f4108S) {
            long j4 = preferenceGroup.f4079c;
            CharSequence string = null;
            C0334f c0334f = new C0334f(preferenceGroup.f4077a, null);
            c0334f.f4068E = R.layout.expand_button;
            Context context = c0334f.f4077a;
            Drawable drawableO = Z2.I.o(context, R.drawable.ic_arrow_down_24dp);
            if (c0334f.f4087k != drawableO) {
                c0334f.f4087k = drawableO;
                c0334f.f4086j = 0;
                c0334f.h();
            }
            c0334f.f4086j = R.drawable.ic_arrow_down_24dp;
            String string2 = context.getString(R.string.expand_button_title);
            if (!TextUtils.equals(string2, c0334f.f4084h)) {
                c0334f.f4084h = string2;
                c0334f.h();
            }
            if (999 != c0334f.f4083g) {
                c0334f.f4083g = androidx.room.A.MAX_BIND_PARAMETER_CNT;
                InterfaceC0343o interfaceC0343o = c0334f.f4070G;
                if (interfaceC0343o != null) {
                    interfaceC0343o.onPreferenceHierarchyChange(c0334f);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Preference preference2 = (Preference) it2.next();
                CharSequence charSequence = preference2.f4084h;
                boolean z4 = preference2 instanceof PreferenceGroup;
                if (z4 && !TextUtils.isEmpty(charSequence)) {
                    arrayList3.add((PreferenceGroup) preference2);
                }
                if (arrayList3.contains(preference2.f4072I)) {
                    if (z4) {
                        arrayList3.add((PreferenceGroup) preference2);
                    }
                } else if (!TextUtils.isEmpty(charSequence)) {
                    string = string == null ? charSequence : context.getString(R.string.summary_collapsed_preference_list, string, charSequence);
                }
            }
            c0334f.v(string);
            c0334f.f4141N = j4 + 1000000;
            c0334f.f4082f = new B0.m(3, this, preferenceGroup);
            arrayList.add(c0334f);
        }
        return arrayList;
    }

    public final void b(PreferenceGroup preferenceGroup, ArrayList arrayList) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.f4104O);
        }
        int size = preferenceGroup.f4104O.size();
        for (int i4 = 0; i4 < size; i4++) {
            Preference preferenceA = preferenceGroup.A(i4);
            arrayList.add(preferenceA);
            B b4 = new B(preferenceA);
            if (!this.mPreferenceResourceDescriptors.contains(b4)) {
                this.mPreferenceResourceDescriptors.add(b4);
            }
            if (preferenceA instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceA;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    b(preferenceGroup2, arrayList);
                }
            }
            preferenceA.f4070G = this;
        }
    }

    @Nullable
    public Preference getItem(int i4) {
        if (i4 < 0 || i4 >= getItemCount()) {
            return null;
        }
        return this.mVisiblePreferences.get(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        if (hasStableIds()) {
            return getItem(i4).d();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        B b4 = new B(getItem(i4));
        int iIndexOf = this.mPreferenceResourceDescriptors.indexOf(b4);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.mPreferenceResourceDescriptors.size();
        this.mPreferenceResourceDescriptors.add(b4);
        return size;
    }

    @Override // androidx.preference.z
    public int getPreferenceAdapterPosition(@NonNull String str) {
        int size = this.mVisiblePreferences.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (TextUtils.equals(str, this.mVisiblePreferences.get(i4).f4088l)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // androidx.preference.InterfaceC0343o
    public void onPreferenceChange(@NonNull Preference preference) {
        int iIndexOf = this.mVisiblePreferences.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.InterfaceC0343o
    public void onPreferenceHierarchyChange(@NonNull Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    @Override // androidx.preference.InterfaceC0343o
    public void onPreferenceVisibilityChange(@NonNull Preference preference) {
        onPreferenceHierarchyChange(preference);
    }

    public void updatePreferences() {
        Iterator<Preference> it = this.mPreferences.iterator();
        while (it.hasNext()) {
            it.next().f4070G = null;
        }
        ArrayList arrayList = new ArrayList(this.mPreferences.size());
        this.mPreferences = arrayList;
        b(this.mPreferenceGroup, arrayList);
        this.mVisiblePreferences = a(this.mPreferenceGroup);
        H h4 = this.mPreferenceGroup.f4078b;
        notifyDataSetChanged();
        Iterator<Preference> it2 = this.mPreferences.iterator();
        while (it2.hasNext()) {
            it2.next().getClass();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(K k4, int i4) {
        ColorStateList colorStateList;
        Preference item = getItem(i4);
        Drawable background = k4.itemView.getBackground();
        Drawable drawable = k4.f4036a;
        if (background != drawable) {
            View view = k4.itemView;
            WeakHashMap weakHashMap = S.f939a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) k4.a(android.R.id.title);
        if (textView != null && (colorStateList = k4.f4037b) != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        item.l(k4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public K onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        B b4 = this.mPreferenceResourceDescriptors.get(i4);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, L.f4041a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = Z2.I.o(viewGroup.getContext(), android.R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(b4.f4002a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            WeakHashMap weakHashMap = S.f939a;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(android.R.id.widget_frame);
        if (viewGroup2 != null) {
            int i5 = b4.f4003b;
            if (i5 != 0) {
                layoutInflaterFrom.inflate(i5, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new K(viewInflate);
    }

    @Override // androidx.preference.z
    public int getPreferenceAdapterPosition(@NonNull Preference preference) {
        int size = this.mVisiblePreferences.size();
        for (int i4 = 0; i4 < size; i4++) {
            Preference preference2 = this.mVisiblePreferences.get(i4);
            if (preference2 != null && preference2.equals(preference)) {
                return i4;
            }
        }
        return -1;
    }
}
