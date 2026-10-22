package Va;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;

/* loaded from: classes4.dex */
public final class s extends FrameLayout implements CollapsibleActionView {

    /* renamed from: a, reason: collision with root package name */
    public final android.view.CollapsibleActionView f1464a;

    /* JADX WARN: Multi-variable type inference failed */
    public s(View view) {
        super(view.getContext());
        this.f1464a = (android.view.CollapsibleActionView) view;
        addView(view);
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void onActionViewCollapsed() {
        this.f1464a.onActionViewCollapsed();
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void onActionViewExpanded() {
        this.f1464a.onActionViewExpanded();
    }
}
