package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/LynxView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class AioLinkRpcServiceImpl$registerAioLinkBridge$1 extends Lambda implements Function0<LynxView> {
    final /* synthetic */ IHybridComponent $componentContainer;

    public AioLinkRpcServiceImpl$registerAioLinkBridge$1(IHybridComponent r100) {
        this.$componentContainer = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LynxView invoke() {
        View r100 = this.$componentContainer.getHybridView();
        if ((r100 instanceof LynxView) == true) goto L6;
        r100 = null;
    L6:
        return (LynxView) r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ LynxView invoke() {
        return invoke();
    }
}
