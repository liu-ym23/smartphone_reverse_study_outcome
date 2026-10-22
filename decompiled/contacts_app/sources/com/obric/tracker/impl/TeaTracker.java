package com.obric.tracker.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.GlobalProxyLancet;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.intf.event.IEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import com.obric.tracker.intf.tracker.ITracker;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TeaTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/obric/tracker/impl/TeaTracker;", "Lcom/obric/tracker/intf/tracker/ITracker;", "()V", "eventCache", "", "", "", "getEventCache", "()Ljava/util/Map;", "eventCache$delegate", "Lkotlin/Lazy;", "cacheKeyOf", "eventName", TraceStatsConsts.STATS_KEY_END, "", "event", "Lcom/obric/tracker/intf/event/IEvent;", "init", "context", "Landroid/content/Context;", "start", "needEventId", "", "track", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TeaTracker implements ITracker {
    public static final Companion Companion = null;
    private static final String TAG = "TeaTracker";
    private final Lazy eventCache$delegate;

    /* JADX INFO: compiled from: TeaTracker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/tracker/impl/TeaTracker$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TeaTracker() {
        this.eventCache$delegate = LazyKt.lazy(TeaTracker$eventCache$2.INSTANCE);
    }

    private final Map<String, Long> getEventCache() {
        return (Map) this.eventCache$delegate.getValue();
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void init(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        PackageInfo r4 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 0);
        long r0 = r4.getLongVersionCode();
        String r6 = r4.versionName;
        if (r6 != null) goto L5;
        r6 = BuildConfig.VERSION_NAME;
    L5:
        MatrixTeaConfig r7 = new MatrixTeaConfig.Builder().setPackageName("com.android.contacts").setVersionCode((int) r0).setVersionName(r6).build();
        MatrixTeaManager.Companion.init(r5, r7);
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void track(IEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof ITeaEvent) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "TeaTracker event is not ITeaEvent");
        return;
    L7:
        if (MatrixTeaManager.Companion.isInited() == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "TeaTracker track skipped, MatrixTeaManager not inited, eventName = " + ((ITeaEvent) r3).getEventName());
        return;
    L10:
        ITeaEvent r4 = (ITeaEvent) r3;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "TeaTracker track, eventName = " + r4.getEventName());
        MatrixTeaManager.Companion.getInstance().onEvent(r4.getEventName(), r4.getEventParams());
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void start(IEvent r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof ITeaEvent) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "TeaTracker event is not ITeaEvent");
        return;
    L6:
        long r1 = System.currentTimeMillis();
        ITeaEvent r8 = (ITeaEvent) r6;
        String r9 = cacheKeyOf(r8.getEventName());
        if (getEventCache().get(r9) == null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "TeaTracker start, event already exists, overwrite! event name: " + r8.getEventName());
    L9:
        getEventCache().put(r9, Long.valueOf(r1));
    }

    @Override // com.obric.tracker.intf.tracker.ITracker
    public void end(IEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if ((r7 instanceof ITeaEvent) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "TeaTracker event is not ITeaEvent");
        return;
    L7:
        if (MatrixTeaManager.Companion.isInited() == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "TeaTracker end skipped, MatrixTeaManager not inited, eventName = " + ((ITeaEvent) r7).getEventName());
        return;
    L10:
        long r2 = System.currentTimeMillis();
        ITeaEvent r8 = (ITeaEvent) r7;
        String r0 = cacheKeyOf(r8.getEventName());
        Long r4 = getEventCache().get(r0);
        if (r4 != null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(EventTrackerManager.TRACKER_TAG, "TeaTracker end, event not found, event name: " + r8.getEventName());
        return;
    L14:
        long r3 = r2 - r4.longValue();
        getEventCache().remove(r0);
        JSONObject r6 = r8.getEventParams();
        r6.put("time_cost", r3);
        MatrixTeaManager.Companion.getInstance().onEvent(r8.getEventName(), r6);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "TeaTracker TeaTracker end, eventName = " + r8.getEventName() + ", timeCost = " + r3);
    }

    private final String cacheKeyOf(String r2) {
        return "tea_event_" + r2;
    }
}
