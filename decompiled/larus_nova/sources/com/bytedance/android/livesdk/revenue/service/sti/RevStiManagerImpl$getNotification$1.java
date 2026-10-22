package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import xr2.j;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "p1", "Lxr2/j;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;)Lxr2/j;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RevStiManagerImpl$getNotification$1 extends FunctionReferenceImpl implements Function1<ShortTermIndicatorEvent, j> {
    public static final RevStiManagerImpl$getNotification$1 INSTANCE = null;

    static {
        INSTANCE = new RevStiManagerImpl$getNotification$1();
    }

    public RevStiManagerImpl$getNotification$1() {
        super(1, g.class, "toRevType", "toRevType(Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;)Lcom/bytedance/android/livesdk/revenue/sti/RevStiEvent;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j invoke2(ShortTermIndicatorEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r100, "$this$toRevType");
        if ((r100 instanceof ShortTermIndicatorEvent.Added) == false) goto L6;
        return new j.a(g.a(r100.getIcon()));
    L6:
        if ((r100 instanceof ShortTermIndicatorEvent.InsertionStarted) == false) goto L9;
        return new j.b(g.a(r100.getIcon()), ((ShortTermIndicatorEvent.InsertionStarted) r100).getFinalPositionOnScreen());
    L9:
        if ((r100 instanceof ShortTermIndicatorEvent.ReInitBigCardAnim) == false) goto L13;
        return new j.c(g.a(r100.getIcon()), ((ShortTermIndicatorEvent.ReInitBigCardAnim) r100).getFinalPositionOnScreen());
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j invoke(ShortTermIndicatorEvent r100) {
        return invoke2(r100);
    }
}
