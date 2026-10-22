package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/util/f;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/dslservice/util/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class AirPerformanceMonitor$onUpdate$1 extends Lambda implements Function1<com.bytedance.android.livesdk.dslservice.util.f, Unit> {
    final /* synthetic */ JSONObject $bulletMetrics;

    public AirPerformanceMonitor$onUpdate$1(JSONObject r100) {
        this.$bulletMetrics = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.dslservice.util.f r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f122972b = this.$bulletMetrics.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.dslservice.util.f r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
