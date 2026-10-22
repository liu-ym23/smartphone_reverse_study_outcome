package l;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends FrameLayout implements k.b {

    /* renamed from: c, reason: collision with root package name */
    public final CollapsibleActionView f7637c;

    /* JADX WARN: Multi-variable type inference failed */
    public p(View view) {
        super(view.getContext());
        this.f7637c = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // k.b
    public final void onActionViewCollapsed() {
        this.f7637c.onActionViewCollapsed();
    }

    @Override // k.b
    public final void onActionViewExpanded() {
        this.f7637c.onActionViewExpanded();
    }
}
