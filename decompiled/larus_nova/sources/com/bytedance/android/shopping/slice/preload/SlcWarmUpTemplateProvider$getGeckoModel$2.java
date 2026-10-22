package com.bytedance.android.shopping.slice.preload;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import pq.c;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpq/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lpq/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SlcWarmUpTemplateProvider$getGeckoModel$2 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ String $url;

    public SlcWarmUpTemplateProvider$getGeckoModel$2(String r100) {
        this.$url = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f530258a = "SlcWarmUpTemplateProvider";
        r100.f530259b = "获取GeckoModel失败：" + this.$url;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
