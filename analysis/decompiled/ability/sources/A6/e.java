package A6;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes3.dex */
public final class e extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f113a;

    public e(float f) {
        this.f113a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        kotlin.jvm.internal.k.f(view, "view");
        kotlin.jvm.internal.k.f(outline, "outline");
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f113a);
    }
}
