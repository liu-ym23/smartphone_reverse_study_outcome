package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import v.e;

/* loaded from: classes.dex */
public class g extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f9075a;

    /* renamed from: b, reason: collision with root package name */
    private View f9076b;

    /* renamed from: c, reason: collision with root package name */
    private int f9077c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f9076b == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f9076b.getLayoutParams();
        bVar2.f8869v0.j1(0);
        e.b bVarA = bVar.f8869v0.A();
        e.b bVar3 = e.b.FIXED;
        if (bVarA != bVar3) {
            bVar.f8869v0.k1(bVar2.f8869v0.W());
        }
        if (bVar.f8869v0.T() != bVar3) {
            bVar.f8869v0.L0(bVar2.f8869v0.x());
        }
        bVar2.f8869v0.j1(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f9075a == -1 && !isInEditMode()) {
            setVisibility(this.f9077c);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f9075a);
        this.f9076b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.b) viewFindViewById.getLayoutParams()).f8845j0 = true;
            this.f9076b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f9076b;
    }

    public int getEmptyVisibility() {
        return this.f9077c;
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

    public void setContentId(int i5) {
        View viewFindViewById;
        if (this.f9075a == i5) {
            return;
        }
        View view = this.f9076b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f9076b.getLayoutParams()).f8845j0 = false;
            this.f9076b = null;
        }
        this.f9075a = i5;
        if (i5 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i5)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i5) {
        this.f9077c = i5;
    }
}
