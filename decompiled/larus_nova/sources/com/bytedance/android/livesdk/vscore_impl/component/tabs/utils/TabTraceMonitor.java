package com.bytedance.android.livesdk.vscore_impl.component.tabs.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public final class TabTraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f160011a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/utils/TabTraceMonitor$Event;", "", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "businessType", "getBusinessType", "productId", "getProductId", "", "needRoomCommonParams", "Z", "getNeedRoomCommonParams", "()Z", "MultiTabChange", "HorizonTabDialogShow", "MultitabLoad", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event HorizonTabDialogShow = null;
        public static final Event MultiTabChange = null;
        public static final Event MultitabLoad = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f160012a = null;
        private final String businessType;
        private final String eventType;
        private final boolean needRoomCommonParams;
        private final String productId;

        static {
            Event r110 = new Event("MultiTabChange", 0, "live_multitab_page_selected", null, null, false, 14, null);
            MultiTabChange = r110;
            Event r100 = new Event("HorizonTabDialogShow", 1, "live_multitab_horizontal_show", null, null, false, 14, null);
            HorizonTabDialogShow = r100;
            Event r101 = new Event("MultitabLoad", 2, "live_multitab_load", null, null, false, 14, null);
            MultitabLoad = r101;
            f160012a = new Event[]{r110, r100, r101};
        }

        public Event() {
            throw null;
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f160012a.clone();
        }

        public final String getBusinessType() {
            return this.businessType;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final boolean getNeedRoomCommonParams() {
            return this.needRoomCommonParams;
        }

        public final String getProductId() {
            return this.productId;
        }

        public Event(String r100, int r101, String r102, String r103, String r104, boolean r105, int r106, DefaultConstructorMarker r107) {
            if ((r106 & 2) == 0) goto L6;
            r103 = "live_multitab";
        L6:
            if ((r106 & 4) == 0) goto L9;
            r104 = "webcast_client_community";
        L9:
            if ((r106 & 8) == 0) goto L11;
            r105 = true;
        L11:
            super(r100, r101);
            this.eventType = r102;
            this.businessType = r103;
            this.productId = r104;
            this.needRoomCommonParams = r105;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/utils/TabTraceMonitor$MultitabLinkEvent;", "", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "MultiTabLoadStart", "MultitabLoadDataInit", "MultitabLoadNeedSelectTabId", "MultitabPerformance", "MultitabContainerInit", "MultitabHybridfragmentInit", "MultitabContainerAddHybrid", "MultitabContainerAddHybridAlreadyExist", "MultitabContainerAddHybridInwindow", "MultitabNativeTabInit", "MultitabWebtabLoad", "MultitabWebtabNotify", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MultitabLinkEvent extends Enum<MultitabLinkEvent> {
        public static final MultitabLinkEvent MultiTabLoadStart = null;
        public static final MultitabLinkEvent MultitabContainerAddHybrid = null;
        public static final MultitabLinkEvent MultitabContainerAddHybridAlreadyExist = null;
        public static final MultitabLinkEvent MultitabContainerAddHybridInwindow = null;
        public static final MultitabLinkEvent MultitabContainerInit = null;
        public static final MultitabLinkEvent MultitabHybridfragmentInit = null;
        public static final MultitabLinkEvent MultitabLoadDataInit = null;
        public static final MultitabLinkEvent MultitabLoadNeedSelectTabId = null;
        public static final MultitabLinkEvent MultitabNativeTabInit = null;
        public static final MultitabLinkEvent MultitabPerformance = null;
        public static final MultitabLinkEvent MultitabWebtabLoad = null;
        public static final MultitabLinkEvent MultitabWebtabNotify = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MultitabLinkEvent[] f160013a = null;
        private final String eventType;

        public static MultitabLinkEvent valueOf(String r100) {
            return (MultitabLinkEvent) a.a(MultitabLinkEvent.class, r100);
        }

        public static MultitabLinkEvent[] values() {
            return (MultitabLinkEvent[]) f160013a.clone();
        }

        static {
            MultitabLinkEvent r100 = new MultitabLinkEvent("MultiTabLoadStart", 0, "live_multitab_load_start");
            MultiTabLoadStart = r100;
            MultitabLinkEvent r101 = new MultitabLinkEvent("MultitabLoadDataInit", 1, "live_multitab_load_data_init");
            MultitabLoadDataInit = r101;
            MultitabLinkEvent r102 = new MultitabLinkEvent("MultitabLoadNeedSelectTabId", 2, "live_multitab_load_needselect_tabId");
            MultitabLoadNeedSelectTabId = r102;
            MultitabLinkEvent r103 = new MultitabLinkEvent("MultitabPerformance", 3, "live_multitab_performance");
            MultitabPerformance = r103;
            MultitabLinkEvent r104 = new MultitabLinkEvent("MultitabContainerInit", 4, "live_multitab_container_init");
            MultitabContainerInit = r104;
            MultitabLinkEvent r105 = new MultitabLinkEvent("MultitabHybridfragmentInit", 5, "live_multitab_hybridfragment_init");
            MultitabHybridfragmentInit = r105;
            MultitabLinkEvent r106 = new MultitabLinkEvent("MultitabContainerAddHybrid", 6, "live_multitab_container_add_hybrid");
            MultitabContainerAddHybrid = r106;
            MultitabLinkEvent r107 = new MultitabLinkEvent("MultitabContainerAddHybridAlreadyExist", 7, "live_multitab_container_add_hybrid_alreadyexist");
            MultitabContainerAddHybridAlreadyExist = r107;
            MultitabLinkEvent r108 = new MultitabLinkEvent("MultitabContainerAddHybridInwindow", 8, "live_multitab_container_add_hybrid_inwindow");
            MultitabContainerAddHybridInwindow = r108;
            MultitabLinkEvent r109 = new MultitabLinkEvent("MultitabNativeTabInit", 9, "live_multitab_native_tab_init");
            MultitabNativeTabInit = r109;
            MultitabLinkEvent r110 = new MultitabLinkEvent("MultitabWebtabLoad", 10, "live_multitab_webtab_load");
            MultitabWebtabLoad = r110;
            MultitabLinkEvent r111 = new MultitabLinkEvent("MultitabWebtabNotify", 11, "live_multitab_webtab_notify_failed");
            MultitabWebtabNotify = r111;
            f160013a = new MultitabLinkEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
        }

        public final String getEventType() {
            return this.eventType;
        }

        public MultitabLinkEvent(String r100, int r101, String r102) {
            super(r100, r101);
            this.eventType = r102;
        }
    }

    static {
    }

    public static void a(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
    L7:
        e = move-exception;
        ALogger.e("TabTraceMonitor", e);
        return;
    L4:
        if (r100.has(r101) == true) goto L12;
        r100.put(r101, r102);     // Catch: Exception -> L7
        return;
    }
}
