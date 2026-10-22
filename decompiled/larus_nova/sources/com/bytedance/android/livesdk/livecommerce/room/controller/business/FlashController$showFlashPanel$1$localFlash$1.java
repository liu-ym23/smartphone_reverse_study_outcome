package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Landroid/content/Context;", "p2", "Lkotlin/Function2;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FlashController$showFlashPanel$1$localFlash$1 extends FunctionReferenceImpl implements Function2<Context, Function2<? super String, ? super String, ? extends Unit>, Unit> {
    public FlashController$showFlashPanel$1$localFlash$1(FlashController r100) {
        super(2, r100, FlashController.class, "getScreenshotSquare", "getScreenshotSquare(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context r100, Function2<? super String, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "p2");
        ((FlashController) this.receiver).H(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context r100, Function2<? super String, ? super String, ? extends Unit> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
