package com.obric.oui.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import bg.h;
import com.obric.oui.panel.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J%\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J=\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/panel/pad/PadBottomSheetBehavior;", "V", "Landroid/view/View;", "Lcom/obric/oui/panel/BottomSheetBehavior;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "calculateCollapsedOffset", "", "onInterceptTouchEvent", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onStartNestedScroll", "coordinatorLayout", "directTargetChild", "target", "axes", "", "type", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onTouchEvent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public PadBottomSheetBehavior(@NotNull Context r10, @NotNull AttributeSet r11) {
        q.g(r10, "context");
        q.g(r11, "attributes");
        super(r10, r11);
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior
    public void calculateCollapsedOffset() {
        if (this.f15742a == false) goto L5;
        int r10 = h.d(this.f15763v - this.f15749h, this.f15750i);
    L6:
        this.f15752k = r10 / 2;
        return;
    L5:
        r10 = this.f15763v - this.f15749h;
        goto L6
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        q.g(r10, "parent");
        q.g(r11, "child");
        q.g(r12, "event");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14, int r15) {
        q.g(r10, "coordinatorLayout");
        q.g(r11, "child");
        q.g(r12, "directTargetChild");
        q.g(r13, "target");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        q.g(r10, "parent");
        q.g(r11, "child");
        q.g(r12, "event");
        return false;
    }
}
