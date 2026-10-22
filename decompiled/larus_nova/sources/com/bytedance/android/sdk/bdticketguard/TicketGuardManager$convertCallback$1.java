package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.init.InitTask;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/init/InitTask;", "initTask", "Lcom/bytedance/android/sdk/bdticketguard/init/c$f;", "initResult", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/sdk/bdticketguard/init/InitTask;Lcom/bytedance/android/sdk/bdticketguard/init/c$f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class TicketGuardManager$convertCallback$1 extends Lambda implements Function2<InitTask, com.bytedance.android.sdk.bdticketguard.init.c.f, Unit> {
    final /* synthetic */ k1 $callback;

    public TicketGuardManager$convertCallback$1(k1 r100) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InitTask r100, com.bytedance.android.sdk.bdticketguard.init.c.f r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InitTask r100, com.bytedance.android.sdk.bdticketguard.init.c.f r101) {
        com.bytedance.android.sdk.bdticketguard.init.f.a(r101);
        throw null;
    }
}
