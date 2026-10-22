package com.obric.tracker.intf.tracker;

import android.content.Context;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.tracker.intf.event.IEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: ITracker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/obric/tracker/intf/tracker/ITracker;", "", TraceStatsConsts.STATS_KEY_END, "", "event", "Lcom/obric/tracker/intf/event/IEvent;", "init", "context", "Landroid/content/Context;", "start", "needEventId", "", "track", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ITracker {

    /* JADX INFO: compiled from: ITracker.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void start$default(ITracker r0, IEvent r1, boolean r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = true;
        L6:
            r0.start(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void end(IEvent r1);

    void init(Context r1);

    void start(IEvent r1, boolean r2);

    void track(IEvent r1);
}
