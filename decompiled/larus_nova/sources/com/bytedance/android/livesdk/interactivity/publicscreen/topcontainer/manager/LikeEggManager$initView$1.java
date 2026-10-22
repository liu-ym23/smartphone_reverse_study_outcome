package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.EasterEggAnimationDialog;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/likeegg/a;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/likeegg/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LikeEggManager$initView$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.likeegg.a, Unit> {
    public LikeEggManager$initView$1(c r100) {
        super(1, r100, c.class, "onFinish", "onFinish(Lcom/bytedance/android/livesdk/chatroom/likeegg/LikeEggMessage;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final com.bytedance.android.livesdk.chatroom.likeegg.a r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        final c r101 = (c) this.receiver;
        int r102 = c.f140053f;
        r101.getClass();
        final Context r103 = com.bytedance.android.live.core.utils.a.d();
        if (r103 != null) goto L6;
        r103 = r101.f140057d.getContext();
    L6:
        EasterEggAnimationDialog.a r104 = EasterEggAnimationDialog.f139896i;
        Function0<Unit> r105 = new LikeEggManager$onFinish$1(r101, r103, r100);
        r104.getClass();
        EasterEggAnimationDialog.a.a(r103, r105);
        GuideTray r106 = GuideTray.HotMsgGather;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.chatroom.likeegg.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
