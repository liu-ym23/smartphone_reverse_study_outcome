package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class W extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3034e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3035f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ WeakReference f3036g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0192b0 f3037h;

    public W(C0192b0 c0192b0, int i4, int i5, WeakReference weakReference) {
        this.f3037h = c0192b0;
        this.f3034e = i4;
        this.f3035f = i5;
        this.f3036g = weakReference;
    }

    @Override // C.b
    public final void g(int i4) {
    }

    @Override // C.b
    public final void h(Typeface typeface) {
        int i4 = this.f3034e;
        if (i4 != -1) {
            typeface = AbstractC0190a0.a(typeface, i4, (this.f3035f & 2) != 0);
        }
        C0192b0 c0192b0 = this.f3037h;
        if (c0192b0.f3067m) {
            c0192b0.f3066l = typeface;
            TextView textView = (TextView) this.f3036g.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new X(textView, typeface, c0192b0.f3064j));
                } else {
                    textView.setTypeface(typeface, c0192b0.f3064j);
                }
            }
        }
    }
}
