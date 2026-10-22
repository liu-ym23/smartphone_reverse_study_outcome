package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: N, reason: collision with root package name */
    public int f4110N;

    /* renamed from: O, reason: collision with root package name */
    public int f4111O;

    /* renamed from: P, reason: collision with root package name */
    public int f4112P;

    /* renamed from: Q, reason: collision with root package name */
    public int f4113Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f4114R;

    /* renamed from: S, reason: collision with root package name */
    public SeekBar f4115S;
    public TextView T;

    /* renamed from: U, reason: collision with root package name */
    public final boolean f4116U;

    /* renamed from: V, reason: collision with root package name */
    public final boolean f4117V;

    /* renamed from: W, reason: collision with root package name */
    public final boolean f4118W;

    /* renamed from: X, reason: collision with root package name */
    public final M f4119X;

    /* renamed from: Y, reason: collision with root package name */
    public final N f4120Y;

    public SeekBarPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle, 0);
        this.f4119X = new M(this);
        this.f4120Y = new N(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4051k, R.attr.seekBarPreferenceStyle, 0);
        this.f4111O = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i4 = typedArrayObtainStyledAttributes.getInt(1, 100);
        int i5 = this.f4111O;
        i4 = i4 < i5 ? i5 : i4;
        if (i4 != this.f4112P) {
            this.f4112P = i4;
            h();
        }
        int i6 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i6 != this.f4113Q) {
            this.f4113Q = Math.min(this.f4112P - this.f4111O, Math.abs(i6));
            h();
        }
        this.f4116U = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f4117V = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.f4118W = typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.f4111O;
        if (progress != this.f4110N) {
            if (a(Integer.valueOf(progress))) {
                z(progress, false);
                return;
            }
            seekBar.setProgress(this.f4110N - this.f4111O);
            int i4 = this.f4110N;
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(String.valueOf(i4));
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) {
        super.l(k4);
        k4.itemView.setOnKeyListener(this.f4120Y);
        this.f4115S = (SeekBar) k4.a(R.id.seekbar);
        TextView textView = (TextView) k4.a(R.id.seekbar_value);
        this.T = textView;
        if (this.f4117V) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.T = null;
        }
        SeekBar seekBar = this.f4115S;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f4119X);
        this.f4115S.setMax(this.f4112P - this.f4111O);
        int i4 = this.f4113Q;
        if (i4 != 0) {
            this.f4115S.setKeyProgressIncrement(i4);
        } else {
            this.f4113Q = this.f4115S.getKeyProgressIncrement();
        }
        this.f4115S.setProgress(this.f4110N - this.f4111O);
        int i5 = this.f4110N;
        TextView textView2 = this.T;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i5));
        }
        this.f4115S.setEnabled(g());
    }

    @Override // androidx.preference.Preference
    public final Object o(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInt(i4, 0));
    }

    @Override // androidx.preference.Preference
    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.p(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.p(savedState.getSuperState());
        this.f4110N = savedState.f4121a;
        this.f4111O = savedState.f4122b;
        this.f4112P = savedState.f4123c;
        h();
    }

    @Override // androidx.preference.Preference
    public final Parcelable q() {
        this.f4073J = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f4094r) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.f4121a = this.f4110N;
        savedState.f4122b = this.f4111O;
        savedState.f4123c = this.f4112P;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void r(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (x()) {
            iIntValue = this.f4078b.b().getInt(this.f4088l, iIntValue);
        }
        z(iIntValue, true);
    }

    public final void z(int i4, boolean z4) {
        int i5 = this.f4111O;
        if (i4 < i5) {
            i4 = i5;
        }
        int i6 = this.f4112P;
        if (i4 > i6) {
            i4 = i6;
        }
        if (i4 != this.f4110N) {
            this.f4110N = i4;
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(String.valueOf(i4));
            }
            if (x()) {
                int i7 = ~i4;
                if (x()) {
                    i7 = this.f4078b.b().getInt(this.f4088l, i7);
                }
                if (i4 != i7) {
                    SharedPreferences.Editor editorA = this.f4078b.a();
                    editorA.putInt(this.f4088l, i4);
                    y(editorA);
                }
            }
            if (z4) {
                h();
            }
        }
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new O();

        /* renamed from: a, reason: collision with root package name */
        public int f4121a;

        /* renamed from: b, reason: collision with root package name */
        public int f4122b;

        /* renamed from: c, reason: collision with root package name */
        public int f4123c;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4121a = parcel.readInt();
            this.f4122b = parcel.readInt();
            this.f4123c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f4121a);
            parcel.writeInt(this.f4122b);
            parcel.writeInt(this.f4123c);
        }

        public SavedState(AbsSavedState absSavedState) {
            super(absSavedState);
        }
    }
}
