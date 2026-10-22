package com.bytedance.android.livesdk.vscore_impl.component.tabs.utils;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public final class TabSlardarMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f160007a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/utils/TabSlardarMonitor$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "", "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "HybridTabLynxViewLoad", "MultiTabChange", "MultiTabDataLoad", "HorizonTabDialogDuration", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event HorizonTabDialogDuration = null;
        public static final Event HybridTabLynxViewLoad = null;
        public static final Event MultiTabChange = null;
        public static final Event MultiTabDataLoad = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f160008a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        static {
            LiveTracingMonitor.EventModule r210 = LiveTracingMonitor.EventModule.MULTI_TAB;
            Event r110 = new Event("HybridTabLynxViewLoad", 0, "live_multitab_webtab_load", r210, false, false, 12, null);
            HybridTabLynxViewLoad = r110;
            Event r100 = new Event("MultiTabChange", 1, "live_multitab_page_selected", r210, false, false, 12, null);
            MultiTabChange = r100;
            Event r101 = new Event("MultiTabDataLoad", 2, "live_multitab_data_error", r210, false, false, 12, null);
            MultiTabDataLoad = r101;
            Event r102 = new Event("HorizonTabDialogDuration", 3, "live_multitab_horizontal_duration", r210, false, false, 12, null);
            HorizonTabDialogDuration = r102;
            f160008a = new Event[]{r110, r100, r101, r102};
        }

        public Event() {
            throw null;
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f160008a.clone();
        }

        public final LiveTracingMonitor.EventModule getEventModule() {
            return this.eventModule;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final boolean getExtraALog() {
            return this.extraALog;
        }

        public final boolean getReportInLocalTest() {
            return this.reportInLocalTest;
        }

        public Event(String r100, int r101, String r102, LiveTracingMonitor.EventModule r103, boolean r104, boolean r105, int r106, DefaultConstructorMarker r107) {
            if ((r106 & 4) == 0) goto L6;
            r104 = false;
        L6:
            if ((r106 & 8) == 0) goto L8;
            r105 = true;
        L8:
            super(r100, r101);
            this.eventName = r102;
            this.eventModule = r103;
            this.extraALog = r104;
            this.reportInLocalTest = r105;
        }
    }

    static {
    }
}
