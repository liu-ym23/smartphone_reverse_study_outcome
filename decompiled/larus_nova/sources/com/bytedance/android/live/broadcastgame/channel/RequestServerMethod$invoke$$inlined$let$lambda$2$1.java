package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/broadcastgame/channel/RequestServerMethod$invoke$1$2$1$1", "com/bytedance/android/live/broadcastgame/channel/RequestServerMethod$invoke$1$2$$special$$inlined$run$lambda$1"}, k = 3, mv = {1, 4, 3})
final class RequestServerMethod$invoke$$inlined$let$lambda$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Throwable $it$inlined;
    final /* synthetic */ u $this_run;
    final /* synthetic */ e this$0;

    public RequestServerMethod$invoke$$inlined$let$lambda$2$1(u r100, e r101, Throwable r102) {
        this.$this_run = r100;
        this.$it$inlined = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IInteractGameService r100 = (IInteractGameService) k.n(IInteractGameService.class);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
