package com.bytedance.android.livesdk.revenue.experience;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lr71/e;", "p1", "Lcom/bytedance/android/livesdk/revenue/experience/a;", AbsMethodDelegate.TAG_INVOKE, "(Lr71/e;)Lcom/bytedance/android/livesdk/revenue/experience/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RevCardStateDispatcherImpl$lifecycleState$1 extends FunctionReferenceImpl implements Function1<r71.e, a> {
    public static final RevCardStateDispatcherImpl$lifecycleState$1 INSTANCE = null;

    static {
        INSTANCE = new RevCardStateDispatcherImpl$lifecycleState$1();
    }

    public RevCardStateDispatcherImpl$lifecycleState$1() {
        super(1, e.class, "toRevType", "toRevType(Lcom/bytedance/android/live/room/api/messagewindow/state/source/CardStateSource;)Lcom/bytedance/android/livesdk/revenue/experience/IRevCardStateSource;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2(r71.e r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r100, "$this$toRevType");
        return new d(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a invoke(r71.e r100) {
        return invoke2(r100);
    }
}
