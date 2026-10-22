package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Guideline extends View {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8884a;

    public Guideline(Context context) {
        super(context);
        this.f8884a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z5) {
        this.f8884a = z5;
    }

    public void setGuidelineBegin(int i5) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f8884a && bVar.f8826a == i5) {
            return;
        }
        bVar.f8826a = i5;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i5) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f8884a && bVar.f8828b == i5) {
            return;
        }
        bVar.f8828b = i5;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f5) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f8884a && bVar.f8830c == f5) {
            return;
        }
        bVar.f8830c = f5;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8884a = true;
        super.setVisibility(8);
    }
}
