package com.obric.apptools.sdk.common;

import android.content.Context;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.apptools.sdk.base.log.L;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.olog.Constants;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppMetrics.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010J\u001a\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0001J\u001a\u0010\u001f\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020 J\u001a\u0010!\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0001J\u0014\u0010\"\u001a\u00020\u0015*\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0004J\n\u0010#\u001a\u00020\u0015*\u00020\nJ\u0014\u0010$\u001a\u00020\u0004*\u00020\n2\b\b\u0002\u0010%\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/apptools/sdk/common/AppMetrics;", "", "()V", "TAG", "", "appContext", "Landroid/content/Context;", "appPackageName", "eventCache", "", "Lcom/obric/apptools/sdk/common/Event;", "getEventCache", "()Ljava/util/Map;", "eventCache$delegate", "Lkotlin/Lazy;", "reporterImpl", "Lcom/obric/apptools/sdk/common/IMetricsReporter;", "cacheKeyOf", "event", "eventId", "dumpCache", "", "eventOf", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "scene", "init", "context", "reporter", "addCategory", "key", "value", "addMetrics", "", "addParam", TraceStatsConsts.STATS_KEY_END, Constants.REPORT_FIELD, "start", "needEventId", "", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppMetrics {
    public static final AppMetrics INSTANCE = null;
    private static final String TAG = "AppMetrics";
    private static Context appContext;
    private static String appPackageName;
    private static final Lazy eventCache$delegate = null;
    private static IMetricsReporter reporterImpl;

    private AppMetrics() {
    }

    static {
        INSTANCE = new AppMetrics();
        eventCache$delegate = LazyKt.lazy(AppMetrics$eventCache$2.INSTANCE);
    }

    private final Map<String, Event> getEventCache() {
        return (Map) eventCache$delegate.getValue();
    }

    public final void init(Context r2, IMetricsReporter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "reporter");
        L.d(TAG, "init");
        appContext = r2;
        String r1 = r2.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r1, "context.packageName");
        appPackageName = r1;
        reporterImpl = r3;
        if (r3 == null) goto L6;
        r3.init(r2);
        return;
    }

    public final Event eventOf(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r3, "scene");
        String r0 = appPackageName;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
        r0 = null;
    L6:
        return new Event(r2, r3, r0);
    }

    public final Event addCategory(Event r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r1.getCategoryParams().put(r2, r3);
        return r1;
    L10:
        throw new IllegalArgumentException("key is empty".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final Event addMetrics(Event r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Long r4 = Long.valueOf(r3);
        r1.getMetricsParams().put(r2, r4);
        return r1;
    L10:
        throw new IllegalArgumentException("key is empty".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final Event addParam(Event r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r1.getExtraParams().put(r2, r3);
        return r1;
    L10:
        throw new IllegalArgumentException("key is empty".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ String start$default(AppMetrics r0, Event r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        return r0.start(r1, r2);
    }

    public final String start(Event r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        long r0 = System.currentTimeMillis();
        if (r7 == false) goto L5;
        String r8 = UUID.randomUUID().toString();
    L6:
        Intrinsics.checkNotNullExpressionValue(r8, "if (needEventId) UUID.ra…UUID().toString() else \"\"");
        String r2 = cacheKeyOf(r6, r8);
        if (getEventCache().get(r2) == null) goto L9;
        L.w(TAG, "start, event already exists, overwrite! action: " + r6.getAction() + ", scene: " + r6.getScene() + ", eventId: " + r8);
    L9:
        Map<String, Event> r5 = getEventCache();
        r6.setStartTime(r0);
        r5.put(r2, r6);
        return r8;
    L5:
        r8 = "";
        goto L6
    }

    public static /* synthetic */ void end$default(AppMetrics r0, Event r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = "";
    L5:
        r0.end(r1, r2);
    }

    public final void end(Event r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "eventId");
        long r0 = System.currentTimeMillis();
        Event r2 = getEventCache().remove(cacheKeyOf(r5, r6));
        if (r2 != null) goto L6;
        L.w(TAG, "end, event not found, action: " + r5.getAction() + ", scene: " + r5.getScene() + ", eventId: " + r6);
        return;
    L6:
        r5.setStartTime(r2.getStartTime());
        r5.setEndTime(r0);
        addMetrics(r5, "time_cost", r0 - r5.getStartTime());
        IMetricsReporter r4 = reporterImpl;
        if (r4 == null) goto L10;
        r4.report(r5);
        return;
    }

    public final void report(Event r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        long r0 = System.currentTimeMillis();
        r3.setStartTime(r0);
        r3.setEndTime(r0);
        IMetricsReporter r2 = reporterImpl;
        if (r2 == null) goto L6;
        r2.report(r3);
        return;
    }

    private final String cacheKeyOf(Event r3, String r4) {
        return "metrics_event_" + r3.getAppPackage() + '_' + r3.getScene() + '_' + r3.getAction() + '_' + r4;
    }

    private final void dumpCache() {
        L.v(TAG, "dumpCache >>> size: " + getEventCache().size());
        Iterator<Map.Entry<String, Event>> r4 = getEventCache().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        L.v(TAG, "dumpCache, event: " + r4.next().getKey());
        goto L4
    L6:
        L.v(TAG, "dumpCache <<<");
    }
}
