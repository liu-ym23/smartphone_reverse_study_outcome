package s3;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
public final class j extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    private final float f20290a;

    public j(float f5) {
        this.f20290a = f5;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        j4.k.g(view, "view");
        j4.k.g(outline, "outline");
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        float fMin = Math.min(view.getWidth(), view.getHeight()) / 2.0f;
        float f5 = this.f20290a;
        if (f5 > 0.0f) {
            fMin = Math.min(f5, fMin);
        }
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), fMin);
    }
}
