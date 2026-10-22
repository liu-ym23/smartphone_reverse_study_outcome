package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context r100) {
        this(r100, null);
    }

    public AppCompatRatingBar(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r100, int r101) {
        monitor-enter(this);
        super.onMeasure(r100, r101);     // Catch: Throwable -> L8
        Bitmap r102 = this.mAppCompatProgressBarHelper.getSampleTile();     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        setMeasuredDimension(View.resolveSizeAndState(r102.getWidth() * getNumStars(), r100, 0), getMeasuredHeight());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public AppCompatRatingBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper r103 = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = r103;
        r103.loadFromAttributes(r101, r102);
    }
}
