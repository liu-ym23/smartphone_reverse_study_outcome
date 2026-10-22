package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String T;

    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int iM = Z2.I.m(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iM);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4044d, iM, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, typedArrayObtainStyledAttributes.getBoolean(0, false))) {
            if (y1.f.f16201b == null) {
                y1.f.f16201b = new y1.f();
            }
            this.f4075L = y1.f.f16201b;
            h();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object o(TypedArray typedArray, int i4) {
        return typedArray.getString(i4);
    }

    @Override // androidx.preference.Preference
    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.p(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.p(savedState.getSuperState());
        z(savedState.f4021a);
    }

    @Override // androidx.preference.Preference
    public final Parcelable q() {
        this.f4073J = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f4094r) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.f4021a = this.T;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void r(Object obj) {
        z(e((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean w() {
        return TextUtils.isEmpty(this.T) || super.w();
    }

    public final void z(String str) {
        boolean zW = w();
        this.T = str;
        t(str);
        boolean zW2 = w();
        if (zW2 != zW) {
            i(zW2);
        }
        h();
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0332d();

        /* renamed from: a, reason: collision with root package name */
        public String f4021a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4021a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f4021a);
        }

        public SavedState(AbsSavedState absSavedState) {
            super(absSavedState);
        }
    }
}
