package x2;

import A2.C0267f;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.familyguard.R;
import g2.C0737g;
import java.util.Iterator;
import java.util.List;
import l2.C0834c;

/* renamed from: x2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1284b extends View {

    /* renamed from: a, reason: collision with root package name */
    private final C0267f f23798a;

    /* renamed from: b, reason: collision with root package name */
    private float f23799b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f23800c;

    public C1284b(Context context) {
        this(context, null);
    }

    public int[] getCategoricalColors() {
        return this.f23798a.t();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f23798a.c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        this.f23798a.e(0, 0, i7 - i5, i8 - i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    public void setCategoricalColors(int[] iArr) {
        this.f23800c = iArr;
        this.f23798a.u(iArr);
    }

    public void setCategoricalStats(z2.d dVar) {
        long[] jArrS = dVar.s();
        if (jArrS == null) {
            return;
        }
        int length = getCategoricalColors().length;
        float[] fArr = new float[length];
        float f5 = 0.0f;
        int i5 = 0;
        while (i5 < length) {
            if (i5 == length - 1) {
                fArr[i5] = 1.0f - f5;
            } else {
                float fL = (float) ((i5 < jArrS.length ? jArrS[i5] : 0.0d) / dVar.l());
                fArr[i5] = fL;
                f5 += fL;
            }
            i5++;
        }
        setSizeRatios(fArr);
    }

    public void setCategoryUsingTimeStatsCacheList(List<C0834c> list) {
        if (list == null) {
            return;
        }
        int length = getCategoricalColors().length;
        int size = list.size();
        float[] fArr = new float[length];
        Iterator<C0834c> it = list.iterator();
        long jG = 0;
        while (it.hasNext()) {
            jG += it.next().g();
        }
        float f5 = 0.0f;
        for (int i5 = 0; i5 < size && i5 < length; i5++) {
            if (i5 == length - 1) {
                fArr[i5] = 1.0f - f5;
            } else {
                float fG = list.get(i5).g() / jG;
                fArr[i5] = fG;
                f5 += fG;
            }
        }
        setSizeRatios(fArr);
    }

    public void setSizeRatios(float[] fArr) {
        this.f23798a.v(fArr);
        invalidate();
    }

    public C1284b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1284b(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public C1284b(Context context, AttributeSet attributeSet, int i5, int i6) throws Resources.NotFoundException {
        super(context, attributeSet, i5, i6);
        this.f23799b = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0737g.f17331Q, i5, i6);
        this.f23799b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        int[] intArray = getResources().getIntArray(R.array.us_categorical_colors);
        this.f23800c = intArray;
        C0267f c0267f = new C0267f(context, intArray);
        this.f23798a = c0267f;
        c0267f.o(false);
        c0267f.f(1.0f);
        c0267f.p(this.f23799b);
        typedArrayObtainStyledAttributes.recycle();
    }
}
