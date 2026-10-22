package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class Mp4EnhancedEnterPlayer$playAnim$5 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$4 $onClick$4;

    public Mp4EnhancedEnterPlayer$playAnim$5(Mp4EnhancedEnterPlayer$playAnim$4 r100) {
        this.$onClick$4 = r100;
        super(0, null, SendEventContainerMethodParamModel.EventKinds.onClick, "invoke()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$onClick$4.invoke2();
    }
}
