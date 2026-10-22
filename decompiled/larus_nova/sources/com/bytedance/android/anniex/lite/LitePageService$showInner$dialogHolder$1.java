package com.bytedance.android.anniex.lite;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import q26.k;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/anniex/base/builder/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LitePageService$showInner$dialogHolder$1 extends Lambda implements Function1<com.bytedance.android.anniex.base.builder.c, Unit> {
    final /* synthetic */ com.bytedance.android.anniex.base.lifecycle.a $annieXLifecycle;
    final /* synthetic */ IAnnieXLifecycleConfigService $annieXLifecycleConfigService;
    final /* synthetic */ String $bid;
    final /* synthetic */ k $config;
    final /* synthetic */ Context $context;

    public LitePageService$showInner$dialogHolder$1(String r100, k r101, Context r102, com.bytedance.android.anniex.base.lifecycle.a r103, IAnnieXLifecycleConfigService r104) {
        this.$bid = r100;
        this.$config = r101;
        this.$context = r102;
        this.$annieXLifecycle = r103;
        this.$annieXLifecycleConfigService = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.anniex.base.builder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$createDialogHolder");
        r100.a(this.$bid);
        r100.b(this.$config.f531448d);
        r100.d((FragmentActivity) this.$context);
        com.bytedance.android.anniex.base.lifecycle.a r101 = this.$annieXLifecycle;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r100.f40263f = r101;
    L5:
        IAnnieXLifecycleConfigService r102 = this.$annieXLifecycleConfigService;
        if (r102 == null) goto L8;
        r102.s();
    L8:
        r100.f40266i = true;
        r100.f40260c.putBoolean("bundle_annie_x_flow", true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.anniex.base.builder.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
