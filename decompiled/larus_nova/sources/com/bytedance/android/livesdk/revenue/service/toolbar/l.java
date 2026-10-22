package com.bytedance.android.livesdk.revenue.service.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<RevToolbarConstants, com.bytedance.android.livesdk.chatroom.viewmodel.c> f157473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f157474b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final IAnimationScheduler f() {
        IAnimationScheduler.Companion r100 = IAnimationScheduler.M0;
        DataCenter r101 = (DataCenter) this.f157474b.a().b(vp2.a.f556611d);
        r100.getClass();
        return IAnimationScheduler.Companion.a(r101);
    }

    public l(com.bytedance.android.live.revenue.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f157474b = r100;
        this.f157473a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.toolbar.b
    public final void ro(RevToolbarConstants r100) {
        Intrinsics.checkNotNullParameter(r100, "constants");
        com.bytedance.android.livesdk.chatroom.viewmodel.c r101 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) ((LinkedHashMap) this.f157473a).get(r100);
        if (r101 == null) goto L7;
        IAnimationScheduler r102 = f();
        if (r102 == null) goto L7;
        r102.unRegisterListener(r101);
    L7:
        this.f157473a.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.toolbar.b
    public final void s0(RevToolbarConstants r100) {
        Intrinsics.checkNotNullParameter(r100, "constants");
        Intrinsics.checkNotNullParameter(r100, "$this$toAnimationSchedulerListener");
        if (j.f157468b[r100.ordinal()] == 1) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodel.a.c r101 = null;
    L6:
        if (r101 == null) goto L11;
        IAnimationScheduler r102 = f();
        if (r102 == null) goto L12;
        r102.requestAnimationAtOnce(r101);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = com.bytedance.android.livesdk.chatroom.viewmodel.a.c.f114775b;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.service.toolbar.b
    public final void g4(RevToolbarConstants r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "constants");
        Intrinsics.checkNotNullParameter(r101, "scheduler");
        final k r102 = new k(this, r101, r100);
        this.f157473a.put(r100, r102);
        IAnimationScheduler r103 = f();
        if (r103 == null) goto L5;
        r103.registerListener(r102);
        return;
    L5:
        IAnimationScheduler.Companion r104 = IAnimationScheduler.M0;
        DataCenter r105 = (DataCenter) this.f157474b.a().b(vp2.a.f556611d);
        Function1<IAnimationScheduler, Unit> r106 = new RevToolbarAnimServiceImpl$registerListener$1(r102);
        r104.getClass();
        IAnimationScheduler.Companion.d(r105, r106);
    }
}
