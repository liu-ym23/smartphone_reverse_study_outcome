package com.bytedance.android.livesdk.vscore_impl.component.tabs.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public final class TabTeaMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f160009a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/utils/TabTeaMonitor$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "", "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "HybridTabLynxViewLoad", "HorizonTabDialogDuration", "MultiTabDataLoad", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event HorizonTabDialogDuration = null;
        public static final Event HybridTabLynxViewLoad = null;
        public static final Event MultiTabDataLoad = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f160010a = null;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        static {
            Event r100 = new Event("HybridTabLynxViewLoad", 0, "live_multitab_webtab_load", false, false, 6, null);
            HybridTabLynxViewLoad = r100;
            Event r101 = new Event("HorizonTabDialogDuration", 1, "live_multitab_horizontal_duration", false, false, 6, null);
            HorizonTabDialogDuration = r101;
            Event r102 = new Event("MultiTabDataLoad", 2, "live_multitab_data_error", false, false, 6, null);
            MultiTabDataLoad = r102;
            f160010a = new Event[]{r100, r101, r102};
        }

        public Event() {
            throw null;
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f160010a.clone();
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

        public Event(String r100, int r101, String r102, boolean r103, boolean r104, int r105, DefaultConstructorMarker r106) {
            if ((r105 & 2) == 0) goto L6;
            r103 = false;
        L6:
            if ((r105 & 4) == 0) goto L8;
            r104 = true;
        L8:
            super(r100, r101);
            this.eventName = r102;
            this.extraALog = r103;
            this.reportInLocalTest = r104;
        }
    }

    static {
    }

    public static void a(HashMap r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
    L7:
        e = move-exception;
        ALogger.e("TabTeaMonitor", e);
        return;
    L4:
        if (r100.containsKey(r101) == true) goto L12;
        r100.put(r101, r102);     // Catch: Exception -> L7
        return;
    }
}
