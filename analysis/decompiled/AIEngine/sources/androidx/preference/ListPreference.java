package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import androidx.preference.Preference;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] X;
    public final CharSequence[] Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f2343a0;
    public boolean b0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Preference.c<ListPreference> {

        /* renamed from: a, reason: collision with root package name */
        public static a f2344a;

        @Override // androidx.preference.Preference.c
        public final CharSequence a(Preference preference) {
            ListPreference listPreference = (ListPreference) preference;
            CharSequence[] charSequenceArr = listPreference.X;
            int iB = listPreference.B(listPreference.Z);
            if (TextUtils.isEmpty((iB < 0 || charSequenceArr == null) ? null : charSequenceArr[iB])) {
                return listPreference.f2347a.getString(R.string.not_set);
            }
            int iB2 = listPreference.B(listPreference.Z);
            if (iB2 < 0 || charSequenceArr == null) {
                return null;
            }
            return charSequenceArr[iB2];
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2431e, i10, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.X = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.Y = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        if (typedArrayObtainStyledAttributes.getBoolean(7, typedArrayObtainStyledAttributes.getBoolean(7, false))) {
            if (a.f2344a == null) {
                a.f2344a = new a();
            }
            this.P = a.f2344a;
            j();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, i.f2433g, i10, 0);
        String string = typedArrayObtainStyledAttributes2.getString(33);
        this.f2343a0 = string == null ? typedArrayObtainStyledAttributes2.getString(7) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final int B(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.Y) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final void C(String str) {
        boolean zEquals = TextUtils.equals(this.Z, str);
        if (zEquals && this.b0) {
            return;
        }
        this.Z = str;
        this.b0 = true;
        v(str);
        if (zEquals) {
            return;
        }
        j();
    }

    @Override // androidx.preference.Preference
    public final CharSequence h() {
        CharSequence[] charSequenceArr;
        Preference.c cVar = this.P;
        if (cVar != null) {
            return cVar.a(this);
        }
        int iB = B(this.Z);
        CharSequence charSequence = (iB < 0 || (charSequenceArr = this.X) == null) ? null : charSequenceArr[iB];
        CharSequence charSequenceH = super.h();
        String str = this.f2343a0;
        if (str != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            String str2 = String.format(str, charSequence);
            if (!TextUtils.equals(str2, charSequenceH)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceH;
    }

    @Override // androidx.preference.Preference
    public final Object q(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // androidx.preference.Preference
    public final void r(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.r(savedState.getSuperState());
        C(savedState.mValue);
    }

    @Override // androidx.preference.Preference
    public final Parcelable s() {
        this.N = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f2363v) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.mValue = this.Z;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void t(Object obj) {
        C(g((String) obj));
    }

    @Override // androidx.preference.Preference
    public final void x(CharSequence charSequence) {
        super.x(charSequence);
        if (charSequence == null) {
            this.f2343a0 = null;
        } else {
            this.f2343a0 = ((String) charSequence).toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String mValue;

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
            this.mValue = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.mValue);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.g.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
