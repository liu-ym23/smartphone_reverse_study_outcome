package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class M extends SeekBar {

    /* renamed from: a, reason: collision with root package name */
    public final N f2879a;

    public M(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        V0.a(getContext(), this);
        N n4 = new N(this);
        this.f2879a = n4;
        n4.a(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        N n4 = this.f2879a;
        Drawable drawable = n4.f2881e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        SeekBar seekBar = n4.f2880d;
        if (drawable.setState(seekBar.getDrawableState())) {
            seekBar.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2879a.f2881e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2879a.d(canvas);
    }
}
