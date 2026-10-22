package G2;

import android.graphics.Canvas;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: G2.a$a, reason: collision with other inner class name */
    public interface InterfaceC0037a {
        void a(Canvas canvas);
    }

    public static int a(Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        return canvas.saveLayerAlpha(f10, f11, f12, f13, i10);
    }
}
