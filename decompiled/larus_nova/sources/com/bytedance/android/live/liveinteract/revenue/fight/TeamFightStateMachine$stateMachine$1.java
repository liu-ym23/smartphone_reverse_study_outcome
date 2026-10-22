package com.bytedance.android.live.liveinteract.revenue.fight;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/e$b;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/e$a;", "", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class TeamFightStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<e.b, e.a, Object>, Unit> {
    final /* synthetic */ e this$0;

    public TeamFightStateMachine$stateMachine$1(e r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.GraphBuilder<e.b, e.a, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(e.b.c.f78207c);
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        int r102 = StateMachine.Matcher.f66086c;
        r100.c(StateMachine.Matcher.a.a(e.b.c.class), r101);
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(e.b.d.class), r103);
        Function1<StateMachine.GraphBuilder<e.b, e.a, Object>.StateDefinitionBuilder<e.b.a>, Unit> r104 = new AnonymousClass3(this);
        r100.c(StateMachine.Matcher.a.a(e.b.a.class), r104);
        Function1<StateMachine.GraphBuilder<e.b, e.a, Object>.StateDefinitionBuilder<e.b.C1217e>, Unit> r105 = new AnonymousClass4(this);
        r100.c(StateMachine.Matcher.a.a(e.b.C1217e.class), r105);
        AnonymousClass5 r106 = AnonymousClass5.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(e.b.C1216b.class), r106);
        r100.b(new AnonymousClass6(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<e.b, e.a, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
