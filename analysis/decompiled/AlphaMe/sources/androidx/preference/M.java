package androidx.preference;

import android.widget.SeekBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class M implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeekBarPreference f4059a;

    public M(SeekBarPreference seekBarPreference) {
        this.f4059a = seekBarPreference;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i4, boolean z4) {
        SeekBarPreference seekBarPreference = this.f4059a;
        if (z4 && (seekBarPreference.f4118W || !seekBarPreference.f4114R)) {
            seekBarPreference.A(seekBar);
            return;
        }
        int i5 = i4 + seekBarPreference.f4111O;
        TextView textView = seekBarPreference.T;
        if (textView != null) {
            textView.setText(String.valueOf(i5));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.f4059a.f4114R = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SeekBarPreference seekBarPreference = this.f4059a;
        seekBarPreference.f4114R = false;
        if (seekBar.getProgress() + seekBarPreference.f4111O != seekBarPreference.f4110N) {
            seekBarPreference.A(seekBar);
        }
    }
}
