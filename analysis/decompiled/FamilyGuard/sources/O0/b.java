package O0;

import android.graphics.Bitmap;
import x0.InterfaceC1277a;

/* loaded from: classes.dex */
public final class b implements InterfaceC1277a.InterfaceC0257a {

    /* renamed from: a, reason: collision with root package name */
    private final D0.d f4302a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.b f4303b;

    public b(D0.d dVar, D0.b bVar) {
        this.f4302a = dVar;
        this.f4303b = bVar;
    }

    @Override // x0.InterfaceC1277a.InterfaceC0257a
    public Bitmap a(int i5, int i6, Bitmap.Config config) {
        return this.f4302a.e(i5, i6, config);
    }

    @Override // x0.InterfaceC1277a.InterfaceC0257a
    public int[] b(int i5) {
        D0.b bVar = this.f4303b;
        return bVar == null ? new int[i5] : (int[]) bVar.d(i5, int[].class);
    }

    @Override // x0.InterfaceC1277a.InterfaceC0257a
    public void c(Bitmap bitmap) {
        this.f4302a.c(bitmap);
    }

    @Override // x0.InterfaceC1277a.InterfaceC0257a
    public void d(byte[] bArr) {
        D0.b bVar = this.f4303b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // x0.InterfaceC1277a.InterfaceC0257a
    public byte[] e(int i5) {
        D0.b bVar = this.f4303b;
        return bVar == null ? new byte[i5] : (byte[]) bVar.d(i5, byte[].class);
    }

    @Override // x0.InterfaceC1277a.InterfaceC0257a
    public void f(int[] iArr) {
        D0.b bVar = this.f4303b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
