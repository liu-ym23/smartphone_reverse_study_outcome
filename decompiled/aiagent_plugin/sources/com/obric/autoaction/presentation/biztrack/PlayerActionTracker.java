package com.obric.autoaction.presentation.biztrack;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayerActionTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerActionTracker extends GestureDetector.SimpleOnGestureListener {
    private static final String ACTION_DOUBLE_TAP = "double_tap";
    private static final String ACTION_LONG_PRESS = "long_press";
    private static final String ACTION_SCROLL = "scroll_start";
    private static final String ACTION_SCROLL_END = "scroll_end";
    private static final String ACTION_TAP = "tap";
    public static final a Companion = null;
    private static final String EVENT_NAME = "oauto_virtual_screen_action_record";
    private static final String TAG = "VirtualDisplayActionTracker";
    private com.obric.autoaction.presentation.biztrack.a actionRecord;
    private final GestureDetector gestureDetector;
    private boolean scrolling;

    /* JADX INFO: compiled from: PlayerActionTracker.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PlayerActionTracker.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24828a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.presentation.b.d.values().length];
            r0[com.obric.autoaction.presentation.b.d.f24818a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.autoaction.presentation.b.d.f24819b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f24828a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public PlayerActionTracker(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.gestureDetector = new GestureDetector(r5, (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(this, GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin"));
    }

    public final void onVirtualPlayerCreated() {
        String r0 = com.obric.autoaction.presentation.function.b.f24937a.a();
        if (r0 == null) goto L6;
        onFunctionStateChange(new com.obric.autoaction.presentation.b.e(r0, com.obric.autoaction.presentation.b.d.f24818a));
        return;
    }

    public final void onReceiveTouchEvent(MotionEvent r3) {
        o.e(r3, "event");
        this.gestureDetector.onTouchEvent(r3);
        if (r3.getActionMasked() == 1) goto L7;
        if (r3.getActionMasked() == 3) goto L7;
        return;
    L7:
        if (this.scrolling == false) goto L11;
        onScrolled(r3);
        return;
    }

    public final void onFunctionStateChange(com.obric.autoaction.presentation.b.e r12) {
        o.e(r12, "event");
        if (o.a(r12.a(), "ManualOperating") == false) goto L5;
    L6:
        com.obric.autoaction.presentation.b.d r0 = r12.b();
        int r1 = b.f24828a[r0.ordinal()];
        if (r1 != 1) goto L9;
        this.actionRecord = new com.obric.autoaction.presentation.biztrack.a(0, 0, 0, 0, 0, null, 0, 127, null);
        return;
    L9:
        if (r1 != 2) goto L12;
        reportActionRecord(r12.a());
        this.actionRecord = null;
        return;
    L12:
        throw new k();
    L5:
        if (o.a(r12.a(), "CallUser") == true) goto L6;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r2) {
        o.e(r2, "e");
        this.scrolling = false;
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r2) {
        o.e(r2, "e");
        recordPlayerAction(ACTION_TAP);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent r2) {
        o.e(r2, "e");
        recordPlayerAction(ACTION_DOUBLE_TAP);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r2) {
        o.e(r2, "e");
        recordPlayerAction(ACTION_LONG_PRESS);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        o.e(r2, "e2");
        if (this.scrolling == true) goto L5;
        this.scrolling = true;
        recordPlayerAction(ACTION_SCROLL);
    L5:
        return true;
    }

    private final void onScrolled(MotionEvent r1) {
        this.scrolling = false;
        recordPlayerAction(ACTION_SCROLL_END);
    }

    private final void recordPlayerAction(String r7) {
        com.obric.autoaction.presentation.biztrack.a r6 = this.actionRecord;
        if (r6 == null) goto L34;
        long r0 = System.currentTimeMillis();
        switch(r7.hashCode()) {
            case -395968400: goto L24;
            case -326696768: goto L20;
            case 114595: goto L16;
            case 66613353: goto L12;
            case 779098677: goto L8;
            default: goto L28;
        };
    L8:
        if (r7.equals(ACTION_DOUBLE_TAP) == false) goto L28;
        r6.b(r6.b() + 1);
        goto L28
    L12:
        if (r7.equals(ACTION_SCROLL_END) == false) goto L28;
        r6.e(r6.e() + 1);
        goto L28
    L16:
        if (r7.equals(ACTION_TAP) == false) goto L28;
        r6.a(r6.a() + 1);
        goto L28
    L20:
        if (r7.equals(ACTION_LONG_PRESS) == false) goto L28;
        r6.c(r6.c() + 1);
        goto L28
    L24:
        if (r7.equals(ACTION_SCROLL) == false) goto L28;
        r6.d(r6.d() + 1);
    L28:
        if (r6.g() > 0) goto L30;
    L32:
        r6.a(r0);
        return;
    L30:
        if (r0 <= r6.g()) goto L32;
        r6.f().add(Long.valueOf(r0 - r6.g()));
        goto L32
    }

    public final void reportActionRecord(String r12) {
        o.e(r12, "functionName");
        com.obric.autoaction.presentation.biztrack.a r11 = this.actionRecord;
        if (r11 == null) goto L9;
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("function_name", r12);
        r5.put("action_count", r11.h());
        r5.put("tap_count", r11.a());
        r5.put("double_tap_count", r11.b());
        r5.put("long_press_count", r11.c());
        r5.put("scroll_start_count", r11.d());
        r5.put("scroll_end_count", r11.e());
        r5.put("average_action_time_interval", r11.i());
        IAutoActionAgentEventListener.SessionInfo r13 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L7;
        com.obric.autogui.session.c.b.a(r5, r13);
    L7:
        x r14 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, EVENT_NAME, r5, false, false, null, 28, null);
        return;
    }
}
