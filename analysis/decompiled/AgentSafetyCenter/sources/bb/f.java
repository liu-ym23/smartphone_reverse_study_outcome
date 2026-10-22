package bb;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public float f2071a;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        view.getClass();
        outline.getClass();
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        float fMin = Math.min(view.getWidth(), view.getHeight()) / 2.0f;
        float f5 = this.f2071a;
        if (f5 > 0.0f) {
            fMin = Math.min(f5, fMin);
        }
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), fMin);
    }
}
