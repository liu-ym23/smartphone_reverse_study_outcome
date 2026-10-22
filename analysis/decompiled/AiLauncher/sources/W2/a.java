package W2;

import android.graphics.Typeface;

/* loaded from: classes2.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f6602a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0114a f6603b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6604c;

    /* renamed from: W2.a$a, reason: collision with other inner class name */
    public interface InterfaceC0114a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0114a interfaceC0114a, Typeface typeface) {
        this.f6602a = typeface;
        this.f6603b = interfaceC0114a;
    }

    @Override // W2.f
    public void a(int i10) {
        d(this.f6602a);
    }

    @Override // W2.f
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f6604c = true;
    }

    public final void d(Typeface typeface) {
        if (this.f6604c) {
            return;
        }
        this.f6603b.a(typeface);
    }
}
