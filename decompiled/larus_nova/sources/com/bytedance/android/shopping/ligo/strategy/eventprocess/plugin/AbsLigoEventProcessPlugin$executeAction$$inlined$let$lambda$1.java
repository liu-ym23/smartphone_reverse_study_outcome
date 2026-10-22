package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/ligo/strategy/eventprocess/plugin/AbsLigoEventProcessPlugin$executeAction$1$1"}, k = 3, mv = {1, 4, 3})
final class AbsLigoEventProcessPlugin$executeAction$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b93.a $callback;
    final /* synthetic */ c93.a $decision$inlined;
    final /* synthetic */ Function0 $onError$inlined;
    final /* synthetic */ Function0 $onIgnored$inlined;
    final /* synthetic */ Function0 $onSuccess$inlined;
    final /* synthetic */ a this$0;

    public AbsLigoEventProcessPlugin$executeAction$$inlined$let$lambda$1(b93.a r100, a r101, Function0 r102, Function0 r103, Function0 r104, c93.a r105) {
        this.$onSuccess$inlined = r102;
        this.$onError$inlined = r103;
        this.$onIgnored$inlined = r104;
        this.$decision$inlined = r105;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ExecutorService r100 = a.f176492a;
        throw null;
    }
}
