package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import y2.AbstractC1322c;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public abstract class l extends AbstractC1322c {

    /* renamed from: c, reason: collision with root package name */
    protected FrameLayout f141c;

    public l(Context context) {
        super(context);
    }

    @Override // y2.i
    public void c(Canvas canvas) {
        this.f141c.draw(canvas);
    }

    @Override // y2.i
    public boolean d() {
        return false;
    }

    @Override // y2.i
    public boolean g(MotionEvent motionEvent, AbstractC1325f abstractC1325f) {
        return false;
    }

    @Override // y2.i
    public int[] j(AbstractC1325f abstractC1325f, int i5, int i6) {
        R1.a.a("FrameForegroundLayer", "onMeasure");
        this.f141c.measure(i5, i6);
        return new int[]{this.f141c.getMeasuredWidth(), this.f141c.getMeasuredHeight()};
    }

    @Override // y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        R1.a.a("FrameForegroundLayer", "onLayout");
        this.f141c.layout(i5, i6, i7, i8);
    }

    protected abstract FrameLayout m(Context context);

    public void n(Context context) {
        this.f141c = m(context);
    }

    public l(Context context, FrameLayout frameLayout) {
        super(context);
        this.f141c = frameLayout;
    }
}
