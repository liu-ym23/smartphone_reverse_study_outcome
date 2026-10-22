package K0;

import C0.v;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final D0.d f3545a = new a();

    class a extends D0.e {
        a() {
        }

        @Override // D0.e, D0.d
        public void c(Bitmap bitmap) {
        }
    }

    static v<Bitmap> a(D0.d dVar, Drawable drawable, int i5, int i6) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z5 = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(dVar, current, i5, i6);
            z5 = true;
        }
        if (!z5) {
            dVar = f3545a;
        }
        return d.f(bitmapB, dVar);
    }

    private static Bitmap b(D0.d dVar, Drawable drawable, int i5, int i6) {
        if (i5 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i6 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i5 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        Lock lockC = q.c();
        lockC.lock();
        Bitmap bitmapD = dVar.d(i5, i6, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapD);
            drawable.setBounds(0, 0, i5, i6);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapD;
        } finally {
            lockC.unlock();
        }
    }
}
