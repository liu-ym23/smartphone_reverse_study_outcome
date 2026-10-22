package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    private OnBindEditTextListener mOnBindEditTextListener;
    private String mText;

    public interface OnBindEditTextListener {
        void onBindEditText(EditText r1);
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String mText;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r1) {
            super(r1);
            this.mText = r1.readString();
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.mText);
        }
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<EditTextPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        @Override // androidx.preference.Preference.SummaryProvider
        public /* bridge */ /* synthetic */ CharSequence provideSummary(Preference r1) {
            return provideSummary((EditTextPreference) r1);
        }

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider != null) goto L6;
            sSimpleSummaryProvider = new SimpleSummaryProvider();
        L6:
            return sSimpleSummaryProvider;
        }

        public CharSequence provideSummary(EditTextPreference r1) {
            if (TextUtils.isEmpty(r1.getText()) == false) goto L7;
            return r1.getContext().getString(R.string.not_set);
        L7:
            return r1.getText();
        }
    }

    public EditTextPreference(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.EditTextPreference, r4, r5);
        if (TypedArrayUtils.getBoolean(r6, R.styleable.EditTextPreference_useSimpleSummaryProvider, R.styleable.EditTextPreference_useSimpleSummaryProvider, false) == false) goto L5;
        setSummaryProvider(SimpleSummaryProvider.getInstance());
    L5:
        r6.recycle();
    }

    public EditTextPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public EditTextPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
    }

    public EditTextPreference(Context r2) {
        this(r2, null);
    }

    public void setText(String r2) {
        boolean r0 = shouldDisableDependents();
        this.mText = r2;
        persistString(r2);
        boolean r3 = shouldDisableDependents();
        if (r3 == r0) goto L5;
        notifyDependencyChange(r3);
    L5:
        notifyChanged();
    }

    public String getText() {
        return this.mText;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return r1.getString(r2);
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object r1) {
        setText(getPersistedString((String) r1));
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        if (TextUtils.isEmpty(this.mText) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.shouldDisableDependents() == true) goto L8;
        return false;
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.mText = getText();
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
        setText(r4.mText);
    }

    public void setOnBindEditTextListener(OnBindEditTextListener r1) {
        this.mOnBindEditTextListener = r1;
    }

    OnBindEditTextListener getOnBindEditTextListener() {
        return this.mOnBindEditTextListener;
    }
}
