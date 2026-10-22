package com.bytedance.android.livesdk.chatroom.vs_base.metrics;

import am2.b0;
import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.dypay.api.DyPayConstant;
import cr1.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/metrics/ReplayUILatch;", "", "", BasicTestActionHandler.TEST_ACTION_RESET, "Lcr1/a;", "uiShowData", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "countDown", "report", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "countDownSet", "Ljava/util/HashSet;", "", DyPayConstant.KEY_START_TIME, "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "maxTime", "J", "", "Lcom/bytedance/android/livesdk/chatroom/vs_base/metrics/ReplayUIMetrics;", "uiMetricsSet", "Ljava/util/Set;", "", "eventName", "Ljava/lang/String;", "MAIN_UI", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayUILatch extends Enum<ReplayUILatch> {
    public static final ReplayUILatch MAIN_UI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayUILatch[] f118030a = null;
    private final HashSet<a> countDownSet;
    private final String eventName;
    private long maxTime;
    private Long startTime;
    private final Set<ReplayUIMetrics> uiMetricsSet;

    static {
        ReplayUILatch r100 = new ReplayUILatch(SetsKt.setOf(new ReplayUIMetrics[]{ReplayUIMetrics.TOOLBAR, ReplayUIMetrics.EXPAND_AREA, ReplayUIMetrics.BACK_GROUND}));
        MAIN_UI = r100;
        f118030a = new ReplayUILatch[]{r100};
    }

    public static ReplayUILatch valueOf(String r100) {
        return (ReplayUILatch) r27.a.a(ReplayUILatch.class, r100);
    }

    public static ReplayUILatch[] values() {
        return (ReplayUILatch[]) f118030a.clone();
    }

    public final void reset() {
        this.countDownSet.clear();
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public ReplayUILatch(Set r100) {
        super("MAIN_UI", 0);
        this.uiMetricsSet = r100;
        this.eventName = "vs_video_main_ui";
        this.countDownSet = new HashSet();
        this.maxTime = -1;
    }

    public final void report(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Long r101 = this.startTime;
        if (r101 == null) goto L17;
        r101.longValue();
        Long r102 = this.startTime;
        Intrinsics.checkNotNull(r102);
        if (r102.longValue() >= 0) goto L7;
        return;
    L7:
        HashMap r103 = new HashMap();
        Iterator<T> r104 = this.countDownSet.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        a r105 = (a) r104.next();
        long r106 = r105.f465035b;
        Long r107 = this.startTime;
        Intrinsics.checkNotNull(r107);
        r103.put(r105.f465034a.name(), String.valueOf(r106 - r107.longValue()));
        goto L9
    L11:
        long r108 = this.maxTime;
        Long r109 = this.startTime;
        Intrinsics.checkNotNull(r109);
        long r110 = r108 - r109.longValue();
        o r111 = d.a(r100).c(b0.class);
        if (r111 == null) goto L14;
        r111.a(r103);
    L14:
        r103.put("duration", String.valueOf(r110));
        d.a(r100).d(this.eventName, r103, new Object[]{IRoom.class});
        return;
    }

    public final void setStartTime(Long r100) {
        this.startTime = r100;
    }

    public final void countDown(a r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "uiShowData");
        if (r101 != null) goto L5;
        return;
    L5:
        Long r102 = this.startTime;
        if (r102 == null) goto L25;
        r102.longValue();
        Long r103 = this.startTime;
        Intrinsics.checkNotNull(r103);
        if (r103.longValue() >= 0) goto L10;
        return;
    L10:
        ReplayUIMetrics r104 = r100.f465034a;
        Iterator<T> r105 = this.countDownSet.iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        if (((a) r105.next()).f465034a != r104) goto L12;
        return;
    L17:
        if (this.uiMetricsSet.contains(r104) == false) goto L26;
        this.countDownSet.add(r100);
        this.maxTime = r100.f465035b;
        if (this.uiMetricsSet.size() != this.countDownSet.size()) goto L27;
        report(r101);
        return;
    L27:
        return;
    L26:
        return;
    }
}
