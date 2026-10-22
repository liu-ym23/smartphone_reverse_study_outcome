package L3;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import j.InterfaceC0625d;

/* loaded from: classes2.dex */
public final class n extends FrameLayout implements InterfaceC0625d {

    /* renamed from: a, reason: collision with root package name */
    public final CollapsibleActionView f1333a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(View view) {
        super(view.getContext());
        this.f1333a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // j.InterfaceC0625d
    public final void b() {
        this.f1333a.onActionViewExpanded();
    }

    @Override // j.InterfaceC0625d
    public final void g() {
        this.f1333a.onActionViewCollapsed();
    }
}
