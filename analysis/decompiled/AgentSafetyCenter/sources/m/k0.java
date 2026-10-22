package m;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends w1 implements m0 {
    public CharSequence E;
    public i0 F;
    public final Rect G;
    public int H;
    public final /* synthetic */ n0 I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(n0 n0Var, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.I = n0Var;
        this.G = new Rect();
        this.f8127s = n0Var;
        this.C = true;
        this.D.setFocusable(true);
        i7.a aVar = new i7.a(1);
        aVar.f5815f = this;
        VarHandle.storeStoreFence();
        this.f8128t = aVar;
    }

    @Override // m.m0
    public final CharSequence d() {
        return this.E;
    }

    @Override // m.m0
    public final void i(CharSequence charSequence) {
        this.E = charSequence;
    }

    @Override // m.m0
    public final void l(int i) {
        this.H = i;
    }

    @Override // m.m0
    public final void m(int i, int i3) {
        ViewTreeObserver viewTreeObserver;
        boolean zIsShowing = this.D.isShowing();
        s();
        this.D.setInputMethodMode(2);
        f();
        j1 j1Var = this.f8116g;
        j1Var.setChoiceMode(1);
        j1Var.setTextDirection(i);
        j1Var.setTextAlignment(i3);
        n0 n0Var = this.I;
        int selectedItemPosition = n0Var.getSelectedItemPosition();
        j1 j1Var2 = this.f8116g;
        if (this.D.isShowing() && j1Var2 != null) {
            j1Var2.setListSelectionHidden(false);
            j1Var2.setSelection(selectedItemPosition);
            if (j1Var2.getChoiceMode() != 0) {
                j1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = n0Var.getViewTreeObserver()) == null) {
            return;
        }
        l.d dVar = new l.d(3);
        dVar.f7543f = this;
        VarHandle.storeStoreFence();
        viewTreeObserver.addOnGlobalLayoutListener(dVar);
        j0 j0Var = new j0();
        j0Var.f7931f = this;
        j0Var.f7930c = dVar;
        VarHandle.storeStoreFence();
        this.D.setOnDismissListener(j0Var);
    }

    @Override // m.w1, m.m0
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.F = (i0) listAdapter;
    }

    public final void s() {
        int i;
        Drawable background = this.D.getBackground();
        n0 n0Var = this.I;
        Rect rect = n0Var.f8018l;
        if (background != null) {
            background.getPadding(rect);
            i = n0Var.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = n0Var.getPaddingLeft();
        int paddingRight = n0Var.getPaddingRight();
        int width = n0Var.getWidth();
        int i3 = n0Var.f8017k;
        if (i3 == -2) {
            int iA = n0Var.a(this.F, this.D.getBackground());
            int i10 = (n0Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (iA > i10) {
                iA = i10;
            }
            r(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i3 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i3);
        }
        this.f8118j = n0Var.getLayoutDirection() == 1 ? (((width - paddingRight) - this.i) - this.H) + i : paddingLeft + this.H + i;
    }
}
