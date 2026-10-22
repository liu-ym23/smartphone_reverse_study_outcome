package com.bytedance.android.ec.hybrid.data.network;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Scheduler;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECHybridNetworkTask$Companion$prepareSchedulerIfNeed$1 extends Lambda implements Function0<Unit> {
    public static final ECHybridNetworkTask$Companion$prepareSchedulerIfNeed$1 INSTANCE = null;

    static {
        INSTANCE = new ECHybridNetworkTask$Companion$prepareSchedulerIfNeed$1();
    }

    public ECHybridNetworkTask$Companion$prepareSchedulerIfNeed$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Lazy r100 = ECHybridNetworkTask.f46759h;
        if (ECHybridNetworkTask.b.a().getPrepareEnable() == true) goto L5;
        return;
    L5:
        List<String> r101 = ECHybridNetworkTask.b.a().getSingleThreadUrls();
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        Scheduler r104 = (Scheduler) ECHybridNetworkTask.f46760i.getValue();
    L14:
        List<String> r105 = ECHybridNetworkTask.b.a().getThreadPoolUrls();
        if (r105 != null) goto L17;
    L20:
        if (r102 == true) goto L23;
        Scheduler r106 = (Scheduler) ECHybridNetworkTask.f46761j.getValue();
        return;
    L23:
        return;
    L17:
        if (r105.isEmpty() == true) goto L20;
        r102 = false;
        goto L20
    L8:
        if (r101.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
