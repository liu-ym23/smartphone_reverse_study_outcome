package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public SeekBar W;
    public TextView X;
    public final boolean Y;
    public final boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public final boolean f2385a0;
    public final a b0;
    public final b c0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i10, boolean z) {
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (z && (seekBarPreference.f2385a0 || !seekBarPreference.V)) {
                seekBarPreference.C(seekBar);
                return;
            }
            int i11 = i10 + seekBarPreference.S;
            TextView textView = seekBarPreference.X;
            if (textView != null) {
                textView.setText(String.valueOf(i11));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.V = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            seekBarPreference.V = false;
            if (seekBar.getProgress() + seekBarPreference.S != seekBarPreference.R) {
                seekBarPreference.C(seekBar);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.Y && (i10 == 21 || i10 == 22)) || i10 == 23 || i10 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.W;
            if (seekBar != null) {
                return seekBar.onKeyDown(i10, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        this.b0 = new a();
        this.c0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2436k, R.attr.seekBarPreferenceStyle, 0);
        this.S = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i10 = typedArrayObtainStyledAttributes.getInt(1, 100);
        int i11 = this.S;
        i10 = i10 < i11 ? i11 : i10;
        if (i10 != this.T) {
            this.T = i10;
            j();
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i12 != this.U) {
            this.U = Math.min(this.T - this.S, Math.abs(i12));
            j();
        }
        this.Y = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.Z = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.f2385a0 = typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void B(int i10, boolean z) {
        int i11 = this.S;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.T;
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 != this.R) {
            this.R = i10;
            TextView textView = this.X;
            if (textView != null) {
                textView.setText(String.valueOf(i10));
            }
            if (z()) {
                int i13 = ~i10;
                if (z()) {
                    i13 = this.f2348b.b().getInt(this.f2357o, i13);
                }
                if (i10 != i13) {
                    SharedPreferences.Editor editorA = this.f2348b.a();
                    editorA.putInt(this.f2357o, i10);
                    if (!this.f2348b.f2413e) {
                        editorA.apply();
                    }
                }
            }
            if (z) {
                j();
            }
        }
    }

    public final void C(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.S;
        if (progress != this.R) {
            if (a(Integer.valueOf(progress))) {
                B(progress, false);
                return;
            }
            seekBar.setProgress(this.R - this.S);
            int i10 = this.R;
            TextView textView = this.X;
            if (textView != null) {
                textView.setText(String.valueOf(i10));
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void n(h hVar) {
        super.n(hVar);
        hVar.itemView.setOnKeyListener(this.c0);
        this.W = (SeekBar) hVar.a(R.id.seekbar);
        TextView textView = (TextView) hVar.a(R.id.seekbar_value);
        this.X = textView;
        if (this.Z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.X = null;
        }
        SeekBar seekBar = this.W;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.b0);
        this.W.setMax(this.T - this.S);
        int i10 = this.U;
        if (i10 != 0) {
            this.W.setKeyProgressIncrement(i10);
        } else {
            this.U = this.W.getKeyProgressIncrement();
        }
        this.W.setProgress(this.R - this.S);
        int i11 = this.R;
        TextView textView2 = this.X;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i11));
        }
        this.W.setEnabled(i());
    }

    @Override // androidx.preference.Preference
    public final Object q(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    @Override // androidx.preference.Preference
    public final void r(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.r(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.r(savedState.getSuperState());
        this.R = savedState.mSeekBarValue;
        this.S = savedState.mMin;
        this.T = savedState.mMax;
        j();
    }

    @Override // androidx.preference.Preference
    public final Parcelable s() {
        this.N = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f2363v) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.mSeekBarValue = this.R;
        savedState.mMin = this.S;
        savedState.mMax = this.T;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void t(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (z()) {
            iIntValue = this.f2348b.b().getInt(this.f2357o, iIntValue);
        }
        B(iIntValue, true);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int mMax;
        int mMin;
        int mSeekBarValue;

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
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
