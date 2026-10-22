package K;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

/* renamed from: K.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0092y extends AbstractC0091x {

    /* renamed from: d, reason: collision with root package name */
    public View f1017d;

    /* renamed from: e, reason: collision with root package name */
    public WindowInsetsController f1018e;

    @Override // K.AbstractC0091x, y1.f
    public final void p() {
        View view = this.f1017d;
        WindowInsetsController windowInsetsController = this.f1018e;
        if (windowInsetsController == null) {
            windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        }
        if (windowInsetsController != null) {
            windowInsetsController.show(WindowInsets.Type.ime());
        } else {
            super.p();
        }
    }
}
