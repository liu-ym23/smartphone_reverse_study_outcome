package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.C0180f;
import com.stepos.alphame.R;
import k.ViewTreeObserverOnGlobalLayoutListenerC0651e;

/* loaded from: classes.dex */
public final class T extends G0 implements U {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f2961A;

    /* renamed from: B, reason: collision with root package name */
    public ListAdapter f2962B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f2963C;

    /* renamed from: D, reason: collision with root package name */
    public int f2964D;

    /* renamed from: E, reason: collision with root package name */
    public final /* synthetic */ V f2965E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(V v4, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.f2965E = v4;
        this.f2963C = new Rect();
        this.f2835o = v4;
        this.f2845y = true;
        this.f2846z.setFocusable(true);
        this.f2836p = new C0180f(1, this, v4);
    }

    @Override // androidx.appcompat.widget.U
    public final void j(CharSequence charSequence) {
        this.f2961A = charSequence;
    }

    @Override // androidx.appcompat.widget.U
    public final void l(int i4) {
        this.f2964D = i4;
    }

    @Override // androidx.appcompat.widget.U
    public final void n(int i4, int i5) {
        ViewTreeObserver viewTreeObserver;
        boolean zIsShowing = this.f2846z.isShowing();
        s();
        this.f2846z.setInputMethodMode(2);
        g();
        C0229u0 c0229u0 = this.f2823c;
        c0229u0.setChoiceMode(1);
        c0229u0.setTextDirection(i4);
        c0229u0.setTextAlignment(i5);
        V v4 = this.f2965E;
        int selectedItemPosition = v4.getSelectedItemPosition();
        C0229u0 c0229u02 = this.f2823c;
        int i6 = 0;
        if (this.f2846z.isShowing() && c0229u02 != null) {
            c0229u02.setListSelectionHidden(false);
            c0229u02.setSelection(selectedItemPosition);
            if (c0229u02.getChoiceMode() != 0) {
                c0229u02.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = v4.getViewTreeObserver()) == null) {
            return;
        }
        ViewTreeObserverOnGlobalLayoutListenerC0651e viewTreeObserverOnGlobalLayoutListenerC0651e = new ViewTreeObserverOnGlobalLayoutListenerC0651e(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0651e);
        this.f2846z.setOnDismissListener(new S(i6, this, viewTreeObserverOnGlobalLayoutListenerC0651e));
    }

    @Override // androidx.appcompat.widget.U
    public final CharSequence p() {
        return this.f2961A;
    }

    @Override // androidx.appcompat.widget.G0, androidx.appcompat.widget.U
    public final void q(ListAdapter listAdapter) {
        super.q(listAdapter);
        this.f2962B = listAdapter;
    }

    public final void s() {
        int i4;
        Drawable background = this.f2846z.getBackground();
        V v4 = this.f2965E;
        if (background != null) {
            background.getPadding(v4.f3022h);
            int layoutDirection = v4.getLayoutDirection();
            Rect rect = v4.f3022h;
            i4 = layoutDirection == 1 ? rect.right : -rect.left;
        } else {
            Rect rect2 = v4.f3022h;
            rect2.right = 0;
            rect2.left = 0;
            i4 = 0;
        }
        int paddingLeft = v4.getPaddingLeft();
        int paddingRight = v4.getPaddingRight();
        int width = v4.getWidth();
        int i5 = v4.f3021g;
        if (i5 == -2) {
            int iA = v4.a((SpinnerAdapter) this.f2962B, this.f2846z.getBackground());
            int i6 = v4.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = v4.f3022h;
            int i7 = (i6 - rect3.left) - rect3.right;
            if (iA > i7) {
                iA = i7;
            }
            r(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i5 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i5);
        }
        this.f2826f = v4.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f2825e) - this.f2964D) + i4 : paddingLeft + this.f2964D + i4;
    }
}
