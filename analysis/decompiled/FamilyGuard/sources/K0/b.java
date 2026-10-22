package K0;

import C0.v;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;
import z0.C1342h;
import z0.EnumC1337c;

/* loaded from: classes.dex */
public class b implements z0.j<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final D0.d f3508a;

    /* renamed from: b, reason: collision with root package name */
    private final z0.j<Bitmap> f3509b;

    public b(D0.d dVar, z0.j<Bitmap> jVar) {
        this.f3508a = dVar;
        this.f3509b = jVar;
    }

    @Override // z0.j
    public EnumC1337c a(C1342h c1342h) {
        return this.f3509b.a(c1342h);
    }

    @Override // z0.InterfaceC1338d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(v<BitmapDrawable> vVar, File file, C1342h c1342h) {
        return this.f3509b.b(new d(vVar.get().getBitmap(), this.f3508a), file, c1342h);
    }
}
