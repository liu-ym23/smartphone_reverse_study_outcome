package com.obric.autogui.common.api.platform.screen.capture;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: IScreenOperationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OScreenEvent {
    public static final Companion Companion = null;
    private String appName;
    private long eventTime;
    private String packageName;
    private int screenOrientation;

    /* JADX INFO: compiled from: IScreenOperationApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final OScreenEvent fromJson(JSONObject r19) {
            o.e(r19, "json");
            int r1 = r19.optInt("type", -1);
            OTouchInfo r3 = null;
            if (r1 != (-1)) goto L5;
            return null;
        L5:
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            int r5 = ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
            int r4 = ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels;
            double r9 = 0.0d;
            switch(r1) {
                case 1: goto L41;
                case 2: goto L33;
                case 3: goto L21;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L56;
                case 7: goto L55;
                default: goto L7;
            };
        L7:
            JSONObject r0 = r19.optJSONObject("start");
            OScreenTouchEvent.OTouchAction r12 = OScreenTouchEvent.OTouchAction.TAP;
            if (r0 == null) goto L49;
            double r14 = r0.optDouble("x", 0.0d);
        L50:
            float r6 = (float) (r14 * ((double) r5));
            if (r0 == null) goto L54;
            r9 = r0.optDouble("y", 0.0d);
        L54:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OScreenTouchEvent(r12, new OTouchInfo(r6, (float) (r9 * ((double) r4))), null, null, 12, null), OScreenEvent.class, "com.obric.aiagent.plugin");
        L49:
            r14 = 0.0d;
            goto L50
        L12:
            String r7 = r19.optString("app");
            String r8 = r19.optString("app_pkg");
            OAppStateEvent r10 = new OAppStateEvent(OAppStateEvent.AppState.OPEN);
            o.a(r7);
            r10.setAppName(r7);
            o.a(r8);
            r10.setPackageName(r8);
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(r10, OScreenEvent.class, "com.obric.aiagent.plugin");
        L13:
            JSONObject r11 = r19.optJSONObject("start");
            OScreenTouchEvent.OTouchAction r13 = OScreenTouchEvent.OTouchAction.BACK_KEY;
            if (r11 == null) goto L16;
            double r15 = r11.optDouble("x", 0.0d);
        L17:
            float r16 = (float) (r15 * ((double) r5));
            if (r11 == null) goto L58;
            r9 = r11.optDouble("y", 0.0d);
        L58:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OScreenTouchEvent(r13, new OTouchInfo(r16, (float) (r9 * ((double) r4))), null, null, 12, null), OScreenEvent.class, "com.obric.aiagent.plugin");
        L16:
            r15 = 0.0d;
            goto L17
        L21:
            JSONObject r17 = r19.optJSONObject("start");
            JSONObject r18 = r19.optJSONObject("end");
            OScreenTouchEvent.OTouchAction r110 = OScreenTouchEvent.OTouchAction.SCROLLED;
            if (r17 == null) goto L24;
            double r111 = r17.optDouble("x", 0.0d);
        L25:
            double r20 = r5;
            float r112 = (float) (r111 * r20);
            if (r17 == null) goto L28;
            double r113 = r17.optDouble("y", 0.0d);
        L29:
            double r21 = r4;
            OTouchInfo r114 = new OTouchInfo(r112, (float) (r113 * r21));
            if (r18 == null) goto L59;
            r3 = new OTouchInfo((float) (r18.optDouble("x", 0.0d) * r20), (float) (r18.optDouble("y", 0.0d) * r21));
        L59:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OScreenTouchEvent(r110, r114, r3, null, 8, null), OScreenEvent.class, "com.obric.aiagent.plugin");
        L28:
            r113 = 0.0d;
            goto L29
        L24:
            r111 = 0.0d;
            goto L25
        L33:
            JSONObject r22 = r19.optJSONObject("start");
            OScreenTouchEvent.OTouchAction r115 = OScreenTouchEvent.OTouchAction.LONG_PRESS;
            if (r22 == null) goto L36;
            double r116 = r22.optDouble("x", 0.0d);
        L37:
            float r23 = (float) (r116 * ((double) r5));
            if (r22 == null) goto L60;
            r9 = r22.optDouble("y", 0.0d);
        L60:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OScreenTouchEvent(r115, new OTouchInfo(r23, (float) (r9 * ((double) r4))), null, null, 12, null), OScreenEvent.class, "com.obric.aiagent.plugin");
        L36:
            r116 = 0.0d;
            goto L37
        L41:
            JSONObject r24 = r19.optJSONObject("start");
            OScreenTouchEvent.OTouchAction r117 = OScreenTouchEvent.OTouchAction.DOUBLE_TAP;
            if (r24 == null) goto L44;
            double r118 = r24.optDouble("x", 0.0d);
        L45:
            float r25 = (float) (r118 * ((double) r5));
            if (r24 == null) goto L61;
            r9 = r24.optDouble("y", 0.0d);
        L61:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OScreenTouchEvent(r117, new OTouchInfo(r25, (float) (r9 * ((double) r4))), null, null, 12, null), OScreenEvent.class, "com.obric.aiagent.plugin");
        L44:
            r118 = 0.0d;
            goto L45
        L55:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OInputMethodEvent(false), OScreenEvent.class, "com.obric.aiagent.plugin");
        L56:
            return (OScreenEvent) ZeusTransformUtils.preCheckCast(new OInputMethodEvent(true), OScreenEvent.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IScreenOperationApi.kt */
    public static final enum EventType extends Enum<EventType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ EventType[] $VALUES = null;
        public static final EventType ACCESSIBILITY = null;
        public static final EventType APP_STATE = null;
        public static final EventType INPUT_METHOD = null;
        public static final EventType TOUCH = null;

        private static final /* synthetic */ EventType[] $values() {
            return new EventType[]{TOUCH, INPUT_METHOD, APP_STATE, ACCESSIBILITY};
        }

        public static a<EventType> getEntries() {
            return $ENTRIES;
        }

        static {
            TOUCH = new EventType("TOUCH", 0);
            INPUT_METHOD = new EventType("INPUT_METHOD", 1);
            APP_STATE = new EventType("APP_STATE", 2);
            ACCESSIBILITY = new EventType("ACCESSIBILITY", 3);
            EventType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private EventType(String r1, int r2) {
            super(r1, r2);
        }

        public static EventType valueOf(String r2) {
            return (EventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventType.class, r2), EventType.class, "com.obric.aiagent.plugin");
        }

        public static EventType[] values() {
            return (EventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventType[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IScreenOperationApi.kt */
    public static final class OAppStateEvent extends OScreenEvent {
        private final EventType eventType;
        private final AppState state;

        /* JADX INFO: compiled from: IScreenOperationApi.kt */
        public static final enum AppState extends Enum<AppState> {
            private static final /* synthetic */ a $ENTRIES = null;
            private static final /* synthetic */ AppState[] $VALUES = null;
            public static final AppState CLOSE = null;
            public static final AppState OPEN = null;

            private static final /* synthetic */ AppState[] $values() {
                return new AppState[]{OPEN, CLOSE};
            }

            public static a<AppState> getEntries() {
                return $ENTRIES;
            }

            static {
                OPEN = new AppState("OPEN", 0);
                CLOSE = new AppState("CLOSE", 1);
                AppState[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            private AppState(String r1, int r2) {
                super(r1, r2);
            }

            public static AppState valueOf(String r2) {
                return (AppState) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppState.class, r2), AppState.class, "com.obric.aiagent.plugin");
            }

            public static AppState[] values() {
                return (AppState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppState[].class, "com.obric.aiagent.plugin");
            }
        }

        public static /* synthetic */ OAppStateEvent copy$default(OAppStateEvent r0, AppState r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.state;
        L6:
            return r0.copy(r1);
        }

        public final AppState component1() {
            return this.state;
        }

        public final OAppStateEvent copy(AppState r1) {
            o.e(r1, "state");
            return new OAppStateEvent(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OAppStateEvent.class) == true) goto L8;
            return false;
        L8:
            OAppStateEvent r6 = (OAppStateEvent) ZeusTransformUtils.preCheckCast(r5, OAppStateEvent.class, "com.obric.aiagent.plugin");
            if (this.state == r6.state) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "OAppStateEvent(state=" + this.state + ')';
        }

        public final AppState getState() {
            return this.state;
        }

        public OAppStateEvent(AppState r2) {
            o.e(r2, "state");
            super(null);
            this.state = r2;
            this.eventType = EventType.APP_STATE;
        }

        @Override // com.obric.autogui.common.api.platform.screen.capture.OScreenEvent
        public EventType getEventType() {
            return this.eventType;
        }
    }

    /* JADX INFO: compiled from: IScreenOperationApi.kt */
    public static final class OInputMethodEvent extends OScreenEvent {
        private final EventType eventType;
        private final boolean visible;

        public static /* synthetic */ OInputMethodEvent copy$default(OInputMethodEvent r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.visible;
        L6:
            return r0.copy(r1);
        }

        public final boolean component1() {
            return this.visible;
        }

        public final OInputMethodEvent copy(boolean r1) {
            return new OInputMethodEvent(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OInputMethodEvent.class) == true) goto L8;
            return false;
        L8:
            OInputMethodEvent r6 = (OInputMethodEvent) ZeusTransformUtils.preCheckCast(r5, OInputMethodEvent.class, "com.obric.aiagent.plugin");
            if (this.visible == r6.visible) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.visible);
        }

        public String toString() {
            return "OInputMethodEvent(visible=" + this.visible + ')';
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public OInputMethodEvent(boolean r2) {
            super(null);
            this.visible = r2;
            this.eventType = EventType.INPUT_METHOD;
        }

        @Override // com.obric.autogui.common.api.platform.screen.capture.OScreenEvent
        public EventType getEventType() {
            return this.eventType;
        }
    }

    /* JADX INFO: compiled from: IScreenOperationApi.kt */
    public static final class OScreenTouchEvent extends OScreenEvent {
        private final OTouchAction action;
        private final OTouchInfo endTouchInfo;
        private final EventType eventType;
        private final OScrollDirection scrollDirection;
        private final OTouchInfo touchInfo;

        /* JADX INFO: compiled from: IScreenOperationApi.kt */
        public static final enum OScrollDirection extends Enum<OScrollDirection> {
            private static final /* synthetic */ a $ENTRIES = null;
            private static final /* synthetic */ OScrollDirection[] $VALUES = null;
            public static final OScrollDirection DOWN = null;
            public static final OScrollDirection LEFT = null;
            public static final OScrollDirection RIGHT = null;
            public static final OScrollDirection UP = null;

            private static final /* synthetic */ OScrollDirection[] $values() {
                return new OScrollDirection[]{UP, DOWN, LEFT, RIGHT};
            }

            public static a<OScrollDirection> getEntries() {
                return $ENTRIES;
            }

            static {
                UP = new OScrollDirection("UP", 0);
                DOWN = new OScrollDirection("DOWN", 1);
                LEFT = new OScrollDirection("LEFT", 2);
                RIGHT = new OScrollDirection("RIGHT", 3);
                OScrollDirection[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            private OScrollDirection(String r1, int r2) {
                super(r1, r2);
            }

            public static OScrollDirection valueOf(String r2) {
                return (OScrollDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(OScrollDirection.class, r2), OScrollDirection.class, "com.obric.aiagent.plugin");
            }

            public static OScrollDirection[] values() {
                return (OScrollDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OScrollDirection[].class, "com.obric.aiagent.plugin");
            }
        }

        /* JADX INFO: compiled from: IScreenOperationApi.kt */
        public static final enum OTouchAction extends Enum<OTouchAction> {
            private static final /* synthetic */ a $ENTRIES = null;
            private static final /* synthetic */ OTouchAction[] $VALUES = null;
            public static final OTouchAction BACK_KEY = null;
            public static final OTouchAction DOUBLE_TAP = null;
            public static final OTouchAction LONG_PRESS = null;
            public static final OTouchAction SCROLLED = null;
            public static final OTouchAction SCROLL_START = null;
            public static final OTouchAction TAP = null;

            private static final /* synthetic */ OTouchAction[] $values() {
                return new OTouchAction[]{TAP, DOUBLE_TAP, LONG_PRESS, SCROLL_START, SCROLLED, BACK_KEY};
            }

            public static a<OTouchAction> getEntries() {
                return $ENTRIES;
            }

            static {
                TAP = new OTouchAction("TAP", 0);
                DOUBLE_TAP = new OTouchAction("DOUBLE_TAP", 1);
                LONG_PRESS = new OTouchAction("LONG_PRESS", 2);
                SCROLL_START = new OTouchAction("SCROLL_START", 3);
                SCROLLED = new OTouchAction("SCROLLED", 4);
                BACK_KEY = new OTouchAction("BACK_KEY", 5);
                OTouchAction[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            private OTouchAction(String r1, int r2) {
                super(r1, r2);
            }

            public static OTouchAction valueOf(String r2) {
                return (OTouchAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(OTouchAction.class, r2), OTouchAction.class, "com.obric.aiagent.plugin");
            }

            public static OTouchAction[] values() {
                return (OTouchAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OTouchAction[].class, "com.obric.aiagent.plugin");
            }
        }

        public static /* synthetic */ OScreenTouchEvent copy$default(OScreenTouchEvent r0, OTouchAction r1, OTouchInfo r2, OTouchInfo r3, OScrollDirection r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.action;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.touchInfo;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.endTouchInfo;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.scrollDirection;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final OTouchAction component1() {
            return this.action;
        }

        public final OTouchInfo component2() {
            return this.touchInfo;
        }

        public final OTouchInfo component3() {
            return this.endTouchInfo;
        }

        public final OScrollDirection component4() {
            return this.scrollDirection;
        }

        public final OScreenTouchEvent copy(OTouchAction r1, OTouchInfo r2, OTouchInfo r3, OScrollDirection r4) {
            o.e(r1, "action");
            o.e(r2, "touchInfo");
            return new OScreenTouchEvent(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OScreenTouchEvent.class) == true) goto L8;
            return false;
        L8:
            OScreenTouchEvent r6 = (OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r5, OScreenTouchEvent.class, "com.obric.aiagent.plugin");
            if (this.action == r6.action) goto L12;
            return false;
        L12:
            if (o.a(this.touchInfo, r6.touchInfo) == true) goto L15;
            return false;
        L15:
            if (o.a(this.endTouchInfo, r6.endTouchInfo) == true) goto L18;
            return false;
        L18:
            if (this.scrollDirection == r6.scrollDirection) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.action.hashCode() * 31) + this.touchInfo.hashCode()) * 31;
            OTouchInfo r1 = this.endTouchInfo;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            OScrollDirection r5 = this.scrollDirection;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "OScreenTouchEvent(action=" + this.action + ", touchInfo=" + this.touchInfo + ", endTouchInfo=" + this.endTouchInfo + ", scrollDirection=" + this.scrollDirection + ')';
        }

        public /* synthetic */ OScreenTouchEvent(OTouchAction r2, OTouchInfo r3, OTouchInfo r4, OScrollDirection r5, int r6, h r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = null;
        L8:
            this(r2, r3, r4, r5);
        }

        public final OTouchAction getAction() {
            return this.action;
        }

        public final OTouchInfo getTouchInfo() {
            return this.touchInfo;
        }

        public final OTouchInfo getEndTouchInfo() {
            return this.endTouchInfo;
        }

        public final OScrollDirection getScrollDirection() {
            return this.scrollDirection;
        }

        public OScreenTouchEvent(OTouchAction r2, OTouchInfo r3, OTouchInfo r4, OScrollDirection r5) {
            o.e(r2, "action");
            o.e(r3, "touchInfo");
            super(null);
            this.action = r2;
            this.touchInfo = r3;
            this.endTouchInfo = r4;
            this.scrollDirection = r5;
            this.eventType = EventType.TOUCH;
        }

        @Override // com.obric.autogui.common.api.platform.screen.capture.OScreenEvent
        public EventType getEventType() {
            return this.eventType;
        }
    }

    /* JADX INFO: compiled from: IScreenOperationApi.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OScreenTouchEvent.OTouchAction.values().length];
            r0[OScreenTouchEvent.OTouchAction.TAP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[OScreenTouchEvent.OTouchAction.DOUBLE_TAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[OScreenTouchEvent.OTouchAction.LONG_PRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[OScreenTouchEvent.OTouchAction.SCROLL_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OScreenTouchEvent.OTouchAction.SCROLLED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[OScreenTouchEvent.OTouchAction.BACK_KEY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ OScreenEvent(h r1) {
        this();
    }

    public abstract EventType getEventType();

    private OScreenEvent() {
        this.eventTime = System.currentTimeMillis();
        this.packageName = "";
        this.appName = "";
        this.screenOrientation = 1;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final void setEventTime(long r1) {
        this.eventTime = r1;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String r2) {
        o.e(r2, "<set-?>");
        this.packageName = r2;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r2) {
        o.e(r2, "<set-?>");
        this.appName = r2;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    public final void setScreenOrientation(int r1) {
        this.screenOrientation = r1;
    }

    public final JSONObject toJson() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (this.screenOrientation == 1) goto L6;
        r3 = false;
    L6:
        Object r1 = r0.getSystemService("window");
        o.a(r1, "null cannot be cast to non-null type android.view.WindowManager");
        Rect r2 = ((WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.aiagent.plugin")).getCurrentWindowMetrics().getBounds();
        o.c(r2, "getBounds(...)");
        if (r3 == false) goto L9;
        int r4 = r2.width();
    L10:
        if (r3 == false) goto L12;
        int r5 = r2.height();
    L13:
        JSONObject r6 = new JSONObject();
        if (ZeusTransformUtils.instanceOf(this, OScreenTouchEvent.class) == false) goto L23;
        r6.put("type", toType(((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getAction()));
        if (((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getAction() == OScreenTouchEvent.OTouchAction.BACK_KEY) goto L19;
        JSONObject r7 = new JSONObject();
        float r9 = 1000;
        r7.put("x", (int) ((((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo().getX() / r4) * r9));
        r7.put("y", (int) ((((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo().getY() / r5) * r9));
        x r8 = x.f38692a;
        r6.put("start", r7);
    L19:
        if (((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getEndTouchInfo() == null) goto L21;
        JSONObject r10 = new JSONObject();
        float r11 = ((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getEndTouchInfo().getX() / r4;
        float r12 = 1000;
        r10.put("x", (int) (r11 * r12));
        r10.put("y", (int) ((((OScreenTouchEvent) ZeusTransformUtils.preCheckCast(this, OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getEndTouchInfo().getY() / r5) * r12));
        x r13 = x.f38692a;
        r6.put("end", r10);
    L21:
        x r14 = x.f38692a;
    L32:
        return r6;
    L23:
        if (ZeusTransformUtils.instanceOf(this, OAppStateEvent.class) == false) goto L26;
        r6.put("type", 5);
        r6.put("app", this.appName);
        r6.put("app_pkg", this.packageName);
        goto L32
    L26:
        if (ZeusTransformUtils.instanceOf(this, OInputMethodEvent.class) == false) goto L34;
        if (((OInputMethodEvent) ZeusTransformUtils.preCheckCast(this, OInputMethodEvent.class, "com.obric.aiagent.plugin")).getVisible() == false) goto L30;
        int r15 = 6;
    L31:
        r6.put("type", r15);
        goto L32
    L30:
        r15 = 7;
        goto L31
    L34:
        throw new k();
    L12:
        r5 = r2.width();
        goto L13
    L9:
        r4 = r2.height();
        goto L10
    }

    private final int toType(OScreenTouchEvent.OTouchAction r1) {
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 4;
    L7:
        return 3;
    L8:
        return 2;
    L9:
        return 1;
    L10:
        return 0;
    L5:
        throw new k();
    }
}
