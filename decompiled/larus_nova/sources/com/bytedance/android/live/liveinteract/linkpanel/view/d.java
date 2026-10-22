package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 f75091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PaidQueueTabView f75092b;

    public d(PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 r100, PaidQueueTabView r101) {
        this.f75091a = r100;
        this.f75092b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f75092b.f75085m = 40;
        PaidQueueTabView r101 = this.f75092b;
        Function1<? super Integer, Unit> r102 = r101.f75081i;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(r101.f75085m);
    L5:
        this.f75091a.invoke(this.f75092b.f75085m.intValue());
        c90.a r104 = this.f75092b.f75073a;
        if (r104 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r104);
        r104.dismiss();
        return;
    }
}
