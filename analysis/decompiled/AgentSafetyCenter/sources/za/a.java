package za;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f16572a;

    /* renamed from: b, reason: collision with root package name */
    public int f16573b;

    /* renamed from: c, reason: collision with root package name */
    public int f16574c;

    /* renamed from: d, reason: collision with root package name */
    public int f16575d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f16576e = new Paint(1);

    public static void a(a aVar, Canvas canvas, float f5, int i, int i3) {
        aVar.getClass();
        Paint paint = aVar.f16576e;
        if (aVar.f16572a <= 0) {
            return;
        }
        boolean z10 = i3 == 1;
        int i10 = z10 ? aVar.f16575d : aVar.f16574c;
        int i11 = i - (z10 ? aVar.f16574c : aVar.f16575d);
        if (i11 <= i10) {
            return;
        }
        paint.setColor(aVar.f16573b);
        canvas.drawRect(i10, f5, i11, f5 + aVar.f16572a, paint);
    }
}
