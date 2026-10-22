package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: T, reason: collision with root package name */
    final q.i<String, Long> f11009T;

    /* renamed from: U, reason: collision with root package name */
    private final Handler f11010U;

    /* renamed from: V, reason: collision with root package name */
    private final List<Preference> f11011V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f11012W;

    /* renamed from: X, reason: collision with root package name */
    private int f11013X;

    /* renamed from: Y, reason: collision with root package name */
    private boolean f11014Y;

    /* renamed from: Z, reason: collision with root package name */
    private int f11015Z;

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f11016a0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f11009T.clear();
            }
        }
    }

    public interface b {
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f11009T = new q.i<>();
        this.f11010U = new Handler(Looper.getMainLooper());
        this.f11012W = true;
        this.f11013X = 0;
        this.f11014Y = false;
        this.f11015Z = Integer.MAX_VALUE;
        this.f11016a0 = new a();
        this.f11011V = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11160A0, i5, i6);
        int i7 = s.f11164C0;
        this.f11012W = androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i7, i7, true);
        int i8 = s.f11162B0;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            c1(androidx.core.content.res.k.d(typedArrayObtainStyledAttributes, i8, i8, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean b1(Preference preference) {
        boolean zRemove;
        synchronized (this) {
            try {
                preference.d0();
                if (preference.v() == this) {
                    preference.b(null);
                }
                zRemove = this.f11011V.remove(preference);
                if (zRemove) {
                    String strS = preference.s();
                    if (strS != null) {
                        this.f11009T.put(strS, Long.valueOf(preference.q()));
                        this.f11010U.removeCallbacks(this.f11016a0);
                        this.f11010U.post(this.f11016a0);
                    }
                    if (this.f11014Y) {
                        preference.Z();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zRemove;
    }

    @Override // androidx.preference.Preference
    public void R(boolean z5) {
        super.R(z5);
        int iX0 = X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            W0(i5).c0(this, z5);
        }
    }

    public void R0(Preference preference) {
        S0(preference);
    }

    public boolean S0(Preference preference) {
        long jF;
        if (this.f11011V.contains(preference)) {
            return true;
        }
        if (preference.s() != null) {
            PreferenceGroup preferenceGroupV = this;
            while (preferenceGroupV.v() != null) {
                preferenceGroupV = preferenceGroupV.v();
            }
            String strS = preference.s();
            if (preferenceGroupV.T0(strS) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + strS + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.u() == Integer.MAX_VALUE) {
            if (this.f11012W) {
                int i5 = this.f11013X;
                this.f11013X = i5 + 1;
                preference.D0(i5);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).d1(this.f11012W);
            }
        }
        int iBinarySearch = Collections.binarySearch(this.f11011V, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        if (!Z0(preference)) {
            return false;
        }
        synchronized (this) {
            this.f11011V.add(iBinarySearch, preference);
        }
        j jVarE = E();
        String strS2 = preference.s();
        if (strS2 == null || !this.f11009T.containsKey(strS2)) {
            jF = jVarE.f();
        } else {
            jF = this.f11009T.get(strS2).longValue();
            this.f11009T.remove(strS2);
        }
        preference.V(jVarE, jF);
        preference.b(this);
        if (this.f11014Y) {
            preference.T();
        }
        S();
        return true;
    }

    @Override // androidx.preference.Preference
    public void T() {
        super.T();
        this.f11014Y = true;
        int iX0 = X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            W0(i5).T();
        }
    }

    public <T extends Preference> T T0(CharSequence charSequence) {
        T t5;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(s(), charSequence)) {
            return this;
        }
        int iX0 = X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            PreferenceGroup preferenceGroup = (T) W0(i5);
            if (TextUtils.equals(preferenceGroup.s(), charSequence)) {
                return preferenceGroup;
            }
            if ((preferenceGroup instanceof PreferenceGroup) && (t5 = (T) preferenceGroup.T0(charSequence)) != null) {
                return t5;
            }
        }
        return null;
    }

    public int U0() {
        return this.f11015Z;
    }

    public b V0() {
        return null;
    }

    public Preference W0(int i5) {
        return this.f11011V.get(i5);
    }

    public int X0() {
        return this.f11011V.size();
    }

    protected boolean Y0() {
        return true;
    }

    @Override // androidx.preference.Preference
    public void Z() {
        super.Z();
        this.f11014Y = false;
        int iX0 = X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            W0(i5).Z();
        }
    }

    protected boolean Z0(Preference preference) {
        preference.c0(this, M0());
        return true;
    }

    public boolean a1(Preference preference) {
        boolean zB1 = b1(preference);
        S();
        return zB1;
    }

    public void c1(int i5) {
        if (i5 != Integer.MAX_VALUE && !K()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f11015Z = i5;
    }

    public void d1(boolean z5) {
        this.f11012W = z5;
    }

    @Override // androidx.preference.Preference
    protected void e0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(c.class)) {
            super.e0(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        this.f11015Z = cVar.f11018a;
        super.e0(cVar.getSuperState());
    }

    void e1() {
        synchronized (this) {
            Collections.sort(this.f11011V);
        }
    }

    @Override // androidx.preference.Preference
    protected Parcelable f0() {
        return new c(super.f0(), this.f11015Z);
    }

    @Override // androidx.preference.Preference
    protected void h(Bundle bundle) {
        super.h(bundle);
        int iX0 = X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            W0(i5).h(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void i(Bundle bundle) {
        super.i(bundle);
        int iX0 = X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            W0(i5).i(bundle);
        }
    }

    static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f11018a;

        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i5) {
                return new c[i5];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f11018a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f11018a);
        }

        c(Parcelable parcelable, int i5) {
            super(parcelable);
            this.f11018a = i5;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
