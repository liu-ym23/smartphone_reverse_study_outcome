package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnchorGameMessageChannel$onLaunchFail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $errorPrompt;
    final /* synthetic */ Function3 $onResult;
    final /* synthetic */ Boolean $stableError;

    public AnchorGameMessageChannel$onLaunchFail$1(Function3 r100, String r101, Boolean r102) {
        this.$onResult = r100;
        this.$errorPrompt = r101;
        this.$stableError = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$onResult.invoke(Boolean.FALSE, this.$errorPrompt, this.$stableError);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
