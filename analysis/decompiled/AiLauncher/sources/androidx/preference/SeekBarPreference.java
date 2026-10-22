package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public int f14341a;

    /* renamed from: b, reason: collision with root package name */
    public int f14342b;

    /* renamed from: c, reason: collision with root package name */
    public int f14343c;

    /* renamed from: d, reason: collision with root package name */
    public int f14344d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14345e;

    /* renamed from: f, reason: collision with root package name */
    public SeekBar f14346f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f14347g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14348h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14349i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14350j;

    /* renamed from: k, reason: collision with root package name */
    public final SeekBar.OnSeekBarChangeListener f14351k;

    /* renamed from: l, reason: collision with root package name */
    public final View.OnKeyListener f14352l;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f14350j || !seekBarPreference.f14345e) {
                    seekBarPreference.i(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.j(i10 + seekBarPreference2.f14342b);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f14345e = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f14345e = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f14342b != seekBarPreference.f14341a) {
                seekBarPreference.i(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f14348h && (i10 == 21 || i10 == 22)) || i10 == 23 || i10 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f14346f;
            if (seekBar != null) {
                return seekBar.onKeyDown(i10, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f14351k = new a();
        this.f14352l = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SeekBarPreference, i10, i11);
        this.f14342b = typedArrayObtainStyledAttributes.getInt(R$styleable.SeekBarPreference_min, 0);
        a(typedArrayObtainStyledAttributes.getInt(R$styleable.SeekBarPreference_android_max, 100));
        b(typedArrayObtainStyledAttributes.getInt(R$styleable.SeekBarPreference_seekBarIncrement, 0));
        this.f14348h = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_adjustable, true);
        this.f14349i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_showSeekBarValue, false);
        this.f14350j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(int i10) {
        int i11 = this.f14342b;
        if (i10 < i11) {
            i10 = i11;
        }
        if (i10 != this.f14343c) {
            this.f14343c = i10;
            notifyChanged();
        }
    }

    public final void b(int i10) {
        if (i10 != this.f14344d) {
            this.f14344d = Math.min(this.f14343c - this.f14342b, Math.abs(i10));
            notifyChanged();
        }
    }

    public void c(int i10) {
        e(i10, true);
    }

    public final void e(int i10, boolean z10) {
        int i11 = this.f14342b;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.f14343c;
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 != this.f14341a) {
            this.f14341a = i10;
            j(i10);
            persistInt(i10);
            if (z10) {
                notifyChanged();
            }
        }
    }

    public void i(SeekBar seekBar) {
        int progress = this.f14342b + seekBar.getProgress();
        if (progress != this.f14341a) {
            if (callChangeListener(Integer.valueOf(progress))) {
                e(progress, false);
            } else {
                seekBar.setProgress(this.f14341a - this.f14342b);
                j(this.f14341a);
            }
        }
    }

    public void j(int i10) {
        TextView textView = this.f14347g;
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        lVar.itemView.setOnKeyListener(this.f14352l);
        this.f14346f = (SeekBar) lVar.a(R$id.seekbar);
        TextView textView = (TextView) lVar.a(R$id.seekbar_value);
        this.f14347g = textView;
        if (this.f14349i) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f14347g = null;
        }
        SeekBar seekBar = this.f14346f;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f14351k);
        this.f14346f.setMax(this.f14343c - this.f14342b);
        int i10 = this.f14344d;
        if (i10 != 0) {
            this.f14346f.setKeyProgressIncrement(i10);
        } else {
            this.f14344d = this.f14346f.getKeyProgressIncrement();
        }
        this.f14346f.setProgress(this.f14341a - this.f14342b);
        j(this.f14341a);
        this.f14346f.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f14341a = savedState.mSeekBarValue;
        this.f14342b = savedState.mMin;
        this.f14343c = savedState.mMax;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.mSeekBarValue = this.f14341a;
        savedState.mMin = this.f14342b;
        savedState.mMax = this.f14343c;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        c(getPersistedInt(((Integer) obj).intValue()));
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int mMax;
        int mMin;
        int mSeekBarValue;

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

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarPreferenceStyle);
    }
}
