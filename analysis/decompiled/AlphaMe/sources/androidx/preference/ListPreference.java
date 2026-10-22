package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] T;

    /* renamed from: U, reason: collision with root package name */
    public final CharSequence[] f4054U;

    /* renamed from: V, reason: collision with root package name */
    public String f4055V;

    /* renamed from: W, reason: collision with root package name */
    public String f4056W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f4057X;

    public ListPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        int i5 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4045e, i4, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.T = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.f4054U = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        if (typedArrayObtainStyledAttributes.getBoolean(7, typedArrayObtainStyledAttributes.getBoolean(7, false))) {
            if (E3.b.f410b == null) {
                E3.b.f410b = new E3.b(i5);
            }
            this.f4075L = E3.b.f410b;
            h();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, L.f4047g, i4, 0);
        this.f4056W = Z2.I.s(typedArrayObtainStyledAttributes2, 33, 7);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final CharSequence A() {
        CharSequence[] charSequenceArr;
        int iZ = z(this.f4055V);
        if (iZ < 0 || (charSequenceArr = this.T) == null) {
            return null;
        }
        return charSequenceArr[iZ];
    }

    public final void B(String str) {
        boolean z4 = !TextUtils.equals(this.f4055V, str);
        if (z4 || !this.f4057X) {
            this.f4055V = str;
            this.f4057X = true;
            t(str);
            if (z4) {
                h();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final CharSequence f() {
        r rVar = this.f4075L;
        if (rVar != null) {
            return rVar.b(this);
        }
        CharSequence charSequenceA = A();
        CharSequence charSequenceF = super.f();
        String str = this.f4056W;
        if (str == null) {
            return charSequenceF;
        }
        Object[] objArr = new Object[1];
        if (charSequenceA == null) {
            charSequenceA = "";
        }
        objArr[0] = charSequenceA;
        String str2 = String.format(str, objArr);
        if (TextUtils.equals(str2, charSequenceF)) {
            return charSequenceF;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
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
        B(savedState.f4058a);
    }

    @Override // androidx.preference.Preference
    public final Parcelable q() {
        this.f4073J = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f4094r) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.f4058a = this.f4055V;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void r(Object obj) {
        B(e((String) obj));
    }

    @Override // androidx.preference.Preference
    public final void v(CharSequence charSequence) {
        super.v(charSequence);
        if (charSequence == null) {
            this.f4056W = null;
        } else {
            this.f4056W = charSequence.toString();
        }
    }

    public final int z(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f4054U) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0335g();

        /* renamed from: a, reason: collision with root package name */
        public String f4058a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4058a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f4058a);
        }

        public SavedState(AbsSavedState absSavedState) {
            super(absSavedState);
        }
    }

    public ListPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, Z2.I.m(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
