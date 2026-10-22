package com.bytedance.android.livesdk.clearscreen.utils;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class ClearScreenLogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f119492a = null;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/clearscreen/utils/ClearScreenLogUtils$Companion$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", TextureRenderKeys.KEY_MODULE_NAME, "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getModuleName", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "GoneInClearNotShow", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Event extends Enum<Event> {
            public static final Event GoneInClearNotShow = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Event[] f119493a = null;
            private final String eventName;
            private final LiveTracingMonitor.EventModule moduleName;

            static {
                Event r100 = new Event(LiveTracingMonitor.EventModule.CLEAR_SCREEN);
                GoneInClearNotShow = r100;
                f119493a = new Event[]{r100};
            }

            public static Event valueOf(String r100) {
                return (Event) r27.a.a(Event.class, r100);
            }

            public static Event[] values() {
                return (Event[]) f119493a.clone();
            }

            public final String getEventName() {
                return this.eventName;
            }

            public final LiveTracingMonitor.EventModule getModuleName() {
                return this.moduleName;
            }

            public Event(LiveTracingMonitor.EventModule r100) {
                super("GoneInClearNotShow", 0);
                this.eventName = "ttlive_clear_widget_not_show";
                this.moduleName = r100;
            }
        }

        public Companion() {
        }

        public static String a() {
            RoomContext.a r100 = RoomContext.Companion;
            RoomContext r101 = RoomContext.a.c(r100, null, 0, 3);
            if (r101 == null) goto L8;
            m<Integer> r102 = r101.getCleanMode();
            if (r102 == null) goto L8;
            if (r102.getValue().intValue() != 3) goto L8;
        L14:
            return "1";
        L8:
            RoomContext r103 = RoomContext.a.c(r100, null, 0, 3);
            if (r103 == null) goto L15;
            m<Integer> r104 = r103.getCleanMode();
            if (r104 == null) goto L15;
            if (r104.getValue().intValue() == 13) goto L14;
        L15:
            return "0";
        }

        public static String b() {
            RoomContext.a r100 = RoomContext.Companion;
            RoomContext r101 = RoomContext.a.c(r100, null, 0, 3);
            if (r101 == null) goto L9;
            m<Integer> r102 = r101.getCleanMode();
            if (r102 == null) goto L9;
            if (r102.getValue().intValue() != 2) goto L9;
            return "2";
        L9:
            RoomContext r103 = RoomContext.a.c(r100, null, 0, 3);
            if (r103 == null) goto L15;
            m<Integer> r104 = r103.getCleanMode();
            if (r104 == null) goto L15;
            if (r104.getValue().intValue() != 3) goto L15;
        L21:
            return "1";
        L15:
            RoomContext r105 = RoomContext.a.c(r100, null, 0, 3);
            if (r105 == null) goto L22;
            m<Integer> r106 = r105.getCleanMode();
            if (r106 == null) goto L22;
            if (r106.getValue().intValue() == 13) goto L21;
        L22:
            return "0";
        }

        public static void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "toolbarIcon");
            HashMap r101 = new HashMap();
            r101.put("tool_bar", r100);
            r101.put("if_pop_up_card", "1");
            u.l().sendLog("livesdk_clear_mode_simple_type_enter", r101, new Object[]{new x(), Room.class});
        }

        public static void g(ArrayList r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            Iterator r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L22;
            String r102 = (String) r101.next();
            ALogger.e("ClearScreenManager", "ClearScreen error!! not show is " + r102 + " .");
            Event r103 = Event.GoneInClearNotShow;
            Intrinsics.checkNotNullParameter(r103, "event");
            Intrinsics.checkNotNullParameter(r102, "widgetName");
            RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r104 == null) goto L10;
            m<Room> r105 = r104.getRoom();
            if (r105 == null) goto L10;
            Room r106 = r105.getValue();
        L11:
            Intrinsics.checkNotNullParameter(r103, "event");
            String r107 = r103.getEventName();
            LiveTracingMonitor.EventModule r108 = r103.getModuleName();
            if (r106 == null) goto L16;
            String r109 = String.valueOf(r106.getRoomId());
            JSONObject r110 = new JSONObject();
            r110.put("room_id", r109);     // Catch: JSONException -> L23
        L17:
            String r111 = String.valueOf(0);
            JSONObject r112 = new JSONObject();
            r112.put("status", r111);     // Catch: JSONException -> L24
        L30:
            r112.put("widget_name", r102);     // Catch: JSONException -> L25
        L21:
            LiveMonitor r113 = new LiveMonitor();
            r113.mCategory = r112;
            r113.mEventModule = r108;
            r113.mServiceName = r107;
            r113.mExtraLog = r110;
            r113.mMetrics = null;
            LiveMonitor.access$002(r113, false);
            LiveMonitor.access$102(r113, false);
            LiveMonitor.access$202(r113, true);
            LiveMonitor.access$302(r113, false);
            LiveMonitor.access$402(r113, false);
            r113.report();
            goto L4
        L16:
            r110 = null;
        L10:
            r106 = null;
            goto L11
        }

        public static void c(String r100, HashMap r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "logMap");
            u.l().sendLog(r100, r101, new Object[]{new x(), Room.class});
        }

        @JvmStatic
        public static void d(DataCenter r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter(r101, "clearType");
            HashMap r103 = new HashMap();
            if (r102 == null) goto L5;
            r103.putAll(r102);
        L5:
            r103.put("clear_type", r101);
            RoomContext r104 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
            if (r104 == null) goto L10;
            m<String> r105 = r104.getEnterClearType();
            if (r105 == null) goto L10;
            r105.setValue(r101);
        L10:
            u.l().sendLog("livesdk_screen_clear", r103, new Object[]{x.class, Room.class});
        }

        @JvmStatic
        public static void f(DataCenter r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter(r101, "clearType");
            HashMap r103 = new HashMap();
            if (r102 == null) goto L5;
            r103.putAll(r102);
        L5:
            r103.put("clear_type", r101);
            RoomContext r104 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
            if (r104 == null) goto L10;
            m<String> r105 = r104.getEnterClearType();
            if (r105 == null) goto L10;
            r105.setValue(r101);
        L10:
            u.l().sendLog("livesdk_screen_clear_cancel", r103, new Object[]{x.class, Room.class});
        }
    }

    static {
        f119492a = new Companion();
    }
}
