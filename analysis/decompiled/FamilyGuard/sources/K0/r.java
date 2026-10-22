package K0;

import C0.v;
import android.graphics.Bitmap;
import z0.C1342h;

/* loaded from: classes.dex */
public final class r implements z0.i<Bitmap, Bitmap> {

    private static final class a implements v<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private final Bitmap f3571a;

        a(Bitmap bitmap) {
            this.f3571a = bitmap;
        }

        @Override // C0.v
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f3571a;
        }

        @Override // C0.v
        public void b() {
        }

        @Override // C0.v
        public int c() {
            return X0.k.h(this.f3571a);
        }

        @Override // C0.v
        public Class<Bitmap> d() {
            return Bitmap.class;
        }
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Bitmap> a(Bitmap bitmap, int i5, int i6, C1342h c1342h) {
        return new a(bitmap);
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Bitmap bitmap, C1342h c1342h) {
        return true;
    }
}
