package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1 extends Lambda implements Function1<StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>, Unit> {
    final /* synthetic */ KtvRoomLyricsStateMachineConfig.d $initState;
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ Function1 $onEnterListener;

    public KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1(KtvRoomLyricsStateMachineConfig.d r100, Function1 r101, Function1 r102) {
        this.$initState = r100;
        this.$onEnterListener = r101;
        this.$listener = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(this.$initState);
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        int r102 = StateMachine.Matcher.f66086c;
        r100.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.a.class), r101);
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.b.class), r103);
        Function1<StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>.StateDefinitionBuilder<KtvRoomLyricsStateMachineConfig.d.e>, Unit> r104 = new AnonymousClass3(this);
        r100.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.e.class), r104);
        Function1<StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>.StateDefinitionBuilder<KtvRoomLyricsStateMachineConfig.d.f>, Unit> r105 = new AnonymousClass4(this);
        r100.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.f.class), r105);
        AnonymousClass5 r106 = AnonymousClass5.INSTANCE;
        r100.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.C2274d.class), r106);
        r100.b(this.$listener);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
