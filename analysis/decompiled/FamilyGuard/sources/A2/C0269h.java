package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import f2.C0702g;

/* renamed from: A2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0269h extends AbstractC0265d {

    /* renamed from: j, reason: collision with root package name */
    protected final Paint f124j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f125k;

    /* renamed from: l, reason: collision with root package name */
    private int f126l;

    public C0269h(Context context, int[] iArr) {
        this(context, iArr, 0);
    }

    @Override // y2.g
    public void c(Canvas canvas) {
        canvas.save();
        Path pathH = h();
        if (pathH != null) {
            canvas.clipPath(pathH);
        }
        int iQ = q();
        if (iQ != 0) {
            this.f124j.setColor(iQ);
            canvas.drawRect(getBounds(), this.f124j);
        }
        if (k() == y2.k.NOT_HOVER) {
            this.f124j.setColor(r()[y2.k.NORMAL.ordinal()]);
            canvas.drawRect(b(), this.f124j);
        }
        this.f124j.setColor(r()[k().ordinal()]);
        canvas.drawRect(b(), this.f124j);
        canvas.restore();
    }

    @Override // A2.AbstractC0265d, y2.g
    public void d(y2.k kVar) {
        if (kVar.ordinal() >= r().length) {
            C0702g.p("ColorHistogramDataDrawable", "setState: state color not found");
        } else {
            super.d(kVar);
        }
    }

    public int q() {
        return this.f126l;
    }

    public int[] r() {
        return this.f125k;
    }

    public C0269h(Context context, int[] iArr, int i5) {
        super(context);
        this.f124j = new Paint();
        this.f125k = iArr;
        this.f126l = i5;
    }
}
