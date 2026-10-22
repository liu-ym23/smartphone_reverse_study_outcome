package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/l;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/j;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/k;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PaidSceneStateMachine$createStateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<l, j, k>, Unit> {
    final /* synthetic */ n this$0;

    public PaidSceneStateMachine$createStateMachine$1(n r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.GraphBuilder<l, j, k> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(l.c.f159462b);
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        int r102 = StateMachine.Matcher.f66086c;
        r100.c(StateMachine.Matcher.a.a(l.c.class), r101);
        Function1<StateMachine.GraphBuilder<l, j, k>.StateDefinitionBuilder<l.b>, Unit> r103 = new AnonymousClass2(this);
        r100.c(StateMachine.Matcher.a.a(l.b.class), r103);
        AnonymousClass3 r104 = AnonymousClass3.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(l.d.class), r104);
        Function1<StateMachine.GraphBuilder<l, j, k>.StateDefinitionBuilder<l.f>, Unit> r105 = new AnonymousClass4(this);
        r100.c(StateMachine.Matcher.a.a(l.f.class), r105);
        Function1<StateMachine.GraphBuilder<l, j, k>.StateDefinitionBuilder<l.e>, Unit> r106 = new AnonymousClass5(this);
        r100.c(StateMachine.Matcher.a.a(l.e.class), r106);
        Function1<StateMachine.GraphBuilder<l, j, k>.StateDefinitionBuilder<l.g>, Unit> r107 = new AnonymousClass6(this);
        r100.c(StateMachine.Matcher.a.a(l.g.class), r107);
        Function1<StateMachine.GraphBuilder<l, j, k>.StateDefinitionBuilder<l.a>, Unit> r108 = new AnonymousClass7(this);
        r100.c(StateMachine.Matcher.a.a(l.a.class), r108);
        r100.b(new AnonymousClass8(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<l, j, k> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
