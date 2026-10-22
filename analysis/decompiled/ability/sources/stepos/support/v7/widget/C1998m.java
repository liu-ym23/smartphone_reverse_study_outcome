package stepos.support.v7.widget;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: stepos.support.v7.widget.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1998m implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6623a;

    public C1998m(View view) {
        this.f6623a = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f6623a.setAlpha(1.0f);
    }
}
