package am5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4394g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4395h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4396i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4397j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f4398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f4401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4403f;

    public int getTouchSideSize() {
        return 0;
    }

    static {
        int r100 = n.d(18);
        f4394g = r100;
        int r101 = n.d(40);
        f4395h = r101;
        f4396i = (r100 * 2) + r101;
        f4397j = n.d(5);
    }

    public int getSideOffsetValue() {
        return this.f4402e;
    }

    public int getSidePadding() {
        return this.f4402e;
    }

    public a(Context r100) {
        super(r100);
        Paint r101 = new Paint();
        this.f4398a = r101;
        Paint r102 = new Paint();
        this.f4401d = r102;
        this.f4402e = f4394g;
        this.f4403f = true;
        this.f4399b = getResources().getColor(R.color.ud_B400);
        this.f4400c = getResources().getColor(R.color.static_white);
        r101.setColor(this.f4399b);
        r101.setAntiAlias(true);
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeWidth(n.d(2));
        r102.setColor(this.f4399b);
        r102.setAntiAlias(true);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(n.d(2));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        super.onDraw(r210);
        float r100 = this.f4402e;
        float r101 = getWidth() - r100;
        float r102 = getHeight() - r100;
        int r103 = 0;
        float r104 = (r100 + r101) / 2.0f;
        float r105 = (r100 + r102) / 2.0f;
        float[] r106 = {r100, r100, r101, r100, r101, r102, r100, r102, r104, r100, r101, r105, r104, r102, r100, r105};
        float r110 = this.f4401d.getStrokeWidth() / 2.0f;
        r210.drawLine(r106[0] - r110, r106[1], r106[2], r106[3], this.f4401d);
        r210.drawLine(r106[2], r106[3] - r110, r106[4], r106[5] + r110, this.f4401d);
        r210.drawLine(r106[4] - r110, r106[5], r106[6], r106[7], this.f4401d);
        r210.drawLine(r106[6], r106[7] + r110, r106[0], r106[1] + r110, this.f4401d);
        if (this.f4403f == true) goto L5;
        return;
    L5:
        if (r103 >= 8) goto L9;
        this.f4398a.setStyle(Paint.Style.FILL);
        this.f4398a.setColor(this.f4400c);
        int r107 = r103 * 2;
        float r108 = r106[r107];
        int r109 = r107 + 1;
        float r111 = r106[r109];
        int r112 = f4397j;
        r210.drawCircle(r108, r111, r112, this.f4398a);
        this.f4398a.setStyle(Paint.Style.STROKE);
        this.f4398a.setColor(this.f4399b);
        r210.drawCircle(r106[r107], r106[r109], r112, this.f4398a);
        r103 = r103 + 1;
        goto L5
    }
}
