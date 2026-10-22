package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends View {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1430a;

    public e(Context context) {
        super(context);
        this.f1430a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.f1430a = z;
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1430a && aVar.f1281a == i10) {
            return;
        }
        aVar.f1281a = i10;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1430a && aVar.f1283b == i10) {
            return;
        }
        aVar.f1283b = i10;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f8) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1430a && aVar.f1284c == f8) {
            return;
        }
        aVar.f1284c = f8;
        setLayoutParams(aVar);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
    }
}
