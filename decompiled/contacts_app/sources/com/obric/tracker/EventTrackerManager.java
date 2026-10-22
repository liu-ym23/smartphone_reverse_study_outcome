package com.obric.tracker;

import android.app.Application;
import com.obric.tracker.impl.SlardarTracker;
import com.obric.tracker.impl.TeaTracker;
import com.obric.tracker.intf.event.IEvent;
import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTrackerManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/tracker/EventTrackerManager;", "", "()V", "TRACKER_TAG", "", "slardarTrackers", "Lcom/obric/tracker/impl/SlardarTracker;", "teaTracker", "Lcom/obric/tracker/impl/TeaTracker;", "endTrack", "", "event", "Lcom/obric/tracker/intf/event/IEvent;", "init", "context", "Landroid/app/Application;", "startTrack", "needEventId", "", "track", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EventTrackerManager {
    public static final EventTrackerManager INSTANCE = null;
    public static final String TRACKER_TAG = "ContactsEventTracker";
    private static final SlardarTracker slardarTrackers = null;
    private static final TeaTracker teaTracker = null;

    private EventTrackerManager() {
    }

    static {
        INSTANCE = new EventTrackerManager();
        teaTracker = new TeaTracker();
        slardarTrackers = new SlardarTracker();
    }

    public final void init(Application r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Application r2 = r1;
        teaTracker.init(r2);
        slardarTrackers.init(r2);
    }

    public final void track(IEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if ((r1 instanceof ITeaEvent) == false) goto L6;
        teaTracker.track(r1);
    L6:
        if ((r1 instanceof ISlardarEvent) == false) goto L9;
        slardarTrackers.track(r1);
        return;
    }

    public static /* synthetic */ void startTrack$default(EventTrackerManager r0, IEvent r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.startTrack(r1, r2);
    }

    public final void startTrack(IEvent r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if ((r1 instanceof ITeaEvent) == false) goto L6;
        teaTracker.start(r1, r2);
    L6:
        if ((r1 instanceof ISlardarEvent) == false) goto L9;
        slardarTrackers.start(r1, r2);
        return;
    }

    public final void endTrack(IEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if ((r1 instanceof ITeaEvent) == false) goto L6;
        teaTracker.end(r1);
    L6:
        if ((r1 instanceof ISlardarEvent) == false) goto L9;
        slardarTrackers.end(r1);
        return;
    }
}
