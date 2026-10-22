package d3;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* renamed from: d3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1376a {
    public static final int[] i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f4287j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f4288a;
    public final Paint b;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public final Path g = new Path();
    public final Paint h;

    public C1376a() {
        Paint paint = new Paint();
        this.h = paint;
        this.f4288a = new Paint();
        a(ViewCompat.MEASURED_STATE_MASK);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint2);
    }

    public final void a(int i6) {
        this.d = ColorUtils.setAlphaComponent(i6, 68);
        this.e = ColorUtils.setAlphaComponent(i6, 20);
        this.f = ColorUtils.setAlphaComponent(i6, 0);
        this.f4288a.setColor(this.d);
    }
}
