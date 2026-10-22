package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.behavior;

import com.bytedance.android.live.room.api.messagewindow.builder.card.CommonCardBuilder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import r71.f;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/CommonCardBuilder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommonToolbarUiHandler$registerIntroCardService$1$1 extends Lambda implements Function1<CommonCardBuilder, Unit> {
    final /* synthetic */ f $it;
    final /* synthetic */ b this$0;

    public CommonToolbarUiHandler$registerIntroCardService$1$1(b r100, f r101) {
        this.$it = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CommonCardBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f98942a = this.$it.f536401a;
        Function1<CommonCardBuilder.d, Unit> r101 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.f98943b = r101;
        r100.c(AnonymousClass2.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CommonCardBuilder r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
