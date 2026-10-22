package z2;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends View {

    /* renamed from: c, reason: collision with root package name */
    public boolean f16331c;

    public o(Context context) {
        super(context);
        this.f16331c = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z10) {
        this.f16331c = z10;
    }

    public void setGuidelineBegin(int i) {
        d dVar = (d) getLayoutParams();
        if (this.f16331c && dVar.f16191a == i) {
            return;
        }
        dVar.f16191a = i;
        setLayoutParams(dVar);
    }

    public void setGuidelineEnd(int i) {
        d dVar = (d) getLayoutParams();
        if (this.f16331c && dVar.f16193b == i) {
            return;
        }
        dVar.f16193b = i;
        setLayoutParams(dVar);
    }

    public void setGuidelinePercent(float f5) {
        d dVar = (d) getLayoutParams();
        if (this.f16331c && dVar.f16195c == f5) {
            return;
        }
        dVar.f16195c = f5;
        setLayoutParams(dVar);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
