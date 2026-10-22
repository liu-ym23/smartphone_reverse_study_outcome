package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.android.live.revenue.common.t;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final class PanelContextManager$attachRechargePanelContext$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ c $context;
    final /* synthetic */ PanelContextManager this$0;

    public PanelContextManager$attachRechargePanelContext$2(PanelContextManager r100, c r101) {
        this.this$0 = r100;
        this.$context = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinkedHashSet<c> r100 = this.this$0.f90157a;
        monitor-enter(r100);
        jy0.b.a("Recharge/PanelContextManager", "detach panel context: " + this.$context + " (" + t.a(this.$context) + ')');     // Catch: Throwable -> L7
        CollectionsKt.removeAll(this.this$0.f90157a, new PanelContextManager$attachRechargePanelContext$2$$special$$inlined$kmpSynchronized$lambda$1(this));     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
