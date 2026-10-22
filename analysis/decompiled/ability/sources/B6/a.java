package B6;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f195a;
    public int b;
    public int c;
    public int d;
    public final Paint e = new Paint(1);

    public static void a(a aVar, Canvas canvas, float f, int i, int i6) {
        aVar.getClass();
        Paint paint = aVar.e;
        if (aVar.f195a <= 0) {
            return;
        }
        boolean z10 = i6 == 1;
        int i10 = z10 ? aVar.d : aVar.c;
        int i11 = i - (z10 ? aVar.c : aVar.d);
        if (i11 <= i10) {
            return;
        }
        paint.setColor(aVar.b);
        canvas.drawRect(i10, f, i11, f + aVar.f195a, paint);
    }
}
