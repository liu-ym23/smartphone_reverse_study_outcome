package com.bytedance.android.live.broadcast.rts;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.foundation.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u00032%\u0010\b\u001a!\u0012\u0017\u0012\u00150\tj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\f"}, d2 = {"<no name provided>", "", JSEventListener.ACTION_RESOLVE, "Lkotlin/Function1;", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusResponse;", "Lkotlin/ParameterName;", "name", "value", "reject", "", "Lcom/bytedance/rts/foundation/RTSError;", "reason", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnchorStatusMocker$Companion$queryAnchorStatus$1 extends Lambda implements Function2<Function1<? super AnchorStatusResponse, ? extends Unit>, Function1<? super Throwable, ? extends Unit>, Unit> {
    final /* synthetic */ String $roomId;

    public AnchorStatusMocker$Companion$queryAnchorStatus$1(String r100) {
        this.$roomId = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Function1<? super AnchorStatusResponse, Unit> r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r101, "reject");
        u.d(new AnonymousClass1(this, r100), 3000);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super AnchorStatusResponse, ? extends Unit> r100, Function1<? super Throwable, ? extends Unit> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
