package k;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import j.InterfaceC0625d;

/* renamed from: k.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0665s extends FrameLayout implements InterfaceC0625d {

    /* renamed from: a, reason: collision with root package name */
    public final CollapsibleActionView f13298a;

    /* JADX WARN: Multi-variable type inference failed */
    public C0665s(View view) {
        super(view.getContext());
        this.f13298a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // j.InterfaceC0625d
    public final void b() {
        this.f13298a.onActionViewExpanded();
    }

    @Override // j.InterfaceC0625d
    public final void g() {
        this.f13298a.onActionViewCollapsed();
    }
}
