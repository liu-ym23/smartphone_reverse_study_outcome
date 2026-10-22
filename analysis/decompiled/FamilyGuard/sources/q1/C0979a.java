package q1;

import android.graphics.Typeface;

/* renamed from: q1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0979a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f19882a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0236a f19883b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f19884c;

    /* renamed from: q1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0236a {
        void a(Typeface typeface);
    }

    public C0979a(InterfaceC0236a interfaceC0236a, Typeface typeface) {
        this.f19882a = typeface;
        this.f19883b = interfaceC0236a;
    }

    private void d(Typeface typeface) {
        if (this.f19884c) {
            return;
        }
        this.f19883b.a(typeface);
    }

    @Override // q1.f
    public void a(int i5) {
        d(this.f19882a);
    }

    @Override // q1.f
    public void b(Typeface typeface, boolean z5) {
        d(typeface);
    }

    public void c() {
        this.f19884c = true;
    }
}
