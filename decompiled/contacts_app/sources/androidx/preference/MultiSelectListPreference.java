package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private Set<String> mValues;

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Set<String> mValues;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r3) {
            super(r3);
            int r0 = r3.readInt();
            this.mValues = new HashSet();
            String[] r1 = new String[r0];
            r3.readStringArray(r1);
            Collections.addAll(this.mValues, r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.mValues.size());
            Set<String> r0 = this.mValues;
            r1.writeStringArray((String[]) r0.toArray(new String[r0.size()]));
        }
    }

    public MultiSelectListPreference(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mValues = new HashSet();
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.MultiSelectListPreference, r4, r5);
        this.mEntries = TypedArrayUtils.getTextArray(r6, R.styleable.MultiSelectListPreference_entries, R.styleable.MultiSelectListPreference_android_entries);
        this.mEntryValues = TypedArrayUtils.getTextArray(r6, R.styleable.MultiSelectListPreference_entryValues, R.styleable.MultiSelectListPreference_android_entryValues);
        r6.recycle();
    }

    public MultiSelectListPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public MultiSelectListPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public MultiSelectListPreference(Context r2) {
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

    public void setValues(Set<String> r2) {
        this.mValues.clear();
        this.mValues.addAll(r2);
        persistStringSet(r2);
        notifyChanged();
    }

    public Set<String> getValues() {
        return this.mValues;
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

    protected boolean[] getSelectedItems() {
        CharSequence[] r0 = this.mEntryValues;
        int r1 = r0.length;
        Set<String> r5 = this.mValues;
        boolean[] r2 = new boolean[r1];
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r2[r3] = r5.contains(r0[r3].toString());
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r3, int r4) {
        CharSequence[] r2 = r3.getTextArray(r4);
        HashSet r5 = new HashSet();
        int r6 = r2.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r5.add(r2[r0].toString());
        r0 = r0 + 1;
        goto L3
    L5:
        return r5;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object r1) {
        setValues(getPersistedStringSet((Set) r1));
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.mValues = getValues();
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
        setValues(r4.mValues);
    }
}
