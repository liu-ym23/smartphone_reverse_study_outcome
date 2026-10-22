package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class TitleBarBadgeView extends View {

    /* renamed from: k, reason: collision with root package name */
    private static int f21814k = 16;

    /* renamed from: l, reason: collision with root package name */
    private static int f21815l = 16;

    /* renamed from: a, reason: collision with root package name */
    private int f21816a;

    /* renamed from: b, reason: collision with root package name */
    private int f21817b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f21818c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f21819d;

    /* renamed from: e, reason: collision with root package name */
    private int f21820e;

    /* renamed from: f, reason: collision with root package name */
    private int f21821f;

    /* renamed from: g, reason: collision with root package name */
    private String f21822g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f21823h;

    /* renamed from: i, reason: collision with root package name */
    private float f21824i;

    /* renamed from: j, reason: collision with root package name */
    private int f21825j;

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21819d = false;
        c(context, attributeSet);
    }

    private int a(int i5, int i6, int i7) {
        return i6 != 1073741824 ? i7 : i5;
    }

    private void c(Context context, AttributeSet attributeSet) {
        d(context, attributeSet);
        e();
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayB = b(context, attributeSet, X4.l.f6178Q4);
        if (typedArrayB == null) {
            return;
        }
        this.f21816a = typedArrayB.getColor(X4.l.f6184R4, getResources().getColor(X4.c.f5863i));
        this.f21817b = (int) typedArrayB.getDimension(X4.l.f6190S4, getResources().getDimension(X4.d.f5899e0));
    }

    private void e() {
        Paint paint = new Paint();
        this.f21818c = paint;
        paint.setColor(this.f21816a);
        this.f21818c.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f21823h = paint2;
        paint2.setColor(-1);
        this.f21823h.setTextSize(N1.i.a(10.0f, getContext()));
        this.f21824i = N1.i.a(16.0f, getContext());
    }

    private boolean f() {
        return !TextUtils.isEmpty(this.f21822g);
    }

    protected TypedArray b(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public int getBadgeColor() {
        return this.f21816a;
    }

    public int getBadgeRadius() {
        return this.f21817b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (!this.f21819d) {
            canvas2 = canvas;
        } else if (f()) {
            canvas.translate(N1.i.a(10.0f, getContext()), (-N1.i.a(17.0f, getContext())) + this.f21825j);
            canvas2 = canvas;
            canvas2.drawRoundRect(0.0f, 0.0f, this.f21824i, N1.i.a(16.0f, getContext()), N1.i.a(8.0f, getContext()), N1.i.a(8.0f, getContext()), this.f21818c);
            canvas2.drawText(String.valueOf(this.f21822g), N1.i.a(5.0f, getContext()), N1.i.a(12.0f, getContext()), this.f21823h);
        } else {
            canvas.drawCircle(this.f21821f / 2, getHeight() / 2, this.f21817b, this.f21818c);
            canvas2 = canvas;
        }
        super.onDraw(canvas2);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        this.f21821f = a(size, mode, f21815l);
        int iA = a(size2, mode2, f21814k);
        this.f21820e = iA;
        setMeasuredDimension(this.f21821f, iA);
    }

    public void setBadgeColor(int i5) {
        this.f21816a = i5;
        invalidate();
    }

    public void setBadgeRadius(int i5) {
        this.f21817b = i5;
        invalidate();
    }

    public void setShow(boolean z5) {
        this.f21819d = z5;
    }
}
