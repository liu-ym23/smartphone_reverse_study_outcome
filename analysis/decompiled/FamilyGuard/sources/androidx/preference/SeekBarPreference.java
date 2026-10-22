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

    /* renamed from: T, reason: collision with root package name */
    int f11020T;

    /* renamed from: U, reason: collision with root package name */
    int f11021U;

    /* renamed from: V, reason: collision with root package name */
    private int f11022V;

    /* renamed from: W, reason: collision with root package name */
    private int f11023W;

    /* renamed from: X, reason: collision with root package name */
    boolean f11024X;

    /* renamed from: Y, reason: collision with root package name */
    SeekBar f11025Y;

    /* renamed from: Z, reason: collision with root package name */
    private TextView f11026Z;

    /* renamed from: a0, reason: collision with root package name */
    boolean f11027a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f11028b0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f11029c0;

    /* renamed from: d0, reason: collision with root package name */
    private final SeekBar.OnSeekBarChangeListener f11030d0;

    /* renamed from: e0, reason: collision with root package name */
    private final View.OnKeyListener f11031e0;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i5, boolean z5) {
            if (z5) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f11029c0 || !seekBarPreference.f11024X) {
                    seekBarPreference.V0(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.W0(i5 + seekBarPreference2.f11021U);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f11024X = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f11024X = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f11021U != seekBarPreference.f11020T) {
                seekBarPreference.V0(seekBar);
            }
        }
    }

    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i5, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f11027a0 && (i5 == 21 || i5 == 22)) || i5 == 23 || i5 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f11025Y;
            if (seekBar != null) {
                return seekBar.onKeyDown(i5, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f11030d0 = new a();
        this.f11031e0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11174H0, i5, i6);
        this.f11021U = typedArrayObtainStyledAttributes.getInt(s.f11180K0, 0);
        R0(typedArrayObtainStyledAttributes.getInt(s.f11176I0, 100));
        S0(typedArrayObtainStyledAttributes.getInt(s.f11182L0, 0));
        this.f11027a0 = typedArrayObtainStyledAttributes.getBoolean(s.f11178J0, true);
        this.f11028b0 = typedArrayObtainStyledAttributes.getBoolean(s.f11184M0, false);
        this.f11029c0 = typedArrayObtainStyledAttributes.getBoolean(s.f11186N0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void U0(int i5, boolean z5) {
        int i6 = this.f11021U;
        if (i5 < i6) {
            i5 = i6;
        }
        int i7 = this.f11022V;
        if (i5 > i7) {
            i5 = i7;
        }
        if (i5 != this.f11020T) {
            this.f11020T = i5;
            W0(i5);
            l0(i5);
            if (z5) {
                Q();
            }
        }
    }

    public final void R0(int i5) {
        int i6 = this.f11021U;
        if (i5 < i6) {
            i5 = i6;
        }
        if (i5 != this.f11022V) {
            this.f11022V = i5;
            Q();
        }
    }

    public final void S0(int i5) {
        if (i5 != this.f11023W) {
            this.f11023W = Math.min(this.f11022V - this.f11021U, Math.abs(i5));
            Q();
        }
    }

    public void T0(int i5) {
        U0(i5, true);
    }

    void V0(SeekBar seekBar) {
        int progress = this.f11021U + seekBar.getProgress();
        if (progress != this.f11020T) {
            if (d(Integer.valueOf(progress))) {
                U0(progress, false);
            } else {
                seekBar.setProgress(this.f11020T - this.f11021U);
                W0(this.f11020T);
            }
        }
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        lVar.itemView.setOnKeyListener(this.f11031e0);
        this.f11025Y = (SeekBar) lVar.a(o.f11145c);
        TextView textView = (TextView) lVar.a(o.f11146d);
        this.f11026Z = textView;
        if (this.f11028b0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f11026Z = null;
        }
        SeekBar seekBar = this.f11025Y;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f11030d0);
        this.f11025Y.setMax(this.f11022V - this.f11021U);
        int i5 = this.f11023W;
        if (i5 != 0) {
            this.f11025Y.setKeyProgressIncrement(i5);
        } else {
            this.f11023W = this.f11025Y.getKeyProgressIncrement();
        }
        this.f11025Y.setProgress(this.f11020T - this.f11021U);
        W0(this.f11020T);
        this.f11025Y.setEnabled(M());
    }

    void W0(int i5) {
        TextView textView = this.f11026Z;
        if (textView != null) {
            textView.setText(String.valueOf(i5));
        }
    }

    @Override // androidx.preference.Preference
    protected Object a0(TypedArray typedArray, int i5) {
        return Integer.valueOf(typedArray.getInt(i5, 0));
    }

    @Override // androidx.preference.Preference
    protected void e0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(c.class)) {
            super.e0(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.e0(cVar.getSuperState());
        this.f11020T = cVar.f11034a;
        this.f11021U = cVar.f11035b;
        this.f11022V = cVar.f11036c;
        Q();
    }

    @Override // androidx.preference.Preference
    protected Parcelable f0() {
        Parcelable parcelableF0 = super.f0();
        if (N()) {
            return parcelableF0;
        }
        c cVar = new c(parcelableF0);
        cVar.f11034a = this.f11020T;
        cVar.f11035b = this.f11021U;
        cVar.f11036c = this.f11022V;
        return cVar;
    }

    @Override // androidx.preference.Preference
    protected void g0(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        T0(x(((Integer) obj).intValue()));
    }

    private static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f11034a;

        /* renamed from: b, reason: collision with root package name */
        int f11035b;

        /* renamed from: c, reason: collision with root package name */
        int f11036c;

        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i5) {
                return new c[i5];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f11034a = parcel.readInt();
            this.f11035b = parcel.readInt();
            this.f11036c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f11034a);
            parcel.writeInt(this.f11035b);
            parcel.writeInt(this.f11036c);
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f11139j);
    }
}
