package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0449t extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f8607b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8608a;

    public C0449t(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        a(context, attributeSet, i5, i6);
    }

    private void a(Context context, AttributeSet attributeSet, int i5, int i6) {
        a0 a0VarV = a0.v(context, attributeSet, g.j.f17092Z1, i5, i6);
        int i7 = g.j.f17102b2;
        if (a0VarV.s(i7)) {
            b(a0VarV.a(i7, false));
        }
        setBackgroundDrawable(a0VarV.g(g.j.f17097a2));
        a0VarV.x();
    }

    private void b(boolean z5) {
        if (f8607b) {
            this.f8608a = z5;
        } else {
            androidx.core.widget.g.a(this, z5);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i5, int i6) {
        if (f8607b && this.f8608a) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i5, int i6, int i7, int i8) {
        if (f8607b && this.f8608a) {
            i6 -= view.getHeight();
        }
        super.update(view, i5, i6, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i5, int i6, int i7) {
        if (f8607b && this.f8608a) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6, i7);
    }
}
