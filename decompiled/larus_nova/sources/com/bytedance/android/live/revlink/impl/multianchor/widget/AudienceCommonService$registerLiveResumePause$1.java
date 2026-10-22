package com.bytedance.android.live.revlink.impl.multianchor.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class AudienceCommonService$registerLiveResumePause$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $onStatusChange;
    final /* synthetic */ c this$0;

    public AudienceCommonService$registerLiveResumePause$1(c r100, Function1 r101) {
        this.this$0 = r100;
        this.$onStatusChange = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<Function1<Boolean, Unit>> r100 = this.this$0.f95129b;
        ArrayList r101 = (ArrayList) r100;
        r101.remove(this.$onStatusChange);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
