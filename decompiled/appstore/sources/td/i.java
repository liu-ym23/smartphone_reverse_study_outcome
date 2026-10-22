package td;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public static final boolean a(View r10) {
        q.g(r10, "<this>");
        if ((r10.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Integer b(View r10) {
        q.g(r10, "<this>");
        if ((r10.getBackground() instanceof ColorDrawable) == false) goto L11;
        Drawable r11 = r10.getBackground();
        if (r11 == null) goto L9;
        return Integer.valueOf(((ColorDrawable) r11).getColor());
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L11:
        if ((r10.getBackground() instanceof GradientDrawable) == false) goto L21;
        Drawable r12 = r10.getBackground();
        if (r12 == null) goto L20;
        ColorStateList r13 = ((GradientDrawable) r12).getColor();
        if (r13 != null) goto L18;
        return null;
    L18:
        return Integer.valueOf(r13.getDefaultColor());
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L21:
        return null;
    }

    public static final void c(View r10, int r11) {
        q.g(r10, "<this>");
        r10.getLayoutParams().height = r11;
        r10.requestLayout();
    }

    public static final void d(View r10, int r11) {
        q.g(r10, "<this>");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        ViewGroup.LayoutParams r13 = null;
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
    L6:
        if (r14 == null) goto L25;
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        int r16 = 0;
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r17 = androidx.core.view.e.b((ViewGroup.MarginLayoutParams) r15);
    L12:
        ViewGroup.LayoutParams r18 = r10.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r13 = r18;
    L16:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r13;
        if (r19 == null) goto L19;
        int r20 = r19.topMargin;
    L20:
        ViewGroup.LayoutParams r21 = r10.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r16 = androidx.core.view.e.a((ViewGroup.MarginLayoutParams) r21);
    L23:
        r14.setMargins(r17, r20, r16, r11);
        r10.requestLayout();
        return;
    L19:
        r20 = 0;
        goto L20
    L11:
        r17 = 0;
        goto L12
    L25:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public static final void e(View r10, int r11) {
        q.g(r10, "<this>");
        r10.getLayoutParams().width = r11;
        r10.requestLayout();
    }
}
