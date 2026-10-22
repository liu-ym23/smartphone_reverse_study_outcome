package com.obric.tracker.impl;

import android.content.Context;
import com.GlobalProxyLancet;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.apptools.sdk.common.AppMetrics;
import com.obric.apptools.sdk.common.Event;
import com.obric.apptools.sdk.common.IMetricsReporter;
import com.obric.apptools.sdk.common.SlardarOsExt;
import com.obric.olog.Constants;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.intf.event.IEvent;
import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.tracker.ITracker;
import com.slardaros.client.AgentEvent;
import com.slardaros.client.MetricEvent;
import com.slardaros.client.SlardarAgent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlardarTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/tracker/impl/SlardarTracker;", "Lcom/obric/tracker/intf/tracker/ITracker;", "()V", TraceStatsConsts.STATS_KEY_END, "", "event", "Lcom/obric/tracker/intf/event/IEvent;", "init", "context", "Landroid/content/Context;", "start", "needEventId", "", "track", "Companion", "SlardarOsReporter", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SlardarTracker implements ITracker {
    public static final Companion Companion = null;
    private static final String TAG = "SlardarTracker";
    private static volatile boolean isInitialized;

    /* JADX INFO: compiled from: SlardarTracker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/tracker/impl/SlardarTracker$Companion;", "", "()V", "TAG", "", "isInitialized", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: SlardarTracker.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/tracker/impl/SlardarTracker$SlardarOsReporter;", "Lcom/obric/apptools/sdk/common/IMetricsReporter;", "(Lcom/obric/tracker/impl/SlardarTracker;)V", "init", "", "context", "Landroid/content/Context;", Constants.REPORT_FIELD, "event", "Lcom/obric/apptools/sdk/common/Event;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class SlardarOsReporter implements IMetricsReporter {
        final /* synthetic */ SlardarTracker this$0;

        public SlardarOsReporter(SlardarTracker r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.apptools.sdk.common.IMetricsReporter
        public void init(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            SlardarAgent.init(r1);
        }

        @Override // com.obric.apptools.sdk.common.IMetricsReporter
        public void report(Event r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            SlardarAgent.onAgentEventList(CollectionsKt.arrayListOf(new AgentEvent[]{new MetricEvent(r3.getEventName(), SlardarOsExt.INSTANCE.constructSlardarParams(r3))}));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SlardarTracker() {
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void init(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppMetrics.INSTANCE.init(r3, new SlardarOsReporter(this));
        isInitialized = true;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker init done");
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void track(IEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if ((r8 instanceof ISlardarEvent) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker event is not ISlardarEvent");
        return;
    L7:
        if (isInitialized == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "SlardarTracker track skipped, AppMetrics not initialized, scene = " + ((ISlardarEvent) r8).getScene());
        return;
    L10:
        ISlardarEvent r9 = (ISlardarEvent) r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker track, scene = " + r9.getScene());
        AppMetrics r7 = AppMetrics.INSTANCE;
        Event r0 = AppMetrics.INSTANCE.eventOf(r9.mo779getAction(), r9.getScene());
        Iterator<Map.Entry<String, Object>> r1 = r9.getCategoryParams().entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, Object> r2 = r1.next();
        AppMetrics.INSTANCE.addCategory(r0, r2.getKey(), r2.getValue());
        goto L12
    L14:
        Iterator<Map.Entry<String, Long>> r3 = r9.getMetricsParams().entrySet().iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        Map.Entry<String, Long> r4 = r3.next();
        AppMetrics.INSTANCE.addMetrics(r0, r4.getKey(), r4.getValue().longValue());
        goto L16
    L18:
        Iterator<Map.Entry<String, Object>> r10 = r9.getExtraParams().entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        Map.Entry<String, Object> r5 = r10.next();
        AppMetrics.INSTANCE.addParam(r0, r5.getKey(), r5.getValue());
        goto L20
    L22:
        r7.report(r0);
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void start(IEvent r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if ((r8 instanceof ISlardarEvent) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker event is not ISlardarEvent");
        return;
    L7:
        if (isInitialized == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "SlardarTracker start skipped, AppMetrics not initialized, scene = " + ((ISlardarEvent) r8).getScene());
        return;
    L10:
        ISlardarEvent r10 = (ISlardarEvent) r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker start, scene = " + r10.getScene());
        AppMetrics r7 = AppMetrics.INSTANCE;
        Event r0 = AppMetrics.INSTANCE.eventOf(r10.mo779getAction(), r10.getScene());
        Iterator<Map.Entry<String, Object>> r1 = r10.getCategoryParams().entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, Object> r2 = r1.next();
        AppMetrics.INSTANCE.addCategory(r0, r2.getKey(), r2.getValue());
        goto L12
    L14:
        Iterator<Map.Entry<String, Long>> r3 = r10.getMetricsParams().entrySet().iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        Map.Entry<String, Long> r4 = r3.next();
        AppMetrics.INSTANCE.addMetrics(r0, r4.getKey(), r4.getValue().longValue());
        goto L16
    L18:
        Iterator<Map.Entry<String, Object>> r5 = r10.getExtraParams().entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        Map.Entry<String, Object> r6 = r5.next();
        AppMetrics.INSTANCE.addParam(r0, r6.getKey(), r6.getValue());
        goto L20
    L22:
        r10.setEventId(r7.start(r0, r9));
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void end(IEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if ((r8 instanceof ISlardarEvent) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker event is not ISlardarEvent");
        return;
    L7:
        if (isInitialized == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "SlardarTracker end skipped, AppMetrics not initialized, scene = " + ((ISlardarEvent) r8).getScene());
        return;
    L10:
        ISlardarEvent r9 = (ISlardarEvent) r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "SlardarTracker end, scene = " + r9.getScene() + ", eventId = " + r9.getEventId());
        AppMetrics r7 = AppMetrics.INSTANCE;
        Event r0 = AppMetrics.INSTANCE.eventOf(r9.mo779getAction(), r9.getScene());
        Iterator<Map.Entry<String, Object>> r1 = r9.getCategoryParams().entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, Object> r2 = r1.next();
        AppMetrics.INSTANCE.addCategory(r0, r2.getKey(), r2.getValue());
        goto L12
    L14:
        Iterator<Map.Entry<String, Long>> r3 = r9.getMetricsParams().entrySet().iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        Map.Entry<String, Long> r4 = r3.next();
        AppMetrics.INSTANCE.addMetrics(r0, r4.getKey(), r4.getValue().longValue());
        goto L16
    L18:
        Iterator<Map.Entry<String, Object>> r5 = r9.getExtraParams().entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        Map.Entry<String, Object> r6 = r5.next();
        AppMetrics.INSTANCE.addParam(r0, r6.getKey(), r6.getValue());
        goto L20
    L22:
        r7.end(r0, r9.getEventId());
    }
}
