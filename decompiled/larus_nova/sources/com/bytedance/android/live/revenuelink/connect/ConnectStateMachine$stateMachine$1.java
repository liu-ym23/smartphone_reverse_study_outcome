package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.live.kmp.statemachine.StateMachine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/live/kmp/statemachine/StateMachine$GraphBuilder;", "Ley/f;", "Ley/e;", "Ley/l;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/live/kmp/statemachine/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ConnectStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<ey.f, ey.e, ey.l>, Unit> {
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ ConnectStateMachine this$0;

    public ConnectStateMachine$stateMachine$1(ConnectStateMachine r100, Function1 r101) {
        this.this$0 = r100;
        this.$listener = r101;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [STATE, ey.f$d, java.lang.Object] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.GraphBuilder<ey.f, ey.e, ey.l> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        ?? r101 = new ey.f.d(0);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "initialState");
        r100.f255144a = r101;
        Function1<StateMachine.GraphBuilder<ey.f, ey.e, ey.l>.StateDefinitionBuilder<ey.f.d>, Unit> r102 = new AnonymousClass1(this);
        int r103 = StateMachine.Matcher.f255148c;
        r100.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.d.class)), r102);
        Function1<StateMachine.GraphBuilder<ey.f, ey.e, ey.l>.StateDefinitionBuilder<ey.f.e>, Unit> r104 = new AnonymousClass2(this);
        r100.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.e.class)), r104);
        AnonymousClass3 r105 = AnonymousClass3.INSTANCE;
        r100.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.b.class)), r105);
        AnonymousClass4 r106 = AnonymousClass4.INSTANCE;
        r100.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.a.class)), r106);
        AnonymousClass5 r107 = AnonymousClass5.INSTANCE;
        r100.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.C5832f.class)), r107);
        r100.a(this.$listener);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<ey.f, ey.e, ey.l> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
