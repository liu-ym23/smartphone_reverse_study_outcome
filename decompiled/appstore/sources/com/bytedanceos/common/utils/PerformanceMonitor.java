package com.bytedanceos.common.utils;

import com.bytedanceos.common.tracker.TrackerElement;
import com.obric.apptools.sdk.common.AppMetrics;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class PerformanceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PerformanceMonitor f10179a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f10180b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f10181c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f10182d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedanceos/common/utils/PerformanceMonitor$Event;", "", "action", "", "scene", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getScene", "DELETE_DOWNLOAD", "COLD_LAUNCH", "SEARCH", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event COLD_LAUNCH = null;
        public static final Event DELETE_DOWNLOAD = null;
        public static final Event SEARCH = null;

        @NotNull
        private final String action;

        @NotNull
        private final String scene;

        private static final /* synthetic */ Event[] $values() {
            return new Event[]{DELETE_DOWNLOAD, COLD_LAUNCH, SEARCH};
        }

        static {
            DELETE_DOWNLOAD = new Event("DELETE_DOWNLOAD", 0, "delete_download", "my_app_page");
            COLD_LAUNCH = new Event("COLD_LAUNCH", 1, "cold_launch", "cold_launch");
            SEARCH = new Event("SEARCH", 2, "search", "search");
            Event[] r10 = $values();
            $VALUES = r10;
            $ENTRIES = kotlin.enums.a.a(r10);
        }

        private Event(String r10, int r11, String r12, String r13) {
            super(r10, r11);
            this.action = r12;
            this.scene = r13;
        }

        @NotNull
        public static EnumEntries<Event> getEntries() {
            return $ENTRIES;
        }

        public static Event valueOf(String r10) {
            return (Event) Enum.valueOf(Event.class, r10);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        @NotNull
        public final String getAction() {
            return this.action;
        }

        @NotNull
        public final String getScene() {
            return this.scene;
        }
    }

    static {
        f10179a = new PerformanceMonitor();
        f10180b = new LinkedHashSet();
        f10181c = new LinkedHashMap();
        f10182d = new LinkedHashMap();
    }

    public PerformanceMonitor() {
    }

    public static final void a(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() == 0) goto L15;
        Map r11 = f10181c;
        if (r11.containsKey(r10) == false) goto L16;
        long r12 = System.currentTimeMillis();
        Long r13 = (Long) r11.get(r10);
        if (r13 == null) goto L14;
        long r14 = r13.longValue();
        AppMetrics r15 = AppMetrics.f11123a;
        AppMetrics.e(r15, r15.b(r15.b(r15.f(TrackerElement.INSTALL, TrackerElement.INSTALL), TrackerElement.PACKAGE_NAME, r10), "install_time", Long.valueOf(r12 - r14)), null, 1, null);
        r11.put(r10, Long.valueOf(System.currentTimeMillis()));
        return;
    L14:
        return;
    L16:
        return;
    }

    public static final void b(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() == 0) goto L12;
        Map r11 = f10181c;
        if (r11.containsKey(r10) == true) goto L13;
        r11.put(r10, Long.valueOf(System.currentTimeMillis()));
        return;
    L13:
        return;
    }

    @JvmStatic
    public static final void end(@NotNull Event r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        Set r11 = f10180b;
        if (r11.contains(r10) == true) goto L5;
        return;
    L5:
        r11.remove(r10);
        AppMetrics r12 = AppMetrics.f11123a;
        AppMetrics.e(r12, r12.f(r10.getAction(), r10.getScene()), null, 1, null);
    }

    @JvmStatic
    public static final void start(@NotNull Event r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        Set r11 = f10180b;
        if (r11.contains(r10) == false) goto L5;
        return;
    L5:
        r11.add(r10);
        AppMetrics r12 = AppMetrics.f11123a;
        AppMetrics.j(r12, r12.f(r10.getAction(), r10.getScene()), false, 1, null);
    }
}
