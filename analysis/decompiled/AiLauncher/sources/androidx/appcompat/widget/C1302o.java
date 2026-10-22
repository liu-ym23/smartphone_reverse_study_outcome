package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;

/* renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1302o extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f9224b = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f9225a;

    public C1302o(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        U uV = U.v(context, attributeSet, R$styleable.PopupWindow, i10, i11);
        int i12 = R$styleable.PopupWindow_overlapAnchor;
        if (uV.s(i12)) {
            b(uV.a(i12, false));
        }
        setBackgroundDrawable(uV.g(R$styleable.PopupWindow_android_popupBackground));
        uV.x();
    }

    public final void b(boolean z10) {
        if (f9224b) {
            this.f9225a = z10;
        } else {
            androidx.core.widget.g.a(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (f9224b && this.f9225a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f9224b && this.f9225a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f9224b && this.f9225a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
