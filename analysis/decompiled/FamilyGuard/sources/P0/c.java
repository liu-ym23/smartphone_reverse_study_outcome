package P0;

import C0.v;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import z0.C1342h;

/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final D0.d f4536a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f4537b;

    /* renamed from: c, reason: collision with root package name */
    private final e<O0.c, byte[]> f4538c;

    public c(D0.d dVar, e<Bitmap, byte[]> eVar, e<O0.c, byte[]> eVar2) {
        this.f4536a = dVar;
        this.f4537b = eVar;
        this.f4538c = eVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static v<O0.c> b(v<Drawable> vVar) {
        return vVar;
    }

    @Override // P0.e
    public v<byte[]> a(v<Drawable> vVar, C1342h c1342h) {
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f4537b.a(K0.d.f(((BitmapDrawable) drawable).getBitmap(), this.f4536a), c1342h);
        }
        if (drawable instanceof O0.c) {
            return this.f4538c.a(b(vVar), c1342h);
        }
        return null;
    }
}
