package stepos.support.v7.widget;

import android.view.View;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class k implements PopupWindow.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ View f12763c;

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f12763c.setAlpha(1.0f);
    }
}
