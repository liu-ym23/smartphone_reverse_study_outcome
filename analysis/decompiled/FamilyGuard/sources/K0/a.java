package K0;

import C0.v;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import z0.C1342h;

/* loaded from: classes.dex */
public class a<DataType> implements z0.i<DataType, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final z0.i<DataType, Bitmap> f3506a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f3507b;

    public a(Resources resources, z0.i<DataType, Bitmap> iVar) {
        this.f3507b = (Resources) X0.j.d(resources);
        this.f3506a = (z0.i) X0.j.d(iVar);
    }

    @Override // z0.i
    public v<BitmapDrawable> a(DataType datatype, int i5, int i6, C1342h c1342h) {
        return m.f(this.f3507b, this.f3506a.a(datatype, i5, i6, c1342h));
    }

    @Override // z0.i
    public boolean b(DataType datatype, C1342h c1342h) {
        return this.f3506a.b(datatype, c1342h);
    }
}
