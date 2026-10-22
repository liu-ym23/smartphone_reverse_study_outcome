package com.bytedance.android.livesdk.revenue.service.sti;

import am2.x;
import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.ShortTermIndicatorUtils;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.android.livesdkapi.thirdrow.ThirdRowContentCount;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RevStiServiceImpl extends AsyncService implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f157446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RevStiFrameworkImpl f157447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ThirdRowContentCount f157448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f157449g;

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final void Io() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final xr2.d Mb() {
        RevStiFrameworkImpl r100 = this.f157447e;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final xr2.e X8() {
        e r100 = this.f157446d;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final m<Integer> cd() {
        ThirdRowContentCount r100 = this.f157448f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getShortTouchCount();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final m<Integer> sh() {
        ThirdRowContentCount r100 = this.f157448f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getActivityBannerCount();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final m<Integer> u8() {
        ThirdRowContentCount r100 = this.f157448f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNormalBannerCount();
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService, com.bytedance.android.scope.o
    public final void onStop() {
        super.onStop();
        this.f157446d = null;
        this.f157447e = null;
    }

    public RevStiServiceImpl(com.bytedance.android.live.revenue.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f157449g = r100;
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r110) {
        if ((r110 instanceof RevStiServiceImpl$onStartAsync$1) == false) goto L7;
        RevStiServiceImpl$onStartAsync$1 r100 = (RevStiServiceImpl$onStartAsync$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        RevStiFrameworkImpl r104 = null;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        RevStiServiceImpl r105 = (RevStiServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L34:
        IShortTermIconFramework r112 = (IShortTermIconFramework) r111;
        if (r112 == null) goto L37;
        r104 = new RevStiFrameworkImpl(r112);
    L37:
        r105.f157447e = r104;
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        RevStiServiceImpl r106 = (RevStiServiceImpl) r100.L$2;
        RoomContext r107 = (RoomContext) r100.L$1;
        RevStiServiceImpl r108 = (RevStiServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
        RevStiServiceImpl r109 = r106;
        RevStiServiceImpl r113 = r108;
        RoomContext r114 = r107;
    L26:
        IShortTermIndicatorManager r115 = (IShortTermIndicatorManager) r111;
        if (r115 == null) goto L29;
        e r116 = new e(r115);
    L30:
        r109.f157446d = r116;
        j<IShortTermIconFramework> r117 = r114.getShortTermIconFramework();
        r100.L$0 = r113;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 3;
        r111 = ey0.e.a(r117, r100);
        if (r111 != r102) goto L33;
        return r102;
    L33:
        r105 = r113;
        goto L34
    L29:
        r116 = null;
        goto L30
    L17:
        r113 = (RevStiServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L22:
        RoomContext r118 = (RoomContext) r111;
        r113.f157448f = r118.getThirdRowContentCount().getValue();
        j<IShortTermIndicatorManager> r119 = r118.getShortTermIndicatorManager();
        r100.L$0 = r113;
        r100.L$1 = r118;
        r100.L$2 = r113;
        r100.label = 2;
        Object r120 = ey0.e.a(r119, r100);
        if (r120 != r102) goto L25;
        return r102;
    L25:
        r114 = r118;
        r111 = r120;
        r109 = r113;
        goto L26
    L18:
        ResultKt.throwOnFailure(r111);
        vh6.a r121 = this.f157449g.a();
        vh6.d<RoomContext> r122 = vp2.a.f556608a;
        r100.L$0 = this;
        r100.label = 1;
        r111 = r121.a(r122, r100);
        if (r111 != r102) goto L21;
        return r102;
    L21:
        r113 = this;
    L7:
        r100 = new RevStiServiceImpl$onStartAsync$1(this, r110);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final void Bl(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Lazy r102 = ShortTermIndicatorUtils.f106541a;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", r100), TuplesKt.to("task_name", r101), TuplesKt.to("status", "normal")});
        j0.l().sendLog("short_task_banner_click", r103, new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final void Zg(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Lazy r102 = ShortTermIndicatorUtils.f106541a;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", r100), TuplesKt.to("task_name", r101), TuplesKt.to("status", "normal")});
        j0.l().sendLog("short_task_banner_show", r103, new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final void I2(String r100, String r101, String r102, long r103, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Intrinsics.checkNotNullParameter(r102, "strategyId");
        Lazy r104 = ShortTermIndicatorUtils.f106541a;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Intrinsics.checkNotNullParameter(r102, "strategyId");
        Map<String, String> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", r100), TuplesKt.to("task_name", r101), TuplesKt.to("temp_strategy_id", r102), TuplesKt.to("temp_show_duration", String.valueOf(r103)), TuplesKt.to("status", "temp")});
        if (r110 == null) goto L5;
        r105.putAll(r110);
    L5:
        j0.l().sendLog("short_task_banner_show", r105, new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.a
    public final void On(String r100, String r101, String r102, long r103, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Intrinsics.checkNotNullParameter(r102, "strategyId");
        Lazy r104 = ShortTermIndicatorUtils.f106541a;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        Intrinsics.checkNotNullParameter(r102, "strategyId");
        Map<String, String> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", r100), TuplesKt.to("task_name", r101), TuplesKt.to("temp_strategy_id", r102), TuplesKt.to("temp_show_duration", String.valueOf(r103)), TuplesKt.to("status", "temp")});
        if (r110 == null) goto L5;
        r105.putAll(r110);
    L5:
        j0.l().sendLog("short_task_banner_click", r105, new Object[]{Room.class, x.class});
    }
}
