package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    private static final String TAG = "ListPreference";
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mSummary;
    private String mValue;
    private boolean mValueSet;

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String mValue;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r1) {
            super(r1);
            this.mValue = r1.readString();
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.mValue);
        }
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        @Override // androidx.preference.Preference.SummaryProvider
        public /* bridge */ /* synthetic */ CharSequence provideSummary(Preference r1) {
            return provideSummary((ListPreference) r1);
        }

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider != null) goto L6;
            sSimpleSummaryProvider = new SimpleSummaryProvider();
        L6:
            return sSimpleSummaryProvider;
        }

        public CharSequence provideSummary(ListPreference r1) {
            if (TextUtils.isEmpty(r1.getEntry()) == false) goto L7;
            return r1.getContext().getString(R.string.not_set);
        L7:
            return r1.getEntry();
        }
    }

    public ListPreference(Context r5, AttributeSet r6, int r7, int r8) {
        super(r5, r6, r7, r8);
        TypedArray r0 = r5.obtainStyledAttributes(r6, R.styleable.ListPreference, r7, r8);
        this.mEntries = TypedArrayUtils.getTextArray(r0, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.mEntryValues = TypedArrayUtils.getTextArray(r0, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        if (TypedArrayUtils.getBoolean(r0, R.styleable.ListPreference_useSimpleSummaryProvider, R.styleable.ListPreference_useSimpleSummaryProvider, false) == false) goto L5;
        setSummaryProvider(SimpleSummaryProvider.getInstance());
    L5:
        r0.recycle();
        TypedArray r9 = r5.obtainStyledAttributes(r6, R.styleable.Preference, r7, r8);
        this.mSummary = TypedArrayUtils.getString(r9, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        r9.recycle();
    }

    public ListPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ListPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context r2) {
        this(r2, null);
    }

    public void setEntries(CharSequence[] r1) {
        this.mEntries = r1;
    }

    public void setEntries(int r2) {
        setEntries(getContext().getResources().getTextArray(r2));
    }

    public CharSequence[] getEntries() {
        return this.mEntries;
    }

    public void setEntryValues(CharSequence[] r1) {
        this.mEntryValues = r1;
    }

    public void setEntryValues(int r2) {
        setEntryValues(getContext().getResources().getTextArray(r2));
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence r1) {
        super.setSummary(r1);
        if (r1 != null) goto L5;
        this.mSummary = null;
        return;
    L5:
        this.mSummary = r1.toString();
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        if (getSummaryProvider() != null) goto L5;
        CharSequence r0 = getEntry();
        CharSequence r1 = super.getSummary();
        String r4 = this.mSummary;
        if (r4 != null) goto L9;
        return r1;
    L9:
        Object[] r2 = new Object[1];
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        r2[0] = r0;
        String r5 = String.format(r4, r2);
        if (TextUtils.equals(r5, r1) == false) goto L15;
        return r1;
    L15:
        Log.w(TAG, "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return r5;
    L5:
        return getSummaryProvider().provideSummary(this);
    }

    public void setValue(String r4) {
        boolean r0 = !TextUtils.equals(this.mValue, r4);
        if (r0 == false) goto L5;
    L6:
        this.mValue = r4;
        this.mValueSet = true;
        persistString(r4);
        if (r0 == false) goto L11;
        notifyChanged();
        return;
    L11:
        return;
    L5:
        if (this.mValueSet == false) goto L6;
    }

    public String getValue() {
        return this.mValue;
    }

    public CharSequence getEntry() {
        int r0 = getValueIndex();
        if (r0 < 0) goto L7;
        CharSequence[] r1 = this.mEntries;
        if (r1 == null) goto L7;
        return r1[r0];
    L7:
        return null;
    }

    public int findIndexOfValue(String r3) {
        if (r3 == null) goto L11;
        CharSequence[] r0 = this.mEntryValues;
        if (r0 == null) goto L15;
        int r1 = r0.length - 1;
    L6:
        if (r1 < 0) goto L16;
        if (TextUtils.equals(this.mEntryValues[r1].toString(), r3) == true) goto L9;
        r1 = r1 - 1;
        goto L6
    L9:
        return r1;
    L16:
        return -1;
    L15:
        return -1;
    L11:
        return -1;
    }

    public void setValueIndex(int r2) {
        CharSequence[] r0 = this.mEntryValues;
        if (r0 == null) goto L6;
        setValue(r0[r2].toString());
        return;
    }

    private int getValueIndex() {
        return findIndexOfValue(this.mValue);
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return r1.getString(r2);
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object r1) {
        setValue(getPersistedString((String) r1));
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.mValue = getValue();
        return r1;
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable r3) {
        if (r3 != null) goto L4;
    L8:
        super.onRestoreInstanceState(r3);
        return;
    L4:
        if (r3.getClass().equals(SavedState.class) == false) goto L8;
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        setValue(r4.mValue);
    }
}
