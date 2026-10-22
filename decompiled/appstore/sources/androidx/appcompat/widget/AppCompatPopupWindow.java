package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f780b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f781a;

    static {
        f780b = false;
    }

    public AppCompatPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12);
        a(r10, r11, r12, 0);
    }

    public final void a(Context r10, AttributeSet r11, int r12, int r13) {
        b0 r14 = b0.v(r10, r11, R$styleable.PopupWindow, r12, r13);
        int r15 = R$styleable.PopupWindow_overlapAnchor;
        if (r14.s(r15) == false) goto L5;
        b(r14.a(r15, false));
    L5:
        setBackgroundDrawable(r14.g(R$styleable.PopupWindow_android_popupBackground));
        r14.w();
    }

    public final void b(boolean r10) {
        if (f780b == false) goto L5;
        this.f781a = r10;
        return;
    L5:
        androidx.core.widget.j.a(this, r10);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12) {
        if (f780b == true) goto L5;
    L7:
        super.showAsDropDown(r10, r11, r12);
        return;
    L5:
        if (this.f781a == false) goto L7;
        r12 = r12 - r10.getHeight();
        goto L7
    }

    @Override // android.widget.PopupWindow
    public void update(View r10, int r11, int r12, int r13, int r14) {
        if (f780b == true) goto L5;
    L7:
        super.update(r10, r11, r12, r13, r14);
        return;
    L5:
        if (this.f781a == false) goto L7;
        r12 = r12 - r10.getHeight();
        goto L7
    }

    public AppCompatPopupWindow(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        a(r10, r11, r12, r13);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        if (f780b == true) goto L5;
    L7:
        super.showAsDropDown(r10, r11, r12, r13);
        return;
    L5:
        if (this.f781a == false) goto L7;
        r12 = r12 - r10.getHeight();
        goto L7
    }
}
