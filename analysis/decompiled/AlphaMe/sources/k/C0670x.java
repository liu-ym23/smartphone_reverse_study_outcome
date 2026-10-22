package k;

import android.widget.PopupWindow;

/* renamed from: k.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0670x implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0671y f13306a;

    public C0670x(C0671y c0671y) {
        this.f13306a = c0671y;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f13306a.c();
    }
}
