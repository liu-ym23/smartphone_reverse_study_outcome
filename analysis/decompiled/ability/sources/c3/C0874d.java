package c3;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

/* renamed from: c3.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0874d extends ResourcesCompat.FontCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0877g f2085a;
    public final /* synthetic */ C0876f b;

    public C0874d(C0876f c0876f, AbstractC0877g abstractC0877g) {
        this.b = c0876f;
        this.f2085a = abstractC0877g;
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* renamed from: onFontRetrievalFailed */
    public final void lambda$callbackFailAsync$1(int i) {
        this.b.n = true;
        this.f2085a.a(i);
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* renamed from: onFontRetrieved */
    public final void lambda$callbackSuccessAsync$0(Typeface typeface) {
        C0876f c0876f = this.b;
        c0876f.p = Typeface.create(typeface, c0876f.d);
        c0876f.n = true;
        this.f2085a.b(c0876f.p, false);
    }
}
