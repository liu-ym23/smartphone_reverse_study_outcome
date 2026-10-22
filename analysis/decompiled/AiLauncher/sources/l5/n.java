package l5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.voice.support.widget.WaveView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class n {
    public final ImageButton button;
    private final ConstraintLayout rootView;
    public final AppCompatTextView textAgain;
    public final AppCompatTextView textPlease;
    public final WaveView wave;
    public final View waveClickArea;

    public n(ConstraintLayout constraintLayout, ImageButton imageButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, WaveView waveView, View view) {
        this.rootView = constraintLayout;
        this.button = imageButton;
        this.textAgain = appCompatTextView;
        this.textPlease = appCompatTextView2;
        this.wave = waveView;
        this.waveClickArea = view;
    }

    public static n a(View view) {
        View viewA;
        int i10 = R$id.button;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.textAgain;
            AppCompatTextView appCompatTextView = (AppCompatTextView) C5437a.a(view, i10);
            if (appCompatTextView != null) {
                i10 = R$id.textPlease;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) C5437a.a(view, i10);
                if (appCompatTextView2 != null) {
                    i10 = R$id.wave;
                    WaveView waveView = (WaveView) C5437a.a(view, i10);
                    if (waveView != null && (viewA = C5437a.a(view, (i10 = R$id.wave_click_area))) != null) {
                        return new n((ConstraintLayout) view, imageButton, appCompatTextView, appCompatTextView2, waveView, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static n b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.layout_record, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
