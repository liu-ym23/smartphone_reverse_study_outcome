package K0;

import C0.v;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: classes.dex */
public final class m implements v<BitmapDrawable>, C0.r {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f3552a;

    /* renamed from: b, reason: collision with root package name */
    private final v<Bitmap> f3553b;

    private m(Resources resources, v<Bitmap> vVar) {
        this.f3552a = (Resources) X0.j.d(resources);
        this.f3553b = (v) X0.j.d(vVar);
    }

    public static v<BitmapDrawable> f(Resources resources, v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new m(resources, vVar);
    }

    @Override // C0.r
    public void a() {
        v<Bitmap> vVar = this.f3553b;
        if (vVar instanceof C0.r) {
            ((C0.r) vVar).a();
        }
    }

    @Override // C0.v
    public void b() {
        this.f3553b.b();
    }

    @Override // C0.v
    public int c() {
        return this.f3553b.c();
    }

    @Override // C0.v
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override // C0.v
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f3552a, this.f3553b.get());
    }
}
