package A2;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import y2.AbstractC1321b;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class n extends AbstractC1321b {

    /* renamed from: h, reason: collision with root package name */
    private int f142h;

    /* renamed from: i, reason: collision with root package name */
    private int f143i;

    /* renamed from: j, reason: collision with root package name */
    private int f144j;

    /* renamed from: k, reason: collision with root package name */
    private int f145k;

    public n(Context context, z2.e eVar) {
        super(context, eVar);
    }

    private int[] n() {
        ArrayList arrayList = new ArrayList();
        y2.g[] gVarArrF = f();
        int length = gVarArrF.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((AbstractC0265d) gVarArrF[i5]).b().height() > 0) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr;
    }

    @Override // y2.i
    public void c(Canvas canvas) {
        for (y2.g gVar : f()) {
            gVar.c(canvas);
        }
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
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        int iR = (size - r()) - q();
        int iS = (size2 - s()) - p();
        int[] iArrA = i().a(abstractC1325f, f(), View.MeasureSpec.makeMeasureSpec(iR, mode), View.MeasureSpec.makeMeasureSpec(iS, mode2));
        return new int[]{iArrA[0] + r() + q(), iArrA[1] + s() + p()};
    }

    @Override // y2.i
    public void l(AbstractC1325f abstractC1325f, boolean z5, int i5, int i6, int i7, int i8) {
        i().b(abstractC1325f, i5, i6, i7, i8, f());
    }

    protected int o(float f5) {
        int[] iArrN = n();
        int i5 = -1;
        if (iArrN.length == 0) {
            return -1;
        }
        int length = iArrN.length;
        int i6 = 0;
        if (length == 1) {
            return iArrN[0];
        }
        while (i6 < length - 1) {
            int i7 = iArrN[i6];
            i6++;
            int i8 = iArrN[i6];
            if (Math.abs(((AbstractC0265d) f()[i7]).getBounds().centerX() - f5) < Math.abs(((AbstractC0265d) f()[i8]).getBounds().centerX() - f5)) {
                return i7;
            }
            i5 = i8;
        }
        return i5;
    }

    public int p() {
        return this.f145k;
    }

    public int q() {
        return this.f143i;
    }

    public int r() {
        return this.f142h;
    }

    public int s() {
        return this.f144j;
    }

    protected void t(int i5) {
        y2.g[] gVarArrF = f();
        if (gVarArrF == null) {
            return;
        }
        int length = gVarArrF.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (v()) {
                if (i5 == i6) {
                    gVarArrF[i6].d(y2.k.SELECTED);
                } else {
                    gVarArrF[i6].d(y2.k.UNSELECTED);
                }
            } else if (u()) {
                if (!(this instanceof com.stepos.familyguard.ui.widget.chart.histogram.c ? ((com.stepos.familyguard.ui.widget.chart.histogram.c) this).z() : false)) {
                    gVarArrF[i6].d(y2.k.NORMAL);
                } else if (i5 == i6) {
                    gVarArrF[i6].d(y2.k.HOVER);
                } else {
                    gVarArrF[i6].d(y2.k.NOT_HOVER);
                }
            }
        }
    }

    public boolean u() {
        return false;
    }

    public boolean v() {
        return false;
    }
}
