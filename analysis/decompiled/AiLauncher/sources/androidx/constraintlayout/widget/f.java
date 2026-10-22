package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class f extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f12860a;

    /* renamed from: b, reason: collision with root package name */
    public View f12861b;

    /* renamed from: c, reason: collision with root package name */
    public int f12862c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f12861b == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f12861b.getLayoutParams();
        bVar2.f12669v0.o1(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = bVar.f12669v0.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviourC != dimensionBehaviour) {
            bVar.f12669v0.p1(bVar2.f12669v0.Y());
        }
        if (bVar.f12669v0.V() != dimensionBehaviour) {
            bVar.f12669v0.Q0(bVar2.f12669v0.z());
        }
        bVar2.f12669v0.o1(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f12860a == -1 && !isInEditMode()) {
            setVisibility(this.f12862c);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f12860a);
        this.f12861b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.b) viewFindViewById.getLayoutParams()).f12645j0 = true;
            this.f12861b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f12861b;
    }

    public int getEmptyVisibility() {
        return this.f12862c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View viewFindViewById;
        if (this.f12860a == i10) {
            return;
        }
        View view = this.f12861b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f12861b.getLayoutParams()).f12645j0 = false;
            this.f12861b = null;
        }
        this.f12860a = i10;
        if (i10 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i10)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i10) {
        this.f12862c = i10;
    }
}
