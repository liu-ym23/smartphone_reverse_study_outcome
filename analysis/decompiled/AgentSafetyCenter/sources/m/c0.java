package m;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.RatingBar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends RatingBar {

    /* renamed from: c, reason: collision with root package name */
    public a0 f7886c;

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        Bitmap bitmap = (Bitmap) this.f7886c.f7870c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
