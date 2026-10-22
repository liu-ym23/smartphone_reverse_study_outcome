package com.bytedance.android.livesdk.vscore_impl.paidlive.scene;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.vscore_api.paidlive.j;
import com.bytedance.android.livesdk.vscore_api.paidlive.k;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/l;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/j;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/k;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/PaidSceneTransition;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/core/utils/StateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BasePaidScene$createStateMachine$1 extends FunctionReferenceImpl implements Function1<StateMachine.c<? extends l, ? extends j, ? extends k>, Unit> {
    public BasePaidScene$createStateMachine$1(BasePaidScene r100) {
        super(1, r100, BasePaidScene.class, "onStateTransition", "onStateTransition(Lcom/bytedance/android/live/core/utils/StateMachine$Transition;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StateMachine.c<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((BasePaidScene) this.receiver).x0(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.c<? extends l, ? extends j, ? extends k> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
