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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: N, reason: collision with root package name */
    public final q.l f4103N;

    /* renamed from: O, reason: collision with root package name */
    public final ArrayList f4104O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f4105P;

    /* renamed from: Q, reason: collision with root package name */
    public int f4106Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f4107R;

    /* renamed from: S, reason: collision with root package name */
    public int f4108S;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 0);
        this.f4103N = new q.l(0);
        new Handler(Looper.getMainLooper());
        this.f4105P = true;
        this.f4106Q = 0;
        this.f4107R = false;
        this.f4108S = Integer.MAX_VALUE;
        this.f4104O = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4049i, i4, 0);
        this.f4105P = typedArrayObtainStyledAttributes.getBoolean(2, typedArrayObtainStyledAttributes.getBoolean(2, true));
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            C(typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, Integer.MAX_VALUE)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final Preference A(int i4) {
        return (Preference) this.f4104O.get(i4);
    }

    public final int B() {
        return this.f4104O.size();
    }

    public final void C(int i4) {
        if (i4 != Integer.MAX_VALUE && !(!TextUtils.isEmpty(this.f4088l))) {
            Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
        }
        this.f4108S = i4;
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int size = this.f4104O.size();
        for (int i4 = 0; i4 < size; i4++) {
            A(i4).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void c(Bundle bundle) {
        super.c(bundle);
        int size = this.f4104O.size();
        for (int i4 = 0; i4 < size; i4++) {
            A(i4).c(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void i(boolean z4) {
        super.i(z4);
        int size = this.f4104O.size();
        for (int i4 = 0; i4 < size; i4++) {
            Preference preferenceA = A(i4);
            if (preferenceA.f4098v == z4) {
                preferenceA.f4098v = !z4;
                preferenceA.i(preferenceA.w());
                preferenceA.h();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void j() {
        super.j();
        this.f4107R = true;
        int iB = B();
        for (int i4 = 0; i4 < iB; i4++) {
            A(i4).j();
        }
    }

    @Override // androidx.preference.Preference
    public final void n() {
        super.n();
        this.f4107R = false;
        int size = this.f4104O.size();
        for (int i4 = 0; i4 < size; i4++) {
            A(i4).n();
        }
    }

    @Override // androidx.preference.Preference
    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.p(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f4108S = savedState.f4109a;
        super.p(savedState.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable q() {
        this.f4073J = true;
        return new SavedState(AbsSavedState.EMPTY_STATE, this.f4108S);
    }

    public final Preference z(CharSequence charSequence) {
        Preference preferenceZ;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(this.f4088l, charSequence)) {
            return this;
        }
        int iB = B();
        for (int i4 = 0; i4 < iB; i4++) {
            Preference preferenceA = A(i4);
            if (TextUtils.equals(preferenceA.f4088l, charSequence)) {
                return preferenceA;
            }
            if ((preferenceA instanceof PreferenceGroup) && (preferenceZ = ((PreferenceGroup) preferenceA).z(charSequence)) != null) {
                return preferenceZ;
            }
        }
        return null;
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new A();

        /* renamed from: a, reason: collision with root package name */
        public final int f4109a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4109a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f4109a);
        }

        public SavedState(AbsSavedState absSavedState, int i4) {
            super(absSavedState);
            this.f4109a = i4;
        }
    }

    public PreferenceGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
