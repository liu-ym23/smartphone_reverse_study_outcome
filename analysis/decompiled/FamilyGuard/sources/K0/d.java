package K0;

import C0.v;
import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class d implements v<Bitmap>, C0.r {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f3513a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.d f3514b;

    public d(Bitmap bitmap, D0.d dVar) {
        this.f3513a = (Bitmap) X0.j.e(bitmap, "Bitmap must not be null");
        this.f3514b = (D0.d) X0.j.e(dVar, "BitmapPool must not be null");
    }

    public static d f(Bitmap bitmap, D0.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, dVar);
    }

    @Override // C0.r
    public void a() {
        this.f3513a.prepareToDraw();
    }

    @Override // C0.v
    public void b() {
        this.f3514b.c(this.f3513a);
    }

    @Override // C0.v
    public int c() {
        return X0.k.h(this.f3513a);
    }

    @Override // C0.v
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    @Override // C0.v
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f3513a;
    }
}
