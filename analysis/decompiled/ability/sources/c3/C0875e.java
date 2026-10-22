package c3;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* renamed from: c3.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0875e extends AbstractC0877g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f2086a;
    public final /* synthetic */ TextPaint b;
    public final /* synthetic */ AbstractC0877g c;
    public final /* synthetic */ C0876f d;

    public C0875e(C0876f c0876f, Context context, TextPaint textPaint, AbstractC0877g abstractC0877g) {
        this.d = c0876f;
        this.f2086a = context;
        this.b = textPaint;
        this.c = abstractC0877g;
    }

    @Override // c3.AbstractC0877g
    public final void a(int i) {
        this.c.a(i);
    }

    @Override // c3.AbstractC0877g
    public final void b(Typeface typeface, boolean z10) {
        this.d.f(this.f2086a, this.b, typeface);
        this.c.b(typeface, z10);
    }
}
