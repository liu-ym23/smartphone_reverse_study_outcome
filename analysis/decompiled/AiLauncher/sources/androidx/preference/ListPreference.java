package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: g, reason: collision with root package name */
    public CharSequence[] f14328g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence[] f14329h;

    /* renamed from: i, reason: collision with root package name */
    public String f14330i;

    /* renamed from: j, reason: collision with root package name */
    public String f14331j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14332k;

    public static final class a implements Preference.f<ListPreference> {

        /* renamed from: a, reason: collision with root package name */
        public static a f14333a;

        public static a b() {
            if (f14333a == null) {
                f14333a = new a();
            }
            return f14333a;
        }

        @Override // androidx.preference.Preference.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.m()) ? listPreference.getContext().getString(R$string.not_set) : listPreference.m();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPreference, i10, i11);
        this.f14328g = s0.k.o(typedArrayObtainStyledAttributes, R$styleable.ListPreference_entries, R$styleable.ListPreference_android_entries);
        this.f14329h = s0.k.o(typedArrayObtainStyledAttributes, R$styleable.ListPreference_entryValues, R$styleable.ListPreference_android_entryValues);
        int i12 = R$styleable.ListPreference_useSimpleSummaryProvider;
        if (s0.k.b(typedArrayObtainStyledAttributes, i12, i12, false)) {
            setSummaryProvider(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i10, i11);
        this.f14331j = s0.k.m(typedArrayObtainStyledAttributes2, R$styleable.Preference_summary, R$styleable.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().a(this);
        }
        CharSequence charSequenceM = m();
        CharSequence summary = super.getSummary();
        String str = this.f14331j;
        if (str != null) {
            if (charSequenceM == null) {
                charSequenceM = "";
            }
            String str2 = String.format(str, charSequenceM);
            if (!TextUtils.equals(str2, summary)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return summary;
    }

    public int k(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f14329h) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f14329h[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] l() {
        return this.f14328g;
    }

    public CharSequence m() {
        CharSequence[] charSequenceArr;
        int iP = p();
        if (iP < 0 || (charSequenceArr = this.f14328g) == null) {
            return null;
        }
        return charSequenceArr[iP];
    }

    public CharSequence[] n() {
        return this.f14329h;
    }

    public String o() {
        return this.f14330i;
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        q(savedState.mValue);
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.mValue = o();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        q(getPersistedString((String) obj));
    }

    public final int p() {
        return k(this.f14330i);
    }

    public void q(String str) {
        boolean zEquals = TextUtils.equals(this.f14330i, str);
        if (zEquals && this.f14332k) {
            return;
        }
        this.f14330i = str;
        this.f14332k = true;
        persistString(str);
        if (zEquals) {
            return;
        }
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null) {
            this.f14331j = null;
        } else {
            this.f14331j = charSequence.toString();
        }
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String mValue;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
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

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, s0.k.a(context, R$attr.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }
}
