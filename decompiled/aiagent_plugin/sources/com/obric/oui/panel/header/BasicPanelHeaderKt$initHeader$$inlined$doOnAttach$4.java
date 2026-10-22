package com.obric.oui.panel.header;

import android.view.View;
import android.widget.ImageView;
import com.obric.oui.common.util.k;
import com.obric.oui.titlebar.OCompoundTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BasicPanelHeaderKt$initHeader$$inlined$doOnAttach$4 implements View.OnAttachStateChangeListener {
    final /* synthetic */ int $iconSize$inlined;
    final /* synthetic */ View $this_doOnAttach;
    final /* synthetic */ OTitleBar $this_initHeader$inlined;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        o.e(r1, "view");
    }

    public BasicPanelHeaderKt$initHeader$$inlined$doOnAttach$4(View r1, OTitleBar r2, int r3) {
        this.$this_doOnAttach = r1;
        this.$this_initHeader$inlined = r2;
        this.$iconSize$inlined = r3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r6) {
        o.e(r6, "view");
        this.$this_doOnAttach.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.$this_initHeader$inlined, View.class, "com.obric.aiagent.plugin");
        int r0 = this.$iconSize$inlined;
        ImageView r3 = ((OCompoundTitleBar) ZeusTransformUtils.preCheckCast(this.$this_initHeader$inlined, OCompoundTitleBar.class, "com.obric.aiagent.plugin")).getStartButton0();
        o.a(r3);
        ImageView r5 = ((OCompoundTitleBar) ZeusTransformUtils.preCheckCast(this.$this_initHeader$inlined, OCompoundTitleBar.class, "com.obric.aiagent.plugin")).getEndButton0();
        o.a(r5);
        k.a(r7, r0, r0, new View[]{(View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin")});
    }
}
