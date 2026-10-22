package te;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class n extends FrameLayout implements k.b {

    /* renamed from: c, reason: collision with root package name */
    public final CollapsibleActionView f13388c;

    /* JADX WARN: Multi-variable type inference failed */
    public n(View view) {
        super(view.getContext());
        this.f13388c = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // k.b
    public final void onActionViewCollapsed() {
        this.f13388c.onActionViewCollapsed();
    }

    @Override // k.b
    public final void onActionViewExpanded() {
        this.f13388c.onActionViewExpanded();
    }
}
