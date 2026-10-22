package y;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* loaded from: classes.dex */
public final class p extends View {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16150a;

    public p(Context context) {
        super(context);
        this.f16150a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z4) {
        this.f16150a = z4;
    }

    public void setGuidelineBegin(int i4) {
        e eVar = (e) getLayoutParams();
        if (this.f16150a && eVar.f15978a == i4) {
            return;
        }
        eVar.f15978a = i4;
        setLayoutParams(eVar);
    }

    public void setGuidelineEnd(int i4) {
        e eVar = (e) getLayoutParams();
        if (this.f16150a && eVar.f15980b == i4) {
            return;
        }
        eVar.f15980b = i4;
        setLayoutParams(eVar);
    }

    public void setGuidelinePercent(float f4) {
        e eVar = (e) getLayoutParams();
        if (this.f16150a && eVar.f15982c == f4) {
            return;
        }
        eVar.f15982c = f4;
        setLayoutParams(eVar);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
    }
}
