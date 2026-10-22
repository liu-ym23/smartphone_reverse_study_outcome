package com.bytedance.android.ec.hybrid.card.cache.template;

import com.bytedance.android.ec.hybrid.card.event.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/event/f;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/hybrid/card/event/f;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LynxCardTemplateCache$unRegisterSubscriber$1 extends Lambda implements Function1<f, Boolean> {
    final /* synthetic */ e this$0;

    public LynxCardTemplateCache$unRegisterSubscriber$1(e r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = r100.f46492b;
        this.this$0.getClass();
        return Intrinsics.areEqual(r101, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(f r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
