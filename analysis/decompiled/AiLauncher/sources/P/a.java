package P;

import D.T;
import K.E0;
import K.InterfaceC0891n;
import androidx.camera.core.impl.utils.ExifData;

/* loaded from: classes.dex */
public final class a implements T {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0891n f5326a;

    public a(InterfaceC0891n interfaceC0891n) {
        this.f5326a = interfaceC0891n;
    }

    @Override // D.T
    public int a() {
        return this.f5326a.a().toFlashState();
    }

    public InterfaceC0891n b() {
        return this.f5326a;
    }

    @Override // D.T
    public void c(ExifData.b bVar) throws NumberFormatException {
        this.f5326a.c(bVar);
    }

    @Override // D.T
    public E0 e() {
        return this.f5326a.e();
    }

    @Override // D.T
    public int f() {
        return 0;
    }

    @Override // D.T
    public long getTimestamp() {
        return this.f5326a.getTimestamp();
    }
}
