package c3;

import android.graphics.Typeface;
import v0.C2054a;

/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0871a extends AbstractC0877g {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f2084a;
    public final C2054a b;
    public boolean c;

    public C0871a(C2054a c2054a, Typeface typeface) {
        this.f2084a = typeface;
        this.b = c2054a;
    }

    @Override // c3.AbstractC0877g
    public final void a(int i) {
        if (this.c) {
            return;
        }
        com.google.android.material.internal.c cVar = (com.google.android.material.internal.c) this.b.f6763a;
        if (cVar.l(this.f2084a)) {
            cVar.j(false);
        }
    }

    @Override // c3.AbstractC0877g
    public final void b(Typeface typeface, boolean z10) {
        if (this.c) {
            return;
        }
        com.google.android.material.internal.c cVar = (com.google.android.material.internal.c) this.b.f6763a;
        if (cVar.l(typeface)) {
            cVar.j(false);
        }
    }
}
