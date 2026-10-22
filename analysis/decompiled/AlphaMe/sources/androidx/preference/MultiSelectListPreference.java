package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import com.stepos.alphame.R;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final CharSequence[] T;

    /* renamed from: U, reason: collision with root package name */
    public final CharSequence[] f4060U;

    /* renamed from: V, reason: collision with root package name */
    public final HashSet f4061V;

    /* JADX WARN: Illegal instructions before constructor call */
    public MultiSelectListPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int iM = Z2.I.m(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle);
        super(context, attributeSet, iM);
        this.f4061V = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4046f, iM, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.T = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.f4060U = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object o(TypedArray typedArray, int i4) {
        CharSequence[] textArray = typedArray.getTextArray(i4);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.p(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.p(savedState.getSuperState());
        z(savedState.f4062a);
    }

    @Override // androidx.preference.Preference
    public final Parcelable q() {
        this.f4073J = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f4094r) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.f4062a = this.f4061V;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void r(Object obj) {
        Set<String> stringSet = (Set) obj;
        if (x()) {
            stringSet = this.f4078b.b().getStringSet(this.f4088l, stringSet);
        }
        z(stringSet);
    }

    public final void z(Set set) {
        HashSet hashSet = this.f4061V;
        hashSet.clear();
        hashSet.addAll(set);
        if (x()) {
            if (!set.equals(x() ? this.f4078b.b().getStringSet(this.f4088l, null) : null)) {
                SharedPreferences.Editor editorA = this.f4078b.a();
                editorA.putStringSet(this.f4088l, set);
                y(editorA);
            }
        }
        h();
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0338j();

        /* renamed from: a, reason: collision with root package name */
        public HashSet f4062a;

        public SavedState(Parcel parcel) {
            super(parcel);
            int i4 = parcel.readInt();
            this.f4062a = new HashSet();
            String[] strArr = new String[i4];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f4062a, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f4062a.size());
            HashSet hashSet = this.f4062a;
            parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
        }

        public SavedState(AbsSavedState absSavedState) {
            super(absSavedState);
        }
    }
}
