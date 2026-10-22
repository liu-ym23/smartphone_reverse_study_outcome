package m;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 implements PopupWindow.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ l.d f7930c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k0 f7931f;

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f7931f.I.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f7930c);
        }
    }
}
