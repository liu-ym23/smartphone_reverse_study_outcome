package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
public class x implements ViewOverlayImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f5102a;

    public x(View r10) {
        this.f5102a = r10.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r10) {
        this.f5102a.add(r10);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r10) {
        this.f5102a.remove(r10);
    }
}
