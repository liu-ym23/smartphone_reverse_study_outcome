package D0;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class e implements d {
    @Override // D0.d
    public void a(int i5) {
    }

    @Override // D0.d
    public void b() {
    }

    @Override // D0.d
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // D0.d
    public Bitmap d(int i5, int i6, Bitmap.Config config) {
        return Bitmap.createBitmap(i5, i6, config);
    }

    @Override // D0.d
    public Bitmap e(int i5, int i6, Bitmap.Config config) {
        return d(i5, i6, config);
    }
}
