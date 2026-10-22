package com.obric.tracker;

import com.GlobalProxyLancet;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.tracker.event.CallScreenShowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallScreenShowUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/obric/tracker/CallScreenShowUtils;", "", "()V", "TAG", "", "event", "Lcom/obric/tracker/event/CallScreenShowEvent;", "getEvent", "()Lcom/obric/tracker/event/CallScreenShowEvent;", "setEvent", "(Lcom/obric/tracker/event/CallScreenShowEvent;)V", TraceStatsConsts.STATS_KEY_END, "", "start", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallScreenShowUtils {
    public static final CallScreenShowUtils INSTANCE = null;
    public static final String TAG = "CallScreenShowUtils";
    private static CallScreenShowEvent event;

    static {
        INSTANCE = new CallScreenShowUtils();
    }

    private CallScreenShowUtils() {
    }

    public final CallScreenShowEvent getEvent() {
        return event;
    }

    public final void setEvent(CallScreenShowEvent r1) {
        event = r1;
    }

    public final void start(CallScreenShowEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        event = r4;
        EventTrackerManager.startTrack$default(EventTrackerManager.INSTANCE, r4, false, 2, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "CallScreenShowUtils start");
    }

    public final void end() {
        CallScreenShowEvent r1 = event;
        if (r1 != null) goto L5;
        return;
    L5:
        EventTrackerManager.INSTANCE.endTrack(r1);
        event = null;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(EventTrackerManager.TRACKER_TAG, "CallScreenShowUtils end");
    }
}
