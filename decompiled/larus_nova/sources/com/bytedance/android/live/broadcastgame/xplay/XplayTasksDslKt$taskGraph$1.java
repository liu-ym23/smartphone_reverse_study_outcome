package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayCompositeTaskBuilderScopeImpl;", "", "Lcom/bytedance/android/live/broadcastgame/xplay/j1;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/broadcastgame/xplay/XplayCompositeTaskBuilderScopeImpl;Ljava/util/List;)Lcom/bytedance/android/live/broadcastgame/xplay/j1;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class XplayTasksDslKt$taskGraph$1 extends Lambda implements Function2<XplayCompositeTaskBuilderScopeImpl, List<? extends j1>, j1> {
    public static final XplayTasksDslKt$taskGraph$1 INSTANCE = null;

    static {
        INSTANCE = new XplayTasksDslKt$taskGraph$1();
    }

    public XplayTasksDslKt$taskGraph$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ j1 invoke(XplayCompositeTaskBuilderScopeImpl r100, List<? extends j1> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j1 invoke2(XplayCompositeTaskBuilderScopeImpl r100, List<? extends j1> r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.getClass();
        return new h1(r101, new XplayCompositeTaskBuilderScopeImpl$makeOnStateChanged$1(r100));
    }
}
