package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatSeekBar extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }

    public AppCompatSeekBar(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r100) {
        monitor-enter(this);
        super.onDraw(r100);     // Catch: Throwable -> L6
        this.mAppCompatSeekBarHelper.drawTickMarks(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public AppCompatSeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatSeekBarHelper r103 = new AppCompatSeekBarHelper(this);
        this.mAppCompatSeekBarHelper = r103;
        r103.loadFromAttributes(r101, r102);
    }
}
