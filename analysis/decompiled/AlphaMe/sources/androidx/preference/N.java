package androidx.preference;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public final class N implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeekBarPreference f4063a;

    public N(SeekBarPreference seekBarPreference) {
        this.f4063a = seekBarPreference;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        SeekBarPreference seekBarPreference = this.f4063a;
        if ((!seekBarPreference.f4116U && (i4 == 21 || i4 == 22)) || i4 == 23 || i4 == 66) {
            return false;
        }
        SeekBar seekBar = seekBarPreference.f4115S;
        if (seekBar != null) {
            return seekBar.onKeyDown(i4, keyEvent);
        }
        Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
        return false;
    }
}
