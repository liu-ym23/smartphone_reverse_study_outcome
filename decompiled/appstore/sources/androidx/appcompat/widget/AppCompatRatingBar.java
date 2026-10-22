package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f782a;

    public AppCompatRatingBar(@NonNull Context r10) {
        this(r10, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r10, int r11) {
        monitor-enter(this);
        super.onMeasure(r10, r11);     // Catch: Throwable -> L7
        Bitmap r12 = this.f782a.b();     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        setMeasuredDimension(View.resolveSizeAndState(r12.getWidth() * getNumStars(), r10, 0), getMeasuredHeight());     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public AppCompatRatingBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.ratingBarStyle);
    }

    public AppCompatRatingBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        x.a(this, getContext());
        k r13 = new k(this);
        this.f782a = r13;
        r13.c(r11, r12);
    }
}
