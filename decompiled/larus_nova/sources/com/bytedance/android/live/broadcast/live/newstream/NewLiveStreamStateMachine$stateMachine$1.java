package com.bytedance.android.live.broadcast.live.newstream;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lqv0/b;", "Lcom/bytedance/android/live/broadcast/live/newstream/d;", "Lcom/bytedance/android/live/broadcast/live/newstream/e;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class NewLiveStreamStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<qv0.b, d, e>, Unit> {
    final /* synthetic */ f this$0;

    public NewLiveStreamStateMachine$stateMachine$1(f r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.GraphBuilder<qv0.b, d, e> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(qv0.b.c.f534872b);
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        int r102 = StateMachine.Matcher.f66086c;
        r100.c(StateMachine.Matcher.a.a(qv0.b.c.class), r101);
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(qv0.b.a.class), r103);
        AnonymousClass3 r104 = AnonymousClass3.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(qv0.b.C7395b.class), r104);
        AnonymousClass4 r105 = AnonymousClass4.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(qv0.b.e.class), r105);
        AnonymousClass5 r106 = AnonymousClass5.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(qv0.b.d.class), r106);
        AnonymousClass6 r107 = AnonymousClass6.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(qv0.b.f.class), r107);
        r100.b(new AnonymousClass7(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<qv0.b, d, e> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
