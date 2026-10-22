package com.bytedance.android.livesdk.chatroom.distribution;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/livesdk/chatroom/distribution/g$c;", "Lcom/bytedance/android/livesdk/chatroom/distribution/g$a;", "Lcom/bytedance/android/livesdk/chatroom/distribution/g$b;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveDistributionStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<g.c, g.a, g.b>, Unit> {
    final /* synthetic */ g this$0;

    public LiveDistributionStateMachine$stateMachine$1(g r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.GraphBuilder<g.c, g.a, g.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(g.c.b.f105770a);
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        int r102 = StateMachine.Matcher.f66086c;
        r100.c(StateMachine.Matcher.a.a(g.c.b.class), r101);
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(g.c.e.class), r103);
        AnonymousClass3 r104 = AnonymousClass3.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(g.c.d.class), r104);
        AnonymousClass4 r105 = AnonymousClass4.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(g.c.C1593c.class), r105);
        AnonymousClass5 r106 = AnonymousClass5.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(g.c.a.class), r106);
        r100.b(new AnonymousClass6(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<g.c, g.a, g.b> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
