package com.obric.oui.push;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OPush.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPush$Builder$buildLayout$8 implements View.OnAttachStateChangeListener {
    final /* synthetic */ ImageView $actionImage;
    final /* synthetic */ TextView $actionText;
    final /* synthetic */ View $contentView;
    final /* synthetic */ a.C0984a this$0;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        o.e(r1, "v");
    }

    OPush$Builder$buildLayout$8(View r1, a.C0984a r2, TextView r3, ImageView r4) {
        this.$contentView = r1;
        this.this$0 = r2;
        this.$actionText = r3;
        this.$actionImage = r4;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r7) {
        o.e(r7, "v");
        View r8 = this.$contentView;
        o.c(r8, "contentView");
        int r0 = g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 80);
        int r2 = g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 80);
        TextView r4 = this.$actionText;
        o.c(r4, "actionText");
        ImageView r6 = this.$actionImage;
        o.c(r6, "actionImage");
        k.a(r8, r0, r2, new View[]{(View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin")});
    }
}
