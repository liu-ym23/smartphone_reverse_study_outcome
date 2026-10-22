package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {SendEventContainerMethodParamModel.EventKinds.onClick, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class Mp4EnhancedEnterPlayer$playAnim$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnimPlayer.a $animParams;
    final /* synthetic */ k32.a $msg;
    final /* synthetic */ ViewGroup $parentView;

    public Mp4EnhancedEnterPlayer$playAnim$4(AnimPlayer.a r100, ViewGroup r101, k32.a r102) {
        this.$animParams = r100;
        this.$parentView = r101;
        this.$msg = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View.OnClickListener r100 = this.$animParams.f136616c;
        if (r100 == null) goto L5;
        r100.onClick(this.$parentView);
    L5:
        RevenueUtils.b r101 = RevenueUtils.f136592i;
        k32.a r102 = this.$msg;
        r101.getClass();
        RevenueUtils.b.f(r102);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
