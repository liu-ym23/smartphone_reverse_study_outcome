package com.bytedance.android.live.core.tetris.widgets.cache;

import androidx.core.util.Consumer;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/c$a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/tetris/widgets/cache/c$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ComponentCacheManager$Companion$initializeForJava$1 extends Lambda implements Function1<c.a, Unit> {
    final /* synthetic */ Consumer $consumer;

    public ComponentCacheManager$Companion$initializeForJava$1(Consumer r100) {
        this.$consumer = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        this.$consumer.accept(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
