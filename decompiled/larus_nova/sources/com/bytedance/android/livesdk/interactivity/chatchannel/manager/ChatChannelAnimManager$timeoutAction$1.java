package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelAnimManager$a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelAnimManager$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ChatChannelAnimManager$timeoutAction$1 extends Lambda implements Function1<ChatChannelAnimManager.a, Unit> {
    final /* synthetic */ ChatChannelAnimManager this$0;

    public ChatChannelAnimManager$timeoutAction$1(ChatChannelAnimManager r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChatChannelAnimManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (Intrinsics.areEqual(this.this$0.f134164b, r100) == false) goto L6;
        ChatChannelAnimManager.c(this.this$0, r100.f134168b);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatChannelAnimManager.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
