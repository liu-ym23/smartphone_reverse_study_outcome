package com.obric.oui.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.panel.BottomSheetBehavior;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: PadBottomSheetBehavior.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, MotionEvent r3) {
        o.e(r1, "parent");
        o.e(r2, "child");
        o.e(r3, "event");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        o.e(r1, "coordinatorLayout");
        o.e(r2, "child");
        o.e(r3, "directTargetChild");
        o.e(r4, "target");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r1, V r2, MotionEvent r3) {
        o.e(r1, "parent");
        o.e(r2, "child");
        o.e(r3, "event");
        return false;
    }

    public PadBottomSheetBehavior(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "attributes");
        super(r5, r6);
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior
    public void d() {
        if (this.f35859a == false) goto L5;
        int r0 = n.c(this.k - this.f35860b, this.f35861c);
    L6:
        this.f35863e = r0;
        this.f35863e /= 2;
        return;
    L5:
        r0 = this.k - this.f35860b;
        goto L6
    }
}
