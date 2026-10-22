package com.bytedance.android.live.liveinteract.channel.widget;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class ChannelLinkInvitedDialog$initView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ChannelLinkInvitedDialog this$0;

    public ChannelLinkInvitedDialog$initView$1(ChannelLinkInvitedDialog r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ChannelLinkInvitedDialog r101 = this.this$0;
        int r102 = ChannelLinkInvitedDialog.D;
        r101.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        Intrinsics.throwUninitializedPropertyAccessException("inviterUser");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
