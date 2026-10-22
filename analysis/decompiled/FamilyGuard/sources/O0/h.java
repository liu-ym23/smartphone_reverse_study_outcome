package O0;

import C0.v;
import android.graphics.Bitmap;
import x0.InterfaceC1277a;
import z0.C1342h;

/* loaded from: classes.dex */
public final class h implements z0.i<InterfaceC1277a, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final D0.d f4337a;

    public h(D0.d dVar) {
        this.f4337a = dVar;
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Bitmap> a(InterfaceC1277a interfaceC1277a, int i5, int i6, C1342h c1342h) {
        return K0.d.f(interfaceC1277a.b(), this.f4337a);
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InterfaceC1277a interfaceC1277a, C1342h c1342h) {
        return true;
    }
}
