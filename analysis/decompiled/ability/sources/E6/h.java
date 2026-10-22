package E6;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class h extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final float f488a;

    public h(float f) {
        this.f488a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        k.f(view, "view");
        k.f(outline, "outline");
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        float fMin = Math.min(view.getWidth(), view.getHeight()) / 2.0f;
        float f = this.f488a;
        if (f > 0.0f) {
            fMin = Math.min(f, fMin);
        }
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), fMin);
    }
}
