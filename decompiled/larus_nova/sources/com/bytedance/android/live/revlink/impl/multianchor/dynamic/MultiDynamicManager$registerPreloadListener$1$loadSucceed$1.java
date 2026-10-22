package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class MultiDynamicManager$registerPreloadListener$1$loadSucceed$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ zy0.b $hybridCard;
    final /* synthetic */ j this$0;

    public MultiDynamicManager$registerPreloadListener$1$loadSucceed$1(j r100, zy0.b r101) {
        this.this$0 = r100;
        this.$hybridCard = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        this.this$0.getClass();
        MultiDynamicManager.j(null, r100, false);
        throw null;
    }
}
