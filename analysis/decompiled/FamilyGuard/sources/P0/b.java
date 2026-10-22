package P0;

import C0.v;
import K0.m;
import X0.j;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import z0.C1342h;

/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f4535a;

    public b(Resources resources) {
        this.f4535a = (Resources) j.d(resources);
    }

    @Override // P0.e
    public v<BitmapDrawable> a(v<Bitmap> vVar, C1342h c1342h) {
        return m.f(this.f4535a, vVar);
    }
}
