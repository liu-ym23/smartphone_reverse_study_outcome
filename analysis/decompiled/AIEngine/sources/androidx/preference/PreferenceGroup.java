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
import android.view.AbsSavedState;
import androidx.preference.Preference;
import androidx.preference.b;
import java.util.ArrayList;
import java.util.Collections;
import p.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final o<String, Long> R;
    public final Handler S;
    public final ArrayList T;
    public boolean U;
    public int V;
    public boolean W;
    public int X;
    public final a Y;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                PreferenceGroup.this.R.clear();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        int a(Preference preference);

        int b(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.R = new o<>();
        this.S = new Handler(Looper.getMainLooper());
        this.U = true;
        this.V = 0;
        this.W = false;
        this.X = Integer.MAX_VALUE;
        this.Y = new a();
        this.T = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2434i, i10, 0);
        this.U = typedArrayObtainStyledAttributes.getBoolean(2, typedArrayObtainStyledAttributes.getBoolean(2, true));
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            int i12 = typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, Integer.MAX_VALUE));
            if (i12 != Integer.MAX_VALUE && TextUtils.isEmpty(this.f2357o)) {
                Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
            }
            this.X = i12;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void B(Preference preference) {
        long jLongValue;
        if (this.T.contains(preference)) {
            return;
        }
        if (preference.f2357o != null) {
            PreferenceGroup preferenceGroup = this;
            while (true) {
                PreferenceGroup preferenceGroup2 = preferenceGroup.M;
                if (preferenceGroup2 == null) {
                    break;
                } else {
                    preferenceGroup = preferenceGroup2;
                }
            }
            String str = preference.f2357o;
            if (preferenceGroup.C(str) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + str + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        int i10 = preference.f2352j;
        if (i10 == Integer.MAX_VALUE) {
            if (this.U) {
                int i11 = this.V;
                this.V = i11 + 1;
                if (i11 != i10) {
                    preference.f2352j = i11;
                    androidx.preference.b bVar = preference.K;
                    if (bVar != null) {
                        Handler handler = bVar.f2394e;
                        b.a aVar = bVar.f2395f;
                        handler.removeCallbacks(aVar);
                        handler.post(aVar);
                    }
                }
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).U = this.U;
            }
        }
        int iBinarySearch = Collections.binarySearch(this.T, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        boolean zY = y();
        if (preference.z == zY) {
            preference.z = !zY;
            preference.k(preference.y());
            preference.j();
        }
        synchronized (this) {
            this.T.add(iBinarySearch, preference);
        }
        f fVar = this.f2348b;
        String str2 = preference.f2357o;
        if (str2 == null || !this.R.containsKey(str2)) {
            synchronized (fVar) {
                jLongValue = fVar.f2410b;
                fVar.f2410b = 1 + jLongValue;
            }
        } else {
            jLongValue = this.R.get(str2).longValue();
            this.R.remove(str2);
        }
        preference.f2349c = jLongValue;
        preference.f2350d = true;
        try {
            preference.m(fVar);
            preference.f2350d = false;
            if (preference.M != null) {
                throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
            }
            preference.M = this;
            if (this.W) {
                preference.l();
            }
            androidx.preference.b bVar2 = this.K;
            if (bVar2 != null) {
                Handler handler2 = bVar2.f2394e;
                b.a aVar2 = bVar2.f2395f;
                handler2.removeCallbacks(aVar2);
                handler2.post(aVar2);
            }
        } catch (Throwable th) {
            preference.f2350d = false;
            throw th;
        }
    }

    public final <T extends Preference> T C(CharSequence charSequence) {
        T t8;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(this.f2357o, charSequence)) {
            return this;
        }
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            PreferenceGroup preferenceGroup = (T) D(i10);
            if (TextUtils.equals(preferenceGroup.f2357o, charSequence)) {
                return preferenceGroup;
            }
            if ((preferenceGroup instanceof PreferenceGroup) && (t8 = (T) preferenceGroup.C(charSequence)) != null) {
                return t8;
            }
        }
        return null;
    }

    public final Preference D(int i10) {
        return (Preference) this.T.get(i10);
    }

    public final void E(Preference preference) {
        synchronized (this) {
            try {
                preference.A();
                if (preference.M == this) {
                    preference.M = null;
                }
                if (this.T.remove(preference)) {
                    String str = preference.f2357o;
                    if (str != null) {
                        this.R.put(str, Long.valueOf(preference.e()));
                        this.S.removeCallbacks(this.Y);
                        this.S.post(this.Y);
                    }
                    if (this.W) {
                        preference.p();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        androidx.preference.b bVar = this.K;
        if (bVar != null) {
            Handler handler = bVar.f2394e;
            b.a aVar = bVar.f2395f;
            handler.removeCallbacks(aVar);
            handler.post(aVar);
        }
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            D(i10).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void c(Bundle bundle) {
        super.c(bundle);
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            D(i10).c(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void k(boolean z) {
        super.k(z);
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preferenceD = D(i10);
            if (preferenceD.z == z) {
                preferenceD.z = !z;
                preferenceD.k(preferenceD.y());
                preferenceD.j();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void l() {
        super.l();
        this.W = true;
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            D(i10).l();
        }
    }

    @Override // androidx.preference.Preference
    public final void p() {
        A();
        this.W = false;
        int size = this.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            D(i10).p();
        }
    }

    @Override // androidx.preference.Preference
    public final void r(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.X = savedState.mInitialExpandedChildrenCount;
        super.r(savedState.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable s() {
        this.N = true;
        return new SavedState(AbsSavedState.EMPTY_STATE, this.X);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int mInitialExpandedChildrenCount;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mInitialExpandedChildrenCount = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mInitialExpandedChildrenCount);
        }

        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.mInitialExpandedChildrenCount = i10;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }
}
